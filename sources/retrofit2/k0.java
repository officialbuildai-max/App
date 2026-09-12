package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import retrofit2.b;
import retrofit2.e;
import retrofit2.k;

/* loaded from: classes7.dex */
public final class k0 {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap f74581a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    final Call.Factory f74582b;

    /* renamed from: c, reason: collision with root package name */
    final HttpUrl f74583c;

    /* renamed from: d, reason: collision with root package name */
    final List f74584d;

    /* renamed from: e, reason: collision with root package name */
    final int f74585e;

    /* renamed from: f, reason: collision with root package name */
    final List f74586f;

    /* renamed from: g, reason: collision with root package name */
    final int f74587g;

    /* renamed from: h, reason: collision with root package name */
    final Executor f74588h;

    /* renamed from: i, reason: collision with root package name */
    final boolean f74589i;

    /* loaded from: classes7.dex */
    class a implements InvocationHandler {

        /* renamed from: a, reason: collision with root package name */
        private final Object[] f74590a = new Object[0];

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Class f74591b;

        a(Class cls) {
            this.f74591b = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f74590a;
            }
            d0 d0Var = b0.f74516b;
            return d0Var.c(method) ? d0Var.b(method, this.f74591b, obj, objArr) : k0.this.c(this.f74591b, method).a(obj, objArr);
        }
    }

    /* loaded from: classes7.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Call.Factory f74593a;

        /* renamed from: b, reason: collision with root package name */
        private HttpUrl f74594b;

        /* renamed from: c, reason: collision with root package name */
        private final List f74595c = new ArrayList();

        /* renamed from: d, reason: collision with root package name */
        private final List f74596d = new ArrayList();

        /* renamed from: e, reason: collision with root package name */
        private Executor f74597e;

        /* renamed from: f, reason: collision with root package name */
        private boolean f74598f;

        public b a(e.a aVar) {
            List list = this.f74596d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(k.a aVar) {
            List list = this.f74595c;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return d(HttpUrl.get(str));
        }

        public b d(HttpUrl httpUrl) {
            Objects.requireNonNull(httpUrl, "baseUrl == null");
            if ("".equals(httpUrl.pathSegments().get(r0.size() - 1))) {
                this.f74594b = httpUrl;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrl);
        }

        public k0 e() {
            if (this.f74594b == null) {
                throw new IllegalStateException("Base URL required.");
            }
            Call.Factory factory = this.f74593a;
            if (factory == null) {
                factory = new OkHttpClient();
            }
            Call.Factory factory2 = factory;
            Executor executor = this.f74597e;
            if (executor == null) {
                executor = b0.f74515a;
            }
            Executor executor2 = executor;
            c cVar = b0.f74517c;
            ArrayList arrayList = new ArrayList(this.f74596d);
            List a11 = cVar.a(executor2);
            arrayList.addAll(a11);
            List b11 = cVar.b();
            int size = b11.size();
            ArrayList arrayList2 = new ArrayList(this.f74595c.size() + 1 + size);
            arrayList2.add(new retrofit2.b());
            arrayList2.addAll(this.f74595c);
            arrayList2.addAll(b11);
            return new k0(factory2, this.f74594b, Collections.unmodifiableList(arrayList2), size, Collections.unmodifiableList(arrayList), a11.size(), executor2, this.f74598f);
        }

        public b f(Call.Factory factory) {
            Objects.requireNonNull(factory, "factory == null");
            this.f74593a = factory;
            return this;
        }

        public b g(OkHttpClient okHttpClient) {
            Objects.requireNonNull(okHttpClient, "client == null");
            return f(okHttpClient);
        }
    }

    k0(Call.Factory factory, HttpUrl httpUrl, List list, int i11, List list2, int i12, Executor executor, boolean z10) {
        this.f74582b = factory;
        this.f74583c = httpUrl;
        this.f74584d = list;
        this.f74585e = i11;
        this.f74586f = list2;
        this.f74587g = i12;
        this.f74588h = executor;
        this.f74589i = z10;
    }

    private void j(Class cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                sb2.append(cls2.getName());
                if (cls2 != cls) {
                    sb2.append(" which is an interface of ");
                    sb2.append(cls.getName());
                }
                throw new IllegalArgumentException(sb2.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f74589i) {
            d0 d0Var = b0.f74516b;
            for (Method method : cls.getDeclaredMethods()) {
                if (!d0Var.c(method) && !Modifier.isStatic(method.getModifiers()) && !method.isSynthetic()) {
                    c(cls, method);
                }
            }
        }
    }

    public e a(Type type, Annotation[] annotationArr) {
        return d(null, type, annotationArr);
    }

    public Object b(Class cls) {
        j(cls);
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    l0 c(Class cls, Method method) {
        l0 l0Var;
        Object obj = this.f74581a.get(method);
        if (obj instanceof l0) {
            return (l0) obj;
        }
        if (obj == null) {
            Object obj2 = new Object();
            synchronized (obj2) {
                try {
                    obj = this.f74581a.putIfAbsent(method, obj2);
                    if (obj == null) {
                        l0 b11 = l0.b(this, cls, method);
                        this.f74581a.put(method, b11);
                        return b11;
                    }
                } finally {
                }
            }
        }
        synchronized (obj) {
            l0Var = (l0) this.f74581a.get(method);
        }
        return l0Var;
    }

    public e d(e.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f74586f.indexOf(aVar) + 1;
        int size = this.f74586f.size();
        for (int i11 = indexOf; i11 < size; i11++) {
            e a11 = ((e.a) this.f74586f.get(i11)).a(type, annotationArr, this);
            if (a11 != null) {
                return a11;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i12 = 0; i12 < indexOf; i12++) {
                sb2.append("\n   * ");
                sb2.append(((e.a) this.f74586f.get(i12)).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f74586f.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(((e.a) this.f74586f.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public k e(k.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int indexOf = this.f74584d.indexOf(aVar) + 1;
        int size = this.f74584d.size();
        for (int i11 = indexOf; i11 < size; i11++) {
            k c11 = ((k.a) this.f74584d.get(i11)).c(type, annotationArr, annotationArr2, this);
            if (c11 != null) {
                return c11;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i12 = 0; i12 < indexOf; i12++) {
                sb2.append("\n   * ");
                sb2.append(((k.a) this.f74584d.get(i12)).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f74584d.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(((k.a) this.f74584d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public k f(k.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int indexOf = this.f74584d.indexOf(aVar) + 1;
        int size = this.f74584d.size();
        for (int i11 = indexOf; i11 < size; i11++) {
            k d11 = ((k.a) this.f74584d.get(i11)).d(type, annotationArr, this);
            if (d11 != null) {
                return d11;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i12 = 0; i12 < indexOf; i12++) {
                sb2.append("\n   * ");
                sb2.append(((k.a) this.f74584d.get(i12)).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f74584d.size();
        while (indexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(((k.a) this.f74584d.get(indexOf)).getClass().getName());
            indexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public k g(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return e(null, type, annotationArr, annotationArr2);
    }

    public k h(Type type, Annotation[] annotationArr) {
        return f(null, type, annotationArr);
    }

    public k i(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f74584d.size();
        for (int i11 = 0; i11 < size; i11++) {
            k e11 = ((k.a) this.f74584d.get(i11)).e(type, annotationArr, this);
            if (e11 != null) {
                return e11;
            }
        }
        return b.d.f74512a;
    }
}
