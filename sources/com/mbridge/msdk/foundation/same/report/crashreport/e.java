package com.mbridge.msdk.foundation.same.report.crashreport;

import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.o0;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class e implements Thread.UncaughtExceptionHandler {

    /* renamed from: d, reason: collision with root package name */
    private static volatile e f35591d;

    /* renamed from: a, reason: collision with root package name */
    private final String f35592a = "CrashHandlerUtil";

    /* renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f35593b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakReference<Context> f35594c;

    private e(Context context) {
        this.f35594c = new WeakReference<>(context);
    }

    public static e a(Context context) {
        if (f35591d == null) {
            synchronized (e.class) {
                try {
                    if (f35591d == null) {
                        f35591d = new e(context);
                    }
                } finally {
                }
            }
        }
        return f35591d;
    }

    private void a(Thread thread, Throwable th2) {
        try {
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f35593b;
            if (uncaughtExceptionHandler == null) {
                Process.killProcess(Process.myPid());
                System.exit(1);
            } else if (!(uncaughtExceptionHandler instanceof e)) {
                uncaughtExceptionHandler.uncaughtException(thread, th2);
            }
        } catch (Throwable th3) {
            o0.b("CrashHandlerUtil", th3.getMessage());
        }
    }

    private boolean a(List<String> list, String str) {
        if (list != null && !list.isEmpty() && !TextUtils.isEmpty(str)) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (str.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void b(Thread thread, Throwable th2) {
        try {
            List<String> a11 = b.a();
            StackTraceElement[] stackTrace = th2.getStackTrace();
            StringBuilder sb2 = new StringBuilder();
            String str = th2.getClass() + ": " + th2.getMessage();
            sb2.append(str);
            sb2.append("\n");
            boolean a12 = a(a11, str);
            int i11 = 0;
            for (int i12 = 0; i12 < stackTrace.length; i12++) {
                String stackTraceElement = stackTrace[i12].toString();
                if (a(a11, stackTraceElement)) {
                    a12 = true;
                    if (i12 == 0) {
                        i11 = 1;
                    }
                }
                sb2.append(stackTraceElement);
                sb2.append("\n");
            }
            if (a12 && sb2.length() >= 1) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("key", "2000052");
                jSONObject.put("crash_first_index_from_mtg", i11);
                JSONObject a13 = a(String.valueOf(System.currentTimeMillis()));
                a13.put("crashinfo", sb2.toString());
                jSONObject.put("exception", a13);
                if (jSONObject.length() > 0) {
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(jSONObject);
                }
                try {
                    Thread.sleep(500L);
                    return;
                } catch (InterruptedException e11) {
                    o0.b("CrashHandlerUtil", e11.getMessage());
                    return;
                }
            }
            a(thread, th2);
        } catch (Throwable th3) {
            a(thread, th2);
            o0.b("CrashHandlerUtil", th3.getMessage());
        }
    }

    public JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.f35594c.get() == null) {
                return jSONObject;
            }
            jSONObject.put("max_memory", String.valueOf((float) ((Runtime.getRuntime().maxMemory() * 1.0d) / 1048576.0d)));
            jSONObject.put("memoryby_app", String.valueOf((float) ((Runtime.getRuntime().totalMemory() * 1.0d) / 1048576.0d)));
            jSONObject.put("remaining_memory", (float) ((Runtime.getRuntime().freeMemory() * 1.0d) / 1048576.0d));
            jSONObject.put("crashtime", str);
            return jSONObject;
        } catch (Throwable th2) {
            o0.b("CrashHandlerUtil", th2.getMessage());
            return jSONObject;
        }
    }

    public void a() {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.f35593b = defaultUncaughtExceptionHandler;
        if (defaultUncaughtExceptionHandler instanceof e) {
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        if (th2 != null) {
            try {
                b(thread, th2);
            } catch (Throwable th3) {
                o0.b("CrashHandlerUtil", th3.getMessage());
            }
        }
        a(thread, th2);
    }
}
