package com.transsion.ad.bidding.nativead;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.cloud.hisavana.sdk.common.bean.AdActiveInfo;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.transsion.ad.db.pslink.AppInstalledBean;
import com.transsion.ad.hi.HiSavanaAdManager;
import com.transsion.ad.ps.installed.AppInstallManager;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class BiddingHiSspNativeProvider extends com.cloud.hisavana.sdk.api.listener.d {

    /* renamed from: h, reason: collision with root package name */
    public static final a f42045h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f42046i = LazyKt.b(new Function0() { // from class: com.transsion.ad.bidding.nativead.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            Map o11;
            o11 = BiddingHiSspNativeProvider.o();
            return o11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private z6.d f42048c;

    /* renamed from: d, reason: collision with root package name */
    private String f42049d;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f42047b = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private final ConcurrentLinkedDeque f42050e = new ConcurrentLinkedDeque();

    /* renamed from: f, reason: collision with root package name */
    private final ConcurrentSkipListSet f42051f = new ConcurrentSkipListSet(new Comparator() { // from class: com.transsion.ad.bidding.nativead.c
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int p11;
            p11 = BiddingHiSspNativeProvider.p((TaNativeInfo) obj, (TaNativeInfo) obj2);
            return p11;
        }
    });

    /* renamed from: g, reason: collision with root package name */
    private int f42052g = 3;

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Map a() {
            return (Map) BiddingHiSspNativeProvider.f42046i.getValue();
        }

        public final BiddingHiSspNativeProvider b(String str) {
            String i11 = com.transsion.ad.scene.a.f42255a.i(str);
            if (i11 == null || i11.length() == 0) {
                return null;
            }
            BiddingHiSspNativeProvider biddingHiSspNativeProvider = (BiddingHiSspNativeProvider) a().get(i11);
            if (biddingHiSspNativeProvider != null) {
                return biddingHiSspNativeProvider;
            }
            BiddingHiSspNativeProvider biddingHiSspNativeProvider2 = new BiddingHiSspNativeProvider();
            biddingHiSspNativeProvider2.s(i11);
            a().put(i11, biddingHiSspNativeProvider2);
            return biddingHiSspNativeProvider2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String j() {
        String simpleName = BiddingHiSspNativeProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String l() {
        String str = this.f42049d;
        return str == null ? "" : str;
    }

    private final boolean m() {
        boolean z10 = this.f42051f.size() >= this.f42052g;
        if (z10) {
            oi.a.o(oi.a.f71145a, "ad_n", j() + " --> isUpperLimit() --- 达到阈值了 --> nativeInfoList.size = " + this.f42051f.size() + " -- cacheUpperLimit = " + this.f42052g, 0, false, 4, null);
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map o() {
        return new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(TaNativeInfo taNativeInfo, TaNativeInfo taNativeInfo2) {
        boolean c11 = Intrinsics.c(taNativeInfo.getAdCreateId(), taNativeInfo2.getAdCreateId());
        AdImage image = taNativeInfo.getImage();
        String imgUrl = image != null ? image.getImgUrl() : null;
        AdImage image2 = taNativeInfo2.getImage();
        boolean c12 = Intrinsics.c(imgUrl, image2 != null ? image2.getImgUrl() : null);
        if (c11 || c12) {
            int compare = Double.compare(taNativeInfo2.getBidPrice(), taNativeInfo.getBidPrice());
            if (compare != 0) {
                return compare;
            }
            return 0;
        }
        int compare2 = Double.compare(taNativeInfo2.getBidPrice(), taNativeInfo.getBidPrice());
        if (compare2 != 0) {
            return compare2;
        }
        String adCreateId = taNativeInfo2.getAdCreateId();
        String adCreateId2 = taNativeInfo.getAdCreateId();
        Intrinsics.g(adCreateId2, "getAdCreateId(...)");
        int compareTo = adCreateId.compareTo(adCreateId2);
        if (compareTo != 0) {
            return compareTo;
        }
        String imgUrl2 = taNativeInfo2.getImage().getImgUrl();
        String imgUrl3 = taNativeInfo.getImage().getImgUrl();
        Intrinsics.g(imgUrl3, "getImgUrl(...)");
        return imgUrl2.compareTo(imgUrl3);
    }

    public final void h(com.cloud.hisavana.sdk.api.listener.d dVar) {
        this.f42050e.add(dVar);
    }

    public final List i(int i11, boolean z10) {
        Object m1185constructorimpl;
        ArrayList arrayList;
        if (i11 > this.f42052g) {
            this.f42052g = i11;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            Iterator it = this.f42051f.iterator();
            while (it.hasNext()) {
                TaNativeInfo taNativeInfo = (TaNativeInfo) it.next();
                z6.d dVar = this.f42048c;
                if (dVar != null && !dVar.v(taNativeInfo)) {
                    taNativeInfo.destroy();
                    it.remove();
                }
            }
            if (!z10 || this.f42051f.size() >= i11) {
                arrayList = new ArrayList();
                int min = Math.min(i11, this.f42051f.size());
                for (int i12 = 0; i12 < min; i12++) {
                    TaNativeInfo taNativeInfo2 = (TaNativeInfo) this.f42051f.pollFirst();
                    if (taNativeInfo2 != null) {
                        arrayList.add(taNativeInfo2);
                    }
                }
            } else {
                arrayList = null;
            }
            m1185constructorimpl = Result.m1185constructorimpl(arrayList);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        List list = (List) (Result.m1188exceptionOrNullimpl(m1185constructorimpl) == null ? m1185constructorimpl : null);
        n();
        return list;
    }

    public final z6.d k() {
        return this.f42048c;
    }

    public final void n() {
        if (!HiSavanaAdManager.f42171a.i()) {
            oi.a.o(oi.a.f71145a, "ad_n", j() + " --> loadAd() --> 广告SDK没有初始化", 0, false, 4, null);
            return;
        }
        if (m() || this.f42047b.get()) {
            return;
        }
        this.f42047b.set(true);
        if (this.f42048c == null) {
            z6.d dVar = new z6.d(l());
            this.f42048c = dVar;
            dVar.p(this);
            z6.d dVar2 = this.f42048c;
            if (dVar2 != null) {
                dVar2.A(this.f42052g);
            }
            oi.a.o(oi.a.f71145a, "ad_n", "============= " + j() + " --> loadAd() --> mPlacementId = " + l() + " --> create TNativeAd() ============= ", 0, false, 4, null);
        }
        z6.d dVar3 = this.f42048c;
        if (dVar3 != null) {
            dVar3.A(this.f42052g);
        }
        z6.d dVar4 = this.f42048c;
        if (dVar4 != null) {
            dVar4.w();
        }
    }

    @Override // com.cloud.hisavana.sdk.api.listener.d
    public void onAdActivate(AdActiveInfo adActiveInfo) {
        String str;
        super.onAdActivate(adActiveInfo);
        AppInstallManager appInstallManager = AppInstallManager.f42250a;
        if (adActiveInfo == null || (str = adActiveInfo.getPackageName()) == null) {
            str = "ew没有传递过来包名";
        }
        AppInstalledBean a11 = appInstallManager.a(str);
        a11.setSource(AppInstalledBean.APP_INSTALLED_BEAN_SOURCE_EW);
        Application a12 = Utils.a();
        Intrinsics.g(a12, "getApp(...)");
        appInstallManager.e(a12, a11);
    }

    @Override // com.cloud.hisavana.sdk.api.listener.d
    public void onAdLoaded(List list) {
        this.f42047b.set(false);
        if (list != null) {
            this.f42051f.addAll(list);
        }
    }

    @Override // com.cloud.hisavana.sdk.api.listener.d
    public void onError(TaErrorCode taErrorCode) {
        this.f42047b.set(false);
        oi.a.f71145a.n("ad_n", j() + " --> onError() --> placementId = " + l() + " --> errorMessage = " + (taErrorCode != null ? taErrorCode.getErrorMessage() : null), 6, false);
    }

    @Override // com.cloud.hisavana.sdk.api.listener.d
    public void onNativeAdClick(TaNativeInfo taNativeInfo) {
        Iterator it = this.f42050e.iterator();
        while (it.hasNext()) {
            ((com.cloud.hisavana.sdk.api.listener.d) it.next()).onNativeAdClick(taNativeInfo);
        }
    }

    @Override // com.cloud.hisavana.sdk.api.listener.d
    public void onNativeAdShow(TaNativeInfo taNativeInfo) {
        Iterator it = this.f42050e.iterator();
        while (it.hasNext()) {
            ((com.cloud.hisavana.sdk.api.listener.d) it.next()).onNativeAdShow(taNativeInfo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q(java.lang.String r14, int r15, java.util.Map r16, kotlin.coroutines.Continuation r17) {
        /*
            r13 = this;
            r6 = r13
            r0 = r14
            r1 = r17
            boolean r2 = r1 instanceof com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider$preLoadAd$1
            if (r2 == 0) goto L17
            r2 = r1
            com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider$preLoadAd$1 r2 = (com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider$preLoadAd$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L17
            int r3 = r3 - r4
            r2.label = r3
            goto L1c
        L17:
            com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider$preLoadAd$1 r2 = new com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider$preLoadAd$1
            r2.<init>(r13, r1)
        L1c:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r2.label
            r5 = 1
            if (r4 == 0) goto L40
            if (r4 != r5) goto L38
            int r0 = r2.I$0
            java.lang.Object r3 = r2.L$1
            java.util.Map r3 = (java.util.Map) r3
            java.lang.Object r2 = r2.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.b(r1)
            r4 = r0
            goto L65
        L38:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L40:
            kotlin.ResultKt.b(r1)
            com.transsion.ad.hi.HiSavanaAdManager r1 = com.transsion.ad.hi.HiSavanaAdManager.f42171a
            boolean r1 = r1.i()
            if (r1 != 0) goto L4e
            kotlin.Unit r0 = kotlin.Unit.f67184a
            return r0
        L4e:
            com.transsion.ad.scene.SceneInterceptManager r1 = com.transsion.ad.scene.SceneInterceptManager.f42254a
            r2.L$0 = r0
            r4 = r16
            r2.L$1 = r4
            r7 = r15
            r2.I$0 = r7
            r2.label = r5
            java.lang.Object r1 = r1.a(r14, r2)
            if (r1 != r3) goto L62
            return r3
        L62:
            r2 = r0
            r3 = r4
            r4 = r7
        L65:
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r0 = r1.getFirst()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L76
            kotlin.Unit r0 = kotlin.Unit.f67184a
            return r0
        L76:
            com.transsion.ad.scene.c r0 = com.transsion.ad.scene.c.f42257a
            r1 = 2
            r5 = 0
            r7 = 0
            boolean r0 = com.transsion.ad.scene.c.b(r0, r2, r7, r1, r5)
            if (r0 == 0) goto L84
            kotlin.Unit r0 = kotlin.Unit.f67184a
            return r0
        L84:
            java.util.concurrent.ConcurrentSkipListSet r0 = r6.f42051f
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L8f
            kotlin.Unit r0 = kotlin.Unit.f67184a
            return r0
        L8f:
            kotlinx.coroutines.i0 r0 = kotlinx.coroutines.y0.b()
            kotlinx.coroutines.n0 r7 = kotlinx.coroutines.o0.a(r0)
            com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider$preLoadAd$2 r10 = new com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider$preLoadAd$2
            r5 = 0
            r0 = r10
            r1 = r2
            r2 = r13
            r0.<init>(r1, r2, r3, r4, r5)
            r11 = 3
            r12 = 0
            r8 = 0
            r9 = 0
            kotlinx.coroutines.i.d(r7, r8, r9, r10, r11, r12)
            kotlin.Unit r0 = kotlin.Unit.f67184a
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.bidding.nativead.BiddingHiSspNativeProvider.q(java.lang.String, int, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void r(com.cloud.hisavana.sdk.api.listener.d dVar) {
        this.f42050e.remove(dVar);
    }

    public final void s(String str) {
        this.f42049d = str;
    }
}
