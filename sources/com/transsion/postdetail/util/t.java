package com.transsion.postdetail.util;

import android.app.Activity;
import android.view.Window;

/* loaded from: classes6.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f50233a = new t();

    private t() {
    }

    public final String a(Integer num) {
        int intValue = num != null ? num.intValue() : 0;
        if (1 > intValue || intValue >= 10) {
            return String.valueOf(intValue);
        }
        return "0" + intValue;
    }

    public final void b(Activity activity, boolean z10) {
        Window window = activity != null ? activity.getWindow() : null;
        if (z10) {
            if (window != null) {
                window.addFlags(128);
            }
        } else if (window != null) {
            window.clearFlags(128);
        }
    }
}
