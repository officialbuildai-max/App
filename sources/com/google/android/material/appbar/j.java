package com.google.android.material.appbar;

import android.view.View;
import androidx.core.view.ViewCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final View f28326a;

    /* renamed from: b, reason: collision with root package name */
    private int f28327b;

    /* renamed from: c, reason: collision with root package name */
    private int f28328c;

    /* renamed from: d, reason: collision with root package name */
    private int f28329d;

    /* renamed from: e, reason: collision with root package name */
    private int f28330e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f28331f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f28332g = true;

    public j(View view) {
        this.f28326a = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        View view = this.f28326a;
        ViewCompat.offsetTopAndBottom(view, this.f28329d - (view.getTop() - this.f28327b));
        View view2 = this.f28326a;
        ViewCompat.offsetLeftAndRight(view2, this.f28330e - (view2.getLeft() - this.f28328c));
    }

    public int b() {
        return this.f28327b;
    }

    public int c() {
        return this.f28329d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        this.f28327b = this.f28326a.getTop();
        this.f28328c = this.f28326a.getLeft();
    }

    public boolean e(int i11) {
        if (!this.f28332g || this.f28330e == i11) {
            return false;
        }
        this.f28330e = i11;
        a();
        return true;
    }

    public boolean f(int i11) {
        if (!this.f28331f || this.f28329d == i11) {
            return false;
        }
        this.f28329d = i11;
        a();
        return true;
    }
}
