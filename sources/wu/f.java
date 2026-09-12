package wu;

import com.tencent.tinker.lib.service.PatchResult;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes7.dex */
public final class f implements ou.c {

    /* renamed from: a, reason: collision with root package name */
    private volatile ou.c f78093a;

    /* renamed from: b, reason: collision with root package name */
    private volatile b f78094b;

    /* renamed from: c, reason: collision with root package name */
    private volatile a f78095c;

    /* renamed from: d, reason: collision with root package name */
    private final List f78096d = new ArrayList();

    /* loaded from: classes7.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        final Throwable f78097a;

        /* renamed from: b, reason: collision with root package name */
        final int f78098b;

        a(Throwable th2, int i11) {
            this.f78097a = th2;
            this.f78098b = i11;
        }
    }

    /* loaded from: classes7.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f78099a;

        /* renamed from: b, reason: collision with root package name */
        final long f78100b;

        b(int i11, long j11) {
            this.f78099a = i11;
            this.f78100b = j11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(String str, String str2) {
        if (this.f78093a != null) {
            this.f78093a.c(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str, String str2) {
        if (this.f78093a != null) {
            this.f78093a.l(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(String str, String str2) {
        if (this.f78093a != null) {
            this.f78093a.h(str, str2);
        }
    }

    @Override // ou.c
    public void a(Throwable th2, int i11) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.a(th2, i11);
        } else {
            this.f78095c = new a(th2, i11);
        }
    }

    @Override // ou.c
    public void b(String str, String str2) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.b(str, str2);
        }
    }

    @Override // ou.c
    public void c(final String str, final String str2) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.c(str, str2);
            return;
        }
        synchronized (this.f78096d) {
            this.f78096d.add(new Runnable() { // from class: wu.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.q(str, str2);
                }
            });
        }
    }

    @Override // ou.c
    public void d(String str, String str2) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.d(str, str2);
        }
    }

    @Override // ou.c
    public void e(File file, int i11) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.e(file, i11);
        }
    }

    @Override // ou.c
    public void f() {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // ou.c
    public void g(String str, Throwable th2) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.g(str, th2);
        }
    }

    @Override // ou.c
    public void h(final String str, final String str2) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.h(str, str2);
            return;
        }
        synchronized (this.f78096d) {
            this.f78096d.add(new Runnable() { // from class: wu.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.s(str, str2);
                }
            });
        }
    }

    @Override // ou.c
    public void i(String str, boolean z10, long j11) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.i(str, z10, j11);
        }
    }

    @Override // ou.c
    public void j(PatchResult patchResult) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.j(patchResult);
        }
    }

    @Override // ou.c
    public void k(int i11, long j11) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.k(i11, j11);
        } else {
            this.f78094b = new b(i11, j11);
        }
    }

    @Override // ou.c
    public void l(final String str, final String str2) {
        ou.c cVar = this.f78093a;
        if (cVar != null) {
            cVar.l(str, str2);
            return;
        }
        synchronized (this.f78096d) {
            this.f78096d.add(new Runnable() { // from class: wu.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.this.r(str, str2);
                }
            });
        }
    }

    public void p(ou.c cVar) {
        this.f78093a = cVar;
        if (cVar == null) {
            return;
        }
        b bVar = this.f78094b;
        if (bVar != null) {
            this.f78094b = null;
            cVar.k(bVar.f78099a, bVar.f78100b);
        }
        a aVar = this.f78095c;
        if (aVar != null) {
            this.f78095c = null;
            cVar.a(aVar.f78097a, aVar.f78098b);
        }
        synchronized (this.f78096d) {
            try {
                Iterator it = this.f78096d.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                this.f78096d.clear();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
