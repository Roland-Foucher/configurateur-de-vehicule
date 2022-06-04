import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { VehicleService } from 'src/app/service/vehicle.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  constructor(private vehicleService: VehicleService, private router: Router) { }

  ngOnInit(): void {
  }

  initDatabase(){
    this.vehicleService.initDatabase();
  }
}
