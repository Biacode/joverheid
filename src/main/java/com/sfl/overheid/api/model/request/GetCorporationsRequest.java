package com.sfl.overheid.api.model.request;

import com.sfl.overheid.api.model.common.AbstractOverheidRequest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 5:25 PM
 */
public class GetCorporationsRequest extends AbstractOverheidRequest {
    private static final long serialVersionUID = -4426790977831863376L;

    //region Properties
    private Map<String, String> filters;
    //endregion

    //region Constructors
    public GetCorporationsRequest() {
        filters = new HashMap<>();
    }

    public GetCorporationsRequest(final Map<String, String> filters) {
        super();
        this.filters = filters;
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
                .append(filters, that.filters)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(filters)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("filters", filters)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(final Map<String, String> filters) {
        this.filters = filters;
    }
    //endregion
}
