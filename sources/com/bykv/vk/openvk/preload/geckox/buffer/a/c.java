package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class c implements com.bykv.vk.openvk.preload.geckox.buffer.a {

    /* renamed from: a, reason: collision with root package name */
    private long f20724a;

    /* renamed from: b, reason: collision with root package name */
    private long f20725b;

    /* renamed from: c, reason: collision with root package name */
    private RandomAccessFile f20726c;

    /* renamed from: d, reason: collision with root package name */
    private AtomicBoolean f20727d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private File f20728e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(long j11, File file) throws IOException {
        this.f20724a = j11;
        this.f20728e = file;
        file.getParentFile().mkdirs();
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            this.f20726c = randomAccessFile;
            randomAccessFile.setLength(j11);
        } catch (Exception e11) {
            CloseableUtils.close(this.f20726c);
            throw new IOException("create raf swap failed! path: " + file.getAbsolutePath() + " caused by: " + e11.getMessage(), e11);
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int a(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f20727d.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || bArr.length == 0 || i12 <= 0 || i11 < 0 || i11 >= bArr.length) {
            return 0;
        }
        if (i11 + i12 > bArr.length) {
            i12 = bArr.length - i11;
        }
        synchronized (this) {
            try {
                long j11 = this.f20725b;
                long j12 = this.f20724a;
                if (j11 == j12) {
                    return 0;
                }
                if (i12 + j11 > j12) {
                    i12 = (int) (j12 - j11);
                }
                this.f20726c.write(bArr, i11, i12);
                this.f20725b += i12;
                return i12;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final synchronized long a(long j11) throws IOException {
        int skipBytes;
        if (this.f20727d.get()) {
            throw new IOException("released!");
        }
        int i11 = (int) j11;
        if (i11 != j11) {
            throw new IOException("too large:".concat(String.valueOf(j11)));
        }
        skipBytes = this.f20726c.skipBytes(i11);
        this.f20725b = this.f20726c.getFilePointer();
        return skipBytes;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a() throws IOException {
        if (this.f20727d.get()) {
            throw new IOException("released!");
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a(int i11) throws IOException {
        a(new byte[]{(byte) i11});
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a(byte[] bArr) throws IOException {
        a(bArr, 0, bArr.length);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr) throws IOException {
        return b(bArr, 0, bArr.length);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int b(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f20727d.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || i12 <= 0 || i11 < 0 || i11 >= bArr.length) {
            return 0;
        }
        if (i11 + i12 > bArr.length) {
            i12 = bArr.length - i11;
        }
        synchronized (this) {
            try {
                long j11 = this.f20725b;
                long j12 = this.f20724a;
                if (j11 == j12) {
                    return -1;
                }
                if (i12 + j11 > j12) {
                    i12 = (int) (j12 - j11);
                }
                int read = this.f20726c.read(bArr, i11, i12);
                if (read == -1) {
                    return -1;
                }
                this.f20725b += read;
                return read;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long b() {
        return this.f20724a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0014, code lost:
    
        if (r4 > r0) goto L6;
     */
    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(long r4) throws java.io.IOException {
        /*
            r3 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r3.f20727d
            boolean r0 = r0.get()
            if (r0 != 0) goto L1f
            r0 = 0
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 >= 0) goto L10
        Le:
            r4 = r0
            goto L17
        L10:
            long r0 = r3.f20724a
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L17
            goto Le
        L17:
            r3.f20725b = r4
            java.io.RandomAccessFile r0 = r3.f20726c
            r0.seek(r4)
            return
        L1f:
            java.io.IOException r4 = new java.io.IOException
            java.lang.String r5 = "released!"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.geckox.buffer.a.c.b(long):void");
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long c() throws IOException {
        if (this.f20727d.get()) {
            throw new IOException("released!");
        }
        return this.f20725b;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) == 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void e() {
        if (this.f20727d.getAndSet(true)) {
            return;
        }
        CloseableUtils.close(this.f20726c);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final File f() {
        return this.f20728e;
    }
}
