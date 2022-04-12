import {Injectable} from '@angular/core';
import {BehaviorSubject, Observable, throwError} from "rxjs";
import {PmPictureDto} from "../model/PmPictureDto";
import {HttpClient} from "@angular/common/http";
import {LoadingService} from "../loading/loading.service";
import {MessagesService} from "../messages/messages.service";
import {catchError, map, tap} from "rxjs/operators";
import {PmDirectoryDto} from "../model/PmDirectoryDto";

@Injectable({
    providedIn: 'root'
})
export class PmTreeStore {

    private subject = new BehaviorSubject<PmDirectoryDto[]>([]);

    pmDirectoryDto$: Observable<PmDirectoryDto[]> = this.subject.asObservable();

    constructor(private http: HttpClient,
                private loadingService: LoadingService,
                private mesassagesService: MessagesService) {
        this.getdirectories(null);

    }

    private getdirectories(pmDirectoryDto: PmDirectoryDto) {
        this.http.get<PmDirectoryDto[]>('/api/getdirectories').pipe(
            tap(
                result =>
                    this.subject.next(result)
            )
        ).subscribe(res => res);
    }

}
