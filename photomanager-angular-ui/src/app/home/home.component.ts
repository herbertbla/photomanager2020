import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {PmPictureDto} from '../model/PmPictureDto';
import {Observable} from 'rxjs';
import {PictureStore} from "../services/picture.store";


@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomeComponent implements OnInit {

    beginnerCourses$: Observable<PmPictureDto[]>;

    advancedCourses$: Observable<PmPictureDto[]>;

    constructor(private coursesStore: PictureStore) {

    }

    ngOnInit() {
        this.reloadCourses();
    }

    reloadCourses() {
        this.beginnerCourses$ = this.coursesStore.filterByCategory("BEGINNER");
        this.advancedCourses$ = this.coursesStore.filterByCategory("ADVANCED");
    }


}




