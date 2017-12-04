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
 * Time: 6:59 PM
 */
public class SuggestionModel implements Serializable {
    private static final long serialVersionUID = -5990440854344314418L;

    //region Properties
    @JsonProperty("handelsnaam")
    private HandelsnaamModel handelsnaam;
    //endregion

    //region Constructors
    public SuggestionModel() {
    }

    public SuggestionModel(final HandelsnaamModel handelsnaam) {
        this.handelsnaam = handelsnaam;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestionModel)) {
            return false;
        }
        final SuggestionModel that = (SuggestionModel) o;
        return new EqualsBuilder()
                .append(handelsnaam, that.handelsnaam)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(handelsnaam)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("handelsnaam", handelsnaam)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public HandelsnaamModel getHandelsnaam() {
        return handelsnaam;
    }

    public void setHandelsnaam(final HandelsnaamModel handelsnaam) {
        this.handelsnaam = handelsnaam;
    }
    //endregion
}
