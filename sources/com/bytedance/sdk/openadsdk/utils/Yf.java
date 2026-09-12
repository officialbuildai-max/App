package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;
import com.bytedance.sdk.openadsdk.AdSlot;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class Yf implements Thread.UncaughtExceptionHandler {
    public static volatile boolean Sj;
    private String TKC;
    private final Thread.UncaughtExceptionHandler sP = Thread.getDefaultUncaughtExceptionHandler();

    private Yf() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        sP();
    }

    public static Yf Sj() {
        return new Yf();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00e9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v14, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.Properties] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Sj(java.lang.Thread r12, java.lang.Throwable r13) {
        /*
            Method dump skipped, instructions count: 249
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.utils.Yf.Sj(java.lang.Thread, java.lang.Throwable):void");
    }

    private void TKC() {
        try {
            Method Sj2 = com.bytedance.sdk.component.utils.ley.Sj("com.bytedance.sdk.openadsdk.TTC2Proxy", "a", Context.class);
            if (Sj2 != null) {
                Sj2.invoke(null, com.bytedance.sdk.openadsdk.core.dNu.Sj());
            }
        } catch (Throwable unused) {
        }
        try {
            Method Sj3 = com.bytedance.sdk.component.utils.ley.Sj("com.bytedance.sdk.openadsdk.TTC3Proxy", "a", Context.class);
            if (Sj3 != null) {
                Sj3.invoke(null, com.bytedance.sdk.openadsdk.core.dNu.Sj());
            }
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.settings.Fmk.gq().Sj();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.Sj.sP.sP.sP();
        } catch (Throwable unused4) {
        }
    }

    private void sP() {
        Context Sj2 = com.bytedance.sdk.openadsdk.core.dNu.Sj();
        if (Sj2 == null) {
            return;
        }
        try {
            File file = new File(Sj2.getFilesDir(), "TTCache");
            file.mkdirs();
            this.TKC = file.getPath();
        } catch (Throwable unused) {
        }
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th2) {
        Sj = true;
        com.bytedance.sdk.component.Dq.uA.sCrashHappened = true;
        com.bytedance.sdk.component.Dq.TKC.EjP.TKC = true;
        boolean z10 = false;
        com.bytedance.sdk.component.Dq.vS.Sj(false);
        try {
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            if (stringWriter2 != null) {
                z10 = stringWriter2.contains(AdSlot.class.getPackage().getName());
            }
        } catch (Throwable unused) {
        }
        if (z10) {
            Sj(thread, th2);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.sP;
        if (uncaughtExceptionHandler == null || uncaughtExceptionHandler == this) {
            return;
        }
        uncaughtExceptionHandler.uncaughtException(thread, th2);
    }
}
