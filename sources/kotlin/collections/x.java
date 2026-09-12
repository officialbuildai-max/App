package kotlin.collections;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class x {
    public static Set a(Set builder) {
        Intrinsics.h(builder, "builder");
        return ((SetBuilder) builder).build();
    }

    public static Set b() {
        return new SetBuilder();
    }

    public static Set c(int i11) {
        return new SetBuilder(i11);
    }

    public static Set d(Object obj) {
        Set singleton = Collections.singleton(obj);
        Intrinsics.g(singleton, "singleton(...)");
        return singleton;
    }

    public static TreeSet e(Object... elements) {
        Intrinsics.h(elements, "elements");
        return (TreeSet) ArraysKt___ArraysKt.G0(elements, new TreeSet());
    }
}
