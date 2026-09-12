package com.cloud.hisavana.sdk.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;
import androidx.room.RoomDatabase;
import androidx.room.q;
import com.cloud.hisavana.sdk.c2;
import com.cloud.hisavana.sdk.c6;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.f5;
import com.cloud.hisavana.sdk.m1;
import com.cloud.hisavana.sdk.v0;
import com.cloud.hisavana.sdk.v3;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.transsion.push.PushConstants;

/* loaded from: classes3.dex */
public abstract class HSRoomDatabase extends RoomDatabase {

    /* renamed from: p, reason: collision with root package name */
    private static volatile HSRoomDatabase f22463p;

    /* renamed from: q, reason: collision with root package name */
    private static final y3.c f22464q = new a(2, 3400);

    /* renamed from: r, reason: collision with root package name */
    private static final y3.c f22465r = new b(2600, 3400);

    /* renamed from: s, reason: collision with root package name */
    private static final y3.c f22466s = new c(2700, 3400);

    /* renamed from: t, reason: collision with root package name */
    private static final y3.c f22467t = new d(2900, 3400);

    /* renamed from: u, reason: collision with root package name */
    private static final y3.c f22468u = new e(2910, 3400);

    /* renamed from: v, reason: collision with root package name */
    private static final y3.c f22469v = new f(3070, 3400);

    /* renamed from: w, reason: collision with root package name */
    private static final y3.c f22470w = new g(3140, 3400);

    /* loaded from: classes3.dex */
    class a extends y3.c {
        a(int i11, int i12) {
            super(i11, i12);
        }

        @Override // y3.c
        public void a(a4.d dVar) {
            HSRoomDatabase.q0(dVar);
            HSRoomDatabase.B0(dVar);
            HSRoomDatabase.C0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    class b extends y3.c {
        b(int i11, int i12) {
            super(i11, i12);
        }

        @Override // y3.c
        public void a(a4.d dVar) {
            HSRoomDatabase.q0(dVar);
            HSRoomDatabase.B0(dVar);
            HSRoomDatabase.C0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    class c extends y3.c {
        c(int i11, int i12) {
            super(i11, i12);
        }

        @Override // y3.c
        public void a(a4.d dVar) {
            HSRoomDatabase.q0(dVar);
            HSRoomDatabase.B0(dVar);
            HSRoomDatabase.C0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    class d extends y3.c {
        d(int i11, int i12) {
            super(i11, i12);
        }

        @Override // y3.c
        public void a(a4.d dVar) {
            HSRoomDatabase.q0(dVar);
            HSRoomDatabase.C0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    class e extends y3.c {
        e(int i11, int i12) {
            super(i11, i12);
        }

        @Override // y3.c
        public void a(a4.d dVar) {
            HSRoomDatabase.q0(dVar);
            HSRoomDatabase.C0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    class f extends y3.c {
        f(int i11, int i12) {
            super(i11, i12);
        }

        @Override // y3.c
        public void a(a4.d dVar) {
            HSRoomDatabase.q0(dVar);
            HSRoomDatabase.C0(dVar);
        }
    }

    /* loaded from: classes3.dex */
    class g extends y3.c {
        g(int i11, int i12) {
            super(i11, i12);
        }

        @Override // y3.c
        public void a(a4.d dVar) {
            try {
                HSRoomDatabase.q0(dVar);
                HSRoomDatabase.m0(dVar, new String[]{"adList_room", "default_ad_room", "attr_impression_room", "attr_click_room", "cloudList_room", "retry_tracking_table_room"});
            } catch (Exception unused) {
            }
        }
    }

    private static void A0(a4.d dVar) {
        Cursor cursor = null;
        try {
            try {
                try {
                    dVar.A();
                    cursor = dVar.i0("SELECT * FROM retry_tracking_table");
                    while (cursor.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("uuid", cursor.getString(g0(cursor, "uuid")));
                        contentValues.put("create_time", Integer.valueOf(cursor.getInt(g0(cursor, "create_time"))));
                        contentValues.put("retry_times", Integer.valueOf(cursor.getInt(g0(cursor, "retry_times"))));
                        contentValues.put("tracking_data", cursor.getString(g0(cursor, "tracking_data")));
                        contentValues.put("md5", cursor.getString(g0(cursor, "md5")));
                        dVar.j0("retry_tracking_table_room", 5, contentValues);
                    }
                    cursor.close();
                    dVar.E("DROP TABLE IF EXISTS retry_tracking_table");
                } catch (Exception e11) {
                    e4.b().e("HSRoomDatabase", "migrateTable_retry_tracking_table failed:" + Log.getStackTraceString(e11));
                    if (cursor != null) {
                        cursor.close();
                    }
                    dVar.E("DROP TABLE IF EXISTS retry_tracking_table");
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                        dVar.I();
                        dVar.L();
                        throw th2;
                    }
                }
                dVar.E("DROP TABLE IF EXISTS retry_tracking_table");
                dVar.I();
                dVar.L();
                throw th2;
            }
        } catch (Exception unused2) {
        }
        dVar.I();
        dVar.L();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B0(a4.d dVar) {
        j7.a.e().s("requestConfigTime");
        j7.a.e().s("hisavanaCurrentCloudControlVersion");
        m0(dVar, new String[]{"adList_room", "default_ad_room", "attr_impression_room", "attr_click_room", "cloudList_room", "retry_tracking_table_room"});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C0(a4.d dVar) {
        m0(dVar, new String[]{"adList_room", "default_ad_room", "attr_impression_room", "attr_click_room", "cloudList_room", "retry_tracking_table_room"});
    }

    private static int g0(Cursor cursor, String str) {
        return Math.max(cursor.getColumnIndex(str), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0010. Please report as an issue. */
    public static void m0(a4.d dVar, String[] strArr) {
        for (String str : strArr) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1155598471:
                    if (str.equals("default_ad_room")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -678579453:
                    if (str.equals("attr_impression_room")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -300504803:
                    if (str.equals("retry_tracking_table_room")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -171726553:
                    if (str.equals("cloudList_room")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -139709376:
                    if (str.equals("attr_click_room")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 97732345:
                    if (str.equals("adList_room")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    z0(dVar);
                    break;
                case 1:
                    w0(dVar);
                    break;
                case 2:
                    A0(dVar);
                    break;
                case 3:
                    y0(dVar);
                    break;
                case 4:
                    u0(dVar);
                    break;
                case 5:
                    s0(dVar);
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q0(a4.d dVar) {
        dVar.E("CREATE TABLE IF NOT EXISTS cloudList_room(codeSeatId TEXT PRIMARY KEY NOT NULL, code_seat_bean TEXT);");
        dVar.E("CREATE TABLE IF NOT EXISTS adList_room(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,ad_creative_id TEXT, codeSeatId TEXT,file_path TEXT,price DOUBLE,is_offline_ad INTEGER,ad_request_ver INTEGER,ad_bean TEXT);");
        dVar.E("CREATE TABLE IF NOT EXISTS retry_tracking_table_room(uuid TEXT NOT NULL, create_time INTEGER,retry_times INTEGER,tracking_data TEXT,md5 TEXT,PRIMARY KEY (uuid))");
        dVar.E("CREATE TABLE IF NOT EXISTS default_ad_room(ad_creative_id TEXT NOT NULL,codeSeatId TEXT NOT NULL,ad_type INTEGER NOT NULL,price DOUBLE DEFAULT 0.0,ad_request_ver INTEGER NOT NULL DEFAULT 0,displayed_times INTEGER NOT NULL  DEFAULT 0,displayed_date TEXT,start_date TEXT,end_date TEXT,display_max_times INTEGER NOT NULL DEFAULT 0,file_path TEXT,default_country_white TEXT,default_country_black TEXT,default_brand_white TEXT,default_brand_black TEXT,ad_bean TEXT, PRIMARY KEY (ad_creative_id,codeSeatId));");
        dVar.E("CREATE TABLE IF NOT EXISTS attr_impression_room(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,pkg TEXT NOT NULL,imp_ts INTEGER NOT NULL DEFAULT 0,ad_creative_id TEXT NOT NULL);");
        dVar.E("CREATE TABLE IF NOT EXISTS attr_click_room(_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,ac_type INTEGER NOT NULL,pkg TEXT NOT NULL,dl_type TEXT NOT NULL,codeSeatId TEXT NOT NULL,click_ts INTEGER NOT NULL DEFAULT 0,ad_creative_id TEXT NOT NULL);");
    }

    private static HSRoomDatabase r0() {
        return (HSRoomDatabase) q.a(com.cloud.sdk.commonutil.util.e.a(), HSRoomDatabase.class, "hisavana.db").b(f22464q, f22465r, f22466s, f22467t, f22468u, f22469v, f22470w).g().e().d();
    }

    private static void s0(a4.d dVar) {
        Cursor cursor = null;
        try {
            try {
                try {
                    dVar.A();
                    cursor = dVar.i0("SELECT * FROM adList");
                    while (cursor.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_id", Integer.valueOf(cursor.getInt(g0(cursor, "_id"))));
                        contentValues.put(TrackingKey.IS_OFFLINE_AD, Integer.valueOf(cursor.getInt(g0(cursor, TrackingKey.IS_OFFLINE_AD))));
                        contentValues.put("ad_bean", cursor.getString(g0(cursor, "ad_bean")));
                        contentValues.put("codeSeatId", cursor.getString(g0(cursor, "codeSeatId")));
                        contentValues.put(BidResponsed.KEY_PRICE, Double.valueOf(cursor.getDouble(g0(cursor, BidResponsed.KEY_PRICE))));
                        contentValues.put("ad_creative_id", cursor.getString(g0(cursor, "ad_creative_id")));
                        contentValues.put("ad_request_ver", Integer.valueOf(cursor.getInt(g0(cursor, "ad_request_ver"))));
                        contentValues.put("file_path", cursor.getString(g0(cursor, "file_path")));
                        dVar.j0("adList_room", 5, contentValues);
                    }
                    cursor.close();
                    dVar.E("DROP TABLE IF EXISTS adList");
                } catch (Exception e11) {
                    e4.b().e("HSRoomDatabase", "migrateTable_adList failed:" + Log.getStackTraceString(e11));
                    if (cursor != null) {
                        cursor.close();
                    }
                    dVar.E("DROP TABLE IF EXISTS adList");
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                        dVar.I();
                        dVar.L();
                        throw th2;
                    }
                }
                dVar.E("DROP TABLE IF EXISTS adList");
                dVar.I();
                dVar.L();
                throw th2;
            }
        } catch (Exception unused2) {
        }
        dVar.I();
        dVar.L();
    }

    private static void u0(a4.d dVar) {
        Cursor cursor = null;
        try {
            try {
                try {
                    dVar.A();
                    cursor = dVar.i0("SELECT * FROM attr_click");
                    while (cursor.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_id", Integer.valueOf(cursor.getInt(g0(cursor, "_id"))));
                        contentValues.put("ac_type", Integer.valueOf(cursor.getInt(g0(cursor, "ac_type"))));
                        contentValues.put(PushConstants.PROVIDER_FIELD_PKG, cursor.getString(g0(cursor, PushConstants.PROVIDER_FIELD_PKG)));
                        contentValues.put("dl_type", cursor.getString(g0(cursor, "dl_type")));
                        contentValues.put("codeSeatId", cursor.getString(g0(cursor, "codeSeatId")));
                        contentValues.put(TrackingKey.CLICK_TS, Integer.valueOf(cursor.getInt(g0(cursor, TrackingKey.CLICK_TS))));
                        contentValues.put("ad_creative_id", cursor.getString(g0(cursor, "ad_creative_id")));
                        dVar.j0("attr_click_room", 5, contentValues);
                    }
                    cursor.close();
                    dVar.E("DROP TABLE IF EXISTS attr_click");
                } catch (Exception e11) {
                    e4.b().e("HSRoomDatabase", "migrateTable_attr_click failed:" + Log.getStackTraceString(e11));
                    if (cursor != null) {
                        cursor.close();
                    }
                    dVar.E("DROP TABLE IF EXISTS attr_click");
                }
            } catch (Throwable th2) {
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused) {
                        dVar.I();
                        dVar.L();
                        throw th2;
                    }
                }
                dVar.E("DROP TABLE IF EXISTS attr_click");
                dVar.I();
                dVar.L();
                throw th2;
            }
        } catch (Exception unused2) {
        }
        dVar.I();
        dVar.L();
    }

    public static HSRoomDatabase v0() {
        if (f22463p == null) {
            synchronized (HSRoomDatabase.class) {
                if (f22463p == null) {
                    try {
                        f22463p = r0();
                        if (a7.c.p()) {
                            e4.b().e("HSRoomDatabase", "current database version is:" + f22463p.z().getReadableDatabase().getVersion());
                        }
                    } catch (Exception e11) {
                        if (a7.c.p()) {
                            Toast.makeText(com.cloud.sdk.commonutil.util.e.a(), "create room database failed:" + Log.getStackTraceString(e11), 1).show();
                        }
                        com.cloud.sdk.commonutil.util.e.a().deleteDatabase("hisavana.db");
                        f22463p = r0();
                    }
                }
            }
        }
        return f22463p;
    }

    private static void w0(a4.d dVar) {
        Cursor cursor = null;
        try {
            try {
                try {
                    dVar.A();
                    cursor = dVar.i0("SELECT * FROM attr_impression");
                    while (cursor.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("_id", Integer.valueOf(cursor.getInt(g0(cursor, "_id"))));
                        contentValues.put(PushConstants.PROVIDER_FIELD_PKG, cursor.getString(g0(cursor, PushConstants.PROVIDER_FIELD_PKG)));
                        contentValues.put("imp_ts", Integer.valueOf(cursor.getInt(g0(cursor, "imp_ts"))));
                        contentValues.put("ad_creative_id", cursor.getString(g0(cursor, "ad_creative_id")));
                        dVar.j0("attr_impression_room", 5, contentValues);
                    }
                    cursor.close();
                    dVar.E("DROP TABLE IF EXISTS attr_impression");
                } catch (Exception e11) {
                    e4.b().e("HSRoomDatabase", "migrateTable_attr_impression failed:" + Log.getStackTraceString(e11));
                    if (cursor != null) {
                        cursor.close();
                    }
                    dVar.E("DROP TABLE IF EXISTS attr_impression");
                }
            } catch (Exception unused) {
            }
            dVar.I();
            dVar.L();
        } catch (Throwable th2) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                    dVar.I();
                    dVar.L();
                    throw th2;
                }
            }
            dVar.E("DROP TABLE IF EXISTS attr_impression");
            dVar.I();
            dVar.L();
            throw th2;
        }
    }

    private static void y0(a4.d dVar) {
        Cursor cursor = null;
        try {
            try {
                try {
                    dVar.A();
                    cursor = dVar.i0("SELECT * FROM cloudList");
                    while (cursor.moveToNext()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("codeSeatId", cursor.getString(g0(cursor, "codeSeatId")));
                        contentValues.put("code_seat_bean", cursor.getString(g0(cursor, "code_seat_bean")));
                        dVar.j0("cloudList_room", 5, contentValues);
                    }
                    cursor.close();
                    dVar.E("DROP TABLE IF EXISTS cloudList");
                } catch (Exception e11) {
                    e4.b().e("HSRoomDatabase", "migrateTable_cloudList failed:" + Log.getStackTraceString(e11));
                    if (cursor != null) {
                        cursor.close();
                    }
                    dVar.E("DROP TABLE IF EXISTS cloudList");
                }
            } catch (Exception unused) {
            }
            dVar.I();
            dVar.L();
        } catch (Throwable th2) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Exception unused2) {
                    dVar.I();
                    dVar.L();
                    throw th2;
                }
            }
            dVar.E("DROP TABLE IF EXISTS cloudList");
            dVar.I();
            dVar.L();
            throw th2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0185 A[Catch: Exception -> 0x018b, TRY_ENTER, TryCatch #0 {Exception -> 0x018b, blocks: (B:23:0x0185, B:24:0x0188, B:48:0x0141), top: B:2:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0195 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void z0(a4.d r23) {
        /*
            Method dump skipped, instructions count: 418
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.database.HSRoomDatabase.z0(a4.d):void");
    }

    public abstract v3 h0();

    public abstract f5 k0();

    public abstract c6 n0();

    public abstract v0 p0();

    public abstract c2 t0();

    public abstract m1 x0();
}
