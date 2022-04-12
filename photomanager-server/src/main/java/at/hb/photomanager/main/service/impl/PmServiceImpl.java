package at.hb.photomanager.main.service.impl;

import at.hb.photomanager.dto.*;
import at.hb.photomanager.file.PmFileServiceImpl;
import at.hb.photomanager.main.service.PmService;
import com.drew.metadata.Metadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

        return pmExifDto;
    }

    @Override
    public String getBase64(String completeFilename) {
        return pmFileService.getBase64Data(completeFilename);
    }

    @Override
    public List<PmFileBaseDto> getDirectories(PmDirectoryDto parentDirectory) {
        List<PmFileBaseDto> pmDiretories = new ArrayList<>();
        PmDirectoryDto pmDirectoryDto = new PmDirectoryDto();
        pmDirectoryDto.setName("basisdir");
        PmPictureDto pmPictureDto = new PmPictureDto();
        pmPictureDto.setFilename("bild1.jpg");
       // pmPictureDto.setPmExifDto(getExif("bild1.jpg")); todo
        List<PmFileBaseDto> pmFileBaseDtos = new ArrayList<>();
        PmFileDto pmFileDto = new PmFileDto();
        pmFileDto.setPmPictureDto(pmPictureDto);
        pmFileDto.setName(pmPictureDto.getFilename());
        pmDirectoryDto.setPmFileBaseDtos(pmFileBaseDtos);

        pmDiretories.add(pmDirectoryDto);
        return pmDiretories;
    }
}
