import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './shared/header/header.component';
import { FooterComponent } from './shared/footer/footer.component';
import { VehicleCardComponent } from './home/vehicle-card/vehicle-card.component';
import { VehiclesComponent } from './home/vehicles/vehicles.component';
import { VehicleService } from './service/vehicle.service';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { OneVehicleComponent } from './home/one-vehicle/one-vehicle.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { NewVehicleComponent } from './new-vehicle/new-vehicle.component';

const appRoutes: Routes = [
  { path: 'vehicles', component: VehiclesComponent},
  { path: 'vehicles/:id', component: OneVehicleComponent},
  { path: 'new-vehicle', component: NewVehicleComponent},
  { path: '', component: VehiclesComponent},
  { path: 'not-found', component: NotFoundComponent},
  { path: '**', redirectTo: '/not-found'}
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    VehicleCardComponent,
    VehiclesComponent,
    OneVehicleComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [VehicleService],
  bootstrap: [AppComponent]
})
export class AppModule { }
