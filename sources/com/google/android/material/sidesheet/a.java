package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class a extends d {

    /* renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f29717a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(SideSheetBehavior sideSheetBehavior) {
        this.f29717a = sideSheetBehavior;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public float b(int i11) {
        float e11 = e();
        return (i11 - e11) / (d() - e11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.leftMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int d() {
        return Math.max(0, this.f29717a.i0() + this.f29717a.g0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int e() {
        return (-this.f29717a.Z()) - this.f29717a.g0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int f() {
        return this.f29717a.g0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int g() {
        return -this.f29717a.Z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int h(View view) {
        return view.getRight() + this.f29717a.g0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getLeft();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int j() {
        return 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean k(float f11) {
        return f11 > 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean l(View view) {
        return view.getRight() < (d() - e()) / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean m(float f11, float f12) {
        return e.a(f11, f12) && Math.abs(f11) > ((float) this.f29717a.k0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean n(View view, float f11) {
        return Math.abs(((float) view.getLeft()) + (f11 * this.f29717a.e0())) > this.f29717a.f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        marginLayoutParams.leftMargin = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
        if (i11 <= this.f29717a.j0()) {
            marginLayoutParams.leftMargin = i12;
        }
    }
}
