import { Component, Input, OnInit } from '@angular/core';
import { VehicleDto } from '../models/VehicleDto.models';

@Component({
  selector: 'app-vehicle-card',
  templateUrl: './vehicle-card.component.html',
  styleUrls: ['./vehicle-card.component.scss']
})
export class VehicleCardComponent implements OnInit {

  @Input() vehicle!: VehicleDto;
  constructor() { }

  ngOnInit(): void {
  }

}
