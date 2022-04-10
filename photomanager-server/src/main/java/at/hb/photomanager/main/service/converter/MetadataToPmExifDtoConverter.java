package at.hb.photomanager.main.service.converter;

import at.hb.photomanager.dto.PmExifDto;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.joda.time.*;
import org.joda.time.format.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * === MetadataToPmExifDtoConverter
 *
 * @author blaschek
 */
@Component
public class MetadataToPmExifDtoConverter implements Converter<Metadata, PmExifDto> {

    @Override
    public PmExifDto convert(Metadata source) {
        PmExifDto pmExifDto = new PmExifDto();

        // iterate through metadata directories
        Iterable<Directory> directories = source.getDirectories();
        directories = directories;
        if (directories != null) {
            directories.forEach(directory -> {
                        // iterate through tags and print to System.out
                        Collection<Tag> tags = directory.getTags();
                        tags.forEach(tag -> {
                                    if (tag.getDirectoryName().equalsIgnoreCase("Exif IFD0")) {
                                        if (tag.getTagName().equalsIgnoreCase("Image Height")) {
                                            pmExifDto.setHeight(getLongFromTag(tag));
                                        } else if (tag.getTagName().equalsIgnoreCase("Image Width")) {
                                            pmExifDto.setWidth(getLongFromTag(tag));
                                        } else if (tag.getTagName().equalsIgnoreCase("X Resolution")) {
                                            pmExifDto.setXRes(getLongFromTag(tag));
                                        } else if (tag.getTagName().equalsIgnoreCase("Y Resolution")) {
                                            pmExifDto.setYRes(getLongFromTag(tag));
                                        } else if (tag.getTagName().equalsIgnoreCase("Date/Time")) {
                                            pmExifDto.setDate(getLocalDateTimeFromTag(tag));
                                        }
                                    } else   if (tag.getDirectoryName().equalsIgnoreCase("Exif Thumbnail")) {
                                        if (tag.getTagName().equalsIgnoreCase("Image Height")) {
                                            pmExifDto.setHeightTn(getLongFromTag(tag));
                                        } else if (tag.getTagName().equalsIgnoreCase("Image Width")) {
                                            pmExifDto.setWidthTn(getLongFromTag(tag));
                                        }
                                    }else   if (tag.getDirectoryName().equalsIgnoreCase("File")) {
                                        if (tag.getTagName().equalsIgnoreCase("File Name")) {
                                            pmExifDto.setFilename(tag.getDescription());
                                        } else if (tag.getTagName().equalsIgnoreCase("File Size")) {
                                            pmExifDto.setFilesize(getLongFromTag(tag));
                                        }else if (tag.getTagName().equalsIgnoreCase("File Modified Date")) {
                                            pmExifDto.setModifiedDate(getLocalDateTimeFromTag(tag));
                                        }
                                    }
                                }
                        );
                    }
            );
        }

        return pmExifDto;
    }

    private Long getLongFromTag(Tag tag) {

        try {
            String[] strings = tag.getDescription().split(" ");
            return Long.parseLong(strings[0]);
        } catch (Exception e) {
            return 0L;
        }
    }

    private DateTime getLocalDateTimeFromTag(Tag tag) {

        try {
            DateTimeFormatter parser = DateTimeFormat.forPattern("yyyy:MM:dd HH:mm:ss");
            return parser.parseDateTime(tag.getDescription());
        } catch (Exception e) {
            return null;
        }
    }
}
