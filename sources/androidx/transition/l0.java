package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.j;

/* loaded from: classes2.dex */
public abstract class l0 extends j {
    private static final String[] O = {"android:visibility:visibility", "android:visibility:parent"};
    private int N = 3;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends AnimatorListenerAdapter implements j.f {

        /* renamed from: a, reason: collision with root package name */
        private final View f15161a;

        /* renamed from: b, reason: collision with root package name */
        private final int f15162b;

        /* renamed from: c, reason: collision with root package name */
        private final ViewGroup f15163c;

        /* renamed from: d, reason: collision with root package name */
        private final boolean f15164d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f15165e;

        /* renamed from: f, reason: collision with root package name */
        boolean f15166f = false;

        a(View view, int i11, boolean z10) {
            this.f15161a = view;
            this.f15162b = i11;
            this.f15163c = (ViewGroup) view.getParent();
            this.f15164d = z10;
            i(true);
        }

        private void h() {
            if (!this.f15166f) {
                z.f(this.f15161a, this.f15162b);
                ViewGroup viewGroup = this.f15163c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        private void i(boolean z10) {
            ViewGroup viewGroup;
            if (!this.f15164d || this.f15165e == z10 || (viewGroup = this.f15163c) == null) {
                return;
            }
            this.f15165e = z10;
            y.b(viewGroup, z10);
        }

        @Override // androidx.transition.j.f
        public void a(j jVar) {
            i(true);
            if (this.f15166f) {
                return;
            }
            z.f(this.f15161a, 0);
        }

        @Override // androidx.transition.j.f
        public void b(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void c(j jVar) {
            i(false);
            if (this.f15166f) {
                return;
            }
            z.f(this.f15161a, this.f15162b);
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void d(j jVar, boolean z10) {
            k.a(this, jVar, z10);
        }

        @Override // androidx.transition.j.f
        public void e(j jVar) {
            jVar.S(this);
        }

        @Override // androidx.transition.j.f
        public void f(j jVar) {
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void g(j jVar, boolean z10) {
            k.b(this, jVar, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f15166f = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                z.f(this.f15161a, 0);
                ViewGroup viewGroup = this.f15163c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends AnimatorListenerAdapter implements j.f {

        /* renamed from: a, reason: collision with root package name */
        private final ViewGroup f15167a;

        /* renamed from: b, reason: collision with root package name */
        private final View f15168b;

        /* renamed from: c, reason: collision with root package name */
        private final View f15169c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f15170d = true;

        b(ViewGroup viewGroup, View view, View view2) {
            this.f15167a = viewGroup;
            this.f15168b = view;
            this.f15169c = view2;
        }

        private void h() {
            this.f15169c.setTag(R$id.save_overlay_view, null);
            this.f15167a.getOverlay().remove(this.f15168b);
            this.f15170d = false;
        }

        @Override // androidx.transition.j.f
        public void a(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void b(j jVar) {
        }

        @Override // androidx.transition.j.f
        public void c(j jVar) {
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void d(j jVar, boolean z10) {
            k.a(this, jVar, z10);
        }

        @Override // androidx.transition.j.f
        public void e(j jVar) {
            jVar.S(this);
        }

        @Override // androidx.transition.j.f
        public void f(j jVar) {
            if (this.f15170d) {
                h();
            }
        }

        @Override // androidx.transition.j.f
        public /* synthetic */ void g(j jVar, boolean z10) {
            k.b(this, jVar, z10);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z10) {
            if (z10) {
                return;
            }
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.f15167a.getOverlay().remove(this.f15168b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f15168b.getParent() == null) {
                this.f15167a.getOverlay().add(this.f15168b);
            } else {
                l0.this.cancel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z10) {
            if (z10) {
                this.f15169c.setTag(R$id.save_overlay_view, this.f15168b);
                this.f15167a.getOverlay().add(this.f15168b);
                this.f15170d = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        boolean f15172a;

        /* renamed from: b, reason: collision with root package name */
        boolean f15173b;

        /* renamed from: c, reason: collision with root package name */
        int f15174c;

        /* renamed from: d, reason: collision with root package name */
        int f15175d;

        /* renamed from: e, reason: collision with root package name */
        ViewGroup f15176e;

        /* renamed from: f, reason: collision with root package name */
        ViewGroup f15177f;

        c() {
        }
    }

    private void f0(w wVar) {
        wVar.f15191a.put("android:visibility:visibility", Integer.valueOf(wVar.f15192b.getVisibility()));
        wVar.f15191a.put("android:visibility:parent", wVar.f15192b.getParent());
        int[] iArr = new int[2];
        wVar.f15192b.getLocationOnScreen(iArr);
        wVar.f15191a.put("android:visibility:screenLocation", iArr);
    }

    private c g0(w wVar, w wVar2) {
        c cVar = new c();
        cVar.f15172a = false;
        cVar.f15173b = false;
        if (wVar == null || !wVar.f15191a.containsKey("android:visibility:visibility")) {
            cVar.f15174c = -1;
            cVar.f15176e = null;
        } else {
            cVar.f15174c = ((Integer) wVar.f15191a.get("android:visibility:visibility")).intValue();
            cVar.f15176e = (ViewGroup) wVar.f15191a.get("android:visibility:parent");
        }
        if (wVar2 == null || !wVar2.f15191a.containsKey("android:visibility:visibility")) {
            cVar.f15175d = -1;
            cVar.f15177f = null;
        } else {
            cVar.f15175d = ((Integer) wVar2.f15191a.get("android:visibility:visibility")).intValue();
            cVar.f15177f = (ViewGroup) wVar2.f15191a.get("android:visibility:parent");
        }
        if (wVar != null && wVar2 != null) {
            int i11 = cVar.f15174c;
            int i12 = cVar.f15175d;
            if (i11 == i12 && cVar.f15176e == cVar.f15177f) {
                return cVar;
            }
            if (i11 != i12) {
                if (i11 == 0) {
                    cVar.f15173b = false;
                    cVar.f15172a = true;
                } else if (i12 == 0) {
                    cVar.f15173b = true;
                    cVar.f15172a = true;
                }
            } else if (cVar.f15177f == null) {
                cVar.f15173b = false;
                cVar.f15172a = true;
            } else if (cVar.f15176e == null) {
                cVar.f15173b = true;
                cVar.f15172a = true;
            }
        } else if (wVar == null && cVar.f15175d == 0) {
            cVar.f15173b = true;
            cVar.f15172a = true;
        } else if (wVar2 == null && cVar.f15174c == 0) {
            cVar.f15173b = false;
            cVar.f15172a = true;
        }
        return cVar;
    }

    @Override // androidx.transition.j
    public String[] E() {
        return O;
    }

    @Override // androidx.transition.j
    public boolean G(w wVar, w wVar2) {
        if (wVar == null && wVar2 == null) {
            return false;
        }
        if (wVar != null && wVar2 != null && wVar2.f15191a.containsKey("android:visibility:visibility") != wVar.f15191a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c g02 = g0(wVar, wVar2);
        if (g02.f15172a) {
            return g02.f15174c == 0 || g02.f15175d == 0;
        }
        return false;
    }

    @Override // androidx.transition.j
    public void f(w wVar) {
        f0(wVar);
    }

    public Animator h0(ViewGroup viewGroup, View view, w wVar, w wVar2) {
        return null;
    }

    public Animator i0(ViewGroup viewGroup, w wVar, int i11, w wVar2, int i12) {
        if ((this.N & 1) != 1 || wVar2 == null) {
            return null;
        }
        if (wVar == null) {
            View view = (View) wVar2.f15192b.getParent();
            if (g0(t(view, false), F(view, false)).f15172a) {
                return null;
            }
        }
        return h0(viewGroup, wVar2.f15192b, wVar, wVar2);
    }

    @Override // androidx.transition.j
    public void j(w wVar) {
        f0(wVar);
    }

    public Animator j0(ViewGroup viewGroup, View view, w wVar, w wVar2) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r10.f15142w != false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator k0(android.view.ViewGroup r11, androidx.transition.w r12, int r13, androidx.transition.w r14, int r15) {
        /*
            Method dump skipped, instructions count: 264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.l0.k0(android.view.ViewGroup, androidx.transition.w, int, androidx.transition.w, int):android.animation.Animator");
    }

    public void l0(int i11) {
        if ((i11 & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.N = i11;
    }

    @Override // androidx.transition.j
    public Animator n(ViewGroup viewGroup, w wVar, w wVar2) {
        c g02 = g0(wVar, wVar2);
        if (!g02.f15172a) {
            return null;
        }
        if (g02.f15176e == null && g02.f15177f == null) {
            return null;
        }
        return g02.f15173b ? i0(viewGroup, wVar, g02.f15174c, wVar2, g02.f15175d) : k0(viewGroup, wVar, g02.f15174c, wVar2, g02.f15175d);
    }
}
