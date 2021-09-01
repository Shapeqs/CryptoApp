import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Crypto} from "../models/crypto.model";
import {environment} from "../../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CryptoService {

  constructor(private http: HttpClient) {
  }

  public getCryptos(): Observable<Crypto[]> {
    return undefined; // this.http.get<Crypto[]>(environment.apiUrls.bottles);
  }
}
