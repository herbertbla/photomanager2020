package at.hb.photomanager.main.enums;


/**
 * === PmScanStatus
 *
 * Enumeration für die Adressart.
 *
 * @author poeschlri
 */
public enum PmScanStatus {

    /**
     * Unbekannt. Notwendig, damit die Schnittstelle rückwärtskompatibel bleibt.
     */
    _UNKNOWN,

    /**
     * komplett mit allen Unterdirectories.
     */
    complete,

    /**
     * partly.
     */
    partly,

    /**
     * notstarted.
     */
    notstarted
}
