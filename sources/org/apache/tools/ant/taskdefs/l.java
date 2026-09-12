package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes7.dex */
public class l implements h {

    /* renamed from: a, reason: collision with root package name */
    private Thread f71530a;

    /* renamed from: b, reason: collision with root package name */
    private Thread f71531b;

    /* renamed from: c, reason: collision with root package name */
    private StreamPumper f71532c;

    /* renamed from: d, reason: collision with root package name */
    private OutputStream f71533d;

    /* renamed from: e, reason: collision with root package name */
    private OutputStream f71534e;

    /* renamed from: f, reason: collision with root package name */
    private InputStream f71535f;

    public l() {
        this(System.out, System.err);
    }

    public l(OutputStream outputStream) {
        this(outputStream, outputStream);
    }

    public l(OutputStream outputStream, OutputStream outputStream2) {
        this(outputStream, outputStream2, null);
    }

    public l(OutputStream outputStream, OutputStream outputStream2, InputStream inputStream) {
        this.f71533d = outputStream;
        this.f71534e = outputStream2;
        this.f71535f = inputStream;
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void a(InputStream inputStream) {
        OutputStream outputStream = this.f71534e;
        if (outputStream != null) {
            e(inputStream, outputStream);
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void b(OutputStream outputStream) {
        InputStream inputStream = this.f71535f;
        if (inputStream != null) {
            this.f71532c = d(inputStream, outputStream, true);
        } else {
            try {
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void c(InputStream inputStream) {
        f(inputStream, this.f71533d);
    }

    StreamPumper d(InputStream inputStream, OutputStream outputStream, boolean z10) {
        StreamPumper streamPumper = new StreamPumper(inputStream, outputStream, z10);
        streamPumper.setAutoflush(true);
        return streamPumper;
    }

    protected void e(InputStream inputStream, OutputStream outputStream) {
        this.f71531b = g(inputStream, outputStream);
    }

    protected void f(InputStream inputStream, OutputStream outputStream) {
        this.f71530a = g(inputStream, outputStream);
    }

    protected Thread g(InputStream inputStream, OutputStream outputStream) {
        return h(inputStream, outputStream, false);
    }

    protected Thread h(InputStream inputStream, OutputStream outputStream, boolean z10) {
        Thread thread = new Thread(new StreamPumper(inputStream, outputStream, z10));
        thread.setDaemon(true);
        return thread;
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void start() {
        this.f71530a.start();
        this.f71531b.start();
        if (this.f71532c != null) {
            Thread thread = new Thread(this.f71532c);
            thread.setDaemon(true);
            thread.start();
        }
    }

    @Override // org.apache.tools.ant.taskdefs.h
    public void stop() {
        try {
            this.f71530a.join();
        } catch (InterruptedException unused) {
        }
        try {
            this.f71531b.join();
        } catch (InterruptedException unused2) {
        }
        StreamPumper streamPumper = this.f71532c;
        if (streamPumper != null) {
            streamPumper.stop();
        }
        try {
            this.f71534e.flush();
        } catch (IOException unused3) {
        }
        try {
            this.f71533d.flush();
        } catch (IOException unused4) {
        }
    }
}
