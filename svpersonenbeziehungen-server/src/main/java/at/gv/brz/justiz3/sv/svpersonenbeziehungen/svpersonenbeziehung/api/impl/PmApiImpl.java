package at.gv.brz.justiz3.sv.svpersonenbeziehungen.svpersonenbeziehung.api.impl;

import at.gv.brz.justiz3.sv.photomanager.api.PmApi;
import at.gv.brz.justiz3.sv.photomanager.utils.PageDto;
import at.gv.brz.justiz3.sv.photomanager.dto.PmPictureDto;
import at.gv.brz.justiz3.sv.photomanager.utils.SearchRequest;
import org.joda.time.DateTime;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blascheh
 */
@RestController
public class PmApiImpl implements PmApi {
    @Override
    public PmPictureDto getPicture(Long id) {
        PmPictureDto pmPictureDto = new PmPictureDto();
        pmPictureDto.setAufnahmedatum(new DateTime());
        pmPictureDto.setDir("directory");
        pmPictureDto.setFilename("filename");
        return pmPictureDto;
    }

    @Override
    public PageDto<PmPictureDto> loadPicturePage(SearchRequest searchRequest) {
        List<PmPictureDto> elements = new ArrayList<>();
        for (int i=0; i<searchRequest.getSize(); i++) {
            PmPictureDto pmPictureDto = new PmPictureDto();
            pmPictureDto.setAufnahmedatum(new DateTime());
            pmPictureDto.setDir("directory"+i);
            pmPictureDto.setFilename("filename"+i);
            pmPictureDto.setId(new Long(i));
            elements.add(pmPictureDto);
        }
        long totalCount = searchRequest.getSize()*10;
        return new PageDto<>(elements, totalCount);
    }

}
