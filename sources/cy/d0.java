package cy;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;
import com.transsion.ad.bidding.base.BiddingIntermediateMaterialBean;
import com.transsion.wrapperad.R$id;
import com.transsion.wrapperad.R$layout;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class d0 extends com.transsion.ad.bidding.base.r {

    /* renamed from: e, reason: collision with root package name */
    public static final a f61072e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private Runnable f61073b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f61074c;

    /* renamed from: d, reason: collision with root package name */
    private long f61075d;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes7.dex */
    public static final class b extends di.a {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f61077e;

        b(View view) {
            this.f61077e = view;
        }

        @Override // di.a
        public void n(BiddingIntermediateMaterialBean biddingIntermediateMaterialBean) {
            d0.this.f61075d = System.currentTimeMillis();
            d0.K(d0.this, this.f61077e, 0L, 2, null);
        }
    }

    /* loaded from: classes7.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f61078a;

        c(TextView textView) {
            this.f61078a = textView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.h(animation, "animation");
            this.f61078a.setTranslationY(0.0f);
            this.f61078a.setAlpha(1.0f);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d0(Context context) {
        super(context);
        Intrinsics.h(context, "context");
    }

    private final void F(View view) {
        this.f61074c = true;
        TextView textView = (TextView) view.findViewById(R$id.call_to_action);
        if (textView == null) {
            return;
        }
        textView.setTranslationY(0.0f);
        textView.setAlpha(1.0f);
        textView.setVisibility(0);
    }

    private final void J(final View view, long j11) {
        if (this.f61074c) {
            return;
        }
        Runnable runnable = this.f61073b;
        if (runnable != null) {
            view.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: cy.c0
            @Override // java.lang.Runnable
            public final void run() {
                d0.L(view, this);
            }
        };
        this.f61073b = runnable2;
        Intrinsics.e(runnable2);
        view.postDelayed(runnable2, j11);
    }

    static /* synthetic */ void K(d0 d0Var, View view, long j11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = 3000;
        }
        d0Var.J(view, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(View view, d0 d0Var) {
        if (view.isAttachedToWindow() && view.isShown()) {
            d0Var.M(view);
        }
    }

    private final void M(View view) {
        if (this.f61074c) {
            return;
        }
        this.f61074c = true;
        TextView textView = (TextView) view.findViewById(R$id.call_to_action);
        if (textView == null) {
            return;
        }
        textView.setTranslationY(textView.getHeight() > 0 ? -textView.getHeight() : -80.0f);
        textView.setAlpha(0.0f);
        textView.setVisibility(0);
        textView.animate().translationY(0.0f).alpha(1.0f).setDuration(400L).setInterpolator(new DecelerateInterpolator()).setListener(new c(textView)).start();
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer A() {
        return Integer.valueOf(R$id.flVolumeContainer);
    }

    public final void G(View rootView) {
        Intrinsics.h(rootView, "rootView");
        if (this.f61074c) {
            F(rootView);
            return;
        }
        TextView textView = (TextView) rootView.findViewById(R$id.call_to_action);
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
        if (this.f61075d == 0) {
            Runnable runnable = this.f61073b;
            if (runnable != null) {
                rootView.removeCallbacks(runnable);
            }
            this.f61073b = null;
            return;
        }
        long currentTimeMillis = 3000 - (System.currentTimeMillis() - this.f61075d);
        if (currentTimeMillis <= 0) {
            F(rootView);
        } else {
            J(rootView, currentTimeMillis);
        }
    }

    public final di.a H(View rootView) {
        Intrinsics.h(rootView, "rootView");
        return new b(rootView);
    }

    public final void I(View rootView) {
        Intrinsics.h(rootView, "rootView");
        if (this.f61074c || this.f61075d == 0) {
            return;
        }
        Runnable runnable = this.f61073b;
        if (runnable != null) {
            rootView.removeCallbacks(runnable);
        }
        this.f61073b = null;
        F(rootView);
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer c() {
        return Integer.valueOf(R$id.adChoicesView);
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer h() {
        return Integer.valueOf(R$id.store_mark_view);
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer i() {
        return Integer.valueOf(R$id.adIcon);
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer l() {
        return Integer.valueOf(R$id.call_to_action);
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer m() {
        return Integer.valueOf(R$id.native_ad_body);
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer s() {
        return Integer.valueOf(R$id.native_ad_icon);
    }

    @Override // com.transsion.ad.bidding.base.r
    public int t() {
        return R$layout.native_trending_native_layout_style_3;
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer v() {
        return Integer.valueOf(R$id.coverview);
    }

    @Override // com.transsion.ad.bidding.base.r
    public Integer z() {
        return Integer.valueOf(R$id.native_ad_title);
    }
}
