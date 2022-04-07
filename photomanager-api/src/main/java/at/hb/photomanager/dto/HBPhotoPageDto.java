package at.hb.photomanager.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author rahmanis
 */
@Data
public class HBPhotoPageDto extends PageDto<HBPhotoDto> {

    public HBPhotoPageDto() {
        super(new ArrayList<>(), 0);
    }

    public HBPhotoPageDto(Collection<HBPhotoDto> elements, long totalCount) {
        super(elements, totalCount);
    }
}
