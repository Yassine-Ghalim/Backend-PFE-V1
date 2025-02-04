import { Component, OnInit } from '@angular/core';
import { KeycloakService } from 'keycloak-angular';
import { KeycloakProfile } from 'keycloak-js';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']  // Corrigé de `styleUrl` à `styleUrls` (erreur typographique)
})
export class AppComponent implements OnInit {
  title = 'angular-app';
  public profile!: KeycloakProfile;

  constructor(public keycloakService: KeycloakService) {}

  ngOnInit() {
    if (this.keycloakService.isLoggedIn()) {
      this.keycloakService.loadUserProfile().then(profile => {
        this.profile = profile;
      });
    }
  }

  async handleLogin() {
    if (typeof window !== 'undefined' && window.location) {
      await this.keycloakService.login({
        redirectUri: window.location.origin
      });
    } else {
      console.error('Window or location is not available.');
    }
  }

  handleLogout() {
    if (typeof window !== 'undefined' && window.location) {
      this.keycloakService.logout(window.location.origin);
    } else {
      console.error('Window or location is not available.');
    }
  }
}
