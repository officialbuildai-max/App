package u;

import androidx.compose.runtime.o1;
import java.util.Arrays;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* loaded from: classes2.dex */
public final class t {

    /* renamed from: e, reason: collision with root package name */
    public static final a f76639e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final int f76640f = 8;

    /* renamed from: g, reason: collision with root package name */
    private static final t f76641g = new t(0, 0, new Object[0]);

    /* renamed from: a, reason: collision with root package name */
    private int f76642a;

    /* renamed from: b, reason: collision with root package name */
    private int f76643b;

    /* renamed from: c, reason: collision with root package name */
    private final w.e f76644c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f76645d;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t a() {
            return t.f76641g;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private t f76646a;

        /* renamed from: b, reason: collision with root package name */
        private final int f76647b;

        public b(t tVar, int i11) {
            this.f76646a = tVar;
            this.f76647b = i11;
        }

        public final t a() {
            return this.f76646a;
        }

        public final int b() {
            return this.f76647b;
        }

        public final void c(t tVar) {
            this.f76646a = tVar;
        }
    }

    public t(int i11, int i12, Object[] objArr) {
        this(i11, i12, objArr, null);
    }

    public t(int i11, int i12, Object[] objArr, w.e eVar) {
        this.f76642a = i11;
        this.f76643b = i12;
        this.f76644c = eVar;
        this.f76645d = objArr;
    }

    private final t A(int i11, f fVar) {
        fVar.p(fVar.size() - 1);
        fVar.n(W(i11));
        if (this.f76645d.length == 2) {
            return null;
        }
        if (this.f76644c != fVar.l()) {
            return new t(0, 0, x.b(this.f76645d, i11), fVar.l());
        }
        this.f76645d = x.b(this.f76645d, i11);
        return this;
    }

    private final t B(int i11, Object obj, Object obj2, w.e eVar) {
        int n11 = n(i11);
        if (this.f76644c != eVar) {
            return new t(i11 | this.f76642a, this.f76643b, x.a(this.f76645d, n11, obj, obj2), eVar);
        }
        this.f76645d = x.a(this.f76645d, n11, obj, obj2);
        this.f76642a = i11 | this.f76642a;
        return this;
    }

    private final t C(int i11, int i12, int i13, Object obj, Object obj2, int i14, w.e eVar) {
        if (this.f76644c != eVar) {
            return new t(this.f76642a ^ i12, i12 | this.f76643b, d(i11, i12, i13, obj, obj2, i14, eVar), eVar);
        }
        this.f76645d = d(i11, i12, i13, obj, obj2, i14, eVar);
        this.f76642a ^= i12;
        this.f76643b |= i12;
        return this;
    }

    private final t F(t tVar, int i11, int i12, w.b bVar, f fVar) {
        if (r(i11)) {
            t N = N(O(i11));
            if (tVar.r(i11)) {
                return N.E(tVar.N(tVar.O(i11)), i12 + 5, bVar, fVar);
            }
            if (!tVar.q(i11)) {
                return N;
            }
            int n11 = tVar.n(i11);
            Object t11 = tVar.t(n11);
            Object W = tVar.W(n11);
            int size = fVar.size();
            t D = N.D(t11 != null ? t11.hashCode() : 0, t11, W, i12 + 5, fVar);
            if (fVar.size() != size) {
                return D;
            }
            bVar.c(bVar.a() + 1);
            return D;
        }
        if (!tVar.r(i11)) {
            int n12 = n(i11);
            Object t12 = t(n12);
            Object W2 = W(n12);
            int n13 = tVar.n(i11);
            Object t13 = tVar.t(n13);
            return u(t12 != null ? t12.hashCode() : 0, t12, W2, t13 != null ? t13.hashCode() : 0, t13, tVar.W(n13), i12 + 5, fVar.l());
        }
        t N2 = tVar.N(tVar.O(i11));
        if (q(i11)) {
            int n14 = n(i11);
            Object t14 = t(n14);
            int i13 = i12 + 5;
            if (!N2.k(t14 != null ? t14.hashCode() : 0, t14, i13)) {
                return N2.D(t14 != null ? t14.hashCode() : 0, t14, W(n14), i13, fVar);
            }
            bVar.c(bVar.a() + 1);
        }
        return N2;
    }

    private final t I(int i11, int i12, f fVar) {
        fVar.p(fVar.size() - 1);
        fVar.n(W(i11));
        if (this.f76645d.length == 2) {
            return null;
        }
        if (this.f76644c != fVar.l()) {
            return new t(i12 ^ this.f76642a, this.f76643b, x.b(this.f76645d, i11), fVar.l());
        }
        this.f76645d = x.b(this.f76645d, i11);
        this.f76642a ^= i12;
        return this;
    }

    private final t J(int i11, int i12, w.e eVar) {
        Object[] objArr = this.f76645d;
        if (objArr.length == 1) {
            return null;
        }
        if (this.f76644c != eVar) {
            return new t(this.f76642a, i12 ^ this.f76643b, x.c(objArr, i11), eVar);
        }
        this.f76645d = x.c(objArr, i11);
        this.f76643b ^= i12;
        return this;
    }

    private final t K(t tVar, t tVar2, int i11, int i12, w.e eVar) {
        return tVar2 == null ? J(i11, i12, eVar) : (this.f76644c == eVar || tVar != tVar2) ? L(i11, tVar2, eVar) : this;
    }

    private final t L(int i11, t tVar, w.e eVar) {
        Object[] objArr = this.f76645d;
        if (objArr.length == 1 && tVar.f76645d.length == 2 && tVar.f76643b == 0) {
            tVar.f76642a = this.f76643b;
            return tVar;
        }
        if (this.f76644c == eVar) {
            objArr[i11] = tVar;
            return this;
        }
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        copyOf[i11] = tVar;
        return new t(this.f76642a, this.f76643b, copyOf, eVar);
    }

    private final t M(int i11, Object obj, f fVar) {
        if (this.f76644c == fVar.l()) {
            this.f76645d[i11 + 1] = obj;
            return this;
        }
        fVar.m(fVar.i() + 1);
        Object[] objArr = this.f76645d;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        copyOf[i11 + 1] = obj;
        return new t(this.f76642a, this.f76643b, copyOf, fVar.l());
    }

    private final t R(int i11, int i12) {
        Object[] objArr = this.f76645d;
        if (objArr.length == 2) {
            return null;
        }
        return new t(i12 ^ this.f76642a, this.f76643b, x.b(objArr, i11));
    }

    private final t S(int i11, int i12) {
        Object[] objArr = this.f76645d;
        if (objArr.length == 1) {
            return null;
        }
        return new t(this.f76642a, i12 ^ this.f76643b, x.c(objArr, i11));
    }

    private final t T(t tVar, t tVar2, int i11, int i12) {
        return tVar2 == null ? S(i11, i12) : tVar != tVar2 ? U(i11, i12, tVar2) : this;
    }

    private final t U(int i11, int i12, t tVar) {
        Object[] objArr = tVar.f76645d;
        if (objArr.length != 2 || tVar.f76643b != 0) {
            Object[] objArr2 = this.f76645d;
            Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            copyOf[i11] = tVar;
            return new t(this.f76642a, this.f76643b, copyOf);
        }
        if (this.f76645d.length == 1) {
            tVar.f76642a = this.f76643b;
            return tVar;
        }
        return new t(this.f76642a ^ i12, i12 ^ this.f76643b, x.e(this.f76645d, i11, n(i12), objArr[0], objArr[1]));
    }

    private final t V(int i11, Object obj) {
        Object[] objArr = this.f76645d;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.g(copyOf, "copyOf(this, size)");
        copyOf[i11 + 1] = obj;
        return new t(this.f76642a, this.f76643b, copyOf);
    }

    private final Object W(int i11) {
        return this.f76645d[i11 + 1];
    }

    private final b b() {
        return new b(this, 1);
    }

    private final b c() {
        return new b(this, 0);
    }

    private final Object[] d(int i11, int i12, int i13, Object obj, Object obj2, int i14, w.e eVar) {
        Object t11 = t(i11);
        return x.d(this.f76645d, i11, O(i12) + 1, u(t11 != null ? t11.hashCode() : 0, t11, W(i11), i13, obj, obj2, i14 + 5, eVar));
    }

    private final int e() {
        if (this.f76643b == 0) {
            return this.f76645d.length / 2;
        }
        int bitCount = Integer.bitCount(this.f76642a);
        int length = this.f76645d.length;
        for (int i11 = bitCount * 2; i11 < length; i11++) {
            bitCount += N(i11).e();
        }
        return bitCount;
    }

    private final boolean f(Object obj) {
        IntProgression s11 = RangesKt.s(RangesKt.t(0, this.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.c(obj, this.f76645d[first])) {
                if (first != last) {
                    first += step;
                }
            }
            return true;
        }
        return false;
    }

    private final Object g(Object obj) {
        IntProgression s11 = RangesKt.s(RangesKt.t(0, this.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return null;
        }
        while (!Intrinsics.c(obj, t(first))) {
            if (first == last) {
                return null;
            }
            first += step;
        }
        return W(first);
    }

    private final b h(Object obj, Object obj2) {
        IntProgression s11 = RangesKt.s(RangesKt.t(0, this.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.c(obj, t(first))) {
                if (first != last) {
                    first += step;
                }
            }
            if (obj2 == W(first)) {
                return null;
            }
            Object[] objArr = this.f76645d;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.g(copyOf, "copyOf(this, size)");
            copyOf[first + 1] = obj2;
            return new t(0, 0, copyOf).c();
        }
        return new t(0, 0, x.a(this.f76645d, 0, obj, obj2)).b();
    }

    private final t i(Object obj) {
        IntProgression s11 = RangesKt.s(RangesKt.t(0, this.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.c(obj, t(first))) {
                if (first != last) {
                    first += step;
                }
            }
            return j(first);
        }
        return this;
    }

    private final t j(int i11) {
        Object[] objArr = this.f76645d;
        if (objArr.length == 2) {
            return null;
        }
        return new t(0, 0, x.b(objArr, i11));
    }

    private final boolean l(t tVar) {
        if (this == tVar) {
            return true;
        }
        if (this.f76643b != tVar.f76643b || this.f76642a != tVar.f76642a) {
            return false;
        }
        int length = this.f76645d.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.f76645d[i11] != tVar.f76645d[i11]) {
                return false;
            }
        }
        return true;
    }

    private final boolean r(int i11) {
        return (i11 & this.f76643b) != 0;
    }

    private final t s(int i11, Object obj, Object obj2) {
        return new t(i11 | this.f76642a, this.f76643b, x.a(this.f76645d, n(i11), obj, obj2));
    }

    private final Object t(int i11) {
        return this.f76645d[i11];
    }

    private final t u(int i11, Object obj, Object obj2, int i12, Object obj3, Object obj4, int i13, w.e eVar) {
        if (i13 > 30) {
            return new t(0, 0, new Object[]{obj, obj2, obj3, obj4}, eVar);
        }
        int f11 = x.f(i11, i13);
        int f12 = x.f(i12, i13);
        if (f11 != f12) {
            return new t((1 << f11) | (1 << f12), 0, f11 < f12 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, eVar);
        }
        return new t(0, 1 << f11, new Object[]{u(i11, obj, obj2, i12, obj3, obj4, i13 + 5, eVar)}, eVar);
    }

    private final t v(int i11, int i12, int i13, Object obj, Object obj2, int i14) {
        return new t(this.f76642a ^ i12, i12 | this.f76643b, d(i11, i12, i13, obj, obj2, i14, null));
    }

    private final t w(Object obj, Object obj2, f fVar) {
        IntProgression s11 = RangesKt.s(RangesKt.t(0, this.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.c(obj, t(first))) {
                if (first != last) {
                    first += step;
                }
            }
            fVar.n(W(first));
            if (this.f76644c == fVar.l()) {
                this.f76645d[first + 1] = obj2;
                return this;
            }
            fVar.m(fVar.i() + 1);
            Object[] objArr = this.f76645d;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.g(copyOf, "copyOf(this, size)");
            copyOf[first + 1] = obj2;
            return new t(0, 0, copyOf, fVar.l());
        }
        fVar.p(fVar.size() + 1);
        return new t(0, 0, x.a(this.f76645d, 0, obj, obj2), fVar.l());
    }

    private final t x(t tVar, w.b bVar, w.e eVar) {
        w.a.a(this.f76643b == 0);
        w.a.a(this.f76642a == 0);
        w.a.a(tVar.f76643b == 0);
        w.a.a(tVar.f76642a == 0);
        Object[] objArr = this.f76645d;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + tVar.f76645d.length);
        Intrinsics.g(copyOf, "copyOf(this, newSize)");
        int length = this.f76645d.length;
        IntProgression s11 = RangesKt.s(RangesKt.t(0, tVar.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                if (f(tVar.f76645d[first])) {
                    bVar.c(bVar.a() + 1);
                } else {
                    Object[] objArr2 = tVar.f76645d;
                    copyOf[length] = objArr2[first];
                    copyOf[length + 1] = objArr2[first + 1];
                    length += 2;
                }
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        if (length == this.f76645d.length) {
            return this;
        }
        if (length == tVar.f76645d.length) {
            return tVar;
        }
        if (length == copyOf.length) {
            return new t(0, 0, copyOf, eVar);
        }
        Object[] copyOf2 = Arrays.copyOf(copyOf, length);
        Intrinsics.g(copyOf2, "copyOf(this, newSize)");
        return new t(0, 0, copyOf2, eVar);
    }

    private final t y(Object obj, Object obj2, f fVar) {
        IntProgression s11 = RangesKt.s(RangesKt.t(0, this.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (true) {
                if (!Intrinsics.c(obj, t(first)) || !Intrinsics.c(obj2, W(first))) {
                    if (first == last) {
                        break;
                    }
                    first += step;
                } else {
                    return A(first, fVar);
                }
            }
        }
        return this;
    }

    private final t z(Object obj, f fVar) {
        IntProgression s11 = RangesKt.s(RangesKt.t(0, this.f76645d.length), 2);
        int first = s11.getFirst();
        int last = s11.getLast();
        int step = s11.getStep();
        if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
            while (!Intrinsics.c(obj, t(first))) {
                if (first != last) {
                    first += step;
                }
            }
            return A(first, fVar);
        }
        return this;
    }

    public final t D(int i11, Object obj, Object obj2, int i12, f fVar) {
        int f11 = 1 << x.f(i11, i12);
        if (q(f11)) {
            int n11 = n(f11);
            if (Intrinsics.c(obj, t(n11))) {
                fVar.n(W(n11));
                return W(n11) == obj2 ? this : M(n11, obj2, fVar);
            }
            fVar.p(fVar.size() + 1);
            return C(n11, f11, i11, obj, obj2, i12, fVar.l());
        }
        if (!r(f11)) {
            fVar.p(fVar.size() + 1);
            return B(f11, obj, obj2, fVar.l());
        }
        int O = O(f11);
        t N = N(O);
        t w11 = i12 == 30 ? N.w(obj, obj2, fVar) : N.D(i11, obj, obj2, i12 + 5, fVar);
        return N == w11 ? this : L(O, w11, fVar.l());
    }

    public final t E(t tVar, int i11, w.b bVar, f fVar) {
        if (this == tVar) {
            bVar.b(e());
            return this;
        }
        if (i11 > 30) {
            return x(tVar, bVar, fVar.l());
        }
        int i12 = this.f76643b | tVar.f76643b;
        int i13 = this.f76642a;
        int i14 = tVar.f76642a;
        int i15 = (i13 ^ i14) & (~i12);
        int i16 = i13 & i14;
        int i17 = i15;
        while (i16 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i16);
            if (Intrinsics.c(t(n(lowestOneBit)), tVar.t(tVar.n(lowestOneBit)))) {
                i17 |= lowestOneBit;
            } else {
                i12 |= lowestOneBit;
            }
            i16 ^= lowestOneBit;
        }
        int i18 = 0;
        if (!((i12 & i17) == 0)) {
            o1.b("Check failed.");
        }
        t tVar2 = (Intrinsics.c(this.f76644c, fVar.l()) && this.f76642a == i17 && this.f76643b == i12) ? this : new t(i17, i12, new Object[(Integer.bitCount(i17) * 2) + Integer.bitCount(i12)]);
        int i19 = i12;
        int i20 = 0;
        while (i19 != 0) {
            int lowestOneBit2 = Integer.lowestOneBit(i19);
            Object[] objArr = tVar2.f76645d;
            objArr[(objArr.length - 1) - i20] = F(tVar, lowestOneBit2, i11, bVar, fVar);
            i20++;
            i19 ^= lowestOneBit2;
        }
        while (i17 != 0) {
            int lowestOneBit3 = Integer.lowestOneBit(i17);
            int i21 = i18 * 2;
            if (tVar.q(lowestOneBit3)) {
                int n11 = tVar.n(lowestOneBit3);
                tVar2.f76645d[i21] = tVar.t(n11);
                tVar2.f76645d[i21 + 1] = tVar.W(n11);
                if (q(lowestOneBit3)) {
                    bVar.c(bVar.a() + 1);
                }
            } else {
                int n12 = n(lowestOneBit3);
                tVar2.f76645d[i21] = t(n12);
                tVar2.f76645d[i21 + 1] = W(n12);
            }
            i18++;
            i17 ^= lowestOneBit3;
        }
        return l(tVar2) ? this : tVar.l(tVar2) ? tVar : tVar2;
    }

    public final t G(int i11, Object obj, int i12, f fVar) {
        int f11 = 1 << x.f(i11, i12);
        if (q(f11)) {
            int n11 = n(f11);
            return Intrinsics.c(obj, t(n11)) ? I(n11, f11, fVar) : this;
        }
        if (!r(f11)) {
            return this;
        }
        int O = O(f11);
        t N = N(O);
        return K(N, i12 == 30 ? N.z(obj, fVar) : N.G(i11, obj, i12 + 5, fVar), O, f11, fVar.l());
    }

    public final t H(int i11, Object obj, Object obj2, int i12, f fVar) {
        int f11 = 1 << x.f(i11, i12);
        if (q(f11)) {
            int n11 = n(f11);
            return (Intrinsics.c(obj, t(n11)) && Intrinsics.c(obj2, W(n11))) ? I(n11, f11, fVar) : this;
        }
        if (!r(f11)) {
            return this;
        }
        int O = O(f11);
        t N = N(O);
        return K(N, i12 == 30 ? N.y(obj, obj2, fVar) : N.H(i11, obj, obj2, i12 + 5, fVar), O, f11, fVar.l());
    }

    public final t N(int i11) {
        Object obj = this.f76645d[i11];
        Intrinsics.f(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (t) obj;
    }

    public final int O(int i11) {
        return (this.f76645d.length - 1) - Integer.bitCount((i11 - 1) & this.f76643b);
    }

    public final b P(int i11, Object obj, Object obj2, int i12) {
        b P;
        int f11 = 1 << x.f(i11, i12);
        if (q(f11)) {
            int n11 = n(f11);
            if (!Intrinsics.c(obj, t(n11))) {
                return v(n11, f11, i11, obj, obj2, i12).b();
            }
            if (W(n11) == obj2) {
                return null;
            }
            return V(n11, obj2).c();
        }
        if (!r(f11)) {
            return s(f11, obj, obj2).b();
        }
        int O = O(f11);
        t N = N(O);
        if (i12 == 30) {
            P = N.h(obj, obj2);
            if (P == null) {
                return null;
            }
        } else {
            P = N.P(i11, obj, obj2, i12 + 5);
            if (P == null) {
                return null;
            }
        }
        P.c(U(O, f11, P.a()));
        return P;
    }

    public final t Q(int i11, Object obj, int i12) {
        int f11 = 1 << x.f(i11, i12);
        if (q(f11)) {
            int n11 = n(f11);
            return Intrinsics.c(obj, t(n11)) ? R(n11, f11) : this;
        }
        if (!r(f11)) {
            return this;
        }
        int O = O(f11);
        t N = N(O);
        return T(N, i12 == 30 ? N.i(obj) : N.Q(i11, obj, i12 + 5), O, f11);
    }

    public final boolean k(int i11, Object obj, int i12) {
        int f11 = 1 << x.f(i11, i12);
        if (q(f11)) {
            return Intrinsics.c(obj, t(n(f11)));
        }
        if (!r(f11)) {
            return false;
        }
        t N = N(O(f11));
        return i12 == 30 ? N.f(obj) : N.k(i11, obj, i12 + 5);
    }

    public final int m() {
        return Integer.bitCount(this.f76642a);
    }

    public final int n(int i11) {
        return Integer.bitCount((i11 - 1) & this.f76642a) * 2;
    }

    public final Object o(int i11, Object obj, int i12) {
        int f11 = 1 << x.f(i11, i12);
        if (q(f11)) {
            int n11 = n(f11);
            if (Intrinsics.c(obj, t(n11))) {
                return W(n11);
            }
            return null;
        }
        if (!r(f11)) {
            return null;
        }
        t N = N(O(f11));
        return i12 == 30 ? N.g(obj) : N.o(i11, obj, i12 + 5);
    }

    public final Object[] p() {
        return this.f76645d;
    }

    public final boolean q(int i11) {
        return (i11 & this.f76642a) != 0;
    }
}
