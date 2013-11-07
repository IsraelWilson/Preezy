package com.tigersmouth.preezy;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomArrayAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	
	//Find way to add int layout to list of non-initialized members
	public CustomArrayAdapter(Context context, String[] values){
		super(context, R.layout.row_notifications, values);
		this.context = context;
		this.values = values;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.row_notifications, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.activity_user);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon_user);
		textView.setText(values[position]);
 
		// Change icon based on name
		String s = values[position];
 
		if (s.equals("Cloud")) {
			imageView.setImageResource(R.drawable.ic_action_cloud);
		} else if (s.equals("Good")) {
			imageView.setImageResource(R.drawable.ic_action_good);
		} else if (s.equals("Mic")) {
			imageView.setImageResource(R.drawable.ic_action_mic);
		} else {
			imageView.setImageResource(R.drawable.ic_action_play);
		}
 
		return rowView;
	}

}
