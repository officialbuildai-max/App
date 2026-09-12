package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import y0.k;
import z0.e;

/* loaded from: classes2.dex */
public class h extends androidx.vectordrawable.graphics.drawable.g {

    /* renamed from: k, reason: collision with root package name */
    static final PorterDuff.Mode f15233k = PorterDuff.Mode.SRC_IN;

    /* renamed from: b, reason: collision with root package name */
    private C0137h f15234b;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuffColorFilter f15235c;

    /* renamed from: d, reason: collision with root package name */
    private ColorFilter f15236d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f15237e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f15238f;

    /* renamed from: g, reason: collision with root package name */
    private Drawable.ConstantState f15239g;

    /* renamed from: h, reason: collision with root package name */
    private final float[] f15240h;

    /* renamed from: i, reason: collision with root package name */
    private final Matrix f15241i;

    /* renamed from: j, reason: collision with root package name */
    private final Rect f15242j;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b extends f {
        b() {
        }

        b(b bVar) {
            super(bVar);
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f15269b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f15268a = z0.e.d(string2);
            }
            this.f15270c = k.g(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (k.j(xmlPullParser, "pathData")) {
                TypedArray k11 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f15205d);
                f(k11, xmlPullParser);
                k11.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c extends f {

        /* renamed from: e, reason: collision with root package name */
        private int[] f15243e;

        /* renamed from: f, reason: collision with root package name */
        y0.d f15244f;

        /* renamed from: g, reason: collision with root package name */
        float f15245g;

        /* renamed from: h, reason: collision with root package name */
        y0.d f15246h;

        /* renamed from: i, reason: collision with root package name */
        float f15247i;

        /* renamed from: j, reason: collision with root package name */
        float f15248j;

        /* renamed from: k, reason: collision with root package name */
        float f15249k;

        /* renamed from: l, reason: collision with root package name */
        float f15250l;

        /* renamed from: m, reason: collision with root package name */
        float f15251m;

        /* renamed from: n, reason: collision with root package name */
        Paint.Cap f15252n;

        /* renamed from: o, reason: collision with root package name */
        Paint.Join f15253o;

        /* renamed from: p, reason: collision with root package name */
        float f15254p;

        c() {
            this.f15245g = 0.0f;
            this.f15247i = 1.0f;
            this.f15248j = 1.0f;
            this.f15249k = 0.0f;
            this.f15250l = 1.0f;
            this.f15251m = 0.0f;
            this.f15252n = Paint.Cap.BUTT;
            this.f15253o = Paint.Join.MITER;
            this.f15254p = 4.0f;
        }

        c(c cVar) {
            super(cVar);
            this.f15245g = 0.0f;
            this.f15247i = 1.0f;
            this.f15248j = 1.0f;
            this.f15249k = 0.0f;
            this.f15250l = 1.0f;
            this.f15251m = 0.0f;
            this.f15252n = Paint.Cap.BUTT;
            this.f15253o = Paint.Join.MITER;
            this.f15254p = 4.0f;
            this.f15243e = cVar.f15243e;
            this.f15244f = cVar.f15244f;
            this.f15245g = cVar.f15245g;
            this.f15247i = cVar.f15247i;
            this.f15246h = cVar.f15246h;
            this.f15270c = cVar.f15270c;
            this.f15248j = cVar.f15248j;
            this.f15249k = cVar.f15249k;
            this.f15250l = cVar.f15250l;
            this.f15251m = cVar.f15251m;
            this.f15252n = cVar.f15252n;
            this.f15253o = cVar.f15253o;
            this.f15254p = cVar.f15254p;
        }

        private Paint.Cap e(int i11, Paint.Cap cap) {
            return i11 != 0 ? i11 != 1 ? i11 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join f(int i11, Paint.Join join) {
            return i11 != 0 ? i11 != 1 ? i11 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f15243e = null;
            if (k.j(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f15269b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f15268a = z0.e.d(string2);
                }
                this.f15246h = k.e(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f15248j = k.f(typedArray, xmlPullParser, "fillAlpha", 12, this.f15248j);
                this.f15252n = e(k.g(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f15252n);
                this.f15253o = f(k.g(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f15253o);
                this.f15254p = k.f(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f15254p);
                this.f15244f = k.e(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f15247i = k.f(typedArray, xmlPullParser, "strokeAlpha", 11, this.f15247i);
                this.f15245g = k.f(typedArray, xmlPullParser, "strokeWidth", 4, this.f15245g);
                this.f15250l = k.f(typedArray, xmlPullParser, "trimPathEnd", 6, this.f15250l);
                this.f15251m = k.f(typedArray, xmlPullParser, "trimPathOffset", 7, this.f15251m);
                this.f15249k = k.f(typedArray, xmlPullParser, "trimPathStart", 5, this.f15249k);
                this.f15270c = k.g(typedArray, xmlPullParser, "fillType", 13, this.f15270c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean a() {
            return this.f15246h.i() || this.f15244f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean b(int[] iArr) {
            return this.f15244f.j(iArr) | this.f15246h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k11 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f15204c);
            h(k11, xmlPullParser, theme);
            k11.recycle();
        }

        float getFillAlpha() {
            return this.f15248j;
        }

        int getFillColor() {
            return this.f15246h.e();
        }

        float getStrokeAlpha() {
            return this.f15247i;
        }

        int getStrokeColor() {
            return this.f15244f.e();
        }

        float getStrokeWidth() {
            return this.f15245g;
        }

        float getTrimPathEnd() {
            return this.f15250l;
        }

        float getTrimPathOffset() {
            return this.f15251m;
        }

        float getTrimPathStart() {
            return this.f15249k;
        }

        void setFillAlpha(float f11) {
            this.f15248j = f11;
        }

        void setFillColor(int i11) {
            this.f15246h.k(i11);
        }

        void setStrokeAlpha(float f11) {
            this.f15247i = f11;
        }

        void setStrokeColor(int i11) {
            this.f15244f.k(i11);
        }

        void setStrokeWidth(float f11) {
            this.f15245g = f11;
        }

        void setTrimPathEnd(float f11) {
            this.f15250l = f11;
        }

        void setTrimPathOffset(float f11) {
            this.f15251m = f11;
        }

        void setTrimPathStart(float f11) {
            this.f15249k = f11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d extends e {

        /* renamed from: a, reason: collision with root package name */
        final Matrix f15255a;

        /* renamed from: b, reason: collision with root package name */
        final ArrayList f15256b;

        /* renamed from: c, reason: collision with root package name */
        float f15257c;

        /* renamed from: d, reason: collision with root package name */
        private float f15258d;

        /* renamed from: e, reason: collision with root package name */
        private float f15259e;

        /* renamed from: f, reason: collision with root package name */
        private float f15260f;

        /* renamed from: g, reason: collision with root package name */
        private float f15261g;

        /* renamed from: h, reason: collision with root package name */
        private float f15262h;

        /* renamed from: i, reason: collision with root package name */
        private float f15263i;

        /* renamed from: j, reason: collision with root package name */
        final Matrix f15264j;

        /* renamed from: k, reason: collision with root package name */
        int f15265k;

        /* renamed from: l, reason: collision with root package name */
        private int[] f15266l;

        /* renamed from: m, reason: collision with root package name */
        private String f15267m;

        public d() {
            super();
            this.f15255a = new Matrix();
            this.f15256b = new ArrayList();
            this.f15257c = 0.0f;
            this.f15258d = 0.0f;
            this.f15259e = 0.0f;
            this.f15260f = 1.0f;
            this.f15261g = 1.0f;
            this.f15262h = 0.0f;
            this.f15263i = 0.0f;
            this.f15264j = new Matrix();
            this.f15267m = null;
        }

        public d(d dVar, androidx.collection.a aVar) {
            super();
            f bVar;
            this.f15255a = new Matrix();
            this.f15256b = new ArrayList();
            this.f15257c = 0.0f;
            this.f15258d = 0.0f;
            this.f15259e = 0.0f;
            this.f15260f = 1.0f;
            this.f15261g = 1.0f;
            this.f15262h = 0.0f;
            this.f15263i = 0.0f;
            Matrix matrix = new Matrix();
            this.f15264j = matrix;
            this.f15267m = null;
            this.f15257c = dVar.f15257c;
            this.f15258d = dVar.f15258d;
            this.f15259e = dVar.f15259e;
            this.f15260f = dVar.f15260f;
            this.f15261g = dVar.f15261g;
            this.f15262h = dVar.f15262h;
            this.f15263i = dVar.f15263i;
            this.f15266l = dVar.f15266l;
            String str = dVar.f15267m;
            this.f15267m = str;
            this.f15265k = dVar.f15265k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f15264j);
            ArrayList arrayList = dVar.f15256b;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                Object obj = arrayList.get(i11);
                if (obj instanceof d) {
                    this.f15256b.add(new d((d) obj, aVar));
                } else {
                    if (obj instanceof c) {
                        bVar = new c((c) obj);
                    } else {
                        if (!(obj instanceof b)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        bVar = new b((b) obj);
                    }
                    this.f15256b.add(bVar);
                    Object obj2 = bVar.f15269b;
                    if (obj2 != null) {
                        aVar.put(obj2, bVar);
                    }
                }
            }
        }

        private void d() {
            this.f15264j.reset();
            this.f15264j.postTranslate(-this.f15258d, -this.f15259e);
            this.f15264j.postScale(this.f15260f, this.f15261g);
            this.f15264j.postRotate(this.f15257c, 0.0f, 0.0f);
            this.f15264j.postTranslate(this.f15262h + this.f15258d, this.f15263i + this.f15259e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f15266l = null;
            this.f15257c = k.f(typedArray, xmlPullParser, "rotation", 5, this.f15257c);
            this.f15258d = typedArray.getFloat(1, this.f15258d);
            this.f15259e = typedArray.getFloat(2, this.f15259e);
            this.f15260f = k.f(typedArray, xmlPullParser, "scaleX", 3, this.f15260f);
            this.f15261g = k.f(typedArray, xmlPullParser, "scaleY", 4, this.f15261g);
            this.f15262h = k.f(typedArray, xmlPullParser, "translateX", 6, this.f15262h);
            this.f15263i = k.f(typedArray, xmlPullParser, "translateY", 7, this.f15263i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f15267m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean a() {
            for (int i11 = 0; i11 < this.f15256b.size(); i11++) {
                if (((e) this.f15256b.get(i11)).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.h.e
        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i11 = 0; i11 < this.f15256b.size(); i11++) {
                z10 |= ((e) this.f15256b.get(i11)).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray k11 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f15203b);
            e(k11, xmlPullParser);
            k11.recycle();
        }

        public String getGroupName() {
            return this.f15267m;
        }

        public Matrix getLocalMatrix() {
            return this.f15264j;
        }

        public float getPivotX() {
            return this.f15258d;
        }

        public float getPivotY() {
            return this.f15259e;
        }

        public float getRotation() {
            return this.f15257c;
        }

        public float getScaleX() {
            return this.f15260f;
        }

        public float getScaleY() {
            return this.f15261g;
        }

        public float getTranslateX() {
            return this.f15262h;
        }

        public float getTranslateY() {
            return this.f15263i;
        }

        public void setPivotX(float f11) {
            if (f11 != this.f15258d) {
                this.f15258d = f11;
                d();
            }
        }

        public void setPivotY(float f11) {
            if (f11 != this.f15259e) {
                this.f15259e = f11;
                d();
            }
        }

        public void setRotation(float f11) {
            if (f11 != this.f15257c) {
                this.f15257c = f11;
                d();
            }
        }

        public void setScaleX(float f11) {
            if (f11 != this.f15260f) {
                this.f15260f = f11;
                d();
            }
        }

        public void setScaleY(float f11) {
            if (f11 != this.f15261g) {
                this.f15261g = f11;
                d();
            }
        }

        public void setTranslateX(float f11) {
            if (f11 != this.f15262h) {
                this.f15262h = f11;
                d();
            }
        }

        public void setTranslateY(float f11) {
            if (f11 != this.f15263i) {
                this.f15263i = f11;
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static abstract class f extends e {

        /* renamed from: a, reason: collision with root package name */
        protected e.b[] f15268a;

        /* renamed from: b, reason: collision with root package name */
        String f15269b;

        /* renamed from: c, reason: collision with root package name */
        int f15270c;

        /* renamed from: d, reason: collision with root package name */
        int f15271d;

        public f() {
            super();
            this.f15268a = null;
            this.f15270c = 0;
        }

        public f(f fVar) {
            super();
            this.f15268a = null;
            this.f15270c = 0;
            this.f15269b = fVar.f15269b;
            this.f15271d = fVar.f15271d;
            this.f15268a = z0.e.f(fVar.f15268a);
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            e.b[] bVarArr = this.f15268a;
            if (bVarArr != null) {
                e.b.i(bVarArr, path);
            }
        }

        public e.b[] getPathData() {
            return this.f15268a;
        }

        public String getPathName() {
            return this.f15269b;
        }

        public void setPathData(e.b[] bVarArr) {
            if (z0.e.b(this.f15268a, bVarArr)) {
                z0.e.k(this.f15268a, bVarArr);
            } else {
                this.f15268a = z0.e.f(bVarArr);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: q, reason: collision with root package name */
        private static final Matrix f15272q = new Matrix();

        /* renamed from: a, reason: collision with root package name */
        private final Path f15273a;

        /* renamed from: b, reason: collision with root package name */
        private final Path f15274b;

        /* renamed from: c, reason: collision with root package name */
        private final Matrix f15275c;

        /* renamed from: d, reason: collision with root package name */
        Paint f15276d;

        /* renamed from: e, reason: collision with root package name */
        Paint f15277e;

        /* renamed from: f, reason: collision with root package name */
        private PathMeasure f15278f;

        /* renamed from: g, reason: collision with root package name */
        private int f15279g;

        /* renamed from: h, reason: collision with root package name */
        final d f15280h;

        /* renamed from: i, reason: collision with root package name */
        float f15281i;

        /* renamed from: j, reason: collision with root package name */
        float f15282j;

        /* renamed from: k, reason: collision with root package name */
        float f15283k;

        /* renamed from: l, reason: collision with root package name */
        float f15284l;

        /* renamed from: m, reason: collision with root package name */
        int f15285m;

        /* renamed from: n, reason: collision with root package name */
        String f15286n;

        /* renamed from: o, reason: collision with root package name */
        Boolean f15287o;

        /* renamed from: p, reason: collision with root package name */
        final androidx.collection.a f15288p;

        public g() {
            this.f15275c = new Matrix();
            this.f15281i = 0.0f;
            this.f15282j = 0.0f;
            this.f15283k = 0.0f;
            this.f15284l = 0.0f;
            this.f15285m = 255;
            this.f15286n = null;
            this.f15287o = null;
            this.f15288p = new androidx.collection.a();
            this.f15280h = new d();
            this.f15273a = new Path();
            this.f15274b = new Path();
        }

        public g(g gVar) {
            this.f15275c = new Matrix();
            this.f15281i = 0.0f;
            this.f15282j = 0.0f;
            this.f15283k = 0.0f;
            this.f15284l = 0.0f;
            this.f15285m = 255;
            this.f15286n = null;
            this.f15287o = null;
            androidx.collection.a aVar = new androidx.collection.a();
            this.f15288p = aVar;
            this.f15280h = new d(gVar.f15280h, aVar);
            this.f15273a = new Path(gVar.f15273a);
            this.f15274b = new Path(gVar.f15274b);
            this.f15281i = gVar.f15281i;
            this.f15282j = gVar.f15282j;
            this.f15283k = gVar.f15283k;
            this.f15284l = gVar.f15284l;
            this.f15279g = gVar.f15279g;
            this.f15285m = gVar.f15285m;
            this.f15286n = gVar.f15286n;
            String str = gVar.f15286n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f15287o = gVar.f15287o;
        }

        private static float a(float f11, float f12, float f13, float f14) {
            return (f11 * f14) - (f12 * f13);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            dVar.f15255a.set(matrix);
            dVar.f15255a.preConcat(dVar.f15264j);
            canvas.save();
            for (int i13 = 0; i13 < dVar.f15256b.size(); i13++) {
                e eVar = (e) dVar.f15256b.get(i13);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f15255a, canvas, i11, i12, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i11, i12, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            float f11 = i11 / this.f15283k;
            float f12 = i12 / this.f15284l;
            float min = Math.min(f11, f12);
            Matrix matrix = dVar.f15255a;
            this.f15275c.set(matrix);
            this.f15275c.postScale(f11, f12);
            float e11 = e(matrix);
            if (e11 == 0.0f) {
                return;
            }
            fVar.d(this.f15273a);
            Path path = this.f15273a;
            this.f15274b.reset();
            if (fVar.c()) {
                this.f15274b.setFillType(fVar.f15270c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f15274b.addPath(path, this.f15275c);
                canvas.clipPath(this.f15274b);
                return;
            }
            c cVar = (c) fVar;
            float f13 = cVar.f15249k;
            if (f13 != 0.0f || cVar.f15250l != 1.0f) {
                float f14 = cVar.f15251m;
                float f15 = (f13 + f14) % 1.0f;
                float f16 = (cVar.f15250l + f14) % 1.0f;
                if (this.f15278f == null) {
                    this.f15278f = new PathMeasure();
                }
                this.f15278f.setPath(this.f15273a, false);
                float length = this.f15278f.getLength();
                float f17 = f15 * length;
                float f18 = f16 * length;
                path.reset();
                if (f17 > f18) {
                    this.f15278f.getSegment(f17, length, path, true);
                    this.f15278f.getSegment(0.0f, f18, path, true);
                } else {
                    this.f15278f.getSegment(f17, f18, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f15274b.addPath(path, this.f15275c);
            if (cVar.f15246h.l()) {
                y0.d dVar2 = cVar.f15246h;
                if (this.f15277e == null) {
                    Paint paint = new Paint(1);
                    this.f15277e = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f15277e;
                if (dVar2.h()) {
                    Shader f19 = dVar2.f();
                    f19.setLocalMatrix(this.f15275c);
                    paint2.setShader(f19);
                    paint2.setAlpha(Math.round(cVar.f15248j * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(h.a(dVar2.e(), cVar.f15248j));
                }
                paint2.setColorFilter(colorFilter);
                this.f15274b.setFillType(cVar.f15270c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f15274b, paint2);
            }
            if (cVar.f15244f.l()) {
                y0.d dVar3 = cVar.f15244f;
                if (this.f15276d == null) {
                    Paint paint3 = new Paint(1);
                    this.f15276d = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f15276d;
                Paint.Join join = cVar.f15253o;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.f15252n;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(cVar.f15254p);
                if (dVar3.h()) {
                    Shader f20 = dVar3.f();
                    f20.setLocalMatrix(this.f15275c);
                    paint4.setShader(f20);
                    paint4.setAlpha(Math.round(cVar.f15247i * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(h.a(dVar3.e(), cVar.f15247i));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(cVar.f15245g * min * e11);
                canvas.drawPath(this.f15274b, paint4);
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a11 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a11) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            c(this.f15280h, f15272q, canvas, i11, i12, colorFilter);
        }

        public boolean f() {
            if (this.f15287o == null) {
                this.f15287o = Boolean.valueOf(this.f15280h.a());
            }
            return this.f15287o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f15280h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f15285m;
        }

        public void setAlpha(float f11) {
            setRootAlpha((int) (f11 * 255.0f));
        }

        public void setRootAlpha(int i11) {
            this.f15285m = i11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: androidx.vectordrawable.graphics.drawable.h$h, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0137h extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        int f15289a;

        /* renamed from: b, reason: collision with root package name */
        g f15290b;

        /* renamed from: c, reason: collision with root package name */
        ColorStateList f15291c;

        /* renamed from: d, reason: collision with root package name */
        PorterDuff.Mode f15292d;

        /* renamed from: e, reason: collision with root package name */
        boolean f15293e;

        /* renamed from: f, reason: collision with root package name */
        Bitmap f15294f;

        /* renamed from: g, reason: collision with root package name */
        ColorStateList f15295g;

        /* renamed from: h, reason: collision with root package name */
        PorterDuff.Mode f15296h;

        /* renamed from: i, reason: collision with root package name */
        int f15297i;

        /* renamed from: j, reason: collision with root package name */
        boolean f15298j;

        /* renamed from: k, reason: collision with root package name */
        boolean f15299k;

        /* renamed from: l, reason: collision with root package name */
        Paint f15300l;

        public C0137h() {
            this.f15291c = null;
            this.f15292d = h.f15233k;
            this.f15290b = new g();
        }

        public C0137h(C0137h c0137h) {
            this.f15291c = null;
            this.f15292d = h.f15233k;
            if (c0137h != null) {
                this.f15289a = c0137h.f15289a;
                g gVar = new g(c0137h.f15290b);
                this.f15290b = gVar;
                if (c0137h.f15290b.f15277e != null) {
                    gVar.f15277e = new Paint(c0137h.f15290b.f15277e);
                }
                if (c0137h.f15290b.f15276d != null) {
                    this.f15290b.f15276d = new Paint(c0137h.f15290b.f15276d);
                }
                this.f15291c = c0137h.f15291c;
                this.f15292d = c0137h.f15292d;
                this.f15293e = c0137h.f15293e;
            }
        }

        public boolean a(int i11, int i12) {
            return i11 == this.f15294f.getWidth() && i12 == this.f15294f.getHeight();
        }

        public boolean b() {
            return !this.f15299k && this.f15295g == this.f15291c && this.f15296h == this.f15292d && this.f15298j == this.f15293e && this.f15297i == this.f15290b.getRootAlpha();
        }

        public void c(int i11, int i12) {
            if (this.f15294f == null || !a(i11, i12)) {
                this.f15294f = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
                this.f15299k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f15294f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f15300l == null) {
                Paint paint = new Paint();
                this.f15300l = paint;
                paint.setFilterBitmap(true);
            }
            this.f15300l.setAlpha(this.f15290b.getRootAlpha());
            this.f15300l.setColorFilter(colorFilter);
            return this.f15300l;
        }

        public boolean f() {
            return this.f15290b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f15290b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f15289a;
        }

        public boolean h(int[] iArr) {
            boolean g11 = this.f15290b.g(iArr);
            this.f15299k |= g11;
            return g11;
        }

        public void i() {
            this.f15295g = this.f15291c;
            this.f15296h = this.f15292d;
            this.f15297i = this.f15290b.getRootAlpha();
            this.f15298j = this.f15293e;
            this.f15299k = false;
        }

        public void j(int i11, int i12) {
            this.f15294f.eraseColor(0);
            this.f15290b.b(new Canvas(this.f15294f), i11, i12, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new h(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new h(this);
        }
    }

    /* loaded from: classes2.dex */
    private static class i extends Drawable.ConstantState {

        /* renamed from: a, reason: collision with root package name */
        private final Drawable.ConstantState f15301a;

        public i(Drawable.ConstantState constantState) {
            this.f15301a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f15301a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f15301a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            h hVar = new h();
            hVar.f15232a = (VectorDrawable) this.f15301a.newDrawable();
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            h hVar = new h();
            hVar.f15232a = (VectorDrawable) this.f15301a.newDrawable(resources);
            return hVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            h hVar = new h();
            hVar.f15232a = (VectorDrawable) this.f15301a.newDrawable(resources, theme);
            return hVar;
        }
    }

    h() {
        this.f15238f = true;
        this.f15240h = new float[9];
        this.f15241i = new Matrix();
        this.f15242j = new Rect();
        this.f15234b = new C0137h();
    }

    h(C0137h c0137h) {
        this.f15238f = true;
        this.f15240h = new float[9];
        this.f15241i = new Matrix();
        this.f15242j = new Rect();
        this.f15234b = c0137h;
        this.f15235c = j(this.f15235c, c0137h.f15291c, c0137h.f15292d);
    }

    static int a(int i11, float f11) {
        return (i11 & 16777215) | (((int) (Color.alpha(i11) * f11)) << 24);
    }

    public static h b(Resources resources, int i11, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            h hVar = new h();
            hVar.f15232a = y0.h.e(resources, i11, theme);
            hVar.f15239g = new i(hVar.f15232a.getConstantState());
            return hVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i11);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e11) {
            Log.e("VectorDrawableCompat", "parser error", e11);
            return null;
        } catch (XmlPullParserException e12) {
            Log.e("VectorDrawableCompat", "parser error", e12);
            return null;
        }
    }

    public static h c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = new h();
        hVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return hVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0137h c0137h = this.f15234b;
        g gVar = c0137h.f15290b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f15280h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f15256b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f15288p.put(cVar.getPathName(), cVar);
                    }
                    c0137h.f15289a = cVar.f15271d | c0137h.f15289a;
                    z10 = false;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f15256b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f15288p.put(bVar.getPathName(), bVar);
                    }
                    c0137h.f15289a = bVar.f15271d | c0137h.f15289a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f15256b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f15288p.put(dVar2.getGroupName(), dVar2);
                    }
                    c0137h.f15289a = dVar2.f15265k | c0137h.f15289a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return isAutoMirrored() && a1.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i11) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        C0137h c0137h = this.f15234b;
        g gVar = c0137h.f15290b;
        c0137h.f15292d = g(k.g(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList c11 = k.c(typedArray, xmlPullParser, theme, "tint", 1);
        if (c11 != null) {
            c0137h.f15291c = c11;
        }
        c0137h.f15293e = k.a(typedArray, xmlPullParser, "autoMirrored", 5, c0137h.f15293e);
        gVar.f15283k = k.f(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f15283k);
        float f11 = k.f(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f15284l);
        gVar.f15284l = f11;
        if (gVar.f15283k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (f11 <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        gVar.f15281i = typedArray.getDimension(3, gVar.f15281i);
        float dimension = typedArray.getDimension(2, gVar.f15282j);
        gVar.f15282j = dimension;
        if (gVar.f15281i <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        gVar.setAlpha(k.f(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            gVar.f15286n = string;
            gVar.f15288p.put(string, gVar);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f15232a;
        if (drawable == null) {
            return false;
        }
        a1.a.b(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f15234b.f15290b.f15288p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f15242j);
        if (this.f15242j.width() <= 0 || this.f15242j.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f15236d;
        if (colorFilter == null) {
            colorFilter = this.f15235c;
        }
        canvas.getMatrix(this.f15241i);
        this.f15241i.getValues(this.f15240h);
        float abs = Math.abs(this.f15240h[0]);
        float abs2 = Math.abs(this.f15240h[4]);
        float abs3 = Math.abs(this.f15240h[1]);
        float abs4 = Math.abs(this.f15240h[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.f15242j.width() * abs));
        int min2 = Math.min(2048, (int) (this.f15242j.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f15242j;
        canvas.translate(rect.left, rect.top);
        if (f()) {
            canvas.translate(this.f15242j.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f15242j.offsetTo(0, 0);
        this.f15234b.c(min, min2);
        if (!this.f15238f) {
            this.f15234b.j(min, min2);
        } else if (!this.f15234b.b()) {
            this.f15234b.j(min, min2);
            this.f15234b.i();
        }
        this.f15234b.d(canvas, colorFilter, this.f15242j);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f15232a;
        return drawable != null ? a1.a.d(drawable) : this.f15234b.f15290b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.f15234b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f15232a;
        return drawable != null ? a1.a.e(drawable) : this.f15236d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f15232a != null && Build.VERSION.SDK_INT >= 24) {
            return new i(this.f15232a.getConstantState());
        }
        this.f15234b.f15289a = getChangingConfigurations();
        return this.f15234b;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.f15234b.f15290b.f15282j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.f15234b.f15290b.f15281i;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z10) {
        this.f15238f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0137h c0137h = this.f15234b;
        c0137h.f15290b = new g();
        TypedArray k11 = k.k(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f15202a);
        i(k11, xmlPullParser, theme);
        k11.recycle();
        c0137h.f15289a = getChangingConfigurations();
        c0137h.f15299k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f15235c = j(this.f15235c, c0137h.f15291c, c0137h.f15292d);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f15232a;
        return drawable != null ? a1.a.h(drawable) : this.f15234b.f15293e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0137h c0137h;
        ColorStateList colorStateList;
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((c0137h = this.f15234b) != null && (c0137h.g() || ((colorStateList = this.f15234b.f15291c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f15237e && super.mutate() == this) {
            this.f15234b = new C0137h(this.f15234b);
            this.f15237e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        boolean z10;
        PorterDuff.Mode mode;
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        C0137h c0137h = this.f15234b;
        ColorStateList colorStateList = c0137h.f15291c;
        if (colorStateList == null || (mode = c0137h.f15292d) == null) {
            z10 = false;
        } else {
            this.f15235c = j(this.f15235c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!c0137h.g() || !c0137h.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j11) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j11);
        } else {
            super.scheduleSelf(runnable, j11);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i11) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else if (this.f15234b.f15290b.getRootAlpha() != i11) {
            this.f15234b.f15290b.setRootAlpha(i11);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.j(drawable, z10);
        } else {
            this.f15234b.f15293e = z10;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i11) {
        super.setChangingConfigurations(i11);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i11, PorterDuff.Mode mode) {
        super.setColorFilter(i11, mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f15236d = colorFilter;
            invalidateSelf();
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z10) {
        super.setFilterBitmap(z10);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f11, float f12) {
        super.setHotspot(f11, f12);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i11, int i12, int i13, int i14) {
        super.setHotspotBounds(i11, i12, i13, i14);
    }

    @Override // androidx.vectordrawable.graphics.drawable.g, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setTint(int i11) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.n(drawable, i11);
        } else {
            setTintList(ColorStateList.valueOf(i11));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.o(drawable, colorStateList);
            return;
        }
        C0137h c0137h = this.f15234b;
        if (c0137h.f15291c != colorStateList) {
            c0137h.f15291c = colorStateList;
            this.f15235c = j(this.f15235c, colorStateList, c0137h.f15292d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            a1.a.p(drawable, mode);
            return;
        }
        C0137h c0137h = this.f15234b;
        if (c0137h.f15292d != mode) {
            c0137h.f15292d = mode;
            this.f15235c = j(this.f15235c, c0137h.f15291c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f15232a;
        return drawable != null ? drawable.setVisible(z10, z11) : super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f15232a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
