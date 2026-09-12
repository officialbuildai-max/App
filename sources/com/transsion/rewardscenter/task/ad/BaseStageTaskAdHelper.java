package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdNativeInfo;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingSspNativeManager;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.rewardscenterapi.MemberTaskItem;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import lg.a;

/* loaded from: classes6.dex */
public abstract class BaseStageTaskAdHelper {

    /* renamed from: e, reason: collision with root package name */
    public static final b f51085e = new b(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f51086f = 8;

    /* renamed from: a, reason: collision with root package name */
    private final Context f51087a;

    /* renamed from: b, reason: collision with root package name */
    private final n0 f51088b;

    /* renamed from: c, reason: collision with root package name */
    private long f51089c;

    /* renamed from: d, reason: collision with root package name */
    private a f51090d;

    /* loaded from: classes6.dex */
    public interface a {
        void a(Integer num);

        void b();

        void start();
    }

    /* loaded from: classes6.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public BaseStageTaskAdHelper(Context context, n0 n0Var) {
        Intrinsics.h(context, "context");
        this.f51087a = context;
        this.f51088b = n0Var;
    }

    public static /* synthetic */ void A(BaseStageTaskAdHelper baseStageTaskAdHelper, v vVar, Function0 function0, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startClaim");
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        baseStageTaskAdHelper.z(vVar, function0);
    }

    public void c(v.c data) {
        Intrinsics.h(data, "data");
    }

    public void d() {
    }

    public final long e(String str) {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b(str);
        if (b11 == null || (jsonElement = b11.get("expDuration")) == null) {
            return 30000L;
        }
        return jsonElement.getAsLong();
    }

    public final void f(Function0 function0) {
        Unit unit;
        if (u.f51176a.j() != null) {
            if (function0 != null) {
                function0.invoke();
                unit = Unit.f67184a;
            } else {
                unit = null;
            }
            if (unit != null) {
                return;
            }
        }
        n0 n0Var = this.f51088b;
        if (n0Var != null) {
            kotlinx.coroutines.k.d(n0Var, null, null, new BaseStageTaskAdHelper$fetchMemberAdTaskInfo$2$1(function0, null), 3, null);
        }
    }

    public final String g(BiddingIntermediateMaterialBean adBean) {
        List<AdMaterialList> adMaterialList;
        AdMaterialList adMaterialList2;
        RecommendInfo psRecommendInfo;
        String packageName;
        AdsDTO adItem;
        Intrinsics.h(adBean, "adBean");
        if (adBean.getNativeInfo() != null) {
            TAdNativeInfo nativeInfo = adBean.getNativeInfo();
            if (nativeInfo == null || (packageName = nativeInfo.getPackageName()) == null) {
                return "";
            }
        } else if (adBean.getSspNativeInfo() != null) {
            TaNativeInfo sspNativeInfo = adBean.getSspNativeInfo();
            if (sspNativeInfo == null || (adItem = sspNativeInfo.getAdItem()) == null) {
                return "";
            }
            String psPackageName = adItem.getPsPackageName();
            packageName = (psPackageName == null || psPackageName.length() == 0) ? adItem.getPackageName() : adItem.getPsPackageName();
            if (packageName == null) {
                return "";
            }
        } else {
            AdPlans plans = adBean.getPlans();
            if (plans == null || (adMaterialList = plans.getAdMaterialList()) == null || (adMaterialList2 = adMaterialList.get(0)) == null || (psRecommendInfo = adMaterialList2.getPsRecommendInfo()) == null || (packageName = psRecommendInfo.getPackageName()) == null) {
                return "";
            }
        }
        return packageName;
    }

    public final long h() {
        return this.f51089c;
    }

    public final boolean i(BiddingIntermediateMaterialBean adBean) {
        RecommendInfo psRecommendInfo;
        Integer adType;
        List<AdMaterialList> adMaterialList;
        AdsDTO adItem;
        Integer pullNewestLive;
        AdsDTO adItem2;
        Integer pullNewestLive2;
        Intrinsics.h(adBean, "adBean");
        if (adBean.getSspNativeInfo() != null) {
            TaNativeInfo sspNativeInfo = adBean.getSspNativeInfo();
            if (sspNativeInfo == null || (adItem2 = sspNativeInfo.getAdItem()) == null || (pullNewestLive2 = adItem2.getPullNewestLive()) == null || pullNewestLive2.intValue() != 1) {
                TaNativeInfo sspNativeInfo2 = adBean.getSspNativeInfo();
                if (sspNativeInfo2 != null && (adItem = sspNativeInfo2.getAdItem()) != null && (pullNewestLive = adItem.getPullNewestLive()) != null && pullNewestLive.intValue() == 2) {
                    return true;
                }
            } else if (!com.transsion.rewardscenter.utils.o.f51365a.a(this.f51087a, g(adBean))) {
                return true;
            }
        } else {
            AdPlans plans = adBean.getPlans();
            AdMaterialList adMaterialList2 = (plans == null || (adMaterialList = plans.getAdMaterialList()) == null) ? null : (AdMaterialList) CollectionsKt.k0(adMaterialList);
            if (adMaterialList2 != null && (psRecommendInfo = adMaterialList2.getPsRecommendInfo()) != null && (adType = psRecommendInfo.getAdType()) != null && adType.intValue() == 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(v.a aVar) {
        return (aVar != null ? aVar.e() : null) == AdTaskState.DOWNLOADING && aVar.g() > 0 && System.currentTimeMillis() - aVar.g() > 180000;
    }

    public final boolean k(v.c cVar) {
        return (cVar != null ? cVar.e() : null) == AdTaskState.DOWNLOADING && cVar.g() > 0 && System.currentTimeMillis() - cVar.g() > 180000;
    }

    public final boolean l(v.c cVar) {
        if (cVar == null || cVar.e() != AdTaskState.PLAYING) {
            return false;
        }
        cVar.q(System.currentTimeMillis() - this.f51089c);
        a.C0856a.f(lg.a.f68962a, "StageTaskAd", "----> onResume playedTime: " + cVar.j(), false, 4, null);
        if (cVar.j() >= e(cVar.c().getSceneId())) {
            cVar.m(AdTaskState.PLAYED);
            u.f51176a.v(cVar.i(), cVar.e());
            return true;
        }
        com.transsion.rewardscenter.utils.p.a(false, "Play for 30 seconds to get the reward.");
        cVar.m(AdTaskState.CLAIMED_STAGE1);
        u.f51176a.v(cVar.i(), cVar.e());
        return true;
    }

    public final boolean m(v.a aVar) {
        boolean z10;
        boolean z11;
        if (aVar == null) {
            return false;
        }
        if (aVar.e() == AdTaskState.DOWNLOADING) {
            if (com.transsion.rewardscenter.utils.o.f51365a.a(this.f51087a, aVar.i())) {
                aVar.m(AdTaskState.INSTALLED);
                u.f51176a.v(aVar.i(), aVar.e());
                z11 = false;
                z10 = true;
            } else if (j(aVar)) {
                aVar.m(AdTaskState.NORMAL);
                aVar.o(0L);
                u.f51176a.v(aVar.i(), aVar.e());
                z10 = false;
                z11 = true;
            }
            return !z10 || z11;
        }
        z10 = false;
        z11 = false;
        if (z10) {
        }
    }

    public final boolean n(v.c cVar) {
        boolean z10;
        boolean z11;
        if (cVar == null) {
            return false;
        }
        AdTaskState e11 = cVar.e();
        AdTaskState adTaskState = AdTaskState.NORMAL;
        if (e11 == adTaskState || cVar.e() == AdTaskState.DOWNLOADING) {
            if (com.transsion.rewardscenter.utils.o.f51365a.a(this.f51087a, cVar.i())) {
                cVar.m(AdTaskState.INSTALLED);
                u.f51176a.v(cVar.i(), cVar.e());
                z11 = false;
                z10 = true;
            } else if (k(cVar)) {
                cVar.m(adTaskState);
                cVar.o(0L);
                u.f51176a.v(cVar.i(), cVar.e());
                z10 = false;
                z11 = true;
            }
            return !z10 || z11;
        }
        z10 = false;
        z11 = false;
        if (z10) {
        }
    }

    public final void o() {
        this.f51089c = System.currentTimeMillis();
    }

    public final void p() {
    }

    public final int q(String str) {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b(str);
        if (b11 == null || (jsonElement = b11.get("cooldownDays")) == null) {
            return 3;
        }
        return jsonElement.getAsInt();
    }

    public final void r() {
        if (v() > 0) {
            BiddingSspNativeManager.Companion.b(BiddingSspNativeManager.A, "MemberTaskStageNativeScene", null, 2, null);
        }
        if (u() > 0 || t() > 0) {
            BiddingSspNativeManager.Companion.b(BiddingSspNativeManager.A, "MemberTaskRegularNativeScene", null, 2, null);
        }
    }

    public final int s(MemberTaskItem memberTaskItem) {
        Integer totalProgress;
        if (memberTaskItem == null) {
            return 0;
        }
        Integer status = memberTaskItem.getStatus();
        if ((status != null && status.intValue() == 3) || (totalProgress = memberTaskItem.getTotalProgress()) == null) {
            return 0;
        }
        int intValue = totalProgress.intValue();
        Integer progress = memberTaskItem.getProgress();
        return intValue - (progress != null ? progress.intValue() : 0);
    }

    public final int t() {
        return s(u.f51176a.g());
    }

    public final int u() {
        return s(u.f51176a.h());
    }

    public final int v() {
        return s(u.f51176a.j());
    }

    public final int w() {
        return s(u.f51176a.k());
    }

    public final void x(a aVar) {
        this.f51090d = aVar;
    }

    public final void y(String packageName, Integer num) {
        Intrinsics.h(packageName, "packageName");
        u.f51176a.u(packageName, num);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z(com.transsion.rewardscenter.task.ad.v r11, kotlin.jvm.functions.Function0 r12) {
        /*
            r10 = this;
            com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper$a r0 = r10.f51090d
            if (r0 == 0) goto L7
            r0.start()
        L7:
            boolean r0 = r11 instanceof com.transsion.rewardscenter.task.ad.v.c
            r1 = 0
            if (r0 == 0) goto L26
            r0 = r11
            com.transsion.rewardscenter.task.ad.v$c r0 = (com.transsion.rewardscenter.task.ad.v.c) r0
            com.transsion.rewardscenter.task.ad.AdTaskState r0 = r0.e()
            com.transsion.rewardscenter.task.ad.AdTaskState r2 = com.transsion.rewardscenter.task.ad.AdTaskState.INSTALLED
            if (r0 != r2) goto L1e
            com.transsion.rewardscenter.task.ad.u r0 = com.transsion.rewardscenter.task.ad.u.f51176a
            com.transsion.rewardscenterapi.MemberTaskItem r0 = r0.j()
            goto L24
        L1e:
            com.transsion.rewardscenter.task.ad.u r0 = com.transsion.rewardscenter.task.ad.u.f51176a
            com.transsion.rewardscenterapi.MemberTaskItem r0 = r0.k()
        L24:
            r3 = r0
            goto L4d
        L26:
            boolean r0 = r11 instanceof com.transsion.rewardscenter.task.ad.v.a
            if (r0 == 0) goto L41
            r0 = r11
            com.transsion.rewardscenter.task.ad.v$a r0 = (com.transsion.rewardscenter.task.ad.v.a) r0
            boolean r0 = r0.k()
            if (r0 == 0) goto L3a
            com.transsion.rewardscenter.task.ad.u r0 = com.transsion.rewardscenter.task.ad.u.f51176a
            com.transsion.rewardscenterapi.MemberTaskItem r0 = r0.h()
            goto L24
        L3a:
            com.transsion.rewardscenter.task.ad.u r0 = com.transsion.rewardscenter.task.ad.u.f51176a
            com.transsion.rewardscenterapi.MemberTaskItem r0 = r0.g()
            goto L24
        L41:
            boolean r0 = r11 instanceof com.transsion.rewardscenter.task.ad.v.b
            if (r0 == 0) goto L4c
            com.transsion.rewardscenter.task.ad.u r0 = com.transsion.rewardscenter.task.ad.u.f51176a
            com.transsion.rewardscenterapi.MemberTaskItem r0 = r0.i()
            goto L24
        L4c:
            r3 = r1
        L4d:
            if (r3 == 0) goto L69
            kotlinx.coroutines.n0 r0 = r10.f51088b
            if (r0 == 0) goto L67
            com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper$startClaim$1$1 r1 = new com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper$startClaim$1$1
            r7 = 0
            r2 = r1
            r4 = r10
            r5 = r11
            r6 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            r8 = 3
            r9 = 0
            r5 = 0
            r6 = 0
            r4 = r0
            r7 = r1
            kotlinx.coroutines.t1 r1 = kotlinx.coroutines.i.d(r4, r5, r6, r7, r8, r9)
        L67:
            if (r1 != 0) goto L78
        L69:
            com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper$a r11 = r10.f51090d
            if (r11 == 0) goto L70
            r11.b()
        L70:
            r11 = 0
            java.lang.String r12 = "Failed to claim points."
            com.transsion.rewardscenter.utils.p.a(r11, r12)
            kotlin.Unit r11 = kotlin.Unit.f67184a
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper.z(com.transsion.rewardscenter.task.ad.v, kotlin.jvm.functions.Function0):void");
    }
}
