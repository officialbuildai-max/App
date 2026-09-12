package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class n0 extends a {

    /* renamed from: e, reason: collision with root package name */
    private final String f68460e;

    public n0(String source) {
        Intrinsics.h(source, "source");
        this.f68460e = source;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int G(int i11) {
        if (i11 < C().length()) {
            return i11;
        }
        return -1;
    }

    @Override // kotlinx.serialization.json.internal.a
    public int I() {
        char charAt;
        int i11 = this.f68409a;
        if (i11 == -1) {
            return i11;
        }
        while (i11 < C().length() && ((charAt = C().charAt(i11)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
            i11++;
        }
        this.f68409a = i11;
        return i11;
    }

    @Override // kotlinx.serialization.json.internal.a
    public boolean L() {
        int I = I();
        if (I == C().length() || I == -1 || C().charAt(I) != ',') {
            return false;
        }
        this.f68409a++;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.serialization.json.internal.a
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public String C() {
        return this.f68460e;
    }

    @Override // kotlinx.serialization.json.internal.a
    public boolean f() {
        int i11 = this.f68409a;
        if (i11 == -1) {
            return false;
        }
        while (i11 < C().length()) {
            char charAt = C().charAt(i11);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.f68409a = i11;
                return D(charAt);
            }
            i11++;
        }
        this.f68409a = i11;
        return false;
    }

    @Override // kotlinx.serialization.json.internal.a
    public String k() {
        o('\"');
        int i11 = this.f68409a;
        int n02 = StringsKt.n0(C(), '\"', i11, false, 4, null);
        if (n02 == -1) {
            z((byte) 1);
            throw new KotlinNothingValueException();
        }
        for (int i12 = i11; i12 < n02; i12++) {
            if (C().charAt(i12) == '\\') {
                return r(C(), this.f68409a, i12);
            }
        }
        this.f68409a = n02 + 1;
        String substring = C().substring(i11, n02);
        Intrinsics.g(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    @Override // kotlinx.serialization.json.internal.a
    public String l(String keyToMatch, boolean z10) {
        Intrinsics.h(keyToMatch, "keyToMatch");
        int i11 = this.f68409a;
        try {
            if (m() != 6) {
                this.f68409a = i11;
                return null;
            }
            if (!Intrinsics.c(z10 ? k() : t(), keyToMatch)) {
                this.f68409a = i11;
                return null;
            }
            if (m() != 5) {
                this.f68409a = i11;
                return null;
            }
            String q11 = z10 ? q() : t();
            this.f68409a = i11;
            return q11;
        } catch (Throwable th2) {
            this.f68409a = i11;
            throw th2;
        }
    }

    @Override // kotlinx.serialization.json.internal.a
    public byte m() {
        byte a11;
        String C = C();
        do {
            int i11 = this.f68409a;
            if (i11 == -1 || i11 >= C.length()) {
                return (byte) 10;
            }
            int i12 = this.f68409a;
            this.f68409a = i12 + 1;
            a11 = b.a(C.charAt(i12));
        } while (a11 == 3);
        return a11;
    }

    @Override // kotlinx.serialization.json.internal.a
    public void o(char c11) {
        if (this.f68409a == -1) {
            N(c11);
        }
        String C = C();
        while (this.f68409a < C.length()) {
            int i11 = this.f68409a;
            this.f68409a = i11 + 1;
            char charAt = C.charAt(i11);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                if (charAt == c11) {
                    return;
                } else {
                    N(c11);
                }
            }
        }
        N(c11);
    }
}
