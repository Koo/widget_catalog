package com.memazou.android.widgets;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;

public class GalleryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gallery);

		Gallery g = (Gallery) findViewById(R.id.gallery);
		g.setAdapter(adapter);

	}

	private SpinnerAdapter adapter = new BaseAdapter() {

		private int[] images = new int[] { R.drawable.neko1, R.drawable.neko2, R.drawable.neko3, R.drawable.neko4 };

		@Override
		public int getCount() {
			return images.length;
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
            TypedArray a = obtainStyledAttributes(R.styleable.Gallery);
            int backgroundId = a.getResourceId(
                    R.styleable.Gallery_android_galleryItemBackground, 0);
            a.recycle();

			ImageView view = new ImageView(getApplicationContext());
			view.setImageResource(images[position]);
			view.setScaleType(ImageView.ScaleType.FIT_XY);
			view .setLayoutParams(new Gallery.LayoutParams(183, 123));
			view.setBackgroundResource(backgroundId);
			return view;
		}

	};
}
