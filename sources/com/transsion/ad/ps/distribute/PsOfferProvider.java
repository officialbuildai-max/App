package com.transsion.ad.ps.distribute;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.transsion.ad.db.pslink.PsLinkAdPlan;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.plan.AdPlanSourceManager;
import com.transsion.ad.ps.model.PsLinkAdInfo;
import com.transsion.ad.ps.model.RecommendInfo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ti.p;

/* loaded from: classes5.dex */
public final class PsOfferProvider {

    /* renamed from: a, reason: collision with root package name */
    public static final PsOfferProvider f42248a = new PsOfferProvider();

    private PsOfferProvider() {
    }

    private final void b(AdPlans adPlans, AdMaterialList adMaterialList, PsLinkAdPlan psLinkAdPlan) {
        if (psLinkAdPlan != null) {
            PsLinkAdInfo psLinkAdInfo = (PsLinkAdInfo) o.d(psLinkAdPlan.getPsLinkAdInfoStr(), PsLinkAdInfo.class);
            RecommendInfo recommendInfo = (RecommendInfo) o.d(psLinkAdPlan.getPsInfoJson(), RecommendInfo.class);
            adMaterialList.setPsLinkAdPlan(psLinkAdPlan);
            adMaterialList.setDownloadMaterialSuccess(true);
            adMaterialList.setType(AdMaterialList.NON_AD_TYPE_TEXT);
            adMaterialList.setTitle(psLinkAdInfo != null ? psLinkAdInfo.getTitle() : null);
            adMaterialList.setDesc(psLinkAdInfo != null ? psLinkAdInfo.getDesc() : null);
            adMaterialList.setPsRecommendInfo(recommendInfo);
            adMaterialList.setImage(new MbAdImage(null, psLinkAdInfo != null ? psLinkAdInfo.getUrl() : null, null, null, null, null, null, null, null, psLinkAdInfo != null ? psLinkAdInfo.getPath() : null, null, null, 3581, null));
            adMaterialList.setButtonText(psLinkAdInfo != null ? psLinkAdInfo.getButtonText() : null);
            if (adPlans != null) {
                adPlans.setAdvertiserName(psLinkAdInfo != null ? psLinkAdInfo.getAdvertiserName() : null);
                adPlans.setAdvertiserAvatar(psLinkAdInfo != null ? psLinkAdInfo.getAdvertiserAvatar() : null);
                adPlans.setAdvertiserAvatarPath(psLinkAdInfo != null ? psLinkAdInfo.getAdvertiserAvatarPath() : null);
            }
            if (adPlans != null) {
                adPlans.setExtImage(new MbAdImage(null, adPlans.getAdvertiserAvatar(), null, null, null, null, null, null, null, adPlans.getAdvertiserAvatarPath(), null, null, 3581, null));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x015c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x015a -> B:12:0x004d). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object c(com.transsion.ad.monopoly.model.AdPlans r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.distribute.PsOfferProvider.c(com.transsion.ad.monopoly.model.AdPlans, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String d() {
        String simpleName = PsOfferProvider.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final boolean f(String str) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (str != null && !StringsKt.q0(str)) {
                List S0 = StringsKt.S0(str, new String[]{","}, false, 0, 6, null);
                ArrayList arrayList = new ArrayList();
                Iterator it = S0.iterator();
                while (it.hasNext()) {
                    Integer v11 = StringsKt.v(StringsKt.n1((String) it.next()).toString());
                    if (v11 != null) {
                        arrayList.add(v11);
                    }
                }
                return CollectionsKt.W0(arrayList).contains(Integer.valueOf(Calendar.getInstance().get(11)));
            }
            return true;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Object m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
                m1185constructorimpl = Boolean.FALSE;
            }
            return ((Boolean) m1185constructorimpl).booleanValue();
        }
    }

    private final boolean h(PsLinkAdPlan psLinkAdPlan) {
        Integer showMax = psLinkAdPlan.getShowMax();
        if (showMax == null || showMax.intValue() != 0) {
            int showedTimes = psLinkAdPlan.getShowedTimes();
            Integer showMax2 = psLinkAdPlan.getShowMax();
            if (showedTimes >= (showMax2 != null ? showMax2.intValue() : 0)) {
                oi.a.k(oi.a.f71145a, d() + " --> isTimesAvailable() --> 不符合展示条件 --> id = " + psLinkAdPlan.getId() + " --> showedTimes = " + psLinkAdPlan.getShowedTimes() + " --> showMax = " + psLinkAdPlan.getShowMax(), 5, false, 4, null);
                return false;
            }
        }
        Integer clickMax = psLinkAdPlan.getClickMax();
        if (clickMax == null || clickMax.intValue() != 0) {
            int clickedTimes = psLinkAdPlan.getClickedTimes();
            Integer clickMax2 = psLinkAdPlan.getClickMax();
            if (clickedTimes >= (clickMax2 != null ? clickMax2.intValue() : 0)) {
                oi.a.k(oi.a.f71145a, d() + " --> isTimesAvailable() --> 不符合展示条件 --> id = " + psLinkAdPlan.getId() + " --> clickedTimes = " + psLinkAdPlan.getClickedTimes() + " --> clickMax = " + psLinkAdPlan.getClickMax(), 5, false, 4, null);
                return false;
            }
        }
        if (f(psLinkAdPlan.getShowHours())) {
            return true;
        }
        int i11 = Calendar.getInstance().get(11);
        oi.a.k(oi.a.f71145a, d() + " --> isTimesAvailable() --> 不符合展示条件 --> id = " + psLinkAdPlan.getId() + " --> showHours = " + psLinkAdPlan.getShowHours() + " --> currentHour = " + i11, 5, false, 4, null);
        return false;
    }

    private final Object i(PsLinkAdPlan psLinkAdPlan, Continuation continuation) {
        if (!TextUtils.equals(psLinkAdPlan != null ? psLinkAdPlan.getShowDate() : null, p.f76389a.c())) {
            if (psLinkAdPlan != null) {
                psLinkAdPlan.setShowedTimes(0);
            }
            if (psLinkAdPlan != null) {
                psLinkAdPlan.setClickedTimes(0);
            }
        }
        if (psLinkAdPlan != null) {
            psLinkAdPlan.setUpdateTimestamp(Boxing.e(System.currentTimeMillis()));
        }
        Object n11 = PsDbManager.f42243a.n(psLinkAdPlan, continuation);
        return n11 == IntrinsicsKt.f() ? n11 : Unit.f67184a;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(com.transsion.ad.monopoly.model.AdPlans r24, kotlin.coroutines.Continuation r25) {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            r2 = r25
            boolean r3 = r2 instanceof com.transsion.ad.ps.distribute.PsOfferProvider$getPsAdPlans$1
            if (r3 == 0) goto L19
            r3 = r2
            com.transsion.ad.ps.distribute.PsOfferProvider$getPsAdPlans$1 r3 = (com.transsion.ad.ps.distribute.PsOfferProvider$getPsAdPlans$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L19
            int r4 = r4 - r5
            r3.label = r4
            goto L1e
        L19:
            com.transsion.ad.ps.distribute.PsOfferProvider$getPsAdPlans$1 r3 = new com.transsion.ad.ps.distribute.PsOfferProvider$getPsAdPlans$1
            r3.<init>(r0, r2)
        L1e:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r5 = r3.label
            r6 = 1
            if (r5 == 0) goto L3b
            if (r5 != r6) goto L33
            java.lang.Object r1 = r3.L$0
            com.transsion.ad.monopoly.model.AdPlans r1 = (com.transsion.ad.monopoly.model.AdPlans) r1
            kotlin.ResultKt.b(r2)
            goto L49
        L33:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L3b:
            kotlin.ResultKt.b(r2)
            r3.L$0 = r1
            r3.label = r6
            java.lang.Object r2 = r0.c(r1, r3)
            if (r2 != r4) goto L49
            return r4
        L49:
            com.transsion.ad.db.pslink.PsLinkAdPlan r2 = (com.transsion.ad.db.pslink.PsLinkAdPlan) r2
            if (r2 != 0) goto L53
            r1 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r1)
            return r1
        L53:
            com.transsion.ad.monopoly.model.AdMaterialList r3 = new com.transsion.ad.monopoly.model.AdMaterialList
            r21 = 8191(0x1fff, float:1.1478E-41)
            r22 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r7 = r3
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
            if (r1 == 0) goto L78
            java.util.List r4 = kotlin.collections.CollectionsKt.e(r3)
            r1.setAdMaterialList(r4)
        L78:
            r0.b(r1, r3, r2)
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.a(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.ps.distribute.PsOfferProvider.e(com.transsion.ad.monopoly.model.AdPlans, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean g(AdPlans adPlans) {
        return TextUtils.equals(adPlans != null ? adPlans.getAdSource() : null, AdPlanSourceManager.AdPlanEnum.AD_PLAN_AD_SOURCE_PS_REFERRAL.getValue());
    }
}
