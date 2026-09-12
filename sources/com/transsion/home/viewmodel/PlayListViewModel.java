package com.transsion.home.viewmodel;

import androidx.view.t0;
import androidx.view.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class PlayListViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final ol.b f45870a = (ol.b) zg.c.f79537e.a().h(ol.b.class);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f45871b = LazyKt.b(new Function0() { // from class: com.transsion.home.viewmodel.m
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            androidx.view.b0 h11;
            h11 = PlayListViewModel.h();
            return h11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private int f45872c = 1;

    /* renamed from: d, reason: collision with root package name */
    private int f45873d = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.view.b0 h() {
        return new androidx.view.b0();
    }

    public final int e() {
        return this.f45872c;
    }

    public final void f(String label, String category, String recType, String topIds, int i11) {
        Intrinsics.h(label, "label");
        Intrinsics.h(category, "category");
        Intrinsics.h(recType, "recType");
        Intrinsics.h(topIds, "topIds");
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new PlayListViewModel$getPlayList$1(this, label, category, recType, topIds, i11, null), 2, null);
    }

    public final androidx.view.b0 g() {
        return (androidx.view.b0) this.f45871b.getValue();
    }

    public final void i(int i11) {
        this.f45872c = i11;
    }
}
