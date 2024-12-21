import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CharacterDto} from './CharacterDto';

@Injectable({
  providedIn: 'root'
})
export class CharacterService {
  private apiUrl = 'http://localhost:8080/api/character';
  private getHeaders(){
    return new HttpHeaders({'Authorization' : `Bearer ${localStorage.getItem('token')}`
      , 'Access-Control-Allow-Origin':'*'})
  }

  constructor(private http: HttpClient) {}

  getCharacters(): Observable<CharacterDto[]> {
    return this.http.get<CharacterDto[]>(`${this.apiUrl}/allCharacters`, {
      headers: this.getHeaders()
    });
  }

  deleteCharacter(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/delete?id=${id}`, {
      headers: this.getHeaders()
    });
  }

  createCharacter(character: CharacterDto): Observable<CharacterDto> {
    return this.http.post<CharacterDto>(`${this.apiUrl}/add`, character, {
      headers: this.getHeaders()
    });
  }

  editCharacter(character: CharacterDto): Observable<CharacterDto> {
    return this.http.put<CharacterDto>(`${this.apiUrl}/edit`, character, {
      headers: this.getHeaders()
    });
  }
}
