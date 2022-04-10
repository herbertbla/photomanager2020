package at.hb.photomanager.utils;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author herbert
 */
public class ImageProcessingTest {

    // Strings für Base64-Codierte Bilddaten
    private BufferedImage bi;

    @Test
    public void testScale() throws IOException {
        ImageIO.setUseCache(false);
        bi = PmImageHelper.readImagefromFile("Chrysanthemum_1000x750.jpg");
        bi = PmImageProcessing.scale(bi, 0.5);

        assertThat(bi.getWidth()).isEqualTo(500);
        assertThat(bi.getHeight()).isEqualTo(375);
    }

    @Test
    public void testScaleToWidth() throws IOException {
        ImageIO.setUseCache(false);
        bi = PmImageHelper.readImagefromFile("Chrysanthemum_1000x750.jpg");
        bi = PmImageProcessing.scaleToWidth(bi, 500);

        assertThat(bi.getWidth()).isEqualTo(500);
        assertThat(bi.getHeight()).isEqualTo(375);
    }

    @Test
    public void testScaleToHeight() throws IOException {
        ImageIO.setUseCache(false);
        bi = PmImageHelper.readImagefromFile("Chrysanthemum_1000x750.jpg");
        bi = PmImageProcessing.scaleToHeight(bi, 375);

        assertThat(bi.getWidth()).isEqualTo(500);
        assertThat(bi.getHeight()).isEqualTo(375);
    }

    @Test
    public void testCalculateScaleFactor() {
        assertThat(PmImageProcessing.calculateScaleFactor(100, 50)).isEqualTo(0.5);
        assertThat(PmImageProcessing.calculateScaleFactor(50, 100)).isEqualTo(2);
    }

    @Test
    public void testHasExpectedAspectRatio() throws IOException{
        bi = PmImageHelper.readImagefromFile("Chrysanthemum_1000x750.jpg");
        assertThat(PmImageProcessing.hasExpectedAspectRatio(bi, 3.0, 4.0, 0.1)).isTrue();
        assertThat(PmImageProcessing.hasExpectedAspectRatio(bi, 4.0, 3.0, 0.1)).isFalse();
    }

    @Test
    public void testIsLandscape() throws IOException{
        bi = PmImageHelper.readImagefromFile("Chrysanthemum_1000x750.jpg");
        assertThat(PmImageProcessing.isLandscape(bi)).isTrue();
        bi = PmImageHelper.readImagefromFile("portrait.jpg");
        assertThat(PmImageProcessing.isLandscape(bi)).isFalse();
    }

    @Test
    public void testRotateClokwise() throws IOException{
        bi = ImageIO.read(PmImageHelper.readInputStreamFromFile("Chrysanthemum_1000x750.jpg"));
        bi = PmImageProcessing.rotateClockwise(bi, 90);

        BufferedImage compare = ImageIO.read(PmImageHelper.readInputStreamFromFile("Chrysanthemum_750x1000.jpg"));
        assertThat(bi.getWidth()).isEqualTo(750);
        assertThat(bi.getHeight()).isEqualTo(1000);
    }

}
