package com.transsion.ugcvideodetail.hepler;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.appbar.AppBarLayout;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.play.detail.widget.PlayDetailResTabTitleView;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import com.transsion.ugcvideodetail.api.bean.UGCVideoInteractiveInfo;
import com.transsion.ugcvideodetail.hepler.e;
import com.transsion.ugcvideodetail.viewmodel.UGCVideoDetailViewModel;
import com.transsion.user.action.sync.event.CommentEvent;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.y0;
import lg.a;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: r, reason: collision with root package name */
    public static final a f56455r = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f56456a;

    /* renamed from: b, reason: collision with root package name */
    private final UGCVideoDetailViewModel f56457b;

    /* renamed from: c, reason: collision with root package name */
    private final UGCVideo f56458c;

    /* renamed from: d, reason: collision with root package name */
    private final DownloadBean f56459d;

    /* renamed from: e, reason: collision with root package name */
    private final MagicIndicator f56460e;

    /* renamed from: f, reason: collision with root package name */
    private final ViewPager2 f56461f;

    /* renamed from: g, reason: collision with root package name */
    private final String f56462g;

    /* renamed from: h, reason: collision with root package name */
    private final UGCVideoPlayFrom f56463h;

    /* renamed from: i, reason: collision with root package name */
    private final String f56464i;

    /* renamed from: j, reason: collision with root package name */
    private final int f56465j;

    /* renamed from: k, reason: collision with root package name */
    private final AppBarLayout f56466k;

    /* renamed from: l, reason: collision with root package name */
    private ORCommonNavigator f56467l;

    /* renamed from: m, reason: collision with root package name */
    private b f56468m;

    /* renamed from: n, reason: collision with root package name */
    private FragmentStateAdapter f56469n;

    /* renamed from: o, reason: collision with root package name */
    private int f56470o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f56471p;

    /* renamed from: q, reason: collision with root package name */
    private final List f56472q;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public final class b extends ik.a {

        /* renamed from: b, reason: collision with root package name */
        private final ViewPager2 f56473b;

        /* renamed from: c, reason: collision with root package name */
        private final List f56474c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ e f56475d;

        public b(e eVar, ViewPager2 viewPager2, List tabList) {
            Intrinsics.h(tabList, "tabList");
            this.f56475d = eVar;
            this.f56473b = viewPager2;
            this.f56474c = tabList;
        }

        private final LinearLayout.LayoutParams j() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMarginStart(dk.a.b(6));
            layoutParams.setMarginEnd(dk.a.b(2));
            return layoutParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(int i11, e eVar, PlayDetailResTabTitleView playDetailResTabTitleView, b bVar, View view) {
            if (i11 == 1 && eVar.f56471p) {
                eVar.f56471p = false;
                playDetailResTabTitleView.setDotVisibility(false);
                com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("key_subj_comment_dot", false);
            }
            ViewPager2 viewPager2 = bVar.f56473b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i11, true);
            }
        }

        @Override // j00.a
        public int a() {
            return this.f56475d.f56463h == UGCVideoPlayFrom.LOCAL_VIDEO ? this.f56475d.f56472q.size() - 1 : this.f56475d.f56472q.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            if (this.f56475d.f56463h == UGCVideoPlayFrom.LOCAL_VIDEO) {
                LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
                linePagerIndicator.setColors(0);
                return linePagerIndicator;
            }
            LinePagerIndicator linePagerIndicator2 = new LinePagerIndicator(context);
            linePagerIndicator2.setMode(1);
            linePagerIndicator2.setLineHeight(com.blankj.utilcode.util.i.e(3.0f));
            linePagerIndicator2.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator2.setEndInterpolator(new DecelerateInterpolator(2.0f));
            linePagerIndicator2.setColors(-1, -1, -1);
            return linePagerIndicator2;
        }

        @Override // j00.a
        public j00.d c(Context context, final int i11) {
            UGCVideoInteractiveInfo interactiveInfo;
            String commentNum;
            Integer v11;
            Intrinsics.h(context, "context");
            final PlayDetailResTabTitleView playDetailResTabTitleView = new PlayDetailResTabTitleView(context);
            final e eVar = this.f56475d;
            if (i11 == 1) {
                playDetailResTabTitleView.setDotVisibility(eVar.f56471p);
                UGCVideo uGCVideo = eVar.f56458c;
                int intValue = (uGCVideo == null || (interactiveInfo = uGCVideo.getInteractiveInfo()) == null || (commentNum = interactiveInfo.getCommentNum()) == null || (v11 = StringsKt.v(commentNum)) == null) ? 0 : v11.intValue();
                String str = "";
                String valueOf = intValue > 99 ? "99+" : intValue <= 0 ? "" : String.valueOf(intValue);
                Object obj = this.f56474c.get(i11);
                if (valueOf.length() != 0) {
                    str = "(" + valueOf + ")";
                }
                playDetailResTabTitleView.setTitle(obj + str);
            } else {
                playDetailResTabTitleView.setTitle((String) this.f56474c.get(i11));
            }
            playDetailResTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.ugcvideodetail.hepler.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e.b.k(i11, eVar, playDetailResTabTitleView, this, view);
                }
            });
            return playDetailResTabTitleView;
        }

        @Override // ik.a
        public LinearLayout.LayoutParams h(Context context, int i11) {
            Intrinsics.h(context, "context");
            return j();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends ViewPager2.OnPageChangeCallback {
        c() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i11) {
            super.onPageScrollStateChanged(i11);
            MagicIndicator magicIndicator = e.this.f56460e;
            if (magicIndicator != null) {
                magicIndicator.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            MagicIndicator magicIndicator = e.this.f56460e;
            if (magicIndicator != null) {
                magicIndicator.onPageScrolled(i11, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            MagicIndicator magicIndicator = e.this.f56460e;
            if (magicIndicator != null) {
                magicIndicator.onPageSelected(i11);
            }
            e.this.f56470o = i11;
            if (i11 == 1) {
                e.this.t();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends FragmentStateAdapter {
        d(Fragment fragment) {
            super(fragment);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x00a9  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x00c6  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00ac  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:53:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0045  */
        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public androidx.fragment.app.Fragment createFragment(int r15) {
            /*
                Method dump skipped, instructions count: 331
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.ugcvideodetail.hepler.e.d.createFragment(int):androidx.fragment.app.Fragment");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return e.this.f56463h == UGCVideoPlayFrom.LOCAL_VIDEO ? e.this.f56472q.size() - 1 : e.this.f56472q.size();
        }
    }

    public e(Fragment fragment, UGCVideoDetailViewModel uGCVideoDetailViewModel, UGCVideo uGCVideo, DownloadBean downloadBean, MagicIndicator magicIndicator, ViewPager2 viewPager2, String str, UGCVideoPlayFrom playFrom, String str2, int i11, AppBarLayout appBarLayout) {
        Intrinsics.h(fragment, "fragment");
        Intrinsics.h(playFrom, "playFrom");
        this.f56456a = fragment;
        this.f56457b = uGCVideoDetailViewModel;
        this.f56458c = uGCVideo;
        this.f56459d = downloadBean;
        this.f56460e = magicIndicator;
        this.f56461f = viewPager2;
        this.f56462g = str;
        this.f56463h = playFrom;
        this.f56464i = str2;
        this.f56465j = i11;
        this.f56466k = appBarLayout;
        this.f56470o = RangesKt.m(i11, 0, playFrom == UGCVideoPlayFrom.LOCAL_VIDEO ? 0 : 1);
        this.f56472q = CollectionsKt.o(Utils.a().getString(R$string.for_you), Utils.a().getString(R$string.name_comments));
        n();
        q();
        p();
        o();
    }

    private final void m() {
        ViewPager2 viewPager2 = this.f56461f;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new c());
        }
        ViewPager2 viewPager22 = this.f56461f;
        if (viewPager22 != null) {
            viewPager22.setCurrentItem(this.f56470o, false);
        }
    }

    private final void n() {
    }

    private final void o() {
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(this.f56456a.requireContext());
        oRCommonNavigator.setFollowTouch(true);
        b bVar = new b(this, this.f56461f, this.f56472q);
        this.f56468m = bVar;
        oRCommonNavigator.setAdapter(bVar);
        this.f56467l = oRCommonNavigator;
        MagicIndicator magicIndicator = this.f56460e;
        if (magicIndicator != null) {
            magicIndicator.setNavigator(oRCommonNavigator);
        }
        MagicIndicator magicIndicator2 = this.f56460e;
        if (magicIndicator2 != null) {
            magicIndicator2.onPageSelected(this.f56470o);
        }
    }

    private final void p() {
        d dVar = new d(this.f56456a);
        this.f56469n = dVar;
        ViewPager2 viewPager2 = this.f56461f;
        if (viewPager2 != null) {
            viewPager2.setAdapter(dVar);
        }
        ViewPager2 viewPager22 = this.f56461f;
        if (viewPager22 != null) {
            viewPager22.setUserInputEnabled(false);
        }
        m();
    }

    private final void q() {
        Fragment fragment = this.f56456a;
        Function1 function1 = new Function1() { // from class: com.transsion.ugcvideodetail.hepler.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit r11;
                r11 = e.r(e.this, (CommentEvent) obj);
                return r11;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = CommentEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(fragment, name, Lifecycle.State.CREATED, y0.c().q(), false, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit r(e eVar, CommentEvent value) {
        UGCVideoInteractiveInfo interactiveInfo;
        String commentNum;
        Integer v11;
        Intrinsics.h(value, "value");
        try {
            UGCVideo uGCVideo = eVar.f56458c;
            if (Intrinsics.c(uGCVideo != null ? uGCVideo.getUgcVideoId() : null, value.getSubjectId())) {
                UGCVideo uGCVideo2 = eVar.f56458c;
                int intValue = ((uGCVideo2 == null || (interactiveInfo = uGCVideo2.getInteractiveInfo()) == null || (commentNum = interactiveInfo.getCommentNum()) == null || (v11 = StringsKt.v(commentNum)) == null) ? 0 : v11.intValue()) + 1;
                String str = "";
                String valueOf = intValue > 99 ? "99+" : intValue <= 0 ? "" : String.valueOf(intValue);
                Object obj = eVar.f56472q.get(1);
                if (valueOf.length() != 0) {
                    str = "(" + valueOf + ")";
                }
                String str2 = obj + str;
                ORCommonNavigator oRCommonNavigator = eVar.f56467l;
                j00.d pagerTitleView = oRCommonNavigator != null ? oRCommonNavigator.getPagerTitleView(1) : null;
                PlayDetailResTabTitleView playDetailResTabTitleView = pagerTitleView instanceof PlayDetailResTabTitleView ? (PlayDetailResTabTitleView) pagerTitleView : null;
                if (playDetailResTabTitleView != null) {
                    playDetailResTabTitleView.setTitle(str2);
                }
            }
        } catch (Exception e11) {
            a.C0856a.g(lg.a.f68962a, " callback change data fail " + e11.getMessage(), false, 2, null);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        AppBarLayout appBarLayout = this.f56466k;
        if (appBarLayout != null) {
            appBarLayout.setExpanded(false, true);
        }
    }

    public final void s(boolean z10) {
        if (com.transsion.baseui.util.c.f43558a.a(90991, 500L) || !this.f56456a.isAdded() || this.f56456a.isDetached() || this.f56456a.isRemoving()) {
            return;
        }
        List<InterfaceC1015e> y02 = this.f56456a.getChildFragmentManager().y0();
        Intrinsics.g(y02, "getFragments(...)");
        for (InterfaceC1015e interfaceC1015e : y02) {
            if (interfaceC1015e instanceof ix.a) {
                ((ix.a) interfaceC1015e).onScreenChange(z10);
            }
        }
    }
}
