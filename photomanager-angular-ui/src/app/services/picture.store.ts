import {Injectable} from "@angular/core";
import {BehaviorSubject, Observable, throwError} from "rxjs";
import {catchError, map, shareReplay, tap} from "rxjs/operators";
import {HttpClient} from "@angular/common/http";
import {LoadingService} from "../loading/loading.service";
import {MessagesService} from "../messages/messages.service";
import {PmPictureDto} from "../model/PmPictureDto";

@Injectable({
    providedIn: 'root'
})
export class PictureStore {

    private subject = new BehaviorSubject<PmPictureDto[]>([]);

    pmPictureDtos$: Observable<PmPictureDto[]> = this.subject.asObservable();

    constructor(private http: HttpClient,
                private loadingService: LoadingService,
                private mesassagesService: MessagesService) {
        this.loadAllPictures()

    }

    filterByCategory(category: string): Observable<PmPictureDto[]> {
        return this.pmPictureDtos$;
    }

    saveCourse(courseId: number, changes:Partial<PmPictureDto>) : Observable<any> {

        //update im Behavior Subject ...
        const courses = this.subject.getValue();
        const index = courses.findIndex(course => course.id == courseId);

        const newCourse : PmPictureDto = {
            ...courses[index],
            ...changes
        };

        //complete copy of the courses array
        const newCourses : PmPictureDto[] = courses.slice(0);
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

    private loadAllPictures() {
        const id = "1";
        const loadCourses$ = this.http.get<PmPictureDto[]>('/api/loadpicturepage')
            .pipe(
                map(res => res["elements"]),
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
