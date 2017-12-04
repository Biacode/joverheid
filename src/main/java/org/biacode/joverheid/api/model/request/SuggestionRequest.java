package org.biacode.joverheid.api.model.request;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.biacode.joverheid.api.model.common.AbstractOverheidRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 7:07 PM
 */
public class SuggestionRequest extends AbstractOverheidRequest {
    private static final long serialVersionUID = -8233085044731714093L;

    //region Properties
    private String query;

    private Map<String, String> filters;
    //endregion

    //region Constructors
    public SuggestionRequest(final String query) {
        filters = new HashMap<>();
        this.query = query;
    }

    public SuggestionRequest(final String query, final Map<String, String> filters) {
        super();
        this.query = query;
        this.filters = filters;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestionRequest)) {
            return false;
        }
        final SuggestionRequest that = (SuggestionRequest) o;
        return new EqualsBuilder()
                .append(query, that.query)
                .append(filters, that.filters)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(query)
                .append(filters)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("query", query)
                .append("filters", filters)
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

    public Map<String, String> getFilters() {
        return filters;
    }

    public void setFilters(final Map<String, String> filters) {
        this.filters = filters;
    }
    //endregion
}
