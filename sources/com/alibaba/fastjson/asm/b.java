package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import okio.Utf8;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f18155a;

    /* renamed from: b, reason: collision with root package name */
    private final int[] f18156b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f18157c;

    /* renamed from: d, reason: collision with root package name */
    private final int f18158d;

    /* renamed from: e, reason: collision with root package name */
    public final int f18159e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f18160f;

    public b(InputStream inputStream, boolean z10) {
        int i11;
        this.f18160f = z10;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            i11 = 0;
            if (read == -1) {
                break;
            } else if (read > 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
        }
        inputStream.close();
        this.f18155a = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[g(8)];
        this.f18156b = iArr;
        int length = iArr.length;
        this.f18157c = new String[length];
        int i12 = 10;
        int i13 = 1;
        while (i13 < length) {
            int i14 = i12 + 1;
            this.f18156b[i13] = i14;
            byte b11 = this.f18155a[i12];
            int i15 = 3;
            if (b11 == 1) {
                i15 = 3 + g(i14);
                if (i15 > i11) {
                    i11 = i15;
                }
            } else if (b11 != 15) {
                if (b11 != 18 && b11 != 3 && b11 != 4) {
                    if (b11 == 5 || b11 == 6) {
                        i13++;
                        i15 = 9;
                    } else {
                        switch (b11) {
                        }
                    }
                }
                i15 = 5;
            } else {
                i15 = 4;
            }
            i12 += i15;
            i13++;
        }
        this.f18158d = i11;
        this.f18159e = i12;
    }

    private int b() {
        int i11 = this.f18159e;
        int g11 = i11 + 8 + (g(i11 + 6) * 2);
        for (int g12 = g(g11); g12 > 0; g12--) {
            for (int g13 = g(g11 + 8); g13 > 0; g13--) {
                g11 += c(g11 + 12) + 6;
            }
            g11 += 8;
        }
        int i12 = g11 + 2;
        for (int g14 = g(i12); g14 > 0; g14--) {
            for (int g15 = g(i12 + 8); g15 > 0; g15--) {
                i12 += c(i12 + 12) + 6;
            }
            i12 += 8;
        }
        return i12 + 2;
    }

    private int c(int i11) {
        byte[] bArr = this.f18155a;
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }

    private int d(TypeCollector typeCollector, char[] cArr, int i11) {
        int g11 = g(i11);
        String f11 = f(i11 + 2, cArr);
        String f12 = f(i11 + 4, cArr);
        int i12 = i11 + 8;
        int i13 = 0;
        int i14 = 0;
        for (int g12 = g(i11 + 6); g12 > 0; g12--) {
            String f13 = f(i12, cArr);
            int c11 = c(i12 + 2);
            int i15 = i12 + 6;
            if (f13.equals("Code")) {
                i14 = i15;
            }
            i12 = i15 + c11;
        }
        g e11 = typeCollector.e(g11, f11, f12);
        if (e11 != null && i14 != 0) {
            int c12 = i14 + 8 + c(i14 + 4);
            int i16 = c12 + 2;
            for (int g13 = g(c12); g13 > 0; g13--) {
                i16 += 8;
            }
            int i17 = i16 + 2;
            int i18 = 0;
            for (int g14 = g(i16); g14 > 0; g14--) {
                String f14 = f(i17, cArr);
                if (f14.equals("LocalVariableTable")) {
                    i13 = i17 + 6;
                } else if (f14.equals("LocalVariableTypeTable")) {
                    i18 = i17 + 6;
                }
                i17 += c(i17 + 2) + 6;
            }
            if (i13 != 0) {
                if (i18 != 0) {
                    int g15 = g(i18) * 3;
                    int i19 = i18 + 2;
                    int[] iArr = new int[g15];
                    while (g15 > 0) {
                        iArr[g15 - 1] = i19 + 6;
                        iArr[g15 - 2] = g(i19 + 8);
                        g15 -= 3;
                        iArr[g15] = g(i19);
                        i19 += 10;
                    }
                }
                int i20 = i13 + 2;
                for (int g16 = g(i13); g16 > 0; g16--) {
                    e11.b(f(i20 + 4, cArr), g(i20 + 8));
                    i20 += 10;
                }
            }
        }
        return i12;
    }

    private String e(int i11, int i12, char[] cArr) {
        int i13;
        int i14 = i12 + i11;
        byte[] bArr = this.f18155a;
        int i15 = 0;
        char c11 = 0;
        char c12 = 0;
        while (i11 < i14) {
            int i16 = i11 + 1;
            byte b11 = bArr[i11];
            if (c11 != 0) {
                if (c11 == 1) {
                    cArr[i15] = (char) ((b11 & Utf8.REPLACEMENT_BYTE) | (c12 << 6));
                    i15++;
                    c11 = 0;
                } else if (c11 == 2) {
                    i13 = (b11 & Utf8.REPLACEMENT_BYTE) | (c12 << 6);
                    c12 = (char) i13;
                    c11 = 1;
                }
                i11 = i16;
            } else {
                int i17 = b11 & 255;
                if (i17 < 128) {
                    cArr[i15] = (char) i17;
                    i15++;
                } else if (i17 >= 224 || i17 <= 191) {
                    c12 = (char) (b11 & 15);
                    c11 = 2;
                } else {
                    i13 = b11 & 31;
                    c12 = (char) i13;
                    c11 = 1;
                }
                i11 = i16;
            }
        }
        return new String(cArr, 0, i15);
    }

    private String f(int i11, char[] cArr) {
        int g11 = g(i11);
        String[] strArr = this.f18157c;
        String str = strArr[g11];
        if (str != null) {
            return str;
        }
        int i12 = this.f18156b[g11];
        String e11 = e(i12 + 2, g(i12), cArr);
        strArr[g11] = e11;
        return e11;
    }

    private int g(int i11) {
        byte[] bArr = this.f18155a;
        return (bArr[i11 + 1] & 255) | ((bArr[i11] & 255) << 8);
    }

    public void a(TypeCollector typeCollector) {
        int i11;
        char[] cArr = new char[this.f18158d];
        if (this.f18160f) {
            int b11 = b();
            for (int g11 = g(b11); g11 > 0; g11--) {
                if ("RuntimeVisibleAnnotations".equals(f(b11 + 2, cArr))) {
                    i11 = b11 + 8;
                    break;
                }
                b11 += c(b11 + 4) + 6;
            }
        }
        i11 = 0;
        int i12 = this.f18159e;
        int g12 = g(i12 + 6);
        int i13 = i12 + 8;
        for (int i14 = 0; i14 < g12; i14++) {
            i13 += 2;
        }
        int i15 = i13 + 2;
        int i16 = i15;
        for (int g13 = g(i13); g13 > 0; g13--) {
            i16 += 8;
            for (int g14 = g(i16 + 6); g14 > 0; g14--) {
                i16 += c(i16 + 2) + 6;
            }
        }
        int i17 = i16 + 2;
        for (int g15 = g(i16); g15 > 0; g15--) {
            i17 += 8;
            for (int g16 = g(i17 + 6); g16 > 0; g16--) {
                i17 += c(i17 + 2) + 6;
            }
        }
        int i18 = i17 + 2;
        for (int g17 = g(i17); g17 > 0; g17--) {
            i18 += c(i18 + 2) + 6;
        }
        if (i11 != 0) {
            int i19 = i11 + 2;
            for (int g18 = g(i11); g18 > 0; g18--) {
                typeCollector.d(f(i19, cArr));
            }
        }
        for (int g19 = g(i13); g19 > 0; g19--) {
            i15 += 8;
            for (int g20 = g(i15 + 6); g20 > 0; g20--) {
                i15 += c(i15 + 2) + 6;
            }
        }
        int i20 = i15 + 2;
        for (int g21 = g(i15); g21 > 0; g21--) {
            i20 = d(typeCollector, cArr, i20);
        }
    }
}
