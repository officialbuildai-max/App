package com.google.android.material.carousel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.carousel.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class CarouselLayoutManager extends RecyclerView.m implements com.google.android.material.carousel.b, RecyclerView.x.b {

    /* renamed from: a, reason: collision with root package name */
    int f28627a;

    /* renamed from: b, reason: collision with root package name */
    int f28628b;

    /* renamed from: c, reason: collision with root package name */
    int f28629c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f28630d;

    /* renamed from: e, reason: collision with root package name */
    private final c f28631e;

    /* renamed from: f, reason: collision with root package name */
    private com.google.android.material.carousel.d f28632f;

    /* renamed from: g, reason: collision with root package name */
    private g f28633g;

    /* renamed from: h, reason: collision with root package name */
    private f f28634h;

    /* renamed from: i, reason: collision with root package name */
    private int f28635i;

    /* renamed from: j, reason: collision with root package name */
    private Map f28636j;

    /* renamed from: k, reason: collision with root package name */
    private com.google.android.material.carousel.c f28637k;

    /* renamed from: l, reason: collision with root package name */
    private final View.OnLayoutChangeListener f28638l;

    /* renamed from: m, reason: collision with root package name */
    private int f28639m;

    /* renamed from: n, reason: collision with root package name */
    private int f28640n;

    /* renamed from: o, reason: collision with root package name */
    private int f28641o;

    /* loaded from: classes4.dex */
    class a extends androidx.recyclerview.widget.h {
        a(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.x
        public PointF a(int i11) {
            return CarouselLayoutManager.this.computeScrollVectorForPosition(i11);
        }

        @Override // androidx.recyclerview.widget.h
        public int t(View view, int i11) {
            if (CarouselLayoutManager.this.f28633g == null || !CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.A(carouselLayoutManager.getPosition(view));
        }

        @Override // androidx.recyclerview.widget.h
        public int u(View view, int i11) {
            if (CarouselLayoutManager.this.f28633g == null || CarouselLayoutManager.this.d()) {
                return 0;
            }
            CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
            return carouselLayoutManager.A(carouselLayoutManager.getPosition(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final View f28643a;

        /* renamed from: b, reason: collision with root package name */
        final float f28644b;

        /* renamed from: c, reason: collision with root package name */
        final float f28645c;

        /* renamed from: d, reason: collision with root package name */
        final d f28646d;

        b(View view, float f11, float f12, d dVar) {
            this.f28643a = view;
            this.f28644b = f11;
            this.f28645c = f12;
            this.f28646d = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends RecyclerView.l {

        /* renamed from: a, reason: collision with root package name */
        private final Paint f28647a;

        /* renamed from: b, reason: collision with root package name */
        private List f28648b;

        c() {
            Paint paint = new Paint();
            this.f28647a = paint;
            this.f28648b = Collections.unmodifiableList(new ArrayList());
            paint.setStrokeWidth(5.0f);
            paint.setColor(-65281);
        }

        void d(List list) {
            this.f28648b = Collections.unmodifiableList(list);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
            super.onDrawOver(canvas, recyclerView, yVar);
            this.f28647a.setStrokeWidth(recyclerView.getResources().getDimension(R$dimen.m3_carousel_debug_keyline_width));
            for (f.c cVar : this.f28648b) {
                this.f28647a.setColor(z0.b.d(-65281, -16776961, cVar.f28684c));
                if (((CarouselLayoutManager) recyclerView.getLayoutManager()).d()) {
                    canvas.drawLine(cVar.f28683b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).S(), cVar.f28683b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).N(), this.f28647a);
                } else {
                    canvas.drawLine(((CarouselLayoutManager) recyclerView.getLayoutManager()).P(), cVar.f28683b, ((CarouselLayoutManager) recyclerView.getLayoutManager()).Q(), cVar.f28683b, this.f28647a);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        final f.c f28649a;

        /* renamed from: b, reason: collision with root package name */
        final f.c f28650b;

        d(f.c cVar, f.c cVar2) {
            androidx.core.util.i.a(cVar.f28682a <= cVar2.f28682a);
            this.f28649a = cVar;
            this.f28650b = cVar2;
        }
    }

    public CarouselLayoutManager() {
        this(new i());
    }

    @SuppressLint({"UnknownNullness"})
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i11, int i12) {
        this.f28630d = false;
        this.f28631e = new c();
        this.f28635i = 0;
        this.f28638l = new View.OnLayoutChangeListener() { // from class: qa.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
                CarouselLayoutManager.this.a0(view, i13, i14, i15, i16, i17, i18, i19, i20);
            }
        };
        this.f28640n = -1;
        this.f28641o = 0;
        k0(new i());
        j0(context, attributeSet);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.d dVar) {
        this(dVar, 0);
    }

    public CarouselLayoutManager(com.google.android.material.carousel.d dVar, int i11) {
        this.f28630d = false;
        this.f28631e = new c();
        this.f28635i = 0;
        this.f28638l = new View.OnLayoutChangeListener() { // from class: qa.a
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20) {
                CarouselLayoutManager.this.a0(view, i13, i14, i15, i16, i17, i18, i19, i20);
            }
        };
        this.f28640n = -1;
        this.f28641o = 0;
        k0(dVar);
        setOrientation(i11);
    }

    private static int B(int i11, int i12, int i13, int i14) {
        int i15 = i12 + i11;
        return i15 < i13 ? i13 - i12 : i15 > i14 ? i14 - i12 : i11;
    }

    private int C(g gVar) {
        boolean X = X();
        f h11 = X ? gVar.h() : gVar.l();
        return (int) (R() - t((X ? h11.h() : h11.a()).f28682a, h11.f() / 2.0f));
    }

    private void D(RecyclerView.t tVar, RecyclerView.y yVar) {
        g0(tVar);
        if (getChildCount() == 0) {
            w(tVar, this.f28635i - 1);
            v(tVar, yVar, this.f28635i);
        } else {
            int position = getPosition(getChildAt(0));
            int position2 = getPosition(getChildAt(getChildCount() - 1));
            w(tVar, position - 1);
            v(tVar, yVar, position2 + 1);
        }
        o0();
    }

    private View E() {
        return getChildAt(X() ? 0 : getChildCount() - 1);
    }

    private View F() {
        return getChildAt(X() ? getChildCount() - 1 : 0);
    }

    private int G() {
        return d() ? a() : b();
    }

    private float H(View view) {
        super.getDecoratedBoundsWithMargins(view, new Rect());
        return d() ? r0.centerX() : r0.centerY();
    }

    private int I() {
        int i11;
        int i12;
        if (getChildCount() <= 0) {
            return 0;
        }
        RecyclerView.n nVar = (RecyclerView.n) getChildAt(0).getLayoutParams();
        if (this.f28637k.f28664a == 0) {
            i11 = ((ViewGroup.MarginLayoutParams) nVar).leftMargin;
            i12 = ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        } else {
            i11 = ((ViewGroup.MarginLayoutParams) nVar).topMargin;
            i12 = ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        }
        return i11 + i12;
    }

    private f J(int i11) {
        f fVar;
        Map map = this.f28636j;
        return (map == null || (fVar = (f) map.get(Integer.valueOf(d1.a.b(i11, 0, Math.max(0, getItemCount() + (-1)))))) == null) ? this.f28633g.g() : fVar;
    }

    private int K() {
        if (getClipToPadding() || !this.f28632f.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingTop() : getPaddingLeft();
    }

    private float L(float f11, d dVar) {
        f.c cVar = dVar.f28649a;
        float f12 = cVar.f28685d;
        f.c cVar2 = dVar.f28650b;
        return oa.a.b(f12, cVar2.f28685d, cVar.f28683b, cVar2.f28683b, f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int N() {
        return this.f28637k.g();
    }

    private int O() {
        return this.f28637k.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int P() {
        return this.f28637k.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int Q() {
        return this.f28637k.j();
    }

    private int R() {
        return this.f28637k.k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int S() {
        return this.f28637k.l();
    }

    private int T() {
        if (getClipToPadding() || !this.f28632f.f()) {
            return 0;
        }
        return getOrientation() == 1 ? getPaddingBottom() : getPaddingRight();
    }

    private int U(int i11, f fVar) {
        return X() ? (int) (((G() - fVar.h().f28682a) - (i11 * fVar.f())) - (fVar.f() / 2.0f)) : (int) (((i11 * fVar.f()) - fVar.a().f28682a) + (fVar.f() / 2.0f));
    }

    private int V(int i11, f fVar) {
        int i12 = Integer.MAX_VALUE;
        for (f.c cVar : fVar.e()) {
            float f11 = (i11 * fVar.f()) + (fVar.f() / 2.0f);
            int G = (X() ? (int) ((G() - cVar.f28682a) - f11) : (int) (f11 - cVar.f28682a)) - this.f28627a;
            if (Math.abs(i12) > Math.abs(G)) {
                i12 = G;
            }
        }
        return i12;
    }

    private static d W(List list, float f11, boolean z10) {
        float f12 = Float.MAX_VALUE;
        int i11 = -1;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        float f13 = -3.4028235E38f;
        float f14 = Float.MAX_VALUE;
        float f15 = Float.MAX_VALUE;
        for (int i15 = 0; i15 < list.size(); i15++) {
            f.c cVar = (f.c) list.get(i15);
            float f16 = z10 ? cVar.f28683b : cVar.f28682a;
            float abs = Math.abs(f16 - f11);
            if (f16 <= f11 && abs <= f12) {
                i11 = i15;
                f12 = abs;
            }
            if (f16 > f11 && abs <= f14) {
                i13 = i15;
                f14 = abs;
            }
            if (f16 <= f15) {
                i12 = i15;
                f15 = f16;
            }
            if (f16 > f13) {
                i14 = i15;
                f13 = f16;
            }
        }
        if (i11 == -1) {
            i11 = i12;
        }
        if (i13 == -1) {
            i13 = i14;
        }
        return new d((f.c) list.get(i11), (f.c) list.get(i13));
    }

    private boolean Y(float f11, d dVar) {
        float t11 = t(f11, L(f11, dVar) / 2.0f);
        if (X()) {
            if (t11 >= 0.0f) {
                return false;
            }
        } else if (t11 <= G()) {
            return false;
        }
        return true;
    }

    private boolean Z(float f11, d dVar) {
        float s11 = s(f11, L(f11, dVar) / 2.0f);
        if (X()) {
            if (s11 <= G()) {
                return false;
            }
        } else if (s11 >= 0.0f) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
        if (i11 == i15 && i12 == i16 && i13 == i17 && i14 == i18) {
            return;
        }
        view.post(new Runnable() { // from class: qa.b
            @Override // java.lang.Runnable
            public final void run() {
                CarouselLayoutManager.this.f0();
            }
        });
    }

    private void b0() {
        if (this.f28630d && Log.isLoggable("CarouselLayoutManager", 3)) {
            for (int i11 = 0; i11 < getChildCount(); i11++) {
                View childAt = getChildAt(i11);
                float H = H(childAt);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("item position ");
                sb2.append(getPosition(childAt));
                sb2.append(", center:");
                sb2.append(H);
                sb2.append(", child index:");
                sb2.append(i11);
            }
        }
    }

    private b c0(RecyclerView.t tVar, float f11, int i11) {
        View o11 = tVar.o(i11);
        measureChildWithMargins(o11, 0, 0);
        float s11 = s(f11, this.f28634h.f() / 2.0f);
        d W = W(this.f28634h.g(), s11, false);
        return new b(o11, s11, x(o11, s11, W), W);
    }

    private int convertFocusDirectionToLayoutDirection(int i11) {
        int orientation = getOrientation();
        if (i11 == 1) {
            return -1;
        }
        if (i11 == 2) {
            return 1;
        }
        if (i11 == 17) {
            if (orientation == 0) {
                return X() ? 1 : -1;
            }
            return Integer.MIN_VALUE;
        }
        if (i11 == 33) {
            return orientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i11 == 66) {
            if (orientation == 0) {
                return X() ? -1 : 1;
            }
            return Integer.MIN_VALUE;
        }
        if (i11 == 130) {
            return orientation == 1 ? 1 : Integer.MIN_VALUE;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Unknown focus request:");
        sb2.append(i11);
        return Integer.MIN_VALUE;
    }

    private float d0(View view, float f11, float f12, Rect rect) {
        float s11 = s(f11, f12);
        d W = W(this.f28634h.g(), s11, false);
        float x10 = x(view, s11, W);
        super.getDecoratedBoundsWithMargins(view, rect);
        l0(view, s11, W);
        this.f28637k.o(view, rect, f12, x10);
        return x10;
    }

    private void e0(RecyclerView.t tVar) {
        View o11 = tVar.o(0);
        measureChildWithMargins(o11, 0, 0);
        f g11 = this.f28632f.g(this, o11);
        if (X()) {
            g11 = f.n(g11, G());
        }
        this.f28633g = g.f(this, g11, I(), K(), T());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0() {
        this.f28633g = null;
        requestLayout();
    }

    private void g0(RecyclerView.t tVar) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            float H = H(childAt);
            if (!Z(H, W(this.f28634h.g(), H, true))) {
                break;
            } else {
                removeAndRecycleView(childAt, tVar);
            }
        }
        while (getChildCount() - 1 >= 0) {
            View childAt2 = getChildAt(getChildCount() - 1);
            float H2 = H(childAt2);
            if (!Y(H2, W(this.f28634h.g(), H2, true))) {
                return;
            } else {
                removeAndRecycleView(childAt2, tVar);
            }
        }
    }

    private void h0(RecyclerView recyclerView, int i11) {
        if (d()) {
            recyclerView.scrollBy(i11, 0);
        } else {
            recyclerView.scrollBy(0, i11);
        }
    }

    private void j0(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Carousel);
            i0(obtainStyledAttributes.getInt(R$styleable.Carousel_carousel_alignment, 0));
            setOrientation(obtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 0));
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void l0(View view, float f11, d dVar) {
        if (view instanceof h) {
            f.c cVar = dVar.f28649a;
            float f12 = cVar.f28684c;
            f.c cVar2 = dVar.f28650b;
            float b11 = oa.a.b(f12, cVar2.f28684c, cVar.f28682a, cVar2.f28682a, f11);
            float height = view.getHeight();
            float width = view.getWidth();
            RectF f13 = this.f28637k.f(height, width, oa.a.b(0.0f, height / 2.0f, 0.0f, 1.0f, b11), oa.a.b(0.0f, width / 2.0f, 0.0f, 1.0f, b11));
            float x10 = x(view, f11, dVar);
            RectF rectF = new RectF(x10 - (f13.width() / 2.0f), x10 - (f13.height() / 2.0f), x10 + (f13.width() / 2.0f), (f13.height() / 2.0f) + x10);
            RectF rectF2 = new RectF(P(), S(), Q(), N());
            if (this.f28632f.f()) {
                this.f28637k.a(f13, rectF, rectF2);
            }
            this.f28637k.n(f13, rectF, rectF2);
            ((h) view).setMaskRectF(f13);
        }
    }

    private void m0(g gVar) {
        int i11 = this.f28629c;
        int i12 = this.f28628b;
        if (i11 <= i12) {
            this.f28634h = X() ? gVar.h() : gVar.l();
        } else {
            this.f28634h = gVar.j(this.f28627a, i12, i11);
        }
        this.f28631e.d(this.f28634h.g());
    }

    private void n0() {
        int itemCount = getItemCount();
        int i11 = this.f28639m;
        if (itemCount == i11 || this.f28633g == null) {
            return;
        }
        if (this.f28632f.h(this, i11)) {
            f0();
        }
        this.f28639m = itemCount;
    }

    private void o0() {
        if (!this.f28630d || getChildCount() < 1) {
            return;
        }
        int i11 = 0;
        while (i11 < getChildCount() - 1) {
            int position = getPosition(getChildAt(i11));
            int i12 = i11 + 1;
            int position2 = getPosition(getChildAt(i12));
            if (position > position2) {
                b0();
                throw new IllegalStateException("Detected invalid child order. Child at index [" + i11 + "] had adapter position [" + position + "] and child at index [" + i12 + "] had adapter position [" + position2 + "].");
            }
            i11 = i12;
        }
    }

    private void r(View view, int i11, b bVar) {
        float f11 = this.f28634h.f() / 2.0f;
        addView(view, i11);
        float f12 = bVar.f28645c;
        this.f28637k.m(view, (int) (f12 - f11), (int) (f12 + f11));
        l0(view, bVar.f28644b, bVar.f28646d);
    }

    private float s(float f11, float f12) {
        return X() ? f11 - f12 : f11 + f12;
    }

    private int scrollBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (getChildCount() == 0 || i11 == 0) {
            return 0;
        }
        if (this.f28633g == null) {
            e0(tVar);
        }
        int B = B(i11, this.f28627a, this.f28628b, this.f28629c);
        this.f28627a += B;
        m0(this.f28633g);
        float f11 = this.f28634h.f() / 2.0f;
        float y10 = y(getPosition(getChildAt(0)));
        Rect rect = new Rect();
        float f12 = X() ? this.f28634h.h().f28683b : this.f28634h.a().f28683b;
        float f13 = Float.MAX_VALUE;
        for (int i12 = 0; i12 < getChildCount(); i12++) {
            View childAt = getChildAt(i12);
            float abs = Math.abs(f12 - d0(childAt, y10, f11, rect));
            if (childAt != null && abs < f13) {
                this.f28640n = getPosition(childAt);
                f13 = abs;
            }
            y10 = s(y10, this.f28634h.f());
        }
        D(tVar, yVar);
        return B;
    }

    private float t(float f11, float f12) {
        return X() ? f11 + f12 : f11 - f12;
    }

    private void u(RecyclerView.t tVar, int i11, int i12) {
        if (i11 < 0 || i11 >= getItemCount()) {
            return;
        }
        b c02 = c0(tVar, y(i11), i11);
        r(c02.f28643a, i12, c02);
    }

    private void v(RecyclerView.t tVar, RecyclerView.y yVar, int i11) {
        float y10 = y(i11);
        while (i11 < yVar.b()) {
            b c02 = c0(tVar, y10, i11);
            if (Y(c02.f28645c, c02.f28646d)) {
                return;
            }
            y10 = s(y10, this.f28634h.f());
            if (!Z(c02.f28645c, c02.f28646d)) {
                r(c02.f28643a, -1, c02);
            }
            i11++;
        }
    }

    private void w(RecyclerView.t tVar, int i11) {
        float y10 = y(i11);
        while (i11 >= 0) {
            b c02 = c0(tVar, y10, i11);
            if (Z(c02.f28645c, c02.f28646d)) {
                return;
            }
            y10 = t(y10, this.f28634h.f());
            if (!Y(c02.f28645c, c02.f28646d)) {
                r(c02.f28643a, 0, c02);
            }
            i11--;
        }
    }

    private float x(View view, float f11, d dVar) {
        f.c cVar = dVar.f28649a;
        float f12 = cVar.f28683b;
        f.c cVar2 = dVar.f28650b;
        float b11 = oa.a.b(f12, cVar2.f28683b, cVar.f28682a, cVar2.f28682a, f11);
        if (dVar.f28650b != this.f28634h.c() && dVar.f28649a != this.f28634h.j()) {
            return b11;
        }
        float e11 = this.f28637k.e((RecyclerView.n) view.getLayoutParams()) / this.f28634h.f();
        f.c cVar3 = dVar.f28650b;
        return b11 + ((f11 - cVar3.f28682a) * ((1.0f - cVar3.f28684c) + e11));
    }

    private float y(int i11) {
        return s(R() - this.f28627a, this.f28634h.f() * i11);
    }

    private int z(RecyclerView.y yVar, g gVar) {
        boolean X = X();
        f l11 = X ? gVar.l() : gVar.h();
        f.c a11 = X ? l11.a() : l11.h();
        int b11 = (int) (((((yVar.b() - 1) * l11.f()) * (X ? -1.0f : 1.0f)) - (a11.f28682a - R())) + (O() - a11.f28682a) + (X ? -a11.f28688g : a11.f28689h));
        return X ? Math.min(0, b11) : Math.max(0, b11);
    }

    int A(int i11) {
        return (int) (this.f28627a - U(i11, J(i11)));
    }

    int M(int i11, f fVar) {
        return U(i11, fVar) - this.f28627a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean X() {
        return d() && getLayoutDirection() == 1;
    }

    @Override // com.google.android.material.carousel.b
    public int a() {
        return getWidth();
    }

    @Override // com.google.android.material.carousel.b
    public int b() {
        return getHeight();
    }

    @Override // com.google.android.material.carousel.b
    public int c() {
        return this.f28641o;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollHorizontally() {
        return d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean canScrollVertically() {
        return !d();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollExtent(RecyclerView.y yVar) {
        if (getChildCount() == 0 || this.f28633g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getWidth() * (this.f28633g.g().f() / computeHorizontalScrollRange(yVar)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollOffset(RecyclerView.y yVar) {
        return this.f28627a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeHorizontalScrollRange(RecyclerView.y yVar) {
        return this.f28629c - this.f28628b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.x.b
    public PointF computeScrollVectorForPosition(int i11) {
        if (this.f28633g == null) {
            return null;
        }
        int M = M(i11, J(i11));
        return d() ? new PointF(M, 0.0f) : new PointF(0.0f, M);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollExtent(RecyclerView.y yVar) {
        if (getChildCount() == 0 || this.f28633g == null || getItemCount() <= 1) {
            return 0;
        }
        return (int) (getHeight() * (this.f28633g.g().f() / computeVerticalScrollRange(yVar)));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollOffset(RecyclerView.y yVar) {
        return this.f28627a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int computeVerticalScrollRange(RecyclerView.y yVar) {
        return this.f28629c - this.f28628b;
    }

    @Override // com.google.android.material.carousel.b
    public boolean d() {
        return this.f28637k.f28664a == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public RecyclerView.n generateDefaultLayoutParams() {
        return new RecyclerView.n(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        super.getDecoratedBoundsWithMargins(view, rect);
        float centerY = rect.centerY();
        if (d()) {
            centerY = rect.centerX();
        }
        float L = L(centerY, W(this.f28634h.g(), centerY, true));
        float width = d() ? (rect.width() - L) / 2.0f : 0.0f;
        float height = d() ? 0.0f : (rect.height() - L) / 2.0f;
        rect.set((int) (rect.left + width), (int) (rect.top + height), (int) (rect.right - width), (int) (rect.bottom - height));
    }

    public int getOrientation() {
        return this.f28637k.f28664a;
    }

    public void i0(int i11) {
        this.f28641o = i11;
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public void k0(com.google.android.material.carousel.d dVar) {
        this.f28632f = dVar;
        f0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void measureChildWithMargins(View view, int i11, int i12) {
        if (!(view instanceof h)) {
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
        RecyclerView.n nVar = (RecyclerView.n) view.getLayoutParams();
        Rect rect = new Rect();
        calculateItemDecorationsForChild(view, rect);
        int i13 = i11 + rect.left + rect.right;
        int i14 = i12 + rect.top + rect.bottom;
        g gVar = this.f28633g;
        float f11 = (gVar == null || this.f28637k.f28664a != 0) ? ((ViewGroup.MarginLayoutParams) nVar).width : gVar.g().f();
        g gVar2 = this.f28633g;
        view.measure(RecyclerView.m.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingLeft() + getPaddingRight() + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin + i13, (int) f11, canScrollHorizontally()), RecyclerView.m.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingTop() + getPaddingBottom() + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin + i14, (int) ((gVar2 == null || this.f28637k.f28664a != 1) ? ((ViewGroup.MarginLayoutParams) nVar).height : gVar2.g().f()), canScrollVertically()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.f28632f.e(recyclerView.getContext());
        f0();
        recyclerView.addOnLayoutChangeListener(this.f28638l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.t tVar) {
        super.onDetachedFromWindow(recyclerView, tVar);
        recyclerView.removeOnLayoutChangeListener(this.f28638l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public View onFocusSearchFailed(View view, int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        int convertFocusDirectionToLayoutDirection;
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i11)) == Integer.MIN_VALUE) {
            return null;
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            if (getPosition(view) == 0) {
                return null;
            }
            u(tVar, getPosition(getChildAt(0)) - 1, 0);
            return F();
        }
        if (getPosition(view) == getItemCount() - 1) {
            return null;
        }
        u(tVar, getPosition(getChildAt(getChildCount() - 1)) + 1, -1);
        return E();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(getPosition(getChildAt(0)));
            accessibilityEvent.setToIndex(getPosition(getChildAt(getChildCount() - 1)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsAdded(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsAdded(recyclerView, i11, i12);
        n0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onItemsRemoved(RecyclerView recyclerView, int i11, int i12) {
        super.onItemsRemoved(recyclerView, i11, i12);
        n0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutChildren(RecyclerView.t tVar, RecyclerView.y yVar) {
        if (yVar.b() <= 0 || G() <= 0.0f) {
            removeAndRecycleAllViews(tVar);
            this.f28635i = 0;
            return;
        }
        boolean X = X();
        boolean z10 = this.f28633g == null;
        if (z10) {
            e0(tVar);
        }
        int C = C(this.f28633g);
        int z11 = z(yVar, this.f28633g);
        this.f28628b = X ? z11 : C;
        if (X) {
            z11 = C;
        }
        this.f28629c = z11;
        if (z10) {
            this.f28627a = C;
            this.f28636j = this.f28633g.i(getItemCount(), this.f28628b, this.f28629c, X());
            int i11 = this.f28640n;
            if (i11 != -1) {
                this.f28627a = U(i11, J(i11));
            }
        }
        int i12 = this.f28627a;
        this.f28627a = i12 + B(0, i12, this.f28628b, this.f28629c);
        this.f28635i = d1.a.b(this.f28635i, 0, yVar.b());
        m0(this.f28633g);
        detachAndScrapAttachedViews(tVar);
        D(tVar, yVar);
        this.f28639m = getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void onLayoutCompleted(RecyclerView.y yVar) {
        super.onLayoutCompleted(yVar);
        if (getChildCount() == 0) {
            this.f28635i = 0;
        } else {
            this.f28635i = getPosition(getChildAt(0));
        }
        o0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean z10, boolean z11) {
        int V;
        if (this.f28633g == null || (V = V(getPosition(view), J(getPosition(view)))) == 0) {
            return false;
        }
        h0(recyclerView, V(getPosition(view), this.f28633g.j(this.f28627a + B(V, this.f28627a, this.f28628b, this.f28629c), this.f28628b, this.f28629c)));
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollHorizontallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (canScrollHorizontally()) {
            return scrollBy(i11, tVar, yVar);
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void scrollToPosition(int i11) {
        this.f28640n = i11;
        if (this.f28633g == null) {
            return;
        }
        this.f28627a = U(i11, J(i11));
        this.f28635i = d1.a.b(i11, 0, Math.max(0, getItemCount() - 1));
        m0(this.f28633g);
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public int scrollVerticallyBy(int i11, RecyclerView.t tVar, RecyclerView.y yVar) {
        if (canScrollVertically()) {
            return scrollBy(i11, tVar, yVar);
        }
        return 0;
    }

    public void setOrientation(int i11) {
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i11);
        }
        assertNotInLayoutOrScroll(null);
        com.google.android.material.carousel.c cVar = this.f28637k;
        if (cVar == null || i11 != cVar.f28664a) {
            this.f28637k = com.google.android.material.carousel.c.c(this, i11);
            f0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.m
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.y yVar, int i11) {
        a aVar = new a(recyclerView.getContext());
        aVar.p(i11);
        startSmoothScroll(aVar);
    }
}
