package androidx.datastore.preferences.core;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public abstract class a {
    public static final Set a(Set set) {
        Intrinsics.h(set, "set");
        Set unmodifiableSet = Collections.unmodifiableSet(CollectionsKt.W0(set));
        Intrinsics.g(unmodifiableSet, "unmodifiableSet(set.toSet())");
        return unmodifiableSet;
    }

    public static final Map b(Map map) {
        Intrinsics.h(map, "map");
        Map unmodifiableMap = Collections.unmodifiableMap(map);
        Intrinsics.g(unmodifiableMap, "unmodifiableMap(map)");
        return unmodifiableMap;
    }
}
