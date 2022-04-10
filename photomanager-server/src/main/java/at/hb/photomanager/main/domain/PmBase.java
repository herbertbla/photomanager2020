package at.hb.photomanager.main.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author blascheh
 */
@Getter
@Setter
@MappedSuperclass
abstract public class PmBase {

    @Id
    protected Long id;

    protected Long version;
}
