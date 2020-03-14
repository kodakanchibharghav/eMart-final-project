import { Component, OnInit } from '@angular/core';
import { Bill } from '../../bill';
import { EmartService } from 'src/app/emart.service';
import { Item } from '../../Item';
import { Router } from '@angular/router';

@Component({

  selector: 'app-bill-list',

  templateUrl: './bill-list.component.html',

  styleUrls: ['./bill-list.component.css']

})

export class BillListComponent implements OnInit {
  allBills: Bill[];
  cartItems: Item[];
  buyerName: string = '';
  buyerId: string = '';
  buyerDate: string = '';
  buyerContact: string = '';
  amount: number = 0;
  showBill: boolean;
  currentBuyer: any

  constructor(protected emartService: EmartService, protected router: Router) { }

  ngOnInit(): void {

    this.currentBuyer = this.emartService.getCurrentBuyer();
    this.allBills = this.emartService.getAllBills();
    if (this.allBills.length == 0) {
      this.showBill = false;
    }
    else {
      this.showBill = true;
    }
  }
}