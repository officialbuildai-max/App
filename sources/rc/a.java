package rc;

import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.firebase.f f74422a;

    /* renamed from: b, reason: collision with root package name */
    private final jc.e f74423b;

    /* renamed from: c, reason: collision with root package name */
    private final ic.b f74424c;

    /* renamed from: d, reason: collision with root package name */
    private final ic.b f74425d;

    public a(com.google.firebase.f fVar, jc.e eVar, ic.b bVar, ic.b bVar2) {
        this.f74422a = fVar;
        this.f74423b = eVar;
        this.f74424c = bVar;
        this.f74425d = bVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.perf.config.a a() {
        return com.google.firebase.perf.config.a.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.firebase.f b() {
        return this.f74422a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public jc.e c() {
        return this.f74423b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ic.b d() {
        return this.f74424c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigManager e() {
        return RemoteConfigManager.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SessionManager f() {
        return SessionManager.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ic.b g() {
        return this.f74425d;
    }
}
