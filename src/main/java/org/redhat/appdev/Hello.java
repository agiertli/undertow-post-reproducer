package org.redhat.appdev;

import javax.inject.Named;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Named("myBean")
public class Hello {

  private Logger logger = LoggerFactory.getLogger(Hello.class.getName());

  public void post(Exchange exchange) {

    exchange.getOut().setBody("I was invoked via POST method");


  }

  public void get(Exchange exchange) {

    exchange.getOut().setBody("I was invoked via GET method");

  }
}