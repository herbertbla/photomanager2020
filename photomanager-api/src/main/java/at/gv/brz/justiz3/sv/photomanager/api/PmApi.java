package at.gv.brz.justiz3.sv.photomanager.api;


import at.gv.brz.justiz3.sv.photomanager.utils.PageDto;
import at.gv.brz.justiz3.sv.photomanager.dto.PmPictureDto;
import at.gv.brz.justiz3.sv.photomanager.utils.SearchRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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


}
