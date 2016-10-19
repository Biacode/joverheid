package com.sfl.overheid.api.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.overheid.api.model.LinksModel;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 5:27 PM
 */
public abstract class AbstractPageAwareResponse extends AbstractOverheidResponse {
    private static final long serialVersionUID = 2843016193536570530L;

    //region Properties
    @JsonProperty("totalItemCount")
    private int totalItemCount;

    @JsonProperty("pageCount")
    private int pageCount;

    @JsonProperty("size")
    private int size;

    @JsonProperty("_links")
    private LinksModel links;
    //endregion

    //region Constructors
    public AbstractPageAwareResponse() {
    }

    public AbstractPageAwareResponse(final int totalItemCount,
                                     final int pageCount,
                                     final int size,
                                     final LinksModel links) {
        this.totalItemCount = totalItemCount;
        this.pageCount = pageCount;
        this.size = size;
        this.links = links;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractPageAwareResponse)) {
            return false;
        }
        final AbstractPageAwareResponse that = (AbstractPageAwareResponse) o;
        return new EqualsBuilder()
                .append(totalItemCount, that.totalItemCount)
                .append(pageCount, that.pageCount)
                .append(size, that.size)
                .append(links, that.links)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(totalItemCount)
                .append(pageCount)
                .append(size)
                .append(links)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("totalItemCount", totalItemCount)
                .append("pageCount", pageCount)
                .append("size", size)
                .append("links", links)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public int getTotalItemCount() {
        return totalItemCount;
    }

    public void setTotalItemCount(final int totalItemCount) {
        this.totalItemCount = totalItemCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(final int pageCount) {
        this.pageCount = pageCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }

    public LinksModel getLinks() {
        return links;
    }

    public void setLinks(final LinksModel links) {
        this.links = links;
    }
    //endregion
}
