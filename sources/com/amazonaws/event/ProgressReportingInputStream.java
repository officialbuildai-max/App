package com.amazonaws.event;

import com.amazonaws.internal.SdkFilterInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class ProgressReportingInputStream extends SdkFilterInputStream {

    /* renamed from: a, reason: collision with root package name */
    private int f18455a;

    /* renamed from: b, reason: collision with root package name */
    private final ProgressListenerCallbackExecutor f18456b;

    /* renamed from: c, reason: collision with root package name */
    private int f18457c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f18458d;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListenerCallbackExecutor progressListenerCallbackExecutor) {
        super(inputStream);
        this.f18455a = 8192;
        this.f18456b = progressListenerCallbackExecutor;
    }

    private void l(int i11) {
        int i12 = this.f18457c + i11;
        this.f18457c = i12;
        if (i12 >= this.f18455a) {
            this.f18456b.c(new ProgressEvent(i12));
            this.f18457c = 0;
        }
    }

    private void m() {
        if (this.f18458d) {
            ProgressEvent progressEvent = new ProgressEvent(this.f18457c);
            progressEvent.c(4);
            this.f18457c = 0;
            this.f18456b.c(progressEvent);
        }
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        int i11 = this.f18457c;
        if (i11 > 0) {
            this.f18456b.c(new ProgressEvent(i11));
            this.f18457c = 0;
        }
        super.close();
    }

    public void n(boolean z10) {
        this.f18458d = z10;
    }

    public void o(int i11) {
        this.f18455a = i11 * 1024;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read() {
        int read = super.read();
        if (read == -1) {
            m();
        } else {
            l(1);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i11, int i12) {
        int read = super.read(bArr, i11, i12);
        if (read == -1) {
            m();
        }
        if (read != -1) {
            l(read);
        }
        return read;
    }

    @Override // com.amazonaws.internal.SdkFilterInputStream, java.io.FilterInputStream, java.io.InputStream
    public void reset() {
        super.reset();
        ProgressEvent progressEvent = new ProgressEvent(this.f18457c);
        progressEvent.c(32);
        this.f18456b.c(progressEvent);
        this.f18457c = 0;
    }
}
