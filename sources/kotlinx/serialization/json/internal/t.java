package kotlinx.serialization.json.internal;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
public abstract class t {
    public static final Map a(int i11) {
        return new ConcurrentHashMap(i11);
    }
}
