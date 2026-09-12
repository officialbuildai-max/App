package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    int f28193e;

    /* renamed from: f, reason: collision with root package name */
    int f28194f;

    /* renamed from: g, reason: collision with root package name */
    int f28195g;

    /* renamed from: h, reason: collision with root package name */
    int f28196h;

    /* renamed from: i, reason: collision with root package name */
    int f28197i;

    /* renamed from: j, reason: collision with root package name */
    float f28198j;

    /* renamed from: k, reason: collision with root package name */
    float f28199k;

    /* renamed from: l, reason: collision with root package name */
    int f28200l;

    /* renamed from: m, reason: collision with root package name */
    int f28201m;

    /* renamed from: o, reason: collision with root package name */
    int f28203o;

    /* renamed from: p, reason: collision with root package name */
    int f28204p;

    /* renamed from: q, reason: collision with root package name */
    boolean f28205q;

    /* renamed from: r, reason: collision with root package name */
    boolean f28206r;

    /* renamed from: a, reason: collision with root package name */
    int f28189a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    int f28190b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    int f28191c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    int f28192d = Integer.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    List f28202n = new ArrayList();

    public int a() {
        return this.f28195g;
    }

    public int b() {
        return this.f28196h;
    }

    public int c() {
        return this.f28196h - this.f28197i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view, int i11, int i12, int i13, int i14) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f28189a = Math.min(this.f28189a, (view.getLeft() - flexItem.getMarginLeft()) - i11);
        this.f28190b = Math.min(this.f28190b, (view.getTop() - flexItem.getMarginTop()) - i12);
        this.f28191c = Math.max(this.f28191c, view.getRight() + flexItem.getMarginRight() + i13);
        this.f28192d = Math.max(this.f28192d, view.getBottom() + flexItem.getMarginBottom() + i14);
    }
}
