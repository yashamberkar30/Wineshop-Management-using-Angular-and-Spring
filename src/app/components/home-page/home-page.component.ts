import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css'],
  providers: [NgbCarouselConfig]
})
export class HomePageComponent implements OnInit {
 logo:string="../../../assets/images/logo.png";
 /*images: string[] = [
   '../../../assets/images/wine2.jpeg',
    '../../../assets/images/wine1.jpeg',
   '../../../assets/images/wine3.jpg'
];*/

  constructor(
    config: NgbCarouselConfig,
    private route: Router
  ) {
    config.interval = 2000;
    config.keyboard = false;
    config.pauseOnHover = false;
  }

  ngOnInit(): void {
  }

  gotoLogin(): void {
    this.route.navigate(['/customers-login'])
  }

}
