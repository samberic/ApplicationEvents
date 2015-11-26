package com.samatkinson.sod;

import java.util.Arrays;
import java.util.List;


/**
 * Created by sam on 26/11/2015.
 */
public class CompositeStartOfDayListener implements StartOfDayListener {


    private List<StartOfDayListener> someStartOfDayProcess;

    public CompositeStartOfDayListener(StartOfDayListener... someStartOfDayProcess) {
        this.someStartOfDayProcess = Arrays.asList(someStartOfDayProcess);
    }

    public void onStartOfDay() {
        someStartOfDayProcess.forEach(StartOfDayListener::onStartOfDay);

    }
}
