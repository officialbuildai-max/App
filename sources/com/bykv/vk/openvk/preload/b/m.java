package com.bykv.vk.openvk.preload.b;

/* loaded from: classes2.dex */
final class m<IN> implements b<IN> {

    /* renamed from: a, reason: collision with root package name */
    private b<IN> f20648a;

    public m(b<IN> bVar) {
        this.f20648a = bVar;
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final <I> I a(Class<? extends d<I, ?>> cls) {
        return (I) this.f20648a.a((Class) cls);
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final Object a(IN in2) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Override // com.bykv.vk.openvk.preload.b.b
    public final <O> O b(Class<? extends d<?, O>> cls) {
        return (O) this.f20648a.b(cls);
    }
}
