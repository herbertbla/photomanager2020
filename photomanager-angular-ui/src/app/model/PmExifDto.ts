import {PmBaseDto} from "./PmBaseDto";

export interface PmExifDto extends PmBaseDto{
    height: number;
    width: number;
    widthTn: number;
    heightTn: number;
    xRes: number;
    yRes: number;
    orientation: number;
    date: Date
    filename: string;
    filesize: number;
    modifiedDate: Date;
}


export function sortPicturesByAufnahmedatum(c1: PmExifDto, c2: PmExifDto) {
    return c1.date.getMilliseconds() - c2.date.getMilliseconds();
}
