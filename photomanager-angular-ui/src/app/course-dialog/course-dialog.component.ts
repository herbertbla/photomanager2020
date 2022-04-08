import {AfterViewInit, Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {PmPictureDto} from "../model/PmPictureDto";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import * as moment from 'moment';
import {MessagesService} from "../messages/messages.service";
import {PictureStore} from "../services/picture.store";

@Component({
    selector: 'course-dialog',
    templateUrl: './course-dialog.component.html',
    styleUrls: ['./course-dialog.component.css'],
    providers: [
        MessagesService
    ]
})
export class CourseDialogComponent implements AfterViewInit {

    form: FormGroup;

    course: PmPictureDto;

    constructor(
        private fb: FormBuilder,
        private dialogRef: MatDialogRef<CourseDialogComponent>,
        @Inject(MAT_DIALOG_DATA) course: PmPictureDto,
        private coursesStore: PictureStore,
        private messagesService: MessagesService) {

        this.course = course;

        this.form = fb.group({
            //description: [course.description, Validators.required],
           // category: [course.category, Validators.required],
           // releasedAt: [moment(), Validators.required],
            //longDescription: [course.longDescription, Validators.required]
        });


    }

    ngAfterViewInit() {

    }

    save() {

        const changes = this.form.value;
        this.coursesStore.saveCourse(this.course.id, changes).subscribe();
        this.dialogRef.close(changes)
    }

    close() {
        this.dialogRef.close();
    }

}
