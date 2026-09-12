package com.transsion.rewardscenter.task.ad;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.config.utils.XLogUtil;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.transsion.ad.bidding.video.BiddingVideoManager;
import com.transsion.push.PushConstants;
import com.transsion.rewardscenter.task.ad.BaseStageTaskAdHelper;
import com.transsion.rewardscenter.task.ad.MemberTaskAdHelper;
import com.transsion.rewardscenter.task.ad.d;
import com.transsion.rewardscenter.task.ad.v;
import com.transsion.web.api.WebConstants;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000f\u0010\fJ\u000f\u0010\u0010\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0010\u0010\fJ\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\fJ\u000f\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0016\u0010\fJ\u001f\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\n¢\u0006\u0004\b#\u0010\fJ\r\u0010$\u001a\u00020\n¢\u0006\u0004\b$\u0010\fJ\u0015\u0010%\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b%\u0010\u0014J\r\u0010&\u001a\u00020\n¢\u0006\u0004\b&\u0010\fJ\u0017\u0010)\u001a\u00020\n2\b\u0010(\u001a\u0004\u0018\u00010'¢\u0006\u0004\b)\u0010*R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u000208078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/transsion/rewardscenter/task/ad/MemberTaskAdView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", CampaignEx.JSON_KEY_AD_R, "()V", "s", TtmlNode.TAG_P, "n", TmcStartParams.KEY_URL_SHORT, "", "packageName", "m", "(Ljava/lang/String;)V", CampaignEx.JSON_KEY_AD_K, "l", "Lcom/transsion/rewardscenter/task/ad/v$c;", WebConstants.FIELD_ITEM, "index", "w", "(Lcom/transsion/rewardscenter/task/ad/v$c;I)V", "Lcom/transsion/rewardscenter/task/ad/v$a;", "v", "(Lcom/transsion/rewardscenter/task/ad/v$a;I)V", "Lwp/a;", XLogUtil.TAG, "setCtxConfig", "(Lwp/a;)V", "onPause", "onResume", "onPackageInstall", PushConstants.PROVIDER_FIELD_DESTROY, "Lcom/transsion/rewardscenter/task/ad/BaseStageTaskAdHelper$a;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClaimListener", "(Lcom/transsion/rewardscenter/task/ad/BaseStageTaskAdHelper$a;)V", "Lcom/transsion/rewardscenter/task/ad/MemberTaskAdHelper;", "a", "Lcom/transsion/rewardscenter/task/ad/MemberTaskAdHelper;", "adHelper", "Lcom/transsion/rewardscenter/task/ad/d;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lcom/transsion/rewardscenter/task/ad/d;", "taskAdAdapter", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "taskAdRecycler", "", "Lcom/transsion/rewardscenter/task/ad/v;", "getFullList", "()Ljava/util/List;", "fullList", "RewardsCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class MemberTaskAdView extends ConstraintLayout {
    public static final int $stable = 8;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private MemberTaskAdHelper adHelper;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private d taskAdAdapter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private RecyclerView taskAdRecycler;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberTaskAdView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberTaskAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MemberTaskAdView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        r();
    }

    public /* synthetic */ MemberTaskAdView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final List<v> getFullList() {
        ArrayList arrayList = new ArrayList();
        List e11 = u.f51176a.e();
        ArrayList arrayList2 = new ArrayList(CollectionsKt.v(e11, 10));
        Iterator it = e11.iterator();
        while (it.hasNext()) {
            arrayList2.add(((v.c) it.next()).i());
        }
        Set W0 = CollectionsKt.W0(arrayList2);
        u uVar = u.f51176a;
        if (!uVar.e().isEmpty()) {
            arrayList.addAll(uVar.e());
        }
        if (!uVar.d().isEmpty()) {
            List d11 = uVar.d();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj : d11) {
                if (!W0.contains(((v.a) obj).i())) {
                    arrayList3.add(obj);
                }
            }
            arrayList.addAll(arrayList3);
        }
        arrayList.add(new v.b(null, 1, null));
        return arrayList;
    }

    private final void k() {
        List<Object> l11;
        MemberTaskAdHelper memberTaskAdHelper;
        d dVar = this.taskAdAdapter;
        if (dVar == null || (l11 = dVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        Iterator<T> it = l11.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int i12 = i11 + 1;
            v vVar = (v) it.next();
            if (vVar instanceof v.c) {
                MemberTaskAdHelper memberTaskAdHelper2 = this.adHelper;
                if (memberTaskAdHelper2 != null) {
                    v.c cVar = (v.c) vVar;
                    if (memberTaskAdHelper2.n(cVar)) {
                        a.C0856a.f(lg.a.f68962a, "StageTaskAd", "MemberTaskAdView----> update stage index: " + i11 + " state: " + cVar.e(), false, 4, null);
                        d dVar2 = this.taskAdAdapter;
                        if (dVar2 != null) {
                            dVar2.notifyItemChanged(i11);
                        }
                    }
                }
            } else if ((vVar instanceof v.a) && (memberTaskAdHelper = this.adHelper) != null) {
                v.a aVar = (v.a) vVar;
                if (memberTaskAdHelper.m(aVar)) {
                    a.C0856a.f(lg.a.f68962a, "StageTaskAd", "MemberTaskAdView----> update regular index: " + i11 + " state: " + aVar.e(), false, 4, null);
                    d dVar3 = this.taskAdAdapter;
                    if (dVar3 != null) {
                        dVar3.notifyItemChanged(i11);
                    }
                }
            }
            i11 = i12;
        }
    }

    private final void l() {
        List<Object> l11;
        d dVar;
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper == null || memberTaskAdHelper.h() != 0) {
            d dVar2 = this.taskAdAdapter;
            if (dVar2 == null || (l11 = dVar2.getData()) == null) {
                l11 = CollectionsKt.l();
            }
            Iterator<T> it = l11.iterator();
            int i11 = 0;
            while (it.hasNext()) {
                int i12 = i11 + 1;
                v vVar = (v) it.next();
                if (vVar instanceof v.c) {
                    MemberTaskAdHelper memberTaskAdHelper2 = this.adHelper;
                    if (memberTaskAdHelper2 != null && memberTaskAdHelper2.l((v.c) vVar) && (dVar = this.taskAdAdapter) != null) {
                        dVar.notifyItemChanged(i11);
                    }
                } else if (vVar instanceof v.a) {
                    v.a aVar = (v.a) vVar;
                    if (aVar.e() == AdTaskState.PLAYING) {
                        aVar.m(AdTaskState.PLAYED);
                        d dVar3 = this.taskAdAdapter;
                        if (dVar3 != null) {
                            dVar3.notifyItemChanged(i11);
                        }
                    }
                }
                i11 = i12;
            }
        }
    }

    private final void m(String packageName) {
        List<Object> l11;
        a.C0856a.f(lg.a.f68962a, "StageTaskAd", "MemberTaskAdView --> checkAdsInstallStatus packageName = " + packageName, false, 4, null);
        d dVar = this.taskAdAdapter;
        if (dVar == null || (l11 = dVar.getData()) == null) {
            l11 = CollectionsKt.l();
        }
        Iterator<T> it = l11.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            int i12 = i11 + 1;
            v vVar = (v) it.next();
            if (vVar instanceof v.c) {
                v.c cVar = (v.c) vVar;
                if (Intrinsics.c(cVar.i(), packageName)) {
                    w(cVar, i11);
                }
            } else if (vVar instanceof v.a) {
                v.a aVar = (v.a) vVar;
                if (Intrinsics.c(aVar.i(), packageName)) {
                    v(aVar, i11);
                }
            }
            i11 = i12;
        }
    }

    private final void n() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.X(new Function1() { // from class: com.transsion.rewardscenter.task.ad.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o11;
                    o11 = MemberTaskAdView.o(MemberTaskAdView.this, (List) obj);
                    return o11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00bf, code lost:
    
        if (r5 != false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit o(com.transsion.rewardscenter.task.ad.MemberTaskAdView r16, java.util.List r17) {
        /*
            Method dump skipped, instructions count: 276
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.rewardscenter.task.ad.MemberTaskAdView.o(com.transsion.rewardscenter.task.ad.MemberTaskAdView, java.util.List):kotlin.Unit");
    }

    private final void p() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.Z(new Function1() { // from class: com.transsion.rewardscenter.task.ad.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit q11;
                    q11 = MemberTaskAdView.q(MemberTaskAdView.this, (List) obj);
                    return q11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit q(MemberTaskAdView memberTaskAdView, List newStageItems) {
        Intrinsics.h(newStageItems, "newStageItems");
        List<v.c> list = newStageItems;
        ArrayList arrayList = new ArrayList(CollectionsKt.v(list, 10));
        for (v.c cVar : list) {
            AdTaskState l11 = u.f51176a.l(cVar.i());
            if (l11 != null) {
                cVar = cVar.a((r25 & 1) != 0 ? cVar.f51197a : null, (r25 & 2) != 0 ? cVar.f51198b : null, (r25 & 4) != 0 ? cVar.f51199c : null, (r25 & 8) != 0 ? cVar.f51200d : null, (r25 & 16) != 0 ? cVar.f51201e : l11, (r25 & 32) != 0 ? cVar.f51202f : null, (r25 & 64) != 0 ? cVar.f51203g : false, (r25 & 128) != 0 ? cVar.f51204h : 0L, (r25 & 256) != 0 ? cVar.f51205i : 0L);
            }
            arrayList.add(cVar);
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            v.c cVar2 = (v.c) obj;
            boolean z10 = cVar2.e().ordinal() > AdTaskState.NORMAL.ordinal();
            com.transsion.rewardscenter.utils.o oVar = com.transsion.rewardscenter.utils.o.f51365a;
            Context context = memberTaskAdView.getContext();
            Intrinsics.g(context, "getContext(...)");
            boolean a11 = oVar.a(context, cVar2.i());
            a.C0856a.f(lg.a.f68962a, "StageTaskAd", "Stage ----> restoreItem: " + z10 + ", isAppInstalled: " + a11, false, 4, null);
            if (z10 || !a11) {
                arrayList2.add(obj);
            }
        }
        List B0 = CollectionsKt.B0(u.f51176a.e(), arrayList2);
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : B0) {
            if (hashSet.add(((v.c) obj2).i())) {
                arrayList3.add(obj2);
            }
        }
        u.f51176a.t(CollectionsKt.K0(arrayList3, MemberTaskAdHelper.f51091r.b()));
        memberTaskAdView.u();
        return Unit.f67184a;
    }

    private final void r() {
        RecyclerView recyclerView = new RecyclerView(getContext());
        addView(recyclerView, new ConstraintLayout.b(-1, -1));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new d.a(16, 0, 2, null));
        this.taskAdRecycler = recyclerView;
    }

    private final void s() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            boolean z10 = memberTaskAdHelper.v() <= 0;
            boolean z11 = memberTaskAdHelper.w() <= 0;
            boolean z12 = memberTaskAdHelper.u() <= 0;
            boolean z13 = memberTaskAdHelper.t() <= 0;
            if (z10) {
                u uVar = u.f51176a;
                List e11 = uVar.e();
                ArrayList arrayList = new ArrayList();
                for (Object obj : e11) {
                    if (((v.c) obj).e().ordinal() >= AdTaskState.CLAIMED_STAGE1.ordinal()) {
                        arrayList.add(obj);
                    }
                }
                uVar.t(arrayList);
            }
            if (z11) {
                u.f51176a.t(CollectionsKt.l());
            }
            for (v.c cVar : u.f51176a.e()) {
                AdTaskState l11 = u.f51176a.l(cVar.i());
                if (l11 != null && cVar.e() != l11) {
                    cVar.m(l11);
                }
            }
            if (z12) {
                u uVar2 = u.f51176a;
                List d11 = uVar2.d();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : d11) {
                    if (!((v.a) obj2).k()) {
                        arrayList2.add(obj2);
                    }
                }
                uVar2.s(arrayList2);
            }
            if (z13) {
                u uVar3 = u.f51176a;
                List d12 = uVar3.d();
                ArrayList arrayList3 = new ArrayList();
                for (Object obj3 : d12) {
                    if (((v.a) obj3).k()) {
                        arrayList3.add(obj3);
                    }
                }
                uVar3.s(arrayList3);
            }
            for (v.a aVar : u.f51176a.d()) {
                AdTaskState l12 = u.f51176a.l(aVar.i());
                if (l12 != null && aVar.e() != l12) {
                    aVar.m(l12);
                }
            }
            u uVar4 = u.f51176a;
            int size = uVar4.e().size();
            MemberTaskAdHelper.a aVar2 = MemberTaskAdHelper.f51091r;
            boolean z14 = size < aVar2.b();
            boolean z15 = uVar4.d().size() < aVar2.a();
            if (!z10 && z14) {
                p();
            }
            if ((!z12 || !z13) && z15) {
                n();
            }
            d dVar = this.taskAdAdapter;
            if (dVar != null) {
                dVar.n1(getFullList());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit t(MemberTaskAdView memberTaskAdView) {
        memberTaskAdView.s();
        BiddingVideoManager.Companion.b(BiddingVideoManager.f42103w, "MemberTaskRewardedScene", null, 2, null);
        return Unit.f67184a;
    }

    private final void u() {
        d dVar = this.taskAdAdapter;
        if (dVar != null) {
            dVar.n1(getFullList());
        }
    }

    private final void v(v.a item, int index) {
        if (item.e() == AdTaskState.NORMAL || item.e() == AdTaskState.DOWNLOADING) {
            item.m(AdTaskState.INSTALLED);
            u.f51176a.v(item.i(), item.e());
            a.C0856a.f(lg.a.f68962a, "StageTaskAd", "MemberTaskAdView --> update regular index:" + index + " installed", false, 4, null);
            d dVar = this.taskAdAdapter;
            if (dVar != null) {
                dVar.notifyItemChanged(index);
            }
        }
    }

    private final void w(v.c item, int index) {
        if (item.e() == AdTaskState.NORMAL || item.e() == AdTaskState.DOWNLOADING) {
            item.m(AdTaskState.INSTALLED);
            u.f51176a.v(item.i(), item.e());
            a.C0856a.f(lg.a.f68962a, "StageTaskAd", "MemberTaskAdView --> update stage index:" + index + " installed", false, 4, null);
            d dVar = this.taskAdAdapter;
            if (dVar != null) {
                dVar.notifyItemChanged(index);
            }
        }
    }

    public final void destroy() {
        for (v.c cVar : u.f51176a.e()) {
            cVar.n(false);
            cVar.p(null);
            cVar.l(null);
            cVar.r(null);
        }
        for (v.a aVar : u.f51176a.d()) {
            aVar.n(false);
            aVar.p(null);
            aVar.l(null);
            aVar.q(null);
        }
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.d();
        }
        this.adHelper = null;
    }

    public final void onPackageInstall(String packageName) {
        Intrinsics.h(packageName, "packageName");
        m(packageName);
    }

    public final void onPause() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.o();
        }
    }

    public final void onResume() {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.p();
        }
        k();
        l();
    }

    public final void setClaimListener(BaseStageTaskAdHelper.a listener) {
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.x(listener);
        }
    }

    public final void setCtxConfig(wp.a config) {
        Intrinsics.h(config, "config");
        Context context = getContext();
        Intrinsics.g(context, "getContext(...)");
        this.adHelper = new MemberTaskAdHelper(context, config.b());
        d dVar = new d(this.adHelper);
        this.taskAdAdapter = dVar;
        RecyclerView recyclerView = this.taskAdRecycler;
        if (recyclerView != null) {
            recyclerView.setAdapter(dVar);
        }
        MemberTaskAdHelper memberTaskAdHelper = this.adHelper;
        if (memberTaskAdHelper != null) {
            memberTaskAdHelper.f(new Function0() { // from class: com.transsion.rewardscenter.task.ad.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit t11;
                    t11 = MemberTaskAdView.t(MemberTaskAdView.this);
                    return t11;
                }
            });
        }
    }
}
