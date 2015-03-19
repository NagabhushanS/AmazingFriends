package com.blogspot.nagabhushan2;

import android.app.Application;

import com.blogspot.nagabhushan.ParseConstants;
import com.blogspot.nagabhushan.R;
import com.blogspot.nagabhushan1.MainActivity;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.PushService;

public class AmazingFriendsApplication extends Application {
	
	@Override
	public void onCreate() { 
		super.onCreate();
		 
		Parse.initialize(this, "PsOttCLwKheePLzmK04aQKCuPvDPoVp1jticfIzj", "lRI1N7DNqhLIGxkx1B2hkpLKg67B5a7U0fbXS9qQ");

	    
	    //PushService.setDefaultPushCallback(this, MainActivity.class);
	    PushService.setDefaultPushCallback(this, MainActivity.class, 
	    		R.drawable.ic_stat_ic_launcher);
	    ParseInstallation.getCurrentInstallation().saveInBackground();
	}
	
	public static void updateParseInstallation(ParseUser user) {
		ParseInstallation installation = ParseInstallation.getCurrentInstallation();
		installation.put(ParseConstants.KEY_USER_ID, user.getObjectId());
		installation.saveInBackground();
	}
}
