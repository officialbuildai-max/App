package com.transsion.ad.monopoly.plan;

import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* loaded from: classes5.dex */
public final class AdPlanUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final AdPlanUtil f42221a = new AdPlanUtil();

    private AdPlanUtil() {
    }

    public final AdMaterialList a(AdPlans adPlans) {
        List<AdMaterialList> adMaterialList;
        List<AdMaterialList> adMaterialList2;
        if (adPlans == null || (adMaterialList = adPlans.getAdMaterialList()) == null || !(!adMaterialList.isEmpty()) || (adMaterialList2 = adPlans.getAdMaterialList()) == null) {
            return null;
        }
        return (AdMaterialList) CollectionsKt.k0(adMaterialList2);
    }

    public final AdPlans b(List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return null;
        }
        final Comparator comparator = new Comparator() { // from class: com.transsion.ad.monopoly.plan.AdPlanUtil$getHighestEcpmAdPlan$$inlined$compareByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                return ComparisonsKt.d(((AdPlans) t12).getEcpmCent(), ((AdPlans) t11).getEcpmCent());
            }
        };
        return (AdPlans) CollectionsKt.x0(list, new Comparator() { // from class: com.transsion.ad.monopoly.plan.AdPlanUtil$getHighestEcpmAdPlan$$inlined$thenBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t11, T t12) {
                int compare = comparator.compare(t11, t12);
                return compare != 0 ? compare : ComparisonsKt.d(((AdPlans) t11).getSort(), ((AdPlans) t12).getSort());
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.transsion.ad.ps.model.RecommendInfo c(com.transsion.ad.monopoly.model.AdPlans r4) {
        /*
            r3 = this;
            r0 = 0
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L14
            com.transsion.ad.monopoly.plan.AdPlanSourceManager r1 = com.transsion.ad.monopoly.plan.AdPlanSourceManager.f42220a     // Catch: java.lang.Throwable -> L14
            boolean r2 = r1.j(r4)     // Catch: java.lang.Throwable -> L14
            if (r2 != 0) goto L16
            boolean r1 = r1.l(r4)     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L12
            goto L16
        L12:
            r4 = r0
            goto L35
        L14:
            r4 = move-exception
            goto L3a
        L16:
            if (r4 == 0) goto L1d
            java.util.List r4 = r4.getAdMaterialList()     // Catch: java.lang.Throwable -> L14
            goto L1e
        L1d:
            r4 = r0
        L1e:
            r1 = r4
            java.util.Collection r1 = (java.util.Collection) r1     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L12
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L14
            if (r1 == 0) goto L2a
            goto L12
        L2a:
            r1 = 0
            java.lang.Object r4 = r4.get(r1)     // Catch: java.lang.Throwable -> L14
            com.transsion.ad.monopoly.model.AdMaterialList r4 = (com.transsion.ad.monopoly.model.AdMaterialList) r4     // Catch: java.lang.Throwable -> L14
            com.transsion.ad.ps.model.RecommendInfo r4 = r4.getPsRecommendInfo()     // Catch: java.lang.Throwable -> L14
        L35:
            java.lang.Object r4 = kotlin.Result.m1185constructorimpl(r4)     // Catch: java.lang.Throwable -> L14
            goto L44
        L3a:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r4 = kotlin.ResultKt.a(r4)
            java.lang.Object r4 = kotlin.Result.m1185constructorimpl(r4)
        L44:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r4)
            if (r1 != 0) goto L4b
            r0 = r4
        L4b:
            com.transsion.ad.ps.model.RecommendInfo r0 = (com.transsion.ad.ps.model.RecommendInfo) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.plan.AdPlanUtil.c(com.transsion.ad.monopoly.model.AdPlans):com.transsion.ad.ps.model.RecommendInfo");
    }
}
