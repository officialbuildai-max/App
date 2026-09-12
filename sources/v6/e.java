package v6;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.cloud.hisavana.abtestkit.OnInitCompleteListener;
import com.cloud.hisavana.abtestkit.bean.OnlineABLayerDTO;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ClientABTestDTOKt;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.hisavana.common.tracking.TrackingKey;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f77178a = new AtomicBoolean(false);

    public static void a() {
        HSScopeHelper.f23249a.g(new Runnable() { // from class: v6.a
            @Override // java.lang.Runnable
            public final void run() {
                e.f();
            }
        });
    }

    public static void b(final long j11) {
        final long currentTimeMillis = System.currentTimeMillis();
        if (l.f77188a.contains(Long.valueOf(j11))) {
            OnlineABLayerDTO onlineABLayerDTO = (OnlineABLayerDTO) l.f77188a.get(Long.valueOf(j11));
            if (onlineABLayerDTO != null) {
                onlineABLayerDTO.setRequestTime(currentTimeMillis);
            }
        } else {
            OnlineABLayerDTO onlineABLayerDTO2 = new OnlineABLayerDTO(null, 1, null);
            onlineABLayerDTO2.setLayerId(j11);
            onlineABLayerDTO2.setRequestTime(currentTimeMillis);
            l.f77188a.put(Long.valueOf(j11), onlineABLayerDTO2);
        }
        if (Log.isLoggable("ADSDK", 3)) {
            com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "ABMemoryCache upsertRequestTimeToMemoryCache onlineLayerMap = " + l.f77188a);
        }
        HSScopeHelper.f23249a.g(new Runnable() { // from class: v6.d
            @Override // java.lang.Runnable
            public final void run() {
                e.c(j11, currentTimeMillis);
            }
        });
    }

    public static final void c(long j11, long j12) {
        Uri uri = com.cloud.hisavana.abtestkit.d.f21394a;
        try {
            ContentResolver contentResolver = com.cloud.sdk.commonutil.util.e.a().getContentResolver();
            z zVar = new z(0L, 0L, null, 7, null);
            zVar.setLayerId(j11);
            zVar.setRequestTime(j12);
            ContentValues contentValues = new ContentValues();
            contentValues.put("abData", GsonUtil.d(zVar));
            contentResolver.update(com.cloud.hisavana.abtestkit.d.f21394a, contentValues, null, null);
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache upsertRequestTimeToDiskCache fail, reason = " + e11.getMessage());
            Unit unit = Unit.f67184a;
        }
    }

    public static void d(OnInitCompleteListener onInitCompleteListener) {
        Uri uri = com.cloud.hisavana.abtestkit.d.f21394a;
        ConcurrentHashMap map = new ConcurrentHashMap();
        ConcurrentHashMap concurrentHashMap = null;
        try {
            Cursor query = com.cloud.sdk.commonutil.util.e.a().getContentResolver().query(com.cloud.hisavana.abtestkit.d.f21394a, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex(ClientABTestDTOKt.LAYER_ID);
                        int columnIndex2 = query.getColumnIndex(TrackingKey.REQUEST_TIME);
                        int columnIndex3 = query.getColumnIndex("ab_info");
                        do {
                            Intrinsics.h(query, "<this>");
                            Long valueOf = columnIndex >= 0 ? Long.valueOf(query.getLong(columnIndex)) : null;
                            if (valueOf != null) {
                                OnlineABLayerDTO onlineABLayerDTO = new OnlineABLayerDTO(null, 1, null);
                                onlineABLayerDTO.setLayerId(valueOf.longValue());
                                Intrinsics.h(query, "<this>");
                                Long valueOf2 = columnIndex2 >= 0 ? Long.valueOf(query.getLong(columnIndex2)) : null;
                                onlineABLayerDTO.setRequestTime(valueOf2 != null ? valueOf2.longValue() : 0L);
                                Intrinsics.h(query, "<this>");
                                String string = columnIndex3 >= 0 ? query.getString(columnIndex3) : null;
                                if (string != null) {
                                    onlineABLayerDTO.setInfo(string);
                                    onlineABLayerDTO.setAbLayerInfo(onlineABLayerDTO.convertLayerInfo(string));
                                }
                                map.put(valueOf, onlineABLayerDTO);
                            }
                        } while (query.moveToNext());
                        com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "ABDiskCache queryAllFromDiskCache success, onlineLayerMap size = " + map.size());
                    }
                    Unit unit = Unit.f67184a;
                    CloseableKt.a(query, null);
                } finally {
                }
            }
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache queryAllFromDiskCache fail, reason = " + e11.getMessage());
        }
        ConcurrentHashMap concurrentHashMap2 = l.f77188a;
        Intrinsics.h(map, "map");
        l.f77188a.clear();
        l.f77188a = map;
        Uri uri2 = com.cloud.hisavana.abtestkit.d.f21394a;
        try {
            int f11 = j7.a.e().f("key_local_ab_data_version_code");
            if (f11 != i7.c.m()) {
                concurrentHashMap = com.cloud.hisavana.abtestkit.d.b();
            } else {
                String j11 = j7.a.e().n() ? j7.a.e().j("key_local_ab_data_json") : com.cloud.hisavana.abtestkit.d.a(Long.valueOf(f11));
                if (j11 != null && j11.length() != 0) {
                    ConcurrentHashMap concurrentHashMap3 = (ConcurrentHashMap) GsonUtil.b(j11, new com.cloud.hisavana.abtestkit.c().getType());
                    com.cloud.sdk.commonutil.util.c Log = com.cloud.sdk.commonutil.util.c.Log();
                    StringBuilder sb2 = new StringBuilder("ABDiskCache queryFromAssets from localABDataJson, localLayerMap size = ");
                    sb2.append(concurrentHashMap3 != null ? Integer.valueOf(concurrentHashMap3.size()) : null);
                    Log.d("ABTEST", sb2.toString());
                    concurrentHashMap = concurrentHashMap3;
                }
            }
        } catch (Exception e12) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache queryFromAssets fail, reason = " + e12.getMessage());
        }
        ConcurrentHashMap concurrentHashMap4 = l.f77189b;
        if (concurrentHashMap4 != null) {
            concurrentHashMap4.clear();
        }
        l.f77189b = concurrentHashMap;
        if (onInitCompleteListener != null) {
            onInitCompleteListener.onInitComplete();
        }
    }

    public static void e(final OnlineABLayerDTO onlineABLayerDTO) {
        ConcurrentHashMap concurrentHashMap = l.f77188a;
        HSScopeHelper.f23249a.g(new Runnable() { // from class: v6.c
            @Override // java.lang.Runnable
            public final void run() {
                e.h(OnlineABLayerDTO.this);
            }
        });
    }

    public static final void f() {
        Uri uri = com.cloud.hisavana.abtestkit.d.f21394a;
        try {
            com.cloud.sdk.commonutil.util.e.a().getContentResolver().delete(com.cloud.hisavana.abtestkit.d.f21394a, null, null);
            com.cloud.sdk.commonutil.util.e.a().getContentResolver().delete(com.cloud.hisavana.abtestkit.d.f21395b, null, null);
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache deleteTable fail, reason = " + e11.getMessage());
        }
    }

    public static void g(final OnInitCompleteListener onInitCompleteListener) {
        AtomicBoolean atomicBoolean = f77178a;
        if (atomicBoolean.get()) {
            com.cloud.sdk.commonutil.util.c.Log().d("ABTEST", "ABMemoryCache queryAllData Initialization has been completed");
            return;
        }
        atomicBoolean.set(true);
        HSScopeHelper hSScopeHelper = HSScopeHelper.f23249a;
        if (hSScopeHelper.c()) {
            hSScopeHelper.g(new Runnable() { // from class: v6.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.i(OnInitCompleteListener.this);
                }
            });
        } else {
            d(onInitCompleteListener);
        }
    }

    public static final void h(OnlineABLayerDTO onlineABLayerDTO) {
        Uri uri = com.cloud.hisavana.abtestkit.d.f21394a;
        if (onlineABLayerDTO != null) {
            long layerId = onlineABLayerDTO.getLayerId();
            try {
                z zVar = new z(0L, 0L, null, 7, null);
                zVar.setLayerId(layerId);
                zVar.setRequestTime(onlineABLayerDTO.getRequestTime());
                zVar.setInfo(onlineABLayerDTO.getInfo());
                ContentValues contentValues = new ContentValues();
                contentValues.put("abData", GsonUtil.d(zVar));
                com.cloud.sdk.commonutil.util.e.a().getContentResolver().insert(com.cloud.hisavana.abtestkit.d.f21394a, contentValues);
            } catch (Exception e11) {
                com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache upsertToDiskCache fail, reason = " + e11.getMessage());
                Unit unit = Unit.f67184a;
            }
        }
    }

    public static final void i(OnInitCompleteListener onInitCompleteListener) {
        d(onInitCompleteListener);
    }
}
