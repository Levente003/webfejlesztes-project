import {Component, Inject} from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatButton, MatButtonModule} from '@angular/material/button';
import {NgForOf, NgIf} from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MAT_DIALOG_DATA, MatDialog, MatDialogActions, MatDialogClose, MatDialogModule} from '@angular/material/dialog';
import {MatSliderModule} from '@angular/material/slider';
import {MatExpansionModule} from '@angular/material/expansion';
import {MatListModule, MatSelectionList} from '@angular/material/list';
import {MatSlideToggleModule} from '@angular/material/slide-toggle';
import {MatChipListbox, MatChipListboxChange, MatChipSelectionChange, MatChipsModule} from '@angular/material/chips';
import {CharacterService} from '../../character.service';
import {CharacterDto} from '../../CharacterDto';
import {MatRipple} from '@angular/material/core';
import {Router} from '@angular/router';


@Component({
  selector: 'app-root',
  imports: [
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    NgForOf,
    MatIconModule,
    MatMenuModule,
    MatCheckboxModule,
    MatSliderModule,
    MatToolbarModule,
    MatExpansionModule,
    MatListModule,
    MatSliderModule,
    MatSlideToggleModule,
    MatChipsModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatRipple,
    NgIf,
  ],
  templateUrl: './character.component.html',
  styleUrls: ['./character.component.css'],
  standalone: true,
})
export class CharacterComponent {
  characters: CharacterDto[] = [];
  loggedInUser = localStorage.getItem('user');

  constructor(public dialog: MatDialog, private apiService: CharacterService, private router: Router) {}

  ngOnInit(): void {
    this.reloadCharacters();
  }

  logout():void{
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    this.router.navigate([''])
  }

  reloadCharacters(): void {
    this.loadCharacters();
    this.filters.ageRange = [this.minAge, this.maxAge];
    this.filters.heightRange = [this.minHeight, this.maxHeight];
    this.filters.weightRange = [this.minWeight, this.maxWeight];
  }

  loadCharacters(): void {
    this.apiService.getCharacters().subscribe((data) => {
      this.characters = data;
    });
  }

  filters = {
    selectedSeries: new Set<string>(),
    ageRange: [this.minAge, this.maxAge],
    heightRange: [this.minHeight, this.maxHeight],
    weightRange: [this.minWeight, this.maxWeight],
    selectedGender: new Set<string>(),
    selectedSpecies: new Set<string>()
  };
  isAscending: boolean = true;
  sortKeyOptions = ['name' , 'age' , 'height'];
  sortKey = 'name';

  capitalise(word: string): string {
    return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
  }

  get sortOrder(): string {
    return this.isAscending ? "Ascending" : "Descending";
  }

  get isAdmin(): boolean {
    return this.loggedInUser == "admin";
  }

  get minAge(): number {
    return this.characters.length > 0 ? this.characters.map(character => character.age)
      .reduce((a, b) => Math.min(a, b), Infinity) : 0;
  }

  get maxAge(): number {
    return this.characters.length > 0 ? this.characters.map(character => character.age)
      .reduce((a, b) => Math.max(a, b), -Infinity) : 0;
  }

  get minHeight(): number {
    return this.characters.length > 0 ? this.characters.map(character => character.height)
      .reduce((a, b) => Math.min(a, b), Infinity) : 0;
  }

  get maxHeight(): number {
    return this.characters.length > 0 ? this.characters.map(character => character.height)
      .reduce((a, b) => Math.max(a, b), -Infinity) : 0;
  }

  get minWeight(): number {
    return this.characters.length > 0 ? this.characters.map(character => character.weight)
      .reduce((a, b) => Math.min(a, b), Infinity) : 0;
  }

  get maxWeight(): number {
    return this.characters.length > 0 ? this.characters.map(character => character.weight)
      .reduce((a, b) => Math.max(a, b), -Infinity) : 0;
  }

  get allSeries(): string[] {
    return this.characters.length > 0
      ? Array.from(new Set(this.characters.map(character => character.series)))
      : [];
  }

  get allGenders(): string[] {
    return this.characters.length > 0
      ? Array.from(new Set(this.characters.map(character => character.gender)))
      : [];
  }

  get allSpecies(): string[] {
    return this.characters.length > 0
      ? Array.from(new Set(this.characters.map(character => character.species)))
      : [];
  }

  toggleFilter(set: Set<string>, value: string) {
    if (set.has(value)) {
      set.delete(value);
    } else {
      set.add(value);
    }
  }

  openEditDialog(character: CharacterDto): void {
    const dialogRef = this.dialog.open(EditCharacterDialog, {
      width: '30%',
      data: { ...character }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.apiService.editCharacter(result).subscribe(
          (newCharacter) => {
            const index = this.characters.indexOf(character);
            if (index > -1) {
              this.characters.splice(index, 1);
            }
            this.characters.push(newCharacter);
            this.filters.ageRange = [this.minAge, this.maxAge];
            this.filters.heightRange = [this.minHeight, this.maxHeight];
            this.filters.weightRange = [this.minWeight, this.maxWeight];
          },
          (error) => {
            console.error('Failed to edit character', error);
          }
        );
      }
    });
  }

  openAddDialog(): void {
    const dialogRef = this.dialog.open(AddCharacterDialog, {
      width: '30%',
      data: { name: '', series: '', age: 0, height: 0, weight: 0, species: '', gender: '' }
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.apiService.createCharacter(result).subscribe(
          (newCharacter) => {
            this.characters.push(newCharacter);
            this.filters.ageRange = [this.minAge, this.maxAge];
            this.filters.heightRange = [this.minHeight, this.maxHeight];
            this.filters.weightRange = [this.minWeight, this.maxWeight];
          },
          (error) => {
            console.error('Failed to add character', error);
          }
        );
      }
    });
  }

  confirmDelete(character: CharacterDto): void {
    if (confirm(`Are you sure you want to delete ${character.name} from ${character.series}?`)) {
      this.apiService.deleteCharacter(character.id).subscribe({
        next: () => {
          // Remove the character from the local array only after successful deletion
          const index = this.characters.indexOf(character);
          if (index > -1) {
            this.characters.splice(index, 1);
          }
        },
        error: (err) => {
          // Log or show an error message to the user
          console.error('Failed to delete character:', err);
          alert('Failed to delete the character. Please try again.');
        }
      });
    }
  }

  filteredCharacters() {
    return this.characters
      .filter(character => !this.filters.selectedSeries.size || this.filters.selectedSeries.has(character.series))
      .filter(character => character.age >= this.filters.ageRange[0] && character.age <= this.filters.ageRange[1])
      .filter(character => character.height >= this.filters.heightRange[0] && character.height <= this.filters.heightRange[1])
      .filter(character => character.weight >= this.filters.weightRange[0] && character.weight <= this.filters.weightRange[1])
      .filter(character => !this.filters.selectedGender.size || this.filters.selectedGender.has(character.gender))
      .filter(character => !this.filters.selectedSpecies.size || this.filters.selectedSpecies.has(character.species))
      .sort((a, b) => {
        if (this.sortKey === 'name') {
          return this.isAscending ? a.name.localeCompare(b.name) : b.name.localeCompare(a.name);
        }
        // @ts-ignore
        return this.isAscending ? a[this.sortKey] - b[this.sortKey] : b[this.sortKey] - a[this.sortKey];
      });
  }
}

@Component({
  selector: 'edit-character-dialog',
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatButtonModule,
  ],
  templateUrl: './edit-character-dialog.html',
  styleUrls: ['./character-dialog.css']
})
export class EditCharacterDialog {
  constructor(@Inject(MAT_DIALOG_DATA) public data: CharacterDto) {}
}

@Component({
  selector: 'add-character-dialog',
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDialogModule,
    MatButtonModule,
  ],
  templateUrl: './add-character-dialog.html',
  styleUrls: ['./character-dialog.css']
})
export class AddCharacterDialog {
  constructor(@Inject(MAT_DIALOG_DATA) public data: CharacterDto) {}
}
