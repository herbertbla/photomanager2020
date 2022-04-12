import {PmPictureDto} from "./PmPictureDto";
import {PmFileBaseDto} from "./PmFileBaseDto";

export interface PmDirectoryDto extends PmFileBaseDto{
  pmPictureDtoList : PmPictureDto[];
}

