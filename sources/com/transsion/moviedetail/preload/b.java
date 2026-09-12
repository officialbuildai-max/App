package com.transsion.moviedetail.preload;

import androidx.view.b0;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b extends qm.b {

    /* renamed from: f, reason: collision with root package name */
    private String f47338f;

    /* renamed from: g, reason: collision with root package name */
    private Integer f47339g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47340h;

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f47341i;

    /* loaded from: classes6.dex */
    public static final class a extends sg.a {
        a() {
        }

        @Override // sg.a
        public void a(String str, String str2) {
            b.this.c(new Pair(str, null));
        }

        @Override // sg.a
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void c(Subject subject) {
            if (subject != null) {
                subject.setRefreshViewOnly(b.this.m());
            }
            b.this.d(new Pair("0", subject));
        }

        @Override // sg.a, io.reactivex.rxjava3.core.o
        public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
            Intrinsics.h(d11, "d");
            super.onSubscribe(d11);
            b.this.i(d11);
        }
    }

    public b(String subjectId, Integer num, boolean z10) {
        Intrinsics.h(subjectId, "subjectId");
        this.f47338f = subjectId;
        this.f47339g = num;
        this.f47340h = z10;
        this.f47341i = LazyKt.a(LazyThreadSafetyMode.NONE, new Function0() { // from class: com.transsion.moviedetail.preload.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                fn.a n11;
                n11 = b.n();
                return n11;
            }
        });
    }

    public /* synthetic */ b(String str, Integer num, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? false : z10);
    }

    private final fn.a l() {
        return (fn.a) this.f47341i.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fn.a n() {
        return (fn.a) zg.c.f79537e.a().h(fn.a.class);
    }

    @Override // qm.b
    public void h(b0 b0Var) {
        l().g(vg.a.f77447a.a(), this.f47338f, this.f47339g).f(sg.d.f75472a.c()).subscribe(new a());
    }

    public final boolean m() {
        return this.f47340h;
    }

    public final void o(boolean z10) {
        this.f47340h = z10;
    }

    public final void p(Integer num) {
        this.f47339g = num;
    }

    public final void q(String str) {
        Intrinsics.h(str, "<set-?>");
        this.f47338f = str;
    }
}
