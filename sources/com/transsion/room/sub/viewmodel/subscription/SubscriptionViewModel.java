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
public final class SubscriptionViewModel extends b {

    /* renamed from: k, reason: collision with root package name */
    public static final a f51840k = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final b0 f51841b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f51842c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f51843d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f51844e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f51845f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f51846g;

    /* renamed from: h, reason: collision with root package name */
    private int f51847h;

    /* renamed from: i, reason: collision with root package name */
    private final lq.a f51848i;

    /* renamed from: j, reason: collision with root package name */
    private String f51849j;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriptionViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51841b = new b0();
        this.f51842c = new b0();
        this.f51843d = new b0();
        this.f51844e = new b0();
        this.f51845f = new b0();
        this.f51846g = new b0();
        this.f51847h = 1;
        this.f51848i = (lq.a) c.f79537e.a().h(lq.a.class);
    }

    public final b0 d() {
        return this.f51841b;
    }

    public final void e(String uid) {
        Intrinsics.h(uid, "uid");
        this.f51849j = uid;
        k.d(u0.a(this), y0.b(), null, new SubscriptionViewModel$getSubscriptionStatsData$1(this, uid, null), 2, null);
    }
}
