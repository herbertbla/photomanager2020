import {PmDirectoryDto} from "./PmDirectoryDto";
import {PmBaseDto} from "./PmBaseDto";

export interface PmFileBaseDto extends PmBaseDto{
    parent: PmDirectoryDto;
    name: string;
}

