package com.google.android.gms.common.server.response;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.JsonUtils;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;
import okio.internal.Buffer;

@ShowFirstParty
@KeepForSdk
/* loaded from: classes3.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', '\"'};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', '\"'};
    private static final char[] zaf = {'\n'};
    private static final zai zag = new zaa();
    private static final zai zah = new zab();
    private static final zai zai = new zac();
    private static final zai zaj = new zad();
    private static final zai zak = new zae();
    private static final zai zal = new zaf();
    private static final zai zam = new zag();
    private static final zai zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack zat = new Stack();

    @ShowFirstParty
    @KeepForSdk
    /* loaded from: classes3.dex */
    public static class ParseException extends Exception {
        public ParseException(@NonNull String str) {
            super(str);
        }

        public ParseException(@NonNull String str, @NonNull Throwable th2) {
            super("Error instantiating inner object", th2);
        }

        public ParseException(@NonNull Throwable th2) {
            super(th2);
        }
    }

    private static final String zaA(BufferedReader bufferedReader, char[] cArr, StringBuilder sb2, @Nullable char[] cArr2) throws ParseException, IOException {
        sb2.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z10 = false;
        boolean z11 = false;
        loop0: while (true) {
            int read = bufferedReader.read(cArr);
            if (read == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            int i11 = 0;
            while (i11 < read) {
                char c11 = cArr[i11];
                if (!Character.isISOControl(c11) || (cArr2 != null && cArr2[0] == c11)) {
                    int i12 = i11 + 1;
                    if (c11 == '\"') {
                        if (!z10) {
                            sb2.append(cArr, 0, i11);
                            bufferedReader.reset();
                            bufferedReader.skip(i12);
                            return z11 ? JsonUtils.unescapeString(sb2.toString()) : sb2.toString();
                        }
                    } else if (c11 == '\\') {
                        z10 = !z10;
                        z11 = true;
                        i11 = i12;
                    }
                    z10 = false;
                    i11 = i12;
                }
            }
            sb2.append(cArr, 0, read);
            bufferedReader.mark(cArr.length);
        }
        throw new ParseException("Unexpected control character while reading string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
    
        return r3.zao[0];
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0022, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0008, code lost:
    
        if (r4.read(r3.zao) != (-1)) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (java.lang.Character.isWhitespace(r3.zao[0]) == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
    
        if (r4.read(r3.zao) != (-1)) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final char zai(java.io.BufferedReader r4) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r3 = this;
            char[] r0 = r3.zao
            int r0 = r4.read(r0)
            r1 = 0
            r2 = -1
            if (r0 == r2) goto L22
        La:
            char[] r0 = r3.zao
            char r0 = r0[r1]
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L1d
            char[] r0 = r3.zao
            int r0 = r4.read(r0)
            if (r0 != r2) goto La
            goto L22
        L1d:
            char[] r4 = r3.zao
            char r4 = r4[r1]
            return r4
        L22:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zai(java.io.BufferedReader):char");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) throws ParseException, IOException {
        int i11;
        int i12;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c11 = cArr[0];
        int i13 = c11 == '-' ? Integer.MIN_VALUE : -2147483647;
        int i14 = c11 == '-' ? 1 : 0;
        if (i14 < zam2) {
            i12 = i14 + 1;
            int digit = Character.digit(cArr[i14], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            i11 = -digit;
        } else {
            i11 = 0;
            i12 = i14;
        }
        while (i12 < zam2) {
            int i15 = i12 + 1;
            int digit2 = Character.digit(cArr[i12], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (i11 < -214748364) {
                throw new ParseException("Number too large");
            }
            int i16 = i11 * 10;
            if (i16 < i13 + digit2) {
                throw new ParseException("Number too large");
            }
            i11 = i16 - digit2;
            i12 = i15;
        }
        if (i14 == 0) {
            return -i11;
        }
        if (i12 > 1) {
            return i11;
        }
        throw new ParseException("No digits to parse");
    }

    @ResultIgnorabilityUnspecified
    private final int zam(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i11;
        char zai2 = zai(bufferedReader);
        if (zai2 == 0) {
            throw new ParseException("Unexpected EOF");
        }
        if (zai2 == ',') {
            throw new ParseException("Missing value");
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return 0;
        }
        bufferedReader.mark(1024);
        if (zai2 == '\"') {
            i11 = 0;
            boolean z10 = false;
            while (i11 < 1024 && bufferedReader.read(cArr, i11, 1) != -1) {
                char c11 = cArr[i11];
                if (Character.isISOControl(c11)) {
                    throw new ParseException("Unexpected control character while reading string");
                }
                int i12 = i11 + 1;
                if (c11 == '\"') {
                    if (!z10) {
                        bufferedReader.reset();
                        bufferedReader.skip(i12);
                        return i11;
                    }
                } else if (c11 == '\\') {
                    z10 = !z10;
                    i11 = i12;
                }
                z10 = false;
                i11 = i12;
            }
        } else {
            cArr[0] = zai2;
            i11 = 1;
            while (i11 < 1024 && bufferedReader.read(cArr, i11, 1) != -1) {
                char c12 = cArr[i11];
                if (c12 == '}' || c12 == ',' || Character.isWhitespace(c12) || cArr[i11] == ']') {
                    bufferedReader.reset();
                    bufferedReader.skip(i11 - 1);
                    cArr[i11] = 0;
                    return i11;
                }
                i11++;
            }
        }
        if (i11 == 1024) {
            throw new ParseException("Absurdly long value");
        }
        throw new ParseException("Unexpected EOF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) throws ParseException, IOException {
        long j11;
        int i11;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0L;
        }
        char[] cArr = this.zaq;
        if (zam2 <= 0) {
            throw new ParseException("No number to parse");
        }
        char c11 = cArr[0];
        long j12 = c11 == '-' ? Long.MIN_VALUE : C.TIME_UNSET;
        int i12 = c11 == '-' ? 1 : 0;
        if (i12 < zam2) {
            i11 = i12 + 1;
            int digit = Character.digit(cArr[i12], 10);
            if (digit < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            j11 = -digit;
        } else {
            j11 = 0;
            i11 = i12;
        }
        while (i11 < zam2) {
            int i13 = i11 + 1;
            int digit2 = Character.digit(cArr[i11], 10);
            if (digit2 < 0) {
                throw new ParseException("Unexpected non-digit character");
            }
            if (j11 < Buffer.OVERFLOW_ZONE) {
                throw new ParseException("Number too large");
            }
            long j13 = j11 * 10;
            int i14 = zam2;
            long j14 = digit2;
            if (j13 < j12 + j14) {
                throw new ParseException("Number too large");
            }
            j11 = j13 - j14;
            zam2 = i14;
            i11 = i13;
        }
        if (i12 == 0) {
            return -j11;
        }
        if (i11 > 1) {
            return j11;
        }
        throw new ParseException("No digits to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final String zao(BufferedReader bufferedReader) throws ParseException, IOException {
        return zap(bufferedReader, this.zap, this.zar, null);
    }

    @Nullable
    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb2, @Nullable char[] cArr2) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            return zaA(bufferedReader, cArr, sb2, cArr2);
        }
        if (zai2 != 'n') {
            throw new ParseException("Expected string");
        }
        zax(bufferedReader, zaa);
        return null;
    }

    @Nullable
    @ResultIgnorabilityUnspecified
    private final String zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        }
        if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        }
        if (zai2 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token: " + zai2);
    }

    @Nullable
    private final String zar(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char zai2 = zai(bufferedReader);
        int i11 = 1;
        if (zai2 == '\"') {
            if (bufferedReader.read(this.zao) == -1) {
                throw new ParseException("Unexpected EOF while parsing string");
            }
            char c11 = this.zao[0];
            boolean z10 = false;
            do {
                if (c11 == '\"') {
                    if (z10) {
                        c11 = '\"';
                        z10 = true;
                    }
                }
                z10 = c11 == '\\' ? !z10 : false;
                if (bufferedReader.read(this.zao) == -1) {
                    throw new ParseException("Unexpected EOF while parsing string");
                }
                c11 = this.zao[0];
            } while (!Character.isISOControl(c11));
            throw new ParseException("Unexpected control character while reading string");
        }
        if (zai2 == ',') {
            throw new ParseException("Missing value");
        }
        if (zai2 == '[') {
            this.zat.push(5);
            bufferedReader.mark(32);
            if (zai(bufferedReader) == ']') {
                zaw(5);
            } else {
                bufferedReader.reset();
                boolean z11 = false;
                boolean z12 = false;
                while (i11 > 0) {
                    char zai3 = zai(bufferedReader);
                    if (zai3 == 0) {
                        throw new ParseException("Unexpected EOF while parsing array");
                    }
                    if (Character.isISOControl(zai3)) {
                        throw new ParseException("Unexpected control character while reading array");
                    }
                    if (zai3 == '\"') {
                        if (!z12) {
                            z11 = !z11;
                        }
                        zai3 = '\"';
                    }
                    if (zai3 == '[') {
                        if (!z11) {
                            i11++;
                        }
                        zai3 = '[';
                    }
                    if (zai3 == ']' && !z11) {
                        i11--;
                    }
                    z12 = (zai3 == '\\' && z11) ? !z12 : false;
                }
                zaw(5);
            }
        } else if (zai2 != '{') {
            bufferedReader.reset();
            zam(bufferedReader, this.zaq);
        } else {
            this.zat.push(1);
            bufferedReader.mark(32);
            char zai4 = zai(bufferedReader);
            if (zai4 == '}') {
                zaw(1);
            } else {
                if (zai4 != '\"') {
                    throw new ParseException("Unexpected token " + zai4);
                }
                bufferedReader.reset();
                zaq(bufferedReader);
                do {
                } while (zar(bufferedReader) != null);
                zaw(1);
            }
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        }
        if (zai5 == '}') {
            zaw(2);
            return null;
        }
        throw new ParseException("Unexpected token " + zai5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final BigDecimal zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final BigInteger zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    @Nullable
    private final ArrayList zau(BufferedReader bufferedReader, zai zaiVar) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        }
        if (zai2 != '[') {
            throw new ParseException("Expected start of array");
        }
        this.zat.push(5);
        ArrayList arrayList = new ArrayList();
        while (true) {
            bufferedReader.mark(1024);
            char zai3 = zai(bufferedReader);
            if (zai3 == 0) {
                throw new ParseException("Unexpected EOF");
            }
            if (zai3 != ',') {
                if (zai3 == ']') {
                    zaw(5);
                    return arrayList;
                }
                bufferedReader.reset();
                arrayList.add(zaiVar.zaa(this, bufferedReader));
            }
        }
    }

    @Nullable
    private final ArrayList zav(BufferedReader bufferedReader, FastJsonResponse.Field field) throws ParseException, IOException {
        ArrayList arrayList = new ArrayList();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        }
        if (zai2 != '{') {
            throw new ParseException("Unexpected token: " + zai2);
        }
        this.zat.push(1);
        while (true) {
            try {
                FastJsonResponse zad2 = field.zad();
                if (!zaz(bufferedReader, zad2)) {
                    return arrayList;
                }
                arrayList.add(zad2);
                char zai3 = zai(bufferedReader);
                if (zai3 != ',') {
                    if (zai3 == ']') {
                        zaw(5);
                        return arrayList;
                    }
                    throw new ParseException("Unexpected token: " + zai3);
                }
                if (zai(bufferedReader) != '{') {
                    throw new ParseException("Expected start of next object in array");
                }
                this.zat.push(1);
            } catch (IllegalAccessException e11) {
                throw new ParseException("Error instantiating inner object", e11);
            } catch (InstantiationException e12) {
                throw new ParseException("Error instantiating inner object", e12);
            }
        }
    }

    private final void zaw(int i11) throws ParseException {
        if (this.zat.isEmpty()) {
            throw new ParseException("Expected state " + i11 + " but had empty stack");
        }
        int intValue = ((Integer) this.zat.pop()).intValue();
        if (intValue == i11) {
            return;
        }
        throw new ParseException("Expected state " + i11 + " but had " + intValue);
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i11 = 0;
        while (true) {
            int length = cArr.length;
            if (i11 >= length) {
                return;
            }
            int read = bufferedReader.read(this.zap, 0, length - i11);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i12 = 0; i12 < read; i12++) {
                if (cArr[i12 + i11] != this.zap[i12]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i11 += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z10) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            if (z10) {
                throw new ParseException("No boolean value found in string");
            }
            return zay(bufferedReader, true);
        }
        if (zai2 == 'f') {
            zax(bufferedReader, z10 ? zae : zad);
            return false;
        }
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return false;
        }
        if (zai2 == 't') {
            zax(bufferedReader, z10 ? zac : zab);
            return true;
        }
        throw new ParseException("Unexpected token: " + zai2);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x003b. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x027b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x025f A[SYNTHETIC] */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean zaz(java.io.BufferedReader r17, com.google.android.gms.common.server.response.FastJsonResponse r18) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 678
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zaz(java.io.BufferedReader, com.google.android.gms.common.server.response.FastJsonResponse):boolean");
    }

    @KeepForSdk
    public void parse(@NonNull InputStream inputStream, @NonNull T t11) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.zat.push(0);
                char zai2 = zai(bufferedReader);
                if (zai2 == 0) {
                    throw new ParseException("No data to parse");
                }
                if (zai2 == '[') {
                    this.zat.push(5);
                    Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t11.getFieldMappings();
                    if (fieldMappings.size() != 1) {
                        throw new ParseException("Object array response class must have a single Field");
                    }
                    FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                    t11.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                } else {
                    if (zai2 != '{') {
                        throw new ParseException("Unexpected token: " + zai2);
                    }
                    this.zat.push(1);
                    zaz(bufferedReader, t11);
                }
                zaw(0);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                    Log.w("FastParser", "Failed to close reader while parsing.");
                }
            } catch (IOException e11) {
                throw new ParseException(e11);
            }
        } catch (Throwable th2) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th2;
        }
    }
}
