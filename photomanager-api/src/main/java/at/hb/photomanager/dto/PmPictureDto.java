package at.hb.photomanager.dto;


import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * === PmPictureDto
 *
 */
@Data
public class PmPictureDto {

    @NotNull
    private Long id; //ID des Insassen (für Security Check)

    @NotNull
    private String dir;

    @NotNull
    private String filename;

    private DateTime aufnahmedatum;

}
