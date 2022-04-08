import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {PmPictureDto} from "../model/PmPictureDto";
import {map, shareReplay} from "rxjs/operators";
import {Lesson} from "../model/lesson";

@Injectable({
    providedIn: 'root'
})
export class PictureService {

    constructor(private httpClient: HttpClient) {
    }

    loadAllCourses(): Observable<PmPictureDto[]> {
        return this.httpClient.get<PmPictureDto[]>('/api/courses')
            .pipe(
                map(result => result["payload"]),
                shareReplay()
            );
    }

    saveCourse(courseId: string, changes: Partial<PmPictureDto>) : Observable<any> {
        return this.httpClient.put(`/api/courses/${courseId}`, changes).pipe(
            shareReplay()
        )
    }

    searchLessons(search : string) : Observable<Lesson[]> {
        return this.httpClient.get<Lesson[]>('/api/lessons/', {
            params: {
                filter: search,
                pageSize: "100"
            }
        }).pipe(
            map(res => res ["payload"]),
            shareReplay()
        );
    }

    loadCourseById(courseId: number) : Observable<PmPictureDto> {
        return this.httpClient.get<PmPictureDto>(`/api/courses/${courseId}`)
            .pipe(
                shareReplay()
            );
    }

    loadAllCourseLessons(courseId: number) : Observable<Lesson[]> {
        return this.httpClient.get<Lesson[]>('/api/lessons/', {
            params: {
                pageSize: "10000",
                courseId : courseId.toString()
            }
        }).pipe(
            map(res => res ["payload"]),
            shareReplay()
        );

    }
}
