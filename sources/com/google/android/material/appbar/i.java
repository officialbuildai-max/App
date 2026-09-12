package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class i extends CoordinatorLayout.c {

    /* renamed from: a, reason: collision with root package name */
    private j f28323a;

    /* renamed from: b, reason: collision with root package name */
    private int f28324b;

    /* renamed from: c, reason: collision with root package name */
    private int f28325c;

    public i() {
        this.f28324b = 0;
        this.f28325c = 0;
    }

    public i(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f28324b = 0;
        this.f28325c = 0;
    }

    public int E() {
        j jVar = this.f28323a;
        if (jVar != null) {
            return jVar.c();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(CoordinatorLayout coordinatorLayout, View view, int i11) {
        coordinatorLayout.onLayoutChild(view, i11);
    }

    public boolean G(int i11) {
        j jVar = this.f28323a;
        if (jVar != null) {
            return jVar.f(i11);
        }
        this.f28324b = i11;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean l(CoordinatorLayout coordinatorLayout, View view, int i11) {
        F(coordinatorLayout, view, i11);
        if (this.f28323a == null) {
            this.f28323a = new j(view);
        }
        this.f28323a.d();
        this.f28323a.a();
        int i12 = this.f28324b;
        if (i12 != 0) {
            this.f28323a.f(i12);
            this.f28324b = 0;
        }
        int i13 = this.f28325c;
        if (i13 == 0) {
            return true;
        }
        this.f28323a.e(i13);
        this.f28325c = 0;
        return true;
    }
}
