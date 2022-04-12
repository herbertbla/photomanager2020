package at.hb.photomanager.api;


import at.hb.photomanager.dto.PmDirectoryDto;
import at.hb.photomanager.dto.PmFileBaseDto;
import at.hb.photomanager.dto.PmPictureDto;
import at.hb.photomanager.utils.PageDto;
import at.hb.photomanager.utils.SearchRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * The interface Sv PmApi.
 *
 * @author blascheh
 */

@Validated
@RequestMapping(value = {"/api"})
public interface PmApi {

    @RequestMapping(value = {"/getpicture/{id}"}, method = RequestMethod.GET)
    PmPictureDto getPicture(@PathVariable("id") Long id);

    @RequestMapping(value = {"/loadpicturepage"}, method = RequestMethod.GET)
    PageDto<PmPictureDto> loadPicturePage(SearchRequest searchRequest);


    @RequestMapping(value = {"/loadphoto/{id}"}, method = RequestMethod.GET)
    String loadPhoto(@PathVariable("id") Long id);

    @RequestMapping(value = {"/getdirectories"}, method = RequestMethod.GET)
    List<PmFileBaseDto> getDirectories(PmDirectoryDto parentDirectory);


}
