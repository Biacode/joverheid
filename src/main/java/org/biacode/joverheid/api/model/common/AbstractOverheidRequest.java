package org.biacode.joverheid.api.model.common;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/4/16
 * Time: 3:03 PM
 */
public abstract class AbstractOverheidRequest implements Serializable {
    private static final long serialVersionUID = -9151773103602627454L;

    //region Properties
    //endregion

    //region Constructors
    public AbstractOverheidRequest() {
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        return this == o
                || o instanceof AbstractOverheidRequest
                && new EqualsBuilder().isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    //endregion
}
