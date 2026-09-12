package com.bykv.vk.openvk.preload.b;

/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    Class<? extends d> f20632a;

    /* renamed from: b, reason: collision with root package name */
    private com.bykv.vk.openvk.preload.b.b.a f20633b;

    /* renamed from: c, reason: collision with root package name */
    private Object[] f20634c;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Class<? extends d> f20635a;

        /* renamed from: b, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.b.b.a f20636b;

        /* renamed from: c, reason: collision with root package name */
        private Object[] f20637c;

        private a() {
        }

        public static a a() {
            return new a();
        }

        public final a a(com.bykv.vk.openvk.preload.b.b.a aVar) {
            this.f20636b = aVar;
            return this;
        }

        public final a a(Class<? extends d> cls) {
            if (cls == null) {
                throw new IllegalArgumentException("interceptor class == null");
            }
            this.f20635a = cls;
            return this;
        }

        public final a a(Object... objArr) {
            this.f20637c = objArr;
            return this;
        }

        public final h b() {
            return new h(this, (byte) 0);
        }
    }

    private h(a aVar) {
        this.f20632a = aVar.f20635a;
        this.f20633b = aVar.f20636b;
        this.f20634c = aVar.f20637c;
        if (this.f20632a == null) {
            throw new IllegalArgumentException("Interceptor class == null");
        }
    }

    /* synthetic */ h(a aVar, byte b11) {
        this(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.bykv.vk.openvk.preload.b.b.a a() {
        return this.f20633b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] b() {
        return this.f20634c;
    }
}
