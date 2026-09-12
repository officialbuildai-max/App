package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;

/* loaded from: classes.dex */
public class DrawableContainerCompat extends Drawable implements Drawable.Callback {

    /* renamed from: a, reason: collision with root package name */
    private c f1266a;

    /* renamed from: b, reason: collision with root package name */
    private Rect f1267b;

    /* renamed from: c, reason: collision with root package name */
    private Drawable f1268c;

    /* renamed from: d, reason: collision with root package name */
    private Drawable f1269d;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1271f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f1273h;

    /* renamed from: i, reason: collision with root package name */
    private Runnable f1274i;

    /* renamed from: j, reason: collision with root package name */
    private long f1275j;

    /* renamed from: k, reason: collision with root package name */
    private long f1276k;

    /* renamed from: l, reason: collision with root package name */
    private b f1277l;

    /* renamed from: e, reason: collision with root package name */
    private int f1270e = 255;

    /* renamed from: g, reason: collision with root package name */
    private int f1272g = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public static boolean a(Drawable.ConstantState constantState) {
            return constantState.canApplyTheme();
        }

        public static void b(Drawable drawable, Outline outline) {
            drawable.getOutline(outline);
        }

        public static Resources c(Resources.Theme theme) {
            return theme.getResources();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b implements Drawable.Callback {

        /* renamed from: a, reason: collision with root package name */
        private Drawable.Callback f1278a;

        b() {
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f1278a;
            this.f1278a = null;
            return callback;
        }

        public b b(Drawable.Callback callback) {
            this.f1278a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
            Drawable.Callback callback = this.f1278a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j11);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f1278a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class c extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a, reason: collision with root package name */
        final DrawableContainerCompat f1279a;

        /* renamed from: b, reason: collision with root package name */
        Resources f1280b;

        /* renamed from: c, reason: collision with root package name */
        int f1281c;

        /* renamed from: d, reason: collision with root package name */
        int f1282d;

        /* renamed from: e, reason: collision with root package name */
        int f1283e;

        /* renamed from: f, reason: collision with root package name */
        SparseArray f1284f;

        /* renamed from: g, reason: collision with root package name */
        Drawable[] f1285g;

        /* renamed from: h, reason: collision with root package name */
        int f1286h;

        /* renamed from: i, reason: collision with root package name */
        boolean f1287i;

        /* renamed from: j, reason: collision with root package name */
        boolean f1288j;

        /* renamed from: k, reason: collision with root package name */
        Rect f1289k;

        /* renamed from: l, reason: collision with root package name */
        boolean f1290l;

        /* renamed from: m, reason: collision with root package name */
        boolean f1291m;

        /* renamed from: n, reason: collision with root package name */
        int f1292n;

        /* renamed from: o, reason: collision with root package name */
        int f1293o;

        /* renamed from: p, reason: collision with root package name */
        int f1294p;

        /* renamed from: q, reason: collision with root package name */
        int f1295q;

        /* renamed from: r, reason: collision with root package name */
        boolean f1296r;

        /* renamed from: s, reason: collision with root package name */
        int f1297s;

        /* renamed from: t, reason: collision with root package name */
        boolean f1298t;

        /* renamed from: u, reason: collision with root package name */
        boolean f1299u;

        /* renamed from: v, reason: collision with root package name */
        boolean f1300v;

        /* renamed from: w, reason: collision with root package name */
        boolean f1301w;

        /* renamed from: x, reason: collision with root package name */
        boolean f1302x;

        /* renamed from: y, reason: collision with root package name */
        boolean f1303y;

        /* renamed from: z, reason: collision with root package name */
        int f1304z;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(c cVar, DrawableContainerCompat drawableContainerCompat, Resources resources) {
            this.f1287i = false;
            this.f1290l = false;
            this.f1302x = true;
            this.A = 0;
            this.B = 0;
            this.f1279a = drawableContainerCompat;
            this.f1280b = resources != null ? resources : cVar != null ? cVar.f1280b : null;
            int f11 = DrawableContainerCompat.f(resources, cVar != null ? cVar.f1281c : 0);
            this.f1281c = f11;
            if (cVar == null) {
                this.f1285g = new Drawable[10];
                this.f1286h = 0;
                return;
            }
            this.f1282d = cVar.f1282d;
            this.f1283e = cVar.f1283e;
            this.f1300v = true;
            this.f1301w = true;
            this.f1287i = cVar.f1287i;
            this.f1290l = cVar.f1290l;
            this.f1302x = cVar.f1302x;
            this.f1303y = cVar.f1303y;
            this.f1304z = cVar.f1304z;
            this.A = cVar.A;
            this.B = cVar.B;
            this.C = cVar.C;
            this.D = cVar.D;
            this.E = cVar.E;
            this.F = cVar.F;
            this.G = cVar.G;
            this.H = cVar.H;
            this.I = cVar.I;
            if (cVar.f1281c == f11) {
                if (cVar.f1288j) {
                    this.f1289k = cVar.f1289k != null ? new Rect(cVar.f1289k) : null;
                    this.f1288j = true;
                }
                if (cVar.f1291m) {
                    this.f1292n = cVar.f1292n;
                    this.f1293o = cVar.f1293o;
                    this.f1294p = cVar.f1294p;
                    this.f1295q = cVar.f1295q;
                    this.f1291m = true;
                }
            }
            if (cVar.f1296r) {
                this.f1297s = cVar.f1297s;
                this.f1296r = true;
            }
            if (cVar.f1298t) {
                this.f1299u = cVar.f1299u;
                this.f1298t = true;
            }
            Drawable[] drawableArr = cVar.f1285g;
            this.f1285g = new Drawable[drawableArr.length];
            this.f1286h = cVar.f1286h;
            SparseArray sparseArray = cVar.f1284f;
            if (sparseArray != null) {
                this.f1284f = sparseArray.clone();
            } else {
                this.f1284f = new SparseArray(this.f1286h);
            }
            int i11 = this.f1286h;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable != null) {
                    Drawable.ConstantState constantState = drawable.getConstantState();
                    if (constantState != null) {
                        this.f1284f.put(i12, constantState);
                    } else {
                        this.f1285g[i12] = drawableArr[i12];
                    }
                }
            }
        }

        private void e() {
            SparseArray sparseArray = this.f1284f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i11 = 0; i11 < size; i11++) {
                    this.f1285g[this.f1284f.keyAt(i11)] = t(((Drawable.ConstantState) this.f1284f.valueAt(i11)).newDrawable(this.f1280b));
                }
                this.f1284f = null;
            }
        }

        private Drawable t(Drawable drawable) {
            a1.a.m(drawable, this.f1304z);
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f1279a);
            return mutate;
        }

        public final int a(Drawable drawable) {
            int i11 = this.f1286h;
            if (i11 >= this.f1285g.length) {
                o(i11, i11 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1279a);
            this.f1285g[i11] = drawable;
            this.f1286h++;
            this.f1283e = drawable.getChangingConfigurations() | this.f1283e;
            p();
            this.f1289k = null;
            this.f1288j = false;
            this.f1291m = false;
            this.f1300v = false;
            return i11;
        }

        final void b(Resources.Theme theme) {
            if (theme != null) {
                e();
                int i11 = this.f1286h;
                Drawable[] drawableArr = this.f1285g;
                for (int i12 = 0; i12 < i11; i12++) {
                    Drawable drawable = drawableArr[i12];
                    if (drawable != null && a1.a.b(drawable)) {
                        a1.a.a(drawableArr[i12], theme);
                        this.f1283e |= drawableArr[i12].getChangingConfigurations();
                    }
                }
                z(a.c(theme));
            }
        }

        public boolean c() {
            if (this.f1300v) {
                return this.f1301w;
            }
            e();
            this.f1300v = true;
            int i11 = this.f1286h;
            Drawable[] drawableArr = this.f1285g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getConstantState() == null) {
                    this.f1301w = false;
                    return false;
                }
            }
            this.f1301w = true;
            return true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i11 = this.f1286h;
            Drawable[] drawableArr = this.f1285g;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                if (drawable == null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) this.f1284f.get(i12);
                    if (constantState != null && a.a(constantState)) {
                        return true;
                    }
                } else if (a1.a.b(drawable)) {
                    return true;
                }
            }
            return false;
        }

        protected void d() {
            this.f1291m = true;
            e();
            int i11 = this.f1286h;
            Drawable[] drawableArr = this.f1285g;
            this.f1293o = -1;
            this.f1292n = -1;
            this.f1295q = 0;
            this.f1294p = 0;
            for (int i12 = 0; i12 < i11; i12++) {
                Drawable drawable = drawableArr[i12];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f1292n) {
                    this.f1292n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f1293o) {
                    this.f1293o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f1294p) {
                    this.f1294p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f1295q) {
                    this.f1295q = minimumHeight;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final int f() {
            return this.f1285g.length;
        }

        public final Drawable g(int i11) {
            int indexOfKey;
            Drawable drawable = this.f1285g[i11];
            if (drawable != null) {
                return drawable;
            }
            SparseArray sparseArray = this.f1284f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i11)) < 0) {
                return null;
            }
            Drawable t11 = t(((Drawable.ConstantState) this.f1284f.valueAt(indexOfKey)).newDrawable(this.f1280b));
            this.f1285g[i11] = t11;
            this.f1284f.removeAt(indexOfKey);
            if (this.f1284f.size() == 0) {
                this.f1284f = null;
            }
            return t11;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1282d | this.f1283e;
        }

        public final int h() {
            return this.f1286h;
        }

        public final int i() {
            if (!this.f1291m) {
                d();
            }
            return this.f1293o;
        }

        public final int j() {
            if (!this.f1291m) {
                d();
            }
            return this.f1295q;
        }

        public final int k() {
            if (!this.f1291m) {
                d();
            }
            return this.f1294p;
        }

        public final Rect l() {
            Rect rect = null;
            if (this.f1287i) {
                return null;
            }
            Rect rect2 = this.f1289k;
            if (rect2 != null || this.f1288j) {
                return rect2;
            }
            e();
            Rect rect3 = new Rect();
            int i11 = this.f1286h;
            Drawable[] drawableArr = this.f1285g;
            for (int i12 = 0; i12 < i11; i12++) {
                if (drawableArr[i12].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i13 = rect3.left;
                    if (i13 > rect.left) {
                        rect.left = i13;
                    }
                    int i14 = rect3.top;
                    if (i14 > rect.top) {
                        rect.top = i14;
                    }
                    int i15 = rect3.right;
                    if (i15 > rect.right) {
                        rect.right = i15;
                    }
                    int i16 = rect3.bottom;
                    if (i16 > rect.bottom) {
                        rect.bottom = i16;
                    }
                }
            }
            this.f1288j = true;
            this.f1289k = rect;
            return rect;
        }

        public final int m() {
            if (!this.f1291m) {
                d();
            }
            return this.f1292n;
        }

        public final int n() {
            if (this.f1296r) {
                return this.f1297s;
            }
            e();
            int i11 = this.f1286h;
            Drawable[] drawableArr = this.f1285g;
            int opacity = i11 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i12 = 1; i12 < i11; i12++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i12].getOpacity());
            }
            this.f1297s = opacity;
            this.f1296r = true;
            return opacity;
        }

        public void o(int i11, int i12) {
            Drawable[] drawableArr = new Drawable[i12];
            Drawable[] drawableArr2 = this.f1285g;
            if (drawableArr2 != null) {
                System.arraycopy(drawableArr2, 0, drawableArr, 0, i11);
            }
            this.f1285g = drawableArr;
        }

        void p() {
            this.f1296r = false;
            this.f1298t = false;
        }

        public final boolean q() {
            return this.f1290l;
        }

        public final boolean r() {
            if (this.f1298t) {
                return this.f1299u;
            }
            e();
            int i11 = this.f1286h;
            Drawable[] drawableArr = this.f1285g;
            boolean z10 = false;
            int i12 = 0;
            while (true) {
                if (i12 >= i11) {
                    break;
                }
                if (drawableArr[i12].isStateful()) {
                    z10 = true;
                    break;
                }
                i12++;
            }
            this.f1299u = z10;
            this.f1298t = true;
            return z10;
        }

        abstract void s();

        public final void u(boolean z10) {
            this.f1290l = z10;
        }

        public final void v(int i11) {
            this.A = i11;
        }

        public final void w(int i11) {
            this.B = i11;
        }

        final boolean x(int i11, int i12) {
            int i13 = this.f1286h;
            Drawable[] drawableArr = this.f1285g;
            boolean z10 = false;
            for (int i14 = 0; i14 < i13; i14++) {
                Drawable drawable = drawableArr[i14];
                if (drawable != null) {
                    boolean m11 = a1.a.m(drawable, i11);
                    if (i14 == i12) {
                        z10 = m11;
                    }
                }
            }
            this.f1304z = i11;
            return z10;
        }

        public final void y(boolean z10) {
            this.f1287i = z10;
        }

        final void z(Resources resources) {
            if (resources != null) {
                this.f1280b = resources;
                int f11 = DrawableContainerCompat.f(resources, this.f1281c);
                int i11 = this.f1281c;
                this.f1281c = f11;
                if (i11 != f11) {
                    this.f1291m = false;
                    this.f1288j = false;
                }
            }
        }
    }

    private void d(Drawable drawable) {
        if (this.f1277l == null) {
            this.f1277l = new b();
        }
        drawable.setCallback(this.f1277l.b(drawable.getCallback()));
        try {
            if (this.f1266a.A <= 0 && this.f1271f) {
                drawable.setAlpha(this.f1270e);
            }
            c cVar = this.f1266a;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    a1.a.o(drawable, cVar.F);
                }
                c cVar2 = this.f1266a;
                if (cVar2.I) {
                    a1.a.p(drawable, cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1266a.f1302x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            a1.a.m(drawable, a1.a.f(this));
            a1.a.j(drawable, this.f1266a.C);
            Rect rect = this.f1267b;
            if (rect != null) {
                a1.a.l(drawable, rect.left, rect.top, rect.right, rect.bottom);
            }
            drawable.setCallback(this.f1277l.a());
        } catch (Throwable th2) {
            drawable.setCallback(this.f1277l.a());
            throw th2;
        }
    }

    private boolean e() {
        return isAutoMirrored() && a1.a.f(this) == 1;
    }

    static int f(Resources resources, int i11) {
        if (resources != null) {
            i11 = resources.getDisplayMetrics().densityDpi;
        }
        if (i11 == 0) {
            return 160;
        }
        return i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0061  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1271f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1268c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r8 = 0
            if (r3 == 0) goto L36
            long r9 = r13.f1275j
            int r11 = (r9 > r6 ? 1 : (r9 == r6 ? 0 : -1))
            if (r11 == 0) goto L38
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f1270e
            r3.setAlpha(r9)
            r13.f1275j = r6
            goto L38
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r9 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$c r10 = r13.f1266a
            int r10 = r10.A
            int r9 = r9 / r10
            int r9 = 255 - r9
            int r10 = r13.f1270e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = r0
            goto L39
        L36:
            r13.f1275j = r6
        L38:
            r3 = r8
        L39:
            android.graphics.drawable.Drawable r9 = r13.f1269d
            if (r9 == 0) goto L61
            long r10 = r13.f1276k
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 == 0) goto L63
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L50
            r9.setVisible(r8, r8)
            r0 = 0
            r13.f1269d = r0
            r13.f1276k = r6
            goto L63
        L50:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$c r4 = r13.f1266a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f1270e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L64
        L61:
            r13.f1276k = r6
        L63:
            r0 = r3
        L64:
            if (r14 == 0) goto L70
            if (r0 == 0) goto L70
            java.lang.Runnable r14 = r13.f1274i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L70:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f1266a.b(theme);
    }

    c b() {
        return this.f1266a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f1272g;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f1266a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1269d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean g(int r10) {
        /*
            r9 = this;
            int r0 = r9.f1272g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$c r0 = r9.f1266a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f1269d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f1268c
            if (r0 == 0) goto L29
            r9.f1269d = r0
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$c r0 = r9.f1266a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f1276k = r0
            goto L35
        L29:
            r9.f1269d = r4
            r9.f1276k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f1268c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$c r0 = r9.f1266a
            int r1 = r0.f1286h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.g(r10)
            r9.f1268c = r0
            r9.f1272g = r10
            if (r0 == 0) goto L5a
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$c r10 = r9.f1266a
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f1275j = r2
        L51:
            r9.d(r0)
            goto L5a
        L55:
            r9.f1268c = r4
            r10 = -1
            r9.f1272g = r10
        L5a:
            long r0 = r9.f1275j
            int r10 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            r0 = 1
            if (r10 != 0) goto L67
            long r1 = r9.f1276k
            int r10 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r10 == 0) goto L79
        L67:
            java.lang.Runnable r10 = r9.f1274i
            if (r10 != 0) goto L73
            androidx.appcompat.graphics.drawable.DrawableContainerCompat$1 r10 = new androidx.appcompat.graphics.drawable.DrawableContainerCompat$1
            r10.<init>()
            r9.f1274i = r10
            goto L76
        L73:
            r9.unscheduleSelf(r10)
        L76:
            r9.a(r0)
        L79:
            r9.invalidateSelf()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainerCompat.g(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1270e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1266a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f1266a.c()) {
            return null;
        }
        this.f1266a.f1282d = getChangingConfigurations();
        return this.f1266a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1268c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f1267b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1266a.q()) {
            return this.f1266a.i();
        }
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1266a.q()) {
            return this.f1266a.m();
        }
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f1266a.q()) {
            return this.f1266a.j();
        }
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f1266a.q()) {
            return this.f1266a.k();
        }
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1268c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f1266a.n();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            a.b(drawable, outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect l11 = this.f1266a.l();
        if (l11 != null) {
            rect.set(l11);
            padding = (l11.right | ((l11.left | l11.top) | l11.bottom)) != 0;
        } else {
            Drawable drawable = this.f1268c;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (e()) {
            int i11 = rect.left;
            rect.left = rect.right;
            rect.right = i11;
        }
        return padding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(c cVar) {
        this.f1266a = cVar;
        int i11 = this.f1272g;
        if (i11 >= 0) {
            Drawable g11 = cVar.g(i11);
            this.f1268c = g11;
            if (g11 != null) {
                d(g11);
            }
        }
        this.f1269d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(Resources resources) {
        this.f1266a.z(resources);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f1266a;
        if (cVar != null) {
            cVar.p();
        }
        if (drawable != this.f1268c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1266a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f1266a.r();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z10;
        Drawable drawable = this.f1269d;
        boolean z11 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1269d = null;
            z10 = true;
        } else {
            z10 = false;
        }
        Drawable drawable2 = this.f1268c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1271f) {
                this.f1268c.setAlpha(this.f1270e);
            }
        }
        if (this.f1276k != 0) {
            this.f1276k = 0L;
            z10 = true;
        }
        if (this.f1275j != 0) {
            this.f1275j = 0L;
        } else {
            z11 = z10;
        }
        if (z11) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1273h && super.mutate() == this) {
            c b11 = b();
            b11.s();
            h(b11);
            this.f1273h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1269d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1268c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i11) {
        return this.f1266a.x(i11, c());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i11) {
        Drawable drawable = this.f1269d;
        if (drawable != null) {
            return drawable.setLevel(i11);
        }
        Drawable drawable2 = this.f1268c;
        if (drawable2 != null) {
            return drawable2.setLevel(i11);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1269d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1268c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j11) {
        if (drawable != this.f1268c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j11);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        if (this.f1271f && this.f1270e == i11) {
            return;
        }
        this.f1271f = true;
        this.f1270e = i11;
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            if (this.f1275j == 0) {
                drawable.setAlpha(i11);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        c cVar = this.f1266a;
        if (cVar.C != z10) {
            cVar.C = z10;
            Drawable drawable = this.f1268c;
            if (drawable != null) {
                a1.a.j(drawable, z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f1266a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f1268c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z10) {
        c cVar = this.f1266a;
        if (cVar.f1302x != z10) {
            cVar.f1302x = z10;
            Drawable drawable = this.f1268c;
            if (drawable != null) {
                drawable.setDither(z10);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f11, float f12) {
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            a1.a.k(drawable, f11, f12);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i11, int i12, int i13, int i14) {
        Rect rect = this.f1267b;
        if (rect == null) {
            this.f1267b = new Rect(i11, i12, i13, i14);
        } else {
            rect.set(i11, i12, i13, i14);
        }
        Drawable drawable = this.f1268c;
        if (drawable != null) {
            a1.a.l(drawable, i11, i12, i13, i14);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        setTintList(ColorStateList.valueOf(i11));
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f1266a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            a1.a.o(this.f1268c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f1266a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            a1.a.p(this.f1268c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        boolean visible = super.setVisible(z10, z11);
        Drawable drawable = this.f1269d;
        if (drawable != null) {
            drawable.setVisible(z10, z11);
        }
        Drawable drawable2 = this.f1268c;
        if (drawable2 != null) {
            drawable2.setVisible(z10, z11);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f1268c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
