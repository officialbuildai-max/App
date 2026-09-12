package ck;

import androidx.view.g0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes5.dex */
public final class u implements androidx.view.f {

    /* renamed from: a, reason: collision with root package name */
    public static final u f17345a = new u();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f17346b;

    private u() {
    }

    public final void a() {
        g0.f9674i.a().getLifecycle().a(this);
    }

    public final boolean b() {
        return f17346b;
    }

    public final void c(boolean z10) {
        f17346b = z10;
    }

    @Override // androidx.view.f
    public /* synthetic */ void onCreate(androidx.view.u uVar) {
        androidx.view.e.a(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onDestroy(androidx.view.u uVar) {
        androidx.view.e.b(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onPause(androidx.view.u uVar) {
        androidx.view.e.c(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onResume(androidx.view.u uVar) {
        androidx.view.e.d(this, uVar);
    }

    @Override // androidx.view.f
    public /* synthetic */ void onStart(androidx.view.u uVar) {
        androidx.view.e.e(this, uVar);
    }

    @Override // androidx.view.f
    public void onStop(androidx.view.u owner) {
        Intrinsics.h(owner, "owner");
        a.C0856a.f(lg.a.f68962a, "DialogSessionManager", "onStop 重置标记为false", false, 4, null);
        f17346b = false;
    }
}
