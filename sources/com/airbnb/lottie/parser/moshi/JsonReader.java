package com.airbnb.lottie.parser.moshi;

import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;

/* loaded from: classes.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f18011g = new String[128];

    /* renamed from: a, reason: collision with root package name */
    int f18012a;

    /* renamed from: b, reason: collision with root package name */
    int[] f18013b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    String[] f18014c = new String[32];

    /* renamed from: d, reason: collision with root package name */
    int[] f18015d = new int[32];

    /* renamed from: e, reason: collision with root package name */
    boolean f18016e;

    /* renamed from: f, reason: collision with root package name */
    boolean f18017f;

    /* loaded from: classes.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        final String[] f18018a;

        /* renamed from: b, reason: collision with root package name */
        final Options f18019b;

        private a(String[] strArr, Options options) {
            this.f18018a = strArr;
            this.f18019b = options;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                Buffer buffer = new Buffer();
                for (int i11 = 0; i11 < strArr.length; i11++) {
                    JsonReader.T(buffer, strArr[i11]);
                    buffer.readByte();
                    byteStringArr[i11] = buffer.readByteString();
                }
                return new a((String[]) strArr.clone(), Options.of(byteStringArr));
            } catch (IOException e11) {
                throw new AssertionError(e11);
            }
        }
    }

    static {
        for (int i11 = 0; i11 <= 31; i11++) {
            f18011g[i11] = String.format("\\u%04x", Integer.valueOf(i11));
        }
        String[] strArr = f18011g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void T(okio.BufferedSink r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = com.airbnb.lottie.parser.moshi.JsonReader.f18011g
            r1 = 34
            r7.writeByte(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.writeUtf8(r8, r4, r3)
        L2e:
            r7.writeUtf8(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.writeUtf8(r8, r4, r2)
        L3b:
            r7.writeByte(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.parser.moshi.JsonReader.T(okio.BufferedSink, java.lang.String):void");
    }

    public static JsonReader s(BufferedSource bufferedSource) {
        return new b(bufferedSource);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final JsonEncodingException U(String str) {
        throw new JsonEncodingException(str + " at path " + getPath());
    }

    public abstract void d();

    public final String getPath() {
        return com.airbnb.lottie.parser.moshi.a.a(this.f18012a, this.f18013b, this.f18014c, this.f18015d);
    }

    public abstract void h();

    public abstract void k();

    public abstract void l();

    public abstract boolean m();

    public abstract boolean n();

    public abstract double o();

    public abstract int p();

    public abstract String q();

    public abstract String r();

    public abstract Token t();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void u(int i11) {
        int i12 = this.f18012a;
        int[] iArr = this.f18013b;
        if (i12 == iArr.length) {
            if (i12 == 256) {
                throw new JsonDataException("Nesting too deep at " + getPath());
            }
            this.f18013b = Arrays.copyOf(iArr, iArr.length * 2);
            String[] strArr = this.f18014c;
            this.f18014c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
            int[] iArr2 = this.f18015d;
            this.f18015d = Arrays.copyOf(iArr2, iArr2.length * 2);
        }
        int[] iArr3 = this.f18013b;
        int i13 = this.f18012a;
        this.f18012a = i13 + 1;
        iArr3[i13] = i11;
    }

    public abstract int v(a aVar);

    public abstract void w();

    public abstract void x();
}
