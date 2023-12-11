import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs';
import { WineshopService } from '../service/wineshop.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.css']
})
export class ForgotPasswordComponent implements OnInit{
  email: string= '';
  isShowChangePassword: boolean = false;
  newPassword: string = '';
  customer: any;
  constructor(
    private wService: WineshopService,
    private route: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit(): void {
    const body = {
      emailID: this.email
    };
    this.wService.forgotPassword(body).pipe(take(1)).subscribe((res) => {
      if (!!res && res?.customerId) {
        this.customer = res;
        this.isShowChangePassword = true;
      }
    },err => {
      this.isShowChangePassword = false;
      alert("Customer not found . Please check email address.")
    });
  }

  onChangePassword(): void {
    this.customer.password = this.newPassword;
    this.wService.changePassword(this.customer?.customerId,this.newPassword).pipe(take(1)).subscribe((res) => {
      if (res && res.customerId) {
        alert("Password has been change successfully");
        this.route.navigate(["/customers-login"]);
      }
    },error => { 
      alert("Error occured while change password.");
    });
  }

}

