import { Component, OnInit } from '@angular/core';
import { Item } from '../../Item';
import { EmartService } from 'src/app/emart.service';
import { Router } from '@angular/router';
import { Bill } from '../../Bill';

@Component({
  selector: 'app-bill-view',
  templateUrl: './bill-view.component.html',
  styleUrls: ['./bill-view.component.css']
})
export class BillViewComponent implements OnInit {
  cartItems: any;
  bill: Bill[];
  buyerName: string = 'megha';
  buyerId: string = '901';
  todayDate: Date = new Date();
  amount: number = 0;
  currentBuyer: any;

  constructor(protected emartService: EmartService, protected router: Router) { }

  ngOnInit(): void {
    this.cartItems = this.emartService.getAllCart();
    let size = this.cartItems.length;
    for (let i = 0; i < size; i++) {
      this.amount = this.amount + this.cartItems[i].itemPrice;
    }
  }

  addBill() {
    this.emartService.addBill(this.todayDate, this.amount).subscribe(
      (res) => {
        this.emartService
          .getBuyer()
          .subscribe((response) => {
            this.currentBuyer = response;
            this.emartService.setBuyerAndBills(this.currentBuyer);
          }
          )
      }
    );
    this.router.navigate(['item-list']);
  }
}