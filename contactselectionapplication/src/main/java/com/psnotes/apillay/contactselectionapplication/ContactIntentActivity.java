package com.psnotes.apillay.contactselectionapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ContactIntentActivity extends MiBaseActivity {

    private int REQUEST_CODE = 0;
    private final int PHONE = 0;
    private final int WEBSITE = 1;
    private ListView intentListView;
    private ArrayAdapter<String> adapter;
    private List<ContactObjects> contactsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_intent);

        intentListView = (ListView)findViewById(R.id.listView1);

        contactsList = new ArrayList<ContactObjects>();
        contactsList.add(new ContactObjects("Android One", "111-1111-1111", "www.androidATC.com"));
        contactsList.add(new ContactObjects("Android Two", "222-2222-2222", "www.androidATC.com"));
        contactsList.add(new ContactObjects("Android Three", "333-3333-3333", "www.androidATC.com"));
        contactsList.add(new ContactObjects("Android Four", "444-4444-4444", "www.androidATC.com"));
        List<String> listName = new ArrayList<String>();
        for (ContactObjects co : contactsList ){
            listName.add(co.getName());
        }
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listName);
        intentListView.setAdapter(adapter);
        intentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ContactIntentActivity.this,ContactPageActivity.class);
                intent.putExtra(OBJETO_CONTACTO, contactsList.get(i));
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle resultado;
        String valor;
        if (data != null && REQUEST_CODE == requestCode) {
            resultado = data.getExtras();
            valor = resultado.getString(VALOR_CONTACTO);
            switch (resultCode) {
                case PHONE: {
                    startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + valor)));
                    break;
                }
                case WEBSITE: {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + valor)));
                    break;
                }
            }
        }
    }
}
