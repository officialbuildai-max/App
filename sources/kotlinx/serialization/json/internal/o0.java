package kotlinx.serialization.json.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public abstract class o0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f68461a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f68462b;

    static {
        String[] strArr = new String[93];
        for (int i11 = 0; i11 < 32; i11++) {
            strArr[i11] = "\\u" + e(i11 >> 12) + e(i11 >> 8) + e(i11 >> 4) + e(i11);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f68461a = strArr;
        byte[] bArr = new byte[93];
        for (int i12 = 0; i12 < 32; i12++) {
            bArr[i12] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f68462b = bArr;
    }

    public static final byte[] a() {
        return f68462b;
    }

    public static final String[] b() {
        return f68461a;
    }

    public static final void c(StringBuilder sb2, String value) {
        Intrinsics.h(sb2, "<this>");
        Intrinsics.h(value, "value");
        sb2.append('\"');
        int length = value.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = value.charAt(i12);
            String[] strArr = f68461a;
            if (charAt < strArr.length && strArr[charAt] != null) {
                sb2.append((CharSequence) value, i11, i12);
                sb2.append(strArr[charAt]);
                i11 = i12 + 1;
            }
        }
        if (i11 != 0) {
            sb2.append((CharSequence) value, i11, value.length());
        } else {
            sb2.append(value);
        }
        sb2.append('\"');
    }

    public static final Boolean d(String str) {
        Intrinsics.h(str, "<this>");
        if (StringsKt.H(str, "true", true)) {
            return Boolean.TRUE;
        }
        if (StringsKt.H(str, "false", true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    private static final char e(int i11) {
        int i12 = i11 & 15;
        return (char) (i12 < 10 ? i12 + 48 : i12 + 87);
    }
}
