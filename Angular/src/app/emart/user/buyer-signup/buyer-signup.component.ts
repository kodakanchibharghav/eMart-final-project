import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmartService } from 'src/app/emart.service';


@Component({
  selector: 'app-buyer-signup',
  templateUrl: './buyer-signup.component.html',
  styleUrls: ['./buyer-signup.component.css']
})
export class BuyerSignupComponent implements OnInit {
  buyerUsername:string='';
  buyerPassword:string='';
  buyerEmail:string='';
  buyerMobile:number;
  buyerDate:Date=new Date();

  buyers: any;
  constructor(protected router: Router,protected emartService: EmartService) { }

  ngOnInit(): void {
  }
    addBuyer(){
    
      let buyer = {
        buyerId:0,
        buyerUsername:this.buyerUsername,
        buyerPassword:this.buyerPassword,
        buyerEmail:this.buyerEmail,
        buyerMobile:this.buyerMobile,
        buyerDate:this.buyerDate
                          
      };
      
      
      this.emartService.addBuyer(buyer).subscribe(
        (response: any)=>{
         // this.buyers.push(response);
        }
      );
      
  this.router.navigate(['']);
  }
}

 