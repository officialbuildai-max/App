package pc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.metrics.h;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Timer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import vc.k;

/* loaded from: classes5.dex */
public class e {

    /* renamed from: i, reason: collision with root package name */
    private static final sc.a f72534i = sc.a.e();

    /* renamed from: a, reason: collision with root package name */
    private final Map f72535a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.perf.config.a f72536b;

    /* renamed from: c, reason: collision with root package name */
    private final com.google.firebase.perf.util.d f72537c;

    /* renamed from: d, reason: collision with root package name */
    private Boolean f72538d;

    /* renamed from: e, reason: collision with root package name */
    private final com.google.firebase.f f72539e;

    /* renamed from: f, reason: collision with root package name */
    private final ic.b f72540f;

    /* renamed from: g, reason: collision with root package name */
    private final jc.e f72541g;

    /* renamed from: h, reason: collision with root package name */
    private final ic.b f72542h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.google.firebase.f fVar, ic.b bVar, jc.e eVar, ic.b bVar2, RemoteConfigManager remoteConfigManager, com.google.firebase.perf.config.a aVar, SessionManager sessionManager) {
        this.f72538d = null;
        this.f72539e = fVar;
        this.f72540f = bVar;
        this.f72541g = eVar;
        this.f72542h = bVar2;
        if (fVar == null) {
            this.f72538d = Boolean.FALSE;
            this.f72536b = aVar;
            this.f72537c = new com.google.firebase.perf.util.d(new Bundle());
            return;
        }
        k.k().r(fVar, eVar, bVar2);
        Context k11 = fVar.k();
        com.google.firebase.perf.util.d a11 = a(k11);
        this.f72537c = a11;
        remoteConfigManager.setFirebaseRemoteConfigProvider(bVar);
        this.f72536b = aVar;
        aVar.P(a11);
        aVar.O(k11);
        sessionManager.setApplicationContext(k11);
        this.f72538d = aVar.j();
        sc.a aVar2 = f72534i;
        if (aVar2.h() && d()) {
            aVar2.f(String.format("Firebase Performance Monitoring is successfully initialized! In a minute, visit the Firebase console to view your data: %s", sc.b.b(fVar.n().e(), k11.getPackageName())));
        }
    }

    private static com.google.firebase.perf.util.d a(Context context) {
        Bundle bundle;
        try {
            bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException | NullPointerException e11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("No perf enable meta data found ");
            sb2.append(e11.getMessage());
            bundle = null;
        }
        return bundle != null ? new com.google.firebase.perf.util.d(bundle) : new com.google.firebase.perf.util.d();
    }

    public static e c() {
        return (e) com.google.firebase.f.l().j(e.class);
    }

    public Map b() {
        return new HashMap(this.f72535a);
    }

    public boolean d() {
        Boolean bool = this.f72538d;
        return bool != null ? bool.booleanValue() : com.google.firebase.f.l().t();
    }

    public h e(String str, String str2) {
        return new h(str, str2, k.k(), new Timer());
    }
}
