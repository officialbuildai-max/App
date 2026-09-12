package wa;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.RoundedCorner;
import android.view.View;
import android.view.WindowInsets;
import com.google.android.material.R$dimen;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.f0;

/* loaded from: classes5.dex */
public class h extends wa.a {

    /* renamed from: g, reason: collision with root package name */
    private final float f77747g;

    /* renamed from: h, reason: collision with root package name */
    private final float f77748h;

    /* renamed from: i, reason: collision with root package name */
    private float f77749i;

    /* renamed from: j, reason: collision with root package name */
    private Rect f77750j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f77751k;

    /* renamed from: l, reason: collision with root package name */
    private Integer f77752l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f77753a;

        a(View view) {
            this.f77753a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            View view = this.f77753a;
            if (view != null) {
                view.setVisibility(0);
            }
        }
    }

    public h(View view) {
        super(view);
        Resources resources = view.getResources();
        this.f77747g = resources.getDimension(R$dimen.m3_back_progress_main_container_min_edge_gap);
        this.f77748h = resources.getDimension(R$dimen.m3_back_progress_main_container_max_translation_y);
    }

    private ValueAnimator h(final ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(clippableRoundedCornerLayout.getCornerRadius(), k());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: wa.g
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.q(ClippableRoundedCornerLayout.this, valueAnimator);
            }
        });
        return ofFloat;
    }

    private AnimatorSet i(View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ObjectAnimator.ofFloat(this.f77731b, (Property<View, Float>) View.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.f77731b, (Property<View, Float>) View.SCALE_Y, 1.0f), ObjectAnimator.ofFloat(this.f77731b, (Property<View, Float>) View.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.f77731b, (Property<View, Float>) View.TRANSLATION_Y, 0.0f));
        animatorSet.addListener(new a(view));
        return animatorSet;
    }

    private int n() {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 31 || (rootWindowInsets = this.f77731b.getRootWindowInsets()) == null) {
            return 0;
        }
        return Math.max(Math.max(o(rootWindowInsets, 0), o(rootWindowInsets, 1)), Math.max(o(rootWindowInsets, 3), o(rootWindowInsets, 2)));
    }

    private int o(WindowInsets windowInsets, int i11) {
        RoundedCorner roundedCorner;
        int radius;
        roundedCorner = windowInsets.getRoundedCorner(i11);
        if (roundedCorner == null) {
            return 0;
        }
        radius = roundedCorner.getRadius();
        return radius;
    }

    private boolean p() {
        int[] iArr = new int[2];
        this.f77731b.getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(ClippableRoundedCornerLayout clippableRoundedCornerLayout, ValueAnimator valueAnimator) {
        clippableRoundedCornerLayout.updateCornerRadius(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void r() {
        this.f77749i = 0.0f;
        this.f77750j = null;
        this.f77751k = null;
    }

    public void g(View view) {
        if (super.b() == null) {
            return;
        }
        AnimatorSet i11 = i(view);
        View view2 = this.f77731b;
        if (view2 instanceof ClippableRoundedCornerLayout) {
            i11.playTogether(h((ClippableRoundedCornerLayout) view2));
        }
        i11.setDuration(this.f77734e);
        i11.start();
        r();
    }

    public void j(long j11, View view) {
        AnimatorSet i11 = i(view);
        i11.setDuration(j11);
        i11.start();
        r();
    }

    public int k() {
        if (this.f77752l == null) {
            this.f77752l = Integer.valueOf(p() ? n() : 0);
        }
        return this.f77752l.intValue();
    }

    public Rect l() {
        return this.f77751k;
    }

    public Rect m() {
        return this.f77750j;
    }

    public void s(float f11, View view) {
        this.f77750j = f0.c(this.f77731b);
        if (view != null) {
            this.f77751k = f0.b(this.f77731b, view);
        }
        this.f77749i = f11;
    }

    public void t(androidx.activity.b bVar, View view) {
        super.d(bVar);
        s(bVar.c(), view);
    }

    public void u(float f11, boolean z10, float f12, float f13) {
        float a11 = a(f11);
        float width = this.f77731b.getWidth();
        float height = this.f77731b.getHeight();
        if (width <= 0.0f || height <= 0.0f) {
            return;
        }
        float a12 = oa.a.a(1.0f, 0.9f, a11);
        float a13 = oa.a.a(0.0f, Math.max(0.0f, ((width - (0.9f * width)) / 2.0f) - this.f77747g), a11) * (z10 ? 1 : -1);
        float min = Math.min(Math.max(0.0f, ((height - (a12 * height)) / 2.0f) - this.f77747g), this.f77748h);
        float f14 = f12 - this.f77749i;
        float a14 = oa.a.a(0.0f, min, Math.abs(f14) / height) * Math.signum(f14);
        this.f77731b.setScaleX(a12);
        this.f77731b.setScaleY(a12);
        this.f77731b.setTranslationX(a13);
        this.f77731b.setTranslationY(a14);
        View view = this.f77731b;
        if (view instanceof ClippableRoundedCornerLayout) {
            ((ClippableRoundedCornerLayout) view).updateCornerRadius(oa.a.a(k(), f13, a11));
        }
    }

    public void v(androidx.activity.b bVar, View view, float f11) {
        if (super.e(bVar) == null) {
            return;
        }
        if (view != null && view.getVisibility() != 4) {
            view.setVisibility(4);
        }
        u(bVar.a(), bVar.b() == 0, bVar.c(), f11);
    }
}
