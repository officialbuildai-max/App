package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import id.m;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class MinimalEncoder {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f32931a = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public enum Mode {
        ASCII,
        C40,
        TEXT,
        X12,
        EDF,
        B256
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f32932a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f32933b;

        static {
            int[] iArr = new int[SymbolShapeHint.values().length];
            f32933b = iArr;
            try {
                iArr[SymbolShapeHint.FORCE_SQUARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32933b[SymbolShapeHint.FORCE_RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[Mode.values().length];
            f32932a = iArr2;
            try {
                iArr2[Mode.ASCII.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32932a[Mode.B256.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32932a[Mode.C40.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32932a[Mode.TEXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32932a[Mode.X12.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f32932a[Mode.EDF.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: g, reason: collision with root package name */
        private static final int[] f32934g = {3, 5, 8, 10, 12, 16, 18, 22, 30, 32, 36, 44, 49, 62, 86, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, 144, 174, Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* renamed from: h, reason: collision with root package name */
        private static final int[] f32935h = {3, 5, 8, 12, 18, 22, 30, 36, 44, 62, 86, Sdk$SDKError.Reason.ASSET_WRITE_ERROR_VALUE, 144, 174, Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE, 280, 368, 456, 576, 696, 816, 1050, 1304, 1558};

        /* renamed from: i, reason: collision with root package name */
        private static final int[] f32936i = {5, 10, 16, 33, 32, 49};

        /* renamed from: a, reason: collision with root package name */
        private final c f32937a;

        /* renamed from: b, reason: collision with root package name */
        private final Mode f32938b;

        /* renamed from: c, reason: collision with root package name */
        private final int f32939c;

        /* renamed from: d, reason: collision with root package name */
        private final int f32940d;

        /* renamed from: e, reason: collision with root package name */
        private final b f32941e;

        /* renamed from: f, reason: collision with root package name */
        private final int f32942f;

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0071, code lost:
        
            if (r0 == r1) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
        
            if (r0 != com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12) goto L75;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c3, code lost:
        
            if (r0 != com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode.X12) goto L75;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private b(com.google.zxing.datamatrix.encoder.MinimalEncoder.c r6, com.google.zxing.datamatrix.encoder.MinimalEncoder.Mode r7, int r8, int r9, com.google.zxing.datamatrix.encoder.MinimalEncoder.b r10) {
            /*
                Method dump skipped, instructions count: 218
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.MinimalEncoder.b.<init>(com.google.zxing.datamatrix.encoder.MinimalEncoder$c, com.google.zxing.datamatrix.encoder.MinimalEncoder$Mode, int, int, com.google.zxing.datamatrix.encoder.MinimalEncoder$b):void");
        }

        /* synthetic */ b(c cVar, Mode mode, int i11, int i12, b bVar, a aVar) {
            this(cVar, mode, i11, i12, bVar);
        }

        static byte[] h(int i11) {
            return new byte[]{(byte) i11};
        }

        static byte[] i(int i11, int i12) {
            return new byte[]{(byte) i11, (byte) i12};
        }

        private static int j(boolean z10, int i11, char c11, int i12) {
            if (c11 == i12) {
                return 27;
            }
            if (z10) {
                if (c11 <= 31) {
                    return c11;
                }
                if (c11 == ' ') {
                    return 3;
                }
                return c11 <= '/' ? c11 - '!' : c11 <= '9' ? c11 - ',' : c11 <= '@' ? c11 - '+' : c11 <= 'Z' ? c11 - '3' : c11 <= '_' ? c11 - 'E' : c11 <= 127 ? c11 - '`' : c11;
            }
            if (c11 != 0) {
                if (i11 == 0 && c11 <= 3) {
                    return c11 - 1;
                }
                if (i11 == 1 && c11 <= 31) {
                    return c11;
                }
                if (c11 == ' ') {
                    return 3;
                }
                if (c11 >= '!' && c11 <= '/') {
                    return c11 - '!';
                }
                if (c11 >= '0' && c11 <= '9') {
                    return c11 - ',';
                }
                if (c11 >= ':' && c11 <= '@') {
                    return c11 - '+';
                }
                if (c11 >= 'A' && c11 <= 'Z') {
                    return c11 - '@';
                }
                if (c11 >= '[' && c11 <= '_') {
                    return c11 - 'E';
                }
                if (c11 != '`') {
                    return (c11 < 'a' || c11 > 'z') ? (c11 < '{' || c11 > 127) ? c11 : c11 - '`' : c11 - 'S';
                }
            }
            return 0;
        }

        static int v(char c11, boolean z10, int i11) {
            if (!(z10 && MinimalEncoder.l(c11)) && (z10 || !MinimalEncoder.n(c11))) {
                return (!(z10 && MinimalEncoder.m(c11, i11)) && (z10 || !MinimalEncoder.o(c11, i11))) ? 2 : 1;
            }
            return 0;
        }

        private static int w(char c11) {
            if (c11 == '\r') {
                return 0;
            }
            if (c11 == '*') {
                return 1;
            }
            if (c11 == '>') {
                return 2;
            }
            if (c11 == ' ') {
                return 3;
            }
            return (c11 < '0' || c11 > '9') ? (c11 < 'A' || c11 > 'Z') ? c11 : c11 - '3' : c11 - ',';
        }

        static void y(byte[] bArr, int i11, int i12, int i13, int i14) {
            int i15 = ((i12 & 255) * 1600) + ((i13 & 255) * 40) + (i14 & 255) + 1;
            bArr[i11] = (byte) (i15 / 256);
            bArr[i11 + 1] = (byte) (i15 % 256);
        }

        int g() {
            int i11 = 0;
            for (b bVar = this; bVar != null && bVar.f32938b == Mode.B256 && i11 <= 250; bVar = bVar.f32941e) {
                i11++;
            }
            return i11;
        }

        byte[] k(boolean z10, int i11) {
            ArrayList arrayList = new ArrayList();
            for (int i12 = 0; i12 < this.f32940d; i12++) {
                char charAt = this.f32937a.charAt(this.f32939c + i12);
                if ((z10 && g.h(charAt)) || (!z10 && g.j(charAt))) {
                    arrayList.add(Byte.valueOf((byte) j(z10, 0, charAt, i11)));
                } else if (MinimalEncoder.k(charAt, i11)) {
                    char c11 = (char) ((charAt & 255) - 128);
                    if (!(z10 && g.h(c11)) && (z10 || !g.j(c11))) {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        int v11 = v(c11, z10, i11);
                        arrayList.add(Byte.valueOf((byte) v11));
                        arrayList.add(Byte.valueOf((byte) j(z10, v11, c11, i11)));
                    } else {
                        arrayList.add((byte) 1);
                        arrayList.add((byte) 30);
                        arrayList.add(Byte.valueOf((byte) j(z10, 0, c11, i11)));
                    }
                } else {
                    int v12 = v(charAt, z10, i11);
                    arrayList.add(Byte.valueOf((byte) v12));
                    arrayList.add(Byte.valueOf((byte) j(z10, v12, charAt, i11)));
                }
            }
            if (arrayList.size() % 3 != 0) {
                arrayList.add((byte) 0);
            }
            byte[] bArr = new byte[(arrayList.size() / 3) * 2];
            int i13 = 0;
            for (int i14 = 0; i14 < arrayList.size(); i14 += 3) {
                y(bArr, i13, ((Byte) arrayList.get(i14)).byteValue() & 255, ((Byte) arrayList.get(i14 + 1)).byteValue() & 255, ((Byte) arrayList.get(i14 + 2)).byteValue() & 255);
                i13 += 2;
            }
            return bArr;
        }

        int l(int i11) {
            return r(i11) - i11;
        }

        byte[] m() {
            switch (a.f32932a[this.f32938b.ordinal()]) {
                case 1:
                    return this.f32937a.a(this.f32939c) ? i(241, this.f32937a.b(this.f32939c) + 1) : MinimalEncoder.k(this.f32937a.charAt(this.f32939c), this.f32937a.f()) ? i(235, this.f32937a.charAt(this.f32939c) - 127) : this.f32940d == 2 ? h(((this.f32937a.charAt(this.f32939c) - '0') * 10) + this.f32937a.charAt(this.f32939c + 1) + 82) : this.f32937a.h(this.f32939c) ? h(232) : h(this.f32937a.charAt(this.f32939c) + 1);
                case 2:
                    return h(this.f32937a.charAt(this.f32939c));
                case 3:
                    return k(true, this.f32937a.f());
                case 4:
                    return k(false, this.f32937a.f());
                case 5:
                    return x();
                case 6:
                    return n();
                default:
                    return new byte[0];
            }
        }

        byte[] n() {
            int ceil = (int) Math.ceil(this.f32940d / 4.0d);
            byte[] bArr = new byte[ceil * 3];
            int i11 = this.f32939c;
            int min = Math.min((this.f32940d + i11) - 1, this.f32937a.length() - 1);
            for (int i12 = 0; i12 < ceil; i12 += 3) {
                int[] iArr = new int[4];
                for (int i13 = 0; i13 < 4; i13++) {
                    if (i11 <= min) {
                        iArr[i13] = this.f32937a.charAt(i11) & '?';
                        i11++;
                    } else {
                        iArr[i13] = i11 == min + 1 ? 31 : 0;
                    }
                }
                int i14 = (iArr[0] << 18) | (iArr[1] << 12) | (iArr[2] << 6) | iArr[3];
                bArr[i12] = (byte) ((i14 >> 16) & 255);
                bArr[i12 + 1] = (byte) ((i14 >> 8) & 255);
                bArr[i12 + 2] = (byte) (i14 & 255);
            }
            return bArr;
        }

        Mode o() {
            if (this.f32938b == Mode.EDF) {
                if (this.f32940d < 4) {
                    return Mode.ASCII;
                }
                int p11 = p();
                if (p11 > 0 && l(this.f32942f + p11) <= 2 - p11) {
                    return Mode.ASCII;
                }
            }
            Mode mode = this.f32938b;
            if (mode == Mode.C40 || mode == Mode.TEXT || mode == Mode.X12) {
                if (this.f32939c + this.f32940d >= this.f32937a.length() && l(this.f32942f) == 0) {
                    return Mode.ASCII;
                }
                if (p() == 1 && l(this.f32942f + 1) == 0) {
                    return Mode.ASCII;
                }
            }
            return this.f32938b;
        }

        int p() {
            int length = this.f32937a.length();
            int i11 = this.f32939c + this.f32940d;
            int i12 = length - i11;
            if (i12 <= 4 && i11 < length) {
                if (i12 == 1) {
                    return MinimalEncoder.k(this.f32937a.charAt(i11), this.f32937a.f()) ? 0 : 1;
                }
                if (i12 == 2) {
                    if (!MinimalEncoder.k(this.f32937a.charAt(i11), this.f32937a.f())) {
                        int i13 = i11 + 1;
                        if (!MinimalEncoder.k(this.f32937a.charAt(i13), this.f32937a.f())) {
                            return (g.f(this.f32937a.charAt(i11)) && g.f(this.f32937a.charAt(i13))) ? 1 : 2;
                        }
                    }
                    return 0;
                }
                if (i12 == 3) {
                    if (g.f(this.f32937a.charAt(i11)) && g.f(this.f32937a.charAt(i11 + 1)) && !MinimalEncoder.k(this.f32937a.charAt(i11 + 2), this.f32937a.f())) {
                        return 2;
                    }
                    return (g.f(this.f32937a.charAt(i11 + 1)) && g.f(this.f32937a.charAt(i11 + 2)) && !MinimalEncoder.k(this.f32937a.charAt(i11), this.f32937a.f())) ? 2 : 0;
                }
                if (g.f(this.f32937a.charAt(i11)) && g.f(this.f32937a.charAt(i11 + 1)) && g.f(this.f32937a.charAt(i11 + 2)) && g.f(this.f32937a.charAt(i11 + 3))) {
                    return 2;
                }
            }
            return 0;
        }

        byte[] q() {
            int[] iArr = a.f32932a;
            switch (iArr[t().ordinal()]) {
                case 1:
                case 2:
                    int i11 = iArr[this.f32938b.ordinal()];
                    if (i11 == 2) {
                        return h(231);
                    }
                    if (i11 == 3) {
                        return h(230);
                    }
                    if (i11 == 4) {
                        return h(239);
                    }
                    if (i11 == 5) {
                        return h(238);
                    }
                    if (i11 == 6) {
                        return h(240);
                    }
                    break;
                case 3:
                case 4:
                case 5:
                    if (this.f32938b != t()) {
                        switch (iArr[this.f32938b.ordinal()]) {
                            case 1:
                                return h(254);
                            case 2:
                                return i(254, 231);
                            case 3:
                                return i(254, 230);
                            case 4:
                                return i(254, 239);
                            case 5:
                                return i(254, 238);
                            case 6:
                                return i(254, 240);
                        }
                    }
                    break;
            }
            return new byte[0];
        }

        int r(int i11) {
            int i12 = a.f32933b[this.f32937a.l().ordinal()];
            if (i12 == 1) {
                for (int i13 : f32935h) {
                    if (i13 >= i11) {
                        return i13;
                    }
                }
            } else if (i12 == 2) {
                for (int i14 : f32936i) {
                    if (i14 >= i11) {
                        return i14;
                    }
                }
            }
            for (int i15 : f32934g) {
                if (i15 >= i11) {
                    return i15;
                }
            }
            int[] iArr = f32934g;
            return iArr[iArr.length - 1];
        }

        Mode s() {
            return this.f32938b;
        }

        Mode t() {
            b bVar = this.f32941e;
            return bVar == null ? Mode.ASCII : bVar.o();
        }

        Mode u() {
            b bVar = this.f32941e;
            return bVar == null ? Mode.ASCII : bVar.f32938b;
        }

        byte[] x() {
            int i11 = (this.f32940d / 3) * 2;
            byte[] bArr = new byte[i11];
            for (int i12 = 0; i12 < i11; i12 += 2) {
                int i13 = (i12 / 2) * 3;
                y(bArr, i12, w(this.f32937a.charAt(this.f32939c + i13)), w(this.f32937a.charAt(this.f32939c + i13 + 1)), w(this.f32937a.charAt(this.f32939c + i13 + 2)));
            }
            return bArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class c extends m {

        /* renamed from: c, reason: collision with root package name */
        private final SymbolShapeHint f32943c;

        /* renamed from: d, reason: collision with root package name */
        private final int f32944d;

        private c(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint, int i12) {
            super(str, charset, i11);
            this.f32943c = symbolShapeHint;
            this.f32944d = i12;
        }

        /* synthetic */ c(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint, int i12, a aVar) {
            this(str, charset, i11, symbolShapeHint, i12);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int k() {
            return this.f32944d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SymbolShapeHint l() {
            return this.f32943c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        private final byte[] f32945a;

        d(b bVar) {
            int i11;
            c cVar = bVar.f32937a;
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            int i12 = 0;
            int c11 = ((bVar.f32938b == Mode.C40 || bVar.f32938b == Mode.TEXT || bVar.f32938b == Mode.X12) && bVar.o() != Mode.ASCII) ? c(b.h(254), arrayList) : 0;
            for (b bVar2 = bVar; bVar2 != null; bVar2 = bVar2.f32941e) {
                c11 += c(bVar2.m(), arrayList);
                if (bVar2.f32941e == null || bVar2.u() != bVar2.s()) {
                    if (bVar2.s() == Mode.B256) {
                        if (c11 <= 249) {
                            arrayList.add(0, Byte.valueOf((byte) c11));
                            i11 = c11 + 1;
                        } else {
                            arrayList.add(0, Byte.valueOf((byte) (c11 % 250)));
                            arrayList.add(0, Byte.valueOf((byte) ((c11 / 250) + 249)));
                            i11 = c11 + 2;
                        }
                        arrayList2.add(Integer.valueOf(arrayList.size()));
                        arrayList3.add(Integer.valueOf(i11));
                    }
                    c(bVar2.q(), arrayList);
                    c11 = 0;
                }
            }
            if (cVar.k() == 5) {
                c(b.h(236), arrayList);
            } else if (cVar.k() == 6) {
                c(b.h(237), arrayList);
            }
            if (cVar.f() > 0) {
                c(b.h(232), arrayList);
            }
            for (int i13 = 0; i13 < arrayList2.size(); i13++) {
                a(arrayList, arrayList.size() - ((Integer) arrayList2.get(i13)).intValue(), ((Integer) arrayList3.get(i13)).intValue());
            }
            int r11 = bVar.r(arrayList.size());
            if (arrayList.size() < r11) {
                arrayList.add((byte) -127);
            }
            while (arrayList.size() < r11) {
                arrayList.add(Byte.valueOf((byte) d(arrayList.size() + 1)));
            }
            this.f32945a = new byte[arrayList.size()];
            while (true) {
                byte[] bArr = this.f32945a;
                if (i12 >= bArr.length) {
                    return;
                }
                bArr[i12] = ((Byte) arrayList.get(i12)).byteValue();
                i12++;
            }
        }

        static void a(List list, int i11, int i12) {
            for (int i13 = 0; i13 < i12; i13++) {
                int i14 = i11 + i13;
                int byteValue = (((Byte) list.get(i14)).byteValue() & 255) + (((i14 + 1) * 149) % 255) + 1;
                if (byteValue > 255) {
                    byteValue += InputDeviceCompat.SOURCE_ANY;
                }
                list.set(i14, Byte.valueOf((byte) byteValue));
            }
        }

        static int c(byte[] bArr, List list) {
            for (int length = bArr.length - 1; length >= 0; length--) {
                list.add(0, Byte.valueOf(bArr[length]));
            }
            return bArr.length;
        }

        private static int d(int i11) {
            int i12 = (i11 * 149) % 253;
            int i13 = i12 + 130;
            return i13 <= 254 ? i13 : i12 - 124;
        }

        public byte[] b() {
            return this.f32945a;
        }
    }

    static void e(b[][] bVarArr, b bVar) {
        int i11 = bVar.f32939c + bVar.f32940d;
        if (bVarArr[i11][bVar.o().ordinal()] == null || bVarArr[i11][bVar.o().ordinal()].f32942f > bVar.f32942f) {
            bVarArr[i11][bVar.o().ordinal()] = bVar;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4 */
    static void f(c cVar, b[][] bVarArr, int i11, b bVar) {
        ?? r102 = 0;
        if (cVar.a(i11)) {
            e(bVarArr, new b(cVar, Mode.ASCII, i11, 1, bVar, null));
            return;
        }
        char charAt = cVar.charAt(i11);
        if (bVar == null || bVar.o() != Mode.EDF) {
            if (g.f(charAt) && cVar.g(i11, 2) && g.f(cVar.charAt(i11 + 1))) {
                e(bVarArr, new b(cVar, Mode.ASCII, i11, 2, bVar, null));
            } else {
                e(bVarArr, new b(cVar, Mode.ASCII, i11, 1, bVar, null));
            }
            Mode[] modeArr = {Mode.C40, Mode.TEXT};
            int i12 = 0;
            while (i12 < 2) {
                Mode mode = modeArr[i12];
                int[] iArr = new int[1];
                if (j(cVar, i11, mode == Mode.C40 ? true : r102, iArr) > 0) {
                    e(bVarArr, new b(cVar, mode, i11, iArr[r102], bVar, null));
                }
                i12++;
                r102 = 0;
            }
            if (cVar.g(i11, 3) && g.k(cVar.charAt(i11)) && g.k(cVar.charAt(i11 + 1)) && g.k(cVar.charAt(i11 + 2))) {
                e(bVarArr, new b(cVar, Mode.X12, i11, 3, bVar, null));
            }
            e(bVarArr, new b(cVar, Mode.B256, i11, 1, bVar, null));
        }
        int i13 = 0;
        while (i13 < 3) {
            int i14 = i11 + i13;
            if (!cVar.g(i14, 1) || !g.i(cVar.charAt(i14))) {
                break;
            }
            i13++;
            e(bVarArr, new b(cVar, Mode.EDF, i11, i13, bVar, null));
        }
        if (i13 == 3 && cVar.g(i11, 4) && g.i(cVar.charAt(i11 + 3))) {
            e(bVarArr, new b(cVar, Mode.EDF, i11, 4, bVar, null));
        }
    }

    static byte[] g(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint, int i12) {
        return i(new c(str, charset, i11, symbolShapeHint, i12, null)).b();
    }

    public static String h(String str, Charset charset, int i11, SymbolShapeHint symbolShapeHint) {
        int i12;
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i12 = 5;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            str = str.substring(7, str.length() - 2);
            i12 = 6;
        } else {
            i12 = 0;
        }
        return new String(g(str, charset, i11, symbolShapeHint, i12), StandardCharsets.ISO_8859_1);
    }

    static d i(c cVar) {
        int length = cVar.length();
        int i11 = 0;
        b[][] bVarArr = (b[][]) Array.newInstance((Class<?>) b.class, length + 1, 6);
        f(cVar, bVarArr, 0, null);
        for (int i12 = 1; i12 <= length; i12++) {
            for (int i13 = 0; i13 < 6; i13++) {
                b bVar = bVarArr[i12][i13];
                if (bVar != null && i12 < length) {
                    f(cVar, bVarArr, i12, bVar);
                }
            }
            for (int i14 = 0; i14 < 6; i14++) {
                bVarArr[i12 - 1][i14] = null;
            }
        }
        int i15 = -1;
        int i16 = Integer.MAX_VALUE;
        while (i11 < 6) {
            b bVar2 = bVarArr[length][i11];
            if (bVar2 != null) {
                int i17 = (i11 < 1 || i11 > 3) ? bVar2.f32942f : bVar2.f32942f + 1;
                if (i17 < i16) {
                    i15 = i11;
                    i16 = i17;
                }
            }
            i11++;
        }
        if (i15 >= 0) {
            return new d(bVarArr[length][i15]);
        }
        throw new IllegalStateException("Failed to encode \"" + cVar + "\"");
    }

    static int j(c cVar, int i11, boolean z10, int[] iArr) {
        int i12 = 0;
        for (int i13 = i11; i13 < cVar.length(); i13++) {
            if (cVar.a(i13)) {
                iArr[0] = 0;
                return 0;
            }
            char charAt = cVar.charAt(i13);
            if ((z10 && g.h(charAt)) || (!z10 && g.j(charAt))) {
                i12++;
            } else if (k(charAt, cVar.f())) {
                int i14 = charAt & 255;
                i12 = (i14 < 128 || (!(z10 && g.h((char) (i14 + (-128)))) && (z10 || !g.j((char) (i14 + (-128)))))) ? i12 + 4 : i12 + 3;
            } else {
                i12 += 2;
            }
            if (i12 % 3 == 0 || ((i12 - 2) % 3 == 0 && i13 + 1 == cVar.length())) {
                iArr[0] = (i13 - i11) + 1;
                return (int) Math.ceil(i12 / 3.0d);
            }
        }
        iArr[0] = 0;
        return 0;
    }

    static boolean k(char c11, int i11) {
        return c11 != i11 && c11 >= 128 && c11 <= 255;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean l(char c11) {
        return c11 <= 31;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean m(char c11, int i11) {
        for (char c12 : f32931a) {
            if (c12 == c11) {
                return true;
            }
        }
        return c11 == i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(char c11) {
        return l(c11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean o(char c11, int i11) {
        return m(c11, i11);
    }
}
