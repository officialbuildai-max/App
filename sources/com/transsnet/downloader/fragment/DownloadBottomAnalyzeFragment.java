package com.transsnet.downloader.fragment;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatTextView;
import com.airbnb.lottie.LottieAnimationView;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.moviedetailapi.DownloadItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.web.api.WebConstants;
import com.transsion.web.api.WebPageIdentity;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.DownloadUrlBean;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import lg.a;

@Deprecated
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0007*\u0001f\b\u0017\u0018\u0000 j2\u00020\u0001:\u0001kB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0003J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JQ\u0010\u001b\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001a\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010\"\u001a\u00020!2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b\"\u0010#J!\u0010$\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016¢\u0006\u0004\b$\u0010%J\u001f\u0010(\u001a\u00020\u00042\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010&¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0003R\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010\u0015\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00100R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010>\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00100R\u0016\u0010@\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010;R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00100R\u0018\u0010C\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00100R\u0018\u0010E\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u00100R\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u0002098\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bL\u0010;R\u001b\u0010S\u001a\u00020N8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u001b\u0010X\u001a\u00020T8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010P\u001a\u0004\bV\u0010WRr\u0010`\u001a^\u0012\u0013\u0012\u00110H¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(\\\u0012\u0013\u0012\u00110\u0013¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(]\u0012\u0013\u0012\u00110\u000b¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(\f\u0012\u0013\u0012\u001109¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(M\u0012\u0004\u0012\u00020\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R3\u0010e\u001a\u001f\u0012\u0013\u0012\u001109¢\u0006\f\bZ\u0012\b\b[\u0012\u0004\b\b(b\u0012\u0004\u0012\u00020\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010i\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006l"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadBottomAnalyzeFragment;", "Lcom/transsion/baseui/dialog/BaseDialog;", "<init>", "()V", "", "M0", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "P0", "(Landroid/view/View;)V", "V0", "Lcom/transsion/baselib/db/download/DownloadBean;", "downloadBean", "U0", "(Lcom/transsion/baselib/db/download/DownloadBean;)V", "Lcom/transsnet/downloader/bean/DownloadUrlBean;", "urlBean", "S0", "(Lcom/transsnet/downloader/bean/DownloadUrlBean;)V", "", "pageName", "pageFrom", "subjectId", "postId", "ops", "resourceId", "taskId", "J0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lkotlin/Function0;", "animaCallback", "Q0", "(Lkotlin/jvm/functions/Function0;)V", "onDestroy", "Lpy/y;", "c", "Lpy/y;", "viewBinding", "d", "Ljava/lang/String;", "e", "lastPageFrom", "Lcom/transsion/moviedetailapi/bean/Subject;", "f", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", be.g.f16474b, "groupId", "", "h", "Z", "animaOnly", "i", "linkUrl", com.mbridge.msdk.foundation.same.report.j.f35620b, "isCheckingLinkUrl", CampaignEx.JSON_KEY_AD_K, "l", "resource", "m", "moduleName", "n", "Lcom/transsion/baselib/db/download/DownloadBean;", "", "o", "I", "localProgress", TtmlNode.TAG_P, "isCancel", "Lcom/transsnet/downloader/manager/g;", CampaignEx.JSON_KEY_AD_Q, "Lkotlin/Lazy;", "K0", "()Lcom/transsnet/downloader/manager/g;", "downloadManager", "Lcom/transsnet/downloader/manager/StartDownloadHelper;", CampaignEx.JSON_KEY_AD_R, "L0", "()Lcom/transsnet/downloader/manager/StartDownloadHelper;", "startDownloadHelper", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "count", "formatSize", "s", "Lkotlin/jvm/functions/Function4;", "itemSelectListener", "Lkotlin/Function1;", "isClose", "t", "Lkotlin/jvm/functions/Function1;", "closeListener", "com/transsnet/downloader/fragment/DownloadBottomAnalyzeFragment$runnable$1", TmcStartParams.KEY_URL_SHORT, "Lcom/transsnet/downloader/fragment/DownloadBottomAnalyzeFragment$runnable$1;", "runnable", "v", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public class DownloadBottomAnalyzeFragment extends BaseDialog {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private py.y viewBinding;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private String pageFrom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Subject subject;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean animaOnly;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String linkUrl;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isCheckingLinkUrl;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String resource;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private DownloadBean downloadBean;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int localProgress;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private boolean isCancel;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Lazy downloadManager;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final Lazy startDownloadHelper;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private Function4 itemSelectListener;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private Function1 closeListener;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private final DownloadBottomAnalyzeFragment$runnable$1 runnable;

    /* loaded from: classes7.dex */
    public static final class b implements Animator.AnimatorListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f58923b;

        b(Function0 function0) {
            this.f58923b = function0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
            if (DownloadBottomAnalyzeFragment.this.isAdded() && !DownloadBottomAnalyzeFragment.this.isStateSaved()) {
                Function0 function0 = this.f58923b;
                if (function0 != null) {
                    function0.invoke();
                }
                DownloadBottomAnalyzeFragment.this.dismiss();
            }
            Function1 function1 = DownloadBottomAnalyzeFragment.this.closeListener;
            if (function1 != null) {
                function1.invoke(Boolean.FALSE);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
            Intrinsics.h(animation, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            Intrinsics.h(animation, "animation");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f58924a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f58924a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f58924a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.view.c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f58924a.invoke(obj);
        }
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$runnable$1] */
    public DownloadBottomAnalyzeFragment() {
        super(R$layout.fragment_download_res_ana);
        this.pageFrom = "";
        this.lastPageFrom = "";
        this.downloadManager = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsnet.downloader.manager.g I0;
                I0 = DownloadBottomAnalyzeFragment.I0();
                return I0;
            }
        });
        this.startDownloadHelper = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.u
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                StartDownloadHelper W0;
                W0 = DownloadBottomAnalyzeFragment.W0();
                return W0;
            }
        });
        this.runnable = new Runnable() { // from class: com.transsnet.downloader.fragment.DownloadBottomAnalyzeFragment$runnable$1
            @Override // java.lang.Runnable
            public void run() {
                int i11;
                py.y yVar;
                int i12;
                py.y yVar2;
                AppCompatTextView appCompatTextView;
                py.y yVar3;
                boolean z10;
                AppCompatTextView appCompatTextView2;
                ProgressBar progressBar;
                int i13;
                DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment = DownloadBottomAnalyzeFragment.this;
                i11 = downloadBottomAnalyzeFragment.localProgress;
                downloadBottomAnalyzeFragment.localProgress = i11 + 1;
                yVar = DownloadBottomAnalyzeFragment.this.viewBinding;
                if (yVar != null && (progressBar = yVar.f73104c) != null) {
                    i13 = DownloadBottomAnalyzeFragment.this.localProgress;
                    progressBar.setProgress(i13);
                }
                i12 = DownloadBottomAnalyzeFragment.this.localProgress;
                if (i12 < 100) {
                    yVar2 = DownloadBottomAnalyzeFragment.this.viewBinding;
                    if (yVar2 == null || (appCompatTextView = yVar2.f73106e) == null) {
                        return;
                    }
                    appCompatTextView.postDelayed(this, 20L);
                    return;
                }
                yVar3 = DownloadBottomAnalyzeFragment.this.viewBinding;
                if (yVar3 != null && (appCompatTextView2 = yVar3.f73106e) != null) {
                    appCompatTextView2.removeCallbacks(this);
                }
                z10 = DownloadBottomAnalyzeFragment.this.isCheckingLinkUrl;
                if (z10) {
                    return;
                }
                DownloadBottomAnalyzeFragment.R0(DownloadBottomAnalyzeFragment.this, null, 1, null);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final com.transsnet.downloader.manager.g I0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J0(String pageName, String pageFrom, String subjectId, String postId, String ops, String resourceId, String taskId) {
        HashMap hashMap = new HashMap();
        hashMap.put(WebConstants.PAGE_FROM, pageFrom);
        hashMap.put("subject_id", subjectId);
        hashMap.put("post_id", postId);
        hashMap.put("ops", ops);
        hashMap.put("resource_id", resourceId);
        hashMap.put("task_id", taskId);
        hashMap.put("module_name", this.moduleName);
        hj.i iVar = hj.i.f64628a;
        if (pageName == null) {
            pageName = "download_click";
        }
        iVar.s(pageName, "download_click", hashMap);
        Bundle bundle = new Bundle();
        bundle.putString("resource_id", resourceId);
        bundle.putString("subject_id", subjectId);
        com.transsion.baselib.report.e.f43398a.l("download_click", bundle, getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsnet.downloader.manager.g K0() {
        return (com.transsnet.downloader.manager.g) this.downloadManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StartDownloadHelper L0() {
        return (StartDownloadHelper) this.startDownloadHelper.getValue();
    }

    private final void M0() {
        HashMap g11;
        AppCompatTextView appCompatTextView;
        py.y yVar = this.viewBinding;
        if (yVar != null && (appCompatTextView = yVar.f73105d) != null) {
            appCompatTextView.setText(getString(R$string.download_analyzing) + " from " + this.resource);
        }
        if (this.animaOnly) {
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g11 = logViewConfig.g()) != null) {
                g11.put("anima_only", "true");
            }
            a.C0856a.f(lg.a.f68962a, "downloadAna", "anima only~}", false, 4, null);
            return;
        }
        a.C0856a.f(lg.a.f68962a, "downloadAna", "single， initData subject is null = " + (this.subject == null) + ", ", false, 4, null);
        String str = this.linkUrl;
        if (str == null || str.length() <= 0) {
            Subject subject = this.subject;
            if (subject != null) {
                if (subject != null) {
                    kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadBottomAnalyzeFragment$initData$3$1(subject, this, null), 3, null);
                    return;
                }
                return;
            } else {
                androidx.view.b0 z10 = DownloadListManager.f60117m.a().z();
                if (z10 != null) {
                    z10.j(this, new c(new Function1() { // from class: com.transsnet.downloader.fragment.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit O0;
                            O0 = DownloadBottomAnalyzeFragment.O0(DownloadBottomAnalyzeFragment.this, (List) obj);
                            return O0;
                        }
                    }));
                    return;
                }
                return;
            }
        }
        this.isCheckingLinkUrl = true;
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        DownloadListManager a11 = aVar.a();
        Subject subject2 = this.subject;
        String subjectId = subject2 != null ? subject2.getSubjectId() : null;
        String str2 = this.linkUrl;
        Intrinsics.e(str2);
        a11.P(subjectId, str2);
        androidx.view.b0 Q = aVar.a().Q();
        if (Q != null) {
            Q.j(this, new c(new Function1() { // from class: com.transsnet.downloader.fragment.r
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit N0;
                    N0 = DownloadBottomAnalyzeFragment.N0(DownloadBottomAnalyzeFragment.this, (DownloadUrlBean) obj);
                    return N0;
                }
            }));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, DownloadUrlBean downloadUrlBean) {
        downloadBottomAnalyzeFragment.isCheckingLinkUrl = false;
        downloadBottomAnalyzeFragment.S0(downloadUrlBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, List list) {
        List list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return Unit.f67184a;
        }
        kotlinx.coroutines.k.d(androidx.view.v.a(downloadBottomAnalyzeFragment), null, null, new DownloadBottomAnalyzeFragment$initData$2$1(list, downloadBottomAnalyzeFragment, null), 3, null);
        return Unit.f67184a;
    }

    private final void P0(View view) {
        LottieAnimationView lottieAnimationView;
        ProgressBar progressBar;
        py.y a11 = py.y.a(view);
        this.viewBinding = a11;
        if (a11 != null && (progressBar = a11.f73104c) != null) {
            progressBar.setMax(100);
        }
        py.y yVar = this.viewBinding;
        if (yVar != null && (lottieAnimationView = yVar.f73103b) != null) {
            lottieAnimationView.playAnimation();
            lottieAnimationView.setRepeatCount(-1);
        }
        V0();
    }

    public static /* synthetic */ void R0(DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment, Function0 function0, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onAnalyzeSuccess");
        }
        if ((i11 & 1) != 0) {
            function0 = null;
        }
        downloadBottomAnalyzeFragment.Q0(function0);
    }

    private final void S0(DownloadUrlBean urlBean) {
        if ((urlBean != null ? urlBean.getResource() : null) != null) {
            DownloadItem resource = urlBean.getResource();
            String url = resource != null ? resource.getUrl() : null;
            if (url != null && url.length() != 0) {
                DownloadItem resource2 = urlBean.getResource();
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = urlBean.getTotalEpisode();
                kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new DownloadBottomAnalyzeFragment$onGetUrlDownloadConfig$2(resource2, this, intRef, urlBean, null), 3, null);
                return;
            }
        }
        a.C0856a.f(lg.a.f68962a, "downloadAna", "url has no resource, open url", false, 4, null);
        Q0(new Function0() { // from class: com.transsnet.downloader.fragment.v
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit T0;
                T0 = DownloadBottomAnalyzeFragment.T0(DownloadBottomAnalyzeFragment.this);
                return T0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(DownloadBottomAnalyzeFragment downloadBottomAnalyzeFragment) {
        Navigator.x(TheRouter.c(WebPageIdentity.WEB_VIEW).K("url", downloadBottomAnalyzeFragment.linkUrl), downloadBottomAnalyzeFragment.getContext(), null, 2, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(DownloadBean downloadBean) {
    }

    private final void V0() {
        AppCompatTextView appCompatTextView;
        LottieAnimationView lottieAnimationView;
        py.y yVar = this.viewBinding;
        if (yVar != null && (lottieAnimationView = yVar.f73103b) != null) {
            lottieAnimationView.setRepeatCount(-1);
            lottieAnimationView.setAnimation(ak.x.f733a.a() ? "download_analyzing_anima_night.json" : "download_analyzing_anima.json");
            lottieAnimationView.playAnimation();
        }
        py.y yVar2 = this.viewBinding;
        if (yVar2 == null || (appCompatTextView = yVar2.f73106e) == null) {
            return;
        }
        appCompatTextView.post(this.runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartDownloadHelper W0() {
        return new StartDownloadHelper();
    }

    public final void Q0(Function0 animaCallback) {
        LottieAnimationView lottieAnimationView;
        ProgressBar progressBar;
        AppCompatTextView appCompatTextView;
        py.y yVar = this.viewBinding;
        if (yVar != null && (appCompatTextView = yVar.f73106e) != null) {
            appCompatTextView.removeCallbacks(this.runnable);
        }
        py.y yVar2 = this.viewBinding;
        if (yVar2 != null && (progressBar = yVar2.f73104c) != null) {
            progressBar.setProgress(100);
        }
        py.y yVar3 = this.viewBinding;
        if (yVar3 == null || (lottieAnimationView = yVar3.f73103b) == null) {
            return;
        }
        lottieAnimationView.setAnimation(ak.x.f733a.a() ? "download_analyzing_success_anima_night.json" : "download_analyzing_success_anima.json");
        lottieAnimationView.setRepeatCount(0);
        lottieAnimationView.addAnimatorListener(new b(animaCallback));
        lottieAnimationView.playAnimation();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        HashMap g11;
        HashMap g12;
        HashMap g13;
        HashMap g14;
        String string;
        super.onCreate(savedInstanceState);
        setCancelable(false);
        setStyle(0, R$style.BottomDialogTheme);
        Bundle arguments = getArguments();
        String str7 = "";
        if (arguments == null || (str = arguments.getString("extra_page_from")) == null) {
            str = "";
        }
        this.pageFrom = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("extra_last_page_from")) == null) {
            str2 = "";
        }
        this.lastPageFrom = str2;
        Bundle arguments3 = getArguments();
        this.subject = (Subject) (arguments3 != null ? arguments3.getSerializable("extra_subject") : null);
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str3 = arguments4.getString("extra_group_id")) == null) {
            str3 = "";
        }
        this.groupId = str3;
        Bundle arguments5 = getArguments();
        this.animaOnly = arguments5 != null ? arguments5.getBoolean("extra_anima_only") : false;
        Bundle arguments6 = getArguments();
        if (arguments6 == null || (str4 = arguments6.getString("extra_link_url")) == null) {
            str4 = "";
        }
        this.linkUrl = str4;
        Bundle arguments7 = getArguments();
        if (arguments7 == null || (str5 = arguments7.getString("extra_ops")) == null) {
            str5 = "";
        }
        this.ops = str5;
        Bundle arguments8 = getArguments();
        if (arguments8 == null || (str6 = arguments8.getString("extra_resource")) == null) {
            str6 = "";
        }
        this.resource = str6;
        Bundle arguments9 = getArguments();
        if (arguments9 != null && (string = arguments9.getString("extra_module_name")) != null) {
            str7 = string;
        }
        this.moduleName = str7;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g14 = logViewConfig.g()) != null) {
            g14.put(WebConstants.PAGE_FROM, this.pageFrom);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g13 = logViewConfig2.g()) != null) {
            g13.put("last_page_from", this.lastPageFrom);
        }
        hj.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g12 = logViewConfig3.g()) != null) {
            g12.put("ops", this.ops);
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 == null || (g11 = logViewConfig4.g()) == null) {
            return;
        }
        g11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "1");
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        a.C0856a.f(lg.a.f68962a, "TAG", "onCreateDialog: ", false, 4, null);
        Context requireContext = requireContext();
        Intrinsics.g(requireContext, "requireContext(...)");
        com.google.android.material.bottomsheet.c cVar = new com.google.android.material.bottomsheet.c(requireContext, getTheme());
        Window window = cVar.getWindow();
        if (window != null) {
            window.setWindowAnimations(R$style.BaseBottomDialogAnimation);
        }
        Window window2 = cVar.getWindow();
        if (window2 != null) {
            window2.setGravity(80);
            window2.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window2.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            }
            attributes.width = com.transsion.baseui.util.a.f43556a.b(requireContext);
            attributes.height = com.blankj.utilcode.util.a0.a(168.0f);
            window2.setBackgroundDrawable(null);
            window2.setAttributes(attributes);
        }
        return cVar;
    }

    @Override // com.transsion.baseui.dialog.BaseDialog, androidx.fragment.app.Fragment
    public void onDestroy() {
        String str;
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        aVar.a().Y(null);
        aVar.a().b0(null);
        super.onDestroy();
        DownloadBean downloadBean = this.downloadBean;
        if (downloadBean != null) {
            Long size = downloadBean.getSize();
            if (size == null || (str = oh.b.a(size.longValue(), 1)) == null) {
                str = "";
            }
            Function4 function4 = this.itemSelectListener;
            if (function4 != null) {
                function4.invoke(1, str, downloadBean, Boolean.valueOf(this.isCancel));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.onViewCreated(view, savedInstanceState);
        P0(view);
        M0();
    }
}
