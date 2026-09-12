package mb;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Object f69584a;

    /* renamed from: b, reason: collision with root package name */
    private final c f69585b;

    /* loaded from: classes5.dex */
    private static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        private final Class f69586a;

        private b(Class cls) {
            this.f69586a = cls;
        }

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) this.f69586a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f69586a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // mb.g.c
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public List a(Context context) {
            Bundle b11 = b(context);
            if (b11 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b11.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b11.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* loaded from: classes5.dex */
    interface c {
        List a(Object obj);
    }

    g(Object obj, c cVar) {
        this.f69584a = obj;
        this.f69585b = cVar;
    }

    public static g c(Context context, Class cls) {
        return new g(context, new b(cls));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ComponentRegistrar d(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e11) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e11);
        } catch (InstantiationException e12) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e12);
        } catch (NoSuchMethodException e13) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e13);
        } catch (InvocationTargetException e14) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e14);
        }
    }

    public List b() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f69585b.a(this.f69584a)) {
            arrayList.add(new ic.b() { // from class: mb.f
                @Override // ic.b
                public final Object get() {
                    ComponentRegistrar d11;
                    d11 = g.d(str);
                    return d11;
                }
            });
        }
        return arrayList;
    }
}
