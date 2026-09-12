package kotlinx.serialization.json.internal;

import java.util.ArrayList;
import kotlin.KotlinNothingValueException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f68409a;

    /* renamed from: c, reason: collision with root package name */
    private String f68411c;

    /* renamed from: b, reason: collision with root package name */
    public final x f68410b = new x();

    /* renamed from: d, reason: collision with root package name */
    private StringBuilder f68412d = new StringBuilder();

    private final int B(CharSequence charSequence, int i11) {
        char charAt = charSequence.charAt(i11);
        if ('0' <= charAt && charAt < ':') {
            return charAt - '0';
        }
        if ('a' <= charAt && charAt < 'g') {
            return charAt - 'W';
        }
        if ('A' <= charAt && charAt < 'G') {
            return charAt - '7';
        }
        y(this, "Invalid toHexChar char '" + charAt + "' in unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final String K() {
        String str = this.f68411c;
        Intrinsics.e(str);
        this.f68411c = null;
        return str;
    }

    private final boolean O() {
        return C().charAt(this.f68409a - 1) != '\"';
    }

    private final int b(int i11) {
        int G = G(i11);
        if (G == -1) {
            y(this, "Expected escape sequence to continue, got EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i12 = G + 1;
        char charAt = C().charAt(G);
        if (charAt == 'u') {
            return d(C(), i12);
        }
        char b11 = b.b(charAt);
        if (b11 != 0) {
            this.f68412d.append(b11);
            return i12;
        }
        y(this, "Invalid escaped char '" + charAt + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final int c(int i11, int i12) {
        e(i11, i12);
        return b(i12 + 1);
    }

    private final int d(CharSequence charSequence, int i11) {
        int i12 = i11 + 4;
        if (i12 < charSequence.length()) {
            this.f68412d.append((char) ((B(charSequence, i11) << 12) + (B(charSequence, i11 + 1) << 8) + (B(charSequence, i11 + 2) << 4) + B(charSequence, i11 + 3)));
            return i12;
        }
        this.f68409a = i11;
        v();
        if (this.f68409a + 4 < charSequence.length()) {
            return d(charSequence, this.f68409a);
        }
        y(this, "Unexpected EOF during unicode escape", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final boolean h(int i11) {
        int G = G(i11);
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int i12 = G + 1;
        int charAt = C().charAt(G) | ' ';
        if (charAt == 102) {
            j("alse", i12);
            return false;
        }
        if (charAt == 116) {
            j("rue", i12);
            return true;
        }
        y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    private final void j(String str, int i11) {
        if (C().length() - i11 < str.length()) {
            y(this, "Unexpected end of boolean literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        int length = str.length();
        for (int i12 = 0; i12 < length; i12++) {
            if (str.charAt(i12) != (C().charAt(i11 + i12) | ' ')) {
                y(this, "Expected valid boolean literal prefix, but had '" + s() + '\'', 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
        }
        this.f68409a = i11 + str.length();
    }

    private final String u(int i11, int i12) {
        e(i11, i12);
        String sb2 = this.f68412d.toString();
        Intrinsics.g(sb2, "escapedString.toString()");
        this.f68412d.setLength(0);
        return sb2;
    }

    public static /* synthetic */ Void y(a aVar, String str, int i11, String str2, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fail");
        }
        if ((i12 & 2) != 0) {
            i11 = aVar.f68409a;
        }
        if ((i12 & 4) != 0) {
            str2 = "";
        }
        return aVar.x(str, i11, str2);
    }

    public final void A(String key) {
        Intrinsics.h(key, "key");
        x("Encountered an unknown key '" + key + '\'', StringsKt.v0(J(0, this.f68409a), key, 0, false, 6, null), "Use 'ignoreUnknownKeys = true' in 'Json {}' builder to ignore unknown keys.");
        throw new KotlinNothingValueException();
    }

    protected abstract CharSequence C();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean D(char c11) {
        return !(c11 == '}' || c11 == ']' || c11 == ':' || c11 == ',');
    }

    public final byte E() {
        CharSequence C = C();
        int i11 = this.f68409a;
        while (true) {
            int G = G(i11);
            if (G == -1) {
                this.f68409a = G;
                return (byte) 10;
            }
            char charAt = C.charAt(G);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.f68409a = G;
                return b.a(charAt);
            }
            i11 = G + 1;
        }
    }

    public final String F(boolean z10) {
        String q11;
        byte E = E();
        if (z10) {
            if (E != 1 && E != 0) {
                return null;
            }
            q11 = s();
        } else {
            if (E != 1) {
                return null;
            }
            q11 = q();
        }
        this.f68411c = q11;
        return q11;
    }

    public abstract int G(int i11);

    public final void H(boolean z10) {
        ArrayList arrayList = new ArrayList();
        byte E = E();
        if (E != 8 && E != 6) {
            s();
            return;
        }
        while (true) {
            byte E2 = E();
            if (E2 != 1) {
                if (E2 == 8 || E2 == 6) {
                    arrayList.add(Byte.valueOf(E2));
                } else if (E2 == 9) {
                    if (((Number) CollectionsKt.u0(arrayList)).byteValue() != 8) {
                        throw w.f(this.f68409a, "found ] instead of } at path: " + this.f68410b, C());
                    }
                    CollectionsKt.L(arrayList);
                } else if (E2 == 7) {
                    if (((Number) CollectionsKt.u0(arrayList)).byteValue() != 6) {
                        throw w.f(this.f68409a, "found } instead of ] at path: " + this.f68410b, C());
                    }
                    CollectionsKt.L(arrayList);
                } else if (E2 == 10) {
                    y(this, "Unexpected end of input due to malformed JSON during ignoring unknown keys", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                m();
                if (arrayList.size() == 0) {
                    return;
                }
            } else if (z10) {
                s();
            } else {
                k();
            }
        }
    }

    public int I() {
        int G;
        char charAt;
        int i11 = this.f68409a;
        while (true) {
            G = G(i11);
            if (G == -1 || !((charAt = C().charAt(G)) == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t')) {
                break;
            }
            i11 = G + 1;
        }
        this.f68409a = G;
        return G;
    }

    public String J(int i11, int i12) {
        return C().subSequence(i11, i12).toString();
    }

    public abstract boolean L();

    public final boolean M() {
        int G = G(I());
        int length = C().length() - G;
        if (length < 4 || G == -1) {
            return true;
        }
        for (int i11 = 0; i11 < 4; i11++) {
            if ("null".charAt(i11) != C().charAt(G + i11)) {
                return true;
            }
        }
        if (length > 4 && b.a(C().charAt(G + 4)) == 0) {
            return true;
        }
        this.f68409a = G + 4;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void N(char c11) {
        int i11 = this.f68409a - 1;
        this.f68409a = i11;
        if (i11 >= 0 && c11 == '\"' && Intrinsics.c(s(), "null")) {
            x("Expected string literal but 'null' literal was found", this.f68409a - 4, "Use 'coerceInputValues = true' in 'Json {}` builder to coerce nulls to default values.");
            throw new KotlinNothingValueException();
        }
        z(b.a(c11));
        throw new KotlinNothingValueException();
    }

    protected void e(int i11, int i12) {
        this.f68412d.append(C(), i11, i12);
    }

    public abstract boolean f();

    public final boolean g() {
        return h(I());
    }

    public final boolean i() {
        boolean z10;
        int I = I();
        if (I == C().length()) {
            y(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(I) == '\"') {
            I++;
            z10 = true;
        } else {
            z10 = false;
        }
        boolean h11 = h(I);
        if (z10) {
            if (this.f68409a == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (C().charAt(this.f68409a) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            this.f68409a++;
        }
        return h11;
    }

    public abstract String k();

    public abstract String l(String str, boolean z10);

    public abstract byte m();

    public final byte n(byte b11) {
        byte m11 = m();
        if (m11 == b11) {
            return m11;
        }
        z(b11);
        throw new KotlinNothingValueException();
    }

    public void o(char c11) {
        v();
        CharSequence C = C();
        int i11 = this.f68409a;
        while (true) {
            int G = G(i11);
            if (G == -1) {
                this.f68409a = G;
                N(c11);
                return;
            }
            int i12 = G + 1;
            char charAt = C.charAt(G);
            if (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t') {
                this.f68409a = i12;
                if (charAt == c11) {
                    return;
                } else {
                    N(c11);
                }
            }
            i11 = i12;
        }
    }

    public final long p() {
        boolean z10;
        int G = G(I());
        if (G >= C().length() || G == -1) {
            y(this, "EOF", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (C().charAt(G) == '\"') {
            G++;
            if (G == C().length()) {
                y(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = G;
        long j11 = 0;
        boolean z11 = true;
        boolean z12 = false;
        while (z11) {
            char charAt = C().charAt(i11);
            if (charAt != '-') {
                if (b.a(charAt) != 0) {
                    break;
                }
                i11++;
                z11 = i11 != C().length();
                int i12 = charAt - '0';
                if (i12 < 0 || i12 >= 10) {
                    y(this, "Unexpected symbol '" + charAt + "' in numeric literal", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                j11 = (j11 * 10) - i12;
                if (j11 > 0) {
                    y(this, "Numeric value overflow", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                if (i11 != G) {
                    y(this, "Unexpected symbol '-' in numeric literal", 0, null, 6, null);
                    throw new KotlinNothingValueException();
                }
                i11++;
                z12 = true;
            }
        }
        if (G == i11 || (z12 && G == i11 - 1)) {
            y(this, "Expected numeric literal", 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        if (z10) {
            if (!z11) {
                y(this, "EOF", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            if (C().charAt(i11) != '\"') {
                y(this, "Expected closing quotation mark", 0, null, 6, null);
                throw new KotlinNothingValueException();
            }
            i11++;
        }
        this.f68409a = i11;
        if (z12) {
            return j11;
        }
        if (j11 != Long.MIN_VALUE) {
            return -j11;
        }
        y(this, "Numeric value overflow", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final String q() {
        return this.f68411c != null ? K() : k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String r(CharSequence source, int i11, int i12) {
        int G;
        Intrinsics.h(source, "source");
        char charAt = source.charAt(i12);
        boolean z10 = false;
        while (charAt != '\"') {
            if (charAt == '\\') {
                G = G(c(i11, i12));
                if (G == -1) {
                    y(this, "EOF", G, null, 4, null);
                    throw new KotlinNothingValueException();
                }
            } else {
                i12++;
                if (i12 >= source.length()) {
                    e(i11, i12);
                    G = G(i12);
                    if (G == -1) {
                        y(this, "EOF", G, null, 4, null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    continue;
                    charAt = source.charAt(i12);
                }
            }
            z10 = true;
            i11 = G;
            i12 = i11;
            charAt = source.charAt(i12);
        }
        String J = !z10 ? J(i11, i12) : u(i11, i12);
        this.f68409a = i12 + 1;
        return J;
    }

    public final String s() {
        if (this.f68411c != null) {
            return K();
        }
        int I = I();
        if (I >= C().length() || I == -1) {
            y(this, "EOF", I, null, 4, null);
            throw new KotlinNothingValueException();
        }
        byte a11 = b.a(C().charAt(I));
        if (a11 == 1) {
            return q();
        }
        if (a11 != 0) {
            y(this, "Expected beginning of the string, but got " + C().charAt(I), 0, null, 6, null);
            throw new KotlinNothingValueException();
        }
        boolean z10 = false;
        while (b.a(C().charAt(I)) == 0) {
            I++;
            if (I >= C().length()) {
                e(this.f68409a, I);
                int G = G(I);
                if (G == -1) {
                    this.f68409a = I;
                    return u(0, 0);
                }
                I = G;
                z10 = true;
            }
        }
        String J = !z10 ? J(this.f68409a, I) : u(this.f68409a, I);
        this.f68409a = I;
        return J;
    }

    public final String t() {
        String s11 = s();
        if (!Intrinsics.c(s11, "null") || !O()) {
            return s11;
        }
        y(this, "Unexpected 'null' value instead of string literal", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return "JsonReader(source='" + ((Object) C()) + "', currentPosition=" + this.f68409a + ')';
    }

    public void v() {
    }

    public final void w() {
        if (m() == 10) {
            return;
        }
        y(this, "Expected EOF after parsing, but had " + C().charAt(this.f68409a - 1) + " instead", 0, null, 6, null);
        throw new KotlinNothingValueException();
    }

    public final Void x(String message, int i11, String hint) {
        String str;
        Intrinsics.h(message, "message");
        Intrinsics.h(hint, "hint");
        if (hint.length() == 0) {
            str = "";
        } else {
            str = '\n' + hint;
        }
        throw w.f(i11, message + " at path: " + this.f68410b.a() + str, C());
    }

    public final Void z(byte b11) {
        y(this, "Expected " + (b11 == 1 ? "quotation mark '\"'" : b11 == 4 ? "comma ','" : b11 == 5 ? "colon ':'" : b11 == 6 ? "start of the object '{'" : b11 == 7 ? "end of the object '}'" : b11 == 8 ? "start of the array '['" : b11 == 9 ? "end of the array ']'" : "valid token") + ", but had '" + ((this.f68409a == C().length() || this.f68409a <= 0) ? "EOF" : String.valueOf(C().charAt(this.f68409a - 1))) + "' instead", this.f68409a - 1, null, 4, null);
        throw new KotlinNothingValueException();
    }
}
