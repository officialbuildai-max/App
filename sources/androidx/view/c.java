package androidx.view;

import androidx.view.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class c {

    /* renamed from: c, reason: collision with root package name */
    static c f9660c = new c();

    /* renamed from: a, reason: collision with root package name */
    private final Map f9661a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map f9662b = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Map f9663a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        final Map f9664b;

        a(Map map) {
            this.f9664b = map;
            for (Map.Entry entry : map.entrySet()) {
                Lifecycle.Event event = (Lifecycle.Event) entry.getValue();
                List list = (List) this.f9663a.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f9663a.put(event, list);
                }
                list.add((b) entry.getKey());
            }
        }

        private static void b(List list, u uVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((b) list.get(size)).a(uVar, event, obj);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(u uVar, Lifecycle.Event event, Object obj) {
            b((List) this.f9663a.get(event), uVar, event, obj);
            b((List) this.f9663a.get(Lifecycle.Event.ON_ANY), uVar, event, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final int f9665a;

        /* renamed from: b, reason: collision with root package name */
        final Method f9666b;

        b(int i11, Method method) {
            this.f9665a = i11;
            this.f9666b = method;
            method.setAccessible(true);
        }

        void a(u uVar, Lifecycle.Event event, Object obj) {
            try {
                int i11 = this.f9665a;
                if (i11 == 0) {
                    this.f9666b.invoke(obj, null);
                } else if (i11 == 1) {
                    this.f9666b.invoke(obj, uVar);
                } else {
                    if (i11 != 2) {
                        return;
                    }
                    this.f9666b.invoke(obj, uVar, event);
                }
            } catch (IllegalAccessException e11) {
                throw new RuntimeException(e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to call observer method", e12.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f9665a == bVar.f9665a && this.f9666b.getName().equals(bVar.f9666b.getName());
        }

        public int hashCode() {
            return (this.f9665a * 31) + this.f9666b.getName().hashCode();
        }
    }

    c() {
    }

    private a a(Class cls, Method[] methodArr) {
        int i11;
        a c11;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c11 = c(superclass)) != null) {
            hashMap.putAll(c11.f9664b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : c(cls2).f9664b.entrySet()) {
                e(hashMap, (b) entry.getKey(), (Lifecycle.Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z10 = false;
        for (Method method : methodArr) {
            d0 d0Var = (d0) method.getAnnotation(d0.class);
            if (d0Var != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i11 = 0;
                } else {
                    if (!u.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i11 = 1;
                }
                Lifecycle.Event value = d0Var.value();
                if (parameterTypes.length > 1) {
                    if (!Lifecycle.Event.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i11 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new b(i11, method), value, cls);
                z10 = true;
            }
        }
        a aVar = new a(hashMap);
        this.f9661a.put(cls, aVar);
        this.f9662b.put(cls, Boolean.valueOf(z10));
        return aVar;
    }

    private Method[] b(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e11) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e11);
        }
    }

    private void e(Map map, b bVar, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = (Lifecycle.Event) map.get(bVar);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(bVar, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + bVar.f9666b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a c(Class cls) {
        a aVar = (a) this.f9661a.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d(Class cls) {
        Boolean bool = (Boolean) this.f9662b.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b11 = b(cls);
        for (Method method : b11) {
            if (((d0) method.getAnnotation(d0.class)) != null) {
                a(cls, b11);
                return true;
            }
        }
        this.f9662b.put(cls, Boolean.FALSE);
        return false;
    }
}
