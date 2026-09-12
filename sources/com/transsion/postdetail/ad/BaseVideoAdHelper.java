package com.transsion.postdetail.ad;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.view.LifecycleCoroutineScope;
import com.blankj.utilcode.util.a0;
import com.cloud.hisavana.sdk.common.util.l0;
import com.google.android.material.card.MaterialCardView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hisavana.common.bean.TAdErrorCode;
import com.hisavana.mediation.ad.TAdChoicesView;
import com.hisavana.mediation.ad.TMediaView;
import com.therouter.TheRouter;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.ad.bidding.base.AbsAdBidding;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.ad.bidding.icon.BiddingIconAdManager;
import com.transsion.ad.bidding.interstitial.BiddingInterstitialManager;
import com.transsion.ad.bidding.nativead.BiddingNativeManager;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baseui.R$mipmap;
import com.transsion.commercializationapi.IInterceptReportApi;
import com.transsion.gslb.GslbSdk;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberSource;
import com.transsion.postdetail.ui.view.AdCountDownView;
import com.transsion.wrapperad.R$id;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import so.q0;

/* loaded from: classes6.dex */
public abstract class BaseVideoAdHelper {
    public static final a R = new a(null);
    private BubbleTextView C;
    private AnimatorSet D;
    private int E;
    private int F;
    private int L;
    private g4.a N;
    private VideoFloatingView O;
    private boolean Q;

    /* renamed from: a, reason: collision with root package name */
    private LifecycleCoroutineScope f48648a;

    /* renamed from: b, reason: collision with root package name */
    private String f48649b;

    /* renamed from: c, reason: collision with root package name */
    private Function1 f48650c;

    /* renamed from: d, reason: collision with root package name */
    private Function0 f48651d;

    /* renamed from: e, reason: collision with root package name */
    private BiddingNativeManager f48652e;

    /* renamed from: f, reason: collision with root package name */
    private BiddingInterstitialManager f48653f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f48655h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f48656i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f48657j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f48658k;

    /* renamed from: l, reason: collision with root package name */
    private long f48659l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f48660m;

    /* renamed from: n, reason: collision with root package name */
    private int f48661n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f48662o;

    /* renamed from: p, reason: collision with root package name */
    private int f48663p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f48664q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f48665r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f48666s;

    /* renamed from: t, reason: collision with root package name */
    private CountDownTimer f48667t;

    /* renamed from: u, reason: collision with root package name */
    private CountDownTimer f48668u;

    /* renamed from: v, reason: collision with root package name */
    private long f48669v;

    /* renamed from: w, reason: collision with root package name */
    private long f48670w;

    /* renamed from: x, reason: collision with root package name */
    private long f48671x;

    /* renamed from: y, reason: collision with root package name */
    private long f48672y;

    /* renamed from: g, reason: collision with root package name */
    private String f48654g = "";

    /* renamed from: z, reason: collision with root package name */
    private final String f48673z = "bubble_tip_video_start";
    private final String A = "bubble_tip_interpolate";
    private final String B = "floating_show_time";
    private final Lazy G = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.q
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int K;
            K = BaseVideoAdHelper.K(BaseVideoAdHelper.this);
            return Integer.valueOf(K);
        }
    });
    private final Lazy H = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.r
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int J;
            J = BaseVideoAdHelper.J(BaseVideoAdHelper.this);
            return Integer.valueOf(J);
        }
    });
    private final Lazy I = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int J0;
            J0 = BaseVideoAdHelper.J0(BaseVideoAdHelper.this);
            return Integer.valueOf(J0);
        }
    });
    private final Lazy J = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int H0;
            H0 = BaseVideoAdHelper.H0(BaseVideoAdHelper.this);
            return Integer.valueOf(H0);
        }
    });
    private final Lazy K = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int I0;
            I0 = BaseVideoAdHelper.I0(BaseVideoAdHelper.this);
            return Integer.valueOf(I0);
        }
    });
    private final Lazy M = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.ad.v
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int S;
            S = BaseVideoAdHelper.S();
            return Integer.valueOf(S);
        }
    });
    private String P = "";

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f48675b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f48676c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Ref.IntRef intRef, String str, long j11) {
            super(j11, 1000L);
            this.f48675b = intRef;
            this.f48676c = str;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            if (Intrinsics.c(this.f48676c, "VideoStartBidScene")) {
                BaseVideoAdHelper.this.f2();
            }
            BaseVideoAdHelper.this.y1(0);
            BaseVideoAdHelper.this.P();
            BaseVideoAdHelper.this.Q();
            BaseVideoAdHelper.this.Z1(this.f48676c);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            BaseVideoAdHelper baseVideoAdHelper = BaseVideoAdHelper.this;
            Ref.IntRef intRef = this.f48675b;
            int i11 = intRef.element;
            intRef.element = i11 - 1;
            baseVideoAdHelper.y1(i11);
            AdCountDownView W = BaseVideoAdHelper.this.W();
            if (W != null) {
                W.refreshCountDown(BaseVideoAdHelper.this.x0());
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class c implements zm.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function0 f48678b;

        c(Function0 function0) {
            this.f48678b = function0;
        }

        @Override // zm.b
        public void a() {
        }

        @Override // zm.b
        public void onSuccess() {
            BaseVideoAdHelper.this.P();
            Function0 function0 = this.f48678b;
            if (function0 != null) {
                function0.invoke();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseVideoAdHelper f48679a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f48680b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(long j11, BaseVideoAdHelper baseVideoAdHelper, Ref.LongRef longRef) {
            super(j11, 1000L);
            this.f48679a = baseVideoAdHelper;
            this.f48680b = longRef;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f48679a.R();
            if (this.f48679a.Q0()) {
                return;
            }
            this.f48679a.n1(this.f48679a.r0() + 1);
            BaseVideoAdHelper baseVideoAdHelper = this.f48679a;
            BiddingNativeManager t02 = baseVideoAdHelper.t0();
            baseVideoAdHelper.M1("VideoInterpolateBidScene", t02 != null ? t02.n0() : null);
            this.f48679a.F1("VideoInterpolateBidScene");
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j11) {
            so.f bind;
            TextView textView;
            AdInterceptTimerView d02 = this.f48679a.d0();
            if (d02 == null || (bind = d02.getBind()) == null || (textView = bind.f75635d) == null) {
                return;
            }
            BaseVideoAdHelper baseVideoAdHelper = this.f48679a;
            Ref.LongRef longRef = this.f48680b;
            long j12 = longRef.element;
            longRef.element = (-1) + j12;
            textView.setText(baseVideoAdHelper.a0(j12));
        }
    }

    private final void E1(ViewGroup viewGroup, boolean z10) {
        ImageView imageView = viewGroup != null ? (ImageView) viewGroup.findViewWithTag("adVolumeImage") : null;
        if (imageView != null) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                layoutParams2.gravity = MaterialCardView.CHECKED_ICON_GRAVITY_BOTTOM_START;
                if (!z10) {
                    layoutParams2.leftMargin = a0.a(this.f48655h ? 16.0f : 12.0f);
                    layoutParams2.bottomMargin = a0.a(this.f48655h ? 16.0f : 10.0f);
                    int a11 = a0.a(this.f48655h ? 44.0f : 28.0f);
                    layoutParams2.width = a11;
                    layoutParams2.height = a11;
                    return;
                }
                int a12 = a0.a(8.0f);
                layoutParams2.leftMargin = a12;
                layoutParams2.bottomMargin = a12;
                int a13 = a0.a(20.0f);
                layoutParams2.width = a13;
                layoutParams2.height = a13;
            }
        }
    }

    private final void F0() {
        AdCountDownView W = W();
        if (W != null) {
            W.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ad.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseVideoAdHelper.G0(BaseVideoAdHelper.this, view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(BaseVideoAdHelper baseVideoAdHelper, View view) {
        M(baseVideoAdHelper, false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.b2();
        baseVideoAdHelper.E++;
        com.transsion.baselib.report.launch.b.f43424a.b().putInt(baseVideoAdHelper.f48673z, baseVideoAdHelper.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int H0(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.k0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.b2();
        baseVideoAdHelper.F++;
        com.transsion.baselib.report.launch.b.f43424a.b().putInt(baseVideoAdHelper.A, baseVideoAdHelper.F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int I0(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.l0();
    }

    private final void I1() {
        if (this.f48662o || this.f48666s || !O0()) {
            return;
        }
        this.f48662o = true;
        U0(new Function0() { // from class: com.transsion.postdetail.ad.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit J1;
                J1 = BaseVideoAdHelper.J1(BaseVideoAdHelper.this);
                return J1;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ad.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit K1;
                K1 = BaseVideoAdHelper.K1(BaseVideoAdHelper.this);
                return K1;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.X("VideoInterpolateBidScene");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int J0(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit J1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.c2();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int K(BaseVideoAdHelper baseVideoAdHelper) {
        return baseVideoAdHelper.X("VideoStartBidScene");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit K1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.f48662o = false;
        baseVideoAdHelper.f48669v = 0L;
        baseVideoAdHelper.f48670w = System.currentTimeMillis();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Context context;
        BiddingInterstitialManager biddingInterstitialManager;
        if (!this.f48655h || this.f48664q) {
            return;
        }
        H(true);
        this.f48658k = true;
        this.f48665r = true;
        ViewGroup f02 = f0();
        if (f02 != null && (context = f02.getContext()) != null && (biddingInterstitialManager = this.f48653f) != null) {
            AbsAdBidding.R0(biddingInterstitialManager, (AppCompatActivity) context, biddingIntermediateMaterialBean, false, 4, null);
        }
        R();
    }

    public static /* synthetic */ void M(BaseVideoAdHelper baseVideoAdHelper, boolean z10, Function0 function0, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkMember");
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        baseVideoAdHelper.L(z10, function0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1(String str, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Context context;
        this.P = str;
        H(true);
        this.f48660m = true;
        this.f48659l = System.currentTimeMillis();
        ViewGroup f02 = f0();
        if (f02 != null && (context = f02.getContext()) != null) {
            cy.b bVar = cy.b.f61063a;
            BiddingNativeManager biddingNativeManager = this.f48652e;
            com.transsion.ad.bidding.base.r a11 = bVar.a(context, biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
            NativeWrapperAdView e02 = e0();
            if (e02 != null) {
                e02.bindNativeView(this.f48652e, a11, biddingIntermediateMaterialBean);
            }
        }
        g1(false);
        ViewGroup f03 = f0();
        if (f03 != null) {
            f03.setVisibility(0);
        }
        I(str);
        R0();
    }

    private final boolean N0(int i11, long j11) {
        return Math.abs(System.currentTimeMillis() - j11) > ((long) i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit O1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.H(false);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit P1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.H(false);
        return Unit.f67184a;
    }

    private final void Q1(String str, Function0 function0, Function0 function02) {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f48648a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.k.d(lifecycleCoroutineScope, null, null, new BaseVideoAdHelper$showSceneAd$1(str, this, function0, function02, null), 3, null);
        }
    }

    static /* synthetic */ void R1(BaseVideoAdHelper baseVideoAdHelper, String str, Function0 function0, Function0 function02, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showSceneAd");
        }
        if ((i11 & 2) != 0) {
            function0 = null;
        }
        if ((i11 & 4) != 0) {
            function02 = null;
        }
        baseVideoAdHelper.Q1(str, function0, function02);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int S() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoFloatingNativeScene");
        if (b11 == null || (jsonElement = b11.get("showMax")) == null) {
            return 10;
        }
        return jsonElement.getAsInt();
    }

    private final boolean S0() {
        return this.f48661n < p0();
    }

    private final int T(String str) {
        JsonElement jsonElement;
        JsonElement jsonElement2;
        JsonElement jsonElement3;
        int hashCode = str.hashCode();
        if (hashCode != -172473003) {
            if (hashCode != -73588874) {
                if (hashCode == 2049503279 && str.equals("VideoEndBidScene")) {
                    JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoEndBidScene");
                    if (b11 == null || (jsonElement3 = b11.get("videoEndAdCountdownTime")) == null) {
                        return 10;
                    }
                    return jsonElement3.getAsInt();
                }
            } else if (str.equals("VideoStartBidScene")) {
                JsonObject b12 = com.transsion.ad.scene.d.f42258a.b("VideoStartBidScene");
                if (b12 == null || (jsonElement2 = b12.get("videoStartAdCountdownTime")) == null) {
                    return 10;
                }
                return jsonElement2.getAsInt();
            }
        } else if (str.equals("VideoInterpolateBidScene")) {
            JsonObject b13 = com.transsion.ad.scene.d.f42258a.b("VideoInterpolateBidScene");
            if (b13 == null || (jsonElement = b13.get("videoInterpolateAdCountdownTime")) == null) {
                return 10;
            }
            return jsonElement.getAsInt();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit T1() {
        return Unit.f67184a;
    }

    private final void U0(final Function0 function0, final Function0 function02) {
        Q1("VideoInterpolateBidScene", new Function0() { // from class: com.transsion.postdetail.ad.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit V0;
                V0 = BaseVideoAdHelper.V0(Function0.this);
                return V0;
            }
        }, new Function0() { // from class: com.transsion.postdetail.ad.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit W0;
                W0 = BaseVideoAdHelper.W0(BaseVideoAdHelper.this, function02);
                return W0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit U1(BaseVideoAdHelper baseVideoAdHelper) {
        Function1 function1 = baseVideoAdHelper.f48650c;
        if (function1 != null) {
            function1.invoke(Boolean.FALSE);
        }
        baseVideoAdHelper.b1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit V0(Function0 function0) {
        function0.invoke();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V1(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        Context context;
        if (this.f48655h) {
            return;
        }
        H(true);
        this.f48658k = true;
        NativeWrapperAdView e02 = e0();
        if (e02 != null && (context = e02.getContext()) != null) {
            cy.b bVar = cy.b.f61063a;
            BiddingNativeManager biddingNativeManager = this.f48652e;
            com.transsion.ad.bidding.base.r a11 = bVar.a(context, biddingNativeManager != null ? biddingNativeManager.getMSceneId() : null);
            NativeWrapperAdView V = V();
            if (V != null) {
                V.bindNativeView(this.f48652e, a11, biddingIntermediateMaterialBean);
            }
        }
        g1(true);
        ViewGroup g02 = g0();
        if (g02 != null) {
            g02.setVisibility(0);
        }
        ImageView s02 = s0();
        if (s02 != null) {
            s02.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ad.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseVideoAdHelper.W1(BaseVideoAdHelper.this, view);
                }
            });
        }
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit W0(BaseVideoAdHelper baseVideoAdHelper, Function0 function0) {
        baseVideoAdHelper.H(false);
        function0.invoke();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W1(BaseVideoAdHelper baseVideoAdHelper, View view) {
        baseVideoAdHelper.O();
    }

    private final int X(String str) {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b(str);
        if (b11 == null || (jsonElement = b11.get("bubbleFrequency")) == null) {
            return 3;
        }
        return jsonElement.getAsInt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Y1(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.H(false);
        baseVideoAdHelper.b1();
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(String str, BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
        this.f48654g = str;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f48648a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.k.d(lifecycleCoroutineScope, null, null, new BaseVideoAdHelper$onAdLoad$1(str, this, biddingIntermediateMaterialBean, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Z1(String str) {
        Object m1185constructorimpl;
        if (str == null || !this.f48655h) {
            return;
        }
        if ((Intrinsics.c(str, "VideoStartBidScene") || Intrinsics.c(str, "VideoInterpolateBidScene")) && this.L < h0()) {
            try {
                Result.Companion companion = Result.INSTANCE;
                g4.a aVar = this.N;
                Unit unit = null;
                Object[] objArr = 0;
                Object[] objArr2 = 0;
                if (aVar != null) {
                    View root = aVar.getRoot();
                    ConstraintLayout constraintLayout = root instanceof ConstraintLayout ? (ConstraintLayout) root : null;
                    if (constraintLayout == null) {
                        return;
                    }
                    Context context = GslbSdk.context;
                    Intrinsics.g(context, "context");
                    VideoFloatingView videoFloatingView = new VideoFloatingView(context, objArr2 == true ? 1 : 0, 2, objArr == true ? 1 : 0);
                    this.O = videoFloatingView;
                    videoFloatingView.show(this.f48648a, constraintLayout, new Function0() { // from class: com.transsion.postdetail.ad.p
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit a22;
                            a22 = BaseVideoAdHelper.a2(BaseVideoAdHelper.this);
                            return a22;
                        }
                    });
                    unit = Unit.f67184a;
                }
                m1185constructorimpl = Result.m1185constructorimpl(unit);
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.INSTANCE;
                m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
            }
            Result.m1184boximpl(m1185constructorimpl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a0(long j11) {
        return j11 + "s";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit a2(BaseVideoAdHelper baseVideoAdHelper) {
        baseVideoAdHelper.L++;
        com.transsion.baselib.report.launch.b.f43424a.b().putInt(baseVideoAdHelper.B, baseVideoAdHelper.L);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b1() {
        Function0 function0 = this.f48651d;
        if (function0 != null) {
            function0.invoke();
        }
        this.f48651d = null;
    }

    private final void b2() {
        NativeWrapperAdView e02 = e0();
        BubbleTextView bubbleTextView = e02 != null ? (BubbleTextView) e02.findViewById(R$id.bubble_tip) : null;
        this.C = bubbleTextView;
        if (bubbleTextView != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(bubbleTextView, "translationY", -35.0f, 15.0f, -35.0f);
            ofFloat.setDuration(900L);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(ofFloat);
            animatorSet.start();
            jg.c.k(bubbleTextView);
            this.D = animatorSet;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c1() {
        this.f48669v = 0L;
        this.f48670w = System.currentTimeMillis();
    }

    private final void c2() {
        so.f bind;
        TextView textView;
        so.f bind2;
        TextView textView2;
        if (this.f48666s) {
            this.f48662o = false;
            return;
        }
        R();
        long o02 = o0();
        Ref.LongRef longRef = new Ref.LongRef();
        longRef.element = o02 / 1000;
        AdInterceptTimerView d02 = d0();
        if (d02 != null) {
            jg.c.k(d02);
        }
        AdInterceptTimerView d03 = d0();
        if (d03 != null && (bind2 = d03.getBind()) != null && (textView2 = bind2.f75635d) != null) {
            textView2.setText(a0(longRef.element));
        }
        AdInterceptTimerView d04 = d0();
        if (d04 != null && (bind = d04.getBind()) != null && (textView = bind.f75637f) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ad.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseVideoAdHelper.d2(BaseVideoAdHelper.this, view);
                }
            });
        }
        d dVar = new d(o02, this, longRef);
        this.f48668u = dVar;
        dVar.start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.view.View] */
    private final void d1() {
        NativeWrapperAdView e02 = e0();
        CardView cardView = e02 != null ? (CardView) e02.findViewById(R$id.adChoicesViewCard) : null;
        if (cardView != null) {
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                int a11 = a0.a(this.f48655h ? 16.0f : 12.0f);
                ((ViewGroup.MarginLayoutParams) bVar).leftMargin = a11;
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = a11;
            }
            View childAt = cardView.getChildAt(0);
            TAdChoicesView tAdChoicesView = childAt instanceof TAdChoicesView ? (TAdChoicesView) childAt : null;
            ImageView childAt2 = tAdChoicesView != null ? tAdChoicesView.getChildAt(0) : null;
            if (childAt2 == null) {
                f1();
                return;
            }
            ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
            int a12 = a0.a(this.f48655h ? 26.0f : 22.0f);
            layoutParams2.width = a12;
            layoutParams2.height = a12;
            ImageView imageView = childAt2 instanceof ImageView ? childAt2 : null;
            if (imageView != null) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            f1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(BaseVideoAdHelper baseVideoAdHelper, View view) {
        M(baseVideoAdHelper, false, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e2() {
        AnimatorSet animatorSet = this.D;
        if (animatorSet != null && animatorSet.isRunning()) {
            animatorSet.cancel();
        }
        BubbleTextView bubbleTextView = this.C;
        if (bubbleTextView != null) {
            jg.c.g(bubbleTextView);
        }
        this.D = null;
    }

    private final void f1() {
        ImageView imageView;
        TextView textView;
        TextView textView2;
        AdCountDownView W = W();
        if (W != null) {
            ViewGroup.LayoutParams layoutParams = W.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                int a11 = a0.a(this.f48655h ? 16.0f : 12.0f);
                layoutParams2.topMargin = a11;
                layoutParams2.rightMargin = a11;
            }
            float f11 = this.f48655h ? 14.0f : 12.0f;
            q0 bind = W.getBind();
            if (bind != null && (textView2 = bind.f75811d) != null) {
                textView2.getLayoutParams().height = a0.a(this.f48655h ? 28.0f : 24.0f);
                textView2.setTextSize(f11);
            }
            q0 bind2 = W.getBind();
            if (bind2 != null && (textView = bind2.f75812e) != null) {
                textView.setTextSize(f11);
            }
            q0 bind3 = W.getBind();
            if (bind3 == null || (imageView = bind3.f75809b) == null) {
                return;
            }
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            int a12 = a0.a(this.f48655h ? 18.0f : 15.0f);
            layoutParams3.width = a12;
            layoutParams3.height = a12;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.transsion.postdetail.ad.BaseVideoAdHelper$wrapperAdListener$1] */
    public final BaseVideoAdHelper$wrapperAdListener$1 g2(final String str, final Function0 function0, final Function0 function02) {
        return new di.a() { // from class: com.transsion.postdetail.ad.BaseVideoAdHelper$wrapperAdListener$1
            @Override // di.a
            public void i(TAdErrorCode tAdErrorCode) {
                LifecycleCoroutineScope v02 = BaseVideoAdHelper.this.v0();
                if (v02 != null) {
                    kotlinx.coroutines.k.d(v02, null, null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingError$1(function02, null), 3, null);
                }
            }

            @Override // di.a
            public void j(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                LifecycleCoroutineScope v02 = BaseVideoAdHelper.this.v0();
                if (v02 != null) {
                    kotlinx.coroutines.k.d(v02, null, null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingLoad$1(function0, BaseVideoAdHelper.this, str, biddingIntermediateMaterialBean, null), 3, null);
                }
            }

            @Override // di.a
            public void l(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                String str2;
                super.l(biddingIntermediateMaterialBean);
                BaseVideoAdHelper.this.P();
                BaseVideoAdHelper baseVideoAdHelper = BaseVideoAdHelper.this;
                str2 = baseVideoAdHelper.P;
                baseVideoAdHelper.Z1(str2);
            }

            @Override // di.a
            public void m(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                LifecycleCoroutineScope v02 = BaseVideoAdHelper.this.v0();
                if (v02 != null) {
                    kotlinx.coroutines.k.d(v02, null, null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingWrapperAdClose$1(BaseVideoAdHelper.this, null), 3, null);
                }
            }

            @Override // di.a
            public void p(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
                super.p(biddingIntermediateMaterialBean);
                LifecycleCoroutineScope v02 = BaseVideoAdHelper.this.v0();
                if (v02 != null) {
                    kotlinx.coroutines.k.d(v02, null, null, new BaseVideoAdHelper$wrapperAdListener$1$onBiddingWrapperAdShowError$1(function02, null), 3, null);
                }
            }
        };
    }

    private final void h1() {
        NativeWrapperAdView e02 = e0();
        BubbleTextView bubbleTextView = e02 != null ? (BubbleTextView) e02.findViewById(R$id.bubble_tip) : null;
        this.C = bubbleTextView;
        if (bubbleTextView != null) {
            bubbleTextView.setTextSize(this.f48655h ? 16.0f : 12.0f);
            bubbleTextView.setArrowPosition(a0.a(this.f48655h ? 110.0f : 90.0f));
        }
    }

    private final void j1() {
        AdInterceptTimerView d02 = d0();
        if (d02 != null) {
            ViewGroup.LayoutParams layoutParams = d02.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).topMargin = a0.a(this.f48655h ? 16.0f : 12.0f);
            }
            int childCount = d02.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = d02.getChildAt(i11);
                if (childAt instanceof AppCompatTextView) {
                    ((AppCompatTextView) childAt).setTextSize(this.f48655h ? 14.0f : 12.0f);
                }
            }
        }
    }

    private final void k1() {
        View j02 = j0();
        if (j02 != null) {
            ViewGroup.LayoutParams layoutParams = j02.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                int i11 = -1;
                ((ViewGroup.MarginLayoutParams) bVar).width = -1;
                if (!this.f48655h) {
                    ViewGroup B0 = B0();
                    i11 = B0 != null ? B0.getHeight() : (int) ((((ViewGroup.MarginLayoutParams) bVar).width * 9.0d) / 16);
                }
                ((ViewGroup.MarginLayoutParams) bVar).height = i11;
            }
        }
    }

    private final void l1() {
        BiddingNativeManager biddingNativeManager = this.f48652e;
        if (biddingNativeManager == null || biddingNativeManager.U0()) {
            NativeWrapperAdView e02 = e0();
            final TMediaView tMediaView = e02 != null ? (TMediaView) e02.findViewById(R$id.native_ad_media) : null;
            if (tMediaView != null) {
                tMediaView.post(new Runnable() { // from class: com.transsion.postdetail.ad.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseVideoAdHelper.m1(TMediaView.this, this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m1(TMediaView tMediaView, BaseVideoAdHelper baseVideoAdHelper) {
        ViewGroup.LayoutParams layoutParams;
        ViewGroup.LayoutParams layoutParams2 = tMediaView.getLayoutParams();
        ConstraintLayout.b bVar = layoutParams2 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams2 : null;
        if (bVar != null) {
            if (baseVideoAdHelper.f48655h) {
                ((ViewGroup.MarginLayoutParams) bVar).height = -1;
                bVar.I = null;
            } else {
                ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                bVar.I = "H,16:9";
            }
        }
        View mediaView = tMediaView.getMediaView();
        if (mediaView != null) {
            mediaView.getLayoutParams().height = -1;
            mediaView.requestLayout();
            if (mediaView instanceof ViewGroup) {
                View childAt = ((ViewGroup) mediaView).getChildAt(0);
                if (childAt != null && (layoutParams = childAt.getLayoutParams()) != null) {
                    layoutParams.height = -1;
                }
                if (childAt != null) {
                    childAt.requestLayout();
                }
            }
        }
    }

    private final void q1() {
        ViewGroup f02 = f0();
        if (f02 != null) {
            ViewGroup.LayoutParams layoutParams = f02.getLayoutParams();
            int i11 = -1;
            layoutParams.width = -1;
            if (!this.f48655h) {
                ViewGroup B0 = B0();
                i11 = B0 != null ? B0.getHeight() : (int) ((layoutParams.width * 9.0d) / 16);
            }
            layoutParams.height = i11;
        }
    }

    private final void r1() {
        NativeWrapperAdView e02 = e0();
        AppCompatTextView appCompatTextView = e02 != null ? (AppCompatTextView) e02.findViewById(R$id.native_ad_action) : null;
        if (appCompatTextView != null) {
            ViewGroup.LayoutParams layoutParams = appCompatTextView.getLayoutParams();
            ConstraintLayout.b bVar = layoutParams instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams : null;
            if (bVar != null) {
                ((ViewGroup.MarginLayoutParams) bVar).height = a0.a(this.f48655h ? 44.0f : 28.0f);
                ((ViewGroup.MarginLayoutParams) bVar).rightMargin = a0.a(this.f48655h ? 73.0f : 52.0f);
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = a0.a(this.f48655h ? 16.0f : 10.0f);
            }
            appCompatTextView.setTextSize(this.f48655h ? 16.0f : 12.0f);
            int a11 = a0.a(this.f48655h ? 16.0f : 6.0f);
            appCompatTextView.setPadding(a11, 3, a11, 4);
        }
    }

    private final void v1() {
        ViewGroup g02 = g0();
        if (g02 != null) {
            ViewGroup.LayoutParams layoutParams = g02.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = a0.a(this.f48655h ? 426.0f : 219.0f);
                layoutParams.height = a0.a(this.f48655h ? 240.0f : 123.0f);
            }
            AppCompatTextView appCompatTextView = (AppCompatTextView) g02.findViewById(R$id.native_ad_action);
            if (appCompatTextView != null) {
                ViewGroup.LayoutParams layoutParams2 = appCompatTextView.getLayoutParams();
                ConstraintLayout.b bVar = layoutParams2 instanceof ConstraintLayout.b ? (ConstraintLayout.b) layoutParams2 : null;
                if (bVar != null) {
                    ((ViewGroup.MarginLayoutParams) bVar).height = a0.a(this.f48655h ? 32.0f : 20.0f);
                    int a11 = a0.a(8.0f);
                    ((ViewGroup.MarginLayoutParams) bVar).rightMargin = a11;
                    ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = a11;
                }
                appCompatTextView.setTextSize(this.f48655h ? 14.0f : 12.0f);
            }
        }
    }

    private final int z0() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoStartBidScene");
        return ((b11 == null || (jsonElement = b11.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    private final void z1() {
        ImageView y02 = y0();
        if (y02 != null) {
            ViewGroup.LayoutParams layoutParams = y02.getLayoutParams();
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                int a11 = a0.a(this.f48655h ? 44.0f : 28.0f);
                layoutParams2.width = a11;
                layoutParams2.height = a11;
                layoutParams2.rightMargin = a0.a(this.f48655h ? 16.0f : 12.0f);
                layoutParams2.bottomMargin = a0.a(this.f48655h ? 16.0f : 10.0f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long A0() {
        return this.f48670w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void A1(boolean z10) {
        this.f48657j = z10;
    }

    protected abstract ViewGroup B0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void B1(boolean z10) {
        this.f48656i = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C0(long j11, long j12) {
        this.f48656i = N0(z0(), j11);
        this.f48657j = N0(c0(), j12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void C1(long j11) {
        this.f48670w = j11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D0(g4.a aVar, String str, Function1 function1) {
        View root;
        this.N = aVar;
        Context context = (aVar == null || (root = aVar.getRoot()) == null) ? null : root.getContext();
        AppCompatActivity appCompatActivity = context instanceof AppCompatActivity ? (AppCompatActivity) context : null;
        this.f48648a = appCompatActivity != null ? androidx.view.v.a(appCompatActivity) : null;
        this.f48649b = str;
        this.f48650c = function1;
        F0();
        BiddingIconAdManager.f41991s.a("VerticalPauseScene", com.transsion.ad.strategy.d.f42285a.a(str));
    }

    public final void D1(long j11) {
        this.f48672y = j11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void E0(String scene) {
        Intrinsics.h(scene, "scene");
        if (!T0(scene, true)) {
            com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
            this.F = bVar.b().getInt(this.A, 0);
            this.E = bVar.b().getInt(this.f48673z, 0);
            this.L = bVar.b().getInt(this.B, 0);
            return;
        }
        this.F = 0;
        com.transsion.baselib.report.launch.b bVar2 = com.transsion.baselib.report.launch.b.f43424a;
        bVar2.b().putInt(this.A, 0);
        this.E = 0;
        bVar2.b().putInt(this.f48673z, 0);
        this.L = 0;
        bVar2.b().putInt(this.B, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F1(String str) {
        NativeWrapperAdView e02;
        NativeWrapperAdView e03;
        if (Intrinsics.c(str, "VideoStartBidScene")) {
            if (this.E < Z() && (e03 = e0()) != null) {
                e03.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ad.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseVideoAdHelper.G1(BaseVideoAdHelper.this);
                    }
                }, 2000L);
                return;
            }
            return;
        }
        if (!Intrinsics.c(str, "VideoInterpolateBidScene") || this.F >= Y() || (e02 = e0()) == null) {
            return;
        }
        e02.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ad.c
            @Override // java.lang.Runnable
            public final void run() {
                BaseVideoAdHelper.H1(BaseVideoAdHelper.this);
            }
        }, 2000L);
    }

    public void H(boolean z10) {
        Function1 function1 = this.f48650c;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z10));
        }
        this.f48664q = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void I(String sceneId) {
        Intrinsics.h(sceneId, "sceneId");
        Ref.IntRef intRef = new Ref.IntRef();
        int i11 = this.f48663p;
        if (i11 == 0) {
            i11 = T(sceneId);
        }
        intRef.element = i11;
        AdCountDownView W = W();
        if (W != null) {
            W.refreshCountDown(intRef.element);
        }
        Q();
        b bVar = new b(intRef, sceneId, intRef.element * 1000);
        this.f48667t = bVar;
        bVar.start();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean K0() {
        return this.f48662o;
    }

    protected final void L(boolean z10, Function0 function0) {
        IInterceptReportApi iInterceptReportApi;
        if (!z10 && (iInterceptReportApi = (IInterceptReportApi) TheRouter.d(IInterceptReportApi.class, new Object[0])) != null) {
            iInterceptReportApi.h();
        }
        IMemberApi iMemberApi = (IMemberApi) TheRouter.d(IMemberApi.class, new Object[0]);
        if (iMemberApi != null) {
            IMemberApi.a.c(iMemberApi, com.blankj.utilcode.util.a.b(), MemberSource.SOURCE_LANDSCAPE_PLAY, new c(function0), false, null, 24, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean L0() {
        return this.f48660m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean M0() {
        return this.f48665r;
    }

    public final void N(long j11, Function0 callback) {
        Intrinsics.h(callback, "callback");
        if (!this.Q && this.f48657j && this.f48672y - j11 <= 30000) {
            this.Q = true;
            BiddingNativeManager.f42070y.a("VideoEndBidScene", com.transsion.ad.strategy.d.f42285a.a(this.f48649b));
        }
        if (this.f48671x == 0) {
            this.f48671x = j11;
            return;
        }
        if (this.f48666s || this.f48664q || !S0()) {
            return;
        }
        if (Math.abs(j11 - this.f48671x) > 5000) {
            this.f48671x = j11;
            this.f48669v += System.currentTimeMillis() - this.f48670w;
            this.f48670w = System.currentTimeMillis();
        }
        if (this.f48669v >= n0()) {
            this.f48651d = callback;
            I1();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N1() {
        if (this.f48655h) {
            R1(this, "LandscapePauseSceneNew", null, new Function0() { // from class: com.transsion.postdetail.ad.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit P1;
                    P1 = BaseVideoAdHelper.P1(BaseVideoAdHelper.this);
                    return P1;
                }
            }, 2, null);
        } else {
            R1(this, "VerticalPauseScene", null, new Function0() { // from class: com.transsion.postdetail.ad.l
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit O1;
                    O1 = BaseVideoAdHelper.O1(BaseVideoAdHelper.this);
                    return O1;
                }
            }, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void O() {
        if (TextUtils.equals(this.f48654g, "LandscapePauseSceneNew") || TextUtils.equals(this.f48654g, "VerticalPauseScene")) {
            P();
        }
    }

    public final boolean O0() {
        return !ox.e.f72320a.b().j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void P() {
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f48648a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.k.d(lifecycleCoroutineScope, null, null, new BaseVideoAdHelper$closeSceneAd$1(this, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean P0() {
        return this.f48658k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Q() {
        CountDownTimer countDownTimer = this.f48667t;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f48667t = null;
    }

    protected final boolean Q0() {
        return this.f48666s;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R() {
        CountDownTimer countDownTimer = this.f48668u;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f48668u = null;
        AdInterceptTimerView d02 = d0();
        if (d02 != null) {
            jg.c.g(d02);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R0() {
        if (this.f48655h) {
            ImageView y02 = y0();
            if (y02 != null) {
                y02.setImageResource(R$mipmap.ad_rotate);
                return;
            }
            return;
        }
        ImageView y03 = y0();
        if (y03 != null) {
            y03.setImageResource(R$mipmap.ad_fullscreen);
        }
    }

    public final void S1(Function0 callback) {
        Intrinsics.h(callback, "callback");
        this.f48651d = callback;
        if (this.f48656i && O0()) {
            Q1("VideoStartBidScene", new Function0() { // from class: com.transsion.postdetail.ad.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit T1;
                    T1 = BaseVideoAdHelper.T1();
                    return T1;
                }
            }, new Function0() { // from class: com.transsion.postdetail.ad.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit U1;
                    U1 = BaseVideoAdHelper.U1(BaseVideoAdHelper.this);
                    return U1;
                }
            });
        } else {
            b1();
        }
    }

    public final boolean T0(String scene, boolean z10) {
        Intrinsics.h(scene, "scene");
        String str = "zero_clock_timestamp_" + scene;
        com.transsion.baselib.report.launch.b bVar = com.transsion.baselib.report.launch.b.f43424a;
        long j11 = bVar.b().getLong(str, 0L);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z11 = currentTimeMillis - j11 >= 86400000;
        if (z10 && z11) {
            bVar.b().putLong(str, l0.c(currentTimeMillis));
        }
        return z11;
    }

    protected final int U() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoEndBidScene");
        return ((b11 == null || (jsonElement = b11.get("threshold")) == null) ? 5 : jsonElement.getAsInt()) * 60000;
    }

    protected abstract NativeWrapperAdView V();

    protected abstract AdCountDownView W();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X0(String sceneId, Function0 function0, Function0 function02) {
        Context context;
        Intrinsics.h(sceneId, "sceneId");
        ViewGroup g02 = g0();
        if (g02 == null || (context = g02.getContext()) == null) {
            return;
        }
        BiddingInterstitialManager biddingInterstitialManager = this.f48653f;
        if (biddingInterstitialManager != null) {
            biddingInterstitialManager.V();
        }
        this.f48653f = null;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f48648a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.k.d(lifecycleCoroutineScope, null, null, new BaseVideoAdHelper$loadLandPauseAd$1(context, this, sceneId, function0, function02, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void X1(Function0 callback) {
        Intrinsics.h(callback, "callback");
        boolean z10 = System.currentTimeMillis() - this.f48659l > ((long) U());
        if (this.f48657j && z10 && O0()) {
            Q1("VideoEndBidScene", callback, new Function0() { // from class: com.transsion.postdetail.ad.f
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit Y1;
                    Y1 = BaseVideoAdHelper.Y1(BaseVideoAdHelper.this);
                    return Y1;
                }
            });
        } else {
            b1();
        }
    }

    protected final int Y() {
        return ((Number) this.H.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y0(String sceneId, Function0 function0, Function0 function02) {
        Context context;
        Intrinsics.h(sceneId, "sceneId");
        ViewGroup f02 = f0();
        if (f02 == null || (context = f02.getContext()) == null) {
            return;
        }
        BiddingNativeManager biddingNativeManager = this.f48652e;
        if (biddingNativeManager != null) {
            biddingNativeManager.V();
        }
        this.f48652e = null;
        LifecycleCoroutineScope lifecycleCoroutineScope = this.f48648a;
        if (lifecycleCoroutineScope != null) {
            kotlinx.coroutines.k.d(lifecycleCoroutineScope, null, null, new BaseVideoAdHelper$loadNativeAd$1(context, this, sceneId, function0, function02, null), 3, null);
        }
    }

    protected final int Z() {
        return ((Number) this.G.getValue()).intValue();
    }

    public final void a1() {
        if (this.f48655h) {
            BiddingInterstitialManager.f42019w.a("LandscapePauseSceneNew", com.transsion.ad.strategy.d.f42285a.a(this.f48649b));
            return;
        }
        VideoFloatingView videoFloatingView = this.O;
        if (videoFloatingView != null) {
            videoFloatingView.hide();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String b0() {
        return this.f48654g;
    }

    protected final int c0() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoEndBidScene");
        return ((b11 == null || (jsonElement = b11.get("interval")) == null) ? 1440 : jsonElement.getAsInt()) * 60000;
    }

    protected abstract AdInterceptTimerView d0();

    protected abstract NativeWrapperAdView e0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e1(Function0 function0) {
        this.f48651d = function0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup f0();

    public abstract void f2();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract ViewGroup g0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g1(boolean z10) {
        try {
            Result.Companion companion = Result.INSTANCE;
            if (z10) {
                k1();
                v1();
                E1(V(), true);
            } else {
                q1();
                l1();
                j1();
                r1();
                z1();
                E1(e0(), false);
                d1();
                h1();
            }
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    protected final int h0() {
        return ((Number) this.M.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String i0() {
        return this.f48649b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void i1(boolean z10) {
        this.f48662o = z10;
    }

    protected abstract View j0();

    protected final int k0() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoInterpolateBidScene");
        return ((b11 == null || (jsonElement = b11.get("enterCountdown")) == null) ? 10 : jsonElement.getAsInt()) * 1000;
    }

    protected final int l0() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoInterpolateBidScene");
        if (b11 == null || (jsonElement = b11.get("frequency")) == null) {
            return 2;
        }
        return jsonElement.getAsInt();
    }

    protected final int m0() {
        JsonElement jsonElement;
        JsonObject b11 = com.transsion.ad.scene.d.f42258a.b("VideoInterpolateBidScene");
        return ((b11 == null || (jsonElement = b11.get("interval")) == null) ? 15 : jsonElement.getAsInt()) * 60000;
    }

    public final int n0() {
        return q0() - o0();
    }

    protected final void n1(int i11) {
        this.f48661n = i11;
    }

    protected final int o0() {
        return ((Number) this.J.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o1(BiddingNativeManager biddingNativeManager) {
        this.f48652e = biddingNativeManager;
    }

    protected final int p0() {
        return ((Number) this.K.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p1(boolean z10) {
        this.f48660m = z10;
    }

    protected final int q0() {
        return ((Number) this.I.getValue()).intValue();
    }

    protected final int r0() {
        return this.f48661n;
    }

    protected abstract ImageView s0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s1(BiddingInterstitialManager biddingInterstitialManager) {
        this.f48653f = biddingInterstitialManager;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BiddingNativeManager t0() {
        return this.f48652e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t1(boolean z10) {
        this.f48665r = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final BiddingInterstitialManager u0() {
        return this.f48653f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void u1(boolean z10) {
        this.f48655h = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final LifecycleCoroutineScope v0() {
        return this.f48648a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long w0() {
        return this.f48669v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w1(boolean z10) {
        this.f48658k = z10;
    }

    protected final int x0() {
        return this.f48663p;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x1(long j11) {
        this.f48669v = j11;
    }

    protected abstract ImageView y0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y1(int i11) {
        this.f48663p = i11;
    }
}
