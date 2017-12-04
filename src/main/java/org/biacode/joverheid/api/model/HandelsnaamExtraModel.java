package org.biacode.joverheid.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 7:00 PM
 */
public class HandelsnaamExtraModel implements Serializable {
    private static final long serialVersionUID = 6725431477723139707L;

    //region Properties
    @JsonProperty("id")
    private String id;
    //endregion

    //region Constructors
    public HandelsnaamExtraModel() {
    }

    public HandelsnaamExtraModel(final String id) {
        this.id = id;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HandelsnaamExtraModel)) {
            return false;
        }
        final HandelsnaamExtraModel that = (HandelsnaamExtraModel) o;
        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }
    //endregion
}
