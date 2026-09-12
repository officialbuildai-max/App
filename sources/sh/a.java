package sh;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.h;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class a extends h {

    /* renamed from: q, reason: collision with root package name */
    private final Float f75473q;

    /* renamed from: r, reason: collision with root package name */
    private final Float f75474r;

    /* renamed from: s, reason: collision with root package name */
    private final DecelerateInterpolator f75475s;

    public a(Context context, Float f11, Float f12) {
        super(context);
        this.f75473q = f11;
        this.f75474r = f12;
        this.f75475s = new DecelerateInterpolator(f12 != null ? f12.floatValue() : 1.0f);
    }

    @Override // androidx.recyclerview.widget.h, androidx.recyclerview.widget.RecyclerView.x
    protected void o(View targetView, RecyclerView.y state, RecyclerView.x.a action) {
        Intrinsics.h(targetView, "targetView");
        Intrinsics.h(state, "state");
        Intrinsics.h(action, "action");
        int t11 = t(targetView, z());
        int u11 = u(targetView, B());
        int w11 = w((int) Math.sqrt((t11 * t11) + (u11 * u11)));
        if (w11 > 0) {
            action.d(-t11, -u11, w11, this.f75475s);
        }
    }

    @Override // androidx.recyclerview.widget.h
    protected float v(DisplayMetrics displayMetrics) {
        Intrinsics.h(displayMetrics, "displayMetrics");
        Float f11 = this.f75473q;
        return (f11 != null ? f11.floatValue() : 25.0f) / displayMetrics.densityDpi;
    }
}
