import { Component, OnInit } from '@angular/core';
import { WineshopService } from '../../service/wineshop.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent implements OnInit {
  userName: string = '';
  constructor(
    private wService: WineshopService
  ) {
    if (this.wService.getAdminName() !== null) {
      this.userName = this.wService.getAdminName();
    }
    this.wService.isAdminLoginPresent();
  }

  ngOnInit(): void {
  }

}