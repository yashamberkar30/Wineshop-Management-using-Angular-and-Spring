import { Component, OnInit } from '@angular/core';
import { WineshopService } from '../../service/wineshop.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';
import { Cart } from '../../model/cart.model';
import { Product } from '../../model/product.model';
import { forkJoin, take } from 'rxjs';


@Component({
  selector: 'app-customer-cart',
  templateUrl: './customer-cart.component.html',
  styleUrls: ['./customer-cart.component.css']
})
export class CustomerCartComponent implements OnInit{

  cartList: Cart[] = [];
  cartListBackup: Cart[] = [];
  grandTotal: number = 0;
  customer: any = {};

  constructor(
    private wService: WineshopService,
    private router: Router,
    private datePipe: DatePipe
  ) {
    this.wService.isClientLoginPresent();
    this.getCartList();
    this.getCustomerDetail();
  }

  ngOnInit(): void {
  }
  getCartList(): void {
    this.wService.cartList().pipe(take(1)).subscribe(
      (res: any) => {
        console.log("****", res);
        if (!!res && Array.isArray(res)) {
          const customerFilter = res.filter((item: Cart)=> item?.customer?.customerId === parseInt(this.wService.getClientAuthorization()));
          console.log("customer filter::::::",customerFilter);
          this.cartList = customerFilter;
          this.cartListBackup = customerFilter;
          if (this.cartList.length > 0) {
            this.cartList.map((item: Cart) => {
              this.grandTotal += (item?.mrpPrice * item?.quantity);
            })
          }
        }
      }, (err: any) => {
        console.log("error");
      }

    );
  }
  getTotal(quantity: number = 0, mrpPrice: number = 0): number {
    return quantity * mrpPrice;
  }
  placeOrder(): void {
    let totalPrice: number = 0;
    const deleteCartReq:any[]=[];
    const productItems: Array<Product> = [];
    this.cartList.forEach((item: Cart) => {
      productItems.push(item?.product);
      totalPrice += (item?.mrpPrice * item?.quantity);
      deleteCartReq.push(this.wService.deleteCart(item?.cartId));
    });
    console.log('>>>>>>>>', totalPrice)
    const body: any = {
      totalPrice: totalPrice,
      orderStatus: "success",
      paymentStatus: "success",
      orderedDate: this.datePipe.transform(new Date(), 'yyyy-MM-dd'),
      customer: this.customer,
      productname: 'xxxxx',
      image: 'xxxxx',
      product: productItems
    };
    this.wService.placeOrderItem(this.customer?.customerId, body).pipe(take(1)).subscribe((res: any) => {
      console.log('>>>>>>>', res);
      forkJoin(deleteCartReq).pipe(take(1)).subscribe();
      alert("Place order Sucessfully");
      this.router.navigate(["/customer/order"]);
    })
    

  }

  getCustomerDetail(): void {
    const cid = this.wService.getClientAuthorization();
    this.wService.getCustomerById(cid).pipe(take(1)).subscribe(
      (res: any) => {
        console.log("Customer***", res);
        if (!!res && res?.customerId) {
          this.customer = res;
        }
      }, (err: any) => {
        console.log("Err");
      }
    )
  }

  deleteCart(cart:Cart, showAlert: boolean = true):void{
    this.wService.deleteCart(cart?.cartId).pipe(take(1)).subscribe(
      (res: any) => {
        if (showAlert) {
          alert("Product deleted sucessfully");
        }
       
        this.getCartList();
      }, (err: any) => {
        console.log("Err");
      }
    )
  }

  onIncreaseQunatity(cart: Cart): void {
    const index = this.cartList.findIndex((item: Cart) => item.cartId === cart?.cartId);
    // const bac = Object.assign(this.cartListBackup);
    const indexBackup = this.cartListBackup.findIndex((item: Cart) => item.cartId === cart?.cartId);
    const qty = cart.quantity + 1;
   //  console.log( this.cartListBackup[indexBackup].quantity , '>>>>>>' , (cart.product?.quantity ))
    if (qty > (cart.product?.quantity  + this.cartListBackup[indexBackup].quantity) ) {
      alert('Added quantity should not greater than avaiable quantity');
      return;
    }
    this.cartList[index].quantity = qty;
    this.updateGrantTotal();
  }

  onDecreaseQunatity(cart: Cart): void {
    const index = this.cartList.findIndex((item: Cart) => item.cartId === cart?.cartId);
    const qty = cart.quantity - 1;
    if (qty === 0) {
      this.deleteCart(cart, false);
    }
    this.cartList[index].quantity = qty;
    this.updateGrantTotal();
  }

  updateGrantTotal(): void {
    let total = 0;
    this.cartList.map((item: Cart) => {
      total+= (item?.mrpPrice * item?.quantity);
     
    })
    this.grandTotal = total;
  }

}

