package com.transsion.ad.ps.attribution;

import com.transsion.ad.db.pslink.AttributionPoint;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.ps.model.RecommendInfo;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class AttributionProduceManager extends BaseAttributionProvider {

    /* renamed from: c, reason: collision with root package name */
    public static final AttributionProduceManager f42234c = new AttributionProduceManager();

    /* loaded from: classes5.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f42235a;

        static {
            int[] iArr = new int[AttributionPoint.AttributionType.values().length];
            try {
                iArr[AttributionPoint.AttributionType.DISPLAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AttributionPoint.AttributionType.CLICK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AttributionPoint.AttributionType.GP_CLICK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f42235a = iArr;
        }
    }

    private AttributionProduceManager() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
    
        if (r0 != null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void k(com.transsion.ad.monopoly.model.AdPlans r4, com.transsion.ad.db.pslink.AttributionPoint.AttributionType r5) {
        /*
            r3 = this;
            kotlin.Result$Companion r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L9
            if (r4 == 0) goto Lb
            java.util.List r4 = r4.getAdMaterialList()     // Catch: java.lang.Throwable -> L9
            goto Lc
        L9:
            r4 = move-exception
            goto L63
        Lb:
            r4 = 0
        Lc:
            if (r4 == 0) goto L5d
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Throwable -> L9
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L9
            r1 = 1
            r0 = r0 ^ r1
            if (r0 != r1) goto L5d
            r0 = 0
            java.lang.Object r4 = r4.get(r0)     // Catch: java.lang.Throwable -> L9
            com.transsion.ad.monopoly.model.AdMaterialList r4 = (com.transsion.ad.monopoly.model.AdMaterialList) r4     // Catch: java.lang.Throwable -> L9
            com.transsion.ad.ps.model.RecommendInfo r4 = r4.getPsRecommendInfo()     // Catch: java.lang.Throwable -> L9
            int[] r0 = com.transsion.ad.ps.attribution.AttributionProduceManager.a.f42235a     // Catch: java.lang.Throwable -> L9
            int r2 = r5.ordinal()     // Catch: java.lang.Throwable -> L9
            r0 = r0[r2]     // Catch: java.lang.Throwable -> L9
            java.lang.String r2 = ""
            if (r0 == r1) goto L50
            r1 = 2
            if (r0 == r1) goto L47
            r1 = 3
            if (r0 != r1) goto L41
            if (r4 == 0) goto L58
            java.lang.String r0 = r4.getGpAttributionLink()     // Catch: java.lang.Throwable -> L9
            if (r0 != 0) goto L3f
            goto L58
        L3f:
            r2 = r0
            goto L58
        L41:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException     // Catch: java.lang.Throwable -> L9
            r4.<init>()     // Catch: java.lang.Throwable -> L9
            throw r4     // Catch: java.lang.Throwable -> L9
        L47:
            if (r4 == 0) goto L58
            java.lang.String r0 = r4.getAttributionLink()     // Catch: java.lang.Throwable -> L9
            if (r0 != 0) goto L3f
            goto L58
        L50:
            if (r4 == 0) goto L58
            java.lang.String r0 = r4.getShowAttributionLink()     // Catch: java.lang.Throwable -> L9
            if (r0 != 0) goto L3f
        L58:
            com.transsion.ad.ps.attribution.AttributionProduceManager r0 = com.transsion.ad.ps.attribution.AttributionProduceManager.f42234c     // Catch: java.lang.Throwable -> L9
            r0.n(r4, r5, r2)     // Catch: java.lang.Throwable -> L9
        L5d:
            kotlin.Unit r4 = kotlin.Unit.f67184a     // Catch: java.lang.Throwable -> L9
            kotlin.Result.m1185constructorimpl(r4)     // Catch: java.lang.Throwable -> L9
            goto L6c
        L63:
            kotlin.Result$Companion r5 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            kotlin.Result.m1185constructorimpl(r4)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.attribution.AttributionProduceManager.k(com.transsion.ad.monopoly.model.AdPlans, com.transsion.ad.db.pslink.AttributionPoint$AttributionType):void");
    }

    private final void n(RecommendInfo recommendInfo, AttributionPoint.AttributionType attributionType, String str) {
        k.d(o0.a(y0.b()), null, null, new AttributionProduceManager$reportUrl$1(str, recommendInfo, attributionType, null), 3, null);
    }

    public final void l(AdPlans adPlans, AttributionPoint.AttributionType type) {
        Intrinsics.h(type, "type");
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.f42220a;
        if (adPlanSourceManager.j(adPlans) || adPlanSourceManager.l(adPlans)) {
            k(adPlans, type);
        }
    }

    public final void m(AdPlans adPlans) {
        AdPlanSourceManager adPlanSourceManager = AdPlanSourceManager.f42220a;
        if (adPlanSourceManager.j(adPlans) || adPlanSourceManager.l(adPlans)) {
            k(adPlans, AttributionPoint.AttributionType.DISPLAY);
        }
    }
}
