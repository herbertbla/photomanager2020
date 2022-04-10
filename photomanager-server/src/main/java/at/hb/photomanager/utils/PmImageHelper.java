package at.hb.photomanager.utils;

import com.google.common.io.ByteStreams;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author herbert
 */
public class PmImageHelper {

    public static String readFromFile(String filename) throws IOException {
        InputStream inputStream = new ClassPathResource(filename).getInputStream();
        byte[] bytes = ByteStreams.toByteArray(inputStream);
        return new String(bytes, "UTF-8");
    }

    public static InputStream readInputStreamFromFile(String filename) throws IOException {
        return new ClassPathResource(filename).getInputStream();
    }

    public static BufferedImage readImagefromFile(String filename) throws IOException {
        ImageIO.setUseCache(false);
        return ImageIO.read(readInputStreamFromFile(filename));
    }
}
