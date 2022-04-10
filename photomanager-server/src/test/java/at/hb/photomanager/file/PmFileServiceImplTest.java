package at.hb.photomanager.file;

import at.hb.photomanager.dto.PmExifDto;
import at.hb.photomanager.main.service.converter.MetadataToPmExifDtoConverter;
import com.drew.metadata.Metadata;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author poeschlri
 */
@RunWith(MockitoJUnitRunner.class)
public class PmFileServiceImplTest {

    private PmFileServiceImpl pmFileService;

    private MetadataToPmExifDtoConverter metadataToPmExifDtoConverter;

    @Before
    public void before() {
        pmFileService = new PmFileServiceImpl();
        metadataToPmExifDtoConverter = new MetadataToPmExifDtoConverter();
    }

    @Test
    public void testExifData() {
        Metadata exif = pmFileService.getExif("C:\\Entwicklung\\Programme\\privat\\workspace\\photomanager2020-2\\photomanager-server\\src\\assets\\testbilder\\bild1.jpg");

        PmExifDto pmExifDto = metadataToPmExifDtoConverter.convert(exif);
        assertThat(pmExifDto.getFilename()).isEqualTo("bild1.jpg");

    }

}
