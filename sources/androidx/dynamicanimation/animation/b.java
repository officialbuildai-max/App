package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements a.b {

    /* renamed from: m, reason: collision with root package name */
    public static final p f9075m = new f("translationX");

    /* renamed from: n, reason: collision with root package name */
    public static final p f9076n = new g("translationY");

    /* renamed from: o, reason: collision with root package name */
    public static final p f9077o = new h("translationZ");

    /* renamed from: p, reason: collision with root package name */
    public static final p f9078p = new i("scaleX");

    /* renamed from: q, reason: collision with root package name */
    public static final p f9079q = new j("scaleY");

    /* renamed from: r, reason: collision with root package name */
    public static final p f9080r = new k("rotation");

    /* renamed from: s, reason: collision with root package name */
    public static final p f9081s = new l("rotationX");

    /* renamed from: t, reason: collision with root package name */
    public static final p f9082t = new m("rotationY");

    /* renamed from: u, reason: collision with root package name */
    public static final p f9083u = new n("x");

    /* renamed from: v, reason: collision with root package name */
    public static final p f9084v = new a("y");

    /* renamed from: w, reason: collision with root package name */
    public static final p f9085w = new C0085b("z");

    /* renamed from: x, reason: collision with root package name */
    public static final p f9086x = new c("alpha");

    /* renamed from: y, reason: collision with root package name */
    public static final p f9087y = new d("scrollX");

    /* renamed from: z, reason: collision with root package name */
    public static final p f9088z = new e("scrollY");

    /* renamed from: d, reason: collision with root package name */
    final Object f9092d;

    /* renamed from: e, reason: collision with root package name */
    final androidx.dynamicanimation.animation.c f9093e;

    /* renamed from: j, reason: collision with root package name */
    private float f9098j;

    /* renamed from: a, reason: collision with root package name */
    float f9089a = 0.0f;

    /* renamed from: b, reason: collision with root package name */
    float f9090b = Float.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    boolean f9091c = false;

    /* renamed from: f, reason: collision with root package name */
    boolean f9094f = false;

    /* renamed from: g, reason: collision with root package name */
    float f9095g = Float.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    float f9096h = -Float.MAX_VALUE;

    /* renamed from: i, reason: collision with root package name */
    private long f9097i = 0;

    /* renamed from: k, reason: collision with root package name */
    private final ArrayList f9099k = new ArrayList();

    /* renamed from: l, reason: collision with root package name */
    private final ArrayList f9100l = new ArrayList();

    /* loaded from: classes.dex */
    static class a extends p {
        a(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setY(f11);
        }
    }

    /* renamed from: androidx.dynamicanimation.animation.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0085b extends p {
        C0085b(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.getZ(view);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            ViewCompat.setZ(view, f11);
        }
    }

    /* loaded from: classes.dex */
    static class c extends p {
        c(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getAlpha();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setAlpha(f11);
        }
    }

    /* loaded from: classes.dex */
    static class d extends p {
        d(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScrollX((int) f11);
        }
    }

    /* loaded from: classes.dex */
    static class e extends p {
        e(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScrollY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScrollY((int) f11);
        }
    }

    /* loaded from: classes.dex */
    static class f extends p {
        f(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setTranslationX(f11);
        }
    }

    /* loaded from: classes.dex */
    static class g extends p {
        g(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getTranslationY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setTranslationY(f11);
        }
    }

    /* loaded from: classes.dex */
    static class h extends p {
        h(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return ViewCompat.getTranslationZ(view);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            ViewCompat.setTranslationZ(view, f11);
        }
    }

    /* loaded from: classes.dex */
    static class i extends p {
        i(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScaleX(f11);
        }
    }

    /* loaded from: classes.dex */
    static class j extends p {
        j(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getScaleY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setScaleY(f11);
        }
    }

    /* loaded from: classes.dex */
    static class k extends p {
        k(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotation();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setRotation(f11);
        }
    }

    /* loaded from: classes.dex */
    static class l extends p {
        l(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setRotationX(f11);
        }
    }

    /* loaded from: classes.dex */
    static class m extends p {
        m(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getRotationY();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setRotationY(f11);
        }
    }

    /* loaded from: classes.dex */
    static class n extends p {
        n(String str) {
            super(str, null);
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public float a(View view) {
            return view.getX();
        }

        @Override // androidx.dynamicanimation.animation.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(View view, float f11) {
            view.setX(f11);
        }
    }

    /* loaded from: classes.dex */
    static class o {

        /* renamed from: a, reason: collision with root package name */
        float f9101a;

        /* renamed from: b, reason: collision with root package name */
        float f9102b;
    }

    /* loaded from: classes.dex */
    public static abstract class p extends androidx.dynamicanimation.animation.c {
        private p(String str) {
            super(str);
        }

        /* synthetic */ p(String str, f fVar) {
            this(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Object obj, androidx.dynamicanimation.animation.c cVar) {
        this.f9092d = obj;
        this.f9093e = cVar;
        if (cVar == f9080r || cVar == f9081s || cVar == f9082t) {
            this.f9098j = 0.1f;
            return;
        }
        if (cVar == f9086x) {
            this.f9098j = 0.00390625f;
        } else if (cVar == f9078p || cVar == f9079q) {
            this.f9098j = 0.00390625f;
        } else {
            this.f9098j = 1.0f;
        }
    }

    private void b(boolean z10) {
        this.f9094f = false;
        androidx.dynamicanimation.animation.a.d().g(this);
        this.f9097i = 0L;
        this.f9091c = false;
        for (int i11 = 0; i11 < this.f9099k.size(); i11++) {
            if (this.f9099k.get(i11) != null) {
                android.support.v4.media.session.c.a(this.f9099k.get(i11));
                throw null;
            }
        }
        f(this.f9099k);
    }

    private float c() {
        return this.f9093e.a(this.f9092d);
    }

    private static void f(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == null) {
                arrayList.remove(size);
            }
        }
    }

    private void j() {
        if (this.f9094f) {
            return;
        }
        this.f9094f = true;
        if (!this.f9091c) {
            this.f9090b = c();
        }
        float f11 = this.f9090b;
        if (f11 > this.f9095g || f11 < this.f9096h) {
            throw new IllegalArgumentException("Starting value need to be in between min value and max value");
        }
        androidx.dynamicanimation.animation.a.d().a(this, 0L);
    }

    @Override // androidx.dynamicanimation.animation.a.b
    public boolean a(long j11) {
        long j12 = this.f9097i;
        if (j12 == 0) {
            this.f9097i = j11;
            g(this.f9090b);
            return false;
        }
        this.f9097i = j11;
        boolean k11 = k(j11 - j12);
        float min = Math.min(this.f9090b, this.f9095g);
        this.f9090b = min;
        float max = Math.max(min, this.f9096h);
        this.f9090b = max;
        g(max);
        if (k11) {
            b(false);
        }
        return k11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        return this.f9098j * 0.75f;
    }

    public boolean e() {
        return this.f9094f;
    }

    void g(float f11) {
        this.f9093e.b(this.f9092d, f11);
        for (int i11 = 0; i11 < this.f9100l.size(); i11++) {
            if (this.f9100l.get(i11) != null) {
                android.support.v4.media.session.c.a(this.f9100l.get(i11));
                throw null;
            }
        }
        f(this.f9100l);
    }

    public b h(float f11) {
        this.f9090b = f11;
        this.f9091c = true;
        return this;
    }

    public void i() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f9094f) {
            return;
        }
        j();
    }

    abstract boolean k(long j11);
}
