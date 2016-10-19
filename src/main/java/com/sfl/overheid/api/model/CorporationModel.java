package com.sfl.overheid.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 3:37 PM
 */
public class CorporationModel implements Serializable {
    private static final long serialVersionUID = 5587461835871092978L;

    //region Properties
    @JsonProperty("dossiernummer")
    private String dossiernummer;

    @JsonProperty("handelsnaam")
    private String handelsnaam;

    @JsonProperty("subdossiernummer")
    private String subdossiernummer;

    @JsonProperty("_links")
    private LinksModel links;
    //endregion

    //region Constructors
    public CorporationModel() {
    }

    public CorporationModel(final String dossiernummer,
                            final String handelsnaam,
                            final String subdossiernummer,
                            final LinksModel links) {
        this.dossiernummer = dossiernummer;
        this.handelsnaam = handelsnaam;
        this.subdossiernummer = subdossiernummer;
        this.links = links;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CorporationModel)) {
            return false;
        }
        final CorporationModel embedded = (CorporationModel) o;
        return new EqualsBuilder()
                .append(dossiernummer, embedded.dossiernummer)
                .append(handelsnaam, embedded.handelsnaam)
                .append(subdossiernummer, embedded.subdossiernummer)
                .append(links, embedded.links)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(dossiernummer)
                .append(handelsnaam)
                .append(subdossiernummer)
                .append(links)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dossiernummer", dossiernummer)
                .append("handelsnaam", handelsnaam)
                .append("subdossiernummer", subdossiernummer)
                .append("links", links)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public String getDossiernummer() {
        return dossiernummer;
    }

    public void setDossiernummer(final String dossiernummer) {
        this.dossiernummer = dossiernummer;
    }

    public String getHandelsnaam() {
        return handelsnaam;
    }

    public void setHandelsnaam(final String handelsnaam) {
        this.handelsnaam = handelsnaam;
    }

    public String getSubdossiernummer() {
        return subdossiernummer;
    }

    public void setSubdossiernummer(final String subdossiernummer) {
        this.subdossiernummer = subdossiernummer;
    }

    public LinksModel getLinks() {
        return links;
    }

    public void setLinks(final LinksModel links) {
        this.links = links;
    }
    //endregion
}
