package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import z4.b2;

/* loaded from: classes2.dex */
public class r implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    static final BigDecimal f413a = BigDecimal.valueOf(-9007199254740991L);

    /* renamed from: b, reason: collision with root package name */
    static final BigDecimal f414b = BigDecimal.valueOf(9007199254740991L);

    /* renamed from: c, reason: collision with root package name */
    public static final r f415c = new r();

    public static Object e(y4.a aVar) {
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() == 2) {
            BigDecimal d02 = bVar.d0();
            bVar.c0(16);
            return d02;
        }
        if (bVar.q0() == 3) {
            BigDecimal d03 = bVar.d0();
            bVar.c0(16);
            return d03;
        }
        Object T = aVar.T();
        if (T == null) {
            return null;
        }
        return TypeUtils.i(T);
    }

    @Override // z4.b2
    public int b() {
        return 2;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        try {
            return e(aVar);
        } catch (Exception e11) {
            throw new JSONException("parseDecimal error, field : " + obj, e11);
        }
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.p0(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        BigDecimal bigDecimal = (BigDecimal) obj;
        int scale = bigDecimal.scale();
        String bigDecimal2 = (!SerializerFeature.isEnabled(i11, j1Var.f344c, SerializerFeature.WriteBigDecimalAsPlain) || scale < -100 || scale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString();
        if (scale == 0 && bigDecimal2.length() >= 16 && SerializerFeature.isEnabled(i11, j1Var.f344c, SerializerFeature.BrowserCompatible) && (bigDecimal.compareTo(f413a) < 0 || bigDecimal.compareTo(f414b) > 0)) {
            j1Var.q0(bigDecimal2);
            return;
        }
        j1Var.write(bigDecimal2);
        if (j1Var.q(SerializerFeature.WriteClassName) && type != BigDecimal.class && bigDecimal.scale() == 0) {
            j1Var.write(46);
        }
    }
}
