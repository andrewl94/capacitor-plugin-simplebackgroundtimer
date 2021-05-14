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


    Runtime.getRuntime().addShutdownHook(new Thread() {

        @Override
        public void run() {
            JSObject ret = new JSObject();
                ret.put("appClosed", true);
                notifyListeners("appClosed", ret);
        }
    
    });

    @PluginMethod
    public void startInterval(PluginCall call) {
        String interval = call.getString("interval");

     
        TimerTask task = new TimerTask() {
            public void run() {
                LocalDateTime now = LocalDateTime.now();  
                JSObject ret = new JSObject();
                ret.put("timestamp", now);
                notifyListeners("interval", ret);
            }
        };
        timer.schedule(task, 0 ,1000);

        JSObject retorno = new JSObject();
        retorno.put("value", true);
        call.success(retorno);
    }

    @PluginMethod
    public void stopInterval(PluginCall call) {
        timer.cancel();
        JSObject retorno = new JSObject();
        retorno.put("value", true);
        call.success(retorno);
    }
}
