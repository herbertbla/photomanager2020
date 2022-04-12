import {ChangeDetectionStrategy, Component, OnInit} from '@angular/core';
import {PmPictureDto} from '../model/PmPictureDto';
import {Observable} from 'rxjs';
import {PictureStore} from "../services/picture.store";
import {PmTreeStore} from "../pm-tree/pm-tree.store";
import {PmDirectoryDto} from "../model/PmDirectoryDto";


@Component({
    selector: 'home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
    changeDetection: ChangeDetectionStrategy.OnPush
})
export class HomeComponent implements OnInit {

    beginnerCourses$: Observable<PmPictureDto[]>;

    pmDirectoryDtos$: Observable<PmDirectoryDto[]>;

    constructor(private coursesStore: PictureStore,
                private pmTreeStore:PmTreeStore) {

    }

    ngOnInit() {
        this.initUi();
    }

    initUi() {
        this.beginnerCourses$ = this.coursesStore.filterByCategory("BEGINNER");
        this.pmDirectoryDtos$ = this.pmTreeStore.pmDirectoryDto$;
    }


}




