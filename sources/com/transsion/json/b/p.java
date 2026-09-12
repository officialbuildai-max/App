package com.transsion.json.b;

import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class p extends ConcurrentHashMap<Class, n> {

    /* renamed from: a, reason: collision with root package name */
    private p f46088a;

    /* renamed from: b, reason: collision with root package name */
    protected boolean f46089b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f46090a;

        a() {
        }

        public void a(boolean z10) {
            this.f46090a = z10;
        }

        public boolean b() {
            return this.f46090a;
        }
    }

    public p() {
    }

    public p(p pVar) {
        this.f46088a = pVar;
    }

    private n a(Class cls, Class cls2, a aVar) {
        if (cls == null) {
            return null;
        }
        if (containsKey(cls)) {
            if (cls != cls2) {
                aVar.a(false);
            }
            return get(cls);
        }
        if (cls.isArray()) {
            aVar.a(false);
            return get(Arrays.class);
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            n a11 = a(cls3, cls2, aVar);
            if (a11 != null) {
                return a11;
            }
        }
        return a(cls.getSuperclass(), cls2, aVar);
    }

    public n a(Class cls, n nVar) {
        if (!this.f46089b) {
            put(cls, nVar);
        }
        return nVar;
    }

    public n a(Object obj) {
        p pVar;
        a aVar = new a();
        Class<?> cls = obj == null ? Void.TYPE : obj.getClass();
        n a11 = a(cls, cls, aVar);
        if (a11 == null && (pVar = this.f46088a) != null && (a11 = pVar.a(obj)) != null) {
            a(obj == null ? Void.TYPE : obj.getClass(), a11);
        }
        if (!aVar.b()) {
            a(cls, a11);
        }
        return a11;
    }
}
