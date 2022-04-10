package at.hb.photomanager.dto;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

/**
 * @author blascheh
 */
@Getter
@Setter
public class PmExifDto {
    private Long height; // in pixels original
    private Long width; // in pixels original
    private Long widthTn; // in pixels thumbnail
    private Long heightTn; // in pixels thumbnail
    private Long xRes; // in dots
    private Long yRes; // in dots
    private Long orientation; // 0 unkown
    private DateTime date; // Aufnahmedatum
    private String filename;
    private Long filesize; // in Byte
    private DateTime modifiedDate; // geändert am
}
