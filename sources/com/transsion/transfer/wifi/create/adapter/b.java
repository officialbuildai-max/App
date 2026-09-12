package com.transsion.transfer.wifi.create.adapter;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private lv.a f56017a;

    /* renamed from: b, reason: collision with root package name */
    private com.transsion.transfer.wifi.create.a f56018b;

    /* renamed from: c, reason: collision with root package name */
    private n0 f56019c;

    public abstract Object a(Continuation continuation);

    public final String b() {
        String simpleName = getClass().getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    public final n0 c() {
        return this.f56019c;
    }

    public final com.transsion.transfer.wifi.create.a d() {
        return this.f56018b;
    }

    public final lv.a e() {
        return this.f56017a;
    }

    public abstract void f();

    public final void g(n0 n0Var) {
        this.f56019c = n0Var;
    }

    public final void h(com.transsion.transfer.wifi.create.a aVar) {
        this.f56018b = aVar;
    }

    public final Object i(lv.a aVar, com.transsion.transfer.wifi.create.a aVar2, n0 n0Var, Continuation continuation) {
        this.f56017a = aVar;
        this.f56018b = aVar2;
        this.f56019c = n0Var;
        Object a11 = a(continuation);
        return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
    }
}
