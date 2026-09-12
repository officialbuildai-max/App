package xl;

import java.io.File;
import java.io.IOException;
import xl.f;
import xl.h;

/* loaded from: classes6.dex */
public class b implements h {

    /* renamed from: a, reason: collision with root package name */
    private f f78435a;

    /* renamed from: b, reason: collision with root package name */
    private final e f78436b = new e();

    /* renamed from: c, reason: collision with root package name */
    private final i f78437c = new i();

    /* renamed from: d, reason: collision with root package name */
    private File f78438d;

    /* renamed from: e, reason: collision with root package name */
    private final long f78439e;

    /* renamed from: f, reason: collision with root package name */
    private final long f78440f;

    /* JADX INFO: Access modifiers changed from: protected */
    public b(File file, long j11, long j12) {
        this.f78438d = file;
        this.f78439e = j11;
        this.f78440f = j12;
    }

    private f d() {
        if (this.f78435a == null) {
            synchronized (b.class) {
                try {
                    if (this.f78435a == null) {
                        File file = this.f78438d;
                        if (file == null) {
                            file = cm.i.a(qk.a.a());
                        }
                        File file2 = file;
                        this.f78438d = file2;
                        this.f78435a = f.k(file2, 1, 1, this.f78439e, this.f78440f);
                    }
                } finally {
                }
            }
        }
        return this.f78435a;
    }

    public File a(wl.e eVar) {
        try {
            f.e q11 = d().q(this.f78437c.a(eVar));
            if (q11 != null) {
                return q11.a(0);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return null;
    }

    public void b() {
        try {
            d().close();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }

    public void c(wl.e eVar, h.a aVar) {
        this.f78436b.a(eVar);
        String a11 = this.f78437c.a(eVar);
        try {
            if (d().q(a11) != null) {
                return;
            }
            f.c h11 = this.f78435a.h(a11);
            if (h11 == null) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Had two simultaneous puts for: ");
                sb2.append(a11);
                throw new IllegalStateException(sb2.toString());
            }
            try {
                if (((j) aVar).a(h11.a(0))) {
                    h11.f();
                }
            } finally {
                h11.d();
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        } finally {
            this.f78436b.b(eVar);
        }
    }
}
