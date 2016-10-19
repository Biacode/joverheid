package com.sfl.overheid.api.model.request;

import com.sfl.overheid.api.model.common.AbstractOverheidRequest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 5:25 PM
 */
public class GetCorporationRequest extends AbstractOverheidRequest {
    private static final long serialVersionUID = 2608168718116097744L;

    //region Properties
    private final String dossiernummer;

    private final String subdossiernummer;
    //endregion

    //region Constructors
    public GetCorporationRequest(final String dossiernummer, final String subdossiernummer) {
        this.dossiernummer = dossiernummer;
        this.subdossiernummer = subdossiernummer;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetCorporationRequest)) {
            return false;
        }
        final GetCorporationRequest that = (GetCorporationRequest) o;
        return new EqualsBuilder()
                .append(dossiernummer, that.dossiernummer)
                .append(subdossiernummer, that.subdossiernummer)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(dossiernummer)
                .append(subdossiernummer)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dossiernummer", dossiernummer)
                .append("subdossiernummer", subdossiernummer)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getDossiernummer() {
        return dossiernummer;
    }

    public String getSubdossiernummer() {
        return subdossiernummer;
    }
    //endregion
}
