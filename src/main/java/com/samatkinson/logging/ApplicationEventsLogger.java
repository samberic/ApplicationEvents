package com.samatkinson.logging;

import com.samatkinson.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by sam on 26/11/2015.
 */
public class ApplicationEventsLogger implements ApplicationEvents {

    public static Logger LOGGER = LoggerFactory.getLogger(ApplicationEventsLogger.class);

    @Override
    public void startOfDayEnds() {
        LOGGER.info("SOD Finished");
    }

    @Override
    public void onStartOfDay() {
        LOGGER.info("SOD Requested, handling...");
    }

}
