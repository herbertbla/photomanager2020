package at.gv.brz.justiz3.sv.photomanager.utils;

import java.util.Collection;

/**
 * @author blascheh
 */
public class PageDto<T> {
    private Collection<T> elements;
    private long totalCount;

    PageDto() {
    }

    public PageDto(Collection<T> elements, long totalCount) {
        this.elements = elements;
        this.totalCount = totalCount;
    }

    public Collection<T> getElements() {
        return this.elements;
    }

    public void setElements(Collection<T> elements) {
        this.elements = elements;
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
