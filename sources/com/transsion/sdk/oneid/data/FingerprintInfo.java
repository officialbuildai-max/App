package com.transsion.sdk.oneid.data;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.transsion.sdk.oneid.b;
import java.io.Serializable;

/* loaded from: classes.dex */
public class FingerprintInfo extends OneBaseInfo implements Serializable {
    public String gsf;
    public String hdid;

    @SuppressLint({"HardwareIds", "MissingPermission"})
    public FingerprintInfo(Context context) {
        this.gsf = "";
        this.hdid = "";
        try {
            Cursor query = context.getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[]{"android_id"}, null);
            if (query == null || !query.moveToNext()) {
                this.gsf = "";
            } else {
                this.gsf = Long.toHexString(query.getLong(1));
            }
            if (query != null) {
                query.close();
            }
        } catch (Exception unused) {
        }
        this.hdid = b.a();
    }
}
