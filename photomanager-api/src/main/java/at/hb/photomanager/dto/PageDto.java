
package at.hb.photomanager.dto;

import java.util.Collection;

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
