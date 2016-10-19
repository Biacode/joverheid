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

import static org.easymock.EasyMock.reset;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/6/16
 * Time: 11:10 AM
 */
public class OverheidClientImplTest extends AbstractOverheidUniTest {

    //region Constants
    private static final String BASE_PATH = "https://api.overheid.com";

    private static final String API_VERSION = "v1";

    private static final String CALENDARS_PATH = "calendars";

    private static final String CHANNELS_PATH = "channels";

    private static final String PROFILES_PATH = "profiles";

    private static final String AUTH_HEADER_KEY = "Authorization";

    private static final String ACCOUNT_PATH = "account";

    private static final String EVENTS = "events";
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
        overheidClient = new OverheidClientImpl(client);
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

    @Test
    public void testDummy() {
        resetAll();
        // test data
        // expectations
        replayAll();
        verifyAll();
    }

    //endregion

}