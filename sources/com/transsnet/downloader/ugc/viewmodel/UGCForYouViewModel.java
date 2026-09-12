package com.transsnet.downloader.ugc.viewmodel;

import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.k;

/* loaded from: classes7.dex */
public final class UGCForYouViewModel extends t0 {

    /* renamed from: c, reason: collision with root package name */
    private String f60002c;

    /* renamed from: a, reason: collision with root package name */
    private final String f60000a = UGCForYouViewModel.class.getSimpleName();

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f60001b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.ugc.viewmodel.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            sy.a j11;
            j11 = UGCForYouViewModel.j();
            return j11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private final b0 f60003d = new b0();

    /* JADX INFO: Access modifiers changed from: private */
    public final sy.a f() {
        return (sy.a) this.f60001b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final sy.a j() {
        return (sy.a) zg.c.f79537e.a().h(sy.a.class);
    }

    public final void g(boolean z10) {
        k.d(u0.a(this), null, null, new UGCForYouViewModel$getUGCDownloadForYouList$1(z10, this, null), 3, null);
    }

    public final b0 h() {
        return this.f60003d;
    }

    public final String i() {
        return this.f60002c;
    }

    public final void k(String str) {
        this.f60002c = str;
    }
}
