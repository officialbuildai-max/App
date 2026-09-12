package org.apache.tools.ant.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes7.dex */
public class h extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private FileOutputStream f71704a;

    /* renamed from: b, reason: collision with root package name */
    private File f71705b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f71706c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f71707d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71708e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f71709f = false;

    public h(File file, boolean z10, boolean z11) {
        this.f71705b = file;
        this.f71706c = z10;
        this.f71707d = z11;
    }

    private synchronized void d() {
        if (this.f71709f) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.f71705b);
            stringBuffer.append(" has already been closed.");
            throw new IOException(stringBuffer.toString());
        }
        if (!this.f71708e) {
            this.f71704a = new FileOutputStream(this.f71705b.getAbsolutePath(), this.f71706c);
            this.f71708e = true;
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        try {
            if (this.f71707d && !this.f71709f) {
                d();
            }
            if (this.f71708e) {
                this.f71704a.close();
            }
            this.f71709f = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i11) {
        d();
        this.f71704a.write(i11);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i11, int i12) {
        d();
        this.f71704a.write(bArr, i11, i12);
    }
}
