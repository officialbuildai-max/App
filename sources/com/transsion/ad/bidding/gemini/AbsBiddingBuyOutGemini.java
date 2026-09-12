package com.transsion.ad.bidding.gemini;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdErrorCode;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.h5.BiddingBuyOutH5AdSourceActivity;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import oi.b;

/* loaded from: classes5.dex */
public abstract class AbsBiddingBuyOutGemini implements b {

    /* renamed from: g, reason: collision with root package name */
    public static final a f41972g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private di.a f41973a;

    /* renamed from: c, reason: collision with root package name */
    private Integer f41975c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f41977e;

    /* renamed from: b, reason: collision with root package name */
    private String f41974b = "";

    /* renamed from: d, reason: collision with root package name */
    private Boolean f41976d = Boolean.TRUE;

    /* renamed from: f, reason: collision with root package name */
    private final BroadcastReceiver f41978f = new BroadcastReceiver() { // from class: com.transsion.ad.bidding.gemini.AbsBiddingBuyOutGemini$myReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.h(intent, "intent");
            AbsBiddingBuyOutGemini.this.p(context, intent);
        }
    };

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final Class d(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        return AdPlanSourceManager.f42220a.c(biddingIntermediateMaterialBean != null ? biddingIntermediateMaterialBean.getPlans() : null) ? BiddingBuyOutH5AdSourceActivity.class : c();
    }

    private final String g() {
        return "com.transsion.ad.bidding." + f() + ".click";
    }

    private final String h() {
        return "com.transsion.ad.bidding." + f() + ".close";
    }

    private final String i() {
        return "com.transsion.ad.bidding." + f() + ".display";
    }

    private final String j() {
        return "com.transsion.ad.bidding." + f() + ".display_timestamp";
    }

    private final di.a k() {
        return this.f41973a;
    }

    private final String l() {
        return "com.transsion.ad.bidding." + f() + ".resume";
    }

    private final String m() {
        return "com.transsion.ad.bidding." + f() + ".rewarded";
    }

    private final String n() {
        return "com.transsion.ad.bidding." + f() + ".show_error";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(Context context, Intent intent) {
        BiddingIntermediateMaterialBean biddingIntermediateMaterialBean;
        di.a k11;
        Object parcelableExtra;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelableExtra = intent.getParcelableExtra("ad_max_ecpm_object", BiddingIntermediateMaterialBean.class);
            biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) parcelableExtra;
        } else {
            biddingIntermediateMaterialBean = (BiddingIntermediateMaterialBean) intent.getParcelableExtra("ad_max_ecpm_object");
        }
        long longExtra = intent.getLongExtra("display_timestamp", 0L);
        String action = intent.getAction();
        if (Intrinsics.c(action, l())) {
            di.a k12 = k();
            if (k12 != null) {
                k12.f(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, i())) {
            di.a k13 = k();
            if (k13 != null) {
                k13.c(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, g())) {
            di.a k14 = k();
            if (k14 != null) {
                k14.a(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, m())) {
            di.a k15 = k();
            if (k15 != null) {
                k15.g(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, j())) {
            di.a k16 = k();
            if (k16 != null) {
                k16.d(biddingIntermediateMaterialBean, longExtra);
                return;
            }
            return;
        }
        if (Intrinsics.c(action, h())) {
            di.a k17 = k();
            if (k17 != null) {
                k17.b(biddingIntermediateMaterialBean);
                return;
            }
            return;
        }
        if (!Intrinsics.c(action, n()) || (k11 = k()) == null) {
            return;
        }
        k11.h(null, biddingIntermediateMaterialBean);
    }

    public final void b() {
        r1.a.b(Utils.a()).e(this.f41978f);
        s(null);
        this.f41977e = false;
    }

    public abstract Class c();

    public final String e() {
        return com.transsion.ad.scene.a.f42255a.a(getMSceneId());
    }

    public abstract String f();

    @Override // oi.b
    public String getClassTag() {
        return b.a.a(this);
    }

    @Override // oi.b
    /* renamed from: getSceneId */
    public String getMSceneId() {
        return this.f41974b;
    }

    public final AbsBiddingBuyOutGemini o(Boolean bool) {
        this.f41976d = bool;
        return this;
    }

    @Override // oi.b
    public void onLog(int i11, String str, String str2, boolean z10) {
        b.a.b(this, i11, str, str2, z10);
    }

    public final AbsBiddingBuyOutGemini q() {
        if (!this.f41977e) {
            this.f41977e = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(l());
            intentFilter.addAction(i());
            intentFilter.addAction(g());
            intentFilter.addAction(m());
            intentFilter.addAction(j());
            intentFilter.addAction(h());
            intentFilter.addAction(n());
            r1.a.b(Utils.a()).c(this.f41978f, intentFilter);
        }
        return this;
    }

    public final AbsBiddingBuyOutGemini r(Integer num) {
        this.f41975c = num;
        return this;
    }

    public final AbsBiddingBuyOutGemini s(di.a aVar) {
        this.f41973a = aVar;
        return this;
    }

    public final AbsBiddingBuyOutGemini t(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        this.f41974b = sceneId;
        return this;
    }

    public final void u(Context context, String sceneId, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Object m1185constructorimpl;
        di.a k11;
        Unit unit;
        Intrinsics.h(sceneId, "sceneId");
        try {
            Result.Companion companion = Result.INSTANCE;
            if (context != null) {
                Intent intent = new Intent(context, (Class<?>) d(biddingIntermediateMaterialBean));
                intent.putExtra("scene_id", sceneId);
                intent.putExtra("ad_max_ecpm_object", biddingIntermediateMaterialBean);
                intent.putExtra("app_layout_id", this.f41975c);
                intent.putExtra("is_show_member_btn", this.f41976d);
                intent.putExtra("action_resume", l());
                intent.putExtra("action_display", i());
                intent.putExtra("action_click", g());
                intent.putExtra("action_display_timestamp", j());
                intent.putExtra("action_rewarded", m());
                intent.putExtra("action_close", h());
                intent.putExtra("show_error", n());
                context.startActivity(intent);
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            m1185constructorimpl = Result.m1185constructorimpl(unit);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null || (k11 = k()) == null) {
            return;
        }
        k11.h(new TAdErrorCode(102, String.valueOf(m1188exceptionOrNullimpl.getMessage())), null);
    }
}
