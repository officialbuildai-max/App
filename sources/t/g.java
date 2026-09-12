package t;

import java.util.Map;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes.dex */
public interface g extends Map, KMappedMarker {

    /* loaded from: classes.dex */
    public interface a extends Map, KMutableMap {
        g build();
    }

    a builder();
}
