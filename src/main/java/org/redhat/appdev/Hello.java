package org.redhat.appdev;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("myBean")
public class Hello {

  @Inject
  private Logger logger;


  public void post(Exchange exchange) {

    exchange.getOut().setBody("I was invoked via POST method");


  }

  public void get(Exchange exchange) {

    logger.info("Is producer working?");

    exchange.getOut().setBody("I was invoked via GET method");

  }
}