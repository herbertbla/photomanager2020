import {Injectable} from "@angular/core";
import {BehaviorSubject, Observable, throwError} from "rxjs";
import {Course, sortCoursesBySeqNo} from "../model/course";
import {catchError, map, shareReplay, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {LoadingService} from "../loading/loading.service";
import {MessagesService} from "../messages/messages.service";

@Injectable({
    providedIn: 'root'
})
export class CoursesStore {

    private subject = new BehaviorSubject<Course[]>([]);

    courses$: Observable<Course[]> = this.subject.asObservable();

    constructor(private http: HttpClient,
                private loadingService: LoadingService,
                private mesassagesService: MessagesService) {
        this.loadAllCourses()

    }

    filterByCategory(category: string): Observable<Course[]> {
        return this.courses$
            .pipe(
                map(courses => courses.filter(course => course.category == category)
                    .sort(sortCoursesBySeqNo))
            )
    }

    saveCourse(courseId: string, changes:Partial<Course>) : Observable<any> {

        //update im Behavior Subject ...
        const courses = this.subject.getValue();
        const index = courses.findIndex(course => course.id == courseId);

        const newCourse : Course = {
            ...courses[index],
            ...changes
        };

        //complete copy of the courses array
        const newCourses : Course[] = courses.slice(0);
        newCourses[index] = newCourse;
        this.subject.next(newCourses);

        // und nun zum Server schicken
        return this.http.put(`/api/courses/${courseId}`, changes)
            .pipe(
                catchError(err => {
                    const message = "Kann nicht speichern";
                    console.log(message, err);
                    this.mesassagesService.showErrors(message);
                    return throwError(err);
                }),
                shareReplay()
            );


    }

    private loadAllCourses() {
        const loadCourses$ = this.http.get<Course[]>('/api/courses')
            .pipe(
                map(response => response["payload"]),
                catchError(err => {
                    const message = "Could not load courses";
                    this.mesassagesService.showErrors(message)
                    console.log(message, err);
                    return throwError(err);

                }),
                tap(courses => this.subject.next(courses))
            );
       this.loadingService.showLoaderUntilCompleted(loadCourses$).subscribe(result => {
       })
    }
}
