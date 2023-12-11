import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { AboutUsComponent } from './components/about-us/about-us.component';

import { AdminLoginComponent } from './components/admin/admin-login/admin-login.component';

import { ForgotPasswordComponent } from './components/forgot-password/forgot-password.component';
import { ChangePasswordComponent } from './components/change-password/change-password.component';
import { CustomerSignUpComponent } from './components/customer/customer-sign-up/customer-sign-up.component';
import { CustomerHomeComponent } from './components/customer/customer-home/customer-home.component';
import { CustomerCartComponent } from './components/customer/customer-cart/customer-cart.component';
import { CustomerOrderComponent } from './components/customer/customer-order/customer-order.component';
import { CustomerPaymentComponent } from './components/customer/customer-payment/customer-payment.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AdminAddproductsComponent } from './components/admin/admin-addproducts/admin-addproducts.component';
import { ProductListComponent } from './components/admin/product-list/product-list.component';
import { AdminOrderListComponent } from './components/admin/admin-order-list/admin-order-list.component';
import { CustomerLoginComponent } from './components/customer/customer-login/customer-login.component';

const routes: Routes = [
  {path:'',component:HomePageComponent},
  {path:'',component:HomePageComponent},
  {path:'contact-us',component:ContactUsComponent},
  {path:'about-us',component:AboutUsComponent},
  {path:'admin-login',component:AdminLoginComponent},
  {path:'customer-login',component:CustomerLoginComponent},
  {path: 'forgot-password',component:ForgotPasswordComponent},
  {path: 'change-password',component:ChangePasswordComponent},
  {path:'customer-register',component:CustomerSignUpComponent},
  {path:'customer-home',component:CustomerHomeComponent},
  {path:'customer',children:[
    {path:'home',component:CustomerHomeComponent},
   
    {path:'cart',component:CustomerCartComponent},
    {path:'order',component:CustomerOrderComponent},
    {path:'payment/:orderId/:totalPrice',component:CustomerPaymentComponent}
]},
{path:'admin',children:[
  {path:'home',component:AdminHomeComponent},
  {path: 'addproduct', component:AdminAddproductsComponent },
  {path:'listproduct',component:ProductListComponent},
  {path :'orderlist',component:AdminOrderListComponent}
]}

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
