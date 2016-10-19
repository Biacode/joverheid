package com.sfl.overheid.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 3:08 PM
 */
public class LinkItemModel implements Serializable {
    private static final long serialVersionUID = -3441437210439377490L;

    //region Properties
    @JsonProperty("href")
    private String href;
    //endregion

    //region Constructors
    public LinkItemModel() {
    }

    public LinkItemModel(final String href) {
        this.href = href;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinkItemModel)) {
            return false;
        }
        final LinkItemModel that = (LinkItemModel) o;
        return new EqualsBuilder()
                .append(href, that.href)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(href)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("href", href)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getHref() {
        return href;
    }

    public void setHref(final String href) {
        this.href = href;
    }
    //endregion
}
