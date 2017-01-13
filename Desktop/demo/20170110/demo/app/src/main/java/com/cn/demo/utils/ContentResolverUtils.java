package com.cn.demo.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;

import com.cn.demo.utils.dto.ContactInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songbo on 2017-01-11.
 * 读取联系人工具类
 */
public class ContentResolverUtils {
    private static final Uri contactsUri = ContactsContract.Contacts.CONTENT_URI;// 联系人的Uri对象
    private static final Uri phoneUri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI;// 获取联系人电话的Uri
    private static final Uri emailUri = ContactsContract.CommonDataKinds.Email.CONTENT_URI;// 获取联系人邮箱的Uri
    /**
     * 读取联系人及电话号码
     */
    public static List<ContactInfo> getContactInfoList(Context context){

        List<ContactInfo> list = new ArrayList<>();

        //取得ContentResolver
        ContentResolver resolver = context.getContentResolver();

        Cursor cursor = resolver.query(contactsUri,null,null,null,null);

        while (cursor.moveToNext()){
            ContactInfo contactInfo = new ContactInfo();
            String contactid = cursor.getString(cursor
                    .getColumnIndex(ContactsContract.Contacts._ID));

            String contactName = cursor.getString(cursor
                    .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            //取得电话
            Cursor phoneCusor=resolver.query(phoneUri, null,
                    ContactsContract.CommonDataKinds.Phone.RAW_CONTACT_ID+"=?",
                    new String[]{contactid}, null);
            List<String> phones = new ArrayList<>();
            while (phoneCusor.moveToNext()){
                String phone = phoneCusor.getString(phoneCusor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                phones.add(phone);
            }
            contactInfo.setContactId(contactid);
            contactInfo.setContactName(contactName);
            contactInfo.setContactPhone(phones);
            list.add(contactInfo);
        }
        return list;
    }
}
