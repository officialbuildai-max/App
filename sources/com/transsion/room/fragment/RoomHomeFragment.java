package com.transsion.room.fragment;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.v0;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.tn.lib.util.networkinfo.NetworkType;
import com.tn.lib.view.RoomCacheAnimationView;
import com.tn.lib.view.RoomCacheStatus;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.widget.GradientTextView;
import com.transsion.baseui.widget.NestedSwipeRefreshLayout;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.moviedetailapi.bean.RoomBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsion.moviedetailapi.bean.RoomTabBean;
import com.transsion.moviedetailapi.bean.RoomTabItem;
import com.transsion.moviedetailapi.bean.RoomTabType;
import com.transsion.postdetailapi.IPostDetailApi;
import com.transsion.publish.api.IPublishApi;
import com.transsion.publish.bean.PublishResult;
import com.transsion.publish.view.UploadView;
import com.transsion.room.activity.RoomHomeActivity;
import com.transsion.room.api.RoomHomeCacheEvent;
import com.transsion.room.api.RoomHomeParentType;
import com.transsion.room.api.RoomHomeRefreshCacheEvent;
import com.transsion.room.api.RoomTabId;
import com.transsion.room.dialog.RequestCacheRoomDialog;
import com.transsion.room.view.RoomHomeTabTitleView;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.room.widget.CommunityRoomsView;
import com.transsion.web.api.WebConstants;
import com.transsion.web.fragment.WebFragmentV2;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.JoinRoomEvent;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import net.lucode.hackware.magicindicator.MagicIndicator;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 |2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001}B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u000f\u0010\u000f\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0010\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0011\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0012\u0010\u0006J\u000f\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010\"\u001a\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0007H\u0016¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b*\u0010\u001bJ\u0019\u0010,\u001a\u00020\u00072\b\u0010+\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b,\u0010-J\u000f\u0010.\u001a\u00020\u0007H\u0016¢\u0006\u0004\b.\u0010\u0006J\u000f\u0010/\u001a\u00020\u0007H\u0016¢\u0006\u0004\b/\u0010\u0006J\u000f\u00100\u001a\u00020\u0007H\u0016¢\u0006\u0004\b0\u0010\u0006J\u000f\u00101\u001a\u00020\u0007H\u0016¢\u0006\u0004\b1\u0010\u0006J\u000f\u00102\u001a\u00020\u0007H\u0016¢\u0006\u0004\b2\u0010\u0006J\u000f\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u0010\u0006J\u0017\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J-\u0010=\u001a\u00020\u00072\u0006\u00109\u001a\u0002082\u0006\u0010:\u001a\u0002042\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030;H\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010A\u001a\u00020\u00072\b\u0010@\u001a\u0004\u0018\u00010?¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u0011\u0010G\u001a\u0004\u0018\u00010FH\u0016¢\u0006\u0004\bG\u0010HJ\u0011\u0010J\u001a\u0004\u0018\u00010IH\u0016¢\u0006\u0004\bJ\u0010KJ\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00030;H\u0016¢\u0006\u0004\bL\u0010MJ\u0019\u0010O\u001a\u0004\u0018\u00010N2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u000204H\u0016¢\u0006\u0004\bQ\u0010RJ\u000f\u0010S\u001a\u00020\u0007H\u0016¢\u0006\u0004\bS\u0010\u0006J\u000f\u0010T\u001a\u00020\u0007H\u0016¢\u0006\u0004\bT\u0010\u0006J\u000f\u0010U\u001a\u00020\u0007H\u0016¢\u0006\u0004\bU\u0010\u0006R\u001b\u0010[\u001a\u00020V8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010@\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\\\u0010]R\u0018\u0010`\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R$\u0010d\u001a\u0010\u0012\u0004\u0012\u000204\u0012\u0006\u0012\u0004\u0018\u00010N0a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010g\u001a\u0002048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010j\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010l\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bk\u0010iR\u0018\u0010n\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010iR\u0018\u0010p\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010iR\u0019\u0010v\u001a\u0004\u0018\u00010q8\u0006¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u001d\u0010{\u001a\u0004\u0018\u00010w8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bx\u0010X\u001a\u0004\by\u0010z¨\u0006~"}, d2 = {"Lcom/transsion/room/fragment/RoomHomeFragment;", "Lcom/transsion/room/fragment/RoomBaseFragment;", "Lbq/q;", "Lcom/transsion/moviedetailapi/bean/RoomTabItem;", "Laq/d;", "<init>", "()V", "", "r1", "b1", "c1", "", "W0", "()Z", "T0", "m1", "w1", "loadData", "z1", "k1", "i1", "Landroid/content/Context;", "context", "A1", "(Landroid/content/Context;)V", "isTabClick", "t1", "(Z)V", "Landroid/view/LayoutInflater;", "inflater", "X0", "(Landroid/view/LayoutInflater;)Lbq/q;", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "lazyLoadData", "lazyLoadWithoutNet", "", "getPageStateLayoutTitle", "()Ljava/lang/String;", "initViewData", "e", "pageFrom", "y", "(Ljava/lang/String;)V", "initViewModel", "initListener", TmcConstants.NAVIGATION_ON_START, "retryLoadData", "onResume", "q1", "", RequestParameters.POSITION, "v0", "(I)V", "Lcom/transsion/room/view/RoomHomeTabTitleView;", "tabView", "index", "", "tabList", "x0", "(Lcom/transsion/room/view/RoomHomeTabTitleView;ILjava/util/List;)V", "Lcom/transsion/publish/bean/PublishResult;", "eventBean", "u1", "(Lcom/transsion/publish/bean/PublishResult;)V", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "Landroidx/viewpager2/widget/ViewPager2;", "z0", "()Landroidx/viewpager2/widget/ViewPager2;", "Lnet/lucode/hackware/magicindicator/MagicIndicator;", "u0", "()Lnet/lucode/hackware/magicindicator/MagicIndicator;", "y0", "()Ljava/util/List;", "Landroidx/fragment/app/Fragment;", "m0", "(I)Landroidx/fragment/app/Fragment;", "A", "()I", "t", "F", "O", "Lcom/transsion/room/viewmodel/RoomViewModel;", be.g.f16474b, "Lkotlin/Lazy;", "V0", "()Lcom/transsion/room/viewmodel/RoomViewModel;", "mRoomViewModel", "h", "Lcom/transsion/publish/bean/PublishResult;", "i", "Landroidx/fragment/app/Fragment;", "mExploreFragment", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "Ljava/util/Map;", "mRefreshViewMap", CampaignEx.JSON_KEY_AD_K, "I", "mExplorePosition", "l", "Ljava/lang/String;", "insertPostId", "m", "insertPostOps", "n", "parentTypeName", "o", "cache", "Lcom/transsion/mb/config/manager/ConfigBean;", TtmlNode.TAG_P, "Lcom/transsion/mb/config/manager/ConfigBean;", "getRoomCacheOpen", "()Lcom/transsion/mb/config/manager/ConfigBean;", "roomCacheOpen", "Lcom/transsion/publish/api/IPublishApi;", CampaignEx.JSON_KEY_AD_Q, "U0", "()Lcom/transsion/publish/api/IPublishApi;", "mPublishedApi", CampaignEx.JSON_KEY_AD_R, "a", "Room_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class RoomHomeFragment extends RoomBaseFragment<bq.q, RoomTabItem> implements aq.d {

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: s, reason: collision with root package name */
    private static final String f51527s = "net_without_wifi_image_tab";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private PublishResult eventBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Fragment mExploreFragment;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int mExplorePosition;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private String insertPostId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private String insertPostOps;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private String parentTypeName;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Lazy mRoomViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(RoomViewModel.class), new Function0<androidx.view.x0>() { // from class: com.transsion.room.fragment.RoomHomeFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final androidx.view.x0 invoke() {
            androidx.view.x0 viewModelStore = Fragment.this.requireActivity().getViewModelStore();
            Intrinsics.g(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomHomeFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = Fragment.this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.g(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private Map mRefreshViewMap = new LinkedHashMap();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private String cache = com.transsion.baselib.report.launch.b.f43424a.b().getString("room_cache_data", "");

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final ConfigBean roomCacheOpen = sm.f.f75530c.a().c("room_cache_open", true);

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final Lazy mPublishedApi = LazyKt.b(new Function0() { // from class: com.transsion.room.fragment.z0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            IPublishApi h12;
            h12 = RoomHomeFragment.h1();
            return h12;
        }
    });

    /* renamed from: com.transsion.room.fragment.RoomHomeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RoomHomeFragment b(Companion companion, RoomHomeParentType roomHomeParentType, String str, String str2, int i11, Object obj) {
            if ((i11 & 2) != 0) {
                str = null;
            }
            if ((i11 & 4) != 0) {
                str2 = null;
            }
            return companion.a(roomHomeParentType, str, str2);
        }

        public final RoomHomeFragment a(RoomHomeParentType parentType, String str, String str2) {
            Intrinsics.h(parentType, "parentType");
            RoomHomeFragment roomHomeFragment = new RoomHomeFragment();
            roomHomeFragment.setArguments(androidx.core.os.d.b(TuplesKt.a("post_id", str), TuplesKt.a("ops", str2), TuplesKt.a("parent_type", parentType.name())));
            return roomHomeFragment;
        }
    }

    /* loaded from: classes6.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f51539a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            try {
                iArr[NetworkType.NETWORK_2G.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkType.NETWORK_3G.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkType.NETWORK_4G.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[NetworkType.NETWORK_5G.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f51539a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            RoomCacheAnimationView roomCacheAnimationView;
            super.onPageSelected(i11);
            bq.q qVar = (bq.q) RoomHomeFragment.this.getMViewBinding();
            if (qVar == null || (roomCacheAnimationView = qVar.f16929d) == null) {
                return;
            }
            roomCacheAnimationView.setVisibility(i11 == RoomHomeFragment.this.mExplorePosition && RoomHomeFragment.this.W0() ? 0 : 8);
        }
    }

    /* loaded from: classes6.dex */
    static final class d implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f51541a;

        d(Function1 function) {
            Intrinsics.h(function, "function");
            this.f51541a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f51541a;
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
            this.f51541a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends CountDownTimer {
        e() {
            super(5000L, 1000L);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.CountDownTimer
        public void onFinish() {
            BubbleTextView bubbleTextView;
            bq.q qVar = (bq.q) RoomHomeFragment.this.getMViewBinding();
            if (qVar == null || (bubbleTextView = qVar.f16927b) == null) {
                return;
            }
            jg.c.g(bubbleTextView);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
        }
    }

    private final void A1(Context context) {
        UploadView uploadView = new UploadView(context);
        uploadView.setPageName("room_home");
        if (!uploadView.getIsShow()) {
            uploadView.setVisibility(0);
            uploadView.setAlpha(1.0f);
            Activity b11 = com.blankj.utilcode.util.a.b();
            if (b11 == null || b11.isFinishing() || b11.isDestroyed()) {
                b11 = com.blankj.utilcode.util.a.b();
            }
            if (b11 == null || b11.isFinishing() || b11.isDestroyed()) {
                return;
            } else {
                uploadView.show(b11);
            }
        }
        uploadView.showFloatView(this.eventBean);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void T0() {
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("room_cache_data", "");
        this.cache = string;
        if (string == null || string.length() == 0) {
            bq.q qVar = (bq.q) getMViewBinding();
            if (qVar == null || (roomCacheAnimationView = qVar.f16929d) == null) {
                return;
            }
            roomCacheAnimationView.setStatus(RoomCacheStatus.START);
            return;
        }
        bq.q qVar2 = (bq.q) getMViewBinding();
        if (qVar2 == null || (roomCacheAnimationView2 = qVar2.f16929d) == null) {
            return;
        }
        roomCacheAnimationView2.setStatus(RoomCacheStatus.END);
    }

    private final IPublishApi U0() {
        return (IPublishApi) this.mPublishedApi.getValue();
    }

    private final RoomViewModel V0() {
        return (RoomViewModel) this.mRoomViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean W0() {
        ConfigBean configBean = this.roomCacheOpen;
        String value = configBean != null ? configBean.getValue() : null;
        if (value != null && value.length() != 0) {
            ConfigBean configBean2 = this.roomCacheOpen;
            if (Intrinsics.c(configBean2 != null ? configBean2.getValue() : null, "true")) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(RoomHomeFragment roomHomeFragment, View view) {
        roomHomeFragment.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z0(RoomHomeFragment roomHomeFragment, View view) {
        roomHomeFragment.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(RoomHomeFragment roomHomeFragment, View view) {
        String string = com.transsion.baselib.report.launch.b.f43424a.b().getString("room_cache_data", "");
        if (string == null || string.length() == 0) {
            roomHomeFragment.w1();
            return;
        }
        IPostDetailApi q02 = roomHomeFragment.q0();
        if (q02 != null) {
            q02.n(roomHomeFragment.mExploreFragment);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void b1() {
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        c1();
        String str = this.cache;
        if (str == null || str.length() == 0) {
            bq.q qVar = (bq.q) getMViewBinding();
            if (qVar == null || (roomCacheAnimationView = qVar.f16929d) == null) {
                return;
            }
            roomCacheAnimationView.setStatus(RoomCacheStatus.START);
            return;
        }
        bq.q qVar2 = (bq.q) getMViewBinding();
        if (qVar2 == null || (roomCacheAnimationView2 = qVar2.f16929d) == null) {
            return;
        }
        roomCacheAnimationView2.setStatus(RoomCacheStatus.END);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c1() {
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        ConfigBean configBean = this.roomCacheOpen;
        String value = configBean != null ? configBean.getValue() : null;
        if (value != null && value.length() != 0) {
            ConfigBean configBean2 = this.roomCacheOpen;
            if (Intrinsics.c(configBean2 != null ? configBean2.getValue() : null, "true")) {
                bq.q qVar = (bq.q) getMViewBinding();
                if (qVar == null || (roomCacheAnimationView2 = qVar.f16929d) == null) {
                    return;
                }
                jg.c.k(roomCacheAnimationView2);
                return;
            }
        }
        bq.q qVar2 = (bq.q) getMViewBinding();
        if (qVar2 == null || (roomCacheAnimationView = qVar2.f16929d) == null) {
            return;
        }
        jg.c.g(roomCacheAnimationView);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d1(RoomHomeFragment roomHomeFragment) {
        roomHomeFragment.r1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void e1(RoomHomeFragment roomHomeFragment, AppBarLayout appBarLayout, int i11) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        bq.q qVar = (bq.q) roomHomeFragment.getMViewBinding();
        if (qVar == null || (nestedSwipeRefreshLayout = qVar.f16932g) == null) {
            return;
        }
        nestedSwipeRefreshLayout.setEnabled(i11 >= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit f1(RoomHomeFragment roomHomeFragment, RoomTabBean roomTabBean) {
        List<RoomTabItem> items;
        List<RoomTabItem> items2;
        List<RoomTabItem> items3;
        String value;
        List<RoomTabItem> items4;
        NetworkType c11 = nh.m.f70597a.c();
        int i11 = -1;
        int i12 = c11 == null ? -1 : b.f51539a[c11.ordinal()];
        int i13 = 0;
        if (i12 == 1 || i12 == 2 || i12 == 3 || i12 == 4) {
            ConfigBean d11 = sm.f.d(sm.f.f75530c.a(), f51527s, false, 2, null);
            if ((d11 == null || (value = d11.getValue()) == null) ? false : Boolean.parseBoolean(value)) {
                if (roomTabBean != null && (items3 = roomTabBean.getItems()) != null) {
                    Iterator<RoomTabItem> it = items3.iterator();
                    while (it.hasNext()) {
                        if (Intrinsics.c(it.next().getTabId(), "images")) {
                            i11 = i13;
                            break;
                        }
                        i13++;
                    }
                    i13 = i11;
                } else if (roomTabBean != null && (items2 = roomTabBean.getItems()) != null) {
                    Iterator<RoomTabItem> it2 = items2.iterator();
                    while (it2.hasNext()) {
                        if (Intrinsics.c(it2.next().getTabId(), roomTabBean.getDefTabId())) {
                            i11 = i13;
                            break;
                        }
                        i13++;
                    }
                    i13 = i11;
                }
            } else if (roomTabBean != null && (items = roomTabBean.getItems()) != null) {
                Iterator<RoomTabItem> it3 = items.iterator();
                while (it3.hasNext()) {
                    if (Intrinsics.c(it3.next().getTabId(), roomTabBean.getDefTabId())) {
                        i11 = i13;
                        break;
                    }
                    i13++;
                }
                i13 = i11;
            }
        } else if (roomTabBean != null && (items4 = roomTabBean.getItems()) != null) {
            Iterator<RoomTabItem> it4 = items4.iterator();
            while (it4.hasNext()) {
                if (Intrinsics.c(it4.next().getTabId(), roomTabBean.getDefTabId())) {
                    i11 = i13;
                    break;
                }
                i13++;
            }
            i13 = i11;
        }
        roomHomeFragment.w0(i13);
        roomHomeFragment.initViewPager();
        roomHomeFragment.s0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit g1(RoomHomeFragment roomHomeFragment, RoomBean roomBean) {
        bq.q qVar;
        CommunityRoomsView communityRoomsView;
        CommunityRoomsView communityRoomsView2;
        CommunityRoomsView communityRoomsView3;
        CommunityRoomsView communityRoomsView4;
        List<RoomItem> items = roomBean != null ? roomBean.getItems() : null;
        if (items != null && !items.isEmpty()) {
            bq.q qVar2 = (bq.q) roomHomeFragment.getMViewBinding();
            if ((qVar2 == null || (communityRoomsView4 = qVar2.f16935j) == null || communityRoomsView4.getVisibility() != 0) && (qVar = (bq.q) roomHomeFragment.getMViewBinding()) != null && (communityRoomsView = qVar.f16935j) != null) {
                jg.c.k(communityRoomsView);
            }
            bq.q qVar3 = (bq.q) roomHomeFragment.getMViewBinding();
            if (qVar3 != null && (communityRoomsView3 = qVar3.f16935j) != null) {
                List<RoomItem> items2 = roomBean != null ? roomBean.getItems() : null;
                Intrinsics.e(items2);
                communityRoomsView3.setList(items2);
            }
            bq.q qVar4 = (bq.q) roomHomeFragment.getMViewBinding();
            if (qVar4 != null && (communityRoomsView2 = qVar4.f16935j) != null) {
                communityRoomsView2.setReportName("room_home", "room_home_community");
            }
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPublishApi h1() {
        return (IPublishApi) TheRouter.d(IPublishApi.class, new Object[0]);
    }

    private final void i1() {
        Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.q0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j12;
                j12 = RoomHomeFragment.j1(RoomHomeFragment.this, (PublishResult) obj);
                return j12;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishResult.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j1(RoomHomeFragment roomHomeFragment, PublishResult it) {
        Intrinsics.h(it, "it");
        roomHomeFragment.u1(it);
        return Unit.f67184a;
    }

    private final void k1() {
        Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.t0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit l12;
                l12 = RoomHomeFragment.l1(RoomHomeFragment.this, (JoinRoomEvent) obj);
                return l12;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = JoinRoomEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit l1(RoomHomeFragment roomHomeFragment, JoinRoomEvent value) {
        CommunityRoomsView communityRoomsView;
        List<RoomItem> dataList;
        Object obj;
        Context context;
        Intrinsics.h(value, "value");
        if (value.getJoin()) {
            Context context2 = roomHomeFragment.getContext();
            if (context2 != null) {
                RoomViewModel.u(roomHomeFragment.V0(), context2, null, 0, 6, null);
            }
        } else {
            bq.q qVar = (bq.q) roomHomeFragment.getMViewBinding();
            if (qVar != null && (communityRoomsView = qVar.f16935j) != null && (dataList = communityRoomsView.getDataList()) != null) {
                Iterator<T> it = dataList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.c(((RoomItem) obj).getGroupId(), value.getGroupId())) {
                        break;
                    }
                }
                if (((RoomItem) obj) != null && (context = roomHomeFragment.getContext()) != null) {
                    RoomViewModel.u(roomHomeFragment.V0(), context, null, 0, 6, null);
                }
            }
        }
        return Unit.f67184a;
    }

    private final void loadData() {
        Context context = getContext();
        if (context != null) {
            RoomViewModel.u(V0(), context, null, 0, 6, null);
        }
    }

    private final void m1() {
        Function1 function1 = new Function1() { // from class: com.transsion.room.fragment.r0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit n12;
                n12 = RoomHomeFragment.n1(RoomHomeFragment.this, (RoomHomeCacheEvent) obj);
                return n12;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = RoomHomeCacheEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsion.room.fragment.s0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit o12;
                o12 = RoomHomeFragment.o1((RoomHomeRefreshCacheEvent) obj);
                return o12;
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = RoomHomeRefreshCacheEvent.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit n1(RoomHomeFragment roomHomeFragment, RoomHomeCacheEvent it) {
        RoomCacheAnimationView roomCacheAnimationView;
        Intrinsics.h(it, "it");
        bq.q qVar = (bq.q) roomHomeFragment.getMViewBinding();
        if (qVar != null && (roomCacheAnimationView = qVar.f16929d) != null) {
            roomCacheAnimationView.setStatus(RoomCacheStatus.END);
        }
        roomHomeFragment.cache = com.transsion.baselib.report.launch.b.f43424a.b().getString("room_cache_data", "");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit o1(RoomHomeRefreshCacheEvent it) {
        Intrinsics.h(it, "it");
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p1(RoomHomeFragment roomHomeFragment) {
        ViewPager2 z02 = roomHomeFragment.z0();
        if (z02 != null) {
            z02.setCurrentItem(roomHomeFragment.o0(), false);
        }
        aq.h.f16175a.q(false);
    }

    private final void r1() {
        loadData();
        T0();
        InterfaceC1015e interfaceC1015e = (Fragment) this.mRefreshViewMap.get(Integer.valueOf(getMSelectTabIndex()));
        if (interfaceC1015e != null) {
            ep.b bVar = interfaceC1015e instanceof ep.b ? (ep.b) interfaceC1015e : null;
            if (bVar != null) {
                bVar.doRefresh(new Function0() { // from class: com.transsion.room.fragment.e1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit s12;
                        s12 = RoomHomeFragment.s1(RoomHomeFragment.this);
                        return s12;
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit s1(RoomHomeFragment roomHomeFragment) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        bq.q qVar;
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout2;
        bq.q qVar2 = (bq.q) roomHomeFragment.getMViewBinding();
        if (qVar2 != null && (nestedSwipeRefreshLayout = qVar2.f16932g) != null && nestedSwipeRefreshLayout.isRefreshing() && (qVar = (bq.q) roomHomeFragment.getMViewBinding()) != null && (nestedSwipeRefreshLayout2 = qVar.f16932g) != null) {
            nestedSwipeRefreshLayout2.setRefreshing(false);
        }
        return Unit.f67184a;
    }

    private final void t1(boolean isTabClick) {
        String str;
        List<RoomTabItem> items;
        RoomTabItem roomTabItem;
        String tabId;
        Map m11 = MapsKt.m(TuplesKt.a("opt_type", isTabClick ? "tab_refresh" : "feed_error"));
        try {
            Result.Companion companion = Result.INSTANCE;
            RoomTabBean roomTabBean = (RoomTabBean) V0().G().f();
            if (roomTabBean == null || (items = roomTabBean.getItems()) == null || (roomTabItem = items.get(getMSelectTabIndex())) == null || (tabId = roomTabItem.getTabId()) == null) {
                str = null;
            } else {
                str = (String) m11.put("subpage_name", "room_home_" + tabId);
            }
            Result.m1185constructorimpl(str);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        hj.i.f64628a.p("room_home", m11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v1(RoomHomeFragment roomHomeFragment) {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        roomHomeFragment.A1(a11);
    }

    private final void w1() {
        RequestCacheRoomDialog a11 = RequestCacheRoomDialog.INSTANCE.a();
        a11.t0(new Function0() { // from class: com.transsion.room.fragment.u0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit x12;
                x12 = RoomHomeFragment.x1(RoomHomeFragment.this);
                return x12;
            }
        });
        Dialog dialog = a11.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(true);
        }
        a11.j0(new DialogInterface.OnDismissListener() { // from class: com.transsion.room.fragment.v0
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                RoomHomeFragment.y1(dialogInterface);
            }
        });
        a11.k0(getContext(), "room_cache_dialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit x1(RoomHomeFragment roomHomeFragment) {
        bq.q qVar;
        RoomCacheAnimationView roomCacheAnimationView;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return Unit.f67184a;
        }
        IPostDetailApi q02 = roomHomeFragment.q0();
        if (q02 != null) {
            q02.g(roomHomeFragment.mExploreFragment, false);
        }
        String str = roomHomeFragment.cache;
        if ((str == null || str.length() == 0) && (qVar = (bq.q) roomHomeFragment.getMViewBinding()) != null && (roomCacheAnimationView = qVar.f16929d) != null) {
            roomCacheAnimationView.setStatus(RoomCacheStatus.LOADING);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y1(DialogInterface dialogInterface) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z1() {
        BubbleTextView bubbleTextView;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        if (bVar.b().getBoolean("show_room_cache_guide", false) || !W0()) {
            return;
        }
        e eVar = new e();
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar != null && (bubbleTextView = qVar.f16927b) != null) {
            jg.c.k(bubbleTextView);
        }
        bq.q qVar2 = (bq.q) getMViewBinding();
        if (qVar2 == null || qVar2.f16927b == null) {
            return;
        }
        eVar.start();
        bVar.b().putBoolean("show_room_cache_guide", true);
    }

    @Override // aq.d
    public int A() {
        return getMSelectTabIndex();
    }

    @Override // aq.d
    public void F() {
        T0();
    }

    @Override // aq.d
    public void O() {
        hj.b logViewConfig = getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* renamed from: X0, reason: merged with bridge method [inline-methods] */
    public bq.q getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        bq.q c11 = bq.q.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aq.d
    public void e(boolean isTabClick) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        AppBarLayout appBarLayout;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        t1(isTabClick);
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar != null && (appBarLayout = qVar.f16928c) != null) {
            appBarLayout.setExpanded(true);
        }
        bq.q qVar2 = (bq.q) getMViewBinding();
        if (qVar2 != null && (nestedSwipeRefreshLayout = qVar2.f16932g) != null) {
            nestedSwipeRefreshLayout.setRefreshing(true);
        }
        r1();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String getPageStateLayoutTitle() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        ViewPager2 viewPager2;
        RoomCacheAnimationView roomCacheAnimationView;
        GradientTextView gradientTextView;
        AppCompatImageView appCompatImageView;
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar != null && (appCompatImageView = qVar.f16930e) != null) {
            appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.p0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomHomeFragment.Y0(RoomHomeFragment.this, view);
                }
            });
        }
        bq.q qVar2 = (bq.q) getMViewBinding();
        if (qVar2 != null && (gradientTextView = qVar2.f16934i) != null) {
            gradientTextView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.x0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomHomeFragment.Z0(RoomHomeFragment.this, view);
                }
            });
        }
        bq.q qVar3 = (bq.q) getMViewBinding();
        if (qVar3 != null && (roomCacheAnimationView = qVar3.f16929d) != null) {
            roomCacheAnimationView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.room.fragment.y0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RoomHomeFragment.a1(RoomHomeFragment.this, view);
                }
            });
        }
        bq.q qVar4 = (bq.q) getMViewBinding();
        if (qVar4 == null || (viewPager2 = qVar4.f16936k) == null) {
            return;
        }
        viewPager2.registerOnPageChangeCallback(new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewData() {
        AppCompatImageView appCompatImageView;
        AppBarLayout appBarLayout;
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar != null && (nestedSwipeRefreshLayout = qVar.f16932g) != null) {
            nestedSwipeRefreshLayout.setProgressBackgroundColorSchemeColor(androidx.core.content.b.getColor(nestedSwipeRefreshLayout.getContext(), R$color.bg_01));
            nestedSwipeRefreshLayout.setColorSchemeColors(androidx.core.content.b.getColor(nestedSwipeRefreshLayout.getContext(), R$color.main_gradient_center), androidx.core.content.b.getColor(nestedSwipeRefreshLayout.getContext(), R$color.main_gradient_start));
            nestedSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.j() { // from class: com.transsion.room.fragment.a1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j
                public final void a() {
                    RoomHomeFragment.d1(RoomHomeFragment.this);
                }
            });
        }
        bq.q qVar2 = (bq.q) getMViewBinding();
        if (qVar2 != null && (appBarLayout = qVar2.f16928c) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.g() { // from class: com.transsion.room.fragment.b1
                @Override // com.google.android.material.appbar.AppBarLayout.b
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i11) {
                    RoomHomeFragment.e1(RoomHomeFragment.this, appBarLayout2, i11);
                }
            });
        }
        bq.q qVar3 = (bq.q) getMViewBinding();
        if (qVar3 != null && (appCompatImageView = qVar3.f16930e) != null && !(getActivity() instanceof RoomHomeActivity)) {
            ViewGroup.LayoutParams layoutParams = appCompatImageView.getLayoutParams();
            Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = com.transsion.usercenter.setting.labelsfeedback.a.b(104);
            appCompatImageView.setLayoutParams(marginLayoutParams);
        }
        b1();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
        V0().v().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.c1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit g12;
                g12 = RoomHomeFragment.g1(RoomHomeFragment.this, (RoomBean) obj);
                return g12;
            }
        }));
        V0().G().j(this, new d(new Function1() { // from class: com.transsion.room.fragment.d1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit f12;
                f12 = RoomHomeFragment.f1(RoomHomeFragment.this, (RoomTabBean) obj);
                return f12;
            }
        }));
        i1();
        k1();
        m1();
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment, com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        V0().H();
        loadData();
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadWithoutNet() {
        V0().H();
        loadData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public Fragment m0(int position) {
        List<RoomTabItem> items;
        RoomTabItem roomTabItem;
        Fragment c11;
        bq.q qVar;
        bq.q qVar2;
        RoomCacheAnimationView roomCacheAnimationView;
        RoomCacheAnimationView roomCacheAnimationView2;
        try {
            RoomTabBean roomTabBean = (RoomTabBean) V0().G().f();
            if (roomTabBean != null && (items = roomTabBean.getItems()) != null && (roomTabItem = items.get(position)) != null) {
                String tabId = roomTabItem.getTabId();
                if (Intrinsics.c(tabId, RoomTabId.EXPLORE.getValue())) {
                    IPostDetailApi q02 = q0();
                    c11 = q02 != null ? q02.d(this.parentTypeName, this.insertPostId, this.insertPostOps) : null;
                    this.mExplorePosition = position;
                    if (getMSelectTabIndex() == position && (((qVar = (bq.q) getMViewBinding()) == null || (roomCacheAnimationView2 = qVar.f16929d) == null || roomCacheAnimationView2.getVisibility() != 0) && W0() && (qVar2 = (bq.q) getMViewBinding()) != null && (roomCacheAnimationView = qVar2.f16929d) != null)) {
                        jg.c.k(roomCacheAnimationView);
                    }
                    this.mExploreFragment = c11;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c11);
                } else if (Intrinsics.c(tabId, RoomTabId.NEARBY.getValue())) {
                    IPostDetailApi q03 = q0();
                    c11 = q03 != null ? q03.l(this.parentTypeName) : null;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c11);
                } else if (Intrinsics.c(tabId, RoomTabId.DISCOVER.getValue())) {
                    IPostDetailApi q04 = q0();
                    c11 = q04 != null ? q04.b(this.parentTypeName, roomTabItem, position) : null;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c11);
                } else if (Intrinsics.c(roomTabItem.getType(), RoomTabType.H5.getValue())) {
                    WebFragmentV2 b11 = WebFragmentV2.INSTANCE.b();
                    Pair a11 = TuplesKt.a("url", roomTabItem.getUrl());
                    Boolean bool = Boolean.TRUE;
                    b11.setArguments(androidx.core.os.d.b(a11, TuplesKt.a(WebConstants.FIELD_STATUS_BAR_HIDDEN, bool), TuplesKt.a(WebConstants.FIELD_TOOL_BAR_HIDDEN, bool)));
                    c11 = b11;
                } else {
                    IPostDetailApi q05 = q0();
                    c11 = q05 != null ? q05.c(this.parentTypeName, roomTabItem, position) : null;
                    this.mRefreshViewMap.put(Integer.valueOf(position), c11);
                }
                if (c11 != null) {
                    return c11;
                }
            }
            IPostDetailApi q06 = q0();
            Fragment d11 = q06 != null ? q06.d(this.parentTypeName, this.insertPostId, this.insertPostOps) : null;
            this.mExploreFragment = d11;
            return d11;
        } catch (Throwable unused) {
            IPostDetailApi q07 = q0();
            Fragment d12 = q07 != null ? q07.d(this.parentTypeName, this.insertPostId, this.insertPostOps) : null;
            this.mExploreFragment = d12;
            return d12;
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public hj.b newLogViewConfig() {
        return new hj.b("room_home", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        this.insertPostId = arguments != null ? arguments.getString("post_id") : null;
        Bundle arguments2 = getArguments();
        this.insertPostOps = arguments2 != null ? arguments2.getString("ops") : null;
        Bundle arguments3 = getArguments();
        this.parentTypeName = arguments3 != null ? arguments3.getString("parent_type") : null;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewPager2 z02;
        super.onResume();
        z1();
        c1();
        if (!aq.h.f16175a.f() || (z02 = z0()) == null) {
            return;
        }
        z02.postDelayed(new Runnable() { // from class: com.transsion.room.fragment.f1
            @Override // java.lang.Runnable
            public final void run() {
                RoomHomeFragment.p1(RoomHomeFragment.this);
            }
        }, 200L);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    public void q1() {
        IPublishApi U0;
        Context context = getContext();
        if (context == null || (U0 = U0()) == null) {
            return;
        }
        U0.b(context);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void retryLoadData() {
        loadData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aq.d
    public void t() {
        RoomCacheAnimationView roomCacheAnimationView;
        if (!nh.m.f70597a.e()) {
            uh.b.f76876a.d(R$string.no_network_toast);
            return;
        }
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar != null && (roomCacheAnimationView = qVar.f16929d) != null) {
            roomCacheAnimationView.setStatus(RoomCacheStatus.LOADING);
        }
        IPostDetailApi q02 = q0();
        if (q02 != null) {
            q02.g(this.mExploreFragment, true);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public MagicIndicator u0() {
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar != null) {
            return qVar.f16931f;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void u1(PublishResult eventBean) {
        bq.q qVar;
        AppCompatImageView appCompatImageView;
        this.eventBean = eventBean;
        Integer valueOf = eventBean != null ? Integer.valueOf(eventBean.getState()) : null;
        if (valueOf == null || valueOf.intValue() != 0 || (qVar = (bq.q) getMViewBinding()) == null || (appCompatImageView = qVar.f16930e) == null) {
            return;
        }
        appCompatImageView.postDelayed(new Runnable() { // from class: com.transsion.room.fragment.w0
            @Override // java.lang.Runnable
            public final void run() {
                RoomHomeFragment.v1(RoomHomeFragment.this);
            }
        }, 1500L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public void v0(int position) {
        NestedSwipeRefreshLayout nestedSwipeRefreshLayout;
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar == null || (nestedSwipeRefreshLayout = qVar.f16932g) == null) {
            return;
        }
        nestedSwipeRefreshLayout.setEnabled(this.mRefreshViewMap.containsKey(Integer.valueOf(position)));
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    public void x0(RoomHomeTabTitleView tabView, int index, List tabList) {
        Intrinsics.h(tabView, "tabView");
        Intrinsics.h(tabList, "tabList");
        RoomTabItem roomTabItem = (RoomTabItem) tabList.get(index);
        tabView.setTitle(roomTabItem.getName());
        tabView.setBadge(roomTabItem);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // aq.d
    public void y(String pageFrom) {
        ViewPager2 viewPager2;
        HashMap g11;
        HashMap g12;
        if (pageFrom != null && pageFrom.length() != 0) {
            hj.b logViewConfig = getLogViewConfig();
            if (logViewConfig != null && (g12 = logViewConfig.g()) != null) {
            }
            String str = getActivity() instanceof RoomHomeActivity ? "sub_page" : "main";
            hj.b logViewConfig2 = getLogViewConfig();
            if (logViewConfig2 != null && (g11 = logViewConfig2.g()) != null) {
            }
        }
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar == null || (viewPager2 = qVar.f16936k) == null) {
            return;
        }
        viewPager2.setCurrentItem(n0());
    }

    @Override // com.transsion.room.fragment.RoomBaseFragment
    /* renamed from: y0 */
    public List getMTabs() {
        List<RoomTabItem> items;
        ArrayList arrayList = new ArrayList();
        RoomTabBean roomTabBean = (RoomTabBean) V0().G().f();
        if (roomTabBean != null && (items = roomTabBean.getItems()) != null) {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                arrayList.add((RoomTabItem) it.next());
            }
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.room.fragment.RoomBaseFragment
    public ViewPager2 z0() {
        bq.q qVar = (bq.q) getMViewBinding();
        if (qVar != null) {
            return qVar.f16936k;
        }
        return null;
    }
}
