package com.google.android.exoplayer2.ui;

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
/* loaded from: classes3.dex */
public final class i0 {
    private boolean A;
    private boolean B;

    /* renamed from: a, reason: collision with root package name */
    private final StyledPlayerControlView f27181a;

    /* renamed from: b, reason: collision with root package name */
    private final View f27182b;

    /* renamed from: c, reason: collision with root package name */
    private final ViewGroup f27183c;

    /* renamed from: d, reason: collision with root package name */
    private final ViewGroup f27184d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewGroup f27185e;

    /* renamed from: f, reason: collision with root package name */
    private final ViewGroup f27186f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewGroup f27187g;

    /* renamed from: h, reason: collision with root package name */
    private final ViewGroup f27188h;

    /* renamed from: i, reason: collision with root package name */
    private final ViewGroup f27189i;

    /* renamed from: j, reason: collision with root package name */
    private final View f27190j;

    /* renamed from: k, reason: collision with root package name */
    private final View f27191k;

    /* renamed from: l, reason: collision with root package name */
    private final AnimatorSet f27192l;

    /* renamed from: m, reason: collision with root package name */
    private final AnimatorSet f27193m;

    /* renamed from: n, reason: collision with root package name */
    private final AnimatorSet f27194n;

    /* renamed from: o, reason: collision with root package name */
    private final AnimatorSet f27195o;

    /* renamed from: p, reason: collision with root package name */
    private final AnimatorSet f27196p;

    /* renamed from: q, reason: collision with root package name */
    private final ValueAnimator f27197q;

    /* renamed from: r, reason: collision with root package name */
    private final ValueAnimator f27198r;

    /* renamed from: s, reason: collision with root package name */
    private final Runnable f27199s = new Runnable() { // from class: com.google.android.exoplayer2.ui.v
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.d0();
        }
    };

    /* renamed from: t, reason: collision with root package name */
    private final Runnable f27200t = new Runnable() { // from class: com.google.android.exoplayer2.ui.b0
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.D();
        }
    };

    /* renamed from: u, reason: collision with root package name */
    private final Runnable f27201u = new Runnable() { // from class: com.google.android.exoplayer2.ui.c0
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.H();
        }
    };

    /* renamed from: v, reason: collision with root package name */
    private final Runnable f27202v = new Runnable() { // from class: com.google.android.exoplayer2.ui.d0
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.G();
        }
    };

    /* renamed from: w, reason: collision with root package name */
    private final Runnable f27203w = new Runnable() { // from class: com.google.android.exoplayer2.ui.e0
        @Override // java.lang.Runnable
        public final void run() {
            i0.this.E();
        }
    };

    /* renamed from: x, reason: collision with root package name */
    private final View.OnLayoutChangeListener f27204x = new View.OnLayoutChangeListener() { // from class: com.google.android.exoplayer2.ui.f0
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            i0.this.S(view, i11, i12, i13, i14, i15, i16, i17, i18);
        }
    };
    private boolean C = true;

    /* renamed from: z, reason: collision with root package name */
    private int f27206z = 0;

    /* renamed from: y, reason: collision with root package name */
    private final List f27205y = new ArrayList();

    /* loaded from: classes3.dex */
    class a extends AnimatorListenerAdapter {
        a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i0.this.f27182b != null) {
                i0.this.f27182b.setVisibility(4);
            }
            if (i0.this.f27183c != null) {
                i0.this.f27183c.setVisibility(4);
            }
            if (i0.this.f27185e != null) {
                i0.this.f27185e.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (!(i0.this.f27190j instanceof DefaultTimeBar) || i0.this.A) {
                return;
            }
            ((DefaultTimeBar) i0.this.f27190j).hideScrubber(250L);
        }
    }

    /* loaded from: classes3.dex */
    class b extends AnimatorListenerAdapter {
        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (i0.this.f27182b != null) {
                i0.this.f27182b.setVisibility(0);
            }
            if (i0.this.f27183c != null) {
                i0.this.f27183c.setVisibility(0);
            }
            if (i0.this.f27185e != null) {
                i0.this.f27185e.setVisibility(i0.this.A ? 0 : 4);
            }
            if (!(i0.this.f27190j instanceof DefaultTimeBar) || i0.this.A) {
                return;
            }
            ((DefaultTimeBar) i0.this.f27190j).showScrubber(250L);
        }
    }

    /* loaded from: classes3.dex */
    class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f27209a;

        c(StyledPlayerControlView styledPlayerControlView) {
            this.f27209a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(1);
            if (i0.this.B) {
                this.f27209a.post(i0.this.f27199s);
                i0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(3);
        }
    }

    /* loaded from: classes3.dex */
    class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f27211a;

        d(StyledPlayerControlView styledPlayerControlView) {
            this.f27211a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(2);
            if (i0.this.B) {
                this.f27211a.post(i0.this.f27199s);
                i0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(3);
        }
    }

    /* loaded from: classes3.dex */
    class e extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ StyledPlayerControlView f27213a;

        e(StyledPlayerControlView styledPlayerControlView) {
            this.f27213a = styledPlayerControlView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(2);
            if (i0.this.B) {
                this.f27213a.post(i0.this.f27199s);
                i0.this.B = false;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(3);
        }
    }

    /* loaded from: classes3.dex */
    class f extends AnimatorListenerAdapter {
        f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(4);
        }
    }

    /* loaded from: classes3.dex */
    class g extends AnimatorListenerAdapter {
        g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i0.this.a0(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            i0.this.a0(4);
        }
    }

    /* loaded from: classes3.dex */
    class h extends AnimatorListenerAdapter {
        h() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i0.this.f27186f != null) {
                i0.this.f27186f.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (i0.this.f27188h != null) {
                i0.this.f27188h.setVisibility(0);
                i0.this.f27188h.setTranslationX(i0.this.f27188h.getWidth());
                i0.this.f27188h.scrollTo(i0.this.f27188h.getWidth(), 0);
            }
        }
    }

    /* loaded from: classes3.dex */
    class i extends AnimatorListenerAdapter {
        i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (i0.this.f27188h != null) {
                i0.this.f27188h.setVisibility(4);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (i0.this.f27186f != null) {
                i0.this.f27186f.setVisibility(0);
            }
        }
    }

    public i0(StyledPlayerControlView styledPlayerControlView) {
        this.f27181a = styledPlayerControlView;
        this.f27182b = styledPlayerControlView.findViewById(R$id.exo_controls_background);
        this.f27183c = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_center_controls);
        this.f27185e = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_minimal_controls);
        ViewGroup viewGroup = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_bottom_bar);
        this.f27184d = viewGroup;
        this.f27189i = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_time);
        View findViewById = styledPlayerControlView.findViewById(R$id.exo_progress);
        this.f27190j = findViewById;
        this.f27186f = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_basic_controls);
        this.f27187g = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls);
        this.f27188h = (ViewGroup) styledPlayerControlView.findViewById(R$id.exo_extra_controls_scroll_view);
        View findViewById2 = styledPlayerControlView.findViewById(R$id.exo_overflow_show);
        this.f27191k = findViewById2;
        View findViewById3 = styledPlayerControlView.findViewById(R$id.exo_overflow_hide);
        if (findViewById2 != null && findViewById3 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.this.U(view);
                }
            });
            findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.exoplayer2.ui.g0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    i0.this.U(view);
                }
            });
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.h0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i0.this.K(valueAnimator);
            }
        });
        ofFloat.addListener(new a());
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.w
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i0.this.L(valueAnimator);
            }
        });
        ofFloat2.addListener(new b());
        Resources resources = styledPlayerControlView.getResources();
        float dimension = resources.getDimension(R$dimen.exo_styled_bottom_bar_height) - resources.getDimension(R$dimen.exo_styled_progress_bar_height);
        float dimension2 = resources.getDimension(R$dimen.exo_styled_bottom_bar_height);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f27192l = animatorSet;
        animatorSet.setDuration(250L);
        animatorSet.addListener(new c(styledPlayerControlView));
        animatorSet.play(ofFloat).with(O(0.0f, dimension, findViewById)).with(O(0.0f, dimension, viewGroup));
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f27193m = animatorSet2;
        animatorSet2.setDuration(250L);
        animatorSet2.addListener(new d(styledPlayerControlView));
        animatorSet2.play(O(dimension, dimension2, findViewById)).with(O(dimension, dimension2, viewGroup));
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.f27194n = animatorSet3;
        animatorSet3.setDuration(250L);
        animatorSet3.addListener(new e(styledPlayerControlView));
        animatorSet3.play(ofFloat).with(O(0.0f, dimension2, findViewById)).with(O(0.0f, dimension2, viewGroup));
        AnimatorSet animatorSet4 = new AnimatorSet();
        this.f27195o = animatorSet4;
        animatorSet4.setDuration(250L);
        animatorSet4.addListener(new f());
        animatorSet4.play(ofFloat2).with(O(dimension, 0.0f, findViewById)).with(O(dimension, 0.0f, viewGroup));
        AnimatorSet animatorSet5 = new AnimatorSet();
        this.f27196p = animatorSet5;
        animatorSet5.setDuration(250L);
        animatorSet5.addListener(new g());
        animatorSet5.play(ofFloat2).with(O(dimension2, 0.0f, findViewById)).with(O(dimension2, 0.0f, viewGroup));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f27197q = ofFloat3;
        ofFloat3.setDuration(250L);
        ofFloat3.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.z
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i0.this.M(valueAnimator);
            }
        });
        ofFloat3.addListener(new h());
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f27198r = ofFloat4;
        ofFloat4.setDuration(250L);
        ofFloat4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.exoplayer2.ui.a0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                i0.this.N(valueAnimator);
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
        this.f27194n.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        a0(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G() {
        this.f27192l.start();
        V(this.f27201u, 2000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f27193m.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f27182b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f27183c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f27185e;
        if (viewGroup2 != null) {
            viewGroup2.setAlpha(floatValue);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        View view = this.f27182b;
        if (view != null) {
            view.setAlpha(floatValue);
        }
        ViewGroup viewGroup = this.f27183c;
        if (viewGroup != null) {
            viewGroup.setAlpha(floatValue);
        }
        ViewGroup viewGroup2 = this.f27185e;
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
            view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.x
                @Override // java.lang.Runnable
                public final void run() {
                    i0.this.e0();
                }
            });
        }
        boolean z10 = i13 - i11 != i17 - i15;
        if (this.A || !z10) {
            return;
        }
        view.post(new Runnable() { // from class: com.google.android.exoplayer2.ui.y
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.T();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        int i11;
        if (this.f27186f == null || this.f27187g == null) {
            return;
        }
        int width = (this.f27181a.getWidth() - this.f27181a.getPaddingLeft()) - this.f27181a.getPaddingRight();
        while (true) {
            if (this.f27187g.getChildCount() <= 1) {
                break;
            }
            int childCount = this.f27187g.getChildCount() - 2;
            View childAt = this.f27187g.getChildAt(childCount);
            this.f27187g.removeViewAt(childCount);
            this.f27186f.addView(childAt, 0);
        }
        View view = this.f27191k;
        if (view != null) {
            view.setVisibility(8);
        }
        int B = B(this.f27189i);
        int childCount2 = this.f27186f.getChildCount() - 1;
        for (int i12 = 0; i12 < childCount2; i12++) {
            B += B(this.f27186f.getChildAt(i12));
        }
        if (B <= width) {
            ViewGroup viewGroup = this.f27188h;
            if (viewGroup == null || viewGroup.getVisibility() != 0 || this.f27198r.isStarted()) {
                return;
            }
            this.f27197q.cancel();
            this.f27198r.start();
            return;
        }
        View view2 = this.f27191k;
        if (view2 != null) {
            view2.setVisibility(0);
            B += B(this.f27191k);
        }
        ArrayList arrayList = new ArrayList();
        for (int i13 = 0; i13 < childCount2; i13++) {
            View childAt2 = this.f27186f.getChildAt(i13);
            B -= B(childAt2);
            arrayList.add(childAt2);
            if (B <= width) {
                break;
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.f27186f.removeViews(0, arrayList.size());
        for (i11 = 0; i11 < arrayList.size(); i11++) {
            this.f27187g.addView((View) arrayList.get(i11), this.f27187g.getChildCount() - 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(View view) {
        X();
        if (view.getId() == R$id.exo_overflow_show) {
            this.f27197q.start();
        } else if (view.getId() == R$id.exo_overflow_hide) {
            this.f27198r.start();
        }
    }

    private void V(Runnable runnable, long j11) {
        if (j11 >= 0) {
            this.f27181a.postDelayed(runnable, j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0(int i11) {
        int i12 = this.f27206z;
        this.f27206z = i11;
        if (i11 == 2) {
            this.f27181a.setVisibility(8);
        } else if (i12 == 2) {
            this.f27181a.setVisibility(0);
        }
        if (i12 != i11) {
            this.f27181a.c0();
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
        int i11 = this.f27206z;
        if (i11 == 1) {
            this.f27195o.start();
        } else if (i11 == 2) {
            this.f27196p.start();
        } else if (i11 == 3) {
            this.B = true;
        } else if (i11 == 4) {
            return;
        }
        X();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e0() {
        ViewGroup viewGroup = this.f27185e;
        if (viewGroup != null) {
            viewGroup.setVisibility(this.A ? 0 : 4);
        }
        View view = this.f27190j;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            int dimensionPixelSize = this.f27181a.getResources().getDimensionPixelSize(R$dimen.exo_styled_progress_margin_bottom);
            if (this.A) {
                dimensionPixelSize = 0;
            }
            marginLayoutParams.bottomMargin = dimensionPixelSize;
            this.f27190j.setLayoutParams(marginLayoutParams);
            View view2 = this.f27190j;
            if (view2 instanceof DefaultTimeBar) {
                DefaultTimeBar defaultTimeBar = (DefaultTimeBar) view2;
                if (this.A) {
                    defaultTimeBar.hideScrubber(true);
                } else {
                    int i11 = this.f27206z;
                    if (i11 == 1) {
                        defaultTimeBar.hideScrubber(false);
                    } else if (i11 != 3) {
                        defaultTimeBar.showScrubber();
                    }
                }
            }
        }
        for (View view3 : this.f27205y) {
            view3.setVisibility((this.A && b0(view3)) ? 4 : 0);
        }
    }

    private boolean f0() {
        int width = (this.f27181a.getWidth() - this.f27181a.getPaddingLeft()) - this.f27181a.getPaddingRight();
        int height = (this.f27181a.getHeight() - this.f27181a.getPaddingBottom()) - this.f27181a.getPaddingTop();
        int B = B(this.f27183c);
        ViewGroup viewGroup = this.f27183c;
        int paddingLeft = B - (viewGroup != null ? viewGroup.getPaddingLeft() + this.f27183c.getPaddingRight() : 0);
        int z10 = z(this.f27183c);
        ViewGroup viewGroup2 = this.f27183c;
        return width <= Math.max(paddingLeft, B(this.f27189i) + B(this.f27191k)) || height <= (z10 - (viewGroup2 != null ? viewGroup2.getPaddingTop() + this.f27183c.getPaddingBottom() : 0)) + (z(this.f27184d) * 2);
    }

    private void y(float f11) {
        if (this.f27188h != null) {
            this.f27188h.setTranslationX((int) (r0.getWidth() * (1.0f - f11)));
        }
        ViewGroup viewGroup = this.f27189i;
        if (viewGroup != null) {
            viewGroup.setAlpha(1.0f - f11);
        }
        ViewGroup viewGroup2 = this.f27186f;
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
        return view != null && this.f27205y.contains(view);
    }

    public void C() {
        int i11 = this.f27206z;
        if (i11 == 3 || i11 == 2) {
            return;
        }
        W();
        if (!this.C) {
            E();
        } else if (this.f27206z == 1) {
            H();
        } else {
            D();
        }
    }

    public void F() {
        int i11 = this.f27206z;
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
        return this.f27206z == 0 && this.f27181a.isVisible();
    }

    public void P() {
        this.f27181a.addOnLayoutChangeListener(this.f27204x);
    }

    public void Q() {
        this.f27181a.removeOnLayoutChangeListener(this.f27204x);
    }

    public void R(boolean z10, int i11, int i12, int i13, int i14) {
        View view = this.f27182b;
        if (view != null) {
            view.layout(0, 0, i13 - i11, i14 - i12);
        }
    }

    public void W() {
        this.f27181a.removeCallbacks(this.f27203w);
        this.f27181a.removeCallbacks(this.f27200t);
        this.f27181a.removeCallbacks(this.f27202v);
        this.f27181a.removeCallbacks(this.f27201u);
    }

    public void X() {
        if (this.f27206z == 3) {
            return;
        }
        W();
        int showTimeoutMs = this.f27181a.getShowTimeoutMs();
        if (showTimeoutMs > 0) {
            if (!this.C) {
                V(this.f27203w, showTimeoutMs);
            } else if (this.f27206z == 1) {
                V(this.f27201u, 2000L);
            } else {
                V(this.f27202v, showTimeoutMs);
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
            this.f27205y.remove(view);
            return;
        }
        if (this.A && b0(view)) {
            view.setVisibility(4);
        } else {
            view.setVisibility(0);
        }
        this.f27205y.add(view);
    }

    public void c0() {
        if (!this.f27181a.isVisible()) {
            this.f27181a.setVisibility(0);
            this.f27181a.k0();
            this.f27181a.g0();
        }
        d0();
    }
}
