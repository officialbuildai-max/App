package e9;

import android.util.Base64;
import com.google.android.exoplayer2.k3;
import com.google.android.exoplayer2.source.o;
import e9.c;
import e9.t1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: classes4.dex */
public final class r1 implements t1 {

    /* renamed from: h, reason: collision with root package name */
    public static final com.google.common.base.q f61864h = new com.google.common.base.q() { // from class: e9.q1
        @Override // com.google.common.base.q
        public final Object get() {
            String k11;
            k11 = r1.k();
            return k11;
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final Random f61865i = new Random();

    /* renamed from: a, reason: collision with root package name */
    private final k3.d f61866a;

    /* renamed from: b, reason: collision with root package name */
    private final k3.b f61867b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f61868c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.common.base.q f61869d;

    /* renamed from: e, reason: collision with root package name */
    private t1.a f61870e;

    /* renamed from: f, reason: collision with root package name */
    private k3 f61871f;

    /* renamed from: g, reason: collision with root package name */
    private String f61872g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f61873a;

        /* renamed from: b, reason: collision with root package name */
        private int f61874b;

        /* renamed from: c, reason: collision with root package name */
        private long f61875c;

        /* renamed from: d, reason: collision with root package name */
        private o.b f61876d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f61877e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f61878f;

        public a(String str, int i11, o.b bVar) {
            this.f61873a = str;
            this.f61874b = i11;
            this.f61875c = bVar == null ? -1L : bVar.f76240d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.f61876d = bVar;
        }

        private int l(k3 k3Var, k3 k3Var2, int i11) {
            if (i11 >= k3Var.t()) {
                if (i11 < k3Var2.t()) {
                    return i11;
                }
                return -1;
            }
            k3Var.r(i11, r1.this.f61866a);
            for (int i12 = r1.this.f61866a.f25237o; i12 <= r1.this.f61866a.f25238p; i12++) {
                int f11 = k3Var2.f(k3Var.q(i12));
                if (f11 != -1) {
                    return k3Var2.j(f11, r1.this.f61867b).f25210c;
                }
            }
            return -1;
        }

        public boolean i(int i11, o.b bVar) {
            if (bVar == null) {
                return i11 == this.f61874b;
            }
            o.b bVar2 = this.f61876d;
            return bVar2 == null ? !bVar.b() && bVar.f76240d == this.f61875c : bVar.f76240d == bVar2.f76240d && bVar.f76238b == bVar2.f76238b && bVar.f76239c == bVar2.f76239c;
        }

        public boolean j(c.a aVar) {
            long j11 = this.f61875c;
            if (j11 == -1) {
                return false;
            }
            o.b bVar = aVar.f61741d;
            if (bVar == null) {
                return this.f61874b != aVar.f61740c;
            }
            if (bVar.f76240d > j11) {
                return true;
            }
            if (this.f61876d == null) {
                return false;
            }
            int f11 = aVar.f61739b.f(bVar.f76237a);
            int f12 = aVar.f61739b.f(this.f61876d.f76237a);
            o.b bVar2 = aVar.f61741d;
            if (bVar2.f76240d < this.f61876d.f76240d || f11 < f12) {
                return false;
            }
            if (f11 > f12) {
                return true;
            }
            if (!bVar2.b()) {
                int i11 = aVar.f61741d.f76241e;
                return i11 == -1 || i11 > this.f61876d.f76238b;
            }
            o.b bVar3 = aVar.f61741d;
            int i12 = bVar3.f76238b;
            int i13 = bVar3.f76239c;
            o.b bVar4 = this.f61876d;
            int i14 = bVar4.f76238b;
            return i12 > i14 || (i12 == i14 && i13 > bVar4.f76239c);
        }

        public void k(int i11, o.b bVar) {
            if (this.f61875c == -1 && i11 == this.f61874b && bVar != null) {
                this.f61875c = bVar.f76240d;
            }
        }

        public boolean m(k3 k3Var, k3 k3Var2) {
            int l11 = l(k3Var, k3Var2, this.f61874b);
            this.f61874b = l11;
            if (l11 == -1) {
                return false;
            }
            o.b bVar = this.f61876d;
            return bVar == null || k3Var2.f(bVar.f76237a) != -1;
        }
    }

    public r1() {
        this(f61864h);
    }

    public r1(com.google.common.base.q qVar) {
        this.f61869d = qVar;
        this.f61866a = new k3.d();
        this.f61867b = new k3.b();
        this.f61868c = new HashMap();
        this.f61871f = k3.f25205a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String k() {
        byte[] bArr = new byte[12];
        f61865i.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private a l(int i11, o.b bVar) {
        a aVar = null;
        long j11 = Long.MAX_VALUE;
        for (a aVar2 : this.f61868c.values()) {
            aVar2.k(i11, bVar);
            if (aVar2.i(i11, bVar)) {
                long j12 = aVar2.f61875c;
                if (j12 == -1 || j12 < j11) {
                    aVar = aVar2;
                    j11 = j12;
                } else if (j12 == j11 && ((a) com.google.android.exoplayer2.util.p0.j(aVar)).f61876d != null && aVar2.f61876d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = (String) this.f61869d.get();
        a aVar3 = new a(str, i11, bVar);
        this.f61868c.put(str, aVar3);
        return aVar3;
    }

    private void m(c.a aVar) {
        if (aVar.f61739b.u()) {
            this.f61872g = null;
            return;
        }
        a aVar2 = (a) this.f61868c.get(this.f61872g);
        a l11 = l(aVar.f61740c, aVar.f61741d);
        this.f61872g = l11.f61873a;
        b(aVar);
        o.b bVar = aVar.f61741d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.f61875c == aVar.f61741d.f76240d && aVar2.f61876d != null && aVar2.f61876d.f76238b == aVar.f61741d.f76238b && aVar2.f61876d.f76239c == aVar.f61741d.f76239c) {
            return;
        }
        o.b bVar2 = aVar.f61741d;
        this.f61870e.q(aVar, l(aVar.f61740c, new o.b(bVar2.f76237a, bVar2.f76240d)).f61873a, l11.f61873a);
    }

    @Override // e9.t1
    public synchronized String a() {
        return this.f61872g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0044, code lost:
    
        if (r25.f61741d.f76240d < r2.f61875c) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00df A[Catch: all -> 0x0037, TryCatch #0 {all -> 0x0037, blocks: (B:4:0x0005, B:9:0x0014, B:12:0x0024, B:14:0x002e, B:19:0x003a, B:22:0x0048, B:24:0x0054, B:25:0x005a, B:27:0x005f, B:29:0x0065, B:31:0x007e, B:32:0x00d9, B:34:0x00df, B:35:0x00f5, B:37:0x0101, B:39:0x0107), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f1  */
    @Override // e9.t1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void b(e9.c.a r25) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e9.r1.b(e9.c$a):void");
    }

    @Override // e9.t1
    public synchronized void c(c.a aVar, int i11) {
        try {
            com.google.android.exoplayer2.util.a.e(this.f61870e);
            boolean z10 = i11 == 0;
            Iterator it = this.f61868c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.j(aVar)) {
                    it.remove();
                    if (aVar2.f61877e) {
                        boolean equals = aVar2.f61873a.equals(this.f61872g);
                        boolean z11 = z10 && equals && aVar2.f61878f;
                        if (equals) {
                            this.f61872g = null;
                        }
                        this.f61870e.Q(aVar, aVar2.f61873a, z11);
                    }
                }
            }
            m(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // e9.t1
    public synchronized void d(c.a aVar) {
        try {
            com.google.android.exoplayer2.util.a.e(this.f61870e);
            k3 k3Var = this.f61871f;
            this.f61871f = aVar.f61739b;
            Iterator it = this.f61868c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.m(k3Var, this.f61871f) && !aVar2.j(aVar)) {
                }
                it.remove();
                if (aVar2.f61877e) {
                    if (aVar2.f61873a.equals(this.f61872g)) {
                        this.f61872g = null;
                    }
                    this.f61870e.Q(aVar, aVar2.f61873a, false);
                }
            }
            m(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // e9.t1
    public synchronized void e(c.a aVar) {
        t1.a aVar2;
        this.f61872g = null;
        Iterator it = this.f61868c.values().iterator();
        while (it.hasNext()) {
            a aVar3 = (a) it.next();
            it.remove();
            if (aVar3.f61877e && (aVar2 = this.f61870e) != null) {
                aVar2.Q(aVar, aVar3.f61873a, false);
            }
        }
    }

    @Override // e9.t1
    public synchronized String f(k3 k3Var, o.b bVar) {
        return l(k3Var.l(bVar.f76237a, this.f61867b).f25210c, bVar).f61873a;
    }

    @Override // e9.t1
    public void g(t1.a aVar) {
        this.f61870e = aVar;
    }
}
