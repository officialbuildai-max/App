package kotlinx.serialization.internal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class k0 extends d1 {

    /* renamed from: c, reason: collision with root package name */
    private final kotlinx.serialization.descriptors.f f68284c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(kotlinx.serialization.b kSerializer, kotlinx.serialization.b vSerializer) {
        super(kSerializer, vSerializer, null);
        Intrinsics.h(kSerializer, "kSerializer");
        Intrinsics.h(vSerializer, "vSerializer");
        this.f68284c = new j0(kSerializer.getDescriptor(), vSerializer.getDescriptor());
    }

    @Override // kotlinx.serialization.internal.d1, kotlinx.serialization.b, kotlinx.serialization.g, kotlinx.serialization.a
    public kotlinx.serialization.descriptors.f getDescriptor() {
        return this.f68284c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public HashMap a() {
        return new HashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public int b(HashMap hashMap) {
        Intrinsics.h(hashMap, "<this>");
        return hashMap.size() * 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void c(HashMap hashMap, int i11) {
        Intrinsics.h(hashMap, "<this>");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Iterator d(Map map) {
        Intrinsics.h(map, "<this>");
        return map.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public int e(Map map) {
        Intrinsics.h(map, "<this>");
        return map.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public HashMap k(Map map) {
        Intrinsics.h(map, "<this>");
        HashMap hashMap = map instanceof HashMap ? (HashMap) map : null;
        return hashMap == null ? new HashMap(map) : hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.internal.a
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Map l(HashMap hashMap) {
        Intrinsics.h(hashMap, "<this>");
        return hashMap;
    }
}
