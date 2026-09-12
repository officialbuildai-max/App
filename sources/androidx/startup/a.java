package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f14985d;

    /* renamed from: e, reason: collision with root package name */
    private static final Object f14986e = new Object();

    /* renamed from: c, reason: collision with root package name */
    final Context f14989c;

    /* renamed from: b, reason: collision with root package name */
    final Set f14988b = new HashSet();

    /* renamed from: a, reason: collision with root package name */
    final Map f14987a = new HashMap();

    a(Context context) {
        this.f14989c = context.getApplicationContext();
    }

    private Object d(Class cls, Set set) {
        Object obj;
        if (f4.a.h()) {
            try {
                f4.a.c(cls.getSimpleName());
            } catch (Throwable th2) {
                f4.a.f();
                throw th2;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f14987a.containsKey(cls)) {
            obj = this.f14987a.get(cls);
        } else {
            set.add(cls);
            try {
                e4.a aVar = (e4.a) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> a11 = aVar.a();
                if (!a11.isEmpty()) {
                    for (Class cls2 : a11) {
                        if (!this.f14987a.containsKey(cls2)) {
                            d(cls2, set);
                        }
                    }
                }
                obj = aVar.b(this.f14989c);
                set.remove(cls);
                this.f14987a.put(cls, obj);
            } catch (Throwable th3) {
                throw new StartupException(th3);
            }
        }
        f4.a.f();
        return obj;
    }

    public static a e(Context context) {
        if (f14985d == null) {
            synchronized (f14986e) {
                try {
                    if (f14985d == null) {
                        f14985d = new a(context);
                    }
                } finally {
                }
            }
        }
        return f14985d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        try {
            try {
                f4.a.c("Startup");
                b(this.f14989c.getPackageManager().getProviderInfo(new ComponentName(this.f14989c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e11) {
                throw new StartupException(e11);
            }
        } finally {
            f4.a.f();
        }
    }

    void b(Bundle bundle) {
        String string = this.f14989c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (e4.a.class.isAssignableFrom(cls)) {
                            this.f14988b.add(cls);
                        }
                    }
                }
                Iterator it = this.f14988b.iterator();
                while (it.hasNext()) {
                    d((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e11) {
                throw new StartupException(e11);
            }
        }
    }

    Object c(Class cls) {
        Object obj;
        synchronized (f14986e) {
            try {
                obj = this.f14987a.get(cls);
                if (obj == null) {
                    obj = d(cls, new HashSet());
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return obj;
    }

    public Object f(Class cls) {
        return c(cls);
    }

    public boolean g(Class cls) {
        return this.f14988b.contains(cls);
    }
}
