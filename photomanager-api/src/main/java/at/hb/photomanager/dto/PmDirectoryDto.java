package at.hb.photomanager.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author blascheh
 */
@Getter
@Setter
public class PmDirectoryDto extends PmFileBaseDto {
    protected List<PmFileBaseDto> pmFileBaseDtos;
}
