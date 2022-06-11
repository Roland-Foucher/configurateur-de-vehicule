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
import { VehicleFormComponent } from './vehicle-form/vehicle-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormBuilderService } from './service/formBuilder.service';

const appRoutes: Routes = [
  { path: 'vehicles', component: VehiclesComponent},
  { path: 'vehicles/:id', component: OneVehicleComponent},
  { path: 'vehicles/edit/:type/:id', component:VehicleFormComponent},
  { path: 'new-vehicle', component: NewVehicleComponent},
  { path: 'new-vehicle/:type', component:VehicleFormComponent},
  { path: '', redirectTo: 'vehicles', pathMatch: 'prefix' },
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
    VehicleFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [VehicleService, FormBuilderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
