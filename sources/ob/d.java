package ob;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import ic.a;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes5.dex */
public final class d implements ob.a {

    /* renamed from: c, reason: collision with root package name */
    private static final h f71069c = new b();

    /* renamed from: a, reason: collision with root package name */
    private final ic.a f71070a;

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference f71071b = new AtomicReference(null);

    /* loaded from: classes5.dex */
    private static final class b implements h {
        private b() {
        }

        @Override // ob.h
        public File a() {
            return null;
        }

        @Override // ob.h
        public CrashlyticsReport.a b() {
            return null;
        }

        @Override // ob.h
        public File c() {
            return null;
        }

        @Override // ob.h
        public File d() {
            return null;
        }

        @Override // ob.h
        public File e() {
            return null;
        }

        @Override // ob.h
        public File f() {
            return null;
        }

        @Override // ob.h
        public File g() {
            return null;
        }
    }

    public d(ic.a aVar) {
        this.f71070a = aVar;
        aVar.a(new a.InterfaceC0817a() { // from class: ob.b
            @Override // ic.a.InterfaceC0817a
            public final void a(ic.b bVar) {
                d.this.g(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(ic.b bVar) {
        g.f().b("Crashlytics native component now available.");
        this.f71071b.set((ob.a) bVar.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(String str, String str2, long j11, sb.e eVar, ic.b bVar) {
        ((ob.a) bVar.get()).c(str, str2, j11, eVar);
    }

    @Override // ob.a
    public h a(String str) {
        ob.a aVar = (ob.a) this.f71071b.get();
        return aVar == null ? f71069c : aVar.a(str);
    }

    @Override // ob.a
    public boolean b() {
        ob.a aVar = (ob.a) this.f71071b.get();
        return aVar != null && aVar.b();
    }

    @Override // ob.a
    public void c(final String str, final String str2, final long j11, final sb.e eVar) {
        g.f().i("Deferring native open session: " + str);
        this.f71070a.a(new a.InterfaceC0817a() { // from class: ob.c
            @Override // ic.a.InterfaceC0817a
            public final void a(ic.b bVar) {
                d.h(str, str2, j11, eVar, bVar);
            }
        });
    }

    @Override // ob.a
    public boolean d(String str) {
        ob.a aVar = (ob.a) this.f71071b.get();
        return aVar != null && aVar.d(str);
    }
}
