package t8;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
class i implements d {

    /* renamed from: a, reason: collision with root package name */
    private final a f76208a;

    /* renamed from: b, reason: collision with root package name */
    private final g f76209b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f76210c;

    /* loaded from: classes4.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        private final Context f76211a;

        /* renamed from: b, reason: collision with root package name */
        private Map f76212b = null;

        a(Context context) {
            this.f76211a = context;
        }

        private Map a(Context context) {
            Bundle d11 = d(context);
            if (d11 == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap hashMap = new HashMap();
            for (String str : d11.keySet()) {
                Object obj = d11.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String trim = str2.trim();
                        if (!trim.isEmpty()) {
                            hashMap.put(trim, str.substring(8));
                        }
                    }
                }
            }
            return hashMap;
        }

        private Map c() {
            if (this.f76212b == null) {
                this.f76212b = a(this.f76211a);
            }
            return this.f76212b;
        }

        private static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        c b(String str) {
            String str2 = (String) c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (c) Class.forName(str2).asSubclass(c.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e11) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e11);
                return null;
            } catch (IllegalAccessException e12) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e12);
                return null;
            } catch (InstantiationException e13) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e13);
                return null;
            } catch (NoSuchMethodException e14) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e14);
                return null;
            } catch (InvocationTargetException e15) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e15);
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Context context, g gVar) {
        this(new a(context), gVar);
    }

    i(a aVar, g gVar) {
        this.f76210c = new HashMap();
        this.f76208a = aVar;
        this.f76209b = gVar;
    }

    @Override // t8.d
    public synchronized k a(String str) {
        if (this.f76210c.containsKey(str)) {
            return (k) this.f76210c.get(str);
        }
        c b11 = this.f76208a.b(str);
        if (b11 == null) {
            return null;
        }
        k create = b11.create(this.f76209b.a(str));
        this.f76210c.put(str, create);
        return create;
    }
}
