package at.gv.brz.justiz3.sv.photomanager.suche.dto;

import lombok.Data;


/**
 * === PbzArtefaktDto
 *
 * Ergebnis-DTO für die Personenbeziehungssuche
 *
 * @author blaschek
 */
@Data
public class PbzArtefaktDto {

    // leider müssen die Sortierkriterien auf 1. Ebene redundat zurückgegebenwerden
    private String nachname;
    private String nachnamebeziehung;
    private Integer hnr;

}
