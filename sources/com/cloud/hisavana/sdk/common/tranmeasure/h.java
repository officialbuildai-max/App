package com.cloud.hisavana.sdk.common.tranmeasure;

import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.cloud.hisavana.sdk.d5;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.h5;
import com.cloud.hisavana.sdk.i5;

/* loaded from: classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    protected final Rect f22218a = new Rect();

    /* renamed from: b, reason: collision with root package name */
    protected String f22219b = "";

    /* JADX INFO: Access modifiers changed from: protected */
    public static h b(d5 d5Var) {
        if (d5Var == null) {
            return null;
        }
        if (d5Var.f22456a > 0.0f) {
            return new h5();
        }
        if (d5Var.f22457b > 0) {
            return new i5();
        }
        return null;
    }

    private boolean c(View view) {
        if (view != null) {
            try {
                if (view.getParent() != null) {
                    ViewParent parent = view.getParent();
                    while (parent instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) parent;
                        if (viewGroup.getVisibility() != 0) {
                            return true;
                        }
                        parent = viewGroup.getParent();
                    }
                }
            } catch (Throwable th2) {
                e4.b().w("ssp", Log.getStackTraceString(th2));
            }
        }
        return false;
    }

    private boolean e(View view) {
        return (view == null || view.getVisibility() != 0 || view.getAlpha() == 0.0f || !view.isAttachedToWindow() || view.getRootView() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int a(d5 d5Var, View view) {
        int d11;
        if (!e(view) || d5Var == null || (d11 = d(d5Var, view)) == 0 || c(view)) {
            return 0;
        }
        return d11;
    }

    protected abstract int d(d5 d5Var, View view);
}
