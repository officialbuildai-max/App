package com.mbridge.msdk.foundation.tools;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class c1 {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f35752a = new AtomicInteger(1);

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static void a(Window window) {
        if (window != null) {
            try {
                int i11 = Build.VERSION.SDK_INT;
                if (i11 >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    if (i11 >= 30) {
                        attributes.layoutInDisplayCutoutMode = 3;
                    } else {
                        attributes.layoutInDisplayCutoutMode = 1;
                    }
                    window.setAttributes(attributes);
                }
            } catch (Throwable th2) {
                o0.b("ViewUtil", th2.getMessage());
            }
        }
    }
}
