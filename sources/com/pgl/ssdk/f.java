package com.pgl.ssdk;

import com.pgl.ssdk.c;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public class f {

    /* loaded from: classes5.dex */
    public static class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public static h a(o oVar, c.a aVar, int i11) throws IOException, a {
        try {
            return g.a(oVar, aVar, i11);
        } catch (i e11) {
            throw new a(e11.getMessage());
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return g.b(byteBuffer);
    }

    public static byte[] b(ByteBuffer byteBuffer) throws com.pgl.ssdk.a {
        return g.c(byteBuffer);
    }
}
