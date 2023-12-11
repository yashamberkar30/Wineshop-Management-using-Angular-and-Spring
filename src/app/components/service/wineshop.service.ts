import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class WineshopService {

  url: string = 'http://localhost:2000';

  category: any = [{
    name: "WINES" , value: 0,
  }, {
    name: "BEER", value: 1,
  }, {
    name: "WHISKEY", value: 2
  }, {
    name: "RUM", value:  3
  },{
    name: "VODKA", value:  4
  }, {
    name: "SCOTCH", value:  5
  },{
    name: "BEVERAGES", value:  6
  }
];

  constructor(
    
   private http: HttpClient,
    private router: Router

  ) { }
  

  /* Client Registeration */
  signUp(body: any): Observable<any> {
    return this.http.post(this.url + "/customers/register", body);
  }
  //client login
  clientSignIn(body: any): Observable<any> {
    return this.http.post(this.url + "/customers/login", body);
  }
//once we logged in that time we are storing client id into token 
storeClientAuthorization(token: string): void {
  localStorage.setItem("token", token);
}

getClientAuthorization(): any {
  const token = localStorage.getItem("token");
  return token; 
}

storeClientUserName(name: string): void {
  localStorage.setItem("userName", name);
}

getClientName(): any {
  const name = localStorage.getItem("userName");
  return name;
}

clientLogout(): void {
  localStorage.clear();
  this.router.navigate(['']);
}
//admin login
adminSignIn(body: any): Observable<any> {
  return this.http.post(this.url + "/admin/login", body);
}
storeAdminAuthorization(token: string): void {
  localStorage.setItem("admin", token);
}
getAdminAuthorization(): any {
  const token = localStorage.getItem("admin");
  return token; 
}

storeAdminUserName(name: string): void {
  localStorage.setItem("adminName", name);
}

getAdminName(): any {
  const name = localStorage.getItem("adminName");
  return name;
}

adminLogout(): void {
  localStorage.clear();
  this.router.navigate(['/']);
}
//product controller
addProduct(body: any): Observable<any> {
  return this.http.post(this.url + "/products/add products", body);
}

getProductlist():Observable<any> {
  return this.http.get(this.url + "/products");
}

deleteProduct(id :any):Observable<any> {
  //return this.http.delete(this.url + "/api/products/" +id);
  //secondway
  return this.http.delete(`${this.url}/products/${id}`);
}

getProductById(id:any):Observable<any> {
  return this.http.get(this.url + "/products/products/"+id);
}


editProduct(body: any,id:any): Observable<any> {
  return this.http.put(this.url + "/products/"+id, body);
}
//cart 
addToCart(body: any,pid:any,cid:any):Observable<any>{
  return this.http.post(this.url+"/cart/"+cid+"/"+pid,body);
}

getCustomerById(id:any):Observable<any> {
  return this.http.get(this.url + "/customers/customer/"+id);
}

cartList():Observable<any>{
  return this.http.get(this.url+"/cart/list");
}
deleteCart(id :any):Observable<any> {
  
  return this.http.delete(`${this.url}/cart/${id}`);
}
//order
placeOrder(cid:any,cartid:any,body:any):Observable<any> {
  return this.http.post(this.url + "/orders/"+cid+"/"+cartid, body);
}

getAllorderList():Observable<any>{
  return this.http.get(this.url+"/orders/");
}


orderList(id:any):Observable<any>{
  return this.http.get(this.url+"/orders/"+id);
}

getCategoryList(): any {
  return this.category;
}
addPayment(body:any,orderid:any,cid:any):Observable<any> {
  return this.http.post(this.url + "/payements/"+orderid+"/"+cid, body);
}

isClientLoginPresent(): void {
  if (this.getClientAuthorization() === null) {
    this.router.navigate(['/customer-login']);
  }
}

isAdminLoginPresent(): void {
  if (this.getAdminAuthorization() === null) {
    this.router.navigate(['/admin-login']);
  }
}

forgotPassword(body: any):Observable<any> {
  return this.http.post(this.url + "/customers/forgotpassword", body);
}

updateCustomerInformation(body: any):Observable<any> {
  return this.http.put(this.url + "/customers/customer/"+body?.customerId, body);
}

changePassword(cid: any,password:any):Observable<any> {
  return this.http.post(this.url + "/customers/"+cid+"/"+password,{});
}

getProductByCategory(cid: any, offset: any, limit: any):Observable<any>{
  return this.http.get(this.url+"/products/" + cid + "/"+ offset + "/" + limit);
}

getAllProducts(offset: any, limit: any):Observable<any>{
  return this.http.get(this.url+"/products/" + offset + "/" + limit);
}

placeOrderItem(cid:any, body:any):Observable<any>{
  return this.http.post(this.url + "/orders/addOrder/"+cid+"/", body);
}
//admin registration
adminSignUp(body: any): Observable<any> {
  return this.http.post(this.url + "/admin/register", body);
}


}
