package io.reactivex.rxjava3.internal.functions;

import io.reactivex.rxjava3.exceptions.OnErrorNotImplementedException;
import java.util.Comparator;
import java.util.concurrent.Callable;

/* loaded from: classes7.dex */
public abstract class Functions {

    /* renamed from: a, reason: collision with root package name */
    static final lz.h f65443a = new g();

    /* renamed from: b, reason: collision with root package name */
    public static final Runnable f65444b = new EmptyRunnable();

    /* renamed from: c, reason: collision with root package name */
    public static final lz.a f65445c = new b();

    /* renamed from: d, reason: collision with root package name */
    static final lz.f f65446d = new c();

    /* renamed from: e, reason: collision with root package name */
    public static final lz.f f65447e = new e();

    /* renamed from: f, reason: collision with root package name */
    public static final lz.f f65448f = new k();

    /* renamed from: g, reason: collision with root package name */
    public static final lz.i f65449g = new d();

    /* renamed from: h, reason: collision with root package name */
    static final lz.j f65450h = new l();

    /* renamed from: i, reason: collision with root package name */
    static final lz.j f65451i = new f();

    /* renamed from: j, reason: collision with root package name */
    static final lz.k f65452j = new j();

    /* renamed from: k, reason: collision with root package name */
    public static final lz.f f65453k = new i();

    /* loaded from: classes7.dex */
    static final class EmptyRunnable implements Runnable {
        EmptyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* loaded from: classes7.dex */
    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* loaded from: classes7.dex */
    static final class a implements lz.h {

        /* renamed from: a, reason: collision with root package name */
        final lz.g f65454a;

        a(lz.g gVar) {
            this.f65454a = gVar;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object apply(Object[] objArr) {
            if (objArr.length == 3) {
                return this.f65454a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* loaded from: classes7.dex */
    static final class b implements lz.a {
        b() {
        }

        @Override // lz.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* loaded from: classes7.dex */
    static final class c implements lz.f {
        c() {
        }

        @Override // lz.f
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* loaded from: classes7.dex */
    static final class d implements lz.i {
        d() {
        }
    }

    /* loaded from: classes7.dex */
    static final class e implements lz.f {
        e() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) {
            pz.a.r(th2);
        }
    }

    /* loaded from: classes7.dex */
    static final class f implements lz.j {
        f() {
        }

        @Override // lz.j
        public boolean a(Object obj) {
            return false;
        }
    }

    /* loaded from: classes7.dex */
    static final class g implements lz.h {
        g() {
        }

        @Override // lz.h
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* loaded from: classes7.dex */
    static final class h implements Callable, lz.k, lz.h {

        /* renamed from: a, reason: collision with root package name */
        final Object f65455a;

        h(Object obj) {
            this.f65455a = obj;
        }

        @Override // lz.h
        public Object apply(Object obj) {
            return this.f65455a;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return this.f65455a;
        }

        @Override // lz.k
        public Object get() {
            return this.f65455a;
        }
    }

    /* loaded from: classes7.dex */
    static final class i implements lz.f {
        i() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(u10.d dVar) {
            dVar.request(Long.MAX_VALUE);
        }
    }

    /* loaded from: classes7.dex */
    static final class j implements lz.k {
        j() {
        }

        @Override // lz.k
        public Object get() {
            return null;
        }
    }

    /* loaded from: classes7.dex */
    static final class k implements lz.f {
        k() {
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th2) {
            pz.a.r(new OnErrorNotImplementedException(th2));
        }
    }

    /* loaded from: classes7.dex */
    static final class l implements lz.j {
        l() {
        }

        @Override // lz.j
        public boolean a(Object obj) {
            return true;
        }
    }

    public static lz.f a() {
        return f65446d;
    }

    public static lz.k b(Object obj) {
        return new h(obj);
    }

    public static lz.h c(lz.g gVar) {
        return new a(gVar);
    }
}
