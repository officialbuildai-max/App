package tn;

import android.content.Context;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.view.InterfaceC1015e;
import androidx.view.Lifecycle;
import androidx.view.c0;
import androidx.view.v0;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.i;
import com.therouter.TheRouter;
import com.transsion.baseui.R$string;
import com.transsion.baseui.widget.magicindicator.ORCommonNavigator;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.SubjectPostCount;
import com.transsion.play.detail.viewmodel.PlayDetailViewModel;
import com.transsion.play.detail.widget.PlayDetailResTabTitleView;
import com.transsion.videodetail.api.IStreamDetailService;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.PublishEvent;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.y0;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import tn.e;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: q, reason: collision with root package name */
    public static final a f76415q = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Fragment f76416a;

    /* renamed from: b, reason: collision with root package name */
    private final Subject f76417b;

    /* renamed from: c, reason: collision with root package name */
    private final MagicIndicator f76418c;

    /* renamed from: d, reason: collision with root package name */
    private final ViewPager2 f76419d;

    /* renamed from: e, reason: collision with root package name */
    private final String f76420e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f76421f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f76422g;

    /* renamed from: h, reason: collision with root package name */
    private final Function1 f76423h;

    /* renamed from: i, reason: collision with root package name */
    private ORCommonNavigator f76424i;

    /* renamed from: j, reason: collision with root package name */
    private b f76425j;

    /* renamed from: k, reason: collision with root package name */
    private FragmentStateAdapter f76426k;

    /* renamed from: l, reason: collision with root package name */
    private int f76427l;

    /* renamed from: m, reason: collision with root package name */
    private long f76428m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f76429n;

    /* renamed from: o, reason: collision with root package name */
    private final Lazy f76430o;

    /* renamed from: p, reason: collision with root package name */
    private final Lazy f76431p;

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
        private final ViewPager2 f76432b;

        /* renamed from: c, reason: collision with root package name */
        private final List f76433c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f76434d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f76435e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f76436f;

        public b(e eVar, ViewPager2 viewPager2, List tabList, boolean z10, boolean z11) {
            Intrinsics.h(tabList, "tabList");
            this.f76436f = eVar;
            this.f76432b = viewPager2;
            this.f76433c = tabList;
            this.f76434d = z10;
            this.f76435e = z11;
        }

        private final LinearLayout.LayoutParams j() {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.setMarginStart(dk.a.b(6));
            layoutParams.setMarginEnd(dk.a.b(2));
            return layoutParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void k(int i11, e eVar, PlayDetailResTabTitleView playDetailResTabTitleView, b bVar, View view) {
            if (i11 == 1 && eVar.f76429n) {
                eVar.f76429n = false;
                playDetailResTabTitleView.setDotVisibility(false);
                com.transsion.baselib.report.launch.b.f43424a.b().putBoolean("key_subj_comment_dot", false);
            }
            ViewPager2 viewPager2 = bVar.f76432b;
            if (viewPager2 != null) {
                viewPager2.setCurrentItem(i11, true);
            }
        }

        @Override // j00.a
        public int a() {
            return (this.f76434d && this.f76435e) ? this.f76433c.size() - 1 : this.f76433c.size();
        }

        @Override // j00.a
        public j00.c b(Context context) {
            Intrinsics.h(context, "context");
            LinePagerIndicator linePagerIndicator = new LinePagerIndicator(context);
            linePagerIndicator.setMode(1);
            linePagerIndicator.setLineHeight(i.e(3.0f));
            linePagerIndicator.setStartInterpolator(new AccelerateInterpolator());
            linePagerIndicator.setEndInterpolator(new DecelerateInterpolator(2.0f));
            linePagerIndicator.setColors(-1, -1, -1);
            return linePagerIndicator;
        }

        @Override // j00.a
        public j00.d c(Context context, final int i11) {
            Intrinsics.h(context, "context");
            final PlayDetailResTabTitleView playDetailResTabTitleView = new PlayDetailResTabTitleView(context);
            final e eVar = this.f76436f;
            if (i11 == 1) {
                playDetailResTabTitleView.setDotVisibility(eVar.f76429n);
            }
            Object obj = this.f76433c.get(i11);
            Intrinsics.g(obj, "get(...)");
            playDetailResTabTitleView.setTitle((String) obj);
            playDetailResTabTitleView.setOnClickListener(new View.OnClickListener() { // from class: tn.f
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
            MagicIndicator magicIndicator = e.this.f76418c;
            if (magicIndicator != null) {
                magicIndicator.onPageScrollStateChanged(i11);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i11, float f11, int i12) {
            super.onPageScrolled(i11, f11, i12);
            MagicIndicator magicIndicator = e.this.f76418c;
            if (magicIndicator != null) {
                magicIndicator.onPageScrolled(i11, f11, i12);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i11) {
            super.onPageSelected(i11);
            Function1 function1 = e.this.f76423h;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i11));
            }
            MagicIndicator magicIndicator = e.this.f76418c;
            if (magicIndicator != null) {
                magicIndicator.onPageSelected(i11);
            }
            e.this.f76427l = i11;
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends FragmentStateAdapter {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ IStreamDetailService f76439b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(IStreamDetailService iStreamDetailService, Fragment fragment) {
            super(fragment);
            this.f76439b = iStreamDetailService;
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int i11) {
            if (i11 == 0) {
                IStreamDetailService iStreamDetailService = this.f76439b;
                Subject subject = e.this.f76417b;
                Subject subject2 = e.this.f76417b;
                return iStreamDetailService.d(subject, subject2 != null ? subject2.getOps() : null, e.this.f76420e, e.this.f76421f, e.this.f76422g);
            }
            IStreamDetailService iStreamDetailService2 = this.f76439b;
            Subject subject3 = e.this.f76417b;
            String subjectId = subject3 != null ? subject3.getSubjectId() : null;
            Subject subject4 = e.this.f76417b;
            return iStreamDetailService2.a(subjectId, subject4 != null ? subject4.getOps() : null, e.this.f76420e);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return (e.this.f76421f && e.this.f76422g) ? e.this.q().size() - 1 : e.this.q().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: tn.e$e, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0954e implements c0, FunctionAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ Function1 f76440a;

        C0954e(Function1 function) {
            Intrinsics.h(function, "function");
            this.f76440a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f76440a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof c0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.c(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.view.c0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f76440a.invoke(obj);
        }
    }

    public e(Fragment fragment, Subject subject, MagicIndicator magicIndicator, ViewPager2 viewPager2, String str, boolean z10, boolean z11, Function1 function1) {
        Intrinsics.h(fragment, "fragment");
        this.f76416a = fragment;
        this.f76417b = subject;
        this.f76418c = magicIndicator;
        this.f76419d = viewPager2;
        this.f76420e = str;
        this.f76421f = z10;
        this.f76422g = z11;
        this.f76423h = function1;
        this.f76430o = LazyKt.b(new Function0() { // from class: tn.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PlayDetailViewModel y10;
                y10 = e.y(e.this);
                return y10;
            }
        });
        this.f76431p = LazyKt.b(new Function0() { // from class: tn.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                List z12;
                z12 = e.z(e.this);
                return z12;
            }
        });
        r();
        u();
        t();
        s();
    }

    public /* synthetic */ e(Fragment fragment, Subject subject, MagicIndicator magicIndicator, ViewPager2 viewPager2, String str, boolean z10, boolean z11, Function1 function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragment, subject, magicIndicator, viewPager2, str, (i11 & 32) != 0 ? false : z10, (i11 & 64) != 0 ? false : z11, (i11 & 128) != 0 ? null : function1);
    }

    private final void o() {
        ViewPager2 viewPager2 = this.f76419d;
        if (viewPager2 != null) {
            viewPager2.registerOnPageChangeCallback(new c());
        }
        ViewPager2 viewPager22 = this.f76419d;
        if (viewPager22 != null) {
            viewPager22.setCurrentItem(this.f76427l, false);
        }
    }

    private final PlayDetailViewModel p() {
        return (PlayDetailViewModel) this.f76430o.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List q() {
        return (List) this.f76431p.getValue();
    }

    private final void r() {
        this.f76429n = com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("key_subj_comment_dot", true);
    }

    private final void s() {
        ORCommonNavigator oRCommonNavigator = new ORCommonNavigator(this.f76416a.requireContext());
        oRCommonNavigator.setFollowTouch(true);
        b bVar = new b(this, this.f76419d, q(), this.f76421f, this.f76422g);
        this.f76425j = bVar;
        oRCommonNavigator.setAdapter(bVar);
        this.f76424i = oRCommonNavigator;
        MagicIndicator magicIndicator = this.f76418c;
        if (magicIndicator != null) {
            magicIndicator.setNavigator(oRCommonNavigator);
        }
    }

    private final void t() {
        IStreamDetailService iStreamDetailService = (IStreamDetailService) TheRouter.d(IStreamDetailService.class, new Object[0]);
        if (iStreamDetailService == null) {
            return;
        }
        d dVar = new d(iStreamDetailService, this.f76416a);
        this.f76426k = dVar;
        ViewPager2 viewPager2 = this.f76419d;
        if (viewPager2 != null) {
            viewPager2.setAdapter(dVar);
        }
        o();
    }

    private final void u() {
        String subjectId;
        Fragment fragment = this.f76416a;
        Function1 function1 = new Function1() { // from class: tn.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit v11;
                v11 = e.v(e.this, (PublishEvent) obj);
                return v11;
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = PublishEvent.class.getName();
        Intrinsics.g(name, "getName(...)");
        flowEventBus.observeEvent(fragment, name, Lifecycle.State.CREATED, y0.c().q(), false, function1);
        p().g().j(this.f76416a, new C0954e(new Function1() { // from class: tn.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w11;
                w11 = e.w(e.this, (SubjectPostCount) obj);
                return w11;
            }
        }));
        Subject subject = this.f76417b;
        if (subject == null || (subjectId = subject.getSubjectId()) == null) {
            return;
        }
        p().f(subjectId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit v(e eVar, PublishEvent it) {
        String str;
        Intrinsics.h(it, "it");
        long j11 = eVar.f76428m + 1;
        eVar.f76428m = j11;
        String valueOf = j11 > 99 ? "99+" : String.valueOf(j11);
        Object obj = eVar.q().get(1);
        if (valueOf.length() == 0) {
            str = "";
        } else {
            str = "(" + valueOf + ")";
        }
        String str2 = obj + str;
        ORCommonNavigator oRCommonNavigator = eVar.f76424i;
        j00.d pagerTitleView = oRCommonNavigator != null ? oRCommonNavigator.getPagerTitleView(1) : null;
        PlayDetailResTabTitleView playDetailResTabTitleView = pagerTitleView instanceof PlayDetailResTabTitleView ? (PlayDetailResTabTitleView) pagerTitleView : null;
        if (playDetailResTabTitleView != null) {
            playDetailResTabTitleView.setTitle(str2);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0041, code lost:
    
        if (r1 == null) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit w(tn.e r7, com.transsion.moviedetailapi.bean.SubjectPostCount r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L8
            java.lang.String r1 = r8.getCount()
            goto L9
        L8:
            r1 = r0
        L9:
            if (r1 == 0) goto L9f
            int r1 = r1.length()
            if (r1 != 0) goto L13
            goto L9f
        L13:
            if (r8 == 0) goto L1a
            java.lang.String r1 = r8.getCount()
            goto L1b
        L1a:
            r1 = r0
        L1b:
            kotlin.jvm.internal.Intrinsics.e(r1)
            java.lang.Long r1 = kotlin.text.StringsKt.x(r1)
            java.lang.String r2 = ""
            if (r1 == 0) goto L43
            long r3 = r1.longValue()
            r7.f76428m = r3
            r5 = 99
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L35
            java.lang.String r1 = "99+"
            goto L41
        L35:
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 > 0) goto L3d
            r1 = r2
            goto L41
        L3d:
            java.lang.String r1 = java.lang.String.valueOf(r3)
        L41:
            if (r1 != 0) goto L47
        L43:
            java.lang.String r1 = r8.getCount()
        L47:
            java.util.List r8 = r7.q()
            r3 = 1
            java.lang.Object r8 = r8.get(r3)
            if (r1 == 0) goto L6f
            int r4 = r1.length()
            if (r4 != 0) goto L59
            goto L6f
        L59:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "("
            r2.append(r4)
            r2.append(r1)
            java.lang.String r1 = ")"
            r2.append(r1)
            java.lang.String r2 = r2.toString()
        L6f:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r8)
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            boolean r1 = r7.f76421f
            if (r1 == 0) goto L86
            boolean r1 = r7.f76422g
            if (r1 != 0) goto L9c
        L86:
            com.transsion.baseui.widget.magicindicator.ORCommonNavigator r7 = r7.f76424i
            if (r7 == 0) goto L8f
            j00.d r7 = r7.getPagerTitleView(r3)
            goto L90
        L8f:
            r7 = r0
        L90:
            boolean r1 = r7 instanceof com.transsion.play.detail.widget.PlayDetailResTabTitleView
            if (r1 == 0) goto L97
            r0 = r7
            com.transsion.play.detail.widget.PlayDetailResTabTitleView r0 = (com.transsion.play.detail.widget.PlayDetailResTabTitleView) r0
        L97:
            if (r0 == 0) goto L9c
            r0.setTitle(r8)
        L9c:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        L9f:
            kotlin.Unit r7 = kotlin.Unit.f67184a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: tn.e.w(tn.e, com.transsion.moviedetailapi.bean.SubjectPostCount):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PlayDetailViewModel y(e eVar) {
        return (PlayDetailViewModel) new v0(eVar.f76416a).a(PlayDetailViewModel.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List z(e eVar) {
        return CollectionsKt.o(eVar.f76416a.requireContext().getString(R$string.for_you), eVar.f76416a.requireContext().getString(R$string.name_comments));
    }

    public final void x(boolean z10) {
        if (com.transsion.baseui.util.c.f43558a.a(90991, 500L) || !this.f76416a.isAdded() || this.f76416a.isDetached() || this.f76416a.isRemoving()) {
            return;
        }
        List<InterfaceC1015e> y02 = this.f76416a.getChildFragmentManager().y0();
        Intrinsics.g(y02, "getFragments(...)");
        for (InterfaceC1015e interfaceC1015e : y02) {
            if (interfaceC1015e instanceof ix.a) {
                ((ix.a) interfaceC1015e).onScreenChange(z10);
            }
        }
    }
}
