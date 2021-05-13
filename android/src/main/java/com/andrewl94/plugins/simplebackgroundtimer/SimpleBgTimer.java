package com.andrewl94.plugins.simplebackgroundtimer;

import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import java.util.Timer;
import java.util.TimerTask;
import java.time.LocalDateTime;   

@NativePlugin
public class SimpleBgTimer extends Plugin {
    private Timer timer = new Timer("Timer");
    private long execucoes = 0;

    @PluginMethod
    public void startInterval(PluginCall call) {
        String interval = call.getString("interval");

     
        TimerTask task = new TimerTask() {
            public void run() {
                LocalDateTime now = LocalDateTime.now();  
                notifyListeners("interval", now);
            }
        };
        timer.schedule(task, 0 ,1000);

        call.success(true);
    }

    @PluginMethod
    public void stopInterval(PluginCall call) {
        timer.cancel();
        call.success(true);
    }
}
