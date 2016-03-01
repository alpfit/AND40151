package com.psnotes.apillay.simpletodolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
// Viewholder pattern for multiple view rows http://www.javacodegeeks.com/2013/09/android-viewholder-pattern-example.html
//https://sriramramani.wordpress.com/2012/07/25/infamous-viewholder-pattern/
public class DynamicListViewActivity extends AppCompatActivity {

    private EditText item;
    private Button add;
    private ListView dynamicListView;
    private ArrayList<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_list_view);

        item = (EditText)findViewById(R.id.itemEditText);
        add = (Button) findViewById(R.id.addItemButton);
        dynamicListView = (ListView)findViewById(R.id.itemslistView);
        list = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(DynamicListViewActivity.this,android.R.layout.simple_list_item_1, list);
        //list.add("Item 1");
        //list.add("Item 2");
        //list.add("Item 3");
        //adapter = new ArrayAdapter<String>(DynamicListViewActivity.this,R.layout.my_text_view, list);
        //adapter = new ArrayAdapter<String>(DynamicListViewActivity.this,R.layout.mi_lista_layout, list);
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
                DesplegarToast("Item " + itemParaBorrar +  " borrado");
                return true;
            }
        });
    }

    // crear un Toast personalizado para efecto de demo
    private void DesplegarToast(String mensaje) {
        Toast unToast;
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup grupoToast = (ViewGroup) findViewById(R.id.toastLayout);
        View miToast = inflater.inflate(R.layout.mi_toast_layout, grupoToast);
        TextView texto = (TextView) miToast.findViewById(R.id.toastTextView);
        texto.setText(mensaje);

        unToast = new Toast(getApplicationContext());
        unToast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        unToast.setDuration(Toast.LENGTH_LONG);
        unToast.setView(miToast);
        unToast.show();
    }

}
