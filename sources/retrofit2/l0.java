package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class l0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static l0 b(k0 k0Var, Class cls, Method method) {
        i0 b11 = i0.b(k0Var, cls, method);
        Type genericReturnType = method.getGenericReturnType();
        if (o0.j(genericReturnType)) {
            throw o0.n(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
        }
        if (genericReturnType != Void.TYPE) {
            return u.f(k0Var, method, b11);
        }
        throw o0.n(method, "Service methods cannot return void.", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Object a(Object obj, Object[] objArr);
}
