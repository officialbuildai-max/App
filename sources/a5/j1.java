package a5;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public final class j1 extends Writer {

    /* renamed from: s, reason: collision with root package name */
    private static final ThreadLocal f336s = new ThreadLocal();

    /* renamed from: t, reason: collision with root package name */
    private static final ThreadLocal f337t = new ThreadLocal();

    /* renamed from: u, reason: collision with root package name */
    private static final char[] f338u = ":true".toCharArray();

    /* renamed from: v, reason: collision with root package name */
    private static final char[] f339v = ":false".toCharArray();

    /* renamed from: w, reason: collision with root package name */
    private static int f340w;

    /* renamed from: x, reason: collision with root package name */
    static final int f341x;

    /* renamed from: a, reason: collision with root package name */
    protected char[] f342a;

    /* renamed from: b, reason: collision with root package name */
    protected int f343b;

    /* renamed from: c, reason: collision with root package name */
    protected int f344c;

    /* renamed from: d, reason: collision with root package name */
    private final Writer f345d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f346e;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f347f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f348g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f349h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f350i;

    /* renamed from: j, reason: collision with root package name */
    protected boolean f351j;

    /* renamed from: k, reason: collision with root package name */
    protected boolean f352k;

    /* renamed from: l, reason: collision with root package name */
    protected boolean f353l;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f354m;

    /* renamed from: n, reason: collision with root package name */
    protected boolean f355n;

    /* renamed from: o, reason: collision with root package name */
    protected char f356o;

    /* renamed from: p, reason: collision with root package name */
    protected int f357p;

    /* renamed from: q, reason: collision with root package name */
    protected boolean f358q;

    /* renamed from: r, reason: collision with root package name */
    protected long f359r;

    static {
        int parseInt;
        f340w = 131072;
        try {
            String j11 = com.alibaba.fastjson.util.f.j("fastjson.serializer_buffer_threshold");
            if (j11 != null && j11.length() > 0 && (parseInt = Integer.parseInt(j11)) >= 64 && parseInt <= 65536) {
                f340w = parseInt * 1024;
            }
        } catch (Throwable unused) {
        }
        f341x = SerializerFeature.UseSingleQuotes.mask | SerializerFeature.BrowserCompatible.mask | SerializerFeature.PrettyFormat.mask | SerializerFeature.WriteEnumUsingToString.mask | SerializerFeature.WriteNonStringValueAsString.mask | SerializerFeature.WriteSlashAsSpecial.mask | SerializerFeature.IgnoreErrorGetter.mask | SerializerFeature.WriteClassName.mask | SerializerFeature.NotWriteDefaultValue.mask;
    }

    public j1() {
        this(null);
    }

    public j1(Writer writer) {
        this(writer, com.alibaba.fastjson.a.DEFAULT_GENERATE_FEATURE, SerializerFeature.EMPTY);
    }

    public j1(Writer writer, int i11, SerializerFeature... serializerFeatureArr) {
        this.f357p = -1;
        this.f345d = writer;
        ThreadLocal threadLocal = f336s;
        char[] cArr = (char[]) threadLocal.get();
        this.f342a = cArr;
        if (cArr != null) {
            threadLocal.set(null);
        } else {
            this.f342a = new char[2048];
        }
        for (SerializerFeature serializerFeature : serializerFeatureArr) {
            i11 |= serializerFeature.getMask();
        }
        this.f344c = i11;
        k();
    }

    private void k0(String str) {
        byte[] bArr = com.alibaba.fastjson.util.f.f18307g;
        int length = str.length();
        boolean z10 = true;
        int i11 = this.f343b + length + 1;
        int i12 = 0;
        if (i11 > this.f342a.length) {
            if (this.f345d != null) {
                if (length == 0) {
                    write(39);
                    write(39);
                    write(58);
                    return;
                }
                int i13 = 0;
                while (true) {
                    if (i13 < length) {
                        char charAt = str.charAt(i13);
                        if (charAt < bArr.length && bArr[charAt] != 0) {
                            break;
                        } else {
                            i13++;
                        }
                    } else {
                        z10 = false;
                        break;
                    }
                }
                if (z10) {
                    write(39);
                }
                while (i12 < length) {
                    char charAt2 = str.charAt(i12);
                    if (charAt2 >= bArr.length || bArr[charAt2] == 0) {
                        write(charAt2);
                    } else {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f18310j[charAt2]);
                    }
                    i12++;
                }
                if (z10) {
                    write(39);
                }
                write(58);
                return;
            }
            o(i11);
        }
        if (length == 0) {
            int i14 = this.f343b;
            if (i14 + 3 > this.f342a.length) {
                o(i14 + 3);
            }
            char[] cArr = this.f342a;
            int i15 = this.f343b;
            int i16 = i15 + 1;
            this.f343b = i16;
            cArr[i15] = '\'';
            int i17 = i15 + 2;
            this.f343b = i17;
            cArr[i16] = '\'';
            this.f343b = i15 + 3;
            cArr[i17] = ':';
            return;
        }
        int i18 = this.f343b;
        int i19 = i18 + length;
        str.getChars(0, length, this.f342a, i18);
        this.f343b = i11;
        int i20 = i18;
        boolean z11 = false;
        while (i20 < i19) {
            char[] cArr2 = this.f342a;
            char c11 = cArr2[i20];
            if (c11 < bArr.length && bArr[c11] != 0) {
                if (z11) {
                    i11++;
                    if (i11 > cArr2.length) {
                        o(i11);
                    }
                    this.f343b = i11;
                    char[] cArr3 = this.f342a;
                    int i21 = i20 + 1;
                    System.arraycopy(cArr3, i21, cArr3, i20 + 2, i19 - i20);
                    char[] cArr4 = this.f342a;
                    cArr4[i20] = '\\';
                    cArr4[i21] = com.alibaba.fastjson.util.f.f18310j[c11];
                    i19++;
                    i20 = i21;
                } else {
                    i11 += 3;
                    if (i11 > cArr2.length) {
                        o(i11);
                    }
                    this.f343b = i11;
                    char[] cArr5 = this.f342a;
                    int i22 = i20 + 1;
                    System.arraycopy(cArr5, i22, cArr5, i20 + 3, (i19 - i20) - 1);
                    char[] cArr6 = this.f342a;
                    System.arraycopy(cArr6, i12, cArr6, 1, i20);
                    char[] cArr7 = this.f342a;
                    cArr7[i18] = '\'';
                    cArr7[i22] = '\\';
                    i20 += 2;
                    cArr7[i20] = com.alibaba.fastjson.util.f.f18310j[c11];
                    i19 += 2;
                    cArr7[this.f343b - 2] = '\'';
                    z11 = true;
                }
            }
            i20++;
            i12 = 0;
        }
        this.f342a[i11 - 1] = ':';
    }

    private int m(OutputStream outputStream) {
        int i11 = (int) (this.f343b * 3.0d);
        ThreadLocal threadLocal = f337t;
        byte[] bArr = (byte[]) threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i11 ? new byte[i11] : bArr;
        int f11 = com.alibaba.fastjson.util.f.f(this.f342a, 0, this.f343b, bArr2);
        outputStream.write(bArr2, 0, f11);
        if (bArr2 != bArr && bArr2.length <= f340w) {
            threadLocal.set(bArr2);
        }
        return f11;
    }

    private byte[] n() {
        int i11 = (int) (this.f343b * 3.0d);
        ThreadLocal threadLocal = f337t;
        byte[] bArr = (byte[]) threadLocal.get();
        if (bArr == null) {
            bArr = new byte[8192];
            threadLocal.set(bArr);
        }
        byte[] bArr2 = bArr.length < i11 ? new byte[i11] : bArr;
        int f11 = com.alibaba.fastjson.util.f.f(this.f342a, 0, this.f343b, bArr2);
        byte[] bArr3 = new byte[f11];
        System.arraycopy(bArr2, 0, bArr3, 0, f11);
        if (bArr2 != bArr && bArr2.length <= f340w) {
            threadLocal.set(bArr2);
        }
        return bArr3;
    }

    public void T(char c11, String str, double d11) {
        write(c11);
        w(str);
        u(d11, false);
    }

    public void U(char c11, String str, int i11) {
        if (i11 == Integer.MIN_VALUE || !this.f347f) {
            write(c11);
            w(str);
            h0(i11);
            return;
        }
        int n11 = i11 < 0 ? com.alibaba.fastjson.util.f.n(-i11) + 1 : com.alibaba.fastjson.util.f.n(i11);
        int length = str.length();
        int i12 = this.f343b + length + 4 + n11;
        if (i12 > this.f342a.length) {
            if (this.f345d != null) {
                write(c11);
                w(str);
                h0(i11);
                return;
            }
            o(i12);
        }
        int i13 = this.f343b;
        this.f343b = i12;
        char[] cArr = this.f342a;
        cArr[i13] = c11;
        int i14 = i13 + length;
        cArr[i13 + 1] = this.f356o;
        str.getChars(0, length, cArr, i13 + 2);
        char[] cArr2 = this.f342a;
        cArr2[i14 + 2] = this.f356o;
        cArr2[i14 + 3] = ':';
        com.alibaba.fastjson.util.f.h(i11, this.f343b, cArr2);
    }

    public void V(char c11, String str, long j11) {
        if (j11 == Long.MIN_VALUE || !this.f347f || p(SerializerFeature.BrowserCompatible.mask)) {
            write(c11);
            w(str);
            l0(j11);
            return;
        }
        int o11 = j11 < 0 ? com.alibaba.fastjson.util.f.o(-j11) + 1 : com.alibaba.fastjson.util.f.o(j11);
        int length = str.length();
        int i11 = this.f343b + length + 4 + o11;
        if (i11 > this.f342a.length) {
            if (this.f345d != null) {
                write(c11);
                w(str);
                l0(j11);
                return;
            }
            o(i11);
        }
        int i12 = this.f343b;
        this.f343b = i11;
        char[] cArr = this.f342a;
        cArr[i12] = c11;
        int i13 = i12 + length;
        cArr[i12 + 1] = this.f356o;
        str.getChars(0, length, cArr, i12 + 2);
        char[] cArr2 = this.f342a;
        cArr2[i13 + 2] = this.f356o;
        cArr2[i13 + 3] = ':';
        com.alibaba.fastjson.util.f.i(j11, this.f343b, cArr2);
    }

    public void Z(char c11, String str, String str2) {
        if (!this.f347f) {
            write(c11);
            w(str);
            if (str2 == null) {
                m0();
                return;
            } else {
                q0(str2);
                return;
            }
        }
        if (this.f346e) {
            write(c11);
            w(str);
            if (str2 == null) {
                m0();
                return;
            } else {
                q0(str2);
                return;
            }
        }
        if (!q(SerializerFeature.BrowserCompatible)) {
            c0(c11, str, str2);
            return;
        }
        write(c11);
        u0(str, ':');
        u0(str2, (char) 0);
    }

    public void a0(char c11, String str, BigDecimal bigDecimal) {
        write(c11);
        w(str);
        if (bigDecimal == null) {
            m0();
        } else {
            int scale = bigDecimal.scale();
            write((!q(SerializerFeature.WriteBigDecimalAsPlain) || scale < -100 || scale >= 100) ? bigDecimal.toString() : bigDecimal.toPlainString());
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public j1 append(char c11) {
        write(c11);
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00cd, code lost:
    
        if (r1[r3] == 4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0220, code lost:
    
        if (r3 != '>') goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00d8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c0(char r22, java.lang.String r23, java.lang.String r24) {
        /*
            Method dump skipped, instructions count: 783
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.j1.c0(char, java.lang.String, java.lang.String):void");
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f345d != null && this.f343b > 0) {
            flush();
        }
        char[] cArr = this.f342a;
        if (cArr.length <= f340w) {
            f336s.set(cArr);
        }
        this.f342a = null;
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "null" : charSequence.toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void d0(float f11, boolean z10) {
        if (f11 != f11 || f11 == Float.POSITIVE_INFINITY || f11 == Float.NEGATIVE_INFINITY) {
            m0();
            return;
        }
        int i11 = this.f343b + 15;
        if (i11 > this.f342a.length) {
            if (this.f345d != null) {
                String b11 = com.alibaba.fastjson.util.k.b(f11);
                write(b11, 0, b11.length());
                if (z10 && q(SerializerFeature.WriteClassName)) {
                    write(70);
                    return;
                }
                return;
            }
            o(i11);
        }
        this.f343b += com.alibaba.fastjson.util.k.a(f11, this.f342a, this.f343b);
        if (z10 && q(SerializerFeature.WriteClassName)) {
            write(70);
        }
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
        Writer writer = this.f345d;
        if (writer == null) {
            return;
        }
        try {
            writer.write(this.f342a, 0, this.f343b);
            this.f345d.flush();
            this.f343b = 0;
        } catch (IOException e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }

    public void g0(byte[] bArr) {
        int length = this.f343b + (bArr.length * 2) + 3;
        if (length > this.f342a.length) {
            o(length);
        }
        char[] cArr = this.f342a;
        int i11 = this.f343b;
        int i12 = i11 + 1;
        this.f343b = i12;
        cArr[i11] = 'x';
        this.f343b = i11 + 2;
        cArr[i12] = '\'';
        for (byte b11 : bArr) {
            int i13 = (b11 & 255) >> 4;
            int i14 = b11 & 15;
            char[] cArr2 = this.f342a;
            int i15 = this.f343b;
            int i16 = i15 + 1;
            this.f343b = i16;
            int i17 = 55;
            cArr2[i15] = (char) (i13 + (i13 < 10 ? 48 : 55));
            this.f343b = i15 + 2;
            if (i14 < 10) {
                i17 = 48;
            }
            cArr2[i16] = (char) (i14 + i17);
        }
        char[] cArr3 = this.f342a;
        int i18 = this.f343b;
        this.f343b = i18 + 1;
        cArr3[i18] = '\'';
    }

    @Override // java.io.Writer, java.lang.Appendable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public j1 append(CharSequence charSequence, int i11, int i12) {
        if (charSequence == null) {
            charSequence = "null";
        }
        String charSequence2 = charSequence.subSequence(i11, i12).toString();
        write(charSequence2, 0, charSequence2.length());
        return this;
    }

    public void h0(int i11) {
        if (i11 == Integer.MIN_VALUE) {
            write("-2147483648");
            return;
        }
        int n11 = i11 < 0 ? com.alibaba.fastjson.util.f.n(-i11) + 1 : com.alibaba.fastjson.util.f.n(i11);
        int i12 = this.f343b + n11;
        if (i12 > this.f342a.length) {
            if (this.f345d != null) {
                char[] cArr = new char[n11];
                com.alibaba.fastjson.util.f.h(i11, n11, cArr);
                write(cArr, 0, n11);
                return;
            }
            o(i12);
        }
        com.alibaba.fastjson.util.f.h(i11, i12, this.f342a);
        this.f343b = i12;
    }

    protected void k() {
        int i11 = this.f344c;
        boolean z10 = (SerializerFeature.QuoteFieldNames.mask & i11) != 0;
        this.f347f = z10;
        boolean z11 = (SerializerFeature.UseSingleQuotes.mask & i11) != 0;
        this.f346e = z11;
        this.f348g = (SerializerFeature.SortField.mask & i11) != 0;
        this.f349h = (SerializerFeature.DisableCircularReferenceDetect.mask & i11) != 0;
        boolean z12 = (SerializerFeature.BeanToArray.mask & i11) != 0;
        this.f350i = z12;
        this.f351j = (SerializerFeature.WriteNonStringValueAsString.mask & i11) != 0;
        this.f352k = (SerializerFeature.NotWriteDefaultValue.mask & i11) != 0;
        boolean z13 = (SerializerFeature.WriteEnumUsingName.mask & i11) != 0;
        this.f353l = z13;
        this.f354m = (SerializerFeature.WriteEnumUsingToString.mask & i11) != 0;
        this.f355n = z10 && (f341x & i11) == 0 && (z12 || z13);
        this.f356o = z11 ? '\'' : '\"';
        boolean z14 = (SerializerFeature.BrowserSecure.mask & i11) != 0;
        this.f358q = z14;
        this.f359r = z14 ? 5764610843043954687L : (i11 & SerializerFeature.WriteSlashAsSpecial.mask) != 0 ? 140758963191807L : 21474836479L;
    }

    public void l(SerializerFeature serializerFeature, boolean z10) {
        if (z10) {
            int mask = this.f344c | serializerFeature.getMask();
            this.f344c = mask;
            SerializerFeature serializerFeature2 = SerializerFeature.WriteEnumUsingToString;
            if (serializerFeature == serializerFeature2) {
                this.f344c = (~SerializerFeature.WriteEnumUsingName.getMask()) & mask;
            } else if (serializerFeature == SerializerFeature.WriteEnumUsingName) {
                this.f344c = (~serializerFeature2.getMask()) & mask;
            }
        } else {
            this.f344c = (~serializerFeature.getMask()) & this.f344c;
        }
        k();
    }

    public void l0(long j11) {
        boolean z10 = q(SerializerFeature.BrowserCompatible) && !q(SerializerFeature.WriteClassName) && (j11 > 9007199254740991L || j11 < -9007199254740991L);
        if (j11 == Long.MIN_VALUE) {
            if (z10) {
                write("\"-9223372036854775808\"");
                return;
            } else {
                write("-9223372036854775808");
                return;
            }
        }
        int o11 = j11 < 0 ? com.alibaba.fastjson.util.f.o(-j11) + 1 : com.alibaba.fastjson.util.f.o(j11);
        int i11 = this.f343b + o11;
        if (z10) {
            i11 += 2;
        }
        if (i11 > this.f342a.length) {
            if (this.f345d != null) {
                char[] cArr = new char[o11];
                com.alibaba.fastjson.util.f.i(j11, o11, cArr);
                if (!z10) {
                    write(cArr, 0, o11);
                    return;
                }
                write(34);
                write(cArr, 0, o11);
                write(34);
                return;
            }
            o(i11);
        }
        if (z10) {
            char[] cArr2 = this.f342a;
            cArr2[this.f343b] = '\"';
            int i12 = i11 - 1;
            com.alibaba.fastjson.util.f.i(j11, i12, cArr2);
            this.f342a[i12] = '\"';
        } else {
            com.alibaba.fastjson.util.f.i(j11, i11, this.f342a);
        }
        this.f343b = i11;
    }

    public void m0() {
        write("null");
    }

    public void o(int i11) {
        int i12 = this.f357p;
        if (i12 != -1 && i11 >= i12) {
            throw new JSONException("serialize exceeded MAX_OUTPUT_LENGTH=" + this.f357p + ", minimumCapacity=" + i11);
        }
        char[] cArr = this.f342a;
        int length = cArr.length + (cArr.length >> 1) + 1;
        if (length >= i11) {
            i11 = length;
        }
        char[] cArr2 = new char[i11];
        System.arraycopy(cArr, 0, cArr2, 0, this.f343b);
        if (this.f342a.length < f340w) {
            ThreadLocal threadLocal = f336s;
            char[] cArr3 = (char[]) threadLocal.get();
            if (cArr3 == null || cArr3.length < this.f342a.length) {
                threadLocal.set(this.f342a);
            }
        }
        this.f342a = cArr2;
    }

    public void o0(int i11, int i12) {
        if ((i11 & i12) == 0 && (this.f344c & i12) == 0) {
            m0();
            return;
        }
        int i13 = SerializerFeature.WriteMapNullValue.mask;
        if ((i11 & i13) != 0 && (i11 & (~i13) & SerializerFeature.WRITE_MAP_NULL_FEATURES) == 0) {
            m0();
            return;
        }
        if (i12 == SerializerFeature.WriteNullListAsEmpty.mask) {
            write("[]");
            return;
        }
        if (i12 == SerializerFeature.WriteNullStringAsEmpty.mask) {
            q0("");
            return;
        }
        if (i12 == SerializerFeature.WriteNullBooleanAsFalse.mask) {
            write("false");
        } else if (i12 == SerializerFeature.WriteNullNumberAsZero.mask) {
            write(48);
        } else {
            m0();
        }
    }

    public boolean p(int i11) {
        return (i11 & this.f344c) != 0;
    }

    public void p0(SerializerFeature serializerFeature) {
        o0(0, serializerFeature.mask);
    }

    public boolean q(SerializerFeature serializerFeature) {
        return (serializerFeature.mask & this.f344c) != 0;
    }

    public void q0(String str) {
        if (this.f346e) {
            v0(str);
        } else {
            u0(str, (char) 0);
        }
    }

    public byte[] r(Charset charset) {
        if (this.f345d == null) {
            return charset == com.alibaba.fastjson.util.f.f18302b ? n() : new String(this.f342a, 0, this.f343b).getBytes(charset);
        }
        throw new UnsupportedOperationException("writer not null");
    }

    public void r0(char[] cArr) {
        if (this.f346e) {
            x0(cArr);
        } else {
            u0(new String(cArr), (char) 0);
        }
    }

    public void s(boolean z10) {
        if (z10) {
            write("true");
        } else {
            write("false");
        }
    }

    public void t(byte[] bArr) {
        if (p(SerializerFeature.WriteClassName.mask)) {
            g0(bArr);
            return;
        }
        int length = bArr.length;
        boolean z10 = this.f346e;
        char c11 = z10 ? '\'' : '\"';
        if (length == 0) {
            write(z10 ? "''" : "\"\"");
            return;
        }
        char[] cArr = com.alibaba.fastjson.util.f.f18316p;
        int i11 = (length / 3) * 3;
        int i12 = length - 1;
        int i13 = this.f343b;
        int i14 = (((i12 / 3) + 1) << 2) + i13;
        int i15 = i14 + 2;
        if (i15 > this.f342a.length) {
            if (this.f345d != null) {
                write(c11);
                int i16 = 0;
                while (i16 < i11) {
                    int i17 = i16 + 2;
                    int i18 = ((bArr[i16 + 1] & 255) << 8) | ((bArr[i16] & 255) << 16);
                    i16 += 3;
                    int i19 = i18 | (bArr[i17] & 255);
                    write(cArr[(i19 >>> 18) & 63]);
                    write(cArr[(i19 >>> 12) & 63]);
                    write(cArr[(i19 >>> 6) & 63]);
                    write(cArr[i19 & 63]);
                }
                int i20 = length - i11;
                if (i20 > 0) {
                    int i21 = ((bArr[i11] & 255) << 10) | (i20 == 2 ? (bArr[i12] & 255) << 2 : 0);
                    write(cArr[i21 >> 12]);
                    write(cArr[(i21 >>> 6) & 63]);
                    write(i20 == 2 ? cArr[i21 & 63] : '=');
                    write(61);
                }
                write(c11);
                return;
            }
            o(i15);
        }
        this.f343b = i15;
        int i22 = i13 + 1;
        this.f342a[i13] = c11;
        int i23 = 0;
        while (i23 < i11) {
            int i24 = i23 + 2;
            int i25 = ((bArr[i23 + 1] & 255) << 8) | ((bArr[i23] & 255) << 16);
            i23 += 3;
            int i26 = i25 | (bArr[i24] & 255);
            char[] cArr2 = this.f342a;
            cArr2[i22] = cArr[(i26 >>> 18) & 63];
            cArr2[i22 + 1] = cArr[(i26 >>> 12) & 63];
            int i27 = i22 + 3;
            cArr2[i22 + 2] = cArr[(i26 >>> 6) & 63];
            i22 += 4;
            cArr2[i27] = cArr[i26 & 63];
        }
        int i28 = length - i11;
        if (i28 > 0) {
            int i29 = ((bArr[i11] & 255) << 10) | (i28 == 2 ? (bArr[i12] & 255) << 2 : 0);
            char[] cArr3 = this.f342a;
            cArr3[i14 - 3] = cArr[i29 >> 12];
            cArr3[i14 - 2] = cArr[(i29 >>> 6) & 63];
            cArr3[i14 - 1] = i28 == 2 ? cArr[i29 & 63] : '=';
            cArr3[i14] = '=';
        }
        this.f342a[i14 + 1] = c11;
    }

    public String toString() {
        return new String(this.f342a, 0, this.f343b);
    }

    public void u(double d11, boolean z10) {
        if (Double.isNaN(d11) || Double.isInfinite(d11)) {
            m0();
            return;
        }
        int i11 = this.f343b + 24;
        if (i11 > this.f342a.length) {
            if (this.f345d != null) {
                String b11 = com.alibaba.fastjson.util.j.b(d11);
                write(b11, 0, b11.length());
                if (z10 && q(SerializerFeature.WriteClassName)) {
                    write(68);
                    return;
                }
                return;
            }
            o(i11);
        }
        this.f343b += com.alibaba.fastjson.util.j.a(d11, this.f342a, this.f343b);
        if (z10 && q(SerializerFeature.WriteClassName)) {
            write(68);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:177:0x02e5, code lost:
    
        if (r4[r14] == 4) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:224:0x0439, code lost:
    
        if (r4 != '>') goto L215;
     */
    /* JADX WARN: Removed duplicated region for block: B:180:0x02ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u0(java.lang.String r23, char r24) {
        /*
            Method dump skipped, instructions count: 1345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a5.j1.u0(java.lang.String, char):void");
    }

    public void v(Enum r22) {
        if (r22 == null) {
            m0();
            return;
        }
        String str = (!this.f353l || this.f354m) ? this.f354m ? r22.toString() : null : r22.name();
        if (str == null) {
            h0(r22.ordinal());
            return;
        }
        int i11 = q(SerializerFeature.UseSingleQuotes) ? 39 : 34;
        write(i11);
        write(str);
        write(i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v0(String str) {
        int i11 = 0;
        if (str == null) {
            int i12 = this.f343b + 4;
            if (i12 > this.f342a.length) {
                o(i12);
            }
            "null".getChars(0, 4, this.f342a, this.f343b);
            this.f343b = i12;
            return;
        }
        int length = str.length();
        int i13 = this.f343b + length + 2;
        if (i13 > this.f342a.length) {
            if (this.f345d != null) {
                write(39);
                while (i11 < str.length()) {
                    char charAt = str.charAt(i11);
                    if (charAt <= '\r' || charAt == '\\' || charAt == '\'' || (charAt == '/' && q(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f18310j[charAt]);
                    } else {
                        write(charAt);
                    }
                    i11++;
                }
                write(39);
                return;
            }
            o(i13);
        }
        int i14 = this.f343b;
        int i15 = i14 + 1;
        int i16 = i15 + length;
        char[] cArr = this.f342a;
        cArr[i14] = '\'';
        str.getChars(0, length, cArr, i15);
        this.f343b = i13;
        int i17 = -1;
        char c11 = 0;
        for (int i18 = i15; i18 < i16; i18++) {
            char c12 = this.f342a[i18];
            if (c12 <= '\r' || c12 == '\\' || c12 == '\'' || (c12 == '/' && q(SerializerFeature.WriteSlashAsSpecial))) {
                i11++;
                i17 = i18;
                c11 = c12;
            }
        }
        int i19 = i13 + i11;
        if (i19 > this.f342a.length) {
            o(i19);
        }
        this.f343b = i19;
        if (i11 == 1) {
            char[] cArr2 = this.f342a;
            int i20 = i17 + 1;
            System.arraycopy(cArr2, i20, cArr2, i17 + 2, (i16 - i17) - 1);
            char[] cArr3 = this.f342a;
            cArr3[i17] = '\\';
            cArr3[i20] = com.alibaba.fastjson.util.f.f18310j[c11];
        } else if (i11 > 1) {
            char[] cArr4 = this.f342a;
            int i21 = i17 + 1;
            System.arraycopy(cArr4, i21, cArr4, i17 + 2, (i16 - i17) - 1);
            char[] cArr5 = this.f342a;
            cArr5[i17] = '\\';
            cArr5[i21] = com.alibaba.fastjson.util.f.f18310j[c11];
            int i22 = i16 + 1;
            for (int i23 = i17 - 1; i23 >= i15; i23--) {
                char c13 = this.f342a[i23];
                if (c13 <= '\r' || c13 == '\\' || c13 == '\'' || (c13 == '/' && q(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr6 = this.f342a;
                    int i24 = i23 + 1;
                    System.arraycopy(cArr6, i24, cArr6, i23 + 2, (i22 - i23) - 1);
                    char[] cArr7 = this.f342a;
                    cArr7[i23] = '\\';
                    cArr7[i24] = com.alibaba.fastjson.util.f.f18310j[c13];
                    i22++;
                }
            }
        }
        this.f342a[this.f343b - 1] = '\'';
    }

    public void w(String str) {
        x(str, false);
    }

    @Override // java.io.Writer
    public void write(int i11) {
        int i12 = 1;
        int i13 = this.f343b + 1;
        if (i13 > this.f342a.length) {
            if (this.f345d != null) {
                flush();
                this.f342a[this.f343b] = (char) i11;
                this.f343b = i12;
            }
            o(i13);
        }
        i12 = i13;
        this.f342a[this.f343b] = (char) i11;
        this.f343b = i12;
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str == null) {
            m0();
        } else {
            write(str, 0, str.length());
        }
    }

    @Override // java.io.Writer
    public void write(String str, int i11, int i12) {
        int i13;
        int i14 = this.f343b + i12;
        if (i14 > this.f342a.length) {
            if (this.f345d == null) {
                o(i14);
            } else {
                while (true) {
                    char[] cArr = this.f342a;
                    int length = cArr.length;
                    int i15 = this.f343b;
                    int i16 = length - i15;
                    i13 = i11 + i16;
                    str.getChars(i11, i13, cArr, i15);
                    this.f343b = this.f342a.length;
                    flush();
                    i12 -= i16;
                    if (i12 <= this.f342a.length) {
                        break;
                    } else {
                        i11 = i13;
                    }
                }
                i14 = i12;
                i11 = i13;
            }
        }
        str.getChars(i11, i12 + i11, this.f342a, this.f343b);
        this.f343b = i14;
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i11, int i12) {
        int i13;
        if (i11 < 0 || i11 > cArr.length || i12 < 0 || (i13 = i11 + i12) > cArr.length || i13 < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (i12 == 0) {
            return;
        }
        int i14 = this.f343b + i12;
        if (i14 > this.f342a.length) {
            if (this.f345d == null) {
                o(i14);
            }
            do {
                char[] cArr2 = this.f342a;
                int length = cArr2.length;
                int i15 = this.f343b;
                int i16 = length - i15;
                System.arraycopy(cArr, i11, cArr2, i15, i16);
                this.f343b = this.f342a.length;
                flush();
                i12 -= i16;
                i11 += i16;
            } while (i12 > this.f342a.length);
            i14 = i12;
        }
        System.arraycopy(cArr, i11, this.f342a, this.f343b, i12);
        this.f343b = i14;
    }

    public void x(String str, boolean z10) {
        if (str == null) {
            write("null:");
            return;
        }
        if (this.f346e) {
            if (!this.f347f) {
                k0(str);
                return;
            } else {
                v0(str);
                write(58);
                return;
            }
        }
        if (this.f347f) {
            u0(str, ':');
            return;
        }
        int i11 = 0;
        boolean z11 = true;
        boolean z12 = str.length() == 0;
        while (true) {
            if (i11 >= str.length()) {
                z11 = z12;
                break;
            }
            char charAt = str.charAt(i11);
            if ((charAt < '@' && (this.f359r & (1 << charAt)) != 0) || charAt == '\\') {
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            u0(str, ':');
        } else {
            write(str);
            write(58);
        }
    }

    protected void x0(char[] cArr) {
        int i11 = 0;
        if (cArr == null) {
            int i12 = this.f343b + 4;
            if (i12 > this.f342a.length) {
                o(i12);
            }
            "null".getChars(0, 4, this.f342a, this.f343b);
            this.f343b = i12;
            return;
        }
        int length = cArr.length;
        int i13 = this.f343b + length + 2;
        if (i13 > this.f342a.length) {
            if (this.f345d != null) {
                write(39);
                while (i11 < cArr.length) {
                    char c11 = cArr[i11];
                    if (c11 <= '\r' || c11 == '\\' || c11 == '\'' || (c11 == '/' && q(SerializerFeature.WriteSlashAsSpecial))) {
                        write(92);
                        write(com.alibaba.fastjson.util.f.f18310j[c11]);
                    } else {
                        write(c11);
                    }
                    i11++;
                }
                write(39);
                return;
            }
            o(i13);
        }
        int i14 = this.f343b;
        int i15 = i14 + 1;
        int i16 = length + i15;
        char[] cArr2 = this.f342a;
        cArr2[i14] = '\'';
        System.arraycopy(cArr, 0, cArr2, i15, cArr.length);
        this.f343b = i13;
        int i17 = -1;
        char c12 = 0;
        for (int i18 = i15; i18 < i16; i18++) {
            char c13 = this.f342a[i18];
            if (c13 <= '\r' || c13 == '\\' || c13 == '\'' || (c13 == '/' && q(SerializerFeature.WriteSlashAsSpecial))) {
                i11++;
                i17 = i18;
                c12 = c13;
            }
        }
        int i19 = i13 + i11;
        if (i19 > this.f342a.length) {
            o(i19);
        }
        this.f343b = i19;
        if (i11 == 1) {
            char[] cArr3 = this.f342a;
            int i20 = i17 + 1;
            System.arraycopy(cArr3, i20, cArr3, i17 + 2, (i16 - i17) - 1);
            char[] cArr4 = this.f342a;
            cArr4[i17] = '\\';
            cArr4[i20] = com.alibaba.fastjson.util.f.f18310j[c12];
        } else if (i11 > 1) {
            char[] cArr5 = this.f342a;
            int i21 = i17 + 1;
            System.arraycopy(cArr5, i21, cArr5, i17 + 2, (i16 - i17) - 1);
            char[] cArr6 = this.f342a;
            cArr6[i17] = '\\';
            cArr6[i21] = com.alibaba.fastjson.util.f.f18310j[c12];
            int i22 = i16 + 1;
            for (int i23 = i17 - 1; i23 >= i15; i23--) {
                char c14 = this.f342a[i23];
                if (c14 <= '\r' || c14 == '\\' || c14 == '\'' || (c14 == '/' && q(SerializerFeature.WriteSlashAsSpecial))) {
                    char[] cArr7 = this.f342a;
                    int i24 = i23 + 1;
                    System.arraycopy(cArr7, i24, cArr7, i23 + 2, (i22 - i23) - 1);
                    char[] cArr8 = this.f342a;
                    cArr8[i23] = '\\';
                    cArr8[i24] = com.alibaba.fastjson.util.f.f18310j[c14];
                    i22++;
                }
            }
        }
        this.f342a[this.f343b - 1] = '\'';
    }

    public int y0(OutputStream outputStream, Charset charset) {
        if (this.f345d != null) {
            throw new UnsupportedOperationException("writer not null");
        }
        if (charset == com.alibaba.fastjson.util.f.f18302b) {
            return m(outputStream);
        }
        byte[] bytes = new String(this.f342a, 0, this.f343b).getBytes(charset);
        outputStream.write(bytes);
        return bytes.length;
    }
}
