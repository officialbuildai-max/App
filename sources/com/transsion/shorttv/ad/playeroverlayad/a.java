package com.transsion.shorttv.ad.playeroverlayad;

import com.transsion.shorttv.ad.AdLoadState;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private AdLoadState f52777a = AdLoadState.IDLE;

    /* renamed from: b, reason: collision with root package name */
    private e f52778b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f52779c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f52780d;

    public final void a() {
        this.f52777a = AdLoadState.DESTROYED;
        e eVar = this.f52778b;
        if (eVar != null) {
            eVar.f();
        }
        this.f52778b = null;
        this.f52779c = false;
    }

    public final e b() {
        return this.f52778b;
    }

    public final AdLoadState c() {
        return this.f52777a;
    }

    public final boolean d() {
        return this.f52780d;
    }

    public final boolean e() {
        return this.f52779c;
    }

    public final void f(e eVar) {
        this.f52778b = eVar;
    }

    public final void g(AdLoadState adLoadState) {
        Intrinsics.h(adLoadState, "<set-?>");
        this.f52777a = adLoadState;
    }

    public final void h(boolean z10) {
        this.f52780d = z10;
    }

    public final void i(boolean z10) {
        this.f52779c = z10;
    }
}
