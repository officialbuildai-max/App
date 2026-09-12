package kb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzdy;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kb.a;

/* loaded from: classes5.dex */
public class b implements kb.a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile kb.a f66876c;

    /* renamed from: a, reason: collision with root package name */
    private final AppMeasurementSdk f66877a;

    /* renamed from: b, reason: collision with root package name */
    final Map f66878b;

    /* loaded from: classes5.dex */
    class a implements a.InterfaceC0837a {

        /* renamed from: a, reason: collision with root package name */
        private final /* synthetic */ String f66879a;

        /* renamed from: b, reason: collision with root package name */
        private final /* synthetic */ b f66880b;

        a(b bVar, String str) {
            this.f66879a = str;
            this.f66880b = bVar;
        }
    }

    private b(AppMeasurementSdk appMeasurementSdk) {
        Preconditions.checkNotNull(appMeasurementSdk);
        this.f66877a = appMeasurementSdk;
        this.f66878b = new ConcurrentHashMap();
    }

    public static kb.a h(f fVar, Context context, fc.d dVar) {
        Preconditions.checkNotNull(fVar);
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(dVar);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (f66876c == null) {
            synchronized (b.class) {
                try {
                    if (f66876c == null) {
                        Bundle bundle = new Bundle(1);
                        if (fVar.u()) {
                            dVar.a(com.google.firebase.b.class, new Executor() { // from class: kb.c
                                @Override // java.util.concurrent.Executor
                                public final void execute(Runnable runnable) {
                                    runnable.run();
                                }
                            }, new fc.b() { // from class: kb.d
                                @Override // fc.b
                                public final void a(fc.a aVar) {
                                    b.i(aVar);
                                }
                            });
                            bundle.putBoolean("dataCollectionDefaultEnabled", fVar.t());
                        }
                        f66876c = new b(zzdy.zza(context, (String) null, (String) null, (String) null, bundle).zzb());
                    }
                } finally {
                }
            }
        }
        return f66876c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void i(fc.a aVar) {
        throw null;
    }

    private final boolean j(String str) {
        return (str.isEmpty() || !this.f66878b.containsKey(str) || this.f66878b.get(str) == null) ? false : true;
    }

    @Override // kb.a
    public a.InterfaceC0837a a(String str, a.b bVar) {
        Preconditions.checkNotNull(bVar);
        if (!com.google.firebase.analytics.connector.internal.a.j(str) || j(str)) {
            return null;
        }
        AppMeasurementSdk appMeasurementSdk = this.f66877a;
        Object dVar = AppMeasurement.FIAM_ORIGIN.equals(str) ? new com.google.firebase.analytics.connector.internal.d(appMeasurementSdk, bVar) : "clx".equals(str) ? new com.google.firebase.analytics.connector.internal.f(appMeasurementSdk, bVar) : null;
        if (dVar == null) {
            return null;
        }
        this.f66878b.put(str, dVar);
        return new a(this, str);
    }

    @Override // kb.a
    public void b(String str, String str2, Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (com.google.firebase.analytics.connector.internal.a.j(str) && com.google.firebase.analytics.connector.internal.a.e(str2, bundle) && com.google.firebase.analytics.connector.internal.a.g(str, str2, bundle)) {
            com.google.firebase.analytics.connector.internal.a.d(str, str2, bundle);
            this.f66877a.logEvent(str, str2, bundle);
        }
    }

    @Override // kb.a
    public void c(String str, String str2, Object obj) {
        if (com.google.firebase.analytics.connector.internal.a.j(str) && com.google.firebase.analytics.connector.internal.a.f(str, str2)) {
            this.f66877a.setUserProperty(str, str2, obj);
        }
    }

    @Override // kb.a
    public void clearConditionalUserProperty(String str, String str2, Bundle bundle) {
        if (str2 == null || com.google.firebase.analytics.connector.internal.a.e(str2, bundle)) {
            this.f66877a.clearConditionalUserProperty(str, str2, bundle);
        }
    }

    @Override // kb.a
    public void d(a.c cVar) {
        if (com.google.firebase.analytics.connector.internal.a.h(cVar)) {
            this.f66877a.setConditionalUserProperty(com.google.firebase.analytics.connector.internal.a.a(cVar));
        }
    }

    @Override // kb.a
    public Map e(boolean z10) {
        return this.f66877a.getUserProperties(null, null, z10);
    }

    @Override // kb.a
    public int f(String str) {
        return this.f66877a.getMaxUserProperties(str);
    }

    @Override // kb.a
    public List g(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        Iterator<Bundle> it = this.f66877a.getConditionalUserProperties(str, str2).iterator();
        while (it.hasNext()) {
            arrayList.add(com.google.firebase.analytics.connector.internal.a.c(it.next()));
        }
        return arrayList;
    }
}
