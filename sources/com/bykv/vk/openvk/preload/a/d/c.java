package com.bykv.vk.openvk.preload.a.d;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class c implements Closeable, Flushable {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f20590a = new String[128];

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f20591b;

    /* renamed from: c, reason: collision with root package name */
    private final Writer f20592c;

    /* renamed from: d, reason: collision with root package name */
    private int[] f20593d = new int[32];

    /* renamed from: e, reason: collision with root package name */
    private int f20594e = 0;

    /* renamed from: f, reason: collision with root package name */
    private String f20595f;

    /* renamed from: g, reason: collision with root package name */
    private String f20596g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f20597h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f20598i;

    /* renamed from: j, reason: collision with root package name */
    private String f20599j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f20600k;

    static {
        for (int i11 = 0; i11 <= 31; i11++) {
            f20590a[i11] = String.format("\\u%04x", Integer.valueOf(i11));
        }
        String[] strArr = f20590a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f20591b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        a(6);
        this.f20596g = ":";
        this.f20600k = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f20592c = writer;
    }

    private c a(int i11, char c11) throws IOException {
        m();
        a(i11);
        this.f20592c.write(c11);
        return this;
    }

    private c a(int i11, int i12, char c11) throws IOException {
        int i13 = i();
        if (i13 != i12 && i13 != i11) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f20599j != null) {
            throw new IllegalStateException("Dangling name: " + this.f20599j);
        }
        this.f20594e--;
        if (i13 == i12) {
            k();
        }
        this.f20592c.write(c11);
        return this;
    }

    private void a(int i11) {
        int i12 = this.f20594e;
        int[] iArr = this.f20593d;
        if (i12 == iArr.length) {
            this.f20593d = Arrays.copyOf(iArr, i12 << 1);
        }
        int[] iArr2 = this.f20593d;
        int i13 = this.f20594e;
        this.f20594e = i13 + 1;
        iArr2[i13] = i11;
    }

    private void b(int i11) {
        this.f20593d[this.f20594e - 1] = i11;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void c(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f20598i
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.bykv.vk.openvk.preload.a.d.c.f20591b
            goto L9
        L7:
            java.lang.String[] r0 = com.bykv.vk.openvk.preload.a.d.c.f20590a
        L9:
            java.io.Writer r1 = r8.f20592c
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f20592c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f20592c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f20592c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f20592c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.d.c.c(java.lang.String):void");
    }

    private int i() {
        int i11 = this.f20594e;
        if (i11 != 0) {
            return this.f20593d[i11 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void j() throws IOException {
        if (this.f20599j != null) {
            l();
            c(this.f20599j);
            this.f20599j = null;
        }
    }

    private void k() throws IOException {
        if (this.f20595f == null) {
            return;
        }
        this.f20592c.write(10);
        int i11 = this.f20594e;
        for (int i12 = 1; i12 < i11; i12++) {
            this.f20592c.write(this.f20595f);
        }
    }

    private void l() throws IOException {
        int i11 = i();
        if (i11 == 5) {
            this.f20592c.write(44);
        } else if (i11 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        k();
        b(4);
    }

    private void m() throws IOException {
        int i11 = i();
        if (i11 == 1) {
            b(2);
            k();
            return;
        }
        if (i11 == 2) {
            this.f20592c.append(',');
            k();
        } else {
            if (i11 == 4) {
                this.f20592c.append((CharSequence) this.f20596g);
                b(5);
                return;
            }
            if (i11 != 6) {
                if (i11 != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f20597h) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            b(7);
        }
    }

    public final c a(long j11) throws IOException {
        j();
        m();
        this.f20592c.write(Long.toString(j11));
        return this;
    }

    public final c a(Boolean bool) throws IOException {
        if (bool == null) {
            return h();
        }
        j();
        m();
        this.f20592c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public final c a(Number number) throws IOException {
        if (number == null) {
            return h();
        }
        j();
        String obj = number.toString();
        if (!this.f20597h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(number)));
        }
        m();
        this.f20592c.append((CharSequence) obj);
        return this;
    }

    public final c a(String str) throws IOException {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f20599j != null) {
            throw new IllegalStateException();
        }
        if (this.f20594e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f20599j = str;
        return this;
    }

    public final void a(boolean z10) {
        this.f20597h = z10;
    }

    public final boolean a() {
        return this.f20597h;
    }

    public final c b(String str) throws IOException {
        if (str == null) {
            return h();
        }
        j();
        m();
        c(str);
        return this;
    }

    public final void b(boolean z10) {
        this.f20598i = z10;
    }

    public final boolean b() {
        return this.f20598i;
    }

    public final void c(boolean z10) {
        this.f20600k = z10;
    }

    public final boolean c() {
        return this.f20600k;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f20592c.close();
        int i11 = this.f20594e;
        if (i11 > 1 || (i11 == 1 && this.f20593d[i11 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f20594e = 0;
    }

    public final c d() throws IOException {
        j();
        return a(1, '[');
    }

    public final c d(boolean z10) throws IOException {
        j();
        m();
        this.f20592c.write(z10 ? "true" : "false");
        return this;
    }

    public final c e() throws IOException {
        return a(1, 2, ']');
    }

    public final c f() throws IOException {
        j();
        return a(3, '{');
    }

    @Override // java.io.Flushable
    public final void flush() throws IOException {
        if (this.f20594e == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f20592c.flush();
    }

    public final c g() throws IOException {
        return a(3, 5, '}');
    }

    public final c h() throws IOException {
        if (this.f20599j != null) {
            if (!this.f20600k) {
                this.f20599j = null;
                return this;
            }
            j();
        }
        m();
        this.f20592c.write("null");
        return this;
    }
}
