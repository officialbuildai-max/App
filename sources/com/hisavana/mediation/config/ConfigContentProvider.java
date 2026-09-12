package com.hisavana.mediation.config;

import android.content.ContentProvider;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;
import be.d;
import com.cloud.config.utils.XLogUtil;
import com.cloud.sdk.commonutil.util.e;
import com.hisavana.common.utils.AdLogUtil;

/* loaded from: classes.dex */
public class ConfigContentProvider extends ContentProvider {

    /* renamed from: a, reason: collision with root package name */
    public UriMatcher f33291a;

    /* renamed from: b, reason: collision with root package name */
    public String f33292b = "";

    /* renamed from: c, reason: collision with root package name */
    public SQLiteDatabase f33293c;

    public final UriMatcher a() {
        if (this.f33291a == null) {
            if (e.a() != null) {
                this.f33292b = e.a().getPackageName() + ".HisavanaConfigContentProvider";
                UriMatcher uriMatcher = new UriMatcher(-1);
                this.f33291a = uriMatcher;
                uriMatcher.addURI(this.f33292b, XLogUtil.TAG, 200);
            } else {
                AdLogUtil.Log().e("ssp", "HSCoreUtil is not init now");
            }
        }
        return this.f33291a;
    }

    public final Cursor b(String[] strArr) {
        String str;
        if (strArr != null) {
            try {
                if (strArr.length != 0) {
                    StringBuilder sb2 = new StringBuilder("(");
                    for (int i11 = 0; i11 < strArr.length; i11++) {
                        AdLogUtil.Log().d("ConfigContentProvider", "getCursorForProvider ***** " + strArr[i11]);
                        if (i11 == strArr.length - 1) {
                            sb2.append("'");
                            sb2.append(strArr[i11]);
                            sb2.append("'");
                        } else {
                            sb2.append("'");
                            sb2.append(strArr[i11]);
                            sb2.append("',");
                        }
                    }
                    sb2.append(")");
                    str = "select * from cloudList where codeSeatId IN " + sb2.toString();
                    c();
                    AdLogUtil.Log().d("ConfigContentProvider", "getCursorForProvider sql " + str);
                    return this.f33293c.rawQuery(str, null);
                }
            } catch (Exception e11) {
                AdLogUtil.Log().e("ConfigContentProvider", "getCursorForProvider e " + Log.getStackTraceString(e11));
                return null;
            }
        }
        str = "select * from cloudList";
        c();
        AdLogUtil.Log().d("ConfigContentProvider", "getCursorForProvider sql " + str);
        return this.f33293c.rawQuery(str, null);
    }

    public final synchronized SQLiteDatabase c() {
        SQLiteDatabase sQLiteDatabase = this.f33293c;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            try {
                this.f33293c = new d(e.a()).getWritableDatabase();
            } catch (Exception e11) {
                AdLogUtil.Log().e("ConfigContentProvider", "openDB ex " + Log.getStackTraceString(e11));
            }
        }
        return this.f33293c;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        if (a() == null || this.f33291a.match(uri) != 200) {
            return 0;
        }
        c();
        AdLogUtil.Log().d("ConfigContentProvider", "delete ");
        try {
            return this.f33293c.delete("cloudList", str, strArr);
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigContentProvider", "delete Exception:" + Log.getStackTraceString(e11));
            return 0;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ea, code lost:
    
        if (r11 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x010d, code lost:
    
        r11.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x010b, code lost:
    
        if (r11 == null) goto L46;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.net.Uri insert(android.net.Uri r11, android.content.ContentValues r12) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisavana.mediation.config.ConfigContentProvider.insert(android.net.Uri, android.content.ContentValues):android.net.Uri");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        try {
            AdLogUtil.Log().d("ConfigContentProvider", "query " + uri);
            if (a() != null && this.f33291a.match(uri) == 200) {
                AdLogUtil.Log().d("ConfigContentProvider", "query ");
                return b(strArr);
            }
        } catch (Exception e11) {
            AdLogUtil.Log().e("ConfigContentProvider", "query error: " + Log.getStackTraceString(e11));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c2, code lost:
    
        if (r5 != null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00e5, code lost:
    
        r5.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00e3, code lost:
    
        if (r5 == null) goto L42;
     */
    @Override // android.content.ContentProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int update(android.net.Uri r5, android.content.ContentValues r6, java.lang.String r7, java.lang.String[] r8) {
        /*
            r4 = this;
            java.lang.String r7 = "ConfigContentProvider"
            android.content.UriMatcher r8 = r4.a()
            r0 = 0
            if (r8 != 0) goto La
            return r0
        La:
            android.content.UriMatcher r8 = r4.f33291a
            int r5 = r8.match(r5)
            r8 = 200(0xc8, float:2.8E-43)
            if (r5 != r8) goto Lf1
            if (r6 == 0) goto Lf1
            java.util.Set r5 = r6.keySet()
            if (r5 == 0) goto Lf1
            java.util.Set r5 = r6.keySet()
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L28
            goto Lf1
        L28:
            r4.c()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            android.database.sqlite.SQLiteDatabase r5 = r4.f33293c     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            if (r5 != 0) goto L35
            if (r5 == 0) goto L34
            r5.endTransaction()
        L34:
            return r0
        L35:
            java.util.Set r5 = r6.keySet()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            com.hisavana.common.utils.AdLogUtil r8 = com.hisavana.common.utils.AdLogUtil.Log()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r1.<init>()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r2 = "update id "
            r1.append(r2)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r1.append(r5)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r8.d(r7, r1)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.util.ArrayList r8 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r8.<init>()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
        L5a:
            boolean r1 = r5.hasNext()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            if (r1 == 0) goto L7c
            java.lang.Object r1 = r5.next()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.Object r1 = r6.get(r1)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.Class<com.hisavana.mediation.bean.CloudControlConfig$CodeSeat> r2 = com.hisavana.mediation.bean.CloudControlConfig.CodeSeat.class
            java.lang.Object r1 = com.cloud.sdk.commonutil.gsonutil.GsonUtil.a(r1, r2)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            com.hisavana.mediation.bean.CloudControlConfig$CodeSeat r1 = (com.hisavana.mediation.bean.CloudControlConfig.CodeSeat) r1     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r8.add(r1)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            goto L5a
        L78:
            r5 = move-exception
            goto Le9
        L7a:
            r5 = move-exception
            goto Lc5
        L7c:
            android.database.sqlite.SQLiteDatabase r5 = r4.f33293c     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r5.beginTransaction()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.util.Iterator r5 = r8.iterator()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
        L85:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            if (r6 == 0) goto Lbb
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            com.hisavana.mediation.bean.CloudControlConfig$CodeSeat r6 = (com.hisavana.mediation.bean.CloudControlConfig.CodeSeat) r6     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r8 = com.cloud.sdk.commonutil.gsonutil.GsonUtil.d(r6)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            android.content.ContentValues r1 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r1.<init>()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r2 = "codeSeatId"
            java.lang.String r3 = r6.getCodeSeatId()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r1.put(r2, r3)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r2 = "json"
            r1.put(r2, r8)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r6 = r6.getCodeSeatId()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String[] r6 = new java.lang.String[]{r6}     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            android.database.sqlite.SQLiteDatabase r8 = r4.f33293c     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            java.lang.String r2 = "cloudList"
            java.lang.String r3 = "codeSeatId=?"
            int r0 = r8.update(r2, r1, r3, r6)     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            goto L85
        Lbb:
            android.database.sqlite.SQLiteDatabase r5 = r4.f33293c     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            r5.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L78 java.lang.Exception -> L7a
            android.database.sqlite.SQLiteDatabase r5 = r4.f33293c
            if (r5 == 0) goto Lf1
            goto Le5
        Lc5:
            com.hisavana.common.utils.AdLogUtil r6 = com.hisavana.common.utils.AdLogUtil.Log()     // Catch: java.lang.Throwable -> L78
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L78
            r8.<init>()     // Catch: java.lang.Throwable -> L78
            java.lang.String r1 = "update e "
            r8.append(r1)     // Catch: java.lang.Throwable -> L78
            java.lang.String r5 = android.util.Log.getStackTraceString(r5)     // Catch: java.lang.Throwable -> L78
            r8.append(r5)     // Catch: java.lang.Throwable -> L78
            java.lang.String r5 = r8.toString()     // Catch: java.lang.Throwable -> L78
            r6.e(r7, r5)     // Catch: java.lang.Throwable -> L78
            android.database.sqlite.SQLiteDatabase r5 = r4.f33293c
            if (r5 == 0) goto Lf1
        Le5:
            r5.endTransaction()
            goto Lf1
        Le9:
            android.database.sqlite.SQLiteDatabase r6 = r4.f33293c
            if (r6 == 0) goto Lf0
            r6.endTransaction()
        Lf0:
            throw r5
        Lf1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisavana.mediation.config.ConfigContentProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
