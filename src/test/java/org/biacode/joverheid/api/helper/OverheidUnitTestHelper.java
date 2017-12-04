package org.biacode.joverheid.api.helper;

import org.biacode.joverheid.api.model.common.AbstractOverheidResponse;
import org.biacode.joverheid.api.model.common.OverheidResult;

import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/6/16
 * Time: 12:12 PM
 */
public final class OverheidUnitTestHelper {

    //region Constructors
    public OverheidUnitTestHelper() {
    }
    //endregion

    //region Common
    public <T extends AbstractOverheidResponse> void assertResultResponse(final OverheidResult<T> expectedResponse,
                                                                          final OverheidResult<T> result) {
        assertNotNull(result);
        assertNotNull(expectedResponse);
        if (result.getResponse() != null) {
            assertEquals(expectedResponse, result);
        }
        if (result.hasError() && result.getError() == null) {
            fail("Can not find error body");
        }
        if (result.hasError()) {
            assertEquals(expectedResponse.getError(), result.getError());
        }
    }
    //endregion

    //region Public methods
    //endregion
}

