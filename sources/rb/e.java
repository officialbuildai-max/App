package rb;

import java.io.File;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: c, reason: collision with root package name */
    private static final b f74369c = new b();

    /* renamed from: a, reason: collision with root package name */
    private final vb.g f74370a;

    /* renamed from: b, reason: collision with root package name */
    private c f74371b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class b implements c {
        private b() {
        }

        @Override // rb.c
        public void a() {
        }

        @Override // rb.c
        public String b() {
            return null;
        }

        @Override // rb.c
        public byte[] c() {
            return null;
        }

        @Override // rb.c
        public void d() {
        }

        @Override // rb.c
        public void e(long j11, String str) {
        }
    }

    public e(vb.g gVar) {
        this.f74370a = gVar;
        this.f74371b = f74369c;
    }

    public e(vb.g gVar, String str) {
        this(gVar);
        e(str);
    }

    private File d(String str) {
        return this.f74370a.q(str, "userlog");
    }

    public void a() {
        this.f74371b.d();
    }

    public byte[] b() {
        return this.f74371b.c();
    }

    public String c() {
        return this.f74371b.b();
    }

    public final void e(String str) {
        this.f74371b.a();
        this.f74371b = f74369c;
        if (str == null) {
            return;
        }
        f(d(str), 65536);
    }

    void f(File file, int i11) {
        this.f74371b = new h(file, i11);
    }

    public void g(long j11, String str) {
        this.f74371b.e(j11, str);
    }
}
