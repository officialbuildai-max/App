package androidx.compose.foundation.lazy.layout;

import android.os.Trace;
import androidx.compose.foundation.lazy.layout.x;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.node.TraversableNode$Companion$TraverseDescendantsAction;
import androidx.compose.ui.node.m1;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* loaded from: classes.dex */
public final class PrefetchHandleProvider {

    /* renamed from: a, reason: collision with root package name */
    private final LazyLayoutItemContentFactory f3086a;

    /* renamed from: b, reason: collision with root package name */
    private final SubcomposeLayoutState f3087b;

    /* renamed from: c, reason: collision with root package name */
    private final i0 f3088c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class HandleAndRequestImpl implements x.b, g0 {

        /* renamed from: a, reason: collision with root package name */
        private final int f3089a;

        /* renamed from: b, reason: collision with root package name */
        private final long f3090b;

        /* renamed from: c, reason: collision with root package name */
        private final f0 f3091c;

        /* renamed from: d, reason: collision with root package name */
        private SubcomposeLayoutState.a f3092d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f3093e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f3094f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f3095g;

        /* renamed from: h, reason: collision with root package name */
        private a f3096h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f3097i;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public final class a {

            /* renamed from: a, reason: collision with root package name */
            private final List f3099a;

            /* renamed from: b, reason: collision with root package name */
            private final List[] f3100b;

            /* renamed from: c, reason: collision with root package name */
            private int f3101c;

            /* renamed from: d, reason: collision with root package name */
            private int f3102d;

            public a(List list) {
                this.f3099a = list;
                this.f3100b = new List[list.size()];
                if (list.isEmpty()) {
                    throw new IllegalArgumentException("NestedPrefetchController shouldn't be created with no states");
                }
            }

            public final boolean a(h0 h0Var) {
                if (this.f3101c >= this.f3099a.size()) {
                    return false;
                }
                if (HandleAndRequestImpl.this.f3094f) {
                    throw new IllegalStateException("Should not execute nested prefetch on canceled request");
                }
                Trace.beginSection("compose:lazy:prefetch:nested");
                while (this.f3101c < this.f3099a.size()) {
                    try {
                        if (this.f3100b[this.f3101c] == null) {
                            if (h0Var.a() <= 0) {
                                Trace.endSection();
                                return true;
                            }
                            List[] listArr = this.f3100b;
                            int i11 = this.f3101c;
                            listArr[i11] = ((x) this.f3099a.get(i11)).b();
                        }
                        List list = this.f3100b[this.f3101c];
                        Intrinsics.e(list);
                        while (this.f3102d < list.size()) {
                            if (((g0) list.get(this.f3102d)).b(h0Var)) {
                                Trace.endSection();
                                return true;
                            }
                            this.f3102d++;
                        }
                        this.f3102d = 0;
                        this.f3101c++;
                    } catch (Throwable th2) {
                        Trace.endSection();
                        throw th2;
                    }
                }
                Unit unit = Unit.f67184a;
                Trace.endSection();
                return false;
            }
        }

        private HandleAndRequestImpl(int i11, long j11, f0 f0Var) {
            this.f3089a = i11;
            this.f3090b = j11;
            this.f3091c = f0Var;
        }

        public /* synthetic */ HandleAndRequestImpl(PrefetchHandleProvider prefetchHandleProvider, int i11, long j11, f0 f0Var, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, j11, f0Var);
        }

        private final boolean d() {
            return this.f3092d != null;
        }

        private final boolean e() {
            if (!this.f3094f) {
                int itemCount = ((m) PrefetchHandleProvider.this.f3086a.d().invoke()).getItemCount();
                int i11 = this.f3089a;
                if (i11 >= 0 && i11 < itemCount) {
                    return true;
                }
            }
            return false;
        }

        private final void f() {
            if (!e()) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performComposition()");
            }
            if (this.f3092d != null) {
                throw new IllegalArgumentException("Request was already composed!");
            }
            m mVar = (m) PrefetchHandleProvider.this.f3086a.d().invoke();
            Object b11 = mVar.b(this.f3089a);
            this.f3092d = PrefetchHandleProvider.this.f3087b.i(b11, PrefetchHandleProvider.this.f3086a.b(this.f3089a, b11, mVar.c(this.f3089a)));
        }

        private final void g(long j11) {
            if (this.f3094f) {
                throw new IllegalArgumentException("Callers should check whether the request is still valid before calling performMeasure()");
            }
            if (this.f3093e) {
                throw new IllegalArgumentException("Request was already measured!");
            }
            this.f3093e = true;
            SubcomposeLayoutState.a aVar = this.f3092d;
            if (aVar == null) {
                throw new IllegalArgumentException("performComposition() must be called before performMeasure()");
            }
            int b11 = aVar.b();
            for (int i11 = 0; i11 < b11; i11++) {
                aVar.c(i11, j11);
            }
        }

        private final a h() {
            SubcomposeLayoutState.a aVar = this.f3092d;
            if (aVar == null) {
                throw new IllegalArgumentException("Should precompose before resolving nested prefetch states");
            }
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            aVar.a("androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode", new Function1<m1, TraversableNode$Companion$TraverseDescendantsAction>() { // from class: androidx.compose.foundation.lazy.layout.PrefetchHandleProvider$HandleAndRequestImpl$resolveNestedPrefetchStates$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public final TraversableNode$Companion$TraverseDescendantsAction invoke(m1 m1Var) {
                    T t11;
                    Intrinsics.f(m1Var, "null cannot be cast to non-null type androidx.compose.foundation.lazy.layout.TraversablePrefetchStateNode");
                    x D1 = ((l0) m1Var).D1();
                    Ref.ObjectRef<List<x>> objectRef2 = objectRef;
                    List<x> list = objectRef2.element;
                    if (list != null) {
                        list.add(D1);
                        t11 = list;
                    } else {
                        t11 = CollectionsKt.q(D1);
                    }
                    objectRef2.element = t11;
                    return TraversableNode$Companion$TraverseDescendantsAction.SkipSubtreeAndContinueTraversal;
                }
            });
            List list = (List) objectRef.element;
            if (list != null) {
                return new a(list);
            }
            return null;
        }

        private final boolean i(h0 h0Var, long j11) {
            long a11 = h0Var.a();
            return (this.f3097i && a11 > 0) || j11 < a11;
        }

        @Override // androidx.compose.foundation.lazy.layout.x.b
        public void a() {
            this.f3097i = true;
        }

        @Override // androidx.compose.foundation.lazy.layout.g0
        public boolean b(h0 h0Var) {
            if (!e()) {
                return false;
            }
            Object c11 = ((m) PrefetchHandleProvider.this.f3086a.d().invoke()).c(this.f3089a);
            if (!d()) {
                if (!i(h0Var, (c11 == null || !this.f3091c.f().a(c11)) ? this.f3091c.e() : this.f3091c.f().c(c11))) {
                    return true;
                }
                f0 f0Var = this.f3091c;
                long nanoTime = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:compose");
                try {
                    f();
                    Unit unit = Unit.f67184a;
                    Trace.endSection();
                    long nanoTime2 = System.nanoTime() - nanoTime;
                    if (c11 != null) {
                        f0Var.f().p(c11, f0.a(f0Var, nanoTime2, f0Var.f().e(c11, 0L)));
                    }
                    f0.b(f0Var, f0.a(f0Var, nanoTime2, f0Var.e()));
                } finally {
                }
            }
            if (!this.f3097i) {
                if (!this.f3095g) {
                    if (h0Var.a() <= 0) {
                        return true;
                    }
                    Trace.beginSection("compose:lazy:prefetch:resolve-nested");
                    try {
                        this.f3096h = h();
                        this.f3095g = true;
                        Unit unit2 = Unit.f67184a;
                    } finally {
                    }
                }
                a aVar = this.f3096h;
                if (aVar != null ? aVar.a(h0Var) : false) {
                    return true;
                }
            }
            if (!this.f3093e && !o0.b.p(this.f3090b)) {
                if (!i(h0Var, (c11 == null || !this.f3091c.h().a(c11)) ? this.f3091c.g() : this.f3091c.h().c(c11))) {
                    return true;
                }
                f0 f0Var2 = this.f3091c;
                long nanoTime3 = System.nanoTime();
                Trace.beginSection("compose:lazy:prefetch:measure");
                try {
                    g(this.f3090b);
                    Unit unit3 = Unit.f67184a;
                    Trace.endSection();
                    long nanoTime4 = System.nanoTime() - nanoTime3;
                    if (c11 != null) {
                        f0Var2.h().p(c11, f0.a(f0Var2, nanoTime4, f0Var2.h().e(c11, 0L)));
                    }
                    f0.c(f0Var2, f0.a(f0Var2, nanoTime4, f0Var2.g()));
                } finally {
                }
            }
            return false;
        }

        @Override // androidx.compose.foundation.lazy.layout.x.b
        public void cancel() {
            if (this.f3094f) {
                return;
            }
            this.f3094f = true;
            SubcomposeLayoutState.a aVar = this.f3092d;
            if (aVar != null) {
                aVar.dispose();
            }
            this.f3092d = null;
        }

        public String toString() {
            return "HandleAndRequestImpl { index = " + this.f3089a + ", constraints = " + ((Object) o0.b.q(this.f3090b)) + ", isComposed = " + d() + ", isMeasured = " + this.f3093e + ", isCanceled = " + this.f3094f + " }";
        }
    }

    public PrefetchHandleProvider(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeLayoutState subcomposeLayoutState, i0 i0Var) {
        this.f3086a = lazyLayoutItemContentFactory;
        this.f3087b = subcomposeLayoutState;
        this.f3088c = i0Var;
    }

    public final g0 c(int i11, long j11, f0 f0Var) {
        return new HandleAndRequestImpl(this, i11, j11, f0Var, null);
    }

    public final x.b d(int i11, long j11, f0 f0Var) {
        HandleAndRequestImpl handleAndRequestImpl = new HandleAndRequestImpl(this, i11, j11, f0Var, null);
        this.f3088c.schedulePrefetch(handleAndRequestImpl);
        return handleAndRequestImpl;
    }
}
