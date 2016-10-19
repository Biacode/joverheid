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
 * Time: 3:03 PM
 */
public class LinksModel implements Serializable {
    private static final long serialVersionUID = 4238590339060302278L;

    //region Properties
    @JsonProperty("self")
    private LinkItemModel self;

    @JsonProperty("next")
    private LinkItemModel next;

    @JsonProperty("first")
    private LinkItemModel first;

    @JsonProperty("burden")
    private LinkItemModel burden;
    //endregion

    //region Constructors
    public LinksModel() {
    }

    public LinksModel(final LinkItemModel self,
                      final LinkItemModel next,
                      final LinkItemModel first,
                      final LinkItemModel burden) {
        this.self = self;
        this.next = next;
        this.first = first;
        this.burden = burden;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof LinksModel)) {
            return false;
        }
        final LinksModel linksModel = (LinksModel) o;
        return new EqualsBuilder()
                .append(self, linksModel.self)
                .append(next, linksModel.next)
                .append(first, linksModel.first)
                .append(burden, linksModel.burden)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(self)
                .append(next)
                .append(first)
                .append(burden)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("self", self)
                .append("next", next)
                .append("first", first)
                .append("burden", burden)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public LinkItemModel getSelf() {
        return self;
    }

    public void setSelf(final LinkItemModel self) {
        this.self = self;
    }

    public LinkItemModel getNext() {
        return next;
    }

    public void setNext(final LinkItemModel next) {
        this.next = next;
    }

    public LinkItemModel getFirst() {
        return first;
    }

    public void setFirst(final LinkItemModel first) {
        this.first = first;
    }

    public LinkItemModel getBurden() {
        return burden;
    }

    public void setBurden(final LinkItemModel burden) {
        this.burden = burden;
    }
    //endregion
}
