package com.wecloud.load.lib;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wecloud.load.lib.bean.CpuVariant;
import com.wecloud.load.lib.bean.SoConfigGroup;
import com.wecloud.load.lib.bean.SoLoadControlConfig;
import com.wecloud.load.lib.bean.SoZipInfo;
import com.wecloud.load.lib.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;
import org.json.JSONObject;

/* loaded from: classes7.dex */
public final class DySoLoadManager {

    /* renamed from: a, reason: collision with root package name */
    public static final DySoLoadManager f60929a = new DySoLoadManager();

    /* renamed from: b, reason: collision with root package name */
    private static SoLoadControlConfig f60930b;

    /* loaded from: classes7.dex */
    public static final class a extends h.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ o f60931a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f60932b;

        a(o oVar, Context context) {
            this.f60931a = oVar;
            this.f60932b = context;
        }

        @Override // com.wecloud.load.lib.h
        public void R(String str, String str2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SO执行结果 - soName: ");
            sb2.append(str);
            sb2.append(", msg: ");
            sb2.append(str2);
            if (str == null || StringsKt.q0(str) || str2 == null || StringsKt.q0(str2)) {
                return;
            }
            DySoLoadManager dySoLoadManager = DySoLoadManager.f60929a;
            if (dySoLoadManager.e(str2)) {
                try {
                    String optString = new JSONObject(str2).optString(NotificationCompat.CATEGORY_EVENT);
                    dySoLoadManager.g(str, MapsKt.l(TuplesKt.a(EventConstants.KEY_ACTION, "so_result"), TuplesKt.a(NotificationCompat.CATEGORY_EVENT, optString), TuplesKt.a(NotificationCompat.CATEGORY_MESSAGE, str2)), optString);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }

        @Override // com.wecloud.load.lib.h
        public void e(String str, int i11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("SO初始化结果 - soName: ");
            sb2.append(str);
            sb2.append(", status: ");
            sb2.append(i11);
            if (str == null || StringsKt.q0(str)) {
                return;
            }
            DySoLoadManager.h(DySoLoadManager.f60929a, str, MapsKt.l(TuplesKt.a("so_name", str), TuplesKt.a(EventConstants.KEY_ACTION, "so_init"), TuplesKt.a(NotificationCompat.CATEGORY_STATUS, String.valueOf(i11))), null, 4, null);
        }

        @Override // com.wecloud.load.lib.h
        public void n0(int i11, int i12, int i13) {
            a.C0856a.f(lg.a.f68962a, "SoLoadManagerExample", "所有ZIP包处理完成 - 总数: " + i11 + ", 总成功: " + i12 + ", 总失败: " + i13, false, 4, null);
        }

        @Override // com.wecloud.load.lib.h
        public void onError(int i11, String str) {
            a.C0856a.l(lg.a.f68962a, "SoLoadManagerExample", "错误 - 错误码: " + i11 + ", 错误信息: " + str, false, 4, null);
            this.f60931a.k(this.f60932b);
        }

        @Override // com.wecloud.load.lib.h
        public void q0(int i11, int i12, int i13, List list, Map map) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ZIP包 groupIndex ");
            sb2.append(i11);
            sb2.append(" 加载完成 - 成功: ");
            sb2.append(i12);
            sb2.append(", 失败: ");
            sb2.append(i13);
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    a.C0856a.f(lg.a.f68962a, "SoLoadManagerExample", "成功加载: " + str, false, 4, null);
                }
            }
            if (map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = (String) entry.getKey();
                    String str3 = (String) entry.getValue();
                    a.C0856a.l(lg.a.f68962a, "SoLoadManagerExample", "加载失败: " + str2 + ", 错误: " + str3, false, 4, null);
                }
            }
        }
    }

    private DySoLoadManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str, Map map, String str2) {
        if (str2 == null || StringsKt.q0(str2)) {
            str2 = "load_so";
        }
        hj.i.f64628a.s(str, str2, map);
    }

    static /* synthetic */ void h(DySoLoadManager dySoLoadManager, String str, Map map, String str2, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str2 = null;
        }
        dySoLoadManager.g(str, map, str2);
    }

    public final void b(Context context, String jsonSoInfo) {
        Intrinsics.h(context, "context");
        Intrinsics.h(jsonSoInfo, "jsonSoInfo");
        SoLoadControlConfig c11 = c(context);
        if (c11 == null || !c11.getEnableService() || c11.getExitProcess()) {
            Boolean valueOf = c11 != null ? Boolean.valueOf(c11.getEnableService()) : null;
            Boolean valueOf2 = c11 != null ? Boolean.valueOf(c11.getEnableService()) : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("未满足条件 控制配置controlConfig=");
            sb2.append(c11);
            sb2.append(" 控制开关=");
            sb2.append(valueOf);
            sb2.append(" 退出开关=");
            sb2.append(valueOf2);
            return;
        }
        o a11 = o.f60988f.a();
        a aVar = new a(a11, context);
        List f11 = f(jsonSoInfo);
        Log.w("SoLoadManagerExample", "解析后的SO配置数量: " + f11.size());
        SoDownloadRequest soDownloadRequest = new SoDownloadRequest(f11, f60930b);
        if (soDownloadRequest.isValid()) {
            a11.i(context, aVar, soDownloadRequest);
        } else {
            a.C0856a.f(lg.a.f68962a, "SoLoadManagerExample", "solist 配置无效 为null或者缺失关键信息，不启动服务", false, 4, null);
        }
    }

    public final SoLoadControlConfig c(Context context) {
        Intrinsics.h(context, "context");
        try {
            String l11 = gz.b.f64159a.b().l("so_load_control_config", null);
            if (l11 != null) {
                a.C0856a.f(lg.a.f68962a, "SoLoadManagerExample", "从 MMKV 读取配置: " + l11, false, 4, null);
            } else {
                a.C0856a.f(lg.a.f68962a, "SoLoadManagerExample", "MMKV 中不存在配置", false, 4, null);
            }
            SoLoadControlConfig soLoadControlConfig = (SoLoadControlConfig) new Gson().fromJson(l11, SoLoadControlConfig.class);
            f60930b = soLoadControlConfig;
            return soLoadControlConfig;
        } catch (Exception e11) {
            a.C0856a.k(lg.a.f68962a, "SoLoadManagerExample", "从 MMKV 读取配置失败: " + e11.getMessage(), e11, false, 8, null);
            return null;
        }
    }

    public final String d() {
        String[] strArr = Build.SUPPORTED_ABIS;
        Intrinsics.e(strArr);
        for (String str : strArr) {
            Intrinsics.e(str);
            if (StringsKt.c0(str, "arm64-v8a", false, 2, null)) {
                return "v8a";
            }
        }
        for (String str2 : strArr) {
            Intrinsics.e(str2);
            if (StringsKt.c0(str2, "armeabi-v7a", false, 2, null)) {
                break;
            }
        }
        return "v7a";
    }

    /*  JADX ERROR: NullPointerException in pass: RegionMakerVisitor
        java.lang.NullPointerException
        */
    public final boolean e(java.lang.String r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L10
            boolean r1 = kotlin.text.StringsKt.q0(r3)
            if (r1 == 0) goto La
            goto L10
        La:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L10
            r1.<init>(r3)     // Catch: org.json.JSONException -> L10
            r0 = 1
        L10:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wecloud.load.lib.DySoLoadManager.e(java.lang.String):boolean");
    }

    public final List f(String jsonString) {
        Intrinsics.h(jsonString, "jsonString");
        String d11 = d();
        Log.w("SoLoadManagerExample", "当前设备CPU架构: " + d11);
        try {
            Object fromJson = new Gson().fromJson(jsonString, new TypeToken<List<? extends SoConfigGroup>>() { // from class: com.wecloud.load.lib.DySoLoadManager$parseAndFilterConfig$type$1
            }.getType());
            Intrinsics.g(fromJson, "fromJson(...)");
            ArrayList arrayList = new ArrayList();
            for (SoConfigGroup soConfigGroup : (List) fromJson) {
                CpuVariant cpuVariant = soConfigGroup.getVariants().get(d11);
                SoZipInfo soZipInfo = cpuVariant != null ? new SoZipInfo(cpuVariant.getZip_url(), cpuVariant.getMd5(), soConfigGroup.getSo_names(), soConfigGroup.getMethod_name(), soConfigGroup.getInput()) : null;
                if (soZipInfo != null) {
                    arrayList.add(soZipInfo);
                }
            }
            return arrayList;
        } catch (Exception e11) {
            Log.e("SoLoadManagerExample", "解析JSON配置失败: " + e11.getMessage());
            return CollectionsKt.l();
        }
    }

    public final void i(Context context, String str) {
        Intrinsics.h(context, "context");
        if (str != null) {
            try {
                if (!StringsKt.q0(str)) {
                    gz.b.f64159a.b().v("so_load_control_config", str);
                    SoLoadControlConfig soLoadControlConfig = (SoLoadControlConfig) new Gson().fromJson(str, SoLoadControlConfig.class);
                    f60930b = soLoadControlConfig;
                    if (soLoadControlConfig != null && soLoadControlConfig.getExitProcess()) {
                        o.f60988f.a().k(context);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("已保存配置到 MMKV: ");
                        sb2.append(str);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("已保存配置到 MMKV: ");
                    sb3.append(str);
                    return;
                }
            } catch (Exception e11) {
                a.C0856a.k(lg.a.f68962a, "SoLoadManagerExample", "保存配置到 MMKV 失败: " + e11.getMessage(), e11, false, 8, null);
                return;
            }
        }
        f60930b = null;
        gz.b.f64159a.b().M("so_load_control_config");
    }
}
