package com.sfl.overheid.api.client;

import com.sfl.overheid.api.model.common.OverheidResult;
import com.sfl.overheid.api.model.response.GetCorporationsResponse;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/4/16
 * Time: 3:01 PM
 */
public interface OverheidClient {
    OverheidResult<GetCorporationsResponse> test();

    Object foo();
}
