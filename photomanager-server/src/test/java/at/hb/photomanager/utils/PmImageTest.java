package at.hb.photomanager.utils;

import at.hb.photomanager.file.PmFileServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author poeschlri
 */
@RunWith(MockitoJUnitRunner.class)
public class PmImageTest {

    private PmFileServiceImpl pmFileService;

    private String filename = "bild1.jpg";

    private File file;

    @Before
    public void before() throws IOException {
        pmFileService = new PmFileServiceImpl();
        file = new ClassPathResource(filename).getFile();
    }

    @Test
    public void testExifData() throws IOException {
        String base64Data = pmFileService.getBase64Data(filename);

        assertThat(base64Data).isEqualTo(filename);

    }

}
