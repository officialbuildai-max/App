package com.transsion.postdetail.layer.local;

import android.R;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.view.v0;
import com.avery.subtitle.widget.SimpleSubtitleView;
import com.blankj.utilcode.util.Utils;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.therouter.TheRouter;
import com.therouter.router.Navigator;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.strategy.b;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baselib.report.l;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.music.MusicFloatManager;
import com.transsion.baseui.widget.f;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.player.mediasession.MediaItem;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.layer.BaseLayer;
import com.transsion.postdetail.layer.SystemTimeManager;
import com.transsion.postdetail.layer.listener.LayerFlag;
import com.transsion.postdetail.layer.local.a0;
import com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment;
import com.transsion.postdetail.util.LocalFloatManager;
import com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel;
import com.transsion.push.api.IPushProvider;
import com.transsion.subtitle.VideoSubtitleControl;
import com.transsion.usercenter.setting.labelsfeedback.model.FbTvData;
import com.transsion.videofloat.bean.FloatActionType;
import com.transsion.videofloat.bean.FloatPlayType;
import com.transsnet.downloader.util.LocalVideoNotExistUtil;
import ej.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import lg.a;
import org.mvel2.ast.ASTNode;
import ox.e;
import vo.d;

/* loaded from: classes6.dex */
public abstract class a0 extends BaseLayer implements vo.d, com.transsion.player.orplayer.f, l.a, b.a {
    private boolean A;
    private View B;
    private View C;
    private float D;
    private long E;
    private final Lazy F;
    private final Lazy G;
    private DownloadBean H;
    private String I;
    private String J;
    private String K;
    private boolean L;
    private vo.c M;
    private boolean N;
    private boolean O;
    private boolean P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private final Lazy U;
    private final Runnable V;
    private String[] W;
    private int X;
    private final Runnable Y;
    private final Runnable Z;

    /* renamed from: a0 */
    private long f49007a0;

    /* renamed from: j */
    private final String f49008j;

    /* renamed from: k */
    private final Fragment f49009k;

    /* renamed from: l */
    private long f49010l;

    /* renamed from: m */
    private final Lazy f49011m;

    /* renamed from: n */
    private final Lazy f49012n;

    /* renamed from: o */
    private final Lazy f49013o;

    /* renamed from: p */
    private int f49014p;

    /* renamed from: q */
    private int f49015q;

    /* renamed from: r */
    private boolean f49016r;

    /* renamed from: s */
    private SystemTimeManager f49017s;

    /* renamed from: t */
    private vo.b f49018t;

    /* renamed from: u */
    private VideoSubtitleControl f49019u;

    /* renamed from: v */
    private eo.n f49020v;

    /* renamed from: w */
    private j1 f49021w;

    /* renamed from: x */
    private String f49022x;

    /* renamed from: y */
    private boolean f49023y;

    /* renamed from: z */
    private boolean f49024z;

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f49025a;

        static {
            int[] iArr = new int[LocalUiType.values().length];
            try {
                iArr[LocalUiType.MIDDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LocalUiType.LAND.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LocalUiType.PORTRAIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f49025a = iArr;
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements f.a {

        /* renamed from: a */
        private long f49026a;

        /* renamed from: b */
        private float f49027b;

        /* renamed from: c */
        private boolean f49028c;

        /* renamed from: d */
        private boolean f49029d;

        /* renamed from: e */
        private boolean f49030e;

        /* renamed from: f */
        private long f49031f;

        /* renamed from: g */
        private float f49032g;

        /* renamed from: i */
        final /* synthetic */ boolean f49034i;

        /* renamed from: j */
        final /* synthetic */ int f49035j;

        /* renamed from: k */
        final /* synthetic */ int f49036k;

        b(boolean z10, int i11, int i12) {
            this.f49034i = z10;
            this.f49035j = i11;
            this.f49036k = i12;
        }

        @Override // com.transsion.baseui.widget.f.a
        public void a() {
            Group Z2 = a0.this.Z2();
            if (Z2 == null || Z2.getVisibility() != 8) {
                a0.this.v1(true);
            } else {
                a0.B2(a0.this, false, 1, null);
            }
        }

        @Override // com.transsion.baseui.widget.f.a
        public void b(float f11, float f12) {
            if (!this.f49028c) {
                SecondariesSeekBar q22 = a0.this.q2();
                this.f49031f = q22 != null ? q22.getCurrentProgress() : 0L;
                a0.this.A2(false);
            }
            a0.this.f49016r = true;
            this.f49028c = true;
            a0.this.X0().removeCallbacks(a0.this.V);
            float f13 = this.f49034i ? f11 - f12 : f12 - f11;
            float f14 = (float) 10000;
            long j11 = ((float) this.f49031f) + ((f13 * f14) / (this.f49035j * 4));
            long j12 = j11 >= 0 ? j11 > 10000 ? 10000L : j11 : 0L;
            SecondariesSeekBar q23 = a0.this.q2();
            if (q23 != null) {
                q23.setProgress(j12);
            }
            this.f49027b = (((float) j12) * 1.0f) / f14;
            long n12 = ((float) a0.this.n1()) * this.f49027b;
            this.f49026a = n12;
            a0.this.E = n12;
            a0.this.c3(true, this.f49026a);
        }

        @Override // com.transsion.baseui.widget.f.a
        public void c(float f11, float f12) {
            eo.n nVar = null;
            if (!this.f49030e) {
                eo.n nVar2 = a0.this.f49020v;
                if (nVar2 == null) {
                    Intrinsics.z("volumeControl");
                    nVar2 = null;
                }
                nVar2.f(false);
                eo.n nVar3 = a0.this.f49020v;
                if (nVar3 == null) {
                    Intrinsics.z("volumeControl");
                    nVar3 = null;
                }
                this.f49032g = nVar3.b();
                this.f49030e = true;
            }
            float f13 = ((f11 - f12) * 2) / this.f49036k;
            eo.n nVar4 = a0.this.f49020v;
            if (nVar4 == null) {
                Intrinsics.z("volumeControl");
            } else {
                nVar = nVar4;
            }
            nVar.a(this.f49032g, f13);
        }

        @Override // com.transsion.baseui.widget.f.a
        public void d(float f11, float f12) {
            eo.n nVar = null;
            if (!this.f49029d) {
                eo.n nVar2 = a0.this.f49020v;
                if (nVar2 == null) {
                    Intrinsics.z("volumeControl");
                    nVar2 = null;
                }
                nVar2.f(false);
                this.f49029d = true;
            }
            eo.n nVar3 = a0.this.f49020v;
            if (nVar3 == null) {
                Intrinsics.z("volumeControl");
            } else {
                nVar = nVar3;
            }
            nVar.d(f11, f12, this.f49036k);
        }

        @Override // com.transsion.baseui.widget.f.a
        public void e() {
            com.transsion.player.orplayer.g H;
            if (this.f49028c) {
                com.transsion.player.orplayer.g H2 = a0.this.H();
                if (H2 != null) {
                    H2.seekTo(this.f49026a);
                }
                com.transsion.player.orplayer.g H3 = a0.this.H();
                if (H3 != null && !H3.isPlaying() && (H = a0.this.H()) != null) {
                    H.play();
                }
                Fragment fragment = a0.this.f49009k;
                LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
                if (localVideoDetailFragment != null) {
                    localVideoDetailFragment.z3(this.f49026a, this.f49027b);
                }
                a0.this.c3(false, 0L);
                a0.this.v1(false);
            }
            a0.this.f49016r = false;
            this.f49028c = false;
            this.f49029d = false;
            this.f49030e = false;
            a0.this.M0();
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            View b12 = a0.this.b1();
            if (b12 == null || !b12.isSelected()) {
                a0.this.d2(e11, true);
            }
        }

        @Override // com.transsion.baseui.widget.f.a
        public void onLongPress(MotionEvent e11) {
            Intrinsics.h(e11, "e");
            View b12 = a0.this.b1();
            if (b12 == null || !b12.isSelected()) {
                a0.this.L2();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements com.tn.lib.view.v {

        /* renamed from: b */
        final /* synthetic */ Ref.LongRef f49038b;

        /* renamed from: c */
        final /* synthetic */ Ref.FloatRef f49039c;

        c(Ref.LongRef longRef, Ref.FloatRef floatRef) {
            this.f49038b = longRef;
            this.f49039c = floatRef;
        }

        @Override // com.tn.lib.view.v
        public void a(SecondariesSeekBar seekBar) {
            com.transsion.player.orplayer.g H;
            Intrinsics.h(seekBar, "seekBar");
            a.C0856a c0856a = lg.a.f68962a;
            String m12 = a0.this.m1();
            Intrinsics.g(m12, "<get-TAG>(...)");
            a.C0856a.f(c0856a, m12, "onStopTrackingTouch targetProgress:" + this.f49038b.element + " ", false, 4, null);
            a0.this.f49016r = false;
            com.transsion.player.orplayer.g H2 = a0.this.H();
            if (H2 != null) {
                H2.seekTo(this.f49038b.element);
            }
            com.transsion.player.orplayer.g H3 = a0.this.H();
            if (H3 != null && !H3.isPlaying() && (H = a0.this.H()) != null) {
                H.play();
            }
            Fragment fragment = a0.this.f49009k;
            LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
            if (localVideoDetailFragment != null) {
                localVideoDetailFragment.z3(this.f49038b.element, this.f49039c.element);
            }
            a0.this.E = seekBar.getCurrentProgress();
            a0.this.c3(false, 0L);
            a0.this.v1(false);
        }

        @Override // com.tn.lib.view.v
        public void b(SecondariesSeekBar seekBar, long j11, boolean z10) {
            View g12;
            Intrinsics.h(seekBar, "seekBar");
            if (z10) {
                View g13 = a0.this.g1();
                if (g13 != null && jg.c.i(g13) && (g12 = a0.this.g1()) != null) {
                    jg.c.g(g12);
                }
                a0.this.f49016r = z10;
                a0.this.X0().removeCallbacks(a0.this.V);
                float f11 = ((float) j11) / ((float) 10000);
                if (a0.this.n1() > 0) {
                    this.f49038b.element = ((float) a0.this.n1()) * f11;
                } else {
                    this.f49039c.element = f11;
                }
                a0.this.E = this.f49038b.element;
                a0.this.c3(true, this.f49038b.element);
            }
        }

        @Override // com.tn.lib.view.v
        public void c(SecondariesSeekBar seekBar) {
            Intrinsics.h(seekBar, "seekBar");
            a.C0856a c0856a = lg.a.f68962a;
            String m12 = a0.this.m1();
            Intrinsics.g(m12, "<get-TAG>(...)");
            a.C0856a.f(c0856a, m12, "onStartTrackingTouch ", false, 4, null);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d implements SystemTimeManager.a {
        d() {
        }

        public static final void c(a0 a0Var) {
            a0Var.d3();
        }

        @Override // com.transsion.postdetail.layer.SystemTimeManager.a
        public long a() {
            FragmentActivity activity = a0.this.f49009k.getActivity();
            if (activity == null) {
                return 30000L;
            }
            final a0 a0Var = a0.this;
            activity.runOnUiThread(new Runnable() { // from class: com.transsion.postdetail.layer.local.b0
                @Override // java.lang.Runnable
                public final void run() {
                    a0.d.c(a0.this);
                }
            });
            return 30000L;
        }
    }

    /* loaded from: classes6.dex */
    public static final class e implements androidx.view.c0, FunctionAdapter {

        /* renamed from: a */
        private final /* synthetic */ Function1 f49041a;

        e(Function1 function) {
            Intrinsics.h(function, "function");
            this.f49041a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function a() {
            return this.f49041a;
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
            this.f49041a.invoke(obj);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f implements sx.a {
        f() {
        }

        @Override // sx.a
        public boolean a(px.a aVar) {
            return LocalFloatManager.f50196b.l(aVar);
        }

        @Override // sx.a
        public void b(px.a aVar) {
            LocalFloatManager.f50196b.j(aVar);
        }

        @Override // sx.a
        public void c(px.a aVar) {
            LocalFloatManager localFloatManager = LocalFloatManager.f50196b;
            localFloatManager.i();
            localFloatManager.m(aVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(final Fragment fragment) {
        super(fragment);
        Intrinsics.h(fragment, "fragment");
        this.f49008j = getClass().getSimpleName();
        this.f49009k = fragment;
        this.f49011m = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.y
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Handler t12;
                t12 = a0.t1();
                return t12;
            }
        });
        this.f49012n = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.z
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Handler R1;
                R1 = a0.R1();
                return R1;
            }
        });
        this.f49013o = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Handler N0;
                N0 = a0.N0();
                return N0;
            }
        });
        this.f49022x = "";
        this.F = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                LocalVideoDetailViewModel l32;
                l32 = a0.l3(Fragment.this);
                return l32;
            }
        });
        this.G = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsnet.downloader.manager.g L0;
                L0 = a0.L0();
                return L0;
            }
        });
        this.I = "";
        this.J = "";
        this.K = "";
        this.Q = 1;
        this.R = 8;
        this.S = 1;
        this.T = 1;
        this.U = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.layer.local.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                com.transsion.baseui.widget.f P0;
                P0 = a0.P0(Fragment.this, this);
                return P0;
            }
        });
        this.V = new Runnable() { // from class: com.transsion.postdetail.layer.local.f
            @Override // java.lang.Runnable
            public final void run() {
                a0.o2(a0.this);
            }
        };
        this.W = new String[]{".", "..", "..."};
        this.Y = new Runnable() { // from class: com.transsion.postdetail.layer.local.g
            @Override // java.lang.Runnable
            public final void run() {
                a0.S1(a0.this);
            }
        };
        this.Z = new Runnable() { // from class: com.transsion.postdetail.layer.local.h
            @Override // java.lang.Runnable
            public final void run() {
                a0.F2(a0.this);
            }
        };
    }

    private final void A1() {
        View A0 = A0();
        if (A0 != null) {
            A0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a0.F1(a0.this, view);
                }
            });
        }
        ImageView f22 = f2();
        if (f22 != null) {
            f22.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a0.G1(a0.this, view);
                }
            });
        }
        View p22 = p2();
        if (p22 != null) {
            p22.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a0.H1(a0.this, view);
                }
            });
        }
        ImageView O0 = O0();
        if (O0 != null) {
            O0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.t
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a0.B1(a0.this, view);
                }
            });
        }
        View i22 = i2();
        if (i22 != null) {
            i22.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.u
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a0.C1(a0.this, view);
                }
            });
        }
        View P1 = P1();
        if (P1 != null) {
            P1.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a0.D1(a0.this, view);
                }
            });
        }
        View j12 = j1();
        if (j12 != null) {
            j12.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.w
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    a0.E1(a0.this, view);
                }
            });
        }
    }

    public static final void B1(a0 a0Var, View view) {
        Navigator K = TheRouter.c("/profile/user_center_labels_feedback").K("feedback_from_page", "SUBJECT_PLAY").K("subject_id", a0Var.K);
        DownloadBean downloadBean = a0Var.H;
        if (downloadBean != null && downloadBean.getType() == 3) {
            K.I("TV_DATA", new FbTvData(a0Var.K, downloadBean.getSe(), downloadBean.getEp()));
        }
        Navigator.x(K, a0Var.f49009k.getContext(), null, 2, null);
    }

    public static /* synthetic */ void B2(a0 a0Var, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showBottomController");
        }
        if ((i11 & 1) != 0) {
            z10 = true;
        }
        a0Var.A2(z10);
    }

    public static final void C1(a0 a0Var, View view) {
        hj.i.f64628a.p("local_video_detail", a0Var.h1());
        a0Var.j2();
    }

    private final void C2(int i11) {
        com.transsion.player.orplayer.g H;
        if (this.B == null) {
            ViewStub m32 = m3();
            this.B = m32 != null ? m32.inflate() : null;
        }
        View view = this.C;
        if (view != null) {
            jg.c.g(view);
        }
        if (a3() == LocalUiType.MIDDLE) {
            u2(false);
        }
        if (isVisible() && (H = H()) != null) {
            H.pause();
        }
        View view2 = this.B;
        if (view2 != null) {
            jg.c.k(view2);
        }
        View view3 = this.B;
        if (view3 != null) {
            view3.setTag(Integer.valueOf(i11));
        }
        View view4 = this.B;
        if (view4 != null) {
            ((TextView) view4.findViewById(R$id.tv_fail_left_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    a0.D2(a0.this, view5);
                }
            });
            ((TextView) view4.findViewById(R$id.tv_fail_right_btn)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    a0.E2(a0.this, view5);
                }
            });
        }
    }

    public static final void D1(a0 a0Var, View view) {
        a0Var.e(FloatActionType.ICON);
    }

    public static final void D2(a0 a0Var, View view) {
        a0Var.c2();
    }

    public static final void E1(a0 a0Var, View view) {
        a0Var.Y1();
    }

    public static final void E2(a0 a0Var, View view) {
        lg.a.f68962a.x("long_video_play", "video error，reload~~ from errorLayout click", true);
        Fragment fragment = a0Var.f49009k;
        LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.r3(true);
        }
    }

    public static final void F1(a0 a0Var, View view) {
        a0Var.V1();
    }

    public static final void F2(a0 a0Var) {
        a0Var.f49022x = "";
        a0Var.C2(0);
        a0Var.f49023y = true;
        a0Var.v1(true);
        Group Z2 = a0Var.Z2();
        if (Z2 != null) {
            Z2.setVisibility(0);
        }
        a0Var.w1(true);
    }

    public static final void G1(a0 a0Var, View view) {
        Fragment fragment = a0Var.f49009k;
        Intrinsics.f(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        bo.c cVar = bo.c.f16723a;
        hj.b logViewConfig = ((LocalVideoDetailFragment) fragment).getLogViewConfig();
        String f11 = logViewConfig != null ? logViewConfig.f() : null;
        String str = a0Var.K;
        DownloadBean downloadBean = a0Var.H;
        cVar.a(f11, str, downloadBean != null ? downloadBean.getOps() : null, false);
        e2(a0Var, null, false, 3, null);
    }

    public static final Unit G2(a0 a0Var, boolean z10) {
        if (z10) {
            vo.b bVar = a0Var.f49018t;
            if (bVar != null) {
                bVar.c(a0Var.H);
            }
            FragmentActivity activity = a0Var.f49009k.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
        return Unit.f67184a;
    }

    public static final void H1(a0 a0Var, View view) {
        a0Var.Y1();
    }

    private final void H2() {
        vo.b bVar;
        View view = this.B;
        if (view == null || view.getVisibility() != 0) {
            if (a3() == LocalUiType.MIDDLE) {
                v1(true);
            } else {
                A2(false);
            }
            u2(false);
            j1 j1Var = this.f49021w;
            if (j1Var != null) {
                j1Var.d();
            }
            if (isVisible() && (bVar = this.f49018t) != null) {
                bVar.d(this.H);
            }
            if (this.C == null) {
                ViewStub n32 = n3();
                this.C = n32 != null ? n32.inflate() : null;
            }
            View view2 = this.C;
            if (view2 != null) {
                jg.c.k(view2);
            }
            View view3 = this.C;
            if (view3 != null) {
                Z1();
                ((TextView) view3.findViewById(R$id.tv_replay)).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.layer.local.r
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        a0.I2(a0.this, view4);
                    }
                });
            }
        }
    }

    private final void I1() {
        this.f49021w = new j1(X2(), Y2());
    }

    public static final void I2(a0 a0Var, View view) {
        a0Var.i3();
    }

    private final void J0() {
        ViewGroup D0;
        boolean u12 = u1();
        View i22 = i2();
        if (i22 != null) {
            i22.setVisibility(u12 ? 0 : 8);
        }
        if (u12 && (D0 = D0()) != null && D0.getVisibility() == 0) {
            hj.i.f64628a.D("local_video_detail", h1());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("vis = ");
        sb2.append(u12);
    }

    private final void J1() {
        Ref.LongRef longRef = new Ref.LongRef();
        Ref.FloatRef floatRef = new Ref.FloatRef();
        SecondariesSeekBar q22 = q2();
        if (q22 != null) {
            q22.setMax(10000L);
        }
        SecondariesSeekBar q23 = q2();
        if (q23 != null) {
            q23.setOnSeekBarChangeListener(new c(longRef, floatRef));
        }
    }

    public static final Unit K1(a0 a0Var, List list) {
        if (list == null || list.isEmpty()) {
            return Unit.f67184a;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = a0Var.f49008j;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "2--fragment, on get series from local, size = " + list.size() + ", uiType = " + a0Var.a3(), false, 4, null);
        a0Var.J0();
        return Unit.f67184a;
    }

    private final void K2() {
        M2();
        a1().post(this.Y);
    }

    public static final com.transsnet.downloader.manager.g L0() {
        return com.transsnet.downloader.manager.p.f59623a.a(Utils.a());
    }

    private final void L1() {
        this.f49017s = new SystemTimeManager(new d());
    }

    private final void M2() {
        a1().removeCallbacks(this.Y);
    }

    public static final Handler N0() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        return new Handler(myLooper);
    }

    private final boolean N1() {
        Fragment fragment = this.f49009k;
        Intrinsics.f(fragment, "null cannot be cast to non-null type com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment");
        return ((LocalVideoDetailFragment) fragment).getIsAdShowing();
    }

    public static final com.transsion.baseui.widget.f P0(Fragment fragment, a0 a0Var) {
        return new com.transsion.baseui.widget.f(fragment.requireContext(), a0Var.Q0());
    }

    private final void Q1() {
        a1().postDelayed(this.Y, 1000L);
    }

    private final Intent R0() {
        Intent intent = new Intent();
        intent.putExtra("path", "/video/detail");
        intent.putExtra("id", this.K);
        return intent;
    }

    public static final Handler R1() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        return new Handler(myLooper);
    }

    public static final void S1(a0 a0Var) {
        int i11 = a0Var.X;
        boolean z10 = false;
        if (i11 >= 2) {
            a0Var.X = 0;
        } else {
            a0Var.X = i11 + 1;
        }
        TextView H0 = a0Var.H0();
        if (H0 != null) {
            H0.setText(Utils.a().getString(R$string.play_loading) + a0Var.W[a0Var.X]);
        }
        if (a0Var.H != null) {
            com.transsnet.downloader.manager.g T0 = a0Var.T0();
            DownloadBean downloadBean = a0Var.H;
            Intrinsics.e(downloadBean);
            z10 = T0.A(downloadBean);
        }
        if (a0Var.f49022x.length() > 0 && !z10) {
            a0Var.f49022x = "";
        }
        TextView G0 = a0Var.G0();
        if (G0 != null) {
            String str = a0Var.f49022x;
            G0.setText(str.length() != 0 ? str : "");
        }
        a0Var.Q1();
    }

    private final Handler U0() {
        return (Handler) this.f49013o.getValue();
    }

    public static final void U1(a0 a0Var) {
        try {
            Result.Companion companion = Result.INSTANCE;
            com.transsion.player.orplayer.g H = a0Var.H();
            if (H != null && H.isPlaying()) {
                a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", "onAdClick resume auto pip", false, 4, null);
                a0Var.b3(true);
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    private final px.a V0() {
        DownloadBean downloadBean = this.H;
        px.a aVar = null;
        if (downloadBean == null) {
            return null;
        }
        if (I() != null && H() != null) {
            a.C0856a c0856a = lg.a.f68962a;
            c0856a.c("VideoFloat", "local--showFloat, name:" + downloadBean.getTotalTitleName(), true);
            ArrayList arrayList = new ArrayList();
            if (downloadBean.isSeries()) {
                List list = (List) o1().i().f();
                if (list == null) {
                    list = new ArrayList();
                }
                Iterator it = list.iterator();
                int i11 = 0;
                int i12 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i12 = -1;
                        break;
                    }
                    if (Intrinsics.c(((DownloadBean) it.next()).getResourceId(), downloadBean.getResourceId())) {
                        break;
                    }
                    i12++;
                }
                lg.a.f68962a.c("VideoFloat", "local--showFloat, 电视剧:" + i12, true);
                if (i12 >= 0) {
                    arrayList.addAll(list);
                } else {
                    List list2 = list;
                    int size = list2.size();
                    int i13 = 0;
                    while (i11 < size && ((DownloadBean) list.get(i11)).getEp() < downloadBean.getEp()) {
                        i13 = i11 + 1;
                        i11 = i13;
                    }
                    arrayList.addAll(list2);
                    if (list.size() <= i13) {
                        arrayList.add(downloadBean);
                    } else {
                        arrayList.add(i13, downloadBean);
                    }
                }
            } else {
                c0856a.c("VideoFloat", "local--showFloat, 电影", true);
                arrayList.add(downloadBean);
            }
            LocalFloatManager.f50196b.p(arrayList);
            ORPlayerView I = I();
            Intrinsics.e(I);
            com.transsion.player.orplayer.g H = H();
            Intrinsics.e(H);
            ViewGroup U2 = U2();
            Intrinsics.e(U2);
            FloatPlayType floatPlayType = FloatPlayType.LOCAL;
            String subjectId = downloadBean.getSubjectId();
            if (subjectId == null) {
                subjectId = "";
            }
            aVar = new px.a(I, H, U2, floatPlayType, subjectId, downloadBean.getSe(), downloadBean.getEp(), "", "local_video_detail");
            aVar.G(downloadBean.getResourceId());
            aVar.J(Integer.valueOf(downloadBean.getSubjectType()));
            aVar.C(com.transsion.postdetail.util.u.b(aVar.b()));
            aVar.A(downloadBean.getOps());
            aVar.E(downloadBean.getPostId());
            aVar.B(downloadBean.getPageFrom());
        }
        return aVar;
    }

    public final Handler X0() {
        return (Handler) this.f49011m.getValue();
    }

    private final void X1(long j11) {
        List list;
        long j12 = this.f49010l;
        if (j12 <= 0 || j12 - j11 >= 5000) {
            return;
        }
        List list2 = (List) o1().i().f();
        if (!this.L || (list = list2) == null || list.isEmpty() || this.N) {
            return;
        }
        this.N = true;
        int size = list.size();
        boolean z10 = false;
        for (int i11 = 0; i11 < size; i11++) {
            DownloadBean downloadBean = (DownloadBean) list2.get(i11);
            String resourceId = downloadBean.getResourceId();
            DownloadBean downloadBean2 = this.H;
            if (Intrinsics.c(resourceId, downloadBean2 != null ? downloadBean2.getResourceId() : null)) {
                z10 = true;
            } else if (z10) {
                l2(downloadBean);
                return;
            }
        }
    }

    private final Intent Z0() {
        IPushProvider iPushProvider = (IPushProvider) TheRouter.d(IPushProvider.class, new Object[0]);
        DownloadBean downloadBean = this.H;
        boolean isCompleted = downloadBean != null ? downloadBean.isCompleted() : false;
        StringBuilder sb2 = new StringBuilder("oneroom://com.community.oneroom?type=");
        sb2.append("/video/detail");
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_resource_id");
        sb2.append(UrlUtils.EQUAL_MARK);
        DownloadBean downloadBean2 = this.H;
        sb2.append(downloadBean2 != null ? downloadBean2.getResourceId() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_local_path");
        sb2.append(UrlUtils.EQUAL_MARK);
        DownloadBean downloadBean3 = this.H;
        sb2.append(downloadBean3 != null ? downloadBean3.getPath() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_url");
        sb2.append(UrlUtils.EQUAL_MARK);
        DownloadBean downloadBean4 = this.H;
        sb2.append(downloadBean4 != null ? downloadBean4.getUrl() : null);
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_page_from");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append("media_notification");
        sb2.append("&channel=media_notification");
        sb2.append(UrlUtils.AND_MARK);
        sb2.append("extra_completed");
        sb2.append(UrlUtils.EQUAL_MARK);
        sb2.append(isCompleted);
        if (iPushProvider == null) {
            return null;
        }
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        Intent a12 = iPushProvider.a(a11);
        if (a12 == null) {
            return null;
        }
        a12.addFlags(603979776);
        a12.setData(Uri.parse(sb2.toString()));
        return a12;
    }

    private final Handler a1() {
        return (Handler) this.f49012n.getValue();
    }

    private final MediaItem c1() {
        DownloadBean downloadBean = this.H;
        String totalTitleName = downloadBean != null ? downloadBean.getTotalTitleName() : null;
        DownloadBean downloadBean2 = this.H;
        String subjectId = downloadBean2 != null ? downloadBean2.getSubjectId() : null;
        DownloadBean downloadBean3 = this.H;
        String cover = downloadBean3 != null ? downloadBean3.getCover() : null;
        DownloadBean downloadBean4 = this.H;
        String resourceId = downloadBean4 != null ? downloadBean4.getResourceId() : null;
        PendingIntent d12 = d1();
        Intent R0 = R0();
        DownloadBean downloadBean5 = this.H;
        boolean z10 = false;
        if (downloadBean5 != null && downloadBean5.getType() == 6) {
            z10 = true;
        }
        return new MediaItem(totalTitleName, "", cover, null, null, null, d12, R0, subjectId, resourceId, Boolean.valueOf(z10), null, null, null, 14392, null);
    }

    private final void c2() {
        Utils.a().startActivity(new Intent("android.settings.WIFI_SETTINGS").setFlags(ASTNode.DEOP));
    }

    public final void c3(boolean z10, long j11) {
        this.A = z10;
        View view = this.B;
        if (view == null || view.getVisibility() != 0) {
            if (!z10) {
                VideoSubtitleControl videoSubtitleControl = this.f49019u;
                if (videoSubtitleControl != null) {
                    videoSubtitleControl.U();
                }
                TextView I0 = I0();
                if (I0 != null) {
                    I0.setVisibility(8);
                }
                View F0 = F0();
                if (F0 != null) {
                    F0.setVisibility(this.f49024z ? 0 : 8);
                    return;
                }
                return;
            }
            TextView I02 = I0();
            if (I02 != null) {
                I02.setVisibility(0);
            }
            TextView I03 = I0();
            if (I03 != null) {
                FragmentActivity activity = this.f49009k.getActivity();
                I03.setText(Html.fromHtml(activity != null ? activity.getString(R$string.post_progress_tx_style, com.transsion.postdetail.util.n.d(j11), com.transsion.postdetail.util.n.d(this.f49010l)) : null));
            }
            VideoSubtitleControl videoSubtitleControl2 = this.f49019u;
            if (videoSubtitleControl2 != null) {
                videoSubtitleControl2.s0(j11);
            }
            View F02 = F0();
            if (F02 != null) {
                F02.setVisibility(8);
            }
        }
    }

    private final PendingIntent d1() {
        return PendingIntent.getActivity(Utils.a(), 0, Z0(), f1());
    }

    public final void d3() {
        TextView h22 = h2();
        if (h22 != null) {
            h22.setText(com.transsion.postdetail.util.u.d());
        }
    }

    public static /* synthetic */ void e2(a0 a0Var, MotionEvent motionEvent, boolean z10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: pause");
        }
        if ((i11 & 1) != 0) {
            motionEvent = null;
        }
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        a0Var.d2(motionEvent, z10);
    }

    private final void e3(long j11) {
        SecondariesSeekBar q22;
        VideoSubtitleControl videoSubtitleControl = this.f49019u;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.s0(j11);
        }
        if (this.f49010l <= 0) {
            com.transsion.player.orplayer.g H = H();
            if (H == null) {
                return;
            } else {
                this.f49010l = H.getDuration();
            }
        }
        if (!this.f49016r) {
            long j12 = this.f49010l;
            if (j12 > 0) {
                long j13 = (int) ((((float) j11) / ((float) j12)) * ((float) 10000));
                if (j13 >= this.E && (q22 = q2()) != null) {
                    q22.setProgress(j13);
                }
            }
        }
        f3(j11, this.f49010l);
    }

    private final int f1() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    private final void f3(long j11, long j12) {
        TextView h32 = h3();
        if (h32 != null) {
            h32.setText(com.transsion.postdetail.util.n.d(this.f49010l));
            TextView k32 = k3();
            if (k32 != null) {
                k32.setText(com.transsion.postdetail.util.n.d(j11));
                return;
            }
            return;
        }
        String str = com.transsion.postdetail.util.n.d(j11) + "/" + com.transsion.postdetail.util.n.d(j12);
        TextView k33 = k3();
        if (k33 != null) {
            k33.setText(str);
        }
    }

    private final void g3() {
        String str;
        String subjectName;
        DownloadBean downloadBean;
        String subjectName2;
        DownloadBean downloadBean2 = this.H;
        boolean z10 = false;
        if (downloadBean2 == null || !downloadBean2.isSeries() || (downloadBean = this.H) == null || (subjectName2 = downloadBean.getSubjectName()) == null || subjectName2.length() <= 0) {
            DownloadBean downloadBean3 = this.H;
            if ((downloadBean3 != null ? downloadBean3.getResolution() : 0) > 0) {
                DownloadBean downloadBean4 = this.H;
                if (downloadBean4 != null && (subjectName = downloadBean4.getSubjectName()) != null) {
                    if (subjectName.length() > 0) {
                        z10 = true;
                    }
                }
                if (z10) {
                    DownloadBean downloadBean5 = this.H;
                    Integer valueOf = downloadBean5 != null ? Integer.valueOf(downloadBean5.getResolution()) : null;
                    DownloadBean downloadBean6 = this.H;
                    str = valueOf + "P " + (downloadBean6 != null ? downloadBean6.getSubjectName() : null);
                }
            }
            DownloadBean downloadBean7 = this.H;
            if (downloadBean7 == null || (str = downloadBean7.getName()) == null) {
                str = "";
            }
        } else {
            DownloadBean downloadBean8 = this.H;
            String subjectName3 = downloadBean8 != null ? downloadBean8.getSubjectName() : null;
            DownloadBean downloadBean9 = this.H;
            str = subjectName3 + " " + (downloadBean9 != null ? DownloadBean.getEpTitleName$default(downloadBean9, false, 1, null) : null);
        }
        updateTitle(str);
    }

    private final Map h1() {
        Pair pair = new Pair("module_name", "play_next");
        Pair pair2 = new Pair("subject_id", this.K);
        DownloadBean downloadBean = this.H;
        return MapsKt.l(pair, pair2, new Pair("ops", downloadBean != null ? downloadBean.getOps() : null), new Pair("resource_id", this.J));
    }

    private final boolean j2() {
        if (this.O) {
            return true;
        }
        List list = (List) o1().i().f();
        if (list != null && this.L) {
            List list2 = list;
            if (!list2.isEmpty()) {
                int size = list2.size();
                boolean z10 = false;
                for (int i11 = 0; i11 < size; i11++) {
                    DownloadBean downloadBean = (DownloadBean) list.get(i11);
                    String resourceId = downloadBean.getResourceId();
                    DownloadBean downloadBean2 = this.H;
                    if (Intrinsics.c(resourceId, downloadBean2 != null ? downloadBean2.getResourceId() : null)) {
                        z10 = true;
                    } else if (z10 && downloadBean.getCanPlay()) {
                        if (downloadBean.isCompleted() && !downloadBean.isFileExist()) {
                            return false;
                        }
                        r2(downloadBean, false);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private final void l2(DownloadBean downloadBean) {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f49008j;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "onPlayProgress next tips name = " + downloadBean.getName() + ", epse = " + downloadBean.getEpse() + ", status = " + downloadBean.getStatus() + " ", false, 4, null);
        if (downloadBean.getCanPlay()) {
            DownloadBean downloadBean2 = this.H;
            if (downloadBean2 != null && downloadBean2.getStatus() == 5 && downloadBean.getStatus() != 5) {
                T0().k(downloadBean);
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.f67412a;
            String string = Utils.a().getString(R$string.series_next_play_tips);
            Intrinsics.g(string, "getString(...)");
            String subjectName = downloadBean.getSubjectName();
            if (subjectName == null) {
                subjectName = "";
            }
            String format = String.format(string, Arrays.copyOf(new Object[]{subjectName, downloadBean.getEp() > 0 ? com.transsion.baseui.util.n.b(downloadBean.getEp(), downloadBean.getSe(), true) : com.transsion.baseui.util.n.c(downloadBean.getEpse(), true)}, 2));
            Intrinsics.g(format, "format(...)");
            i(format, 3000L);
        }
    }

    public static final LocalVideoDetailViewModel l3(Fragment fragment) {
        FragmentActivity requireActivity = fragment.requireActivity();
        Intrinsics.g(requireActivity, "requireActivity(...)");
        return (LocalVideoDetailViewModel) new androidx.view.v0(requireActivity, new v0.d()).a(LocalVideoDetailViewModel.class);
    }

    private final void m2(ORPlayerView oRPlayerView) {
        ViewParent parent = oRPlayerView.getParent();
        if (parent instanceof FrameLayout) {
            ((FrameLayout) parent).removeView(oRPlayerView);
        }
    }

    public static final void o2(a0 a0Var) {
        a0Var.x1();
    }

    public static final Handler t1() {
        Looper myLooper = Looper.myLooper();
        Intrinsics.e(myLooper);
        return new Handler(myLooper);
    }

    private final boolean u1() {
        List list = (List) o1().i().f();
        if (list != null && this.L) {
            List list2 = list;
            if (!list2.isEmpty()) {
                int size = list2.size();
                boolean z10 = false;
                for (int i11 = 0; i11 < size; i11++) {
                    DownloadBean downloadBean = (DownloadBean) list.get(i11);
                    String resourceId = downloadBean.getResourceId();
                    DownloadBean downloadBean2 = this.H;
                    if (Intrinsics.c(resourceId, downloadBean2 != null ? downloadBean2.getResourceId() : null)) {
                        z10 = true;
                    } else if (z10 && downloadBean.getCanPlay()) {
                        return !downloadBean.isCompleted() || downloadBean.isFileExist();
                    }
                }
            }
        }
        return false;
    }

    private final void w1(boolean z10) {
        if (!z10) {
            FrameLayout j32 = j3();
            if (j32 != null) {
                jg.c.k(j32);
                return;
            }
            return;
        }
        SimpleSubtitleView S2 = S2();
        if (S2 != null) {
            jg.c.h(S2);
        }
        FrameLayout j33 = j3();
        if (j33 != null) {
            jg.c.g(j33);
        }
        J2(false);
    }

    public static final Unit w2(a0 a0Var, boolean z10) {
        ProgressBar P2 = a0Var.P2();
        if (P2 != null) {
            P2.setVisibility(z10 ? 0 : 8);
        }
        ImageView O2 = a0Var.O2();
        if (O2 != null) {
            O2.setVisibility(z10 ? 8 : 0);
        }
        TextView Q2 = a0Var.Q2();
        if (Q2 != null) {
            Q2.setText(Utils.a().getString(z10 ? R$string.play_loading : R$string.turn_on_short));
        }
        return Unit.f67184a;
    }

    private final void x1() {
        Group Z2;
        ViewGroup D0;
        if (!C0() && (D0 = D0()) != null) {
            D0.setVisibility(8);
        }
        if (!this.f49023y && (Z2 = Z2()) != null) {
            Z2.setVisibility(8);
        }
        View A0 = A0();
        if (A0 != null) {
            A0.setVisibility(8);
        }
        ViewGroup E0 = E0();
        if (E0 != null) {
            E0.setVisibility(8);
        }
        ViewGroup g22 = g2();
        if (g22 != null) {
            g22.setVisibility(8);
        }
        View r12 = r1();
        if (r12 != null) {
            r12.setVisibility(8);
        }
        View q12 = q1();
        if (q12 != null) {
            q12.setVisibility(8);
        }
        View b12 = b1();
        if (b12 != null) {
            b12.setVisibility(8);
        }
    }

    public static final Unit x2(a0 a0Var, View switchView, boolean z10) {
        Intrinsics.h(switchView, "switchView");
        a0Var.b2(switchView, z10);
        return Unit.f67184a;
    }

    public static final Unit y1(a0 a0Var, Subject subject) {
        a0Var.B0(subject);
        return Unit.f67184a;
    }

    public static final Unit y2(a0 a0Var, View settingView) {
        Intrinsics.h(settingView, "settingView");
        a0Var.a2(settingView);
        return Unit.f67184a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003e, code lost:
    
        if (r3 != 3) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void z1() {
        /*
            r6 = this;
            eo.n$a r0 = eo.n.f62093a
            androidx.fragment.app.Fragment r1 = r6.f49009k
            android.content.Context r1 = r1.requireContext()
            java.lang.String r2 = "requireContext(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r2)
            androidx.constraintlayout.widget.ConstraintLayout r2 = r6.n2()
            eo.n r0 = r0.a(r1, r2)
            r6.f49020v = r0
            if (r0 != 0) goto L1f
            java.lang.String r0 = "volumeControl"
            kotlin.jvm.internal.Intrinsics.z(r0)
            r0 = 0
        L1f:
            r0.g()
            boolean r0 = jg.c.f()
            int r1 = com.blankj.utilcode.util.y.c()
            int r2 = com.blankj.utilcode.util.y.e()
            com.transsion.postdetail.layer.local.LocalUiType r3 = r6.a3()
            int[] r4 = com.transsion.postdetail.layer.local.a0.a.f49025a
            int r3 = r3.ordinal()
            r3 = r4[r3]
            r4 = 1
            if (r3 == r4) goto L45
            r4 = 3
            if (r3 == r4) goto L41
            goto L4a
        L41:
            r5 = r2
            r2 = r1
            r1 = r5
            goto L4a
        L45:
            int r1 = r2 * 9
            int r1 = r1 / 16
            goto L41
        L4a:
            com.transsion.baseui.widget.f r3 = r6.W0()
            com.transsion.postdetail.layer.local.a0$b r4 = new com.transsion.postdetail.layer.local.a0$b
            r4.<init>(r0, r1, r2)
            r3.s(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.layer.local.a0.z1():void");
    }

    @Override // vo.d
    public void A(VideoSubtitleControl control) {
        Intrinsics.h(control, "control");
        this.f49019u = control;
        control.b0(com.transsion.postdetail.util.u.c(a3()), R2(), V2(), T2(), N2(), true);
        control.k0(new Function1() { // from class: com.transsion.postdetail.layer.local.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit w22;
                w22 = a0.w2(a0.this, ((Boolean) obj).booleanValue());
                return w22;
            }
        });
        control.F(com.transsion.postdetail.util.u.c(a3()), new Function2() { // from class: com.transsion.postdetail.layer.local.o
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                Unit x22;
                x22 = a0.x2(a0.this, (View) obj, ((Boolean) obj2).booleanValue());
                return x22;
            }
        }, new Function1() { // from class: com.transsion.postdetail.layer.local.p
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y22;
                y22 = a0.y2(a0.this, (View) obj);
                return y22;
            }
        });
    }

    public abstract View A0();

    public void A2(boolean z10) {
        View findViewById;
        if (this.f49023y || this.P || !com.blankj.utilcode.util.c.l()) {
            return;
        }
        View b12 = b1();
        if (b12 != null) {
            if (b12.isSelected()) {
                b12.setVisibility(b12.getVisibility() == 0 ? 8 : 0);
                return;
            }
            b12.setVisibility(0);
        }
        X0().removeCallbacks(this.V);
        if (z10) {
            v1(false);
        }
        ViewGroup D0 = D0();
        if (D0 != null) {
            D0.setVisibility(0);
        }
        Group Z2 = Z2();
        if (Z2 != null) {
            Z2.setVisibility(0);
        }
        ViewGroup g22 = g2();
        if (g22 != null) {
            g22.setVisibility(0);
        }
        View r12 = r1();
        if (r12 != null) {
            r12.setVisibility(0);
        }
        View A0 = A0();
        if (A0 != null) {
            A0.setVisibility(0);
        }
        View q12 = q1();
        if (q12 != null) {
            q12.setVisibility(0);
        }
        ViewGroup E0 = E0();
        if (E0 != null) {
            E0.setVisibility(0);
        }
        ConstraintLayout n22 = n2();
        if (n22 == null || (findViewById = n22.findViewById(R.id.message)) == null) {
            return;
        }
        findViewById.setVisibility(8);
    }

    @Override // vo.d
    public void B(int i11) {
        d.a.n(this, i11);
    }

    public void B0(Subject subject) {
    }

    @Override // vo.d
    public void C(vo.c event) {
        Intrinsics.h(event, "event");
        this.M = event;
    }

    public abstract boolean C0();

    @Override // vo.d
    public void D(vo.b event) {
        Intrinsics.h(event, "event");
        this.f49018t = event;
    }

    public abstract ViewGroup D0();

    public void E(DownloadBean downloadBean) {
        d.a.c(this, downloadBean);
    }

    public abstract ViewGroup E0();

    public abstract View F0();

    public abstract TextView G0();

    public abstract TextView H0();

    public abstract TextView I0();

    public void J2(boolean z10) {
        View F0;
        if (this.f49024z == z10) {
            return;
        }
        this.f49024z = z10;
        if (z10) {
            if (!this.A && (F0 = F0()) != null) {
                F0.setVisibility(0);
            }
            K2();
            return;
        }
        M2();
        View F02 = F0();
        if (F02 != null) {
            F02.setVisibility(8);
        }
    }

    public final void K0() {
        if (j2()) {
            return;
        }
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f49008j;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "onCompletion, showReplay", false, 4, null);
        H2();
    }

    public final void L2() {
        com.transsion.player.orplayer.g H = H();
        if (H == null || H.isPlaying()) {
            this.f49007a0 = SystemClock.elapsedRealtime();
            this.D = com.transsion.baselib.helper.d.f43319a.d();
            com.transsion.player.orplayer.g H2 = H();
            if (H2 != null) {
                H2.setSpeed(this.D * 2.0f);
            }
            x1();
            v1(true);
            View k22 = k2();
            if (k22 != null) {
                jg.c.k(k22);
            }
            String str = this.K;
            DownloadBean downloadBean = this.H;
            ak.p.a("local_video_detail", str, downloadBean != null ? downloadBean.getOps() : null, Float.valueOf(this.D));
        }
    }

    @Override // com.transsion.postdetail.layer.BaseLayer
    public void M(com.transsion.player.orplayer.g orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.h(orPlayer, "orPlayer");
        Intrinsics.h(orPlayerView, "orPlayerView");
        super.M(orPlayer, orPlayerView);
        eo.n nVar = this.f49020v;
        if (nVar == null) {
            Intrinsics.z("volumeControl");
            nVar = null;
        }
        nVar.e(orPlayer);
    }

    public final void M0() {
        if (this.D > 0.0f) {
            com.transsion.player.orplayer.g H = H();
            if (H != null) {
                H.setSpeed(this.D);
            }
            View k22 = k2();
            if (k22 != null) {
                jg.c.g(k22);
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.f49007a0;
            String str = this.K;
            DownloadBean downloadBean = this.H;
            ak.p.b("local_video_detail", elapsedRealtime, str, downloadBean != null ? downloadBean.getOps() : null, Float.valueOf(this.D));
            this.D = 0.0f;
        }
    }

    public boolean M1() {
        return false;
    }

    public abstract ViewGroup N2();

    public abstract ImageView O0();

    protected final boolean O1() {
        Function0 p11;
        DownloadBean downloadBean = this.H;
        return (downloadBean == null || !downloadBean.isMusic()) && (p11 = ko.l0.f67091a.p()) != null && ((Boolean) p11.invoke()).booleanValue();
    }

    public abstract ImageView O2();

    public abstract View P1();

    public abstract ProgressBar P2();

    public abstract View Q0();

    public abstract TextView Q2();

    public abstract TextView R2();

    public final DownloadBean S0() {
        return this.H;
    }

    public abstract SimpleSubtitleView S2();

    public final com.transsnet.downloader.manager.g T0() {
        return (com.transsnet.downloader.manager.g) this.G.getValue();
    }

    public final void T1(boolean z10) {
        ConstraintLayout n22;
        ConstraintLayout n23 = n2();
        if (n23 != null) {
            n23.setVisibility(z10 ? 0 : 8);
        }
        if (!z10 || (n22 = n2()) == null) {
            return;
        }
        n22.setFocusableInTouchMode(true);
        n22.requestFocus();
    }

    public abstract SimpleSubtitleView T2();

    public abstract ViewGroup U2();

    public abstract void V1();

    public abstract SimpleSubtitleView V2();

    public final com.transsion.baseui.widget.f W0() {
        return (com.transsion.baseui.widget.f) this.U.getValue();
    }

    public void W1(boolean z10) {
    }

    public abstract TextView W2();

    public abstract TextView X2();

    public final int Y0() {
        return this.f49015q;
    }

    public void Y1() {
        FragmentActivity activity;
        int i11;
        com.transsion.player.orplayer.g H;
        View view;
        com.transsion.player.orplayer.g H2 = H();
        if (H2 != null && !H2.isPlaying() && (H = H()) != null && !H.isComplete() && !N1()) {
            com.transsion.player.orplayer.g H3 = H();
            if (H3 != null) {
                H3.play();
            }
            View view2 = this.C;
            if (view2 != null && jg.c.i(view2) && (view = this.C) != null) {
                jg.c.g(view);
            }
        }
        com.transsion.player.orplayer.g H4 = H();
        if (H4 != null) {
            H4.setScaleMode(com.transsion.baselib.helper.d.f43319a.c());
        }
        int i12 = this.f49014p;
        LocalUiType localUiType = (i12 <= 0 || (i11 = this.f49015q) <= 0 || i11 <= i12) ? LocalUiType.LAND : LocalUiType.PORTRAIT;
        if (localUiType == LocalUiType.LAND && (activity = this.f49009k.getActivity()) != null) {
            activity.setRequestedOrientation(6);
        }
        ox.c.f72319a.a();
        F(LayerFlag.LOCAL_UI_CHANGED, localUiType);
    }

    public abstract TextView Y2();

    public void Z1() {
    }

    public abstract Group Z2();

    public void a(LocalUiType uiType) {
        vo.b bVar;
        Intrinsics.h(uiType, "uiType");
        if (!isVisible() || (bVar = this.f49018t) == null) {
            return;
        }
        bVar.a(uiType);
    }

    public void a2(View view) {
        Intrinsics.h(view, "view");
    }

    public abstract LocalUiType a3();

    @Override // vo.d
    public void b(boolean z10, boolean z11) {
        if (z10) {
            A2(z11);
        } else {
            v1(z11);
        }
    }

    public View b1() {
        return d.a.a(this);
    }

    public void b2(View view, boolean z10) {
        Intrinsics.h(view, "view");
        A2(true);
        String string = Utils.a().getString(z10 ? com.transsion.subtitle.R$string.subtitle_turn_on_toast : com.transsion.subtitle.R$string.subtitle_turn_off_toast);
        Intrinsics.g(string, "getString(...)");
        d.a.l(this, string, 0L, 2, null);
    }

    public void b3(boolean z10) {
        try {
            Result.Companion companion = Result.INSTANCE;
            FragmentActivity activity = this.f49009k.getActivity();
            if (activity == null || activity.isDestroyed() || activity.isFinishing() || !com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_pip_enable", true)) {
                return;
            }
            ox.e b11 = ox.e.f72320a.b();
            ORPlayerView I = I();
            ViewParent parent = I != null ? I.getParent() : null;
            Result.m1185constructorimpl(b11.a(activity, false, z10, parent instanceof ViewGroup ? (ViewGroup) parent : null));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public void c() {
        DownloadBean downloadBean = this.H;
        if (downloadBean != null) {
            downloadBean.setPlaying(false);
        }
        SystemTimeManager systemTimeManager = this.f49017s;
        if (systemTimeManager != null) {
            systemTimeManager.c();
        }
        X0().removeCallbacksAndMessages(null);
        a1().removeCallbacksAndMessages(null);
        U0().removeCallbacksAndMessages(null);
        com.transsion.ad.strategy.b.f42281a.m(this);
        com.transsion.baselib.report.l.f43413a.u(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void canNonSubscriberPlay(boolean z10, int i11, int i12, mo.d dVar) {
        f.a.a(this, z10, i11, i12, dVar);
    }

    @Override // vo.d
    public void d() {
        d.a.i(this);
    }

    protected final void d2(MotionEvent motionEvent, boolean z10) {
        com.transsion.baseui.util.c cVar = com.transsion.baseui.util.c.f43558a;
        ImageView f22 = f2();
        if (cVar.a(f22 != null ? f22.getId() : 9527, 500L)) {
            return;
        }
        View view = this.B;
        if (view != null && view.getVisibility() == 0) {
            View view2 = this.B;
            if (!(view2 != null ? Intrinsics.c(view2.getTag(), 1) : false)) {
                if (nh.m.f70597a.e()) {
                    return;
                }
                com.tn.lib.widget.toast.core.h.f41533a.k(com.transsion.baseui.R$string.base_network_fail);
                return;
            } else {
                lg.a.f68962a.x("long_video_play", "video error，reload~~ from errorLayout", true);
                Fragment fragment = this.f49009k;
                LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
                if (localVideoDetailFragment != null) {
                    LocalVideoDetailFragment.s3(localVideoDetailFragment, false, 1, null);
                    return;
                }
                return;
            }
        }
        com.transsion.player.orplayer.g H = H();
        if (H != null && H.isComplete()) {
            if (M1()) {
                return;
            }
            i3();
            return;
        }
        com.transsion.player.orplayer.g H2 = H();
        if (H2 != null && H2.isPlaying()) {
            s1(motionEvent, z10);
            return;
        }
        P(false);
        u2(true);
        ox.c.f72319a.a();
        com.transsion.player.orplayer.g H3 = H();
        if (H3 != null) {
            H3.play();
        }
    }

    @Override // vo.d
    public boolean e(FloatActionType actionType) {
        FragmentActivity activity;
        Intrinsics.h(actionType, "actionType");
        DownloadBean downloadBean = this.H;
        if ((downloadBean == null || !downloadBean.isMusic()) && (activity = this.f49009k.getActivity()) != null && !activity.isDestroyed() && !activity.isFinishing()) {
            FloatActionType floatActionType = FloatActionType.ICON;
            if (actionType != floatActionType && !com.transsion.baselib.report.launch.b.f43424a.b().getBoolean("k_pip_enable", true)) {
                lg.a.f68962a.c("VideoFloat", "local 设置页pip开关被关闭了", true);
                return false;
            }
            px.a V0 = V0();
            if (V0 != null) {
                if (actionType != floatActionType && !V0.f().isPlaying()) {
                    lg.a.f68962a.c("VideoFloat-pip", "local 视频暂停，无需触发画中画", true);
                    return false;
                }
                e.a aVar = ox.e.f72320a;
                if (aVar.b().c()) {
                    v1(true);
                    a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", "local 当前可用画中画，使用画中画播放", false, 4, null);
                    aVar.b().k(activity, V0, actionType, a3() == LocalUiType.LAND);
                    return true;
                }
                ox.b.f72314a.c().g(activity, V0, actionType == floatActionType, a3() == LocalUiType.LAND, new Function1() { // from class: com.transsion.postdetail.layer.local.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit G2;
                        G2 = a0.G2(a0.this, ((Boolean) obj).booleanValue());
                        return G2;
                    }
                }, new f());
            }
        }
        return false;
    }

    public final String e1() {
        return this.I;
    }

    public void f(boolean z10, String str) {
        d.a.h(this, z10, str);
    }

    public abstract ImageView f2();

    @Override // vo.d
    public void g() {
        J2(false);
        C2(1);
        this.f49022x = "";
        this.f49023y = true;
        v1(true);
        Group Z2 = Z2();
        if (Z2 != null) {
            Z2.setVisibility(0);
        }
        w1(true);
    }

    protected final View g1() {
        return this.C;
    }

    public abstract ViewGroup g2();

    public void h(String subjectId, String resourceId) {
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(resourceId, "resourceId");
        this.K = subjectId;
        this.L = true;
        FragmentActivity activity = this.f49009k.getActivity();
        if (activity != null) {
            o1().i().j(activity, new e(new Function1() { // from class: com.transsion.postdetail.layer.local.m
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit K1;
                    K1 = a0.K1(a0.this, (List) obj);
                    return K1;
                }
            }));
        }
    }

    public abstract TextView h2();

    public abstract TextView h3();

    @Override // vo.d
    public void i(String content, long j11) {
        Intrinsics.h(content, "content");
        j1 j1Var = this.f49021w;
        if (j1Var != null) {
            j1Var.h(content, j11);
        }
    }

    public final String i1() {
        return this.J;
    }

    public abstract View i2();

    public void i3() {
        vo.b bVar = this.f49018t;
        if (bVar != null) {
            bVar.b(this.H);
        }
        View view = this.C;
        if (view != null) {
            jg.c.g(view);
        }
        this.E = 0L;
        com.transsion.player.orplayer.g H = H();
        if (H != null) {
            H.seekTo(0L);
        }
        com.transsion.player.orplayer.g H2 = H();
        if (H2 != null) {
            H2.play();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void initPlayer() {
        com.transsion.player.orplayer.g H;
        f.a.b(this);
        View view = this.C;
        if (view != null) {
            jg.c.g(view);
        }
        if (this.f49010l > 0 || (H = H()) == null) {
            return;
        }
        long duration = H.getDuration();
        this.f49010l = duration;
        if (duration > 0) {
            f3(0L, duration);
        }
    }

    public boolean isVisible() {
        ConstraintLayout n22 = n2();
        return n22 != null && n22.getVisibility() == 0;
    }

    public void j(boolean z10) {
        d.a.k(this, z10);
    }

    public abstract View j1();

    public abstract FrameLayout j3();

    public void k(DownloadBean downloadBean, String pageFrom, boolean z10) {
        Long duration;
        Long duration2;
        Intrinsics.h(pageFrom, "pageFrom");
        this.H = downloadBean;
        o1().e().q(downloadBean);
        this.I = pageFrom;
        if (((downloadBean == null || (duration2 = downloadBean.getDuration()) == null) ? 0L : duration2.longValue()) > 30000) {
            f3(0L, (downloadBean == null || (duration = downloadBean.getDuration()) == null) ? 0L : duration.longValue());
        }
        View P1 = P1();
        if (P1 != null) {
            P1.setVisibility(O1() ? 0 : 8);
        }
        if (downloadBean != null) {
            downloadBean.setPlaying(true);
        }
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f49008j;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "updateInfo,name = " + (downloadBean != null ? downloadBean.getName() : null) + ", epse = " + (downloadBean != null ? Integer.valueOf(downloadBean.getEpse()) : null), false, 4, null);
        g3();
    }

    public final String k1() {
        return this.K;
    }

    public abstract View k2();

    public abstract TextView k3();

    @Override // vo.d
    public void l(Map progress) {
        Intrinsics.h(progress, "progress");
        SecondariesSeekBar q22 = q2();
        if (q22 != null) {
            q22.setSecondariesProgress(progress);
        }
    }

    public final SystemTimeManager l1() {
        return this.f49017s;
    }

    public void m(LocalUiType localUiType) {
        d.a.f(this, localUiType);
    }

    public final String m1() {
        return this.f49008j;
    }

    public abstract ViewStub m3();

    @Override // vo.d
    public void n() {
        com.transsion.player.orplayer.g H;
        if (ox.c.f72319a.c(H()) || (H = H()) == null) {
            return;
        }
        H.pause();
    }

    public final long n1() {
        return this.f49010l;
    }

    public abstract ConstraintLayout n2();

    public abstract ViewStub n3();

    @Override // vo.d
    public void o(float f11) {
        d.a.o(this, f11);
        VideoSubtitleControl videoSubtitleControl = this.f49019u;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.t0(f11);
        }
    }

    public final LocalVideoDetailViewModel o1() {
        return (LocalVideoDetailViewModel) this.F.getValue();
    }

    @Override // com.transsion.ad.strategy.b.a
    public void onAdClick(AdPlans adPlans) {
        a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", "onAdClick stop auto pip", false, 4, null);
        b3(false);
        ConstraintLayout n22 = n2();
        if (n22 != null) {
            n22.postDelayed(new Runnable() { // from class: com.transsion.postdetail.layer.local.q
                @Override // java.lang.Runnable
                public final void run() {
                    a0.U1(a0.this);
                }
            }, 3000L);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onAliyunDecodeErrorChangeSoftwareDecoder(ao.e eVar) {
        f.a.c(this, eVar);
    }

    @Override // com.transsion.baselib.report.l.a
    public void onBackgroundStatusChange(boolean z10) {
    }

    @Override // com.transsion.player.orplayer.f
    public void onBufferedPosition(long j11, ao.e eVar) {
        f.a.d(this, j11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onCompletion(ao.e eVar) {
        f.a.e(this, eVar);
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f49008j;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "onCompletion, uiType = " + a3(), false, 4, null);
        if (M1()) {
            u2(false);
        } else {
            K0();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onFocusChange(boolean z10) {
        f.a.g(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onIsPlayingChanged(boolean z10) {
        f.a.h(this, z10);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingBegin(ao.e eVar) {
        this.f49023y = false;
        J2(true);
        View view = this.B;
        if (view != null) {
            jg.c.g(view);
        }
        w1(false);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingEnd(ao.e eVar) {
        J2(false);
        U0().removeCallbacksAndMessages(null);
        this.f49023y = false;
        View view = this.B;
        if (view != null) {
            jg.c.g(view);
        }
        w1(false);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoadingProgress(int i11, float f11, ao.e eVar) {
        f.a.m(this, i11, f11, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onLoopingStart() {
        f.a.o(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onMediaItemTransition(String str) {
        f.a.p(this, str);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayError(PlayError errorInfo, ao.e eVar) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.E = 0L;
        Integer errorCode = errorInfo.getErrorCode();
        if (errorCode != null && errorCode.intValue() == 537067524) {
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.f49008j;
            Intrinsics.g(TAG, "TAG");
            a.C0856a.f(c0856a, TAG, "--onPlayError，net time out ,", false, 4, null);
            if (nh.m.f70597a.e()) {
                g();
            } else {
                U0().postDelayed(this.Z, 500L);
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerRelease(ao.e eVar) {
        f.a.t(this, eVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onPlayerReset() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f49008j;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "onPlayerReset", false, 4, null);
        this.f49023y = false;
        this.f49010l = 0L;
        this.E = 0L;
    }

    @Override // com.transsion.player.orplayer.f
    public void onPrepare(ao.e eVar) {
        f.a.w(this, eVar);
        this.E = 0L;
    }

    public void onProgress(long j11, ao.e eVar) {
        e3(j11);
        if (a3() == LocalUiType.MIDDLE) {
            ImageView f22 = f2();
            if (f22 != null ? Intrinsics.c(f22.getTag(), Boolean.FALSE) : false) {
                u2(true);
            }
        }
        if (this.f49024z) {
            J2(false);
        }
        X1(j11);
        VideoSubtitleControl videoSubtitleControl = this.f49019u;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.S(j11);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onRenderFirstFrame() {
        f.a.A(this);
        if (a3() == LocalUiType.MIDDLE) {
            ImageView f22 = f2();
            if (f22 != null ? Intrinsics.c(f22.getTag(), Boolean.FALSE) : false) {
                u2(true);
            }
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onSetDataSource() {
        f.a.B(this);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksAudioBitrateChange(int i11) {
        f.a.C(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksChange(mo.c cVar) {
        f.a.D(this, cVar);
    }

    @Override // com.transsion.player.orplayer.f
    public void onTracksVideoBitrateChange(int i11) {
        f.a.E(this, i11);
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoPause(ao.e eVar) {
        b3(false);
        u2(false);
        if (!N1()) {
            B2(this, false, 1, null);
        }
        VideoSubtitleControl videoSubtitleControl = this.f49019u;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.R();
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoSizeChanged(int i11, int i12) {
        f.a.H(this, i11, i12);
        if ((i11 <= 0 || this.f49014p == i11) && (i12 <= 0 || this.f49015q == i12)) {
            return;
        }
        this.f49015q = i12;
        this.f49014p = i11;
    }

    @Override // com.transsion.player.orplayer.f
    public void onVideoStart(ao.e eVar) {
        b3(true);
        u2(true);
        v1(false);
        VideoSubtitleControl videoSubtitleControl = this.f49019u;
        if (videoSubtitleControl != null) {
            videoSubtitleControl.T();
        }
        J2(false);
        this.O = false;
        View view = this.C;
        if (view != null) {
            jg.c.g(view);
        }
        J0();
    }

    @Override // vo.d
    public void onViewPause() {
        d.a.g(this);
    }

    @Override // vo.d
    public void onViewResume() {
        com.transsion.player.orplayer.g H;
        if (J() || !nh.m.f70597a.e() || ox.c.f72319a.d() || N1() || (H = H()) == null) {
            return;
        }
        H.play();
    }

    @Override // vo.d
    public void p(String resourceId, String subjectId, String postId, boolean z10, boolean z11) {
        Intrinsics.h(resourceId, "resourceId");
        Intrinsics.h(subjectId, "subjectId");
        Intrinsics.h(postId, "postId");
        this.J = resourceId;
        this.K = subjectId;
        O(postId);
        FragmentActivity activity = this.f49009k.getActivity();
        if (activity != null) {
            o1().g().j(activity, new e(new Function1() { // from class: com.transsion.postdetail.layer.local.x
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit y12;
                    y12 = a0.y1(a0.this, (Subject) obj);
                    return y12;
                }
            }));
        }
    }

    public final int p1() {
        return this.f49014p;
    }

    public abstract View p2();

    @Override // vo.d
    public void q(int i11, int i12) {
        this.f49015q = i12;
        this.f49014p = i11;
    }

    public abstract View q1();

    public abstract SecondariesSeekBar q2();

    public void r(View rootView, LocalUiType uiType) {
        Intrinsics.h(rootView, "rootView");
        Intrinsics.h(uiType, "uiType");
        this.L = false;
        this.N = false;
        T1(false);
        com.transsion.baselib.report.l.f43413a.g(this);
        View F0 = F0();
        if (F0 != null) {
            F0.setVisibility(8);
        }
        A1();
        J1();
        L1();
        I1();
        z1();
        com.transsion.ad.strategy.b.f42281a.c(this);
    }

    public abstract View r1();

    public final void r2(DownloadBean nextVideoBean, boolean z10) {
        Intrinsics.h(nextVideoBean, "nextVideoBean");
        if (z10 && nextVideoBean.isCompleted() && !nextVideoBean.isFileExist()) {
            FragmentActivity activity = this.f49009k.getActivity();
            if (activity != null) {
                LocalVideoNotExistUtil.f60027a.v(activity, nextVideoBean, -1);
                return;
            }
            return;
        }
        View view = this.C;
        if (view != null) {
            jg.c.g(view);
        }
        DownloadBean downloadBean = this.H;
        if (downloadBean != null) {
            downloadBean.setPlaying(false);
        }
        o1().f().q(this.H);
        this.O = true;
        SecondariesSeekBar q22 = q2();
        if (q22 != null) {
            q22.setProgress(0L);
        }
        e3(0L);
        if (isVisible()) {
            vo.c cVar = this.M;
            if (cVar != null) {
                cVar.a(nextVideoBean, !z10);
            }
            com.transsion.player.orplayer.g H = H();
            if (H != null) {
                H.clearScreen();
            }
            com.transsion.player.orplayer.g H2 = H();
            if (H2 != null) {
                H2.stop();
            }
            com.transsion.player.orplayer.g H3 = H();
            if (H3 != null) {
                H3.reset();
            }
        }
        this.N = false;
        s();
        String postId = nextVideoBean.getPostId();
        if (postId == null) {
            postId = "";
        }
        O(postId);
        String subjectId = nextVideoBean.getSubjectId();
        if (subjectId == null) {
            subjectId = "";
        }
        this.K = subjectId;
        this.H = nextVideoBean;
        nextVideoBean.setPlaying(true);
        l(new LinkedHashMap());
        boolean z11 = nextVideoBean.getStatus() != 5;
        f.a.j(this, null, 1, null);
        if (isVisible()) {
            com.transsnet.downloader.util.i.f60062a.d("1");
            if (z11) {
                vo.c cVar2 = this.M;
                if (cVar2 != null) {
                    cVar2.b(nextVideoBean);
                    return;
                }
                return;
            }
            lg.a.f68962a.c("long_video_play", "series playerSetDataSource, subjectId = " + nextVideoBean.getSubjectId() + ",resourceId = " + nextVideoBean.getResourceId() + ", path = " + nextVideoBean.getPath(), true);
            com.transsion.player.orplayer.g H4 = H();
            if (H4 != null) {
                H4.clearScreen();
            }
            com.transsion.player.orplayer.g H5 = H();
            if (H5 != null) {
                DownloadBean downloadBean2 = this.H;
                String resourceId = downloadBean2 != null ? downloadBean2.getResourceId() : null;
                String path = nextVideoBean.getPath();
                ao.e eVar = new ao.e(resourceId, path == null ? "" : path, 0, null, c1(), 12, null);
                MusicFloatManager.a aVar = MusicFloatManager.f43508h;
                aVar.b().C(eVar.e());
                aVar.b().B(eVar.i());
                H5.setDataSource(eVar);
            }
            com.transsion.player.orplayer.g H6 = H();
            if (H6 != null) {
                H6.prepare();
            }
        }
    }

    @Override // vo.d
    public void s() {
        j1 j1Var = this.f49021w;
        if (j1Var != null) {
            j1Var.d();
        }
    }

    public void s1(MotionEvent motionEvent, boolean z10) {
        this.P = false;
        P(true);
        u2(false);
        com.transsion.player.orplayer.g H = H();
        if (H != null) {
            H.pause();
        }
        Fragment fragment = this.f49009k;
        LocalVideoDetailFragment localVideoDetailFragment = fragment instanceof LocalVideoDetailFragment ? (LocalVideoDetailFragment) fragment : null;
        if (localVideoDetailFragment != null) {
            localVideoDetailFragment.d3();
        }
        J2(false);
    }

    public final void s2(String str) {
        ImageView imageView;
        FrameLayout j32 = j3();
        if (j32 == null || (imageView = (ImageView) j32.findViewById(R$id.id_local_video_cover)) == null) {
            imageView = new ImageView(this.f49009k.requireContext());
            FrameLayout j33 = j3();
            if (j33 != null) {
                j33.addView(imageView, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        K(imageView);
        ImageView G = G();
        if (G != null) {
            int f11 = com.transsion.core.utils.e.f();
            f.a aVar = ej.f.f62005a;
            if (str == null) {
                str = "";
            }
            ej.a.a(G).load(f.a.e(aVar, str, f11, false, false, 12, null)).into(G);
        }
    }

    @Override // com.transsion.player.orplayer.f
    public void setOnSeekCompleteListener() {
        f.a.K(this);
    }

    @Override // vo.d
    public void t(boolean z10) {
        FragmentActivity activity;
        px.a V0;
        d.a.d(this, z10);
        if (!z10 || (activity = this.f49009k.getActivity()) == null || activity.isDestroyed() || activity.isFinishing() || (V0 = V0()) == null || Build.VERSION.SDK_INT < 31) {
            return;
        }
        a.C0856a.f(lg.a.f68962a, "VideoFloat-pip", "onPictureInPictureModeChanged local--- updateData", false, 4, null);
        ox.e.f72320a.b().h(activity, V0);
    }

    public final void t2(int i11) {
        this.f49015q = i11;
    }

    public void u(String str, String str2) {
        d.a.j(this, str, str2);
    }

    public void u2(boolean z10) {
        W1(z10);
        ImageView f22 = f2();
        if (f22 != null) {
            f22.setTag(Boolean.valueOf(z10));
        }
        if (z10) {
            ImageView f23 = f2();
            if (f23 != null) {
                f23.setImageResource(R$mipmap.icon_player_pause);
                return;
            }
            return;
        }
        ImageView f24 = f2();
        if (f24 != null) {
            f24.setImageResource(R$mipmap.icon_player_play);
        }
    }

    @Override // vo.d
    public void updateTitle(String title) {
        Intrinsics.h(title, "title");
        TextView W2 = W2();
        if (W2 != null) {
            W2.setText(title);
        }
    }

    public void v(boolean z10) {
        com.transsion.player.orplayer.g H;
        if (!z10) {
            U0().postDelayed(this.Z, 1000L);
            return;
        }
        w1(false);
        this.f49023y = false;
        View view = this.B;
        if (view != null && view.getVisibility() == 0 && !J() && (H = H()) != null) {
            H.play();
        }
        View view2 = this.B;
        if (view2 != null) {
            jg.c.g(view2);
        }
    }

    public final void v1(boolean z10) {
        if (com.blankj.utilcode.util.c.l()) {
            if (z10) {
                x1();
                return;
            }
            com.transsion.player.orplayer.g H = H();
            if (H == null || !H.isPlaying()) {
                return;
            }
            X0().removeCallbacks(this.V);
            X0().postDelayed(this.V, 3000L);
        }
    }

    public final void v2(String str) {
        Intrinsics.h(str, "<set-?>");
        this.K = str;
    }

    @Override // vo.d
    public void w(PostSubjectItem postSubjectItem) {
        d.a.m(this, postSubjectItem);
    }

    @Override // vo.d
    public void x(String speed) {
        Intrinsics.h(speed, "speed");
        this.f49022x = speed;
    }

    @Override // vo.d
    public void y(View view, boolean z10) {
        d.a.b(this, view, z10);
    }

    @Override // vo.d
    public void z() {
        String playingUrl;
        d.a.e(this);
        if (ox.c.f72319a.c(H())) {
            return;
        }
        if (com.transsion.videofloat.manager.a0.f58056a.c(H())) {
            a.C0856a c0856a = lg.a.f68962a;
            String TAG = this.f49008j;
            Intrinsics.g(TAG, "TAG");
            c0856a.c(TAG, "local 播放器在缓存中，这里不能release", true);
            return;
        }
        com.transsion.player.orplayer.g H = H();
        if (H != null) {
            DownloadBean downloadBean = this.H;
            H.release((downloadBean == null || (playingUrl = downloadBean.getPlayingUrl()) == null) ? null : Integer.valueOf(playingUrl.hashCode()).toString());
        }
    }

    public final void z0() {
        a.C0856a c0856a = lg.a.f68962a;
        String TAG = this.f49008j;
        Intrinsics.g(TAG, "TAG");
        a.C0856a.f(c0856a, TAG, "addLandSurface 宽:" + this.f49014p + ",高:" + this.f49015q, false, 4, null);
        ORPlayerView I = I();
        if (I != null) {
            m2(I);
        }
        FrameLayout j32 = j3();
        if (j32 != null) {
            j32.addView(I(), 0, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public final void z2(int i11) {
        this.f49014p = i11;
    }
}
