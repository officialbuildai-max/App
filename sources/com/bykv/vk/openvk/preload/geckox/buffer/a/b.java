package com.bykv.vk.openvk.preload.geckox.buffer.a;

import com.bykv.vk.openvk.preload.geckox.utils.CloseableUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
final class b implements com.bykv.vk.openvk.preload.geckox.buffer.a {

    /* renamed from: a, reason: collision with root package name */
    private RandomAccessFile f20721a;

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f20722b = new AtomicBoolean(false);

    /* renamed from: c, reason: collision with root package name */
    private File f20723c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(File file) throws IOException {
        this.f20723c = file;
        file.getParentFile().mkdirs();
        try {
            this.f20721a = new RandomAccessFile(file, "rw");
        } catch (Exception e11) {
            CloseableUtils.close(this.f20721a);
            throw new IOException("create raf mSwap failed! path: " + file.getAbsolutePath() + " caused by: " + e11.getMessage(), e11);
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int a(byte[] bArr, int i11, int i12) throws IOException {
        if (this.f20722b.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || bArr.length == 0 || i12 <= 0 || i11 < 0 || i11 >= bArr.length) {
            return 0;
        }
        if (i11 + i12 > bArr.length) {
            i12 = bArr.length - i11;
        }
        synchronized (this) {
            this.f20721a.write(bArr, i11, i12);
        }
        return i12;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final synchronized long a(long j11) throws IOException {
        if (this.f20722b.get()) {
            throw new IOException("released!");
        }
        if (((int) j11) != j11) {
            throw new IOException("too large:".concat(String.valueOf(j11)));
        }
        return this.f20721a.skipBytes(r0);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void a() throws IOException {
        if (this.f20722b.get()) {
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
        int read;
        if (this.f20722b.get()) {
            throw new IOException("released!");
        }
        if (bArr == null || i12 <= 0 || i11 < 0 || i11 >= bArr.length) {
            return 0;
        }
        if (i11 + i12 > bArr.length) {
            i12 = bArr.length - i11;
        }
        synchronized (this) {
            read = this.f20721a.read(bArr, i11, i12);
        }
        return read;
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long b() throws IOException {
        return this.f20721a.length();
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void b(long j11) throws IOException {
        if (this.f20722b.get()) {
            throw new IOException("released!");
        }
        if (j11 < 0) {
            j11 = 0;
        }
        this.f20721a.seek(j11);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final long c() throws IOException {
        if (this.f20722b.get()) {
            throw new IOException("released!");
        }
        return this.f20721a.getFilePointer();
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final int d() throws IOException {
        byte[] bArr = new byte[1];
        if (b(bArr) <= 0) {
            return -1;
        }
        return bArr[0];
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final void e() {
        if (this.f20722b.getAndSet(true)) {
            return;
        }
        CloseableUtils.close(this.f20721a);
    }

    @Override // com.bykv.vk.openvk.preload.geckox.buffer.a
    public final File f() {
        return this.f20723c;
    }
}
