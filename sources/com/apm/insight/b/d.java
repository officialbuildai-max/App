package com.apm.insight.b;

import android.app.ActivityManager;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.apm.insight.b.h;
import com.apm.insight.l.m;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f19441a = null;

    /* renamed from: b, reason: collision with root package name */
    private static long f19442b = -1;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f19443c;

    /* renamed from: d, reason: collision with root package name */
    private static FileObserver f19444d;

    /* renamed from: e, reason: collision with root package name */
    private static ActivityManager.ProcessErrorStateInfo f19445e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Context context) {
        if (SystemClock.uptimeMillis() - f19442b < 5000) {
            return null;
        }
        try {
            ActivityManager.ProcessErrorStateInfo a11 = com.apm.insight.l.a.a(context);
            if (a11 != null && Process.myPid() == a11.pid) {
                ActivityManager.ProcessErrorStateInfo processErrorStateInfo = f19445e;
                if (processErrorStateInfo != null && String.valueOf(processErrorStateInfo.condition).equals(String.valueOf(a11.condition)) && String.valueOf(processErrorStateInfo.processName).equals(String.valueOf(a11.processName)) && String.valueOf(processErrorStateInfo.pid).equals(String.valueOf(a11.pid)) && String.valueOf(processErrorStateInfo.uid).equals(String.valueOf(a11.uid)) && String.valueOf(processErrorStateInfo.tag).equals(String.valueOf(a11.tag)) && String.valueOf(processErrorStateInfo.shortMsg).equals(String.valueOf(a11.shortMsg)) && String.valueOf(processErrorStateInfo.longMsg).equals(String.valueOf(a11.longMsg))) {
                    return null;
                }
                f19445e = a11;
                f19441a = null;
                f19442b = SystemClock.uptimeMillis();
                f19443c = false;
                if (!com.apm.insight.e.t()) {
                    return "|------------- processErrorStateInfo--------------|\ndisable anr info\n\"-----------------------end----------------------------\"";
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("|------------- processErrorStateInfo--------------|\n");
                sb2.append("condition: " + a11.condition + "\n");
                sb2.append("processName: " + a11.processName + "\n");
                sb2.append("pid: " + a11.pid + "\n");
                sb2.append("uid: " + a11.uid + "\n");
                sb2.append("tag: " + a11.tag + "\n");
                sb2.append("shortMsg : " + a11.shortMsg + "\n");
                sb2.append("longMsg : " + a11.longMsg + "\n");
                sb2.append("-----------------------end----------------------------");
                return sb2.toString();
            }
        } catch (Throwable unused) {
        }
        String str = f19441a;
        if (str == null) {
            return null;
        }
        f19443c = true;
        f19441a = null;
        f19442b = SystemClock.uptimeMillis();
        return str;
    }

    public static JSONObject a() throws JSONException {
        try {
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("thread_number", 1);
            jSONObject.put("mainStackFromTrace", m.a(stackTrace));
            return jSONObject;
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
            return null;
        }
    }

    public static void a(final String str, final h.a aVar) {
        FileObserver fileObserver = f19444d;
        if (fileObserver != null) {
            fileObserver.stopWatching();
        }
        FileObserver fileObserver2 = new FileObserver(str) { // from class: com.apm.insight.b.d.1
            @Override // android.os.FileObserver
            public final void onEvent(int i11, @Nullable String str2) {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    String unused = d.f19441a = aVar.a();
                } catch (Throwable th2) {
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                }
            }
        };
        f19444d = fileObserver2;
        fileObserver2.startWatching();
    }

    public static boolean b() {
        return f19443c;
    }

    public static void c() {
        f19445e = null;
    }
}
