import { Routes } from '@angular/router';
import {LoginComponent} from './login/login.component';
import {CharacterComponent} from './character/character.component';

export const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'characters', component: CharacterComponent}
];
