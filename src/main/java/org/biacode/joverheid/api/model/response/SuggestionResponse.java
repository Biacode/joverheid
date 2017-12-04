package org.biacode.joverheid.api.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.biacode.joverheid.api.model.HandelsnaamModel;
import org.biacode.joverheid.api.model.StraatModel;
import org.biacode.joverheid.api.model.common.AbstractOverheidResponse;

import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 7:04 PM
 */
public class SuggestionResponse extends AbstractOverheidResponse {
    private static final long serialVersionUID = -2540940140614837275L;

    //region Properties
    @JsonProperty("handelsnaam")
    private List<HandelsnaamModel> handelsnaam;

    @JsonProperty("straat")
    private List<StraatModel> straat;
    //endregion

    //region Constructors
    public SuggestionResponse() {
    }

    public SuggestionResponse(final List<HandelsnaamModel> handelsnaam,
                              final List<StraatModel> straat) {
        this.handelsnaam = handelsnaam;
        this.straat = straat;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SuggestionResponse)) {
            return false;
        }
        final SuggestionResponse that = (SuggestionResponse) o;
        return new EqualsBuilder()
                .append(handelsnaam, that.handelsnaam)
                .append(straat, that.straat)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(handelsnaam)
                .append(straat)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("handelsnaam", handelsnaam)
                .append("straat", straat)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public List<HandelsnaamModel> getHandelsnaam() {
        return handelsnaam;
    }

    public void setHandelsnaam(final List<HandelsnaamModel> handelsnaam) {
        this.handelsnaam = handelsnaam;
    }

    public List<StraatModel> getStraat() {
        return straat;
    }

    public void setStraat(final List<StraatModel> straat) {
        this.straat = straat;
    }
    //endregion
}
