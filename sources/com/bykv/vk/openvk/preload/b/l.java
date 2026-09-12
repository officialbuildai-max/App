package com.bykv.vk.openvk.preload.b;

import com.bykv.vk.openvk.preload.b.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class l<IN, OUT> extends d<IN, OUT> {

    /* renamed from: d, reason: collision with root package name */
    private Map<String, a> f20644d;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        List<h> f20645a = new ArrayList();

        public final a a(h hVar) {
            this.f20645a.add(hVar);
            return this;
        }

        public final a a(List<h> list) {
            this.f20645a.addAll(list);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private Map<String, a> f20646a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.b.b.a f20647b;

        public final h a(Class<? extends l> cls) {
            return h.a.a().a(cls).a(this.f20646a).a(this.f20647b).b();
        }

        public final a a(String str) {
            if (this.f20646a.containsKey(str)) {
                throw new IllegalArgumentException("duplicated branch name");
            }
            a aVar = new a();
            this.f20646a.put(str, aVar);
            return aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<h> list) {
        return !list.isEmpty() && list.get(list.size() - 1).f20632a == f.class;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<String, a> a() {
        return this.f20644d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bykv.vk.openvk.preload.b.d
    public final void a(Object... objArr) {
        Object obj;
        super.a(objArr);
        if (objArr == null || objArr.length != 1 || (obj = objArr[0]) == null) {
            throw new IllegalStateException("args error");
        }
        try {
            this.f20644d = (Map) obj;
        } catch (ClassCastException e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
