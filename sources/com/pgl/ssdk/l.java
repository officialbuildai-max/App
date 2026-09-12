package com.pgl.ssdk;

import java.io.IOException;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: classes5.dex */
public class l implements o {

    /* renamed from: a, reason: collision with root package name */
    private final FileChannel f40230a;

    /* renamed from: b, reason: collision with root package name */
    private final long f40231b;

    /* renamed from: c, reason: collision with root package name */
    private final long f40232c;

    public l(FileChannel fileChannel, long j11, long j12) {
        if (j11 < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j12)));
        }
        if (j12 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j12)));
        }
        this.f40230a = fileChannel;
        this.f40231b = j11;
        this.f40232c = j12;
    }

    private static void a(long j11, long j12, long j13) {
        if (j11 < 0) {
            throw new IndexOutOfBoundsException("offset: ".concat(String.valueOf(j11)));
        }
        if (j12 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(j12)));
        }
        if (j11 > j13) {
            throw new IndexOutOfBoundsException("offset (" + j11 + ") > source size (" + j13 + ")");
        }
        long j14 = j11 + j12;
        if (j14 < j11) {
            throw new IndexOutOfBoundsException("offset (" + j11 + ") + size (" + j12 + ") overflow");
        }
        if (j14 <= j13) {
            return;
        }
        throw new IndexOutOfBoundsException("offset (" + j11 + ") + size (" + j12 + ") > source size (" + j13 + ")");
    }

    @Override // com.pgl.ssdk.o
    public long a() {
        long j11 = this.f40232c;
        if (j11 != -1) {
            return j11;
        }
        try {
            return this.f40230a.size();
        } catch (IOException unused) {
            return 0L;
        }
    }

    @Override // com.pgl.ssdk.o
    public ByteBuffer a(long j11, int i11) throws IOException {
        if (i11 < 0) {
            throw new IndexOutOfBoundsException("size: ".concat(String.valueOf(i11)));
        }
        ByteBuffer allocate = ByteBuffer.allocate(i11);
        a(j11, i11, allocate);
        allocate.flip();
        return allocate;
    }

    public void a(long j11, int i11, ByteBuffer byteBuffer) throws IOException {
        int read;
        a(j11, i11, a());
        if (i11 == 0) {
            return;
        }
        if (i11 > byteBuffer.remaining()) {
            throw new BufferOverflowException();
        }
        long j12 = this.f40231b + j11;
        int limit = byteBuffer.limit();
        try {
            byteBuffer.limit(byteBuffer.position() + i11);
            while (i11 > 0) {
                synchronized (this.f40230a) {
                    this.f40230a.position(j12);
                    read = this.f40230a.read(byteBuffer);
                }
                j12 += read;
                i11 -= read;
            }
        } finally {
            byteBuffer.limit(limit);
        }
    }

    @Override // com.pgl.ssdk.o
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public l a(long j11, long j12) {
        long a11 = a();
        a(j11, j12, a11);
        return (j11 == 0 && j12 == a11) ? this : new l(this.f40230a, this.f40231b + j11, j12);
    }
}
