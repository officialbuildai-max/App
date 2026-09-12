package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Map;

/* loaded from: classes2.dex */
public class j implements z0 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Class f330a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile boolean f331b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile Method f332c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile Method f333d;

    /* renamed from: e, reason: collision with root package name */
    public static j f334e = new j();

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        JSONException jSONException;
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        if (interfaces.length == 1 && interfaces[0].isAnnotation()) {
            Class<?> cls = interfaces[0];
            if (f330a == null && !f331b) {
                try {
                    f330a = Class.forName("sun.reflect.annotation.AnnotationType");
                } finally {
                }
            }
            if (f330a == null) {
                throw new JSONException("not support Type Annotation.");
            }
            if (f332c == null && !f331b) {
                try {
                    f332c = f330a.getMethod("getInstance", Class.class);
                } finally {
                }
            }
            if (f333d == null && !f331b) {
                try {
                    f333d = f330a.getMethod("members", null);
                } finally {
                }
            }
            if (f332c == null || f331b) {
                throw new JSONException("not support Type Annotation.");
            }
            try {
                try {
                    Map map = (Map) f333d.invoke(f332c.invoke(null, cls), null);
                    JSONObject jSONObject = new JSONObject(map.size());
                    Object obj3 = null;
                    for (Map.Entry entry : map.entrySet()) {
                        try {
                            obj3 = ((Method) entry.getValue()).invoke(obj, null);
                        } catch (IllegalAccessException | InvocationTargetException unused) {
                        }
                        jSONObject.put((String) entry.getKey(), com.alibaba.fastjson.a.toJSON(obj3));
                    }
                    o0Var.A(jSONObject);
                } finally {
                }
            } finally {
            }
        }
    }
}
