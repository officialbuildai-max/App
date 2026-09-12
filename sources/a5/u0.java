package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicLong;
import z4.b2;

/* loaded from: classes2.dex */
public class u0 implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static u0 f425a = new u0();

    @Override // z4.b2
    public int b() {
        return 2;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        Long w11;
        y4.b bVar = aVar.f78954f;
        try {
            int q02 = bVar.q0();
            if (q02 == 2) {
                long l11 = bVar.l();
                bVar.c0(16);
                w11 = Long.valueOf(l11);
            } else if (q02 == 3) {
                w11 = Long.valueOf(TypeUtils.E0(bVar.d0()));
                bVar.c0(16);
            } else {
                if (q02 == 12) {
                    JSONObject jSONObject = new JSONObject(true);
                    aVar.q0(jSONObject);
                    w11 = TypeUtils.w(jSONObject);
                } else {
                    w11 = TypeUtils.w(aVar.T());
                }
                if (w11 == null) {
                    return null;
                }
            }
            return type == AtomicLong.class ? new AtomicLong(w11.longValue()) : w11;
        } catch (Exception e11) {
            throw new JSONException("parseLong error, field : " + obj, e11);
        }
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.p0(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        long longValue = ((Long) obj).longValue();
        j1Var.l0(longValue);
        if (!j1Var.q(SerializerFeature.WriteClassName) || longValue > 2147483647L || longValue < -2147483648L || type == Long.class || type == Long.TYPE) {
            return;
        }
        j1Var.write(76);
    }
}
