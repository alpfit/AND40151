package com.psnotes.apillay.contactselectionapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ContactPageActivity extends MiBaseActivity implements View.OnClickListener {

    private final int PHONE = 0;
    private final int WEBSITE = 1;
    private TextView contactName;
    private TextView contactPhone;
    private TextView contactWebsite;
    private ContactObjects contactObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);
        contactName = (TextView)findViewById(R.id.contactName);
        contactPhone = (TextView)findViewById(R.id.contactPhone);
        contactWebsite = (TextView)findViewById(R.id.contactWebsite);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            contactObject = (ContactObjects)getIntent().getSerializableExtra(OBJETO_CONTACTO);
            contactName.setText(contactObject.getName());
            contactPhone.setText("Phone : " + contactObject.getPhone());
            contactWebsite.setText(contactObject.getWebsite());

            contactPhone.setOnClickListener(this);
            contactWebsite.setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        boolean terminado = false;
        switch (view.getId()) {
            case R.id.contactPhone: {
                intent.putExtra(VALOR_CONTACTO,contactObject.getPhone());
                setResult(PHONE, intent);
                terminado = true;
                break;
            }
            case R.id.contactWebsite: {
                intent.putExtra(VALOR_CONTACTO, contactObject.getWebsite());
                setResult(WEBSITE, intent);
                terminado = true;
                break;
            }
        }
        if (terminado) {
            finish();
        }
    }
}
