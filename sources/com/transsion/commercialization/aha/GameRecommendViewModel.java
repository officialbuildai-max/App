package com.transsion.commercialization.aha;

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
public final class GameRecommendViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f43801a = new b0();

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f43802b = LazyKt.b(new Function0() { // from class: com.transsion.commercialization.aha.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            g l11;
            l11 = GameRecommendViewModel.l();
            return l11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private int f43803c;

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String simpleName = GameRecommendViewModel.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g k() {
        return (g) this.f43802b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g l() {
        return (g) zg.c.f79537e.a().h(g.class);
    }

    public final b0 h() {
        return this.f43801a;
    }

    public final void i() {
        k.d(u0.a(this), y0.b(), null, new GameRecommendViewModel$getAllGame$1(this, null), 2, null);
    }
}
