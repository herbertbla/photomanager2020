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
@Table(name = "PMPICTURE")
public class PmPicture extends PmBase {
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    protected PmDirectory pmDirectory;

    @Column(name="FILENAME", nullable = false)
    protected String filename;

    @Column(name="PM_SCAN_STATUS", nullable = false)
    protected PmScanStatus pmScanStatus;


}
