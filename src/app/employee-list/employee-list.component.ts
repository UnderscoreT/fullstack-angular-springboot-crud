import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrl: './employee-list.component.css'
})
export class EmployeeListComponent implements OnInit {
  
  employees!: Employee[];
  constructor(){}
  ngOnInit(): void {
    this.employees=[{
      "id": 1,
      "firstName": "Obey",
      "lastName": "Sibanda",
      "emailId": "obeyblessing@gmail.com"
      },
      {"id": 2,
      "firstName": "Beaulah",
      "lastName": "Sibanda",
      "emailId": "beaulah@gmail.com"
      
  }]

  }
 

}
