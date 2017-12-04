package org.biacode.joverheid.api.test;

import org.biacode.joverheid.api.helper.OverheidUnitTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/6/16
 * Time: 12:12 PM
 */
@Ignore
@RunWith(EasyMockRunner.class)
public abstract class AbstractOverheidUniTest extends EasyMockSupport {

    //region Dependencies
    private final OverheidUnitTestHelper helper;
    //endregion

    //region Constructors
    protected AbstractOverheidUniTest() {
        helper = new OverheidUnitTestHelper();
    }
    //endregion

    //region Public methods
    protected OverheidUnitTestHelper getHelper() {
        return helper;
    }
    //endregion

}
