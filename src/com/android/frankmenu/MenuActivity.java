package com.android.frankmenu;

import android.app.Activity;
import android.os.Bundle;
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
	private String addr;
	private String output;
	private TextView price[];
	private int number;
	private Activity context;
	public void initView(){
		   menu[0] = (CheckBox)findViewById(R.id.checkBox1);
		   menu[1] = (CheckBox)findViewById(R.id.checkBox2);
		   price[0] = (TextView)findViewById(R.id.price1);
		   price[1] = (TextView)findViewById(R.id.price2);
		   sendbutton = (Button)findViewById(R.id.button1);
		   menu[0].setOnCheckedChangeListener(new select());
		   menu[1].setOnCheckedChangeListener(new select());
	}
	private class select implements CompoundButton.OnCheckedChangeListener{
         @Override
         public void onCheckedChanged(CompoundButton buttonView,
                 boolean isChecked) {
        	 switch(buttonView.getId()){
             // TODO Auto-generated method stub
        	 case R.id.checkBox1:	
        		 if(isChecked){
             		selecedmenu[0] = new SelecedMenu((String)menu[0].getText(),
             				Integer.parseInt((String)price[0].getText()));
             		number++;
             	}else{
             		selecedmenu[0] = new SelecedMenu();
             		number--;
             	}
        		 break;
        	 case R.id.checkBox2:
        		 if(isChecked){
              		selecedmenu[1] = new SelecedMenu((String)menu[1].getText(),
              				Integer.parseInt((String)price[1].getText()));
              		number++;
              	}else{
              		selecedmenu[1] = new SelecedMenu();
              		number--;
              	}
         		 break;
        	 }
         }
     }; 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		   setContentView(R.layout.food);
		   menu = new CheckBox[100];
		   selecedmenu = new SelecedMenu[100];
		   price = new TextView[100];
		   context = this;
		   initView();
		   addr = "用户地址信息 ";
		   number = 0;
		   selecedmenu[0] = new SelecedMenu();
		   selecedmenu[1] = new SelecedMenu();
		   msg = new Message("13141048947");
		 
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
					output = addr + selecedmenu[0].toString() + selecedmenu[1].toString();
					Toast toast = Toast.makeText(getApplicationContext(),
							output, Toast.LENGTH_SHORT); 
					toast.show(); 
					//发送信息
					//msg.sendMessage(output, context);
				}
			}
			   
		   });
	}

}
