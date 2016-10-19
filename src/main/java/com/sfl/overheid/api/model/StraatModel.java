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
 * Time: 7:03 PM
 */
public class StraatModel implements Serializable {
    private static final long serialVersionUID = -3258981198997271477L;

    //region Properties
    @JsonProperty("text")
    private String text;

    @JsonProperty("extra")
    private StraatExtraModel extra;
    //endregion

    //region Constructors
    public StraatModel() {
    }

    public StraatModel(final String text, final StraatExtraModel extra) {
        this.text = text;
        this.extra = extra;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StraatModel)) {
            return false;
        }
        final StraatModel that = (StraatModel) o;
        return new EqualsBuilder()
                .append(text, that.text)
                .append(extra, that.extra)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(text)
                .append(extra)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("text", text)
                .append("extra", extra)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public StraatExtraModel getExtra() {
        return extra;
    }

    public void setExtra(final StraatExtraModel extra) {
        this.extra = extra;
    }
    //endregion
}

