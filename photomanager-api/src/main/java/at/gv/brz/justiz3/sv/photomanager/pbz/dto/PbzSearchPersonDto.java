package at.gv.brz.justiz3.sv.photomanager.pbz.dto;


import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.NotNull;

/**
 * === PbzSearchPersonDto
 *
 * Dto zur Ermittlung bestehender Bezugspersonen
 *
 * @author Schinko
 */
@Data
public class PbzSearchPersonDto {

    @NotNull
    private Long insasseId; //ID des Insassen (für Security Check)

    @NotNull
    private String nachname;

    @NotNull
    private String vorname;

    private DateTime geburtsdatum;

}
