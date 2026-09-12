package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* loaded from: classes7.dex */
public interface k {

    /* loaded from: classes7.dex */
    public static abstract class a {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type a(int i11, ParameterizedType parameterizedType) {
            return o0.g(i11, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class b(Type type) {
            return o0.h(type);
        }

        public k c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, k0 k0Var) {
            return null;
        }

        public k d(Type type, Annotation[] annotationArr, k0 k0Var) {
            return null;
        }

        public k e(Type type, Annotation[] annotationArr, k0 k0Var) {
            return null;
        }
    }

    Object convert(Object obj);
}
