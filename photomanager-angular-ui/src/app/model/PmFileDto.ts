import {PmPictureDto} from "./PmPictureDto";
import {PmFileBaseDto} from "./PmFileBaseDto";

export interface PmFileDto extends PmFileBaseDto{
    pmPictureDto: PmPictureDto;
}

