package org.jsoup.parser;

import java.io.Reader;
import java.util.ArrayList;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    a f72000a;

    /* renamed from: b, reason: collision with root package name */
    h f72001b;

    /* renamed from: c, reason: collision with root package name */
    protected Document f72002c;

    /* renamed from: d, reason: collision with root package name */
    protected ArrayList f72003d;

    /* renamed from: e, reason: collision with root package name */
    protected String f72004e;

    /* renamed from: f, reason: collision with root package name */
    protected Token f72005f;

    /* renamed from: g, reason: collision with root package name */
    protected ParseErrorList f72006g;

    /* renamed from: h, reason: collision with root package name */
    protected d f72007h;

    /* renamed from: i, reason: collision with root package name */
    private Token.h f72008i = new Token.h();

    /* renamed from: j, reason: collision with root package name */
    private Token.g f72009j = new Token.g();

    /* JADX INFO: Access modifiers changed from: protected */
    public Element a() {
        int size = this.f72003d.size();
        if (size > 0) {
            return (Element) this.f72003d.get(size - 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract d b();

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        org.jsoup.helper.d.k(reader, "String input must not be null");
        org.jsoup.helper.d.k(str, "BaseURI must not be null");
        this.f72002c = new Document(str);
        this.f72007h = dVar;
        this.f72000a = new a(reader);
        this.f72006g = parseErrorList;
        this.f72005f = null;
        this.f72001b = new h(this.f72000a, parseErrorList);
        this.f72003d = new ArrayList(32);
        this.f72004e = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Document d(Reader reader, String str, ParseErrorList parseErrorList, d dVar) {
        c(reader, str, parseErrorList, dVar);
        i();
        return this.f72002c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean e(Token token);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(String str) {
        Token token = this.f72005f;
        Token.g gVar = this.f72009j;
        return token == gVar ? e(new Token.g().B(str)) : e(gVar.m().B(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(String str) {
        Token token = this.f72005f;
        Token.h hVar = this.f72008i;
        return token == hVar ? e(new Token.h().B(str)) : e(hVar.m().B(str));
    }

    public boolean h(String str, org.jsoup.nodes.b bVar) {
        Token token = this.f72005f;
        Token.h hVar = this.f72008i;
        if (token == hVar) {
            return e(new Token.h().G(str, bVar));
        }
        hVar.m();
        this.f72008i.G(str, bVar);
        return e(this.f72008i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        Token t11;
        do {
            t11 = this.f72001b.t();
            e(t11);
            t11.m();
        } while (t11.f71910a != Token.TokenType.EOF);
    }
}
