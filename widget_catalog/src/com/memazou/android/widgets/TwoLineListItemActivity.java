package com.memazou.android.widgets;

import android.app.ListActivity;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class TwoLineListItemActivity extends ListActivity {
	private static final String[] COLUMN_NAMES = new String[] { "_id", "Title",
			"caption" };
	private static final String[] DISPLAY_COLUMN_NAMES = new String[] {
			"Title", "caption" };

	private MatrixCursor cursor;

	private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			String message = "select " + id + "'s item";
			Toast.makeText(TwoLineListItemActivity.this, message, Toast.LENGTH_LONG).show();
		}

	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.two_line_list_item);

		cursor = new MatrixCursor(COLUMN_NAMES);
		CharSequence[] titles = getResources().getTextArray(
				R.array.title_list);
		CharSequence[] values = getResources().getTextArray(
				R.array.value_list);
		for (int i = 0; i < titles.length; i++) {
			String text1 = titles[i].toString();
			String text2 = values[i].toString();
			cursor.addRow(new String[] { String.valueOf(i), text1, text2 });
		}

		ListAdapter adapter = new SimpleCursorAdapter(this,
				android.R.layout.simple_list_item_2, cursor,
				DISPLAY_COLUMN_NAMES, new int[] { android.R.id.text1,
						android.R.id.text2 });

		setListAdapter(adapter);
		getListView().setOnItemClickListener(listener);
	}

}