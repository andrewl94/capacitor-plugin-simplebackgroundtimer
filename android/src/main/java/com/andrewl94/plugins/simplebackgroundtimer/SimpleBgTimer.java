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
    private boolean execucoes = false;



    @PluginMethod
    public void startInterval(PluginCall call) {
        String interval = call.getString("interval");

     
        TimerTask task = new TimerTask() {
            public void run() {
                LocalDateTime now = LocalDateTime.now();  
                JSObject ret = new JSObject();
                ret.put("timestamp", "teste");
                notifyListeners("interval", ret);
            }
        };
        if(execucoes == false){
            timer.schedule(task, 0 ,1000);
            execucoes = true
        }
        

        JSObject retorno = new JSObject();
        retorno.put("value", true);
        call.success(retorno);
    }

    @PluginMethod
    public void stopInterval(PluginCall call) {
        timer.cancel();
        JSObject retorno = new JSObject();
        execucoes = false;
        retorno.put("value", true);
        call.success(retorno);
    }
}
