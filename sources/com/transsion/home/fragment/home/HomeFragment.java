package com.transsion.home.fragment.home;

import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.cloud.config.utils.XLogUtil;
import com.cloud.tmc.integration.constants.IntegrationConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.activity.BaseActivity;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.widget.BlurredSectorView;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$drawable;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.GradeGroup;
import com.transsion.home.bean.GradeItem;
import com.transsion.home.bean.HomePreferencesConfig;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.fragment.dialog.CategoryDiscoverDialog;
import com.transsion.home.fragment.dialog.GradeSelectDialog;
import com.transsion.home.fragment.dialog.HomePreferencesEnterPopDialog;
import com.transsion.home.fragment.home.HomeFragment;
import com.transsion.home.fragment.tab.BaseHomeSubFragment;
import com.transsion.home.fragment.tab.EmptyFragment;
import com.transsion.home.fragment.tab.MovieFragment;
import com.transsion.home.fragment.tab.SubShortTvFragment;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.fragment.tab.TopRoomFragment;
import com.transsion.home.fragment.tab.TrendingFragment;
import com.transsion.home.fragment.tab.TrendingUGCFragment;
import com.transsion.home.fragment.tab.TvChannelTabFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.p004enum.HomeTabType;
import com.transsion.home.viewmodel.HomePreferencesViewModel;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.memberapi.IMemberApi;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.startup.pref.consume.AppStartReport;
import com.transsion.web.api.WebConstants;
import com.transsion.web.fragment.WebFragmentV2;
import com.transsnet.downloader.util.DownloadSDCardUtil;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import nh.n;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u009e\u00012\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001jB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0004J!\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\u0004J\u0019\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001e\u0010\u0004J\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010\u0004J\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u0004J\u000f\u0010!\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u0004J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\tH\u0016¢\u0006\u0004\b%\u0010\u0004J\u000f\u0010&\u001a\u00020\tH\u0016¢\u0006\u0004\b&\u0010\u0004J\u0015\u0010(\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u001a¢\u0006\u0004\b(\u0010\u001dJ\r\u0010)\u001a\u00020\t¢\u0006\u0004\b)\u0010\u0004J\u001d\u0010,\u001a\u00020\t2\u0006\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\f¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u001a¢\u0006\u0004\b1\u00102J\u001d\u00105\u001a\u00020\t2\u0006\u00103\u001a\u00020\"2\u0006\u00104\u001a\u00020\u001a¢\u0006\u0004\b5\u00106J\r\u00107\u001a\u00020\t¢\u0006\u0004\b7\u0010\u0004J\u0015\u00109\u001a\b\u0012\u0004\u0012\u00020\"08H\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\t2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b?\u0010>J\u000f\u0010@\u001a\u00020\tH\u0002¢\u0006\u0004\b@\u0010\u0004J\u000f\u0010A\u001a\u00020\tH\u0002¢\u0006\u0004\bA\u0010\u0004J\u000f\u0010B\u001a\u00020\tH\u0002¢\u0006\u0004\bB\u0010\u0004J\u000f\u0010C\u001a\u00020\tH\u0002¢\u0006\u0004\bC\u0010\u0004J\u0019\u0010E\u001a\u00020\t2\b\u0010D\u001a\u0004\u0018\u00010\"H\u0002¢\u0006\u0004\bE\u0010FJ\u0019\u0010I\u001a\u00020\t2\b\u0010H\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\tH\u0002¢\u0006\u0004\bK\u0010\u0004J\u000f\u0010L\u001a\u00020\u001aH\u0002¢\u0006\u0004\bL\u00102J\u000f\u0010M\u001a\u00020\tH\u0002¢\u0006\u0004\bM\u0010\u0004J\u0017\u0010P\u001a\u00020O2\u0006\u0010N\u001a\u00020\fH\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\tH\u0002¢\u0006\u0004\bR\u0010\u0004J\u001f\u0010T\u001a\u00020\f2\u0006\u0010S\u001a\u00020\"2\u0006\u0010+\u001a\u00020\fH\u0002¢\u0006\u0004\bT\u0010UJ\u000f\u0010V\u001a\u00020\tH\u0002¢\u0006\u0004\bV\u0010\u0004J\u000f\u0010W\u001a\u00020\tH\u0002¢\u0006\u0004\bW\u0010\u0004J\u001f\u0010Y\u001a\u00020\t2\u0006\u0010N\u001a\u00020\f2\u0006\u0010X\u001a\u00020\u001aH\u0002¢\u0006\u0004\bY\u0010ZJ\u001b\u0010^\u001a\u0004\u0018\u00010]2\b\u0010\\\u001a\u0004\u0018\u00010[H\u0002¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\tH\u0002¢\u0006\u0004\b`\u0010\u0004J\u0017\u0010b\u001a\u00020\t2\u0006\u0010a\u001a\u00020\fH\u0002¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\tH\u0002¢\u0006\u0004\bd\u0010\u0004J\u000f\u0010e\u001a\u00020\tH\u0002¢\u0006\u0004\be\u0010\u0004J\u0019\u0010h\u001a\u00020\t2\b\u0010g\u001a\u0004\u0018\u00010fH\u0002¢\u0006\u0004\bh\u0010iR\u0018\u0010H\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010n\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bl\u0010mR\u001c\u0010r\u001a\b\u0012\u0002\b\u0003\u0018\u00010o8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u001b\u0010x\u001a\u00020s8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bt\u0010u\u001a\u0004\bv\u0010wR\u0016\u0010{\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010zR\u001a\u0010\u0081\u0001\u001a\u0004\u0018\u00010~8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001b\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0086\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0085\u0001\u0010zR\u0018\u0010\u0088\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010mR\u001b\u0010\u008b\u0001\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0018\u0010\u008d\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010mR\u0018\u0010\u008f\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008e\u0001\u0010mR\u0018\u0010\u0091\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0090\u0001\u0010zR\u001a\u0010\u0095\u0001\u001a\u00030\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R\u001c\u0010\u0099\u0001\u001a\u0005\u0018\u00010\u0096\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001¨\u0006\u009f\u0001"}, d2 = {"Lcom/transsion/home/fragment/home/HomeFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lgl/r;", "<init>", "()V", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "Landroid/os/Bundle;", "savedInstanceState", "", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "I0", "()I", "Landroid/view/LayoutInflater;", "inflater", "K0", "(Landroid/view/LayoutInflater;)Lgl/r;", "c1", "initData", "lazyLoadData", "Landroid/content/Intent;", "intent", "newIntent", "(Landroid/content/Intent;)V", "", "hidden", "onHiddenChanged", "(Z)V", "logPause", "logResume", "onResume", "onPause", "", "J0", "()Ljava/lang/String;", "onDestroyView", "onDestroy", "isWhite", "D0", "v1", "tabCode", "tabId", "u1", "(Ljava/lang/String;I)V", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "Y0", "()Z", "pageTabName", "isRefresh", "b1", "(Ljava/lang/String;Z)V", "x1", "", "L0", "()Ljava/util/List;", "Lcom/transsion/home/bean/HomePreferencesConfig;", XLogUtil.TAG, "N0", "(Lcom/transsion/home/bean/HomePreferencesConfig;)V", "n1", "g1", "X0", "R0", "y1", AppMeasurementSdk.ConditionalUserProperty.VALUE, "s1", "(Ljava/lang/String;)V", "Lcom/transsion/home/bean/AppTab;", "appTab", "z1", "(Lcom/transsion/home/bean/AppTab;)V", "Z0", "w1", "initViewPager", RequestParameters.POSITION, "Landroidx/fragment/app/Fragment;", "E0", "(I)Landroidx/fragment/app/Fragment;", "B0", "code", "H0", "(Ljava/lang/String;I)I", "e1", "k1", "smoothScroll", "d1", "(IZ)V", "", "navigator", "Landroid/widget/HorizontalScrollView;", "G0", "(Ljava/lang/Object;)Landroid/widget/HorizontalScrollView;", "l1", "scrollX", "O0", "(I)V", "q1", "a1", "Lcom/transsion/home/bean/HomeTabItem;", "tabItem", "M0", "(Lcom/transsion/home/bean/HomeTabItem;)V", "a", "Lcom/transsion/home/bean/AppTab;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "I", "mSelectTabIndex", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "c", "Lcom/transsion/home/fragment/tab/BaseHomeSubFragment;", "trendingFragment", "Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "d", "Lkotlin/Lazy;", "F0", "()Lcom/transsion/home/viewmodel/HomePreferencesViewModel;", "homePreferencesViewModel", "e", "Z", "viewPagerInitialized", "f", "lazyLoadAttempted", "Lcom/transsion/home/fragment/home/HomeSearchViewManager;", be.g.f16474b, "Lcom/transsion/home/fragment/home/HomeSearchViewManager;", "mHomeSearchViewManager", "h", "Landroid/os/Bundle;", "mSavedInstanceState", "i", "isHandlingRedirect", com.mbridge.msdk.foundation.same.report.j.f35620b, "lastValidPosition", CampaignEx.JSON_KEY_AD_K, "Landroid/widget/HorizontalScrollView;", "cachedScrollView", "l", "lastTopTabScrollX", "m", "scrollStartSelectIndex", "n", "isTopTabScrolling", "", "o", "J", "resumeTimeStamp", "Landroid/os/Handler;", TtmlNode.TAG_P, "Landroid/os/Handler;", "scrollStopHandler", "Ljava/lang/Runnable;", CampaignEx.JSON_KEY_AD_Q, "Ljava/lang/Runnable;", "scrollStopRunnable", CampaignEx.JSON_KEY_AD_R, "Home_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes5.dex */
public final class HomeFragment extends BaseFragment<gl.r> {

    /* renamed from: s, reason: collision with root package name */
    public static final int f45162s = 8;

    /* renamed from: t, reason: collision with root package name */
    private static int f45163t;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private AppTab appTab;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int mSelectTabIndex = f45163t;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private BaseHomeSubFragment trendingFragment;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy homePreferencesViewModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean viewPagerInitialized;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean lazyLoadAttempted;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private HomeSearchViewManager mHomeSearchViewManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Bundle mSavedInstanceState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isHandlingRedirect;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int lastValidPosition;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private HorizontalScrollView cachedScrollView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int lastTopTabScrollX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int scrollStartSelectIndex;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isTopTabScrolling;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private Handler scrollStopHandler;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private Runnable scrollStopRunnable;

    /* loaded from: classes5.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f45181a;

        static {
            int[] iArr = new int[HomeTabType.values().length];
            try {
                iArr[HomeTabType.SUB_OPERATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HomeTabType.SUBJECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HomeTabType.H5TAB.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HomeTabType.TRENDING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HomeTabType.SHORT_TV_TAB.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HomeTabType.SUB_ROOM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HomeTabType.TV_CHANNEL_TAB.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f45181a = iArr;
        }
    }

    /* loaded from: classes5.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(HomeFragment homeFragment, int i11) {
            MagicIndicator magicIndicator;
            gl.r mViewBinding = homeFragment.getMViewBinding();
            if (mViewBinding != null && (magicIndicator = mViewBinding.f63948k) != null) {
                magicIndicator.onPageSelected(i11);
            }
            homeFragment.d1(i11, false);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            MagicIndicator magicIndicator;
            super.onPageScrollStateChanged(i11);
            gl.r mViewBinding = HomeFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f63948k) == null) {
                return;
            }
            magicIndicator.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            MagicIndicator magicIndicator;
            super.onPageScrolled(i11, f11, i12);
            gl.r mViewBinding = HomeFragment.this.getMViewBinding();
            if (mViewBinding == null || (magicIndicator = mViewBinding.f63948k) == null) {
                return;
            }
            magicIndicator.onPageScrolled(i11, f11, i12);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(final int i11) {
            MagicIndicator magicIndicator;
            String str;
            List<HomeTabItem> homeTabs;
            List<HomeTabItem> homeTabs2;
            super.onPageSelected(i11);
            if (HomeFragment.this.isHandlingRedirect || i11 < 0 || HomeFragment.this.mSelectTabIndex == i11) {
                return;
            }
            AppTab appTab = HomeFragment.this.appTab;
            HomeTabItem homeTabItem = (appTab == null || (homeTabs2 = appTab.getHomeTabs()) == null) ? null : homeTabs2.get(i11);
            if (homeTabItem == null || !homeTabItem.isOpenLandPage()) {
                HomeFragment.this.lastValidPosition = i11;
                gl.r mViewBinding = HomeFragment.this.getMViewBinding();
                if (mViewBinding != null && (magicIndicator = mViewBinding.f63948k) != null) {
                    final HomeFragment homeFragment = HomeFragment.this;
                    magicIndicator.post(new Runnable() { // from class: com.transsion.home.fragment.home.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            HomeFragment.c.b(HomeFragment.this, i11);
                        }
                    });
                }
            } else {
                HomeFragment.this.isHandlingRedirect = true;
                ak.k.h(homeTabItem.getUrl(), null, 1, null);
            }
            AppTab appTab2 = HomeFragment.this.appTab;
            HomeTabItem homeTabItem2 = (appTab2 == null || (homeTabs = appTab2.getHomeTabs()) == null) ? null : homeTabs.get(i11);
            com.transsion.baselib.helper.a aVar = com.transsion.baselib.helper.a.f43316a;
            String J0 = HomeFragment.this.J0();
            if (homeTabItem2 == null || (str = homeTabItem2.getName()) == null) {
                str = "";
            }
            aVar.n(J0, str);
            HomeFragment.this.mSelectTabIndex = i11;
            HomeFragment homeFragment2 = HomeFragment.this;
            homeFragment2.b1(homeFragment2.J0(), false);
            if (HomeFragment.this.isAdded()) {
                Fragment k02 = HomeFragment.this.getChildFragmentManager().k0("f" + HomeFragment.this.mSelectTabIndex);
                if (k02 instanceof BaseHomeSubFragment) {
                    ((BaseHomeSubFragment) k02).o0();
                } else {
                    HomeFragment.this.D0(false);
                }
            }
            if (Intrinsics.c(homeTabItem2 != null ? homeTabItem2.getTabCode() : null, "Education") && HomeFragment.this.isAdded() && !HomeFragment.this.isDetached() && !HomeFragment.this.isRemoving()) {
                CourseManager courseManager = CourseManager.f44139a;
                FragmentManager supportFragmentManager = HomeFragment.this.requireActivity().getSupportFragmentManager();
                Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
                courseManager.h(supportFragmentManager);
            }
            HomeFragment.this.x1();
        }
    }

    /* loaded from: classes5.dex */
    public static final class d extends FragmentStateAdapter {
        d() {
            super(HomeFragment.this);
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            return HomeFragment.this.E0(i11);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<HomeTabItem> homeTabs;
            AppTab appTab = HomeFragment.this.appTab;
            if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
                return 0;
            }
            return homeTabs.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class e implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f45184a;

        e(Function1 function) {
            Intrinsics.h(function, "function");
            this.f45184a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f45184a;
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
            this.f45184a.invoke(obj);
        }
    }

    /* loaded from: classes5.dex */
    public static final class f implements nh.n {
        f() {
        }

        @Override // nh.n
        public void onConnected() {
            n.a.a(this);
        }

        @Override // nh.n
        public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
            Intrinsics.h(network, "network");
            Intrinsics.h(networkCapabilities, "networkCapabilities");
            HomeSearchViewManager homeSearchViewManager = HomeFragment.this.mHomeSearchViewManager;
            if (homeSearchViewManager != null) {
                homeSearchViewManager.I(network, networkCapabilities);
            }
        }

        @Override // nh.n
        public void onDisconnected() {
        }
    }

    public HomeFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.home.fragment.home.HomeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.homePreferencesViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(HomePreferencesViewModel.class), new Function0<x0>() { // from class: com.transsion.home.fragment.home.HomeFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.home.fragment.home.HomeFragment$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object invoke = Function0.this.invoke();
                androidx.view.m mVar = invoke instanceof androidx.view.m ? (androidx.view.m) invoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = this.getDefaultViewModelProviderFactory();
                }
                Intrinsics.g(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.scrollStartSelectIndex = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b1, code lost:
    
        if (r4 < ((r0 == null || (r0 = r0.getHomeTabs()) == null) ? 0 : r0.size())) goto L59;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void B0() {
        /*
            Method dump skipped, instructions count: 241
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.home.HomeFragment.B0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(HomeFragment homeFragment) {
        MagicIndicator magicIndicator;
        gl.r mViewBinding = homeFragment.getMViewBinding();
        if (mViewBinding != null && (magicIndicator = mViewBinding.f63948k) != null) {
            magicIndicator.onPageSelected(homeFragment.mSelectTabIndex);
        }
        homeFragment.b1(homeFragment.J0(), true);
        homeFragment.l1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment E0(int position) {
        Integer tabId;
        Integer tabId2;
        Integer tabId3;
        Integer tabId4;
        Integer tabId5;
        Integer tabId6;
        Integer tabId7;
        List<HomeTabItem> homeTabs;
        int i11 = 1;
        AppTab appTab = this.appTab;
        HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : homeTabs.get(position);
        a.C0856a c0856a = lg.a.f68962a;
        c0856a.c("HomeFragment", "getFragment: " + (homeTabItem != null ? homeTabItem.getType() : null) + "&position:" + position + "&tabCode:" + (homeTabItem != null ? homeTabItem.getTabCode() : null) + "&displayType:" + (homeTabItem != null ? homeTabItem.getDisplayType() : null), true);
        HomeTabType.Companion companion = HomeTabType.INSTANCE;
        if (companion.a(homeTabItem != null ? homeTabItem.getType() : null) == HomeTabType.SUB_NOVEL) {
            uj.a aVar = uj.a.f76883a;
            Application a11 = Utils.a();
            Intrinsics.g(a11, "getApp(...)");
            aVar.d(a11);
        }
        if (homeTabItem != null && homeTabItem.isOpenLandPage()) {
            a.C0856a.f(c0856a, "HomeFragment", "getFragment isOpenLandPage", false, 4, null);
            return new EmptyFragment();
        }
        HomeTabType a12 = companion.a(homeTabItem != null ? homeTabItem.getType() : null);
        switch (a12 == null ? -1 : b.f45181a[a12.ordinal()]) {
            case 1:
                SubTabFragment.Companion companion2 = SubTabFragment.INSTANCE;
                if (homeTabItem != null && (tabId = homeTabItem.getTabId()) != null) {
                    i11 = tabId.intValue();
                }
                return companion2.b(i11, homeTabItem != null ? homeTabItem.getTabCode() : null);
            case 2:
                MovieFragment.Companion companion3 = MovieFragment.INSTANCE;
                if (homeTabItem != null && (tabId2 = homeTabItem.getTabId()) != null) {
                    i11 = tabId2.intValue();
                }
                return MovieFragment.Companion.b(companion3, i11, false, null, homeTabItem != null ? homeTabItem.getTabCode() : null, 6, null);
            case 3:
                WebFragmentV2 b11 = WebFragmentV2.INSTANCE.b();
                Pair a13 = TuplesKt.a("url", homeTabItem != null ? homeTabItem.getUrl() : null);
                Boolean bool = Boolean.TRUE;
                b11.setArguments(androidx.core.os.d.b(a13, TuplesKt.a(WebConstants.FIELD_TOOL_BAR_HIDDEN, bool), TuplesKt.a(WebConstants.TAB_CODE, homeTabItem != null ? homeTabItem.getTabCode() : null), TuplesKt.a(WebConstants.NEED_HEADER, bool), TuplesKt.a("nested_scroll_intercept", bool), TuplesKt.a(WebConstants.HEADER_BG, Integer.valueOf(R$drawable.home_title_gradient_bg))));
                return b11;
            case 4:
                ak.g gVar = ak.g.f714a;
                if ((gVar.b() && (this.trendingFragment instanceof TrendingFragment)) || (!gVar.b() && (this.trendingFragment instanceof TrendingUGCFragment))) {
                    this.trendingFragment = null;
                }
                BaseHomeSubFragment baseHomeSubFragment = this.trendingFragment;
                if (baseHomeSubFragment != null) {
                    return baseHomeSubFragment;
                }
                if (gVar.b()) {
                    TrendingUGCFragment.Companion companion4 = TrendingUGCFragment.INSTANCE;
                    if (homeTabItem != null && (tabId4 = homeTabItem.getTabId()) != null) {
                        i11 = tabId4.intValue();
                    }
                    TrendingUGCFragment a14 = companion4.a(i11, homeTabItem != null ? homeTabItem.getTabCode() : null);
                    this.trendingFragment = a14;
                    return a14;
                }
                TrendingFragment.Companion companion5 = TrendingFragment.INSTANCE;
                if (homeTabItem != null && (tabId3 = homeTabItem.getTabId()) != null) {
                    i11 = tabId3.intValue();
                }
                TrendingFragment a15 = companion5.a(i11, homeTabItem != null ? homeTabItem.getTabCode() : null);
                this.trendingFragment = a15;
                return a15;
            case 5:
                return SubShortTvFragment.INSTANCE.a((homeTabItem == null || (tabId5 = homeTabItem.getTabId()) == null) ? 13 : tabId5.intValue());
            case 6:
                return new TopRoomFragment();
            case 7:
                return TvChannelTabFragment.INSTANCE.a((homeTabItem == null || (tabId6 = homeTabItem.getTabId()) == null) ? ak.g.f714a.b() ? 1033 : 42 : tabId6.intValue(), homeTabItem != null ? homeTabItem.getTabCode() : null);
            default:
                MovieFragment.Companion companion6 = MovieFragment.INSTANCE;
                if (homeTabItem != null && (tabId7 = homeTabItem.getTabId()) != null) {
                    i11 = tabId7.intValue();
                }
                return MovieFragment.Companion.b(companion6, i11, false, null, homeTabItem != null ? homeTabItem.getTabCode() : null, 6, null);
        }
    }

    private final HomePreferencesViewModel F0() {
        return (HomePreferencesViewModel) this.homePreferencesViewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [android.view.ViewParent] */
    /* JADX WARN: Type inference failed for: r11v8, types: [android.view.ViewParent] */
    private final HorizontalScrollView G0(Object navigator) {
        HorizontalScrollView horizontalScrollView;
        boolean z10 = navigator instanceof CommonNavigator;
        if (z10) {
            try {
                Field declaredField = CommonNavigator.class.getDeclaredField("a");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(navigator);
                if (obj instanceof HorizontalScrollView) {
                    horizontalScrollView = (HorizontalScrollView) obj;
                }
            } catch (Exception e11) {
                a.C0856a.f(lg.a.f68962a, "HomeFragment", "setupTopTabScrollListener: failed to get scrollView from CommonNavigator, " + e11.getMessage(), false, 4, null);
            }
            horizontalScrollView = null;
        } else {
            if (navigator instanceof ORCommonNavigator) {
                try {
                    Field declaredField2 = ORCommonNavigator.class.getDeclaredField("a");
                    declaredField2.setAccessible(true);
                    Object obj2 = declaredField2.get(navigator);
                    if (obj2 instanceof HorizontalScrollView) {
                        horizontalScrollView = (HorizontalScrollView) obj2;
                    }
                } catch (Exception e12) {
                    a.C0856a.f(lg.a.f68962a, "HomeFragment", "setupTopTabScrollListener: failed to get scrollView from ORCommonNavigator, " + e12.getMessage(), false, 4, null);
                }
            }
            horizontalScrollView = null;
        }
        if (horizontalScrollView != null) {
            return horizontalScrollView;
        }
        LinearLayout titleContainer = z10 ? ((CommonNavigator) navigator).getTitleContainer() : navigator instanceof ORCommonNavigator ? ((ORCommonNavigator) navigator).getTitleContainer() : null;
        HorizontalScrollView parent = titleContainer != null ? titleContainer.getParent() : 0;
        while (parent != 0 && !(parent instanceof HorizontalScrollView)) {
            parent = parent.getParent();
        }
        return parent instanceof HorizontalScrollView ? parent : null;
    }

    private final int H0(String code, int tabId) {
        List<HomeTabItem> homeTabs;
        AppTab appTab;
        List<HomeTabItem> homeTabs2;
        Integer tabId2;
        int i11 = 0;
        if (tabId >= 0 && (appTab = this.appTab) != null && (homeTabs2 = appTab.getHomeTabs()) != null) {
            int i12 = 0;
            for (Object obj : homeTabs2) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    CollectionsKt.u();
                }
                HomeTabItem homeTabItem = (HomeTabItem) obj;
                if (homeTabItem != null && (tabId2 = homeTabItem.getTabId()) != null && tabId2.intValue() == tabId) {
                    return i12;
                }
                i12 = i13;
            }
        }
        AppTab appTab2 = this.appTab;
        if (appTab2 != null && (homeTabs = appTab2.getHomeTabs()) != null) {
            for (Object obj2 : homeTabs) {
                int i14 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.u();
                }
                HomeTabItem homeTabItem2 = (HomeTabItem) obj2;
                if (Intrinsics.c(homeTabItem2 != null ? homeTabItem2.getTabCode() : null, code)) {
                    return i11;
                }
                i11 = i14;
            }
        }
        return f45163t;
    }

    private final List L0() {
        String name;
        List<HomeTabItem> homeTabs;
        ArrayList arrayList = new ArrayList();
        gl.r mViewBinding = getMViewBinding();
        MagicIndicator magicIndicator = mViewBinding != null ? mViewBinding.f63948k : null;
        h00.a navigator = magicIndicator != null ? magicIndicator.getNavigator() : null;
        if (this.appTab != null && navigator != null) {
            LinearLayout titleContainer = navigator instanceof CommonNavigator ? ((CommonNavigator) navigator).getTitleContainer() : navigator instanceof ORCommonNavigator ? ((ORCommonNavigator) navigator).getTitleContainer() : null;
            if (titleContainer == null) {
                return arrayList;
            }
            HorizontalScrollView horizontalScrollView = this.cachedScrollView;
            if (horizontalScrollView == null) {
                horizontalScrollView = G0(navigator);
            }
            int scrollX = horizontalScrollView != null ? horizontalScrollView.getScrollX() : 0;
            int width = horizontalScrollView != null ? horizontalScrollView.getWidth() : titleContainer.getMeasuredWidth();
            int childCount = titleContainer.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = titleContainer.getChildAt(i11);
                AppTab appTab = this.appTab;
                HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : (HomeTabItem) CollectionsKt.l0(homeTabs, i11);
                int left = childAt.getLeft() - scrollX;
                int right = childAt.getRight() - scrollX;
                if (left < width && right > 0 && homeTabItem != null && (name = homeTabItem.getName()) != null) {
                    arrayList.add(name);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void M0(com.transsion.home.bean.HomeTabItem r7) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.home.HomeFragment.M0(com.transsion.home.bean.HomeTabItem):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void N0(com.transsion.home.bean.HomePreferencesConfig r12) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.home.HomeFragment.N0(com.transsion.home.bean.HomePreferencesConfig):void");
    }

    private final void O0(int scrollX) {
        Handler handler;
        if (scrollX != this.lastTopTabScrollX) {
            if (!this.isTopTabScrolling) {
                this.scrollStartSelectIndex = this.mSelectTabIndex;
                this.isTopTabScrolling = true;
            }
            Runnable runnable = this.scrollStopRunnable;
            if (runnable != null && (handler = this.scrollStopHandler) != null) {
                handler.removeCallbacks(runnable);
            }
            this.scrollStopRunnable = new Runnable() { // from class: com.transsion.home.fragment.home.i
                @Override // java.lang.Runnable
                public final void run() {
                    HomeFragment.P0(HomeFragment.this);
                }
            };
            Handler handler2 = new Handler(Looper.getMainLooper());
            this.scrollStopHandler = handler2;
            Runnable runnable2 = this.scrollStopRunnable;
            if (runnable2 != null) {
                handler2.postDelayed(runnable2, 100L);
            }
        } else if (this.isTopTabScrolling) {
            this.isTopTabScrolling = false;
            this.scrollStartSelectIndex = this.mSelectTabIndex;
        }
        this.lastTopTabScrollX = scrollX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P0(HomeFragment homeFragment) {
        homeFragment.isTopTabScrolling = false;
        String J0 = homeFragment.J0();
        if (J0.length() > 0) {
            homeFragment.b1(J0, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(HomeFragment homeFragment, ak.n value) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        ViewPager2 viewPager2;
        Intrinsics.h(value, "value");
        String a11 = value.a();
        boolean z10 = a11 == null || a11.length() == 0;
        gl.r mViewBinding = homeFragment.getMViewBinding();
        if (mViewBinding != null && (viewPager2 = mViewBinding.f63956s) != null) {
            viewPager2.setUserInputEnabled(z10);
        }
        if (z10) {
            HomeSearchViewManager homeSearchViewManager = homeFragment.mHomeSearchViewManager;
            if (homeSearchViewManager != null) {
                homeSearchViewManager.C(homeFragment.appTab);
            }
        } else {
            HomeSearchViewManager homeSearchViewManager2 = homeFragment.mHomeSearchViewManager;
            if (homeSearchViewManager2 != null) {
                homeSearchViewManager2.n();
            }
            HomeSearchViewManager homeSearchViewManager3 = homeFragment.mHomeSearchViewManager;
            if (homeSearchViewManager3 != null) {
                homeSearchViewManager3.C(homeFragment.appTab);
            }
            gl.r mViewBinding2 = homeFragment.getMViewBinding();
            if (mViewBinding2 != null && (appCompatImageView2 = mViewBinding2.f63946i) != null) {
                jg.c.g(appCompatImageView2);
            }
            gl.r mViewBinding3 = homeFragment.getMViewBinding();
            if (mViewBinding3 != null && (appCompatImageView = mViewBinding3.f63945h) != null) {
                jg.c.g(appCompatImageView);
            }
        }
        return Unit.f67184a;
    }

    private final void R0() {
        PreloadTrendingData.a aVar = PreloadTrendingData.f45940n;
        AppTab appTab = (AppTab) aVar.a().C().f();
        this.appTab = appTab;
        a.C0856a.f(lg.a.f68962a, "HomeFragment", "homeTabFromCache = " + appTab, false, 4, null);
        if (this.appTab == null) {
            aVar.a().C().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit S0;
                    S0 = HomeFragment.S0(HomeFragment.this, (AppTab) obj);
                    return S0;
                }
            }));
        }
        aVar.a().D().p(this);
        aVar.a().D().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.q
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = HomeFragment.T0(HomeFragment.this, (AppTab) obj);
                return T0;
            }
        }));
        y1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S0(HomeFragment homeFragment, AppTab appTab) {
        a.C0856a.f(lg.a.f68962a, "HomeFragment", "homeTabFromCache2 = " + appTab, false, 4, null);
        if (homeFragment.isAdded()) {
            homeFragment.z1(appTab);
            homeFragment.Z0();
        }
        PreloadTrendingData.f45940n.a().C().p(homeFragment);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(final HomeFragment homeFragment, final AppTab appTab) {
        a.C0856a.f(lg.a.f68962a, "HomeFragment", "LanguageRestart homeTabFromNet2 = " + appTab, false, 4, null);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.transsion.home.fragment.home.f
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.U0(HomeFragment.this, appTab);
            }
        }, 100L);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U0(HomeFragment homeFragment, AppTab appTab) {
        if (homeFragment.isAdded()) {
            homeFragment.z1(appTab);
            homeFragment.Z0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.e(homePreferencesConfig);
        homeFragment.N0(homePreferencesConfig);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig) {
        Intrinsics.e(homePreferencesConfig);
        homeFragment.n1(homePreferencesConfig);
        return Unit.f67184a;
    }

    private final void X0() {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("mRecyclerView");
            Intrinsics.g(declaredField, "getDeclaredField(...)");
            declaredField.setAccessible(true);
            gl.r mViewBinding = getMViewBinding();
            Object obj = declaredField.get(mViewBinding != null ? mViewBinding.f63956s : null);
            Intrinsics.f(obj, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
            Intrinsics.g(declaredField2, "getDeclaredField(...)");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(recyclerView);
            Intrinsics.f(obj2, "null cannot be cast to non-null type kotlin.Int");
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 2));
            a.C0856a.f(lg.a.f68962a, "invoke", "testOver", false, 4, null);
        } catch (Exception e11) {
            a.C0856a.f(lg.a.f68962a, "invoke", "Exception " + e11.getMessage(), false, 4, null);
        }
    }

    private final void Z0() {
        if (this.lazyLoadAttempted) {
            w1();
        }
    }

    private final void a1() {
        List<HomeTabItem> homeTabs;
        AppTab appTab = this.appTab;
        if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
            return;
        }
        Iterator<HomeTabItem> it = homeTabs.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            HomeTabItem next = it.next();
            if (next != null) {
                Integer tabId = next.getTabId();
                int value = HomeTabId.UGC_Kids_Education.getValue();
                if (tabId != null && tabId.intValue() == value) {
                    break;
                }
            }
            i11++;
        }
        if (i11 < 0) {
            return;
        }
        Fragment k02 = getChildFragmentManager().k0("f" + i11);
        if (k02 instanceof BaseHomeSubFragment) {
            ((BaseHomeSubFragment) k02).c0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(int position, boolean smoothScroll) {
        Object m1185constructorimpl;
        ConfigBean c11;
        gl.r mViewBinding;
        MagicIndicator magicIndicator;
        h00.a navigator;
        String value;
        Boolean m12;
        try {
            Result.Companion companion = Result.INSTANCE;
            c11 = sm.f.f75530c.a().c("home_tab_menu_show", true);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (!((c11 == null || (value = c11.getValue()) == null || (m12 = StringsKt.m1(value)) == null) ? false : m12.booleanValue()) || (mViewBinding = getMViewBinding()) == null || (magicIndicator = mViewBinding.f63948k) == null || (navigator = magicIndicator.getNavigator()) == null) {
            return;
        }
        LinearLayout titleContainer = navigator instanceof CommonNavigator ? ((CommonNavigator) navigator).getTitleContainer() : navigator instanceof ORCommonNavigator ? ((ORCommonNavigator) navigator).getTitleContainer() : null;
        if (titleContainer != null && position >= 0 && position < titleContainer.getChildCount()) {
            HorizontalScrollView horizontalScrollView = this.cachedScrollView;
            if (horizontalScrollView == null) {
                horizontalScrollView = G0(navigator);
                this.cachedScrollView = horizontalScrollView;
                if (horizontalScrollView == null) {
                    return;
                }
            }
            View childAt = titleContainer.getChildAt(position);
            int left = (childAt.getLeft() + (childAt.getWidth() / 2)) - (horizontalScrollView.getWidth() / 2);
            int f11 = RangesKt.f(titleContainer.getWidth() - horizontalScrollView.getWidth(), 0);
            if (left < 0) {
                left = 0;
            } else if (left > f11) {
                left = f11;
            }
            if (smoothScroll) {
                horizontalScrollView.smoothScrollTo(left, 0);
            } else {
                horizontalScrollView.scrollTo(left, 0);
            }
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
            Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
            if (m1188exceptionOrNullimpl != null) {
                a.C0856a.f(lg.a.f68962a, "HomeFragment", "scrollTopTabToPosition: failed to scroll top tab, " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
            }
        }
    }

    private final void e1() {
        ConstraintLayout root;
        final int i11 = this.lastValidPosition;
        gl.r mViewBinding = getMViewBinding();
        if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.home.r
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.f1(HomeFragment.this, i11);
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f1(HomeFragment homeFragment, int i11) {
        ViewPager2 viewPager2;
        MagicIndicator magicIndicator;
        if (homeFragment.isAdded()) {
            gl.r mViewBinding = homeFragment.getMViewBinding();
            if (mViewBinding != null && (magicIndicator = mViewBinding.f63948k) != null) {
                magicIndicator.onPageSelected(i11);
            }
            gl.r mViewBinding2 = homeFragment.getMViewBinding();
            if (mViewBinding2 != null && (viewPager2 = mViewBinding2.f63956s) != null) {
                viewPager2.setCurrentItem(i11, false);
            }
            homeFragment.isHandlingRedirect = false;
            homeFragment.mSelectTabIndex = i11;
            homeFragment.D0(false);
        }
    }

    private final void g1() {
        AppCompatImageButton appCompatImageButton;
        ConstraintLayout constraintLayout;
        X0();
        k1();
        gl.r mViewBinding = getMViewBinding();
        if (mViewBinding != null && (constraintLayout = mViewBinding.f63942e) != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeFragment.j1(HomeFragment.this, view);
                }
            });
        }
        gl.r mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (appCompatImageButton = mViewBinding2.f63939b) == null) {
            return;
        }
        appCompatImageButton.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeFragment.h1(HomeFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h1(final HomeFragment homeFragment, View view) {
        Object m1185constructorimpl;
        ViewPager2 viewPager2;
        com.transsion.baselib.helper.a.f43316a.n(homeFragment.J0(), "home_top_tab_more_menu");
        a.C0856a.f(lg.a.f68962a, "HomeFragment", "Menu button clicked, showing category discover dialog", false, 4, null);
        try {
            Result.Companion companion = Result.INSTANCE;
            CategoryDiscoverDialog a11 = CategoryDiscoverDialog.INSTANCE.a();
            AppTab appTab = homeFragment.appTab;
            a11.s0(appTab != null ? appTab.getHomeTabs() : null);
            gl.r mViewBinding = homeFragment.getMViewBinding();
            a11.r0((mViewBinding == null || (viewPager2 = mViewBinding.f63956s) == null) ? 0 : viewPager2.getCurrentItem());
            a11.q0(new Function1() { // from class: com.transsion.home.fragment.home.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit i12;
                    i12 = HomeFragment.i1(HomeFragment.this, (HomeTabItem) obj);
                    return i12;
                }
            });
            a11.l0(homeFragment, "category_discover");
            HashMap hashMap = new HashMap();
            hashMap.put("dialog_name", "home_switch_tab");
            hj.i.f64628a.s(homeFragment.J0(), "dialog_show", hashMap);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.f(lg.a.f68962a, "HomeFragment", "Failed to show category discover dialog: " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit i1(HomeFragment homeFragment, HomeTabItem homeTabItem) {
        a.C0856a.f(lg.a.f68962a, "HomeFragment", "Selected category: " + homeTabItem, false, 4, null);
        homeFragment.M0(homeTabItem);
        return Unit.f67184a;
    }

    private final void initViewPager() {
        ViewPager2 viewPager2;
        ViewPager2 viewPager22;
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "HomeFragment", "initViewPager", false, 4, null);
        if (isAdded()) {
            gl.r mViewBinding = getMViewBinding();
            if (mViewBinding != null && (viewPager22 = mViewBinding.f63956s) != null) {
                viewPager22.setUserInputEnabled(!ak.o.f721a.i());
            }
            a.C0856a.f(c0856a, "HomeFragment", "initViewPager fragment count " + getChildFragmentManager().y0().size(), false, 4, null);
            gl.r mViewBinding2 = getMViewBinding();
            if (mViewBinding2 != null && (viewPager2 = mViewBinding2.f63956s) != null) {
                viewPager2.setAdapter(new d());
            }
            B0();
            AppStartReport.f54571a.l("home_vp_ready");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j1(HomeFragment homeFragment, View view) {
        homeFragment.q1();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", "grade_select");
        com.transsion.baselib.helper.a.f43316a.i(homeFragment.J0(), linkedHashMap);
    }

    private final void k1() {
        setNetListener(new f());
    }

    private final void l1() {
        MagicIndicator magicIndicator;
        h00.a navigator;
        gl.r mViewBinding = getMViewBinding();
        if (mViewBinding == null || (magicIndicator = mViewBinding.f63948k) == null || (navigator = magicIndicator.getNavigator()) == null) {
            return;
        }
        final HorizontalScrollView G0 = G0(navigator);
        this.cachedScrollView = G0;
        if (G0 == null) {
            a.C0856a.f(lg.a.f68962a, "HomeFragment", "setupTopTabScrollListener: scrollView is null, cannot setup scroll listener", false, 4, null);
            return;
        }
        this.lastTopTabScrollX = G0.getScrollX();
        this.scrollStartSelectIndex = this.mSelectTabIndex;
        G0.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() { // from class: com.transsion.home.fragment.home.h
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                HomeFragment.m1(G0, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(HorizontalScrollView horizontalScrollView, HomeFragment homeFragment) {
        homeFragment.O0(horizontalScrollView.getScrollX());
    }

    private final void n1(final HomePreferencesConfig config) {
        Object m1185constructorimpl;
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isDestroyed()) {
            FragmentActivity activity2 = getActivity();
            if (activity2 == null || !activity2.isFinishing()) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    HomePreferencesEnterPopDialog a11 = HomePreferencesEnterPopDialog.INSTANCE.a();
                    a11.t0(config);
                    rl.c.f74670a.n(config);
                    F0().D(config);
                    a11.u0(new Function1() { // from class: com.transsion.home.fragment.home.n
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit o12;
                            o12 = HomeFragment.o1(HomeFragment.this, config, (List) obj);
                            return o12;
                        }
                    });
                    a11.v0(new Function0() { // from class: com.transsion.home.fragment.home.o
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit p12;
                            p12 = HomeFragment.p1(HomeFragment.this, config);
                            return p12;
                        }
                    });
                    a11.l0(this, "HomePreferencesEnterPopDialog");
                    m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
                if (m1188exceptionOrNullimpl != null) {
                    a.C0856a.l(lg.a.f68962a, "HomeFragment", "showEnterPopDialog error: " + m1188exceptionOrNullimpl.getMessage(), false, 4, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig, List selected) {
        Intrinsics.h(selected, "selected");
        homeFragment.F0().B(homePreferencesConfig);
        homeFragment.F0().L(homePreferencesConfig, selected);
        rl.c.f74670a.m(homePreferencesConfig, selected);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit p1(HomeFragment homeFragment, HomePreferencesConfig homePreferencesConfig) {
        homeFragment.F0().C(homePreferencesConfig);
        rl.c.f74670a.o(homePreferencesConfig);
        return Unit.f67184a;
    }

    private final void q1() {
        List<GradeGroup> arrayList;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            if (activity.isDestroyed() || activity.isFinishing()) {
                activity = null;
            }
            if (activity == null) {
                return;
            }
            GradeSelectDialog gradeSelectDialog = new GradeSelectDialog();
            AppTab appTab = this.appTab;
            if (appTab == null || (arrayList = appTab.getHomeGradeList()) == null) {
                arrayList = new ArrayList<>();
            }
            gradeSelectDialog.x0(arrayList, J0());
            gradeSelectDialog.z0(ak.o.f721a.e());
            gradeSelectDialog.y0(new Function1() { // from class: com.transsion.home.fragment.home.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit r12;
                    r12 = HomeFragment.r1(HomeFragment.this, (GradeItem) obj);
                    return r12;
                }
            });
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics.g(supportFragmentManager, "getSupportFragmentManager(...)");
            gradeSelectDialog.show(supportFragmentManager, "GradeSelectDialog");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r1(HomeFragment homeFragment, GradeItem gradeItem) {
        String str;
        String str2;
        TnTextView tnTextView;
        String name;
        String str3 = "";
        if (gradeItem == null || (str = gradeItem.getName()) == null) {
            str = "";
        }
        if (gradeItem == null || (str2 = gradeItem.getGrade()) == null) {
            str2 = "";
        }
        ak.o oVar = ak.o.f721a;
        oVar.m(str);
        oVar.l(str2);
        rl.e eVar = rl.e.f74676a;
        eVar.b().putString("selected_grade_name", str);
        eVar.b().putString("selected_grade", str2);
        gl.r mViewBinding = homeFragment.getMViewBinding();
        if (mViewBinding != null && (tnTextView = mViewBinding.f63952o) != null) {
            if (gradeItem != null && (name = gradeItem.getName()) != null) {
                str3 = name;
            }
            tnTextView.setText(str3);
        }
        a.C0856a.f(lg.a.f68962a, "HomeFragment", "Grade selected: " + (gradeItem != null ? gradeItem.getName() : null) + ", saved: " + str, false, 4, null);
        homeFragment.a1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s1(String value) {
        gl.r mViewBinding;
        AppCompatImageButton appCompatImageButton;
        AppCompatImageButton appCompatImageButton2;
        Boolean m12;
        boolean booleanValue = (value == null || (m12 = StringsKt.m1(value)) == null) ? false : m12.booleanValue();
        gl.r mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (appCompatImageButton2 = mViewBinding2.f63939b) != null) {
            appCompatImageButton2.setVisibility(booleanValue ? 0 : 8);
        }
        a.C0856a.f(lg.a.f68962a, "HomeFragment", "Menu button visibility: " + booleanValue, false, 4, null);
        if (!booleanValue || (mViewBinding = getMViewBinding()) == null || (appCompatImageButton = mViewBinding.f63939b) == null) {
            return;
        }
        appCompatImageButton.post(new Runnable() { // from class: com.transsion.home.fragment.home.e
            @Override // java.lang.Runnable
            public final void run() {
                HomeFragment.t1(HomeFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t1(HomeFragment homeFragment) {
        com.transsion.baselib.helper.a.f43316a.m(homeFragment.J0(), CollectionsKt.e("home_top_tab_more_menu"), false);
    }

    private final boolean w1() {
        List<HomeTabItem> homeTabs;
        if (this.viewPagerInitialized) {
            return false;
        }
        if (!isAdded() || getMViewBinding() == null) {
            a.C0856a.f(lg.a.f68962a, "HomeFragment", "tryLazyInitViewPager skip, not attached", false, 4, null);
            return false;
        }
        AppTab appTab = this.appTab;
        int size = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? 0 : homeTabs.size();
        if (size <= 0) {
            a.C0856a.f(lg.a.f68962a, "HomeFragment", "tryLazyInitViewPager skip, tabSize=" + size, false, 4, null);
            return false;
        }
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.f(c0856a, "HomeFragment", "tryLazyInitViewPager initViewPager tabSize=" + size, false, 4, null);
        initViewPager();
        if (!isAdded()) {
            return false;
        }
        this.viewPagerInitialized = true;
        a.C0856a.f(c0856a, "HomeFragment", "tryLazyInitViewPager done", false, 4, null);
        return true;
    }

    private final void y1() {
        ConfigBean c11 = sm.f.f75530c.a().c("home_tab_menu_show", true);
        String value = c11 != null ? c11.getValue() : null;
        s1(value);
        if (value == null || value.length() == 0) {
            kotlinx.coroutines.k.d(androidx.view.v.a(this), null, null, new HomeFragment$updateMenuButtonVisibility$1(this, null), 3, null);
        }
    }

    private final void z1(AppTab appTab) {
        List<HomeTabItem> homeTabs;
        List<HomeTabItem> homeTabs2;
        HomeTabItem homeTabItem;
        HomeTabItem homeTabItem2;
        if (appTab != null) {
            List<HomeTabItem> homeTabs3 = appTab.getHomeTabs();
            if ((homeTabs3 != null ? homeTabs3.size() : 0) > 0) {
                String version = appTab.getVersion();
                AppTab appTab2 = this.appTab;
                if (Intrinsics.c(version, appTab2 != null ? appTab2.getVersion() : null)) {
                    List<HomeTabItem> homeTabs4 = appTab.getHomeTabs();
                    String name = (homeTabs4 == null || (homeTabItem2 = homeTabs4.get(0)) == null) ? null : homeTabItem2.getName();
                    AppTab appTab3 = this.appTab;
                    if (Intrinsics.c(name, (appTab3 == null || (homeTabs2 = appTab3.getHomeTabs()) == null || (homeTabItem = homeTabs2.get(0)) == null) ? null : homeTabItem.getName())) {
                        List<HomeTabItem> homeTabs5 = appTab.getHomeTabs();
                        Integer valueOf = homeTabs5 != null ? Integer.valueOf(homeTabs5.size()) : null;
                        AppTab appTab4 = this.appTab;
                        if (Intrinsics.c(valueOf, (appTab4 == null || (homeTabs = appTab4.getHomeTabs()) == null) ? null : Integer.valueOf(homeTabs.size()))) {
                            return;
                        }
                    }
                }
                this.appTab = appTab;
                this.trendingFragment = null;
                HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
                if (homeSearchViewManager != null) {
                    homeSearchViewManager.O(appTab);
                }
                if (this.viewPagerInitialized) {
                    this.trendingFragment = null;
                    initViewPager();
                }
            }
        }
    }

    public final void D0(boolean isWhite) {
        FragmentActivity activity = getActivity();
        BaseActivity baseActivity = activity instanceof BaseActivity ? (BaseActivity) activity : null;
        if (baseActivity != null) {
            baseActivity.changeStatusFontColor(isWhite, true);
        }
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.l(isWhite);
        }
    }

    /* renamed from: I0, reason: from getter */
    public final int getMSelectTabIndex() {
        return this.mSelectTabIndex;
    }

    public final String J0() {
        HomeTabItem homeTabItem;
        String tabCode;
        AppTab appTab = this.appTab;
        List<HomeTabItem> homeTabs = appTab != null ? appTab.getHomeTabs() : null;
        int i11 = this.mSelectTabIndex;
        if (i11 >= 0) {
            return (i11 >= (homeTabs != null ? homeTabs.size() : 0) || homeTabs == null || (homeTabItem = homeTabs.get(this.mSelectTabIndex)) == null || (tabCode = homeTabItem.getTabCode()) == null) ? "" : tabCode;
        }
        return "";
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: K0, reason: merged with bridge method [inline-methods] */
    public gl.r getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        gl.r c11 = gl.r.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    public final boolean Y0() {
        Fragment k02 = getChildFragmentManager().k0("f" + this.mSelectTabIndex);
        return (k02 instanceof WebFragmentV2) && ((WebFragmentV2) k02).u1();
    }

    public final void b1(String pageTabName, boolean isRefresh) {
        Intrinsics.h(pageTabName, "pageTabName");
        com.transsion.baselib.helper.a.f43316a.m(pageTabName, L0(), isRefresh);
    }

    public final void c1() {
        Fragment k02 = getChildFragmentManager().k0("f" + this.mSelectTabIndex);
        if (k02 instanceof BaseHomeSubFragment) {
            ((BaseHomeSubFragment) k02).p0();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        DownloadSDCardUtil.f60017a.c();
        ox.b.f72314a.c().d();
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.p();
        }
        IRewardsCenterApi iRewardsCenterApi = (IRewardsCenterApi) TheRouter.d(IRewardsCenterApi.class, new Object[0]);
        if (iRewardsCenterApi != null) {
            iRewardsCenterApi.b();
        }
        Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.home.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = HomeFragment.Q0(HomeFragment.this, (ak.n) obj);
                return Q0;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = ak.n.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        gl.r mViewBinding;
        BlurredSectorView blurredSectorView;
        Intrinsics.h(view, "view");
        androidx.view.v.a(this);
        this.mSavedInstanceState = savedInstanceState;
        R0();
        g1();
        gl.r mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null) {
            HomeSearchViewManager homeSearchViewManager = new HomeSearchViewManager(mViewBinding2, this);
            this.mHomeSearchViewManager = homeSearchViewManager;
            homeSearchViewManager.C(this.appTab);
        }
        rl.e eVar = rl.e.f74676a;
        String string = eVar.b().getString("selected_grade_name", "All");
        if (string != null && string.length() != 0) {
            ak.o.f721a.m(string);
        }
        String string2 = eVar.b().getString("selected_grade", "UN_GRADE");
        if (string2 != null && string2.length() != 0) {
            ak.o.f721a.l(string2);
        }
        x1();
        AppStartReport.f54571a.l("home_init_view");
        if (Build.VERSION.SDK_INT <= 23 && (mViewBinding = getMViewBinding()) != null && (blurredSectorView = mViewBinding.f63951n) != null) {
            blurredSectorView.setVisibility(8);
        }
        if (ak.o.f721a.i()) {
            return;
        }
        F0().A();
        F0().x().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit V0;
                V0 = HomeFragment.V0(HomeFragment.this, (HomePreferencesConfig) obj);
                return V0;
            }
        }));
        F0().s().j(getViewLifecycleOwner(), new e(new Function1() { // from class: com.transsion.home.fragment.home.k
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit W0;
                W0 = HomeFragment.W0(HomeFragment.this, (HomePreferencesConfig) obj);
                return W0;
            }
        }));
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        this.lazyLoadAttempted = true;
        w1();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.f43398a.n(IntegrationConstants.NAVIGATION_BAR_HOME_ACTION_DEFAULT, Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001b A[Catch: Exception -> 0x0014, TryCatch #0 {Exception -> 0x0014, blocks: (B:3:0x0003, B:6:0x000b, B:11:0x001b, B:12:0x0021, B:14:0x002f, B:16:0x0033, B:23:0x003b, B:24:0x0041), top: B:2:0x0003 }] */
    @Override // com.transsion.baseui.fragment.BaseFragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void newIntent(android.content.Intent r7) {
        /*
            r6 = this;
            super.newIntent(r7)
            boolean r0 = r6.isAdded()     // Catch: java.lang.Exception -> L14
            if (r0 == 0) goto L39
            if (r7 == 0) goto L16
            java.lang.String r0 = "topTab"
            java.lang.String r0 = r7.getStringExtra(r0)     // Catch: java.lang.Exception -> L14
            if (r0 != 0) goto L18
            goto L16
        L14:
            r7 = move-exception
            goto L45
        L16:
            java.lang.String r0 = "Trending"
        L18:
            r1 = -1
            if (r7 == 0) goto L21
            java.lang.String r2 = "secondTabIndex"
            int r1 = r7.getIntExtra(r2, r1)     // Catch: java.lang.Exception -> L14
        L21:
            int r7 = r6.H0(r0, r1)     // Catch: java.lang.Exception -> L14
            r6.mSelectTabIndex = r7     // Catch: java.lang.Exception -> L14
            g4.a r7 = r6.getMViewBinding()     // Catch: java.lang.Exception -> L14
            gl.r r7 = (gl.r) r7     // Catch: java.lang.Exception -> L14
            if (r7 == 0) goto L64
            androidx.viewpager2.widget.ViewPager2 r7 = r7.f63956s     // Catch: java.lang.Exception -> L14
            if (r7 == 0) goto L64
            int r0 = r6.mSelectTabIndex     // Catch: java.lang.Exception -> L14
            r7.setCurrentItem(r0)     // Catch: java.lang.Exception -> L14
            goto L64
        L39:
            if (r7 == 0) goto L40
            android.os.Bundle r7 = r7.getExtras()     // Catch: java.lang.Exception -> L14
            goto L41
        L40:
            r7 = 0
        L41:
            r6.setArguments(r7)     // Catch: java.lang.Exception -> L14
            goto L64
        L45:
            lg.a$a r0 = lg.a.f68962a
            java.lang.String r7 = r7.getMessage()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "error= "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r2 = r1.toString()
            r4 = 4
            r5 = 0
            java.lang.String r1 = "HomeFragment"
            r3 = 0
            lg.a.C0856a.f(r0, r1, r2, r3, r4, r5)
        L64:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.fragment.home.HomeFragment.newIntent(android.content.Intent):void");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        DownloadSDCardUtil.f60017a.e();
        PreloadTrendingData.f45940n.a().D().p(this);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.L();
        }
        HomeSearchViewManager homeSearchViewManager2 = this.mHomeSearchViewManager;
        if (homeSearchViewManager2 != null) {
            homeSearchViewManager2.n();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.trendingFragment = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
                HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
                if (homeSearchViewManager != null) {
                    homeSearchViewManager.L();
                }
            } else {
                logResume();
                HomeSearchViewManager homeSearchViewManager2 = this.mHomeSearchViewManager;
                if (homeSearchViewManager2 != null) {
                    homeSearchViewManager2.M(true);
                }
                HomeSearchViewManager homeSearchViewManager3 = this.mHomeSearchViewManager;
                if (homeSearchViewManager3 != null) {
                    homeSearchViewManager3.G();
                }
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
        lg.a.f68962a.d("onPause fragment count " + getChildFragmentManager().y0().size(), true);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.L();
        }
        if (this.isHandlingRedirect) {
            e1();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible() + " fragment:" + this, 1, null);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        if (homeSearchViewManager != null) {
            homeSearchViewManager.M(true);
        }
        Bundle bundle = this.mSavedInstanceState;
        Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("saved_search_color", 2)) : null;
        if ((valueOf != null && valueOf.intValue() == 0) || (valueOf != null && valueOf.intValue() == 1)) {
            Fragment k02 = getChildFragmentManager().k0("f" + this.mSelectTabIndex);
            if (k02 instanceof BaseHomeSubFragment) {
                ((BaseHomeSubFragment) k02).b0(valueOf != null && valueOf.intValue() == 1);
            } else {
                D0(valueOf != null && valueOf.intValue() == 1);
            }
            this.mSavedInstanceState = null;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.h(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("current_tab", this.mSelectTabIndex);
        HomeSearchViewManager homeSearchViewManager = this.mHomeSearchViewManager;
        int i11 = 0;
        if (homeSearchViewManager != null && homeSearchViewManager.D()) {
            i11 = 1;
        }
        outState.putInt("saved_search_color", i11);
    }

    public final void u1(String tabCode, int tabId) {
        ViewPager2 viewPager2;
        Intrinsics.h(tabCode, "tabCode");
        int H0 = H0(tabCode, tabId);
        gl.r mViewBinding = getMViewBinding();
        if (mViewBinding == null || (viewPager2 = mViewBinding.f63956s) == null) {
            return;
        }
        viewPager2.setCurrentItem(H0, false);
    }

    public final void v1() {
        ViewPager2 viewPager2;
        BaseHomeSubFragment baseHomeSubFragment = this.trendingFragment;
        if (baseHomeSubFragment instanceof TrendingFragment) {
            Intrinsics.f(baseHomeSubFragment, "null cannot be cast to non-null type com.transsion.home.fragment.tab.TrendingFragment");
            ((TrendingFragment) baseHomeSubFragment).h2();
        } else if (baseHomeSubFragment instanceof TrendingUGCFragment) {
            Intrinsics.f(baseHomeSubFragment, "null cannot be cast to non-null type com.transsion.home.fragment.tab.TrendingUGCFragment");
            ((TrendingUGCFragment) baseHomeSubFragment).t1();
        }
        gl.r mViewBinding = getMViewBinding();
        if (mViewBinding == null || (viewPager2 = mViewBinding.f63956s) == null) {
            return;
        }
        viewPager2.setCurrentItem(f45163t, false);
    }

    public final void x1() {
        gl.r mViewBinding;
        TnTextView tnTextView;
        AppCompatImageView appCompatImageView;
        ConstraintLayout constraintLayout;
        List<HomeTabItem> homeTabs;
        AppTab appTab = this.appTab;
        HomeTabItem homeTabItem = (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) ? null : (HomeTabItem) CollectionsKt.l0(homeTabs, this.mSelectTabIndex);
        boolean h11 = HomeTabId.INSTANCE.h(homeTabItem != null ? homeTabItem.getTabId() : null, false);
        ak.o oVar = ak.o.f721a;
        boolean z10 = oVar.i() && h11;
        gl.r mViewBinding2 = getMViewBinding();
        if (mViewBinding2 != null && (constraintLayout = mViewBinding2.f63942e) != null) {
            constraintLayout.setVisibility(z10 ? 0 : 8);
        }
        gl.r mViewBinding3 = getMViewBinding();
        if (mViewBinding3 != null && (appCompatImageView = mViewBinding3.f63944g) != null) {
            appCompatImageView.setVisibility(z10 ? 8 : 0);
        }
        if (!z10 || (mViewBinding = getMViewBinding()) == null || (tnTextView = mViewBinding.f63952o) == null) {
            return;
        }
        tnTextView.setText(oVar.f());
    }
}
