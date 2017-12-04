package org.biacode.joverheid.api.model.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.biacode.joverheid.api.model.common.AbstractOverheidRequest;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 5:25 PM
 */
public class GetCorporationsRequest extends AbstractOverheidRequest {
    private static final long serialVersionUID = -4426790977831863376L;

    //region Properties
    private String query;
    //endregion

    //region Constructors
    public GetCorporationsRequest() {
    }

    public GetCorporationsRequest(final String query) {
        this.query = query;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GetCorporationsRequest)) {
            return false;
        }
        final GetCorporationsRequest that = (GetCorporationsRequest) o;
        return new EqualsBuilder()
                .appendSuper(super.equals(o))
                .append(query, that.query)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .appendSuper(super.hashCode())
                .append(query)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("query", query)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getQuery() {
        return query;
    }

    public void setQuery(final String query) {
        this.query = query;
    }
    //endregion
}
