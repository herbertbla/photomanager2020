package at.hb.photomanager.main.domain;

import at.hb.photomanager.main.enums.PmScanStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author blascheh
 */
@Entity
@Getter
@Setter
@Table(name = "PMCONFIGURATION")
public class PmDirectory extends PmBase {
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    protected PmConfiguration pmConfiguration;

    @Column(name="LAUFWERK", nullable = false)
    protected String laufwerk;

    @Column(name="PATH", nullable = false)
    protected String path;

    @Column(name="PM_SCAN_STATUS", nullable = false)
    protected PmScanStatus pmScanStatus;


}
