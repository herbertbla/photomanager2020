package at.hb.photomanager.main.service.impl;

import at.hb.photomanager.dto.PmExifDto;
import at.hb.photomanager.file.PmFileServiceImpl;
import at.hb.photomanager.main.service.PmService;
import com.drew.metadata.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * @author blascheh
 */
@Service
public class PmServiceImpl implements PmService {

    private final ConversionService conversionService;
    private final PmFileServiceImpl pmFileService;

    @Autowired
    public PmServiceImpl(ConversionService conversionService, PmFileServiceImpl pmFileService) {
        this.conversionService = conversionService;
        this.pmFileService = pmFileService;
    }

    @Override
    public PmExifDto getExif(String completeFileName) {

        Metadata exif = pmFileService.getExif(completeFileName);
        PmExifDto pmExifDto = this.conversionService.convert(exif, PmExifDto.class);

        return null;
    }

    @Override
    public String getBase64(String completeFilename) {
        return pmFileService.getBase64Data(completeFilename);
    }
}
