package com.sfl.overheid.api.impl;

import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.client.impl.OverheidClientImpl;
import com.sfl.overheid.api.test.AbstractOverheidUniTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import java.util.UUID;

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
        overheidClient = new OverheidClientImpl(client, UUID.randomUUID().toString());
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

    //endregion

    //endregion

}