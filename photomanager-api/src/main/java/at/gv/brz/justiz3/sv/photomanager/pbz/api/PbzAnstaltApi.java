package at.gv.brz.justiz3.sv.photomanager.pbz.api;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The interface Sv PbzAnstaltApi.
 *
 * @author blascheh
 */

@Validated
@RequestMapping(value = {"/api"})
public interface PbzAnstaltApi {

    @RequestMapping(value = {"/long"}, method = RequestMethod.GET)
   Long getLong();


}
