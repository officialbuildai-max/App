package com.bykv.vk.openvk.preload.a;

import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class l extends i {

    /* renamed from: a, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.a.b.g<String, i> f20613a = new com.bykv.vk.openvk.preload.a.b.g<>();

    public final void a(String str, i iVar) {
        com.bykv.vk.openvk.preload.a.b.g<String, i> gVar = this.f20613a;
        if (iVar == null) {
            iVar = k.f20612a;
        }
        gVar.put(str, iVar);
    }

    public final Set<Map.Entry<String, i>> d() {
        return this.f20613a.entrySet();
    }

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof l) && ((l) obj).f20613a.equals(this.f20613a);
        }
        return true;
    }

    public final int hashCode() {
        return this.f20613a.hashCode();
    }
}
