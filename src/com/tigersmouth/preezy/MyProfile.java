package com.tigersmouth.preezy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ViewFlipper;

public class MyProfile extends Fragment {
	View fragView;
	
	private ViewFlipper flipper;
	private ImageButton notificationsButton;
	private ImageButton eventFeedButton;
	private ImageButton businessCardButton;
	
	private ListView lv;
	String [] values;
	Context context;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);

		fragView = inflater.inflate(R.layout.activity_my_profile, container, false);
		
		flipper = (ViewFlipper) fragView.findViewById(R.id.flipper_my_profile);
		notificationsButton = (ImageButton) fragView.findViewById(R.id.button_notifications);
		eventFeedButton = (ImageButton) fragView.findViewById(R.id.button_event_feed);
		businessCardButton = (ImageButton) fragView.findViewById(R.id.button_business_card);
		
		notificationsButton.setOnClickListener(new OnClickListener() {			 
			@Override
			public void onClick(View v) {
				//Code to execute on button click
				flipper.setDisplayedChild(0);
				
			} 
		});
		
		eventFeedButton.setOnClickListener(new OnClickListener() {			 
			@Override
			public void onClick(View v) {
				//Code to execute on button click
				flipper.setDisplayedChild(1);
				
			} 
		});
		
		businessCardButton.setOnClickListener(new OnClickListener() {			 
			@Override
			public void onClick(View v) {
				//Code to execute on button click
				flipper.setDisplayedChild(2);
				
			} 
		});
		
		//Code for setting up the list view
		lv = (ListView) fragView.findViewById(R.id.listView_notifications);
		values = new String[] { "Cloud", "Good", "Mic", "Play" };
		context = fragView.getContext();
		
		CustomArrayAdapter adapter = new CustomArrayAdapter(context, values);
		lv.setAdapter(adapter);
		
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
		      @Override
		      public void onItemClick(AdapterView<?> parent, final View view,
		          int position, long id) {
		    	  //Do something when item in the list is selected
		    	  
		      }
		            });
		
		
		
		return fragView;
		
	}
}
