package com.transsion.room.sub.viewmodel.subscription;

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
public final class SubFollowingsViewModel extends b {

    /* renamed from: g, reason: collision with root package name */
    public static final a f51828g = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private String f51829b;

    /* renamed from: c, reason: collision with root package name */
    private int f51830c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f51831d;

    /* renamed from: e, reason: collision with root package name */
    private final lq.b f51832e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f51833f;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubFollowingsViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51830c = 8;
        this.f51832e = (lq.b) c.f79537e.a().h(lq.b.class);
        this.f51833f = new b0();
    }

    public final b0 e() {
        return this.f51833f;
    }

    public final void f(String str) {
        this.f51829b = str;
        k.d(u0.a(this), y0.b(), null, new SubFollowingsViewModel$getSubscriptionFollowingsData$1(this, str, null), 2, null);
    }

    public final boolean g() {
        return this.f51831d;
    }

    public final void h(String str) {
        this.f51831d = false;
        if (str == null || str.length() == 0) {
            lg.a.f68962a.x("SubFollowingsViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.f51833f.n(null);
            return;
        }
        lg.a.f68962a.c("SubFollowingsViewModel", "loadMore: load nextCursor=" + str, true);
        f(str);
    }

    public final void i() {
        lg.a.f68962a.c("SubFollowingsViewModel", "refresh: reset page to 1 and load first page", true);
        this.f51829b = "";
        this.f51831d = true;
        f("");
    }
}
