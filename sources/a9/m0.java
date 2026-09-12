package a9;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import b9.a;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.i;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import v8.a;

/* loaded from: classes3.dex */
public class m0 implements a9.d, b9.a, a9.c {

    /* renamed from: f, reason: collision with root package name */
    private static final r8.c f494f = r8.c.b("proto");

    /* renamed from: a, reason: collision with root package name */
    private final v0 f495a;

    /* renamed from: b, reason: collision with root package name */
    private final c9.a f496b;

    /* renamed from: c, reason: collision with root package name */
    private final c9.a f497c;

    /* renamed from: d, reason: collision with root package name */
    private final e f498d;

    /* renamed from: e, reason: collision with root package name */
    private final uz.a f499e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface b {
        Object apply(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        final String f500a;

        /* renamed from: b, reason: collision with root package name */
        final String f501b;

        private c(String str, String str2) {
            this.f500a = str;
            this.f501b = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public interface d {
        Object a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(c9.a aVar, c9.a aVar2, e eVar, v0 v0Var, uz.a aVar3) {
        this.f495a = v0Var;
        this.f496b = aVar;
        this.f497c = aVar2;
        this.f498d = eVar;
        this.f499e = aVar3;
    }

    private boolean C0() {
        return v0() * x0() >= this.f498d.f();
    }

    private List E0(List list, Map map) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            k kVar = (k) listIterator.next();
            if (map.containsKey(Long.valueOf(kVar.c()))) {
                i.a p11 = kVar.b().p();
                for (c cVar : (Set) map.get(Long.valueOf(kVar.c()))) {
                    p11.c(cVar.f500a, cVar.f501b);
                }
                listIterator.set(k.a(kVar.c(), kVar.d(), p11.d()));
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object F0(Cursor cursor) {
        while (cursor.moveToNext()) {
            i(cursor.getInt(0), LogEventDropped.Reason.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer G0(long j11, SQLiteDatabase sQLiteDatabase) {
        String[] strArr = {String.valueOf(j11)};
        m1(sQLiteDatabase.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new b() { // from class: a9.s
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object F0;
                F0 = m0.this.F0((Cursor) obj);
                return F0;
            }
        });
        return Integer.valueOf(sQLiteDatabase.delete("events", "timestamp_ms < ?", strArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object H0(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object I0(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ SQLiteDatabase J0(Throwable th2) {
        throw new SynchronizationException("Timed out while trying to open db.", th2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long K0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v8.e L0(long j11, Cursor cursor) {
        cursor.moveToNext();
        return v8.e.c().c(cursor.getLong(0)).b(j11).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ v8.e M0(final long j11, SQLiteDatabase sQLiteDatabase) {
        return (v8.e) m1(sQLiteDatabase.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new b() { // from class: a9.d0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                v8.e L0;
                L0 = m0.L0(j11, (Cursor) obj);
                return L0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long N0(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean O0(com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        Long z02 = z0(sQLiteDatabase, oVar);
        return z02 == null ? Boolean.FALSE : (Boolean) m1(r0().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{z02.toString()}), new b() { // from class: a9.u
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                return Boolean.valueOf(((Cursor) obj).moveToNext());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List P0(SQLiteDatabase sQLiteDatabase) {
        return (List) m1(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), new b() { // from class: a9.k0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                List Q0;
                Q0 = m0.Q0((Cursor) obj);
                return Q0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List Q0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(com.google.android.datatransport.runtime.o.a().b(cursor.getString(1)).d(d9.a.b(cursor.getInt(2))).c(g1(cursor.getString(3))).a());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List R0(com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        List e12 = e1(sQLiteDatabase, oVar, this.f498d.d());
        for (Priority priority : Priority.values()) {
            if (priority != oVar.d()) {
                int d11 = this.f498d.d() - e12.size();
                if (d11 <= 0) {
                    break;
                }
                e12.addAll(e1(sQLiteDatabase, oVar.f(priority), d11));
            }
        }
        return E0(e12, f1(sQLiteDatabase, e12));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ v8.a S0(Map map, a.C0974a c0974a, Cursor cursor) {
        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            LogEventDropped.Reason m02 = m0(cursor.getInt(1));
            long j11 = cursor.getLong(2);
            if (!map.containsKey(string)) {
                map.put(string, new ArrayList());
            }
            ((List) map.get(string)).add(LogEventDropped.c().c(m02).b(j11).a());
        }
        h1(c0974a, map);
        return c0974a.e(y0()).d(u0()).c((String) this.f499e.get()).b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ v8.a T0(String str, final Map map, final a.C0974a c0974a, SQLiteDatabase sQLiteDatabase) {
        return (v8.a) m1(sQLiteDatabase.rawQuery(str, new String[0]), new b() { // from class: a9.a0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                v8.a S0;
                S0 = m0.this.S0(map, c0974a, (Cursor) obj);
                return S0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object U0(List list, com.google.android.datatransport.runtime.o oVar, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j11 = cursor.getLong(0);
            boolean z10 = cursor.getInt(7) != 0;
            i.a o11 = com.google.android.datatransport.runtime.i.a().n(cursor.getString(1)).i(cursor.getLong(2)).o(cursor.getLong(3));
            if (z10) {
                o11.h(new com.google.android.datatransport.runtime.h(k1(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                o11.h(new com.google.android.datatransport.runtime.h(k1(cursor.getString(4)), i1(j11)));
            }
            if (!cursor.isNull(6)) {
                o11.g(Integer.valueOf(cursor.getInt(6)));
            }
            if (!cursor.isNull(8)) {
                o11.l(Integer.valueOf(cursor.getInt(8)));
            }
            if (!cursor.isNull(9)) {
                o11.m(cursor.getString(9));
            }
            if (!cursor.isNull(10)) {
                o11.j(cursor.getBlob(10));
            }
            if (!cursor.isNull(11)) {
                o11.k(cursor.getBlob(11));
            }
            list.add(k.a(j11, oVar, o11.d()));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object V0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j11 = cursor.getLong(0);
            Set set = (Set) map.get(Long.valueOf(j11));
            if (set == null) {
                set = new HashSet();
                map.put(Long.valueOf(j11), set);
            }
            set.add(new c(cursor.getString(1), cursor.getString(2)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Long W0(com.google.android.datatransport.runtime.i iVar, com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        if (C0()) {
            i(1L, LogEventDropped.Reason.CACHE_FULL, iVar.n());
            return -1L;
        }
        long p02 = p0(sQLiteDatabase, oVar);
        int e11 = this.f498d.e();
        byte[] a11 = iVar.e().a();
        boolean z10 = a11.length <= e11;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(p02));
        contentValues.put("transport_name", iVar.n());
        contentValues.put("timestamp_ms", Long.valueOf(iVar.f()));
        contentValues.put("uptime_ms", Long.valueOf(iVar.o()));
        contentValues.put("payload_encoding", iVar.e().b().a());
        contentValues.put("code", iVar.d());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z10));
        contentValues.put("payload", z10 ? a11 : new byte[0]);
        contentValues.put("product_id", iVar.l());
        contentValues.put("pseudonymous_id", iVar.m());
        contentValues.put("experiment_ids_clear_blob", iVar.g());
        contentValues.put("experiment_ids_encrypted_blob", iVar.h());
        long insert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z10) {
            int ceil = (int) Math.ceil(a11.length / e11);
            for (int i11 = 1; i11 <= ceil; i11++) {
                byte[] copyOfRange = Arrays.copyOfRange(a11, (i11 - 1) * e11, Math.min(i11 * e11, a11.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(insert));
                contentValues2.put("sequence_num", Integer.valueOf(i11));
                contentValues2.put("bytes", copyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry entry : iVar.k().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(insert));
            contentValues3.put("name", (String) entry.getKey());
            contentValues3.put(AppMeasurementSdk.ConditionalUserProperty.VALUE, (String) entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(insert);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ byte[] X0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            i11 += blob.length;
        }
        byte[] bArr = new byte[i11];
        int i12 = 0;
        for (int i13 = 0; i13 < arrayList.size(); i13++) {
            byte[] bArr2 = (byte[]) arrayList.get(i13);
            System.arraycopy(bArr2, 0, bArr, i12, bArr2.length);
            i12 += bArr2.length;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Y0(Cursor cursor) {
        while (cursor.moveToNext()) {
            i(cursor.getInt(0), LogEventDropped.Reason.MAX_RETRIES_REACHED, cursor.getString(1));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object Z0(String str, String str2, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        m1(sQLiteDatabase.rawQuery(str2, null), new b() { // from class: a9.v
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object Y0;
                Y0 = m0.this.Y0((Cursor) obj);
                return Y0;
            }
        });
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean a1(Cursor cursor) {
        return Boolean.valueOf(cursor.getCount() > 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object b1(String str, LogEventDropped.Reason reason, long j11, SQLiteDatabase sQLiteDatabase) {
        if (((Boolean) m1(sQLiteDatabase.rawQuery("SELECT 1 FROM log_event_dropped WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())}), new b() { // from class: a9.y
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Boolean a12;
                a12 = m0.a1((Cursor) obj);
                return a12;
            }
        })).booleanValue()) {
            sQLiteDatabase.execSQL("UPDATE log_event_dropped SET events_dropped_count = events_dropped_count + " + j11 + " WHERE log_source = ? AND reason = ?", new String[]{str, Integer.toString(reason.getNumber())});
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("log_source", str);
            contentValues.put("reason", Integer.valueOf(reason.getNumber()));
            contentValues.put("events_dropped_count", Long.valueOf(j11));
            sQLiteDatabase.insert("log_event_dropped", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object c1(long j11, com.google.android.datatransport.runtime.o oVar, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j11));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(d9.a.a(oVar.d()))}) < 1) {
            contentValues.put("backend_name", oVar.b());
            contentValues.put(TrackingKey.PRIORITY, Integer.valueOf(d9.a.a(oVar.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d1(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement("DELETE FROM log_event_dropped").execute();
        sQLiteDatabase.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + this.f496b.getTime()).execute();
        return null;
    }

    private List e1(SQLiteDatabase sQLiteDatabase, final com.google.android.datatransport.runtime.o oVar, int i11) {
        final ArrayList arrayList = new ArrayList();
        Long z02 = z0(sQLiteDatabase, oVar);
        if (z02 == null) {
            return arrayList;
        }
        m1(sQLiteDatabase.query("events", new String[]{"_id", "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", "payload", "code", "inline", "product_id", "pseudonymous_id", "experiment_ids_clear_blob", "experiment_ids_encrypted_blob"}, "context_id = ?", new String[]{z02.toString()}, null, null, null, String.valueOf(i11)), new b() { // from class: a9.x
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object U0;
                U0 = m0.this.U0(arrayList, oVar, (Cursor) obj);
                return U0;
            }
        });
        return arrayList;
    }

    private Map f1(SQLiteDatabase sQLiteDatabase, List list) {
        final HashMap hashMap = new HashMap();
        StringBuilder sb2 = new StringBuilder("event_id IN (");
        for (int i11 = 0; i11 < list.size(); i11++) {
            sb2.append(((k) list.get(i11)).c());
            if (i11 < list.size() - 1) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        m1(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", AppMeasurementSdk.ConditionalUserProperty.VALUE}, sb2.toString(), null, null, null, null), new b() { // from class: a9.z
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object V0;
                V0 = m0.V0(hashMap, (Cursor) obj);
                return V0;
            }
        });
        return hashMap;
    }

    private static byte[] g1(String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private void h1(a.C0974a c0974a, Map map) {
        for (Map.Entry entry : map.entrySet()) {
            c0974a.a(v8.c.c().c((String) entry.getKey()).b((List) entry.getValue()).a());
        }
    }

    private byte[] i1(long j11) {
        return (byte[]) m1(r0().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j11)}, null, null, "sequence_num"), new b() { // from class: a9.b0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                byte[] X0;
                X0 = m0.X0((Cursor) obj);
                return X0;
            }
        });
    }

    private Object j1(d dVar, b bVar) {
        long time = this.f497c.getTime();
        while (true) {
            try {
                return dVar.a();
            } catch (SQLiteDatabaseLockedException e11) {
                if (this.f497c.getTime() >= this.f498d.b() + time) {
                    return bVar.apply(e11);
                }
                SystemClock.sleep(50L);
            }
        }
    }

    private static r8.c k1(String str) {
        return str == null ? f494f : r8.c.b(str);
    }

    private static String l1(Iterable iterable) {
        StringBuilder sb2 = new StringBuilder("(");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            sb2.append(((k) it.next()).c());
            if (it.hasNext()) {
                sb2.append(',');
            }
        }
        sb2.append(')');
        return sb2.toString();
    }

    private LogEventDropped.Reason m0(int i11) {
        LogEventDropped.Reason reason = LogEventDropped.Reason.REASON_UNKNOWN;
        if (i11 == reason.getNumber()) {
            return reason;
        }
        LogEventDropped.Reason reason2 = LogEventDropped.Reason.MESSAGE_TOO_OLD;
        if (i11 == reason2.getNumber()) {
            return reason2;
        }
        LogEventDropped.Reason reason3 = LogEventDropped.Reason.CACHE_FULL;
        if (i11 == reason3.getNumber()) {
            return reason3;
        }
        LogEventDropped.Reason reason4 = LogEventDropped.Reason.PAYLOAD_TOO_BIG;
        if (i11 == reason4.getNumber()) {
            return reason4;
        }
        LogEventDropped.Reason reason5 = LogEventDropped.Reason.MAX_RETRIES_REACHED;
        if (i11 == reason5.getNumber()) {
            return reason5;
        }
        LogEventDropped.Reason reason6 = LogEventDropped.Reason.INVALID_PAYLOD;
        if (i11 == reason6.getNumber()) {
            return reason6;
        }
        LogEventDropped.Reason reason7 = LogEventDropped.Reason.SERVER_ERROR;
        if (i11 == reason7.getNumber()) {
            return reason7;
        }
        w8.a.b("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i11));
        return reason;
    }

    static Object m1(Cursor cursor, b bVar) {
        try {
            return bVar.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    private void o0(final SQLiteDatabase sQLiteDatabase) {
        j1(new d() { // from class: a9.l
            @Override // a9.m0.d
            public final Object a() {
                Object H0;
                H0 = m0.H0(sQLiteDatabase);
                return H0;
            }
        }, new b() { // from class: a9.w
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object I0;
                I0 = m0.I0((Throwable) obj);
                return I0;
            }
        });
    }

    private long p0(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.o oVar) {
        Long z02 = z0(sQLiteDatabase, oVar);
        if (z02 != null) {
            return z02.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", oVar.b());
        contentValues.put(TrackingKey.PRIORITY, Integer.valueOf(d9.a.a(oVar.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (oVar.c() != null) {
            contentValues.put("extras", Base64.encodeToString(oVar.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    private v8.b u0() {
        return v8.b.b().b(v8.d.c().b(q0()).c(e.f477a.f()).a()).a();
    }

    private long v0() {
        return r0().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    private long x0() {
        return r0().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    private v8.e y0() {
        final long time = this.f496b.getTime();
        return (v8.e) B0(new b() { // from class: a9.c0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                v8.e M0;
                M0 = m0.M0(time, (SQLiteDatabase) obj);
                return M0;
            }
        });
    }

    private Long z0(SQLiteDatabase sQLiteDatabase, com.google.android.datatransport.runtime.o oVar) {
        StringBuilder sb2 = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(oVar.b(), String.valueOf(d9.a.a(oVar.d()))));
        if (oVar.c() != null) {
            sb2.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(oVar.c(), 0));
        } else {
            sb2.append(" and extras is null");
        }
        return (Long) m1(sQLiteDatabase.query("transport_contexts", new String[]{"_id"}, sb2.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), new b() { // from class: a9.n
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Long N0;
                N0 = m0.N0((Cursor) obj);
                return N0;
            }
        });
    }

    @Override // a9.d
    public int B() {
        final long time = this.f496b.getTime() - this.f498d.c();
        return ((Integer) B0(new b() { // from class: a9.j0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Integer G0;
                G0 = m0.this.G0(time, (SQLiteDatabase) obj);
                return G0;
            }
        })).intValue();
    }

    Object B0(b bVar) {
        SQLiteDatabase r02 = r0();
        r02.beginTransaction();
        try {
            Object apply = bVar.apply(r02);
            r02.setTransactionSuccessful();
            return apply;
        } finally {
            r02.endTransaction();
        }
    }

    @Override // a9.d
    public void C(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            r0().compileStatement("DELETE FROM events WHERE _id in " + l1(iterable)).execute();
        }
    }

    @Override // a9.d
    public void G(final com.google.android.datatransport.runtime.o oVar, final long j11) {
        B0(new b() { // from class: a9.p
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object c12;
                c12 = m0.c1(j11, oVar, (SQLiteDatabase) obj);
                return c12;
            }
        });
    }

    @Override // a9.d
    public Iterable H() {
        return (Iterable) B0(new b() { // from class: a9.g0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                List P0;
                P0 = m0.P0((SQLiteDatabase) obj);
                return P0;
            }
        });
    }

    @Override // a9.d
    public long O(com.google.android.datatransport.runtime.o oVar) {
        return ((Long) m1(r0().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{oVar.b(), String.valueOf(d9.a.a(oVar.d()))}), new b() { // from class: a9.h0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Long K0;
                K0 = m0.K0((Cursor) obj);
                return K0;
            }
        })).longValue();
    }

    @Override // a9.d
    public boolean P(final com.google.android.datatransport.runtime.o oVar) {
        return ((Boolean) B0(new b() { // from class: a9.o
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Boolean O0;
                O0 = m0.this.O0(oVar, (SQLiteDatabase) obj);
                return O0;
            }
        })).booleanValue();
    }

    @Override // a9.d
    public void Q(Iterable iterable) {
        if (iterable.iterator().hasNext()) {
            final String str = "UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + l1(iterable);
            final String str2 = "SELECT COUNT(*), transport_name FROM events WHERE num_attempts >= 16 GROUP BY transport_name";
            B0(new b() { // from class: a9.l0
                @Override // a9.m0.b
                public final Object apply(Object obj) {
                    Object Z0;
                    Z0 = m0.this.Z0(str, str2, (SQLiteDatabase) obj);
                    return Z0;
                }
            });
        }
    }

    @Override // a9.d
    public Iterable X(final com.google.android.datatransport.runtime.o oVar) {
        return (Iterable) B0(new b() { // from class: a9.m
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                List R0;
                R0 = m0.this.R0(oVar, (SQLiteDatabase) obj);
                return R0;
            }
        });
    }

    @Override // b9.a
    public Object b(a.InterfaceC0150a interfaceC0150a) {
        SQLiteDatabase r02 = r0();
        o0(r02);
        try {
            Object execute = interfaceC0150a.execute();
            r02.setTransactionSuccessful();
            return execute;
        } finally {
            r02.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f495a.close();
    }

    @Override // a9.c
    public void d() {
        B0(new b() { // from class: a9.q
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object d12;
                d12 = m0.this.d1((SQLiteDatabase) obj);
                return d12;
            }
        });
    }

    @Override // a9.c
    public v8.a h() {
        final a.C0974a e11 = v8.a.e();
        final HashMap hashMap = new HashMap();
        final String str = "SELECT log_source, reason, events_dropped_count FROM log_event_dropped";
        return (v8.a) B0(new b() { // from class: a9.t
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                v8.a T0;
                T0 = m0.this.T0(str, hashMap, e11, (SQLiteDatabase) obj);
                return T0;
            }
        });
    }

    @Override // a9.c
    public void i(final long j11, final LogEventDropped.Reason reason, final String str) {
        B0(new b() { // from class: a9.r
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Object b12;
                b12 = m0.b1(str, reason, j11, (SQLiteDatabase) obj);
                return b12;
            }
        });
    }

    long q0() {
        return v0() * x0();
    }

    SQLiteDatabase r0() {
        final v0 v0Var = this.f495a;
        Objects.requireNonNull(v0Var);
        return (SQLiteDatabase) j1(new d() { // from class: a9.e0
            @Override // a9.m0.d
            public final Object a() {
                return v0.this.getWritableDatabase();
            }
        }, new b() { // from class: a9.f0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                SQLiteDatabase J0;
                J0 = m0.J0((Throwable) obj);
                return J0;
            }
        });
    }

    @Override // a9.d
    public k t0(final com.google.android.datatransport.runtime.o oVar, final com.google.android.datatransport.runtime.i iVar) {
        w8.a.c("SQLiteEventStore", "Storing event with priority=%s, name=%s for destination %s", oVar.d(), iVar.n(), oVar.b());
        long longValue = ((Long) B0(new b() { // from class: a9.i0
            @Override // a9.m0.b
            public final Object apply(Object obj) {
                Long W0;
                W0 = m0.this.W0(iVar, oVar, (SQLiteDatabase) obj);
                return W0;
            }
        })).longValue();
        if (longValue < 1) {
            return null;
        }
        return k.a(longValue, oVar, iVar);
    }
}
