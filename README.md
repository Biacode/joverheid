### CI Status
[![Build Status](https://travis-ci.org/bia-code/joverheid.svg?branch=master)](https://travis-ci.org/bia-code/joverheid)
[![SonarCube](https://getstreaming.files.wordpress.com/2012/10/sonar.png)](https://sonarqube.com/dashboard/index/com.sfl.joverheid:joverheid)
# joverheid
Java implementation of Overheid.io API
# How to use

### Installation

First of all, you need any implementation of ```javax.ws.rs.client.Client```
For example you can use jersey client

Add the following dependency to your maven pom.xml file
```xml
<dependency>
    <groupId>org.glassfish.jersey.core</groupId>
    <artifactId>jersey-client</artifactId>
    <version>${jersey.client.version}</version>
</dependency>
```
Then you need pass client implementation to OverheidClient as constructor param.

# Example to construct client implementation in spring framework.
In application context XML add the following XML definition
```java
<bean id="overheidJerseyClientBuilder"
          class="com.sfl.overheid.api.configuration.impl.OverheidJerseyClientBuilderImpl"/>

<bean id="overheidJerseyClient" factory-bean="overheidJerseyClientBuilder" factory-method="build"/>

<bean id="overheidClient" class="com.sfl.overheid.api.client.impl.OverheidClientImpl">
    <constructor-arg name="client" ref="overheidJerseyClient"/>
</bean>

```

# If you simply need to test overheid API.
Then construct jersey client as follows
```java
package my.application;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.sfl.overheid.api.client.OverheidClient;
import com.sfl.overheid.api.client.impl.OverheidClientImpl;
import com.sfl.overheid.api.model.common.OverheidResult;
import com.sfl.overheid.api.model.request.GetCorporationsRequest;
import com.sfl.overheid.api.model.response.GetCorporationsResponse;

import javax.ws.rs.client.ClientBuilder;
import java.util.HashMap;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        // construct overheid java client
        final OverheidClient overheidClient = new OverheidClientImpl(
                ClientBuilder.newBuilder().register(JacksonJsonProvider.class).build(),
                "Your API key here"
        );
        // you can build filters and pass them to the request constructor as follows
        final Map<String, String> filters = new HashMap<>();
        filters.put("size", "10");
        filters.put("filters[postcode]", "3083cz");
        final GetCorporationsRequest getCorporationsRequest = new GetCorporationsRequest(filters);
        final OverheidResult<GetCorporationsResponse> corporations = overheidClient
                .getCorporations(getCorporationsRequest);
        // check if there is any error
        if (corporations.hasError()) {
            System.out.println(corporations.getError());
        } else {
            // the getResponse() will return the response models E.g. embedded and links
            System.out.println(corporations.getResponse());
            System.out.println(corporations.getResponse().getEmbedded());
            System.out.println(corporations.getResponse().getLinks());
        }
    }
}
```

# Available API calls
**Get single corporation**
```
overheidClient.getCorporation(new GetCorporationRequest(12345, "subdossier nummer here"));
```

**Get corporations**
```
overheidClient.getCorporations(new GetCorporationsRequest(filters));
```

**Get dossier corporation**
```
overheidClient.getDossierCorporation(new GetDossierCorporationRequest(12345));
```

**Get suggestions**
```
overheidClient.getSuggestion(new SuggestionRequest("oudet", filters));
```

# Best practices
Make singleton of the ```OverheidClient``` so you do not need to construct the client for every API call 

The official Overheid [documentation](https://overheid.io/documentatie/kvk)