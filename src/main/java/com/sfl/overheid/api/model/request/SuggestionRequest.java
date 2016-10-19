package com.sfl.overheid.api.model.request;

import com.sfl.overheid.api.model.common.AbstractOverheidRequest;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

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
    //endregion

    //region Constructors
    public SuggestionRequest() {
    }

    public SuggestionRequest(final String query) {
        this.query = query;
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
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
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
