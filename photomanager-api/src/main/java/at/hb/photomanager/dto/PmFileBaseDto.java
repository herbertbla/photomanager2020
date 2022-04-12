package at.hb.photomanager.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author blascheh
 */
@Getter
@Setter
public class PmFileBaseDto extends PmBaseDto {
    protected PmDirectoryDto parent;
    protected String name;
}
