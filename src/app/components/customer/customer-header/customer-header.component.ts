import { Component, OnInit } from '@angular/core';
import { WineshopService } from '../../service/wineshop.service';
import { NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-customer-header',
  templateUrl: './customer-header.component.html',
  styleUrls: ['./customer-header.component.css']
})
export class CustomerHeaderComponent implements OnInit{

  url: string = "/customer/home";
  userName: string = '';
  constructor(
    private wService :WineshopService,
    private router:Router
  ) {
    if (this.wService.getClientName() !== null) {
      this.userName = this.wService.getClientName();
    }
  }

  ngOnInit(): void {
    this.router.events.pipe(
      filter(event => event instanceof NavigationStart)
    ).subscribe((event: any) => {
      this.url = event?.url;
    });
  }
  routerToLink(link: string): void {
    if (link === '/customer/logout') {
      this.wService.clientLogout();
      return;
    }
    this.router.navigate([link]);
  }

}
