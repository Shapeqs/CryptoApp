import {Component, Input} from '@angular/core';
import {Crypto} from "../../models/crypto.model";

@Component({
  selector: 'app-crypto',
  templateUrl: './crypto.component.html',
  styleUrls: ['./crypto.component.scss']
})
export class CryptoComponent {

  @Input() crypto: Crypto;

  constructor() { }

}
