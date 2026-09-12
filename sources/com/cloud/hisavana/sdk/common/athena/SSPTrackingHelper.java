package com.cloud.hisavana.sdk.common.athena;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.WebPageBean;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.util.g0;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigCodeSeatDTO;
import com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.ABTest;
import com.cloud.hisavana.sdk.data.bean.response.ccofig.CustomConfigManager;
import com.cloud.hisavana.sdk.k1;
import com.cloud.hisavana.sdk.q3;
import com.cloud.sdk.commonutil.gsonutil.GsonUtil;
import com.hisavana.common.tracking.TrackingKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes3.dex */
public final class SSPTrackingHelper {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f22036b;

    /* renamed from: a, reason: collision with root package name */
    public static final SSPTrackingHelper f22035a = new SSPTrackingHelper();

    /* renamed from: c, reason: collision with root package name */
    private static int f22037c = 10;

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f22038d = LazyKt.b(new Function0<Boolean>() { // from class: com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper$IS_DEBUG_LOG_MODE$2
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            boolean z10;
            try {
                z10 = Log.isLoggable("ADSDK", 3);
            } catch (Throwable unused) {
                z10 = false;
            }
            return Boolean.valueOf(z10);
        }
    });

    /* renamed from: e, reason: collision with root package name */
    private static final Map f22039e = Collections.synchronizedMap(new LinkedHashMap<String, ConcurrentHashMap<String, Object>>() { // from class: com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper$fillingTrackingMap$1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof ConcurrentHashMap) {
                return containsValue((ConcurrentHashMap<String, Object>) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(ConcurrentHashMap<String, Object> concurrentHashMap) {
            return super.containsValue((Object) concurrentHashMap);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, ConcurrentHashMap<String, Object>>> entrySet() {
            return getEntries();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ ConcurrentHashMap<String, Object> get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ ConcurrentHashMap<String, Object> get(String str) {
            return (ConcurrentHashMap) super.get((Object) str);
        }

        public /* bridge */ Set<Map.Entry<String, ConcurrentHashMap<String, Object>>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (ConcurrentHashMap<String, Object>) obj2);
        }

        public final /* bridge */ ConcurrentHashMap getOrDefault(Object obj, ConcurrentHashMap concurrentHashMap) {
            return !(obj instanceof String) ? concurrentHashMap : getOrDefault((String) obj, (ConcurrentHashMap<String, Object>) concurrentHashMap);
        }

        public /* bridge */ ConcurrentHashMap<String, Object> getOrDefault(String str, ConcurrentHashMap<String, Object> concurrentHashMap) {
            return (ConcurrentHashMap) super.getOrDefault((Object) str, (String) concurrentHashMap);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<ConcurrentHashMap<String, Object>> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ ConcurrentHashMap<String, Object> remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        public /* bridge */ ConcurrentHashMap<String, Object> remove(String str) {
            return (ConcurrentHashMap) super.remove((Object) str);
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof ConcurrentHashMap)) {
                return remove((String) obj, (ConcurrentHashMap<String, Object>) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, ConcurrentHashMap<String, Object> concurrentHashMap) {
            return super.remove((Object) str, (Object) concurrentHashMap);
        }

        @Override // java.util.LinkedHashMap
        protected boolean removeEldestEntry(Map.Entry<String, ConcurrentHashMap<String, Object>> eldest) {
            return size() > 30;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<ConcurrentHashMap<String, Object>> values() {
            return getValues();
        }
    });

    private SSPTrackingHelper() {
    }

    public static /* synthetic */ void C(SSPTrackingHelper sSPTrackingHelper, int i11, q3 q3Var, List list, String str, String str2, int i12, long j11, int i13, boolean z10, int i14, Object obj) {
        sSPTrackingHelper.B(i11, q3Var, list, str, str2, i12, j11, i13, (i14 & 256) != 0 ? false : z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(q3 q3Var, int i11, int i12, boolean z10, List adsDTOs, long j11, String str, String str2, int i13) {
        String valueOf;
        ConfigCodeSeatDTO f11;
        Intrinsics.h(adsDTOs, "$adsDTOs");
        try {
            SSPTrackingHelper sSPTrackingHelper = f22035a;
            Bundle v11 = sSPTrackingHelper.v(q3Var, i11);
            String string = v11.getString("temp_online_failed_code", "");
            v11.remove("temp_online_failed_code");
            if (i12 != 1) {
                v11.putInt("s_callback_status", i12);
            }
            if (z10) {
                v11.putInt("s_req_bidding", 1);
            }
            sSPTrackingHelper.Y(q3Var != null ? q3Var.n() : null);
            if (i11 == 0) {
                valueOf = "0";
            } else {
                if (string != null && string.length() != 0) {
                    valueOf = i11 + '_' + string;
                }
                valueOf = String.valueOf(i11);
            }
            String str3 = valueOf;
            Intrinsics.e(string);
            if (string.length() > 0) {
                v11.putString("s_online_failed_reason_v2", string);
            }
            v11.remove("s_online_status");
            v11.remove("s_default_status");
            v11.remove("s_offline_status");
            v11.remove("s_ma_d_s");
            v11.remove("s_req_timeout");
            v11.remove("s_ma_d_fr");
            AdsDTO adsDTO = (AdsDTO) CollectionsKt.k0(adsDTOs);
            if ((adsDTO != null ? adsDTO.getSource() : 0) == 4) {
                AthenaTracker.a.H(adsDTOs, q3Var != null ? q3Var.n() : null, q3Var != null ? q3Var.i() : null, j11, v11);
            } else {
                AthenaTracker.a.k(adsDTOs, q3Var != null ? q3Var.n() : null, q3Var != null ? q3Var.o() : 0, str, str3, j11, q3Var != null ? q3Var.i() : null, (q3Var == null || (f11 = q3Var.f()) == null) ? false : f11.isOfflineAdEnable(), str2, i13, v11);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(q3 fetchInfo, String str, String str2) {
        Intrinsics.h(fetchInfo, "$fetchInfo");
        try {
            AthenaTracker.a.o(fetchInfo, str, str2);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(q3 q3Var, List list, long j11, boolean z10) {
        try {
            f22035a.Y(q3Var != null ? q3Var.n() : null);
            AthenaTracker.a.p(q3Var, list, j11, Boolean.valueOf(z10));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(q3 q3Var, List list) {
        try {
            AthenaTracker.a.q(q3Var, list);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ArrayList arrayList, Integer num, AdsDTO adsDTO, Bundle bundle) {
        String d11;
        Intrinsics.h(bundle, "$bundle");
        if (arrayList != null) {
            try {
                if (arrayList.isEmpty()) {
                    arrayList = null;
                }
                if (arrayList != null && (d11 = GsonUtil.d(arrayList)) != null) {
                    String str = d11.length() > 0 ? d11 : null;
                    if (str != null) {
                        bundle.putString("s_click_chain_list", str);
                    }
                }
            } catch (Throwable unused) {
                return;
            }
        }
        AthenaTracker.a.j(String.valueOf(num), adsDTO, bundle);
    }

    public static /* synthetic */ void O(SSPTrackingHelper sSPTrackingHelper, Integer num, String str, String str2, AdsDTO adsDTO, Bundle bundle, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            bundle = null;
        }
        sSPTrackingHelper.N(num, str, str2, adsDTO, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(Integer num, String str, String str2, AdsDTO adsDTO, Bundle bundle) {
        try {
            AthenaTracker.a.s(String.valueOf(num), str, str2, adsDTO, bundle);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0086 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00b8, B:42:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00b8, B:42:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00b8, B:42:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00b8, B:42:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void R(java.lang.Integer r4, com.cloud.hisavana.sdk.data.bean.response.AdsDTO r5, java.lang.Long r6, java.lang.Boolean r7, java.lang.Boolean r8, java.lang.String r9, java.lang.Long r10, android.os.Bundle r11) {
        /*
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> L9
            r0.<init>()     // Catch: java.lang.Throwable -> L9
            r0.putAll(r11)     // Catch: java.lang.Throwable -> L9
            goto Le
        L9:
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> L1b
            r0.<init>()     // Catch: java.lang.Throwable -> L1b
        Le:
            java.lang.String r11 = "error_code"
            java.lang.String r1 = ""
            if (r4 == 0) goto L1e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L1b
            if (r4 != 0) goto L1f
            goto L1e
        L1b:
            r4 = move-exception
            goto Lc6
        L1e:
            r4 = r1
        L1f:
            r0.putString(r11, r4)     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L80
            java.lang.String r4 = "trigger_id"
            java.lang.String r11 = r5.getTriggerId()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "s_click_tracking_id"
            java.lang.String r11 = r5.getClickid()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "ad_creative_id"
            java.lang.String r11 = r5.getAdCreativeId()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "code_seat_type"
            java.lang.Integer r11 = r5.getCodeSeatType()     // Catch: java.lang.Throwable -> L80
            if (r11 != 0) goto L49
            r11 = -1
            goto L50
        L49:
            kotlin.jvm.internal.Intrinsics.e(r11)     // Catch: java.lang.Throwable -> L80
            int r11 = r11.intValue()     // Catch: java.lang.Throwable -> L80
        L50:
            r0.putInt(r4, r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "code_seat_id"
            java.lang.String r11 = r5.getCodeSeatId()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "show_id"
            java.lang.String r11 = r5.getUuid()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "preload_enable"
            java.lang.Boolean r11 = r5.getPreloadEnable()     // Catch: java.lang.Throwable -> L80
            java.lang.String r2 = "getPreloadEnable(...)"
            kotlin.jvm.internal.Intrinsics.g(r11, r2)     // Catch: java.lang.Throwable -> L80
            boolean r11 = r11.booleanValue()     // Catch: java.lang.Throwable -> L80
            r0.putInt(r4, r11)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "preload_status"
            int r5 = r5.getPreloadStatus()     // Catch: java.lang.Throwable -> L80
            r0.putInt(r4, r5)     // Catch: java.lang.Throwable -> L80
        L80:
            java.lang.String r4 = "s_cct_load_time"
            r2 = 0
            if (r6 == 0) goto L8b
            long r5 = r6.longValue()     // Catch: java.lang.Throwable -> L1b
            goto L8c
        L8b:
            r5 = r2
        L8c:
            r0.putLong(r4, r5)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_aborted"
            r5 = 0
            if (r7 == 0) goto L99
            boolean r6 = r7.booleanValue()     // Catch: java.lang.Throwable -> L1b
            goto L9a
        L99:
            r6 = r5
        L9a:
            r0.putBoolean(r4, r6)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_warmup"
            if (r8 == 0) goto La5
            boolean r5 = r8.booleanValue()     // Catch: java.lang.Throwable -> L1b
        La5:
            r0.putBoolean(r4, r5)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_version"
            if (r9 != 0) goto Lad
            r9 = r1
        Lad:
            r0.putString(r4, r9)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_launch_time"
            if (r10 == 0) goto Lb8
            long r2 = r10.longValue()     // Catch: java.lang.Throwable -> L1b
        Lb8:
            r0.putLong(r4, r2)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_device"
            java.lang.String r5 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L1b
            r0.putString(r4, r5)     // Catch: java.lang.Throwable -> L1b
            com.cloud.hisavana.sdk.common.athena.AthenaTracker.a.A(r0)     // Catch: java.lang.Throwable -> L1b
            goto Ld1
        Lc6:
            com.cloud.hisavana.sdk.e4 r5 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r6 = "SSPTrackingHelper"
            java.lang.String r7 = "realTrackingCCTLandingPage"
            r5.e(r6, r7, r4)
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper.R(java.lang.Integer, com.cloud.hisavana.sdk.data.bean.response.AdsDTO, java.lang.Long, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Long, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0086 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00ba, B:28:0x00c1, B:29:0x00c5, B:46:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0094 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00ba, B:28:0x00c1, B:29:0x00c5, B:46:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00ba, B:28:0x00c1, B:29:0x00c5, B:46:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b4 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00ba, B:28:0x00c1, B:29:0x00c5, B:46:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c1 A[Catch: all -> 0x001b, TryCatch #2 {all -> 0x001b, blocks: (B:6:0x0014, B:9:0x001f, B:13:0x0086, B:14:0x008c, B:16:0x0094, B:17:0x009a, B:19:0x00a1, B:20:0x00a5, B:23:0x00ad, B:25:0x00b4, B:26:0x00ba, B:28:0x00c1, B:29:0x00c5, B:46:0x0009, B:2:0x0000), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0024 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void T(java.lang.Integer r4, com.cloud.hisavana.sdk.data.bean.response.AdsDTO r5, java.lang.Long r6, java.lang.Boolean r7, java.lang.Boolean r8, java.lang.String r9, java.lang.Long r10, java.lang.Long r11, android.os.Bundle r12) {
        /*
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> L9
            r0.<init>()     // Catch: java.lang.Throwable -> L9
            r0.putAll(r12)     // Catch: java.lang.Throwable -> L9
            goto Le
        L9:
            android.os.Bundle r0 = new android.os.Bundle     // Catch: java.lang.Throwable -> L1b
            r0.<init>()     // Catch: java.lang.Throwable -> L1b
        Le:
            java.lang.String r12 = "error_code"
            java.lang.String r1 = ""
            if (r4 == 0) goto L1e
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L1b
            if (r4 != 0) goto L1f
            goto L1e
        L1b:
            r4 = move-exception
            goto Ld3
        L1e:
            r4 = r1
        L1f:
            r0.putString(r12, r4)     // Catch: java.lang.Throwable -> L1b
            if (r5 == 0) goto L80
            java.lang.String r4 = "trigger_id"
            java.lang.String r12 = r5.getTriggerId()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r12)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "s_click_tracking_id"
            java.lang.String r12 = r5.getClickid()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r12)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "ad_creative_id"
            java.lang.String r12 = r5.getAdCreativeId()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r12)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "code_seat_type"
            java.lang.Integer r12 = r5.getCodeSeatType()     // Catch: java.lang.Throwable -> L80
            if (r12 != 0) goto L49
            r12 = -1
            goto L50
        L49:
            kotlin.jvm.internal.Intrinsics.e(r12)     // Catch: java.lang.Throwable -> L80
            int r12 = r12.intValue()     // Catch: java.lang.Throwable -> L80
        L50:
            r0.putInt(r4, r12)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "code_seat_id"
            java.lang.String r12 = r5.getCodeSeatId()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r12)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "show_id"
            java.lang.String r12 = r5.getUuid()     // Catch: java.lang.Throwable -> L80
            r0.putString(r4, r12)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "preload_enable"
            java.lang.Boolean r12 = r5.getPreloadEnable()     // Catch: java.lang.Throwable -> L80
            java.lang.String r2 = "getPreloadEnable(...)"
            kotlin.jvm.internal.Intrinsics.g(r12, r2)     // Catch: java.lang.Throwable -> L80
            boolean r12 = r12.booleanValue()     // Catch: java.lang.Throwable -> L80
            r0.putInt(r4, r12)     // Catch: java.lang.Throwable -> L80
            java.lang.String r4 = "preload_status"
            int r5 = r5.getPreloadStatus()     // Catch: java.lang.Throwable -> L80
            r0.putInt(r4, r5)     // Catch: java.lang.Throwable -> L80
        L80:
            java.lang.String r4 = "s_cct_load_time"
            r2 = 0
            if (r6 == 0) goto L8b
            long r5 = r6.longValue()     // Catch: java.lang.Throwable -> L1b
            goto L8c
        L8b:
            r5 = r2
        L8c:
            r0.putLong(r4, r5)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_aborted"
            r5 = 0
            if (r7 == 0) goto L99
            boolean r6 = r7.booleanValue()     // Catch: java.lang.Throwable -> L1b
            goto L9a
        L99:
            r6 = r5
        L9a:
            r0.putBoolean(r4, r6)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_warmup"
            if (r8 == 0) goto La5
            boolean r5 = r8.booleanValue()     // Catch: java.lang.Throwable -> L1b
        La5:
            r0.putBoolean(r4, r5)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_version"
            if (r9 != 0) goto Lad
            r9 = r1
        Lad:
            r0.putString(r4, r9)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_launch_time"
            if (r10 == 0) goto Lb9
            long r5 = r10.longValue()     // Catch: java.lang.Throwable -> L1b
            goto Lba
        Lb9:
            r5 = r2
        Lba:
            r0.putLong(r4, r5)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_landing_stay_time"
            if (r11 == 0) goto Lc5
            long r2 = r11.longValue()     // Catch: java.lang.Throwable -> L1b
        Lc5:
            r0.putLong(r4, r2)     // Catch: java.lang.Throwable -> L1b
            java.lang.String r4 = "s_cct_device"
            java.lang.String r5 = android.os.Build.BRAND     // Catch: java.lang.Throwable -> L1b
            r0.putString(r4, r5)     // Catch: java.lang.Throwable -> L1b
            com.cloud.hisavana.sdk.common.athena.AthenaTracker.a.z(r0)     // Catch: java.lang.Throwable -> L1b
            goto Lde
        Ld3:
            com.cloud.hisavana.sdk.e4 r5 = com.cloud.hisavana.sdk.e4.b()
            java.lang.String r6 = "SSPTrackingHelper"
            java.lang.String r7 = "realTrackingCCTLandingPageExit"
            r5.e(r6, r7, r4)
        Lde:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper.T(java.lang.Integer, com.cloud.hisavana.sdk.data.bean.response.AdsDTO, java.lang.Long, java.lang.Boolean, java.lang.Boolean, java.lang.String, java.lang.Long, java.lang.Long, android.os.Bundle):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(Bundle bundle, q3 q3Var, int i11, TaErrorCode taErrorCode) {
        String str;
        String n11;
        try {
            Bundle bundle2 = new Bundle();
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            if (q3Var != null && (n11 = q3Var.n()) != null) {
                bundle2.putString(TrackingKey.TRIGGER_ID, n11);
            }
            if (q3Var != null) {
                bundle2.putInt("ad_type", q3Var.e());
            }
            bundle2.putLong(TrackingKey.EVENT_TS, System.currentTimeMillis());
            bundle2.putInt("s_track_event_type", i11);
            if (i11 == 2) {
                if (taErrorCode == null || (str = Integer.valueOf(taErrorCode.getErrorCode()).toString()) == null) {
                    str = "";
                }
                bundle2.putString("error_code", str);
            }
            AthenaTracker.a.n(bundle2);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(WebPageBean webPageBean, AdsDTO adsDTO, boolean z10, List list, List list2, Boolean bool, Long l11, boolean z11, Bundle bundle, Integer num) {
        Bundle bundle2;
        int intValue;
        String str;
        try {
            try {
                bundle2 = new Bundle();
                if (bundle != null) {
                    bundle2.putAll(bundle);
                }
            } catch (Throwable unused) {
                bundle2 = new Bundle();
            }
            if (webPageBean != null) {
                bundle2.putString("webId", webPageBean.getWebId());
                if (!z10) {
                    bundle2.putString("url", webPageBean.getUrl());
                    bundle2.putLong("spendTime", webPageBean.getSpendTime());
                }
                if (num == null || (str = num.toString()) == null) {
                    str = "";
                }
                bundle2.putString("error_code", str);
            }
            if (adsDTO != null) {
                bundle2.putString(TrackingKey.TRIGGER_ID, adsDTO.getTriggerId());
                bundle2.putString("s_click_tracking_id", adsDTO.getClickid());
                try {
                    Integer codeSeatType = adsDTO.getCodeSeatType();
                    if (codeSeatType == null) {
                        intValue = -1;
                    } else {
                        Intrinsics.e(codeSeatType);
                        intValue = codeSeatType.intValue();
                    }
                    bundle2.putInt("code_seat_type", intValue);
                    bundle2.putString(TrackingKey.CODE_SEAT_ID, adsDTO.getCodeSeatId());
                    bundle2.putString("ad_creative_id", adsDTO.getAdCreativeId());
                    bundle2.putString(TrackingKey.SHOW_ID, adsDTO.getUuid());
                    Boolean preloadEnable = adsDTO.getPreloadEnable();
                    Intrinsics.g(preloadEnable, "getPreloadEnable(...)");
                    bundle2.putInt("preload_enable", preloadEnable.booleanValue() ? 1 : 0);
                    bundle2.putInt("preload_status", adsDTO.getPreloadStatus());
                } catch (Throwable unused2) {
                }
            }
            if (!z10) {
                if (list != null && (!list.isEmpty())) {
                    bundle2.putString("s_landing_router", GsonUtil.d(list));
                }
                if (list2 != null && (!list2.isEmpty())) {
                    bundle2.putString("s_landing_ges_router", GsonUtil.d(list2));
                }
            }
            bundle2.putInt("s_landing_complete", Intrinsics.c(bool, Boolean.TRUE) ? 1 : 0);
            if (l11 != null) {
                if ((l11.longValue() != 0 ? l11 : null) != null) {
                    bundle2.putLong("s_landing_stay_time", l11.longValue());
                }
            }
            if (z11) {
                bundle2.putInt("s_landing_nav_finish", 1);
            }
            AthenaTracker.a.Y(bundle2);
        } catch (Throwable unused3) {
        }
    }

    private final void Y(String str) {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    f22039e.remove(str);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private final boolean r() {
        return ((Boolean) f22038d.getValue()).booleanValue();
    }

    private final boolean u(String str) {
        if (str != null) {
            try {
                if (str.length() != 0) {
                    if (t()) {
                        return true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private final Bundle v(q3 q3Var, int i11) {
        String n11;
        if (q3Var != null) {
            try {
                n11 = q3Var.n();
            } catch (Throwable unused) {
                return new Bundle();
            }
        } else {
            n11 = null;
        }
        Bundle k11 = g0.k(p(n11));
        if (i11 == 0) {
            w(k11);
        } else {
            w(k11);
        }
        return k11;
    }

    private final void w(Bundle bundle) {
        try {
            int i11 = bundle.getInt("s_online_status");
            if (i11 == 2) {
                String string = bundle.getString("s_online_failed_reason_v2");
                int i12 = bundle.getInt("s_ma_d_s", 0);
                TaErrorCode taErrorCode = TaErrorCode.ERROR_ONLINE_NEW_REQUEST_TIMEOUT;
                if (Intrinsics.c(string, String.valueOf(taErrorCode.getErrorCode()))) {
                    if (i12 == 1) {
                        g0.g(bundle, "temp_online_failed_code", "5032");
                        return;
                    } else {
                        g0.g(bundle, "temp_online_failed_code", String.valueOf(taErrorCode.getErrorCode()));
                        return;
                    }
                }
                if (i12 != 3) {
                    g0.g(bundle, "temp_online_failed_code", string);
                    return;
                }
                g0.g(bundle, "temp_online_failed_code", "5029_" + string);
                return;
            }
            if (i11 != 1) {
                String string2 = bundle.getString("s_req_chs");
                if (string2 == null || !StringsKt.c0(string2, "2", false, 2, null)) {
                    int i13 = bundle.getInt("temp_online_without_req", -1);
                    if (i13 != -1) {
                        g0.g(bundle, "temp_online_failed_code", String.valueOf(i13));
                    }
                    g0.i(bundle, "temp_online_without_req");
                    return;
                }
                boolean z10 = bundle.getBoolean("s_req_timeout", false);
                int i14 = bundle.getInt("s_ma_d_s", 0);
                if (z10) {
                    if (i14 == 1) {
                        g0.g(bundle, "temp_online_failed_code", "5033");
                        return;
                    } else {
                        g0.g(bundle, "temp_online_failed_code", "5025");
                        return;
                    }
                }
                if (i14 == 1) {
                    g0.g(bundle, "temp_online_failed_code", "5030");
                } else {
                    g0.g(bundle, "temp_online_failed_code", "5026");
                }
            }
        } catch (Throwable unused) {
        }
    }

    public final void A(int i11, q3 q3Var, List list, String str, String str2, int i12, long j11, int i13) {
        C(this, i11, q3Var, list, str, str2, i12, j11, i13, false, 256, null);
    }

    public final void B(final int i11, final q3 q3Var, List list, final String str, final String str2, final int i12, final long j11, final int i13, final boolean z10) {
        try {
            final ArrayList arrayList = new ArrayList();
            if (list != null) {
                arrayList.addAll(list);
            }
            i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.q
                @Override // java.lang.Runnable
                public final void run() {
                    SSPTrackingHelper.D(q3.this, i11, i13, z10, arrayList, j11, str, str2, i12);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void E(final q3 fetchInfo, final String str, final String str2) {
        Intrinsics.h(fetchInfo, "fetchInfo");
        try {
            i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.i
                @Override // java.lang.Runnable
                public final void run() {
                    SSPTrackingHelper.F(q3.this, str, str2);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void G(final q3 q3Var, final List list, final long j11, final boolean z10) {
        try {
            i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.p
                @Override // java.lang.Runnable
                public final void run() {
                    SSPTrackingHelper.H(q3.this, list, j11, z10);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void I(final q3 q3Var, final List list) {
        try {
            i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.h
                @Override // java.lang.Runnable
                public final void run() {
                    SSPTrackingHelper.J(q3.this, list);
                }
            });
        } catch (Throwable unused) {
        }
    }

    public final void K(final Integer num, final AdsDTO adsDTO, final Bundle bundle, final ArrayList arrayList) {
        Intrinsics.h(bundle, "bundle");
        i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.j
            @Override // java.lang.Runnable
            public final void run() {
                SSPTrackingHelper.L(arrayList, num, adsDTO, bundle);
            }
        });
    }

    public final void M(Integer num, String str, String str2, AdsDTO adsDTO) {
        O(this, num, str, str2, adsDTO, null, 16, null);
    }

    public final void N(final Integer num, final String str, final String str2, final AdsDTO adsDTO, final Bundle bundle) {
        i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.m
            @Override // java.lang.Runnable
            public final void run() {
                SSPTrackingHelper.P(num, str, str2, adsDTO, bundle);
            }
        });
    }

    public final void Q(final Integer num, final AdsDTO adsDTO, final Long l11, final Long l12, final Boolean bool, final String str, final Boolean bool2, final Bundle bundle) {
        i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.n
            @Override // java.lang.Runnable
            public final void run() {
                SSPTrackingHelper.R(num, adsDTO, l12, bool2, bool, str, l11, bundle);
            }
        });
    }

    public final void S(final Integer num, final AdsDTO adsDTO, final Long l11, final Long l12, final Long l13, final Boolean bool, final String str, final Boolean bool2, final Bundle bundle) {
        i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.k
            @Override // java.lang.Runnable
            public final void run() {
                SSPTrackingHelper.T(num, adsDTO, l12, bool2, bool, str, l11, l13, bundle);
            }
        });
    }

    public final void U(final int i11, final q3 q3Var, final TaErrorCode taErrorCode, final Bundle bundle) {
        i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.o
            @Override // java.lang.Runnable
            public final void run() {
                SSPTrackingHelper.V(bundle, q3Var, i11, taErrorCode);
            }
        });
    }

    public final void W(final Integer num, final List list, final List list2, final AdsDTO adsDTO, final WebPageBean webPageBean, final boolean z10, final boolean z11, final Long l11, final Boolean bool, final Bundle bundle) {
        i7.b.c(new Runnable() { // from class: com.cloud.hisavana.sdk.common.athena.l
            @Override // java.lang.Runnable
            public final void run() {
                SSPTrackingHelper.X(WebPageBean.this, adsDTO, z11, list, list2, bool, l11, z10, bundle, num);
            }
        });
    }

    public final void Z(String str, Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.putInt("is_dev_open", u(str) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
    }

    public final void a0(String str, Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.putInt("is_filling_dev_open", u(str) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
    }

    public final void b0(String str, Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.putInt("is_show_dev_open", u(str) ? 1 : 0);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0027 A[Catch: all -> 0x0047, TRY_LEAVE, TryCatch #0 {all -> 0x0047, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000d, B:9:0x0015, B:11:0x001b, B:16:0x0027), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean k(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 1
            com.cloud.hisavana.sdk.k1 r1 = com.cloud.hisavana.sdk.k1.o()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L12
            com.cloud.hisavana.sdk.data.bean.response.ConfigTotalDTO$ExtInfo r1 = r1.m()     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L12
            boolean r1 = r1.isEnableClientSampling()     // Catch: java.lang.Throwable -> L47
            goto L13
        L12:
            r1 = r0
        L13:
            if (r1 == 0) goto L24
            boolean r1 = r6.r()     // Catch: java.lang.Throwable -> L47
            if (r1 != 0) goto L24
            boolean r1 = r6.u(r7)     // Catch: java.lang.Throwable -> L47
            if (r1 == 0) goto L22
            goto L24
        L22:
            r1 = 0
            goto L25
        L24:
            r1 = r0
        L25:
            if (r1 != 0) goto L46
            com.cloud.hisavana.sdk.e4 r2 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> L47
            java.lang.String r3 = "SSPTrackingHelper"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r4.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = "eventName -> "
            r4.append(r5)     // Catch: java.lang.Throwable -> L47
            r4.append(r7)     // Catch: java.lang.Throwable -> L47
            java.lang.String r7 = " reporting not allowed"
            r4.append(r7)     // Catch: java.lang.Throwable -> L47
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L47
            r2.d(r3, r7)     // Catch: java.lang.Throwable -> L47
        L46:
            r0 = r1
        L47:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper.k(java.lang.String):boolean");
    }

    public final boolean l(String str, String str2) {
        Object m1185constructorimpl;
        boolean z10;
        ArrayList<String> trackEvent;
        try {
            Result.Companion companion = Result.INSTANCE;
            ABTest aBTestData = CustomConfigManager.getABTestData(str);
            if (aBTestData != null && (trackEvent = aBTestData.getTrackEvent()) != null && !trackEvent.isEmpty()) {
                Iterator<T> it = trackEvent.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.c((String) it.next(), str2)) {
                        z10 = true;
                        break;
                    }
                }
            }
            z10 = false;
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf(z10));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Boolean bool = Boolean.FALSE;
        if (Result.m1191isFailureimpl(m1185constructorimpl)) {
            m1185constructorimpl = bool;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    public final AdsDTO m(G g11) {
        List s11;
        if (g11 == null || (s11 = g11.s()) == null) {
            return null;
        }
        return (AdsDTO) CollectionsKt.k0(s11);
    }

    public final long n() {
        Object m1185constructorimpl;
        ConfigTotalDTO.ExtInfo m11;
        try {
            Result.Companion companion = Result.INSTANCE;
            k1 o11 = k1.o();
            m1185constructorimpl = Result.m1185constructorimpl(Long.valueOf((o11 == null || (m11 = o11.m()) == null) ? 0L : m11.getAdReqInterval()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = 0L;
        }
        return ((Number) m1185constructorimpl).longValue();
    }

    public final String o(G g11) {
        q3 p11;
        String i11 = (g11 == null || (p11 = g11.p()) == null) ? null : p11.i();
        return i11 == null ? "" : i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0034 A[Catch: all -> 0x000b, TryCatch #0 {all -> 0x000b, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0010, B:9:0x0017, B:15:0x0030, B:17:0x004d, B:25:0x0032, B:26:0x0033, B:27:0x0034, B:11:0x0018, B:13:0x0020), top: B:1:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0010 A[Catch: all -> 0x000b, TryCatch #0 {all -> 0x000b, blocks: (B:2:0x0000, B:4:0x0004, B:8:0x0010, B:9:0x0017, B:15:0x0030, B:17:0x004d, B:25:0x0032, B:26:0x0033, B:27:0x0034, B:11:0x0018, B:13:0x0020), top: B:1:0x0000, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.concurrent.ConcurrentHashMap p(java.lang.String r5) {
        /*
            r4 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> Lb
            if (r5 == 0) goto Ld
            int r0 = r5.length()     // Catch: java.lang.Throwable -> Lb
            if (r0 != 0) goto Le
            goto Ld
        Lb:
            r5 = move-exception
            goto L52
        Ld:
            r5 = 0
        Le:
            if (r5 == 0) goto L34
            java.util.Map r0 = com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper.f22039e     // Catch: java.lang.Throwable -> Lb
            java.lang.String r1 = "fillingTrackingMap"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)     // Catch: java.lang.Throwable -> Lb
            monitor-enter(r0)     // Catch: java.lang.Throwable -> Lb
            java.lang.Object r1 = r0.get(r5)     // Catch: java.lang.Throwable -> L2e
            java.util.concurrent.ConcurrentHashMap r1 = (java.util.concurrent.ConcurrentHashMap) r1     // Catch: java.lang.Throwable -> L2e
            if (r1 != 0) goto L30
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> L2e
            r1.<init>()     // Catch: java.lang.Throwable -> L2e
            java.lang.String r2 = "fillingTrackingMap"
            kotlin.jvm.internal.Intrinsics.g(r0, r2)     // Catch: java.lang.Throwable -> L2e
            r0.put(r5, r1)     // Catch: java.lang.Throwable -> L2e
            goto L30
        L2e:
            r5 = move-exception
            goto L32
        L30:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
            goto L4d
        L32:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb
            throw r5     // Catch: java.lang.Throwable -> Lb
        L34:
            java.util.concurrent.ConcurrentHashMap r1 = new java.util.concurrent.ConcurrentHashMap     // Catch: java.lang.Throwable -> Lb
            r1.<init>()     // Catch: java.lang.Throwable -> Lb
            com.cloud.hisavana.sdk.e4 r5 = com.cloud.hisavana.sdk.e4.b()     // Catch: java.lang.Throwable -> Lb
            java.lang.String r0 = "SSPTrackingHelper"
            java.lang.Throwable r2 = new java.lang.Throwable     // Catch: java.lang.Throwable -> Lb
            java.lang.String r3 = "getFillingTrackingBundle: triggerId is empty"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb
            java.lang.String r2 = android.util.Log.getStackTraceString(r2)     // Catch: java.lang.Throwable -> Lb
            r5.d(r0, r2)     // Catch: java.lang.Throwable -> Lb
        L4d:
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r1)     // Catch: java.lang.Throwable -> Lb
            goto L5c
        L52:
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.ResultKt.a(r5)
            java.lang.Object r5 = kotlin.Result.m1185constructorimpl(r5)
        L5c:
            java.lang.Throwable r0 = kotlin.Result.m1188exceptionOrNullimpl(r5)
            if (r0 != 0) goto L63
            goto L68
        L63:
            java.util.concurrent.ConcurrentHashMap r5 = new java.util.concurrent.ConcurrentHashMap
            r5.<init>()
        L68:
            java.util.concurrent.ConcurrentHashMap r5 = (java.util.concurrent.ConcurrentHashMap) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper.p(java.lang.String):java.util.concurrent.ConcurrentHashMap");
    }

    public final String q(G g11) {
        q3 p11;
        String n11 = (g11 == null || (p11 = g11.p()) == null) ? null : p11.n();
        return n11 == null ? "" : n11;
    }

    public final String s(String urlString) {
        Object m1185constructorimpl;
        Intrinsics.h(urlString, "urlString");
        try {
            Result.Companion companion = Result.INSTANCE;
            Uri parse = Uri.parse(urlString);
            Intrinsics.g(parse, "parse(this)");
            m1185constructorimpl = Result.m1185constructorimpl(parse.buildUpon().clearQuery().fragment(null).build().toString());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = "";
        }
        return (String) m1185constructorimpl;
    }

    public final boolean t() {
        ConfigTotalDTO.ExtInfo m11;
        try {
            k1 o11 = k1.o();
            int clientSamplingRatio = (o11 == null || (m11 = o11.m()) == null) ? 10 : m11.getClientSamplingRatio();
            if (clientSamplingRatio == 100) {
                return true;
            }
            if (AthenaTracker.f22032b || f22037c != clientSamplingRatio) {
                f22036b = AthenaTracker.n(com.cloud.sdk.commonutil.util.e.a(), clientSamplingRatio);
                f22037c = clientSamplingRatio;
            }
            return f22036b;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final void x(List list, q3 q3Var) {
        int source;
        if (list != null) {
            try {
                if (!list.isEmpty() && list.size() > 1 && (source = ((AdsDTO) CollectionsKt.i0(list)).getSource()) != 2 && source != 1 && !list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        AdsDTO adsDTO = (AdsDTO) it.next();
                        if (adsDTO.getSource() == 2 || adsDTO.getSource() == 1) {
                            g0.h(p(q3Var != null ? q3Var.n() : null), "s_online_failed_reason_v2", "5031");
                            return;
                        }
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void y(int i11, Bundle bundle, int i12) {
        String str = i11 != 1 ? i11 != 2 ? "" : "s_click_pkg_f_r" : "s_click_dp_f_r";
        if (str.length() <= 0 || bundle == null) {
            return;
        }
        bundle.putInt(str, i12);
    }

    public final void z(String str, String str2) {
        try {
            ConcurrentHashMap p11 = p(str);
            String a11 = g0.a(p11, "s_req_chs");
            if (a11 != null) {
                if (a11.length() <= 0) {
                    a11 = null;
                }
                if (a11 != null) {
                    String str3 = a11 + ',' + str2;
                    if (str3 != null) {
                        str2 = str3;
                    }
                }
            }
            g0.h(p11, "s_req_chs", str2);
        } catch (Throwable unused) {
        }
    }
}
