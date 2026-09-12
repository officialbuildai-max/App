package androidx.collection;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class x implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f2433a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ long[] f2434b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f2435c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f2436d;

    @JvmOverloads
    public x() {
        this(0, 1, null);
    }

    public x(int i11) {
        if (i11 == 0) {
            this.f2434b = n.a.f70175b;
            this.f2435c = n.a.f70176c;
        } else {
            int f11 = n.a.f(i11);
            this.f2434b = new long[f11];
            this.f2435c = new Object[f11];
        }
    }

    public /* synthetic */ x(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 10 : i11);
    }

    public void a(long j11, Object obj) {
        Object obj2;
        int i11 = this.f2436d;
        if (i11 != 0 && j11 <= this.f2434b[i11 - 1]) {
            k(j11, obj);
            return;
        }
        if (this.f2433a) {
            long[] jArr = this.f2434b;
            if (i11 >= jArr.length) {
                Object[] objArr = this.f2435c;
                int i12 = 0;
                for (int i13 = 0; i13 < i11; i13++) {
                    Object obj3 = objArr[i13];
                    obj2 = y.f2437a;
                    if (obj3 != obj2) {
                        if (i13 != i12) {
                            jArr[i12] = jArr[i13];
                            objArr[i12] = obj3;
                            objArr[i13] = null;
                        }
                        i12++;
                    }
                }
                this.f2433a = false;
                this.f2436d = i12;
            }
        }
        int i14 = this.f2436d;
        if (i14 >= this.f2434b.length) {
            int f11 = n.a.f(i14 + 1);
            long[] copyOf = Arrays.copyOf(this.f2434b, f11);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f2434b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f2435c, f11);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f2435c = copyOf2;
        }
        this.f2434b[i14] = j11;
        this.f2435c[i14] = obj;
        this.f2436d = i14 + 1;
    }

    public void b() {
        int i11 = this.f2436d;
        Object[] objArr = this.f2435c;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.f2436d = 0;
        this.f2433a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public x clone() {
        Object clone = super.clone();
        Intrinsics.f(clone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        x xVar = (x) clone;
        xVar.f2434b = (long[]) this.f2434b.clone();
        xVar.f2435c = (Object[]) this.f2435c.clone();
        return xVar;
    }

    public boolean d(long j11) {
        return g(j11) >= 0;
    }

    public Object e(long j11) {
        Object obj;
        int b11 = n.a.b(this.f2434b, this.f2436d, j11);
        if (b11 >= 0) {
            Object obj2 = this.f2435c[b11];
            obj = y.f2437a;
            if (obj2 != obj) {
                return this.f2435c[b11];
            }
        }
        return null;
    }

    public Object f(long j11, Object obj) {
        Object obj2;
        int b11 = n.a.b(this.f2434b, this.f2436d, j11);
        if (b11 < 0) {
            return obj;
        }
        Object obj3 = this.f2435c[b11];
        obj2 = y.f2437a;
        return obj3 == obj2 ? obj : this.f2435c[b11];
    }

    public int g(long j11) {
        Object obj;
        if (this.f2433a) {
            int i11 = this.f2436d;
            long[] jArr = this.f2434b;
            Object[] objArr = this.f2435c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj2 = objArr[i13];
                obj = y.f2437a;
                if (obj2 != obj) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj2;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f2433a = false;
            this.f2436d = i12;
        }
        return n.a.b(this.f2434b, this.f2436d, j11);
    }

    public boolean i() {
        return n() == 0;
    }

    public long j(int i11) {
        Object obj;
        if (!(i11 >= 0 && i11 < this.f2436d)) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        if (this.f2433a) {
            int i12 = this.f2436d;
            long[] jArr = this.f2434b;
            Object[] objArr = this.f2435c;
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                Object obj2 = objArr[i14];
                obj = y.f2437a;
                if (obj2 != obj) {
                    if (i14 != i13) {
                        jArr[i13] = jArr[i14];
                        objArr[i13] = obj2;
                        objArr[i14] = null;
                    }
                    i13++;
                }
            }
            this.f2433a = false;
            this.f2436d = i13;
        }
        return this.f2434b[i11];
    }

    public void k(long j11, Object obj) {
        Object obj2;
        Object obj3;
        int b11 = n.a.b(this.f2434b, this.f2436d, j11);
        if (b11 >= 0) {
            this.f2435c[b11] = obj;
            return;
        }
        int i11 = ~b11;
        if (i11 < this.f2436d) {
            Object obj4 = this.f2435c[i11];
            obj3 = y.f2437a;
            if (obj4 == obj3) {
                this.f2434b[i11] = j11;
                this.f2435c[i11] = obj;
                return;
            }
        }
        if (this.f2433a) {
            int i12 = this.f2436d;
            long[] jArr = this.f2434b;
            if (i12 >= jArr.length) {
                Object[] objArr = this.f2435c;
                int i13 = 0;
                for (int i14 = 0; i14 < i12; i14++) {
                    Object obj5 = objArr[i14];
                    obj2 = y.f2437a;
                    if (obj5 != obj2) {
                        if (i14 != i13) {
                            jArr[i13] = jArr[i14];
                            objArr[i13] = obj5;
                            objArr[i14] = null;
                        }
                        i13++;
                    }
                }
                this.f2433a = false;
                this.f2436d = i13;
                i11 = ~n.a.b(this.f2434b, i13, j11);
            }
        }
        int i15 = this.f2436d;
        if (i15 >= this.f2434b.length) {
            int f11 = n.a.f(i15 + 1);
            long[] copyOf = Arrays.copyOf(this.f2434b, f11);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f2434b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f2435c, f11);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f2435c = copyOf2;
        }
        int i16 = this.f2436d;
        if (i16 - i11 != 0) {
            long[] jArr2 = this.f2434b;
            int i17 = i11 + 1;
            ArraysKt.m(jArr2, jArr2, i17, i11, i16);
            Object[] objArr2 = this.f2435c;
            ArraysKt.n(objArr2, objArr2, i17, i11, this.f2436d);
        }
        this.f2434b[i11] = j11;
        this.f2435c[i11] = obj;
        this.f2436d++;
    }

    public void l(long j11) {
        Object obj;
        Object obj2;
        int b11 = n.a.b(this.f2434b, this.f2436d, j11);
        if (b11 >= 0) {
            Object obj3 = this.f2435c[b11];
            obj = y.f2437a;
            if (obj3 != obj) {
                Object[] objArr = this.f2435c;
                obj2 = y.f2437a;
                objArr[b11] = obj2;
                this.f2433a = true;
            }
        }
    }

    public void m(int i11) {
        Object obj;
        Object obj2;
        Object obj3 = this.f2435c[i11];
        obj = y.f2437a;
        if (obj3 != obj) {
            Object[] objArr = this.f2435c;
            obj2 = y.f2437a;
            objArr[i11] = obj2;
            this.f2433a = true;
        }
    }

    public int n() {
        Object obj;
        if (this.f2433a) {
            int i11 = this.f2436d;
            long[] jArr = this.f2434b;
            Object[] objArr = this.f2435c;
            int i12 = 0;
            for (int i13 = 0; i13 < i11; i13++) {
                Object obj2 = objArr[i13];
                obj = y.f2437a;
                if (obj2 != obj) {
                    if (i13 != i12) {
                        jArr[i12] = jArr[i13];
                        objArr[i12] = obj2;
                        objArr[i13] = null;
                    }
                    i12++;
                }
            }
            this.f2433a = false;
            this.f2436d = i12;
        }
        return this.f2436d;
    }

    public Object o(int i11) {
        Object obj;
        if (!(i11 >= 0 && i11 < this.f2436d)) {
            n.d.a("Expected index to be within 0..size()-1, but was " + i11);
        }
        if (this.f2433a) {
            int i12 = this.f2436d;
            long[] jArr = this.f2434b;
            Object[] objArr = this.f2435c;
            int i13 = 0;
            for (int i14 = 0; i14 < i12; i14++) {
                Object obj2 = objArr[i14];
                obj = y.f2437a;
                if (obj2 != obj) {
                    if (i14 != i13) {
                        jArr[i13] = jArr[i14];
                        objArr[i13] = obj2;
                        objArr[i14] = null;
                    }
                    i13++;
                }
            }
            this.f2433a = false;
            this.f2436d = i13;
        }
        return this.f2435c[i11];
    }

    public String toString() {
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f2436d * 28);
        sb2.append('{');
        int i11 = this.f2436d;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(j(i12));
            sb2.append('=');
            Object o11 = o(i12);
            if (o11 != sb2) {
                sb2.append(o11);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "StringBuilder(capacity).…builderAction).toString()");
        return sb3;
    }
}
