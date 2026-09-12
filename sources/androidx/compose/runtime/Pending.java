package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
final class Pending {

    /* renamed from: a, reason: collision with root package name */
    private final List f3694a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3695b;

    /* renamed from: c, reason: collision with root package name */
    private int f3696c;

    /* renamed from: d, reason: collision with root package name */
    private final List f3697d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.collection.e0 f3698e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f3699f;

    public Pending(List list, int i11) {
        this.f3694a = list;
        this.f3695b = i11;
        if (!(i11 >= 0)) {
            o1.a("Invalid start index");
        }
        this.f3697d = new ArrayList();
        androidx.collection.e0 e0Var = new androidx.collection.e0(0, 1, null);
        int size = list.size();
        int i12 = 0;
        for (int i13 = 0; i13 < size; i13++) {
            q0 q0Var = (q0) this.f3694a.get(i13);
            e0Var.t(q0Var.b(), new i0(i13, i12, q0Var.c()));
            i12 += q0Var.c();
        }
        this.f3698e = e0Var;
        this.f3699f = LazyKt.b(new Function0<h1>() { // from class: androidx.compose.runtime.Pending$keyMap$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                return h1.a(m84invokeSAeQiB4());
            }

            /* renamed from: invoke-SAeQiB4, reason: not valid java name */
            public final androidx.collection.n0 m84invokeSAeQiB4() {
                androidx.collection.n0 I;
                Object A;
                I = k.I(Pending.this.b().size());
                Pending pending = Pending.this;
                int size2 = pending.b().size();
                for (int i14 = 0; i14 < size2; i14++) {
                    q0 q0Var2 = (q0) pending.b().get(i14);
                    A = k.A(q0Var2);
                    h1.f(I, A, q0Var2);
                }
                return I;
            }
        });
    }

    public final int a() {
        return this.f3696c;
    }

    public final List b() {
        return this.f3694a;
    }

    public final androidx.collection.n0 c() {
        return ((h1) this.f3699f.getValue()).h();
    }

    public final q0 d(int i11, Object obj) {
        return (q0) h1.e(c(), obj != null ? new p0(Integer.valueOf(i11), obj) : Integer.valueOf(i11));
    }

    public final int e() {
        return this.f3695b;
    }

    public final List f() {
        return this.f3697d;
    }

    public final int g(q0 q0Var) {
        i0 i0Var = (i0) this.f3698e.c(q0Var.b());
        if (i0Var != null) {
            return i0Var.b();
        }
        return -1;
    }

    public final boolean h(q0 q0Var) {
        return this.f3697d.add(q0Var);
    }

    public final void i(q0 q0Var, int i11) {
        this.f3698e.t(q0Var.b(), new i0(-1, i11, 0));
    }

    public final void j(int i11, int i12, int i13) {
        char c11 = 7;
        long j11 = -9187201950435737472L;
        if (i11 > i12) {
            androidx.collection.e0 e0Var = this.f3698e;
            Object[] objArr = e0Var.f2380c;
            long[] jArr = e0Var.f2378a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i14 = 0;
            while (true) {
                long j12 = jArr[i14];
                if ((((~j12) << 7) & j12 & j11) != j11) {
                    int i15 = 8 - ((~(i14 - length)) >>> 31);
                    for (int i16 = 0; i16 < i15; i16++) {
                        if ((j12 & 255) < 128) {
                            i0 i0Var = (i0) objArr[(i14 << 3) + i16];
                            int b11 = i0Var.b();
                            if (i11 <= b11 && b11 < i11 + i13) {
                                i0Var.e((b11 - i11) + i12);
                            } else if (i12 <= b11 && b11 < i11) {
                                i0Var.e(b11 + i13);
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i15 != 8) {
                        return;
                    }
                }
                if (i14 == length) {
                    return;
                }
                i14++;
                j11 = -9187201950435737472L;
            }
        } else {
            if (i12 <= i11) {
                return;
            }
            androidx.collection.e0 e0Var2 = this.f3698e;
            Object[] objArr2 = e0Var2.f2380c;
            long[] jArr2 = e0Var2.f2378a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i17 = 0;
            while (true) {
                long j13 = jArr2[i17];
                if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i18 = 8 - ((~(i17 - length2)) >>> 31);
                    for (int i19 = 0; i19 < i18; i19++) {
                        if ((j13 & 255) < 128) {
                            i0 i0Var2 = (i0) objArr2[(i17 << 3) + i19];
                            int b12 = i0Var2.b();
                            if (i11 <= b12 && b12 < i11 + i13) {
                                i0Var2.e((b12 - i11) + i12);
                            } else if (i11 + 1 <= b12 && b12 < i12) {
                                i0Var2.e(b12 - i13);
                            }
                        }
                        j13 >>= 8;
                    }
                    if (i18 != 8) {
                        return;
                    }
                }
                if (i17 == length2) {
                    return;
                }
                i17++;
                c11 = 7;
            }
        }
    }

    public final void k(int i11, int i12) {
        char c11 = 7;
        long j11 = -9187201950435737472L;
        if (i11 > i12) {
            androidx.collection.e0 e0Var = this.f3698e;
            Object[] objArr = e0Var.f2380c;
            long[] jArr = e0Var.f2378a;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i13 = 0;
            while (true) {
                long j12 = jArr[i13];
                if ((((~j12) << 7) & j12 & j11) != j11) {
                    int i14 = 8 - ((~(i13 - length)) >>> 31);
                    for (int i15 = 0; i15 < i14; i15++) {
                        if ((j12 & 255) < 128) {
                            i0 i0Var = (i0) objArr[(i13 << 3) + i15];
                            int c12 = i0Var.c();
                            if (c12 == i11) {
                                i0Var.f(i12);
                            } else if (i12 <= c12 && c12 < i11) {
                                i0Var.f(c12 + 1);
                            }
                        }
                        j12 >>= 8;
                    }
                    if (i14 != 8) {
                        return;
                    }
                }
                if (i13 == length) {
                    return;
                }
                i13++;
                j11 = -9187201950435737472L;
            }
        } else {
            if (i12 <= i11) {
                return;
            }
            androidx.collection.e0 e0Var2 = this.f3698e;
            Object[] objArr2 = e0Var2.f2380c;
            long[] jArr2 = e0Var2.f2378a;
            int length2 = jArr2.length - 2;
            if (length2 < 0) {
                return;
            }
            int i16 = 0;
            while (true) {
                long j13 = jArr2[i16];
                if ((((~j13) << c11) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i17 = 8 - ((~(i16 - length2)) >>> 31);
                    for (int i18 = 0; i18 < i17; i18++) {
                        if ((j13 & 255) < 128) {
                            i0 i0Var2 = (i0) objArr2[(i16 << 3) + i18];
                            int c13 = i0Var2.c();
                            if (c13 == i11) {
                                i0Var2.f(i12);
                            } else if (i11 + 1 <= c13 && c13 < i12) {
                                i0Var2.f(c13 - 1);
                            }
                        }
                        j13 >>= 8;
                    }
                    if (i17 != 8) {
                        return;
                    }
                }
                if (i16 == length2) {
                    return;
                }
                i16++;
                c11 = 7;
            }
        }
    }

    public final void l(int i11) {
        this.f3696c = i11;
    }

    public final int m(q0 q0Var) {
        i0 i0Var = (i0) this.f3698e.c(q0Var.b());
        if (i0Var != null) {
            return i0Var.c();
        }
        return -1;
    }

    public final boolean n(int i11, int i12) {
        int b11;
        i0 i0Var = (i0) this.f3698e.c(i11);
        if (i0Var == null) {
            return false;
        }
        int b12 = i0Var.b();
        int a11 = i12 - i0Var.a();
        i0Var.d(i12);
        if (a11 == 0) {
            return true;
        }
        androidx.collection.e0 e0Var = this.f3698e;
        Object[] objArr = e0Var.f2380c;
        long[] jArr = e0Var.f2378a;
        int length = jArr.length - 2;
        if (length < 0) {
            return true;
        }
        int i13 = 0;
        while (true) {
            long j11 = jArr[i13];
            if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i14 = 8 - ((~(i13 - length)) >>> 31);
                for (int i15 = 0; i15 < i14; i15++) {
                    if ((255 & j11) < 128) {
                        i0 i0Var2 = (i0) objArr[(i13 << 3) + i15];
                        if (i0Var2.b() >= b12 && !Intrinsics.c(i0Var2, i0Var) && (b11 = i0Var2.b() + a11) >= 0) {
                            i0Var2.e(b11);
                        }
                    }
                    j11 >>= 8;
                }
                if (i14 != 8) {
                    return true;
                }
            }
            if (i13 == length) {
                return true;
            }
            i13++;
        }
    }

    public final int o(q0 q0Var) {
        i0 i0Var = (i0) this.f3698e.c(q0Var.b());
        return i0Var != null ? i0Var.a() : q0Var.c();
    }
}
