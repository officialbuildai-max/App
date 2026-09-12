package com.transsion.ad.ps.distribute;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.monopoly.plan.AdPlanUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import mi.l;

/* loaded from: classes5.dex */
public final class PsDbManager {

    /* renamed from: a, reason: collision with root package name */
    public static final PsDbManager f42243a = new PsDbManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42244b = LazyKt.b(new Function0() { // from class: com.transsion.ad.ps.distribute.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            l m11;
            m11 = PsDbManager.m();
            return m11;
        }
    });

    private PsDbManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e() {
        String simpleName = PsDbManager.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final l i() {
        return (l) f42244b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final l m() {
        MbAdDatabase.Companion companion = MbAdDatabase.INSTANCE;
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        return companion.b(a11).A0();
    }

    public final Object c(String str, List list, Continuation continuation) {
        Object d11 = i().d(str, list, continuation);
        return d11 == IntrinsicsKt.f() ? d11 : Unit.f67184a;
    }

    public final Object d(Continuation continuation) {
        return i().a(continuation);
    }

    public final Object f(String str, Continuation continuation) {
        return i().c(String.valueOf(str), continuation);
    }

    public final Object g(int i11, Continuation continuation) {
        return i().f(i11, continuation);
    }

    public final Object h(String str, Continuation continuation) {
        return i().g(str, continuation);
    }

    public final Object j(PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        Object b11 = i().b(psLinkAdPlan, continuation);
        return b11 == IntrinsicsKt.f() ? b11 : Unit.f67184a;
    }

    public final void k(AdPlans adPlans) {
        AdMaterialList a11;
        PsLinkAdPlan psLinkAdPlan;
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.f42220a;
        if ((!adPlanSourceManager.j(adPlans) && !adPlanSourceManager.l(adPlans)) || (a11 = AdPlanUtil.f42221a.a(adPlans)) == null || (psLinkAdPlan = a11.getPsLinkAdPlan()) == null) {
            return;
        }
        k.d(o0.a(y0.b()), null, null, new PsDbManager$onBiddingBuyOutClick$1(psLinkAdPlan, null), 3, null);
    }

    public final void l(AdPlans adPlans) {
        AdMaterialList a11;
        PsLinkAdPlan psLinkAdPlan;
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.f42220a;
        if ((!adPlanSourceManager.j(adPlans) && !adPlanSourceManager.l(adPlans)) || (a11 = AdPlanUtil.f42221a.a(adPlans)) == null || (psLinkAdPlan = a11.getPsLinkAdPlan()) == null) {
            return;
        }
        k.d(o0.a(y0.b()), null, null, new PsDbManager$onBiddingBuyOutDisplay$1(psLinkAdPlan, null), 3, null);
    }

    public final Object n(PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        Object e11;
        return (psLinkAdPlan == null || (e11 = f42243a.i().e(psLinkAdPlan, continuation)) != IntrinsicsKt.f()) ? Unit.f67184a : e11;
    }
}
