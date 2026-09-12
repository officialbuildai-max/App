package retrofit2;

import android.os.Build;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/* loaded from: classes7.dex */
class d0 {

    /* loaded from: classes7.dex */
    static final class a extends d0 {
        @Override // retrofit2.d0
        Object b(Method method, Class cls, Object obj, Object[] objArr) {
            if (Build.VERSION.SDK_INT >= 26) {
                return t.a(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }

        @Override // retrofit2.d0
        boolean c(Method method) {
            boolean isDefault;
            isDefault = method.isDefault();
            return isDefault;
        }
    }

    /* loaded from: classes7.dex */
    static class b extends d0 {
        @Override // retrofit2.d0
        String a(Method method, int i11) {
            Parameter[] parameters;
            boolean isNamePresent;
            String name;
            parameters = method.getParameters();
            Parameter parameter = parameters[i11];
            isNamePresent = parameter.isNamePresent();
            if (!isNamePresent) {
                return super.a(method, i11);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("parameter '");
            name = parameter.getName();
            sb2.append(name);
            sb2.append('\'');
            return sb2.toString();
        }

        @Override // retrofit2.d0
        Object b(Method method, Class cls, Object obj, Object[] objArr) {
            return t.a(method, cls, obj, objArr);
        }

        @Override // retrofit2.d0
        boolean c(Method method) {
            boolean isDefault;
            isDefault = method.isDefault();
            return isDefault;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(Method method, int i11) {
        return "parameter #" + (i11 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object b(Method method, Class cls, Object obj, Object[] objArr) {
        throw new AssertionError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Method method) {
        return false;
    }
}
