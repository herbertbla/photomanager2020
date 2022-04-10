package at.hb.photomanager.utils;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author herbert
 */
public class ImageEncodingTest {

    @Test
    public void hasBase64FormatTest() throws IOException{
        String img = PmImageHelper.readFromFile("Base64Portrait.txt");
        String imgJpeg = PmImageHelper.readFromFile("Chrysanthemum_1000x750.jpg");

        assertThat(PmImageEncoding.hasBase64ImageFormat(img, PmImageFormat.IMAGE_FORMAT_JPG)).isTrue();
        assertThat(PmImageEncoding.hasBase64ImageFormat(imgJpeg, PmImageFormat.IMAGE_FORMAT_JPG)).isFalse();
    }

    @Test
    public void encodeBase64Test() throws IOException {
        BufferedImage bi = PmImageHelper.readImagefromFile("portrait.jpg");
        String compareImg = PmImageHelper.readFromFile("Base64Portrait.txt");

        String base64encoded = PmImageEncoding.encodeBase64(bi,PmImageFormat.IMAGE_FORMAT_JPG, 1.0f);

        assertThat(base64encoded).isEqualTo(compareImg);
    }

}
