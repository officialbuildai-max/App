package y8;

import b9.a;
import com.google.android.datatransport.runtime.o;
import com.google.android.datatransport.runtime.t;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import r8.j;
import t8.k;
import z8.u;

/* loaded from: classes4.dex */
public class c implements e {

    /* renamed from: f, reason: collision with root package name */
    private static final Logger f79055f = Logger.getLogger(t.class.getName());

    /* renamed from: a, reason: collision with root package name */
    private final u f79056a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f79057b;

    /* renamed from: c, reason: collision with root package name */
    private final t8.d f79058c;

    /* renamed from: d, reason: collision with root package name */
    private final a9.d f79059d;

    /* renamed from: e, reason: collision with root package name */
    private final b9.a f79060e;

    public c(Executor executor, t8.d dVar, u uVar, a9.d dVar2, b9.a aVar) {
        this.f79057b = executor;
        this.f79058c = dVar;
        this.f79056a = uVar;
        this.f79059d = dVar2;
        this.f79060e = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(o oVar, com.google.android.datatransport.runtime.i iVar) {
        this.f79059d.t0(oVar, iVar);
        this.f79056a.a(oVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final o oVar, j jVar, com.google.android.datatransport.runtime.i iVar) {
        try {
            k a11 = this.f79058c.a(oVar.b());
            if (a11 == null) {
                String format = String.format("Transport backend '%s' is not registered", oVar.b());
                f79055f.warning(format);
                jVar.a(new IllegalArgumentException(format));
            } else {
                final com.google.android.datatransport.runtime.i a12 = a11.a(iVar);
                this.f79060e.b(new a.InterfaceC0150a() { // from class: y8.b
                    @Override // b9.a.InterfaceC0150a
                    public final Object execute() {
                        Object d11;
                        d11 = c.this.d(oVar, a12);
                        return d11;
                    }
                });
                jVar.a(null);
            }
        } catch (Exception e11) {
            f79055f.warning("Error scheduling event " + e11.getMessage());
            jVar.a(e11);
        }
    }

    @Override // y8.e
    public void a(final o oVar, final com.google.android.datatransport.runtime.i iVar, final j jVar) {
        this.f79057b.execute(new Runnable() { // from class: y8.a
            @Override // java.lang.Runnable
            public final void run() {
                c.this.e(oVar, jVar, iVar);
            }
        });
    }
}
