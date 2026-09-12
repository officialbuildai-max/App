package com.pgl.ssdk;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.view.Display;

/* loaded from: classes5.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    private static volatile DisplayManager.DisplayListener f40285a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f40286b;

    /* renamed from: c, reason: collision with root package name */
    private static String f40287c;

    /* renamed from: d, reason: collision with root package name */
    private static String f40288d;

    /* renamed from: e, reason: collision with root package name */
    private static String f40289e;

    /* renamed from: f, reason: collision with root package name */
    private static DisplayManager f40290f;

    /* loaded from: classes5.dex */
    static class a implements DisplayManager.DisplayListener {
        a() {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i11) {
            y.b(i11, 1);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i11) {
            y.b(i11, 3);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i11) {
            y.b(i11, 2);
        }
    }

    private static String a(int i11) {
        Display display = f40290f.getDisplay(i11);
        return display != null ? a(display) : "pd";
    }

    public static String a(Context context) {
        Display[] displays;
        if (f40290f == null) {
            f40290f = (DisplayManager) context.getSystemService("display");
        }
        DisplayManager displayManager = f40290f;
        if (displayManager == null || (displays = displayManager.getDisplays()) == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < displays.length; i11++) {
            Display display = displays[i11];
            if (display != null && display.getDisplayId() != 0) {
                stringBuffer.append(a(displays[i11]));
                if (i11 != displays.length - 1) {
                    stringBuffer.append(",");
                }
            }
        }
        return stringBuffer.toString();
    }

    private static String a(Display display) {
        String name = display.getName();
        Object a11 = s0.a(display, display.getClass(), "getType", new Class[0], new Object[0]);
        Object a12 = s0.a(display, display.getClass(), "getOwnerPackageName", new Class[0], new Object[0]);
        Object a13 = s0.a(null, display.getClass(), "TYPE_VIRTUAL", null);
        return String.format("%s#%s#%b", a12, name, Boolean.valueOf((a11 == null || a13 == null || ((Integer) a11).intValue() != ((Integer) a13).intValue()) ? false : true));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i11, int i12) {
        if (i11 == 0) {
            return;
        }
        try {
            String a11 = a(i11);
            if (i12 == 1) {
                if (a11.equals(f40287c)) {
                    return;
                }
                f40287c = a11;
            } else if (i12 == 2) {
                if (a11.equals(f40288d)) {
                    return;
                }
                f40288d = a11;
            } else {
                if (i12 != 3 || a11.equals(f40289e)) {
                    return;
                }
                f40289e = a11;
            }
        } catch (Throwable unused) {
        }
    }

    public static boolean b(Context context) {
        if (f40287c == null && f40288d == null && f40289e == null) {
            return (context == null || TextUtils.isEmpty(a(context))) ? false : true;
        }
        return true;
    }

    public static void c(Context context) {
        Handler b11;
        if (f40286b) {
            return;
        }
        f40286b = true;
        if (f40285a == null) {
            f40285a = new a();
        }
        if (f40290f == null) {
            f40290f = (DisplayManager) context.getSystemService("display");
        }
        if (f40290f == null || (b11 = o0.b()) == null) {
            return;
        }
        try {
            f40290f.registerDisplayListener(f40285a, b11);
        } catch (Exception unused) {
        }
    }
}
