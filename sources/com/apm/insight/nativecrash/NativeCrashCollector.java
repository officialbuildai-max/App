package com.apm.insight.nativecrash;

import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.apm.insight.CrashType;
import com.apm.insight.ICrashCallback;
import com.apm.insight.Npth;
import com.apm.insight.e;
import com.apm.insight.l.m;
import com.apm.insight.runtime.a.c;
import com.apm.insight.runtime.a.f;
import com.apm.insight.runtime.j;
import com.apm.insight.runtime.l;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class NativeCrashCollector {
    public static int a() {
        return 6;
    }

    private static void a(String str, String str2, String str3) {
        for (ICrashCallback iCrashCallback : l.a().d()) {
            try {
                if (iCrashCallback instanceof com.apm.insight.b) {
                    ((com.apm.insight.b) iCrashCallback).a(CrashType.NATIVE, str, str3, str2);
                } else {
                    iCrashCallback.onCrash(CrashType.NATIVE, str, null);
                }
            } catch (Throwable th2) {
                com.apm.insight.c.a();
                j.a(th2, "NPTH_CATCH");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if ("main".equalsIgnoreCase(str)) {
            return m.a(Looper.getMainLooper().getThread().getStackTrace());
        }
        ThreadGroup threadGroup = Looper.getMainLooper().getThread().getThreadGroup();
        int activeCount = threadGroup.activeCount();
        Thread[] threadArr = new Thread[activeCount + (activeCount / 2)];
        int enumerate = threadGroup.enumerate(threadArr);
        for (int i11 = 0; i11 < enumerate; i11++) {
            String name = threadArr[i11].getName();
            if (!TextUtils.isEmpty(name) && (name.equals(str) || name.startsWith(str) || name.endsWith(str))) {
                return m.a(threadArr[i11].getStackTrace());
            }
        }
        try {
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                String name2 = entry.getKey().getName();
                if (!name2.equals(str) && !name2.startsWith(str) && !name2.endsWith(str)) {
                }
                return m.a(entry.getValue());
            }
        } catch (Throwable th2) {
            com.apm.insight.c.a();
            j.a(th2, "NPTH_CATCH");
        }
        return "";
    }

    @Keep
    public static void onNativeCrash(final String str) {
        final long currentTimeMillis = System.currentTimeMillis();
        com.apm.insight.a.a((Object) "[onNativeCrash] enter");
        try {
            com.apm.insight.k.b.a().b();
            final File e11 = com.apm.insight.l.j.e(new File(com.apm.insight.l.j.a(), e.f()));
            com.apm.insight.entity.a a11 = f.a().a(CrashType.NATIVE, new c.a() { // from class: com.apm.insight.nativecrash.NativeCrashCollector.1
                @Override // com.apm.insight.runtime.a.c.a
                public final com.apm.insight.entity.a a(int i11, com.apm.insight.entity.a aVar) {
                    if (i11 == 1) {
                        String str2 = str;
                        if (str2 != null && str2.length() != 0) {
                            aVar.a("java_data", (Object) NativeCrashCollector.b(str));
                        }
                        aVar.a("crash_after_crash", Npth.hasCrashWhenNativeCrash() ? "true" : "false");
                    } else if (i11 == 2) {
                        if (e.x()) {
                            JSONArray b11 = com.apm.insight.b.f.b().b();
                            long uptimeMillis = SystemClock.uptimeMillis();
                            JSONObject a12 = com.apm.insight.b.f.b().a(uptimeMillis).a();
                            JSONArray a13 = com.apm.insight.b.j.a(uptimeMillis);
                            aVar.a("history_message", (Object) b11);
                            aVar.a("current_message", a12);
                            aVar.a("pending_messages", (Object) a13);
                        }
                        aVar.a("disable_looper_monitor", String.valueOf(com.apm.insight.runtime.a.c()));
                        aVar.a("npth_force_apm_crash", String.valueOf(com.apm.insight.c.a.a()));
                    } else if (i11 != 3) {
                        if (i11 == 4) {
                            com.apm.insight.l.a.a(e.g(), aVar.c());
                        }
                    } else if (com.apm.insight.runtime.a.d()) {
                        aVar.a("all_thread_stacks", m.b(str));
                        aVar.a("has_all_thread_stack", "true");
                    }
                    return aVar;
                }

                @Override // com.apm.insight.runtime.a.c.a
                public final com.apm.insight.entity.a b(int i11, com.apm.insight.entity.a aVar) {
                    try {
                        JSONObject c11 = aVar.c();
                        if (c11.length() > 0) {
                            com.apm.insight.l.f.a(new File(e11.getAbsolutePath() + '.' + i11), c11);
                        }
                    } catch (IOException e12) {
                        com.apm.insight.c.a();
                        j.a(e12, "NPTH_CATCH");
                    }
                    if (i11 == 0) {
                        com.apm.insight.a.a.a();
                        com.apm.insight.a.a.a();
                        CrashType crashType = CrashType.LAUNCH;
                        e.f();
                    }
                    return aVar;
                }
            });
            JSONObject c11 = a11.c();
            if (c11 != null && c11.length() != 0) {
                long currentTimeMillis2 = System.currentTimeMillis();
                long j11 = currentTimeMillis2 - currentTimeMillis;
                try {
                    c11.put("java_end", currentTimeMillis2);
                    a11.b("crash_cost", String.valueOf(j11));
                    a11.a("crash_cost", String.valueOf(j11 / 1000));
                } catch (Throwable unused) {
                }
                File file = new File(e11.getAbsolutePath() + ".tmp");
                com.apm.insight.l.f.a(file, c11);
                file.renameTo(e11);
            }
        } catch (Throwable th2) {
            try {
                com.apm.insight.c.a();
                j.a(th2, "NPTH_CATCH");
                try {
                    if (l.a().d().isEmpty()) {
                        return;
                    }
                    File file2 = new File(com.apm.insight.l.j.a(), e.f());
                    c cVar = new c(file2);
                    cVar.b(file2);
                    a(cVar.c(), cVar.a(), str);
                } catch (Throwable unused2) {
                    a("", null, str);
                }
            } finally {
                try {
                    if (!l.a().d().isEmpty()) {
                        File file3 = new File(com.apm.insight.l.j.a(), e.f());
                        c cVar2 = new c(file3);
                        cVar2.b(file3);
                        a(cVar2.c(), cVar2.a(), str);
                    }
                } catch (Throwable unused3) {
                    a("", null, str);
                }
            }
        }
    }
}
