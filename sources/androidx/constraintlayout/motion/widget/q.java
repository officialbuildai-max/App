package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q {
    private static final float[][] G = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] H = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: r, reason: collision with root package name */
    private float f7558r;

    /* renamed from: s, reason: collision with root package name */
    private float f7559s;

    /* renamed from: t, reason: collision with root package name */
    private final MotionLayout f7560t;

    /* renamed from: a, reason: collision with root package name */
    private int f7541a = 0;

    /* renamed from: b, reason: collision with root package name */
    private int f7542b = 0;

    /* renamed from: c, reason: collision with root package name */
    private int f7543c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f7544d = -1;

    /* renamed from: e, reason: collision with root package name */
    private int f7545e = -1;

    /* renamed from: f, reason: collision with root package name */
    private int f7546f = -1;

    /* renamed from: g, reason: collision with root package name */
    private float f7547g = 0.5f;

    /* renamed from: h, reason: collision with root package name */
    private float f7548h = 0.5f;

    /* renamed from: i, reason: collision with root package name */
    float f7549i = 0.5f;

    /* renamed from: j, reason: collision with root package name */
    float f7550j = 0.5f;

    /* renamed from: k, reason: collision with root package name */
    private int f7551k = -1;

    /* renamed from: l, reason: collision with root package name */
    boolean f7552l = false;

    /* renamed from: m, reason: collision with root package name */
    private float f7553m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    private float f7554n = 1.0f;

    /* renamed from: o, reason: collision with root package name */
    private boolean f7555o = false;

    /* renamed from: p, reason: collision with root package name */
    private float[] f7556p = new float[2];

    /* renamed from: q, reason: collision with root package name */
    private int[] f7557q = new int[2];

    /* renamed from: u, reason: collision with root package name */
    private float f7561u = 4.0f;

    /* renamed from: v, reason: collision with root package name */
    private float f7562v = 1.2f;

    /* renamed from: w, reason: collision with root package name */
    private boolean f7563w = true;

    /* renamed from: x, reason: collision with root package name */
    private float f7564x = 1.0f;

    /* renamed from: y, reason: collision with root package name */
    private int f7565y = 0;

    /* renamed from: z, reason: collision with root package name */
    private float f7566z = 10.0f;
    private float A = 10.0f;
    private float B = 1.0f;
    private float C = Float.NaN;
    private float D = Float.NaN;
    private int E = 0;
    private int F = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnTouchListener {
        a(q qVar) {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements NestedScrollView.e {
        b(q qVar) {
        }

        @Override // androidx.core.widget.NestedScrollView.e
        public void a(NestedScrollView nestedScrollView, int i11, int i12, int i13, int i14) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f7560t = motionLayout;
        c(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void b(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = typedArray.getIndex(i11);
            if (index == R$styleable.OnSwipe_touchAnchorId) {
                this.f7544d = typedArray.getResourceId(index, this.f7544d);
            } else if (index == R$styleable.OnSwipe_touchAnchorSide) {
                int i12 = typedArray.getInt(index, this.f7541a);
                this.f7541a = i12;
                float[] fArr = G[i12];
                this.f7548h = fArr[0];
                this.f7547g = fArr[1];
            } else if (index == R$styleable.OnSwipe_dragDirection) {
                int i13 = typedArray.getInt(index, this.f7542b);
                this.f7542b = i13;
                float[][] fArr2 = H;
                if (i13 < fArr2.length) {
                    float[] fArr3 = fArr2[i13];
                    this.f7553m = fArr3[0];
                    this.f7554n = fArr3[1];
                } else {
                    this.f7554n = Float.NaN;
                    this.f7553m = Float.NaN;
                    this.f7552l = true;
                }
            } else if (index == R$styleable.OnSwipe_maxVelocity) {
                this.f7561u = typedArray.getFloat(index, this.f7561u);
            } else if (index == R$styleable.OnSwipe_maxAcceleration) {
                this.f7562v = typedArray.getFloat(index, this.f7562v);
            } else if (index == R$styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f7563w = typedArray.getBoolean(index, this.f7563w);
            } else if (index == R$styleable.OnSwipe_dragScale) {
                this.f7564x = typedArray.getFloat(index, this.f7564x);
            } else if (index == R$styleable.OnSwipe_dragThreshold) {
                this.f7566z = typedArray.getFloat(index, this.f7566z);
            } else if (index == R$styleable.OnSwipe_touchRegionId) {
                this.f7545e = typedArray.getResourceId(index, this.f7545e);
            } else if (index == R$styleable.OnSwipe_onTouchUp) {
                this.f7543c = typedArray.getInt(index, this.f7543c);
            } else if (index == R$styleable.OnSwipe_nestedScrollFlags) {
                this.f7565y = typedArray.getInteger(index, 0);
            } else if (index == R$styleable.OnSwipe_limitBoundsTo) {
                this.f7546f = typedArray.getResourceId(index, 0);
            } else if (index == R$styleable.OnSwipe_rotationCenterId) {
                this.f7551k = typedArray.getResourceId(index, this.f7551k);
            } else if (index == R$styleable.OnSwipe_springDamping) {
                this.A = typedArray.getFloat(index, this.A);
            } else if (index == R$styleable.OnSwipe_springMass) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == R$styleable.OnSwipe_springStiffness) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == R$styleable.OnSwipe_springStopThreshold) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == R$styleable.OnSwipe_springBoundary) {
                this.E = typedArray.getInt(index, this.E);
            } else if (index == R$styleable.OnSwipe_autoCompleteMode) {
                this.F = typedArray.getInt(index, this.F);
            }
        }
    }

    private void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.OnSwipe);
        b(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        View view;
        int i11 = this.f7544d;
        if (i11 != -1) {
            view = this.f7560t.findViewById(i11);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + androidx.constraintlayout.motion.widget.a.c(this.f7560t.getContext(), this.f7544d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new a(this));
            nestedScrollView.setOnScrollChangeListener(new b(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float a(float f11, float f12) {
        return (f11 * this.f7553m) + (f12 * this.f7554n);
    }

    public int d() {
        return this.F;
    }

    public int e() {
        return this.f7565y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF f(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i11 = this.f7546f;
        if (i11 == -1 || (findViewById = viewGroup.findViewById(i11)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        return this.f7562v;
    }

    public float h() {
        return this.f7561u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i() {
        return this.f7563w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j(float f11, float f12) {
        this.f7560t.Q(this.f7544d, this.f7560t.getProgress(), this.f7548h, this.f7547g, this.f7556p);
        float f13 = this.f7553m;
        if (f13 != 0.0f) {
            float[] fArr = this.f7556p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f11 * f13) / fArr[0];
        }
        float[] fArr2 = this.f7556p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f12 * this.f7554n) / fArr2[1];
    }

    public int k() {
        return this.E;
    }

    public float l() {
        return this.A;
    }

    public float m() {
        return this.B;
    }

    public float n() {
        return this.C;
    }

    public float o() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF p(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i11 = this.f7545e;
        if (i11 == -1 || (findViewById = viewGroup.findViewById(i11)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int q() {
        return this.f7545e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.f7555o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(MotionEvent motionEvent, MotionLayout.e eVar, int i11, p pVar) {
        int i12;
        if (this.f7552l) {
            t(motionEvent, eVar, i11, pVar);
            return;
        }
        eVar.a(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f7558r = motionEvent.getRawX();
            this.f7559s = motionEvent.getRawY();
            this.f7555o = false;
            return;
        }
        if (action == 1) {
            this.f7555o = false;
            eVar.d(1000);
            float c11 = eVar.c();
            float b11 = eVar.b();
            float progress = this.f7560t.getProgress();
            int i13 = this.f7544d;
            if (i13 != -1) {
                this.f7560t.Q(i13, progress, this.f7548h, this.f7547g, this.f7556p);
            } else {
                float min = Math.min(this.f7560t.getWidth(), this.f7560t.getHeight());
                float[] fArr = this.f7556p;
                fArr[1] = this.f7554n * min;
                fArr[0] = min * this.f7553m;
            }
            float f11 = this.f7553m;
            float[] fArr2 = this.f7556p;
            float f12 = f11 != 0.0f ? c11 / fArr2[0] : b11 / fArr2[1];
            float f13 = !Float.isNaN(f12) ? (f12 / 3.0f) + progress : progress;
            if (f13 == 0.0f || f13 == 1.0f || (i12 = this.f7543c) == 3) {
                if (0.0f >= f13 || 1.0f <= f13) {
                    this.f7560t.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            float f14 = ((double) f13) < 0.5d ? 0.0f : 1.0f;
            if (i12 == 6) {
                if (progress + f12 < 0.0f) {
                    f12 = Math.abs(f12);
                }
                f14 = 1.0f;
            }
            if (this.f7543c == 7) {
                if (progress + f12 > 1.0f) {
                    f12 = -Math.abs(f12);
                }
                f14 = 0.0f;
            }
            this.f7560t.touchAnimateTo(this.f7543c, f14, f12);
            if (0.0f >= progress || 1.0f <= progress) {
                this.f7560t.setState(MotionLayout.TransitionState.FINISHED);
                return;
            }
            return;
        }
        if (action != 2) {
            return;
        }
        float rawY = motionEvent.getRawY() - this.f7559s;
        float rawX = motionEvent.getRawX() - this.f7558r;
        if (Math.abs((this.f7553m * rawX) + (this.f7554n * rawY)) > this.f7566z || this.f7555o) {
            float progress2 = this.f7560t.getProgress();
            if (!this.f7555o) {
                this.f7555o = true;
                this.f7560t.setProgress(progress2);
            }
            int i14 = this.f7544d;
            if (i14 != -1) {
                this.f7560t.Q(i14, progress2, this.f7548h, this.f7547g, this.f7556p);
            } else {
                float min2 = Math.min(this.f7560t.getWidth(), this.f7560t.getHeight());
                float[] fArr3 = this.f7556p;
                fArr3[1] = this.f7554n * min2;
                fArr3[0] = min2 * this.f7553m;
            }
            float f15 = this.f7553m;
            float[] fArr4 = this.f7556p;
            if (Math.abs(((f15 * fArr4[0]) + (this.f7554n * fArr4[1])) * this.f7564x) < 0.01d) {
                float[] fArr5 = this.f7556p;
                fArr5[0] = 0.01f;
                fArr5[1] = 0.01f;
            }
            float max = Math.max(Math.min(progress2 + (this.f7553m != 0.0f ? rawX / this.f7556p[0] : rawY / this.f7556p[1]), 1.0f), 0.0f);
            if (this.f7543c == 6) {
                max = Math.max(max, 0.01f);
            }
            if (this.f7543c == 7) {
                max = Math.min(max, 0.99f);
            }
            float progress3 = this.f7560t.getProgress();
            if (max != progress3) {
                if (progress3 == 0.0f || progress3 == 1.0f) {
                    this.f7560t.L(progress3 == 0.0f);
                }
                this.f7560t.setProgress(max);
                eVar.d(1000);
                this.f7560t.f7227d = this.f7553m != 0.0f ? eVar.c() / this.f7556p[0] : eVar.b() / this.f7556p[1];
            } else {
                this.f7560t.f7227d = 0.0f;
            }
            this.f7558r = motionEvent.getRawX();
            this.f7559s = motionEvent.getRawY();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0294  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void t(android.view.MotionEvent r24, androidx.constraintlayout.motion.widget.MotionLayout.e r25, int r26, androidx.constraintlayout.motion.widget.p r27) {
        /*
            Method dump skipped, instructions count: 834
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.q.t(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$e, int, androidx.constraintlayout.motion.widget.p):void");
    }

    public String toString() {
        if (Float.isNaN(this.f7553m)) {
            return "rotation";
        }
        return this.f7553m + " , " + this.f7554n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(float f11, float f12) {
        float progress = this.f7560t.getProgress();
        if (!this.f7555o) {
            this.f7555o = true;
            this.f7560t.setProgress(progress);
        }
        this.f7560t.Q(this.f7544d, progress, this.f7548h, this.f7547g, this.f7556p);
        float f13 = this.f7553m;
        float[] fArr = this.f7556p;
        if (Math.abs((f13 * fArr[0]) + (this.f7554n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.f7556p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f14 = this.f7553m;
        float max = Math.max(Math.min(progress + (f14 != 0.0f ? (f11 * f14) / this.f7556p[0] : (f12 * this.f7554n) / this.f7556p[1]), 1.0f), 0.0f);
        if (max != this.f7560t.getProgress()) {
            this.f7560t.setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(float f11, float f12) {
        this.f7555o = false;
        float progress = this.f7560t.getProgress();
        this.f7560t.Q(this.f7544d, progress, this.f7548h, this.f7547g, this.f7556p);
        float f13 = this.f7553m;
        float[] fArr = this.f7556p;
        float f14 = f13 != 0.0f ? (f11 * f13) / fArr[0] : (f12 * this.f7554n) / fArr[1];
        if (!Float.isNaN(f14)) {
            progress += f14 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z10 = progress != 1.0f;
            int i11 = this.f7543c;
            if ((i11 != 3) && z10) {
                this.f7560t.touchAnimateTo(i11, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f14);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(float f11, float f12) {
        this.f7558r = f11;
        this.f7559s = f12;
    }

    public void x(boolean z10) {
        if (z10) {
            float[][] fArr = H;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = G;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = H;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = G;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[] fArr5 = G[this.f7541a];
        this.f7548h = fArr5[0];
        this.f7547g = fArr5[1];
        int i11 = this.f7542b;
        float[][] fArr6 = H;
        if (i11 >= fArr6.length) {
            return;
        }
        float[] fArr7 = fArr6[i11];
        this.f7553m = fArr7[0];
        this.f7554n = fArr7[1];
    }

    public void y(int i11) {
        this.f7543c = i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(float f11, float f12) {
        this.f7558r = f11;
        this.f7559s = f12;
        this.f7555o = false;
    }
}
