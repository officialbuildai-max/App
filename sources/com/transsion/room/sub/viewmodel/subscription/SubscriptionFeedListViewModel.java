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
public final class SubscriptionFeedListViewModel extends b {

    /* renamed from: f, reason: collision with root package name */
    public static final a f51834f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static int f51835g = 8;

    /* renamed from: b, reason: collision with root package name */
    private String f51836b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f51837c;

    /* renamed from: d, reason: collision with root package name */
    private final lq.a f51838d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f51839e;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionFeedListViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51838d = (lq.a) c.f79537e.a().h(lq.a.class);
        this.f51839e = new b0();
    }

    public final b0 e() {
        return this.f51839e;
    }

    public final void f(String str) {
        this.f51836b = str;
        k.d(u0.a(this), y0.b(), null, new SubscriptionFeedListViewModel$getSubscriptionFeedData$1(this, str, null), 2, null);
    }

    public final boolean g() {
        return this.f51837c;
    }

    public final void h(String str) {
        this.f51837c = false;
        if (str == null || str.length() == 0) {
            lg.a.f68962a.x("SubscriptionFeedListViewModel", "loadMore: nextCursor is null or empty, cannot load more", true);
            this.f51839e.n(null);
            return;
        }
        lg.a.f68962a.c("SubscriptionFeedListViewModel", "loadMore: load nextCursor=" + str, true);
        f(str);
    }

    public final void i() {
        lg.a.f68962a.c("SubscriptionFeedListViewModel", "refresh: reset page to 1 and load first page", true);
        this.f51837c = true;
        f("");
    }
}
