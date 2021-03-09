package com.example.akanksha.broadcast_179;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;


public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean state = intent.getBooleanExtra("state", false);
        if(state == false){
            Toast.makeText(context, "Broadcast : Flight mode Off.",
                    Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(context, "Broadcast : Flight mode On.",
                    Toast.LENGTH_LONG).show();
        }
    }

}
