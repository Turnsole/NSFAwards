package com.lastminutedevice.nsfawards;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Maintains the request queue.
 */
public class NSFAwardsApplication extends Application {
    private static NSFAwardsApplication instance;
    private RequestQueue requestQueue;

    @Override
    public void onCreate() {
        super.onCreate();
        requestQueue = Volley.newRequestQueue(this);
        instance = this;
    }

    public synchronized static NSFAwardsApplication getInstance() {
        return instance;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
