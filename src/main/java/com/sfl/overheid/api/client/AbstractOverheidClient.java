package com.sfl.overheid.api.client;

import javax.ws.rs.client.Client;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/5/16
 * Time: 11:43 AM
 */
public abstract class AbstractOverheidClient {

    //region Dependencies
    private final Client client;

    private final String apiKey;
    //endregion

    //region Constructors
    public AbstractOverheidClient(final Client client, final String apiKey) {
        this.client = client;
        this.apiKey = apiKey;
    }
    //endregion

    //region Public methods
    protected Client getClient() {
        return client;
    }

    protected String getApiKey() {
        return apiKey;
    }
    //endregion
}
