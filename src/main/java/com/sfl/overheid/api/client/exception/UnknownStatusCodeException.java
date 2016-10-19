package com.sfl.overheid.api.client.exception;


import com.sfl.overheid.api.model.common.AbstractOverheidRequest;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/7/16
 * Time: 9:23 PM
 */
public class UnknownStatusCodeException extends RuntimeException {
    private static final long serialVersionUID = 6484963847484081436L;

    private final AbstractOverheidRequest request;

    //region Constructors
    public UnknownStatusCodeException(final String message, final AbstractOverheidRequest request) {
        super(message);
        this.request = request;
    }
    //endregion

    //region Public methods
    public AbstractOverheidRequest getRequest() {
        return request;
    }
    //endregion
}
