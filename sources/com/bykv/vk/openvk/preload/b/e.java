package com.bykv.vk.openvk.preload.b;

/* loaded from: classes2.dex */
public interface e {

    /* loaded from: classes2.dex */
    public static class a implements e {
        @Override // com.bykv.vk.openvk.preload.b.e
        public final <T> T a(Class<T> cls) {
            try {
                return cls.newInstance();
            } catch (Exception e11) {
                throw new RuntimeException(e11);
            }
        }
    }

    <T> T a(Class<T> cls);
}
