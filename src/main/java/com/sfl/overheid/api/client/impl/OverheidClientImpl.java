package com.sfl.overheid.api.client.impl;

import com.sfl.overheid.api.client.AbstractOverheidClient;
import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.model.common.AbstractOverheidRequest;
import com.sfl.overheid.api.model.common.OverheidResult;
import com.sfl.overheid.api.model.response.OverheidResponse;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
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
    private static final String BASE_PATH = "https://overheid.io/api/kvk";

    private static final String API_KEY_HEADER_NAME = "Ovio-api-key";

    private static final String QUERY_PARAM_DATE_FORMAT = "YYYY-MM-dd";

    //region Exception messages
    //endregion

    //endregion

    //region Constructors
    public OverheidClientImpl(final Client client, final String apiKey) {
        super(client, apiKey);
        LOGGER.debug("Initializing overheid client");
    }
    //endregion

    //region Public methods
    @Override
    public OverheidResult<OverheidResponse> test() {
        try {
            return getClient()
                    .target(BASE_PATH)
                    .queryParam("filters[postcode]", "3083cz")
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header(API_KEY_HEADER_NAME, getApiKey())
                    .get(new GenericType<OverheidResult<OverheidResponse>>() {
                    });
        } catch (final Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
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
