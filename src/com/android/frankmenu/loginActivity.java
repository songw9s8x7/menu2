package com.android.frankmenu;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.menu.R;

public class loginActivity extends Activity {
	private EditText user_name;
	private EditText user_addr;
	private Button finished;
	private String user_info;
	private void initView(){
		user_name = (EditText)findViewById(R.id.user_name);
		user_addr = (EditText)findViewById(R.id.user_addr);
		finished = (Button)findViewById(R.id.finished);
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.food);
		initView();	
finished.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences userInfo = getSharedPreferences("user_info", 0);
				String name = userInfo.getString("name", "");
				String addr = userInfo.getString("addr", "");
				name = user_name.getText().toString();
				addr = user_addr.getText().toString();
			
			}
		});
	}
	
}
