package at.hb.photomanager.main.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author blascheh
 */
@Getter
@Setter
@MappedSuperclass
 public abstract class PmBase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    protected Long id;

    protected Long version;
}
