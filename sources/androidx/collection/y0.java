package androidx.collection;

import java.util.Arrays;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public class y0 implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ boolean f2438a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ int[] f2439b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object[] f2440c;

    /* renamed from: d, reason: collision with root package name */
    public /* synthetic */ int f2441d;

    @JvmOverloads
    public y0() {
        this(0, 1, null);
    }

    public y0(int i11) {
        if (i11 == 0) {
            this.f2439b = n.a.f70174a;
            this.f2440c = n.a.f70176c;
        } else {
            int e11 = n.a.e(i11);
            this.f2439b = new int[e11];
            this.f2440c = new Object[e11];
        }
    }

    public /* synthetic */ y0(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 10 : i11);
    }

    public void a(int i11, Object obj) {
        int i12 = this.f2441d;
        if (i12 != 0 && i11 <= this.f2439b[i12 - 1]) {
            l(i11, obj);
            return;
        }
        if (this.f2438a && i12 >= this.f2439b.length) {
            z0.f(this);
        }
        int i13 = this.f2441d;
        if (i13 >= this.f2439b.length) {
            int e11 = n.a.e(i13 + 1);
            int[] copyOf = Arrays.copyOf(this.f2439b, e11);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f2439b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f2440c, e11);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f2440c = copyOf2;
        }
        this.f2439b[i13] = i11;
        this.f2440c[i13] = obj;
        this.f2441d = i13 + 1;
    }

    public void b() {
        int i11 = this.f2441d;
        Object[] objArr = this.f2440c;
        for (int i12 = 0; i12 < i11; i12++) {
            objArr[i12] = null;
        }
        this.f2441d = 0;
        this.f2438a = false;
    }

    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public y0 clone() {
        Object clone = super.clone();
        Intrinsics.f(clone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        y0 y0Var = (y0) clone;
        y0Var.f2439b = (int[]) this.f2439b.clone();
        y0Var.f2440c = (Object[]) this.f2440c.clone();
        return y0Var;
    }

    public boolean d(int i11) {
        return i(i11) >= 0;
    }

    public boolean e(Object obj) {
        if (this.f2438a) {
            z0.f(this);
        }
        int i11 = this.f2441d;
        int i12 = 0;
        while (true) {
            if (i12 >= i11) {
                i12 = -1;
                break;
            }
            if (this.f2440c[i12] == obj) {
                break;
            }
            i12++;
        }
        return i12 >= 0;
    }

    public Object f(int i11) {
        return z0.c(this, i11);
    }

    public Object g(int i11, Object obj) {
        return z0.d(this, i11, obj);
    }

    public int i(int i11) {
        if (this.f2438a) {
            z0.f(this);
        }
        return n.a.a(this.f2439b, this.f2441d, i11);
    }

    public int j(Object obj) {
        if (this.f2438a) {
            z0.f(this);
        }
        int i11 = this.f2441d;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.f2440c[i12] == obj) {
                return i12;
            }
        }
        return -1;
    }

    public int k(int i11) {
        if (this.f2438a) {
            z0.f(this);
        }
        return this.f2439b[i11];
    }

    public void l(int i11, Object obj) {
        Object obj2;
        int a11 = n.a.a(this.f2439b, this.f2441d, i11);
        if (a11 >= 0) {
            this.f2440c[a11] = obj;
            return;
        }
        int i12 = ~a11;
        if (i12 < this.f2441d) {
            Object obj3 = this.f2440c[i12];
            obj2 = z0.f2442a;
            if (obj3 == obj2) {
                this.f2439b[i12] = i11;
                this.f2440c[i12] = obj;
                return;
            }
        }
        if (this.f2438a && this.f2441d >= this.f2439b.length) {
            z0.f(this);
            i12 = ~n.a.a(this.f2439b, this.f2441d, i11);
        }
        int i13 = this.f2441d;
        if (i13 >= this.f2439b.length) {
            int e11 = n.a.e(i13 + 1);
            int[] copyOf = Arrays.copyOf(this.f2439b, e11);
            Intrinsics.g(copyOf, "copyOf(this, newSize)");
            this.f2439b = copyOf;
            Object[] copyOf2 = Arrays.copyOf(this.f2440c, e11);
            Intrinsics.g(copyOf2, "copyOf(this, newSize)");
            this.f2440c = copyOf2;
        }
        int i14 = this.f2441d;
        if (i14 - i12 != 0) {
            int[] iArr = this.f2439b;
            int i15 = i12 + 1;
            ArraysKt.l(iArr, iArr, i15, i12, i14);
            Object[] objArr = this.f2440c;
            ArraysKt.n(objArr, objArr, i15, i12, this.f2441d);
        }
        this.f2439b[i12] = i11;
        this.f2440c[i12] = obj;
        this.f2441d++;
    }

    public void m(int i11) {
        z0.e(this, i11);
    }

    public void n(int i11) {
        Object obj;
        Object obj2;
        Object obj3 = this.f2440c[i11];
        obj = z0.f2442a;
        if (obj3 != obj) {
            Object[] objArr = this.f2440c;
            obj2 = z0.f2442a;
            objArr[i11] = obj2;
            this.f2438a = true;
        }
    }

    public Object o(int i11, Object obj) {
        int i12 = i(i11);
        if (i12 < 0) {
            return null;
        }
        Object[] objArr = this.f2440c;
        Object obj2 = objArr[i12];
        objArr[i12] = obj;
        return obj2;
    }

    public int p() {
        if (this.f2438a) {
            z0.f(this);
        }
        return this.f2441d;
    }

    public Object q(int i11) {
        if (this.f2438a) {
            z0.f(this);
        }
        return this.f2440c[i11];
    }

    public String toString() {
        if (p() <= 0) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(this.f2441d * 28);
        sb2.append('{');
        int i11 = this.f2441d;
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 > 0) {
                sb2.append(", ");
            }
            sb2.append(k(i12));
            sb2.append('=');
            Object q11 = q(i12);
            if (q11 != this) {
                sb2.append(q11);
            } else {
                sb2.append("(this Map)");
            }
        }
        sb2.append('}');
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "buffer.toString()");
        return sb3;
    }
}
