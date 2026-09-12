package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicBoolean;
import z4.b2;

/* loaded from: classes2.dex */
public class t implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final t f419a = new t();

    @Override // z4.b2
    public int b() {
        return 6;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        Boolean k11;
        y4.b bVar = aVar.f78954f;
        try {
            if (bVar.q0() == 6) {
                bVar.c0(16);
                k11 = Boolean.TRUE;
            } else if (bVar.q0() == 7) {
                bVar.c0(16);
                k11 = Boolean.FALSE;
            } else if (bVar.q0() == 2) {
                int o11 = bVar.o();
                bVar.c0(16);
                k11 = o11 == 1 ? Boolean.TRUE : Boolean.FALSE;
            } else {
                Object T = aVar.T();
                if (T == null) {
                    return null;
                }
                k11 = TypeUtils.k(T);
            }
            return type == AtomicBoolean.class ? new AtomicBoolean(k11.booleanValue()) : k11;
        } catch (Exception e11) {
            throw new JSONException("parseBoolean error, field : " + obj, e11);
        }
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        Boolean bool = (Boolean) obj;
        if (bool == null) {
            j1Var.p0(SerializerFeature.WriteNullBooleanAsFalse);
        } else if (bool.booleanValue()) {
            j1Var.write("true");
        } else {
            j1Var.write("false");
        }
    }
}
