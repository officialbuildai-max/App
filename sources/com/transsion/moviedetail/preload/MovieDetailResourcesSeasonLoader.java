package com.transsion.moviedetail.preload;

import androidx.view.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class MovieDetailResourcesSeasonLoader extends qm.b {

    /* renamed from: f, reason: collision with root package name */
    private String f47335f;

    /* renamed from: g, reason: collision with root package name */
    private final Lazy f47336g;

    public MovieDetailResourcesSeasonLoader(String subjectId) {
        Intrinsics.h(subjectId, "subjectId");
        this.f47335f = subjectId;
        this.f47336g = LazyKt.b(new Function0() { // from class: com.transsion.moviedetail.preload.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                qy.a o11;
                o11 = MovieDetailResourcesSeasonLoader.o();
                return o11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final qy.a m() {
        return (qy.a) this.f47336g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qy.a o() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    @Override // qm.b
    public void h(b0 b0Var) {
        t1 d11;
        d11 = k.d(o0.a(y0.b()), null, null, new MovieDetailResourcesSeasonLoader$loadDataFromService$1(this, null), 3, null);
        j(d11);
    }

    public final String n() {
        return this.f47335f;
    }

    public final void p(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f47335f = str;
    }
}
