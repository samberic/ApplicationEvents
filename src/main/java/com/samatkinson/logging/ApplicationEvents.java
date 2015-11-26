package com.samatkinson.logging;

import com.samatkinson.sod.StartOfDayListener;

/**
 * Created by sam on 26/11/2015.
 */
public interface ApplicationEvents extends StartOfDayListener {
    void startOfDayEnds();

    void onStartOfDay();
}
