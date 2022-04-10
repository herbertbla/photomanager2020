package at.hb.photomanager.utils;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Utility functions to convert image formats between:
 * - Base64
 * - byte[]
 * - BufferedImage
 *
 * @author herbert
 * @author Schinko
 */
public final class PmImageEncoding {

    /**
     * ==== decodeBase64
     *
     * @param base64Img the base 64 img
     * @return the buffered image
     * @throws IOException the io exception
     */
    public static BufferedImage decodeBase64(String base64Img) throws IOException {
        String[] splittedStr = base64Img.split(",");
        BufferedImage img = null;
        if (splittedStr.length > 1) {
            String base64ImgData = splittedStr[1];
            ByteArrayInputStream base = new ByteArrayInputStream(base64ImgData.getBytes("UTF8"));
            ImageIO.setUseCache(false);
            img = ImageIO.read(new Base64InputStream(base));
            base.close();
        }
        return img;
    }

    /**
     * ==== encodeBase64
     * Encode base 64 string.
     *
     * @param img    the img as BufferedImage
     * @param format the format
     * @return the string
     * @throws IOException the io exception
     */
    public static String encodeBase64(BufferedImage img, PmImageFormat format, Float compressionQuality) throws IOException {
        byte[] imgInBytes = imgToByteArray(img, format, compressionQuality);
        return encodeBase64(imgInBytes, format);
    }

    /**
     * ==== encodeBase64
     * Encode base 64 string.
     *
     * @param img    the img as byte[]
     * @param format the format
     * @return the string
     * @throws IOException the io exception
     */
    public static String encodeBase64(byte[] img, PmImageFormat format) throws IOException {
        return format.getBase64Prefix().concat(Base64.encodeBase64String(img));
    }

    /**
     * ==== imgToByteArray
     * Img to byte array byte [ ].
     *
     * @param img the img as BufferedImage
     * @return the img as byte[]
     * @throws IOException the io exception
     */
    public static byte[] imgToByteArray(BufferedImage img, PmImageFormat format, Float quality) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageOutputStream ios = ImageIO.createImageOutputStream(baos);
        ImageWriter writer = ImageIO.getImageWritersByFormatName(format.getImageIoFormatId()).next();
        ImageWriteParam param = writer.getDefaultWriteParam();
        if (quality != null) {
            param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
            param.setCompressionQuality(quality);
        }
        writer.setOutput(ios);
        writer.write(null, new IIOImage(img, null, null), param);
        writer.dispose();
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }

    /**
     * ==== byteArrayToBufferedImage
     *
     * @param imageData
     * @return the image
     */
    public static BufferedImage byteArrayToBufferedImage(byte[] imageData) throws IOException {
        ImageIO.setUseCache(false);
        BufferedImage read = ImageIO.read(new ByteArrayInputStream(imageData));
        return read;
    }

    /**
     * ==== hasBase64ImageFormat
     * Parses first part of the Base64 string to find out the image format
     *
     * @param base64Img the base 64 img
     * @param format the base 64 format
     * @return true if it is the specified base 64 format
     */
    public static boolean hasBase64ImageFormat(String base64Img, PmImageFormat format) {
        if (base64Img == null || base64Img.isEmpty()) {
            return false;
        }
        return base64Img.startsWith(format.getBase64Prefix());
    }
}
