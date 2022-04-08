import {Component, Input, OnInit} from '@angular/core';
import {PhotoService} from "./photo.service";
import {Observable} from "rxjs";

@Component({
  selector: 'photo',
  templateUrl: './photo.component.html',
  styleUrls: ['./photo.component.scss']
})
export class PhotoComponent implements OnInit {

  @Input()
  id: number;
  data$: Observable<string>;

  constructor(private photoService:PhotoService) {

  }

  ngOnInit(): void {
    this.data$ = this.photoService.loadPhoto(this.id);
  }

}
