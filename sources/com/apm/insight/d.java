package com.apm.insight;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.apm.insight.MonitorCrash;
import com.apm.insight.k.j;
import com.apm.insight.l.m;
import com.meituan.android.walle.ChannelReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    protected static MonitorCrash f19522a;

    /* renamed from: c, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, d> f19523c = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private MonitorCrash f19524b;

    private d(MonitorCrash monitorCrash) {
        this.f19524b = monitorCrash;
        com.apm.insight.entity.b.a(this);
        com.apm.insight.j.b.c();
        j.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(String str) {
        return f19523c.get(str);
    }

    public static Object a() {
        return f19522a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context, final MonitorCrash monitorCrash) {
        f19522a = monitorCrash;
        d dVar = new d(monitorCrash);
        final com.apm.insight.nativecrash.b a11 = e.a();
        Npth.init(context, new ICommonParams() { // from class: com.apm.insight.d.1
            @Override // com.apm.insight.ICommonParams
            public final Map<String, Object> getCommonParams() {
                JSONObject d11 = d.this.d();
                HashMap hashMap = new HashMap();
                if (d11 != null) {
                    Iterator<String> keys = d11.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, d11.opt(next));
                    }
                }
                return hashMap;
            }

            @Override // com.apm.insight.ICommonParams
            public final String getDeviceId() {
                return TextUtils.isEmpty(monitorCrash.mConfig.mDeviceId) ? a11.d() : monitorCrash.mConfig.mDeviceId;
            }

            @Override // com.apm.insight.ICommonParams
            public final List<String> getPatchInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final Map<String, Integer> getPluginInfo() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final String getSessionId() {
                return null;
            }

            @Override // com.apm.insight.ICommonParams
            public final long getUserId() {
                return 0L;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(MonitorCrash monitorCrash) {
        d dVar = new d(monitorCrash);
        if (monitorCrash.mConfig != null) {
            f19523c.put(monitorCrash.mConfig.mAid, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f19524b.mConfig.mPackageName == null) {
                Context g11 = e.g();
                PackageInfo packageInfo = g11.getPackageManager().getPackageInfo(g11.getPackageName(), 128);
                if (packageInfo != null) {
                    MonitorCrash.Config config = this.f19524b.mConfig;
                    if (config.mVersionInt == -1) {
                        config.mVersionInt = packageInfo.versionCode;
                    }
                    if (config.mVersionStr == null) {
                        config.mVersionStr = packageInfo.versionName;
                    }
                }
            }
        } catch (Throwable unused) {
        }
        if (TextUtils.isEmpty(this.f19524b.mConfig.mDeviceId) || "0".equals(this.f19524b.mConfig.mDeviceId)) {
            this.f19524b.mConfig.mDeviceId = e.c().a();
        }
        try {
            jSONObject.put("aid", String.valueOf(this.f19524b.mConfig.mAid));
            jSONObject.put("update_version_code", this.f19524b.mConfig.mVersionInt);
            jSONObject.put("version_code", this.f19524b.mConfig.mVersionInt);
            jSONObject.put("app_version", this.f19524b.mConfig.mVersionStr);
            jSONObject.put(ChannelReader.CHANNEL_KEY, this.f19524b.mConfig.mChannel);
            jSONObject.put("package", a.a(this.f19524b.mConfig.mPackageName));
            jSONObject.put("device_id", this.f19524b.mConfig.mDeviceId);
            jSONObject.put("user_id", this.f19524b.mConfig.mUID);
            jSONObject.put("ssid", this.f19524b.mConfig.mSSID);
            jSONObject.put("os", "Android");
            jSONObject.put("so_list", a.a(this.f19524b.mConfig.mSoList));
            jSONObject.put("thread_list", a.a(this.f19524b.mConfig.mThreadList));
            jSONObject.put("single_upload", 0);
        } catch (JSONException unused2) {
        }
        return jSONObject;
    }

    @Nullable
    public final JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th2) {
        return a(stackTraceElementArr, th2, null);
    }

    @Nullable
    public final JSONArray a(StackTraceElement[] stackTraceElementArr, Throwable th2, String str) {
        String[] strArr = this.f19524b.mConfig.mPackageName;
        if (strArr == null) {
            return new JSONArray().put(new m.a(0, stackTraceElementArr.length).a());
        }
        if (th2 == null || stackTraceElementArr == null) {
            return null;
        }
        JSONArray a11 = m.a(stackTraceElementArr, strArr);
        if (str != null && this.f19524b.mConfig.mThreadList != null && a.a(a11)) {
            for (String str2 : this.f19524b.mConfig.mThreadList) {
                if (TextUtils.equals(str2, str)) {
                    a11.put(new m.a(0, stackTraceElementArr.length).a());
                }
            }
        }
        return a11;
    }

    public final JSONArray a(String[] strArr) {
        return this.f19524b.config().mPackageName == null ? new JSONArray().put(new m.a(0, strArr.length).a()) : m.a(strArr, this.f19524b.mConfig.mPackageName);
    }

    public final JSONObject a(CrashType crashType, JSONArray jSONArray) {
        Map<? extends String, ? extends String> userData;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("header", d());
            jSONObject.put("line_num", jSONArray);
            if (crashType != null) {
                AttachUserData attachUserData = this.f19524b.mCustomData;
                jSONObject.put("custom", (attachUserData == null || (userData = attachUserData.getUserData(crashType)) == null) ? null : new JSONObject(userData));
                jSONObject.put("filters", new JSONObject(this.f19524b.mTagMap));
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    public final boolean a(Object obj) {
        return this.f19524b == obj;
    }

    public final boolean a(String str, String str2) {
        if (this.f19524b.config().mPackageName == null) {
            return true;
        }
        return com.apm.insight.entity.b.a(str, a.a(this.f19524b.mConfig.mSoList), str2, a.a(this.f19524b.mConfig.mThreadList));
    }

    public final String b() {
        return this.f19524b.mConfig.mAid;
    }

    public final JSONObject c() {
        return d();
    }
}
