package com.transsion.postdetail.viewmodel.ugcfavorite;

import android.app.Application;
import androidx.view.b;
import androidx.view.b0;
import androidx.view.u0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;
import zg.c;

/* loaded from: classes6.dex */
public final class UgcFavoriteViewModel extends b {

    /* renamed from: h, reason: collision with root package name */
    public static final a f50318h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static int f50319i = 10;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f50320b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f50321c;

    /* renamed from: d, reason: collision with root package name */
    private final jq.a f50322d;

    /* renamed from: e, reason: collision with root package name */
    private String f50323e;

    /* renamed from: f, reason: collision with root package name */
    private String f50324f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f50325g;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcFavoriteViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f50320b = new b0();
        this.f50321c = new b0();
        this.f50322d = (jq.a) c.f79537e.a().h(jq.a.class);
    }

    public final b0 e() {
        return this.f50320b;
    }

    public final void f(String page, String userId) {
        Intrinsics.h(page, "page");
        Intrinsics.h(userId, "userId");
        this.f50323e = page;
        this.f50324f = userId;
        k.d(u0.a(this), y0.b(), null, new UgcFavoriteViewModel$getUgcVideoFavoriteList$1(this, page, userId, null), 2, null);
    }

    public final boolean g() {
        return this.f50325g;
    }

    public final void h(String str) {
        this.f50325g = false;
        if (str == null || str.length() == 0) {
            lg.a.f68962a.x("UgcFavoriteViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.f50320b.n(null);
            return;
        }
        lg.a.f68962a.c("UgcFavoriteViewModel", "loadMore: load nextPage=" + str, true);
        f(str.toString(), String.valueOf(this.f50324f));
    }

    public final void i() {
        lg.a.f68962a.c("UgcFavoriteViewModel", "refresh: reset page to 1 and load first page", true);
        this.f50323e = "1";
        this.f50325g = true;
        f(String.valueOf("1"), String.valueOf(this.f50324f));
    }
}
