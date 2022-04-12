package at.hb.photomanager.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * === PmPictureDto
 *
 */
@Getter
@Setter
public class PmPictureDto extends PmBaseDto {

    @NotNull
    private String filename;

    private PmExifDto pmExifDto;

    private String base64Tn; // base64 ecoded Thumbnail

}
