package com.pgl.ssdk.ces;

import android.content.Context;

/* loaded from: classes5.dex */
public final class a {
    public static native Object meta(int i11, Context context, Object obj);

    public static Object njss(int i11, Object obj) {
        try {
            b h11 = b.h();
            if (h11 != null) {
                return h11.a(i11, obj);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }
}
