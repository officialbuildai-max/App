package com.bykv.vk.openvk.preload.a;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: g, reason: collision with root package name */
    private String f20607g;

    /* renamed from: a, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.a.b.c f20601a = com.bykv.vk.openvk.preload.a.b.c.f20508a;

    /* renamed from: b, reason: collision with root package name */
    private q f20602b = q.f20615a;

    /* renamed from: c, reason: collision with root package name */
    private c f20603c = b.f20392a;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Type, f<?>> f20604d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private final List<s> f20605e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    private final List<s> f20606f = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    private int f20608h = 2;

    /* renamed from: i, reason: collision with root package name */
    private int f20609i = 2;

    /* renamed from: j, reason: collision with root package name */
    private boolean f20610j = true;

    public final d a() {
        a aVar;
        a aVar2;
        a aVar3;
        ArrayList arrayList = new ArrayList(this.f20605e.size() + this.f20606f.size() + 3);
        arrayList.addAll(this.f20605e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f20606f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        String str = this.f20607g;
        int i11 = this.f20608h;
        int i12 = this.f20609i;
        if (str == null || "".equals(str.trim())) {
            if (i11 != 2 && i12 != 2) {
                a aVar4 = new a(Date.class, i11, i12);
                a aVar5 = new a(Timestamp.class, i11, i12);
                a aVar6 = new a(java.sql.Date.class, i11, i12);
                aVar = aVar4;
                aVar2 = aVar5;
                aVar3 = aVar6;
            }
            return new d(this.f20601a, this.f20603c, this.f20604d, this.f20610j, this.f20602b, arrayList);
        }
        aVar = new a(Date.class, str);
        aVar2 = new a(Timestamp.class, str);
        aVar3 = new a(java.sql.Date.class, str);
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Date.class, aVar));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(Timestamp.class, aVar2));
        arrayList.add(com.bykv.vk.openvk.preload.a.b.a.m.a(java.sql.Date.class, aVar3));
        return new d(this.f20601a, this.f20603c, this.f20604d, this.f20610j, this.f20602b, arrayList);
    }

    public final e a(Type type, Object obj) {
        com.bykv.vk.openvk.preload.falconx.a.a.a(true);
        this.f20605e.add(com.bykv.vk.openvk.preload.a.b.a.m.a(com.bykv.vk.openvk.preload.a.c.a.a(type), (r) obj));
        return this;
    }
}
