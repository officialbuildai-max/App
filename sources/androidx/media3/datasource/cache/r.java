package androidx.media3.datasource.cache;

import androidx.media3.common.util.a1;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class r extends BufferedOutputStream {

    /* renamed from: a, reason: collision with root package name */
    private boolean f10949a;

    public r(OutputStream outputStream) {
        super(outputStream);
    }

    public r(OutputStream outputStream, int i11) {
        super(outputStream, i11);
    }

    public void b(OutputStream outputStream) {
        androidx.media3.common.util.a.g(this.f10949a);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f10949a = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f10949a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        if (th != null) {
            a1.m1(th);
        }
    }
}
