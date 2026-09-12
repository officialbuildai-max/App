package sc;

import java.util.Locale;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f75442c;

    /* renamed from: a, reason: collision with root package name */
    private final c f75443a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f75444b;

    private a() {
        this(null);
    }

    public a(c cVar) {
        this.f75444b = false;
        this.f75443a = cVar == null ? c.c() : cVar;
    }

    public static a e() {
        if (f75442c == null) {
            synchronized (a.class) {
                try {
                    if (f75442c == null) {
                        f75442c = new a();
                    }
                } finally {
                }
            }
        }
        return f75442c;
    }

    public void a(String str) {
        if (this.f75444b) {
            this.f75443a.a(str);
        }
    }

    public void b(String str, Object... objArr) {
        if (this.f75444b) {
            this.f75443a.a(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void c(String str) {
        if (this.f75444b) {
            this.f75443a.b(str);
        }
    }

    public void d(String str, Object... objArr) {
        if (this.f75444b) {
            this.f75443a.b(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public void f(String str) {
        if (this.f75444b) {
            this.f75443a.d(str);
        }
    }

    public void g(String str, Object... objArr) {
        if (this.f75444b) {
            this.f75443a.d(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    public boolean h() {
        return this.f75444b;
    }

    public void i(boolean z10) {
        this.f75444b = z10;
    }

    public void j(String str) {
        if (this.f75444b) {
            this.f75443a.e(str);
        }
    }

    public void k(String str, Object... objArr) {
        if (this.f75444b) {
            this.f75443a.e(String.format(Locale.ENGLISH, str, objArr));
        }
    }
}
