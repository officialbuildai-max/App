package nb;

import android.os.Bundle;
import com.google.android.gms.measurement.AppMeasurement;
import ic.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kb.a;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final ic.a f70417a;

    /* renamed from: b, reason: collision with root package name */
    private volatile pb.a f70418b;

    /* renamed from: c, reason: collision with root package name */
    private volatile qb.b f70419c;

    /* renamed from: d, reason: collision with root package name */
    private final List f70420d;

    public d(ic.a aVar) {
        this(aVar, new qb.c(), new pb.f());
    }

    public d(ic.a aVar, qb.b bVar, pb.a aVar2) {
        this.f70417a = aVar;
        this.f70419c = bVar;
        this.f70420d = new ArrayList();
        this.f70418b = aVar2;
        f();
    }

    private void f() {
        this.f70417a.a(new a.InterfaceC0817a() { // from class: nb.c
            @Override // ic.a.InterfaceC0817a
            public final void a(ic.b bVar) {
                d.this.i(bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(String str, Bundle bundle) {
        this.f70418b.a(str, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(qb.a aVar) {
        synchronized (this) {
            try {
                if (this.f70419c instanceof qb.c) {
                    this.f70420d.add(aVar);
                }
                this.f70419c.a(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(ic.b bVar) {
        ob.g.f().b("AnalyticsConnector now available.");
        kb.a aVar = (kb.a) bVar.get();
        pb.e eVar = new pb.e(aVar);
        e eVar2 = new e();
        if (j(aVar, eVar2) == null) {
            ob.g.f().k("Could not register Firebase Analytics listener; a listener is already registered.");
            return;
        }
        ob.g.f().b("Registered Firebase Analytics listener.");
        pb.d dVar = new pb.d();
        pb.c cVar = new pb.c(eVar, 500, TimeUnit.MILLISECONDS);
        synchronized (this) {
            try {
                Iterator it = this.f70420d.iterator();
                while (it.hasNext()) {
                    dVar.a((qb.a) it.next());
                }
                eVar2.d(dVar);
                eVar2.e(cVar);
                this.f70419c = dVar;
                this.f70418b = cVar;
            } finally {
            }
        }
    }

    private static a.InterfaceC0837a j(kb.a aVar, e eVar) {
        a.InterfaceC0837a a11 = aVar.a("clx", eVar);
        if (a11 == null) {
            ob.g.f().b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
            a11 = aVar.a(AppMeasurement.CRASH_ORIGIN, eVar);
            if (a11 != null) {
                ob.g.f().k("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
            }
        }
        return a11;
    }

    public pb.a d() {
        return new pb.a() { // from class: nb.b
            @Override // pb.a
            public final void a(String str, Bundle bundle) {
                d.this.g(str, bundle);
            }
        };
    }

    public qb.b e() {
        return new qb.b() { // from class: nb.a
            @Override // qb.b
            public final void a(qb.a aVar) {
                d.this.h(aVar);
            }
        };
    }
}
