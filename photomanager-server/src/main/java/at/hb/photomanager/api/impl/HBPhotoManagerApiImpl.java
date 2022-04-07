package at.hb.photomanager.api.impl;

import at.hb.photomanager.api.PhotoManagerApi;
import at.hb.photomanager.dto.PhotoDto;
import at.hb.photomanager.dto.PhotoPageDto;
import at.hb.photomanager.dto.SearchPhotoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author blascheh
 */
@RestController
@Slf4j
public class HBPhotoManagerApiImpl implements PhotoManagerApi {

    public HBPhotoManagerApiImpl() {
        log.info("HBPhotoManagerApiImpl");
    }
    @Override
    public PhotoPageDto getPhotos(SearchPhotoDto dto) {
        PhotoPageDto hbPhotoPageDto = new PhotoPageDto();
        List<PhotoDto> photos = new ArrayList<>();
        PhotoDto photo = new PhotoDto();
        photo.setFilename("Testfilename");
        photos.add(photo);
        hbPhotoPageDto.setElements(photos);

        return hbPhotoPageDto;
    }
}
