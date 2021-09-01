import {Injectable, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {CryptoService} from "./shared/services/crypto.service";
import {HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest} from "@angular/common/http";
import {ListingComponent} from './pages/listing/listing.component';
import {RouterModule} from '@angular/router';
import {CryptoComponent} from './shared/component/crypto/crypto.component';
import {PageNotFoundComponent} from './pages/page-not-found/page-not-found.component';
import {FormsModule} from "@angular/forms";
import {ModalModule} from 'ngx-bootstrap/modal';

@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone({
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
    });
    return next.handle(xhr);
  }
}

@NgModule({
  declarations: [
    AppComponent,
    ListingComponent,
    CryptoComponent,
    PageNotFoundComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot([
      {path: 'all', component: ListingComponent},
      {path: '', redirectTo: '/all', pathMatch: 'full'},
      {path: '**', component: PageNotFoundComponent}
    ]),
    NgbModule,
    FormsModule,
    ModalModule,
  ],
  providers: [CryptoService, { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true
  }],
  bootstrap: [AppComponent]
})

export class AppModule {
}
