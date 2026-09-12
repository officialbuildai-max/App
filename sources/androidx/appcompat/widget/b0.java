package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import androidx.collection.x0;
import androidx.collection.y0;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class b0 {

    /* renamed from: i, reason: collision with root package name */
    private static b0 f2027i;

    /* renamed from: a, reason: collision with root package name */
    private WeakHashMap f2029a;

    /* renamed from: b, reason: collision with root package name */
    private x0 f2030b;

    /* renamed from: c, reason: collision with root package name */
    private y0 f2031c;

    /* renamed from: d, reason: collision with root package name */
    private final WeakHashMap f2032d = new WeakHashMap(0);

    /* renamed from: e, reason: collision with root package name */
    private TypedValue f2033e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2034f;

    /* renamed from: g, reason: collision with root package name */
    private f f2035g;

    /* renamed from: h, reason: collision with root package name */
    private static final PorterDuff.Mode f2026h = PorterDuff.Mode.SRC_IN;

    /* renamed from: j, reason: collision with root package name */
    private static final c f2028j = new c(6);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a implements e {
        a() {
        }

        @Override // androidx.appcompat.widget.b0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.appcompat.graphics.drawable.a.m(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e11);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements e {
        b() {
        }

        @Override // androidx.appcompat.widget.b0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.c.b(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e11);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends androidx.collection.z {
        public c(int i11) {
            super(i11);
        }

        private static int b(int i11, PorterDuff.Mode mode) {
            return ((i11 + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter c(int i11, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i11, mode)));
        }

        PorterDuffColorFilter d(int i11, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i11, mode)), porterDuffColorFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d implements e {
        d() {
        }

        @Override // androidx.appcompat.widget.b0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) d.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor(null).newInstance(null);
                    h.a.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e11) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e11);
                }
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface e {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* loaded from: classes.dex */
    public interface f {
        Drawable a(b0 b0Var, Context context, int i11);

        ColorStateList b(Context context, int i11);

        boolean c(Context context, int i11, Drawable drawable);

        PorterDuff.Mode d(int i11);

        boolean e(Context context, int i11, Drawable drawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class g implements e {
        g() {
        }

        @Override // androidx.appcompat.widget.b0.e
        public Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return androidx.vectordrawable.graphics.drawable.h.c(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e11) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e11);
                return null;
            }
        }
    }

    private void a(String str, e eVar) {
        if (this.f2030b == null) {
            this.f2030b = new x0();
        }
        this.f2030b.put(str, eVar);
    }

    private synchronized boolean b(Context context, long j11, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            androidx.collection.x xVar = (androidx.collection.x) this.f2032d.get(context);
            if (xVar == null) {
                xVar = new androidx.collection.x();
                this.f2032d.put(context, xVar);
            }
            xVar.k(j11, new WeakReference(constantState));
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void c(Context context, int i11, ColorStateList colorStateList) {
        if (this.f2029a == null) {
            this.f2029a = new WeakHashMap();
        }
        y0 y0Var = (y0) this.f2029a.get(context);
        if (y0Var == null) {
            y0Var = new y0();
            this.f2029a.put(context, y0Var);
        }
        y0Var.a(i11, colorStateList);
    }

    private void d(Context context) {
        if (this.f2034f) {
            return;
        }
        this.f2034f = true;
        Drawable j11 = j(context, R$drawable.abc_vector_test);
        if (j11 == null || !q(j11)) {
            this.f2034f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long e(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    private Drawable f(Context context, int i11) {
        if (this.f2033e == null) {
            this.f2033e = new TypedValue();
        }
        TypedValue typedValue = this.f2033e;
        context.getResources().getValue(i11, typedValue, true);
        long e11 = e(typedValue);
        Drawable i12 = i(context, e11);
        if (i12 != null) {
            return i12;
        }
        f fVar = this.f2035g;
        Drawable a11 = fVar == null ? null : fVar.a(this, context, i11);
        if (a11 != null) {
            a11.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e11, a11);
        }
        return a11;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized b0 h() {
        b0 b0Var;
        synchronized (b0.class) {
            try {
                if (f2027i == null) {
                    b0 b0Var2 = new b0();
                    f2027i = b0Var2;
                    p(b0Var2);
                }
                b0Var = f2027i;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return b0Var;
    }

    private synchronized Drawable i(Context context, long j11) {
        androidx.collection.x xVar = (androidx.collection.x) this.f2032d.get(context);
        if (xVar == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) xVar.e(j11);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            xVar.l(j11);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter l(int i11, PorterDuff.Mode mode) {
        PorterDuffColorFilter c11;
        synchronized (b0.class) {
            c cVar = f2028j;
            c11 = cVar.c(i11, mode);
            if (c11 == null) {
                c11 = new PorterDuffColorFilter(i11, mode);
                cVar.d(i11, mode, c11);
            }
        }
        return c11;
    }

    private ColorStateList n(Context context, int i11) {
        y0 y0Var;
        WeakHashMap weakHashMap = this.f2029a;
        if (weakHashMap == null || (y0Var = (y0) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) y0Var.f(i11);
    }

    private static void p(b0 b0Var) {
        if (Build.VERSION.SDK_INT < 24) {
            b0Var.a("vector", new g());
            b0Var.a("animated-vector", new b());
            b0Var.a("animated-selector", new a());
            b0Var.a("drawable", new d());
        }
    }

    private static boolean q(Drawable drawable) {
        return (drawable instanceof androidx.vectordrawable.graphics.drawable.h) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable r(Context context, int i11) {
        int next;
        x0 x0Var = this.f2030b;
        if (x0Var == null || x0Var.isEmpty()) {
            return null;
        }
        y0 y0Var = this.f2031c;
        if (y0Var != null) {
            String str = (String) y0Var.f(i11);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f2030b.get(str) == null)) {
                return null;
            }
        } else {
            this.f2031c = new y0();
        }
        if (this.f2033e == null) {
            this.f2033e = new TypedValue();
        }
        TypedValue typedValue = this.f2033e;
        Resources resources = context.getResources();
        resources.getValue(i11, typedValue, true);
        long e11 = e(typedValue);
        Drawable i12 = i(context, e11);
        if (i12 != null) {
            return i12;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i11);
                AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f2031c.a(i11, name);
                e eVar = (e) this.f2030b.get(name);
                if (eVar != null) {
                    i12 = eVar.a(context, xml, asAttributeSet, context.getTheme());
                }
                if (i12 != null) {
                    i12.setChangingConfigurations(typedValue.changingConfigurations);
                    b(context, e11, i12);
                }
            } catch (Exception e12) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e12);
            }
        }
        if (i12 == null) {
            this.f2031c.a(i11, "appcompat_skip_skip");
        }
        return i12;
    }

    private Drawable v(Context context, int i11, boolean z10, Drawable drawable) {
        ColorStateList m11 = m(context, i11);
        if (m11 != null) {
            Drawable r11 = a1.a.r(drawable.mutate());
            a1.a.o(r11, m11);
            PorterDuff.Mode o11 = o(i11);
            if (o11 == null) {
                return r11;
            }
            a1.a.p(r11, o11);
            return r11;
        }
        f fVar = this.f2035g;
        if ((fVar == null || !fVar.e(context, i11, drawable)) && !x(context, i11, drawable) && z10) {
            return null;
        }
        return drawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void w(Drawable drawable, h0 h0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z10 = h0Var.f2112d;
            if (z10 || h0Var.f2111c) {
                drawable.setColorFilter(g(z10 ? h0Var.f2109a : null, h0Var.f2111c ? h0Var.f2110b : f2026h, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
            }
        }
    }

    public synchronized Drawable j(Context context, int i11) {
        return k(context, i11, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable k(Context context, int i11, boolean z10) {
        Drawable r11;
        try {
            d(context);
            r11 = r(context, i11);
            if (r11 == null) {
                r11 = f(context, i11);
            }
            if (r11 == null) {
                r11 = androidx.core.content.b.getDrawable(context, i11);
            }
            if (r11 != null) {
                r11 = v(context, i11, z10, r11);
            }
            if (r11 != null) {
                y.b(r11);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return r11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ColorStateList m(Context context, int i11) {
        ColorStateList n11;
        n11 = n(context, i11);
        if (n11 == null) {
            f fVar = this.f2035g;
            n11 = fVar == null ? null : fVar.b(context, i11);
            if (n11 != null) {
                c(context, i11, n11);
            }
        }
        return n11;
    }

    PorterDuff.Mode o(int i11) {
        f fVar = this.f2035g;
        if (fVar == null) {
            return null;
        }
        return fVar.d(i11);
    }

    public synchronized void s(Context context) {
        androidx.collection.x xVar = (androidx.collection.x) this.f2032d.get(context);
        if (xVar != null) {
            xVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Drawable t(Context context, t0 t0Var, int i11) {
        try {
            Drawable r11 = r(context, i11);
            if (r11 == null) {
                r11 = t0Var.a(i11);
            }
            if (r11 == null) {
                return null;
            }
            return v(context, i11, false, r11);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void u(f fVar) {
        this.f2035g = fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x(Context context, int i11, Drawable drawable) {
        f fVar = this.f2035g;
        return fVar != null && fVar.c(context, i11, drawable);
    }
}
