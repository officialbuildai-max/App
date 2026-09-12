package com.transsion.ad.bidding.base;

import android.app.Activity;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import oi.b;

/* loaded from: classes5.dex */
public abstract class AbsBiddingInterceptHiSavanaAdManager extends x implements oi.b {

    /* renamed from: d, reason: collision with root package name */
    private di.a f41906d;

    /* renamed from: e, reason: collision with root package name */
    private String f41907e;

    /* renamed from: f, reason: collision with root package name */
    private Map f41908f;

    /* renamed from: g, reason: collision with root package name */
    private AtomicBoolean f41909g = new AtomicBoolean(false);

    /* renamed from: h, reason: collision with root package name */
    private AdditionalInfo f41910h;

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean k(List list) {
        List list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            return false;
        }
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            if (AdPlanSourceManager.f42220a.e((AdPlans) it.next())) {
                return true;
            }
        }
        return false;
    }

    private final boolean n(String str) {
        Object m1185constructorimpl;
        JsonElement jsonElement;
        try {
            Result.Companion companion = Result.INSTANCE;
            JsonObject b11 = com.transsion.ad.scene.d.f42258a.b(str);
            m1185constructorimpl = Result.m1185constructorimpl(Boolean.valueOf((b11 == null || (jsonElement = b11.get("preload")) == null) ? false : jsonElement.getAsBoolean()));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            m1185constructorimpl = Boolean.FALSE;
        }
        return ((Boolean) m1185constructorimpl).booleanValue();
    }

    private final Integer t() {
        int f11 = f();
        if (f11 != 3) {
            return f11 != 4 ? null : 3;
        }
        return 5;
    }

    public final void b() {
        ce.b e11 = e();
        if (e11 == null || !e11.hasAd()) {
            l();
        }
    }

    public final void c(di.a aVar) {
        di.a aVar2 = this.f41906d;
        if (aVar2 != null && Intrinsics.c(aVar2, aVar)) {
            p(null);
            b.a.c(this, 3, "destroy() --> 移除监听", null, false, 4, null);
        }
    }

    public final void d(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        kotlinx.coroutines.k.d(o0.a(y0.c()), null, null, new AbsBiddingInterceptHiSavanaAdManager$enterScene$1(this, sceneId, null), 3, null);
    }

    public abstract ce.b e();

    public abstract int f();

    public final AdditionalInfo g() {
        ce.b e11 = e();
        if (e11 != null && !e11.hasAd() && f() != 5) {
            return null;
        }
        Integer t11 = t();
        if (t11 != null) {
            int intValue = t11.intValue();
            AdditionalInfo additionalInfo = this.f41910h;
            if (additionalInfo != null) {
                ce.b e12 = e();
                additionalInfo.setEcpm(e12 != null ? Double.valueOf(e12.getTopPrice(intValue)) : null);
            }
        }
        return this.f41910h;
    }

    @Override // oi.b
    public String getClassTag() {
        return b.a.a(this);
    }

    @Override // oi.b
    /* renamed from: getSceneId */
    public String getMSceneId() {
        return "";
    }

    public final di.a h() {
        return this.f41906d;
    }

    public final String i() {
        return this.f41907e;
    }

    public final Boolean j() {
        ce.b e11 = e();
        if (e11 != null) {
            return Boolean.valueOf(e11.hasAd());
        }
        return null;
    }

    public final void l() {
        if (!HiSavanaAdManager.f42171a.i() && f() != 5) {
            di.a aVar = this.f41906d;
            if (aVar != null) {
                aVar.onLoadFailure(new TAdErrorCode(103, "广告SDK没有初始化"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (this.f41909g.get()) {
            di.a aVar2 = this.f41906d;
            if (aVar2 != null) {
                aVar2.onLoadFailure(new TAdErrorCode(103, "当前正在展示Hi广告"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (e() == null) {
            di.a aVar3 = this.f41906d;
            if (aVar3 != null) {
                aVar3.onLoadFailure(new TAdErrorCode(103, "getAdInstance() == null"), new AdditionalInfo());
                return;
            }
            return;
        }
        ce.b e11 = e();
        if (e11 != null) {
            e11.loadAd();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m(java.lang.String r9, java.util.Map r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1 r0 = (com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1 r0 = new com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$1
            r0.<init>(r8, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3b
            if (r2 != r4) goto L33
            java.lang.Object r9 = r0.L$1
            r10 = r9
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r9 = r0.L$0
            java.lang.String r9 = (java.lang.String) r9
            kotlin.ResultKt.b(r11)
            goto L86
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L3b:
            kotlin.ResultKt.b(r11)
            boolean r11 = r8.n(r9)
            if (r11 != 0) goto L6c
            java.lang.String r10 = r8.getClassTag()
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r10)
            java.lang.String r10 = " --> sceneId = "
            r11.append(r10)
            r11.append(r9)
            java.lang.String r9 = " --> 预请求开关关闭"
            r11.append(r9)
            java.lang.String r9 = r11.toString()
            java.lang.String r10 = r8.getLogTag()
            r11 = 3
            r8.onLog(r11, r9, r10, r3)
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        L6c:
            com.transsion.ad.hi.HiSavanaAdManager r11 = com.transsion.ad.hi.HiSavanaAdManager.f42171a
            boolean r11 = r11.i()
            if (r11 != 0) goto L77
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        L77:
            com.transsion.ad.scene.SceneInterceptManager r11 = com.transsion.ad.scene.SceneInterceptManager.f42254a
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r4
            java.lang.Object r11 = r11.a(r9, r0)
            if (r11 != r1) goto L86
            return r1
        L86:
            kotlin.Pair r11 = (kotlin.Pair) r11
            java.lang.Object r11 = r11.getFirst()
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r11 == 0) goto L97
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        L97:
            com.transsion.ad.scene.c r11 = com.transsion.ad.scene.c.f42257a
            r0 = 2
            r1 = 0
            boolean r11 = com.transsion.ad.scene.c.b(r11, r9, r3, r0, r1)
            if (r11 == 0) goto La4
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        La4:
            ce.b r11 = r8.e()
            if (r11 == 0) goto Lb3
            boolean r11 = r11.hasAd()
            if (r11 != r4) goto Lb3
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        Lb3:
            kotlinx.coroutines.i0 r11 = kotlinx.coroutines.y0.b()
            kotlinx.coroutines.n0 r2 = kotlinx.coroutines.o0.a(r11)
            com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2 r5 = new com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager$preLoadAd$2
            r5.<init>(r9, r10, r8, r1)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.base.AbsBiddingInterceptHiSavanaAdManager.m(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public abstract void o();

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onClick(tAdNativeInfo, additionalInfo);
        di.a aVar = this.f41906d;
        if (aVar != null) {
            aVar.onClick(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClosed(int i11) {
        super.onClosed(i11);
        this.f41909g.set(false);
        di.a aVar = this.f41906d;
        if (aVar != null) {
            aVar.onClosed(i11);
        }
        this.f41906d = null;
        o();
        if (f() == 5) {
            return;
        }
        l();
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadFailure(tAdErrorCode, additionalInfo);
        this.f41909g.set(false);
        di.a aVar = this.f41906d;
        if (aVar != null) {
            aVar.onLoadFailure(tAdErrorCode, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadSuccess(additionalInfo);
        this.f41910h = additionalInfo;
        di.a aVar = this.f41906d;
        if (aVar != null) {
            aVar.onLoadSuccess(additionalInfo);
        }
    }

    @Override // oi.b
    public void onLog(int i11, String str, String str2, boolean z10) {
        b.a.b(this, i11, str, str2, z10);
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onRewarded() {
        super.onRewarded();
        di.a aVar = this.f41906d;
        if (aVar != null) {
            aVar.onRewarded();
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShow(tAdNativeInfo, additionalInfo);
        this.f41909g.set(true);
        di.a aVar = this.f41906d;
        if (aVar != null) {
            aVar.onShow(tAdNativeInfo, additionalInfo);
        }
        this.f41910h = null;
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShowError(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShowError(tAdErrorCode, additionalInfo);
        this.f41909g.set(false);
        di.a aVar = this.f41906d;
        if (aVar != null) {
            aVar.onShowError(tAdErrorCode, additionalInfo);
        }
    }

    public final AbsBiddingInterceptHiSavanaAdManager p(di.a aVar) {
        this.f41906d = aVar;
        return this;
    }

    public final void q(String str) {
        this.f41907e = str;
    }

    public abstract void r(Activity activity, String str, Integer num, Map map);

    public final void s(Activity activity, Integer num, String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        if (activity == null) {
            di.a aVar = this.f41906d;
            if (aVar != null) {
                aVar.onShowError(new TAdErrorCode(103, "activity is null"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (this.f41909g.get()) {
            di.a aVar2 = this.f41906d;
            if (aVar2 != null) {
                aVar2.onShowError(new TAdErrorCode(103, "当前正在展示Hi广告"), new AdditionalInfo());
                return;
            }
            return;
        }
        if (f() == 5) {
            r(activity, sceneId, num, this.f41908f);
            return;
        }
        ce.b e11 = e();
        if (e11 != null && e11.hasAd()) {
            r(activity, sceneId, num, this.f41908f);
            return;
        }
        di.a aVar3 = this.f41906d;
        if (aVar3 != null) {
            aVar3.onShowError(new TAdErrorCode(103, "当前还没有广告"), new AdditionalInfo());
        }
        p(null);
        l();
    }
}
