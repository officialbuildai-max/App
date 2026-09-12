package com.transsion.room.sub.viewmodel.likes;

import android.app.Application;
import androidx.view.b;
import androidx.view.b0;
import androidx.view.u0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;
import lg.a;
import zg.c;

/* loaded from: classes6.dex */
public final class UgcLikesViewModel extends b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f51819i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private static int f51820j = 8;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f51821b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f51822c;

    /* renamed from: d, reason: collision with root package name */
    private final kq.a f51823d;

    /* renamed from: e, reason: collision with root package name */
    private String f51824e;

    /* renamed from: f, reason: collision with root package name */
    private String f51825f;

    /* renamed from: g, reason: collision with root package name */
    private String f51826g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f51827h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcLikesViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51821b = new b0();
        this.f51822c = new b0();
        this.f51823d = (kq.a) c.f79537e.a().h(kq.a.class);
    }

    public final b0 e() {
        return this.f51821b;
    }

    public final b0 f() {
        return this.f51822c;
    }

    public final void g(String page, String userId) {
        Intrinsics.h(page, "page");
        Intrinsics.h(userId, "userId");
        this.f51825f = page;
        this.f51826g = userId;
        a.C0856a.f(lg.a.f68962a, "UgcLikesViewModel", "Likes getUgcVideoLikesBean", false, 4, null);
        k.d(u0.a(this), y0.b(), null, new UgcLikesViewModel$getUgcVideoLikesBean$1(page, userId, this, null), 2, null);
    }

    public final boolean h() {
        return this.f51827h;
    }

    public final void i(String str) {
        this.f51827h = false;
        if (str == null || str.length() == 0) {
            lg.a.f68962a.x("UgcLikesViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.f51822c.n(null);
            return;
        }
        lg.a.f68962a.c("UgcLikesViewModel", "loadMore: load nextPage=" + str, true);
        g(str.toString(), String.valueOf(this.f51826g));
    }

    public final void j(String ugcVideoId, boolean z10) {
        Intrinsics.h(ugcVideoId, "ugcVideoId");
        this.f51824e = ugcVideoId;
        k.d(u0.a(this), y0.b(), null, new UgcLikesViewModel$postLikeUgcVideo$1(ugcVideoId, z10, this, null), 2, null);
    }

    public final void k() {
        lg.a.f68962a.c("UgcLikesViewModel", "refresh: reset page to 1 and load first page", true);
        this.f51825f = "1";
        this.f51827h = true;
        g(String.valueOf("1"), String.valueOf(this.f51826g));
    }
}
