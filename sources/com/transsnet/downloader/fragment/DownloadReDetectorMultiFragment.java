package com.transsnet.downloader.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.noober.background.view.BLFrameLayout;
import com.therouter.TheRouter;
import com.tn.lib.widget.R$string;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.commercializationapi.ITaskCenterApi;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.memberapi.MemberSceneType;
import com.transsion.moviedetailapi.bean.ResourcesSeason;
import com.transsion.moviedetailapi.bean.ResourcesSeasonList;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.push.PushConstants;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.bean.DownloadListBean;
import com.transsnet.downloader.fragment.DownloadReDetectorMultiFragment;
import com.transsnet.downloader.manager.StartDownloadHelper;
import com.transsnet.downloader.viewmodel.DownloadListManager;
import com.transsnet.downloader.viewmodel.DownloadResourcesDetectorViewModel;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import lg.a;
import ok.b;
import zm.a;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u008c\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002\u008d\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001d\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\r\u0010\fJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u000f\u0010\u001b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001b\u0010\u0005J\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0002¢\u0006\u0004\b!\u0010\"JQ\u0010+\u001a\u00020\u00062\b\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010%\u001a\u00020#2\b\u0010&\u001a\u0004\u0018\u00010#2\b\u0010'\u001a\u0004\u0018\u00010#2\b\u0010(\u001a\u0004\u0018\u00010#2\b\u0010)\u001a\u0004\u0018\u00010#2\u0006\u0010*\u001a\u00020#H\u0002¢\u0006\u0004\b+\u0010,J\u000f\u0010-\u001a\u00020\u0006H\u0002¢\u0006\u0004\b-\u0010\u0005J\u000f\u0010.\u001a\u00020\u0010H\u0002¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\u0006H\u0016¢\u0006\u0004\b0\u0010\u0005J\u0019\u00103\u001a\u00020\u00062\b\u00102\u001a\u0004\u0018\u000101H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u00020\u00022\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020#H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010<\u001a\u00020;H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u0010>\u001a\u00020;H\u0016¢\u0006\u0004\b>\u0010=J\u000f\u0010?\u001a\u00020\u0006H\u0016¢\u0006\u0004\b?\u0010\u0005J\u000f\u0010@\u001a\u00020\u0006H\u0016¢\u0006\u0004\b@\u0010\u0005J\u000f\u0010A\u001a\u00020\u0006H\u0016¢\u0006\u0004\bA\u0010\u0005J\u000f\u0010B\u001a\u00020\u0006H\u0016¢\u0006\u0004\bB\u0010\u0005J\u000f\u0010C\u001a\u00020\u0006H\u0016¢\u0006\u0004\bC\u0010\u0005J-\u0010G\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00102\f\u0010E\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010F\u001a\u00020;H\u0016¢\u0006\u0004\bG\u0010HJ!\u0010K\u001a\u00020\u00062\u0006\u0010D\u001a\u00020\u00102\b\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bK\u0010LJ\u0017\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020;H\u0016¢\u0006\u0004\bN\u0010OJ\u0017\u0010P\u001a\u00020\u00062\u0006\u0010M\u001a\u00020;H\u0016¢\u0006\u0004\bP\u0010OR\u0018\u0010T\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010X\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010VR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b]\u0010VR\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010VR\u0018\u0010a\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b`\u0010VR\u0018\u0010c\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010VR\u0016\u0010f\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010i\u001a\u00020I8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0016\u0010k\u001a\u00020#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010VR\u0014\u0010n\u001a\u00020l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010mR\u0016\u0010p\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010oR\u0016\u0010r\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010oR\u0018\u0010v\u001a\u0004\u0018\u00010s8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bt\u0010uR(\u0010z\u001a\u0014\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010yR\"\u0010|\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020;0w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010yR$\u0010~\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010I0w8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010yR\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u0018\u0010\u0083\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010oR\u0018\u0010\u0085\u0001\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010eR!\u0010\u008b\u0001\u001a\u00030\u0086\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0006\b\u0089\u0001\u0010\u008a\u0001¨\u0006\u008e\u0001"}, d2 = {"Lcom/transsnet/downloader/fragment/DownloadReDetectorMultiFragment;", "Lcom/transsnet/downloader/fragment/DownloadReDetectorBaseFragment;", "Lpy/b0;", "Lny/c;", "<init>", "()V", "", "initView", "", "Lcom/transsion/moviedetailapi/bean/ResourcesSeason;", "data", "p1", "(Ljava/util/List;)V", "V0", "Lcom/google/android/material/tabs/TabLayout;", "tabView", "", TtmlNode.RIGHT, "s1", "(Lcom/google/android/material/tabs/TabLayout;I)V", "Lcom/transsnet/downloader/bean/DownloadListBean;", "listBean", "m1", "(Lcom/transsnet/downloader/bean/DownloadListBean;)V", "o1", "n1", "k1", "j1", "Lcom/transsnet/downloader/fragment/DownloadMultiListFragment;", "Z0", "()Lcom/transsnet/downloader/fragment/DownloadMultiListFragment;", "", "Lcom/transsion/baselib/db/download/DownloadBean;", "X0", "()Ljava/util/List;", "", "pageName", "pageFrom", "subjectId", "postId", "ops", "resourceId", "taskId", "Y0", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "W0", "a1", "()I", "initViewData", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "Landroid/view/LayoutInflater;", "inflater", "c1", "(Landroid/view/LayoutInflater;)Lpy/b0;", "getPageStateLayoutTitle", "()Ljava/lang/String;", "", "isAudioShowNoNetworkLayout", "()Z", "isMonitorNetworkState", "initViewModel", "initListener", "retryLoadData", "x0", "onDestroy", RequestParameters.POSITION, "selectedList", IntegrationConstants.NAVIGATION_BAR_ALL_ACTION, CampaignEx.JSON_KEY_AD_K, "(ILjava/util/List;Z)V", "", "size", "x", "(ILjava/lang/Long;)V", PushConstants.PUSH_SERVICE_TYPE_SHOW, "w", "(Z)V", "U", "Lcom/transsnet/downloader/adapter/l;", "l", "Lcom/transsnet/downloader/adapter/l;", "mAdapter", "m", "Ljava/lang/String;", "n", "lastPageFrom", "Lcom/transsion/moviedetailapi/bean/Subject;", "o", "Lcom/transsion/moviedetailapi/bean/Subject;", "subject", TtmlNode.TAG_P, "groupId", CampaignEx.JSON_KEY_AD_Q, CampaignEx.JSON_KEY_AD_R, "targetResourceId", "s", "moduleName", "t", "Z", "isSelectAll", TmcStartParams.KEY_URL_SHORT, "J", "localTotalSize", "v", "formatSize", "Lkotlinx/coroutines/n0;", "Lkotlinx/coroutines/n0;", "downloadCoroutineScope", "I", "targetSeason", "y", "curSeason", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "z", "Lcom/transsnet/downloader/viewmodel/DownloadResourcesDetectorViewModel;", "groupMainViewModel", "", "A", "Ljava/util/Map;", "checkedList", "B", "allCheckMap", "C", "sizeMap", "D", "Ljava/lang/Integer;", "currentResolution", "E", "resolution", "F", "showPremiumIfNeed", "Lcom/transsnet/downloader/manager/StartDownloadHelper;", "G", "Lkotlin/Lazy;", "b1", "()Lcom/transsnet/downloader/manager/StartDownloadHelper;", "startDownloadHelper", "H", "a", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes7.dex */
public final class DownloadReDetectorMultiFragment extends DownloadReDetectorBaseFragment<py.b0> implements ny.c {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private Integer currentResolution;

    /* renamed from: E, reason: from kotlin metadata */
    private int resolution;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean showPremiumIfNeed;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private com.transsnet.downloader.adapter.l mAdapter;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Subject subject;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private String groupId;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private String ops;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String targetResourceId;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private String moduleName;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private long localTotalSize;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private int targetSeason;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    private DownloadResourcesDetectorViewModel groupMainViewModel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String pageFrom = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String lastPageFrom = "";

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private String formatSize = "";

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private final kotlinx.coroutines.n0 downloadCoroutineScope = kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b());

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private int curSeason = 1;

    /* renamed from: A, reason: from kotlin metadata */
    private Map checkedList = new LinkedHashMap();

    /* renamed from: B, reason: from kotlin metadata */
    private Map allCheckMap = new LinkedHashMap();

    /* renamed from: C, reason: from kotlin metadata */
    private Map sizeMap = new LinkedHashMap();

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy startDownloadHelper = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.fragment.e3
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            StartDownloadHelper r12;
            r12 = DownloadReDetectorMultiFragment.r1();
            return r12;
        }
    });

    /* renamed from: com.transsnet.downloader.fragment.DownloadReDetectorMultiFragment$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DownloadReDetectorMultiFragment a(String str, String str2, Subject subject, String str3, String str4, String str5, String str6, int i11) {
            DownloadReDetectorMultiFragment downloadReDetectorMultiFragment = new DownloadReDetectorMultiFragment();
            downloadReDetectorMultiFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("extra_page_from", str), TuplesKt.a("extra_last_page_from", str2), TuplesKt.a("extra_subject", subject), TuplesKt.a("extra_group_id", str3), TuplesKt.a("extra_ops", str4), TuplesKt.a("extra_target_resource_id", str5), TuplesKt.a("extra_module_name", str6), TuplesKt.a("extra_season", Integer.valueOf(i11))));
            return downloadReDetectorMultiFragment;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ok.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit c(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment) {
            downloadReDetectorMultiFragment.k1();
            return Unit.f67184a;
        }

        @Override // ok.b
        public void a(boolean z10) {
            b.a.a(this, z10);
        }

        @Override // ok.b
        public void onFail() {
            ok.c.f71157a.a(DownloadReDetectorMultiFragment.this.getClassTag() + " --> interception() --> onFail() --> 失败了");
        }

        @Override // ok.b
        public void onSuccess() {
            FragmentActivity activity = DownloadReDetectorMultiFragment.this.getActivity();
            if (activity != null) {
                final DownloadReDetectorMultiFragment downloadReDetectorMultiFragment = DownloadReDetectorMultiFragment.this;
                Subject subject = downloadReDetectorMultiFragment.subject;
                if (subject != null) {
                    com.transsnet.downloader.manager.f.f59601a.a().j(activity, subject, new Function0() { // from class: com.transsnet.downloader.fragment.n3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit c11;
                            c11 = DownloadReDetectorMultiFragment.b.c(DownloadReDetectorMultiFragment.this);
                            return c11;
                        }
                    });
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements zm.a {
        c() {
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
            DownloadReDetectorMultiFragment.this.n1();
        }

        @Override // zm.a
        public void f(MemberCheckResult memberCheckResult) {
            a.C1007a.a(this, memberCheckResult);
        }

        @Override // zm.a
        public void onFail(String errorMsg) {
            Intrinsics.h(errorMsg, "errorMsg");
            a.C1007a.b(this, errorMsg);
            a.C0856a.f(lg.a.f68962a, "co_mem", "DownloadReDetectorGroupMainFragment --> onSelectAllClickIfNeed() --> 剧集全选 --> " + errorMsg, false, 4, null);
        }
    }

    /* loaded from: classes7.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f59087a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f59087a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f59087a;
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
            this.f59087a.invoke(obj);
        }
    }

    /* loaded from: classes7.dex */
    public static final class e implements TabLayout.OnTabSelectedListener {
        e() {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            DownloadReDetectorMultiFragment.this.W0();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void V0(List data) {
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var != null) {
            TabLayout subjectTab = b0Var.f72733m;
            Intrinsics.g(subjectTab, "subjectTab");
            subjectTab.setVisibility(data.size() > 1 ? 0 : 8);
            p1(data);
            int i11 = 0;
            int i12 = 0;
            for (Object obj : data) {
                int i13 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                if (((ResourcesSeason) obj).getSe() == this.targetSeason) {
                    i12 = i11;
                }
                i11 = i13;
            }
            TabLayout subjectTab2 = b0Var.f72733m;
            Intrinsics.g(subjectTab2, "subjectTab");
            s1(subjectTab2, dk.a.b(12));
            if (b0Var.f72743w.isFakeDragging()) {
                return;
            }
            b0Var.f72743w.setCurrentItem(i12, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void W0() {
        AppCompatImageView appCompatImageView;
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var == null || (appCompatImageView = b0Var.f72727g) == null) {
            return;
        }
        Boolean bool = (Boolean) this.allCheckMap.get(Integer.valueOf(a1()));
        appCompatImageView.setSelected(bool != null ? bool.booleanValue() : false);
    }

    private final List X0() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.checkedList.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.addAll((Collection) ((Map.Entry) it.next()).getValue());
        }
        return arrayList;
    }

    private final void Y0(String pageName, String pageFrom, String subjectId, String postId, String ops, String resourceId, String taskId) {
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

    /* JADX WARN: Multi-variable type inference failed */
    private final DownloadMultiListFragment Z0() {
        ViewPager2 viewPager2;
        py.b0 b0Var = (py.b0) getMViewBinding();
        int f11 = RangesKt.f((b0Var == null || (viewPager2 = b0Var.f72743w) == null) ? 0 : viewPager2.getCurrentItem(), 0);
        com.transsnet.downloader.adapter.l lVar = this.mAdapter;
        if (lVar != null) {
            return lVar.g(f11);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int a1() {
        TabLayout tabLayout;
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var == null || (tabLayout = b0Var.f72733m) == null) {
            return 0;
        }
        return tabLayout.getSelectedTabPosition();
    }

    private final StartDownloadHelper b1() {
        return (StartDownloadHelper) this.startDownloadHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment, View view) {
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        List X0 = downloadReDetectorMultiFragment.X0();
        if (X0.isEmpty()) {
            uh.b.f76876a.d(com.transsnet.downloader.R$string.download_unselected_tips);
            return;
        }
        DownloadBean downloadBean = (DownloadBean) CollectionsKt.k0(X0);
        if (downloadBean != null) {
            com.transsion.baselib.report.launch.b.f43424a.b().putInt("download_last_resolution", downloadBean.getResolution());
        }
        ITaskCenterApi iTaskCenterApi = (ITaskCenterApi) TheRouter.d(ITaskCenterApi.class, new Object[0]);
        if (iTaskCenterApi != null) {
            Integer num = downloadReDetectorMultiFragment.currentResolution;
            DownloadBean downloadBean2 = (DownloadBean) CollectionsKt.k0(X0);
            iTaskCenterApi.f(num, downloadBean2 != null ? downloadBean2.getGenre() : null, new b(), MemberSceneType.SCENE_HDDL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment, View view) {
        downloadReDetectorMultiFragment.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment, View view) {
        downloadReDetectorMultiFragment.o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment, View view) {
        downloadReDetectorMultiFragment.o1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit h1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment, int i11, ResourcesSeasonList resourcesSeasonList) {
        List<ResourcesSeason> seasons;
        a.C0856a c0856a = lg.a.f68962a;
        String tag = downloadReDetectorMultiFragment.getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "获取当前季跟分辨率的信息,resolution:" + i11 + ", curSeason:" + downloadReDetectorMultiFragment.curSeason, false, 4, null);
        Subject subject = downloadReDetectorMultiFragment.subject;
        if (subject != null) {
            subject.setSubjectType(resourcesSeasonList != null ? resourcesSeasonList.getSubjectType() : null);
        }
        if (resourcesSeasonList != null && (seasons = resourcesSeasonList.getSeasons()) != null) {
            downloadReDetectorMultiFragment.V0(seasons);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment, DownloadListBean downloadListBean) {
        downloadReDetectorMultiFragment.m1(downloadListBean);
        return Unit.f67184a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void initView() {
        LinearLayoutCompat linearLayoutCompat;
        AppCompatImageView appCompatImageView;
        AppCompatTextView appCompatTextView;
        ImageView imageView;
        CoordinatorLayout coordinatorLayout;
        ViewGroup.LayoutParams layoutParams;
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var != null && (coordinatorLayout = b0Var.f72723c) != null && (layoutParams = coordinatorLayout.getLayoutParams()) != null) {
            layoutParams.height = q0();
        }
        py.b0 b0Var2 = (py.b0) getMViewBinding();
        if (b0Var2 != null && (imageView = b0Var2.f72728h) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.h3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorMultiFragment.e1(DownloadReDetectorMultiFragment.this, view);
                }
            });
        }
        py.b0 b0Var3 = (py.b0) getMViewBinding();
        if (b0Var3 != null && (appCompatTextView = b0Var3.f72737q) != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.i3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorMultiFragment.f1(DownloadReDetectorMultiFragment.this, view);
                }
            });
        }
        py.b0 b0Var4 = (py.b0) getMViewBinding();
        if (b0Var4 != null && (appCompatImageView = b0Var4.f72727g) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.j3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DownloadReDetectorMultiFragment.g1(DownloadReDetectorMultiFragment.this, view);
                }
            });
        }
        py.b0 b0Var5 = (py.b0) getMViewBinding();
        if (b0Var5 == null || (linearLayoutCompat = b0Var5.f72722b) == null) {
            return;
        }
        linearLayoutCompat.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.fragment.k3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadReDetectorMultiFragment.d1(DownloadReDetectorMultiFragment.this, view);
            }
        });
    }

    private final void j1() {
        androidx.view.b0 p11;
        androidx.view.b0 i11;
        List X0 = X0();
        if (X0.isEmpty()) {
            return;
        }
        DownloadResourcesDetectorViewModel viewModel = getViewModel();
        if (viewModel != null && (i11 = viewModel.i()) != null) {
            i11.q(new com.transsnet.downloader.viewmodel.b(X0.size(), this.formatSize, (DownloadBean) X0.get(0), false));
        }
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 == null || (p11 = viewModel2.p()) == null) {
            return;
        }
        p11.q(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void k1() {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        AppCompatTextView appCompatTextView;
        AppCompatImageView appCompatImageView;
        View view;
        FrameLayout frameLayout;
        if (u0(this.localTotalSize)) {
            return;
        }
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var != null && (frameLayout = b0Var.f72725e) != null && frameLayout.getVisibility() == 0) {
            lg.a.f68962a.p("download", new String[]{"DownloadReDetectorGroupMainFragment --> onDownload() --> 当前正在全选中"}, true);
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String tag = getTAG();
        Intrinsics.g(tag, "<get-TAG>(...)");
        a.C0856a.f(c0856a, tag, "onDownload ", false, 4, null);
        py.b0 b0Var2 = (py.b0) getMViewBinding();
        if (b0Var2 != null && (view = b0Var2.f72741u) != null) {
            jg.c.k(view);
        }
        py.b0 b0Var3 = (py.b0) getMViewBinding();
        if (b0Var3 != null && (appCompatImageView = b0Var3.f72726f) != null) {
            jg.c.g(appCompatImageView);
        }
        py.b0 b0Var4 = (py.b0) getMViewBinding();
        if (b0Var4 != null && (appCompatTextView = b0Var4.f72734n) != null) {
            jg.c.g(appCompatTextView);
        }
        py.b0 b0Var5 = (py.b0) getMViewBinding();
        if (b0Var5 != null && (progressBar2 = b0Var5.f72731k) != null) {
            jg.c.k(progressBar2);
        }
        List X0 = X0();
        int i11 = 0;
        for (Object obj : X0) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            DownloadBean downloadBean = (DownloadBean) obj;
            String uuid = UUID.randomUUID().toString();
            Intrinsics.g(uuid, "toString(...)");
            downloadBean.setTaskId(uuid);
            Y0(this.pageFrom, this.lastPageFrom, downloadBean.getSubjectId(), downloadBean.getPostId(), this.ops, downloadBean.getResourceId(), uuid);
            lg.a.f68962a.p("download", new String[]{"剧集多资源，下载点击，开始下载: subjectId = " + downloadBean.getSubjectId() + ",resourceId = " + downloadBean.getResourceId() + ", name = " + downloadBean.getTotalTitleName()}, true);
            i11 = i12;
        }
        p0().D(X0);
        b1().f(X0);
        kotlinx.coroutines.k.d(this.downloadCoroutineScope, null, null, new DownloadReDetectorMultiFragment$onDownload$2(X0, this, null), 3, null);
        long size = ((X0.size() / 20) * 100) + 300;
        py.b0 b0Var6 = (py.b0) getMViewBinding();
        if (b0Var6 == null || (progressBar = b0Var6.f72731k) == null) {
            return;
        }
        progressBar.postDelayed(new Runnable() { // from class: com.transsnet.downloader.fragment.l3
            @Override // java.lang.Runnable
            public final void run() {
                DownloadReDetectorMultiFragment.l1(DownloadReDetectorMultiFragment.this);
            }
        }, size);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment) {
        downloadReDetectorMultiFragment.j1();
    }

    private final void m1(DownloadListBean listBean) {
        if (listBean == null || listBean.getResolutionList() == null) {
            return;
        }
        this.showPremiumIfNeed = true;
        Integer resolution = listBean.getResolution();
        int intValue = resolution != null ? resolution.intValue() : 0;
        this.resolution = intValue;
        com.transsnet.downloader.adapter.l lVar = this.mAdapter;
        if (lVar != null) {
            lVar.m(Integer.valueOf(intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void n1() {
        py.b0 b0Var;
        AppCompatImageView appCompatImageView;
        DownloadMultiListFragment Z0 = Z0();
        if ((Z0 != null && !Z0.j1()) || (b0Var = (py.b0) getMViewBinding()) == null || (appCompatImageView = b0Var.f72727g) == null) {
            return;
        }
        appCompatImageView.setSelected(!appCompatImageView.isSelected());
        this.isSelectAll = appCompatImageView.isSelected();
        DownloadMultiListFragment Z02 = Z0();
        if (Z02 != null) {
            Z02.l1(this.isSelectAll);
        }
    }

    private final void o1() {
        DownloadMultiListFragment Z0;
        if (this.isSelectAll || (Z0 = Z0()) == null || !Z0.b1()) {
            n1();
            return;
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            DownloadMultiListFragment Z02 = Z0();
            iMemberApi.o(Z02 != null ? Z02.Y0() : null, new c());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void p1(List data) {
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var != null) {
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.g(requireActivity, "requireActivity(...)");
            com.transsnet.downloader.adapter.l lVar = new com.transsnet.downloader.adapter.l(requireActivity, this);
            lVar.k(this.ops);
            lVar.o(this.subject);
            lVar.i(this.groupId);
            lVar.l(this.pageFrom);
            lVar.j(this.lastPageFrom);
            lVar.n(this.showPremiumIfNeed);
            lVar.p(this.targetResourceId);
            lVar.q(this.targetSeason);
            lVar.setData(data);
            this.mAdapter = lVar;
            b0Var.f72743w.setAdapter(lVar);
            new TabLayoutMediator(b0Var.f72733m, b0Var.f72743w, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.transsnet.downloader.fragment.m3
                @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
                public final void onConfigureTab(TabLayout.Tab tab, int i11) {
                    DownloadReDetectorMultiFragment.q1(DownloadReDetectorMultiFragment.this, tab, i11);
                }
            }).attach();
            b0Var.f72733m.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(DownloadReDetectorMultiFragment downloadReDetectorMultiFragment, TabLayout.Tab tab, int i11) {
        ResourcesSeason h11;
        Intrinsics.h(tab, "tab");
        com.transsnet.downloader.adapter.l lVar = downloadReDetectorMultiFragment.mAdapter;
        tab.setText("Unit " + ((lVar == null || (h11 = lVar.h(i11)) == null) ? null : Integer.valueOf(h11.getSe())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final StartDownloadHelper r1() {
        return new StartDownloadHelper();
    }

    private final void s1(TabLayout tabView, int right) {
        int b11 = dk.a.b(28);
        int tabCount = tabView.getTabCount();
        for (int i11 = 0; i11 < tabCount; i11++) {
            if (tabView.getTabAt(i11) == null) {
                return;
            }
            View childAt = tabView.getChildAt(0);
            Intrinsics.f(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
            View childAt2 = ((ViewGroup) childAt).getChildAt(i11);
            Intrinsics.g(childAt2, "getChildAt(...)");
            ViewGroup.LayoutParams layoutParams = childAt2.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.setMargins(0, 0, right, 0);
            marginLayoutParams.height = b11;
        }
        tabView.requestLayout();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ny.c
    public void U(boolean show) {
        FrameLayout frameLayout;
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var == null || (frameLayout = b0Var.f72725e) == null) {
            return;
        }
        frameLayout.setVisibility(show ? 0 : 8);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public py.b0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        py.b0 c11 = py.b0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        a.C0856a.f(lg.a.f68962a, "premium_d", "DownloadReDetectorMultiFragment --> initViewData()", false, 4, null);
        initView();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        String subjectId;
        DownloadResourcesDetectorViewModel viewModel;
        androidx.view.b0 y10;
        final int i11 = com.transsion.baselib.report.launch.b.f43424a.b().getInt("download_last_resolution", 0);
        DownloadResourcesDetectorViewModel viewModel2 = getViewModel();
        if (viewModel2 != null && (y10 = viewModel2.y()) != null) {
            y10.j(this, new d(new Function1() { // from class: com.transsnet.downloader.fragment.f3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit h12;
                    h12 = DownloadReDetectorMultiFragment.h1(DownloadReDetectorMultiFragment.this, i11, (ResourcesSeasonList) obj);
                    return h12;
                }
            }));
        }
        DownloadResourcesDetectorViewModel downloadResourcesDetectorViewModel = (DownloadResourcesDetectorViewModel) new androidx.view.v0(this).a(DownloadResourcesDetectorViewModel.class);
        downloadResourcesDetectorViewModel.s().j(this, new d(new Function1() { // from class: com.transsnet.downloader.fragment.g3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit i12;
                i12 = DownloadReDetectorMultiFragment.i1(DownloadReDetectorMultiFragment.this, (DownloadListBean) obj);
                return i12;
            }
        }));
        this.groupMainViewModel = downloadResourcesDetectorViewModel;
        Subject subject = this.subject;
        if (subject != null && (subjectId = subject.getSubjectId()) != null && (viewModel = getViewModel()) != null) {
            viewModel.u(subjectId);
        }
        DownloadResourcesDetectorViewModel viewModel3 = getViewModel();
        if (viewModel3 != null) {
            viewModel3.v();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isAudioShowNoNetworkLayout() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean isMonitorNetworkState() {
        return false;
    }

    @Override // ny.c
    public void k(int position, List selectedList, boolean all) {
        Intrinsics.h(selectedList, "selectedList");
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        this.checkedList.put(Integer.valueOf(position), selectedList);
        this.allCheckMap.put(Integer.valueOf(position), Boolean.valueOf(all));
        a.C0856a.f(lg.a.f68962a, "zxb_log", "DownloadReDetectorGroupMainFragment --> onSelectData() --> selectedList.size = " + this.checkedList.size(), false, 4, null);
        Iterator it = selectedList.iterator();
        long j11 = 0L;
        while (it.hasNext()) {
            DownloadBean downloadBean = (DownloadBean) it.next();
            if (!downloadBean.isUnable()) {
                Long size = downloadBean.getSize();
                j11 += size != null ? size.longValue() : 0L;
            }
        }
        x(position, Long.valueOf(j11));
        W0();
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        String str2;
        String str3;
        String str4;
        HashMap g11;
        HashMap g12;
        HashMap g13;
        HashMap g14;
        HashMap g15;
        String string;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String str5 = "";
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
        if (arguments4 == null || (str3 = arguments4.getString("extra_ops")) == null) {
            str3 = "";
        }
        this.ops = str3;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str4 = arguments5.getString("extra_target_resource_id")) == null) {
            str4 = "";
        }
        this.targetResourceId = str4;
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (string = arguments6.getString("extra_module_name")) != null) {
            str5 = string;
        }
        this.moduleName = str5;
        Bundle arguments7 = getArguments();
        this.targetSeason = arguments7 != null ? arguments7.getInt("extra_season") : 0;
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (g15 = logViewConfig.g()) != null) {
            g15.put(WebConstants.PAGE_FROM, this.pageFrom);
        }
        hj.b logViewConfig2 = getLogViewConfig();
        if (logViewConfig2 != null && (g14 = logViewConfig2.g()) != null) {
            g14.put("last_page_from", this.lastPageFrom);
        }
        hj.b logViewConfig3 = getLogViewConfig();
        if (logViewConfig3 != null && (g13 = logViewConfig3.g()) != null) {
            Subject subject = this.subject;
            g13.put("subject_id", subject != null ? subject.getSubjectId() : null);
        }
        hj.b logViewConfig4 = getLogViewConfig();
        if (logViewConfig4 != null && (g12 = logViewConfig4.g()) != null) {
            g12.put("ops", this.ops);
        }
        hj.b logViewConfig5 = getLogViewConfig();
        if (logViewConfig5 == null || (g11 = logViewConfig5.g()) == null) {
            return;
        }
        g11.put(NativeComponentConstants.KEY_COMPONENT_TYPE, "2");
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        DownloadListManager.a aVar = DownloadListManager.f60117m;
        aVar.a().Y(null);
        try {
            aVar.a().A().clear();
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        super.onDestroy();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        loadDefaultData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ny.c
    public void w(boolean show) {
        BLFrameLayout bLFrameLayout;
        py.b0 b0Var = (py.b0) getMViewBinding();
        if (b0Var == null || (bLFrameLayout = b0Var.f72724d) == null) {
            return;
        }
        bLFrameLayout.setVisibility(show ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ny.c
    public void x(int position, Long size) {
        AppCompatTextView appCompatTextView;
        AppCompatTextView appCompatTextView2;
        if (!isAdded() || isDetached() || isRemoving()) {
            return;
        }
        this.sizeMap.put(Integer.valueOf(position), size);
        Iterator it = this.sizeMap.entrySet().iterator();
        long j11 = 0;
        while (it.hasNext()) {
            Long l11 = (Long) ((Map.Entry) it.next()).getValue();
            j11 += l11 != null ? l11.longValue() : 0L;
        }
        if (j11 <= 0) {
            py.b0 b0Var = (py.b0) getMViewBinding();
            if (b0Var == null || (appCompatTextView2 = b0Var.f72734n) == null) {
                return;
            }
            appCompatTextView2.setText(getString(com.transsnet.downloader.R$string.str_download));
            return;
        }
        py.b0 b0Var2 = (py.b0) getMViewBinding();
        if (b0Var2 == null || (appCompatTextView = b0Var2.f72734n) == null) {
            return;
        }
        appCompatTextView.setText(getString(com.transsnet.downloader.R$string.str_download) + " · " + oh.b.a(j11, 1));
    }

    @Override // com.transsnet.downloader.fragment.DownloadReDetectorBaseFragment
    public void x0() {
        super.x0();
        if (G0()) {
            F0();
        }
    }
}
