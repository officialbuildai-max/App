package n4;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name */
    private final d f70301c;

    /* renamed from: e, reason: collision with root package name */
    protected w4.c f70303e;

    /* renamed from: a, reason: collision with root package name */
    final List f70299a = new ArrayList(1);

    /* renamed from: b, reason: collision with root package name */
    private boolean f70300b = false;

    /* renamed from: d, reason: collision with root package name */
    protected float f70302d = 0.0f;

    /* renamed from: f, reason: collision with root package name */
    private Object f70304f = null;

    /* renamed from: g, reason: collision with root package name */
    private float f70305g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f70306h = -1.0f;

    /* loaded from: classes2.dex */
    public interface b {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements d {
        private c() {
        }

        @Override // n4.a.d
        public boolean a(float f11) {
            throw new IllegalStateException("not implemented");
        }

        @Override // n4.a.d
        public w4.a b() {
            throw new IllegalStateException("not implemented");
        }

        @Override // n4.a.d
        public boolean c(float f11) {
            return false;
        }

        @Override // n4.a.d
        public float d() {
            return 0.0f;
        }

        @Override // n4.a.d
        public float e() {
            return 1.0f;
        }

        @Override // n4.a.d
        public boolean isEmpty() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface d {
        boolean a(float f11);

        w4.a b();

        boolean c(float f11);

        float d();

        float e();

        boolean isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class e implements d {

        /* renamed from: a, reason: collision with root package name */
        private final List f70307a;

        /* renamed from: c, reason: collision with root package name */
        private w4.a f70309c = null;

        /* renamed from: d, reason: collision with root package name */
        private float f70310d = -1.0f;

        /* renamed from: b, reason: collision with root package name */
        private w4.a f70308b = f(0.0f);

        e(List list) {
            this.f70307a = list;
        }

        private w4.a f(float f11) {
            List list = this.f70307a;
            w4.a aVar = (w4.a) list.get(list.size() - 1);
            if (f11 >= aVar.f()) {
                return aVar;
            }
            for (int size = this.f70307a.size() - 2; size >= 1; size--) {
                w4.a aVar2 = (w4.a) this.f70307a.get(size);
                if (this.f70308b != aVar2 && aVar2.a(f11)) {
                    return aVar2;
                }
            }
            return (w4.a) this.f70307a.get(0);
        }

        @Override // n4.a.d
        public boolean a(float f11) {
            w4.a aVar = this.f70309c;
            w4.a aVar2 = this.f70308b;
            if (aVar == aVar2 && this.f70310d == f11) {
                return true;
            }
            this.f70309c = aVar2;
            this.f70310d = f11;
            return false;
        }

        @Override // n4.a.d
        public w4.a b() {
            return this.f70308b;
        }

        @Override // n4.a.d
        public boolean c(float f11) {
            if (this.f70308b.a(f11)) {
                return !this.f70308b.i();
            }
            this.f70308b = f(f11);
            return true;
        }

        @Override // n4.a.d
        public float d() {
            return ((w4.a) this.f70307a.get(0)).f();
        }

        @Override // n4.a.d
        public float e() {
            return ((w4.a) this.f70307a.get(r0.size() - 1)).c();
        }

        @Override // n4.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class f implements d {

        /* renamed from: a, reason: collision with root package name */
        private final w4.a f70311a;

        /* renamed from: b, reason: collision with root package name */
        private float f70312b = -1.0f;

        f(List list) {
            this.f70311a = (w4.a) list.get(0);
        }

        @Override // n4.a.d
        public boolean a(float f11) {
            if (this.f70312b == f11) {
                return true;
            }
            this.f70312b = f11;
            return false;
        }

        @Override // n4.a.d
        public w4.a b() {
            return this.f70311a;
        }

        @Override // n4.a.d
        public boolean c(float f11) {
            return !this.f70311a.i();
        }

        @Override // n4.a.d
        public float d() {
            return this.f70311a.f();
        }

        @Override // n4.a.d
        public float e() {
            return this.f70311a.c();
        }

        @Override // n4.a.d
        public boolean isEmpty() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List list) {
        this.f70301c = p(list);
    }

    private float g() {
        if (this.f70305g == -1.0f) {
            this.f70305g = this.f70301c.d();
        }
        return this.f70305g;
    }

    private static d p(List list) {
        return list.isEmpty() ? new c() : list.size() == 1 ? new f(list) : new e(list);
    }

    public void a(b bVar) {
        this.f70299a.add(bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public w4.a b() {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        w4.a b11 = this.f70301c.b();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseKeyframeAnimation#getCurrentKeyframe");
        }
        return b11;
    }

    float c() {
        if (this.f70306h == -1.0f) {
            this.f70306h = this.f70301c.e();
        }
        return this.f70306h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float d() {
        Interpolator interpolator;
        w4.a b11 = b();
        if (b11 == null || b11.i() || (interpolator = b11.f77689d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        if (this.f70300b) {
            return 0.0f;
        }
        w4.a b11 = b();
        if (b11.i()) {
            return 0.0f;
        }
        return (this.f70302d - b11.f()) / (b11.c() - b11.f());
    }

    public float f() {
        return this.f70302d;
    }

    public Object h() {
        float e11 = e();
        if (this.f70303e == null && this.f70301c.a(e11)) {
            return this.f70304f;
        }
        w4.a b11 = b();
        Interpolator interpolator = b11.f77690e;
        Object i11 = (interpolator == null || b11.f77691f == null) ? i(b11, d()) : j(b11, e11, interpolator.getInterpolation(e11), b11.f77691f.getInterpolation(e11));
        this.f70304f = i11;
        return i11;
    }

    abstract Object i(w4.a aVar, float f11);

    protected Object j(w4.a aVar, float f11, float f12, float f13) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public boolean k() {
        return this.f70303e != null;
    }

    public void l() {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#notifyListeners");
        }
        for (int i11 = 0; i11 < this.f70299a.size(); i11++) {
            ((b) this.f70299a.get(i11)).a();
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("BaseKeyframeAnimation#notifyListeners");
        }
    }

    public void m() {
        this.f70300b = true;
    }

    public void n(float f11) {
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("BaseKeyframeAnimation#setProgress");
        }
        if (this.f70301c.isEmpty()) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
                return;
            }
            return;
        }
        if (f11 < g()) {
            f11 = g();
        } else if (f11 > c()) {
            f11 = c();
        }
        if (f11 == this.f70302d) {
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
            }
        } else {
            this.f70302d = f11;
            if (this.f70301c.c(f11)) {
                l();
            }
            if (com.airbnb.lottie.d.g()) {
                com.airbnb.lottie.d.c("BaseKeyframeAnimation#setProgress");
            }
        }
    }

    public void o(w4.c cVar) {
        w4.c cVar2 = this.f70303e;
        if (cVar2 != null) {
            cVar2.c(null);
        }
        this.f70303e = cVar;
        if (cVar != null) {
            cVar.c(this);
        }
    }
}
