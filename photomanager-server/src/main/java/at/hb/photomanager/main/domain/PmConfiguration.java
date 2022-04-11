package at.hb.photomanager.main.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author blascheh
 */
@Entity
@Getter
@Setter
@Table(name = "PMCONFIGURATION")
public class PmConfiguration extends PmBase {
    @OneToMany(mappedBy = "pmConfiguration", cascade = CascadeType.ALL, orphanRemoval = true)
    protected List<PmDirectory> pmDirectories;



}
