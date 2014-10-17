package com.android.frankmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.menu.R;

public class MenuActivity extends Activity{
	private CheckBox menu[];
	private Button sendbutton;
	private SelecedMenu selecedmenu[];
	private Message msg;
	private String user_info;
	private boolean flag[];
	private TextView price[];
	private int number;
	private Activity context;
	private int checkbox_base;
	private int price_base;
	private TextView Dialog_text;
	public void initView(){
		   checkbox_base = R.id.checkBox1;
		   price_base = R.id.price1;
		   int i = 0;
		   for (i = 0; i < 27; i++){
		   menu[i] = (CheckBox)findViewById(checkbox_base + 3*i);
		   price[i] = (TextView)findViewById(price_base+3*i);
		   menu[i].setOnCheckedChangeListener(new select());
		   }
		   sendbutton = (Button)findViewById(R.id.button1);
	}
	private class select implements CompoundButton.OnCheckedChangeListener{
         @Override
         public void onCheckedChanged(CompoundButton buttonView,
                 boolean isChecked) {
        	 int i = 0;
        	for(i = 0;i < 27; i++){
        		if(buttonView.getId() == (checkbox_base + 3*i))
        		{
        			if (isChecked){
        				flag[i] = true;
        				number++;
        			} else {
        				flag[i] = false;
        				number--;
        			}
        		}
        	}
         }
     }; 
	private void get_user_data(){
		SharedPreferences userInfo = getSharedPreferences("user_infos", 0);
		String name = userInfo.getString("name","");
		String addr = userInfo.getString("addr","");
		user_info = name + addr;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		   setContentView(R.layout.food);
		   menu = new CheckBox[100];
		   selecedmenu = new SelecedMenu[100];
		   price = new TextView[100];
		   flag = new boolean[100];
		   context = this;
		   initView();
		   get_user_data();
		   number = 0;
		   selecedmenu[0] = new SelecedMenu();
		   selecedmenu[1] = new SelecedMenu();
		   msg = new Message("15000530652");
		   sendbutton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(number == 0){
					Toast toast = Toast.makeText(getApplicationContext(),
							"请选择您需要的菜品!", Toast.LENGTH_SHORT); 
					toast.show(); //请选择菜品
				}
				else{
					int i = 0;
					String output = "";
					output += user_info + "\n";
					for(i = 0;i < 27;i++){
						if(flag[i] == true){
							output += menu[i].getText().toString() + "\n";
						}
					}
				
					Dialog alertDialog = new AlertDialog.Builder(context). 
			                setTitle("点菜清单"). 
			                setIcon(R.drawable.ic_launcher). 
			                setMessage(output). 
			                setPositiveButton("确认", 
			                		new DialogInterface.OnClickListener(){

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											// TODO Auto-generated method stub
											//发送信息
											//msg.sendMessage(output, context);
										
										}
			                	
			                }).
			                setNegativeButton("取消",
			                		new DialogInterface.OnClickListener(){

										@Override
										public void onClick(
												DialogInterface dialog,
												int which) {
											// TODO Auto-generated method stub
											
										}}).create();
					 alertDialog.show(); 
		
				}
			}
			   
		   });
	}

}
