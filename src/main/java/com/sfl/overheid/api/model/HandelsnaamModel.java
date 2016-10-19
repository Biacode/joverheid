package com.sfl.overheid.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 6:59 PM
 */
public class HandelsnaamModel implements Serializable {
    private static final long serialVersionUID = -3244701486611767189L;

    //region Properties
    @JsonProperty("text")
    private String text;

    @JsonProperty("extra")
    private HandelsnaamExtraModel extra;
    //endregion

    //region Constructors
    public HandelsnaamModel() {
    }
    //endregion

    //region Equals, HashCode and ToString
    //endregion

    //region Properties getters and setters
    //endregion
}
