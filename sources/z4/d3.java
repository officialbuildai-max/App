package z4;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

/* loaded from: classes3.dex */
public class d3 implements a5.z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static d3 f79346a = new d3();

    @Override // z4.b2
    public int b() {
        return 12;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        Optional of2;
        Optional empty;
        OptionalDouble of3;
        OptionalDouble empty2;
        OptionalLong of4;
        OptionalLong empty3;
        OptionalInt of5;
        OptionalInt empty4;
        if (type == c2.a()) {
            Integer t11 = TypeUtils.t(aVar.m0(Integer.class));
            if (t11 == null) {
                empty4 = OptionalInt.empty();
                return empty4;
            }
            of5 = OptionalInt.of(t11.intValue());
            return of5;
        }
        if (type == x2.a()) {
            Long w11 = TypeUtils.w(aVar.m0(Long.class));
            if (w11 == null) {
                empty3 = OptionalLong.empty();
                return empty3;
            }
            of4 = OptionalLong.of(w11.longValue());
            return of4;
        }
        if (type == a3.a()) {
            Double q11 = TypeUtils.q(aVar.m0(Double.class));
            if (q11 == null) {
                empty2 = OptionalDouble.empty();
                return empty2;
            }
            of3 = OptionalDouble.of(q11.doubleValue());
            return of3;
        }
        Object o02 = aVar.o0(TypeUtils.P0(type));
        if (o02 == null) {
            empty = Optional.empty();
            return empty;
        }
        of2 = Optional.of(o02);
        return of2;
    }

    @Override // a5.z0
    public void d(a5.o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        boolean isPresent;
        long asLong;
        boolean isPresent2;
        int asInt;
        boolean isPresent3;
        double asDouble;
        boolean isPresent4;
        if (obj == null) {
            o0Var.C();
            return;
        }
        if (e2.a(obj)) {
            Optional a11 = l2.a(obj);
            isPresent4 = a11.isPresent();
            o0Var.A(isPresent4 ? a11.get() : null);
            return;
        }
        if (p2.a(obj)) {
            OptionalDouble a12 = q2.a(obj);
            isPresent3 = a12.isPresent();
            if (!isPresent3) {
                o0Var.C();
                return;
            } else {
                asDouble = a12.getAsDouble();
                o0Var.A(Double.valueOf(asDouble));
                return;
            }
        }
        if (t2.a(obj)) {
            OptionalInt a13 = u2.a(obj);
            isPresent2 = a13.isPresent();
            if (!isPresent2) {
                o0Var.C();
                return;
            } else {
                asInt = a13.getAsInt();
                o0Var.f371k.h0(asInt);
                return;
            }
        }
        if (!h2.a(obj)) {
            throw new JSONException("not support optional : " + obj.getClass());
        }
        OptionalLong a14 = i2.a(obj);
        isPresent = a14.isPresent();
        if (!isPresent) {
            o0Var.C();
        } else {
            asLong = a14.getAsLong();
            o0Var.f371k.l0(asLong);
        }
    }
}
