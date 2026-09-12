package y1;

import android.util.Base64;
import androidx.media3.common.e0;
import androidx.media3.exoplayer.source.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import y1.c;
import y1.c4;

/* loaded from: classes2.dex */
public final class u1 implements c4 {

    /* renamed from: i, reason: collision with root package name */
    public static final com.google.common.base.q f78884i = new com.google.common.base.q() { // from class: y1.t1
        @Override // com.google.common.base.q
        public final Object get() {
            String m11;
            m11 = u1.m();
            return m11;
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private static final Random f78885j = new Random();

    /* renamed from: a, reason: collision with root package name */
    private final e0.c f78886a;

    /* renamed from: b, reason: collision with root package name */
    private final e0.b f78887b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f78888c;

    /* renamed from: d, reason: collision with root package name */
    private final com.google.common.base.q f78889d;

    /* renamed from: e, reason: collision with root package name */
    private c4.a f78890e;

    /* renamed from: f, reason: collision with root package name */
    private androidx.media3.common.e0 f78891f;

    /* renamed from: g, reason: collision with root package name */
    private String f78892g;

    /* renamed from: h, reason: collision with root package name */
    private long f78893h;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f78894a;

        /* renamed from: b, reason: collision with root package name */
        private int f78895b;

        /* renamed from: c, reason: collision with root package name */
        private long f78896c;

        /* renamed from: d, reason: collision with root package name */
        private r.b f78897d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f78898e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f78899f;

        public a(String str, int i11, r.b bVar) {
            this.f78894a = str;
            this.f78895b = i11;
            this.f78896c = bVar == null ? -1L : bVar.f12968d;
            if (bVar == null || !bVar.b()) {
                return;
            }
            this.f78897d = bVar;
        }

        private int l(androidx.media3.common.e0 e0Var, androidx.media3.common.e0 e0Var2, int i11) {
            if (i11 >= e0Var.p()) {
                if (i11 < e0Var2.p()) {
                    return i11;
                }
                return -1;
            }
            e0Var.n(i11, u1.this.f78886a);
            for (int i12 = u1.this.f78886a.f10046n; i12 <= u1.this.f78886a.f10047o; i12++) {
                int b11 = e0Var2.b(e0Var.m(i12));
                if (b11 != -1) {
                    return e0Var2.f(b11, u1.this.f78887b).f10018c;
                }
            }
            return -1;
        }

        public boolean i(int i11, r.b bVar) {
            if (bVar == null) {
                return i11 == this.f78895b;
            }
            r.b bVar2 = this.f78897d;
            return bVar2 == null ? !bVar.b() && bVar.f12968d == this.f78896c : bVar.f12968d == bVar2.f12968d && bVar.f12966b == bVar2.f12966b && bVar.f12967c == bVar2.f12967c;
        }

        public boolean j(c.a aVar) {
            r.b bVar = aVar.f78736d;
            if (bVar == null) {
                return this.f78895b != aVar.f78735c;
            }
            long j11 = this.f78896c;
            if (j11 == -1) {
                return false;
            }
            if (bVar.f12968d > j11) {
                return true;
            }
            if (this.f78897d == null) {
                return false;
            }
            int b11 = aVar.f78734b.b(bVar.f12965a);
            int b12 = aVar.f78734b.b(this.f78897d.f12965a);
            r.b bVar2 = aVar.f78736d;
            if (bVar2.f12968d < this.f78897d.f12968d || b11 < b12) {
                return false;
            }
            if (b11 > b12) {
                return true;
            }
            if (!bVar2.b()) {
                int i11 = aVar.f78736d.f12969e;
                return i11 == -1 || i11 > this.f78897d.f12966b;
            }
            r.b bVar3 = aVar.f78736d;
            int i12 = bVar3.f12966b;
            int i13 = bVar3.f12967c;
            r.b bVar4 = this.f78897d;
            int i14 = bVar4.f12966b;
            if (i12 <= i14) {
                return i12 == i14 && i13 > bVar4.f12967c;
            }
            return true;
        }

        public void k(int i11, r.b bVar) {
            if (this.f78896c != -1 || i11 != this.f78895b || bVar == null || bVar.f12968d < u1.this.n()) {
                return;
            }
            this.f78896c = bVar.f12968d;
        }

        public boolean m(androidx.media3.common.e0 e0Var, androidx.media3.common.e0 e0Var2) {
            int l11 = l(e0Var, e0Var2, this.f78895b);
            this.f78895b = l11;
            if (l11 == -1) {
                return false;
            }
            r.b bVar = this.f78897d;
            return bVar == null || e0Var2.b(bVar.f12965a) != -1;
        }
    }

    public u1() {
        this(f78884i);
    }

    public u1(com.google.common.base.q qVar) {
        this.f78889d = qVar;
        this.f78886a = new e0.c();
        this.f78887b = new e0.b();
        this.f78888c = new HashMap();
        this.f78891f = androidx.media3.common.e0.f10007a;
        this.f78893h = -1L;
    }

    private void l(a aVar) {
        if (aVar.f78896c != -1) {
            this.f78893h = aVar.f78896c;
        }
        this.f78892g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String m() {
        byte[] bArr = new byte[12];
        f78885j.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long n() {
        a aVar = (a) this.f78888c.get(this.f78892g);
        return (aVar == null || aVar.f78896c == -1) ? this.f78893h + 1 : aVar.f78896c;
    }

    private a o(int i11, r.b bVar) {
        a aVar = null;
        long j11 = Long.MAX_VALUE;
        for (a aVar2 : this.f78888c.values()) {
            aVar2.k(i11, bVar);
            if (aVar2.i(i11, bVar)) {
                long j12 = aVar2.f78896c;
                if (j12 == -1 || j12 < j11) {
                    aVar = aVar2;
                    j11 = j12;
                } else if (j12 == j11 && ((a) androidx.media3.common.util.a1.i(aVar)).f78897d != null && aVar2.f78897d != null) {
                    aVar = aVar2;
                }
            }
        }
        if (aVar != null) {
            return aVar;
        }
        String str = (String) this.f78889d.get();
        a aVar3 = new a(str, i11, bVar);
        this.f78888c.put(str, aVar3);
        return aVar3;
    }

    private void p(c.a aVar) {
        if (aVar.f78734b.q()) {
            String str = this.f78892g;
            if (str != null) {
                l((a) androidx.media3.common.util.a.e((a) this.f78888c.get(str)));
                return;
            }
            return;
        }
        a aVar2 = (a) this.f78888c.get(this.f78892g);
        a o11 = o(aVar.f78735c, aVar.f78736d);
        this.f78892g = o11.f78894a;
        c(aVar);
        r.b bVar = aVar.f78736d;
        if (bVar == null || !bVar.b()) {
            return;
        }
        if (aVar2 != null && aVar2.f78896c == aVar.f78736d.f12968d && aVar2.f78897d != null && aVar2.f78897d.f12966b == aVar.f78736d.f12966b && aVar2.f78897d.f12967c == aVar.f78736d.f12967c) {
            return;
        }
        r.b bVar2 = aVar.f78736d;
        this.f78890e.H(aVar, o(aVar.f78735c, new r.b(bVar2.f12965a, bVar2.f12968d)).f78894a, o11.f78894a);
    }

    @Override // y1.c4
    public synchronized String a() {
        return this.f78892g;
    }

    @Override // y1.c4
    public synchronized String b(androidx.media3.common.e0 e0Var, r.b bVar) {
        return o(e0Var.h(bVar.f12965a, this.f78887b).f10018c, bVar).f78894a;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00de A[Catch: all -> 0x0044, TryCatch #0 {, blocks: (B:4:0x0005, B:9:0x0014, B:11:0x0018, B:16:0x0024, B:18:0x0030, B:20:0x003a, B:24:0x0047, B:26:0x0053, B:27:0x0059, B:29:0x005e, B:31:0x0064, B:33:0x007d, B:34:0x00d8, B:36:0x00de, B:37:0x00f4, B:39:0x0100, B:41:0x0106), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f0  */
    @Override // y1.c4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void c(y1.c.a r25) {
        /*
            Method dump skipped, instructions count: 279
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.u1.c(y1.c$a):void");
    }

    @Override // y1.c4
    public synchronized void d(c.a aVar, int i11) {
        try {
            androidx.media3.common.util.a.e(this.f78890e);
            boolean z10 = i11 == 0;
            Iterator it = this.f78888c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.j(aVar)) {
                    it.remove();
                    if (aVar2.f78898e) {
                        boolean equals = aVar2.f78894a.equals(this.f78892g);
                        boolean z11 = z10 && equals && aVar2.f78899f;
                        if (equals) {
                            l(aVar2);
                        }
                        this.f78890e.l(aVar, aVar2.f78894a, z11);
                    }
                }
            }
            p(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // y1.c4
    public synchronized void e(c.a aVar) {
        c4.a aVar2;
        try {
            String str = this.f78892g;
            if (str != null) {
                l((a) androidx.media3.common.util.a.e((a) this.f78888c.get(str)));
            }
            Iterator it = this.f78888c.values().iterator();
            while (it.hasNext()) {
                a aVar3 = (a) it.next();
                it.remove();
                if (aVar3.f78898e && (aVar2 = this.f78890e) != null) {
                    aVar2.l(aVar, aVar3.f78894a, false);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // y1.c4
    public synchronized void f(c.a aVar) {
        try {
            androidx.media3.common.util.a.e(this.f78890e);
            androidx.media3.common.e0 e0Var = this.f78891f;
            this.f78891f = aVar.f78734b;
            Iterator it = this.f78888c.values().iterator();
            while (it.hasNext()) {
                a aVar2 = (a) it.next();
                if (aVar2.m(e0Var, this.f78891f) && !aVar2.j(aVar)) {
                }
                it.remove();
                if (aVar2.f78898e) {
                    if (aVar2.f78894a.equals(this.f78892g)) {
                        l(aVar2);
                    }
                    this.f78890e.l(aVar, aVar2.f78894a, false);
                }
            }
            p(aVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // y1.c4
    public void g(c4.a aVar) {
        this.f78890e = aVar;
    }
}
