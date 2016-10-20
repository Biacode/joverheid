package com.sfl.overheid.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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

    @JsonProperty("last")
    private LinkItemModel last;

    @JsonProperty("burden")
    private LinkItemModel burden;
    //endregion

    //region Constructors
    public LinksModel() {
    }

    public LinksModel(final LinkItemModel self,
                      final LinkItemModel next,
                      final LinkItemModel first,
                      final LinkItemModel last,
                      final LinkItemModel burden) {
        this.self = self;
        this.next = next;
        this.first = first;
        this.last = last;
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
        final LinksModel that = (LinksModel) o;
        return new EqualsBuilder()
                .append(self, that.self)
                .append(next, that.next)
                .append(first, that.first)
                .append(last, that.last)
                .append(burden, that.burden)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(self)
                .append(next)
                .append(first)
                .append(last)
                .append(burden)
                .toHashCode();
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

    public LinkItemModel getLast() {
        return last;
    }

    public void setLast(final LinkItemModel last) {
        this.last = last;
    }

    public LinkItemModel getBurden() {
        return burden;
    }

    public void setBurden(final LinkItemModel burden) {
        this.burden = burden;
    }
    //endregion
}
