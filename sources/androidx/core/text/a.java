package androidx.core.text;

import android.text.SpannableStringBuilder;
import java.util.Locale;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    static final t f8316d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f8317e;

    /* renamed from: f, reason: collision with root package name */
    private static final String f8318f;

    /* renamed from: g, reason: collision with root package name */
    static final a f8319g;

    /* renamed from: h, reason: collision with root package name */
    static final a f8320h;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f8321a;

    /* renamed from: b, reason: collision with root package name */
    private final int f8322b;

    /* renamed from: c, reason: collision with root package name */
    private final t f8323c;

    /* renamed from: androidx.core.text.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0074a {

        /* renamed from: a, reason: collision with root package name */
        private boolean f8324a;

        /* renamed from: b, reason: collision with root package name */
        private int f8325b;

        /* renamed from: c, reason: collision with root package name */
        private t f8326c;

        public C0074a() {
            c(a.g(Locale.getDefault()));
        }

        private static a b(boolean z10) {
            return z10 ? a.f8320h : a.f8319g;
        }

        private void c(boolean z10) {
            this.f8324a = z10;
            this.f8326c = a.f8316d;
            this.f8325b = 2;
        }

        public a a() {
            return (this.f8325b == 2 && this.f8326c == a.f8316d) ? b(this.f8324a) : new a(this.f8324a, this.f8325b, this.f8326c);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: f, reason: collision with root package name */
        private static final byte[] f8327f = new byte[1792];

        /* renamed from: a, reason: collision with root package name */
        private final CharSequence f8328a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f8329b;

        /* renamed from: c, reason: collision with root package name */
        private final int f8330c;

        /* renamed from: d, reason: collision with root package name */
        private int f8331d;

        /* renamed from: e, reason: collision with root package name */
        private char f8332e;

        static {
            for (int i11 = 0; i11 < 1792; i11++) {
                f8327f[i11] = Character.getDirectionality(i11);
            }
        }

        b(CharSequence charSequence, boolean z10) {
            this.f8328a = charSequence;
            this.f8329b = z10;
            this.f8330c = charSequence.length();
        }

        private static byte c(char c11) {
            return c11 < 1792 ? f8327f[c11] : Character.getDirectionality(c11);
        }

        private byte f() {
            char charAt;
            int i11 = this.f8331d;
            do {
                int i12 = this.f8331d;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f8328a;
                int i13 = i12 - 1;
                this.f8331d = i13;
                charAt = charSequence.charAt(i13);
                this.f8332e = charAt;
                if (charAt == '&') {
                    return (byte) 12;
                }
            } while (charAt != ';');
            this.f8331d = i11;
            this.f8332e = ';';
            return (byte) 13;
        }

        private byte g() {
            char charAt;
            do {
                int i11 = this.f8331d;
                if (i11 >= this.f8330c) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f8328a;
                this.f8331d = i11 + 1;
                charAt = charSequence.charAt(i11);
                this.f8332e = charAt;
            } while (charAt != ';');
            return (byte) 12;
        }

        private byte h() {
            char charAt;
            int i11 = this.f8331d;
            while (true) {
                int i12 = this.f8331d;
                if (i12 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f8328a;
                int i13 = i12 - 1;
                this.f8331d = i13;
                char charAt2 = charSequence.charAt(i13);
                this.f8332e = charAt2;
                if (charAt2 == '<') {
                    return (byte) 12;
                }
                if (charAt2 == '>') {
                    break;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i14 = this.f8331d;
                        if (i14 > 0) {
                            CharSequence charSequence2 = this.f8328a;
                            int i15 = i14 - 1;
                            this.f8331d = i15;
                            charAt = charSequence2.charAt(i15);
                            this.f8332e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
            this.f8331d = i11;
            this.f8332e = '>';
            return (byte) 13;
        }

        private byte i() {
            char charAt;
            int i11 = this.f8331d;
            while (true) {
                int i12 = this.f8331d;
                if (i12 >= this.f8330c) {
                    this.f8331d = i11;
                    this.f8332e = '<';
                    return (byte) 13;
                }
                CharSequence charSequence = this.f8328a;
                this.f8331d = i12 + 1;
                char charAt2 = charSequence.charAt(i12);
                this.f8332e = charAt2;
                if (charAt2 == '>') {
                    return (byte) 12;
                }
                if (charAt2 == '\"' || charAt2 == '\'') {
                    do {
                        int i13 = this.f8331d;
                        if (i13 < this.f8330c) {
                            CharSequence charSequence2 = this.f8328a;
                            this.f8331d = i13 + 1;
                            charAt = charSequence2.charAt(i13);
                            this.f8332e = charAt;
                        }
                    } while (charAt != charAt2);
                }
            }
        }

        byte a() {
            char charAt = this.f8328a.charAt(this.f8331d - 1);
            this.f8332e = charAt;
            if (Character.isLowSurrogate(charAt)) {
                int codePointBefore = Character.codePointBefore(this.f8328a, this.f8331d);
                this.f8331d -= Character.charCount(codePointBefore);
                return Character.getDirectionality(codePointBefore);
            }
            this.f8331d--;
            byte c11 = c(this.f8332e);
            if (!this.f8329b) {
                return c11;
            }
            char c12 = this.f8332e;
            return c12 == '>' ? h() : c12 == ';' ? f() : c11;
        }

        byte b() {
            char charAt = this.f8328a.charAt(this.f8331d);
            this.f8332e = charAt;
            if (Character.isHighSurrogate(charAt)) {
                int codePointAt = Character.codePointAt(this.f8328a, this.f8331d);
                this.f8331d += Character.charCount(codePointAt);
                return Character.getDirectionality(codePointAt);
            }
            this.f8331d++;
            byte c11 = c(this.f8332e);
            if (!this.f8329b) {
                return c11;
            }
            char c12 = this.f8332e;
            return c12 == '<' ? i() : c12 == '&' ? g() : c11;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:46:0x0045. Please report as an issue. */
        int d() {
            this.f8331d = 0;
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (this.f8331d < this.f8330c && i11 == 0) {
                byte b11 = b();
                if (b11 != 0) {
                    if (b11 == 1 || b11 == 2) {
                        if (i13 == 0) {
                            return 1;
                        }
                    } else if (b11 != 9) {
                        switch (b11) {
                            case 14:
                            case 15:
                                i13++;
                                i12 = -1;
                                continue;
                            case 16:
                            case 17:
                                i13++;
                                i12 = 1;
                                continue;
                            case 18:
                                i13--;
                                i12 = 0;
                                continue;
                        }
                    }
                } else if (i13 == 0) {
                    return -1;
                }
                i11 = i13;
            }
            if (i11 == 0) {
                return 0;
            }
            if (i12 != 0) {
                return i12;
            }
            while (this.f8331d > 0) {
                switch (a()) {
                    case 14:
                    case 15:
                        if (i11 == i13) {
                            return -1;
                        }
                        i13--;
                    case 16:
                    case 17:
                        if (i11 == i13) {
                            return 1;
                        }
                        i13--;
                    case 18:
                        i13++;
                }
            }
            return 0;
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:33:0x001c. Please report as an issue. */
        int e() {
            this.f8331d = this.f8330c;
            int i11 = 0;
            while (true) {
                int i12 = i11;
                while (this.f8331d > 0) {
                    byte a11 = a();
                    if (a11 != 0) {
                        if (a11 == 1 || a11 == 2) {
                            if (i11 == 0) {
                                return 1;
                            }
                            if (i12 == 0) {
                                break;
                            }
                        } else if (a11 != 9) {
                            switch (a11) {
                                case 14:
                                case 15:
                                    if (i12 == i11) {
                                        return -1;
                                    }
                                    i11--;
                                    break;
                                case 16:
                                case 17:
                                    if (i12 == i11) {
                                        return 1;
                                    }
                                    i11--;
                                    break;
                                case 18:
                                    i11++;
                                    break;
                                default:
                                    if (i12 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i11 == 0) {
                            return -1;
                        }
                        if (i12 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }
    }

    static {
        t tVar = u.f8335c;
        f8316d = tVar;
        f8317e = Character.toString((char) 8206);
        f8318f = Character.toString((char) 8207);
        f8319g = new a(false, 2, tVar);
        f8320h = new a(true, 2, tVar);
    }

    a(boolean z10, int i11, t tVar) {
        this.f8321a = z10;
        this.f8322b = i11;
        this.f8323c = tVar;
    }

    private static int a(CharSequence charSequence) {
        return new b(charSequence, false).d();
    }

    private static int b(CharSequence charSequence) {
        return new b(charSequence, false).e();
    }

    public static a c() {
        return new C0074a().a();
    }

    static boolean g(Locale locale) {
        return v.a(locale) == 1;
    }

    private String h(CharSequence charSequence, t tVar) {
        boolean a11 = tVar.a(charSequence, 0, charSequence.length());
        return (this.f8321a || !(a11 || b(charSequence) == 1)) ? this.f8321a ? (!a11 || b(charSequence) == -1) ? f8318f : "" : "" : f8317e;
    }

    private String i(CharSequence charSequence, t tVar) {
        boolean a11 = tVar.a(charSequence, 0, charSequence.length());
        return (this.f8321a || !(a11 || a(charSequence) == 1)) ? this.f8321a ? (!a11 || a(charSequence) == -1) ? f8318f : "" : "" : f8317e;
    }

    public boolean d() {
        return (this.f8322b & 2) != 0;
    }

    public boolean e(CharSequence charSequence) {
        return this.f8323c.a(charSequence, 0, charSequence.length());
    }

    public boolean f(String str) {
        return e(str);
    }

    public CharSequence j(CharSequence charSequence) {
        return k(charSequence, this.f8323c, true);
    }

    public CharSequence k(CharSequence charSequence, t tVar, boolean z10) {
        if (charSequence == null) {
            return null;
        }
        boolean a11 = tVar.a(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (d() && z10) {
            spannableStringBuilder.append((CharSequence) i(charSequence, a11 ? u.f8334b : u.f8333a));
        }
        if (a11 != this.f8321a) {
            spannableStringBuilder.append(a11 ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z10) {
            spannableStringBuilder.append((CharSequence) h(charSequence, a11 ? u.f8334b : u.f8333a));
        }
        return spannableStringBuilder;
    }

    public String l(String str) {
        return n(str, this.f8323c, true);
    }

    public String m(String str, t tVar) {
        return n(str, tVar, true);
    }

    public String n(String str, t tVar, boolean z10) {
        if (str == null) {
            return null;
        }
        return k(str, tVar, z10).toString();
    }
}
