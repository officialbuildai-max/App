package com.transsion.room.sub.viewmodel.subscription;

import android.app.Application;
import androidx.view.b;
import androidx.view.b0;
import androidx.view.u0;
import com.transsion.room.sub.fragment.subscription.SubscriptionFragment;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.y0;
import lq.c;

/* loaded from: classes6.dex */
public final class UgcTrendingHomeViewModel extends b {

    /* renamed from: i, reason: collision with root package name */
    public static final a f51850i = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private Integer f51851b;

    /* renamed from: c, reason: collision with root package name */
    private Integer f51852c;

    /* renamed from: d, reason: collision with root package name */
    private final c f51853d;

    /* renamed from: e, reason: collision with root package name */
    private String f51854e;

    /* renamed from: f, reason: collision with root package name */
    private SubscriptionFragment.TabType f51855f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f51856g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f51857h;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UgcTrendingHomeViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51851b = 1;
        this.f51852c = 8;
        this.f51853d = (c) zg.c.f79537e.a().h(c.class);
        this.f51854e = "";
        this.f51855f = SubscriptionFragment.TabType.HOTTEST;
        this.f51857h = new b0();
    }

    public final void e(Integer num, String str) {
        this.f51854e = str;
        this.f51851b = num;
        k.d(u0.a(this), y0.b(), null, new UgcTrendingHomeViewModel$getUgcHomeTrendingData$1(num, this, str, null), 2, null);
    }

    public final b0 f() {
        return this.f51857h;
    }

    public final boolean g() {
        return this.f51856g;
    }

    public final void h(Integer num) {
        this.f51856g = false;
        if (num != null && num.intValue() <= 0) {
            lg.a.f68962a.x("UgcTrendingHomeViewModel", "loadMore: nextPage is null or empty, cannot load more", true);
            this.f51857h.n(null);
            return;
        }
        lg.a.f68962a.c("UgcTrendingHomeViewModel", "loadMore: load nextPage=" + num, true);
        e(num, this.f51854e);
    }

    public final void i() {
        lg.a.f68962a.c("UgcTrendingHomeViewModel", "refresh: reset page to 1 and load first page", true);
        this.f51851b = 1;
        String apiValue = this.f51855f.getApiValue();
        this.f51854e = apiValue;
        this.f51856g = true;
        e(this.f51851b, apiValue);
    }
}
