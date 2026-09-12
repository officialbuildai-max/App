package mb;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final String f69560a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f69561b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f69562c;

    /* renamed from: d, reason: collision with root package name */
    private final int f69563d;

    /* renamed from: e, reason: collision with root package name */
    private final int f69564e;

    /* renamed from: f, reason: collision with root package name */
    private final h f69565f;

    /* renamed from: g, reason: collision with root package name */
    private final Set f69566g;

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private String f69567a;

        /* renamed from: b, reason: collision with root package name */
        private final Set f69568b;

        /* renamed from: c, reason: collision with root package name */
        private final Set f69569c;

        /* renamed from: d, reason: collision with root package name */
        private int f69570d;

        /* renamed from: e, reason: collision with root package name */
        private int f69571e;

        /* renamed from: f, reason: collision with root package name */
        private h f69572f;

        /* renamed from: g, reason: collision with root package name */
        private final Set f69573g;

        private b(Class cls, Class... clsArr) {
            this.f69567a = null;
            HashSet hashSet = new HashSet();
            this.f69568b = hashSet;
            this.f69569c = new HashSet();
            this.f69570d = 0;
            this.f69571e = 0;
            this.f69573g = new HashSet();
            a0.c(cls, "Null interface");
            hashSet.add(b0.b(cls));
            for (Class cls2 : clsArr) {
                a0.c(cls2, "Null interface");
                this.f69568b.add(b0.b(cls2));
            }
        }

        private b(b0 b0Var, b0... b0VarArr) {
            this.f69567a = null;
            HashSet hashSet = new HashSet();
            this.f69568b = hashSet;
            this.f69569c = new HashSet();
            this.f69570d = 0;
            this.f69571e = 0;
            this.f69573g = new HashSet();
            a0.c(b0Var, "Null interface");
            hashSet.add(b0Var);
            for (b0 b0Var2 : b0VarArr) {
                a0.c(b0Var2, "Null interface");
            }
            Collections.addAll(this.f69568b, b0VarArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b g() {
            this.f69571e = 1;
            return this;
        }

        private b i(int i11) {
            a0.d(this.f69570d == 0, "Instantiation type has already been set.");
            this.f69570d = i11;
            return this;
        }

        private void j(b0 b0Var) {
            a0.a(!this.f69568b.contains(b0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b b(r rVar) {
            a0.c(rVar, "Null dependency");
            j(rVar.c());
            this.f69569c.add(rVar);
            return this;
        }

        public b c() {
            return i(1);
        }

        public c d() {
            a0.d(this.f69572f != null, "Missing required property: factory.");
            return new c(this.f69567a, new HashSet(this.f69568b), new HashSet(this.f69569c), this.f69570d, this.f69571e, this.f69572f, this.f69573g);
        }

        public b e() {
            return i(2);
        }

        public b f(h hVar) {
            this.f69572f = (h) a0.c(hVar, "Null factory");
            return this;
        }

        public b h(String str) {
            this.f69567a = str;
            return this;
        }
    }

    private c(String str, Set set, Set set2, int i11, int i12, h hVar, Set set3) {
        this.f69560a = str;
        this.f69561b = Collections.unmodifiableSet(set);
        this.f69562c = Collections.unmodifiableSet(set2);
        this.f69563d = i11;
        this.f69564e = i12;
        this.f69565f = hVar;
        this.f69566g = Collections.unmodifiableSet(set3);
    }

    public static b c(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b d(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static b e(b0 b0Var) {
        return new b(b0Var, new b0[0]);
    }

    public static b f(b0 b0Var, b0... b0VarArr) {
        return new b(b0Var, b0VarArr);
    }

    public static c l(final Object obj, Class cls) {
        return m(cls).f(new h() { // from class: mb.a
            @Override // mb.h
            public final Object a(e eVar) {
                Object q11;
                q11 = c.q(obj, eVar);
                return q11;
            }
        }).d();
    }

    public static b m(Class cls) {
        return c(cls).g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object q(Object obj, e eVar) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object r(Object obj, e eVar) {
        return obj;
    }

    public static c s(final Object obj, Class cls, Class... clsArr) {
        return d(cls, clsArr).f(new h() { // from class: mb.b
            @Override // mb.h
            public final Object a(e eVar) {
                Object r11;
                r11 = c.r(obj, eVar);
                return r11;
            }
        }).d();
    }

    public Set g() {
        return this.f69562c;
    }

    public h h() {
        return this.f69565f;
    }

    public String i() {
        return this.f69560a;
    }

    public Set j() {
        return this.f69561b;
    }

    public Set k() {
        return this.f69566g;
    }

    public boolean n() {
        return this.f69563d == 1;
    }

    public boolean o() {
        return this.f69563d == 2;
    }

    public boolean p() {
        return this.f69564e == 0;
    }

    public c t(h hVar) {
        return new c(this.f69560a, this.f69561b, this.f69562c, this.f69563d, this.f69564e, hVar, this.f69566g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f69561b.toArray()) + ">{" + this.f69563d + ", type=" + this.f69564e + ", deps=" + Arrays.toString(this.f69562c.toArray()) + "}";
    }
}
