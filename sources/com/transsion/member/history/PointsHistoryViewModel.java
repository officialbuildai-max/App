package com.transsion.member.history;

import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class PointsHistoryViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f46626a = LazyKt.b(new Function0() { // from class: com.transsion.member.history.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vm.a g11;
            g11 = PointsHistoryViewModel.g();
            return g11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final b0 f46627b = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final vm.a f() {
        return (vm.a) this.f46626a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vm.a g() {
        return (vm.a) zg.c.f79537e.a().h(vm.a.class);
    }

    public final void d(String page) {
        Intrinsics.h(page, "page");
        k.d(u0.a(this), y0.b(), null, new PointsHistoryViewModel$fetchHistory$1(this, page, null), 2, null);
    }

    public final b0 e() {
        return this.f46627b;
    }
}
