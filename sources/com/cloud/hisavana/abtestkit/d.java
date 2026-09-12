package com.cloud.hisavana.abtestkit;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.cloud.hisavana.abtestkit.bean.ABLayerInfo;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.cloud.sdk.commonutil.util.e;
import com.cloud.sdk.commonutil.util.o;
import com.google.gson.reflect.TypeToken;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import v6.r;

/* loaded from: classes3.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final Uri f21394a;

    /* renamed from: b, reason: collision with root package name */
    public static final Uri f21395b;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00020\u0001¨\u0006\u0004"}, d2 = {"com/cloud/hisavana/abtestkit/d$a", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/cloud/hisavana/abtestkit/bean/ABLayerInfo;", "abtestkit_release"}, k = 1, mv = {1, 9, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes3.dex */
    public static final class a extends TypeToken<List<? extends ABLayerInfo>> {
    }

    static {
        Uri parse = Uri.parse("content://" + e.d() + ".HisavanaContentProvider/ab_data");
        Intrinsics.g(parse, "parse(this)");
        f21394a = parse;
        Uri parse2 = Uri.parse("content://" + e.d() + ".HisavanaContentProvider/local_ab_data");
        Intrinsics.g(parse2, "parse(this)");
        f21395b = parse2;
    }

    public static String a(Long l11) {
        try {
            ContentResolver contentResolver = e.a().getContentResolver();
            Uri withAppendedId = ContentUris.withAppendedId(f21395b, l11.longValue());
            Intrinsics.g(withAppendedId, "withAppendedId(...)");
            Cursor query = contentResolver.query(withAppendedId, null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndex = query.getColumnIndex("local_ab_json");
                        Intrinsics.h(query, "<this>");
                        String string = columnIndex >= 0 ? query.getString(columnIndex) : null;
                        CloseableKt.a(query, null);
                        return string;
                    }
                    Unit unit = Unit.f67184a;
                    CloseableKt.a(query, null);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.a(query, th2);
                        throw th3;
                    }
                }
            }
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache queryLocalABFromDiskCache fail, reason = " + e11.getMessage());
        }
        return null;
    }

    public static ConcurrentHashMap b() {
        List<ABLayerInfo> list;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        String str = null;
        try {
            str = o.j("hisavana_ab_data.json");
            if (Log.isLoggable("ADSDK", 3)) {
                com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "ABDiskCache readAssets jsonString = " + str);
            }
        } catch (FileNotFoundException e11) {
            j7.a.e().p("key_local_ab_data_version_code", i7.c.m());
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache readAssets file not found, reason = " + e11.getMessage());
        } catch (Exception e12) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache readAssets fail, reason = " + e12.getMessage());
        }
        if (str != null) {
            try {
                if (str.length() != 0 && (list = (List) GsonUtil.b(str, new a().getType())) != null && !list.isEmpty()) {
                    for (ABLayerInfo aBLayerInfo : list) {
                        if (aBLayerInfo != null && aBLayerInfo.getLayerId() != null) {
                            concurrentHashMap.put(aBLayerInfo.getLayerId(), aBLayerInfo);
                        }
                    }
                    String d11 = GsonUtil.d(concurrentHashMap);
                    j7.a.e().p("key_local_ab_data_version_code", i7.c.m());
                    if (j7.a.e().n()) {
                        j7.a.e().r("key_local_ab_data_json", d11);
                    } else {
                        r rVar = new r(0);
                        rVar.f77194a = i7.c.m();
                        rVar.f77195b = d11;
                        c(rVar);
                    }
                    com.cloud.sdk.commonutil.util.c.Log().i("ABTEST", "ABDiskCache readAssets success, localLayerMap size = " + concurrentHashMap.size());
                }
            } catch (Exception e13) {
                com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache readAssets fail, reason = " + e13.getMessage());
            }
        }
        return concurrentHashMap;
    }

    public static void c(r rVar) {
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("localABData", GsonUtil.d(rVar));
            e.a().getContentResolver().insert(f21395b, contentValues);
        } catch (Exception e11) {
            com.cloud.sdk.commonutil.util.c.Log().w("ABTEST", "ABDiskCache upsertLocalABToDiskCache fail, reason = " + e11.getMessage());
            Unit unit = Unit.f67184a;
        }
    }
}
