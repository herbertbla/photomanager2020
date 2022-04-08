export interface PmPhotoDto {
    id: string;
    data: string;
    dimX: number;
    dimY: number;
    aufloesung: string;
    aufnahmedatum: Date
}


export function sortPicturesByAufnahmedatum(c1: PmPhotoDto, c2: PmPhotoDto) {
    return c1.aufnahmedatum.getMilliseconds() - c2.aufnahmedatum.getMilliseconds();
}
