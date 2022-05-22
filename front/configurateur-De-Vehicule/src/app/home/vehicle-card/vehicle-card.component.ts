import { Component, Input, OnInit } from '@angular/core';
import { SmallVehicleDTO } from 'src/app/models/SmallVehicleDTO.models';
import { VehicleType } from '../../enum/VehicleType';
import { VehicleDto } from '../../models/VehicleDto.models';

@Component({
  selector: 'app-vehicle-card',
  templateUrl: './vehicle-card.component.html',
  styleUrls: ['./vehicle-card.component.scss']
})
export class VehicleCardComponent implements OnInit {

  @Input() vehicle!: SmallVehicleDTO;

  imageSource!: String;

  ngOnInit(): void {

    this.imageSource = this.vehicle.vehiculeType === VehicleType.CAR ? "https://media.larmoiredebebe.com/ab/products/00/05/90/73/AB0005907354_1.jpg" :
                        this.vehicle.vehiculeType === VehicleType.MOTO ? "https://m.media-amazon.com/images/I/61+wIDiVDJL._AC_SL1000_.jpg" :
                        this.vehicle.vehiculeType === VehicleType.BIKE ? "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRr2uySO194IXZU9FA4fg2jkqqChR06bLyqHrS1tIMQTBssnzTqAdx95kSWsWEvklXIPL8&usqp=CAU" :
                        "https://cdn.pixabay.com/photo/2015/11/03/08/56/question-mark-1019820_1280.jpg"
  }

}
