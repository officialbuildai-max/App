package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.j;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.Map;

/* loaded from: classes2.dex */
public class b extends j {
    private static final String[] O = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    private static final Property P = new a(PointF.class, "topLeft");
    private static final Property Q = new C0133b(PointF.class, "bottomRight");
    private static final Property R = new c(PointF.class, "bottomRight");
    private static final Property S = new d(PointF.class, "topLeft");
    private static final Property T = new e(PointF.class, RequestParameters.POSITION);
    private static final androidx.transition.h U = new androidx.transition.h();
    private boolean N = false;

    /* loaded from: classes2.dex */
    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    /* renamed from: androidx.transition.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0133b extends Property {
        C0133b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    /* loaded from: classes2.dex */
    class c extends Property {
        c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            z.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* loaded from: classes2.dex */
    class d extends Property {
        d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            z.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* loaded from: classes2.dex */
    class e extends Property {
        e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            z.d(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* loaded from: classes2.dex */
    class f extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ i f15067a;
        private final i mViewBounds;

        f(i iVar) {
            this.f15067a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* loaded from: classes2.dex */
    private static class g extends AnimatorListenerAdapter implements j.f {

        /* renamed from: a, reason: collision with root package name */
        private final View f15069a;

        /* renamed from: b, reason: collision with root package name */
        private final Rect f15070b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f15071c;

        /* renamed from: d, reason: collision with root package name */
        private final Rect f15072d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean f15073e;

        /* renamed from: f, reason: collision with root package name */
        private final int f15074f;

        /* renamed from: g, reason: collision with root package name */
        private final int f15075g;

        /* renamed from: h, reason: collision with root package name */
        private final int f15076h;

        /* renamed from: i, reason: collision with root package name */
        private final int f15077i;

        /* renamed from: j, reason: collision with root package name */
        private final int f15078j;

        /* renamed from: k, reason: collision with root package name */
        private final int f15079k;

        /* renamed from: l, reason: collision with root package name */
        private final int f15080l;

        /* renamed from: m, reason: collision with root package name */
        private final int f15081m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f15082n;

        g(View view, Rect rect, boolean z10, Rect rect2, boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
            this.f15069a = view;
            this.f15070b = rect;
            this.f15071c = z10;
            this.f15072d = rect2;
            this.f15073e = z11;
            this.f15074f = i11;
            this.f15075g = i12;
            this.f15076h = i13;
            this.f15077i = i14;
            this.f15078j = i15;
            this.f15079k = i16;
            this.f15080l = i17;
            this.f15081m = i18;
        }

        @Override // androidx.transition.j.f
        public void a(j jVar) {
            Rect rect = (Rect) this.f15069a.getTag(R$id.transition_clip);
            this.f15069a.setTag(R$id.transition_clip, null);
            this.f15069a.setClipBounds(rect);
        }

        @Override // androidx.transition.j.f
        public void b(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void c(j jVar) {
            this.f15069a.setTag(R$id.transition_clip, this.f15069a.getClipBounds());
            this.f15069a.setClipBounds(this.f15073e ? null : this.f15072d);
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void d(j jVar, boolean z10) {
            k.a(this, jVar, z10);
        }

        @Override // androidx.transition.j.f
        public void e(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void f(j jVar) {
            this.f15082n = true;
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void g(j jVar, boolean z10) {
            k.b(this, jVar, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (this.f15082n) {
                return;
            }
            Rect rect = null;
            if (z10) {
                if (!this.f15071c) {
                    rect = this.f15070b;
                }
            } else if (!this.f15073e) {
                rect = this.f15072d;
            }
            this.f15069a.setClipBounds(rect);
            if (z10) {
                z.d(this.f15069a, this.f15074f, this.f15075g, this.f15076h, this.f15077i);
            } else {
                z.d(this.f15069a, this.f15078j, this.f15079k, this.f15080l, this.f15081m);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            int max = Math.max(this.f15076h - this.f15074f, this.f15080l - this.f15078j);
            int max2 = Math.max(this.f15077i - this.f15075g, this.f15081m - this.f15079k);
            int i11 = z10 ? this.f15078j : this.f15074f;
            int i12 = z10 ? this.f15079k : this.f15075g;
            z.d(this.f15069a, i11, i12, max + i11, max2 + i12);
            this.f15069a.setClipBounds(z10 ? this.f15072d : this.f15070b);
        }
    }

    /* loaded from: classes2.dex */
    private static class h extends r {

        /* renamed from: a, reason: collision with root package name */
        boolean f15083a = false;

        /* renamed from: b, reason: collision with root package name */
        final ViewGroup f15084b;

        h(ViewGroup viewGroup) {
            this.f15084b = viewGroup;
        }

        @Override // androidx.transition.r, androidx.transition.j.f
        public void a(j jVar) {
            y.b(this.f15084b, true);
        }

        @Override // androidx.transition.r, androidx.transition.j.f
        public void c(j jVar) {
            y.b(this.f15084b, false);
        }

        @Override // androidx.transition.r, androidx.transition.j.f
        public void e(j jVar) {
            if (!this.f15083a) {
                y.b(this.f15084b, false);
            }
            jVar.S(this);
        }

        @Override // androidx.transition.r, androidx.transition.j.f
        public void f(j jVar) {
            y.b(this.f15084b, false);
            this.f15083a = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        private int f15085a;

        /* renamed from: b, reason: collision with root package name */
        private int f15086b;

        /* renamed from: c, reason: collision with root package name */
        private int f15087c;

        /* renamed from: d, reason: collision with root package name */
        private int f15088d;

        /* renamed from: e, reason: collision with root package name */
        private final View f15089e;

        /* renamed from: f, reason: collision with root package name */
        private int f15090f;

        /* renamed from: g, reason: collision with root package name */
        private int f15091g;

        i(View view) {
            this.f15089e = view;
        }

        private void b() {
            z.d(this.f15089e, this.f15085a, this.f15086b, this.f15087c, this.f15088d);
            this.f15090f = 0;
            this.f15091g = 0;
        }

        void a(PointF pointF) {
            this.f15087c = Math.round(pointF.x);
            this.f15088d = Math.round(pointF.y);
            int i11 = this.f15091g + 1;
            this.f15091g = i11;
            if (this.f15090f == i11) {
                b();
            }
        }

        void c(PointF pointF) {
            this.f15085a = Math.round(pointF.x);
            this.f15086b = Math.round(pointF.y);
            int i11 = this.f15090f + 1;
            this.f15090f = i11;
            if (i11 == this.f15091g) {
                b();
            }
        }
    }

    private void f0(w wVar) {
        View view = wVar.f15192b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        wVar.f15191a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        wVar.f15191a.put("android:changeBounds:parent", wVar.f15192b.getParent());
        if (this.N) {
            wVar.f15191a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // androidx.transition.j
    public String[] E() {
        return O;
    }

    @Override // androidx.transition.j
    public void f(w wVar) {
        f0(wVar);
    }

    @Override // androidx.transition.j
    public void j(w wVar) {
        Rect rect;
        f0(wVar);
        if (!this.N || (rect = (Rect) wVar.f15192b.getTag(R$id.transition_clip)) == null) {
            return;
        }
        wVar.f15191a.put("android:changeBounds:clip", rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.j
    public Animator n(ViewGroup viewGroup, w wVar, w wVar2) {
        int i11;
        View view;
        int i12;
        int i13;
        int i14;
        ObjectAnimator a11;
        int i15;
        ObjectAnimator objectAnimator;
        Animator c11;
        if (wVar == null || wVar2 == null) {
            return null;
        }
        Map map = wVar.f15191a;
        Map map2 = wVar2.f15191a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = wVar2.f15192b;
        Rect rect = (Rect) wVar.f15191a.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) wVar2.f15191a.get("android:changeBounds:bounds");
        int i16 = rect.left;
        int i17 = rect2.left;
        int i18 = rect.top;
        int i19 = rect2.top;
        int i20 = rect.right;
        int i21 = rect2.right;
        int i22 = rect.bottom;
        int i23 = rect2.bottom;
        int i24 = i20 - i16;
        int i25 = i22 - i18;
        int i26 = i21 - i17;
        int i27 = i23 - i19;
        Rect rect3 = (Rect) wVar.f15191a.get("android:changeBounds:clip");
        Rect rect4 = (Rect) wVar2.f15191a.get("android:changeBounds:clip");
        if ((i24 == 0 || i25 == 0) && (i26 == 0 || i27 == 0)) {
            i11 = 0;
        } else {
            i11 = (i16 == i17 && i18 == i19) ? 0 : 1;
            if (i20 != i21 || i22 != i23) {
                i11++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i11++;
        }
        if (i11 <= 0) {
            return null;
        }
        if (this.N) {
            view = view2;
            z.d(view, i16, i18, Math.max(i24, i26) + i16, i18 + Math.max(i25, i27));
            if (i16 == i17 && i18 == i19) {
                i12 = i21;
                i13 = i20;
                i14 = i18;
                a11 = null;
            } else {
                i12 = i21;
                i13 = i20;
                i14 = i18;
                a11 = androidx.transition.f.a(view, T, v().a(i16, i18, i17, i19));
            }
            boolean z10 = rect3 == null;
            if (z10) {
                i15 = 0;
                rect3 = new Rect(0, 0, i24, i25);
            } else {
                i15 = 0;
            }
            Rect rect5 = rect3;
            int i28 = rect4 == null ? 1 : i15;
            Rect rect6 = i28 != 0 ? new Rect(i15, i15, i26, i27) : rect4;
            if (rect5.equals(rect6)) {
                objectAnimator = null;
            } else {
                view.setClipBounds(rect5);
                androidx.transition.h hVar = U;
                Object[] objArr = new Object[2];
                objArr[i15] = rect5;
                objArr[1] = rect6;
                objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", hVar, objArr);
                g gVar = new g(view, rect5, z10, rect6, i28, i16, i14, i13, i22, i17, i19, i12, i23);
                objectAnimator.addListener(gVar);
                a(gVar);
            }
            c11 = v.c(a11, objectAnimator);
        } else {
            view = view2;
            z.d(view, i16, i18, i20, i22);
            if (i11 != 2) {
                c11 = (i16 == i17 && i18 == i19) ? androidx.transition.f.a(view, R, v().a(i20, i22, i21, i23)) : androidx.transition.f.a(view, S, v().a(i16, i18, i17, i19));
            } else if (i24 == i26 && i25 == i27) {
                c11 = androidx.transition.f.a(view, T, v().a(i16, i18, i17, i19));
            } else {
                i iVar = new i(view);
                ObjectAnimator a12 = androidx.transition.f.a(iVar, P, v().a(i16, i18, i17, i19));
                ObjectAnimator a13 = androidx.transition.f.a(iVar, Q, v().a(i20, i22, i21, i23));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(a12, a13);
                animatorSet.addListener(new f(iVar));
                c11 = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            y.b(viewGroup4, true);
            x().a(new h(viewGroup4));
        }
        return c11;
    }
}
