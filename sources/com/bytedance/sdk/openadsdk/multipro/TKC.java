package com.bytedance.sdk.openadsdk.multipro;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.dx;
import com.bytedance.sdk.component.utils.sU;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class TKC {
    private static boolean Sj = true;
    private static final AtomicBoolean sP = new AtomicBoolean(false);

    public static void Sj() {
        Sj = false;
    }

    public static void Sj(Context context) {
        if (context != null && Sj && sP.compareAndSet(false, true)) {
            try {
                if (Build.VERSION.SDK_INT >= 28) {
                    if (dx.Sj(context)) {
                        sP(context);
                        return;
                    }
                    String sP2 = dx.sP(context);
                    try {
                        if (TextUtils.isEmpty(sP2)) {
                            sP2 = context.getPackageName() + Process.myPid();
                        }
                        WebView.setDataDirectorySuffix(sP2);
                    } catch (IllegalStateException unused) {
                        Sj(sP2);
                    } catch (Exception unused2) {
                    }
                }
            } catch (Throwable th2) {
                sU.sP(th2.getMessage(), new Object[0]);
            }
        }
    }

    private static void Sj(File file) {
        Sj(file, file.exists() ? file.delete() : false);
    }

    private static void Sj(File file, boolean z10) {
        if (!z10 || file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (IOException e11) {
            sU.sP("TTAD.TTMultiInitHelper", e11.getMessage());
        }
    }

    private static void Sj(String str) {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            Field field = (Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix");
            field.setAccessible(true);
            if (TextUtils.isEmpty((String) field.get(cls))) {
                field.set(cls, str);
            }
        } catch (Throwable unused) {
        }
    }

    private static String sP() {
        try {
            Method declaredMethod = Class.class.getDeclaredMethod("forName", String.class);
            Method declaredMethod2 = Class.class.getDeclaredMethod("getDeclaredField", String.class);
            declaredMethod2.setAccessible(true);
            Class cls = (Class) declaredMethod.invoke(null, "android.webkit.WebViewFactory");
            return (String) ((Field) declaredMethod2.invoke(cls, "sDataDirectorySuffix")).get(cls);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:54:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0087 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void sP(android.content.Context r3) {
        /*
            java.lang.String r0 = sP()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto Ld
            java.lang.String r0 = "webview"
            goto L17
        Ld:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "webview_"
            java.lang.String r0 = r1.concat(r0)
        L17:
            r1 = 0
            java.io.File r3 = r3.getDir(r0, r1)
            java.lang.String r3 = r3.getPath()
            java.io.File r0 = new java.io.File
            java.lang.String r1 = "webview_data.lock"
            r0.<init>(r3, r1)
            r0.getAbsolutePath()
            boolean r3 = r0.exists()
            if (r3 != 0) goto L31
            return
        L31:
            r3 = 0
            java.io.RandomAccessFile r1 = new java.io.RandomAccessFile     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6c
            java.lang.String r2 = "rw"
            r1.<init>(r0, r2)     // Catch: java.lang.Throwable -> L68 java.lang.Exception -> L6c
            java.nio.channels.FileChannel r2 = r1.getChannel()     // Catch: java.lang.Throwable -> L64 java.lang.Exception -> L6d
            if (r2 == 0) goto L46
            java.nio.channels.FileLock r3 = r2.tryLock()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L62
            goto L46
        L44:
            r3 = move-exception
            goto L85
        L46:
            if (r3 == 0) goto L4c
            r3.close()     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L62
            goto L4f
        L4c:
            Sj(r0)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L62
        L4f:
            if (r2 == 0) goto L59
            r2.close()     // Catch: java.lang.Throwable -> L55
            goto L59
        L55:
            r3 = move-exception
            r3.getMessage()
        L59:
            r1.close()     // Catch: java.lang.Throwable -> L5d
            return
        L5d:
            r3 = move-exception
            r3.getMessage()
            return
        L62:
            r3 = r2
            goto L6d
        L64:
            r0 = move-exception
            r2 = r3
        L66:
            r3 = r0
            goto L85
        L68:
            r0 = move-exception
            r1 = r3
            r2 = r1
            goto L66
        L6c:
            r1 = r3
        L6d:
            Sj(r0)     // Catch: java.lang.Throwable -> L64
            if (r3 == 0) goto L7a
            r3.close()     // Catch: java.lang.Throwable -> L76
            goto L7a
        L76:
            r3 = move-exception
            r3.getMessage()
        L7a:
            if (r1 == 0) goto L84
            r1.close()     // Catch: java.lang.Throwable -> L80
            return
        L80:
            r3 = move-exception
            r3.getMessage()
        L84:
            return
        L85:
            if (r2 == 0) goto L8f
            r2.close()     // Catch: java.lang.Throwable -> L8b
            goto L8f
        L8b:
            r0 = move-exception
            r0.getMessage()
        L8f:
            if (r1 == 0) goto L99
            r1.close()     // Catch: java.lang.Throwable -> L95
            goto L99
        L95:
            r0 = move-exception
            r0.getMessage()
        L99:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.multipro.TKC.sP(android.content.Context):void");
    }
}
