package com.mbridge.msdk.foundation.download.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.GlobalComponent;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.o0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class DatabaseHelper implements IDatabaseHelper {
    private volatile SQLiteDatabase database;
    private final IDatabaseOpenHelper databaseOpenHelper;
    private final Handler handler;
    private final String tableName = GlobalComponent.getInstance().getDatabaseTableName();

    public DatabaseHelper(Context context, Handler handler, IDatabaseOpenHelper iDatabaseOpenHelper) {
        this.handler = handler;
        this.databaseOpenHelper = iDatabaseOpenHelper;
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void clear() {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.9
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    return;
                }
                try {
                    if (DatabaseHelper.this.database.isOpen()) {
                        try {
                            DatabaseHelper.this.database.beginTransaction();
                            DatabaseHelper.this.database.delete(DatabaseHelper.this.tableName, null, null);
                            DatabaseHelper.this.database.setTransactionSuccessful();
                            try {
                                if (DatabaseHelper.this.database.inTransaction()) {
                                    DatabaseHelper.this.database.endTransaction();
                                }
                            } catch (Throwable th2) {
                                o0.b(IDatabaseHelper.TAG, th2.getMessage());
                            }
                        } catch (Exception e11) {
                            if (MBridgeConstans.DEBUG) {
                                e11.printStackTrace();
                            }
                            try {
                                if (DatabaseHelper.this.database.inTransaction()) {
                                    DatabaseHelper.this.database.endTransaction();
                                }
                            } catch (Throwable th3) {
                                o0.b(IDatabaseHelper.TAG, th3.getMessage());
                            }
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                        }
                    } catch (Throwable th5) {
                        o0.b(IDatabaseHelper.TAG, th5.getMessage());
                    }
                    throw th4;
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void find(final String str, final String str2, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v11, types: [boolean] */
            /* JADX WARN: Type inference failed for: r0v12, types: [android.database.Cursor] */
            /* JADX WARN: Type inference failed for: r0v14 */
            @Override // java.lang.Runnable
            public void run() {
                Cursor cursor;
                IDatabaseHelper.IDatabaseListener iDatabaseListener2;
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                DownloadModel downloadModel = null;
                if (!Objects.isNull(DatabaseHelper.this.database)) {
                    ?? isOpen = DatabaseHelper.this.database.isOpen();
                    try {
                        if (isOpen != 0) {
                            try {
                                cursor = DatabaseHelper.this.database.rawQuery("SELECT * FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = ? AND " + DownloadModel.DIRECTORY_PATH + " = ?", new String[]{str, str2});
                                if (cursor != null) {
                                    try {
                                        if (cursor.moveToFirst()) {
                                            downloadModel = DownloadModel.create(cursor);
                                        }
                                    } catch (Exception e11) {
                                        e = e11;
                                        if (MBridgeConstans.DEBUG) {
                                            e.printStackTrace();
                                        }
                                        if (cursor != null) {
                                            cursor.close();
                                        }
                                        iDatabaseListener2 = iDatabaseListener;
                                        if (iDatabaseListener2 == null) {
                                            return;
                                        }
                                        iDatabaseListener2.onDatabase(downloadModel);
                                        return;
                                    }
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                iDatabaseListener2 = iDatabaseListener;
                                if (iDatabaseListener2 == null) {
                                    return;
                                }
                            } catch (Exception e12) {
                                e = e12;
                                cursor = null;
                            } catch (Throwable th2) {
                                th = th2;
                                isOpen = 0;
                                if (isOpen != 0) {
                                    isOpen.close();
                                }
                                IDatabaseHelper.IDatabaseListener iDatabaseListener3 = iDatabaseListener;
                                if (iDatabaseListener3 != null) {
                                    iDatabaseListener3.onDatabase(null);
                                }
                                throw th;
                            }
                            iDatabaseListener2.onDatabase(downloadModel);
                            return;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (Objects.isNotNull(iDatabaseListener)) {
                    iDatabaseListener.onDatabase(null);
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public List<DownloadModel> findAll() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    cursor = rawQuery("SELECT * FROM " + this.tableName, null);
                    if (cursor != null) {
                        while (cursor.moveToNext()) {
                            arrayList.add(DownloadModel.create(cursor));
                        }
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                }
                return arrayList;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
                return arrayList;
            }
        } catch (Throwable unused) {
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void findByDownloadUrl(final String str, final IDatabaseHelper.IDatabaseListener iDatabaseListener) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.2
            /* JADX WARN: Removed duplicated region for block: B:36:0x00a0  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() {
                /*
                    r4 = this;
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r0)
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
                    if (r0 == 0) goto L19
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r1 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$100(r0)
                    android.database.sqlite.SQLiteDatabase r1 = r1.getWritableDatabase()
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$002(r0, r1)
                L19:
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r0)
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r0)
                    r1 = 0
                    if (r0 != 0) goto Lab
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this
                    android.database.sqlite.SQLiteDatabase r0 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r0)
                    boolean r0 = r0.isOpen()
                    if (r0 != 0) goto L34
                    goto Lab
                L34:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    r0.<init>()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String r2 = "SELECT * FROM "
                    r0.append(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$200(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    r0.append(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String r2 = " WHERE "
                    r0.append(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String r2 = "download_url"
                    r0.append(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String r2 = " = ?"
                    r0.append(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    com.mbridge.msdk.foundation.download.database.DatabaseHelper r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.this     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    android.database.sqlite.SQLiteDatabase r2 = com.mbridge.msdk.foundation.download.database.DatabaseHelper.access$000(r2)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String r3 = r3     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    java.lang.String[] r3 = new java.lang.String[]{r3}     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    android.database.Cursor r0 = r2.rawQuery(r0, r3)     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
                    if (r0 == 0) goto L7b
                    boolean r2 = r0.moveToFirst()     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                    if (r2 == 0) goto L7b
                    com.mbridge.msdk.foundation.download.database.DownloadModel r1 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r0)     // Catch: java.lang.Throwable -> L77 java.lang.Exception -> L79
                    goto L7b
                L77:
                    r2 = move-exception
                    goto L9e
                L79:
                    r2 = move-exception
                    goto L8a
                L7b:
                    if (r0 == 0) goto L80
                    r0.close()
                L80:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto L9d
                    goto L9a
                L85:
                    r2 = move-exception
                    r0 = r1
                    goto L9e
                L88:
                    r2 = move-exception
                    r0 = r1
                L8a:
                    boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L77
                    if (r3 == 0) goto L91
                    r2.printStackTrace()     // Catch: java.lang.Throwable -> L77
                L91:
                    if (r0 == 0) goto L96
                    r0.close()
                L96:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto L9d
                L9a:
                    r0.onDatabase(r1)
                L9d:
                    return
                L9e:
                    if (r0 == 0) goto La3
                    r0.close()
                La3:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    if (r0 == 0) goto Laa
                    r0.onDatabase(r1)
                Laa:
                    throw r2
                Lab:
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    boolean r0 = com.mbridge.msdk.foundation.download.utils.Objects.isNotNull(r0)
                    if (r0 == 0) goto Lb8
                    com.mbridge.msdk.foundation.download.database.IDatabaseHelper$IDatabaseListener r0 = r2
                    r0.onDatabase(r1)
                Lb8:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.AnonymousClass2.run():void");
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0067, code lost:
    
        if (r1.moveToFirst() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0069, code lost:
    
        r0.add(com.mbridge.msdk.foundation.download.database.DownloadModel.create(r1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        if (r1.moveToNext() != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0076, code lost:
    
        if (r1 != null) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0086, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0081, code lost:
    
        if (r1 != null) goto L28;
     */
    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.util.List<com.mbridge.msdk.foundation.download.database.DownloadModel> getUnwantedModels(long r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            if (r2 == 0) goto L1b
            com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper r2 = r5.databaseOpenHelper     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            android.database.sqlite.SQLiteDatabase r2 = r2.getWritableDatabase()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            r5.database = r2     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            goto L1b
        L17:
            r6 = move-exception
            goto L87
        L19:
            r6 = move-exception
            goto L7a
        L1b:
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            boolean r2 = com.mbridge.msdk.foundation.download.utils.Objects.isNull(r2)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            if (r2 != 0) goto L79
            android.database.sqlite.SQLiteDatabase r2 = r5.database     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            boolean r2 = r2.isOpen()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            if (r2 != 0) goto L2c
            goto L79
        L2c:
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            long r2 = r2 - r6
            android.database.sqlite.SQLiteDatabase r6 = r5.database     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            r7.<init>()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String r4 = "SELECT * FROM "
            r7.append(r4)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String r4 = r5.tableName     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            r7.append(r4)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String r4 = " WHERE "
            r7.append(r4)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String r4 = "last_modified_time"
            r7.append(r4)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String r4 = " <= ?"
            r7.append(r4)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            java.lang.String[] r2 = new java.lang.String[]{r2}     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            android.database.Cursor r1 = r6.rawQuery(r7, r2)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            if (r1 == 0) goto L76
            boolean r6 = r1.moveToFirst()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            if (r6 == 0) goto L76
        L69:
            com.mbridge.msdk.foundation.download.database.DownloadModel r6 = com.mbridge.msdk.foundation.download.database.DownloadModel.create(r1)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            r0.add(r6)     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            boolean r6 = r1.moveToNext()     // Catch: java.lang.Throwable -> L17 java.lang.Exception -> L19
            if (r6 != 0) goto L69
        L76:
            if (r1 == 0) goto L86
            goto L83
        L79:
            return r0
        L7a:
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Throwable -> L17
            if (r7 == 0) goto L81
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L17
        L81:
            if (r1 == 0) goto L86
        L83:
            r1.close()
        L86:
            return r0
        L87:
            if (r1 == 0) goto L8c
            r1.close()
        L8c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.database.DatabaseHelper.getUnwantedModels(long):java.util.List");
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void insert(final DownloadModel downloadModel) {
        this.handler.postAtFrontOfQueue(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.3
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    try {
                        DatabaseHelper.this.database.beginTransaction();
                        DatabaseHelper.this.database.insert(DatabaseHelper.this.tableName, null, DownloadModel.create(downloadModel));
                        DatabaseHelper.this.database.setTransactionSuccessful();
                        try {
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        } catch (Throwable th2) {
                            o0.b(IDatabaseHelper.TAG, th2.getMessage());
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                        try {
                            if (DatabaseHelper.this.database.inTransaction()) {
                                DatabaseHelper.this.database.endTransaction();
                            }
                        } catch (Throwable th3) {
                            o0.b(IDatabaseHelper.TAG, th3.getMessage());
                        }
                    }
                } catch (Throwable th4) {
                    try {
                        if (DatabaseHelper.this.database.inTransaction()) {
                            DatabaseHelper.this.database.endTransaction();
                        }
                    } catch (Throwable th5) {
                        o0.b(IDatabaseHelper.TAG, th5.getMessage());
                    }
                    throw th4;
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public Cursor rawQuery(String str, String[] strArr) {
        try {
            try {
                if (Objects.isNull(this.database)) {
                    this.database = this.databaseOpenHelper.getWritableDatabase();
                }
                if (!Objects.isNull(this.database) && this.database.isOpen()) {
                    this.database.beginTransaction();
                    Cursor rawQuery = this.database.rawQuery(str, strArr);
                    this.database.setTransactionSuccessful();
                    try {
                        if (this.database.inTransaction()) {
                            this.database.endTransaction();
                        }
                    } catch (Throwable th2) {
                        if (MBridgeConstans.DEBUG) {
                            th2.printStackTrace();
                        }
                    }
                    return rawQuery;
                }
                return null;
            } finally {
                try {
                    if (this.database.inTransaction()) {
                        this.database.endTransaction();
                    }
                } catch (Throwable th3) {
                    if (MBridgeConstans.DEBUG) {
                        th3.printStackTrace();
                    }
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
            try {
                if (this.database.inTransaction()) {
                    this.database.endTransaction();
                }
            } catch (Throwable th4) {
                if (MBridgeConstans.DEBUG) {
                    th4.printStackTrace();
                }
            }
            return null;
        }
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.7
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = ?", new Object[]{str});
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void remove(final String str, final String str2) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.6
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.execSQL("DELETE FROM " + DatabaseHelper.this.tableName + " WHERE " + DownloadModel.DOWNLOAD_ID + " = ? AND " + DownloadModel.DIRECTORY_PATH + " = ?", new Object[]{str, str2});
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void update(final DownloadModel downloadModel, final String str) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.4
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{downloadModel.getDownloadId(), str});
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateProgress(final String str, final String str2, final DownloadModel downloadModel) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.5
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, DownloadModel.create(downloadModel), "download_id = ? AND director_path = ?", new String[]{str, str2});
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }

    @Override // com.mbridge.msdk.foundation.download.database.IDatabaseHelper
    public void updateUnzipResource(final String str, String str2, long j11) {
        this.handler.post(new Runnable() { // from class: com.mbridge.msdk.foundation.download.database.DatabaseHelper.8
            @Override // java.lang.Runnable
            public void run() {
                if (Objects.isNull(DatabaseHelper.this.database)) {
                    DatabaseHelper databaseHelper = DatabaseHelper.this;
                    databaseHelper.database = databaseHelper.databaseOpenHelper.getWritableDatabase();
                }
                if (Objects.isNull(DatabaseHelper.this.database) || !DatabaseHelper.this.database.isOpen()) {
                    return;
                }
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put(DownloadModel.DOWNLOAD_ID, str);
                    DatabaseHelper.this.database.update(DatabaseHelper.this.tableName, contentValues, "download_id = ?", new String[]{str});
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                    }
                }
            }
        });
    }
}
