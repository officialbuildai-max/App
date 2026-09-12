package androidx.media3.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e0 {
    private boolean A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    private final PlayerControlView f13734a;

    /* renamed from: b, reason: collision with root package name */
    private final View f13735b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewGroup f13736c;

    /* renamed from: d, reason: collision with root package name */
    private final ViewGroup f13737d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewGroup f13738e;

    /* renamed from: f, reason: collision with root package name */
    private final ViewGroup f13739f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewGroup f13740g;

    /* renamed from: h, reason: collision with root package name */
    private final ViewGroup f13741h;

    /* renamed from: i, reason: collision with root package name */
    private final ViewGroup f13742i;

    /* renamed from: j, reason: collision with root package name */
    private final View f13743j;

    /* renamed from: k, reason: collision with root package name */
    private final View f13744k;

    /* renamed from: l, reason: collision with root package name */
    private final AnimatorSet f13745l;

    /* renamed from: m, reason: collision with root package name */
    private final AnimatorSet f13746m;

    /* renamed from: n, reason: collision with root package name */
    private final AnimatorSet f13747n;

    /* renamed from: o, reason: collision with root package name */
    private final AnimatorSet f13748o;

    /* renamed from: p, reason: collision with root package name */
    private final AnimatorSet f13749p;

    /* renamed from: q, reason: collision with root package name */
    private final ValueAnimator f13750q;

    /* renamed from: r, reason: collision with root package name */
    private final ValueAnimator f13751r;

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f13752s = new Runnable() { // from class: androidx.media3.ui.r
        @Override // java.lang.Runnable
        public final void run() {
            e0.this.d0();
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private final Runnable f13753t = new Runnable() { // from class: androidx.media3.ui.x
        @Override // java.lang.Runnable
        public final void run() {
            e0.this.D();
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private final Runnable f13754u = new Runnable() { // from class: androidx.media3.ui.y
        @Override // java.lang.Runnable
        public final void run() {
            e0.this.H();
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f13755v = new Runnable() { // from class: androidx.media3.ui.z
        @Override // java.lang.Runnable
        public final void run() {
            e0.this.G();
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f13756w = new Runnable() { // from class: androidx.media3.ui.a0
        @Override // java.lang.Runnable
        public final void run() {
            e0.this.E();
        }
    };

    /* renamed from: x, reason: collision with root package name */
    private final View.OnLayoutChangeListener f13757x = new View.OnLayoutChangeListener() { // from class: androidx.media3.ui.b0
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            e0.this.S(view, i11, i12, i13, i14, i15, i16, i17, i18);
        }
    };
    private boolean C = true;

    /* renamed from: z, reason: collision with root package name */
    private int f13759z = 0;

    /* renamed from: y, reason: collision with root package name */
    private final List f13758y = new ArrayList();

    /* loaded from: classes2.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e0.this.f13735b != null) {
                e0.this.f13735b.setVisibility(4);
            }
            if (e0.this.f13736c != null) {
                e0.this.f13736c.setVisibility(4);
            }
            if (e0.this.f13738e != null) {
                e0.this.f13738e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(e0.this.f13743j instanceof DefaultTimeBar) || e0.this.A) {
                return;
            }
            ((DefaultTimeBar) e0.this.f13743j).hideScrubber(250L);
        }
    }

    /* loaded from: classes2.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e0.this.f13735b != null) {
                e0.this.f13735b.setVisibility(0);
            }
            if (e0.this.f13736c != null) {
                e0.this.f13736c.setVisibility(0);
            }
            if (e0.this.f13738e != null) {
                e0.this.f13738e.setVisibility(e0.this.A ? 0 : 4);
            }
            if (!(e0.this.f13743j instanceof DefaultTimeBar) || e0.this.A) {
                return;
            }
            ((DefaultTimeBar) e0.this.f13743j).showScrubber(250L);
        }
    }

    /* loaded from: classes2.dex */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerControlView f13762a;

        c(PlayerControlView playerControlView) {
            this.f13762a = playerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e0.this.a0(1);
            if (e0.this.B) {
                this.f13762a.post(e0.this.f13752s);
                e0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e0.this.a0(3);
        }
    }

    /* loaded from: classes2.dex */
    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerControlView f13764a;

        d(PlayerControlView playerControlView) {
            this.f13764a = playerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e0.this.a0(2);
            if (e0.this.B) {
                this.f13764a.post(e0.this.f13752s);
                e0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e0.this.a0(3);
        }
    }

    /* loaded from: classes2.dex */
    class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ PlayerControlView f13766a;

        e(PlayerControlView playerControlView) {
            this.f13766a = playerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e0.this.a0(2);
            if (e0.this.B) {
                this.f13766a.post(e0.this.f13752s);
                e0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e0.this.a0(3);
        }
    }

    /* loaded from: classes2.dex */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e0.this.a0(4);
        }
    }

    /* loaded from: classes2.dex */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            e0.this.a0(4);
        }
    }

    /* loaded from: classes2.dex */
    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e0.this.f13739f != null) {
                e0.this.f13739f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e0.this.f13741h != null) {
                e0.this.f13741h.setVisibility(0);
                e0.this.f13741h.setTranslationX(e0.this.f13741h.getWidth());
                e0.this.f13741h.scrollTo(e0.this.f13741h.getWidth(), 0);
            }
        }
    }

    /* loaded from: classes2.dex */
    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (e0.this.f13741h != null) {
                e0.this.f13741h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (e0.this.f13739f != null) {
                e0.this.f13739f.setVisibility(0);
            }
        }
    }

    public e0(PlayerControlView playerControlView) {
        this.f13734a = playerControlView;
        this.f13735b = playerControlView.findViewById(R$id.exo_controls_background);
        this.f13736c = (ViewGroup) playerControlView.findViewById(R$id.exo_center_controls);
        this.f13738e = (ViewGroup) playerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) playerControlView.findViewById(R$id.exo_bottom_bar);
        this.f13737d = viewGroup;
        this.f13742i = (ViewGroup) playerControlView.findViewById(R$id.exo_time);
        View findViewById = playerControlView.findViewById(R$id.exo_progress);
        this.f13743j = findViewById;
        this.f13739f = (ViewGroup) playerControlView.findViewById(R$id.exo_basic_controls);
        this.f13740g = (ViewGroup) playerControlView.findViewById(R$id.exo_extra_controls);
        this.f13741h = (ViewGroup) playerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View findViewById2 = playerControlView.findViewById(R$id.exo_overflow_show);
        this.f13744k = findViewById2;
        View findViewById3 = playerControlView.findViewById(R$id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.this.U(view);
                }
            });
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: androidx.media3.ui.c0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    e0.this.U(view);
                }
            });
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.d0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e0.this.K(valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.s
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e0.this.L(valueAnimator);
            }
        });
        ofFloat2.addListener(new b());
        Resources resources = playerControlView.getResources();
        float dimension = resources.getDimension(R$dimen.exo_styled_bottom_bar_height) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R$dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f13745l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(playerControlView));
        animatorSet.play(ofFloat).with(O(0.0f, dimension, findViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f13746m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(playerControlView));
        animatorSet2.play(O(dimension, dimension2, findViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f13747n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(playerControlView));
        animatorSet3.play(ofFloat).with(O(0.0f, dimension2, findViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f13748o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(ofFloat2).with(O(dimension, 0.0f, findViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f13749p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(ofFloat2).with(O(dimension2, 0.0f, findViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f13750q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.v
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e0.this.M(valueAnimator);
            }
        });
        ofFloat3.addListener(new h());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f13751r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.media3.ui.w
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                e0.this.N(valueAnimator);
            }
        });
        ofFloat4.addListener(new i());
    }

    private static int B(View view) {
        if (view == null) {
            return 0;
        }
        int width = view.getWidth();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return width;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return width + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        this.f13747n.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        a0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.f13745l.start();
        V(this.f13754u, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f13746m.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f13735b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f13736c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f13738e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f13735b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f13736c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f13738e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(ValueAnimator valueAnimator) {
        y(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private static ObjectAnimator O(float f11, float f12, View view) {
        return ObjectAnimator.ofFloat(view, "translationY", f11, f12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        boolean f02 = f0();
        if (this.A != f02) {
            this.A = f02;
            view.post(new Runnable() { // from class: androidx.media3.ui.t
                @Override // java.lang.Runnable
                public final void run() {
                    e0.this.e0();
                }
            });
        }
        boolean z10 = i13 - i11 != i17 - i15;
        if (this.A || !z10) {
            return;
        }
        view.post(new Runnable() { // from class: androidx.media3.ui.u
            @Override // java.lang.Runnable
            public final void run() {
                e0.this.T();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        int i11;
        if (this.f13739f == null || this.f13740g == null) {
            return;
        }
        int width = (this.f13734a.getWidth() - this.f13734a.getPaddingLeft()) - this.f13734a.getPaddingRight();
        while (true) {
            if (this.f13740g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f13740g.getChildCount() - 2;
            View childAt = this.f13740g.getChildAt(childCount);
            this.f13740g.removeViewAt(childCount);
            this.f13739f.addView(childAt, 0);
        }
        View view = this.f13744k;
        if (view != null) {
            view.setVisibility(8);
        }
        int B = B(this.f13742i);
        int childCount2 = this.f13739f.getChildCount() - 1;
        for (int i12 = 0; i12 < childCount2; i12++) {
            B += B(this.f13739f.getChildAt(i12));
        }
        if (B <= width) {
            ViewGroup viewGroup = this.f13741h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f13751r.isStarted()) {
                return;
            }
            this.f13750q.cancel();
            this.f13751r.start();
            return;
        }
        View view2 = this.f13744k;
        if (view2 != null) {
            view2.setVisibility(0);
            B += B(this.f13744k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = this.f13739f.getChildAt(i13);
            B -= B(childAt2);
            arrayList.add(childAt2);
            if (B <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f13739f.removeViews(0, arrayList.size());
        for (i11 = 0; i11 < arrayList.size(); i11++) {
            this.f13740g.addView((View) arrayList.get(i11), this.f13740g.getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(View view) {
        X();
        if (view.getId() == R$id.exo_overflow_show) {
            this.f13750q.start();
        } else if (view.getId() == R$id.exo_overflow_hide) {
            this.f13751r.start();
        }
    }

    private void V(Runnable runnable, long j11) {
        if (j11 >= 0) {
            this.f13734a.postDelayed(runnable, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i11) {
        int i12 = this.f13759z;
        this.f13759z = i11;
        if (i11 == 2) {
            this.f13734a.setVisibility(8);
        } else if (i12 == 2) {
            this.f13734a.setVisibility(0);
        }
        if (i12 != i11) {
            this.f13734a.Z();
        }
    }

    private boolean b0(View view) {
        int id2 = view.getId();
        return id2 == R$id.exo_bottom_bar || id2 == R$id.exo_prev || id2 == R$id.exo_next || id2 == R$id.exo_rew || id2 == R$id.exo_rew_with_amount || id2 == R$id.exo_ffwd || id2 == R$id.exo_ffwd_with_amount;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0() {
        if (!this.C) {
            a0(0);
            X();
            return;
        }
        int i11 = this.f13759z;
        if (i11 == 1) {
            this.f13748o.start();
        } else if (i11 == 2) {
            this.f13749p.start();
        } else if (i11 == 3) {
            this.B = true;
        } else if (i11 == 4) {
            return;
        }
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        ViewGroup viewGroup = this.f13738e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        if (this.f13743j != null) {
            int dimensionPixelSize = this.f13734a.getResources().getDimensionPixelSize(R$dimen.exo_styled_progress_margin_bottom);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f13743j.getLayoutParams();
            if (marginLayoutParams != null) {
                if (this.A) {
                    dimensionPixelSize = 0;
                }
                marginLayoutParams.bottomMargin = dimensionPixelSize;
                this.f13743j.setLayoutParams(marginLayoutParams);
            }
            View view = this.f13743j;
            if (view instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view;
                if (this.A) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i11 = this.f13759z;
                    if (i11 == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i11 != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View view2 : this.f13758y) {
            view2.setVisibility((this.A && b0(view2)) ? 4 : 0);
        }
    }

    private boolean f0() {
        int width = (this.f13734a.getWidth() - this.f13734a.getPaddingLeft()) - this.f13734a.getPaddingRight();
        int height = (this.f13734a.getHeight() - this.f13734a.getPaddingBottom()) - this.f13734a.getPaddingTop();
        int B = B(this.f13736c);
        ViewGroup viewGroup = this.f13736c;
        int paddingLeft = B - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f13736c.getPaddingRight() : 0);
        int z10 = z(this.f13736c);
        ViewGroup viewGroup2 = this.f13736c;
        return width <= Math.max(paddingLeft, B(this.f13742i) + B(this.f13744k)) || height <= (z10 - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f13736c.getPaddingBottom() : 0)) + (z(this.f13737d) * 2);
    }

    private void y(float f11) {
        if (this.f13741h != null) {
            this.f13741h.setTranslationX((int) (r0.getWidth() * (1.0f - f11)));
        }
        ViewGroup viewGroup = this.f13742i;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f11);
        }
        ViewGroup viewGroup2 = this.f13739f;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(1.0f - f11);
        }
    }

    private static int z(View view) {
        if (view == null) {
            return 0;
        }
        int height = view.getHeight();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return height;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return height + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public boolean A(View view) {
        return view != null && this.f13758y.contains(view);
    }

    public void C() {
        int i11 = this.f13759z;
        if (i11 == 3 || i11 == 2) {
            return;
        }
        W();
        if (!this.C) {
            E();
        } else if (this.f13759z == 1) {
            H();
        } else {
            D();
        }
    }

    public void F() {
        int i11 = this.f13759z;
        if (i11 == 3 || i11 == 2) {
            return;
        }
        W();
        E();
    }

    public boolean I() {
        return this.C;
    }

    public boolean J() {
        return this.f13759z == 0 && this.f13734a.isVisible();
    }

    public void P() {
        this.f13734a.addOnLayoutChangeListener(this.f13757x);
    }

    public void Q() {
        this.f13734a.removeOnLayoutChangeListener(this.f13757x);
    }

    public void R(boolean z10, int i11, int i12, int i13, int i14) {
        View view = this.f13735b;
        if (view != null) {
            view.layout(0, 0, i13 - i11, i14 - i12);
        }
    }

    public void W() {
        this.f13734a.removeCallbacks(this.f13756w);
        this.f13734a.removeCallbacks(this.f13753t);
        this.f13734a.removeCallbacks(this.f13755v);
        this.f13734a.removeCallbacks(this.f13754u);
    }

    public void X() {
        if (this.f13759z == 3) {
            return;
        }
        W();
        int showTimeoutMs = this.f13734a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                V(this.f13756w, showTimeoutMs);
            } else if (this.f13759z == 1) {
                V(this.f13754u, 2000L);
            } else {
                V(this.f13755v, showTimeoutMs);
            }
        }
    }

    public void Y(boolean z10) {
        this.C = z10;
    }

    public void Z(View view, boolean z10) {
        if (view == null) {
            return;
        }
        if (!z10) {
            view.setVisibility(8);
            this.f13758y.remove(view);
            return;
        }
        if (this.A && b0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f13758y.add(view);
    }

    public void c0() {
        if (!this.f13734a.isVisible()) {
            this.f13734a.setVisibility(0);
            this.f13734a.f0();
            this.f13734a.d0();
        }
        d0();
    }
}
