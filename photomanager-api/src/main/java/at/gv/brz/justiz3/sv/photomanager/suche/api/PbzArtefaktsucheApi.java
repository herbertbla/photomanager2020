package at.gv.brz.justiz3.sv.photomanager.suche.api;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * === PbzArtefaktsucheApi
 *
 * Schnittstelle für die generische Suche nach Artefakten.
 */
@Validated
@RequestMapping(value = {"/api/photomanagersuche"})
public interface PbzArtefaktsucheApi {


}

