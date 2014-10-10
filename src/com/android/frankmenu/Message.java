package com.android.frankmenu;


import java.util.Iterator;
import java.util.List;


import android.app.Activity;
import android.app.PendingIntent;
import android.telephony.SmsManager;


public class Message {
	private String number;
	public Message(String phonenumber){
		number = phonenumber;
	}
	public void sendMessage(String msg,Activity menu_ac){
		SmsManager smsManager = SmsManager.getDefault();
		PendingIntent sentIntent = PendingIntent.getActivity(
				menu_ac,0,menu_ac.getIntent(),
				PendingIntent.FLAG_UPDATE_CURRENT);
		if(msg.length() > 70){
			List<String> msgs = smsManager.divideMessage(msg);
			Iterator<String> iter = msgs.iterator();
			while(iter.hasNext()){
				String ever_msg = iter.next();
				smsManager.sendTextMessage(number,null,ever_msg,
						sentIntent,null);
			}
		} else {
			smsManager.sendTextMessage(number,null,msg,
					sentIntent,null);
		}

	}
	} 