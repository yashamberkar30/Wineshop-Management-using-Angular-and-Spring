import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { WineshopService } from '../../service/wineshop.service';
//import { take } from 'rxjs';
import { take } from 'rxjs/operators';

@Component({
  selector: 'app-customer-login',
  templateUrl: './customer-login.component.html',
  styleUrls: ['./customer-login.component.css']
})
export class CustomerLoginComponent implements OnInit {
  email: string = "";
  password: string = "";
  customerLoginForm: FormGroup; 

  constructor(
    private router: Router,
    private wservice: WineshopService,
    private fb: FormBuilder
  ) {
    const pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
    this.customerLoginForm = this.fb.group({
      email: ['', [Validators.required, Validators.pattern(pattern)]],
      password: [null, Validators.compose([Validators.required, Validators.minLength(8)]),
      ]
    });
  }

  ngOnInit(): void {
  }

  signIn(): void {
    const body: {
      emailID: string;
      password: string;
    } = {
      emailID: this.customerLoginForm.controls['email'].value,
      password: this.customerLoginForm.controls['password'].value
    };
  
    console.log("=======>", body);
    this.wservice.clientSignIn(body).pipe(take(1)).subscribe((res: any) => {
      console.log("***", res);
      if (res && res?.customerId) {
        // alert("Login successful");
        this.wservice.storeClientAuthorization(res?.customerId);
        let userName = '';
        if (res?.firstName) {
          userName += res?.firstName;
        }
        if (res?.lastName) {
          userName += ' ' + res?.lastName;
        }
        this.wservice.storeClientUserName(userName);
        this.router.navigate(['/customer/home']);
      }
    }, (err: any) => {
      console.log("Error  ", err);
      alert("Something's going wrong in login!! Please try again");
    })
  }

  routeToNewUser(): void {
    this.router.navigate(["/customer-register"]);
  }

  routeToForgotPassword(): void {
    this.router.navigate(["/forgot-password"]);
  }
}
