package com.transsion.play.detail.viewmodel;

import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import zg.c;

/* loaded from: classes6.dex */
public final class PlayDetailViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f47970a = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.play.detail.viewmodel.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            wn.a h11;
            h11 = PlayDetailViewModel.h();
            return h11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private final b0 f47971b = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final wn.a e() {
        return (wn.a) this.f47970a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final wn.a h() {
        return (wn.a) c.f79537e.a().h(wn.a.class);
    }

    public final void f(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        k.d(u0.a(this), null, null, new PlayDetailViewModel$getSubjectPostCount$1(this, subjectId, null), 3, null);
    }

    public final b0 g() {
        return this.f47971b;
    }
}
