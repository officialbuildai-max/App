package com.facebook.biddingkit.logging;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: b, reason: collision with root package name */
    private static volatile f f24182b;

    /* renamed from: a, reason: collision with root package name */
    private final d f24183a;

    public f(Context context) {
        this.f24183a = new d(context, "EventLogsDatabase.db", null, 1);
    }

    public static void b(String str) {
        try {
            d().c().delete("EVENT_LOGS", "ID=?", new String[]{str});
        } catch (Throwable th2) {
            b.b("EventLogDatabaseAdapter", "Failed deleting entry", th2);
        }
    }

    public static f d() {
        return f24182b;
    }

    public static List e(int i11) {
        LinkedList linkedList = new LinkedList();
        try {
            Cursor query = d().c().query("EVENT_LOGS", null, null, null, null, null, null, null);
            int columnIndex = query.getColumnIndex("exception");
            int columnIndex2 = query.getColumnIndex("auction_id");
            int columnIndex3 = query.getColumnIndex("ID");
            int columnIndex4 = query.getColumnIndex("bidder_data");
            while (query.moveToNext() && i11 > 0) {
                e eVar = new e();
                eVar.e(query.getString(columnIndex));
                eVar.a(query.getString(columnIndex2));
                eVar.c(query.getString(columnIndex3));
                JSONObject jSONObject = new JSONObject(query.getString(columnIndex4));
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                    eVar.g(next, jSONObject2.optString("result"));
                    eVar.b(next, jSONObject2.optString("cpm_cents"));
                    eVar.d(next, jSONObject2.optString("error"));
                    eVar.f(next, jSONObject2.optString("latency_ms"));
                }
                linkedList.add(eVar);
                i11--;
            }
            query.close();
        } catch (Throwable th2) {
            b.b("EventLogDatabaseAdapter", "Failed getting rows", th2);
        }
        return linkedList;
    }

    public static void f(Context context) {
        if (f24182b == null) {
            synchronized (f.class) {
                try {
                    if (f24182b == null) {
                        f24182b = new f(context);
                    }
                } finally {
                }
            }
        }
    }

    public static void g(e eVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("auction_id", eVar.i());
            contentValues.put("exception", eVar.l());
            contentValues.put("bidder_data", eVar.h().toString());
            SQLiteDatabase c11 = d().c();
            c11.insert("EVENT_LOGS", null, contentValues);
            c11.close();
        } catch (Exception e11) {
            b.b("EventLogDatabaseAdapter", "Failed inserting an entry", e11);
        }
    }

    public void a() {
        SQLiteDatabase c11 = c();
        if (c11 != null) {
            c11.close();
        }
    }

    public SQLiteDatabase c() {
        try {
            return this.f24183a.getWritableDatabase();
        } catch (Throwable th2) {
            b.b("EventLogDatabaseAdapter", "Failed getting Writable Database", th2);
            return null;
        }
    }

    public void finalize() {
        a();
        super.finalize();
    }
}
