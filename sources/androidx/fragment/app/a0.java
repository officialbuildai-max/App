package androidx.fragment.app;

import java.io.Writer;

/* loaded from: classes.dex */
final class a0 extends Writer {

    /* renamed from: a, reason: collision with root package name */
    private final String f9508a;

    /* renamed from: b, reason: collision with root package name */
    private StringBuilder f9509b = new StringBuilder(128);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(String str) {
        this.f9508a = str;
    }

    private void d() {
        if (this.f9509b.length() > 0) {
            this.f9509b.toString();
            StringBuilder sb2 = this.f9509b;
            sb2.delete(0, sb2.length());
        }
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        d();
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        d();
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            char c11 = cArr[i11 + i13];
            if (c11 == '\n') {
                d();
            } else {
                this.f9509b.append(c11);
            }
        }
    }
}
