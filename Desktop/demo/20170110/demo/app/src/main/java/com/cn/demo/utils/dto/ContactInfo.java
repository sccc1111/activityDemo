package com.cn.demo.utils.dto;

import java.util.List;

/**
 * Created by songbo on 2017-01-11.
 */
public class ContactInfo {
    private String contactId;
    private String contactName;
    private List<String> contactPhone;

    public String getContactId()
    {
        return contactId;
    }

    public String getContactName()
    {
        return contactName;
    }

    public List<String> getContactPhone()
    {
        return contactPhone;
    }

    public void setContactId(String id)
    {
        contactId = id;
    }

    public void setContactName(String name)
    {
        contactName = name;
    }

    public void setContactPhone(List<String> phone)
    {
        contactPhone = phone;
    }
}
