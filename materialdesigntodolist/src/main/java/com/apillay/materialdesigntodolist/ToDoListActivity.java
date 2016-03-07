package com.apillay.materialdesigntodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ToDoListActivity extends AppCompatActivity {
    private EditText item;
    private ImageButton add;
    private ListView dynamicListView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        item = (EditText)findViewById(R.id.itemEditText);
        add = (ImageButton) findViewById(R.id.add_item_button);
        dynamicListView = (ListView)findViewById(R.id.itemsListView);
        list = new ArrayList<String>();
        list.add("Android ATC");
        adapter = new ArrayAdapter<String>(ToDoListActivity.this,android.R.layout.simple_list_item_1, list);
        dynamicListView.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String todoItem = item.getText().toString();
                if (todoItem.length() > 0) {
                    list.add(todoItem);
                    adapter.notifyDataSetChanged();
                    item.setText("");
                }
            }
        });
        dynamicListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemParaBorrar = list.get(i).toString();
                list.remove(i);
                adapter.notifyDataSetChanged();
                Toast.makeText(ToDoListActivity.this, "Item " + itemParaBorrar + " borrado",Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        boolean retVal = true;
        if (id != R.id.action_settings) {
            retVal = super.onOptionsItemSelected(item);
        }
        return retVal;
    }
}
