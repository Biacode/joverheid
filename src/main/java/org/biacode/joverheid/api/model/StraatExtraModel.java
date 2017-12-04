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
 * Time: 7:01 PM
 */
public class StraatExtraModel implements Serializable {
    private static final long serialVersionUID = -7173123822366780431L;

    //region Properties
    @JsonProperty("postcode")
    private String postcode;
    //endregion

    //region Constructors
    public StraatExtraModel() {
    }

    public StraatExtraModel(final String postcode) {
        this.postcode = postcode;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StraatExtraModel)) {
            return false;
        }
        final StraatExtraModel that = (StraatExtraModel) o;
        return new EqualsBuilder()
                .append(postcode, that.postcode)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(postcode)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("postcode", postcode)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }
    //endregion
}
