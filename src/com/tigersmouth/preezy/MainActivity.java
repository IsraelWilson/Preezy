package com.tigersmouth.preezy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
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
		
		
		GeneralPromotion initialFragment = new GeneralPromotion();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		transaction.add(R.id.fragment_container, initialFragment);
		transaction.commit();
		
		//Adds tabs to the action bar for each fragment
		//There are different implementation to get the tab attached to a fragment
		//Android Developers does this differently. Might consider doing a cleaner revision	    
	    ActionBar.Tab generalPromotionTab = actionBar.newTab().setText(R.string.label_general_promotion)
	    		.setIcon(R.drawable.ic_action_mic);
	    ActionBar.Tab myProfileTab = actionBar.newTab().setText(R.string.label_my_profile)
	    		.setIcon(R.drawable.ic_action_video);
	    
	    Fragment generalPromotionFragment = new GeneralPromotion();
	    Fragment myProfileFragment = new MyProfile();
	    
	    generalPromotionTab.setTabListener(new MyTabsListener(generalPromotionFragment));
	    myProfileTab.setTabListener(new MyTabsListener(myProfileFragment));
	    
	    actionBar.addTab(generalPromotionTab);
	    actionBar.addTab(myProfileTab);
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
			swapFragment = new MyProfile();
			ft.replace(R.id.fragment_container, swapFragment );
			ft.addToBackStack(null);
			ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			ft.commit();
			return true;
		} else if (itemId == R.id.action2) {
			//Switch Fragment here
			swapFragment = new GeneralPromotion();
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
