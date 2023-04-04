import { Component } from '@angular/core';
import { BancoModel } from './models/BancoModel';
import { BancoService } from './service/BancoService';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {


  public banco: BancoModel = new BancoModel();
  
  constructor(private bancoService: BancoService) { }


  salvar(): void {

    this.bancoService.salvar(this.banco).subscribe(element => {
      this.banco = new BancoModel();
      console.log("Deu Certo!!!");

    })

  }
}
