package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public abstract class c {

    /* loaded from: classes5.dex */
    public static class a extends r {
        public a(long j11, long j12, int i11, long j13, ByteBuffer byteBuffer) {
            super(j11, j12, i11, j13, byteBuffer);
        }
    }

    public static a a(o oVar) throws IOException, q {
        r a11 = d.a(oVar);
        return new a(a11.a(), a11.c(), a11.b(), a11.e(), a11.d());
    }
}
