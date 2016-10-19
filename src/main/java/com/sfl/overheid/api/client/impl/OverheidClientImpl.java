package com.sfl.overheid.api.client.impl;

import com.sfl.overheid.api.client.AbstractOverheidClient;
import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.model.common.AbstractOverheidRequest;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import java.util.Date;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/5/16
 * Time: 11:44 AM
 */
public class OverheidClientImpl extends AbstractOverheidClient implements OverheidClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OverheidClientImpl.class);

    //region Constants
    private static final String BASE_PATH = "https://api.overheid.com";

    private static final String QUERY_PARAM_DATE_FORMAT = "YYYY-MM-dd";

    //region Exception messages
    //endregion

    //endregion

    //region Constructors
    public OverheidClientImpl(final Client client) {
        super(client);
        LOGGER.debug("Initializing overheid client");
    }
    //endregion

    //region Public methods

    //endregion

    //region Utility methods
    private void assertOverheidRequest(final AbstractOverheidRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("The overheid request should not be null");
        }
    }

    private String getQueryParamFromDate(final Date date, final int daysToAdd) {
        return new DateTime(date).plusDays(daysToAdd).withZone(DateTimeZone.UTC).toString(QUERY_PARAM_DATE_FORMAT);
    }
    //endregion
}
