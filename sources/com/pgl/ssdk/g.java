package com.pgl.ssdk;

import com.pgl.ssdk.d;
import java.io.IOException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f40186a = "0123456789abcdef".toCharArray();

    public static h a(o oVar, r rVar, int i11) throws IOException, i {
        try {
            d.a a11 = d.a(oVar, rVar);
            long b11 = a11.b();
            o a12 = a11.a();
            ByteBuffer a13 = a12.a(0L, (int) a12.a());
            a13.order(ByteOrder.LITTLE_ENDIAN);
            return new h(a(a13, i11), b11, rVar.a(), rVar.e(), rVar.d());
        } catch (b e11) {
            throw new i(e11.getMessage(), e11);
        }
    }

    public static ByteBuffer a(ByteBuffer byteBuffer, int i11) throws i {
        a(byteBuffer);
        ByteBuffer a11 = a(byteBuffer, 8, byteBuffer.capacity() - 24);
        int i12 = 0;
        while (a11.hasRemaining()) {
            i12++;
            if (a11.remaining() < 8) {
                throw new i("Insufficient data to read size of APK Signing Block entry #".concat(String.valueOf(i12)));
            }
            long j11 = a11.getLong();
            if (j11 < 4 || j11 > 2147483647L) {
                throw new i("APK Signing Block entry #" + i12 + " size out of range: " + j11);
            }
            int i13 = (int) j11;
            int position = a11.position() + i13;
            if (i13 > a11.remaining()) {
                throw new i("APK Signing Block entry #" + i12 + " size out of range: " + i13 + ", available: " + a11.remaining());
            }
            if (a11.getInt() == i11) {
                return b(a11, i13 - 4);
            }
            a11.position(position);
        }
        throw new i("No APK Signature Scheme block in APK Signing Block with ID: ".concat(String.valueOf(i11)));
    }

    private static ByteBuffer a(ByteBuffer byteBuffer, int i11, int i12) {
        if (i11 < 0) {
            throw new IllegalArgumentException("start: ".concat(String.valueOf(i11)));
        }
        if (i12 < i11) {
            throw new IllegalArgumentException("end < start: " + i12 + " < " + i11);
        }
        int capacity = byteBuffer.capacity();
        if (i12 > byteBuffer.capacity()) {
            throw new IllegalArgumentException("end > capacity: " + i12 + " > " + capacity);
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        try {
            byteBuffer.position(0);
            byteBuffer.limit(i12);
            byteBuffer.position(i11);
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            return slice;
        } finally {
            byteBuffer.position(0);
            byteBuffer.limit(limit);
            byteBuffer.position(position);
        }
    }

    public static void a(ByteBuffer byteBuffer) {
        if (byteBuffer.order() != ByteOrder.LITTLE_ENDIAN) {
            throw new IllegalArgumentException("ByteBuffer byte order must be little endian");
        }
    }

    public static ByteBuffer b(ByteBuffer byteBuffer) throws a {
        if (byteBuffer.remaining() < 4) {
            throw new a("Remaining buffer too short to contain length of length-prefixed field. Remaining: " + byteBuffer.remaining());
        }
        int i11 = byteBuffer.getInt();
        if (i11 < 0) {
            throw new IllegalArgumentException("Negative length");
        }
        if (i11 <= byteBuffer.remaining()) {
            return b(byteBuffer, i11);
        }
        throw new a("Length-prefixed field longer than remaining buffer. Field length: " + i11 + ", remaining: " + byteBuffer.remaining());
    }

    private static ByteBuffer b(ByteBuffer byteBuffer, int i11) {
        if (i11 < 0) {
            throw new IllegalArgumentException("size: ".concat(String.valueOf(i11)));
        }
        int limit = byteBuffer.limit();
        int position = byteBuffer.position();
        int i12 = i11 + position;
        if (i12 < position || i12 > limit) {
            throw new BufferUnderflowException();
        }
        byteBuffer.limit(i12);
        try {
            ByteBuffer slice = byteBuffer.slice();
            slice.order(byteBuffer.order());
            byteBuffer.position(i12);
            return slice;
        } finally {
            byteBuffer.limit(limit);
        }
    }

    public static byte[] c(ByteBuffer byteBuffer) throws a {
        int i11 = byteBuffer.getInt();
        if (i11 < 0) {
            throw new a("Negative length");
        }
        if (i11 <= byteBuffer.remaining()) {
            byte[] bArr = new byte[i11];
            byteBuffer.get(bArr);
            return bArr;
        }
        throw new a("Underflow while reading length-prefixed value. Length: " + i11 + ", available: " + byteBuffer.remaining());
    }
}
