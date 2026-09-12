package a5;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.j3;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import z4.b2;

/* loaded from: classes2.dex */
public class i0 implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static i0 f320a = new i0();

    @Override // z4.b2
    public int b() {
        return 0;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        if (type instanceof ParameterizedType) {
            type = ((ParameterizedType) type).getRawType();
        }
        if (type != ArrayListMultimap.class) {
            return null;
        }
        ArrayListMultimap create = ArrayListMultimap.create();
        for (Map.Entry<String, Object> entry : aVar.l0().entrySet()) {
            Object value = entry.getValue();
            if (value instanceof Collection) {
                create.putAll(entry.getKey(), (List) value);
            } else {
                create.put(entry.getKey(), value);
            }
        }
        return create;
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj instanceof j3) {
            o0Var.A(((j3) obj).asMap());
        }
    }
}
