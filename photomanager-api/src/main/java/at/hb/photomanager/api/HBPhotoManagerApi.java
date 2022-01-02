package at.hb.photomanager.api;


import at.hb.photomanager.dto.HBPhotoPageDto;
import at.hb.photomanager.dto.HBSearchPhotoDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.groups.Default;

/**
 * The interface Sv PbzAnstaltApi.
 *
 * @author blascheh
 */

@Validated
@RequestMapping(value = {"/api/hbphotomanger"})
public interface HBPhotoManagerApi {


    /**
     * Liste aller Photos.
     *
     * @param dto      Daten der neuen Person
     * @return Liste der gefundenen Personen oder leere Liste
     */
    @RequestMapping(value = {"/getphotos"}, method = RequestMethod.GET)
    HBPhotoPageDto getPhotos(
            @Validated(value = {Default.class}) HBSearchPhotoDto dto);


}
