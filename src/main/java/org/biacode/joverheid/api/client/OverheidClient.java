package org.biacode.joverheid.api.client;

import org.biacode.joverheid.api.model.common.OverheidResult;
import org.biacode.joverheid.api.model.request.GetCorporationRequest;
import org.biacode.joverheid.api.model.request.GetCorporationsRequest;
import org.biacode.joverheid.api.model.request.GetDossierCorporationRequest;
import org.biacode.joverheid.api.model.request.SuggestionRequest;
import org.biacode.joverheid.api.model.response.GetCorporationResponse;
import org.biacode.joverheid.api.model.response.GetCorporationsResponse;
import org.biacode.joverheid.api.model.response.GetDossierCorporationResponse;
import org.biacode.joverheid.api.model.response.SuggestionResponse;

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
