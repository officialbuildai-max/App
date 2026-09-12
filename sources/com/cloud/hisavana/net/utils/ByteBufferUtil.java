package com.cloud.hisavana.net.utils;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class ByteBufferUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicReference f21501a = new AtomicReference();

    /* loaded from: classes3.dex */
    private static class ByteBufferStream extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        private final ByteBuffer f21502a;

        /* renamed from: b, reason: collision with root package name */
        private int f21503b;

        @Override // java.io.InputStream
        public int available() {
            return this.f21502a.remaining();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i11) {
            this.f21503b = this.f21502a.position();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f21502a.hasRemaining()) {
                return this.f21502a.get();
            }
            return -1;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            if (!this.f21502a.hasRemaining()) {
                return -1;
            }
            int min = Math.min(i12, available());
            this.f21502a.get(bArr, i11, min);
            return min;
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            int i11 = this.f21503b;
            if (i11 == -1) {
                throw new IOException("Cannot reset to unset mark position");
            }
            this.f21502a.position(i11);
        }

        @Override // java.io.InputStream
        public long skip(long j11) {
            if (!this.f21502a.hasRemaining()) {
                return -1L;
            }
            long min = Math.min(j11, available());
            this.f21502a.position((int) (r0.position() + min));
            return min;
        }
    }

    /* loaded from: classes3.dex */
    public static class ContentLengthInputStream extends InputStream {

        /* renamed from: a, reason: collision with root package name */
        private final InputStream f21504a;

        /* renamed from: b, reason: collision with root package name */
        private final int f21505b;

        @Override // java.io.InputStream
        public int available() {
            return this.f21505b;
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f21504a.close();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i11) {
            this.f21504a.mark(i11);
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f21504a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            return this.f21504a.read();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return this.f21504a.read(bArr);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i11, int i12) {
            return this.f21504a.read(bArr, i11, i12);
        }

        @Override // java.io.InputStream
        public synchronized void reset() {
            this.f21504a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j11) {
            return this.f21504a.skip(j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class SafeArray {

        /* renamed from: a, reason: collision with root package name */
        private final int f21506a;

        /* renamed from: b, reason: collision with root package name */
        private final int f21507b;

        /* renamed from: c, reason: collision with root package name */
        private final byte[] f21508c;

        public SafeArray(byte[] bArr, int i11, int i12) {
            this.f21508c = bArr;
            this.f21506a = i11;
            this.f21507b = i12;
        }
    }

    private ByteBufferUtil() {
    }

    public static ByteBuffer a(File file) {
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel = null;
        try {
            randomAccessFile = new RandomAccessFile(file, CampaignEx.JSON_KEY_AD_R);
            try {
                fileChannel = randomAccessFile.getChannel();
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, file.length()).load();
                try {
                    fileChannel.close();
                } catch (IOException unused) {
                }
                try {
                    randomAccessFile.close();
                } catch (IOException unused2) {
                }
                return load;
            } catch (Throwable th2) {
                th = th2;
                if (fileChannel != null) {
                    try {
                        fileChannel.close();
                    } catch (IOException unused3) {
                    }
                }
                if (randomAccessFile == null) {
                    throw th;
                }
                try {
                    randomAccessFile.close();
                    throw th;
                } catch (IOException unused4) {
                    throw th;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            randomAccessFile = null;
        }
    }

    private static SafeArray b(ByteBuffer byteBuffer) {
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            return null;
        }
        return new SafeArray(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
    }

    public static byte[] c(ByteBuffer byteBuffer) {
        SafeArray b11 = b(byteBuffer);
        if (b11 != null && b11.f21506a == 0 && b11.f21507b == b11.f21508c.length) {
            return byteBuffer.array();
        }
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        byte[] bArr = new byte[asReadOnlyBuffer.limit()];
        asReadOnlyBuffer.position(0);
        asReadOnlyBuffer.get(bArr);
        return bArr;
    }
}
