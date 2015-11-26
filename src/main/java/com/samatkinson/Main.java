package com.samatkinson;

import com.samatkinson.logging.ApplicationEvents;
import com.samatkinson.logging.ApplicationEventsLogger;
import com.samatkinson.sod.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;


public class Main {
    private static ApplicationEvents applicationEvents = new ApplicationEventsLogger();

    public static void main(String[] args) {
        StartOfDayListener startOfDayListeners = new CompositeStartOfDayListener(
                applicationEvents,
                new SomeStartOfDayProcess(),
                new SomeStartOfDayProcess(),
                new SomeStartOfDayProcess()
        );

        get("/beginStartOfDay", new SoDHandler(startOfDayListeners, applicationEvents));
    }


    private static class SoDHandler implements Route {

        private StartOfDayListener startOfDayListeners;
        private ApplicationEvents applicationEvents;

        private SoDHandler(StartOfDayListener startOfDayListeners, ApplicationEvents applicationEvents) {
            this.startOfDayListeners = startOfDayListeners;
            this.applicationEvents = applicationEvents;
        }

        public Object handle(Request request, Response response) throws Exception {
            startOfDayListeners.onStartOfDay();

            applicationEvents.startOfDayEnds();

            return "Start of Day complete";
        }

    }

}
