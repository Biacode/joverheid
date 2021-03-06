package org.biacode.joverheid.api.model.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.biacode.joverheid.api.model.common.AbstractOverheidRequest;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 5:36 PM
 */
public class GetDossierCorporationRequest extends AbstractOverheidRequest {
    private static final long serialVersionUID = -8005074235948641178L;

    //region Properties
    private final int dossiernummer;
    //endregion

    //region Constructors
    public GetDossierCorporationRequest(final int dossiernummer) {
        this.dossiernummer = dossiernummer;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetDossierCorporationRequest)) {
            return false;
        }
        final GetDossierCorporationRequest that = (GetDossierCorporationRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(dossiernummer, that.dossiernummer)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(dossiernummer)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dossiernummer", dossiernummer)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public int getDossiernummer() {
        return dossiernummer;
    }
    //endregion
}
