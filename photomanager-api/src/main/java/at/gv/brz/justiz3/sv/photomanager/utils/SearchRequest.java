package at.gv.brz.justiz3.sv.photomanager.utils;

import java.util.Arrays;

/**
 * @author blascheh
 */

public class SearchRequest {
    public static final int DEFAULT_ELEMENTS_IN_LIST = 100;
    public static final int MAX_ELEMENTS_IN_LIST = 200;
    private int page;
    protected int size = 100;
    private String sort;

    public SearchRequest() {
    }

    public SearchRequest(int page, int size) {
        this.setPage(page);
        this.setSize(size);
    }

    public void setSize(int size) {
        this.size = Math.min(200, size);
    }

    public SearchRequest(int page, int size, String sort) {
        this.setPage(page);
        this.setSize(size);
        this.setSort(sort);
    }

    public int getPage() {
        return this.page;
    }

    public final void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return this.size;
    }

    public String getSort() {
        return this.sort;
    }

    public final void setSort(String sort) {
        this.sort = sort;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj != null && this.getClass() == obj.getClass()) {
            SearchRequest other = (SearchRequest)obj;
            return this.page == other.page && this.size == other.size && (this.sort == other.sort || this.sort != null && this.sort.equals(other.sort));
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.page, this.size, this.sort});
    }
}
