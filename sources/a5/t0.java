package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import java.util.List;

/* loaded from: classes2.dex */
public final class t0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final t0 f420a = new t0();

    @Override // a5.z0
    public final void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        int i12;
        Object obj3;
        boolean z10;
        char c11;
        j1 j1Var = o0Var.f371k;
        SerializerFeature serializerFeature = SerializerFeature.WriteClassName;
        boolean z11 = j1Var.q(serializerFeature) || SerializerFeature.isEnabled(i11, serializerFeature);
        j1 j1Var2 = o0Var.f371k;
        Type V = z11 ? TypeUtils.V(type) : null;
        if (obj == null) {
            j1Var2.p0(SerializerFeature.WriteNullListAsEmpty);
            return;
        }
        List list = (List) obj;
        if (list.size() == 0) {
            j1Var2.append("[]");
            return;
        }
        e1 e1Var = o0Var.f378r;
        o0Var.w(e1Var, obj, obj2, 0);
        try {
            char c12 = ',';
            if (j1Var2.q(SerializerFeature.PrettyFormat)) {
                j1Var2.append('[');
                o0Var.s();
                int i13 = 0;
                for (Object obj4 : list) {
                    if (i13 != 0) {
                        j1Var2.append(c12);
                    }
                    o0Var.v();
                    if (obj4 == null) {
                        c11 = c12;
                        o0Var.f371k.m0();
                    } else if (o0Var.k(obj4)) {
                        o0Var.D(obj4);
                        c11 = c12;
                    } else {
                        z0 q11 = o0Var.q(obj4.getClass());
                        c11 = c12;
                        o0Var.f378r = new e1(e1Var, obj, obj2, 0, 0);
                        q11.d(o0Var, obj4, Integer.valueOf(i13), V, i11);
                    }
                    i13++;
                    c12 = c11;
                }
                o0Var.l();
                o0Var.v();
                j1Var2.append(']');
                o0Var.f378r = e1Var;
                return;
            }
            char c13 = ',';
            j1Var2.append('[');
            int size = list.size();
            int i14 = 0;
            while (i14 < size) {
                Object obj5 = list.get(i14);
                if (i14 != 0) {
                    j1Var2.append(c13);
                }
                if (obj5 == null) {
                    j1Var2.append("null");
                } else {
                    Class<?> cls = obj5.getClass();
                    if (cls == Integer.class) {
                        j1Var2.h0(((Integer) obj5).intValue());
                    } else if (cls == Long.class) {
                        long longValue = ((Long) obj5).longValue();
                        if (z11) {
                            j1Var2.l0(longValue);
                            j1Var2.write(76);
                        } else {
                            j1Var2.l0(longValue);
                        }
                    } else if ((SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0) {
                        i12 = i14;
                        o0Var.q(obj5.getClass()).d(o0Var, obj5, Integer.valueOf(i14), V, i11);
                        z10 = z11;
                        i14 = i12 + 1;
                        z11 = z10;
                        c13 = ',';
                    } else {
                        i12 = i14;
                        if (j1Var2.f349h) {
                            obj3 = obj5;
                            z10 = z11;
                        } else {
                            obj3 = obj5;
                            z10 = z11;
                            o0Var.f378r = new e1(e1Var, obj, obj2, 0, 0);
                        }
                        if (o0Var.k(obj3)) {
                            o0Var.D(obj3);
                        } else {
                            z0 q12 = o0Var.q(obj3.getClass());
                            if ((SerializerFeature.WriteClassName.mask & i11) == 0 || !(q12 instanceof p0)) {
                                q12.d(o0Var, obj3, Integer.valueOf(i12), V, i11);
                            } else {
                                ((p0) q12).x(o0Var, obj3, Integer.valueOf(i12), V, i11);
                            }
                        }
                        i14 = i12 + 1;
                        z11 = z10;
                        c13 = ',';
                    }
                }
                i12 = i14;
                z10 = z11;
                i14 = i12 + 1;
                z11 = z10;
                c13 = ',';
            }
            j1Var2.append(']');
            o0Var.f378r = e1Var;
        } catch (Throwable th2) {
            o0Var.f378r = e1Var;
            throw th2;
        }
    }
}
