package com.transsion.usercenter.me;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.Lifecycle;
import androidx.view.v0;
import androidx.view.x0;
import androidx.view.y0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.bubbleview.BubbleFrameLayout;
import com.transsion.baselib.kids.KidsAccountManager;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.IPremiumApi;
import com.transsion.rewardscenterapi.IRewardsCenterApi;
import com.transsion.usercenter.profile.bean.IconItemInfo;
import com.transsion.usercenter.profile.bean.MeHistoryInfo;
import com.transsion.usercenter.profile.bean.MeItemInfo;
import com.transsion.web.api.WebConstants;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import dz.a;
import fw.k0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t*\u0002\u0086\u0001\u0018\u0000 \u0092\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001]B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u0017\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u000f\u0010\u0018\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0018\u0010\u0005J\u000f\u0010\u0019\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0019\u0010\u0005J\u000f\u0010\u001a\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001a\u0010\u0005J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001b\u0010\u0013J\u000f\u0010\u001c\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u0016J\u000f\u0010\u001d\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001d\u0010\u0016J\u000f\u0010\u001e\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0002¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u001f\u0010%\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002¢\u0006\u0004\b%\u0010&J\u001f\u0010'\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\"H\u0002¢\u0006\u0004\b'\u0010&J\u0017\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\"H\u0002¢\u0006\u0004\b)\u0010*J\u0013\u0010+\u001a\u00020\u0010*\u00020\"H\u0002¢\u0006\u0004\b+\u0010*J\u0013\u0010,\u001a\u00020\u0010*\u00020\"H\u0002¢\u0006\u0004\b,\u0010*J\u000f\u0010-\u001a\u00020\u0010H\u0002¢\u0006\u0004\b-\u0010\u001fJ\u000f\u0010.\u001a\u00020\u0010H\u0002¢\u0006\u0004\b.\u0010\u001fJ\u000f\u0010/\u001a\u00020\u0010H\u0002¢\u0006\u0004\b/\u0010\u001fJ\u000f\u00100\u001a\u00020\u0010H\u0002¢\u0006\u0004\b0\u0010\u001fJ\u000f\u00102\u001a\u000201H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0010H\u0002¢\u0006\u0004\b4\u0010\u001fJ\u000f\u00105\u001a\u00020\u0006H\u0002¢\u0006\u0004\b5\u0010\u0005J\u0011\u00107\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0004\b7\u00108J\u000f\u00109\u001a\u00020\u0006H\u0002¢\u0006\u0004\b9\u0010\u0005J\u000f\u0010:\u001a\u00020\u0006H\u0002¢\u0006\u0004\b:\u0010\u0005J\u001f\u0010>\u001a\u00020\u00062\u000e\u0010=\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010;H\u0002¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\u0006H\u0002¢\u0006\u0004\b@\u0010\u0005J\u0017\u0010C\u001a\u00020\u00022\u0006\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bC\u0010DJ!\u0010G\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bG\u0010HJ!\u0010I\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\"2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016¢\u0006\u0004\bI\u0010HJ\u000f\u0010J\u001a\u00020\u0006H\u0016¢\u0006\u0004\bJ\u0010\u0005J\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010\u0005J\u0017\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020LH\u0016¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bP\u0010\u0005J\u0017\u0010R\u001a\u00020\u00062\u0006\u0010Q\u001a\u00020\u0014H\u0016¢\u0006\u0004\bR\u0010SJ\u000f\u0010T\u001a\u00020\u0006H\u0016¢\u0006\u0004\bT\u0010\u0005J\u000f\u0010U\u001a\u00020\u0006H\u0016¢\u0006\u0004\bU\u0010\u0005J\u000f\u0010V\u001a\u00020\u0006H\u0016¢\u0006\u0004\bV\u0010\u0005J\u000f\u0010W\u001a\u00020\u0006H\u0016¢\u0006\u0004\bW\u0010\u0005J\u000f\u0010X\u001a\u00020\u0006H\u0016¢\u0006\u0004\bX\u0010\u0005J\u000f\u0010Z\u001a\u00020YH\u0016¢\u0006\u0004\bZ\u0010[R\u001b\u0010a\u001a\u00020\\8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`R\u001d\u0010f\u001a\u0004\u0018\u00010b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010^\u001a\u0004\bd\u0010eR\u001d\u0010k\u001a\u0004\u0018\u00010g8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bh\u0010^\u001a\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010r\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0016\u0010t\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010qR\u0016\u0010w\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bx\u0010vR\u0018\u0010}\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010|R\u0016\u0010\u007f\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010qR\u0018\u0010\u0081\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010vR\u0018\u0010\u0083\u0001\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0082\u0001\u0010vR\u001a\u0010\u0085\u0001\u001a\u0004\u0018\u00010z8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010|R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R*\u0010\u0091\u0001\u001a\u00030\u008a\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008b\u0001\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001\"\u0006\b\u008f\u0001\u0010\u0090\u0001¨\u0006\u0093\u0001"}, d2 = {"Lcom/transsion/usercenter/me/MeFragment;", "Lcom/transsion/baseui/fragment/BaseFragment;", "Lfw/k0;", "Ldz/a;", "<init>", "()V", "", "U0", "Lcom/transsion/usercenter/profile/bean/MeItemInfo;", WebConstants.FIELD_ITEM, "d1", "(Lcom/transsion/usercenter/profile/bean/MeItemInfo;)V", "j1", "f1", "p1", "r1", "", "updateToken", "z1", "(I)V", "", "y1", "()Z", "h1", "e1", "l1", "n1", "w1", "v1", "t1", "z0", "()I", "w0", "L0", "Landroid/view/View;", MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW, "rootView", "K0", "(Landroid/view/View;Landroid/view/View;)I", "J0", "tipView", "G0", "(Landroid/view/View;)I", "c1", "b1", "F0", "E0", "B0", "C0", "", "H0", "()Ljava/lang/String;", "y0", "x0", "Landroidx/fragment/app/FragmentActivity;", "g1", "()Landroidx/fragment/app/FragmentActivity;", "P0", "S0", "", "", "historyList", "u1", "(Ljava/util/List;)V", "a1", "Landroid/view/LayoutInflater;", "inflater", "I0", "(Landroid/view/LayoutInflater;)Lfw/k0;", "Landroid/os/Bundle;", "savedInstanceState", "initView", "(Landroid/view/View;Landroid/os/Bundle;)V", "initData", "lazyLoadData", "onResume", "Lcom/transsnet/loginapi/bean/UserInfo;", "user", "onLogin", "(Lcom/transsnet/loginapi/bean/UserInfo;)V", "onLogout", "hidden", "onHiddenChanged", "(Z)V", "logResume", "logPause", "onPause", "onDestroy", "onDestroyView", "Lhj/b;", "newLogViewConfig", "()Lhj/b;", "Lcom/transsion/usercenter/me/MeViewmodel;", "a", "Lkotlin/Lazy;", "D0", "()Lcom/transsion/usercenter/me/MeViewmodel;", "mViewModel", "Lcom/transsnet/loginapi/ILoginApi;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "getMLoginApi", "()Lcom/transsnet/loginapi/ILoginApi;", "mLoginApi", "Lcom/transsion/memberapi/IPremiumApi;", "c", "A0", "()Lcom/transsion/memberapi/IPremiumApi;", "iPremiumApi", "Lcom/transsion/usercenter/me/adapter/o;", "d", "Lcom/transsion/usercenter/me/adapter/o;", "mAdapter", "e", "Z", "needResumeRefreshData", "f", "myActivityTipUpdateScheduled", be.g.f16474b, "I", "myActivityTipRetryCount", "h", "myActivityTipUpdateToken", "Ljava/lang/Runnable;", "i", "Ljava/lang/Runnable;", "initialMyActivityTipCheckRunnable", com.mbridge.msdk.foundation.same.report.j.f35620b, "loginPremiumTipUpdateScheduled", CampaignEx.JSON_KEY_AD_K, "loginPremiumTipRetryCount", "l", "loginPremiumTipUpdateToken", "m", "initialLoginPremiumTipCheckRunnable", "com/transsion/usercenter/me/MeFragment$b", "n", "Lcom/transsion/usercenter/me/MeFragment$b;", "myActivityTipScrollListener", "", "o", "J", "getResumeTimeStamp", "()J", "setResumeTimeStamp", "(J)V", "resumeTimeStamp", TtmlNode.TAG_P, "UserCenter_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class MeFragment extends BaseFragment<k0> implements dz.a {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Lazy mViewModel;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Lazy mLoginApi;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Lazy iPremiumApi;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.transsion.usercenter.me.adapter.o mAdapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean needResumeRefreshData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean myActivityTipUpdateScheduled;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int myActivityTipRetryCount;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int myActivityTipUpdateToken;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Runnable initialMyActivityTipCheckRunnable;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean loginPremiumTipUpdateScheduled;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int loginPremiumTipRetryCount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int loginPremiumTipUpdateToken;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Runnable initialLoginPremiumTipCheckRunnable;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final b myActivityTipScrollListener;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private long resumeTimeStamp;

    /* renamed from: com.transsion.usercenter.me.MeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes6.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MeFragment a() {
            return new MeFragment();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends RecyclerView.r {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            Intrinsics.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i11, i12);
            if (i12 != 0) {
                MeFragment.this.r1();
                MeFragment.this.n1();
            }
        }
    }

    /* loaded from: classes6.dex */
    static final class c implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f57014a;

        c(Function1 function) {
            Intrinsics.h(function, "function");
            this.f57014a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f57014a;
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
            this.f57014a.invoke(obj);
        }
    }

    public MeFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.usercenter.me.MeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.mViewModel = FragmentViewModelLazyKt.a(this, Reflection.b(MeViewmodel.class), new Function0<x0>() { // from class: com.transsion.usercenter.me.MeFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) Function0.this.invoke()).getViewModelStore();
                Intrinsics.g(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.usercenter.me.MeFragment$special$$inlined$viewModels$default$3
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
        this.mLoginApi = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                ILoginApi mLoginApi_delegate$lambda$0;
                mLoginApi_delegate$lambda$0 = MeFragment.mLoginApi_delegate$lambda$0();
                return mLoginApi_delegate$lambda$0;
            }
        });
        this.iPremiumApi = LazyKt.b(new Function0() { // from class: com.transsion.usercenter.me.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                IPremiumApi M0;
                M0 = MeFragment.M0();
                return M0;
            }
        });
        this.myActivityTipScrollListener = new b();
    }

    private final IPremiumApi A0() {
        return (IPremiumApi) this.iPremiumApi.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A1(MeFragment meFragment, int i11) {
        meFragment.z1(i11);
    }

    private final int B0() {
        return (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
    }

    private final int C0() {
        return (int) TypedValue.applyDimension(1, 9.0f, getResources().getDisplayMetrics());
    }

    private final MeViewmodel D0() {
        return (MeViewmodel) this.mViewModel.getValue();
    }

    private final int E0() {
        return (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
    }

    private final int F0() {
        return (int) TypedValue.applyDimension(1, 8.0f, getResources().getDisplayMetrics());
    }

    private final int G0(View tipView) {
        int width;
        if (tipView.getHeight() > 0) {
            return tipView.getHeight();
        }
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (width = (mViewBinding.getRoot().getWidth() - c1(tipView)) - b1(tipView)) <= 0) {
            return 0;
        }
        tipView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        return tipView.getMeasuredHeight();
    }

    private final String H0() {
        String format = new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date());
        Intrinsics.g(format, "format(...)");
        return format;
    }

    private final int J0(View view, View rootView) {
        return K0(view, rootView) + view.getHeight();
    }

    private final int K0(View view, View rootView) {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view.getLocationInWindow(iArr);
        rootView.getLocationInWindow(iArr2);
        return iArr[1] - iArr2[1];
    }

    private final void L0() {
        ConstraintLayout constraintLayout;
        e1();
        this.loginPremiumTipUpdateScheduled = false;
        this.loginPremiumTipRetryCount = 0;
        this.loginPremiumTipUpdateToken++;
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f62863h) == null) {
            return;
        }
        constraintLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IPremiumApi M0() {
        return (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit N0(MeFragment meFragment, List list) {
        ConstraintLayout constraintLayout;
        BubbleFrameLayout bubbleFrameLayout;
        hj.b logViewConfig = meFragment.getLogViewConfig();
        if (logViewConfig != null) {
            logViewConfig.k(true);
        }
        k0 mViewBinding = meFragment.getMViewBinding();
        boolean z10 = (mViewBinding == null || (bubbleFrameLayout = mViewBinding.f62867l) == null || bubbleFrameLayout.getVisibility() == 4) ? false : true;
        k0 mViewBinding2 = meFragment.getMViewBinding();
        boolean z11 = (mViewBinding2 == null || (constraintLayout = mViewBinding2.f62863h) == null || constraintLayout.getVisibility() == 4) ? false : true;
        com.transsion.usercenter.me.adapter.o oVar = meFragment.mAdapter;
        if (oVar != null) {
            oVar.n1(list);
        }
        if (z10) {
            meFragment.p1();
        } else {
            meFragment.j1();
        }
        if (z11) {
            meFragment.l1();
        } else {
            meFragment.h1();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O0(MeFragment meFragment, List list) {
        meFragment.u1(list);
        return Unit.f67184a;
    }

    private final void P0() {
        Function1 function1 = new Function1() { // from class: com.transsion.usercenter.me.h
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit Q0;
                Q0 = MeFragment.Q0(MeFragment.this, (my.e) obj);
                return Q0;
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = my.e.class.getName();
        Intrinsics.g(name, "getName(...)");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(this, name, state, kotlinx.coroutines.y0.c().q(), false, function1);
        Function1 function12 = new Function1() { // from class: com.transsion.usercenter.me.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit R0;
                R0 = MeFragment.R0(MeFragment.this, (my.d) obj);
                return R0;
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = my.d.class.getName();
        Intrinsics.g(name2, "getName(...)");
        flowEventBus2.observeEvent(this, name2, state, kotlinx.coroutines.y0.c().q(), false, function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Q0(MeFragment meFragment, my.e value) {
        Intrinsics.h(value, "value");
        meFragment.D0().y();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit R0(MeFragment meFragment, my.d value) {
        Intrinsics.h(value, "value");
        meFragment.D0().y();
        return Unit.f67184a;
    }

    private final void S0() {
        Function1 function1 = new Function1() { // from class: com.transsion.usercenter.me.g
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T0;
                T0 = MeFragment.T0(MeFragment.this, (KidsAccountManager.a) obj);
                return T0;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = KidsAccountManager.a.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(this, name, Lifecycle.State.CREATED, kotlinx.coroutines.y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T0(MeFragment meFragment, KidsAccountManager.a value) {
        Intrinsics.h(value, "value");
        meFragment.lazyLoadData();
        return Unit.f67184a;
    }

    private final void U0() {
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding != null) {
            ConstraintLayout root = mViewBinding.getRoot();
            Intrinsics.g(root, "getRoot(...)");
            jg.c.e(root);
            AppCompatImageView ivQrCode = mViewBinding.f62858c;
            Intrinsics.g(ivQrCode, "ivQrCode");
            jg.c.c(ivQrCode, 0L, new Function1() { // from class: com.transsion.usercenter.me.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit V0;
                    V0 = MeFragment.V0(MeFragment.this, (View) obj);
                    return V0;
                }
            }, 1, null);
            com.transsion.usercenter.me.adapter.o oVar = new com.transsion.usercenter.me.adapter.o(null, new Function1() { // from class: com.transsion.usercenter.me.n
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit W0;
                    W0 = MeFragment.W0(MeFragment.this, (MeItemInfo) obj);
                    return W0;
                }
            }, new Function1() { // from class: com.transsion.usercenter.me.o
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit X0;
                    X0 = MeFragment.X0(MeFragment.this, (MeItemInfo) obj);
                    return X0;
                }
            }, 1, null);
            this.mAdapter = oVar;
            mViewBinding.f62857b.setAdapter(oVar);
            mViewBinding.f62857b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
            mViewBinding.f62857b.addOnScrollListener(this.myActivityTipScrollListener);
            AppCompatImageView myActivityTipClose = mViewBinding.f62866k;
            Intrinsics.g(myActivityTipClose, "myActivityTipClose");
            jg.c.c(myActivityTipClose, 0L, new Function1() { // from class: com.transsion.usercenter.me.p
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Y0;
                    Y0 = MeFragment.Y0(MeFragment.this, (View) obj);
                    return Y0;
                }
            }, 1, null);
            AppCompatImageView loginPremiumTipClose = mViewBinding.f62862g;
            Intrinsics.g(loginPremiumTipClose, "loginPremiumTipClose");
            jg.c.c(loginPremiumTipClose, 0L, new Function1() { // from class: com.transsion.usercenter.me.q
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit Z0;
                    Z0 = MeFragment.Z0(MeFragment.this, (View) obj);
                    return Z0;
                }
            }, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(MeFragment meFragment, View it) {
        Intrinsics.h(it, "it");
        Navigator.x(TheRouter.c("/profile/qr_code"), meFragment.requireContext(), null, 2, null);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(MeFragment meFragment, MeItemInfo item) {
        Intrinsics.h(item, "item");
        meFragment.d1(item);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit X0(MeFragment meFragment, MeItemInfo item) {
        Intrinsics.h(item, "item");
        meFragment.needResumeRefreshData = true;
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y0(MeFragment meFragment, View it) {
        Intrinsics.h(it, "it");
        meFragment.x0();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Z0(MeFragment meFragment, View it) {
        Intrinsics.h(it, "it");
        meFragment.w0();
        return Unit.f67184a;
    }

    private final void a1() {
        IRewardsCenterApi iRewardsCenterApi = (IRewardsCenterApi) TheRouter.d(IRewardsCenterApi.class, new Object[0]);
        if (iRewardsCenterApi != null) {
            Context applicationContext = requireContext().getApplicationContext();
            Intrinsics.g(applicationContext, "getApplicationContext(...)");
            androidx.view.u viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.g(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            iRewardsCenterApi.c(applicationContext, androidx.view.v.a(viewLifecycleOwner));
        }
    }

    private final int b1(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.getMarginEnd();
        }
        return 0;
    }

    private final int c1(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            return marginLayoutParams.getMarginStart();
        }
        return 0;
    }

    private final void d1(MeItemInfo item) {
        Object data = item.getData();
        IconItemInfo iconItemInfo = data instanceof IconItemInfo ? (IconItemInfo) data : null;
        if (Intrinsics.c(iconItemInfo != null ? iconItemInfo.getDeepLink() : null, "my_activity_type")) {
            x0();
        }
        if (item.getType() == 5 || item.getType() == 1 || item.getType() == 2 || item.getType() == 11) {
            this.needResumeRefreshData = true;
        }
    }

    private final void e1() {
        RecyclerView recyclerView;
        Runnable runnable = this.initialLoginPremiumTipCheckRunnable;
        if (runnable == null) {
            return;
        }
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f62857b) != null) {
            recyclerView.removeCallbacks(runnable);
        }
        this.initialLoginPremiumTipCheckRunnable = null;
    }

    private final void f1() {
        RecyclerView recyclerView;
        Runnable runnable = this.initialMyActivityTipCheckRunnable;
        if (runnable == null) {
            return;
        }
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f62857b) != null) {
            recyclerView.removeCallbacks(runnable);
        }
        this.initialMyActivityTipCheckRunnable = null;
    }

    private final FragmentActivity g1() {
        FragmentActivity activity = getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    private final ILoginApi getMLoginApi() {
        return (ILoginApi) this.mLoginApi.getValue();
    }

    private final void h1() {
        final k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null) {
            return;
        }
        e1();
        this.loginPremiumTipUpdateScheduled = false;
        this.loginPremiumTipRetryCount = 0;
        this.loginPremiumTipUpdateToken++;
        ConstraintLayout loginPremiumTipContainer = mViewBinding.f62863h;
        Intrinsics.g(loginPremiumTipContainer, "loginPremiumTipContainer");
        loginPremiumTipContainer.setVisibility(4);
        if (t1()) {
            final int i11 = this.loginPremiumTipUpdateToken;
            Runnable runnable = new Runnable() { // from class: com.transsion.usercenter.me.f
                @Override // java.lang.Runnable
                public final void run() {
                    MeFragment.i1(MeFragment.this, mViewBinding, i11);
                }
            };
            this.initialLoginPremiumTipCheckRunnable = runnable;
            mViewBinding.f62857b.postDelayed(runnable, 50L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i1(MeFragment meFragment, k0 k0Var, int i11) {
        if (meFragment.g1() != null && Intrinsics.c(meFragment.getMViewBinding(), k0Var) && meFragment.loginPremiumTipUpdateToken == i11) {
            meFragment.initialLoginPremiumTipCheckRunnable = null;
            meFragment.loginPremiumTipUpdateScheduled = true;
            meFragment.loginPremiumTipRetryCount = 0;
            meFragment.w1(i11);
        }
    }

    private final void j1() {
        final k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null) {
            return;
        }
        f1();
        this.myActivityTipUpdateScheduled = false;
        this.myActivityTipRetryCount = 0;
        this.myActivityTipUpdateToken++;
        BubbleFrameLayout myActivityTipContainer = mViewBinding.f62867l;
        Intrinsics.g(myActivityTipContainer, "myActivityTipContainer");
        myActivityTipContainer.setVisibility(4);
        if (com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("key_my_activity_tip_dismissed", false)) {
            return;
        }
        final int i11 = this.myActivityTipUpdateToken;
        Runnable runnable = new Runnable() { // from class: com.transsion.usercenter.me.c
            @Override // java.lang.Runnable
            public final void run() {
                MeFragment.k1(MeFragment.this, mViewBinding, i11);
            }
        };
        this.initialMyActivityTipCheckRunnable = runnable;
        mViewBinding.f62857b.postDelayed(runnable, 50L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k1(MeFragment meFragment, k0 k0Var, int i11) {
        if (meFragment.g1() != null && Intrinsics.c(meFragment.getMViewBinding(), k0Var) && meFragment.myActivityTipUpdateToken == i11) {
            meFragment.initialMyActivityTipCheckRunnable = null;
            meFragment.myActivityTipUpdateScheduled = true;
            meFragment.myActivityTipRetryCount = 0;
            meFragment.z1(i11);
        }
    }

    private final void l1() {
        final k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null) {
            return;
        }
        e1();
        this.loginPremiumTipUpdateScheduled = true;
        this.loginPremiumTipRetryCount = 0;
        this.loginPremiumTipUpdateToken++;
        if (t1()) {
            final int i11 = this.loginPremiumTipUpdateToken;
            mViewBinding.f62857b.post(new Runnable() { // from class: com.transsion.usercenter.me.e
                @Override // java.lang.Runnable
                public final void run() {
                    MeFragment.m1(MeFragment.this, mViewBinding, i11);
                }
            });
        } else {
            this.loginPremiumTipUpdateScheduled = false;
            ConstraintLayout loginPremiumTipContainer = mViewBinding.f62863h;
            Intrinsics.g(loginPremiumTipContainer, "loginPremiumTipContainer");
            loginPremiumTipContainer.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(MeFragment meFragment, k0 k0Var, int i11) {
        if (Intrinsics.c(meFragment.getMViewBinding(), k0Var) && meFragment.loginPremiumTipUpdateToken == i11) {
            meFragment.w1(i11);
        } else {
            meFragment.loginPremiumTipUpdateScheduled = false;
            meFragment.loginPremiumTipRetryCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ILoginApi mLoginApi_delegate$lambda$0() {
        return (ILoginApi) TheRouter.d(ILoginApi.class, new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n1() {
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null) {
            return;
        }
        if (!t1()) {
            ConstraintLayout loginPremiumTipContainer = mViewBinding.f62863h;
            Intrinsics.g(loginPremiumTipContainer, "loginPremiumTipContainer");
            loginPremiumTipContainer.setVisibility(4);
        } else {
            if (this.loginPremiumTipUpdateScheduled) {
                return;
            }
            this.loginPremiumTipUpdateScheduled = true;
            this.loginPremiumTipRetryCount = 0;
            final int i11 = this.loginPremiumTipUpdateToken;
            mViewBinding.f62857b.post(new Runnable() { // from class: com.transsion.usercenter.me.t
                @Override // java.lang.Runnable
                public final void run() {
                    MeFragment.o1(MeFragment.this, i11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o1(MeFragment meFragment, int i11) {
        if (meFragment.loginPremiumTipUpdateToken == i11) {
            meFragment.w1(i11);
        }
    }

    private final void p1() {
        final k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null) {
            return;
        }
        f1();
        this.myActivityTipUpdateScheduled = true;
        this.myActivityTipRetryCount = 0;
        this.myActivityTipUpdateToken++;
        if (!com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("key_my_activity_tip_dismissed", false)) {
            final int i11 = this.myActivityTipUpdateToken;
            mViewBinding.f62857b.post(new Runnable() { // from class: com.transsion.usercenter.me.b
                @Override // java.lang.Runnable
                public final void run() {
                    MeFragment.q1(MeFragment.this, mViewBinding, i11);
                }
            });
        } else {
            this.myActivityTipUpdateScheduled = false;
            BubbleFrameLayout myActivityTipContainer = mViewBinding.f62867l;
            Intrinsics.g(myActivityTipContainer, "myActivityTipContainer");
            myActivityTipContainer.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q1(MeFragment meFragment, k0 k0Var, int i11) {
        if (Intrinsics.c(meFragment.getMViewBinding(), k0Var) && meFragment.myActivityTipUpdateToken == i11) {
            meFragment.z1(i11);
        } else {
            meFragment.myActivityTipUpdateScheduled = false;
            meFragment.myActivityTipRetryCount = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r1() {
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null) {
            return;
        }
        if (com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("key_my_activity_tip_dismissed", false)) {
            BubbleFrameLayout myActivityTipContainer = mViewBinding.f62867l;
            Intrinsics.g(myActivityTipContainer, "myActivityTipContainer");
            myActivityTipContainer.setVisibility(4);
        } else {
            if (this.myActivityTipUpdateScheduled) {
                return;
            }
            this.myActivityTipUpdateScheduled = true;
            this.myActivityTipRetryCount = 0;
            final int i11 = this.myActivityTipUpdateToken;
            mViewBinding.f62857b.post(new Runnable() { // from class: com.transsion.usercenter.me.d
                @Override // java.lang.Runnable
                public final void run() {
                    MeFragment.s1(MeFragment.this, i11);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s1(MeFragment meFragment, int i11) {
        if (meFragment.myActivityTipUpdateToken == i11) {
            meFragment.z1(i11);
        }
    }

    private final boolean t1() {
        ILoginApi mLoginApi = getMLoginApi();
        if (mLoginApi == null || mLoginApi.a() || Intrinsics.c(com.transsion.baselib.report.launch.b.f43424a.b().getString("key_login_premium_tip_close_date", ""), H0())) {
            return false;
        }
        IPremiumApi A0 = A0();
        boolean u11 = A0 != null ? A0.u() : false;
        IPremiumApi A02 = A0();
        return !mLoginApi.a() && (u11 || (A02 != null ? A02.k() : false));
    }

    private final void u1(List historyList) {
        com.transsion.usercenter.me.adapter.o oVar = this.mAdapter;
        if (oVar == null) {
            return;
        }
        int i11 = 0;
        for (Object obj : oVar.getData()) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt.u();
            }
            MeItemInfo meItemInfo = (MeItemInfo) obj;
            if (meItemInfo.getType() == 4) {
                Object data = meItemInfo.getData();
                MeHistoryInfo meHistoryInfo = data instanceof MeHistoryInfo ? (MeHistoryInfo) data : null;
                if (meHistoryInfo != null) {
                    meHistoryInfo.setList(historyList);
                } else {
                    meItemInfo.setData(new MeHistoryInfo(historyList));
                }
                oVar.notifyItemChanged(i11);
                return;
            }
            i11 = i12;
        }
    }

    private final boolean v1() {
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || g1() == null) {
            return false;
        }
        if (!t1()) {
            ConstraintLayout loginPremiumTipContainer = mViewBinding.f62863h;
            Intrinsics.g(loginPremiumTipContainer, "loginPremiumTipContainer");
            loginPremiumTipContainer.setVisibility(4);
            return false;
        }
        int z02 = z0();
        if (z02 == -1) {
            ConstraintLayout loginPremiumTipContainer2 = mViewBinding.f62863h;
            Intrinsics.g(loginPremiumTipContainer2, "loginPremiumTipContainer");
            loginPremiumTipContainer2.setVisibility(4);
            return false;
        }
        RecyclerView.m layoutManager = mViewBinding.f62857b.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return false;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
            return true;
        }
        if (z02 < findFirstVisibleItemPosition || z02 > findLastVisibleItemPosition) {
            ConstraintLayout loginPremiumTipContainer3 = mViewBinding.f62863h;
            Intrinsics.g(loginPremiumTipContainer3, "loginPremiumTipContainer");
            loginPremiumTipContainer3.setVisibility(4);
            return false;
        }
        if (linearLayoutManager.findViewByPosition(z02) == null) {
            return true;
        }
        ConstraintLayout loginPremiumTipContainer4 = mViewBinding.f62863h;
        Intrinsics.g(loginPremiumTipContainer4, "loginPremiumTipContainer");
        if (G0(loginPremiumTipContainer4) <= 0) {
            return true;
        }
        Intrinsics.g(mViewBinding.getRoot(), "getRoot(...)");
        loginPremiumTipContainer4.setY((J0(r2, r0) + B0()) - C0());
        loginPremiumTipContainer4.setVisibility(0);
        return false;
    }

    private final void w0() {
        com.transsion.baselib.report.launch.b.f43424a.b().putString("key_login_premium_tip_close_date", H0());
        L0();
    }

    private final void w1(final int updateToken) {
        int i11;
        RecyclerView recyclerView;
        if (this.loginPremiumTipUpdateToken != updateToken) {
            this.loginPremiumTipUpdateScheduled = false;
            this.loginPremiumTipRetryCount = 0;
            return;
        }
        if (!v1() || (i11 = this.loginPremiumTipRetryCount) >= 3) {
            this.loginPremiumTipUpdateScheduled = false;
            this.loginPremiumTipRetryCount = 0;
            return;
        }
        this.loginPremiumTipRetryCount = i11 + 1;
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f62857b) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.usercenter.me.j
            @Override // java.lang.Runnable
            public final void run() {
                MeFragment.x1(MeFragment.this, updateToken);
            }
        });
    }

    private final void x0() {
        BubbleFrameLayout bubbleFrameLayout;
        com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("key_my_activity_tip_dismissed", true);
        f1();
        this.myActivityTipUpdateScheduled = false;
        this.myActivityTipRetryCount = 0;
        this.myActivityTipUpdateToken++;
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (bubbleFrameLayout = mViewBinding.f62867l) == null) {
            return;
        }
        bubbleFrameLayout.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x1(MeFragment meFragment, int i11) {
        meFragment.w1(i11);
    }

    private final int y0() {
        com.transsion.usercenter.me.adapter.o oVar = this.mAdapter;
        if (oVar == null) {
            return -1;
        }
        Iterator<Object> it = oVar.getData().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            Object data = ((MeItemInfo) it.next()).getData();
            IconItemInfo iconItemInfo = data instanceof IconItemInfo ? (IconItemInfo) data : null;
            if (Intrinsics.c(iconItemInfo != null ? iconItemInfo.getDeepLink() : null, "my_activity_type")) {
                break;
            }
            i11++;
        }
        if (i11 >= 0) {
            return i11;
        }
        return -1;
    }

    private final boolean y1() {
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || g1() == null) {
            return false;
        }
        if (com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("key_my_activity_tip_dismissed", false)) {
            BubbleFrameLayout myActivityTipContainer = mViewBinding.f62867l;
            Intrinsics.g(myActivityTipContainer, "myActivityTipContainer");
            myActivityTipContainer.setVisibility(4);
            return false;
        }
        int y02 = y0();
        if (y02 == -1) {
            BubbleFrameLayout myActivityTipContainer2 = mViewBinding.f62867l;
            Intrinsics.g(myActivityTipContainer2, "myActivityTipContainer");
            myActivityTipContainer2.setVisibility(4);
            return false;
        }
        RecyclerView.m layoutManager = mViewBinding.f62857b.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null) {
            return false;
        }
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition == -1 || findLastVisibleItemPosition == -1) {
            return true;
        }
        if (y02 < findFirstVisibleItemPosition || y02 > findLastVisibleItemPosition) {
            BubbleFrameLayout myActivityTipContainer3 = mViewBinding.f62867l;
            Intrinsics.g(myActivityTipContainer3, "myActivityTipContainer");
            myActivityTipContainer3.setVisibility(4);
            return false;
        }
        if (linearLayoutManager.findViewByPosition(y02) == null) {
            return true;
        }
        BubbleFrameLayout myActivityTipContainer4 = mViewBinding.f62867l;
        Intrinsics.g(myActivityTipContainer4, "myActivityTipContainer");
        if (G0(myActivityTipContainer4) <= 0) {
            return true;
        }
        Intrinsics.g(mViewBinding.getRoot(), "getRoot(...)");
        myActivityTipContainer4.setY(((K0(r2, r0) - r4) - E0()) + F0());
        myActivityTipContainer4.setVisibility(0);
        return false;
    }

    private final int z0() {
        com.transsion.usercenter.me.adapter.o oVar = this.mAdapter;
        if (oVar == null) {
            return -1;
        }
        Iterator<Object> it = oVar.getData().iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            }
            if (((MeItemInfo) it.next()).getType() == 1) {
                break;
            }
            i11++;
        }
        if (i11 >= 0) {
            return i11;
        }
        return -1;
    }

    private final void z1(final int updateToken) {
        int i11;
        RecyclerView recyclerView;
        if (this.myActivityTipUpdateToken != updateToken) {
            this.myActivityTipUpdateScheduled = false;
            this.myActivityTipRetryCount = 0;
            return;
        }
        if (!y1() || (i11 = this.myActivityTipRetryCount) >= 3) {
            this.myActivityTipUpdateScheduled = false;
            this.myActivityTipRetryCount = 0;
            return;
        }
        this.myActivityTipRetryCount = i11 + 1;
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f62857b) == null) {
            return;
        }
        recyclerView.post(new Runnable() { // from class: com.transsion.usercenter.me.k
            @Override // java.lang.Runnable
            public final void run() {
                MeFragment.A1(MeFragment.this, updateToken);
            }
        });
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* renamed from: I0, reason: merged with bridge method [inline-methods] */
    public k0 getViewBinding(LayoutInflater inflater) {
        Intrinsics.h(inflater, "inflater");
        k0 c11 = k0.c(inflater);
        Intrinsics.g(c11, "inflate(...)");
        return c11;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initData(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        super.initData(view, savedInstanceState);
        D0().I().j(this, new c(new Function1() { // from class: com.transsion.usercenter.me.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit N0;
                N0 = MeFragment.N0(MeFragment.this, (List) obj);
                return N0;
            }
        }));
        D0().C().j(this, new c(new Function1() { // from class: com.transsion.usercenter.me.l
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit O0;
                O0 = MeFragment.O0(MeFragment.this, (List) obj);
                return O0;
            }
        }));
        P0();
        S0();
        ILoginApi mLoginApi = getMLoginApi();
        if (mLoginApi != null) {
            mLoginApi.g(this);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle savedInstanceState) {
        Intrinsics.h(view, "view");
        U0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        D0().z();
        D0().A();
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            iMemberApi.p();
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logPause() {
        super.logPause();
        if (this.resumeTimeStamp != 0) {
            com.transsion.baselib.report.e.f43398a.n("profiledetail", Long.valueOf(SystemClock.elapsedRealtime() - this.resumeTimeStamp), getContext());
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void logResume() {
        super.logResume();
        this.resumeTimeStamp = SystemClock.elapsedRealtime();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public hj.b newLogViewConfig() {
        UserInfo i11;
        String str = null;
        hj.b bVar = new hj.b("profiledetail", false, 2, null);
        bVar.g().put("user_status", "me");
        HashMap g11 = bVar.g();
        ILoginApi mLoginApi = getMLoginApi();
        if (mLoginApi != null && (i11 = mLoginApi.i()) != null) {
            str = i11.getUserId();
        }
        g11.put("user_id", String.valueOf(str));
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ILoginApi mLoginApi = getMLoginApi();
        if (mLoginApi != null) {
            mLoginApi.p(this);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        RecyclerView recyclerView;
        f1();
        L0();
        this.myActivityTipUpdateToken++;
        this.myActivityTipUpdateScheduled = false;
        this.myActivityTipRetryCount = 0;
        k0 mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f62857b) != null) {
            recyclerView.removeOnScrollListener(this.myActivityTipScrollListener);
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (isResumed()) {
            if (hidden) {
                logPause();
            } else {
                lazyLoadData();
                logResume();
            }
        }
        com.transsion.baseui.activity.k.h(null, this, hidden, null, 9, null);
    }

    @Override // dz.a
    public void onLogin(UserInfo user) {
        Intrinsics.h(user, "user");
        a.C0761a.a(this, user);
        L0();
        lazyLoadData();
    }

    @Override // dz.a
    public void onLogout() {
        a.C0761a.b(this);
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        com.transsion.baseui.activity.k.l(null, this, null, 5, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.needResumeRefreshData) {
            this.needResumeRefreshData = false;
            lazyLoadData();
        }
        com.transsion.baseui.activity.k.p(null, this, "visible=" + isVisible(), 1, null);
        a1();
    }

    @Override // dz.a
    public void onUpdateUserInfo(UserInfo userInfo) {
        a.C0761a.c(this, userInfo);
    }
}
