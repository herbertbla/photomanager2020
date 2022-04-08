import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {Lesson} from '../model/lesson';
import {PictureService} from "../services/picture.service";


@Component({
    selector: 'course',
    templateUrl: './search-lessons.component.html',
    styleUrls: ['./search-lessons.component.css'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class SearchLessonsComponent implements OnInit {

    searchResults$: Observable<Lesson[]>;

    activeLesson: Lesson;

    constructor(private coursesService: PictureService) {


    }

    ngOnInit() {


    }

    onSearch(value: string) {

        this.searchResults$ = this.coursesService.searchLessons(value);

    }

    openLesson(lesson: Lesson) {
        this.activeLesson = lesson;

    }

    onBackToSearch() {
        this.activeLesson = null;

    }
}











