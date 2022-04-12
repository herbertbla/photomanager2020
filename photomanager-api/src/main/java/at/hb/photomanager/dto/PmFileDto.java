package at.hb.photomanager.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author blascheh
 */
@Getter
@Setter
public class PmFileDto extends PmFileBaseDto {
    private PmPictureDto pmPictureDto;
}
