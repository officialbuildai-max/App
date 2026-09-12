package com.transsion.commercialization.task;

import com.blankj.utilcode.util.Utils;
import com.therouter.TheRouter;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.monopoly.manager.AdSceneAssetsManager;
import com.transsion.commercialization.R$string;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.OpType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class DownloadInterceptAdHelper {

    /* renamed from: a, reason: collision with root package name */
    private final ok.b f43899a;

    /* renamed from: b, reason: collision with root package name */
    private final MemberCheckResult f43900b;

    /* renamed from: c, reason: collision with root package name */
    private final String f43901c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f43902d;

    /* renamed from: e, reason: collision with root package name */
    private BiddingNativeManager f43903e;

    /* renamed from: f, reason: collision with root package name */
    private OpType f43904f;

    /* renamed from: g, reason: collision with root package name */
    private AdInterceptDialog f43905g;

    public DownloadInterceptAdHelper(ok.b bVar, MemberCheckResult memberCheckResult, String str, boolean z10) {
        this.f43899a = bVar;
        this.f43900b = memberCheckResult;
        this.f43901c = str;
        this.f43902d = z10;
        this.f43904f = OpType.OP_AD;
    }

    public /* synthetic */ DownloadInterceptAdHelper(ok.b bVar, MemberCheckResult memberCheckResult, String str, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i11 & 2) != 0 ? null : memberCheckResult, (i11 & 4) != 0 ? null : str, (i11 & 8) != 0 ? false : z10);
    }

    private final void i() {
        ok.b bVar = this.f43899a;
        if (bVar != null) {
            bVar.a(false);
        }
        BiddingNativeManager biddingNativeManager = this.f43903e;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.f43905g = null;
    }

    private final String j(MemberCheckResult memberCheckResult) {
        return (memberCheckResult != null ? memberCheckResult.getMemberPrice() : null) + " " + (memberCheckResult != null ? memberCheckResult.getCurrency() : null) + " ";
    }

    private final void k() {
        kotlinx.coroutines.k.d(o0.a(y0.b()), null, null, new DownloadInterceptAdHelper$loadNativeAd$1(this, null), 3, null);
    }

    private final void l() {
        com.transsion.commercialization.pslink.a.f43883a.b(AdSceneAssetsManager.f42212b.getClassTag() + " --> showAdInterceptDialog() --> 广告任务 未完成 --> 结束流程");
        uh.b.f76876a.e(Utils.a().getString(R$string.co_cancel_tips));
        ok.b bVar = this.f43899a;
        if (bVar != null) {
            bVar.onFail();
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        com.transsion.commercialization.pslink.a.f43883a.a(AdSceneAssetsManager.f42212b.getClassTag() + " --> showAdInterceptDialog() --> 广告任务完成 --> 继续执行下载任务 --> 结束流程");
        ok.b bVar = this.f43899a;
        if (bVar != null) {
            bVar.onSuccess();
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.n(this.f43904f, new Function1() { // from class: com.transsion.commercialization.task.f
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit n11;
                    n11 = DownloadInterceptAdHelper.n(DownloadInterceptAdHelper.this, obj);
                    return n11;
                }
            });
        }
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit n(DownloadInterceptAdHelper downloadInterceptAdHelper, Object obj) {
        com.transsion.commercialization.pslink.a.f43883a.a(AdSceneAssetsManager.f42212b.getClassTag() + " --> checkMember() --> uploadOperationStat --> " + downloadInterceptAdHelper.f43904f + " --> success");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p(DownloadInterceptAdHelper downloadInterceptAdHelper, int i11) {
        if (i11 == 1) {
            downloadInterceptAdHelper.l();
        } else if (i11 == 2) {
            downloadInterceptAdHelper.m();
        }
        return Unit.f67184a;
    }

    public final void h() {
        k();
    }

    public final void o(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        MemberCheckResult memberCheckResult = this.f43900b;
        String interceptType = memberCheckResult != null ? memberCheckResult.getInterceptType() : null;
        OpType opType = OpType.OP_INSTALL;
        if (!Intrinsics.c(interceptType, opType.getValue())) {
            opType = OpType.OP_AD;
            Intrinsics.c(interceptType, opType.getValue());
        }
        this.f43904f = opType;
        ok.b bVar = this.f43899a;
        if (bVar != null) {
            bVar.a(true);
        }
        AdInterceptDialog adInterceptDialog = new AdInterceptDialog();
        this.f43905g = adInterceptDialog;
        adInterceptDialog.N0(j(this.f43900b));
        adInterceptDialog.I0(this.f43901c);
        adInterceptDialog.H0(this.f43902d);
        adInterceptDialog.F0(this.f43903e, biddingIntermediateMaterialBean);
        adInterceptDialog.G0(new Function1() { // from class: com.transsion.commercialization.task.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit p11;
                p11 = DownloadInterceptAdHelper.p(DownloadInterceptAdHelper.this, ((Integer) obj).intValue());
                return p11;
            }
        });
        adInterceptDialog.k0(com.blankj.utilcode.util.a.b(), "AdInterceptDialog");
    }
}
