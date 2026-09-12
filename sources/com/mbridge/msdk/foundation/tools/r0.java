package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes5.dex */
public class r0 {

    /* renamed from: a, reason: collision with root package name */
    static String f35856a = "";

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f35857b = false;

    /* renamed from: c, reason: collision with root package name */
    private static int f35858c = -1;

    /* renamed from: d, reason: collision with root package name */
    private static int f35859d = -1;

    /* renamed from: e, reason: collision with root package name */
    private static long f35860e;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            r0.b();
        }
    }

    public static int a() {
        if (System.currentTimeMillis() - f35860e > 1800000) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a());
        }
        return f35858c;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f35857b) {
                return;
            }
            f35857b = true;
            File externalFilesDir = context.getExternalFilesDir(null);
            if (externalFilesDir != null) {
                f35856a = externalFilesDir.getAbsolutePath();
            }
            try {
                b(context);
            } catch (Exception unused) {
                b(context);
            }
        } catch (Exception e11) {
            o0.b("SameSDCardTool", e11.getMessage());
        }
    }

    public static void b() {
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            long blockSize = statFs.getBlockSize();
            long availableBlocks = statFs.getAvailableBlocks();
            f35859d = Long.valueOf(((statFs.getBlockCount() * blockSize) / 1000) / 1000).intValue();
            f35858c = Long.valueOf(((availableBlocks * blockSize) / 1000) / 1000).intValue();
            f35860e = System.currentTimeMillis();
        } catch (Exception e11) {
            o0.b("SameSDCardTool", e11.getMessage());
        }
    }

    private static void b(Context context) {
        File externalFilesDir;
        if (TextUtils.isEmpty(f35856a) && (externalFilesDir = context.getExternalFilesDir(null)) != null) {
            f35856a = externalFilesDir.getAbsolutePath();
        }
        if (!TextUtils.isEmpty(f35856a)) {
            com.mbridge.msdk.foundation.same.directory.e.a(new com.mbridge.msdk.foundation.same.directory.d(f35856a));
            com.mbridge.msdk.foundation.same.directory.e.b().a();
        }
        b();
    }

    public static int c() {
        return f35859d;
    }
}
