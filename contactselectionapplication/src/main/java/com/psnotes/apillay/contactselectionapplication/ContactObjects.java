package com.psnotes.apillay.contactselectionapplication;

import java.io.Serializable;

/**
 * Created by apillay on 2/15/2016.
 */
public class ContactObjects implements Serializable {
    private static final long SERIAL_VERSION_UID = 1L;
    private String name;
    private String phone;
    private String website;

    public ContactObjects(String name, String phone, String website) {
        this.name = name;
        this.phone = phone;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
