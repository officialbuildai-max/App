package androidx.navigation;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.y0;

/* loaded from: classes2.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    private final ReentrantLock f14040a = new ReentrantLock(true);

    /* renamed from: b, reason: collision with root package name */
    private final y0 f14041b;

    /* renamed from: c, reason: collision with root package name */
    private final y0 f14042c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f14043d;

    /* renamed from: e, reason: collision with root package name */
    private final i1 f14044e;

    /* renamed from: f, reason: collision with root package name */
    private final i1 f14045f;

    public r() {
        y0 a11 = j1.a(CollectionsKt.l());
        this.f14041b = a11;
        y0 a12 = j1.a(SetsKt.f());
        this.f14042c = a12;
        this.f14044e = kotlinx.coroutines.flow.d.b(a11);
        this.f14045f = kotlinx.coroutines.flow.d.b(a12);
    }

    public abstract NavBackStackEntry a(NavDestination navDestination, Bundle bundle);

    public final i1 b() {
        return this.f14044e;
    }

    public final i1 c() {
        return this.f14045f;
    }

    public final boolean d() {
        return this.f14043d;
    }

    public void e(NavBackStackEntry entry) {
        Intrinsics.h(entry, "entry");
        y0 y0Var = this.f14042c;
        y0Var.setValue(SetsKt.k((Set) y0Var.getValue(), entry));
    }

    public void f(NavBackStackEntry backStackEntry) {
        Intrinsics.h(backStackEntry, "backStackEntry");
        y0 y0Var = this.f14041b;
        y0Var.setValue(CollectionsKt.C0(CollectionsKt.z0((Iterable) y0Var.getValue(), CollectionsKt.u0((List) this.f14041b.getValue())), backStackEntry));
    }

    public void g(NavBackStackEntry popUpTo, boolean z10) {
        Intrinsics.h(popUpTo, "popUpTo");
        ReentrantLock reentrantLock = this.f14040a;
        reentrantLock.lock();
        try {
            y0 y0Var = this.f14041b;
            Iterable iterable = (Iterable) y0Var.getValue();
            ArrayList arrayList = new ArrayList();
            for (Object obj : iterable) {
                if (Intrinsics.c((NavBackStackEntry) obj, popUpTo)) {
                    break;
                } else {
                    arrayList.add(obj);
                }
            }
            y0Var.setValue(arrayList);
            Unit unit = Unit.f67184a;
            reentrantLock.unlock();
        } catch (Throwable th2) {
            reentrantLock.unlock();
            throw th2;
        }
    }

    public void h(NavBackStackEntry backStackEntry) {
        Intrinsics.h(backStackEntry, "backStackEntry");
        ReentrantLock reentrantLock = this.f14040a;
        reentrantLock.lock();
        try {
            y0 y0Var = this.f14041b;
            y0Var.setValue(CollectionsKt.C0((Collection) y0Var.getValue(), backStackEntry));
            Unit unit = Unit.f67184a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void i(boolean z10) {
        this.f14043d = z10;
    }
}
