package a5;

import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Type;
import z4.b2;

/* loaded from: classes2.dex */
public class x implements z0, b2 {

    /* renamed from: a, reason: collision with root package name */
    public static final x f434a = new x();

    @Override // z4.b2
    public int b() {
        return 4;
    }

    @Override // z4.b2
    public Object c(y4.a aVar, Type type, Object obj) {
        Object T = aVar.T();
        if (T == null) {
            return null;
        }
        return TypeUtils.n(T);
    }

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        Character ch2 = (Character) obj;
        if (ch2 == null) {
            j1Var.q0("");
        } else if (ch2.charValue() == 0) {
            j1Var.q0("\u0000");
        } else {
            j1Var.q0(ch2.toString());
        }
    }
}
