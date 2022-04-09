import {ChangeDetectionStrategy, Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {PmPictureDto} from "../model/PmPictureDto";
import {MatDialog, MatDialogConfig} from "@angular/material/dialog";
import {CourseDialogComponent} from "../course-dialog/course-dialog.component";
import {filter, tap} from "rxjs/operators";

@Component({
  selector: 'courses-card-list',
  templateUrl: './picture-card-list.component.html',
  styleUrls: ['./picture-card-list.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class PictureCardListComponent implements OnInit {

  @Input()
  pmPictureDtos: PmPictureDto[] = [];

  @Output()
  private coursesChanged = new EventEmitter();

  constructor(private dialog: MatDialog) { }

  ngOnInit(): void {
  }


  editCourse(course: PmPictureDto) {

    const dialogConfig = new MatDialogConfig();

    dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    dialogConfig.width = "400px";

    dialogConfig.data = course;

    const dialogRef = this.dialog.open(CourseDialogComponent, dialogConfig);

    dialogRef.afterClosed()
        .pipe(
            filter(val => !!val),
            tap(() => this.coursesChanged.emit())

        )
        .subscribe()

  }
}
