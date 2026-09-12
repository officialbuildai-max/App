package com.mbridge.msdk.foundation.db;

import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class a<T> {
    protected f mHelper;

    public a(f fVar) {
        this.mHelper = fVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized SQLiteDatabase getReadableDatabase() {
        try {
        } catch (Exception unused) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            o0.a("BaseDao", "getReadableDatabase error");
            return null;
        }
        return this.mHelper.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized SQLiteDatabase getWritableDatabase() {
        try {
        } catch (Exception unused) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            o0.a("BaseDao", "getWritableDatabase error");
            return null;
        }
        return this.mHelper.d();
    }
}
