package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.h0;
import java.util.Map;

/* loaded from: classes.dex */
final class j0 implements i0 {
    private static int a(int i11, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        h0 h0Var = (h0) obj2;
        int i12 = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            i12 += h0Var.a(i11, entry.getKey(), entry.getValue());
        }
        return i12;
    }

    private static MapFieldLite b(Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        MapFieldLite mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.isMutable()) {
                mapFieldLite = mapFieldLite.mutableCopy();
            }
            mapFieldLite.mergeFrom(mapFieldLite2);
        }
        return mapFieldLite;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public Map forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public h0.a forMapMetadata(Object obj) {
        return ((h0) obj).c();
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public Map forMutableMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public int getSerializedSize(int i11, Object obj, Object obj2) {
        return a(i11, obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public boolean isImmutable(Object obj) {
        return !((MapFieldLite) obj).isMutable();
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public Object mergeFrom(Object obj, Object obj2) {
        return b(obj, obj2);
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public Object newMapField(Object obj) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    @Override // androidx.datastore.preferences.protobuf.i0
    public Object toImmutable(Object obj) {
        ((MapFieldLite) obj).makeImmutable();
        return obj;
    }
}
