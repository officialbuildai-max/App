package androidx.view;

import androidx.view.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import k.b;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.y0;

/* loaded from: classes.dex */
public class w extends Lifecycle {

    /* renamed from: k, reason: collision with root package name */
    public static final a f9741k = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9742b;

    /* renamed from: c, reason: collision with root package name */
    private k.a f9743c;

    /* renamed from: d, reason: collision with root package name */
    private Lifecycle.State f9744d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference f9745e;

    /* renamed from: f, reason: collision with root package name */
    private int f9746f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9747g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9748h;

    /* renamed from: i, reason: collision with root package name */
    private ArrayList f9749i;

    /* renamed from: j, reason: collision with root package name */
    private final y0 f9750j;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Lifecycle.State a(Lifecycle.State state1, Lifecycle.State state) {
            Intrinsics.h(state1, "state1");
            return (state == null || state.compareTo(state1) >= 0) ? state1 : state;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Lifecycle.State f9751a;

        /* renamed from: b, reason: collision with root package name */
        private r f9752b;

        public b(t tVar, Lifecycle.State initialState) {
            Intrinsics.h(initialState, "initialState");
            Intrinsics.e(tVar);
            this.f9752b = y.f(tVar);
            this.f9751a = initialState;
        }

        public final void a(u uVar, Lifecycle.Event event) {
            Intrinsics.h(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.f9751a = w.f9741k.a(this.f9751a, targetState);
            r rVar = this.f9752b;
            Intrinsics.e(uVar);
            rVar.onStateChanged(uVar, event);
            this.f9751a = targetState;
        }

        public final Lifecycle.State b() {
            return this.f9751a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public w(u provider) {
        this(provider, true);
        Intrinsics.h(provider, "provider");
    }

    private w(u uVar, boolean z10) {
        this.f9742b = z10;
        this.f9743c = new k.a();
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.f9744d = state;
        this.f9749i = new ArrayList();
        this.f9745e = new WeakReference(uVar);
        this.f9750j = j1.a(state);
    }

    private final void e(u uVar) {
        Iterator descendingIterator = this.f9743c.descendingIterator();
        Intrinsics.g(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.f9748h) {
            Map.Entry entry = (Map.Entry) descendingIterator.next();
            Intrinsics.g(entry, "next()");
            t tVar = (t) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f9744d) > 0 && !this.f9748h && this.f9743c.contains(tVar)) {
                Lifecycle.Event a11 = Lifecycle.Event.INSTANCE.a(bVar.b());
                if (a11 == null) {
                    throw new IllegalStateException("no event down from " + bVar.b());
                }
                m(a11.getTargetState());
                bVar.a(uVar, a11);
                l();
            }
        }
    }

    private final Lifecycle.State f(t tVar) {
        b bVar;
        Map.Entry j11 = this.f9743c.j(tVar);
        Lifecycle.State state = null;
        Lifecycle.State b11 = (j11 == null || (bVar = (b) j11.getValue()) == null) ? null : bVar.b();
        if (!this.f9749i.isEmpty()) {
            state = (Lifecycle.State) this.f9749i.get(r0.size() - 1);
        }
        a aVar = f9741k;
        return aVar.a(aVar.a(this.f9744d, b11), state);
    }

    private final void g(String str) {
        if (!this.f9742b || x.a()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void h(u uVar) {
        b.d c11 = this.f9743c.c();
        Intrinsics.g(c11, "observerMap.iteratorWithAdditions()");
        while (c11.hasNext() && !this.f9748h) {
            Map.Entry entry = (Map.Entry) c11.next();
            t tVar = (t) entry.getKey();
            b bVar = (b) entry.getValue();
            while (bVar.b().compareTo(this.f9744d) < 0 && !this.f9748h && this.f9743c.contains(tVar)) {
                m(bVar.b());
                Lifecycle.Event c12 = Lifecycle.Event.INSTANCE.c(bVar.b());
                if (c12 == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(uVar, c12);
                l();
            }
        }
    }

    private final boolean j() {
        if (this.f9743c.size() == 0) {
            return true;
        }
        Map.Entry a11 = this.f9743c.a();
        Intrinsics.e(a11);
        Lifecycle.State b11 = ((b) a11.getValue()).b();
        Map.Entry e11 = this.f9743c.e();
        Intrinsics.e(e11);
        Lifecycle.State b12 = ((b) e11.getValue()).b();
        return b11 == b12 && this.f9744d == b12;
    }

    private final void k(Lifecycle.State state) {
        Lifecycle.State state2 = this.f9744d;
        if (state2 == state) {
            return;
        }
        if (state2 == Lifecycle.State.INITIALIZED && state == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("State must be at least CREATED to move to " + state + ", but was " + this.f9744d + " in component " + this.f9745e.get()).toString());
        }
        this.f9744d = state;
        if (this.f9747g || this.f9746f != 0) {
            this.f9748h = true;
            return;
        }
        this.f9747g = true;
        o();
        this.f9747g = false;
        if (this.f9744d == Lifecycle.State.DESTROYED) {
            this.f9743c = new k.a();
        }
    }

    private final void l() {
        this.f9749i.remove(r0.size() - 1);
    }

    private final void m(Lifecycle.State state) {
        this.f9749i.add(state);
    }

    private final void o() {
        u uVar = (u) this.f9745e.get();
        if (uVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!j()) {
            this.f9748h = false;
            Lifecycle.State state = this.f9744d;
            Map.Entry a11 = this.f9743c.a();
            Intrinsics.e(a11);
            if (state.compareTo(((b) a11.getValue()).b()) < 0) {
                e(uVar);
            }
            Map.Entry e11 = this.f9743c.e();
            if (!this.f9748h && e11 != null && this.f9744d.compareTo(((b) e11.getValue()).b()) > 0) {
                h(uVar);
            }
        }
        this.f9748h = false;
        this.f9750j.setValue(b());
    }

    @Override // androidx.view.Lifecycle
    public void a(t observer) {
        u uVar;
        Intrinsics.h(observer, "observer");
        g("addObserver");
        Lifecycle.State state = this.f9744d;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        b bVar = new b(observer, state2);
        if (((b) this.f9743c.g(observer, bVar)) == null && (uVar = (u) this.f9745e.get()) != null) {
            boolean z10 = this.f9746f != 0 || this.f9747g;
            Lifecycle.State f11 = f(observer);
            this.f9746f++;
            while (bVar.b().compareTo(f11) < 0 && this.f9743c.contains(observer)) {
                m(bVar.b());
                Lifecycle.Event c11 = Lifecycle.Event.INSTANCE.c(bVar.b());
                if (c11 == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(uVar, c11);
                l();
                f11 = f(observer);
            }
            if (!z10) {
                o();
            }
            this.f9746f--;
        }
    }

    @Override // androidx.view.Lifecycle
    public Lifecycle.State b() {
        return this.f9744d;
    }

    @Override // androidx.view.Lifecycle
    public void d(t observer) {
        Intrinsics.h(observer, "observer");
        g("removeObserver");
        this.f9743c.h(observer);
    }

    public void i(Lifecycle.Event event) {
        Intrinsics.h(event, "event");
        g("handleLifecycleEvent");
        k(event.getTargetState());
    }

    public void n(Lifecycle.State state) {
        Intrinsics.h(state, "state");
        g("setCurrentState");
        k(state);
    }
}
