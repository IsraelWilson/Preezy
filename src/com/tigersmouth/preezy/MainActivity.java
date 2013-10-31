package com.tigersmouth.preezy;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	public static Context appContext;
	Fragment swapFragment;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		appContext = getApplicationContext();
		
		//Hides the Title Bar and Home Icon
		ActionBar actionBar = getSupportActionBar();
		//actionBar.setDisplayShowHomeEnabled(false);
		//actionBar.setDisplayShowTitleEnabled(false);
		
		
		GeneralPromotion initialFragment = new GeneralPromotion();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.fragment_container, initialFragment);
		transaction.commit();
		
		//Adds tabs to the action bar for each fragment
		//There are different implementation to get the tab attached to a fragment
		//Android Developers does this differently. Might consider doing a cleaner revision	    
	    ActionBar.Tab generalPromotionTab = actionBar.newTab().setText(R.string.label_general_promotion)
	    		.setIcon(R.drawable.ic_action_mic);
	    ActionBar.Tab eventFeedTab = actionBar.newTab().setText(R.string.label_event_feed)
	    		.setIcon(R.drawable.ic_action_play);
	    ActionBar.Tab myProfileTab = actionBar.newTab().setText(R.string.label_my_profile)
	    		.setIcon(R.drawable.ic_action_video);
	    ActionBar.Tab notificationsTab = actionBar.newTab().setText(R.string.label_notifications)
	    		.setIcon(R.drawable.ic_action_cloud);
	    ActionBar.Tab businessCardTab = actionBar.newTab().setText(R.string.label_business_card)
	    		.setIcon(R.drawable.ic_action_good);
	    
	    Fragment generalPromotionFragment = new GeneralPromotion();
	    Fragment eventFeedFragment = new EventFeed();
	    Fragment myProfileFragment = new MyProfile();
	    Fragment notificationsFragment = new Notifications();
	    Fragment businessCardFragment = new BusinessCard();
	    
	    generalPromotionTab.setTabListener(new MyTabsListener(generalPromotionFragment));
	    eventFeedTab.setTabListener(new MyTabsListener(eventFeedFragment));
	    myProfileTab.setTabListener(new MyTabsListener(myProfileFragment));
	    notificationsTab.setTabListener(new MyTabsListener( notificationsFragment));
	    businessCardTab.setTabListener(new MyTabsListener(businessCardFragment));
	    
	    actionBar.addTab(generalPromotionTab);
	    actionBar.addTab(eventFeedTab);
	    actionBar.addTab(myProfileTab);
	    actionBar.addTab(notificationsTab);
	    actionBar.addTab(businessCardTab);
	    actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
	}
	
	//This method inflates the action bar if it exist
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.action_menu, menu);
		return true;
	}
	
	//This method is used for handling click events from the ActionBar action items
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		
		int itemId = item.getItemId();
		if (itemId == R.id.action1) {
			//Switch Fragment here
			swapFragment = new EventFeed();
			ft.replace(R.id.fragment_container, swapFragment );
			ft.addToBackStack(null);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			return true;
		} else if (itemId == R.id.action2) {
			//Switch Fragment here
			swapFragment = new MyProfile();
			ft.replace(R.id.fragment_container, swapFragment );
			ft.addToBackStack(null);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			return true;
		} else if (itemId == R.id.action3) {
			//Switch Fragment here
			swapFragment = new GeneralPromotion();
			ft.replace(R.id.fragment_container, swapFragment );
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();
			return true;
		} else if (itemId == R.id.action4) {
			//Switch Fragment here
			swapFragment = new Notifications();
			ft.replace(R.id.fragment_container, swapFragment );
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();
			return true;
		} else if (itemId == R.id.action5) {
			//Switch Fragment here
			swapFragment = new BusinessCard();
			ft.replace(R.id.fragment_container, swapFragment );
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.addToBackStack(null);
			ft.commit();
			return true;
		} else if (itemId == R.id.action_settings) {
			//Create a setting actions function
			return true;
		} else {
			return super.onOptionsItemSelected(item);
		}
	}
	
	@Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("tab", getSupportActionBar().getSelectedNavigationIndex());
    }
}
