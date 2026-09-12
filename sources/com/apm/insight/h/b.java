package com.apm.insight.h;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.apm.insight.e;
import com.apm.insight.l.f;
import com.apm.insight.l.j;
import com.apm.insight.nativecrash.NativeImpl;
import com.apm.insight.runtime.m;
import com.apm.insight.runtime.n;
import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f19631a;

    /* renamed from: b, reason: collision with root package name */
    private Map<String, String> f19632b;

    public b(File file) {
        String a11;
        File c11 = j.c(file);
        if (!c11.exists() || c11.length() == 0 || (a11 = NativeImpl.a(c11.getAbsolutePath())) == null) {
            return;
        }
        String[] split = a11.split("\n");
        this.f19632b = new HashMap();
        for (String str : split) {
            String[] split2 = str.split(UrlUtils.EQUAL_MARK);
            if (split2.length == 2) {
                this.f19632b.put(split2[0], split2[1]);
            }
        }
    }

    public static String a() {
        return e.g().getFilesDir() + "/apminsight/selflib/";
    }

    public static String a(String str) {
        return e.g().getFilesDir() + "/apminsight/selflib/lib" + str + ".so";
    }

    static /* synthetic */ void b() {
        if (f19631a == null) {
            f19631a = new HashMap<>();
            File file = new File(e.g().getFilesDir(), "/apminsight/selflib/");
            String[] list = file.list();
            if (list != null) {
                for (String str : list) {
                    if (str.endsWith(".ver")) {
                        try {
                            f19631a.put(str.substring(0, str.length() - 4), f.a(file.getAbsolutePath() + "/" + str, "\n"));
                        } catch (Throwable th2) {
                            com.apm.insight.c.a();
                            com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                        }
                    } else if (!str.endsWith(".so")) {
                        f.a(new File(file, str));
                    }
                }
            }
        }
    }

    public static void b(final String str) {
        m.a().a(new Runnable() { // from class: com.apm.insight.h.b.1

            /* renamed from: a, reason: collision with root package name */
            private boolean f19633a = false;

            @Override // java.lang.Runnable
            public final void run() {
                String str2;
                b.b();
                if (b.c(str)) {
                    return;
                }
                n.a("updateSo", str);
                File file = new File(b.a(str));
                file.getParentFile().mkdirs();
                if (file.exists()) {
                    file.delete();
                }
                String str3 = "doUnpackLibrary: " + str;
                if (e.i().isDebugMode()) {
                    Log.w("npth", str3);
                }
                try {
                    str2 = c.a(e.g(), str, file);
                } catch (Throwable th2) {
                    n.a("updateSoError", str);
                    com.apm.insight.c.a();
                    com.apm.insight.runtime.j.a(th2, "NPTH_CATCH");
                    str2 = null;
                }
                if (str2 != null) {
                    if (this.f19633a) {
                        n.a("updateSoFailed", str);
                        return;
                    }
                    this.f19633a = true;
                    n.a("updateSoPostRetry", str);
                    m.a().a(this, 3000L);
                    return;
                }
                b.f19631a.put(file.getName(), "2008-20250701130429");
                try {
                    f.a(new File(e.g().getFilesDir() + "/apminsight/selflib/" + str + ".ver"), "2008-20250701130429", false);
                } catch (Throwable unused) {
                }
                n.a("updateSoSuccess", str);
            }
        });
    }

    static /* synthetic */ boolean c(String str) {
        return "2008-20250701130429".equals(f19631a.get(str)) && new File(a(str)).exists();
    }

    public final boolean d() {
        Map<String, String> map = this.f19632b;
        return (map == null || map.isEmpty() || TextUtils.isEmpty(this.f19632b.get("process_name")) || TextUtils.isEmpty(this.f19632b.get("crash_thread_name")) || TextUtils.isEmpty(this.f19632b.get("pid")) || TextUtils.isEmpty(this.f19632b.get("tid")) || TextUtils.isEmpty(this.f19632b.get("start_time")) || TextUtils.isEmpty(this.f19632b.get("crash_time")) || TextUtils.isEmpty(this.f19632b.get("signal_line"))) ? false : true;
    }

    @Nullable
    public final String e() {
        return this.f19632b.get("signal_line");
    }

    public final Map<String, String> f() {
        return this.f19632b;
    }
}
