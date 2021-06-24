import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calcularhoras',
  templateUrl: './calcularhoras.component.html',
  styleUrls: ['./calcularhoras.component.css']
})
export class CalcularhorasComponent implements OnInit {

  horas:number = 0
  precio:number = 10
  sueldo:number = 0
  bono:number = 0
  constructor() { }

  ngOnInit(): void {
  }
  calcular(){
    this.bono = this.horas>40?300:0
    this.sueldo = this.bono + this.horas*this.precio
    console.log(this.bono)
    console.log(this.sueldo)
  }
}
