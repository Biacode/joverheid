package com.sfl.overheid.api.client;

import com.sfl.overheid.api.model.common.OverheidResult;
import com.sfl.overheid.api.model.request.GetCorporationRequest;
import com.sfl.overheid.api.model.request.GetCorporationsRequest;
import com.sfl.overheid.api.model.request.GetDossierCorporationRequest;
import com.sfl.overheid.api.model.request.SuggestionRequest;
import com.sfl.overheid.api.model.response.GetCorporationResponse;
import com.sfl.overheid.api.model.response.GetCorporationsResponse;
import com.sfl.overheid.api.model.response.GetDossierCorporationResponse;
import com.sfl.overheid.api.model.response.SuggestionResponse;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/4/16
 * Time: 3:01 PM
 */
public interface OverheidClient {
    OverheidResult<GetCorporationResponse> getCorporation(final GetCorporationRequest request);

    OverheidResult<GetCorporationsResponse> getCorporations(final GetCorporationsRequest request);

    OverheidResult<GetDossierCorporationResponse> getDossierCorporation(final GetDossierCorporationRequest request);

    OverheidResult<SuggestionResponse> getSuggestion(final SuggestionRequest request);
}
