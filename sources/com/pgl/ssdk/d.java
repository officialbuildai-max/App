package com.pgl.ssdk;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes5.dex */
public class d {

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f40182a;

        /* renamed from: b, reason: collision with root package name */
        private final o f40183b;

        public a(long j11, o oVar) {
            this.f40182a = j11;
            this.f40183b = oVar;
        }

        public o a() {
            return this.f40183b;
        }

        public long b() {
            return this.f40182a;
        }
    }

    public static a a(o oVar, r rVar) throws IOException, b {
        long a11 = rVar.a();
        long c11 = rVar.c() + a11;
        long e11 = rVar.e();
        if (c11 != e11) {
            throw new b("ZIP Central Directory is not immediately followed by End of Central Directory. CD end: " + c11 + ", EoCD start: " + e11);
        }
        if (a11 < 32) {
            throw new b("APK too small for APK Signing Block. ZIP Central Directory offset: ".concat(String.valueOf(a11)));
        }
        ByteBuffer a12 = oVar.a(a11 - 24, 24);
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        a12.order(byteOrder);
        if (a12.getLong(8) != 2334950737559900225L || a12.getLong(16) != 3617552046287187010L) {
            throw new b("No APK Signing Block before ZIP Central Directory");
        }
        long j11 = a12.getLong(0);
        if (j11 < a12.capacity() || j11 > 2147483639) {
            throw new b("APK Signing Block size out of range: ".concat(String.valueOf(j11)));
        }
        long j12 = (int) (8 + j11);
        long j13 = a11 - j12;
        if (j13 < 0) {
            throw new b("APK Signing Block offset out of range: ".concat(String.valueOf(j13)));
        }
        ByteBuffer a13 = oVar.a(j13, 8);
        a13.order(byteOrder);
        long j14 = a13.getLong(0);
        if (j14 == j11) {
            return new a(j13, oVar.a(j13, j12));
        }
        throw new b("APK Signing Block sizes in header and footer do not match: " + j14 + " vs " + j11);
    }

    public static r a(o oVar) throws IOException, q {
        m<ByteBuffer, Long> a11 = n.a(oVar);
        if (a11 == null) {
            throw new q("ZIP End of Central Directory record not found");
        }
        ByteBuffer a12 = a11.a();
        long longValue = a11.b().longValue();
        a12.order(ByteOrder.LITTLE_ENDIAN);
        long c11 = n.c(a12);
        if (c11 > longValue) {
            throw new q("ZIP Central Directory start offset out of range: " + c11 + ". ZIP End of Central Directory offset: " + longValue);
        }
        long d11 = n.d(a12);
        long j11 = c11 + d11;
        if (j11 <= longValue) {
            return new r(c11, d11, n.e(a12), longValue, a12);
        }
        throw new q("ZIP Central Directory overlaps with End of Central Directory. CD end: " + j11 + ", EoCD start: " + longValue);
    }
}
