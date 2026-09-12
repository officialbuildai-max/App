package com.cloud.hisavana.abtestkit.db;

import a4.d;
import a4.e;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import android.util.Log;
import androidx.room.q;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.c;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import v6.m;
import v6.r;
import v6.s;
import v6.z;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0004J\u001c\u0010\u0018\u001a\u00020\u00192\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\b\u0010\u001d\u001a\u00020\u0019H\u0002JS\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010 \u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00142\b\u0010!\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\"J=\u0010#\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0012\u0010\u0013\u001a\u000e\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/cloud/hisavana/abtestkit/db/ABContentProvider;", "", "()V", "AB_PATH", "", "AB_SUCCESS", "", "LOCAL_AB_BY_VERSION_CODE_SUCCESS", "LOCAL_AB_PATH", "LOCAL_AB_SUCCESS", "authorities", "database", "Lcom/cloud/hisavana/abtestkit/db/ABRoomDatabase;", "uriMatcher", "Landroid/content/UriMatcher;", RequestParameters.SUBRESOURCE_DELETE, "uri", "Landroid/net/Uri;", "selection", "selectionArgs", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "getUri", "content", "initUriMatcher", "", "insert", "values", "Landroid/content/ContentValues;", "openDB", "query", "Landroid/database/Cursor;", "projection", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "abtestkit_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes3.dex */
public final class ABContentProvider {
    public static final String AB_PATH = "ab_data";
    public static final int AB_SUCCESS = 300;
    public static final ABContentProvider INSTANCE = new ABContentProvider();
    public static final int LOCAL_AB_BY_VERSION_CODE_SUCCESS = 500;
    public static final String LOCAL_AB_PATH = "local_ab_data";
    public static final int LOCAL_AB_SUCCESS = 400;
    private static String authorities;
    private static ABRoomDatabase database;
    private static UriMatcher uriMatcher;

    private ABContentProvider() {
    }

    @JvmStatic
    public static final int delete(Uri uri, String selection, String[] selectionArgs) {
        s h02;
        m g02;
        Intrinsics.h(uri, "uri");
        if (uriMatcher == null) {
            c.Log().d("ABTEST", "delete uriMatcher is null");
            return -1;
        }
        if (Log.isLoggable("ADSDK", 3)) {
            c Log = c.Log();
            StringBuilder sb2 = new StringBuilder("delete uri = ");
            sb2.append(uri);
            sb2.append(" and match result = ");
            UriMatcher uriMatcher2 = uriMatcher;
            sb2.append(uriMatcher2 != null ? Integer.valueOf(uriMatcher2.match(uri)) : null);
            Log.i("ABTEST", sb2.toString());
        }
        try {
            INSTANCE.openDB();
            if (database == null) {
                return -1;
            }
            UriMatcher uriMatcher3 = uriMatcher;
            Integer valueOf = uriMatcher3 != null ? Integer.valueOf(uriMatcher3.match(uri)) : null;
            if (valueOf != null && valueOf.intValue() == 300) {
                ABRoomDatabase aBRoomDatabase = database;
                if (aBRoomDatabase == null || (h02 = aBRoomDatabase.h0()) == null) {
                    return 0;
                }
                h02.a();
                return 0;
            }
            if (valueOf.intValue() == 400) {
                ABRoomDatabase aBRoomDatabase2 = database;
                if (aBRoomDatabase2 == null || (g02 = aBRoomDatabase2.g0()) == null) {
                    return 0;
                }
                g02.a();
                return 0;
            }
            c.Log().d("ABTEST", "delete uri is wrong");
            return -1;
        } catch (Exception e11) {
            c.Log().w("ABTEST", "delete fail, reason = " + e11.getMessage());
            return -1;
        }
    }

    @JvmStatic
    public static final void initUriMatcher(UriMatcher uriMatcher2, String authorities2) {
        uriMatcher = uriMatcher2;
        authorities = authorities2;
        if (uriMatcher2 != null) {
            uriMatcher2.addURI(authorities2, AB_PATH, 300);
        }
        if (uriMatcher2 != null) {
            uriMatcher2.addURI(authorities2, LOCAL_AB_PATH, 400);
        }
        if (uriMatcher2 != null) {
            uriMatcher2.addURI(authorities2, "local_ab_data/#", 500);
        }
    }

    @JvmStatic
    public static final Uri insert(Uri uri, ContentValues values) {
        String str;
        ABRoomDatabase aBRoomDatabase;
        s h02;
        m g02;
        m g03;
        Intrinsics.h(uri, "uri");
        if (uriMatcher == null || values == null) {
            c.Log().d("ABTEST", "insertOrUpdate uriMatcher or values is null");
            return INSTANCE.getUri("error/null_input");
        }
        if (Log.isLoggable("ADSDK", 3)) {
            c Log = c.Log();
            StringBuilder sb2 = new StringBuilder("insertOrUpdate uri = ");
            sb2.append(uri);
            sb2.append(" and match result = ");
            UriMatcher uriMatcher2 = uriMatcher;
            sb2.append(uriMatcher2 != null ? Integer.valueOf(uriMatcher2.match(uri)) : null);
            Log.i("ABTEST", sb2.toString());
        }
        try {
            ABContentProvider aBContentProvider = INSTANCE;
            aBContentProvider.openDB();
            if (database == null) {
                return null;
            }
            UriMatcher uriMatcher3 = uriMatcher;
            Integer valueOf = uriMatcher3 != null ? Integer.valueOf(uriMatcher3.match(uri)) : null;
            boolean z10 = false;
            if (valueOf != null && valueOf.intValue() == 300) {
                str = AB_PATH;
                String asString = values.getAsString("abData");
                if (asString != null && asString.length() != 0) {
                    z zVar = (z) GsonUtil.a(asString, z.class);
                    if (zVar != null && (aBRoomDatabase = database) != null && (h02 = aBRoomDatabase.h0()) != null) {
                        h02.a(zVar);
                    }
                    c.Log().i("ABTEST", "insertOrUpdate success");
                    z10 = true;
                }
                return aBContentProvider.getUri(str + '/' + z10);
            }
            if (valueOf.intValue() == 400) {
                str = LOCAL_AB_PATH;
                String asString2 = values.getAsString("localABData");
                if (asString2 != null && asString2.length() != 0) {
                    r rVar = (r) GsonUtil.a(asString2, r.class);
                    if (rVar != null) {
                        ABRoomDatabase aBRoomDatabase2 = database;
                        if (aBRoomDatabase2 != null && (g03 = aBRoomDatabase2.g0()) != null) {
                            g03.a();
                        }
                        ABRoomDatabase aBRoomDatabase3 = database;
                        if (aBRoomDatabase3 != null && (g02 = aBRoomDatabase3.g0()) != null) {
                            g02.a(rVar);
                        }
                    }
                    c.Log().i("ABTEST", "local AB insertOrUpdate success");
                    z10 = true;
                }
                return aBContentProvider.getUri(str + '/' + z10);
            }
            c.Log().d("ABTEST", "insertOrUpdate uri is wrong");
            return aBContentProvider.getUri("error/invalid_uri");
        } catch (Exception e11) {
            c.Log().w("ABTEST", "insertOrUpdate fail, reason = " + e11.getMessage());
            return INSTANCE.getUri("error/exception");
        }
    }

    private final void openDB() {
        e z10;
        d readableDatabase;
        if (database == null) {
            ABRoomDatabase aBRoomDatabase = ABRoomDatabase.f21396p;
            if (ABRoomDatabase.f21396p == null) {
                synchronized (ABRoomDatabase.class) {
                    try {
                        if (ABRoomDatabase.f21396p == null) {
                            try {
                                Context a11 = com.cloud.sdk.commonutil.util.e.a();
                                Intrinsics.g(a11, "getContext(...)");
                                ABRoomDatabase.f21396p = (ABRoomDatabase) q.a(a11, ABRoomDatabase.class, "hisavana_ab_data.db").g().e().d();
                                if (Log.isLoggable("ADSDK", 3)) {
                                    c Log = c.Log();
                                    StringBuilder sb2 = new StringBuilder("current database version is: ");
                                    ABRoomDatabase aBRoomDatabase2 = ABRoomDatabase.f21396p;
                                    sb2.append((aBRoomDatabase2 == null || (z10 = aBRoomDatabase2.z()) == null || (readableDatabase = z10.getReadableDatabase()) == null) ? null : Integer.valueOf(readableDatabase.getVersion()));
                                    Log.i("ABTEST", sb2.toString());
                                }
                            } catch (Exception e11) {
                                if (Log.isLoggable("ADSDK", 3)) {
                                    c.Log().w("ABTEST", "create room database failed: " + e11.getMessage());
                                }
                                com.cloud.sdk.commonutil.util.e.a().deleteDatabase("hisavana_ab_data.db");
                                ABRoomDatabase aBRoomDatabase3 = ABRoomDatabase.f21396p;
                                Context a12 = com.cloud.sdk.commonutil.util.e.a();
                                Intrinsics.g(a12, "getContext(...)");
                                ABRoomDatabase.f21396p = (ABRoomDatabase) q.a(a12, ABRoomDatabase.class, "hisavana_ab_data.db").g().e().d();
                            }
                        }
                        Unit unit = Unit.f67184a;
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            database = ABRoomDatabase.f21396p;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return null;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final android.database.Cursor query(android.net.Uri r1, java.lang.String[] r2, java.lang.String r3, java.lang.String[] r4, java.lang.String r5) {
        /*
            java.lang.String r2 = "uri"
            kotlin.jvm.internal.Intrinsics.h(r1, r2)
            android.content.UriMatcher r2 = com.cloud.hisavana.abtestkit.db.ABContentProvider.uriMatcher
            java.lang.String r3 = "ABTEST"
            r4 = 0
            if (r2 != 0) goto L16
            com.cloud.sdk.commonutil.util.c r1 = com.cloud.sdk.commonutil.util.c.Log()
            java.lang.String r2 = "query uriMatcher is null"
            r1.d(r3, r2)
            return r4
        L16:
            java.lang.String r2 = "ADSDK"
            r5 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r5)
            if (r2 == 0) goto L4a
            com.cloud.sdk.commonutil.util.c r2 = com.cloud.sdk.commonutil.util.c.Log()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "query uri = "
            r5.<init>(r0)
            r5.append(r1)
            java.lang.String r0 = " and match result = "
            r5.append(r0)
            android.content.UriMatcher r0 = com.cloud.hisavana.abtestkit.db.ABContentProvider.uriMatcher
            if (r0 == 0) goto L3f
            int r0 = r0.match(r1)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L40
        L3f:
            r0 = r4
        L40:
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r2.i(r3, r5)
        L4a:
            com.cloud.hisavana.abtestkit.db.ABContentProvider r2 = com.cloud.hisavana.abtestkit.db.ABContentProvider.INSTANCE     // Catch: java.lang.Exception -> L61
            r2.openDB()     // Catch: java.lang.Exception -> L61
            com.cloud.hisavana.abtestkit.db.ABRoomDatabase r2 = com.cloud.hisavana.abtestkit.db.ABContentProvider.database     // Catch: java.lang.Exception -> L61
            if (r2 != 0) goto L54
            return r4
        L54:
            android.content.UriMatcher r2 = com.cloud.hisavana.abtestkit.db.ABContentProvider.uriMatcher     // Catch: java.lang.Exception -> L61
            if (r2 == 0) goto L63
            int r2 = r2.match(r1)     // Catch: java.lang.Exception -> L61
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Exception -> L61
            goto L64
        L61:
            r1 = move-exception
            goto L9d
        L63:
            r2 = r4
        L64:
            if (r2 != 0) goto L67
            goto L7f
        L67:
            int r5 = r2.intValue()     // Catch: java.lang.Exception -> L61
            r0 = 300(0x12c, float:4.2E-43)
            if (r5 != r0) goto L7f
            com.cloud.hisavana.abtestkit.db.ABRoomDatabase r1 = com.cloud.hisavana.abtestkit.db.ABContentProvider.database     // Catch: java.lang.Exception -> L61
            if (r1 == 0) goto Lb6
            v6.s r1 = r1.h0()     // Catch: java.lang.Exception -> L61
            if (r1 == 0) goto Lb6
            android.database.Cursor r1 = r1.b()     // Catch: java.lang.Exception -> L61
        L7d:
            r4 = r1
            goto Lb6
        L7f:
            if (r2 != 0) goto L82
            goto Lb6
        L82:
            int r2 = r2.intValue()     // Catch: java.lang.Exception -> L61
            r5 = 500(0x1f4, float:7.0E-43)
            if (r2 != r5) goto Lb6
            long r1 = android.content.ContentUris.parseId(r1)     // Catch: java.lang.Exception -> L61
            com.cloud.hisavana.abtestkit.db.ABRoomDatabase r5 = com.cloud.hisavana.abtestkit.db.ABContentProvider.database     // Catch: java.lang.Exception -> L61
            if (r5 == 0) goto Lb6
            v6.m r5 = r5.g0()     // Catch: java.lang.Exception -> L61
            if (r5 == 0) goto Lb6
            android.database.Cursor r1 = r5.a(r1)     // Catch: java.lang.Exception -> L61
            goto L7d
        L9d:
            com.cloud.sdk.commonutil.util.c r2 = com.cloud.sdk.commonutil.util.c.Log()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r0 = "query db fail: "
            r5.<init>(r0)
            java.lang.String r1 = r1.getMessage()
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r2.w(r3, r1)
        Lb6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.abtestkit.db.ABContentProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    @JvmStatic
    public static final int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        s h02;
        m g02;
        Intrinsics.h(uri, "uri");
        int i11 = -1;
        if (uriMatcher == null || values == null) {
            c.Log().d("ABTEST", "uriMatcher or values is null");
            return -1;
        }
        if (Log.isLoggable("ADSDK", 3)) {
            c.Log().i("ABTEST", "update values = " + values);
        }
        try {
            INSTANCE.openDB();
            if (database == null) {
                return -1;
            }
            UriMatcher uriMatcher2 = uriMatcher;
            Integer valueOf = uriMatcher2 != null ? Integer.valueOf(uriMatcher2.match(uri)) : null;
            try {
                if (valueOf != null && valueOf.intValue() == 300) {
                    String asString = values.getAsString("abData");
                    if (asString != null && asString.length() != 0) {
                        z zVar = (z) GsonUtil.a(asString, z.class);
                        if (zVar != null) {
                            ABRoomDatabase aBRoomDatabase = database;
                            if (aBRoomDatabase != null && (h02 = aBRoomDatabase.h0()) != null) {
                                h02.b(zVar);
                            }
                            return 1;
                        }
                        return 0;
                    }
                    return -1;
                }
                if (valueOf.intValue() == 400) {
                    String asString2 = values.getAsString("localABData");
                    if (asString2 != null && asString2.length() != 0) {
                        r rVar = (r) GsonUtil.a(asString2, r.class);
                        if (rVar != null) {
                            ABRoomDatabase aBRoomDatabase2 = database;
                            if (aBRoomDatabase2 != null && (g02 = aBRoomDatabase2.g0()) != null) {
                                g02.b(rVar);
                            }
                            return 1;
                        }
                        return 0;
                    }
                    return -1;
                }
                c.Log().i("ABTEST", "update uri is wrong");
                return -1;
            } catch (Exception e11) {
                e = e11;
                i11 = 1;
                c.Log().w("ABTEST", "update fail, reason = " + e.getMessage());
                return i11;
            }
        } catch (Exception e12) {
            e = e12;
        }
    }

    public final Uri getUri(String content) {
        Intrinsics.h(content, "content");
        Uri parse = Uri.parse("content://" + authorities + '/' + content);
        Intrinsics.g(parse, "parse(this)");
        return parse;
    }
}
