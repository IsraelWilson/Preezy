package com.tigersmouth.preezy;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.widget.Toast;

public class MyTabsListener implements TabListener {
	public Fragment fragment;
	
	public MyTabsListener( Fragment fragment ){
		this.fragment = fragment;
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		Toast.makeText(MainActivity.appContext, "Reselected!", Toast.LENGTH_LONG).show();

	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.replace(R.id.fragment_container, fragment);

	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		ft.remove(fragment);

	}

}
