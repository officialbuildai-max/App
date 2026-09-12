package com.transsion.rewardscenter;

import android.content.Context;
import androidx.view.LiveData;
import androidx.view.b0;
import androidx.view.v;
import com.transsion.rewardscenter.task.ad.g0;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.rewardscenterapi.RewardsCenterData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import lg.a;

/* loaded from: classes6.dex */
public final class RewardsCenterProvider implements IRewardsCenterApi {

    /* renamed from: b, reason: collision with root package name */
    private volatile RewardsCenterData f51003b;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f51002a = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            up.a j11;
            j11 = RewardsCenterProvider.j();
            return j11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private final b0 f51004c = new b0(0);

    /* JADX INFO: Access modifiers changed from: private */
    public static final up.a j() {
        return (up.a) zg.c.f79537e.a().h(up.a.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final up.a k() {
        return (up.a) this.f51002a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit l(g0 g0Var) {
        g0Var.r();
        return Unit.f67184a;
    }

    @Override // com.transsion.rewardscenterapi.IRewardsCenterApi
    public RewardsCenterData a() {
        return this.f51003b;
    }

    @Override // com.transsion.rewardscenterapi.IRewardsCenterApi
    public void b() {
        k.d(v.a(androidx.view.g0.f9674i.a()), null, null, new RewardsCenterProvider$fetchRewardsCenterData$1(this, null), 3, null);
    }

    @Override // com.transsion.rewardscenterapi.IRewardsCenterApi
    public void c(Context context, n0 n0Var) {
        Intrinsics.h(context, "context");
        a.C0856a.f(lg.a.f68962a, "RewardsCenter", "preloadTaskAd", false, 4, null);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.g(applicationContext, "getApplicationContext(...)");
        final g0 g0Var = new g0(applicationContext, n0Var);
        g0Var.f(new Function0() { // from class: com.transsion.rewardscenter.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit l11;
                l11 = RewardsCenterProvider.l(g0.this);
                return l11;
            }
        });
    }

    @Override // com.transsion.rewardscenterapi.IRewardsCenterApi
    public LiveData d() {
        k.d(v.a(androidx.view.g0.f9674i.a()), null, null, new RewardsCenterProvider$fetchUnclaimRewardCount$1(this, null), 3, null);
        return this.f51004c;
    }
}
