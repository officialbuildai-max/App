package com.transsion.postdetail.layer.local;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.tn.lib.view.SecondariesSeekBar;
import com.tn.lib.widget.R$mipmap;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.R$string;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.p007enum.ScaleMode;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.fragment.LocalVideoMiddleSeriesListFragment;
import com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView;
import com.transsion.publish.view.PublishStateView;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsnet.downloader.manager.DownloadEsHelper;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class LocalVideoMiddleLayer extends a0 {

    /* renamed from: k0, reason: collision with root package name */
    public static final a f48995k0 = new a(null);

    /* renamed from: b0, reason: collision with root package name */
    private final Fragment f48996b0;

    /* renamed from: c0, reason: collision with root package name */
    private so.b0 f48997c0;

    /* renamed from: d0, reason: collision with root package name */
    private w0 f48998d0;

    /* renamed from: e0, reason: collision with root package name */
    private long f48999e0;

    /* renamed from: f0, reason: collision with root package name */
    private LocalVideoMiddleSeriesListFragment f49000f0;

    /* renamed from: g0, reason: collision with root package name */
    private tn.e f49001g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f49002h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f49003i0;

    /* renamed from: j0, reason: collision with root package name */
    private LocalBackAdHelper f49004j0;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements androidx.view.f {
        b() {
        }

        @Override // androidx.view.f
        public /* synthetic */ void onCreate(androidx.view.u uVar) {
            androidx.view.e.a(this, uVar);
        }

        @Override // androidx.view.f
        public void onDestroy(androidx.view.u owner) {
            LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
            Intrinsics.h(owner, "owner");
            androidx.view.e.b(this, owner);
            LocalBackAdHelper localBackAdHelper = LocalVideoMiddleLayer.this.f49004j0;
            if (localBackAdHelper != null) {
                localBackAdHelper.o();
            }
            so.b0 b0Var = LocalVideoMiddleLayer.this.f48997c0;
            if (b0Var == null || (localVideoMiddleHeaderView = b0Var.f75570v) == null) {
                return;
            }
            localVideoMiddleHeaderView.destroy();
        }

        @Override // androidx.view.f
        public /* synthetic */ void onPause(androidx.view.u uVar) {
            androidx.view.e.c(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onResume(androidx.view.u uVar) {
            androidx.view.e.d(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onStart(androidx.view.u uVar) {
            androidx.view.e.e(this, uVar);
        }

        @Override // androidx.view.f
        public /* synthetic */ void onStop(androidx.view.u uVar) {
            androidx.view.e.f(this, uVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleLayer(Fragment fragment) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.f48996b0 = fragment;
    }

    private final w0 A3() {
        so.b0 b0Var;
        ViewStub viewStub;
        View inflate;
        if (this.f48998d0 == null && (b0Var = this.f48997c0) != null && (viewStub = b0Var.U) != null && (inflate = viewStub.inflate()) != null) {
            so.a0 a11 = so.a0.a(inflate);
            Intrinsics.g(a11, "bind(...)");
            this.f48998d0 = new w0(a11);
        }
        return this.f48998d0;
    }

    private final LocalBackAdHelper B3() {
        LocalBackAdHelper localBackAdHelper = this.f49004j0;
        if (localBackAdHelper != null) {
            return localBackAdHelper;
        }
        LocalBackAdHelper localBackAdHelper2 = new LocalBackAdHelper("LocalVideoBackInterstitialV2Scene", androidx.view.v.a(this.f48996b0), new Function0() { // from class: com.transsion.postdetail.layer.local.b1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Activity C3;
                C3 = LocalVideoMiddleLayer.C3(LocalVideoMiddleLayer.this);
                return C3;
            }
        }, new Function0() { // from class: com.transsion.postdetail.layer.local.c1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit D3;
                D3 = LocalVideoMiddleLayer.D3(LocalVideoMiddleLayer.this);
                return D3;
            }
        }, false, 16, null);
        this.f49004j0 = localBackAdHelper2;
        return localBackAdHelper2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Activity C3(LocalVideoMiddleLayer localVideoMiddleLayer) {
        FragmentActivity activity = localVideoMiddleLayer.f48996b0.getActivity();
        if (activity == null || activity.isDestroyed() || activity.isFinishing()) {
            return null;
        }
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D3(final LocalVideoMiddleLayer localVideoMiddleLayer) {
        ConstraintLayout root;
        so.b0 b0Var = localVideoMiddleLayer.f48997c0;
        if (b0Var != null && (root = b0Var.getRoot()) != null) {
            root.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.d1
                @Override // java.lang.Runnable
                public final void run() {
                    LocalVideoMiddleLayer.E3(LocalVideoMiddleLayer.this);
                }
            }, 200L);
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E3(LocalVideoMiddleLayer localVideoMiddleLayer) {
        J3(localVideoMiddleLayer, false, 1, null);
    }

    private final void F3() {
        TextView textView;
        so.b0 b0Var = this.f48997c0;
        if (b0Var == null || (textView = b0Var.f75573y) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleLayer.G3(LocalVideoMiddleLayer.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G3(LocalVideoMiddleLayer localVideoMiddleLayer, View view) {
        if (view.isSelected()) {
            view.setSelected(false);
            localVideoMiddleLayer.M3(false);
            DownloadBean S0 = localVideoMiddleLayer.S0();
            if (S0 != null) {
                localVideoMiddleLayer.T0().G(S0);
                return;
            }
            return;
        }
        if (!nh.m.f70597a.e()) {
            com.tn.lib.widget.toast.core.h.f41533a.k(R$string.base_network_fail);
            return;
        }
        view.setSelected(true);
        localVideoMiddleLayer.M3(true);
        DownloadBean S02 = localVideoMiddleLayer.S0();
        if (S02 != null) {
            localVideoMiddleLayer.T0().k(S02);
        }
    }

    private final void H3() {
        Fragment k02 = this.f48996b0.getChildFragmentManager().k0("LocalVideoMiddleSeriesList");
        if (k02 instanceof LocalVideoMiddleSeriesListFragment) {
            ((LocalVideoMiddleSeriesListFragment) k02).n0(true);
        }
    }

    private final void I3(boolean z10) {
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
        FragmentActivity activity;
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f48996b0.getLifecycle().a(new b());
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (z10) {
            if (e(FloatActionType.BACK) || (activity = this.f48996b0.getActivity()) == null) {
                return;
            }
            activity.finish();
            return;
        }
        so.b0 b0Var = this.f48997c0;
        if (b0Var == null || (localVideoMiddleHeaderView = b0Var.f75570v) == null) {
            return;
        }
        localVideoMiddleHeaderView.destroy();
    }

    static /* synthetic */ void J3(LocalVideoMiddleLayer localVideoMiddleLayer, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        localVideoMiddleLayer.I3(z10);
    }

    private final void K3() {
        LocalBackAdHelper B3 = B3();
        DownloadBean S0 = S0();
        B3.q(S0 != null ? S0.getGenre() : null);
    }

    private final void L3(DownloadBean downloadBean) {
        if (downloadBean == null) {
            return;
        }
        DownloadEsHelper a11 = DownloadEsHelper.f59542m.a();
        String resourceId = downloadBean.getResourceId();
        if (resourceId == null) {
            resourceId = downloadBean.getUrl();
        }
        DownloadBean q11 = a11.q(resourceId);
        if (q11 != null) {
            downloadBean = q11;
        }
        r2(downloadBean, true);
    }

    private final void M3(boolean z10) {
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        if (z10) {
            so.b0 b0Var = this.f48997c0;
            if (b0Var != null && (textView4 = b0Var.f75574z) != null) {
                textView4.setText(this.f48996b0.getString(com.transsion.postdetail.R$string.download_playing_downloading_tips));
            }
            so.b0 b0Var2 = this.f48997c0;
            if (b0Var2 == null || (textView3 = b0Var2.f75573y) == null) {
                return;
            }
            textView3.setText(this.f48996b0.getString(com.transsion.postdetail.R$string.download_playing_pause));
            return;
        }
        so.b0 b0Var3 = this.f48997c0;
        if (b0Var3 != null && (textView2 = b0Var3.f75574z) != null) {
            textView2.setText(this.f48996b0.getString(com.transsion.postdetail.R$string.download_playing_pause_tips));
        }
        so.b0 b0Var4 = this.f48997c0;
        if (b0Var4 == null || (textView = b0Var4.f75573y) == null) {
            return;
        }
        textView.setText(this.f48996b0.getString(com.transsion.postdetail.R$string.download_playing_resume));
    }

    private final void N3() {
        so.b0 b0Var;
        PublishStateView publishStateView;
        DownloadBean S0 = S0();
        if (S0 == null || (b0Var = this.f48997c0) == null || (publishStateView = b0Var.f75561m) == null) {
            return;
        }
        String groupId = S0.getGroupId();
        String str = groupId == null ? "" : groupId;
        String cover = S0.getCover();
        String str2 = cover == null ? "" : cover;
        String name = S0.getName();
        publishStateView.publishSource(4, (r19 & 2) != 0 ? "" : null, (r19 & 4) != 0 ? "" : null, (r19 & 8) != 0 ? "" : null, (r19 & 16) != 0 ? "" : null, (r19 & 32) != 0 ? "" : str, (r19 & 64) != 0 ? "" : name == null ? "" : name, (r19 & 128) == 0 ? str2 : "", (r19 & 256) != 0 ? false : true);
    }

    private final void O3(String str) {
        ConstraintLayout root;
        if (System.currentTimeMillis() - com.transsion.baselib.report.launch.b.f43424a.b().getLong("show_LocalVideoBackInterstitialV2Scene_timestamp", 0L) >= com.transsion.ad.scene.a.f42255a.k("LocalVideoBackInterstitialV2Scene") * 60000) {
            R3();
            return;
        }
        ii.b.d(ii.b.f65371a, "LocalVideoBackInterstitialV2Scene", false, 2, null);
        so.b0 b0Var = this.f48997c0;
        if (b0Var == null || (root = b0Var.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.a1
            @Override // java.lang.Runnable
            public final void run() {
                LocalVideoMiddleLayer.P3(LocalVideoMiddleLayer.this);
            }
        }, 200L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P3(LocalVideoMiddleLayer localVideoMiddleLayer) {
        J3(localVideoMiddleLayer, false, 1, null);
    }

    private final void Q3(boolean z10) {
        FrameLayout frameLayout;
        so.b0 b0Var = this.f48997c0;
        if (b0Var == null || (frameLayout = b0Var.f75552d) == null) {
            return;
        }
        frameLayout.setVisibility(z10 ? 0 : 8);
    }

    private final void R3() {
        LocalBackAdHelper B3 = B3();
        DownloadBean S0 = S0();
        B3.r(S0 != null ? S0.getGenre() : null);
    }

    private final void S3() {
        LocalVideoMiddleSeriesListFragment a11 = LocalVideoMiddleSeriesListFragment.INSTANCE.a();
        a11.r0(S0(), e1());
        a11.s0(new Function2() { // from class: com.transsion.postdetail.layer.local.e1
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit T3;
                T3 = LocalVideoMiddleLayer.T3(LocalVideoMiddleLayer.this, (DownloadBean) obj, ((Integer) obj2).intValue());
                return T3;
            }
        });
        a11.t0(this.f48996b0, R$id.fl_series_list_container);
        this.f49000f0 = a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T3(LocalVideoMiddleLayer localVideoMiddleLayer, DownloadBean bean, int i11) {
        Intrinsics.h(bean, "bean");
        localVideoMiddleLayer.L3(bean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U3(LocalVideoMiddleLayer localVideoMiddleLayer, DownloadBean downloadBean) {
        localVideoMiddleLayer.L3(downloadBean);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V3(LocalVideoMiddleLayer localVideoMiddleLayer) {
        localVideoMiddleLayer.S3();
        return Unit.f67184a;
    }

    private final void y3(boolean z10, boolean z11) {
        w0 A3;
        if (z11 && (A3 = A3()) != null) {
            A3.d(z10);
        }
        long j11 = z10 ? RangesKt.j(this.f48999e0 + 10000, n1()) : RangesKt.g(this.f48999e0 - 10000, 0L);
        this.f48999e0 = j11;
        com.transsion.player.orplayer.g H = H();
        if (H != null) {
            H.seekTo(j11);
        }
    }

    static /* synthetic */ void z3(LocalVideoMiddleLayer localVideoMiddleLayer, boolean z10, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        localVideoMiddleLayer.y3(z10, z11);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View A0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.L;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    protected void B0(Subject subject) {
        super.B0(subject);
        if (this.f49002h0) {
            return;
        }
        this.f49002h0 = true;
        if (subject != null) {
            kotlinx.coroutines.k.d(kotlinx.coroutines.o0.a(kotlinx.coroutines.y0.b()), null, null, new LocalVideoMiddleLayer$bindMovieDetail$1(this, subject, null), 3, null);
            String ops = subject.getOps();
            if (ops == null || ops.length() == 0) {
                DownloadBean S0 = S0();
                subject.setOps(S0 != null ? S0.getOps() : null);
            }
        }
        if (subject == null) {
            subject = xn.a.a(S0());
        }
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        DownloadBean S02 = S0();
        a.C0856a.f(c0856a, m12, "bindMovieDetail, isInnerVideo:" + (S02 != null ? Boolean.valueOf(S02.isInnerSubjectRes()) : null), false, 4, null);
        Fragment fragment = this.f48996b0;
        so.b0 b0Var = this.f48997c0;
        this.f49001g0 = new tn.e(fragment, subject, b0Var != null ? b0Var.f75566r : null, b0Var != null ? b0Var.f75569u : null, "local_video_detail", true, !(S0() != null ? r1.isInnerSubjectRes() : true), null, 128, null);
        new tn.g(this.f48996b0, R$id.subjectDetailLayout, subject, "local_video_detail", "download_subject", true, !(S0() != null ? r1.isInnerSubjectRes() : true));
        Q3(false);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public boolean C0() {
        return false;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup D0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.J;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void E(DownloadBean bean) {
        so.b0 b0Var;
        TextView textView;
        TextView textView2;
        so.b0 b0Var2;
        FrameLayout frameLayout;
        Intrinsics.h(bean, "bean");
        super.E(bean);
        int status = bean.getStatus();
        if (status != 1 && status != 2 && status != 3) {
            if (status != 5) {
                return;
            }
            a.C0856a c0856a = lg.a.f68962a;
            String m12 = m1();
            Intrinsics.g(m12, "<get-TAG>(...)");
            String resourceId = bean.getResourceId();
            DownloadBean S0 = S0();
            a.C0856a.v(c0856a, m12, "onDownloadCallback, success  resourceId = " + resourceId + ", cur resourceId = " + (S0 != null ? S0.getResourceId() : null), false, 4, null);
            String resourceId2 = bean.getResourceId();
            DownloadBean S02 = S0();
            if (!Intrinsics.c(resourceId2, S02 != null ? S02.getResourceId() : null) || (b0Var2 = this.f48997c0) == null || (frameLayout = b0Var2.f75553e) == null) {
                return;
            }
            jg.c.g(frameLayout);
            return;
        }
        if (!this.f49003i0) {
            DownloadBean S03 = S0();
            if (Intrinsics.c(S03 != null ? S03.getSubjectId() : null, bean.getSubjectId())) {
                a.C0856a c0856a2 = lg.a.f68962a;
                String m13 = m1();
                Intrinsics.g(m13, "<get-TAG>(...)");
                a.C0856a.v(c0856a2, m13, "onDownloadCallback, refresh  epse = " + bean.getEpse(), false, 4, null);
                this.f49003i0 = true;
                o1().h(S0());
            }
        }
        String resourceId3 = bean.getResourceId();
        DownloadBean S04 = S0();
        if (!Intrinsics.c(resourceId3, S04 != null ? S04.getResourceId() : null) || (b0Var = this.f48997c0) == null || (textView = b0Var.f75573y) == null || textView.isSelected()) {
            return;
        }
        so.b0 b0Var3 = this.f48997c0;
        if (b0Var3 != null && (textView2 = b0Var3.f75573y) != null) {
            textView2.setSelected(true);
        }
        M3(true);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup E0() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View F0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.Q;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView G0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.D;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView H0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.B;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView I0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.K;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup N2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.f75555g;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ImageView O0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.f75559k;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ImageView O2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View P1() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.f75560l;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ProgressBar P2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View Q0() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.G;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView Q2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView R2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SimpleSubtitleView S2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SimpleSubtitleView T2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.H;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup U2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.f75557i;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void V1() {
        O3("onBackClick");
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SimpleSubtitleView V2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.I;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView W2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView X2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.E;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView Y2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.F;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public Group Z2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.M;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void a(LocalUiType uiType) {
        Window window;
        Intrinsics.h(uiType, "uiType");
        j(false);
        tn.e eVar = this.f49001g0;
        if (eVar != null) {
            eVar.x(uiType != LocalUiType.MIDDLE);
        }
        LocalUiType localUiType = LocalUiType.MIDDLE;
        if (uiType == localUiType) {
            a.C0856a c0856a = lg.a.f68962a;
            String m12 = m1();
            Intrinsics.g(m12, "<get-TAG>(...)");
            a.C0856a.f(c0856a, m12, "onLocalUiChanged 2 middle", false, 4, null);
            com.transsion.player.orplayer.g H = H();
            if (H != null) {
                H.setScaleMode(ScaleMode.SCALE_ASPECT_FIT);
            }
            FragmentActivity activity = this.f48996b0.getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                WindowInsetsControllerCompat insetsController = WindowCompat.getInsetsController(window, window.getDecorView());
                Intrinsics.g(insetsController, "getInsetsController(...)");
                insetsController.show(WindowInsetsCompat.Type.navigationBars());
            }
            z0();
        }
        lg.a.f68962a.c("long_video_play", "middle, onLocalUiChanged uiType = " + uiType, true);
        T1(uiType == localUiType);
        super.a(uiType);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public LocalUiType a3() {
        return LocalUiType.MIDDLE;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void c() {
        super.c();
        I3(false);
        this.f48997c0 = null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void f(boolean z10, String requestKey) {
        Intrinsics.h(requestKey, "requestKey");
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ImageView f2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.N;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewGroup g2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void h(String subjectId, String resourceId) {
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(resourceId, "resourceId");
        super.h(subjectId, resourceId);
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        a.C0856a.v(c0856a, m12, "initSeries", false, 4, null);
        o1().h(S0());
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView h2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView h3() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View i2() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public boolean isVisible() {
        ConstraintLayout constraintLayout;
        so.b0 b0Var = this.f48997c0;
        return (b0Var == null || (constraintLayout = b0Var.f75567s) == null || constraintLayout.getVisibility() != 0) ? false : true;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void j(boolean z10) {
        View view;
        so.b0 b0Var = this.f48997c0;
        if (b0Var == null || (view = b0Var.T) == null) {
            return;
        }
        view.setVisibility(z10 ? 0 : 8);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View j1() {
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public FrameLayout j3() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.S;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void k(DownloadBean downloadBean, String pageFrom, boolean z10) {
        TextView textView;
        FrameLayout frameLayout;
        so.b0 b0Var;
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView2;
        String path;
        FrameLayout frameLayout2;
        Intrinsics.h(pageFrom, "pageFrom");
        super.k(downloadBean, pageFrom, z10);
        if ((downloadBean == null || downloadBean.getStatus() != 5) && downloadBean != null && downloadBean.isInnerRes()) {
            so.b0 b0Var2 = this.f48997c0;
            if (b0Var2 != null && (frameLayout = b0Var2.f75553e) != null) {
                jg.c.k(frameLayout);
            }
            boolean A = T0().A(downloadBean);
            so.b0 b0Var3 = this.f48997c0;
            if (b0Var3 != null && (textView = b0Var3.f75573y) != null) {
                textView.setSelected(A);
            }
            M3(A);
        } else {
            so.b0 b0Var4 = this.f48997c0;
            if (b0Var4 != null && (frameLayout2 = b0Var4.f75553e) != null) {
                jg.c.g(frameLayout2);
            }
        }
        if (downloadBean != null && downloadBean.getType() == 6 && (path = downloadBean.getPath()) != null && StringsKt.c0(path, ".mp3", false, 2, null)) {
            s2(downloadBean.getCover());
        }
        N3();
        so.b0 b0Var5 = this.f48997c0;
        if (b0Var5 != null && (localVideoMiddleHeaderView2 = b0Var5.f75570v) != null) {
            localVideoMiddleHeaderView2.updateDownloadBean(downloadBean);
        }
        o1().d(downloadBean != null ? downloadBean.getSubjectId() : null);
        if (!z10 || (b0Var = this.f48997c0) == null || (localVideoMiddleHeaderView = b0Var.f75570v) == null) {
            return;
        }
        localVideoMiddleHeaderView.init(downloadBean, b0Var != null ? b0Var.f75568t : null, androidx.view.v.a(this.f48996b0));
        localVideoMiddleHeaderView.setItemClickCallback(new Function1() { // from class: com.transsion.postdetail.layer.local.y0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit U3;
                U3 = LocalVideoMiddleLayer.U3(LocalVideoMiddleLayer.this, (DownloadBean) obj);
                return U3;
            }
        });
        localVideoMiddleHeaderView.setAllListClickCallback(new Function0() { // from class: com.transsion.postdetail.layer.local.z0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit V3;
                V3 = LocalVideoMiddleLayer.V3(LocalVideoMiddleLayer.this);
                return V3;
            }
        });
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View k2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.C;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public TextView k3() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.R;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void m(LocalUiType newConfig) {
        Intrinsics.h(newConfig, "newConfig");
        super.m(newConfig);
        if (newConfig == LocalUiType.LAND) {
            Y1();
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewStub m3() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.V;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ConstraintLayout n2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.f75567s;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public ViewStub n3() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.W;
        }
        return null;
    }

    @Override // vo.d
    public void onBackPressed() {
        a.C0856a c0856a = lg.a.f68962a;
        String m12 = m1();
        Intrinsics.g(m12, "<get-TAG>(...)");
        a.C0856a.f(c0856a, m12, "middle onBackPressed", false, 4, null);
        LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment = this.f49000f0;
        if (localVideoMiddleSeriesListFragment == null || localVideoMiddleSeriesListFragment.getIsRemoved()) {
            O3("onBackPressed");
            return;
        }
        LocalVideoMiddleSeriesListFragment localVideoMiddleSeriesListFragment2 = this.f49000f0;
        if (localVideoMiddleSeriesListFragment2 != null) {
            LocalVideoMiddleSeriesListFragment.o0(localVideoMiddleSeriesListFragment2, false, 1, null);
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0, com.transsion.player.orplayer.f
    public void onProgress(long j11, ao.e eVar) {
        super.onProgress(j11, eVar);
        if (isVisible()) {
            this.f48999e0 = j11;
            i0.f49093v.a().t(j11, n1());
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View p2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.O;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View q1() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.f75563o;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public SecondariesSeekBar q2() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.P;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void r(View rootView, LocalUiType uiType) {
        PublishStateView publishStateView;
        View view;
        Intrinsics.h(rootView, "rootView");
        Intrinsics.h(uiType, "uiType");
        if (uiType != LocalUiType.MIDDLE) {
            return;
        }
        this.f48997c0 = so.b0.a(rootView);
        super.r(rootView, uiType);
        so.b0 b0Var = this.f48997c0;
        ViewGroup.LayoutParams layoutParams = (b0Var == null || (view = b0Var.f75558j) == null) ? null : view.getLayoutParams();
        Intrinsics.f(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).topMargin = com.blankj.utilcode.util.d.c();
        Q3(true);
        F3();
        H3();
        K3();
        so.b0 b0Var2 = this.f48997c0;
        if (b0Var2 != null && (publishStateView = b0Var2.f75561m) != null) {
            publishStateView.setImageResource(R$mipmap.libui_ic_base_whit_publish);
        }
        b3(false);
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public View r1() {
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null) {
            return b0Var.f75562n;
        }
        return null;
    }

    @Override // com.transsion.postdetail.layer.local.a0
    public void s1(MotionEvent motionEvent, boolean z10) {
        View view;
        so.b0 b0Var = this.f48997c0;
        if (b0Var != null && (view = b0Var.T) != null) {
            jg.c.g(view);
        }
        if (!z10 || motionEvent == null) {
            super.s1(motionEvent, false);
            return;
        }
        int e11 = com.blankj.utilcode.util.y.e() / 3;
        int rawX = (int) motionEvent.getRawX();
        if (rawX >= 0 && rawX <= e11) {
            z3(this, false, false, 2, null);
        } else if (rawX > e11 * 2) {
            z3(this, true, false, 2, null);
        } else {
            super.s1(motionEvent, false);
        }
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void u(String subjectId, String resourceId) {
        LocalVideoMiddleHeaderView localVideoMiddleHeaderView;
        DownloadBean downloadBean;
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(resourceId, "resourceId");
        so.b0 b0Var = this.f48997c0;
        if (b0Var == null || (localVideoMiddleHeaderView = b0Var.f75570v) == null || (downloadBean = localVideoMiddleHeaderView.getDownloadBean(resourceId)) == null) {
            return;
        }
        r2(downloadBean, true);
    }

    @Override // com.transsion.postdetail.layer.local.a0, vo.d
    public void v(boolean z10) {
        super.v(z10);
    }
}
