package com.transsion.home.fragment.home;

import android.content.Context;
import android.content.Intent;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.ViewSwitcher;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.view.Lifecycle;
import com.tn.lib.view.GradientLinePagerIndicator;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.widget.CustomPagerTitleView;
import com.transsion.home.R$layout;
import com.transsion.home.bean.AppTab;
import com.transsion.home.bean.HomeTabItem;
import com.transsion.home.bean.HotSearchKeyWord;
import com.transsion.home.bean.HotSubjectEntity;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p004enum.HomeTabId;
import com.transsion.home.view.CustomTabAdView;
import com.transsion.home.viewmodel.preload.PreloadTrendingData;
import com.transsion.usercenterapi.UpdateResultEvent;
import com.transsion.version.update.UpdateManager;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;
import lg.a;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

/* loaded from: classes5.dex */
public final class HomeSearchViewManager {

    /* renamed from: a, reason: collision with root package name */
    private final gl.r f45186a;

    /* renamed from: b, reason: collision with root package name */
    private final HomeFragment f45187b;

    /* renamed from: c, reason: collision with root package name */
    private t f45188c;

    /* renamed from: d, reason: collision with root package name */
    private Context f45189d;

    /* renamed from: e, reason: collision with root package name */
    private final ArrayList f45190e;

    /* renamed from: f, reason: collision with root package name */
    private int f45191f;

    /* renamed from: g, reason: collision with root package name */
    private String f45192g;

    /* renamed from: h, reason: collision with root package name */
    private CommonNavigator f45193h;

    /* renamed from: i, reason: collision with root package name */
    private a f45194i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f45195j;

    /* renamed from: k, reason: collision with root package name */
    private ConstraintLayout.b f45196k;

    /* renamed from: l, reason: collision with root package name */
    private n0 f45197l;

    /* renamed from: m, reason: collision with root package name */
    private final Handler f45198m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class a extends j00.a {

        /* renamed from: b, reason: collision with root package name */
        private AppTab f45199b;

        /* renamed from: com.transsion.home.fragment.home.HomeSearchViewManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0627a extends com.transsion.baseui.util.f {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ HomeSearchViewManager f45201e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f45202f;

            C0627a(HomeSearchViewManager homeSearchViewManager, int i11) {
                this.f45201e = homeSearchViewManager;
                this.f45202f = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                this.f45201e.f45186a.f63956s.setCurrentItem(this.f45202f, false);
                this.f45201e.f45186a.f63948k.onPageScrolled(this.f45202f, 0.0f, 0);
            }
        }

        /* loaded from: classes5.dex */
        public static final class b extends com.transsion.baseui.util.f {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ HomeSearchViewManager f45203e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f45204f;

            b(HomeSearchViewManager homeSearchViewManager, int i11) {
                this.f45203e = homeSearchViewManager;
                this.f45204f = i11;
            }

            @Override // com.transsion.baseui.util.f
            public void c(View view) {
            }

            @Override // com.transsion.baseui.util.f
            public void d(View view) {
                this.f45203e.f45186a.f63956s.setCurrentItem(this.f45204f, false);
                this.f45203e.f45186a.f63948k.onPageScrolled(this.f45204f, 0.0f, 0);
            }
        }

        public a(AppTab appTab) {
            this.f45199b = appTab;
        }

        @Override // j00.a
        public int a() {
            List<HomeTabItem> homeTabs;
            AppTab appTab = this.f45199b;
            if (appTab == null || (homeTabs = appTab.getHomeTabs()) == null) {
                return 1;
            }
            return homeTabs.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            Context context2 = HomeSearchViewManager.this.f45189d;
            if (context2 == null) {
                Intrinsics.z("context");
                context2 = null;
            }
            GradientLinePagerIndicator gradientLinePagerIndicator = new GradientLinePagerIndicator(context2);
            gradientLinePagerIndicator.setMode(2);
            gradientLinePagerIndicator.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            gradientLinePagerIndicator.setLineWidth(com.blankj.utilcode.util.i.e(24.0f));
            gradientLinePagerIndicator.setRoundRadius(com.blankj.utilcode.util.i.e(1.5f));
            gradientLinePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            gradientLinePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            int color = androidx.core.content.b.getColor(context, R$color.transparent);
            gradientLinePagerIndicator.setColors(color, color, color);
            return gradientLinePagerIndicator;
        }

        @Override // j00.a
        public j00.d c(Context context, int i11) {
            List<HomeTabItem> homeTabs;
            HomeTabItem homeTabItem;
            List<HomeTabItem> homeTabs2;
            List<HomeTabItem> homeTabs3;
            HomeTabItem homeTabItem2;
            AppTab appTab = this.f45199b;
            String str = null;
            r0 = null;
            HomeTabItem homeTabItem3 = null;
            str = null;
            str = null;
            if (((appTab == null || (homeTabs3 = appTab.getHomeTabs()) == null || (homeTabItem2 = homeTabs3.get(i11)) == null) ? null : homeTabItem2.getNameImage()) != null) {
                Context context2 = HomeSearchViewManager.this.f45189d;
                if (context2 == null) {
                    Intrinsics.z("context");
                    context2 = null;
                }
                CustomTabAdView customTabAdView = new CustomTabAdView(context2);
                customTabAdView.setOnClickListener(new C0627a(HomeSearchViewManager.this, i11));
                AppTab appTab2 = this.f45199b;
                if (appTab2 != null && (homeTabs2 = appTab2.getHomeTabs()) != null) {
                    homeTabItem3 = homeTabs2.get(i11);
                }
                customTabAdView.showData(homeTabItem3);
                return customTabAdView;
            }
            int a11 = com.blankj.utilcode.util.a0.a(10.0f);
            Context context3 = HomeSearchViewManager.this.f45189d;
            if (context3 == null) {
                Intrinsics.z("context");
                context3 = null;
            }
            CustomPagerTitleView customPagerTitleView = new CustomPagerTitleView(context3, 17, a11);
            HomeSearchViewManager homeSearchViewManager = HomeSearchViewManager.this;
            AppTab appTab3 = this.f45199b;
            if (appTab3 != null && (homeTabs = appTab3.getHomeTabs()) != null && (homeTabItem = homeTabs.get(i11)) != null) {
                str = homeTabItem.getName();
            }
            customPagerTitleView.setText(str);
            customPagerTitleView.setTextSize(16.0f);
            customPagerTitleView.setOnClickListener(new b(homeSearchViewManager, i11));
            return customPagerTitleView;
        }

        public final void h(AppTab appTab) {
            this.f45199b = appTab;
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class b implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f45205a;

        b(Function1 function) {
            Intrinsics.h(function, "function");
            this.f45205a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f45205a;
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
            this.f45205a.invoke(obj);
        }
    }

    public HomeSearchViewManager(gl.r mViewBinding, HomeFragment mFragment) {
        Intrinsics.h(mViewBinding, "mViewBinding");
        Intrinsics.h(mFragment, "mFragment");
        this.f45186a = mViewBinding;
        this.f45187b = mFragment;
        this.f45190e = new ArrayList();
        this.f45197l = o0.a(y0.b());
        this.f45198m = new Handler(Looper.getMainLooper(), new Handler.Callback() { // from class: com.transsion.home.fragment.home.w
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean H;
                H = HomeSearchViewManager.H(HomeSearchViewManager.this, message);
                return H;
            }
        });
    }

    private final void A(List list) {
        this.f45186a.f63953p.setTextWithString("");
        this.f45190e.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            HotSearchKeyWord hotSearchKeyWord = (HotSearchKeyWord) it.next();
            ArrayList arrayList = this.f45190e;
            String title = hotSearchKeyWord.getTitle();
            if (title == null) {
                title = "";
            }
            arrayList.add(title);
        }
        TextSwitcher textSwitcher = this.f45186a.f63950m;
        if (textSwitcher.getChildCount() == 0) {
            textSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.transsion.home.fragment.home.d0
                @Override // android.widget.ViewSwitcher.ViewFactory
                public final View makeView() {
                    View B;
                    B = HomeSearchViewManager.B(HomeSearchViewManager.this);
                    return B;
                }
            });
        }
        int i11 = this.f45191f;
        if (i11 >= 0 && i11 < this.f45190e.size()) {
            String str = (String) this.f45190e.get(this.f45191f);
            this.f45192g = str;
            textSwitcher.setText(str);
        }
        textSwitcher.setInAnimation(q());
        textSwitcher.setOutAnimation(J());
        N(this, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View B(HomeSearchViewManager homeSearchViewManager) {
        return LayoutInflater.from(homeSearchViewManager.f45187b.requireContext()).inflate(R$layout.view_text, (ViewGroup) null);
    }

    private final void E(boolean z10) {
        String str;
        com.transsion.home.view.g.f45838a.b(false);
        yj.b bVar = (yj.b) yj.a.f79145a.a(yj.b.class);
        if (z10) {
            if (bVar != null) {
                String str2 = this.f45192g;
                String str3 = str2 == null ? "" : str2;
                str = str2 != null ? str2 : "";
                ArrayList arrayList = this.f45190e;
                Context requireContext = this.f45187b.requireContext();
                Intrinsics.g(requireContext, "requireContext(...)");
                bVar.a(str3, str, arrayList, requireContext);
            }
        } else if (bVar != null) {
            String str4 = this.f45192g;
            str = str4 != null ? str4 : "";
            ArrayList arrayList2 = this.f45190e;
            Context requireContext2 = this.f45187b.requireContext();
            Intrinsics.g(requireContext2, "requireContext(...)");
            bVar.b(str, arrayList2, requireContext2);
        }
        K(z10);
    }

    static /* synthetic */ void F(HomeSearchViewManager homeSearchViewManager, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        homeSearchViewManager.E(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean H(HomeSearchViewManager homeSearchViewManager, Message it) {
        String str;
        Intrinsics.h(it, "it");
        if (it.what == 100) {
            homeSearchViewManager.f45191f++;
            if (homeSearchViewManager.f45190e.isEmpty()) {
                str = "";
            } else {
                ArrayList arrayList = homeSearchViewManager.f45190e;
                str = (String) arrayList.get(homeSearchViewManager.f45191f % arrayList.size());
            }
            homeSearchViewManager.f45192g = str;
            homeSearchViewManager.f45186a.f63950m.setText(str);
            N(homeSearchViewManager, false, 1, null);
        }
        return true;
    }

    private final AnimationSet J() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private final void K(boolean z10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("module_name", z10 ? "search_button" : "search");
        String str = this.f45192g;
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("hot_search_word", str);
        com.transsion.baselib.helper.a.f43316a.i(SubTabFragment.INSTANCE.a(HomeTabId.INSTANCE.g()), linkedHashMap);
    }

    public static /* synthetic */ void N(HomeSearchViewManager homeSearchViewManager, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        homeSearchViewManager.M(z10);
    }

    private final void m(boolean z10) {
        LinearLayout linearLayout;
        CommonNavigator commonNavigator = this.f45193h;
        if (commonNavigator != null) {
            int color = androidx.core.content.b.getColor(commonNavigator.getContext(), R$color.common_white);
            int color2 = androidx.core.content.b.getColor(commonNavigator.getContext(), R$color.transparent);
            LinearLayout linearLayout2 = (LinearLayout) commonNavigator.findViewById(R$id.title_container);
            int childCount = linearLayout2.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = linearLayout2.getChildAt(i11);
                if (childAt instanceof CustomPagerTitleView) {
                    CustomPagerTitleView customPagerTitleView = (CustomPagerTitleView) childAt;
                    customPagerTitleView.setNormalColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R$color.white_60));
                    customPagerTitleView.setSelectedColor(color);
                    if (i11 == this.f45187b.getMSelectTabIndex()) {
                        customPagerTitleView.setTextColor(color);
                    } else {
                        customPagerTitleView.setTextColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R$color.white_60));
                    }
                    ViewGroup.LayoutParams layoutParams = customPagerTitleView.getLayoutParams();
                    Intrinsics.f(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    layoutParams2.width = -2;
                    layoutParams2.height = -1;
                    customPagerTitleView.setLayoutParams(layoutParams2);
                } else if (childAt instanceof CustomTabAdView) {
                    CustomTabAdView customTabAdView = (CustomTabAdView) childAt;
                    customTabAdView.changeTextColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R$color.white_60), androidx.core.content.b.getColor(linearLayout2.getContext(), R$color.common_white));
                    if (i11 == this.f45187b.getMSelectTabIndex()) {
                        customTabAdView.setTextColor(color);
                    } else {
                        customTabAdView.setTextColor(androidx.core.content.b.getColor(linearLayout2.getContext(), R$color.white_60));
                    }
                }
            }
            CommonNavigator commonNavigator2 = this.f45193h;
            if (commonNavigator2 == null || (linearLayout = (LinearLayout) commonNavigator2.findViewById(R$id.indicator_container)) == null) {
                return;
            }
            int childCount2 = linearLayout.getChildCount();
            for (int i12 = 0; i12 < childCount2; i12++) {
                View childAt2 = linearLayout.getChildAt(i12);
                if (childAt2 instanceof GradientLinePagerIndicator) {
                    ((GradientLinePagerIndicator) childAt2).setColors(color2, color2, color2);
                }
            }
        }
    }

    private final void o() {
        if (!UpdateManager.f57641f.a().g()) {
            this.f45186a.f63946i.setVisibility(8);
        } else {
            this.f45186a.f63946i.setVisibility(0);
            this.f45186a.f63946i.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    HomeSearchViewManager.p(HomeSearchViewManager.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(HomeSearchViewManager homeSearchViewManager, View view) {
        kotlinx.coroutines.k.d(homeSearchViewManager.f45197l, null, null, new HomeSearchViewManager$handleUpdateIcon$1$1(homeSearchViewManager, null), 3, null);
    }

    private final AnimationSet q() {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(1000L);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(1000L);
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.addAnimation(alphaAnimation);
        return animationSet;
    }

    private final void r() {
        Intent intent;
        this.f45186a.f63953p.setLocalChangeListener(new Function0() { // from class: com.transsion.home.fragment.home.e0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit s11;
                s11 = HomeSearchViewManager.s();
                return s11;
            }
        });
        FragmentActivity activity = this.f45187b.getActivity();
        boolean z10 = false;
        if (activity != null && (intent = activity.getIntent()) != null) {
            z10 = intent.getBooleanExtra("extra_language_activity_restart", false);
        }
        if (z10) {
            PreloadTrendingData.f45940n.a().z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s() {
        PreloadTrendingData.f45940n.a().z();
        return Unit.f67184a;
    }

    private final void t() {
        this.f45186a.f63955r.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.u(HomeSearchViewManager.this, view);
            }
        });
        this.f45186a.f63954q.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.v(HomeSearchViewManager.this, view);
            }
        });
        this.f45186a.f63944g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.home.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HomeSearchViewManager.w(view);
            }
        });
        r();
        PreloadTrendingData.f45940n.a().H().j(this.f45187b, new b(new Function1() { // from class: com.transsion.home.fragment.home.a0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit x10;
                x10 = HomeSearchViewManager.x(HomeSearchViewManager.this, (HotSubjectEntity) obj);
                return x10;
            }
        }));
        HomeFragment homeFragment = this.f45187b;
        Function1 function1 = new Function1() { // from class: com.transsion.home.fragment.home.b0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y10;
                y10 = HomeSearchViewManager.y(HomeSearchViewManager.this, (UpdateResultEvent) obj);
                return y10;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = UpdateResultEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(homeFragment, name, Lifecycle.State.CREATED, y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(HomeSearchViewManager homeSearchViewManager, View view) {
        F(homeSearchViewManager, false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(HomeSearchViewManager homeSearchViewManager, View view) {
        homeSearchViewManager.E(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit x(HomeSearchViewManager homeSearchViewManager, HotSubjectEntity hotSubjectEntity) {
        List<HotSearchKeyWord> everyoneSearch;
        if (hotSubjectEntity != null && (everyoneSearch = hotSubjectEntity.getEveryoneSearch()) != null) {
            homeSearchViewManager.A(everyoneSearch);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(HomeSearchViewManager homeSearchViewManager, UpdateResultEvent it) {
        Intrinsics.h(it, "it");
        homeSearchViewManager.o();
        return Unit.f67184a;
    }

    private final void z(AppTab appTab) {
        Context context = this.f45189d;
        if (context == null) {
            Intrinsics.z("context");
            context = null;
        }
        this.f45193h = new CommonNavigator(context);
        a aVar = new a(appTab);
        this.f45194i = aVar;
        CommonNavigator commonNavigator = this.f45193h;
        if (commonNavigator != null) {
            commonNavigator.setAdapter(aVar);
        }
        this.f45186a.f63948k.setNavigator(this.f45193h);
    }

    public final void C(AppTab appTab) {
        Object m1185constructorimpl;
        this.f45189d = this.f45187b.requireContext();
        ViewGroup.LayoutParams layoutParams = this.f45186a.f63955r.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = com.blankj.utilcode.util.a0.a(4.0f) + com.blankj.utilcode.util.d.c();
        this.f45186a.f63955r.setLayoutParams(bVar);
        this.f45196k = bVar;
        o();
        z(appTab);
        t();
        try {
            Result.Companion companion = Result.INSTANCE;
            t tVar = new t();
            this.f45188c = tVar;
            FrameLayout flGameCenter = this.f45186a.f63940c;
            Intrinsics.g(flGameCenter, "flGameCenter");
            FrameLayout flPhoneCenter = this.f45186a.f63941d;
            Intrinsics.g(flPhoneCenter, "flPhoneCenter");
            AppCompatImageView ivMbLogo = this.f45186a.f63944g;
            Intrinsics.g(ivMbLogo, "ivMbLogo");
            tVar.b(flGameCenter, flPhoneCenter, ivMbLogo, androidx.view.v.a(this.f45187b));
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            a.C0856a.l(lg.a.f68962a, "zxb_icon", "HomeSearchViewManager --> initGameCenter() --> it --> " + m1188exceptionOrNullimpl, false, 4, null);
        }
        AppCompatImageView ivNovelEnter = this.f45186a.f63945h;
        Intrinsics.g(ivNovelEnter, "ivNovelEnter");
        new v(ivNovelEnter);
    }

    public final boolean D() {
        return this.f45195j;
    }

    public final void G() {
        t tVar = this.f45188c;
        if (tVar != null) {
            tVar.c();
        }
    }

    public final void I(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        if (this.f45190e.isEmpty()) {
            PreloadTrendingData.f45940n.a().G();
        }
    }

    public final void L() {
        this.f45198m.removeCallbacksAndMessages(null);
    }

    public final void M(boolean z10) {
        if (this.f45190e.size() <= 0) {
            return;
        }
        if (this.f45191f >= this.f45190e.size()) {
            this.f45191f %= this.f45190e.size();
        }
        if (z10) {
            L();
            this.f45198m.sendEmptyMessageDelayed(100, 500L);
        } else {
            L();
            this.f45198m.sendEmptyMessageDelayed(100, 5000L);
        }
    }

    public final void O(AppTab appTab) {
        Intrinsics.h(appTab, "appTab");
        a aVar = this.f45194i;
        if (aVar != null) {
            aVar.h(appTab);
        }
        if (this.f45195j) {
            m(true);
        }
    }

    public final void l(boolean z10) {
        this.f45195j = z10;
        m(z10);
    }

    public final void n() {
        t tVar = this.f45188c;
        if (tVar != null) {
            tVar.a();
        }
    }
}
