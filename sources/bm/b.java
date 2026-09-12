package bm;

import com.transsion.core.log.ObjectLogUtils;

/* loaded from: classes5.dex */
public class b implements c {

    /* renamed from: d, reason: collision with root package name */
    private static b f16707d;

    /* renamed from: a, reason: collision with root package name */
    boolean f16708a = false;

    /* renamed from: b, reason: collision with root package name */
    int f16709b = 2;

    /* renamed from: c, reason: collision with root package name */
    private ObjectLogUtils f16710c = new ObjectLogUtils.a().o(true).r(true).q(false).m();

    private b() {
    }

    public static b b() {
        if (f16707d == null) {
            synchronized (b.class) {
                try {
                    if (f16707d == null) {
                        f16707d = new b();
                    }
                } finally {
                }
            }
        }
        return f16707d;
    }

    @Override // bm.c
    public void a(boolean z10) {
        if (z10 != this.f16708a) {
            this.f16708a = z10;
        }
    }

    public boolean c() {
        return this.f16708a;
    }

    @Override // bm.c
    public void d(String str, String str2) {
        f(2, str, str2);
    }

    @Override // bm.c
    public void e(String str, String str2) {
        f(6, str, str2);
    }

    @Override // bm.c
    public void e(String str, String str2, Throwable th2) {
        g(6, str, str2, th2);
    }

    public void f(int i11, String str, String str2) {
        g(i11, str, str2, null);
    }

    public void g(int i11, String str, String str2, Throwable th2) {
        if (c() && h(i11)) {
            if (i11 == 2) {
                this.f16710c.y(str, str2, th2);
                return;
            }
            if (i11 == 3) {
                this.f16710c.h(str, str2, th2);
                return;
            }
            if (i11 == 4) {
                this.f16710c.o(str, str2, th2);
            } else if (i11 == 5) {
                this.f16710c.A(str, str2, th2);
            } else {
                if (i11 != 6) {
                    return;
                }
                this.f16710c.j(str, str2, th2);
            }
        }
    }

    public boolean h(int i11) {
        return i11 >= this.f16709b;
    }

    @Override // bm.c
    public void v(String str, String str2) {
        f(2, str, str2);
    }
}
