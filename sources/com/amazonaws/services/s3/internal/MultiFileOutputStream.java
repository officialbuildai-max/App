package com.amazonaws.services.s3.internal;

import com.amazonaws.AbortedException;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.OnFileDelete;
import com.amazonaws.services.s3.UploadObjectObserver;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
public class MultiFileOutputStream extends OutputStream implements OnFileDelete {

    /* renamed from: c, reason: collision with root package name */
    private int f18717c;

    /* renamed from: f, reason: collision with root package name */
    private UploadObjectObserver f18720f;

    /* renamed from: g, reason: collision with root package name */
    private int f18721g;

    /* renamed from: h, reason: collision with root package name */
    private long f18722h;

    /* renamed from: i, reason: collision with root package name */
    private FileOutputStream f18723i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f18724j;

    /* renamed from: k, reason: collision with root package name */
    private Semaphore f18725k;

    /* renamed from: d, reason: collision with root package name */
    private long f18718d = 5242880;

    /* renamed from: e, reason: collision with root package name */
    private long f18719e = Long.MAX_VALUE;

    /* renamed from: a, reason: collision with root package name */
    private final File f18715a = new File(System.getProperty("java.io.tmpdir"));

    /* renamed from: b, reason: collision with root package name */
    private final String f18716b = k() + "." + UUID.randomUUID();

    private void d() {
        Semaphore semaphore = this.f18725k;
        if (semaphore == null || this.f18719e == Long.MAX_VALUE) {
            return;
        }
        try {
            semaphore.acquire();
        } catch (InterruptedException e11) {
            throw new AbortedException(e11);
        }
    }

    private FileOutputStream h() {
        if (this.f18724j) {
            throw new IOException("Output stream is already closed");
        }
        FileOutputStream fileOutputStream = this.f18723i;
        if (fileOutputStream == null || this.f18721g >= this.f18718d) {
            if (fileOutputStream != null) {
                fileOutputStream.close();
                this.f18720f.c(new PartCreationEvent(i(this.f18717c), this.f18717c, false, this));
            }
            this.f18721g = 0;
            this.f18717c++;
            d();
            File i11 = i(this.f18717c);
            i11.deleteOnExit();
            this.f18723i = new FileOutputStream(i11);
        }
        return this.f18723i;
    }

    static String k() {
        return new SimpleDateFormat("yyMMdd-hhmmss").format(new Date());
    }

    @Override // com.amazonaws.services.s3.OnFileDelete
    public void b(FileDeletionEvent fileDeletionEvent) {
        Semaphore semaphore = this.f18725k;
        if (semaphore != null) {
            semaphore.release();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f18724j) {
            return;
        }
        this.f18724j = true;
        FileOutputStream fileOutputStream = this.f18723i;
        if (fileOutputStream != null) {
            fileOutputStream.close();
            File i11 = i(this.f18717c);
            if (i11.length() != 0) {
                this.f18720f.c(new PartCreationEvent(i(this.f18717c), this.f18717c, true, this));
                return;
            }
            if (i11.delete()) {
                return;
            }
            LogFactory.b(getClass()).a("Ignoring failure to delete empty file " + i11);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        FileOutputStream fileOutputStream = this.f18723i;
        if (fileOutputStream != null) {
            fileOutputStream.flush();
        }
    }

    public File i(int i11) {
        return new File(this.f18715a, this.f18716b + "." + i11);
    }

    @Override // java.io.OutputStream
    public void write(int i11) {
        h().write(i11);
        this.f18721g++;
        this.f18722h++;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        if (bArr.length == 0) {
            return;
        }
        h().write(bArr);
        this.f18721g += bArr.length;
        this.f18722h += bArr.length;
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i11, int i12) {
        if (bArr.length == 0) {
            return;
        }
        h().write(bArr, i11, i12);
        this.f18721g += i12;
        this.f18722h += i12;
    }
}
