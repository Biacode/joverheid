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
 * Time: 5:36 PM
 */
public class CorporationModel implements Serializable {
    private static final long serialVersionUID = -5311598814389909412L;

    //region Properties
    @JsonProperty("actief")
    private boolean actief;

    @JsonProperty("bestaandehandelsnaam")
    private String bestaandehandelsnaam;

    @JsonProperty("dossiernummer")
    private int dossiernummer;

    @JsonProperty("handelsnaam")
    private String handelsnaam;

    @JsonProperty("handelsnaam_url")
    private String handelsnaamUrl;

    @JsonProperty("huisnummer")
    private int huisnummer;

    @JsonProperty("huisnummertoevoeging")
    private String huisnummertoevoeging;

    @JsonProperty("plaats")
    private String plaats;

    @JsonProperty("postcode")
    private String postcode;

    @JsonProperty("status")
    private String status;

    @JsonProperty("straat")
    private String straat;

    @JsonProperty("straat_url")
    private String straatUrl;

    @JsonProperty("subdossiernummer")
    private String subdossiernummer;

    @JsonProperty("type")
    private String type;

    @JsonProperty("vestigingsnummer")
    private int vestigingsnummer;

    @JsonProperty("subtype")
    private String subtype;

    @JsonProperty("_links")
    private LinksModel links;
    //endregion

    //region Constructors
    public CorporationModel() {
    }

    public CorporationModel(final boolean actief,
                            final String bestaandehandelsnaam,
                            final int dossiernummer,
                            final String handelsnaam,
                            final String handelsnaamUrl,
                            final int huisnummer,
                            final String huisnummertoevoeging,
                            final String plaats,
                            final String postcode,
                            final String status,
                            final String straat,
                            final String straatUrl,
                            final String subdossiernummer,
                            final String type,
                            final int vestigingsnummer,
                            final String subtype,
                            final LinksModel links) {
        this.actief = actief;
        this.bestaandehandelsnaam = bestaandehandelsnaam;
        this.dossiernummer = dossiernummer;
        this.handelsnaam = handelsnaam;
        this.handelsnaamUrl = handelsnaamUrl;
        this.huisnummer = huisnummer;
        this.huisnummertoevoeging = huisnummertoevoeging;
        this.plaats = plaats;
        this.postcode = postcode;
        this.status = status;
        this.straat = straat;
        this.straatUrl = straatUrl;
        this.subdossiernummer = subdossiernummer;
        this.type = type;
        this.vestigingsnummer = vestigingsnummer;
        this.subtype = subtype;
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
        final CorporationModel that = (CorporationModel) o;
        return new EqualsBuilder()
                .append(actief, that.actief)
                .append(dossiernummer, that.dossiernummer)
                .append(huisnummer, that.huisnummer)
                .append(vestigingsnummer, that.vestigingsnummer)
                .append(bestaandehandelsnaam, that.bestaandehandelsnaam)
                .append(handelsnaam, that.handelsnaam)
                .append(handelsnaamUrl, that.handelsnaamUrl)
                .append(huisnummertoevoeging, that.huisnummertoevoeging)
                .append(plaats, that.plaats)
                .append(postcode, that.postcode)
                .append(status, that.status)
                .append(straat, that.straat)
                .append(straatUrl, that.straatUrl)
                .append(subdossiernummer, that.subdossiernummer)
                .append(type, that.type)
                .append(subtype, that.subtype)
                .append(links, that.links)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(actief)
                .append(bestaandehandelsnaam)
                .append(dossiernummer)
                .append(handelsnaam)
                .append(handelsnaamUrl)
                .append(huisnummer)
                .append(huisnummertoevoeging)
                .append(plaats)
                .append(postcode)
                .append(status)
                .append(straat)
                .append(straatUrl)
                .append(subdossiernummer)
                .append(type)
                .append(vestigingsnummer)
                .append(subtype)
                .append(links)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("actief", actief)
                .append("bestaandehandelsnaam", bestaandehandelsnaam)
                .append("dossiernummer", dossiernummer)
                .append("handelsnaam", handelsnaam)
                .append("handelsnaamUrl", handelsnaamUrl)
                .append("huisnummer", huisnummer)
                .append("huisnummertoevoeging", huisnummertoevoeging)
                .append("plaats", plaats)
                .append("postcode", postcode)
                .append("status", status)
                .append("straat", straat)
                .append("straatUrl", straatUrl)
                .append("subdossiernummer", subdossiernummer)
                .append("type", type)
                .append("vestigingsnummer", vestigingsnummer)
                .append("subtype", subtype)
                .append("links", links)
                .toString();
    }
    //endregion

    //region Properties getters and setters
    public boolean isActief() {
        return actief;
    }

    public void setActief(final boolean actief) {
        this.actief = actief;
    }

    public String getBestaandehandelsnaam() {
        return bestaandehandelsnaam;
    }

    public void setBestaandehandelsnaam(final String bestaandehandelsnaam) {
        this.bestaandehandelsnaam = bestaandehandelsnaam;
    }

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

    public String getHandelsnaamUrl() {
        return handelsnaamUrl;
    }

    public void setHandelsnaamUrl(final String handelsnaamUrl) {
        this.handelsnaamUrl = handelsnaamUrl;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(final int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getHuisnummertoevoeging() {
        return huisnummertoevoeging;
    }

    public void setHuisnummertoevoeging(final String huisnummertoevoeging) {
        this.huisnummertoevoeging = huisnummertoevoeging;
    }

    public String getPlaats() {
        return plaats;
    }

    public void setPlaats(final String plaats) {
        this.plaats = plaats;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(final String postcode) {
        this.postcode = postcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(final String straat) {
        this.straat = straat;
    }

    public String getStraatUrl() {
        return straatUrl;
    }

    public void setStraatUrl(final String straatUrl) {
        this.straatUrl = straatUrl;
    }

    public String getSubdossiernummer() {
        return subdossiernummer;
    }

    public void setSubdossiernummer(final String subdossiernummer) {
        this.subdossiernummer = subdossiernummer;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public int getVestigingsnummer() {
        return vestigingsnummer;
    }

    public void setVestigingsnummer(final int vestigingsnummer) {
        this.vestigingsnummer = vestigingsnummer;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(final String subtype) {
        this.subtype = subtype;
    }

    public LinksModel getLinks() {
        return links;
    }

    public void setLinks(final LinksModel links) {
        this.links = links;
    }
    //endregion
}
