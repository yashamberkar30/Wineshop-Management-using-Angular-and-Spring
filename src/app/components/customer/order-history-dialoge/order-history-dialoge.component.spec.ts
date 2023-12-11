import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderHistoryDialogeComponent } from './order-history-dialoge.component';

describe('OrderHistoryDialogeComponent', () => {
  let component: OrderHistoryDialogeComponent;
  let fixture: ComponentFixture<OrderHistoryDialogeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OrderHistoryDialogeComponent]
    });
    fixture = TestBed.createComponent(OrderHistoryDialogeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
