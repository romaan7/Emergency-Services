package com.emergency.services;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.emergency.services.alarm.*;
import com.emergency.services.firstaid.EmergencyListActivity;
import com.emergency.services.library.UserFunctions;
import com.emergency.services.R;

@SuppressLint("NewApi")
public class DashboardActivity extends Activity {
	UserFunctions userFunctions;
	Button btnLogout;
	Button btnAbout;
	ImageView bloodImg;
	ImageView sos;
	ImageView hospital;
	ImageView news;
	ImageView reminder;
	ImageView rss;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
/*
         * Dashboard Screen for the application
         *  */  
        // Check login status in database
        userFunctions = new UserFunctions();
        if(userFunctions.isUserLoggedIn(getApplicationContext())){
        	setContentView(R.layout.dashboard);
        	btnLogout = (Button) findViewById(R.id.btnLogout);
        	btnAbout = (Button) findViewById(R.id.btnAbout);
        	
        	bloodImg =  (ImageView) findViewById(R.id.bloodImg);
            sos =  (ImageView) findViewById(R.id.sos);
            hospital =  (ImageView) findViewById(R.id.hospital);
            news =  (ImageView) findViewById(R.id.news);
            reminder =  (ImageView) findViewById(R.id.reminder);
            rss =  (ImageView) findViewById(R.id.rss);
            
            bloodImg.setOnClickListener(new View.OnClickListener() {

    			public void onClick(View view) {
    				Intent blood = new Intent(getApplicationContext(),
    						SearchBlood.class);
    				startActivity(blood);
    				
    			}
    		}); 
            
          sos.setOnClickListener(new View.OnClickListener() {

    			public void onClick(View view) {
    				Intent sos = new Intent(getApplicationContext(),
    						SosActivity.class);
    				startActivity(sos);
    			}
    		}); 
            
            hospital.setOnClickListener(new View.OnClickListener() {

    			public void onClick(View view) {
    				Intent hospital = new Intent(getApplicationContext(),
    						HospitalSearch.class);
    				startActivity(hospital);
    			}
    		}); 
            
            news.setOnClickListener(new View.OnClickListener() {

    			public void onClick(View view) {
    				Intent news = new Intent(getApplicationContext(),
    						EmergencyListActivity.class);
    				startActivity(news);
    			}
    		}); 
            
            reminder.setOnClickListener(new View.OnClickListener() {

    			public void onClick(View view) {
    				Intent reminder = new Intent(getApplicationContext(),
    						MainActivity.class);
    				startActivity(reminder);
    			}
    		});  
            
            rss.setOnClickListener(new View.OnClickListener() {

    			public void onClick(View view) {
    				Intent reminder = new Intent(getApplicationContext(),
    						MainActivity.class);
    				startActivity(reminder);
    			}
    		}); 
            
            

        	btnLogout.setOnClickListener(new View.OnClickListener() {
    			
    			public void onClick(View arg0) {
    				// TODO Auto-generated method stub
    				userFunctions.logoutUser(getApplicationContext());
    				Intent login = new Intent(getApplicationContext(), LoginActivity.class);
    	        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	        	startActivity(login);
    	        	// Closing dashboard screen
    	        	finish();
    			}
    		});
        	
        	btnAbout.setOnClickListener(new View.OnClickListener() {
    			
        		public void onClick(View view) {
        			showAbout();
    			}
    		}); 
        	
        }else{
        	// user is not logged in show login screen
        	Intent login = new Intent(getApplicationContext(), LoginActivity.class);
        	login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        	startActivity(login);
        	// Closing dashboard screen
        	finish();
        }
    
    }
    
    
    protected void showAbout() {
        // Inflate the about message contents
        View messageView = getLayoutInflater().inflate(R.layout.about_activity, null, false);
 
        // When linking text, force to always use default color. This works
        // around a pressed color state bug.
 //       TextView textView = (TextView) messageView.findViewById(R.id.about_credits);
//        int defaultColor = textView.getTextColors().getDefaultColor();
//        textView.setTextColor(defaultColor);
 
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_launcher);
        builder.setTitle(R.string.app_name);
        builder.setView(messageView);
        builder.create();
        builder.show();
    }
    
    

	
}