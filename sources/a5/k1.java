package a5;

import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.reflect.Type;
import z4.b2;

/* loaded from: classes2.dex */
public class k1 implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static k1 f362a = new k1();

    public static Object e(y4.a aVar) {
        y4.b s11 = aVar.s();
        if (s11.q0() == 4) {
            String k02 = s11.k0();
            s11.c0(16);
            return k02;
        }
        if (s11.q0() == 2) {
            String C0 = s11.C0();
            s11.c0(16);
            return C0;
        }
        Object T = aVar.T();
        if (T == null) {
            return null;
        }
        return T.toString();
    }

    @Override // z4.b2
    public int b() {
        return 4;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        if (type == StringBuffer.class) {
            y4.b bVar = aVar.f78954f;
            if (bVar.q0() == 4) {
                String k02 = bVar.k0();
                bVar.c0(16);
                return new StringBuffer(k02);
            }
            Object T = aVar.T();
            if (T == null) {
                return null;
            }
            return new StringBuffer(T.toString());
        }
        if (type != StringBuilder.class) {
            return e(aVar);
        }
        y4.b bVar2 = aVar.f78954f;
        if (bVar2.q0() == 4) {
            String k03 = bVar2.k0();
            bVar2.c0(16);
            return new StringBuilder(k03);
        }
        Object T2 = aVar.T();
        if (T2 == null) {
            return null;
        }
        return new StringBuilder(T2.toString());
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        f(o0Var, (String) obj);
    }

    public void f(o0 o0Var, String str) {
        j1 j1Var = o0Var.f371k;
        if (str == null) {
            j1Var.p0(SerializerFeature.WriteNullStringAsEmpty);
        } else {
            j1Var.q0(str);
        }
    }
}
