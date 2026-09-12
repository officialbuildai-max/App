package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$id;
import com.google.android.material.circularreveal.c;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;
import oa.h;
import oa.i;
import oa.j;

@Deprecated
/* loaded from: classes4.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: c, reason: collision with root package name */
    private final Rect f30216c;

    /* renamed from: d, reason: collision with root package name */
    private final RectF f30217d;

    /* renamed from: e, reason: collision with root package name */
    private final RectF f30218e;

    /* renamed from: f, reason: collision with root package name */
    private final int[] f30219f;

    /* renamed from: g, reason: collision with root package name */
    private float f30220g;

    /* renamed from: h, reason: collision with root package name */
    private float f30221h;

    /* loaded from: classes4.dex */
    class a extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f30222a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ View f30223b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ View f30224c;

        a(boolean z10, View view, View view2) {
            this.f30222a = z10;
            this.f30223b = view;
            this.f30224c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f30222a) {
                return;
            }
            this.f30223b.setVisibility(4);
            this.f30224c.setAlpha(1.0f);
            this.f30224c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.f30222a) {
                this.f30223b.setVisibility(0);
                this.f30224c.setAlpha(0.0f);
                this.f30224c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f30226a;

        b(View view) {
            this.f30226a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.f30226a.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f30228a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Drawable f30229b;

        c(com.google.android.material.circularreveal.c cVar, Drawable drawable) {
            this.f30228a = cVar;
            this.f30229b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f30228a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f30228a.setCircularRevealOverlayDrawable(this.f30229b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class d extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.android.material.circularreveal.c f30231a;

        d(com.google.android.material.circularreveal.c cVar) {
            this.f30231a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.f30231a.getRevealInfo();
            revealInfo.f28812c = Float.MAX_VALUE;
            this.f30231a.setRevealInfo(revealInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public h f30233a;

        /* renamed from: b, reason: collision with root package name */
        public j f30234b;
    }

    public FabTransformationBehavior() {
        this.f30216c = new Rect();
        this.f30217d = new RectF();
        this.f30218e = new RectF();
        this.f30219f = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f30216c = new Rect();
        this.f30217d = new RectF();
        this.f30218e = new RectF();
        this.f30219f = new int[2];
    }

    private ViewGroup K(View view) {
        View findViewById = view.findViewById(R$id.mtrl_child_content_container);
        return findViewById != null ? f0(findViewById) : ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) ? f0(((ViewGroup) view).getChildAt(0)) : f0(view);
    }

    private void L(View view, e eVar, i iVar, i iVar2, float f11, float f12, float f13, float f14, RectF rectF) {
        float S = S(eVar, iVar, f11, f13);
        float S2 = S(eVar, iVar2, f12, f14);
        Rect rect = this.f30216c;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f30217d;
        rectF2.set(rect);
        RectF rectF3 = this.f30218e;
        T(view, rectF3);
        rectF3.offset(S, S2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void M(View view, RectF rectF) {
        T(view, rectF);
        rectF.offset(this.f30220g, this.f30221h);
    }

    private Pair N(float f11, float f12, boolean z10, e eVar) {
        i h11;
        i h12;
        if (f11 == 0.0f || f12 == 0.0f) {
            h11 = eVar.f30233a.h("translationXLinear");
            h12 = eVar.f30233a.h("translationYLinear");
        } else if ((!z10 || f12 >= 0.0f) && (z10 || f12 <= 0.0f)) {
            h11 = eVar.f30233a.h("translationXCurveDownwards");
            h12 = eVar.f30233a.h("translationYCurveDownwards");
        } else {
            h11 = eVar.f30233a.h("translationXCurveUpwards");
            h12 = eVar.f30233a.h("translationYCurveUpwards");
        }
        return new Pair(h11, h12);
    }

    private float O(View view, View view2, j jVar) {
        RectF rectF = this.f30217d;
        RectF rectF2 = this.f30218e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(-Q(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float P(View view, View view2, j jVar) {
        RectF rectF = this.f30217d;
        RectF rectF2 = this.f30218e;
        M(view, rectF);
        T(view2, rectF2);
        rectF2.offset(0.0f, -R(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float Q(View view, View view2, j jVar) {
        float centerX;
        float centerX2;
        float f11;
        RectF rectF = this.f30217d;
        RectF rectF2 = this.f30218e;
        M(view, rectF);
        T(view2, rectF2);
        int i11 = jVar.f71061a & 7;
        if (i11 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i11 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else {
            if (i11 != 5) {
                f11 = 0.0f;
                return f11 + jVar.f71062b;
            }
            centerX = rectF2.right;
            centerX2 = rectF.right;
        }
        f11 = centerX - centerX2;
        return f11 + jVar.f71062b;
    }

    private float R(View view, View view2, j jVar) {
        float centerY;
        float centerY2;
        float f11;
        RectF rectF = this.f30217d;
        RectF rectF2 = this.f30218e;
        M(view, rectF);
        T(view2, rectF2);
        int i11 = jVar.f71061a & 112;
        if (i11 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i11 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else {
            if (i11 != 80) {
                f11 = 0.0f;
                return f11 + jVar.f71063c;
            }
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        }
        f11 = centerY - centerY2;
        return f11 + jVar.f71063c;
    }

    private float S(e eVar, i iVar, float f11, float f12) {
        long c11 = iVar.c();
        long d11 = iVar.d();
        i h11 = eVar.f30233a.h("expansion");
        return oa.a.a(f11, f12, iVar.e().getInterpolation(((float) (((h11.c() + h11.d()) + 17) - c11)) / ((float) d11)));
    }

    private void T(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f30219f);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void U(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ViewGroup K;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof com.google.android.material.circularreveal.c) && com.google.android.material.circularreveal.b.f28796j == 0) || (K = K(view2)) == null) {
                return;
            }
            if (z10) {
                if (!z11) {
                    oa.d.f71047a.set(K, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(K, (Property<ViewGroup, Float>) oa.d.f71047a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(K, (Property<ViewGroup, Float>) oa.d.f71047a, 0.0f);
            }
            eVar.f30233a.h("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void V(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            int d02 = d0(view);
            int i11 = 16777215 & d02;
            if (z10) {
                if (!z11) {
                    cVar.setCircularRevealScrimColor(d02);
                }
                ofInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) c.d.f28809a, i11);
            } else {
                ofInt = ObjectAnimator.ofInt(cVar, (Property<com.google.android.material.circularreveal.c, Integer>) c.d.f28809a, d02);
            }
            ofInt.setEvaluator(oa.c.b());
            eVar.f30233a.h(TtmlNode.ATTR_TTS_COLOR).a(ofInt);
            list.add(ofInt);
        }
    }

    private void W(View view, View view2, boolean z10, e eVar, List list) {
        float Q = Q(view, view2, eVar.f30234b);
        float R = R(view, view2, eVar.f30234b);
        Pair N = N(Q, R, z10, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        Property property = View.TRANSLATION_X;
        if (!z10) {
            Q = this.f30220g;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, Q);
        Property property2 = View.TRANSLATION_Y;
        if (!z10) {
            R = this.f30221h;
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, R);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private void X(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ObjectAnimator ofFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z10) {
            if (!z11) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        eVar.f30233a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Y(View view, View view2, boolean z10, boolean z11, e eVar, float f11, float f12, List list, List list2) {
        Animator animator;
        if (view2 instanceof com.google.android.material.circularreveal.c) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            float O = O(view, view2, eVar.f30234b);
            float P = P(view, view2, eVar.f30234b);
            ((FloatingActionButton) view).getContentRect(this.f30216c);
            float width = this.f30216c.width() / 2.0f;
            i h11 = eVar.f30233a.h("expansion");
            if (z10) {
                if (!z11) {
                    cVar.setRevealInfo(new c.e(O, P, width));
                }
                if (z11) {
                    width = cVar.getRevealInfo().f28812c;
                }
                animator = com.google.android.material.circularreveal.a.a(cVar, O, P, va.a.b(O, P, 0.0f, 0.0f, f11, f12));
                animator.addListener(new d(cVar));
                b0(view2, h11.c(), (int) O, (int) P, width, list);
            } else {
                float f13 = cVar.getRevealInfo().f28812c;
                Animator a11 = com.google.android.material.circularreveal.a.a(cVar, O, P, width);
                int i11 = (int) O;
                int i12 = (int) P;
                b0(view2, h11.c(), i11, i12, f13, list);
                a0(view2, h11.c(), h11.d(), eVar.f30233a.i(), i11, i12, width, list);
                animator = a11;
            }
            h11.a(animator);
            list.add(animator);
            list2.add(com.google.android.material.circularreveal.a.b(cVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Z(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof com.google.android.material.circularreveal.c) && (view instanceof ImageView)) {
            com.google.android.material.circularreveal.c cVar = (com.google.android.material.circularreveal.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z10) {
                if (!z11) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) oa.e.f71048b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, (Property<Drawable, Integer>) oa.e.f71048b, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.f30233a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(cVar, drawable));
        }
    }

    private void a0(View view, long j11, long j12, long j13, int i11, int i12, float f11, List list) {
        long j14 = j11 + j12;
        if (j14 < j13) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i11, i12, f11, f11);
            createCircularReveal.setStartDelay(j14);
            createCircularReveal.setDuration(j13 - j14);
            list.add(createCircularReveal);
        }
    }

    private void b0(View view, long j11, int i11, int i12, float f11, List list) {
        if (j11 > 0) {
            Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i11, i12, f11, f11);
            createCircularReveal.setStartDelay(0L);
            createCircularReveal.setDuration(j11);
            list.add(createCircularReveal);
        }
    }

    private void c0(View view, View view2, boolean z10, boolean z11, e eVar, List list, List list2, RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float Q = Q(view, view2, eVar.f30234b);
        float R = R(view, view2, eVar.f30234b);
        Pair N = N(Q, R, z10, eVar);
        i iVar = (i) N.first;
        i iVar2 = (i) N.second;
        if (z10) {
            if (!z11) {
                view2.setTranslationX(-Q);
                view2.setTranslationY(-R);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            L(view2, eVar, iVar, iVar2, -Q, -R, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -Q);
            ofFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -R);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    private int d0(View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    private ViewGroup f0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    protected AnimatorSet J(View view, View view2, boolean z10, boolean z11) {
        e e02 = e0(view2.getContext(), z10);
        if (z10) {
            this.f30220g = view.getTranslationX();
            this.f30221h = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        X(view, view2, z10, z11, e02, arrayList, arrayList2);
        RectF rectF = this.f30217d;
        c0(view, view2, z10, z11, e02, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        W(view, view2, z10, e02, arrayList);
        Z(view, view2, z10, z11, e02, arrayList, arrayList2);
        Y(view, view2, z10, z11, e02, width, height, arrayList, arrayList2);
        V(view, view2, z10, z11, e02, arrayList, arrayList2);
        U(view, view2, z10, z11, e02, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        oa.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z10, view2, view));
        int size = arrayList2.size();
        for (int i11 = 0; i11 < size; i11++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i11));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean e(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    protected abstract e e0(Context context, boolean z10);

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void g(CoordinatorLayout.f fVar) {
        if (fVar.f7989h == 0) {
            fVar.f7989h = 80;
        }
    }
}
