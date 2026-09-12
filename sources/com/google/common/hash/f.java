package com.google.common.hash;

/* loaded from: classes4.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    static final int f30934a = (int) System.currentTimeMillis();

    public static d a() {
        return Murmur3_128HashFunction.MURMUR3_128;
    }

    public static d b(int i11) {
        return new Murmur3_128HashFunction(i11);
    }
}
