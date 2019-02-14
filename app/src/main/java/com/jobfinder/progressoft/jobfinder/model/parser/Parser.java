package com.jobfinder.progressoft.jobfinder.model.parser;

import com.jobfinder.progressoft.jobfinder.model.vo.ResponseError;

import org.json.JSONException;
import org.json.JSONObject;

public class Parser {
    private static final String OBJECT_ERROR = "error";
    private static final String VALUE_ERROR_CODE = "code";
    private static final String VALUE_ERROR_DESCRIPTION = "description";

    public static ResponseError parseResponseError(JSONObject jsonObject) {
        try {
            JSONObject errorObject = jsonObject.getJSONObject(OBJECT_ERROR);
            String errorCode = errorObject.getString(VALUE_ERROR_CODE);
            String errorDescription = errorObject.getString(VALUE_ERROR_DESCRIPTION);
            return new ResponseError(Integer.parseInt(errorCode), errorDescription);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}