package com.transsion.ad.strategy;

import androidx.view.u;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class k implements androidx.view.f {

    /* renamed from: a, reason: collision with root package name */
    public static final k f42290a = new k();

    private k() {
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(u uVar) {
        androidx.view.e.a(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onDestroy(u uVar) {
        androidx.view.e.b(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onPause(u uVar) {
        androidx.view.e.c(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onResume(u uVar) {
        androidx.view.e.d(this, uVar);
    }

    @Override // androidx.view.f
    public void onStart(u owner) {
        Intrinsics.h(owner, "owner");
        androidx.view.e.e(this, owner);
        a.f42280a.a();
    }

    @Override // androidx.view.f
    public void onStop(u owner) {
        Intrinsics.h(owner, "owner");
        androidx.view.e.f(this, owner);
        a.f42280a.b();
    }
}
