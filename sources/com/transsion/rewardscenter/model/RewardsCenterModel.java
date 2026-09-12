package com.transsion.rewardscenter.model;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.b0;
import androidx.view.u0;
import com.cloud.tmc.integration.event.EventConstants;
import com.transsion.rewardscenter.utils.p;
import com.transsion.rewardscenter.utils.q;
import com.transsion.rewardscenterapi.Banner;
import com.transsion.rewardscenterapi.Lottery;
import com.transsion.rewardscenterapi.SkuPoint;
import com.transsion.rewardscenterapi.User;
import java.util.LinkedHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class RewardsCenterModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f51009b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f51010c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f51011d;

    /* renamed from: e, reason: collision with root package name */
    private final b0 f51012e;

    /* renamed from: f, reason: collision with root package name */
    private final b0 f51013f;

    /* renamed from: g, reason: collision with root package name */
    private final b0 f51014g;

    /* renamed from: h, reason: collision with root package name */
    private final b0 f51015h;

    /* renamed from: i, reason: collision with root package name */
    private final b0 f51016i;

    /* renamed from: j, reason: collision with root package name */
    private String f51017j;

    /* renamed from: k, reason: collision with root package name */
    private final b0 f51018k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RewardsCenterModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51009b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.model.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                up.a z10;
                z10 = RewardsCenterModel.z();
                return z10;
            }
        });
        this.f51010c = new b0();
        this.f51011d = new b0();
        this.f51012e = new b0();
        this.f51013f = new b0();
        this.f51014g = new b0();
        this.f51015h = new b0(Boolean.FALSE);
        this.f51016i = new b0();
        this.f51018k = new b0();
    }

    public static /* synthetic */ void h(RewardsCenterModel rewardsCenterModel, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = null;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        rewardsCenterModel.g(str, z10);
    }

    public static /* synthetic */ void j(RewardsCenterModel rewardsCenterModel, Function0 function0, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        rewardsCenterModel.i(function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final up.a s() {
        return (up.a) this.f51009b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final up.a z() {
        return (up.a) zg.c.f79537e.a().h(up.a.class);
    }

    public final void A(String str) {
        this.f51017j = str;
    }

    public final void B(String cc2, String number, String iso) {
        Intrinsics.h(cc2, "cc");
        Intrinsics.h(number, "number");
        Intrinsics.h(iso, "iso");
        String str = this.f51017j;
        if (str == null || str.length() == 0) {
            return;
        }
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RewardsCenterModel$submitAndClaim$1(this, str, cc2, number, iso, null), 3, null);
    }

    public final void C(int i11) {
        User user = (User) this.f51011d.f();
        if (user == null) {
            return;
        }
        this.f51011d.q(User.copy$default(user, i11, null, null, false, 14, null));
    }

    public final void e(String drawResultId) {
        Intrinsics.h(drawResultId, "drawResultId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RewardsCenterModel$claim$1(drawResultId, this, null), 3, null);
    }

    public final void f(String drawResultId) {
        Intrinsics.h(drawResultId, "drawResultId");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RewardsCenterModel$claimVip$1(this, drawResultId, null), 3, null);
    }

    public final void g(String str, boolean z10) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RewardsCenterModel$drawTask$1(this, str, z10, null), 3, null);
    }

    public final void i(Function0 function0) {
        kotlinx.coroutines.k.d(u0.a(this), null, null, new RewardsCenterModel$fetchRewardsCenterData$1(function0, this, null), 3, null);
    }

    public final String k() {
        Lottery lottery = (Lottery) this.f51010c.f();
        if (lottery != null) {
            return lottery.getActivityId();
        }
        return null;
    }

    public final SkuPoint l() {
        Banner banner;
        Lottery lottery = (Lottery) this.f51010c.f();
        if (lottery == null || (banner = lottery.getBanner()) == null) {
            return null;
        }
        return banner.getSku();
    }

    public final b0 m() {
        return this.f51016i;
    }

    public final b0 n() {
        return this.f51018k;
    }

    public final b0 o() {
        return this.f51015h;
    }

    public final b0 p() {
        return this.f51010c;
    }

    public final String q() {
        return this.f51017j;
    }

    public final b0 r() {
        return this.f51012e;
    }

    public final b0 t() {
        return this.f51014g;
    }

    public final String u() {
        Banner banner;
        Lottery lottery = (Lottery) this.f51010c.f();
        if (lottery == null || (banner = lottery.getBanner()) == null) {
            return null;
        }
        return banner.getSkuId();
    }

    public final b0 v() {
        return this.f51013f;
    }

    public final User w() {
        return (User) this.f51011d.f();
    }

    public final b0 x() {
        return this.f51011d;
    }

    public final void y(AppCompatActivity activity, String phone, int i11) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(phone, "phone");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("phone", phone);
        linkedHashMap.put("activity", "lottery");
        linkedHashMap.put(EventConstants.KEY_SOURCE, String.valueOf(i11));
        q.a("payment", linkedHashMap);
        com.transsion.payment.lib.f a11 = com.transsion.payment.lib.f.f47848b.a();
        String u11 = u();
        if (u11 == null) {
            u11 = "";
        }
        com.transsion.payment.lib.f.f(a11, activity, u11, null, null, false, linkedHashMap, new com.transsion.payment.lib.b() { // from class: com.transsion.rewardscenter.model.RewardsCenterModel$payment$1
            @Override // com.transsion.payment.lib.b
            public void a(Integer num, String str, boolean z10, String str2) {
                a.C0856a.f(lg.a.f68962a, "RewardsCenter", "Payment failed " + str + ", " + num, false, 4, null);
                if (str == null) {
                    str = "top-up failed, Please try again.";
                }
                p.a(false, str);
            }

            @Override // com.transsion.payment.lib.b
            public void b(boolean z10) {
                a.C0856a.f(lg.a.f68962a, "RewardsCenter", "onPendingTransition()", false, 4, null);
            }

            @Override // com.transsion.payment.lib.b
            public void c(int i12, String balance, String str) {
                Intrinsics.h(balance, "balance");
                RewardsCenterModel.h(RewardsCenterModel.this, str, false, 2, null);
                kotlinx.coroutines.k.d(u0.a(RewardsCenterModel.this), null, null, new RewardsCenterModel$payment$1$success$1(RewardsCenterModel.this, null), 3, null);
            }
        }, null, 148, null);
    }
}
