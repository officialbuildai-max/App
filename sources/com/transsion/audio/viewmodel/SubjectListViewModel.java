package com.transsion.audio.viewmodel;

import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;

/* loaded from: classes5.dex */
public final class SubjectListViewModel extends t0 {

    /* renamed from: c */
    public static final a f43025c = new a(null);

    /* renamed from: a */
    private final Lazy f43026a = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a j11;
            j11 = SubjectListViewModel.j();
            return j11;
        }
    });

    /* renamed from: b */
    private final Lazy f43027b = LazyKt.b(new Function0() { // from class: com.transsion.audio.viewmodel.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 e11;
            e11 = SubjectListViewModel.e();
            return e11;
        }
    });

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final b0 e() {
        return new b0();
    }

    public static /* synthetic */ void h(SubjectListViewModel subjectListViewModel, boolean z10, String str, String str2, int i11, int i12, int i13, int i14, int i15, Object obj) {
        subjectListViewModel.g(z10, str, (i15 & 4) != 0 ? "1" : str2, (i15 & 8) != 0 ? 8 : i11, (i15 & 16) != 0 ? 1 : i12, (i15 & 32) != 0 ? 8 : i13, (i15 & 64) != 0 ? 0 : i14);
    }

    public final qy.a i() {
        return (qy.a) this.f43026a.getValue();
    }

    public static final qy.a j() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    public final b0 f() {
        return (b0) this.f43027b.getValue();
    }

    public final void g(boolean z10, String str, String nextPage, int i11, int i12, int i13, int i14) {
        Intrinsics.h(nextPage, "nextPage");
        k.d(u0.a(this), null, null, new SubjectListViewModel$getDownloadList$1(this, str, nextPage, i11, i12, i13, i14, z10, null), 3, null);
    }
}
