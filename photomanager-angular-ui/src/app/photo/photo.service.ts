import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable, throwError} from "rxjs";
import {catchError, map, shareReplay} from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class PhotoService {

    constructor(private httpClient: HttpClient) {
    }

    loadPhoto(id: number): Observable<string> {
        return this.httpClient.get(`/api/loadphoto/${id}`,
            {responseType: 'text'}
        ).pipe(
            map(res => {
                console.log(res);
                return res;
            }),
            catchError(err => {
                const message = "Kann nicht speichern";
                console.log(message, err);
                return throwError(err);
            }),
            shareReplay()
        )
    }
}
