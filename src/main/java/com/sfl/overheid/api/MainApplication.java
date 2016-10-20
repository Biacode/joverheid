package com.sfl.overheid.api;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.client.impl.OverheidClientImpl;
import com.sfl.overheid.api.model.request.SuggestionRequest;

import javax.ws.rs.client.ClientBuilder;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 10/19/16
 * Time: 2:15 PM
 */
public class MainApplication {
    public static void main(String[] args) {
        final OverheidClient overheidClient = new OverheidClientImpl(
                ClientBuilder.newBuilder().register(JacksonJsonProvider.class).build(),
                "9f01f0b265d703e164681e1f232b0c12607724c26e7b417aa396a2280733cbb8"
        );
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "3");
        final Object test = overheidClient.getSuggestion(new SuggestionRequest("oudet", filters));
        System.out.println(test.toString());
    }
}
