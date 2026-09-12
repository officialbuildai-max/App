package androidx.work;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    private static final String f16109a;

    static {
        String i11 = t.i("InputMerger");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f16109a = i11;
    }

    public static final k a(String className) {
        Intrinsics.h(className, "className");
        try {
            Object newInstance = Class.forName(className).getDeclaredConstructor(null).newInstance(null);
            Intrinsics.f(newInstance, "null cannot be cast to non-null type androidx.work.InputMerger");
            return (k) newInstance;
        } catch (Exception e11) {
            t.e().d(f16109a, "Trouble instantiating " + className, e11);
            return null;
        }
    }
}
