import {AfterViewInit, ChangeDetectionStrategy, Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Data} from '@angular/router';
import {PmPictureDto} from '../model/PmPictureDto';
import {
  debounceTime,
  distinctUntilChanged,
  startWith,
  tap,
  delay,
  map,
  concatMap,
  switchMap,
  withLatestFrom,
  concatAll, shareReplay, catchError
} from 'rxjs/operators';
import {merge, fromEvent, Observable, concat, throwError, combineLatest} from 'rxjs';
import {Lesson} from '../model/lesson';
import {PictureService} from "../services/picture.service";

interface CourseData {
  course: PmPictureDto;
  lessons: Lesson[];
}

@Component({
  selector: 'course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class CourseComponent implements OnInit {

  data$: Observable<CourseData>;

  constructor(private route: ActivatedRoute,
              private coursesService: PictureService
              ) {


  }

  ngOnInit() {

    const courseId = parseInt(this.route.snapshot.paramMap.get("courseId"));

    const course$ = this.coursesService.loadCourseById(courseId).pipe(
        startWith(null)
    );

    const lessons$ = this.coursesService.loadAllCourseLessons(courseId).pipe(
        startWith([])
    );

    this.data$ = combineLatest(course$, lessons$)
        .pipe(
            map(([course,lessons]) => {
              return {
                course,
                lessons
              }
            }),
            tap(console.log)
        );
  }


}











