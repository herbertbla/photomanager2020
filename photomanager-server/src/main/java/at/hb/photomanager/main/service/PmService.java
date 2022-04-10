package at.hb.photomanager.main.service;

import at.hb.photomanager.dto.PmExifDto;

/**
 * === PbzService
 *
 * Service zur Abfrage von Insassen und deren Personenbeziehungen
 *
 * @author blaschek
 */
public interface PmService {

    PmExifDto getExif(String completeFilename);
}
