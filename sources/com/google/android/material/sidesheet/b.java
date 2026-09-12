package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b extends d {

    /* renamed from: a, reason: collision with root package name */
    final SideSheetBehavior f29718a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(SideSheetBehavior sideSheetBehavior) {
        this.f29718a = sideSheetBehavior;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int a(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public float b(int i11) {
        float e11 = e();
        return (e11 - i11) / (e11 - d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int d() {
        return Math.max(0, (e() - this.f29718a.Z()) - this.f29718a.g0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int e() {
        return this.f29718a.j0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int f() {
        return this.f29718a.j0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int g() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int h(View view) {
        return view.getLeft() - this.f29718a.g0();
    }

    @Override // com.google.android.material.sidesheet.d
    public int i(CoordinatorLayout coordinatorLayout) {
        return coordinatorLayout.getRight();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public int j() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean k(float f11) {
        return f11 < 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean l(View view) {
        return view.getLeft() > (e() + d()) / 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean m(float f11, float f12) {
        return e.a(f11, f12) && Math.abs(f11) > ((float) this.f29718a.k0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public boolean n(View view, float f11) {
        return Math.abs(((float) view.getRight()) + (f11 * this.f29718a.e0())) > this.f29718a.f0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public void o(ViewGroup.MarginLayoutParams marginLayoutParams, int i11) {
        marginLayoutParams.rightMargin = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.sidesheet.d
    public void p(ViewGroup.MarginLayoutParams marginLayoutParams, int i11, int i12) {
        int j02 = this.f29718a.j0();
        if (i11 <= j02) {
            marginLayoutParams.rightMargin = j02 - i11;
        }
    }
}
