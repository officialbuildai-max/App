package z8;

import b9.a;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private final Executor f79477a;

    /* renamed from: b, reason: collision with root package name */
    private final a9.d f79478b;

    /* renamed from: c, reason: collision with root package name */
    private final u f79479c;

    /* renamed from: d, reason: collision with root package name */
    private final b9.a f79480d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Executor executor, a9.d dVar, u uVar, b9.a aVar) {
        this.f79477a = executor;
        this.f79478b = dVar;
        this.f79479c = uVar;
        this.f79480d = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        Iterator it = this.f79478b.H().iterator();
        while (it.hasNext()) {
            this.f79479c.a((com.google.android.datatransport.runtime.o) it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f79480d.b(new a.InterfaceC0150a() { // from class: z8.r
            @Override // b9.a.InterfaceC0150a
            public final Object execute() {
                Object d11;
                d11 = s.this.d();
                return d11;
            }
        });
    }

    public void c() {
        this.f79477a.execute(new Runnable() { // from class: z8.q
            @Override // java.lang.Runnable
            public final void run() {
                s.this.e();
            }
        });
    }
}
