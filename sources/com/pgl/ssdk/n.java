package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import okhttp3.internal.http2.Settings;

/* loaded from: classes5.dex */
public abstract class n {
    public static int a(ByteBuffer byteBuffer, int i11) {
        return byteBuffer.getShort(i11) & 65535;
    }

    public static m<ByteBuffer, Long> a(o oVar) throws IOException {
        if (oVar.a() < 22) {
            return null;
        }
        m<ByteBuffer, Long> a11 = a(oVar, 0);
        return a11 != null ? a11 : a(oVar, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
    }

    private static m<ByteBuffer, Long> a(o oVar, int i11) throws IOException {
        if (i11 < 0 || i11 > 65535) {
            throw new IllegalArgumentException("maxCommentSize: ".concat(String.valueOf(i11)));
        }
        long a11 = oVar.a();
        if (a11 < 22) {
            return null;
        }
        int min = ((int) Math.min(i11, a11 - 22)) + 22;
        long j11 = a11 - min;
        ByteBuffer a12 = oVar.a(j11, min);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        a12.order(byteOrder);
        int b11 = b(a12);
        if (b11 == -1) {
            return null;
        }
        a12.position(b11);
        ByteBuffer slice = a12.slice();
        slice.order(byteOrder);
        return m.a(slice, Long.valueOf(j11 + b11));
    }

    static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    private static int b(ByteBuffer byteBuffer) {
        a(byteBuffer);
        int capacity = byteBuffer.capacity();
        if (capacity < 22) {
            return -1;
        }
        int i11 = capacity - 22;
        int min = Math.min(i11, Settings.DEFAULT_INITIAL_WINDOW_SIZE);
        for (int i12 = 0; i12 <= min; i12++) {
            int i13 = i11 - i12;
            if (byteBuffer.getInt(i13) == 101010256 && a(byteBuffer, i13 + 20) == i12) {
                return i13;
            }
        }
        return -1;
    }

    static long b(ByteBuffer byteBuffer, int i11) {
        return byteBuffer.getInt(i11) & 4294967295L;
    }

    public static long c(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 16);
    }

    public static long d(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return b(byteBuffer, byteBuffer.position() + 12);
    }

    public static int e(ByteBuffer byteBuffer) {
        a(byteBuffer);
        return a(byteBuffer, byteBuffer.position() + 10);
    }
}
