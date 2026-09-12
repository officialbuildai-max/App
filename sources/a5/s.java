package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.math.BigInteger;
import z4.b2;

/* loaded from: classes2.dex */
public class s implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    private static final BigInteger f416a = BigInteger.valueOf(-9007199254740991L);

    /* renamed from: b, reason: collision with root package name */
    private static final BigInteger f417b = BigInteger.valueOf(9007199254740991L);

    /* renamed from: c, reason: collision with root package name */
    public static final s f418c = new s();

    public static Object e(y4.a aVar) {
        y4.b bVar = aVar.f78954f;
        if (bVar.q0() != 2) {
            Object T = aVar.T();
            if (T == null) {
                return null;
            }
            return TypeUtils.j(T);
        }
        String C0 = bVar.C0();
        bVar.c0(16);
        if (C0.length() <= 65535) {
            return new BigInteger(C0);
        }
        throw new JSONException("decimal overflow");
    }

    @Override // z4.b2
    public int b() {
        return 2;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        return e(aVar);
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        if (obj == null) {
            j1Var.p0(SerializerFeature.WriteNullNumberAsZero);
            return;
        }
        BigInteger bigInteger = (BigInteger) obj;
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.length() < 16 || !SerializerFeature.isEnabled(i11, j1Var.f344c, SerializerFeature.BrowserCompatible) || (bigInteger.compareTo(f416a) >= 0 && bigInteger.compareTo(f417b) <= 0)) {
            j1Var.write(bigInteger2);
        } else {
            j1Var.q0(bigInteger2);
        }
    }
}
