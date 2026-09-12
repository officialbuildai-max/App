package androidx.media3.exoplayer;

import androidx.media3.common.e0;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class u3 extends androidx.media3.exoplayer.a {

    /* renamed from: h, reason: collision with root package name */
    private final int f13020h;

    /* renamed from: i, reason: collision with root package name */
    private final int f13021i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f13022j;

    /* renamed from: k, reason: collision with root package name */
    private final int[] f13023k;

    /* renamed from: l, reason: collision with root package name */
    private final androidx.media3.common.e0[] f13024l;

    /* renamed from: m, reason: collision with root package name */
    private final Object[] f13025m;

    /* renamed from: n, reason: collision with root package name */
    private final HashMap f13026n;

    /* loaded from: classes2.dex */
    class a extends androidx.media3.exoplayer.source.m {

        /* renamed from: f, reason: collision with root package name */
        private final e0.c f13027f;

        a(androidx.media3.common.e0 e0Var) {
            super(e0Var);
            this.f13027f = new e0.c();
        }

        @Override // androidx.media3.exoplayer.source.m, androidx.media3.common.e0
        public e0.b g(int i11, e0.b bVar, boolean z10) {
            e0.b g11 = super.g(i11, bVar, z10);
            if (super.n(g11.f10018c, this.f13027f).f()) {
                g11.u(bVar.f10016a, bVar.f10017b, bVar.f10018c, bVar.f10019d, bVar.f10020e, androidx.media3.common.b.f9955g, true);
            } else {
                g11.f10021f = true;
            }
            return g11;
        }
    }

    public u3(Collection collection, g2.v vVar) {
        this(G(collection), H(collection), vVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private u3(androidx.media3.common.e0[] e0VarArr, Object[] objArr, g2.v vVar) {
        super(false, vVar);
        int i11 = 0;
        int length = e0VarArr.length;
        this.f13024l = e0VarArr;
        this.f13022j = new int[length];
        this.f13023k = new int[length];
        this.f13025m = objArr;
        this.f13026n = new HashMap();
        int length2 = e0VarArr.length;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i11 < length2) {
            androidx.media3.common.e0 e0Var = e0VarArr[i11];
            this.f13024l[i14] = e0Var;
            this.f13023k[i14] = i12;
            this.f13022j[i14] = i13;
            i12 += e0Var.p();
            i13 += this.f13024l[i14].i();
            this.f13026n.put(objArr[i14], Integer.valueOf(i14));
            i11++;
            i14++;
        }
        this.f13020h = i12;
        this.f13021i = i13;
    }

    private static androidx.media3.common.e0[] G(Collection collection) {
        androidx.media3.common.e0[] e0VarArr = new androidx.media3.common.e0[collection.size()];
        Iterator it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            e0VarArr[i11] = ((c3) it.next()).b();
            i11++;
        }
        return e0VarArr;
    }

    private static Object[] H(Collection collection) {
        Object[] objArr = new Object[collection.size()];
        Iterator it = collection.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            objArr[i11] = ((c3) it.next()).a();
            i11++;
        }
        return objArr;
    }

    @Override // androidx.media3.exoplayer.a
    protected int A(int i11) {
        return this.f13023k[i11];
    }

    @Override // androidx.media3.exoplayer.a
    protected androidx.media3.common.e0 D(int i11) {
        return this.f13024l[i11];
    }

    public u3 E(g2.v vVar) {
        androidx.media3.common.e0[] e0VarArr = new androidx.media3.common.e0[this.f13024l.length];
        int i11 = 0;
        while (true) {
            androidx.media3.common.e0[] e0VarArr2 = this.f13024l;
            if (i11 >= e0VarArr2.length) {
                return new u3(e0VarArr, this.f13025m, vVar);
            }
            e0VarArr[i11] = new a(e0VarArr2[i11]);
            i11++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List F() {
        return Arrays.asList(this.f13024l);
    }

    @Override // androidx.media3.common.e0
    public int i() {
        return this.f13021i;
    }

    @Override // androidx.media3.common.e0
    public int p() {
        return this.f13020h;
    }

    @Override // androidx.media3.exoplayer.a
    protected int s(Object obj) {
        Integer num = (Integer) this.f13026n.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // androidx.media3.exoplayer.a
    protected int t(int i11) {
        return androidx.media3.common.util.a1.g(this.f13022j, i11 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.a
    protected int u(int i11) {
        return androidx.media3.common.util.a1.g(this.f13023k, i11 + 1, false, false);
    }

    @Override // androidx.media3.exoplayer.a
    protected Object x(int i11) {
        return this.f13025m[i11];
    }

    @Override // androidx.media3.exoplayer.a
    protected int z(int i11) {
        return this.f13022j[i11];
    }
}
