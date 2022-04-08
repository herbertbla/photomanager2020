import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'photo',
  templateUrl: './photo.component.html',
  styleUrls: ['./photo.component.scss']
})
export class PhotoComponent implements OnInit {

  @Input()
  id: string;

  constructor() { }

  ngOnInit(): void {
  }

}
