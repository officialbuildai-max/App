package androidx.media3.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final File f10449a;

    /* renamed from: b, reason: collision with root package name */
    private final File f10450b;

    /* loaded from: classes2.dex */
    private static final class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final FileOutputStream f10451a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f10452b = false;

        public a(File file) {
            this.f10451a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f10452b) {
                return;
            }
            this.f10452b = true;
            flush();
            try {
                this.f10451a.getFD().sync();
            } catch (IOException e11) {
                u.i("AtomicFile", "Failed to sync file descriptor:", e11);
            }
            this.f10451a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f10451a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i11) {
            this.f10451a.write(i11);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f10451a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i11, int i12) {
            this.f10451a.write(bArr, i11, i12);
        }
    }

    public b(File file) {
        this.f10449a = file;
        this.f10450b = new File(file.getPath() + ".bak");
    }

    private void e() {
        if (this.f10450b.exists()) {
            this.f10449a.delete();
            this.f10450b.renameTo(this.f10449a);
        }
    }

    public void a() {
        this.f10449a.delete();
        this.f10450b.delete();
    }

    public void b(OutputStream outputStream) {
        outputStream.close();
        this.f10450b.delete();
    }

    public boolean c() {
        return this.f10449a.exists() || this.f10450b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.f10449a);
    }

    public OutputStream f() {
        if (this.f10449a.exists()) {
            if (this.f10450b.exists()) {
                this.f10449a.delete();
            } else if (!this.f10449a.renameTo(this.f10450b)) {
                u.h("AtomicFile", "Couldn't rename file " + this.f10449a + " to backup file " + this.f10450b);
            }
        }
        try {
            return new a(this.f10449a);
        } catch (FileNotFoundException e11) {
            File parentFile = this.f10449a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f10449a, e11);
            }
            try {
                return new a(this.f10449a);
            } catch (FileNotFoundException e12) {
                throw new IOException("Couldn't create " + this.f10449a, e12);
            }
        }
    }
}
