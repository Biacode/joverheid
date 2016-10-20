package com.sfl.overheid.api.client.impl;

import com.sfl.overheid.api.client.AbstractOverheidClient;
import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.model.common.AbstractOverheidRequest;
import com.sfl.overheid.api.model.common.OverheidErrorTypeModel;
import com.sfl.overheid.api.model.common.OverheidResult;
import com.sfl.overheid.api.model.request.GetCorporationRequest;
import com.sfl.overheid.api.model.request.GetCorporationsRequest;
import com.sfl.overheid.api.model.request.GetDossierCorporationRequest;
import com.sfl.overheid.api.model.request.SuggestionRequest;
import com.sfl.overheid.api.model.response.GetCorporationResponse;
import com.sfl.overheid.api.model.response.GetCorporationsResponse;
import com.sfl.overheid.api.model.response.GetDossierCorporationResponse;
import com.sfl.overheid.api.model.response.SuggestionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/5/16
 * Time: 11:44 AM
 */
public class OverheidClientImpl extends AbstractOverheidClient implements OverheidClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OverheidClientImpl.class);

    //region Constants
    private static final String API_BASE_PATH = "https://overheid.io/api/kvk";
    private static final String SUGGESTER_BASE_PATH = "https://overheid.io/suggest/kvk";

    private static final String API_KEY_HEADER_NAME = "Ovio-api-key";

    //region Exception messages
    private static final String NOT_AUTHORIZED_EXCEPTION_MSG = "Not authorized exception - {} occur while processing request - {}";
    private static final String UNKNOWN_EXCEPTION_MSG = "Unknown error - {} occur while processing request - {}";
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
    public OverheidResult<GetCorporationResponse> getCorporation(final GetCorporationRequest request) {
        assertOverheidRequest(request);
        try {
            return getClient()
                    .target(API_BASE_PATH)
                    .path(Integer.toString(request.getDossiernummer()))
                    .path(request.getSubdossiernummer())
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header(API_KEY_HEADER_NAME, getApiKey())
                    .get(new GenericType<OverheidResult<GetCorporationResponse>>() {
                    });
        } catch (final NotAuthorizedException ignore) {
            LOGGER.debug(NOT_AUTHORIZED_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        } catch (final RuntimeException ignore) {
            LOGGER.debug(UNKNOWN_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        }
    }

    @Override
    public OverheidResult<GetCorporationsResponse> getCorporations(final GetCorporationsRequest request) {
        assertOverheidRequest(request);
        try {
            WebTarget target = getClient().target(API_BASE_PATH);
            for (final String key : request.getFilters().keySet()) {
                target = target.queryParam(key, request.getFilters().get(key));
            }
            return target
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header(API_KEY_HEADER_NAME, getApiKey())
                    .get(new GenericType<OverheidResult<GetCorporationsResponse>>() {
                    });
        } catch (final NotAuthorizedException ignore) {
            LOGGER.debug(NOT_AUTHORIZED_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        } catch (final RuntimeException ignore) {
            LOGGER.debug(UNKNOWN_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        }
    }

    @Override
    public OverheidResult<GetDossierCorporationResponse> getDossierCorporation(final GetDossierCorporationRequest request) {
        assertOverheidRequest(request);
        try {
            return getClient()
                    .target(API_BASE_PATH)
                    .path(Integer.toString(request.getDossiernummer()))
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header(API_KEY_HEADER_NAME, getApiKey())
                    .get(new GenericType<OverheidResult<GetDossierCorporationResponse>>() {
                    });
        } catch (final NotAuthorizedException ignore) {
            LOGGER.debug(NOT_AUTHORIZED_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        } catch (final RuntimeException ignore) {
            LOGGER.debug(UNKNOWN_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        }
    }

    @Override
    public OverheidResult<SuggestionResponse> getSuggestion(final SuggestionRequest request) {
        assertSuggestionRequest(request);
        try {
            WebTarget target = getClient().target(SUGGESTER_BASE_PATH).path(request.getQuery());
            for (final String key : request.getFilters().keySet()) {
                target = target.queryParam(key, request.getFilters().get(key));
            }
            return target
                    .request(MediaType.APPLICATION_JSON_TYPE)
                    .header(API_KEY_HEADER_NAME, getApiKey())
                    .get(new GenericType<OverheidResult<SuggestionResponse>>() {
                    });
        } catch (final NotAuthorizedException ignore) {
            LOGGER.debug(NOT_AUTHORIZED_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        } catch (final RuntimeException ignore) {
            LOGGER.debug(UNKNOWN_EXCEPTION_MSG, ignore, request);
            return new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        }
    }
    //endregion

    //region Utility methods
    private void assertOverheidRequest(final AbstractOverheidRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("The overheid request should not be null");
        }
    }

    private void assertSuggestionRequest(final SuggestionRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("The suggestion request should not be null");
        }
        if (request.getQuery() == null) {
            throw new IllegalArgumentException("The suggestions request query should not be null");
        }
    }
    //endregion
}
