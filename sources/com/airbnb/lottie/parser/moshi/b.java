package com.airbnb.lottie.parser.moshi;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class b extends JsonReader {

    /* renamed from: n, reason: collision with root package name */
    private static final ByteString f18020n = ByteString.encodeUtf8("'\\");

    /* renamed from: o, reason: collision with root package name */
    private static final ByteString f18021o = ByteString.encodeUtf8("\"\\");

    /* renamed from: p, reason: collision with root package name */
    private static final ByteString f18022p = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: q, reason: collision with root package name */
    private static final ByteString f18023q = ByteString.encodeUtf8("\n\r");

    /* renamed from: r, reason: collision with root package name */
    private static final ByteString f18024r = ByteString.encodeUtf8("*/");

    /* renamed from: h, reason: collision with root package name */
    private final BufferedSource f18025h;

    /* renamed from: i, reason: collision with root package name */
    private final Buffer f18026i;

    /* renamed from: j, reason: collision with root package name */
    private int f18027j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f18028k;

    /* renamed from: l, reason: collision with root package name */
    private int f18029l;

    /* renamed from: m, reason: collision with root package name */
    private String f18030m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.f18025h = bufferedSource;
        this.f18026i = bufferedSource.getBufferField();
        u(6);
    }

    private void V() {
        if (!this.f18016e) {
            throw U("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int Z() {
        int[] iArr = this.f18013b;
        int i11 = this.f18012a;
        int i12 = iArr[i11 - 1];
        if (i12 == 1) {
            iArr[i11 - 1] = 2;
        } else if (i12 == 2) {
            int d02 = d0(true);
            this.f18026i.readByte();
            if (d02 != 44) {
                if (d02 != 59) {
                    if (d02 != 93) {
                        throw U("Unterminated array");
                    }
                    this.f18027j = 4;
                    return 4;
                }
                V();
            }
        } else {
            if (i12 == 3 || i12 == 5) {
                iArr[i11 - 1] = 4;
                if (i12 == 5) {
                    int d03 = d0(true);
                    this.f18026i.readByte();
                    if (d03 != 44) {
                        if (d03 != 59) {
                            if (d03 != 125) {
                                throw U("Unterminated object");
                            }
                            this.f18027j = 2;
                            return 2;
                        }
                        V();
                    }
                }
                int d04 = d0(true);
                if (d04 == 34) {
                    this.f18026i.readByte();
                    this.f18027j = 13;
                    return 13;
                }
                if (d04 == 39) {
                    this.f18026i.readByte();
                    V();
                    this.f18027j = 12;
                    return 12;
                }
                if (d04 != 125) {
                    V();
                    if (!c0((char) d04)) {
                        throw U("Expected name");
                    }
                    this.f18027j = 14;
                    return 14;
                }
                if (i12 == 5) {
                    throw U("Expected name");
                }
                this.f18026i.readByte();
                this.f18027j = 2;
                return 2;
            }
            if (i12 == 4) {
                iArr[i11 - 1] = 5;
                int d05 = d0(true);
                this.f18026i.readByte();
                if (d05 != 58) {
                    if (d05 != 61) {
                        throw U("Expected ':'");
                    }
                    V();
                    if (this.f18025h.request(1L) && this.f18026i.getByte(0L) == 62) {
                        this.f18026i.readByte();
                    }
                }
            } else if (i12 == 6) {
                iArr[i11 - 1] = 7;
            } else if (i12 == 7) {
                if (d0(false) == -1) {
                    this.f18027j = 18;
                    return 18;
                }
                V();
            } else if (i12 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int d06 = d0(true);
        if (d06 == 34) {
            this.f18026i.readByte();
            this.f18027j = 9;
            return 9;
        }
        if (d06 == 39) {
            V();
            this.f18026i.readByte();
            this.f18027j = 8;
            return 8;
        }
        if (d06 != 44 && d06 != 59) {
            if (d06 == 91) {
                this.f18026i.readByte();
                this.f18027j = 3;
                return 3;
            }
            if (d06 != 93) {
                if (d06 == 123) {
                    this.f18026i.readByte();
                    this.f18027j = 1;
                    return 1;
                }
                int k02 = k0();
                if (k02 != 0) {
                    return k02;
                }
                int l02 = l0();
                if (l02 != 0) {
                    return l02;
                }
                if (!c0(this.f18026i.getByte(0L))) {
                    throw U("Expected value");
                }
                V();
                this.f18027j = 10;
                return 10;
            }
            if (i12 == 1) {
                this.f18026i.readByte();
                this.f18027j = 4;
                return 4;
            }
        }
        if (i12 != 1 && i12 != 2) {
            throw U("Unexpected value");
        }
        V();
        this.f18027j = 7;
        return 7;
    }

    private int a0(String str, JsonReader.a aVar) {
        int length = aVar.f18018a.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (str.equals(aVar.f18018a[i11])) {
                this.f18027j = 0;
                this.f18014c[this.f18012a - 1] = str;
                return i11;
            }
        }
        return -1;
    }

    private boolean c0(int i11) {
        if (i11 == 9 || i11 == 10 || i11 == 12 || i11 == 13 || i11 == 32) {
            return false;
        }
        if (i11 != 35) {
            if (i11 == 44) {
                return false;
            }
            if (i11 != 47 && i11 != 61) {
                if (i11 == 123 || i11 == 125 || i11 == 58) {
                    return false;
                }
                if (i11 != 59) {
                    switch (i11) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        V();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        r6.f18026i.skip(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
    
        if (r2 != 47) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        if (r2 != 35) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        V();
        q0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0037, code lost:
    
        if (r6.f18025h.request(2) != false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003a, code lost:
    
        V();
        r3 = r6.f18026i.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0047, code lost:
    
        if (r3 == 42) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005a, code lost:
    
        r6.f18026i.readByte();
        r6.f18026i.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0068, code lost:
    
        if (p0() == false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0071, code lost:
    
        throw U("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0049, code lost:
    
        if (r3 == 47) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x004c, code lost:
    
        r6.f18026i.readByte();
        r6.f18026i.readByte();
        q0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x004b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int d0(boolean r7) {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            okio.BufferedSource r2 = r6.f18025h
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L80
            okio.Buffer r2 = r6.f18026i
            long r4 = (long) r1
            byte r2 = r2.getByte(r4)
            r4 = 10
            if (r2 == r4) goto L7e
            r4 = 32
            if (r2 == r4) goto L7e
            r4 = 13
            if (r2 == r4) goto L7e
            r4 = 9
            if (r2 != r4) goto L25
            goto L7e
        L25:
            okio.Buffer r3 = r6.f18026i
            long r4 = (long) r1
            r3.skip(r4)
            r1 = 47
            if (r2 != r1) goto L72
            okio.BufferedSource r3 = r6.f18025h
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3a
            return r2
        L3a:
            r6.V()
            okio.Buffer r3 = r6.f18026i
            r4 = 1
            byte r3 = r3.getByte(r4)
            r4 = 42
            if (r3 == r4) goto L5a
            if (r3 == r1) goto L4c
            return r2
        L4c:
            okio.Buffer r1 = r6.f18026i
            r1.readByte()
            okio.Buffer r1 = r6.f18026i
            r1.readByte()
            r6.q0()
            goto L1
        L5a:
            okio.Buffer r1 = r6.f18026i
            r1.readByte()
            okio.Buffer r1 = r6.f18026i
            r1.readByte()
            boolean r1 = r6.p0()
            if (r1 == 0) goto L6b
            goto L1
        L6b:
            java.lang.String r7 = "Unterminated comment"
            com.airbnb.lottie.parser.moshi.JsonEncodingException r7 = r6.U(r7)
            throw r7
        L72:
            r1 = 35
            if (r2 != r1) goto L7d
            r6.V()
            r6.q0()
            goto L1
        L7d:
            return r2
        L7e:
            r1 = r3
            goto L2
        L80:
            if (r7 != 0) goto L84
            r7 = -1
            return r7
        L84:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.d0(boolean):int");
    }

    private String g0(ByteString byteString) {
        StringBuilder sb2 = null;
        while (true) {
            long indexOfElement = this.f18025h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw U("Unterminated string");
            }
            if (this.f18026i.getByte(indexOfElement) != 92) {
                if (sb2 == null) {
                    String readUtf8 = this.f18026i.readUtf8(indexOfElement);
                    this.f18026i.readByte();
                    return readUtf8;
                }
                sb2.append(this.f18026i.readUtf8(indexOfElement));
                this.f18026i.readByte();
                return sb2.toString();
            }
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            sb2.append(this.f18026i.readUtf8(indexOfElement));
            this.f18026i.readByte();
            sb2.append(m0());
        }
    }

    private String h0() {
        long indexOfElement = this.f18025h.indexOfElement(f18022p);
        return indexOfElement != -1 ? this.f18026i.readUtf8(indexOfElement) : this.f18026i.readUtf8();
    }

    private int k0() {
        String str;
        String str2;
        int i11;
        byte b11 = this.f18026i.getByte(0L);
        if (b11 == 116 || b11 == 84) {
            str = "true";
            str2 = "TRUE";
            i11 = 5;
        } else if (b11 == 102 || b11 == 70) {
            str = "false";
            str2 = "FALSE";
            i11 = 6;
        } else {
            if (b11 != 110 && b11 != 78) {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i11 = 7;
        }
        int length = str.length();
        int i12 = 1;
        while (i12 < length) {
            int i13 = i12 + 1;
            if (!this.f18025h.request(i13)) {
                return 0;
            }
            byte b12 = this.f18026i.getByte(i12);
            if (b12 != str.charAt(i12) && b12 != str2.charAt(i12)) {
                return 0;
            }
            i12 = i13;
        }
        if (this.f18025h.request(length + 1) && c0(this.f18026i.getByte(length))) {
            return 0;
        }
        this.f18026i.skip(length);
        this.f18027j = i11;
        return i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0081, code lost:
    
        if (c0(r11) != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0083, code lost:
    
        if (r6 != 2) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0085, code lost:
    
        if (r7 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x008b, code lost:
    
        if (r8 != Long.MIN_VALUE) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x008d, code lost:
    
        if (r10 == false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0091, code lost:
    
        if (r8 != 0) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0093, code lost:
    
        if (r10 != false) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0095, code lost:
    
        if (r10 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0098, code lost:
    
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0099, code lost:
    
        r16.f18028k = r8;
        r16.f18026i.skip(r5);
        r16.f18027j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a6, code lost:
    
        if (r6 == 2) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00a9, code lost:
    
        if (r6 == 4) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00ac, code lost:
    
        if (r6 != 7) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00af, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b0, code lost:
    
        r16.f18029l = r5;
        r16.f18027j = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b6, code lost:
    
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b7, code lost:
    
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int l0() {
        /*
            Method dump skipped, instructions count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.b.l0():int");
    }

    private char m0() {
        int i11;
        if (!this.f18025h.request(1L)) {
            throw U("Unterminated escape sequence");
        }
        byte readByte = this.f18026i.readByte();
        if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
            return (char) readByte;
        }
        if (readByte == 98) {
            return '\b';
        }
        if (readByte == 102) {
            return '\f';
        }
        if (readByte == 110) {
            return '\n';
        }
        if (readByte == 114) {
            return '\r';
        }
        if (readByte == 116) {
            return '\t';
        }
        if (readByte != 117) {
            if (this.f18016e) {
                return (char) readByte;
            }
            throw U("Invalid escape sequence: \\" + ((char) readByte));
        }
        if (!this.f18025h.request(4L)) {
            throw new EOFException("Unterminated escape sequence at path " + getPath());
        }
        char c11 = 0;
        for (int i12 = 0; i12 < 4; i12++) {
            byte b11 = this.f18026i.getByte(i12);
            char c12 = (char) (c11 << 4);
            if (b11 >= 48 && b11 <= 57) {
                i11 = b11 - 48;
            } else if (b11 >= 97 && b11 <= 102) {
                i11 = b11 - 87;
            } else {
                if (b11 < 65 || b11 > 70) {
                    throw U("\\u" + this.f18026i.readUtf8(4L));
                }
                i11 = b11 - 55;
            }
            c11 = (char) (c12 + i11);
        }
        this.f18026i.skip(4L);
        return c11;
    }

    private void o0(ByteString byteString) {
        while (true) {
            long indexOfElement = this.f18025h.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw U("Unterminated string");
            }
            if (this.f18026i.getByte(indexOfElement) != 92) {
                this.f18026i.skip(indexOfElement + 1);
                return;
            } else {
                this.f18026i.skip(indexOfElement + 1);
                m0();
            }
        }
    }

    private boolean p0() {
        long indexOf = this.f18025h.indexOf(f18024r);
        boolean z10 = indexOf != -1;
        Buffer buffer = this.f18026i;
        buffer.skip(z10 ? indexOf + r1.size() : buffer.size());
        return z10;
    }

    private void q0() {
        long indexOfElement = this.f18025h.indexOfElement(f18023q);
        Buffer buffer = this.f18026i;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    private void r0() {
        long indexOfElement = this.f18025h.indexOfElement(f18022p);
        Buffer buffer = this.f18026i;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f18027j = 0;
        this.f18013b[0] = 8;
        this.f18012a = 1;
        this.f18026i.clear();
        this.f18025h.close();
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void d() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 3) {
            u(1);
            this.f18015d[this.f18012a - 1] = 0;
            this.f18027j = 0;
        } else {
            throw new JsonDataException("Expected BEGIN_ARRAY but was " + t() + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void h() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 1) {
            u(3);
            this.f18027j = 0;
            return;
        }
        throw new JsonDataException("Expected BEGIN_OBJECT but was " + t() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void k() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 != 4) {
            throw new JsonDataException("Expected END_ARRAY but was " + t() + " at path " + getPath());
        }
        int i12 = this.f18012a;
        this.f18012a = i12 - 1;
        int[] iArr = this.f18015d;
        int i13 = i12 - 2;
        iArr[i13] = iArr[i13] + 1;
        this.f18027j = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void l() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 != 2) {
            throw new JsonDataException("Expected END_OBJECT but was " + t() + " at path " + getPath());
        }
        int i12 = this.f18012a;
        int i13 = i12 - 1;
        this.f18012a = i13;
        this.f18014c[i13] = null;
        int[] iArr = this.f18015d;
        int i14 = i12 - 2;
        iArr[i14] = iArr[i14] + 1;
        this.f18027j = 0;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean m() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        return (i11 == 2 || i11 == 4 || i11 == 18) ? false : true;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public boolean n() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 5) {
            this.f18027j = 0;
            int[] iArr = this.f18015d;
            int i12 = this.f18012a - 1;
            iArr[i12] = iArr[i12] + 1;
            return true;
        }
        if (i11 == 6) {
            this.f18027j = 0;
            int[] iArr2 = this.f18015d;
            int i13 = this.f18012a - 1;
            iArr2[i13] = iArr2[i13] + 1;
            return false;
        }
        throw new JsonDataException("Expected a boolean but was " + t() + " at path " + getPath());
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public double o() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 16) {
            this.f18027j = 0;
            int[] iArr = this.f18015d;
            int i12 = this.f18012a - 1;
            iArr[i12] = iArr[i12] + 1;
            return this.f18028k;
        }
        if (i11 == 17) {
            this.f18030m = this.f18026i.readUtf8(this.f18029l);
        } else if (i11 == 9) {
            this.f18030m = g0(f18021o);
        } else if (i11 == 8) {
            this.f18030m = g0(f18020n);
        } else if (i11 == 10) {
            this.f18030m = h0();
        } else if (i11 != 11) {
            throw new JsonDataException("Expected a double but was " + t() + " at path " + getPath());
        }
        this.f18027j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f18030m);
            if (this.f18016e || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                this.f18030m = null;
                this.f18027j = 0;
                int[] iArr2 = this.f18015d;
                int i13 = this.f18012a - 1;
                iArr2[i13] = iArr2[i13] + 1;
                return parseDouble;
            }
            throw new JsonEncodingException("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
        } catch (NumberFormatException unused) {
            throw new JsonDataException("Expected a double but was " + this.f18030m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int p() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 16) {
            long j11 = this.f18028k;
            int i12 = (int) j11;
            if (j11 == i12) {
                this.f18027j = 0;
                int[] iArr = this.f18015d;
                int i13 = this.f18012a - 1;
                iArr[i13] = iArr[i13] + 1;
                return i12;
            }
            throw new JsonDataException("Expected an int but was " + this.f18028k + " at path " + getPath());
        }
        if (i11 == 17) {
            this.f18030m = this.f18026i.readUtf8(this.f18029l);
        } else if (i11 == 9 || i11 == 8) {
            String g02 = i11 == 9 ? g0(f18021o) : g0(f18020n);
            this.f18030m = g02;
            try {
                int parseInt = Integer.parseInt(g02);
                this.f18027j = 0;
                int[] iArr2 = this.f18015d;
                int i14 = this.f18012a - 1;
                iArr2[i14] = iArr2[i14] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i11 != 11) {
            throw new JsonDataException("Expected an int but was " + t() + " at path " + getPath());
        }
        this.f18027j = 11;
        try {
            double parseDouble = Double.parseDouble(this.f18030m);
            int i15 = (int) parseDouble;
            if (i15 == parseDouble) {
                this.f18030m = null;
                this.f18027j = 0;
                int[] iArr3 = this.f18015d;
                int i16 = this.f18012a - 1;
                iArr3[i16] = iArr3[i16] + 1;
                return i15;
            }
            throw new JsonDataException("Expected an int but was " + this.f18030m + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new JsonDataException("Expected an int but was " + this.f18030m + " at path " + getPath());
        }
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String q() {
        String str;
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 14) {
            str = h0();
        } else if (i11 == 13) {
            str = g0(f18021o);
        } else if (i11 == 12) {
            str = g0(f18020n);
        } else {
            if (i11 != 15) {
                throw new JsonDataException("Expected a name but was " + t() + " at path " + getPath());
            }
            str = this.f18030m;
        }
        this.f18027j = 0;
        this.f18014c[this.f18012a - 1] = str;
        return str;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public String r() {
        String readUtf8;
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 10) {
            readUtf8 = h0();
        } else if (i11 == 9) {
            readUtf8 = g0(f18021o);
        } else if (i11 == 8) {
            readUtf8 = g0(f18020n);
        } else if (i11 == 11) {
            readUtf8 = this.f18030m;
            this.f18030m = null;
        } else if (i11 == 16) {
            readUtf8 = Long.toString(this.f18028k);
        } else {
            if (i11 != 17) {
                throw new JsonDataException("Expected a string but was " + t() + " at path " + getPath());
            }
            readUtf8 = this.f18026i.readUtf8(this.f18029l);
        }
        this.f18027j = 0;
        int[] iArr = this.f18015d;
        int i12 = this.f18012a - 1;
        iArr[i12] = iArr[i12] + 1;
        return readUtf8;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public JsonReader.Token t() {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        switch (i11) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String toString() {
        return "JsonReader(" + this.f18025h + ")";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public int v(JsonReader.a aVar) {
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 < 12 || i11 > 15) {
            return -1;
        }
        if (i11 == 15) {
            return a0(this.f18030m, aVar);
        }
        int select = this.f18025h.select(aVar.f18019b);
        if (select != -1) {
            this.f18027j = 0;
            this.f18014c[this.f18012a - 1] = aVar.f18018a[select];
            return select;
        }
        String str = this.f18014c[this.f18012a - 1];
        String q11 = q();
        int a02 = a0(q11, aVar);
        if (a02 == -1) {
            this.f18027j = 15;
            this.f18030m = q11;
            this.f18014c[this.f18012a - 1] = str;
        }
        return a02;
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void w() {
        if (this.f18017f) {
            throw new JsonDataException("Cannot skip unexpected " + t() + " at " + getPath());
        }
        int i11 = this.f18027j;
        if (i11 == 0) {
            i11 = Z();
        }
        if (i11 == 14) {
            r0();
        } else if (i11 == 13) {
            o0(f18021o);
        } else if (i11 == 12) {
            o0(f18020n);
        } else if (i11 != 15) {
            throw new JsonDataException("Expected a name but was " + t() + " at path " + getPath());
        }
        this.f18027j = 0;
        this.f18014c[this.f18012a - 1] = "null";
    }

    @Override // com.airbnb.lottie.parser.moshi.JsonReader
    public void x() {
        if (this.f18017f) {
            throw new JsonDataException("Cannot skip unexpected " + t() + " at " + getPath());
        }
        int i11 = 0;
        do {
            int i12 = this.f18027j;
            if (i12 == 0) {
                i12 = Z();
            }
            if (i12 == 3) {
                u(1);
            } else if (i12 == 1) {
                u(3);
            } else {
                if (i12 == 4) {
                    i11--;
                    if (i11 < 0) {
                        throw new JsonDataException("Expected a value but was " + t() + " at path " + getPath());
                    }
                    this.f18012a--;
                } else if (i12 == 2) {
                    i11--;
                    if (i11 < 0) {
                        throw new JsonDataException("Expected a value but was " + t() + " at path " + getPath());
                    }
                    this.f18012a--;
                } else if (i12 == 14 || i12 == 10) {
                    r0();
                } else if (i12 == 9 || i12 == 13) {
                    o0(f18021o);
                } else if (i12 == 8 || i12 == 12) {
                    o0(f18020n);
                } else if (i12 == 17) {
                    this.f18026i.skip(this.f18029l);
                } else if (i12 == 18) {
                    throw new JsonDataException("Expected a value but was " + t() + " at path " + getPath());
                }
                this.f18027j = 0;
            }
            i11++;
            this.f18027j = 0;
        } while (i11 != 0);
        int[] iArr = this.f18015d;
        int i13 = this.f18012a;
        int i14 = i13 - 1;
        iArr[i14] = iArr[i14] + 1;
        this.f18014c[i13 - 1] = "null";
    }
}
