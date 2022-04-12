package at.hb.photomanager.file;

import at.hb.photomanager.dto.PmExifDto;
import at.hb.photomanager.main.service.converter.MetadataToPmExifDtoConverter;
import com.drew.metadata.Metadata;
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
public class PmPictureServiceImplTest {

    private PmFileServiceImpl pmFileService;

    private MetadataToPmExifDtoConverter metadataToPmExifDtoConverter;

    private String filename = "bild1.jpg";

    private File file;

    @Before
    public void before() throws IOException {
        pmFileService = new PmFileServiceImpl();
        metadataToPmExifDtoConverter = new MetadataToPmExifDtoConverter();
        file = new ClassPathResource(filename).getFile();
    }

    @Test
    public void testExifData() {
        Metadata exif = pmFileService.getExif(file);

        PmExifDto pmExifDto = metadataToPmExifDtoConverter.convert(exif);
        assertThat(pmExifDto.getFilename()).isEqualTo(filename);

    }

}
