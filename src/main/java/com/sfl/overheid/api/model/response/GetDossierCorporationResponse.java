package com.sfl.overheid.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.overheid.api.model.EmbeddedCorporationModel;
import com.sfl.overheid.api.model.LinksModel;
import com.sfl.overheid.api.model.common.AbstractPageAwareResponse;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 5:42 PM
 */
public class GetDossierCorporationResponse extends AbstractPageAwareResponse {
    private static final long serialVersionUID = 6140020605783546968L;

    //region Properties
    @JsonProperty("_embedded")
    private EmbeddedCorporationModel embedded;
    //endregion

    //region Constructors
    public GetDossierCorporationResponse() {
    }

    public GetDossierCorporationResponse(final int totalItemCount, final int pageCount, final int size, final LinksModel links, final EmbeddedCorporationModel embedded) {
        super(totalItemCount, pageCount, size, links);
        this.embedded = embedded;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetDossierCorporationResponse)) {
            return false;
        }
        final GetDossierCorporationResponse that = (GetDossierCorporationResponse) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(embedded, that.embedded)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(embedded)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("embedded", embedded)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public EmbeddedCorporationModel getEmbedded() {
        return embedded;
    }

    public void setEmbedded(final EmbeddedCorporationModel embedded) {
        this.embedded = embedded;
    }
    //endregion
}
