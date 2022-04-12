import {PmExifDto} from "./PmExifDto";
import {PmBaseDto} from "./PmBaseDto";

export interface PmPictureDto extends PmBaseDto{
  filename: string;
  pmExifDto: PmExifDto;
  base64Tn: string;
}

