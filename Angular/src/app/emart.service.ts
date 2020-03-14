import { Injectable } from '@angular/core';
import { Item } from './emart/Item';
import { Bill } from './emart/Bill';
import { Seller } from './emart/Seller';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Buyer } from './emart/Buyer';

@Injectable({
  providedIn: 'root'
})
export class EmartService {
  getcurrentBuyer(): Bill[] {
    throw new Error("Method not implemented.");
  }

  allItems: Item[];
  cartItems: any;
  allBills: any;
  currentBuyer: any;
  allSellers: Seller[];

  constructor(protected http: HttpClient) {
    this.allBills = [];
    this.cartItems = [];
  }

  getAllItems() {
    return this.http.get("http://localhost:8083/buyeritemservice/eMart/item/all");
  }

  setBuyerAndBills(currentBuyer) {
    this.currentBuyer = currentBuyer;
    this.allBills = currentBuyer.allBills;
  }
  setSellerAndBills(currentSeller) {
    this.currentBuyer = currentSeller;
    this.allBills = currentSeller.allBills;
  }

  getCurrentBuyer() {
    return this.currentBuyer;
  }

  getItem(itemId: string) {
    return this.http.get("http://localhost:8083/buyeritemservice/eMart/item/" + itemId);
  }

  addToCart(item: any) {
    this.cartItems.push(item);
  }

  getAllCart() {
    return [].concat(this.cartItems);
  }

  getAllBills() {
    return [].concat(this.allBills);
  }


  // Deleting the cart items //
  deleteCartItem(itemId: number) {
    let size = this.cartItems.length;
    for (let i = 0; i < size; i++) {
      if (this.cartItems[i].id == itemId) {
        this.cartItems.splice(i, 1);
        break;
      }
    }
  }

  //  to add Bill to the database 
  addBill(todayDate: Date, amt: number) {
    let allBillDetails: any[] = [];
    for (let i = 0; i < this.cartItems.length; i++) {
      allBillDetails.push({
        billDetailsId: 0,
        billPojo: null,
        itemPojo: this.cartItems[i]
      })
    };
    let bill: any = {
      billlId: 0,
      billType: 'Debit',
      billDate: todayDate,
      billRemarks: 'paid',
      billAmount: amt,
      buyerPojo: {
        buyerId: this.currentBuyer.buyerId
      },
      allBillDetails: allBillDetails
    }
    this.cartItems = [];
    return this.http.post("http://localhost:8083/buyeritemservice/eMart/bill", bill);
  }

  // Getting current buyer details 
  getBuyer() {
    return this.http.get("http://localhost:8083/loginservice/eMart/buyer/" + this.currentBuyer.buyerId);
  }
  presentBuyer(){
    return this.currentBuyer;
  }

  // Validate Buyer 
  validateBuyer(user: string, password: string) {
    let credentials = user + ':' + password;
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', credentials);
    return this.http.get("http://localhost:8083/loginservice/eMart/validate", { headers });
  }
  
  // Validate Seller 
 
  addBuyer(buyer){
   
    return this.http.post("http://localhost:8083/BuyerSignupService/eMart/buyer", buyer);
    
  }
  addSeller(seller:any){
   
    return this.http.post("http://localhost:8083/SellerSignupService/eMart/seller", seller);
}
validateSeller(user: string, password: string){
  let credentials = user + ':' + password;
    let headers = new HttpHeaders();
    headers = headers.set('Authorization', credentials);
    return this.http.get("http://localhost:8083/SellerSignupService/eMart/validateSeller", { headers });
}
}