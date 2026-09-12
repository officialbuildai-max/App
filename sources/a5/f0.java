package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Enumeration;

/* loaded from: classes2.dex */
public class f0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public static f0 f273a = new f0();

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.p0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        int i12 = 0;
        Type type2 = (j1Var.q(SerializerFeature.WriteClassName) && (type instanceof ParameterizedType)) ? ((ParameterizedType) type).getActualTypeArguments()[0] : null;
        Enumeration enumeration = (Enumeration) obj;
        e1 e1Var = o0Var.f378r;
        o0Var.w(e1Var, obj, obj2, 0);
        try {
            j1Var.append('[');
            while (enumeration.hasMoreElements()) {
                Object nextElement = enumeration.nextElement();
                int i13 = i12 + 1;
                if (i12 != 0) {
                    j1Var.append(',');
                }
                if (nextElement == null) {
                    j1Var.m0();
                } else {
                    o0Var.q(nextElement.getClass()).d(o0Var, nextElement, Integer.valueOf(i12), type2, 0);
                }
                i12 = i13;
            }
            j1Var.append(']');
            o0Var.f378r = e1Var;
        } catch (Throwable th2) {
            o0Var.f378r = e1Var;
            throw th2;
        }
    }
}
