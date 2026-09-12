package androidx.work.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class c0 implements a0 {

    /* renamed from: b, reason: collision with root package name */
    private final a0 f15661b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f15662c;

    public c0(a0 delegate) {
        Intrinsics.h(delegate, "delegate");
        this.f15661b = delegate;
        this.f15662c = new Object();
    }

    @Override // androidx.work.impl.a0
    public boolean a(androidx.work.impl.model.x id2) {
        boolean a11;
        Intrinsics.h(id2, "id");
        synchronized (this.f15662c) {
            a11 = this.f15661b.a(id2);
        }
        return a11;
    }

    @Override // androidx.work.impl.a0
    public y b(androidx.work.impl.model.x id2) {
        y b11;
        Intrinsics.h(id2, "id");
        synchronized (this.f15662c) {
            b11 = this.f15661b.b(id2);
        }
        return b11;
    }

    @Override // androidx.work.impl.a0
    public /* synthetic */ y c(androidx.work.impl.model.j0 j0Var) {
        return z.a(this, j0Var);
    }

    @Override // androidx.work.impl.a0
    public y d(androidx.work.impl.model.x id2) {
        y d11;
        Intrinsics.h(id2, "id");
        synchronized (this.f15662c) {
            d11 = this.f15661b.d(id2);
        }
        return d11;
    }

    @Override // androidx.work.impl.a0
    public List remove(String workSpecId) {
        List remove;
        Intrinsics.h(workSpecId, "workSpecId");
        synchronized (this.f15662c) {
            remove = this.f15661b.remove(workSpecId);
        }
        return remove;
    }
}
