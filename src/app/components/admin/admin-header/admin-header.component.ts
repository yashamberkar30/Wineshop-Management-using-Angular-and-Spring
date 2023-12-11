import { AfterViewInit, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { WineshopService } from '../../service/wineshop.service';
import { NavigationStart, Router } from '@angular/router';
import { filter } from 'rxjs';

@Component({
  selector: 'app-admin-header',
  templateUrl: './admin-header.component.html',
  styleUrls: ['./admin-header.component.css']
})
export class AdminHeaderComponent implements OnInit{
 url: string = '';
  userName: string = '';
  constructor(
    private wService :WineshopService,
    private router:Router,
    private changeDetector: ChangeDetectorRef
  ) {
    if (this.wService.getAdminName() !== null) {
      this.userName = this.wService.getAdminName();
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
    if (link === '/admin/logout') {
      this.wService.adminLogout();
      return;
    }
    this.router.navigate([link]);
  }

}