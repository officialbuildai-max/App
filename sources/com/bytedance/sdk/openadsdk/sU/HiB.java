package com.bytedance.sdk.openadsdk.sU;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Base64;

/* loaded from: classes3.dex */
public class HiB {
    public static int Dq = 2;
    protected static int EjP = 30;
    protected static long HiB = 15360;
    public static int Jcg = 1;
    protected static String Sj = "images";
    public static int TEQ = 8;
    protected static int TKC = 1;
    public static int Ym = 16;

    /* renamed from: aa, reason: collision with root package name */
    public static int f21203aa = 32;
    protected static String sP = null;
    public static int uA = 4;
    public static int vS;

    /* JADX INFO: Access modifiers changed from: protected */
    public static Bitmap Sj(String str) {
        byte[] decode = Base64.decode(str, 2);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static boolean Sj(Context context) {
        boolean z10;
        boolean z11;
        if (Build.VERSION.SDK_INT >= 33) {
            z10 = context.checkSelfPermission("android.permission.READ_MEDIA_IMAGES") == 0;
        } else {
            z10 = context.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0;
            if (context.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
                z11 = false;
                return !z11 && z10;
            }
        }
        z11 = true;
        if (z11) {
        }
    }

    public static boolean Sj(Context context, int i11) {
        boolean Sj2;
        boolean Sj3;
        if (vS == 0) {
            if (Build.VERSION.SDK_INT >= 33) {
                Sj2 = Sj(context, "android.permission.READ_MEDIA_IMAGES");
                Sj3 = true;
            } else {
                Sj2 = Sj(context, "android.permission.READ_EXTERNAL_STORAGE");
                Sj3 = Sj(context, "android.permission.WRITE_EXTERNAL_STORAGE");
            }
            boolean Sj4 = Sj(context, "android.permission.CAMERA");
            boolean Sj5 = Sj(context, "android.permission.RECORD_AUDIO");
            PackageManager packageManager = context.getPackageManager();
            if (Sj2 && Sj3) {
                vS |= Jcg;
            }
            if (Sj4 && packageManager.hasSystemFeature("android.hardware.camera")) {
                vS |= Dq;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.gyroscope")) {
                vS |= uA;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                vS |= TEQ;
            }
            if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                vS |= Ym;
            }
            if (Sj5 && packageManager.hasSystemFeature("android.hardware.microphone")) {
                vS |= f21203aa;
            }
        }
        return (vS & i11) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean Sj(Context context, String str) {
        return false;
    }

    public static float sP(Context context) {
        if (context == null) {
            return 0.0f;
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean sP(Context context, String str) {
        return context.checkSelfPermission(str) == 0;
    }
}
