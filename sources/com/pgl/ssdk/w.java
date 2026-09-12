package com.pgl.ssdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.input.InputManager;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class w {

    /* renamed from: a, reason: collision with root package name */
    private static int f40271a;

    /* renamed from: b, reason: collision with root package name */
    private static int f40272b;

    /* renamed from: c, reason: collision with root package name */
    private static int f40273c;

    /* renamed from: d, reason: collision with root package name */
    private static int f40274d;

    /* renamed from: e, reason: collision with root package name */
    private static int f40275e;

    /* renamed from: f, reason: collision with root package name */
    private static int f40276f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f40277g;

    /* renamed from: h, reason: collision with root package name */
    private static InputManager f40278h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f40279a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f40280b;

        a(Context context, int i11) {
            this.f40279a = context;
            this.f40280b = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean isExternal;
            InputManager b11 = w.b(this.f40279a);
            if (b11 == null) {
                return;
            }
            InputDevice inputDevice = b11.getInputDevice(this.f40280b);
            w.h();
            if (inputDevice == null) {
                w.b();
                w.c();
                w.c("nihc");
            } else if (inputDevice.isVirtual()) {
                w.d();
                w.e();
                w.c("vihc");
            } else if (Build.VERSION.SDK_INT >= 29) {
                isExternal = inputDevice.isExternal();
                if (isExternal) {
                    w.f();
                    w.g();
                    w.c("eihc");
                }
            }
        }
    }

    public static void a(MotionEvent motionEvent, Context context) {
        if (motionEvent == null || context == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            o0.b(new a(context, motionEvent.getDeviceId()));
        }
    }

    public static void a(JSONObject jSONObject) {
        h();
        try {
            jSONObject.put("vihc", f40274d);
            jSONObject.put("eihc", f40275e);
            jSONObject.put("nihc", f40276f);
            jSONObject.put("vic", f40271a);
            jSONObject.put("nic", f40273c);
            jSONObject.put("eic", f40272b);
        } catch (JSONException unused) {
        }
    }

    static /* synthetic */ int b() {
        int i11 = f40273c;
        f40273c = i11 + 1;
        return i11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int b(String str) {
        char c11;
        h();
        str.hashCode();
        switch (str.hashCode()) {
            case 100415:
                if (str.equals("eic")) {
                    c11 = 0;
                    break;
                }
                c11 = 65535;
                break;
            case 109064:
                if (str.equals("nic")) {
                    c11 = 1;
                    break;
                }
                c11 = 65535;
                break;
            case 116752:
                if (str.equals("vic")) {
                    c11 = 2;
                    break;
                }
                c11 = 65535;
                break;
            case 3113119:
                if (str.equals("eihc")) {
                    c11 = 3;
                    break;
                }
                c11 = 65535;
                break;
            case 3381238:
                if (str.equals("nihc")) {
                    c11 = 4;
                    break;
                }
                c11 = 65535;
                break;
            case 3619566:
                if (str.equals("vihc")) {
                    c11 = 5;
                    break;
                }
                c11 = 65535;
                break;
            default:
                c11 = 65535;
                break;
        }
        switch (c11) {
            case 0:
                return f40272b;
            case 1:
                return f40273c;
            case 2:
                return f40271a;
            case 3:
                return f40275e;
            case 4:
                return f40276f;
            case 5:
                return f40274d;
            default:
                return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static InputManager b(Context context) {
        if (f40278h == null) {
            f40278h = (InputManager) context.getSystemService("input");
        }
        return f40278h;
    }

    static /* synthetic */ int c() {
        int i11 = f40276f;
        f40276f = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(String str) {
        try {
            SharedPreferences a11 = u0.a(x.b());
            if (a11 != null) {
                a11.edit().putInt(str, a11.getInt(str, 0) + 1).apply();
            }
        } catch (Throwable unused) {
        }
    }

    static /* synthetic */ int d() {
        int i11 = f40271a;
        f40271a = i11 + 1;
        return i11;
    }

    static /* synthetic */ int e() {
        int i11 = f40274d;
        f40274d = i11 + 1;
        return i11;
    }

    static /* synthetic */ int f() {
        int i11 = f40272b;
        f40272b = i11 + 1;
        return i11;
    }

    static /* synthetic */ int g() {
        int i11 = f40275e;
        f40275e = i11 + 1;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h() {
        if (f40277g) {
            return;
        }
        try {
            SharedPreferences a11 = u0.a(x.b());
            if (a11 != null) {
                f40276f = a11.getInt("nihc", 0);
                f40275e = a11.getInt("eihc", 0);
                f40274d = a11.getInt("vihc", 0);
                f40277g = true;
            }
        } catch (Throwable unused) {
        }
    }
}
