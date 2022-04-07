package at.hb.photomanager.api;


import at.hb.photomanager.dto.PhotoPageDto;
import at.hb.photomanager.dto.SearchPhotoDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.groups.Default;

/**
 * The interface Sv PhotoManagerApi.
 *
 * @author blascheh
 */

@Validated
@RequestMapping(value = {"/api/photomanger"})
public interface PhotoManagerApi {


    /**
     * Liste aller Photos.
     *
     * @param dto      Daten der neuen Person
     * @return Liste der gefundenen Personen oder leere Liste
     */
    @RequestMapping(value = {"/searchphotos"}, method = RequestMethod.GET)
    PhotoPageDto getPhotos(
            @Validated(value = {Default.class}) SearchPhotoDto dto);


}
