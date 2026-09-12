package com.airbnb.lottie.model.layer;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.content.LBlendMode;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.layer.Layer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import n4.a;
import n4.h;
import n4.p;
import u4.j;
import v4.l;

/* loaded from: classes2.dex */
public abstract class a implements m4.e, a.b, p4.e {
    private Paint A;
    float B;
    BlurMaskFilter C;
    l4.a D;

    /* renamed from: a, reason: collision with root package name */
    private final Path f17940a = new Path();

    /* renamed from: b, reason: collision with root package name */
    private final Matrix f17941b = new Matrix();

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f17942c = new Matrix();

    /* renamed from: d, reason: collision with root package name */
    private final Paint f17943d = new l4.a(1);

    /* renamed from: e, reason: collision with root package name */
    private final Paint f17944e;

    /* renamed from: f, reason: collision with root package name */
    private final Paint f17945f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f17946g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f17947h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f17948i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f17949j;

    /* renamed from: k, reason: collision with root package name */
    private final RectF f17950k;

    /* renamed from: l, reason: collision with root package name */
    private final RectF f17951l;

    /* renamed from: m, reason: collision with root package name */
    private final RectF f17952m;

    /* renamed from: n, reason: collision with root package name */
    private final String f17953n;

    /* renamed from: o, reason: collision with root package name */
    final Matrix f17954o;

    /* renamed from: p, reason: collision with root package name */
    final LottieDrawable f17955p;

    /* renamed from: q, reason: collision with root package name */
    final Layer f17956q;

    /* renamed from: r, reason: collision with root package name */
    private h f17957r;

    /* renamed from: s, reason: collision with root package name */
    private n4.d f17958s;

    /* renamed from: t, reason: collision with root package name */
    private a f17959t;

    /* renamed from: u, reason: collision with root package name */
    private a f17960u;

    /* renamed from: v, reason: collision with root package name */
    private List f17961v;

    /* renamed from: w, reason: collision with root package name */
    private final List f17962w;

    /* renamed from: x, reason: collision with root package name */
    public final p f17963x;

    /* renamed from: y, reason: collision with root package name */
    private boolean f17964y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f17965z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.airbnb.lottie.model.layer.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class C0180a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f17966a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f17967b;

        static {
            int[] iArr = new int[Mask.MaskMode.values().length];
            f17967b = iArr;
            try {
                iArr[Mask.MaskMode.MASK_MODE_NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17967b[Mask.MaskMode.MASK_MODE_SUBTRACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17967b[Mask.MaskMode.MASK_MODE_INTERSECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17967b[Mask.MaskMode.MASK_MODE_ADD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[Layer.LayerType.values().length];
            f17966a = iArr2;
            try {
                iArr2[Layer.LayerType.SHAPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f17966a[Layer.LayerType.PRE_COMP.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f17966a[Layer.LayerType.SOLID.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f17966a[Layer.LayerType.IMAGE.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f17966a[Layer.LayerType.NULL.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f17966a[Layer.LayerType.TEXT.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f17966a[Layer.LayerType.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(LottieDrawable lottieDrawable, Layer layer) {
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        this.f17944e = new l4.a(1, mode);
        PorterDuff.Mode mode2 = PorterDuff.Mode.DST_OUT;
        this.f17945f = new l4.a(1, mode2);
        l4.a aVar = new l4.a(1);
        this.f17946g = aVar;
        this.f17947h = new l4.a(PorterDuff.Mode.CLEAR);
        this.f17948i = new RectF();
        this.f17949j = new RectF();
        this.f17950k = new RectF();
        this.f17951l = new RectF();
        this.f17952m = new RectF();
        this.f17954o = new Matrix();
        this.f17962w = new ArrayList();
        this.f17964y = true;
        this.B = 0.0f;
        this.f17955p = lottieDrawable;
        this.f17956q = layer;
        this.f17953n = layer.j() + "#draw";
        if (layer.i() == Layer.MatteType.INVERT) {
            aVar.setXfermode(new PorterDuffXfermode(mode2));
        } else {
            aVar.setXfermode(new PorterDuffXfermode(mode));
        }
        p b11 = layer.x().b();
        this.f17963x = b11;
        b11.b(this);
        if (layer.h() != null && !layer.h().isEmpty()) {
            h hVar = new h(layer.h());
            this.f17957r = hVar;
            Iterator it = hVar.a().iterator();
            while (it.hasNext()) {
                ((n4.a) it.next()).a(this);
            }
            for (n4.a aVar2 : this.f17957r.c()) {
                i(aVar2);
                aVar2.a(this);
            }
        }
        O();
    }

    private void C(RectF rectF, Matrix matrix) {
        this.f17950k.set(0.0f, 0.0f, 0.0f, 0.0f);
        if (A()) {
            int size = this.f17957r.b().size();
            for (int i11 = 0; i11 < size; i11++) {
                Mask mask = (Mask) this.f17957r.b().get(i11);
                Path path = (Path) ((n4.a) this.f17957r.a().get(i11)).h();
                if (path != null) {
                    this.f17940a.set(path);
                    this.f17940a.transform(matrix);
                    int i12 = C0180a.f17967b[mask.a().ordinal()];
                    if (i12 == 1 || i12 == 2) {
                        return;
                    }
                    if ((i12 == 3 || i12 == 4) && mask.d()) {
                        return;
                    }
                    this.f17940a.computeBounds(this.f17952m, false);
                    if (i11 == 0) {
                        this.f17950k.set(this.f17952m);
                    } else {
                        RectF rectF2 = this.f17950k;
                        rectF2.set(Math.min(rectF2.left, this.f17952m.left), Math.min(this.f17950k.top, this.f17952m.top), Math.max(this.f17950k.right, this.f17952m.right), Math.max(this.f17950k.bottom, this.f17952m.bottom));
                    }
                }
            }
            if (rectF.intersect(this.f17950k)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void D(RectF rectF, Matrix matrix) {
        if (B() && this.f17956q.i() != Layer.MatteType.INVERT) {
            this.f17951l.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f17959t.f(this.f17951l, matrix, true);
            if (rectF.intersect(this.f17951l)) {
                return;
            }
            rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    private void E() {
        this.f17955p.invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        N(this.f17958s.q() == 1.0f);
    }

    private void G(float f11) {
        this.f17955p.O().n().a(this.f17956q.j(), f11);
    }

    private void N(boolean z10) {
        if (z10 != this.f17964y) {
            this.f17964y = z10;
            E();
        }
    }

    private void O() {
        if (this.f17956q.f().isEmpty()) {
            N(true);
            return;
        }
        n4.d dVar = new n4.d(this.f17956q.f());
        this.f17958s = dVar;
        dVar.m();
        this.f17958s.a(new a.b() { // from class: s4.a
            @Override // n4.a.b
            public final void a() {
                com.airbnb.lottie.model.layer.a.this.F();
            }
        });
        N(((Float) this.f17958s.h()).floatValue() == 1.0f);
        i(this.f17958s);
    }

    private void j(Canvas canvas, Matrix matrix, n4.a aVar, n4.a aVar2) {
        this.f17940a.set((Path) aVar.h());
        this.f17940a.transform(matrix);
        this.f17943d.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f17940a, this.f17943d);
    }

    private void k(Canvas canvas, Matrix matrix, n4.a aVar, n4.a aVar2) {
        l.n(canvas, this.f17948i, this.f17944e);
        this.f17940a.set((Path) aVar.h());
        this.f17940a.transform(matrix);
        this.f17943d.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f17940a, this.f17943d);
        canvas.restore();
    }

    private void l(Canvas canvas, Matrix matrix, n4.a aVar, n4.a aVar2) {
        l.n(canvas, this.f17948i, this.f17943d);
        canvas.drawRect(this.f17948i, this.f17943d);
        this.f17940a.set((Path) aVar.h());
        this.f17940a.transform(matrix);
        this.f17943d.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        canvas.drawPath(this.f17940a, this.f17945f);
        canvas.restore();
    }

    private void m(Canvas canvas, Matrix matrix, n4.a aVar, n4.a aVar2) {
        l.n(canvas, this.f17948i, this.f17944e);
        canvas.drawRect(this.f17948i, this.f17943d);
        this.f17945f.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        this.f17940a.set((Path) aVar.h());
        this.f17940a.transform(matrix);
        canvas.drawPath(this.f17940a, this.f17945f);
        canvas.restore();
    }

    private void n(Canvas canvas, Matrix matrix, n4.a aVar, n4.a aVar2) {
        l.n(canvas, this.f17948i, this.f17945f);
        canvas.drawRect(this.f17948i, this.f17943d);
        this.f17945f.setAlpha((int) (((Integer) aVar2.h()).intValue() * 2.55f));
        this.f17940a.set((Path) aVar.h());
        this.f17940a.transform(matrix);
        canvas.drawPath(this.f17940a, this.f17945f);
        canvas.restore();
    }

    private void o(Canvas canvas, Matrix matrix) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#saveLayer");
        }
        l.o(canvas, this.f17948i, this.f17944e, 19);
        if (Build.VERSION.SDK_INT < 28) {
            s(canvas);
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#saveLayer");
        }
        for (int i11 = 0; i11 < this.f17957r.b().size(); i11++) {
            Mask mask = (Mask) this.f17957r.b().get(i11);
            n4.a aVar = (n4.a) this.f17957r.a().get(i11);
            n4.a aVar2 = (n4.a) this.f17957r.c().get(i11);
            int i12 = C0180a.f17967b[mask.a().ordinal()];
            if (i12 != 1) {
                if (i12 == 2) {
                    if (i11 == 0) {
                        this.f17943d.setColor(ViewCompat.MEASURED_STATE_MASK);
                        this.f17943d.setAlpha(255);
                        canvas.drawRect(this.f17948i, this.f17943d);
                    }
                    if (mask.d()) {
                        n(canvas, matrix, aVar, aVar2);
                    } else {
                        p(canvas, matrix, aVar);
                    }
                } else if (i12 != 3) {
                    if (i12 == 4) {
                        if (mask.d()) {
                            l(canvas, matrix, aVar, aVar2);
                        } else {
                            j(canvas, matrix, aVar, aVar2);
                        }
                    }
                } else if (mask.d()) {
                    m(canvas, matrix, aVar, aVar2);
                } else {
                    k(canvas, matrix, aVar, aVar2);
                }
            } else if (q()) {
                this.f17943d.setAlpha(255);
                canvas.drawRect(this.f17948i, this.f17943d);
            }
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#restoreLayer");
        }
        canvas.restore();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#restoreLayer");
        }
    }

    private void p(Canvas canvas, Matrix matrix, n4.a aVar) {
        this.f17940a.set((Path) aVar.h());
        this.f17940a.transform(matrix);
        canvas.drawPath(this.f17940a, this.f17945f);
    }

    private boolean q() {
        if (this.f17957r.a().isEmpty()) {
            return false;
        }
        for (int i11 = 0; i11 < this.f17957r.b().size(); i11++) {
            if (((Mask) this.f17957r.b().get(i11)).a() != Mask.MaskMode.MASK_MODE_NONE) {
                return false;
            }
        }
        return true;
    }

    private void r() {
        if (this.f17961v != null) {
            return;
        }
        if (this.f17960u == null) {
            this.f17961v = Collections.emptyList();
            return;
        }
        this.f17961v = new ArrayList();
        for (a aVar = this.f17960u; aVar != null; aVar = aVar.f17960u) {
            this.f17961v.add(aVar);
        }
    }

    private void s(Canvas canvas) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#clearLayer");
        }
        RectF rectF = this.f17948i;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f17947h);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#clearLayer");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a u(b bVar, Layer layer, LottieDrawable lottieDrawable, com.airbnb.lottie.h hVar) {
        switch (C0180a.f17966a[layer.g().ordinal()]) {
            case 1:
                return new e(lottieDrawable, layer, bVar, hVar);
            case 2:
                return new b(lottieDrawable, layer, hVar.o(layer.n()), hVar);
            case 3:
                return new f(lottieDrawable, layer);
            case 4:
                return new c(lottieDrawable, layer);
            case 5:
                return new d(lottieDrawable, layer);
            case 6:
                return new g(lottieDrawable, layer);
            default:
                v4.f.c("Unknown layer type " + layer.g());
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        h hVar = this.f17957r;
        return (hVar == null || hVar.a().isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean B() {
        return this.f17959t != null;
    }

    public void H(n4.a aVar) {
        this.f17962w.remove(aVar);
    }

    void I(p4.d dVar, int i11, List list, p4.d dVar2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J(a aVar) {
        this.f17959t = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(boolean z10) {
        if (z10 && this.A == null) {
            this.A = new l4.a();
        }
        this.f17965z = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(a aVar) {
        this.f17960u = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(float f11) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseLayer#setProgress");
            com.airbnb.lottie.d.b("BaseLayer#setProgress.transform");
        }
        this.f17963x.j(f11);
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseLayer#setProgress.transform");
        }
        if (this.f17957r != null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("BaseLayer#setProgress.mask");
            }
            for (int i11 = 0; i11 < this.f17957r.a().size(); i11++) {
                ((n4.a) this.f17957r.a().get(i11)).n(f11);
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseLayer#setProgress.mask");
            }
        }
        if (this.f17958s != null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("BaseLayer#setProgress.inout");
            }
            this.f17958s.n(f11);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseLayer#setProgress.inout");
            }
        }
        if (this.f17959t != null) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("BaseLayer#setProgress.matte");
            }
            this.f17959t.M(f11);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseLayer#setProgress.matte");
            }
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseLayer#setProgress.animations." + this.f17962w.size());
        }
        for (int i12 = 0; i12 < this.f17962w.size(); i12++) {
            ((n4.a) this.f17962w.get(i12)).n(f11);
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseLayer#setProgress.animations." + this.f17962w.size());
            com.airbnb.lottie.d.c("BaseLayer#setProgress");
        }
    }

    @Override // n4.a.b
    public void a() {
        E();
    }

    @Override // p4.e
    public void b(Object obj, w4.c cVar) {
        this.f17963x.c(obj, cVar);
    }

    @Override // m4.c
    public void c(List list, List list2) {
    }

    @Override // p4.e
    public void d(p4.d dVar, int i11, List list, p4.d dVar2) {
        a aVar = this.f17959t;
        if (aVar != null) {
            p4.d a11 = dVar2.a(aVar.getName());
            if (dVar.c(this.f17959t.getName(), i11)) {
                list.add(a11.i(this.f17959t));
            }
            if (dVar.h(getName(), i11)) {
                this.f17959t.I(dVar, dVar.e(this.f17959t.getName(), i11) + i11, list, a11);
            }
        }
        if (dVar.g(getName(), i11)) {
            if (!"__container".equals(getName())) {
                dVar2 = dVar2.a(getName());
                if (dVar.c(getName(), i11)) {
                    list.add(dVar2.i(this));
                }
            }
            if (dVar.h(getName(), i11)) {
                I(dVar, i11 + dVar.e(getName(), i11), list, dVar2);
            }
        }
    }

    @Override // m4.e
    public void f(RectF rectF, Matrix matrix, boolean z10) {
        this.f17948i.set(0.0f, 0.0f, 0.0f, 0.0f);
        r();
        this.f17954o.set(matrix);
        if (z10) {
            List list = this.f17961v;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f17954o.preConcat(((a) this.f17961v.get(size)).f17963x.f());
                }
            } else {
                a aVar = this.f17960u;
                if (aVar != null) {
                    this.f17954o.preConcat(aVar.f17963x.f());
                }
            }
        }
        this.f17954o.preConcat(this.f17963x.f());
    }

    @Override // m4.c
    public String getName() {
        return this.f17956q.j();
    }

    @Override // m4.e
    public void h(Canvas canvas, Matrix matrix, int i11) {
        Paint paint;
        Integer num;
        com.airbnb.lottie.d.b(this.f17953n);
        if (!this.f17964y || this.f17956q.y()) {
            com.airbnb.lottie.d.c(this.f17953n);
            return;
        }
        r();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#parentMatrix");
        }
        this.f17941b.reset();
        this.f17941b.set(matrix);
        for (int size = this.f17961v.size() - 1; size >= 0; size--) {
            this.f17941b.preConcat(((a) this.f17961v.get(size)).f17963x.f());
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#parentMatrix");
        }
        n4.a h11 = this.f17963x.h();
        int intValue = (int) ((((i11 / 255.0f) * ((h11 == null || (num = (Integer) h11.h()) == null) ? 100 : num.intValue())) / 100.0f) * 255.0f);
        if (!B() && !A() && v() == LBlendMode.NORMAL) {
            this.f17941b.preConcat(this.f17963x.f());
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#drawLayer");
            }
            t(canvas, this.f17941b, intValue);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#drawLayer");
            }
            G(com.airbnb.lottie.d.c(this.f17953n));
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("Layer#computeBounds");
        }
        f(this.f17948i, this.f17941b, false);
        D(this.f17948i, matrix);
        this.f17941b.preConcat(this.f17963x.f());
        C(this.f17948i, this.f17941b);
        this.f17949j.set(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight());
        canvas.getMatrix(this.f17942c);
        if (!this.f17942c.isIdentity()) {
            Matrix matrix2 = this.f17942c;
            matrix2.invert(matrix2);
            this.f17942c.mapRect(this.f17949j);
        }
        if (!this.f17948i.intersect(this.f17949j)) {
            this.f17948i.set(0.0f, 0.0f, 0.0f, 0.0f);
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("Layer#computeBounds");
        }
        if (this.f17948i.width() >= 1.0f && this.f17948i.height() >= 1.0f) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#saveLayer");
            }
            this.f17943d.setAlpha(255);
            z0.d.b(this.f17943d, v().toNativeBlendMode());
            l.n(canvas, this.f17948i, this.f17943d);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#saveLayer");
            }
            if (v() != LBlendMode.MULTIPLY) {
                s(canvas);
            } else {
                if (this.D == null) {
                    l4.a aVar = new l4.a();
                    this.D = aVar;
                    aVar.setColor(-1);
                }
                RectF rectF = this.f17948i;
                canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.D);
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#drawLayer");
            }
            t(canvas, this.f17941b, intValue);
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#drawLayer");
            }
            if (A()) {
                o(canvas, this.f17941b);
            }
            if (B()) {
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.b("Layer#drawMatte");
                    com.airbnb.lottie.d.b("Layer#saveLayer");
                }
                l.o(canvas, this.f17948i, this.f17946g, 19);
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("Layer#saveLayer");
                }
                s(canvas);
                this.f17959t.h(canvas, matrix, intValue);
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.b("Layer#restoreLayer");
                }
                canvas.restore();
                if (com.airbnb.lottie.d.g()) {
                    com.airbnb.lottie.d.c("Layer#restoreLayer");
                    com.airbnb.lottie.d.c("Layer#drawMatte");
                }
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.b("Layer#restoreLayer");
            }
            canvas.restore();
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("Layer#restoreLayer");
            }
        }
        if (this.f17965z && (paint = this.A) != null) {
            paint.setStyle(Paint.Style.STROKE);
            this.A.setColor(-251901);
            this.A.setStrokeWidth(4.0f);
            canvas.drawRect(this.f17948i, this.A);
            this.A.setStyle(Paint.Style.FILL);
            this.A.setColor(1357638635);
            canvas.drawRect(this.f17948i, this.A);
        }
        G(com.airbnb.lottie.d.c(this.f17953n));
    }

    public void i(n4.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f17962w.add(aVar);
    }

    abstract void t(Canvas canvas, Matrix matrix, int i11);

    public LBlendMode v() {
        return this.f17956q.a();
    }

    public r4.a w() {
        return this.f17956q.b();
    }

    public BlurMaskFilter x(float f11) {
        if (this.B == f11) {
            return this.C;
        }
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(f11 / 2.0f, BlurMaskFilter.Blur.NORMAL);
        this.C = blurMaskFilter;
        this.B = f11;
        return blurMaskFilter;
    }

    public j y() {
        return this.f17956q.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Layer z() {
        return this.f17956q;
    }
}
