package com.transsion.baseui.widget.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.transsion.baseui.R$styleable;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final float[] f43744a = new float[4];

    /* renamed from: b, reason: collision with root package name */
    final int[] f43745b = new int[4];

    /* renamed from: c, reason: collision with root package name */
    final RectF f43746c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    int f43747d = 0;

    /* renamed from: e, reason: collision with root package name */
    int f43748e = -1;

    /* renamed from: f, reason: collision with root package name */
    int f43749f = 1291845631;

    /* renamed from: g, reason: collision with root package name */
    int f43750g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f43751h = 0;

    /* renamed from: i, reason: collision with root package name */
    int f43752i = 0;

    /* renamed from: j, reason: collision with root package name */
    float f43753j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    float f43754k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    float f43755l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    float f43756m = 0.5f;

    /* renamed from: n, reason: collision with root package name */
    float f43757n = 20.0f;

    /* renamed from: o, reason: collision with root package name */
    boolean f43758o = true;

    /* renamed from: p, reason: collision with root package name */
    boolean f43759p = true;

    /* renamed from: q, reason: collision with root package name */
    boolean f43760q = true;

    /* renamed from: r, reason: collision with root package name */
    int f43761r = -1;

    /* renamed from: s, reason: collision with root package name */
    int f43762s = 1;

    /* renamed from: t, reason: collision with root package name */
    long f43763t = 1000;

    /* renamed from: u, reason: collision with root package name */
    long f43764u;

    /* renamed from: com.transsion.baseui.widget.shimmer.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static class C0612a extends b {
        public C0612a() {
            this.f43765a.f43760q = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.baseui.widget.shimmer.a.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public C0612a d() {
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        final a f43765a = new a();

        private static float b(float f11, float f12, float f13) {
            return Math.min(f12, Math.max(f11, f13));
        }

        public a a() {
            this.f43765a.b();
            this.f43765a.c();
            return this.f43765a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b c(TypedArray typedArray) {
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_clip_to_children)) {
                g(typedArray.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_clip_to_children, this.f43765a.f43758o));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_auto_start)) {
                e(typedArray.getBoolean(R$styleable.ShimmerFrameLayout_shimmer_auto_start, this.f43765a.f43759p));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_base_alpha)) {
                f(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_highlight_alpha)) {
                n(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_duration)) {
                j(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_duration, (int) this.f43765a.f43763t));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_count)) {
                p(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_count, this.f43765a.f43761r));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_delay)) {
                q(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_delay, (int) this.f43765a.f43764u));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_repeat_mode)) {
                r(typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_repeat_mode, this.f43765a.f43762s));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_direction)) {
                int i11 = typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_direction, this.f43765a.f43747d);
                if (i11 == 1) {
                    h(1);
                } else if (i11 == 2) {
                    h(2);
                } else if (i11 != 3) {
                    h(0);
                } else {
                    h(3);
                }
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_shape)) {
                if (typedArray.getInt(R$styleable.ShimmerFrameLayout_shimmer_shape, this.f43765a.f43750g) != 1) {
                    s(0);
                } else {
                    s(1);
                }
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_dropoff)) {
                i(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_dropoff, this.f43765a.f43756m));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_fixed_width)) {
                l(typedArray.getDimensionPixelSize(R$styleable.ShimmerFrameLayout_shimmer_fixed_width, this.f43765a.f43751h));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_fixed_height)) {
                k(typedArray.getDimensionPixelSize(R$styleable.ShimmerFrameLayout_shimmer_fixed_height, this.f43765a.f43752i));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_intensity)) {
                o(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_intensity, this.f43765a.f43755l));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_width_ratio)) {
                u(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_width_ratio, this.f43765a.f43753j));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_height_ratio)) {
                m(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_height_ratio, this.f43765a.f43754k));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_tilt)) {
                t(typedArray.getFloat(R$styleable.ShimmerFrameLayout_shimmer_tilt, this.f43765a.f43757n));
            }
            return d();
        }

        protected abstract b d();

        public b e(boolean z10) {
            this.f43765a.f43759p = z10;
            return d();
        }

        public b f(float f11) {
            int b11 = (int) (b(0.0f, 1.0f, f11) * 255.0f);
            a aVar = this.f43765a;
            aVar.f43749f = (b11 << 24) | (aVar.f43749f & 16777215);
            return d();
        }

        public b g(boolean z10) {
            this.f43765a.f43758o = z10;
            return d();
        }

        public b h(int i11) {
            this.f43765a.f43747d = i11;
            return d();
        }

        public b i(float f11) {
            if (f11 >= 0.0f) {
                this.f43765a.f43756m = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f11);
        }

        public b j(long j11) {
            if (j11 >= 0) {
                this.f43765a.f43763t = j11;
                return d();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j11);
        }

        public b k(int i11) {
            if (i11 >= 0) {
                this.f43765a.f43752i = i11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height: " + i11);
        }

        public b l(int i11) {
            if (i11 >= 0) {
                this.f43765a.f43751h = i11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width: " + i11);
        }

        public b m(float f11) {
            if (f11 >= 0.0f) {
                this.f43765a.f43754k = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f11);
        }

        public b n(float f11) {
            int b11 = (int) (b(0.0f, 1.0f, f11) * 255.0f);
            a aVar = this.f43765a;
            aVar.f43748e = (b11 << 24) | (aVar.f43748e & 16777215);
            return d();
        }

        public b o(float f11) {
            if (f11 >= 0.0f) {
                this.f43765a.f43755l = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f11);
        }

        public b p(int i11) {
            this.f43765a.f43761r = i11;
            return d();
        }

        public b q(long j11) {
            if (j11 >= 0) {
                this.f43765a.f43764u = j11;
                return d();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j11);
        }

        public b r(int i11) {
            this.f43765a.f43762s = i11;
            return d();
        }

        public b s(int i11) {
            this.f43765a.f43750g = i11;
            return d();
        }

        public b t(float f11) {
            this.f43765a.f43757n = f11;
            return d();
        }

        public b u(float f11) {
            if (f11 >= 0.0f) {
                this.f43765a.f43753j = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f11);
        }
    }

    /* loaded from: classes5.dex */
    public static class c extends b {
        public c() {
            this.f43765a.f43760q = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.transsion.baseui.widget.shimmer.a.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public c c(TypedArray typedArray) {
            super.c(typedArray);
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_base_color)) {
                x(typedArray.getColor(R$styleable.ShimmerFrameLayout_shimmer_base_color, this.f43765a.f43749f));
            }
            if (typedArray.hasValue(R$styleable.ShimmerFrameLayout_shimmer_highlight_color)) {
                y(typedArray.getColor(R$styleable.ShimmerFrameLayout_shimmer_highlight_color, this.f43765a.f43748e));
            }
            return d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.baseui.widget.shimmer.a.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public c d() {
            return this;
        }

        public c x(int i11) {
            a aVar = this.f43765a;
            aVar.f43749f = (i11 & 16777215) | (aVar.f43749f & ViewCompat.MEASURED_STATE_MASK);
            return d();
        }

        public c y(int i11) {
            this.f43765a.f43748e = i11;
            return d();
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i11) {
        int i12 = this.f43752i;
        return i12 > 0 ? i12 : Math.round(this.f43754k * i11);
    }

    void b() {
        if (this.f43750g != 1) {
            int[] iArr = this.f43745b;
            int i11 = this.f43749f;
            iArr[0] = i11;
            int i12 = this.f43748e;
            iArr[1] = i12;
            iArr[2] = i12;
            iArr[3] = i11;
            return;
        }
        int[] iArr2 = this.f43745b;
        int i13 = this.f43748e;
        iArr2[0] = i13;
        iArr2[1] = i13;
        int i14 = this.f43749f;
        iArr2[2] = i14;
        iArr2[3] = i14;
    }

    void c() {
        if (this.f43750g != 1) {
            this.f43744a[0] = Math.max(((1.0f - this.f43755l) - this.f43756m) / 2.0f, 0.0f);
            this.f43744a[1] = Math.max(((1.0f - this.f43755l) - 0.001f) / 2.0f, 0.0f);
            this.f43744a[2] = Math.min(((this.f43755l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.f43744a[3] = Math.min(((this.f43755l + 1.0f) + this.f43756m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.f43744a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f43755l, 1.0f);
        this.f43744a[2] = Math.min(this.f43755l + this.f43756m, 1.0f);
        this.f43744a[3] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i11) {
        int i12 = this.f43751h;
        return i12 > 0 ? i12 : Math.round(this.f43753j * i11);
    }
}
