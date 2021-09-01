import {Component, OnInit} from '@angular/core';
import {CryptoService} from "../../shared/services/crypto.service";
import {HttpErrorResponse} from "@angular/common/http";
import {Observable} from "rxjs";
import {Crypto} from "../../shared/models/crypto.model";

@Component({
  selector: 'app-listing',
  templateUrl: './listing.component.html',
  styleUrls: ['./listing.component.scss']
})
export class ListingComponent implements OnInit {

  cryptos$: Observable<Crypto[]> = this.cryptoService.getCryptos();
  cryptos: Crypto[];

  constructor(private cryptoService: CryptoService) {
  }

  ngOnInit() {
    this.cryptos$.subscribe(cryptos => {
        this.cryptos = cryptos;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

}
