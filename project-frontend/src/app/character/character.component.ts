import { Component } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatSelectModule} from '@angular/material/select';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import {NgForOf} from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import {MatToolbar} from '@angular/material/toolbar';
import {MatMenu, MatMenuModule, MatMenuTrigger} from '@angular/material/menu';
import {MatCheckbox, MatCheckboxModule} from '@angular/material/checkbox';

export interface Character {
  name: string;
  series: string;
  age: number;
  height: number;
  weight: number;
  species: string;
  gender: string;
}

@Component({
  selector: 'app-character',
  imports: [
    FormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatSelectModule,
    MatInputModule,
    MatButtonModule,
    NgForOf,
    MatIconModule,
    MatToolbar,
    MatMenuModule,
    MatCheckboxModule,
  ],
  templateUrl: './character.component.html',
  styleUrl: './character.component.css',
  standalone: true
})
export class CharacterComponent {
  token = localStorage.getItem('token');
  characters: Character[] = [
    { name: 'John Doe', series: 'Series A', age: 30, height: 180, weight: 75, species: 'Human', gender: 'Male' },
    { name: 'Jane Smith', series: 'Series B', age: 28, height: 170, weight: 60, species: 'Human', gender: 'Female' },
    { name: 'Alex Johnson', series: 'Series A', age: 35, height: 175, weight: 80, species: 'Human', gender: 'Male' },
  ];

  filters = {
    age: false,
    series: false,
    height: false,
    weight: false,
    species: false,
    gender: false,
  };

  selectedSeries = new Set<string>()

  get allSeries(): string[] {
    return Array.from(new Set(this.characters.map(character => character.series)));
  }

  toggleSeries(series: string) {
    if (this.selectedSeries.has(series)) {
      this.selectedSeries.delete(series);
    } else {
      this.selectedSeries.add(series);
    }
  }

  sortKey = 'age';
  sortOrder = 'asc';
  addCharacter() {
    this.characters.push({
      name: 'New Character',
      series: 'New Series',
      age: 0,
      height: 0,
      weight: 0,
      species: 'Unknown',
      gender: 'Unknown'
    });
  }

  deleteCharacter(index: number) {
    this.characters.splice(index, 1);
  }

  editCharacter(index: number, field: keyof Character, value: any) {
    // @ts-ignore
    this.characters[index][field] = value;
  }

  filteredCharacters() {
    let filtered = this.characters;

    return filtered.sort((a, b) => {
      // @ts-ignore
      if (a[this.sortKey] < b[this.sortKey]) {
        return this.sortOrder === 'asc' ? -1 : 1;
      } else { // @ts-ignore
        if (a[this.sortKey] > b[this.sortKey]) {
                return this.sortOrder === 'asc' ? 1 : -1;
              }
      }
      return 0;
    });
  }

  protected readonly prompt = prompt;
}
