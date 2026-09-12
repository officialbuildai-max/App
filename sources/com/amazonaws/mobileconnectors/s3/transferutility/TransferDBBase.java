package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

/* loaded from: classes2.dex */
class TransferDBBase {

    /* renamed from: f, reason: collision with root package name */
    private static final Log f18534f = LogFactory.b(TransferDBBase.class);

    /* renamed from: g, reason: collision with root package name */
    private static final Object f18535g = new Object();

    /* renamed from: a, reason: collision with root package name */
    private final Context f18536a;

    /* renamed from: b, reason: collision with root package name */
    private final Uri f18537b;

    /* renamed from: c, reason: collision with root package name */
    private final UriMatcher f18538c;

    /* renamed from: d, reason: collision with root package name */
    private final TransferDatabaseHelper f18539d;

    /* renamed from: e, reason: collision with root package name */
    private SQLiteDatabase f18540e;

    public TransferDBBase(Context context) {
        this.f18536a = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.f18539d = transferDatabaseHelper;
        this.f18540e = transferDatabaseHelper.getWritableDatabase();
        this.f18537b = Uri.parse("content://" + packageName + "/transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f18538c = uriMatcher;
        uriMatcher.addURI(packageName, "transfers", 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    private void c() {
        synchronized (f18535g) {
            try {
                if (!this.f18540e.isOpen()) {
                    this.f18540e = this.f18539d.getWritableDatabase();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public int a(Uri uri, ContentValues[] contentValuesArr) {
        int match = this.f18538c.match(uri);
        c();
        if (match != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        int i11 = 0;
        try {
            try {
                this.f18540e.beginTransaction();
                i11 = (int) this.f18540e.insertOrThrow("awstransfer", null, contentValuesArr[0]);
                for (int i12 = 1; i12 < contentValuesArr.length; i12++) {
                    contentValuesArr[i12].put("main_upload_id", Integer.valueOf(i11));
                    this.f18540e.insertOrThrow("awstransfer", null, contentValuesArr[i12]);
                }
                this.f18540e.setTransactionSuccessful();
            } catch (Exception e11) {
                f18534f.e("bulkInsert error : ", e11);
            }
            this.f18540e.endTransaction();
            return i11;
        } catch (Throwable th2) {
            this.f18540e.endTransaction();
            throw th2;
        }
    }

    public int b(Uri uri, String str, String[] strArr) {
        int match = this.f18538c.match(uri);
        c();
        if (match == 10) {
            return this.f18540e.delete("awstransfer", str, strArr);
        }
        if (match != 20) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        String lastPathSegment = uri.getLastPathSegment();
        if (TextUtils.isEmpty(str)) {
            return this.f18540e.delete("awstransfer", "_id=" + lastPathSegment, null);
        }
        return this.f18540e.delete("awstransfer", "_id=" + lastPathSegment + " and " + str, strArr);
    }

    public Uri d() {
        return this.f18537b;
    }

    public Uri e(Uri uri, ContentValues contentValues) {
        int match = this.f18538c.match(uri);
        c();
        if (match != 10) {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return Uri.parse("transfers/" + this.f18540e.insertOrThrow("awstransfer", null, contentValues));
    }

    public Cursor f(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("awstransfer");
        int match = this.f18538c.match(uri);
        if (match == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (match == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (match == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else {
            if (match != 40) {
                throw new IllegalArgumentException("Unknown URI: " + uri);
            }
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        }
        c();
        return sQLiteQueryBuilder.query(this.f18540e, strArr, str, strArr2, null, null, str2);
    }

    public synchronized int g(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int update;
        try {
            int match = this.f18538c.match(uri);
            c();
            if (match == 10) {
                update = this.f18540e.update("awstransfer", contentValues, str, strArr);
            } else {
                if (match != 20) {
                    throw new IllegalArgumentException("Unknown URI: " + uri);
                }
                String lastPathSegment = uri.getLastPathSegment();
                if (TextUtils.isEmpty(str)) {
                    update = this.f18540e.update("awstransfer", contentValues, "_id=" + lastPathSegment, null);
                } else {
                    update = this.f18540e.update("awstransfer", contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return update;
    }
}
