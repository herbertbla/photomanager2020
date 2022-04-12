import {Component, Input, OnInit} from '@angular/core';
import {PmFileBaseDto} from "../model/PmFileBaseDto";

@Component({
  selector: 'pm-tree',
  templateUrl: './pm-tree.component.html',
  styleUrls: ['./pm-tree.component.scss']
})
export class PmTreeComponent implements OnInit {

  @Input()
  pmFileBaseDtos : PmFileBaseDto[];

  constructor() { }

  ngOnInit(): void {
  }

}
