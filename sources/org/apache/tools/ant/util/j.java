package org.apache.tools.ant.util;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

/* loaded from: classes7.dex */
public abstract class j extends OutputStream {

    /* renamed from: a, reason: collision with root package name */
    private ByteArrayOutputStream f71711a = new ByteArrayOutputStream(Sdk$SDKError.Reason.OMSDK_DOWNLOAD_JS_ERROR_VALUE);

    /* renamed from: b, reason: collision with root package name */
    private boolean f71712b = false;

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f71711a.size() > 0) {
            d();
        }
        super.close();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        try {
            h(this.f71711a.toString());
        } finally {
            this.f71711a.reset();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public final void flush() {
        if (this.f71711a.size() > 0) {
            d();
        }
    }

    protected abstract void h(String str);

    @Override // java.io.OutputStream
    public final void write(int i11) {
        byte b11 = (byte) i11;
        if (b11 != 10 && b11 != 13) {
            this.f71711a.write(i11);
        } else if (!this.f71712b) {
            d();
        }
        this.f71712b = b11 == 13;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i11, int i12) {
        byte b11;
        while (i12 > 0) {
            int i13 = i11;
            while (i12 > 0 && (b11 = bArr[i13]) != 10 && b11 != 13) {
                i13++;
                i12--;
            }
            int i14 = i13 - i11;
            if (i14 > 0) {
                this.f71711a.write(bArr, i11, i14);
            }
            i11 = i13;
            while (i12 > 0) {
                byte b12 = bArr[i11];
                if (b12 == 10 || b12 == 13) {
                    write(b12);
                    i11++;
                    i12--;
                }
            }
        }
    }
}
