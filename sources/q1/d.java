package q1;

import androidx.view.t0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f73169a = new d();

    private d() {
    }

    public final t0 a(Class modelClass) {
        Intrinsics.h(modelClass, "modelClass");
        try {
            Object newInstance = modelClass.getDeclaredConstructor(null).newInstance(null);
            Intrinsics.g(newInstance, "{\n            modelClass…).newInstance()\n        }");
            return (t0) newInstance;
        } catch (IllegalAccessException e11) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e11);
        } catch (InstantiationException e12) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e12);
        } catch (NoSuchMethodException e13) {
            throw new RuntimeException("Cannot create an instance of " + modelClass, e13);
        }
    }
}
