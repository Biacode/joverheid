package com.sfl.overheid.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 5:47 PM
 */
public class EmbeddedCorporationModel implements Serializable {
    private static final long serialVersionUID = -3084975052067266217L;

    //region Properties
    @JsonProperty("rechtspersoon")
    private List<CorporationModel> corporations;
    //endregion

    //region Constructors
    public EmbeddedCorporationModel() {
    }

    public EmbeddedCorporationModel(final List<CorporationModel> corporations) {
        this.corporations = corporations;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmbeddedCorporationModel)) {
            return false;
        }
        final EmbeddedCorporationModel that = (EmbeddedCorporationModel) o;
        return new EqualsBuilder()
                .append(corporations, that.corporations)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(corporations)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("corporations", corporations)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public List<CorporationModel> getCorporations() {
        return corporations;
    }

    public void setCorporations(final List<CorporationModel> corporations) {
        this.corporations = corporations;
    }
    //endregion
}
