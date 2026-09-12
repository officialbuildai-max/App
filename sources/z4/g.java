package z4;

import com.alibaba.fastjson.JSONException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

/* loaded from: classes3.dex */
public class g implements b2 {

    /* renamed from: a, reason: collision with root package name */
    private final Method f79349a;

    /* renamed from: b, reason: collision with root package name */
    private final Class f79350b;

    public g(Method method) {
        this.f79349a = method;
        this.f79350b = method.getParameterTypes()[0];
    }

    @Override // z4.b2
    public int b() {
        return 0;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        try {
            return this.f79349a.invoke(null, aVar.m0(this.f79350b));
        } catch (IllegalAccessException e11) {
            throw new JSONException("parse enum error", e11);
        } catch (InvocationTargetException e12) {
            throw new JSONException("parse enum error", e12);
        }
    }
}
