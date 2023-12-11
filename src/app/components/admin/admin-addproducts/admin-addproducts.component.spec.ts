import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminAddproductsComponent } from './admin-addproducts.component';

describe('AdminAddproductsComponent', () => {
  let component: AdminAddproductsComponent;
  let fixture: ComponentFixture<AdminAddproductsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AdminAddproductsComponent]
    });
    fixture = TestBed.createComponent(AdminAddproductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
