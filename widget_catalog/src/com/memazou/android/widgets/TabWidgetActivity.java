package com.memazou.android.widgets;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;

public class TabWidgetActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.tab_widget, tabHost.getTabContentView(), true);


//		tabHost.addTab(tabHost.newTabSpec("T01")
//						.setIndicator("Tab1", getResources().getDrawable(R.drawable.attention))
//						.setContent(new Intent(this, GridViewActivity.class)));
//		tabHost.addTab(tabHost.newTabSpec("T02")
//				.setIndicator("Tab2", getResources().getDrawable(R.drawable.blog))
//				.setContent(new Intent(this, GalleryActivity.class)));
//		tabHost.addTab(tabHost.newTabSpec("T03")
//				.setIndicator("Tab3", getResources().getDrawable(R.drawable.base))
//				.setContent(new Intent(this, AutoCompleteTextViewActivity.class)));

		tabHost.addTab(tabHost.newTabSpec("T01")
				.setIndicator("Tab1", getResources().getDrawable(R.drawable.attention))
				.setContent(R.id.tab01));
		tabHost.addTab(tabHost.newTabSpec("T02").setIndicator("Tab2",
				getResources().getDrawable(R.drawable.blog))
				.setContent(R.id.tab02));
				
		tabHost.addTab(tabHost.newTabSpec("T03").setIndicator("Tab3",
				getResources().getDrawable(R.drawable.base))
				.setContent(R.id.tab03));
}
}
