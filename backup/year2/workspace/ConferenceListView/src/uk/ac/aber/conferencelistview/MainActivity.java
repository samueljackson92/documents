package uk.ac.aber.conferencelistview;

import android.os.Bundle;
import android.app.ListActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private static final String LOG_TAG = "ConferenceListView";
    static final String[] EVENTS = new String[] {"Event1", "Event2", "Event3", "Event4", "Event5", "Event6"
    	,"Event1", "Event2", "Event3", "Event4", "Event5", "Event6"};
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(LOG_TAG, "onCreate run");
        
        View header = getLayoutInflater().inflate(R.layout.header, null);
        
        ListView lv = getListView();
        
        lv.addHeaderView(header, null, false);
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, EVENTS);
        setListAdapter(adapter);
    }
	
	@Override
	protected void onListItemClick(ListView l, View view, int position, long id) {
		Toast.makeText(getApplicationContext(), ((TextView) view).getText(), Toast.LENGTH_SHORT).show();
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
