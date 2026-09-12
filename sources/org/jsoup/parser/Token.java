package org.jsoup.parser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class Token {

    /* renamed from: a, reason: collision with root package name */
    TokenType f71910a;

    /* loaded from: classes7.dex */
    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    /* loaded from: classes7.dex */
    static final class b extends c {
        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            p(str);
        }

        @Override // org.jsoup.parser.Token.c
        public String toString() {
            return "<![CDATA[" + q() + "]]>";
        }
    }

    /* loaded from: classes7.dex */
    static class c extends Token {

        /* renamed from: b, reason: collision with root package name */
        private String f71911b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c() {
            super();
            this.f71910a = TokenType.Character;
        }

        @Override // org.jsoup.parser.Token
        Token m() {
            this.f71911b = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c p(String str) {
            this.f71911b = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String q() {
            return this.f71911b;
        }

        public String toString() {
            return q();
        }
    }

    /* loaded from: classes7.dex */
    static final class d extends Token {

        /* renamed from: b, reason: collision with root package name */
        final StringBuilder f71912b;

        /* renamed from: c, reason: collision with root package name */
        boolean f71913c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public d() {
            super();
            this.f71912b = new StringBuilder();
            this.f71913c = false;
            this.f71910a = TokenType.Comment;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token m() {
            Token.n(this.f71912b);
            this.f71913c = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String p() {
            return this.f71912b.toString();
        }

        public String toString() {
            return "<!--" + p() + "-->";
        }
    }

    /* loaded from: classes7.dex */
    static final class e extends Token {

        /* renamed from: b, reason: collision with root package name */
        final StringBuilder f71914b;

        /* renamed from: c, reason: collision with root package name */
        String f71915c;

        /* renamed from: d, reason: collision with root package name */
        final StringBuilder f71916d;

        /* renamed from: e, reason: collision with root package name */
        final StringBuilder f71917e;

        /* renamed from: f, reason: collision with root package name */
        boolean f71918f;

        /* JADX INFO: Access modifiers changed from: package-private */
        public e() {
            super();
            this.f71914b = new StringBuilder();
            this.f71915c = null;
            this.f71916d = new StringBuilder();
            this.f71917e = new StringBuilder();
            this.f71918f = false;
            this.f71910a = TokenType.Doctype;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        public Token m() {
            Token.n(this.f71914b);
            this.f71915c = null;
            Token.n(this.f71916d);
            Token.n(this.f71917e);
            this.f71918f = false;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String p() {
            return this.f71914b.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String q() {
            return this.f71915c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String r() {
            return this.f71916d.toString();
        }

        public String s() {
            return this.f71917e.toString();
        }

        public boolean t() {
            return this.f71918f;
        }
    }

    /* loaded from: classes7.dex */
    static final class f extends Token {
        /* JADX INFO: Access modifiers changed from: package-private */
        public f() {
            super();
            this.f71910a = TokenType.EOF;
        }

        @Override // org.jsoup.parser.Token
        Token m() {
            return this;
        }
    }

    /* loaded from: classes7.dex */
    static final class g extends i {
        /* JADX INFO: Access modifiers changed from: package-private */
        public g() {
            this.f71910a = TokenType.EndTag;
        }

        public String toString() {
            return "</" + A() + ">";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class h extends i {
        /* JADX INFO: Access modifiers changed from: package-private */
        public h() {
            this.f71927j = new org.jsoup.nodes.b();
            this.f71910a = TokenType.StartTag;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token.i, org.jsoup.parser.Token
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public i m() {
            super.m();
            this.f71927j = new org.jsoup.nodes.b();
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public h G(String str, org.jsoup.nodes.b bVar) {
            this.f71919b = str;
            this.f71927j = bVar;
            this.f71920c = e10.b.a(str);
            return this;
        }

        public String toString() {
            org.jsoup.nodes.b bVar = this.f71927j;
            if (bVar == null || bVar.size() <= 0) {
                return "<" + A() + ">";
            }
            return "<" + A() + " " + this.f71927j.toString() + ">";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static abstract class i extends Token {

        /* renamed from: b, reason: collision with root package name */
        protected String f71919b;

        /* renamed from: c, reason: collision with root package name */
        protected String f71920c;

        /* renamed from: d, reason: collision with root package name */
        private String f71921d;

        /* renamed from: e, reason: collision with root package name */
        private StringBuilder f71922e;

        /* renamed from: f, reason: collision with root package name */
        private String f71923f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f71924g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f71925h;

        /* renamed from: i, reason: collision with root package name */
        boolean f71926i;

        /* renamed from: j, reason: collision with root package name */
        org.jsoup.nodes.b f71927j;

        i() {
            super();
            this.f71922e = new StringBuilder();
            this.f71924g = false;
            this.f71925h = false;
            this.f71926i = false;
        }

        private void w() {
            this.f71925h = true;
            String str = this.f71923f;
            if (str != null) {
                this.f71922e.append(str);
                this.f71923f = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String A() {
            String str = this.f71919b;
            org.jsoup.helper.d.b(str == null || str.length() == 0);
            return this.f71919b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final i B(String str) {
            this.f71919b = str;
            this.f71920c = e10.b.a(str);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void C() {
            if (this.f71927j == null) {
                this.f71927j = new org.jsoup.nodes.b();
            }
            String str = this.f71921d;
            if (str != null) {
                String trim = str.trim();
                this.f71921d = trim;
                if (trim.length() > 0) {
                    this.f71927j.w(this.f71921d, this.f71925h ? this.f71922e.length() > 0 ? this.f71922e.toString() : this.f71923f : this.f71924g ? "" : null);
                }
            }
            this.f71921d = null;
            this.f71924g = false;
            this.f71925h = false;
            Token.n(this.f71922e);
            this.f71923f = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final String D() {
            return this.f71920c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // org.jsoup.parser.Token
        /* renamed from: E */
        public i m() {
            this.f71919b = null;
            this.f71920c = null;
            this.f71921d = null;
            Token.n(this.f71922e);
            this.f71923f = null;
            this.f71924g = false;
            this.f71925h = false;
            this.f71926i = false;
            this.f71927j = null;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void F() {
            this.f71924g = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void p(char c11) {
            q(String.valueOf(c11));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void q(String str) {
            String str2 = this.f71921d;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f71921d = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void r(char c11) {
            w();
            this.f71922e.append(c11);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void s(String str) {
            w();
            if (this.f71922e.length() == 0) {
                this.f71923f = str;
            } else {
                this.f71922e.append(str);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void t(int[] iArr) {
            w();
            for (int i11 : iArr) {
                this.f71922e.appendCodePoint(i11);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void u(char c11) {
            v(String.valueOf(c11));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void v(String str) {
            String str2 = this.f71919b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.f71919b = str;
            this.f71920c = e10.b.a(str);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void x() {
            if (this.f71921d != null) {
                C();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final org.jsoup.nodes.b y() {
            return this.f71927j;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final boolean z() {
            return this.f71926i;
        }
    }

    private Token() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(StringBuilder sb2) {
        if (sb2 != null) {
            sb2.delete(0, sb2.length());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a() {
        return (c) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d b() {
        return (d) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e c() {
        return (e) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g d() {
        return (g) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h e() {
        return (h) this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean f() {
        return this instanceof b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return this.f71910a == TokenType.Character;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h() {
        return this.f71910a == TokenType.Comment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        return this.f71910a == TokenType.Doctype;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j() {
        return this.f71910a == TokenType.EOF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        return this.f71910a == TokenType.EndTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean l() {
        return this.f71910a == TokenType.StartTag;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Token m();

    /* JADX INFO: Access modifiers changed from: package-private */
    public String o() {
        return getClass().getSimpleName();
    }
}
