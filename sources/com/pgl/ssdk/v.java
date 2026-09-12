package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.camera2.CameraManager;
import android.telephony.TelephonyManager;

/* loaded from: classes5.dex */
public class v {

    /* renamed from: a, reason: collision with root package name */
    public static int f40269a = -1;

    /* renamed from: b, reason: collision with root package name */
    public static int f40270b = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            v.f40270b = v.b(x.b());
            SharedPreferences a11 = u0.a(x.b());
            if (a11 != null) {
                a11.edit().putInt("camera_count", v.f40270b).apply();
            }
        }
    }

    public static int a() {
        int i11;
        int i12 = f40270b;
        if (i12 != -1) {
            return i12;
        }
        SharedPreferences a11 = u0.a(x.b());
        if (a11 == null || (i11 = a11.getInt("camera_count", -1)) == -1) {
            o0.b(new a());
            return -1;
        }
        f40270b = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(Context context) {
        int i11 = f40270b;
        if (i11 != -1) {
            return i11;
        }
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                f40270b = cameraManager.getCameraIdList().length;
            } catch (Throwable unused) {
                f40270b = -1;
            }
        } else {
            f40270b = -2;
        }
        return f40270b;
    }

    public static int c(Context context) {
        TelephonyManager telephonyManager;
        if (f40269a == -1 && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
            f40269a = telephonyManager.getSimState();
        }
        return f40269a;
    }
}
