package com.google.android.material.carousel;

import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes4.dex */
abstract class c {

    /* renamed from: a, reason: collision with root package name */
    final int f28664a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f28665b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(int i11, CarouselLayoutManager carouselLayoutManager) {
            super(i11, null);
            this.f28665b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.c
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f11 = rectF2.top;
            float f12 = rectF3.top;
            if (f11 < f12 && rectF2.bottom > f12) {
                float f13 = f12 - f11;
                rectF.top += f13;
                rectF3.top += f13;
            }
            float f14 = rectF2.bottom;
            float f15 = rectF3.bottom;
            if (f14 <= f15 || rectF2.top >= f15) {
                return;
            }
            float f16 = f14 - f15;
            rectF.bottom = Math.max(rectF.bottom - f16, rectF.top);
            rectF2.bottom = Math.max(rectF2.bottom - f16, rectF2.top);
        }

        @Override // com.google.android.material.carousel.c
        public float e(RecyclerView.n nVar) {
            return ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }

        @Override // com.google.android.material.carousel.c
        public RectF f(float f11, float f12, float f13, float f14) {
            return new RectF(0.0f, f13, f12, f11 - f13);
        }

        @Override // com.google.android.material.carousel.c
        int g() {
            return this.f28665b.getHeight();
        }

        @Override // com.google.android.material.carousel.c
        int h() {
            return g();
        }

        @Override // com.google.android.material.carousel.c
        int i() {
            return this.f28665b.getPaddingLeft();
        }

        @Override // com.google.android.material.carousel.c
        int j() {
            return this.f28665b.getWidth() - this.f28665b.getPaddingRight();
        }

        @Override // com.google.android.material.carousel.c
        int k() {
            return l();
        }

        @Override // com.google.android.material.carousel.c
        int l() {
            return 0;
        }

        @Override // com.google.android.material.carousel.c
        public void m(View view, int i11, int i12) {
            int i13 = i();
            this.f28665b.layoutDecoratedWithMargins(view, i13, i11, i13 + p(view), i12);
        }

        @Override // com.google.android.material.carousel.c
        public void n(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.bottom <= rectF3.top) {
                float floor = ((float) Math.floor(rectF.bottom)) - 1.0f;
                rectF.bottom = floor;
                rectF.top = Math.min(rectF.top, floor);
            }
            if (rectF2.top >= rectF3.bottom) {
                float ceil = ((float) Math.ceil(rectF.top)) + 1.0f;
                rectF.top = ceil;
                rectF.bottom = Math.max(ceil, rectF.bottom);
            }
        }

        @Override // com.google.android.material.carousel.c
        public void o(View view, Rect rect, float f11, float f12) {
            view.offsetTopAndBottom((int) (f12 - (rect.top + f11)));
        }

        int p(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f28665b.getDecoratedMeasuredWidth(view) + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselLayoutManager f28666b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i11, CarouselLayoutManager carouselLayoutManager) {
            super(i11, null);
            this.f28666b = carouselLayoutManager;
        }

        @Override // com.google.android.material.carousel.c
        public void a(RectF rectF, RectF rectF2, RectF rectF3) {
            float f11 = rectF2.left;
            float f12 = rectF3.left;
            if (f11 < f12 && rectF2.right > f12) {
                float f13 = f12 - f11;
                rectF.left += f13;
                rectF2.left += f13;
            }
            float f14 = rectF2.right;
            float f15 = rectF3.right;
            if (f14 <= f15 || rectF2.left >= f15) {
                return;
            }
            float f16 = f14 - f15;
            rectF.right = Math.max(rectF.right - f16, rectF.left);
            rectF2.right = Math.max(rectF2.right - f16, rectF2.left);
        }

        @Override // com.google.android.material.carousel.c
        public float e(RecyclerView.n nVar) {
            return ((ViewGroup.MarginLayoutParams) nVar).rightMargin + ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
        }

        @Override // com.google.android.material.carousel.c
        public RectF f(float f11, float f12, float f13, float f14) {
            return new RectF(f14, 0.0f, f12 - f14, f11);
        }

        @Override // com.google.android.material.carousel.c
        int g() {
            return this.f28666b.getHeight() - this.f28666b.getPaddingBottom();
        }

        @Override // com.google.android.material.carousel.c
        int h() {
            return this.f28666b.X() ? i() : j();
        }

        @Override // com.google.android.material.carousel.c
        int i() {
            return 0;
        }

        @Override // com.google.android.material.carousel.c
        int j() {
            return this.f28666b.getWidth();
        }

        @Override // com.google.android.material.carousel.c
        int k() {
            return this.f28666b.X() ? j() : i();
        }

        @Override // com.google.android.material.carousel.c
        int l() {
            return this.f28666b.getPaddingTop();
        }

        @Override // com.google.android.material.carousel.c
        public void m(View view, int i11, int i12) {
            int l11 = l();
            this.f28666b.layoutDecoratedWithMargins(view, i11, l11, i12, l11 + p(view));
        }

        @Override // com.google.android.material.carousel.c
        public void n(RectF rectF, RectF rectF2, RectF rectF3) {
            if (rectF2.right <= rectF3.left) {
                float floor = ((float) Math.floor(rectF.right)) - 1.0f;
                rectF.right = floor;
                rectF.left = Math.min(rectF.left, floor);
            }
            if (rectF2.left >= rectF3.right) {
                float ceil = ((float) Math.ceil(rectF.left)) + 1.0f;
                rectF.left = ceil;
                rectF.right = Math.max(ceil, rectF.right);
            }
        }

        @Override // com.google.android.material.carousel.c
        public void o(View view, Rect rect, float f11, float f12) {
            view.offsetLeftAndRight((int) (f12 - (rect.left + f11)));
        }

        int p(View view) {
            RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
            return this.f28666b.getDecoratedMeasuredHeight(view) + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }
    }

    private c(int i11) {
        this.f28664a = i11;
    }

    /* synthetic */ c(int i11, a aVar) {
        this(i11);
    }

    private static c b(CarouselLayoutManager carouselLayoutManager) {
        return new b(0, carouselLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c c(CarouselLayoutManager carouselLayoutManager, int i11) {
        if (i11 == 0) {
            return b(carouselLayoutManager);
        }
        if (i11 == 1) {
            return d(carouselLayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    private static c d(CarouselLayoutManager carouselLayoutManager) {
        return new a(1, carouselLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(RectF rectF, RectF rectF2, RectF rectF3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract float e(RecyclerView.n nVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract RectF f(float f11, float f12, float f13, float f14);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int g();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int j();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int k();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int l();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void m(View view, int i11, int i12);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n(RectF rectF, RectF rectF2, RectF rectF3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(View view, Rect rect, float f11, float f12);
}
