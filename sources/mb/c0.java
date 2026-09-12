package mb;

import com.google.firebase.components.DependencyException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes5.dex */
final class c0 implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Set f69574a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f69575b;

    /* renamed from: c, reason: collision with root package name */
    private final Set f69576c;

    /* renamed from: d, reason: collision with root package name */
    private final Set f69577d;

    /* renamed from: e, reason: collision with root package name */
    private final Set f69578e;

    /* renamed from: f, reason: collision with root package name */
    private final Set f69579f;

    /* renamed from: g, reason: collision with root package name */
    private final e f69580g;

    /* loaded from: classes5.dex */
    private static class a implements fc.c {

        /* renamed from: a, reason: collision with root package name */
        private final Set f69581a;

        /* renamed from: b, reason: collision with root package name */
        private final fc.c f69582b;

        public a(Set set, fc.c cVar) {
            this.f69581a = set;
            this.f69582b = cVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(c cVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.e()) {
                if (rVar.g()) {
                    hashSet4.add(rVar.c());
                } else {
                    hashSet.add(rVar.c());
                }
            } else if (rVar.d()) {
                hashSet3.add(rVar.c());
            } else if (rVar.g()) {
                hashSet5.add(rVar.c());
            } else {
                hashSet2.add(rVar.c());
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(b0.b(fc.c.class));
        }
        this.f69574a = Collections.unmodifiableSet(hashSet);
        this.f69575b = Collections.unmodifiableSet(hashSet2);
        this.f69576c = Collections.unmodifiableSet(hashSet3);
        this.f69577d = Collections.unmodifiableSet(hashSet4);
        this.f69578e = Collections.unmodifiableSet(hashSet5);
        this.f69579f = cVar.k();
        this.f69580g = eVar;
    }

    @Override // mb.e
    public Object a(Class cls) {
        if (!this.f69574a.contains(b0.b(cls))) {
            throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object a11 = this.f69580g.a(cls);
        return !cls.equals(fc.c.class) ? a11 : new a(this.f69579f, (fc.c) a11);
    }

    @Override // mb.e
    public ic.b b(b0 b0Var) {
        if (this.f69578e.contains(b0Var)) {
            return this.f69580g.b(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", b0Var));
    }

    @Override // mb.e
    public Object c(b0 b0Var) {
        if (this.f69574a.contains(b0Var)) {
            return this.f69580g.c(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency %s.", b0Var));
    }

    @Override // mb.e
    public /* synthetic */ Set d(Class cls) {
        return d.e(this, cls);
    }

    @Override // mb.e
    public Set e(b0 b0Var) {
        if (this.f69577d.contains(b0Var)) {
            return this.f69580g.e(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Set<%s>.", b0Var));
    }

    @Override // mb.e
    public ic.b f(Class cls) {
        return g(b0.b(cls));
    }

    @Override // mb.e
    public ic.b g(b0 b0Var) {
        if (this.f69575b.contains(b0Var)) {
            return this.f69580g.g(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Provider<%s>.", b0Var));
    }

    @Override // mb.e
    public ic.a h(b0 b0Var) {
        if (this.f69576c.contains(b0Var)) {
            return this.f69580g.h(b0Var);
        }
        throw new DependencyException(String.format("Attempting to request an undeclared dependency Deferred<%s>.", b0Var));
    }

    @Override // mb.e
    public ic.a i(Class cls) {
        return h(b0.b(cls));
    }
}
