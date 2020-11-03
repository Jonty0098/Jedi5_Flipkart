package com.dropwizard;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.rest.CustomerControler;
import com.flipkart.rest.RestController;
import com.flipkart.rest.SmsAdminRest;
import com.flipkart.rest.SmsProfessorRest;
import com.flipkart.rest.SmsStudentRest;
import com.flipkart.rest.SmsUserRest;
/**
 * Entry point for our application 
 *
 */
public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        e.jersey().register(new CustomerControler());
        e.jersey().register(new RestController());
        e.jersey().register(new SmsAdminRest());
        e.jersey().register(new SmsProfessorRest());
        e.jersey().register(new SmsStudentRest());
        e.jersey().register(new SmsUserRest());
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}