import { Component, Input } from '@angular/core';
import { Provider } from '../types';

@Component({
  selector: 'app-provider-profile',
  imports: [],
  templateUrl: './provider-profile.component.html',
  styleUrl: './provider-profile.component.scss',
})
export class ProviderProfileComponent {
  @Input() provider!: Provider;
}
