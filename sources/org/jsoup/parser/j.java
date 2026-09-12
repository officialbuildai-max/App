package org.jsoup.parser;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.io.Reader;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.l;
import org.jsoup.nodes.m;
import org.jsoup.parser.Token;

/* loaded from: classes7.dex */
public class j extends i {

    /* loaded from: classes7.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f72010a;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            f72010a = iArr;
            try {
                iArr[Token.TokenType.StartTag.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f72010a[Token.TokenType.EndTag.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f72010a[Token.TokenType.Comment.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f72010a[Token.TokenType.Character.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f72010a[Token.TokenType.Doctype.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f72010a[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    private void n(org.jsoup.nodes.j jVar) {
        a().g0(jVar);
    }

    private void o(Token.g gVar) {
        Element element;
        String b11 = this.f72007h.b(gVar.f71919b);
        int size = this.f72003d.size() - 1;
        while (true) {
            if (size < 0) {
                element = null;
                break;
            }
            element = (Element) this.f72003d.get(size);
            if (element.B().equals(b11)) {
                break;
            } else {
                size--;
            }
        }
        if (element == null) {
            return;
        }
        for (int size2 = this.f72003d.size() - 1; size2 >= 0; size2--) {
            Element element2 = (Element) this.f72003d.get(size2);
            this.f72003d.remove(size2);
            if (element2 == element) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.jsoup.parser.i
    public d b() {
        return d.f71955d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.parser.i
    public void c(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        super.c(reader, str, parseErrorList, dVar);
        this.f72003d.add(this.f72002c);
        this.f72002c.g1().n(Document.OutputSettings.Syntax.xml);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.jsoup.parser.i
    public boolean e(Token token) {
        switch (a.f72010a[token.f71910a.ordinal()]) {
            case 1:
                j(token.e());
                return true;
            case 2:
                o(token.d());
                return true;
            case 3:
                l(token.b());
                return true;
            case 4:
                k(token.a());
                return true;
            case 5:
                m(token.c());
                return true;
            case 6:
                return true;
            default:
                org.jsoup.helper.d.a("Unexpected token type: " + token.f71910a);
                return true;
        }
    }

    Element j(Token.h hVar) {
        f l11 = f.l(hVar.A(), this.f72007h);
        Element element = new Element(l11, this.f72004e, this.f72007h.a(hVar.f71927j));
        n(element);
        if (!hVar.z()) {
            this.f72003d.add(element);
        } else if (!l11.f()) {
            l11.j();
        }
        return element;
    }

    void k(Token.c cVar) {
        String q11 = cVar.q();
        n(cVar.f() ? new org.jsoup.nodes.d(q11) : new l(q11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [org.jsoup.nodes.j, org.jsoup.nodes.m] */
    /* JADX WARN: Type inference failed for: r5v0, types: [org.jsoup.parser.j, org.jsoup.parser.i] */
    void l(Token.d dVar) {
        org.jsoup.nodes.e eVar = new org.jsoup.nodes.e(dVar.p());
        if (dVar.f71913c) {
            String c02 = eVar.c0();
            if (c02.length() > 1 && (c02.startsWith("!") || c02.startsWith(UrlUtils.QUESTION_MARK))) {
                Document c11 = d10.a.c("<" + c02.substring(1, c02.length() - 1) + ">", this.f72004e, e.g());
                if (c11.n() > 0) {
                    Element m02 = c11.m0(0);
                    ?? mVar = new m(this.f72007h.b(m02.U0()), c02.startsWith("!"));
                    mVar.i().e(m02.i());
                    eVar = mVar;
                }
            }
        }
        n(eVar);
    }

    void m(Token.e eVar) {
        org.jsoup.nodes.g gVar = new org.jsoup.nodes.g(this.f72007h.b(eVar.p()), eVar.r(), eVar.s());
        gVar.d0(eVar.q());
        n(gVar);
    }
}
