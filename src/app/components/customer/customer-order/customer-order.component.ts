import { Component } from '@angular/core';
import { Order } from '../../model/order.model';
import { Router } from '@angular/router';
import { WineshopService } from '../../service/wineshop.service';
import { DatePipe } from '@angular/common';
import { take } from 'rxjs';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-customer-order',
  templateUrl: './customer-order.component.html',
  styleUrls: ['./customer-order.component.css']
})
export class CustomerOrderComponent {

  orderList: Order[]=[];
  constructor(
    private wService: WineshopService,
    private router: Router,
    private datePipe : DatePipe,
    private dialog: MatDialog
  ) { 
    this.wService.isClientLoginPresent();
  }

  ngOnInit(): void {
    this.getOrderList();
  }
  getOrderList():void{
    this.wService.orderList(this.wService.getClientAuthorization()).pipe(take(1)).subscribe(
      (res: any) => {
        console.log("****",res);
        if(!!res && Array.isArray(res)){
          this.orderList=res;
        }
        
      }, err => {
        console.log("Error");
      }
    )
  }
  getDate(d:string|undefined):any{
    //return  !!d ? this.datePipe.transform(new Date(d),"" )?.toString(): "";
    //return this.datePipe.transform(d,"").toString();
    let ans :any;
    console.log("DDDDDD",d);
    if(!!d && d!== null){
      ans=this.datePipe.transform(d,"shortDate")||null;
      console.log("@@@@@@@@",ans);
    }
    return ans;
  }
  
  addPayment(order: Order): void {
    this.router.navigate([`/customer/payment/${order?.orderId}/${order?.totalPrice}`])
  }
  
  }

