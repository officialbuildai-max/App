package com.transsion.sunflower;

import android.content.Context;
import android.content.Intent;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final Context f55188a;

    /* renamed from: b, reason: collision with root package name */
    private Function1 f55189b;

    /* renamed from: c, reason: collision with root package name */
    private Function1 f55190c;

    /* renamed from: d, reason: collision with root package name */
    private Function0 f55191d;

    /* renamed from: e, reason: collision with root package name */
    private Function0 f55192e;

    /* renamed from: f, reason: collision with root package name */
    private FSNConfig f55193f;

    /* renamed from: g, reason: collision with root package name */
    private int f55194g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f55195h;

    /* renamed from: i, reason: collision with root package name */
    private Intent f55196i;

    public d(Context ctx) {
        Intrinsics.h(ctx, "ctx");
        this.f55188a = ctx;
        this.f55194g = R$mipmap.ic_launcher;
    }

    public final FSNManager a() {
        return FSNManager.f55175f.b(this);
    }

    public final FSNConfig b() {
        return this.f55193f;
    }

    public final Context c() {
        return this.f55188a;
    }

    public final int d() {
        return this.f55194g;
    }

    public final Function1 e() {
        return this.f55189b;
    }

    public final Function1 f() {
        return this.f55190c;
    }

    public final Function0 g() {
        return this.f55192e;
    }

    public final Intent h() {
        return this.f55196i;
    }

    public final Function0 i() {
        return this.f55191d;
    }

    public final boolean j() {
        return this.f55195h;
    }

    public final void k(Function0 function0) {
        this.f55191d = function0;
    }

    public final void l(FSNConfig fSNConfig) {
        this.f55193f = fSNConfig;
    }

    public final void m(boolean z10) {
        this.f55195h = z10;
    }

    public final void n(int i11) {
        this.f55194g = i11;
    }

    public final void o(Function1 function1) {
        this.f55189b = function1;
    }

    public final void p(Function1 function1) {
        this.f55190c = function1;
    }

    public final void q(Function0 function0) {
        this.f55192e = function0;
    }

    public final void r(Intent intent) {
        this.f55196i = intent;
    }
}
