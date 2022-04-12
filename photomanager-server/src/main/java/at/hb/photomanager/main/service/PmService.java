package at.hb.photomanager.main.service;

import at.hb.photomanager.dto.PmDirectoryDto;
import at.hb.photomanager.dto.PmExifDto;
import at.hb.photomanager.dto.PmFileBaseDto;

import java.util.List;

/**
 * === PbzService
 *
 *
 * @author blaschek
 */
public interface PmService {

    PmExifDto getExif(String completeFilename);

    String getBase64(String completeFilename);

    List<PmFileBaseDto> getDirectories(PmDirectoryDto parentDirectory);
}
