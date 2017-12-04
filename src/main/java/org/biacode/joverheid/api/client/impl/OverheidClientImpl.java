package org.biacode.joverheid.api.client.impl;

import org.biacode.joverheid.api.client.AbstractOverheidClient;
import org.biacode.joverheid.api.client.OverheidClient;
import org.biacode.joverheid.api.model.common.AbstractOverheidRequest;
import org.biacode.joverheid.api.model.common.OverheidErrorTypeModel;
import org.biacode.joverheid.api.model.common.OverheidResult;
import org.biacode.joverheid.api.model.request.GetCorporationRequest;
import org.biacode.joverheid.api.model.request.GetCorporationsRequest;
import org.biacode.joverheid.api.model.request.GetDossierCorporationRequest;
import org.biacode.joverheid.api.model.request.SuggestionRequest;
import org.biacode.joverheid.api.model.response.GetCorporationResponse;
import org.biacode.joverheid.api.model.response.GetCorporationsResponse;
import org.biacode.joverheid.api.model.response.GetDossierCorporationResponse;
import org.biacode.joverheid.api.model.response.SuggestionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/5/16
 * Time: 11:44 AM
 */
@SuppressWarnings({"squid:S1075"})
public class OverheidClientImpl extends AbstractOverheidClient implements OverheidClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(OverheidClientImpl.class);

    //region Constants
    private static final String API_BASE_PATH = "https://overheid.io/api/kvk";
    private static final String SUGGESTER_BASE_PATH = "https://overheid.io/suggest/kvk";

    private static final String API_KEY_HEADER_NAME = "Ovio-api-key";

    private static final String FIELDS_FILTER_QUERY_PARAM = "fields[]";

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
            return getClient()
                    .target(API_BASE_PATH)
                    .queryParam("query", request.getQuery())
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "actief")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "bestaandehandelsnaam")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "dossiernummer")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "handelsnaam")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "handelsnaam_url")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "huisnummer")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "huisnummertoevoeging")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "plaats")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "postcode")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "status")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "straat")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "straat_url")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "subdossiernummer")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "type")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "vestigingsnummer")
                    .queryParam(FIELDS_FILTER_QUERY_PARAM, "subtype")
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
            for (final Map.Entry<String, String> entry : request.getFilters().entrySet()) {
                target = target.queryParam(entry.getKey(), entry.getValue());
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
