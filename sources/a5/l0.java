package a5;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public class l0 implements z0 {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f365a = new l0();

    @Override // a5.z0
    public void d(o0 o0Var, Object obj, Object obj2, Type type, int i11) {
        j1 j1Var = o0Var.f371k;
        v0 v0Var = v0.f428j;
        try {
            Field declaredField = obj.getClass().getDeclaredField("map");
            if (Modifier.isPrivate(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }
            v0Var.d(o0Var, declaredField.get(obj), obj2, type, i11);
        } catch (Exception unused) {
            j1Var.m0();
        }
    }
}
