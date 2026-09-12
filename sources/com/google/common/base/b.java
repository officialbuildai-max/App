package com.google.common.base;

/* loaded from: classes4.dex */
public abstract class b implements n {

    /* loaded from: classes4.dex */
    private static final class a extends e {

        /* renamed from: b, reason: collision with root package name */
        static final b f30272b = new a();

        a() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return c11 <= 127;
        }
    }

    /* renamed from: com.google.common.base.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    static abstract class AbstractC0403b extends b {
        AbstractC0403b() {
        }

        @Override // com.google.common.base.n
        public /* bridge */ /* synthetic */ boolean apply(Object obj) {
            return super.b((Character) obj);
        }
    }

    /* loaded from: classes4.dex */
    private static final class c extends AbstractC0403b {

        /* renamed from: a, reason: collision with root package name */
        private final char f30273a;

        /* renamed from: b, reason: collision with root package name */
        private final char f30274b;

        c(char c11, char c12) {
            m.d(c12 >= c11);
            this.f30273a = c11;
            this.f30274b = c12;
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return this.f30273a <= c11 && c11 <= this.f30274b;
        }

        public String toString() {
            return "CharMatcher.inRange('" + b.j(this.f30273a) + "', '" + b.j(this.f30274b) + "')";
        }
    }

    /* loaded from: classes4.dex */
    private static final class d extends AbstractC0403b {

        /* renamed from: a, reason: collision with root package name */
        private final char f30275a;

        d(char c11) {
            this.f30275a = c11;
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return c11 == this.f30275a;
        }

        public String toString() {
            return "CharMatcher.is('" + b.j(this.f30275a) + "')";
        }
    }

    /* loaded from: classes4.dex */
    static abstract class e extends AbstractC0403b {

        /* renamed from: a, reason: collision with root package name */
        private final String f30276a;

        e(String str) {
            this.f30276a = (String) m.o(str);
        }

        public final String toString() {
            return this.f30276a;
        }
    }

    /* loaded from: classes4.dex */
    private static final class f extends e {

        /* renamed from: b, reason: collision with root package name */
        static final b f30277b = new f();

        private f() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.b
        public int e(CharSequence charSequence, int i11) {
            m.r(i11, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return false;
        }

        @Override // com.google.common.base.b
        public boolean h(CharSequence charSequence) {
            return charSequence.length() == 0;
        }
    }

    /* loaded from: classes4.dex */
    static final class g extends e {

        /* renamed from: b, reason: collision with root package name */
        static final int f30278b = Integer.numberOfLeadingZeros(31);

        /* renamed from: c, reason: collision with root package name */
        static final b f30279c = new g();

        g() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.b
        public boolean g(char c11) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c11) >>> f30278b) == c11;
        }
    }

    protected b() {
    }

    public static b c() {
        return a.f30272b;
    }

    public static b d(char c11, char c12) {
        return new c(c11, c12);
    }

    public static b f(char c11) {
        return new d(c11);
    }

    public static b i() {
        return f.f30277b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String j(char c11) {
        char[] cArr = new char[6];
        cArr[0] = '\\';
        cArr[1] = 'u';
        cArr[2] = 0;
        cArr[3] = 0;
        cArr[4] = 0;
        cArr[5] = 0;
        for (int i11 = 0; i11 < 4; i11++) {
            cArr[5 - i11] = "0123456789ABCDEF".charAt(c11 & 15);
            c11 = (char) (c11 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static b k() {
        return g.f30279c;
    }

    public boolean b(Character ch2) {
        return g(ch2.charValue());
    }

    public int e(CharSequence charSequence, int i11) {
        int length = charSequence.length();
        m.r(i11, length);
        while (i11 < length) {
            if (g(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }

    public abstract boolean g(char c11);

    public boolean h(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!g(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }
}
