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
    @JoinColumn(name = "ID", nullable = false)
    private PmConfiguration pmConfiguration;

    @Column(name="LAUFWERK", nullable = false)
    private String laufwerk;

    @Column(name="PATH", nullable = false)
    private String path;

    @Column(name="PM_SCAN_STATUS", nullable = false)
    private PmScanStatus pmScanStatus;


}
