package com.google.protobuf;

import com.google.protobuf.m0;
import java.util.Map;

/* loaded from: classes4.dex */
interface n0 {
    Map<?, ?> forMapData(Object obj);

    m0.b forMapMetadata(Object obj);

    Map<?, ?> forMutableMapData(Object obj);

    int getSerializedSize(int i11, Object obj, Object obj2);

    boolean isImmutable(Object obj);

    Object mergeFrom(Object obj, Object obj2);

    Object newMapField(Object obj);

    Object toImmutable(Object obj);
}
