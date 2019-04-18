package org.redhat.appdev;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;
import org.apache.camel.model.rest.RestBindingMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Startup
@ApplicationScoped
@ContextName("reproducer")
public class RESTBuilder extends RouteBuilder {

    private Logger logger = LoggerFactory.getLogger(RESTBuilder.class.getName());

    @Override
    public void configure() throws Exception {
        logger.info("initializing camel routes");

        restConfiguration().component("undertow").host("localhost").port("8081").bindingMode(RestBindingMode.json);

        rest("/").description("Hello World Camel On EAP API")

         .post("/executePost").route().bean("myBean","post").endRest()
         .get("/executeGet").route().bean("myBean","get").endRest();
    }

}
