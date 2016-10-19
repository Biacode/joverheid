package com.sfl.overheid.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.overheid.api.model.Embedded;
import com.sfl.overheid.api.model.LinksModel;
import com.sfl.overheid.api.model.common.AbstractOverheidResponse;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 3:44 PM
 */
public class OverheidResponse extends AbstractOverheidResponse {
    private static final long serialVersionUID = 4292100832418027473L;

    //region Properties
    @JsonProperty("totalItemCount")
    private int totalItemCount;

    @JsonProperty("pageCount")
    private int pageCount;

    @JsonProperty("size")
    private int size;

    @JsonProperty("_links")
    private LinksModel links;

    @JsonProperty("_embedded")
    private Embedded embedded;
    //endregion

    //region Constructors
    public OverheidResponse() {
    }

    public OverheidResponse(final int totalItemCount, final int pageCount, final int size, final LinksModel links, final Embedded embedded) {
        this.totalItemCount = totalItemCount;
        this.pageCount = pageCount;
        this.size = size;
        this.links = links;
        this.embedded = embedded;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof OverheidResponse)) {
            return false;
        }
        final OverheidResponse that = (OverheidResponse) o;
        return new EqualsBuilder()
                .append(totalItemCount, that.totalItemCount)
                .append(pageCount, that.pageCount)
                .append(size, that.size)
                .append(links, that.links)
                .append(embedded, that.embedded)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(totalItemCount)
                .append(pageCount)
                .append(size)
                .append(links)
                .append(embedded)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("totalItemCount", totalItemCount)
                .append("pageCount", pageCount)
                .append("size", size)
                .append("links", links)
                .append("embedded", embedded)
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

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(final Embedded embedded) {
        this.embedded = embedded;
    }
    //endregion
}
