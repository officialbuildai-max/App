package tc;

/* loaded from: classes5.dex */
public class a extends e {

    /* renamed from: b, reason: collision with root package name */
    private static final sc.a f76298b = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final com.google.firebase.perf.v1.c f76299a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(com.google.firebase.perf.v1.c cVar) {
        this.f76299a = cVar;
    }

    private boolean g() {
        com.google.firebase.perf.v1.c cVar = this.f76299a;
        if (cVar == null) {
            f76298b.j("ApplicationInfo is null");
            return false;
        }
        if (!cVar.s()) {
            f76298b.j("GoogleAppId is null");
            return false;
        }
        if (!this.f76299a.q()) {
            f76298b.j("AppInstanceId is null");
            return false;
        }
        if (!this.f76299a.r()) {
            f76298b.j("ApplicationProcessState is null");
            return false;
        }
        if (!this.f76299a.p()) {
            return true;
        }
        if (!this.f76299a.m().l()) {
            f76298b.j("AndroidAppInfo.packageName is null");
            return false;
        }
        if (this.f76299a.m().m()) {
            return true;
        }
        f76298b.j("AndroidAppInfo.sdkVersion is null");
        return false;
    }

    @Override // tc.e
    public boolean c() {
        if (g()) {
            return true;
        }
        f76298b.j("ApplicationInfo is invalid");
        return false;
    }
}
