package androidx.room.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public abstract class f {
    public static final Object a(Class klass, String suffix) {
        String str;
        String str2;
        Intrinsics.h(klass, "klass");
        Intrinsics.h(suffix, "suffix");
        Package r02 = klass.getPackage();
        if (r02 == null || (str = r02.getName()) == null) {
            str = "";
        }
        String canonicalName = klass.getCanonicalName();
        Intrinsics.e(canonicalName);
        if (str.length() != 0) {
            canonicalName = canonicalName.substring(str.length() + 1);
            Intrinsics.g(canonicalName, "substring(...)");
        }
        String str3 = StringsKt.P(canonicalName, '.', '_', false, 4, null) + suffix;
        try {
            if (str.length() == 0) {
                str2 = str3;
            } else {
                str2 = str + '.' + str3;
            }
            Class<?> cls = Class.forName(str2, true, klass.getClassLoader());
            Intrinsics.f(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.util.KClassUtil.findAndInstantiateDatabaseImpl>");
            return cls.getDeclaredConstructor(null).newInstance(null);
        } catch (ClassNotFoundException e11) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str3 + " does not exist. Is Room annotation processor correctly configured?", e11);
        } catch (IllegalAccessException e12) {
            throw new RuntimeException("Cannot access the constructor " + klass.getCanonicalName(), e12);
        } catch (InstantiationException e13) {
            throw new RuntimeException("Failed to create an instance of " + klass.getCanonicalName(), e13);
        }
    }

    public static /* synthetic */ Object b(Class cls, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            str = "_Impl";
        }
        return a(cls, str);
    }
}
