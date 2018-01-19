package com.kg.vista.ooba.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.kg.vista.ooba.R;


//import kg.ooba.mobile.android.pages.FourButtonsActivity;

public class SplashScreen extends Activity {

    private UsersManagement usrData = new UsersManagement();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    //Intent intent = new Intent(SplashScreen.this, WelcomeActivity.class);
                    Intent intent;
                    String USER_ID = usrData.getUserData(SplashScreen.this);
                    if (Integer.parseInt(USER_ID) > 0) {
                        //intent = new Intent(SplashScreen.this,FourButtonsActivity.class);
                        intent = new Intent(SplashScreen.this, MainActivity.class);
                    } else {
                        intent = new Intent(SplashScreen.this, WelcomeActivity.class);
                    }
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {
        // TODO Auto-generated method stub
        super.onPause();
        finish();
    }

}
