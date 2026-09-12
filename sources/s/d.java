package s;

import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.a2;
import androidx.compose.runtime.b2;
import androidx.compose.runtime.c2;
import androidx.compose.runtime.j2;
import androidx.compose.runtime.k1;
import androidx.compose.runtime.m2;
import androidx.compose.runtime.y0;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes2.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private final int f74907a;

    /* renamed from: b, reason: collision with root package name */
    private final int f74908b;

    /* loaded from: classes2.dex */
    public static final class a extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final a f74909c = new a();

        private a() {
            super(1, 0, 2, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.D(eVar.b(q.a(0)));
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "distance" : super.e(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final a0 f74910c = new a0();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private a0() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.a0.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.W0();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final b f74911c = new b();

        private b() {
            super(0, 2, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            Object a11 = eVar.a(t.a(1));
            if (a11 instanceof c2) {
                a2Var.c(((c2) a11).b());
            }
            m2Var.G(cVar, a11);
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "anchor" : t.b(i11, t.a(1)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final b0 f74912c = new b0();

        private b0() {
            super(1, 0, 2, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            int R;
            int b11 = eVar.b(q.a(0));
            int e02 = m2Var.e0();
            int c02 = m2Var.c0();
            int d12 = m2Var.d1(c02);
            int c12 = m2Var.c1(c02);
            for (int max = Math.max(d12, c12 - b11); max < c12; max++) {
                Object[] objArr = m2Var.f3885c;
                R = m2Var.R(max);
                Object obj = objArr[R];
                if (obj instanceof c2) {
                    a2Var.e(((c2) obj).b(), e02 - max, -1, -1);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).x();
                }
            }
            m2Var.k1(b11);
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "count" : super.e(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final c f74913c = new c();

        private c() {
            super(0, 2, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.internal.c cVar = (androidx.compose.runtime.internal.c) eVar.a(t.a(1));
            int a11 = cVar != null ? cVar.a() : 0;
            s.a aVar = (s.a) eVar.a(t.a(0));
            if (a11 > 0) {
                fVar = new k1(fVar, a11);
            }
            aVar.b(fVar, m2Var, a2Var);
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "changes" : t.b(i11, t.a(1)) ? "effectiveNodeIndex" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final c0 f74914c = new c0();

        private c0() {
            super(1, 2, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            int i11;
            int i12;
            Object a11 = eVar.a(t.a(0));
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(1));
            int b11 = eVar.b(q.a(0));
            if (a11 instanceof c2) {
                a2Var.c(((c2) a11).b());
            }
            int F = m2Var.F(cVar);
            Object R0 = m2Var.R0(F, b11, a11);
            if (!(R0 instanceof c2)) {
                if (R0 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) R0).x();
                    return;
                }
                return;
            }
            int e02 = m2Var.e0() - m2Var.a1(F, b11);
            c2 c2Var = (c2) R0;
            androidx.compose.runtime.c a12 = c2Var.a();
            if (a12 == null || !a12.b()) {
                i11 = -1;
                i12 = -1;
            } else {
                i11 = m2Var.F(a12);
                i12 = m2Var.e0() - m2Var.b1(i11);
            }
            a2Var.e(c2Var.b(), e02, i11, i12);
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "groupSlotIndex" : super.e(i11);
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : t.b(i11, t.a(1)) ? "anchor" : super.f(i11);
        }
    }

    /* renamed from: s.d$d, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0941d extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final C0941d f74915c = new C0941d();

        private C0941d() {
            super(0, 2, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            int a11 = ((androidx.compose.runtime.internal.c) eVar.a(t.a(0))).a();
            List list = (List) eVar.a(t.a(1));
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Object obj = list.get(i11);
                Intrinsics.f(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int i12 = a11 + i11;
                fVar.i(i12, obj);
                fVar.g(i12, obj);
            }
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "effectiveNodeIndex" : t.b(i11, t.a(1)) ? "nodes" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final d0 f74916c = new d0();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private d0() {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r3.<init>(r2, r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.d0.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.o1(eVar.a(t.a(0)));
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "data" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final e f74917c = new e();

        private e() {
            super(0, 4, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            y0 y0Var = (y0) eVar.a(t.a(2));
            androidx.compose.runtime.m mVar = (androidx.compose.runtime.m) eVar.a(t.a(1));
            mVar.l(y0Var);
            androidx.compose.runtime.k.s("Could not resolve state for movable content");
            throw new KotlinNothingValueException();
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "resolvedState" : t.b(i11, t.a(1)) ? "resolvedCompositionContext" : t.b(i11, t.a(2)) ? "from" : t.b(i11, t.a(3)) ? "to" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class e0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final e0 f74918c = new e0();

        private e0() {
            super(0, 2, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            ((Function2) eVar.a(t.a(1))).invoke(fVar.d(), eVar.a(t.a(0)));
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : t.b(i11, t.a(1)) ? "block" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final f f74919c = new f();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private f() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.f.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.k.t(m2Var, a2Var);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final f0 f74920c = new f0();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private f0() {
            /*
                r2 = this;
                r0 = 1
                r1 = 0
                r2.<init>(r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.f0.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            Object a11 = eVar.a(t.a(0));
            int b11 = eVar.b(q.a(0));
            if (a11 instanceof c2) {
                a2Var.c(((c2) a11).b());
            }
            Object S0 = m2Var.S0(b11, a11);
            if (S0 instanceof c2) {
                a2Var.e(((c2) S0).b(), m2Var.e0() - m2Var.a1(m2Var.a0(), b11), -1, -1);
            } else if (S0 instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) S0).x();
            }
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "groupSlotIndex" : super.e(i11);
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final g f74921c = new g();

        private g() {
            super(0, 2, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            int d11;
            androidx.compose.runtime.internal.c cVar = (androidx.compose.runtime.internal.c) eVar.a(t.a(0));
            androidx.compose.runtime.c cVar2 = (androidx.compose.runtime.c) eVar.a(t.a(1));
            Intrinsics.f(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            d11 = s.f.d(m2Var, cVar2, fVar);
            cVar.b(d11);
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "effectiveNodeIndexOut" : t.b(i11, t.a(1)) ? "anchor" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class g0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final g0 f74922c = new g0();

        private g0() {
            super(1, 0, 2, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            int b11 = eVar.b(q.a(0));
            for (int i11 = 0; i11 < b11; i11++) {
                fVar.l();
            }
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "count" : super.e(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class h extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final h f74923c = new h();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private h() {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r3.<init>(r2, r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.h.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            Intrinsics.f(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            for (Object obj : (Object[]) eVar.a(t.a(0))) {
                fVar.j(obj);
            }
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "nodes" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class h0 extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final h0 f74924c = new h0();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private h0() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.h0.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            Object d11 = fVar.d();
            Intrinsics.f(d11, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
            ((androidx.compose.runtime.h) d11).onReuse();
        }
    }

    /* loaded from: classes2.dex */
    public static final class i extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final i f74925c = new i();

        private i() {
            super(0, 2, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            ((Function1) eVar.a(t.a(0))).invoke((androidx.compose.runtime.l) eVar.a(t.a(1)));
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "anchor" : t.b(i11, t.a(1)) ? "composition" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final j f74926c = new j();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private j() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.j.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.T();
        }
    }

    /* loaded from: classes2.dex */
    public static final class k extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final k f74927c = new k();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private k() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.k.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            Intrinsics.f(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            s.f.e(m2Var, fVar, 0);
            m2Var.T();
        }
    }

    /* loaded from: classes2.dex */
    public static final class l extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final l f74928c = new l();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private l() {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r3.<init>(r2, r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.l.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.W((androidx.compose.runtime.c) eVar.a(t.a(0)));
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "anchor" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class m extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final m f74929c = new m();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private m() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.m.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.V(0);
        }
    }

    /* loaded from: classes2.dex */
    public static final class n extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final n f74930c = new n();

        private n() {
            super(1, 2, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            Object invoke = ((Function0) eVar.a(t.a(0))).invoke();
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(1));
            int b11 = eVar.b(q.a(0));
            Intrinsics.f(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            m2Var.s1(cVar, invoke);
            fVar.g(b11, invoke);
            fVar.j(invoke);
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "insertIndex" : super.e(i11);
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "factory" : t.b(i11, t.a(1)) ? "groupAnchor" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class o extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final o f74931c = new o();

        private o() {
            super(0, 2, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            j2 j2Var = (j2) eVar.a(t.a(1));
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            m2Var.I();
            m2Var.v0(j2Var, cVar.d(j2Var), false);
            m2Var.U();
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "anchor" : t.b(i11, t.a(1)) ? "from" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class p extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final p f74932c = new p();

        private p() {
            super(0, 3, 1, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            j2 j2Var = (j2) eVar.a(t.a(1));
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            s.c cVar2 = (s.c) eVar.a(t.a(2));
            m2 x10 = j2Var.x();
            try {
                cVar2.d(fVar, x10, a2Var);
                Unit unit = Unit.f67184a;
                x10.L(true);
                m2Var.I();
                m2Var.v0(j2Var, cVar.d(j2Var), false);
                m2Var.U();
            } catch (Throwable th2) {
                x10.L(false);
                throw th2;
            }
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "anchor" : t.b(i11, t.a(1)) ? "from" : t.b(i11, t.a(2)) ? "fixups" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class q {
        public static int a(int i11) {
            return i11;
        }

        public static final boolean b(int i11, int i12) {
            return i11 == i12;
        }
    }

    /* loaded from: classes2.dex */
    public static final class r extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final r f74933c = new r();

        private r() {
            super(1, 0, 2, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.w0(eVar.b(q.a(0)));
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "offset" : super.e(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class s extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final s f74934c = new s();

        private s() {
            super(3, 0, 2, null);
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            fVar.f(eVar.b(q.a(0)), eVar.b(q.a(1)), eVar.b(q.a(2)));
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "from" : q.b(i11, q.a(1)) ? "to" : q.b(i11, q.a(2)) ? "count" : super.e(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class t {
        public static int a(int i11) {
            return i11;
        }

        public static final boolean b(int i11, int i12) {
            return i11 == i12;
        }
    }

    /* loaded from: classes2.dex */
    public static final class u extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final u f74935c = new u();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private u() {
            /*
                r2 = this;
                r0 = 1
                r1 = 0
                r2.<init>(r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.u.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.c cVar = (androidx.compose.runtime.c) eVar.a(t.a(0));
            int b11 = eVar.b(q.a(0));
            fVar.l();
            Intrinsics.f(fVar, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            fVar.i(b11, m2Var.B0(cVar));
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "insertIndex" : super.e(i11);
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "groupAnchor" : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class v extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final v f74936c = new v();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private v() {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r3.<init>(r2, r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.v.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            a2Var.c((b2) eVar.a(t.a(0)));
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? AppMeasurementSdk.ConditionalUserProperty.VALUE : super.f(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class w extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final w f74937c = new w();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private w() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.w.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            androidx.compose.runtime.k.K(m2Var, a2Var);
        }
    }

    /* loaded from: classes2.dex */
    public static final class x extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final x f74938c = new x();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private x() {
            /*
                r3 = this;
                r0 = 0
                r1 = 0
                r2 = 2
                r3.<init>(r2, r0, r2, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.x.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            fVar.e(eVar.b(q.a(0)), eVar.b(q.a(1)));
        }

        @Override // s.d
        public String e(int i11) {
            return q.b(i11, q.a(0)) ? "removeIndex" : q.b(i11, q.a(1)) ? "count" : super.e(i11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class y extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final y f74939c = new y();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private y() {
            /*
                r3 = this;
                r0 = 3
                r1 = 0
                r2 = 0
                r3.<init>(r2, r2, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.y.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            m2Var.O0();
        }
    }

    /* loaded from: classes2.dex */
    public static final class z extends d {

        /* renamed from: c, reason: collision with root package name */
        public static final z f74940c = new z();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private z() {
            /*
                r3 = this;
                r0 = 1
                r1 = 0
                r2 = 0
                r3.<init>(r2, r0, r0, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: s.d.z.<init>():void");
        }

        @Override // s.d
        public void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var) {
            a2Var.a((Function0) eVar.a(t.a(0)));
        }

        @Override // s.d
        public String f(int i11) {
            return t.b(i11, t.a(0)) ? "effect" : super.f(i11);
        }
    }

    private d(int i11, int i12) {
        this.f74907a = i11;
        this.f74908b = i12;
    }

    public /* synthetic */ d(int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? 0 : i12, null);
    }

    public /* synthetic */ d(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, i12);
    }

    public abstract void a(s.e eVar, androidx.compose.runtime.f fVar, m2 m2Var, a2 a2Var);

    public final int b() {
        return this.f74907a;
    }

    public final String c() {
        String g11 = Reflection.b(getClass()).g();
        return g11 == null ? "" : g11;
    }

    public final int d() {
        return this.f74908b;
    }

    public String e(int i11) {
        return "IntParameter(" + i11 + ')';
    }

    public String f(int i11) {
        return "ObjectParameter(" + i11 + ')';
    }

    public String toString() {
        return c();
    }
}
