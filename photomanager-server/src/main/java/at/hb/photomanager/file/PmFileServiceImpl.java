package at.hb.photomanager.file;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

/**
 * @author blascheh
 */

@Service
public class PmFileServiceImpl {

    public Metadata getExif(String completeFileName) {
        File jpegFile = new File(completeFileName);
        Metadata source = null;
        try {
            source = JpegMetadataReader.readMetadata(jpegFile);
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
}
