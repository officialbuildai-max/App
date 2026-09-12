package androidx.recyclerview.widget;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FastScroller extends RecyclerView.l implements RecyclerView.q {
    private static final int[] D = {R.attr.state_pressed};
    private static final int[] E = new int[0];
    int A;
    private final Runnable B;
    private final RecyclerView.r C;

    /* renamed from: a, reason: collision with root package name */
    private final int f14233a;

    /* renamed from: b, reason: collision with root package name */
    private final int f14234b;

    /* renamed from: c, reason: collision with root package name */
    final StateListDrawable f14235c;

    /* renamed from: d, reason: collision with root package name */
    final Drawable f14236d;

    /* renamed from: e, reason: collision with root package name */
    private final int f14237e;

    /* renamed from: f, reason: collision with root package name */
    private final int f14238f;

    /* renamed from: g, reason: collision with root package name */
    private final StateListDrawable f14239g;

    /* renamed from: h, reason: collision with root package name */
    private final Drawable f14240h;

    /* renamed from: i, reason: collision with root package name */
    private final int f14241i;

    /* renamed from: j, reason: collision with root package name */
    private final int f14242j;

    /* renamed from: k, reason: collision with root package name */
    int f14243k;

    /* renamed from: l, reason: collision with root package name */
    int f14244l;

    /* renamed from: m, reason: collision with root package name */
    float f14245m;

    /* renamed from: n, reason: collision with root package name */
    int f14246n;

    /* renamed from: o, reason: collision with root package name */
    int f14247o;

    /* renamed from: p, reason: collision with root package name */
    float f14248p;

    /* renamed from: s, reason: collision with root package name */
    private RecyclerView f14251s;

    /* renamed from: z, reason: collision with root package name */
    final ValueAnimator f14258z;

    /* renamed from: q, reason: collision with root package name */
    private int f14249q = 0;

    /* renamed from: r, reason: collision with root package name */
    private int f14250r = 0;

    /* renamed from: t, reason: collision with root package name */
    private boolean f14252t = false;

    /* renamed from: u, reason: collision with root package name */
    private boolean f14253u = false;

    /* renamed from: v, reason: collision with root package name */
    private int f14254v = 0;

    /* renamed from: w, reason: collision with root package name */
    private int f14255w = 0;

    /* renamed from: x, reason: collision with root package name */
    private final int[] f14256x = new int[2];

    /* renamed from: y, reason: collision with root package name */
    private final int[] f14257y = new int[2];

    /* loaded from: classes2.dex */
    class a extends RecyclerView.r {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
            FastScroller.this.v(recyclerView.computeHorizontalScrollOffset(), recyclerView.computeVerticalScrollOffset());
        }
    }

    /* loaded from: classes2.dex */
    private class b extends AnimatorListenerAdapter {

        /* renamed from: a, reason: collision with root package name */
        private boolean f14260a = false;

        b() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f14260a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f14260a) {
                this.f14260a = false;
                return;
            }
            if (((Float) FastScroller.this.f14258z.getAnimatedValue()).floatValue() == 0.0f) {
                FastScroller fastScroller = FastScroller.this;
                fastScroller.A = 0;
                fastScroller.s(0);
            } else {
                FastScroller fastScroller2 = FastScroller.this;
                fastScroller2.A = 2;
                fastScroller2.p();
            }
        }
    }

    /* loaded from: classes2.dex */
    private class c implements ValueAnimator.AnimatorUpdateListener {
        c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            FastScroller.this.f14235c.setAlpha(floatValue);
            FastScroller.this.f14236d.setAlpha(floatValue);
            FastScroller.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FastScroller(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i11, int i12, int i13) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f14258z = ofFloat;
        this.A = 0;
        this.B = new Runnable() { // from class: androidx.recyclerview.widget.FastScroller.1
            @Override // java.lang.Runnable
            public void run() {
                FastScroller.this.k(500);
            }
        };
        this.C = new a();
        this.f14235c = stateListDrawable;
        this.f14236d = drawable;
        this.f14239g = stateListDrawable2;
        this.f14240h = drawable2;
        this.f14237e = Math.max(i11, stateListDrawable.getIntrinsicWidth());
        this.f14238f = Math.max(i11, drawable.getIntrinsicWidth());
        this.f14241i = Math.max(i11, stateListDrawable2.getIntrinsicWidth());
        this.f14242j = Math.max(i11, drawable2.getIntrinsicWidth());
        this.f14233a = i12;
        this.f14234b = i13;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new b());
        ofFloat.addUpdateListener(new c());
        d(recyclerView);
    }

    private void e() {
        this.f14251s.removeCallbacks(this.B);
    }

    private void f() {
        this.f14251s.removeItemDecoration(this);
        this.f14251s.removeOnItemTouchListener(this);
        this.f14251s.removeOnScrollListener(this.C);
        e();
    }

    private void g(Canvas canvas) {
        int i11 = this.f14250r;
        int i12 = this.f14241i;
        int i13 = this.f14247o;
        int i14 = this.f14246n;
        this.f14239g.setBounds(0, 0, i14, i12);
        this.f14240h.setBounds(0, 0, this.f14249q, this.f14242j);
        canvas.translate(0.0f, i11 - i12);
        this.f14240h.draw(canvas);
        canvas.translate(i13 - (i14 / 2), 0.0f);
        this.f14239g.draw(canvas);
        canvas.translate(-r2, -r0);
    }

    private void h(Canvas canvas) {
        int i11 = this.f14249q;
        int i12 = this.f14237e;
        int i13 = i11 - i12;
        int i14 = this.f14244l;
        int i15 = this.f14243k;
        int i16 = i14 - (i15 / 2);
        this.f14235c.setBounds(0, 0, i12, i15);
        this.f14236d.setBounds(0, 0, this.f14238f, this.f14250r);
        if (!m()) {
            canvas.translate(i13, 0.0f);
            this.f14236d.draw(canvas);
            canvas.translate(0.0f, i16);
            this.f14235c.draw(canvas);
            canvas.translate(-i13, -i16);
            return;
        }
        this.f14236d.draw(canvas);
        canvas.translate(this.f14237e, i16);
        canvas.scale(-1.0f, 1.0f);
        this.f14235c.draw(canvas);
        canvas.scale(-1.0f, 1.0f);
        canvas.translate(-this.f14237e, -i16);
    }

    private int[] i() {
        int[] iArr = this.f14257y;
        int i11 = this.f14234b;
        iArr[0] = i11;
        iArr[1] = this.f14249q - i11;
        return iArr;
    }

    private int[] j() {
        int[] iArr = this.f14256x;
        int i11 = this.f14234b;
        iArr[0] = i11;
        iArr[1] = this.f14250r - i11;
        return iArr;
    }

    private void l(float f11) {
        int[] i11 = i();
        float max = Math.max(i11[0], Math.min(i11[1], f11));
        if (Math.abs(this.f14247o - max) < 2.0f) {
            return;
        }
        int r11 = r(this.f14248p, max, i11, this.f14251s.computeHorizontalScrollRange(), this.f14251s.computeHorizontalScrollOffset(), this.f14249q);
        if (r11 != 0) {
            this.f14251s.scrollBy(r11, 0);
        }
        this.f14248p = max;
    }

    private boolean m() {
        return ViewCompat.getLayoutDirection(this.f14251s) == 1;
    }

    private void q(int i11) {
        e();
        this.f14251s.postDelayed(this.B, i11);
    }

    private int r(float f11, float f12, int[] iArr, int i11, int i12, int i13) {
        int i14 = iArr[1] - iArr[0];
        if (i14 == 0) {
            return 0;
        }
        int i15 = i11 - i13;
        int i16 = (int) (((f12 - f11) / i14) * i15);
        int i17 = i12 + i16;
        if (i17 >= i15 || i17 < 0) {
            return 0;
        }
        return i16;
    }

    private void t() {
        this.f14251s.addItemDecoration(this);
        this.f14251s.addOnItemTouchListener(this);
        this.f14251s.addOnScrollListener(this.C);
    }

    private void w(float f11) {
        int[] j11 = j();
        float max = Math.max(j11[0], Math.min(j11[1], f11));
        if (Math.abs(this.f14244l - max) < 2.0f) {
            return;
        }
        int r11 = r(this.f14245m, max, j11, this.f14251s.computeVerticalScrollRange(), this.f14251s.computeVerticalScrollOffset(), this.f14250r);
        if (r11 != 0) {
            this.f14251s.scrollBy(0, r11);
        }
        this.f14245m = max;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void a(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.f14254v == 0) {
            return;
        }
        if (motionEvent.getAction() == 0) {
            boolean o11 = o(motionEvent.getX(), motionEvent.getY());
            boolean n11 = n(motionEvent.getX(), motionEvent.getY());
            if (o11 || n11) {
                if (n11) {
                    this.f14255w = 1;
                    this.f14248p = (int) motionEvent.getX();
                } else if (o11) {
                    this.f14255w = 2;
                    this.f14245m = (int) motionEvent.getY();
                }
                s(2);
                return;
            }
            return;
        }
        if (motionEvent.getAction() == 1 && this.f14254v == 2) {
            this.f14245m = 0.0f;
            this.f14248p = 0.0f;
            s(1);
            this.f14255w = 0;
            return;
        }
        if (motionEvent.getAction() == 2 && this.f14254v == 2) {
            u();
            if (this.f14255w == 1) {
                l(motionEvent.getX());
            }
            if (this.f14255w == 2) {
                w(motionEvent.getY());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public boolean b(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i11 = this.f14254v;
        if (i11 == 1) {
            boolean o11 = o(motionEvent.getX(), motionEvent.getY());
            boolean n11 = n(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() != 0) {
                return false;
            }
            if (!o11 && !n11) {
                return false;
            }
            if (n11) {
                this.f14255w = 1;
                this.f14248p = (int) motionEvent.getX();
            } else if (o11) {
                this.f14255w = 2;
                this.f14245m = (int) motionEvent.getY();
            }
            s(2);
        } else if (i11 != 2) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(boolean z10) {
    }

    public void d(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f14251s;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            f();
        }
        this.f14251s = recyclerView;
        if (recyclerView != null) {
            t();
        }
    }

    void k(int i11) {
        int i12 = this.A;
        if (i12 == 1) {
            this.f14258z.cancel();
        } else if (i12 != 2) {
            return;
        }
        this.A = 3;
        ValueAnimator valueAnimator = this.f14258z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
        this.f14258z.setDuration(i11);
        this.f14258z.start();
    }

    boolean n(float f11, float f12) {
        if (f12 >= this.f14250r - this.f14241i) {
            int i11 = this.f14247o;
            int i12 = this.f14246n;
            if (f11 >= i11 - (i12 / 2) && f11 <= i11 + (i12 / 2)) {
                return true;
            }
        }
        return false;
    }

    boolean o(float f11, float f12) {
        if (!m() ? f11 >= this.f14249q - this.f14237e : f11 <= this.f14237e) {
            int i11 = this.f14244l;
            int i12 = this.f14243k;
            if (f12 >= i11 - (i12 / 2) && f12 <= i11 + (i12 / 2)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (this.f14249q != this.f14251s.getWidth() || this.f14250r != this.f14251s.getHeight()) {
            this.f14249q = this.f14251s.getWidth();
            this.f14250r = this.f14251s.getHeight();
            s(0);
        } else if (this.A != 0) {
            if (this.f14252t) {
                h(canvas);
            }
            if (this.f14253u) {
                g(canvas);
            }
        }
    }

    void p() {
        this.f14251s.invalidate();
    }

    void s(int i11) {
        if (i11 == 2 && this.f14254v != 2) {
            this.f14235c.setState(D);
            e();
        }
        if (i11 == 0) {
            p();
        } else {
            u();
        }
        if (this.f14254v == 2 && i11 != 2) {
            this.f14235c.setState(E);
            q(1200);
        } else if (i11 == 1) {
            q(1500);
        }
        this.f14254v = i11;
    }

    public void u() {
        int i11 = this.A;
        if (i11 != 0) {
            if (i11 != 3) {
                return;
            } else {
                this.f14258z.cancel();
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.f14258z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.f14258z.setDuration(500L);
        this.f14258z.setStartDelay(0L);
        this.f14258z.start();
    }

    void v(int i11, int i12) {
        int computeVerticalScrollRange = this.f14251s.computeVerticalScrollRange();
        int i13 = this.f14250r;
        this.f14252t = computeVerticalScrollRange - i13 > 0 && i13 >= this.f14233a;
        int computeHorizontalScrollRange = this.f14251s.computeHorizontalScrollRange();
        int i14 = this.f14249q;
        boolean z10 = computeHorizontalScrollRange - i14 > 0 && i14 >= this.f14233a;
        this.f14253u = z10;
        boolean z11 = this.f14252t;
        if (!z11 && !z10) {
            if (this.f14254v != 0) {
                s(0);
                return;
            }
            return;
        }
        if (z11) {
            float f11 = i13;
            this.f14244l = (int) ((f11 * (i12 + (f11 / 2.0f))) / computeVerticalScrollRange);
            this.f14243k = Math.min(i13, (i13 * i13) / computeVerticalScrollRange);
        }
        if (this.f14253u) {
            float f12 = i14;
            this.f14247o = (int) ((f12 * (i11 + (f12 / 2.0f))) / computeHorizontalScrollRange);
            this.f14246n = Math.min(i14, (i14 * i14) / computeHorizontalScrollRange);
        }
        int i15 = this.f14254v;
        if (i15 == 0 || i15 == 1) {
            s(1);
        }
    }
}
