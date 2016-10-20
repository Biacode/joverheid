package com.sfl.overheid.api.impl;

import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.client.impl.OverheidClientImpl;
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
import com.sfl.overheid.api.test.AbstractOverheidUniTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.reset;
import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/6/16
 * Time: 11:10 AM
 */
public class OverheidClientImplTest extends AbstractOverheidUniTest {

    //region Constants
    private static final String API_BASE_PATH = "https://overheid.io/api/kvk";
    private static final String SUGGESTER_BASE_PATH = "https://overheid.io/suggest/kvk";

    private static final String API_KEY_HEADER_NAME = "Ovio-api-key";

    //region Exception messages
    private static final String NOT_AUTHORIZED_EXCEPTION_MSG
            = "Not authorized exception - {} occur while processing request - {}";

    private static final String UNKNOWN_EXCEPTION_MSG
            = "Unknown error - {} occur while processing request - {}";
    //endregion

    private static final String API_KEY = UUID.randomUUID().toString();

    //endregion

    //region Test subject and mocks
    @TestSubject
    private final OverheidClient overheidClient;

    @Mock
    private Client client;

    @Mock
    private WebTarget webTarget;

    @Mock
    private Invocation.Builder builder;
    //endregion

    //region Constructors
    public OverheidClientImplTest() {
        overheidClient = new OverheidClientImpl(client, API_KEY);
    }
    //endregion

    //region Test callbacks
    @Before
    public void before() {
        reset(client);
        reset(webTarget);
        reset(builder);
    }
    //endregion

    //region Test methods

    //region getCorporation

    /**
     * With invalid arguments
     */
    @Test
    public void testGetCorporationScenario1() {
        resetAll();
        // test data
        // expectations
        replayAll();
        try {
            overheidClient.getCorporation(null);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    /**
     * When throws not authorized exception
     */
    @Test
    public void testGetCorporationScenario2() {
        resetAll();
        // test data
        final OverheidResult<GetCorporationResponse> expectedResponse =
                new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        final GetCorporationRequest request = new GetCorporationRequest(7, UUID.randomUUID().toString());
        // expectations
        expect(client.target(API_BASE_PATH)).andThrow(new NotAuthorizedException("Not authorized"));
        replayAll();
        final OverheidResult<GetCorporationResponse> result = overheidClient.getCorporation(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    /**
     * When throws runtime exception
     */
    @Test
    public void testGetCorporationScenario3() {
        resetAll();
        // test data
        final OverheidResult<GetCorporationResponse> expectedResponse =
                new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        final GetCorporationRequest request = new GetCorporationRequest(7, UUID.randomUUID().toString());
        // expectations
        expect(client.target(API_BASE_PATH)).andThrow(new IllegalArgumentException("runtime"));
        replayAll();
        final OverheidResult<GetCorporationResponse> result = overheidClient.getCorporation(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    /**
     * General case
     */
    @Test
    public void testGetCorporationScenario4() {
        resetAll();
        // test data
        final GetCorporationRequest request = new GetCorporationRequest(7, UUID.randomUUID().toString());
        final OverheidResult<GetCorporationResponse> expectedResponse =
                new OverheidResult<>(new GetCorporationResponse());
        // expectations
        expect(client.target(API_BASE_PATH)).andReturn(webTarget);
        expect(webTarget.path(Integer.toString(request.getDossiernummer()))).andReturn(webTarget);
        expect(webTarget.path(request.getSubdossiernummer())).andReturn(webTarget);
        expect(webTarget.request(MediaType.APPLICATION_JSON_TYPE)).andReturn(builder);
        expectAuthHeader();
        expect(builder.get(new GenericType<OverheidResult<GetCorporationResponse>>() {
        })).andReturn(expectedResponse);
        replayAll();
        final OverheidResult<GetCorporationResponse> result = overheidClient.getCorporation(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }
    //endregion

    //region getCorporations

    /**
     * With invalid arguments
     */
    @Test
    public void testGetCorporationsScenario1() {
        resetAll();
        // test data
        // expectations
        replayAll();
        try {
            overheidClient.getCorporations(null);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    /**
     * When throws not authorized exception
     */
    @Test
    public void testGetCorporationsScenario2() {
        resetAll();
        // test data
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "10");
        filters.put("filters[postcode]", "3083cz");
        final GetCorporationsRequest request = new GetCorporationsRequest(filters);
        final OverheidResult<GetCorporationsResponse> expectedResponse
                = new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        // expectations
        expect(client.target(API_BASE_PATH)).andThrow(new NotAuthorizedException("not authorized"));
        replayAll();
        final OverheidResult<GetCorporationsResponse> result = overheidClient.getCorporations(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    /**
     * When throws runtime exception
     */
    @Test
    public void testGetCorporationsScenario3() {
        resetAll();
        // test data
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "10");
        filters.put("filters[postcode]", "3083cz");
        final GetCorporationsRequest request = new GetCorporationsRequest(filters);
        final OverheidResult<GetCorporationsResponse> expectedResponse
                = new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        // expectations
        expect(client.target(API_BASE_PATH)).andThrow(new IllegalArgumentException("runtime"));
        replayAll();
        final OverheidResult<GetCorporationsResponse> result = overheidClient.getCorporations(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    /**
     * General scenario
     */
    @Test
    public void testGetCorporationsScenario4() {
        resetAll();
        // test data
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "10");
        filters.put("filters[postcode]", "3083cz");
        final GetCorporationsRequest request = new GetCorporationsRequest(filters);
        final OverheidResult<GetCorporationsResponse> expectedResponse
                = new OverheidResult<>(new GetCorporationsResponse());
        // expectations
        expect(client.target(API_BASE_PATH)).andReturn(webTarget);
        for (final String key : request.getFilters().keySet()) {
            expect(webTarget.queryParam(key, request.getFilters().get(key))).andReturn(webTarget);
        }
        expect(webTarget.request(MediaType.APPLICATION_JSON_TYPE)).andReturn(builder);
        expectAuthHeader();
        expect(builder.get(new GenericType<OverheidResult<GetCorporationsResponse>>() {
        })).andReturn(expectedResponse);
        replayAll();
        final OverheidResult<GetCorporationsResponse> result = overheidClient.getCorporations(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }
    //endregion

    //region getDossierCorporation

    /**
     * With invalid arguments
     */
    @Test
    public void testGetDossierCorporationScenario1() {
        resetAll();
        // test data
        // expectations
        replayAll();
        try {
            overheidClient.getDossierCorporation(null);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    /**
     * When throws not authorized exception
     */
    @Test
    public void testGetDossierCorporationScenario2() {
        resetAll();
        // test data
        final GetDossierCorporationRequest request = new GetDossierCorporationRequest(7);
        final OverheidResult<GetDossierCorporationResponse> expectedResponse
                = new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        // expectations
        expect(client.target(API_BASE_PATH)).andThrow(new NotAuthorizedException("not authorized"));
        replayAll();
        final OverheidResult<GetDossierCorporationResponse> result = overheidClient.getDossierCorporation(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    /**
     * When throws runtime exception
     */
    @Test
    public void testGetDossierCorporationScenario3() {
        resetAll();
        // test data
        final GetDossierCorporationRequest request = new GetDossierCorporationRequest(7);
        final OverheidResult<GetDossierCorporationResponse> expectedResponse
                = new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        // expectations
        expect(client.target(API_BASE_PATH)).andThrow(new IllegalArgumentException("runtime"));
        replayAll();
        final OverheidResult<GetDossierCorporationResponse> result = overheidClient.getDossierCorporation(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    @Test
    public void testGetDossierCorporationScenario4() {
        resetAll();
        // test data
        final GetDossierCorporationRequest request = new GetDossierCorporationRequest(7);
        final OverheidResult<GetDossierCorporationResponse> expectedResponse
                = new OverheidResult<>(new GetDossierCorporationResponse());
        // expectations
        expect(client.target(API_BASE_PATH)).andReturn(webTarget);
        expect(webTarget.path(Integer.toString(request.getDossiernummer()))).andReturn(webTarget);
        expect(webTarget.request(MediaType.APPLICATION_JSON_TYPE)).andReturn(builder);
        expectAuthHeader();
        expect(builder.get(new GenericType<OverheidResult<GetDossierCorporationResponse>>() {
        })).andReturn(expectedResponse);
        replayAll();
        final OverheidResult<GetDossierCorporationResponse> result = overheidClient.getDossierCorporation(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }
    //endregion

    //region getSuggestion

    /**
     * With invalid arguments
     */
    @Test
    public void testGetSuggestionScenario1() {
        resetAll();
        // test data
        // expectations
        replayAll();
        try {
            overheidClient.getSuggestion(null);
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        try {
            overheidClient.getSuggestion(new SuggestionRequest(null));
            fail();
        } catch (final IllegalArgumentException ignore) {
        }
        verifyAll();
    }

    /**
     * When throws not authorized exception
     */
    @Test
    public void testGetSuggestionScenario2() {
        resetAll();
        // test data
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "10");
        filters.put("filters[postcode]", "3083cz");
        final SuggestionRequest request = new SuggestionRequest(UUID.randomUUID().toString(), filters);
        final OverheidResult<SuggestionResponse> expectedResponse
                = new OverheidResult<>(OverheidErrorTypeModel.NOT_AUTHORIZED);
        // expectations
        expect(client.target(SUGGESTER_BASE_PATH)).andThrow(new NotAuthorizedException("not authorized"));
        replayAll();
        final OverheidResult<SuggestionResponse> result = overheidClient.getSuggestion(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    /**
     * When throws runtime exception
     */
    @Test
    public void testGetSuggestionScenario3() {
        resetAll();
        // test data
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "10");
        filters.put("filters[postcode]", "3083cz");
        final SuggestionRequest request = new SuggestionRequest(UUID.randomUUID().toString(), filters);
        final OverheidResult<SuggestionResponse> expectedResponse
                = new OverheidResult<>(OverheidErrorTypeModel.UNKNOWN);
        // expectations
        expect(client.target(SUGGESTER_BASE_PATH)).andThrow(new IllegalArgumentException("runtime"));
        replayAll();
        final OverheidResult<SuggestionResponse> result = overheidClient.getSuggestion(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }

    @Test
    public void testGetSuggestionScenario4() {
        resetAll();
        // test data
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "10");
        filters.put("filters[postcode]", "3083cz");
        final SuggestionRequest request = new SuggestionRequest(UUID.randomUUID().toString(), filters);
        final OverheidResult<SuggestionResponse> expectedResponse = new OverheidResult<>(new SuggestionResponse());
        // expectations
        expect(client.target(SUGGESTER_BASE_PATH)).andReturn(webTarget);
        expect(webTarget.path(request.getQuery())).andReturn(webTarget);
        for (final String key : request.getFilters().keySet()) {
            expect(webTarget.queryParam(key, request.getFilters().get(key))).andReturn(webTarget);
        }
        expect(webTarget.request(MediaType.APPLICATION_JSON_TYPE)).andReturn(builder);
        expectAuthHeader();
        expect(builder.get(new GenericType<OverheidResult<SuggestionResponse>>() {
        })).andReturn(expectedResponse);
        replayAll();
        final OverheidResult<SuggestionResponse> result = overheidClient.getSuggestion(request);
        getHelper().assertResultResponse(expectedResponse, result);
        verifyAll();
    }
    //endregion

    //endregion

    //region Utility methods
    private void expectAuthHeader() {
        expect(builder.header(API_KEY_HEADER_NAME, API_KEY)).andReturn(builder);
    }
    //endregion
}