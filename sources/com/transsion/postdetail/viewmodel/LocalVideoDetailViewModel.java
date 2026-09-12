package com.transsion.postdetail.viewmodel;

import android.util.Log;
import androidx.view.b0;
import androidx.view.t0;
import androidx.view.u0;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.moviedetailapi.bean.Subject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class LocalVideoDetailViewModel extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f50254a = "LocalVideoViewModel";

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f50255b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.viewmodel.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            qy.a k11;
            k11 = LocalVideoDetailViewModel.k();
            return k11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private b0 f50256c = new b0();

    /* renamed from: d, reason: collision with root package name */
    private b0 f50257d = new b0();

    /* renamed from: e, reason: collision with root package name */
    private b0 f50258e = new b0();

    /* renamed from: f, reason: collision with root package name */
    private final b0 f50259f = new b0();

    private final qy.a j() {
        return (qy.a) this.f50255b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qy.a k() {
        return (qy.a) zg.c.f79537e.a().h(qy.a.class);
    }

    public final void d(String str) {
        if (str == null || str.length() == 0) {
            this.f50259f.n(null);
        } else if (nh.m.f70597a.e()) {
            j().h(vg.a.f77447a.a(), str).f(sg.d.f75472a.c()).subscribe(new sg.a() { // from class: com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel$fetchMovieData$1
                @Override // sg.a
                public void a(String str2, String str3) {
                    String str4;
                    LocalVideoDetailViewModel.this.g().n(null);
                    str4 = LocalVideoDetailViewModel.this.f50254a;
                    Log.e(str4, "message:" + str3);
                }

                @Override // sg.a
                /* renamed from: e, reason: merged with bridge method [inline-methods] */
                public void c(Subject subject) {
                    kotlinx.coroutines.k.d(u0.a(LocalVideoDetailViewModel.this), null, null, new LocalVideoDetailViewModel$fetchMovieData$1$onSuccess$1(LocalVideoDetailViewModel.this, subject, null), 3, null);
                }

                @Override // sg.a, io.reactivex.rxjava3.core.o
                public void onSubscribe(io.reactivex.rxjava3.disposables.c d11) {
                    Intrinsics.h(d11, "d");
                    super.onSubscribe(d11);
                }
            });
        } else {
            this.f50259f.n(null);
        }
    }

    public final b0 e() {
        return this.f50257d;
    }

    public final b0 f() {
        return this.f50258e;
    }

    public final b0 g() {
        return this.f50259f;
    }

    public final void h(DownloadBean downloadBean) {
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new LocalVideoDetailViewModel$getSeriesFromLocal$1(downloadBean, this, null), 2, null);
    }

    public final b0 i() {
        return this.f50256c;
    }
}
