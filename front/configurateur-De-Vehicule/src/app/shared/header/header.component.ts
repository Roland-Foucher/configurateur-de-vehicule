import { Component, OnInit } from '@angular/core';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private vehicleService: VehicleService) { }

  ngOnInit(): void {
  }

  initDatabase(){
    this.vehicleService.initDatabase();

  }
}
