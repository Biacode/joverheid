package com.sfl.overheid.api;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.client.impl.OverheidClientImpl;

import javax.ws.rs.client.ClientBuilder;

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
        final Object test = overheidClient.test();
        System.out.println(test.toString());
    }
}
