package com.google.android.exoplayer2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final File f27608a;

    /* renamed from: b, reason: collision with root package name */
    private final File f27609b;

    /* loaded from: classes3.dex */
    private static final class a extends OutputStream {

        /* renamed from: a, reason: collision with root package name */
        private final FileOutputStream f27610a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f27611b = false;

        public a(File file) {
            this.f27610a = new FileOutputStream(file);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f27611b) {
                return;
            }
            this.f27611b = true;
            flush();
            try {
                this.f27610a.getFD().sync();
            } catch (IOException e11) {
                s.j("AtomicFile", "Failed to sync file descriptor:", e11);
            }
            this.f27610a.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f27610a.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i11) {
            this.f27610a.write(i11);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f27610a.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i11, int i12) {
            this.f27610a.write(bArr, i11, i12);
        }
    }

    public b(File file) {
        this.f27608a = file;
        this.f27609b = new File(file.getPath() + ".bak");
    }

    private void e() {
        if (this.f27609b.exists()) {
            this.f27608a.delete();
            this.f27609b.renameTo(this.f27608a);
        }
    }

    public void a() {
        this.f27608a.delete();
        this.f27609b.delete();
    }

    public void b(OutputStream outputStream) {
        outputStream.close();
        this.f27609b.delete();
    }

    public boolean c() {
        return this.f27608a.exists() || this.f27609b.exists();
    }

    public InputStream d() {
        e();
        return new FileInputStream(this.f27608a);
    }

    public OutputStream f() {
        if (this.f27608a.exists()) {
            if (this.f27609b.exists()) {
                this.f27608a.delete();
            } else if (!this.f27608a.renameTo(this.f27609b)) {
                s.i("AtomicFile", "Couldn't rename file " + this.f27608a + " to backup file " + this.f27609b);
            }
        }
        try {
            return new a(this.f27608a);
        } catch (FileNotFoundException e11) {
            File parentFile = this.f27608a.getParentFile();
            if (parentFile == null || !parentFile.mkdirs()) {
                throw new IOException("Couldn't create " + this.f27608a, e11);
            }
            try {
                return new a(this.f27608a);
            } catch (FileNotFoundException e12) {
                throw new IOException("Couldn't create " + this.f27608a, e12);
            }
        }
    }
}
