package at.hb.photomanager.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author rahmanis
 */
@Data
public class PhotoPageDto extends PageDto<PhotoDto> {

    public PhotoPageDto() {
        super(new ArrayList<>(), 0);
    }

    public PhotoPageDto(Collection<PhotoDto> elements, long totalCount) {
        super(elements, totalCount);
    }
}
