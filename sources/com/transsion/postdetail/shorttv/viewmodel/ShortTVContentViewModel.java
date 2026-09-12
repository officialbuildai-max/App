package com.transsion.postdetail.shorttv.viewmodel;

import android.app.Application;
import androidx.view.b0;
import androidx.view.u0;
import com.blankj.utilcode.util.Utils;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.ShortTVPlayDao;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class ShortTVContentViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f49281b;

    /* renamed from: c, reason: collision with root package name */
    private final Lazy f49282c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f49283d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f49284e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f49285f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f49286g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f49287h;

    /* renamed from: i, reason: collision with root package name */
    private final b0 f49288i;

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f49289j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVContentViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f49281b = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.viewmodel.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                xo.b m11;
                m11 = ShortTVContentViewModel.m();
                return m11;
            }
        });
        this.f49282c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.viewmodel.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ShortTVPlayDao n11;
                n11 = ShortTVContentViewModel.n();
                return n11;
            }
        });
        this.f49283d = new b0();
        this.f49284e = new b0();
        this.f49285f = new b0();
        this.f49286g = new b0();
        this.f49287h = new b0();
        this.f49288i = new b0();
        this.f49289j = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.shorttv.viewmodel.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n0 g11;
                g11 = ShortTVContentViewModel.g();
                return g11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n0 g() {
        return o0.a(y0.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.b k() {
        return (xo.b) this.f49281b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.b m() {
        return (xo.b) zg.c.f79537e.a().h(xo.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ShortTVPlayDao n() {
        Application a11 = Utils.a();
        if (a11 != null) {
            return AppDatabase.INSTANCE.b(a11).x1();
        }
        return null;
    }

    public final b0 h() {
        return this.f49285f;
    }

    public final b0 i() {
        return this.f49286g;
    }

    public final b0 j() {
        return this.f49288i;
    }

    public final void l(String nextPage, int i11, boolean z10) {
        Intrinsics.h(nextPage, "nextPage");
        k.d(u0.a(this), null, null, new ShortTVContentViewModel$getShortTVFavoriteList$1(this, nextPage, i11, z10, null), 3, null);
    }
}
