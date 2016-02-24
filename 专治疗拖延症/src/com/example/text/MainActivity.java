package com.example.text;


import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.text.R.id;

public class MainActivity extends Activity {
	 private static final ViewGroup LinearLayout = null;
	ActionBar actionBar ;
	 public ImageButton m_bt;
	 int i = 1;
	// LinearLayout linear1,linear2,linear3,linear4,linear5;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setActionBarLayout( R.layout.caidan );
		//LinearLayout linear = (LinearLayout)((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate( R.layout.activity_main, null);  
		//------------���Բ��ֵļ����¼�-----------------------------
		LinearLayout linear = (LinearLayout) findViewById(R.id.linear);
		 linear.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "��ӳɹ�",Toast.LENGTH_SHORT).show();
				m_click();
				i++;
				//System.out.println("%d"+i);
				//System.out.println("-------------------");
			}
		});
		//---------------�˵��ļ����¼�	-----------------
		m_bt =  (ImageButton) findViewById(R.id.im_bt);
		m_bt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//LinearLayout dh_bt = (LinearLayout)getLayoutInflater()  
		             //  .inflate( R.layout.dh_btn, null);//�����ʽ
				final String[] items = new String[]{"���Ƽ�¼","���Ƴ̶�","������ʽ"};
				Builder builder = new AlertDialog.Builder(MainActivity.this);
				//builder.setView(dh_bt);//���öԻ�����ʽ
				builder.setItems(items,new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						 startActivity(new Intent (MainActivity.this, rl.class) );
						
					}
				});
				builder.create().show();
			}
		});
	}
	//--------------�޸�actionbar----------------------
	public void setActionBarLayout( int layoutId ){
		actionBar = getActionBar();
	    if( null != actionBar ){
	        actionBar.setDisplayShowHomeEnabled(false);
	        actionBar.setDisplayShowCustomEnabled(true);
	        LayoutInflater inflator = (LayoutInflater)   this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	        View v = inflator.inflate(layoutId, null);
	        ActionBar.LayoutParams layout = new  ActionBar.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
	        actionBar.setCustomView(v,layout);
	    }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	//----------------���ڵ�����ֵĵ������----------------------
	public void m_click() {
		LinearLayout L1 = new LinearLayout(this);	
		LinearLayout LL1 = (LinearLayout)this.getLayoutInflater().inflate(R.layout.activity_main,null);
		LinearLayout LL2 = (LinearLayout)this.getLayoutInflater().inflate(R.layout.linear1,LL1,false);
		LinearLayout LL3 = (LinearLayout)this.getLayoutInflater().inflate(R.layout.linear2,LL1,false);
		LinearLayout LL4 = (LinearLayout)this.getLayoutInflater().inflate(R.layout.linear3,LL1,false);
		LinearLayout LL5 = (LinearLayout)this.getLayoutInflater().inflate(R.layout.linear4,LL1,false);
		switch (i) {
		case 1:
			setContentView(LL1); 
			LL1.addView(LL2);
			break;
		case 2:
			setContentView(LL1); 
			LL1.addView(LL3);
		case 3:
			setContentView(LL1); 
			LL1.addView(LL4);
		case 4:
			setContentView(LL1); 
			LL1.addView(LL5);
		default:
			break;
		}	
		
		
	}
}
