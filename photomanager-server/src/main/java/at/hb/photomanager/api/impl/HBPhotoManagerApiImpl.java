package at.hb.photomanager.api.impl;

import at.hb.photomanager.api.HBPhotoManagerApi;
import at.hb.photomanager.dto.HBPhotoDto;
import at.hb.photomanager.dto.HBPhotoPageDto;
import at.hb.photomanager.dto.HBSearchPhotoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blascheh
 */
@RestController
@Slf4j
public class HBPhotoManagerApiImpl implements HBPhotoManagerApi {

    public HBPhotoManagerApiImpl() {
        log.info("HBPhotoManagerApiImpl");
    }
    @Override
    public HBPhotoPageDto getPhotos(HBSearchPhotoDto dto) {
        HBPhotoPageDto hbPhotoPageDto = new HBPhotoPageDto();
        List<HBPhotoDto> photos = new ArrayList<>();
        HBPhotoDto photo = new HBPhotoDto();
        photo.setFilename("Testfilename");
        photos.add(photo);
        hbPhotoPageDto.setElements(photos);

        return hbPhotoPageDto;
    }
}
