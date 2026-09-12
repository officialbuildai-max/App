package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsAnimationCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
class e extends WindowInsetsAnimationCompat.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final View f28529a;

    /* renamed from: b, reason: collision with root package name */
    private int f28530b;

    /* renamed from: c, reason: collision with root package name */
    private int f28531c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f28532d;

    public e(View view) {
        super(0);
        this.f28532d = new int[2];
        this.f28529a = view;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onEnd(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f28529a.setTranslationY(0.0f);
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public void onPrepare(WindowInsetsAnimationCompat windowInsetsAnimationCompat) {
        this.f28529a.getLocationOnScreen(this.f28532d);
        this.f28530b = this.f28532d[1];
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsCompat onProgress(WindowInsetsCompat windowInsetsCompat, List list) {
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            if ((((WindowInsetsAnimationCompat) it.next()).getTypeMask() & WindowInsetsCompat.Type.ime()) != 0) {
                this.f28529a.setTranslationY(oa.a.c(this.f28531c, 0, r0.getInterpolatedFraction()));
                break;
            }
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.WindowInsetsAnimationCompat.Callback
    public WindowInsetsAnimationCompat.BoundsCompat onStart(WindowInsetsAnimationCompat windowInsetsAnimationCompat, WindowInsetsAnimationCompat.BoundsCompat boundsCompat) {
        this.f28529a.getLocationOnScreen(this.f28532d);
        int i11 = this.f28530b - this.f28532d[1];
        this.f28531c = i11;
        this.f28529a.setTranslationY(i11);
        return boundsCompat;
    }
}
