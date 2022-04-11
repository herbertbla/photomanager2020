package at.hb.photomanager.main.service;

import at.hb.photomanager.dto.PmExifDto;

/**
 * === PbzService
 *
 *
 * @author blaschek
 */
public interface PmService {

    PmExifDto getExif(String completeFilename);

    String getBase64(String completeFilename);
}
