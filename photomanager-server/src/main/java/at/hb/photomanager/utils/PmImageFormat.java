package at.hb.photomanager.utils;

/**
 * Image format identifier
 *
 * @author herbert
 * @author herbert
 */
public enum PmImageFormat {

    IMAGE_FORMAT_JPG("jpeg","data:image/jpeg;base64,");

    private final String imageIoFormatId;
    private final String base64Prefix;

    PmImageFormat(final String imageIoFormatId, final String base64Prefix) {
        this.imageIoFormatId = imageIoFormatId;
        this.base64Prefix = base64Prefix;
    }

    public String getImageIoFormatId() {
        return imageIoFormatId;
    }

    public String getBase64Prefix() {
        return base64Prefix;
    }
}
