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
public class CorporationsModel implements Serializable {
    private static final long serialVersionUID = 5587461835871092978L;

    //region Properties
    @JsonProperty("dossiernummer")
    private int dossiernummer;

    @JsonProperty("handelsnaam")
    private String handelsnaam;

    @JsonProperty("subdossiernummer")
    private String subdossiernummer;

    @JsonProperty("vestigingsnummer")
    private Integer vestigingsnummer;

    @JsonProperty("_links")
    private LinksModel links;
    //endregion

    //region Constructors
    public CorporationsModel() {
    }

    public CorporationsModel(final int dossiernummer,
                             final String handelsnaam,
                             final String subdossiernummer,
                             final Integer vestigingsnummer,
                             final LinksModel links) {
        this.dossiernummer = dossiernummer;
        this.handelsnaam = handelsnaam;
        this.subdossiernummer = subdossiernummer;
        this.vestigingsnummer = vestigingsnummer;
        this.links = links;
    }
    //endregion

    //region Equals, HashCode and ToString
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CorporationsModel)) {
            return false;
        }
        final CorporationsModel that = (CorporationsModel) o;
        return new EqualsBuilder()
                .append(dossiernummer, that.dossiernummer)
                .append(handelsnaam, that.handelsnaam)
                .append(subdossiernummer, that.subdossiernummer)
                .append(vestigingsnummer, that.vestigingsnummer)
                .append(links, that.links)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(dossiernummer)
                .append(handelsnaam)
                .append(subdossiernummer)
                .append(vestigingsnummer)
                .append(links)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("dossiernummer", dossiernummer)
                .append("handelsnaam", handelsnaam)
                .append("subdossiernummer", subdossiernummer)
                .append("vestigingsnummer", vestigingsnummer)
                .append("links", links)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public int getDossiernummer() {
        return dossiernummer;
    }

    public void setDossiernummer(final int dossiernummer) {
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

    public Integer getVestigingsnummer() {
        return vestigingsnummer;
    }

    public void setVestigingsnummer(final Integer vestigingsnummer) {
        this.vestigingsnummer = vestigingsnummer;
    }

    public LinksModel getLinks() {
        return links;
    }

    public void setLinks(final LinksModel links) {
        this.links = links;
    }
    //endregion
}
