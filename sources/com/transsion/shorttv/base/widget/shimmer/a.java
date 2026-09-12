package com.transsion.shorttv.base.widget.shimmer;

import android.content.res.TypedArray;
import android.graphics.RectF;
import androidx.core.view.ViewCompat;
import com.transsion.shorttv.R$styleable;

/* loaded from: classes6.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    final float[] f52988a = new float[4];

    /* renamed from: b, reason: collision with root package name */
    final int[] f52989b = new int[4];

    /* renamed from: c, reason: collision with root package name */
    final RectF f52990c = new RectF();

    /* renamed from: d, reason: collision with root package name */
    int f52991d = 0;

    /* renamed from: e, reason: collision with root package name */
    int f52992e = -1;

    /* renamed from: f, reason: collision with root package name */
    int f52993f = 1291845631;

    /* renamed from: g, reason: collision with root package name */
    int f52994g = 0;

    /* renamed from: h, reason: collision with root package name */
    int f52995h = 0;

    /* renamed from: i, reason: collision with root package name */
    int f52996i = 0;

    /* renamed from: j, reason: collision with root package name */
    float f52997j = 1.0f;

    /* renamed from: k, reason: collision with root package name */
    float f52998k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    float f52999l = 0.0f;

    /* renamed from: m, reason: collision with root package name */
    float f53000m = 0.5f;

    /* renamed from: n, reason: collision with root package name */
    float f53001n = 20.0f;

    /* renamed from: o, reason: collision with root package name */
    boolean f53002o = true;

    /* renamed from: p, reason: collision with root package name */
    boolean f53003p = true;

    /* renamed from: q, reason: collision with root package name */
    boolean f53004q = true;

    /* renamed from: r, reason: collision with root package name */
    int f53005r = -1;

    /* renamed from: s, reason: collision with root package name */
    int f53006s = 1;

    /* renamed from: t, reason: collision with root package name */
    long f53007t = 1000;

    /* renamed from: u, reason: collision with root package name */
    long f53008u;

    /* renamed from: com.transsion.shorttv.base.widget.shimmer.a$a, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0654a extends b {
        public C0654a() {
            this.f53009a.f53004q = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.shorttv.base.widget.shimmer.a.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public C0654a d() {
            return this;
        }
    }

    /* loaded from: classes6.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        final a f53009a = new a();

        private static float b(float f11, float f12, float f13) {
            return Math.min(f12, Math.max(f11, f13));
        }

        public a a() {
            this.f53009a.b();
            this.f53009a.c();
            return this.f53009a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b c(TypedArray typedArray) {
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_clip_to_children)) {
                g(typedArray.getBoolean(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_clip_to_children, this.f53009a.f53002o));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_auto_start)) {
                e(typedArray.getBoolean(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_auto_start, this.f53009a.f53003p));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_base_alpha)) {
                f(typedArray.getFloat(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_base_alpha, 0.3f));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_highlight_alpha)) {
                n(typedArray.getFloat(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_highlight_alpha, 1.0f));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_duration)) {
                j(typedArray.getInt(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_duration, (int) this.f53009a.f53007t));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_repeat_count)) {
                p(typedArray.getInt(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_repeat_count, this.f53009a.f53005r));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_repeat_delay)) {
                q(typedArray.getInt(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_repeat_delay, (int) this.f53009a.f53008u));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_repeat_mode)) {
                r(typedArray.getInt(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_repeat_mode, this.f53009a.f53006s));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_direction)) {
                int i11 = typedArray.getInt(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_direction, this.f53009a.f52991d);
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
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_shape)) {
                if (typedArray.getInt(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_shape, this.f53009a.f52994g) != 1) {
                    s(0);
                } else {
                    s(1);
                }
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_dropoff)) {
                i(typedArray.getFloat(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_dropoff, this.f53009a.f53000m));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_fixed_width)) {
                l(typedArray.getDimensionPixelSize(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_fixed_width, this.f53009a.f52995h));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_fixed_height)) {
                k(typedArray.getDimensionPixelSize(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_fixed_height, this.f53009a.f52996i));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_intensity)) {
                o(typedArray.getFloat(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_intensity, this.f53009a.f52999l));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_width_ratio)) {
                u(typedArray.getFloat(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_width_ratio, this.f53009a.f52997j));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_height_ratio)) {
                m(typedArray.getFloat(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_height_ratio, this.f53009a.f52998k));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_tilt)) {
                t(typedArray.getFloat(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_tilt, this.f53009a.f53001n));
            }
            return d();
        }

        protected abstract b d();

        public b e(boolean z10) {
            this.f53009a.f53003p = z10;
            return d();
        }

        public b f(float f11) {
            int b11 = (int) (b(0.0f, 1.0f, f11) * 255.0f);
            a aVar = this.f53009a;
            aVar.f52993f = (b11 << 24) | (aVar.f52993f & 16777215);
            return d();
        }

        public b g(boolean z10) {
            this.f53009a.f53002o = z10;
            return d();
        }

        public b h(int i11) {
            this.f53009a.f52991d = i11;
            return d();
        }

        public b i(float f11) {
            if (f11 >= 0.0f) {
                this.f53009a.f53000m = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid dropoff value: " + f11);
        }

        public b j(long j11) {
            if (j11 >= 0) {
                this.f53009a.f53007t = j11;
                return d();
            }
            throw new IllegalArgumentException("Given a negative duration: " + j11);
        }

        public b k(int i11) {
            if (i11 >= 0) {
                this.f53009a.f52996i = i11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height: " + i11);
        }

        public b l(int i11) {
            if (i11 >= 0) {
                this.f53009a.f52995h = i11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width: " + i11);
        }

        public b m(float f11) {
            if (f11 >= 0.0f) {
                this.f53009a.f52998k = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid height ratio: " + f11);
        }

        public b n(float f11) {
            int b11 = (int) (b(0.0f, 1.0f, f11) * 255.0f);
            a aVar = this.f53009a;
            aVar.f52992e = (b11 << 24) | (aVar.f52992e & 16777215);
            return d();
        }

        public b o(float f11) {
            if (f11 >= 0.0f) {
                this.f53009a.f52999l = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid intensity value: " + f11);
        }

        public b p(int i11) {
            this.f53009a.f53005r = i11;
            return d();
        }

        public b q(long j11) {
            if (j11 >= 0) {
                this.f53009a.f53008u = j11;
                return d();
            }
            throw new IllegalArgumentException("Given a negative repeat delay: " + j11);
        }

        public b r(int i11) {
            this.f53009a.f53006s = i11;
            return d();
        }

        public b s(int i11) {
            this.f53009a.f52994g = i11;
            return d();
        }

        public b t(float f11) {
            this.f53009a.f53001n = f11;
            return d();
        }

        public b u(float f11) {
            if (f11 >= 0.0f) {
                this.f53009a.f52997j = f11;
                return d();
            }
            throw new IllegalArgumentException("Given invalid width ratio: " + f11);
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends b {
        public c() {
            this.f53009a.f53004q = false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.transsion.shorttv.base.widget.shimmer.a.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public c c(TypedArray typedArray) {
            super.c(typedArray);
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_base_color)) {
                x(typedArray.getColor(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_base_color, this.f53009a.f52993f));
            }
            if (typedArray.hasValue(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_highlight_color)) {
                y(typedArray.getColor(R$styleable.ShortTvShimmerFrameLayout_short_tv_shimmer_highlight_color, this.f53009a.f52992e));
            }
            return d();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.shorttv.base.widget.shimmer.a.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public c d() {
            return this;
        }

        public c x(int i11) {
            a aVar = this.f53009a;
            aVar.f52993f = (i11 & 16777215) | (aVar.f52993f & ViewCompat.MEASURED_STATE_MASK);
            return d();
        }

        public c y(int i11) {
            this.f53009a.f52992e = i11;
            return d();
        }
    }

    a() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(int i11) {
        int i12 = this.f52996i;
        return i12 > 0 ? i12 : Math.round(this.f52998k * i11);
    }

    void b() {
        if (this.f52994g != 1) {
            int[] iArr = this.f52989b;
            int i11 = this.f52993f;
            iArr[0] = i11;
            int i12 = this.f52992e;
            iArr[1] = i12;
            iArr[2] = i12;
            iArr[3] = i11;
            return;
        }
        int[] iArr2 = this.f52989b;
        int i13 = this.f52992e;
        iArr2[0] = i13;
        iArr2[1] = i13;
        int i14 = this.f52993f;
        iArr2[2] = i14;
        iArr2[3] = i14;
    }

    void c() {
        if (this.f52994g != 1) {
            this.f52988a[0] = Math.max(((1.0f - this.f52999l) - this.f53000m) / 2.0f, 0.0f);
            this.f52988a[1] = Math.max(((1.0f - this.f52999l) - 0.001f) / 2.0f, 0.0f);
            this.f52988a[2] = Math.min(((this.f52999l + 1.0f) + 0.001f) / 2.0f, 1.0f);
            this.f52988a[3] = Math.min(((this.f52999l + 1.0f) + this.f53000m) / 2.0f, 1.0f);
            return;
        }
        float[] fArr = this.f52988a;
        fArr[0] = 0.0f;
        fArr[1] = Math.min(this.f52999l, 1.0f);
        this.f52988a[2] = Math.min(this.f52999l + this.f53000m, 1.0f);
        this.f52988a[3] = 1.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d(int i11) {
        int i12 = this.f52995h;
        return i12 > 0 ? i12 : Math.round(this.f52997j * i11);
    }
}
