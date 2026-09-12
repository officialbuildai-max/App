package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public static String f19337a = "Volley";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f19338b = Log.isLoggable("Volley", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final String f19339c = l.class.getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: c, reason: collision with root package name */
        public static final boolean f19340c = l.f19338b;

        /* renamed from: a, reason: collision with root package name */
        private final List f19341a = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        private boolean f19342b = false;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.android.volley.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static class C0183a {

            /* renamed from: a, reason: collision with root package name */
            public final String f19343a;

            /* renamed from: b, reason: collision with root package name */
            public final long f19344b;

            /* renamed from: c, reason: collision with root package name */
            public final long f19345c;

            public C0183a(String str, long j11, long j12) {
                this.f19343a = str;
                this.f19344b = j11;
                this.f19345c = j12;
            }
        }

        private long c() {
            if (this.f19341a.size() == 0) {
                return 0L;
            }
            return ((C0183a) this.f19341a.get(r2.size() - 1)).f19345c - ((C0183a) this.f19341a.get(0)).f19345c;
        }

        public synchronized void a(String str, long j11) {
            if (this.f19342b) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.f19341a.add(new C0183a(str, j11, SystemClock.elapsedRealtime()));
        }

        public synchronized void b(String str) {
            this.f19342b = true;
            long c11 = c();
            if (c11 <= 0) {
                return;
            }
            long j11 = ((C0183a) this.f19341a.get(0)).f19345c;
            l.b("(%-4d ms) %s", Long.valueOf(c11), str);
            for (C0183a c0183a : this.f19341a) {
                long j12 = c0183a.f19345c;
                l.b("(+%-4d) [%2d] %s", Long.valueOf(j12 - j11), Long.valueOf(c0183a.f19344b), c0183a.f19343a);
                j11 = j12;
            }
        }

        protected void finalize() {
            if (this.f19342b) {
                return;
            }
            b("Request on the loose");
            l.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    private static String a(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i11 = 2;
        while (true) {
            if (i11 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i11].getClassName().equals(f19339c)) {
                String className = stackTrace[i11].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + "." + stackTrace[i11].getMethodName();
                break;
            }
            i11++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void b(String str, Object... objArr) {
        a(str, objArr);
    }

    public static void c(String str, Object... objArr) {
        Log.e(f19337a, a(str, objArr));
    }

    public static void d(Throwable th2, String str, Object... objArr) {
        Log.e(f19337a, a(str, objArr), th2);
    }

    public static void e(String str, Object... objArr) {
        if (f19338b) {
            Log.v(f19337a, a(str, objArr));
        }
    }

    public static void f(String str, Object... objArr) {
        Log.wtf(f19337a, a(str, objArr));
    }
}
