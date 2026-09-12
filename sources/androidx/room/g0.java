package androidx.room;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class g0 implements a4.g, a4.f {

    /* renamed from: i, reason: collision with root package name */
    public static final a f14767i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    public static final TreeMap f14768j = new TreeMap();

    /* renamed from: a, reason: collision with root package name */
    private final int f14769a;

    /* renamed from: b, reason: collision with root package name */
    private volatile String f14770b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f14771c;

    /* renamed from: d, reason: collision with root package name */
    public final double[] f14772d;

    /* renamed from: e, reason: collision with root package name */
    public final String[] f14773e;

    /* renamed from: f, reason: collision with root package name */
    public final byte[][] f14774f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f14775g;

    /* renamed from: h, reason: collision with root package name */
    private int f14776h;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final g0 a(String query, int i11) {
            Intrinsics.h(query, "query");
            TreeMap treeMap = g0.f14768j;
            synchronized (treeMap) {
                Map.Entry ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i11));
                if (ceilingEntry == null) {
                    Unit unit = Unit.f67184a;
                    g0 g0Var = new g0(i11, null);
                    g0Var.l(query, i11);
                    return g0Var;
                }
                treeMap.remove(ceilingEntry.getKey());
                g0 g0Var2 = (g0) ceilingEntry.getValue();
                g0Var2.l(query, i11);
                Intrinsics.e(g0Var2);
                return g0Var2;
            }
        }

        public final void b() {
            TreeMap treeMap = g0.f14768j;
            if (treeMap.size() <= 15) {
                return;
            }
            int size = treeMap.size() - 10;
            Iterator it = treeMap.descendingKeySet().iterator();
            Intrinsics.g(it, "iterator(...)");
            while (true) {
                int i11 = size - 1;
                if (size <= 0) {
                    return;
                }
                it.next();
                it.remove();
                size = i11;
            }
        }
    }

    private g0(int i11) {
        this.f14769a = i11;
        int i12 = i11 + 1;
        this.f14775g = new int[i12];
        this.f14771c = new long[i12];
        this.f14772d = new double[i12];
        this.f14773e = new String[i12];
        this.f14774f = new byte[i12];
    }

    public /* synthetic */ g0(int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11);
    }

    public static final g0 h(String str, int i11) {
        return f14767i.a(str, i11);
    }

    @Override // a4.f
    public void a(int i11, double d11) {
        this.f14775g[i11] = 3;
        this.f14772d[i11] = d11;
    }

    @Override // a4.g
    public void b(a4.f statement) {
        Intrinsics.h(statement, "statement");
        int k11 = k();
        if (1 > k11) {
            return;
        }
        int i11 = 1;
        while (true) {
            int i12 = this.f14775g[i11];
            if (i12 == 1) {
                statement.g(i11);
            } else if (i12 == 2) {
                statement.c(i11, this.f14771c[i11]);
            } else if (i12 == 3) {
                statement.a(i11, this.f14772d[i11]);
            } else if (i12 == 4) {
                String str = this.f14773e[i11];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.y(i11, str);
            } else if (i12 == 5) {
                byte[] bArr = this.f14774f[i11];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                statement.e(i11, bArr);
            }
            if (i11 == k11) {
                return;
            } else {
                i11++;
            }
        }
    }

    @Override // a4.f
    public void c(int i11, long j11) {
        this.f14775g[i11] = 2;
        this.f14771c[i11] = j11;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // a4.g
    public String d() {
        String str = this.f14770b;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // a4.f
    public void e(int i11, byte[] value) {
        Intrinsics.h(value, "value");
        this.f14775g[i11] = 5;
        this.f14774f[i11] = value;
    }

    @Override // a4.f
    public void g(int i11) {
        this.f14775g[i11] = 1;
    }

    public int k() {
        return this.f14776h;
    }

    public final void l(String query, int i11) {
        Intrinsics.h(query, "query");
        this.f14770b = query;
        this.f14776h = i11;
    }

    public final void release() {
        TreeMap treeMap = f14768j;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.f14769a), this);
            f14767i.b();
            Unit unit = Unit.f67184a;
        }
    }

    @Override // a4.f
    public void y(int i11, String value) {
        Intrinsics.h(value, "value");
        this.f14775g[i11] = 4;
        this.f14773e[i11] = value;
    }
}
