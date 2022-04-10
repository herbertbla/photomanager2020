package at.hb.photomanager.file;

import at.hb.photomanager.utils.PmImageEncoding;
import at.hb.photomanager.utils.PmImageFormat;
import at.hb.photomanager.utils.PmImageHelper;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.springframework.stereotype.Service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * @author blascheh
 */

@Service
public class PmFileServiceImpl {

    public Metadata getExif(File file) {

        Metadata source = null;
        try {
            source = JpegMetadataReader.readMetadata(file);
        } catch (JpegProcessingException | IOException ex) {
            ex.printStackTrace();
        }
        // iterate through metadata directories
        Iterable<Directory> directories = source.getDirectories();
        directories = directories;
        if (directories != null) {
            directories.forEach(directory -> {
                        // iterate through tags and print to System.out
                        Collection<Tag> tags = directory.getTags();
                        tags.forEach(tag -> {
                                    System.out.println(tag);
                                }
                        );
                    }
            );
        }

        /*
        https://www.java-forum.org/thema/exif-mittels-java-auslesen.110178/
        */
        return source;
    }

    public Metadata getExif(String completeFileName) {
        File jpegFile = new File(completeFileName);
        return getExif(jpegFile);
    }

    public String getBase64Data(String completeFileName) {
        BufferedImage bi;
       String str = null;
        try {
            bi = PmImageHelper.readImagefromFile(completeFileName);
            str = PmImageEncoding.encodeBase64(bi, PmImageFormat.IMAGE_FORMAT_JPG, 1.0F);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }

}
