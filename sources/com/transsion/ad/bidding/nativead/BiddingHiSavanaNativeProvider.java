package com.transsion.ad.bidding.nativead;

import com.blankj.utilcode.util.Utils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.AdditionalInfo;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.common.bean.TAdRequestBody;
import com.hisavana.mediation.ad.TNativeAd;
import com.transsion.ad.bidding.base.x;
import com.transsion.ad.hi.HiSavanaAdManager;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class BiddingHiSavanaNativeProvider extends x {

    /* renamed from: j, reason: collision with root package name */
    public static final a f42037j = new a(null);

    /* renamed from: k, reason: collision with root package name */
    private static final Lazy f42038k = LazyKt.b(new Function0() { // from class: com.transsion.ad.bidding.nativead.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Map s11;
            s11 = BiddingHiSavanaNativeProvider.s();
            return s11;
        }
    });

    /* renamed from: f, reason: collision with root package name */
    private String f42041f;

    /* renamed from: g, reason: collision with root package name */
    private String f42042g;

    /* renamed from: h, reason: collision with root package name */
    private TNativeAd f42043h;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentLinkedDeque f42039d = new ConcurrentLinkedDeque();

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentSkipListSet f42040e = new ConcurrentSkipListSet(new Comparator() { // from class: com.transsion.ad.bidding.nativead.a
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int t11;
            t11 = BiddingHiSavanaNativeProvider.t((TAdNativeInfo) obj, (TAdNativeInfo) obj2);
            return t11;
        }
    });

    /* renamed from: i, reason: collision with root package name */
    private AtomicBoolean f42044i = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) BiddingHiSavanaNativeProvider.f42038k.getValue();
        }

        public final BiddingHiSavanaNativeProvider b(String str) {
            String h11 = com.transsion.ad.scene.a.f42255a.h(str);
            if (h11 == null || h11.length() == 0) {
                return null;
            }
            BiddingHiSavanaNativeProvider biddingHiSavanaNativeProvider = (BiddingHiSavanaNativeProvider) a().get(h11);
            if (biddingHiSavanaNativeProvider != null) {
                return biddingHiSavanaNativeProvider;
            }
            BiddingHiSavanaNativeProvider biddingHiSavanaNativeProvider2 = new BiddingHiSavanaNativeProvider();
            biddingHiSavanaNativeProvider2.y(h11);
            biddingHiSavanaNativeProvider2.z(str);
            a().put(h11, biddingHiSavanaNativeProvider2);
            return biddingHiSavanaNativeProvider2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getClassTag() {
        String simpleName = BiddingHiSavanaNativeProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final void h() {
        if (this.f42043h == null) {
            TNativeAd tNativeAd = new TNativeAd(Utils.a(), n());
            this.f42043h = tNativeAd;
            tNativeAd.setRequestBody(new TAdRequestBody.AdRequestBodyBuild().setAdditionalListener(this).build());
            oi.a.f71145a.n("ad_n", "============= " + getClassTag() + " --> loadAd() --> mPlacementId = " + n() + " --> create TNativeAd() =================== ", 5, false);
        }
    }

    private final TAdNativeInfo m() {
        if (this.f42040e.isEmpty()) {
            return null;
        }
        TAdNativeInfo tAdNativeInfo = (TAdNativeInfo) this.f42040e.pollFirst();
        if (tAdNativeInfo == null || !tAdNativeInfo.isExpired()) {
            return tAdNativeInfo;
        }
        tAdNativeInfo.release();
        return m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String n() {
        String str = this.f42042g;
        return str == null ? "" : str;
    }

    private final boolean p() {
        int m11 = com.transsion.ad.scene.a.f42255a.m(this.f42041f);
        boolean z10 = this.f42040e.size() >= m11;
        if (z10) {
            oi.a.f71145a.n("ad_n", getClassTag() + " --> isUpperLimit() --- 达到阈值了 --> nativeInfoList.size = " + this.f42040e.size() + " -- cacheUpperLimit = " + m11, 5, false);
        }
        return z10;
    }

    public static /* synthetic */ void r(BiddingHiSavanaNativeProvider biddingHiSavanaNativeProvider, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "";
        }
        biddingHiSavanaNativeProvider.q(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map s() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int t(TAdNativeInfo tAdNativeInfo, TAdNativeInfo tAdNativeInfo2) {
        int compare = Double.compare(tAdNativeInfo2.getEcpmPrice(), tAdNativeInfo.getEcpmPrice());
        if (compare != 0) {
            return compare;
        }
        String adId = tAdNativeInfo.getAdId();
        String adId2 = tAdNativeInfo2.getAdId();
        Intrinsics.g(adId2, "getAdId(...)");
        return adId.compareTo(adId2);
    }

    public static /* synthetic */ Object v(BiddingHiSavanaNativeProvider biddingHiSavanaNativeProvider, String str, Map map, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = null;
        }
        return biddingHiSavanaNativeProvider.u(str, map, continuation);
    }

    private final boolean w(String str) {
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

    public final void g(di.a aVar) {
        this.f42039d.add(aVar);
    }

    public final void i(String msg) {
        Intrinsics.h(msg, "msg");
        h();
        TNativeAd tNativeAd = this.f42043h;
        if (tNativeAd == null || !tNativeAd.hasAd()) {
            q(msg);
        }
    }

    public final void j(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        k.d(o0.a(y0.c()), null, null, new BiddingHiSavanaNativeProvider$enterScene$1(this, sceneId, null), 3, null);
    }

    public final TAdNativeInfo k() {
        List<TAdNativeInfo> nativeAdInfo;
        TNativeAd tNativeAd = this.f42043h;
        if (tNativeAd != null && (nativeAdInfo = tNativeAd.getNativeAdInfo()) != null) {
            this.f42040e.addAll(nativeAdInfo);
        }
        TAdNativeInfo m11 = m();
        if (!p()) {
            q("同步获取广告，继续装填缓存池");
        }
        return m11;
    }

    public final TNativeAd l() {
        return this.f42043h;
    }

    public final boolean o() {
        return !this.f42040e.isEmpty();
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onClick(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onClick(tAdNativeInfo, additionalInfo);
        Iterator it = this.f42039d.iterator();
        while (it.hasNext()) {
            ((di.a) it.next()).onClick(tAdNativeInfo, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadFailure(TAdErrorCode tAdErrorCode, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadFailure(tAdErrorCode, additionalInfo);
        this.f42044i.set(false);
        oi.a.o(oi.a.f71145a, "ad_n", getClassTag() + " --> onLoadFailure() --> placementId = " + n() + " --> errorMessage = " + (tAdErrorCode != null ? tAdErrorCode.getErrorMessage() : null), 6, false, 8, null);
        Iterator it = this.f42039d.iterator();
        while (it.hasNext()) {
            ((di.a) it.next()).onLoadFailure(tAdErrorCode, additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onLoadSuccess(AdditionalInfo additionalInfo) {
        List<TAdNativeInfo> nativeAdInfo;
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onLoadSuccess(additionalInfo);
        TNativeAd tNativeAd = this.f42043h;
        if (tNativeAd != null && (nativeAdInfo = tNativeAd.getNativeAdInfo()) != null) {
            this.f42040e.addAll(nativeAdInfo);
        }
        if (!p()) {
            q("缓存池没有达到阈值，继续请求");
        }
        this.f42044i.set(false);
        Iterator it = this.f42039d.iterator();
        while (it.hasNext()) {
            ((di.a) it.next()).onLoadSuccess(additionalInfo);
        }
    }

    @Override // com.hisavana.common.interfacz.TAdditionalListener
    public void onShow(TAdNativeInfo tAdNativeInfo, AdditionalInfo additionalInfo) {
        Intrinsics.h(additionalInfo, "additionalInfo");
        super.onShow(tAdNativeInfo, additionalInfo);
        Iterator it = this.f42039d.iterator();
        while (it.hasNext()) {
            ((di.a) it.next()).onShow(tAdNativeInfo, additionalInfo);
        }
    }

    public final void q(String msg) {
        Intrinsics.h(msg, "msg");
        if (HiSavanaAdManager.f42171a.i()) {
            if (this.f42044i.get()) {
                return;
            }
            this.f42044i.set(true);
            h();
            TNativeAd tNativeAd = this.f42043h;
            if (tNativeAd != null) {
                tNativeAd.loadAd();
                return;
            }
            return;
        }
        oi.a.f71145a.n("ad_n", getClassTag() + " --> loadAd(" + msg + ") --> 广告SDK没有初始化", 6, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(java.lang.String r9, java.util.Map r10, kotlin.coroutines.Continuation r11) {
        /*
            r8 = this;
            boolean r0 = r11 instanceof com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$preLoadAd$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$preLoadAd$1 r0 = (com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$preLoadAd$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$preLoadAd$1 r0 = new com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$preLoadAd$1
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
            boolean r11 = r8.w(r9)
            if (r11 != 0) goto L6c
            oi.a r10 = oi.a.f71145a
            java.lang.String r11 = r8.getClassTag()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r11)
            java.lang.String r11 = " --> sceneId = "
            r0.append(r11)
            r0.append(r9)
            java.lang.String r9 = " --> 预请求开关关闭"
            r0.append(r9)
            java.lang.String r9 = r0.toString()
            r11 = 3
            java.lang.String r0 = "ad_n"
            r10.n(r0, r9, r11, r3)
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
            boolean r11 = r8.o()
            if (r11 == 0) goto Lad
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        Lad:
            kotlinx.coroutines.i0 r11 = kotlinx.coroutines.y0.b()
            kotlinx.coroutines.n0 r2 = kotlinx.coroutines.o0.a(r11)
            com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$preLoadAd$2 r5 = new com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider$preLoadAd$2
            r5.<init>(r9, r8, r10, r1)
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.nativead.BiddingHiSavanaNativeProvider.u(java.lang.String, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void x(di.a aVar) {
        this.f42039d.remove(aVar);
    }

    public final void y(String str) {
        this.f42042g = str;
    }

    public final void z(String str) {
        this.f42041f = str;
    }
}
