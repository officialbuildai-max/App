package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    private final Class f74631a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f74632b;

    /* renamed from: c, reason: collision with root package name */
    private final Method f74633c;

    /* renamed from: d, reason: collision with root package name */
    private final List f74634d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Class cls, Object obj, Method method, List list) {
        this.f74631a = cls;
        this.f74632b = obj;
        this.f74633c = method;
        this.f74634d = Collections.unmodifiableList(list);
    }

    public Method a() {
        return this.f74633c;
    }

    public Class b() {
        return this.f74631a;
    }

    public String toString() {
        return String.format("%s.%s() %s", this.f74631a.getName(), this.f74633c.getName(), this.f74634d);
    }
}
