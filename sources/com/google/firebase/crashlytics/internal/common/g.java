package com.google.firebase.crashlytics.internal.common;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes4.dex */
class g {

    /* renamed from: b, reason: collision with root package name */
    private static final String f31231b = CommonUtils.z(UUID.randomUUID().toString() + System.currentTimeMillis());

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicLong f31232c = new AtomicLong(0);

    /* renamed from: a, reason: collision with root package name */
    private final String f31233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g() {
        byte[] bArr = new byte[10];
        f(bArr);
        e(bArr);
        d(bArr);
        String t11 = CommonUtils.t(bArr);
        Locale locale = Locale.US;
        this.f31233a = String.format(locale, "%s%s%s%s", t11.substring(0, 12), t11.substring(12, 16), t11.subSequence(16, 20), f31231b.substring(0, 12)).toUpperCase(locale);
    }

    private static byte[] a(long j11) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j11);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j11) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) j11);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void d(byte[] bArr) {
        byte[] b11 = b(Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b11[0];
        bArr[9] = b11[1];
    }

    private void e(byte[] bArr) {
        byte[] b11 = b(f31232c.incrementAndGet());
        bArr[6] = b11[0];
        bArr[7] = b11[1];
    }

    private void f(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a11 = a(time / 1000);
        bArr[0] = a11[0];
        bArr[1] = a11[1];
        bArr[2] = a11[2];
        bArr[3] = a11[3];
        byte[] b11 = b(time % 1000);
        bArr[4] = b11[0];
        bArr[5] = b11[1];
    }

    public String c() {
        return this.f31233a;
    }

    public String toString() {
        return this.f31233a;
    }
}
