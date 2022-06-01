import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ImageUrl } from '../enum/ImageUrl';

@Component({
  selector: 'app-new-vehicle',
  templateUrl: './new-vehicle.component.html',
  styleUrls: ['./new-vehicle.component.scss']
})
export class NewVehicleComponent implements OnInit {

  carUrl: ImageUrl = ImageUrl.CAR;
  motoUrl:ImageUrl = ImageUrl.MOTO;
  bikeUrl:ImageUrl = ImageUrl.BIKE

  constructor(private router: Router) { }

  ngOnInit(): void {

  }

  newForm(imageUrl: ImageUrl)
  {
    switch (imageUrl) {
      case ImageUrl.CAR:
        this.router.navigate(["/new-vehicle/car"]);
        break;
      case ImageUrl.MOTO:
        this.router.navigate(["/new-vehicle/moto"]);
        break;
      case ImageUrl.BIKE:
        this.router.navigate(["new-vehicle/bike"]);
        break;
      default:
        this.router.navigate(["not-found"]);
        break;
    }

  }


}
