package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes7.dex */
public interface e {

    /* loaded from: classes7.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type b(int i11, ParameterizedType parameterizedType) {
            return o0.g(i11, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class c(Type type) {
            return o0.h(type);
        }

        public abstract e a(Type type, Annotation[] annotationArr, k0 k0Var);
    }

    Type a();

    Object b(d dVar);
}
