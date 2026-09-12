package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: classes5.dex */
public class e {
    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        try {
            Resources resources = context.getResources();
            return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android")) > 0;
        } catch (Throwable th2) {
            o0.b("DomainSameTool", th2.getMessage(), th2);
            return false;
        }
    }
}
