package com.transsnet.downloader.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$string;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.bean.DownloadResolutionItem;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$layout;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import lg.a;
import zm.a;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ'\u0010\u0017\u001a\u00020\f2\u000e\u0010\u0015\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00142\u0006\u0010\u0016\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u0012J\u0015\u0010 \u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\t¢\u0006\u0004\b \u0010\u0012J#\u0010%\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010$\u001a\u00020\t¢\u0006\u0004\b%\u0010&J#\u0010)\u001a\u00020\f2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020'0!2\u0006\u0010(\u001a\u00020\t¢\u0006\u0004\b)\u0010&J'\u0010,\u001a\u00020\f2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\f0*¢\u0006\u0004\b,\u0010-J'\u0010.\u001a\u00020\f2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\f0*¢\u0006\u0004\b.\u0010-J\u001b\u00100\u001a\u00020\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0/¢\u0006\u0004\b0\u00101J\u001b\u00102\u001a\u00020\f2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\f0/¢\u0006\u0004\b2\u00101J\u0017\u00105\u001a\u00020\f2\b\u00104\u001a\u0004\u0018\u000103¢\u0006\u0004\b5\u00106R\u0014\u00109\u001a\u0002038\u0002X\u0082D¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010=\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010CR*\u0010G\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\f\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR*\u0010I\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\f\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010FR\u001e\u0010L\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010KR\u001e\u0010N\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bM\u0010KR\u0016\u0010P\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010?R\u0016\u0010R\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010?R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010\u0010\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010?R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006W"}, d2 = {"Lcom/transsnet/downloader/widget/DownloadResolutionTabView;", "Lcom/noober/background/view/BLConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "n", "()V", TtmlNode.TAG_P, "curSeason", "t", "(I)V", "l", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "adapter", RequestParameters.POSITION, "o", "(Lcom/chad/library/adapter/base/BaseQuickAdapter;I)V", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", "setSubject", "(Lcom/transsion/moviedetailapi/bean/Subject;)V", "seasons", "setSeasons", "season", "setSeason", "", "Lcom/transsion/moviedetailapi/bean/DownloadResolutionItem;", "data", "resolutionPosition", "setResolutionContentData", "(Ljava/util/List;I)V", "Lcom/transsion/moviedetailapi/bean/DubsInfo;", "audioPosition", "setAudioContentData", "Lkotlin/Function2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setResolutionItemClickListener", "(Lkotlin/jvm/functions/Function2;)V", "setAudioItemClickListener", "Lkotlin/Function0;", "setSeasonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAudioClickListener", "", "name", "updateAudioTrack", "(Ljava/lang/String;)V", "a", "Ljava/lang/String;", "TAG", "Lpy/y0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lpy/y0;", "viewBinding", "c", "I", "dp16", "Lcom/transsnet/downloader/adapter/r;", "d", "Lcom/transsnet/downloader/adapter/r;", "resolutionTabAdapter", "e", "Lkotlin/jvm/functions/Function2;", "resolutionItemClickListener", "f", "audioItemClickListener", be.g.f16474b, "Lkotlin/jvm/functions/Function0;", "audioClickListener", "h", "seasonClickListener", "i", "curResPosition", com.mbridge.msdk.foundation.same.report.j.f35620b, "curAudioPosition", CampaignEx.JSON_KEY_AD_K, "Lcom/transsion/moviedetailapi/bean/Subject;", "m", "Ljava/lang/Integer;", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadResolutionTabView extends BLConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final py.y0 viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final int dp16;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.transsnet.downloader.adapter.r resolutionTabAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function2 resolutionItemClickListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function2 audioItemClickListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Function0 audioClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Function0 seasonClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int curResPosition;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int curAudioPosition;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Subject subject;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int curSeason;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Integer seasons;

    /* loaded from: classes7.dex */
    public static final class a implements zm.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseQuickAdapter f60268b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f60269c;

        a(BaseQuickAdapter baseQuickAdapter, int i11) {
            this.f60268b = baseQuickAdapter;
            this.f60269c = i11;
        }

        @Override // zm.a
        public void a(MemberCheckResult memberCheckResult) {
            a.C1007a.f(this, memberCheckResult);
        }

        @Override // zm.a
        public void b(MemberCheckResult memberCheckResult) {
            a.C1007a.d(this, memberCheckResult);
        }

        @Override // zm.a
        public void c(MemberCheckResult memberCheckResult) {
            a.C1007a.g(this, memberCheckResult);
        }

        @Override // zm.a
        public void d(MemberCheckResult memberCheckResult) {
            a.C1007a.e(this, memberCheckResult);
        }

        @Override // zm.a
        public void e() {
            a.C1007a.c(this);
            DownloadResolutionTabView downloadResolutionTabView = DownloadResolutionTabView.this;
            BaseQuickAdapter baseQuickAdapter = this.f60268b;
            Intrinsics.e(baseQuickAdapter);
            downloadResolutionTabView.o(baseQuickAdapter, this.f60269c);
        }

        @Override // zm.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C1007a.a(this, memberCheckResult);
        }

        @Override // zm.a
        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.C1007a.b(this, errorMsg);
            a.C0856a.f(lg.a.f68962a, "co_mem", "DownloadResolutionTabView --> initRvAndAdapter() --> 剧集选择分辨率 -->  " + errorMsg, false, 4, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.TAG = "DownloadResolutionTabView";
        this.dp16 = com.blankj.utilcode.util.a0.a(16.0f);
        this.curResPosition = -1;
        this.curAudioPosition = -1;
        this.curSeason = 1;
        View.inflate(context, R$layout.layout_download_re_resolution_tab, this);
        py.y0 a11 = py.y0.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        n();
    }

    private final void l() {
        com.transsnet.downloader.adapter.r rVar = new com.transsnet.downloader.adapter.r();
        rVar.E1(this.subject);
        rVar.w1(new p6.d() { // from class: com.transsnet.downloader.widget.v
            @Override // p6.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadResolutionTabView.m(DownloadResolutionTabView.this, baseQuickAdapter, view, i11);
            }
        });
        this.resolutionTabAdapter = rVar;
        RecyclerView recyclerView = this.viewBinding.f73114h;
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ig.a(dk.a.b(8), 0, 0, 0));
        }
        recyclerView.setAdapter(this.resolutionTabAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(DownloadResolutionTabView downloadResolutionTabView, BaseQuickAdapter adapter, View view, int i11) {
        IMemberApi iMemberApi;
        Intrinsics.h(adapter, "adapter");
        Intrinsics.h(view, "view");
        if (i11 == downloadResolutionTabView.curResPosition) {
            return;
        }
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_tips);
            return;
        }
        Object f02 = adapter.f0(i11);
        DownloadResolutionItem downloadResolutionItem = f02 instanceof DownloadResolutionItem ? (DownloadResolutionItem) f02 : null;
        if (downloadResolutionItem == null || (iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0])) == null) {
            return;
        }
        iMemberApi.o(Integer.valueOf(downloadResolutionItem.getResolution()), new a(adapter, i11));
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void n() {
        /*
            r3 = this;
            android.view.ViewGroup$LayoutParams r0 = r3.getLayoutParams()
            if (r0 == 0) goto L13
            android.view.ViewGroup$LayoutParams r0 = r3.getLayoutParams()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = (androidx.constraintlayout.widget.ConstraintLayout.b) r0
            if (r0 != 0) goto L1a
        L13:
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = new androidx.constraintlayout.widget.ConstraintLayout$b
            r1 = -1
            r2 = -2
            r0.<init>(r1, r2)
        L1a:
            int r1 = r3.dp16
            r0.setMarginStart(r1)
            int r1 = r3.dp16
            r0.setMarginEnd(r1)
            r3.setLayoutParams(r0)
            r3.l()
            r3.p()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.widget.DownloadResolutionTabView.n():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(BaseQuickAdapter adapter, int position) {
        Function2 function2;
        try {
            Object f02 = adapter.f0(this.curResPosition);
            DownloadResolutionItem downloadResolutionItem = f02 instanceof DownloadResolutionItem ? (DownloadResolutionItem) f02 : null;
            if (downloadResolutionItem != null) {
                downloadResolutionItem.setSelected(false);
            }
            adapter.notifyItemChanged(this.curResPosition, Boolean.FALSE);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Object f03 = adapter.f0(position);
        DownloadResolutionItem downloadResolutionItem2 = f03 instanceof DownloadResolutionItem ? (DownloadResolutionItem) f03 : null;
        if (downloadResolutionItem2 != null) {
            downloadResolutionItem2.setSelected(true);
        }
        adapter.notifyItemChanged(position, Boolean.TRUE);
        this.curResPosition = position;
        if (downloadResolutionItem2 == null || (function2 = this.resolutionItemClickListener) == null) {
            return;
        }
        function2.invoke(Integer.valueOf(position), downloadResolutionItem2);
    }

    private final void p() {
        this.viewBinding.f73108b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.s
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.q(DownloadResolutionTabView.this, view);
            }
        });
        this.viewBinding.f73115i.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.r(DownloadResolutionTabView.this, view);
            }
        });
        this.viewBinding.f73112f.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.u
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.s(DownloadResolutionTabView.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(DownloadResolutionTabView downloadResolutionTabView, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = downloadResolutionTabView.subject;
        Navigator.x(K.K("subject_id", subject != null ? subject.getSubjectId() : null), downloadResolutionTabView.getContext(), null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(DownloadResolutionTabView downloadResolutionTabView, View view) {
        a.C0856a.f(lg.a.f68962a, "DownloadDialog", "innerTvTitle click then switch audio track", false, 4, null);
        Function0 function0 = downloadResolutionTabView.audioClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(DownloadResolutionTabView downloadResolutionTabView, View view) {
        a.C0856a.f(lg.a.f68962a, "DownloadDialog", "Switch seasons", false, 4, null);
        com.blankj.utilcode.util.a.b();
        Function0 function0 = downloadResolutionTabView.seasonClickListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final void t(int curSeason) {
        this.curSeason = curSeason;
        Subject subject = this.subject;
        if (subject != null && subject.isTvType()) {
            BLTextView bLTextView = this.viewBinding.f73112f;
            Context context = getContext();
            bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, jn.f.a(curSeason)) : null);
            return;
        }
        Subject subject2 = this.subject;
        if (subject2 == null || !subject2.isEduType()) {
            BLTextView ivSeasons = this.viewBinding.f73112f;
            Intrinsics.g(ivSeasons, "ivSeasons");
            jg.c.g(ivSeasons);
        } else {
            BLTextView bLTextView2 = this.viewBinding.f73112f;
            Context context2 = getContext();
            bLTextView2.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, jn.f.a(curSeason)) : null);
        }
    }

    public final void setAudioClickListener(Function0<Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.audioClickListener = listener;
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x003e, code lost:
    
        if (r8.size() > 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void setAudioContentData(java.util.List<com.transsion.moviedetailapi.bean.DubsInfo> r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "data"
            kotlin.jvm.internal.Intrinsics.h(r8, r0)
            lg.a$a r1 = lg.a.f68962a
            int r0 = r8.size()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "setAudioContentData size:"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r3 = r2.toString()
            r5 = 4
            r6 = 0
            java.lang.String r2 = "DownloadDialog"
            r4 = 0
            lg.a.C0856a.f(r1, r2, r3, r4, r5, r6)
            r7.curAudioPosition = r9
            py.y0 r0 = r7.viewBinding
            com.noober.background.view.BLTextView r0 = r0.f73115i
            java.lang.String r1 = "tvLanguage"
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            r1 = r8
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 0
            if (r1 != 0) goto L41
            int r1 = r8.size()
            r3 = 1
            if (r1 <= r3) goto L41
            goto L42
        L41:
            r3 = r2
        L42:
            if (r3 == 0) goto L45
            goto L47
        L45:
            r2 = 8
        L47:
            r0.setVisibility(r2)
            if (r9 < 0) goto L63
            int r0 = r8.size()
            if (r9 >= r0) goto L63
            py.y0 r0 = r7.viewBinding
            com.noober.background.view.BLTextView r0 = r0.f73115i
            java.lang.Object r8 = r8.get(r9)
            com.transsion.moviedetailapi.bean.DubsInfo r8 = (com.transsion.moviedetailapi.bean.DubsInfo) r8
            java.lang.String r8 = r8.getLanName()
            r0.setText(r8)
        L63:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.widget.DownloadResolutionTabView.setAudioContentData(java.util.List, int):void");
    }

    public final void setAudioItemClickListener(Function2<? super Integer, ? super DubsInfo, Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.audioItemClickListener = listener;
    }

    public final void setResolutionContentData(List<DownloadResolutionItem> data, int resolutionPosition) {
        Intrinsics.h(data, "data");
        RecyclerView qualityRecyclerView = this.viewBinding.f73114h;
        Intrinsics.g(qualityRecyclerView, "qualityRecyclerView");
        jg.c.k(qualityRecyclerView);
        View vLine = this.viewBinding.f73117k;
        Intrinsics.g(vLine, "vLine");
        jg.c.k(vLine);
        this.curResPosition = resolutionPosition;
        com.transsnet.downloader.adapter.r rVar = this.resolutionTabAdapter;
        if (rVar != null) {
            List<DownloadResolutionItem> list = data;
            rVar.n1(list);
            if (list.isEmpty()) {
                return;
            }
            o(rVar, resolutionPosition);
        }
    }

    public final void setResolutionItemClickListener(Function2<? super Integer, ? super DownloadResolutionItem, Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.resolutionItemClickListener = listener;
    }

    public final void setSeason(int season) {
        t(season);
    }

    public final void setSeasonClickListener(Function0<Unit> listener) {
        Intrinsics.h(listener, "listener");
        this.seasonClickListener = listener;
    }

    public final void setSeasons(int seasons) {
        this.seasons = Integer.valueOf(seasons);
        if (seasons <= 1) {
            BLTextView ivSeasons = this.viewBinding.f73112f;
            Intrinsics.g(ivSeasons, "ivSeasons");
            jg.c.g(ivSeasons);
        } else {
            BLTextView ivSeasons2 = this.viewBinding.f73112f;
            Intrinsics.g(ivSeasons2, "ivSeasons");
            jg.c.k(ivSeasons2);
        }
    }

    public final void setSubject(Subject subject) {
        ResourceDetectors resourceDetectors;
        Intrinsics.h(subject, "subject");
        this.subject = subject;
        List<ResourceDetectors> resourceDetectors2 = subject.getResourceDetectors();
        if (resourceDetectors2 == null || (resourceDetectors = (ResourceDetectors) CollectionsKt.k0(resourceDetectors2)) == null) {
            return;
        }
        this.viewBinding.f73110d.setText(resourceDetectors.getUploadBy());
    }

    public final void updateAudioTrack(String name) {
        this.viewBinding.f73115i.setText(name);
    }
}
