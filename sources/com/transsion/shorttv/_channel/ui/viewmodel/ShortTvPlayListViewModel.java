package com.transsion.shorttv._channel.ui.viewmodel;

import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ShortTvPlayListViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final nr.a f52696a = (nr.a) zg.c.f79537e.a().h(nr.a.class);

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f52697b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv._channel.ui.viewmodel.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 h11;
            h11 = ShortTvPlayListViewModel.h();
            return h11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private int f52698c = 1;

    /* renamed from: d, reason: collision with root package name */
    private int f52699d = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 h() {
        return new b0();
    }

    public final int e() {
        return this.f52698c;
    }

    public final void f(String label, String category, String recType, String topIds, int i11) {
        Intrinsics.h(label, "label");
        Intrinsics.h(category, "category");
        Intrinsics.h(recType, "recType");
        Intrinsics.h(topIds, "topIds");
        k.d(u0.a(this), y0.b(), null, new ShortTvPlayListViewModel$getPlayList$1(this, label, category, recType, topIds, i11, null), 2, null);
    }

    public final b0 g() {
        return (b0) this.f52697b.getValue();
    }

    public final void i(int i11) {
        this.f52698c = i11;
    }
}
