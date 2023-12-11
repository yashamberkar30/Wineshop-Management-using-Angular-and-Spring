import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatIconModule} from '@angular/material/icon'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MatDialogModule } from '@angular/material/dialog';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';
import { AdminAddproductsComponent } from './components/admin/admin-addproducts/admin-addproducts.component';
import { AdminHeaderComponent } from './components/admin/admin-header/admin-header.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AdminOrderListComponent } from './components/admin/admin-order-list/admin-order-list.component';
import { ProductListComponent } from './components/admin/product-list/product-list.component';
import { AppHeaderComponent } from './components/app-header/app-header.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { CustomerCartComponent } from './components/customer/customer-cart/customer-cart.component';
import { CustomerHeaderComponent } from './components/customer/customer-header/customer-header.component';
import { CustomerHomeComponent } from './components/customer/customer-home/customer-home.component';
import { CustomerOrderComponent } from './components/customer/customer-order/customer-order.component';
import { CustomerPaymentComponent } from './components/customer/customer-payment/customer-payment.component';
import { CustomerSignUpComponent } from './components/customer/customer-sign-up/customer-sign-up.component';
import {MatMenuModule} from '@angular/material/menu';
import { DatePipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { PagingComponent } from './components/paging/paging.component';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';
import { OrderHistoryDialogeComponent } from './components/customer/order-history-dialoge/order-history-dialoge.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { MatNativeDateModule, MatRippleModule } from '@angular/material/core';
import { MatButtonModule } from '@angular/material/button';
import {MatButtonToggleModule} from '@angular/material/button-toggle'

@NgModule({
  declarations: [
    AppComponent,
    OrderHistoryDialogeComponent,
    HomePageComponent,
    AboutUsComponent,
    ContactUsComponent,
    AdminLoginComponent,
    AdminAddproductsComponent,
    AdminHeaderComponent,
    AdminHomeComponent,
    AdminOrderListComponent,
    ProductListComponent,
    AppHeaderComponent,
    CustomerCartComponent,
    CustomerHeaderComponent,
    CustomerHomeComponent,
    CustomerOrderComponent,
    CustomerPaymentComponent,
    CustomerSignUpComponent,
    ChangePasswordComponent,
    ForgotPasswordComponent,
    PagingComponent,
    CustomerLoginComponent,
    OrderHistoryDialogeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDatepickerModule,
    MatMenuModule,
    NgbModule,
    MatDialogModule,
    MatSnackBarModule,
    HttpClientModule,
    MatIconModule,
    MatNativeDateModule,
    MatRippleModule,
    MatButtonModule,
    MatButtonToggleModule
    
   
  ],
  providers: [
    DatePipe
  ],
  schemas: [
    CUSTOM_ELEMENTS_SCHEMA
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
