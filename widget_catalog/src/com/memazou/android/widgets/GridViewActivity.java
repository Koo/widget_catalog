package com.memazou.android.widgets;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewActivity extends Activity {

	private GridView gridView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.grid_view);
		
		gridView = (GridView) findViewById(R.id.gridView);
		gridView.setAdapter(adapter);
	}

	private BaseAdapter adapter = new BaseAdapter() {

		@Override
		public int getCount() {
			return IMAGE_IDS.length;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(getApplicationContext());
                imageView.setLayoutParams(new GridView.LayoutParams(60, 40));
                imageView.setAdjustViewBounds(false);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
			} else {
				imageView = (ImageView) convertView;
			}
			
			imageView.setImageResource(IMAGE_IDS[position]);
			return imageView;
		}
		
	};
	
	private int[] IMAGE_IDS = new int[]{
			R.drawable.neko1,
			R.drawable.neko2,
			R.drawable.neko3,
			R.drawable.neko4,
			R.drawable.neko1,
			R.drawable.neko2,
			R.drawable.neko3,
			R.drawable.neko4,
			R.drawable.neko1,
			R.drawable.neko2,
			R.drawable.neko3,
			R.drawable.neko4,
			R.drawable.neko1,
			R.drawable.neko2,
			R.drawable.neko3,
			R.drawable.neko4,
			R.drawable.neko1,
			R.drawable.neko2,
			R.drawable.neko3,
			R.drawable.neko4,
	};
}
