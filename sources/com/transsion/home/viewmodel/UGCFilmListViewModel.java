package com.transsion.home.viewmodel;

import android.app.Application;
import androidx.view.u0;
import com.transsion.moviedetailapi.bean.Pager;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;
import lg.a;

/* loaded from: classes5.dex */
public final class UGCFilmListViewModel extends androidx.view.b {

    /* renamed from: j, reason: collision with root package name */
    public static final a f45909j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    public static final int f45910k = 8;

    /* renamed from: b, reason: collision with root package name */
    private final ol.b f45911b;

    /* renamed from: c, reason: collision with root package name */
    private String f45912c;

    /* renamed from: d, reason: collision with root package name */
    private int f45913d;

    /* renamed from: e, reason: collision with root package name */
    private Pager f45914e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f45915f;

    /* renamed from: g, reason: collision with root package name */
    private final androidx.view.b0 f45916g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.view.b0 f45917h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f45918i;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UGCFilmListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f45911b = (ol.b) zg.c.f79537e.a().h(ol.b.class);
        this.f45912c = "";
        this.f45913d = 1;
        this.f45916g = new androidx.view.b0();
        this.f45917h = new androidx.view.b0();
    }

    private final void i(int i11) {
        a.C0856a.f(lg.a.f68962a, "FilmListViewModel", "getFilmList: start loading, page=" + i11 + ", filmType=" + this.f45912c, false, 4, null);
        kotlinx.coroutines.k.d(u0.a(this), y0.b(), null, new UGCFilmListViewModel$getFilmList$1(this, i11, null), 2, null);
    }

    public final androidx.view.b0 j() {
        return this.f45917h;
    }

    public final androidx.view.b0 k() {
        return this.f45916g;
    }

    public final boolean l() {
        Pager pager = this.f45914e;
        if (pager != null) {
            return Intrinsics.c(pager.getHasMore(), Boolean.TRUE);
        }
        return false;
    }

    public final void m(String filmType) {
        Intrinsics.h(filmType, "filmType");
        this.f45912c = filmType;
        a.C0856a.f(lg.a.f68962a, "FilmListViewModel", "init: filmType=" + filmType, false, 4, null);
    }

    public final boolean n() {
        return this.f45915f;
    }

    public final void o() {
        Pager pager = this.f45914e;
        String nextPage = pager != null ? pager.getNextPage() : null;
        if (nextPage == null || nextPage.length() == 0) {
            a.C0856a.z(lg.a.f68962a, "FilmListViewModel", "loadMore: nextPage is null or empty, cannot load more", false, 4, null);
            this.f45916g.n(null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "FilmListViewModel", "loadMore: load nextPage=" + nextPage, false, 4, null);
        this.f45915f = false;
        Integer v11 = StringsKt.v(nextPage);
        i(v11 != null ? v11.intValue() : 1);
    }

    public final void p() {
        a.C0856a.f(lg.a.f68962a, "FilmListViewModel", "refresh: reset page to 1 and load first page", false, 4, null);
        this.f45913d = 1;
        this.f45914e = null;
        this.f45915f = true;
        i(1);
    }
}
