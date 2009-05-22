package com.memazou.android.widgets;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class CatalogActivity extends ListActivity {
	private static final String[] COLUMN_NAMES = new String[] { "_id", "Title",
			"caption" };
	private static final String[] DISPLAY_COLUMN_NAMES = new String[] {
			"Title", "caption" };

	private MatrixCursor cursor;
	private List<Intent> activityIntents = new ArrayList<Intent>();

	private AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {

			Intent intent = activityIntents.get(position);
			try {
				startActivity(intent);
			} catch (ActivityNotFoundException e) {
				Toast.makeText(CatalogActivity.this, "activity [" + intent.toString() + "] not found", Toast.LENGTH_SHORT).show();
			}
		}

	};

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		cursor = new MatrixCursor(COLUMN_NAMES);
		CharSequence[] textArray = getResources().getTextArray(
				R.array.view_list);
		for (int i = 0; i < textArray.length / 2; i++) {
			String text1 = textArray[2 * i].toString();
			String text2 = textArray[2 * i + 1].toString();
			Intent intent = new Intent();
			intent.setClassName("com.memazou.android.widgets", "com.memazou.android.widgets." + textArray[2 * i] + "Activity");
			activityIntents.add(intent);
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