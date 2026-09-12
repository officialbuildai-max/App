package com.facebook.biddingkit.logging;

import android.os.Process;
import android.text.TextUtils;
import java.lang.Thread;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class c implements Thread.UncaughtExceptionHandler {

    /* renamed from: a, reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f24176a;

    public c(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f24176a = uncaughtExceptionHandler;
    }

    private void a(Thread thread, Throwable th2) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f24176a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        } else {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b() {
        Thread.setDefaultUncaughtExceptionHandler(new c(Thread.getDefaultUncaughtExceptionHandler()));
    }

    private static void c() {
        try {
            Process.killProcess(Process.myPid());
        } catch (Throwable unused) {
        }
        try {
            System.exit(10);
        } catch (Throwable unused2) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        try {
            String a11 = g.a(th2);
            if (!TextUtils.isEmpty(a11) && a11.contains("com.facebook.biddingkit")) {
                b.c("CrashReportHandler", a11);
            }
        } catch (Exception unused) {
        }
        a(thread, th2);
    }
}
