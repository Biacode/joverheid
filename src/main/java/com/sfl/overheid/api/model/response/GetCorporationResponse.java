package com.sfl.overheid.api.model.response;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.sfl.overheid.api.model.CorporationModel;
import com.sfl.overheid.api.model.common.AbstractOverheidResponse;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 4:47 PM
 */
public class GetCorporationResponse extends AbstractOverheidResponse {
    private static final long serialVersionUID = 2019786801813544626L;

    //region Properties
    @JsonUnwrapped
    private CorporationModel corporation;
    //endregion

    //region Constructors
    public GetCorporationResponse() {
    }

    public GetCorporationResponse(final CorporationModel corporation) {
        this.corporation = corporation;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetCorporationResponse)) {
            return false;
        }
        final GetCorporationResponse that = (GetCorporationResponse) o;
        return new EqualsBuilder()
                .append(corporation, that.corporation)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(corporation)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("corporation", corporation)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public CorporationModel getCorporation() {
        return corporation;
    }

    public void setCorporation(final CorporationModel corporation) {
        this.corporation = corporation;
    }
    //endregion
}
