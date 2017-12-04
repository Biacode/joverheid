package org.biacode.joverheid.api.configuration.impl;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.biacode.joverheid.api.configuration.OverheidJerseyClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/5/16
 * Time: 11:36 AM
 */
public class OverheidJerseyClientBuilderImpl implements OverheidJerseyClientBuilder {

    private static final Logger LOGGER = LoggerFactory.getLogger(OverheidJerseyClientBuilderImpl.class);

    //region Constructors
    public OverheidJerseyClientBuilderImpl() {
        LOGGER.debug("Initializing overheid jersey client build");
    }
    //endregion

    //region Public methods
    @Override
    public Client build() {
        return ClientBuilder.newBuilder().register(JacksonJsonProvider.class).build();
    }
    //endregion

}
