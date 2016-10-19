package com.sfl.overheid.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sfl.overheid.api.model.EmbeddedCorporationsModel;
import com.sfl.overheid.api.model.LinksModel;
import com.sfl.overheid.api.model.common.AbstractPageAwareResponse;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 3:44 PM
 */
public class GetCorporationsResponse extends AbstractPageAwareResponse {
    private static final long serialVersionUID = 4292100832418027473L;

    //region Properties
    @JsonProperty("_embedded")
    private EmbeddedCorporationsModel embeddedCorporationsModel;
    //endregion

    //region Constructors
    public GetCorporationsResponse() {
    }

    public GetCorporationsResponse(final int totalItemCount,
                                   final int pageCount,
                                   final int size,
                                   final LinksModel links,
                                   final EmbeddedCorporationsModel embeddedCorporationsModel) {
        super(totalItemCount, pageCount, size, links);
        this.embeddedCorporationsModel = embeddedCorporationsModel;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetCorporationsResponse)) {
            return false;
        }
        final GetCorporationsResponse that = (GetCorporationsResponse) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(embeddedCorporationsModel, that.embeddedCorporationsModel)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(embeddedCorporationsModel)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("embeddedCorporationsModel", embeddedCorporationsModel)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public EmbeddedCorporationsModel getEmbeddedCorporationsModel() {
        return embeddedCorporationsModel;
    }

    public void setEmbeddedCorporationsModel(final EmbeddedCorporationsModel embeddedCorporationsModel) {
        this.embeddedCorporationsModel = embeddedCorporationsModel;
    }
    //endregion
}
