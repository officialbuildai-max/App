package ab;

import ab.n;
import ab.o;
import ab.p;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import com.google.android.material.R$attr;
import java.util.BitSet;

/* loaded from: classes4.dex */
public class i extends Drawable implements q {

    /* renamed from: x, reason: collision with root package name */
    private static final String f547x = "i";

    /* renamed from: y, reason: collision with root package name */
    private static final Paint f548y;

    /* renamed from: a, reason: collision with root package name */
    private c f549a;

    /* renamed from: b, reason: collision with root package name */
    private final p.g[] f550b;

    /* renamed from: c, reason: collision with root package name */
    private final p.g[] f551c;

    /* renamed from: d, reason: collision with root package name */
    private final BitSet f552d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f553e;

    /* renamed from: f, reason: collision with root package name */
    private final Matrix f554f;

    /* renamed from: g, reason: collision with root package name */
    private final Path f555g;

    /* renamed from: h, reason: collision with root package name */
    private final Path f556h;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f557i;

    /* renamed from: j, reason: collision with root package name */
    private final RectF f558j;

    /* renamed from: k, reason: collision with root package name */
    private final Region f559k;

    /* renamed from: l, reason: collision with root package name */
    private final Region f560l;

    /* renamed from: m, reason: collision with root package name */
    private n f561m;

    /* renamed from: n, reason: collision with root package name */
    private final Paint f562n;

    /* renamed from: o, reason: collision with root package name */
    private final Paint f563o;

    /* renamed from: p, reason: collision with root package name */
    private final za.a f564p;

    /* renamed from: q, reason: collision with root package name */
    private final o.b f565q;

    /* renamed from: r, reason: collision with root package name */
    private final o f566r;

    /* renamed from: s, reason: collision with root package name */
    private PorterDuffColorFilter f567s;

    /* renamed from: t, reason: collision with root package name */
    private PorterDuffColorFilter f568t;

    /* renamed from: u, reason: collision with root package name */
    private int f569u;

    /* renamed from: v, reason: collision with root package name */
    private final RectF f570v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f571w;

    /* loaded from: classes4.dex */
    class a implements o.b {
        a() {
        }

        @Override // ab.o.b
        public void a(p pVar, Matrix matrix, int i11) {
            i.this.f552d.set(i11 + 4, pVar.e());
            i.this.f551c[i11] = pVar.f(matrix);
        }

        @Override // ab.o.b
        public void b(p pVar, Matrix matrix, int i11) {
            i.this.f552d.set(i11, pVar.e());
            i.this.f550b[i11] = pVar.f(matrix);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b implements n.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ float f573a;

        b(float f11) {
            this.f573a = f11;
        }

        @Override // ab.n.c
        public d a(d dVar) {
            return dVar instanceof l ? dVar : new ab.b(this.f573a, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class c extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        n f575a;

        /* renamed from: b, reason: collision with root package name */
        ta.a f576b;

        /* renamed from: c, reason: collision with root package name */
        ColorFilter f577c;

        /* renamed from: d, reason: collision with root package name */
        ColorStateList f578d;

        /* renamed from: e, reason: collision with root package name */
        ColorStateList f579e;

        /* renamed from: f, reason: collision with root package name */
        ColorStateList f580f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f581g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f582h;

        /* renamed from: i, reason: collision with root package name */
        Rect f583i;

        /* renamed from: j, reason: collision with root package name */
        float f584j;

        /* renamed from: k, reason: collision with root package name */
        float f585k;

        /* renamed from: l, reason: collision with root package name */
        float f586l;

        /* renamed from: m, reason: collision with root package name */
        int f587m;

        /* renamed from: n, reason: collision with root package name */
        float f588n;

        /* renamed from: o, reason: collision with root package name */
        float f589o;

        /* renamed from: p, reason: collision with root package name */
        float f590p;

        /* renamed from: q, reason: collision with root package name */
        int f591q;

        /* renamed from: r, reason: collision with root package name */
        int f592r;

        /* renamed from: s, reason: collision with root package name */
        int f593s;

        /* renamed from: t, reason: collision with root package name */
        int f594t;

        /* renamed from: u, reason: collision with root package name */
        boolean f595u;

        /* renamed from: v, reason: collision with root package name */
        Paint.Style f596v;

        public c(c cVar) {
            this.f578d = null;
            this.f579e = null;
            this.f580f = null;
            this.f581g = null;
            this.f582h = PorterDuff.Mode.SRC_IN;
            this.f583i = null;
            this.f584j = 1.0f;
            this.f585k = 1.0f;
            this.f587m = 255;
            this.f588n = 0.0f;
            this.f589o = 0.0f;
            this.f590p = 0.0f;
            this.f591q = 0;
            this.f592r = 0;
            this.f593s = 0;
            this.f594t = 0;
            this.f595u = false;
            this.f596v = Paint.Style.FILL_AND_STROKE;
            this.f575a = cVar.f575a;
            this.f576b = cVar.f576b;
            this.f586l = cVar.f586l;
            this.f577c = cVar.f577c;
            this.f578d = cVar.f578d;
            this.f579e = cVar.f579e;
            this.f582h = cVar.f582h;
            this.f581g = cVar.f581g;
            this.f587m = cVar.f587m;
            this.f584j = cVar.f584j;
            this.f593s = cVar.f593s;
            this.f591q = cVar.f591q;
            this.f595u = cVar.f595u;
            this.f585k = cVar.f585k;
            this.f588n = cVar.f588n;
            this.f589o = cVar.f589o;
            this.f590p = cVar.f590p;
            this.f592r = cVar.f592r;
            this.f594t = cVar.f594t;
            this.f580f = cVar.f580f;
            this.f596v = cVar.f596v;
            if (cVar.f583i != null) {
                this.f583i = new Rect(cVar.f583i);
            }
        }

        public c(n nVar, ta.a aVar) {
            this.f578d = null;
            this.f579e = null;
            this.f580f = null;
            this.f581g = null;
            this.f582h = PorterDuff.Mode.SRC_IN;
            this.f583i = null;
            this.f584j = 1.0f;
            this.f585k = 1.0f;
            this.f587m = 255;
            this.f588n = 0.0f;
            this.f589o = 0.0f;
            this.f590p = 0.0f;
            this.f591q = 0;
            this.f592r = 0;
            this.f593s = 0;
            this.f594t = 0;
            this.f595u = false;
            this.f596v = Paint.Style.FILL_AND_STROKE;
            this.f575a = nVar;
            this.f576b = aVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i(this);
            iVar.f553e = true;
            return iVar;
        }
    }

    static {
        Paint paint = new Paint(1);
        f548y = paint;
        paint.setColor(-1);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    public i() {
        this(new n());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i(c cVar) {
        this.f550b = new p.g[4];
        this.f551c = new p.g[4];
        this.f552d = new BitSet(8);
        this.f554f = new Matrix();
        this.f555g = new Path();
        this.f556h = new Path();
        this.f557i = new RectF();
        this.f558j = new RectF();
        this.f559k = new Region();
        this.f560l = new Region();
        Paint paint = new Paint(1);
        this.f562n = paint;
        Paint paint2 = new Paint(1);
        this.f563o = paint2;
        this.f564p = new za.a();
        this.f566r = Looper.getMainLooper().getThread() == Thread.currentThread() ? o.k() : new o();
        this.f570v = new RectF();
        this.f571w = true;
        this.f549a = cVar;
        paint2.setStyle(Paint.Style.STROKE);
        paint.setStyle(Paint.Style.FILL);
        q0();
        p0(getState());
        this.f565q = new a();
    }

    public i(n nVar) {
        this(new c(nVar, null));
    }

    public i(Context context, AttributeSet attributeSet, int i11, int i12) {
        this(n.e(context, attributeSet, i11, i12).m());
    }

    private float I() {
        if (R()) {
            return this.f563o.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean P() {
        c cVar = this.f549a;
        int i11 = cVar.f591q;
        return i11 != 1 && cVar.f592r > 0 && (i11 == 2 || Z());
    }

    private boolean Q() {
        Paint.Style style = this.f549a.f596v;
        return style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.FILL;
    }

    private boolean R() {
        Paint.Style style = this.f549a.f596v;
        return (style == Paint.Style.FILL_AND_STROKE || style == Paint.Style.STROKE) && this.f563o.getStrokeWidth() > 0.0f;
    }

    private void T() {
        super.invalidateSelf();
    }

    private void W(Canvas canvas) {
        if (P()) {
            canvas.save();
            Y(canvas);
            if (!this.f571w) {
                p(canvas);
                canvas.restore();
                return;
            }
            int width = (int) (this.f570v.width() - getBounds().width());
            int height = (int) (this.f570v.height() - getBounds().height());
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path.");
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.f570v.width()) + (this.f549a.f592r * 2) + width, ((int) this.f570v.height()) + (this.f549a.f592r * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f11 = (getBounds().left - this.f549a.f592r) - width;
            float f12 = (getBounds().top - this.f549a.f592r) - height;
            canvas2.translate(-f11, -f12);
            p(canvas2);
            canvas.drawBitmap(createBitmap, f11, f12, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int X(int i11, int i12) {
        return (i11 * (i12 + (i12 >>> 7))) >>> 8;
    }

    private void Y(Canvas canvas) {
        canvas.translate(D(), E());
    }

    private PorterDuffColorFilter f(Paint paint, boolean z10) {
        if (!z10) {
            return null;
        }
        int color = paint.getColor();
        int l11 = l(color);
        this.f569u = l11;
        if (l11 != color) {
            return new PorterDuffColorFilter(l11, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void g(RectF rectF, Path path) {
        h(rectF, path);
        if (this.f549a.f584j != 1.0f) {
            this.f554f.reset();
            Matrix matrix = this.f554f;
            float f11 = this.f549a.f584j;
            matrix.setScale(f11, f11, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.f554f);
        }
        path.computeBounds(this.f570v, true);
    }

    private void i() {
        n y10 = G().y(new b(-I()));
        this.f561m = y10;
        this.f566r.e(y10, this.f549a.f585k, x(), this.f556h);
    }

    private PorterDuffColorFilter j(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z10) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z10) {
            colorForState = l(colorForState);
        }
        this.f569u = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter k(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z10) {
        return (colorStateList == null || mode == null) ? f(paint, z10) : j(colorStateList, mode, z10);
    }

    public static i m(Context context) {
        return n(context, 0.0f);
    }

    public static i n(Context context, float f11) {
        return o(context, f11, null);
    }

    public static i o(Context context, float f11, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(com.google.android.material.color.b.c(context, R$attr.colorSurface, i.class.getSimpleName()));
        }
        i iVar = new i();
        iVar.S(context);
        iVar.d0(colorStateList);
        iVar.c0(f11);
        return iVar;
    }

    private void p(Canvas canvas) {
        if (this.f552d.cardinality() > 0) {
            Log.w(f547x, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.f549a.f593s != 0) {
            canvas.drawPath(this.f555g, this.f564p.c());
        }
        for (int i11 = 0; i11 < 4; i11++) {
            this.f550b[i11].b(this.f564p, this.f549a.f592r, canvas);
            this.f551c[i11].b(this.f564p, this.f549a.f592r, canvas);
        }
        if (this.f571w) {
            int D = D();
            int E = E();
            canvas.translate(-D, -E);
            canvas.drawPath(this.f555g, f548y);
            canvas.translate(D, E);
        }
    }

    private boolean p0(int[] iArr) {
        boolean z10;
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        if (this.f549a.f578d == null || color2 == (colorForState2 = this.f549a.f578d.getColorForState(iArr, (color2 = this.f562n.getColor())))) {
            z10 = false;
        } else {
            this.f562n.setColor(colorForState2);
            z10 = true;
        }
        if (this.f549a.f579e == null || color == (colorForState = this.f549a.f579e.getColorForState(iArr, (color = this.f563o.getColor())))) {
            return z10;
        }
        this.f563o.setColor(colorForState);
        return true;
    }

    private void q(Canvas canvas) {
        r(canvas, this.f562n, this.f555g, this.f549a.f575a, w());
    }

    private boolean q0() {
        PorterDuffColorFilter porterDuffColorFilter = this.f567s;
        PorterDuffColorFilter porterDuffColorFilter2 = this.f568t;
        c cVar = this.f549a;
        this.f567s = k(cVar.f581g, cVar.f582h, this.f562n, true);
        c cVar2 = this.f549a;
        this.f568t = k(cVar2.f580f, cVar2.f582h, this.f563o, false);
        c cVar3 = this.f549a;
        if (cVar3.f595u) {
            this.f564p.d(cVar3.f581g.getColorForState(getState(), 0));
        }
        return (androidx.core.util.d.a(porterDuffColorFilter, this.f567s) && androidx.core.util.d.a(porterDuffColorFilter2, this.f568t)) ? false : true;
    }

    private void r(Canvas canvas, Paint paint, Path path, n nVar, RectF rectF) {
        if (!nVar.u(rectF)) {
            canvas.drawPath(path, paint);
        } else {
            float a11 = nVar.t().a(rectF) * this.f549a.f585k;
            canvas.drawRoundRect(rectF, a11, a11, paint);
        }
    }

    private void r0() {
        float O = O();
        this.f549a.f592r = (int) Math.ceil(0.75f * O);
        this.f549a.f593s = (int) Math.ceil(O * 0.25f);
        q0();
        T();
    }

    private RectF x() {
        this.f558j.set(w());
        float I = I();
        this.f558j.inset(I, I);
        return this.f558j;
    }

    public float A() {
        return this.f549a.f585k;
    }

    public float B() {
        return this.f549a.f588n;
    }

    public int C() {
        return this.f569u;
    }

    public int D() {
        c cVar = this.f549a;
        return (int) (cVar.f593s * Math.sin(Math.toRadians(cVar.f594t)));
    }

    public int E() {
        c cVar = this.f549a;
        return (int) (cVar.f593s * Math.cos(Math.toRadians(cVar.f594t)));
    }

    public int F() {
        return this.f549a.f592r;
    }

    public n G() {
        return this.f549a.f575a;
    }

    public ColorStateList H() {
        return this.f549a.f579e;
    }

    public float J() {
        return this.f549a.f586l;
    }

    public ColorStateList K() {
        return this.f549a.f581g;
    }

    public float L() {
        return this.f549a.f575a.r().a(w());
    }

    public float M() {
        return this.f549a.f575a.t().a(w());
    }

    public float N() {
        return this.f549a.f590p;
    }

    public float O() {
        return y() + N();
    }

    public void S(Context context) {
        this.f549a.f576b = new ta.a(context);
        r0();
    }

    public boolean U() {
        ta.a aVar = this.f549a.f576b;
        return aVar != null && aVar.e();
    }

    public boolean V() {
        return this.f549a.f575a.u(w());
    }

    public boolean Z() {
        return (V() || this.f555g.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    public void a0(float f11) {
        setShapeAppearanceModel(this.f549a.f575a.w(f11));
    }

    public void b0(d dVar) {
        setShapeAppearanceModel(this.f549a.f575a.x(dVar));
    }

    public void c0(float f11) {
        c cVar = this.f549a;
        if (cVar.f589o != f11) {
            cVar.f589o = f11;
            r0();
        }
    }

    public void d0(ColorStateList colorStateList) {
        c cVar = this.f549a;
        if (cVar.f578d != colorStateList) {
            cVar.f578d = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f562n.setColorFilter(this.f567s);
        int alpha = this.f562n.getAlpha();
        this.f562n.setAlpha(X(alpha, this.f549a.f587m));
        this.f563o.setColorFilter(this.f568t);
        this.f563o.setStrokeWidth(this.f549a.f586l);
        int alpha2 = this.f563o.getAlpha();
        this.f563o.setAlpha(X(alpha2, this.f549a.f587m));
        if (this.f553e) {
            i();
            g(w(), this.f555g);
            this.f553e = false;
        }
        W(canvas);
        if (Q()) {
            q(canvas);
        }
        if (R()) {
            t(canvas);
        }
        this.f562n.setAlpha(alpha);
        this.f563o.setAlpha(alpha2);
    }

    public void e0(float f11) {
        c cVar = this.f549a;
        if (cVar.f585k != f11) {
            cVar.f585k = f11;
            this.f553e = true;
            invalidateSelf();
        }
    }

    public void f0(int i11, int i12, int i13, int i14) {
        c cVar = this.f549a;
        if (cVar.f583i == null) {
            cVar.f583i = new Rect();
        }
        this.f549a.f583i.set(i11, i12, i13, i14);
        invalidateSelf();
    }

    public void g0(Paint.Style style) {
        this.f549a.f596v = style;
        T();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f549a.f587m;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f549a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f549a.f591q == 2) {
            return;
        }
        if (V()) {
            outline.setRoundRect(getBounds(), L() * this.f549a.f585k);
        } else {
            g(w(), this.f555g);
            com.google.android.material.drawable.d.l(outline, this.f555g);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        Rect rect2 = this.f549a.f583i;
        if (rect2 == null) {
            return super.getPadding(rect);
        }
        rect.set(rect2);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.f559k.set(getBounds());
        g(w(), this.f555g);
        this.f560l.setPath(this.f555g, this.f559k);
        this.f559k.op(this.f560l, Region.Op.DIFFERENCE);
        return this.f559k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void h(RectF rectF, Path path) {
        o oVar = this.f566r;
        c cVar = this.f549a;
        oVar.d(cVar.f575a, cVar.f585k, rectF, this.f565q, path);
    }

    public void h0(float f11) {
        c cVar = this.f549a;
        if (cVar.f588n != f11) {
            cVar.f588n = f11;
            r0();
        }
    }

    public void i0(boolean z10) {
        this.f571w = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.f553e = true;
        super.invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        ColorStateList colorStateList3;
        ColorStateList colorStateList4;
        return super.isStateful() || ((colorStateList = this.f549a.f581g) != null && colorStateList.isStateful()) || (((colorStateList2 = this.f549a.f580f) != null && colorStateList2.isStateful()) || (((colorStateList3 = this.f549a.f579e) != null && colorStateList3.isStateful()) || ((colorStateList4 = this.f549a.f578d) != null && colorStateList4.isStateful())));
    }

    public void j0(int i11) {
        this.f564p.d(i11);
        this.f549a.f595u = false;
        T();
    }

    public void k0(int i11) {
        c cVar = this.f549a;
        if (cVar.f591q != i11) {
            cVar.f591q = i11;
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int l(int i11) {
        float O = O() + B();
        ta.a aVar = this.f549a.f576b;
        return aVar != null ? aVar.c(i11, O) : i11;
    }

    public void l0(float f11, int i11) {
        o0(f11);
        n0(ColorStateList.valueOf(i11));
    }

    public void m0(float f11, ColorStateList colorStateList) {
        o0(f11);
        n0(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f549a = new c(this.f549a);
        return this;
    }

    public void n0(ColorStateList colorStateList) {
        c cVar = this.f549a;
        if (cVar.f579e != colorStateList) {
            cVar.f579e = colorStateList;
            onStateChange(getState());
        }
    }

    public void o0(float f11) {
        this.f549a.f586l = f11;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f553e = true;
        super.onBoundsChange(rect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        boolean z10 = p0(iArr) || q0();
        if (z10) {
            invalidateSelf();
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s(Canvas canvas, Paint paint, Path path, RectF rectF) {
        r(canvas, paint, path, this.f549a.f575a, rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        c cVar = this.f549a;
        if (cVar.f587m != i11) {
            cVar.f587m = i11;
            T();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f549a.f577c = colorFilter;
        T();
    }

    @Override // ab.q
    public void setShapeAppearanceModel(n nVar) {
        this.f549a.f575a = nVar;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f549a.f581g = colorStateList;
        q0();
        T();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f549a;
        if (cVar.f582h != mode) {
            cVar.f582h = mode;
            q0();
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t(Canvas canvas) {
        r(canvas, this.f563o, this.f556h, this.f561m, x());
    }

    public float u() {
        return this.f549a.f575a.j().a(w());
    }

    public float v() {
        return this.f549a.f575a.l().a(w());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF w() {
        this.f557i.set(getBounds());
        return this.f557i;
    }

    public float y() {
        return this.f549a.f589o;
    }

    public ColorStateList z() {
        return this.f549a.f578d;
    }
}
