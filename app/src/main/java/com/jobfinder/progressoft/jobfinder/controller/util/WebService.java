package com.jobfinder.progressoft.jobfinder.controller.util;

import android.net.Uri;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WebService {
    private static final String PARAM_WEBSERVICE_KEY = "key";
    private static final String WEBSERVICE_KEY = "Ae#T%_)34C!?";
   //public static final String URL = "https://jobs.search.gov/jobs/search.json";
    public static final String URL_Get_Hub = "https://jobs.github.com/positions.json?";
    public static final String URL_Search_Gov ="https://jobs.search.gov/jobs/search.json?";
    private static final int CONNECTION_TIME_OUT = 10000;
    private static final String SCHEME = "https";
    private static final String AUTHORITY = "maps.googleapis.com";
    private static final String PATH = "maps/api/timezone/json";

    public static String callGetService(Map<String, String> params) {
        Uri uri = getUri(params);

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(URL_Get_Hub+uri));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                String res = out.toString();
                out.close();
                return res;
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String callSearchService(Map<String, String> params) {
        Uri uri = getUri(params);

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse response = httpclient.execute(new HttpGet(URL_Search_Gov+uri));
            StatusLine statusLine = response.getStatusLine();
            if (statusLine.getStatusCode() == HttpStatus.SC_OK) {
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                response.getEntity().writeTo(out);
                String res = out.toString();
                out.close();
                return res;
            } else {
                response.getEntity().getContent().close();
                throw new IOException(statusLine.getReasonPhrase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Uri getUri(Map<String, String> params) {
        Uri.Builder uriBuilder = new Uri.Builder().scheme(SCHEME)
                .authority(AUTHORITY)
                .path(PATH);

        for (Map.Entry<String, String> param : params.entrySet()) {
            uriBuilder.appendQueryParameter(param.getKey(), param.getValue());
        }

        return uriBuilder.build();
    }
}