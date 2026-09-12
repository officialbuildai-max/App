package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* loaded from: classes2.dex */
class TransferDatabaseHelper extends SQLiteOpenHelper {

    /* renamed from: a, reason: collision with root package name */
    private final Context f18545a;

    /* renamed from: b, reason: collision with root package name */
    private int f18546b;

    public TransferDatabaseHelper(Context context) {
        this(context, 6);
    }

    public TransferDatabaseHelper(Context context, int i11) {
        super(context, "awss3transfertable.db", (SQLiteDatabase.CursorFactory) null, i11);
        this.f18545a = context;
        this.f18546b = i11;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        TransferTable.f(sQLiteDatabase, this.f18546b);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        this.f18545a.deleteDatabase("awss3transfertable.db");
        onCreate(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i11, int i12) {
        TransferTable.g(sQLiteDatabase, i11, i12);
    }
}
