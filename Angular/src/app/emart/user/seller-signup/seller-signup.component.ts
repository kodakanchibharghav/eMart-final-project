import { Component, OnInit } from '@angular/core';
import { EmartService } from 'src/app/emart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-seller-signup',
  templateUrl: './seller-signup.component.html',
  styleUrls: ['./seller-signup.component.css']
})
export class SellerSignupComponent implements OnInit {

  sellerUsername:string='';
  sellerPassword:string='';
  sellerCompany:string='';
  sellerGst:number;
  sellerBrief:string='';
  sellerAddress:string='';
  sellerEmail:string='';
  sellerWebsite:string='';
  sellerContact:number;
  sellers:any;



  constructor(protected emartService:EmartService,protected router:Router) { }

  ngOnInit(): void {
  }

  addSeller(){

    let seller = {

      id:0,
      username:this.sellerUsername,
      password:this.sellerPassword,
      company:this.sellerCompany,
      gst:this.sellerGst,
      brief:this.sellerBrief,
      address:this.sellerAddress,
      email:this.sellerEmail,
      website:this.sellerWebsite,
      contact:this.sellerContact

    };
    this.emartService.addSeller(seller).subscribe(
      (response: any)=>{

      }
    );

    this.router.navigate(['/login']);
  }

}
