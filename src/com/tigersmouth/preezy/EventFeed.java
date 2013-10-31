package com.tigersmouth.preezy;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EventFeed extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, 
			Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		return inflater.inflate(R.layout.activity_event_feed, container, false);
		}
}
