package at.gv.brz.justiz3.sv.svpersonenbeziehungen.svpersonenbeziehung.api.impl;

import at.gv.brz.justiz3.sv.photomanager.pbz.api.PbzAnstaltApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author blascheh
 */
@RestController
public class PbzAnstaltApiImpl implements PbzAnstaltApi {
    public PbzAnstaltApiImpl() {

    }
    @Override
    public Long getLong() {
        return 1L;
    }
}
