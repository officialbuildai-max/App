package org.jsoup.parser;

import com.cloud.tmc.integration.event.EventConstants;
import com.cloud.tmc.integration.params.TmcStartParams;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.cloud.tmc.offline.download.constants.OfflineConstantsKt;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Token;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public enum HtmlTreeBuilderState {
    Initial { // from class: org.jsoup.parser.HtmlTreeBuilderState.1
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
            } else {
                if (!token.i()) {
                    bVar.C0(HtmlTreeBuilderState.BeforeHtml);
                    return bVar.e(token);
                }
                Token.e c11 = token.c();
                org.jsoup.nodes.g gVar = new org.jsoup.nodes.g(bVar.f72007h.b(c11.p()), c11.r(), c11.s());
                gVar.d0(c11.q());
                bVar.w().g0(gVar);
                if (c11.t()) {
                    bVar.w().i1(Document.QuirksMode.quirks);
                }
                bVar.C0(HtmlTreeBuilderState.BeforeHtml);
            }
            return true;
        }
    },
    BeforeHtml { // from class: org.jsoup.parser.HtmlTreeBuilderState.2
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.V("html");
            bVar.C0(HtmlTreeBuilderState.BeforeHead);
            return bVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (token.h()) {
                bVar.O(token.b());
            } else {
                if (HtmlTreeBuilderState.isWhitespace(token)) {
                    return true;
                }
                if (!token.l() || !token.e().D().equals("html")) {
                    if ((!token.k() || !org.jsoup.helper.c.b(token.d().D(), TtmlNode.TAG_HEAD, TtmlNode.TAG_BODY, "html", TtmlNode.TAG_BR)) && token.k()) {
                        bVar.p(this);
                        return false;
                    }
                    return anythingElse(token, bVar);
                }
                bVar.L(token.e());
                bVar.C0(HtmlTreeBuilderState.BeforeHead);
            }
            return true;
        }
    },
    BeforeHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.3
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
            } else {
                if (token.i()) {
                    bVar.p(this);
                    return false;
                }
                if (token.l() && token.e().D().equals("html")) {
                    return HtmlTreeBuilderState.InBody.process(token, bVar);
                }
                if (!token.l() || !token.e().D().equals(TtmlNode.TAG_HEAD)) {
                    if (token.k() && org.jsoup.helper.c.b(token.d().D(), TtmlNode.TAG_HEAD, TtmlNode.TAG_BODY, "html", TtmlNode.TAG_BR)) {
                        bVar.g(TtmlNode.TAG_HEAD);
                        return bVar.e(token);
                    }
                    if (token.k()) {
                        bVar.p(this);
                        return false;
                    }
                    bVar.g(TtmlNode.TAG_HEAD);
                    return bVar.e(token);
                }
                bVar.A0(bVar.L(token.e()));
                bVar.C0(HtmlTreeBuilderState.InHead);
            }
            return true;
        }
    },
    InHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.4
        private boolean anythingElse(Token token, i iVar) {
            iVar.f(TtmlNode.TAG_HEAD);
            return iVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            int i11 = a.f71892a[token.f71910a.ordinal()];
            if (i11 == 1) {
                bVar.O(token.b());
            } else {
                if (i11 == 2) {
                    bVar.p(this);
                    return false;
                }
                if (i11 == 3) {
                    Token.h e11 = token.e();
                    String D = e11.D();
                    if (D.equals("html")) {
                        return HtmlTreeBuilderState.InBody.process(token, bVar);
                    }
                    if (org.jsoup.helper.c.b(D, "base", "basefont", "bgsound", "command", "link")) {
                        Element P = bVar.P(e11);
                        if (D.equals("base") && P.w("href")) {
                            bVar.e0(P);
                        }
                    } else if (D.equals("meta")) {
                        bVar.P(e11);
                    } else if (D.equals(CampaignEx.JSON_KEY_TITLE)) {
                        HtmlTreeBuilderState.handleRcData(e11, bVar);
                    } else if (org.jsoup.helper.c.b(D, "noframes", TtmlNode.TAG_STYLE)) {
                        HtmlTreeBuilderState.handleRawtext(e11, bVar);
                    } else if (D.equals("noscript")) {
                        bVar.L(e11);
                        bVar.C0(HtmlTreeBuilderState.InHeadNoscript);
                    } else {
                        if (!D.equals("script")) {
                            if (!D.equals(TtmlNode.TAG_HEAD)) {
                                return anythingElse(token, bVar);
                            }
                            bVar.p(this);
                            return false;
                        }
                        bVar.f72001b.u(TokeniserState.ScriptData);
                        bVar.d0();
                        bVar.C0(HtmlTreeBuilderState.Text);
                        bVar.L(e11);
                    }
                } else {
                    if (i11 != 4) {
                        return anythingElse(token, bVar);
                    }
                    String D2 = token.d().D();
                    if (!D2.equals(TtmlNode.TAG_HEAD)) {
                        if (org.jsoup.helper.c.b(D2, TtmlNode.TAG_BODY, "html", TtmlNode.TAG_BR)) {
                            return anythingElse(token, bVar);
                        }
                        bVar.p(this);
                        return false;
                    }
                    bVar.j0();
                    bVar.C0(HtmlTreeBuilderState.AfterHead);
                }
            }
            return true;
        }
    },
    InHeadNoscript { // from class: org.jsoup.parser.HtmlTreeBuilderState.5
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.p(this);
            bVar.N(new Token.c().p(token.toString()));
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.i()) {
                bVar.p(this);
                return true;
            }
            if (token.l() && token.e().D().equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.k() && token.d().D().equals("noscript")) {
                bVar.j0();
                bVar.C0(HtmlTreeBuilderState.InHead);
                return true;
            }
            if (HtmlTreeBuilderState.isWhitespace(token) || token.h() || (token.l() && org.jsoup.helper.c.b(token.e().D(), "basefont", "bgsound", "link", "meta", "noframes", TtmlNode.TAG_STYLE))) {
                return bVar.n0(token, HtmlTreeBuilderState.InHead);
            }
            if (token.k() && token.d().D().equals(TtmlNode.TAG_BR)) {
                return anythingElse(token, bVar);
            }
            if ((!token.l() || !org.jsoup.helper.c.b(token.e().D(), TtmlNode.TAG_HEAD, "noscript")) && !token.k()) {
                return anythingElse(token, bVar);
            }
            bVar.p(this);
            return false;
        }
    },
    AfterHead { // from class: org.jsoup.parser.HtmlTreeBuilderState.6
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.g(TtmlNode.TAG_BODY);
            bVar.q(true);
            return bVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return true;
            }
            if (!token.l()) {
                if (!token.k()) {
                    anythingElse(token, bVar);
                    return true;
                }
                if (org.jsoup.helper.c.b(token.d().D(), TtmlNode.TAG_BODY, "html")) {
                    anythingElse(token, bVar);
                    return true;
                }
                bVar.p(this);
                return false;
            }
            Token.h e11 = token.e();
            String D = e11.D();
            if (D.equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (D.equals(TtmlNode.TAG_BODY)) {
                bVar.L(e11);
                bVar.q(false);
                bVar.C0(HtmlTreeBuilderState.InBody);
                return true;
            }
            if (D.equals("frameset")) {
                bVar.L(e11);
                bVar.C0(HtmlTreeBuilderState.InFrameset);
                return true;
            }
            if (!org.jsoup.helper.c.b(D, "base", "basefont", "bgsound", "link", "meta", "noframes", "script", TtmlNode.TAG_STYLE, CampaignEx.JSON_KEY_TITLE)) {
                if (D.equals(TtmlNode.TAG_HEAD)) {
                    bVar.p(this);
                    return false;
                }
                anythingElse(token, bVar);
                return true;
            }
            bVar.p(this);
            Element z10 = bVar.z();
            bVar.o0(z10);
            bVar.n0(token, HtmlTreeBuilderState.InHead);
            bVar.s0(z10);
            return true;
        }
    },
    InBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.7
        boolean anyOtherEndTag(Token token, org.jsoup.parser.b bVar) {
            String b11 = bVar.f72007h.b(token.d().A());
            ArrayList B = bVar.B();
            int size = B.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = (Element) B.get(size);
                if (element.B().equals(b11)) {
                    bVar.t(b11);
                    if (!b11.equals(bVar.a().B())) {
                        bVar.p(this);
                    }
                    bVar.l0(b11);
                } else {
                    if (bVar.b0(element)) {
                        bVar.p(this);
                        return false;
                    }
                    size--;
                }
            }
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            Element element;
            int i11 = a.f71892a[token.f71910a.ordinal()];
            boolean z10 = true;
            if (i11 == 1) {
                bVar.O(token.b());
            } else {
                if (i11 == 2) {
                    bVar.p(this);
                    return false;
                }
                if (i11 != 3) {
                    if (i11 == 4) {
                        Token.g d11 = token.d();
                        String D = d11.D();
                        if (org.jsoup.helper.c.c(D, b.f71908p)) {
                            int i12 = 0;
                            while (i12 < 8) {
                                Element u11 = bVar.u(D);
                                if (u11 == null) {
                                    return anyOtherEndTag(token, bVar);
                                }
                                if (!bVar.g0(u11)) {
                                    bVar.p(this);
                                    bVar.r0(u11);
                                    return z10;
                                }
                                if (!bVar.E(u11.B())) {
                                    bVar.p(this);
                                    return false;
                                }
                                if (bVar.a() != u11) {
                                    bVar.p(this);
                                }
                                ArrayList B = bVar.B();
                                int size = B.size();
                                boolean z11 = false;
                                Element element2 = null;
                                for (int i13 = 0; i13 < size && i13 < 64; i13++) {
                                    element = (Element) B.get(i13);
                                    if (element == u11) {
                                        element2 = (Element) B.get(i13 - 1);
                                        z11 = z10;
                                    } else if (z11 && bVar.b0(element)) {
                                        break;
                                    }
                                }
                                element = null;
                                if (element == null) {
                                    bVar.l0(u11.B());
                                    bVar.r0(u11);
                                    return z10;
                                }
                                Element element3 = element;
                                Element element4 = element3;
                                for (int i14 = 0; i14 < 3; i14++) {
                                    if (bVar.g0(element3)) {
                                        element3 = bVar.j(element3);
                                    }
                                    if (!bVar.Z(element3)) {
                                        bVar.s0(element3);
                                    } else {
                                        if (element3 == u11) {
                                            break;
                                        }
                                        Element element5 = new Element(f.l(element3.B(), d.f71955d), bVar.v());
                                        bVar.u0(element3, element5);
                                        bVar.w0(element3, element5);
                                        if (element4.I() != null) {
                                            element4.L();
                                        }
                                        element5.g0(element4);
                                        element3 = element5;
                                        element4 = element3;
                                    }
                                }
                                if (org.jsoup.helper.c.c(element2.B(), b.f71909q)) {
                                    if (element4.I() != null) {
                                        element4.L();
                                    }
                                    bVar.R(element4);
                                } else {
                                    if (element4.I() != null) {
                                        element4.L();
                                    }
                                    element2.g0(element4);
                                }
                                Element element6 = new Element(u11.T0(), bVar.v());
                                element6.i().e(u11.i());
                                for (org.jsoup.nodes.j jVar : (org.jsoup.nodes.j[]) element.o().toArray(new org.jsoup.nodes.j[element.n()])) {
                                    element6.g0(jVar);
                                }
                                element.g0(element6);
                                bVar.r0(u11);
                                bVar.s0(u11);
                                bVar.U(element, element6);
                                i12++;
                                z10 = true;
                            }
                        } else if (org.jsoup.helper.c.c(D, b.f71907o)) {
                            if (!bVar.E(D)) {
                                bVar.p(this);
                                return false;
                            }
                            bVar.s();
                            if (!bVar.a().B().equals(D)) {
                                bVar.p(this);
                            }
                            bVar.l0(D);
                        } else {
                            if (D.equals(TtmlNode.TAG_SPAN)) {
                                return anyOtherEndTag(token, bVar);
                            }
                            if (D.equals("li")) {
                                if (!bVar.D(D)) {
                                    bVar.p(this);
                                    return false;
                                }
                                bVar.t(D);
                                if (!bVar.a().B().equals(D)) {
                                    bVar.p(this);
                                }
                                bVar.l0(D);
                            } else if (D.equals(TtmlNode.TAG_BODY)) {
                                if (!bVar.E(TtmlNode.TAG_BODY)) {
                                    bVar.p(this);
                                    return false;
                                }
                                bVar.C0(HtmlTreeBuilderState.AfterBody);
                            } else if (D.equals("html")) {
                                if (bVar.f(TtmlNode.TAG_BODY)) {
                                    return bVar.e(d11);
                                }
                            } else if (D.equals("form")) {
                                org.jsoup.nodes.h x10 = bVar.x();
                                bVar.y0(null);
                                if (x10 == null || !bVar.E(D)) {
                                    bVar.p(this);
                                    return false;
                                }
                                bVar.s();
                                if (!bVar.a().B().equals(D)) {
                                    bVar.p(this);
                                }
                                bVar.s0(x10);
                            } else if (D.equals(TtmlNode.TAG_P)) {
                                if (!bVar.C(D)) {
                                    bVar.p(this);
                                    bVar.g(D);
                                    return bVar.e(d11);
                                }
                                bVar.t(D);
                                if (!bVar.a().B().equals(D)) {
                                    bVar.p(this);
                                }
                                bVar.l0(D);
                            } else if (!org.jsoup.helper.c.c(D, b.f71898f)) {
                                String[] strArr = b.f71895c;
                                if (org.jsoup.helper.c.c(D, strArr)) {
                                    if (!bVar.G(strArr)) {
                                        bVar.p(this);
                                        return false;
                                    }
                                    bVar.t(D);
                                    if (!bVar.a().B().equals(D)) {
                                        bVar.p(this);
                                    }
                                    bVar.m0(strArr);
                                } else {
                                    if (D.equals("sarcasm")) {
                                        return anyOtherEndTag(token, bVar);
                                    }
                                    if (!org.jsoup.helper.c.c(D, b.f71900h)) {
                                        if (!D.equals(TtmlNode.TAG_BR)) {
                                            return anyOtherEndTag(token, bVar);
                                        }
                                        bVar.p(this);
                                        bVar.g(TtmlNode.TAG_BR);
                                        return false;
                                    }
                                    if (!bVar.E("name")) {
                                        if (!bVar.E(D)) {
                                            bVar.p(this);
                                            return false;
                                        }
                                        bVar.s();
                                        if (!bVar.a().B().equals(D)) {
                                            bVar.p(this);
                                        }
                                        bVar.l0(D);
                                        bVar.k();
                                    }
                                }
                            } else {
                                if (!bVar.E(D)) {
                                    bVar.p(this);
                                    return false;
                                }
                                bVar.t(D);
                                if (!bVar.a().B().equals(D)) {
                                    bVar.p(this);
                                }
                                bVar.l0(D);
                            }
                        }
                    } else if (i11 == 5) {
                        Token.c a11 = token.a();
                        if (a11.q().equals(HtmlTreeBuilderState.nullString)) {
                            bVar.p(this);
                            return false;
                        }
                        if (bVar.r() && HtmlTreeBuilderState.isWhitespace(a11)) {
                            bVar.q0();
                            bVar.N(a11);
                        } else {
                            bVar.q0();
                            bVar.N(a11);
                            bVar.q(false);
                        }
                    }
                    return z10;
                }
                Token.h e11 = token.e();
                String D2 = e11.D();
                if (D2.equals("a")) {
                    if (bVar.u("a") != null) {
                        bVar.p(this);
                        bVar.f("a");
                        Element y10 = bVar.y("a");
                        if (y10 != null) {
                            bVar.r0(y10);
                            bVar.s0(y10);
                        }
                    }
                    bVar.q0();
                    bVar.p0(bVar.L(e11));
                } else if (org.jsoup.helper.c.c(D2, b.f71901i)) {
                    bVar.q0();
                    bVar.P(e11);
                    bVar.q(false);
                } else if (org.jsoup.helper.c.c(D2, b.f71894b)) {
                    if (bVar.C(TtmlNode.TAG_P)) {
                        bVar.f(TtmlNode.TAG_P);
                    }
                    bVar.L(e11);
                } else if (D2.equals(TtmlNode.TAG_SPAN)) {
                    bVar.q0();
                    bVar.L(e11);
                } else if (D2.equals("li")) {
                    bVar.q(false);
                    ArrayList B2 = bVar.B();
                    int size2 = B2.size() - 1;
                    while (true) {
                        if (size2 <= 0) {
                            break;
                        }
                        Element element7 = (Element) B2.get(size2);
                        if (element7.B().equals("li")) {
                            bVar.f("li");
                            break;
                        }
                        if (bVar.b0(element7) && !org.jsoup.helper.c.c(element7.B(), b.f71897e)) {
                            break;
                        }
                        size2--;
                    }
                    if (bVar.C(TtmlNode.TAG_P)) {
                        bVar.f(TtmlNode.TAG_P);
                    }
                    bVar.L(e11);
                } else if (D2.equals("html")) {
                    bVar.p(this);
                    Element element8 = (Element) bVar.B().get(0);
                    Iterator it = e11.y().iterator();
                    while (it.hasNext()) {
                        org.jsoup.nodes.a aVar = (org.jsoup.nodes.a) it.next();
                        if (!element8.w(aVar.getKey())) {
                            element8.i().x(aVar);
                        }
                    }
                } else {
                    if (org.jsoup.helper.c.c(D2, b.f71893a)) {
                        return bVar.n0(token, HtmlTreeBuilderState.InHead);
                    }
                    if (D2.equals(TtmlNode.TAG_BODY)) {
                        bVar.p(this);
                        ArrayList B3 = bVar.B();
                        if (B3.size() == 1 || (B3.size() > 2 && !((Element) B3.get(1)).B().equals(TtmlNode.TAG_BODY))) {
                            return false;
                        }
                        bVar.q(false);
                        Element element9 = (Element) B3.get(1);
                        Iterator it2 = e11.y().iterator();
                        while (it2.hasNext()) {
                            org.jsoup.nodes.a aVar2 = (org.jsoup.nodes.a) it2.next();
                            if (!element9.w(aVar2.getKey())) {
                                element9.i().x(aVar2);
                            }
                        }
                    } else if (D2.equals("frameset")) {
                        bVar.p(this);
                        ArrayList B4 = bVar.B();
                        if (B4.size() == 1 || ((B4.size() > 2 && !((Element) B4.get(1)).B().equals(TtmlNode.TAG_BODY)) || !bVar.r())) {
                            return false;
                        }
                        Element element10 = (Element) B4.get(1);
                        if (element10.I() != null) {
                            element10.L();
                        }
                        for (int i15 = 1; B4.size() > i15; i15 = 1) {
                            B4.remove(B4.size() - i15);
                        }
                        bVar.L(e11);
                        bVar.C0(HtmlTreeBuilderState.InFrameset);
                    } else {
                        String[] strArr2 = b.f71895c;
                        if (org.jsoup.helper.c.c(D2, strArr2)) {
                            if (bVar.C(TtmlNode.TAG_P)) {
                                bVar.f(TtmlNode.TAG_P);
                            }
                            if (org.jsoup.helper.c.c(bVar.a().B(), strArr2)) {
                                bVar.p(this);
                                bVar.j0();
                            }
                            bVar.L(e11);
                        } else if (org.jsoup.helper.c.c(D2, b.f71896d)) {
                            if (bVar.C(TtmlNode.TAG_P)) {
                                bVar.f(TtmlNode.TAG_P);
                            }
                            bVar.L(e11);
                            bVar.f72000a.u("\n");
                            bVar.q(false);
                        } else {
                            if (D2.equals("form")) {
                                if (bVar.x() != null) {
                                    bVar.p(this);
                                    return false;
                                }
                                if (bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                bVar.Q(e11, true);
                                return true;
                            }
                            if (org.jsoup.helper.c.c(D2, b.f71898f)) {
                                bVar.q(false);
                                ArrayList B5 = bVar.B();
                                int size3 = B5.size() - 1;
                                while (true) {
                                    if (size3 <= 0) {
                                        break;
                                    }
                                    Element element11 = (Element) B5.get(size3);
                                    if (org.jsoup.helper.c.c(element11.B(), b.f71898f)) {
                                        bVar.f(element11.B());
                                        break;
                                    }
                                    if (bVar.b0(element11) && !org.jsoup.helper.c.c(element11.B(), b.f71897e)) {
                                        break;
                                    }
                                    size3--;
                                }
                                if (bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                bVar.L(e11);
                            } else if (D2.equals("plaintext")) {
                                if (bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                bVar.L(e11);
                                bVar.f72001b.u(TokeniserState.PLAINTEXT);
                            } else if (D2.equals("button")) {
                                if (bVar.C("button")) {
                                    bVar.p(this);
                                    bVar.f("button");
                                    bVar.e(e11);
                                } else {
                                    bVar.q0();
                                    bVar.L(e11);
                                    bVar.q(false);
                                }
                            } else if (org.jsoup.helper.c.c(D2, b.f71899g)) {
                                bVar.q0();
                                bVar.p0(bVar.L(e11));
                            } else if (D2.equals("nobr")) {
                                bVar.q0();
                                if (bVar.E("nobr")) {
                                    bVar.p(this);
                                    bVar.f("nobr");
                                    bVar.q0();
                                }
                                bVar.p0(bVar.L(e11));
                            } else if (org.jsoup.helper.c.c(D2, b.f71900h)) {
                                bVar.q0();
                                bVar.L(e11);
                                bVar.S();
                                bVar.q(false);
                            } else if (D2.equals("table")) {
                                if (bVar.w().h1() != Document.QuirksMode.quirks && bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                bVar.L(e11);
                                bVar.q(false);
                                bVar.C0(HtmlTreeBuilderState.InTable);
                            } else if (D2.equals("input")) {
                                bVar.q0();
                                if (!bVar.P(e11).f(NativeComponentConstants.KEY_COMPONENT_TYPE).equalsIgnoreCase("hidden")) {
                                    bVar.q(false);
                                }
                            } else if (org.jsoup.helper.c.c(D2, b.f71902j)) {
                                bVar.P(e11);
                            } else if (D2.equals("hr")) {
                                if (bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                bVar.P(e11);
                                bVar.q(false);
                            } else if (D2.equals("image")) {
                                if (bVar.y("svg") == null) {
                                    return bVar.e(e11.B("img"));
                                }
                                bVar.L(e11);
                            } else if (D2.equals("isindex")) {
                                bVar.p(this);
                                if (bVar.x() != null) {
                                    return false;
                                }
                                bVar.g("form");
                                if (e11.f71927j.p(EventConstants.KEY_ACTION)) {
                                    bVar.x().j0(EventConstants.KEY_ACTION, e11.f71927j.n(EventConstants.KEY_ACTION));
                                }
                                bVar.g("hr");
                                bVar.g("label");
                                bVar.e(new Token.c().p(e11.f71927j.p("prompt") ? e11.f71927j.n("prompt") : "This is a searchable index. Enter search keywords: "));
                                org.jsoup.nodes.b bVar2 = new org.jsoup.nodes.b();
                                Iterator it3 = e11.f71927j.iterator();
                                while (it3.hasNext()) {
                                    org.jsoup.nodes.a aVar3 = (org.jsoup.nodes.a) it3.next();
                                    if (!org.jsoup.helper.c.c(aVar3.getKey(), b.f71903k)) {
                                        bVar2.x(aVar3);
                                    }
                                }
                                bVar2.w("name", "isindex");
                                bVar.h("input", bVar2);
                                bVar.f("label");
                                bVar.g("hr");
                                bVar.f("form");
                            } else if (D2.equals("textarea")) {
                                bVar.L(e11);
                                bVar.f72001b.u(TokeniserState.Rcdata);
                                bVar.d0();
                                bVar.q(false);
                                bVar.C0(HtmlTreeBuilderState.Text);
                            } else if (D2.equals("xmp")) {
                                if (bVar.C(TtmlNode.TAG_P)) {
                                    bVar.f(TtmlNode.TAG_P);
                                }
                                bVar.q0();
                                bVar.q(false);
                                HtmlTreeBuilderState.handleRawtext(e11, bVar);
                            } else if (D2.equals("iframe")) {
                                bVar.q(false);
                                HtmlTreeBuilderState.handleRawtext(e11, bVar);
                            } else if (D2.equals("noembed")) {
                                HtmlTreeBuilderState.handleRawtext(e11, bVar);
                            } else if (D2.equals("select")) {
                                bVar.q0();
                                bVar.L(e11);
                                bVar.q(false);
                                HtmlTreeBuilderState B0 = bVar.B0();
                                if (B0.equals(HtmlTreeBuilderState.InTable) || B0.equals(HtmlTreeBuilderState.InCaption) || B0.equals(HtmlTreeBuilderState.InTableBody) || B0.equals(HtmlTreeBuilderState.InRow) || B0.equals(HtmlTreeBuilderState.InCell)) {
                                    bVar.C0(HtmlTreeBuilderState.InSelectInTable);
                                } else {
                                    bVar.C0(HtmlTreeBuilderState.InSelect);
                                }
                            } else if (org.jsoup.helper.c.c(D2, b.f71904l)) {
                                if (bVar.a().B().equals("option")) {
                                    bVar.f("option");
                                }
                                bVar.q0();
                                bVar.L(e11);
                            } else if (org.jsoup.helper.c.c(D2, b.f71905m)) {
                                if (bVar.E("ruby")) {
                                    bVar.s();
                                    if (!bVar.a().B().equals("ruby")) {
                                        bVar.p(this);
                                        bVar.k0("ruby");
                                    }
                                    bVar.L(e11);
                                }
                            } else if (D2.equals("math")) {
                                bVar.q0();
                                bVar.L(e11);
                            } else if (D2.equals("svg")) {
                                bVar.q0();
                                bVar.L(e11);
                            } else {
                                if (org.jsoup.helper.c.c(D2, b.f71906n)) {
                                    bVar.p(this);
                                    return false;
                                }
                                bVar.q0();
                                bVar.L(e11);
                            }
                        }
                    }
                }
            }
            return true;
        }
    },
    Text { // from class: org.jsoup.parser.HtmlTreeBuilderState.8
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.g()) {
                bVar.N(token.a());
                return true;
            }
            if (token.j()) {
                bVar.p(this);
                bVar.j0();
                bVar.C0(bVar.h0());
                return bVar.e(token);
            }
            if (!token.k()) {
                return true;
            }
            bVar.j0();
            bVar.C0(bVar.h0());
            return true;
        }
    },
    InTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.9
        boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.p(this);
            if (!org.jsoup.helper.c.b(bVar.a().B(), "table", "tbody", "tfoot", "thead", "tr")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            bVar.z0(true);
            boolean n02 = bVar.n0(token, HtmlTreeBuilderState.InBody);
            bVar.z0(false);
            return n02;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.g()) {
                bVar.f0();
                bVar.d0();
                bVar.C0(HtmlTreeBuilderState.InTableText);
                return bVar.e(token);
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (!token.l()) {
                if (!token.k()) {
                    if (!token.j()) {
                        return anythingElse(token, bVar);
                    }
                    if (bVar.a().B().equals("html")) {
                        bVar.p(this);
                    }
                    return true;
                }
                String D = token.d().D();
                if (!D.equals("table")) {
                    if (!org.jsoup.helper.c.b(D, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                        return anythingElse(token, bVar);
                    }
                    bVar.p(this);
                    return false;
                }
                if (!bVar.K(D)) {
                    bVar.p(this);
                    return false;
                }
                bVar.l0("table");
                bVar.x0();
                return true;
            }
            Token.h e11 = token.e();
            String D2 = e11.D();
            if (D2.equals("caption")) {
                bVar.n();
                bVar.S();
                bVar.L(e11);
                bVar.C0(HtmlTreeBuilderState.InCaption);
            } else if (D2.equals("colgroup")) {
                bVar.n();
                bVar.L(e11);
                bVar.C0(HtmlTreeBuilderState.InColumnGroup);
            } else {
                if (D2.equals("col")) {
                    bVar.g("colgroup");
                    return bVar.e(token);
                }
                if (org.jsoup.helper.c.b(D2, "tbody", "tfoot", "thead")) {
                    bVar.n();
                    bVar.L(e11);
                    bVar.C0(HtmlTreeBuilderState.InTableBody);
                } else {
                    if (org.jsoup.helper.c.b(D2, "td", "th", "tr")) {
                        bVar.g("tbody");
                        return bVar.e(token);
                    }
                    if (D2.equals("table")) {
                        bVar.p(this);
                        if (bVar.f("table")) {
                            return bVar.e(token);
                        }
                    } else {
                        if (org.jsoup.helper.c.b(D2, TtmlNode.TAG_STYLE, "script")) {
                            return bVar.n0(token, HtmlTreeBuilderState.InHead);
                        }
                        if (D2.equals("input")) {
                            if (!e11.f71927j.n(NativeComponentConstants.KEY_COMPONENT_TYPE).equalsIgnoreCase("hidden")) {
                                return anythingElse(token, bVar);
                            }
                            bVar.P(e11);
                        } else {
                            if (!D2.equals("form")) {
                                return anythingElse(token, bVar);
                            }
                            bVar.p(this);
                            if (bVar.x() != null) {
                                return false;
                            }
                            bVar.Q(e11, false);
                        }
                    }
                }
            }
            return true;
        }
    },
    InTableText { // from class: org.jsoup.parser.HtmlTreeBuilderState.10
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (a.f71892a[token.f71910a.ordinal()] == 5) {
                Token.c a11 = token.a();
                if (a11.q().equals(HtmlTreeBuilderState.nullString)) {
                    bVar.p(this);
                    return false;
                }
                bVar.A().add(a11.q());
                return true;
            }
            if (bVar.A().size() > 0) {
                for (String str : bVar.A()) {
                    if (HtmlTreeBuilderState.isWhitespace(str)) {
                        bVar.N(new Token.c().p(str));
                    } else {
                        bVar.p(this);
                        if (org.jsoup.helper.c.b(bVar.a().B(), "table", "tbody", "tfoot", "thead", "tr")) {
                            bVar.z0(true);
                            bVar.n0(new Token.c().p(str), HtmlTreeBuilderState.InBody);
                            bVar.z0(false);
                        } else {
                            bVar.n0(new Token.c().p(str), HtmlTreeBuilderState.InBody);
                        }
                    }
                }
                bVar.f0();
            }
            bVar.C0(bVar.h0());
            return bVar.e(token);
        }
    },
    InCaption { // from class: org.jsoup.parser.HtmlTreeBuilderState.11
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.k() && token.d().D().equals("caption")) {
                if (!bVar.K(token.d().D())) {
                    bVar.p(this);
                    return false;
                }
                bVar.s();
                if (!bVar.a().B().equals("caption")) {
                    bVar.p(this);
                }
                bVar.l0("caption");
                bVar.k();
                bVar.C0(HtmlTreeBuilderState.InTable);
                return true;
            }
            if ((token.l() && org.jsoup.helper.c.b(token.e().D(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) || (token.k() && token.d().D().equals("table"))) {
                bVar.p(this);
                if (bVar.f("caption")) {
                    return bVar.e(token);
                }
                return true;
            }
            if (!token.k() || !org.jsoup.helper.c.b(token.d().D(), TtmlNode.TAG_BODY, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            bVar.p(this);
            return false;
        }
    },
    InColumnGroup { // from class: org.jsoup.parser.HtmlTreeBuilderState.12
        private boolean anythingElse(Token token, i iVar) {
            if (iVar.f("colgroup")) {
                return iVar.e(token);
            }
            return true;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            int i11 = a.f71892a[token.f71910a.ordinal()];
            if (i11 == 1) {
                bVar.O(token.b());
            } else if (i11 == 2) {
                bVar.p(this);
            } else if (i11 == 3) {
                Token.h e11 = token.e();
                String D = e11.D();
                D.hashCode();
                if (!D.equals("col")) {
                    return !D.equals("html") ? anythingElse(token, bVar) : bVar.n0(token, HtmlTreeBuilderState.InBody);
                }
                bVar.P(e11);
            } else {
                if (i11 != 4) {
                    if (i11 == 6 && bVar.a().B().equals("html")) {
                        return true;
                    }
                    return anythingElse(token, bVar);
                }
                if (!token.d().f71920c.equals("colgroup")) {
                    return anythingElse(token, bVar);
                }
                if (bVar.a().B().equals("html")) {
                    bVar.p(this);
                    return false;
                }
                bVar.j0();
                bVar.C0(HtmlTreeBuilderState.InTable);
            }
            return true;
        }
    },
    InTableBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.13
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            return bVar.n0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean exitTableBody(Token token, org.jsoup.parser.b bVar) {
            if (!bVar.K("tbody") && !bVar.K("thead") && !bVar.E("tfoot")) {
                bVar.p(this);
                return false;
            }
            bVar.m();
            bVar.f(bVar.a().B());
            return bVar.e(token);
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            int i11 = a.f71892a[token.f71910a.ordinal()];
            if (i11 == 3) {
                Token.h e11 = token.e();
                String D = e11.D();
                if (D.equals("template")) {
                    bVar.L(e11);
                    return true;
                }
                if (D.equals("tr")) {
                    bVar.m();
                    bVar.L(e11);
                    bVar.C0(HtmlTreeBuilderState.InRow);
                    return true;
                }
                if (!org.jsoup.helper.c.b(D, "th", "td")) {
                    return org.jsoup.helper.c.b(D, "caption", "col", "colgroup", "tbody", "tfoot", "thead") ? exitTableBody(token, bVar) : anythingElse(token, bVar);
                }
                bVar.p(this);
                bVar.g("tr");
                return bVar.e(e11);
            }
            if (i11 != 4) {
                return anythingElse(token, bVar);
            }
            String D2 = token.d().D();
            if (!org.jsoup.helper.c.b(D2, "tbody", "tfoot", "thead")) {
                if (D2.equals("table")) {
                    return exitTableBody(token, bVar);
                }
                if (!org.jsoup.helper.c.b(D2, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html", "td", "th", "tr")) {
                    return anythingElse(token, bVar);
                }
                bVar.p(this);
                return false;
            }
            if (!bVar.K(D2)) {
                bVar.p(this);
                return false;
            }
            bVar.m();
            bVar.j0();
            bVar.C0(HtmlTreeBuilderState.InTable);
            return true;
        }
    },
    InRow { // from class: org.jsoup.parser.HtmlTreeBuilderState.14
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            return bVar.n0(token, HtmlTreeBuilderState.InTable);
        }

        private boolean handleMissingTr(Token token, i iVar) {
            if (iVar.f("tr")) {
                return iVar.e(token);
            }
            return false;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.l()) {
                Token.h e11 = token.e();
                String D = e11.D();
                if (D.equals("template")) {
                    bVar.L(e11);
                    return true;
                }
                if (!org.jsoup.helper.c.b(D, "th", "td")) {
                    return org.jsoup.helper.c.b(D, "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr") ? handleMissingTr(token, bVar) : anythingElse(token, bVar);
                }
                bVar.o();
                bVar.L(e11);
                bVar.C0(HtmlTreeBuilderState.InCell);
                bVar.S();
                return true;
            }
            if (!token.k()) {
                return anythingElse(token, bVar);
            }
            String D2 = token.d().D();
            if (D2.equals("tr")) {
                if (!bVar.K(D2)) {
                    bVar.p(this);
                    return false;
                }
                bVar.o();
                bVar.j0();
                bVar.C0(HtmlTreeBuilderState.InTableBody);
                return true;
            }
            if (D2.equals("table")) {
                return handleMissingTr(token, bVar);
            }
            if (!org.jsoup.helper.c.b(D2, "tbody", "tfoot", "thead")) {
                if (!org.jsoup.helper.c.b(D2, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html", "td", "th")) {
                    return anythingElse(token, bVar);
                }
                bVar.p(this);
                return false;
            }
            if (bVar.K(D2)) {
                bVar.f("tr");
                return bVar.e(token);
            }
            bVar.p(this);
            return false;
        }
    },
    InCell { // from class: org.jsoup.parser.HtmlTreeBuilderState.15
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            return bVar.n0(token, HtmlTreeBuilderState.InBody);
        }

        private void closeCell(org.jsoup.parser.b bVar) {
            if (bVar.K("td")) {
                bVar.f("td");
            } else {
                bVar.f("th");
            }
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (!token.k()) {
                if (!token.l() || !org.jsoup.helper.c.b(token.e().D(), "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr")) {
                    return anythingElse(token, bVar);
                }
                if (bVar.K("td") || bVar.K("th")) {
                    closeCell(bVar);
                    return bVar.e(token);
                }
                bVar.p(this);
                return false;
            }
            String D = token.d().D();
            if (!org.jsoup.helper.c.b(D, "td", "th")) {
                if (org.jsoup.helper.c.b(D, TtmlNode.TAG_BODY, "caption", "col", "colgroup", "html")) {
                    bVar.p(this);
                    return false;
                }
                if (!org.jsoup.helper.c.b(D, "table", "tbody", "tfoot", "thead", "tr")) {
                    return anythingElse(token, bVar);
                }
                if (bVar.K(D)) {
                    closeCell(bVar);
                    return bVar.e(token);
                }
                bVar.p(this);
                return false;
            }
            if (!bVar.K(D)) {
                bVar.p(this);
                bVar.C0(HtmlTreeBuilderState.InRow);
                return false;
            }
            bVar.s();
            if (!bVar.a().B().equals(D)) {
                bVar.p(this);
            }
            bVar.l0(D);
            bVar.k();
            bVar.C0(HtmlTreeBuilderState.InRow);
            return true;
        }
    },
    InSelect { // from class: org.jsoup.parser.HtmlTreeBuilderState.16
        private boolean anythingElse(Token token, org.jsoup.parser.b bVar) {
            bVar.p(this);
            return false;
        }

        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            switch (a.f71892a[token.f71910a.ordinal()]) {
                case 1:
                    bVar.O(token.b());
                    return true;
                case 2:
                    bVar.p(this);
                    return false;
                case 3:
                    Token.h e11 = token.e();
                    String D = e11.D();
                    if (D.equals("html")) {
                        return bVar.n0(e11, HtmlTreeBuilderState.InBody);
                    }
                    if (D.equals("option")) {
                        if (bVar.a().B().equals("option")) {
                            bVar.f("option");
                        }
                        bVar.L(e11);
                    } else {
                        if (!D.equals("optgroup")) {
                            if (D.equals("select")) {
                                bVar.p(this);
                                return bVar.f("select");
                            }
                            if (!org.jsoup.helper.c.b(D, "input", "keygen", "textarea")) {
                                return D.equals("script") ? bVar.n0(token, HtmlTreeBuilderState.InHead) : anythingElse(token, bVar);
                            }
                            bVar.p(this);
                            if (!bVar.H("select")) {
                                return false;
                            }
                            bVar.f("select");
                            return bVar.e(e11);
                        }
                        if (bVar.a().B().equals("option")) {
                            bVar.f("option");
                        } else if (bVar.a().B().equals("optgroup")) {
                            bVar.f("optgroup");
                        }
                        bVar.L(e11);
                    }
                    return true;
                case 4:
                    String D2 = token.d().D();
                    D2.hashCode();
                    char c11 = 65535;
                    switch (D2.hashCode()) {
                        case -1010136971:
                            if (D2.equals("option")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case -906021636:
                            if (D2.equals("select")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case -80773204:
                            if (D2.equals("optgroup")) {
                                c11 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            if (bVar.a().B().equals("option")) {
                                bVar.j0();
                            } else {
                                bVar.p(this);
                            }
                            return true;
                        case 1:
                            if (!bVar.H(D2)) {
                                bVar.p(this);
                                return false;
                            }
                            bVar.l0(D2);
                            bVar.x0();
                            return true;
                        case 2:
                            if (bVar.a().B().equals("option") && bVar.j(bVar.a()) != null && bVar.j(bVar.a()).B().equals("optgroup")) {
                                bVar.f("option");
                            }
                            if (bVar.a().B().equals("optgroup")) {
                                bVar.j0();
                            } else {
                                bVar.p(this);
                            }
                            return true;
                        default:
                            return anythingElse(token, bVar);
                    }
                case 5:
                    Token.c a11 = token.a();
                    if (a11.q().equals(HtmlTreeBuilderState.nullString)) {
                        bVar.p(this);
                        return false;
                    }
                    bVar.N(a11);
                    return true;
                case 6:
                    if (!bVar.a().B().equals("html")) {
                        bVar.p(this);
                    }
                    return true;
                default:
                    return anythingElse(token, bVar);
            }
        }
    },
    InSelectInTable { // from class: org.jsoup.parser.HtmlTreeBuilderState.17
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.l() && org.jsoup.helper.c.b(token.e().D(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                bVar.p(this);
                bVar.f("select");
                return bVar.e(token);
            }
            if (!token.k() || !org.jsoup.helper.c.b(token.d().D(), "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th")) {
                return bVar.n0(token, HtmlTreeBuilderState.InSelect);
            }
            bVar.p(this);
            if (!bVar.K(token.d().D())) {
                return false;
            }
            bVar.f("select");
            return bVar.e(token);
        }
    },
    AfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.18
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (token.l() && token.e().D().equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.k() && token.d().D().equals("html")) {
                if (bVar.Y()) {
                    bVar.p(this);
                    return false;
                }
                bVar.C0(HtmlTreeBuilderState.AfterAfterBody);
                return true;
            }
            if (token.j()) {
                return true;
            }
            bVar.p(this);
            bVar.C0(HtmlTreeBuilderState.InBody);
            return bVar.e(token);
        }
    },
    InFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.19
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
            } else if (token.h()) {
                bVar.O(token.b());
            } else {
                if (token.i()) {
                    bVar.p(this);
                    return false;
                }
                if (token.l()) {
                    Token.h e11 = token.e();
                    String D = e11.D();
                    D.hashCode();
                    char c11 = 65535;
                    switch (D.hashCode()) {
                        case -1644953643:
                            if (D.equals("frameset")) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case 3213227:
                            if (D.equals("html")) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case 97692013:
                            if (D.equals("frame")) {
                                c11 = 2;
                                break;
                            }
                            break;
                        case 1192721831:
                            if (D.equals("noframes")) {
                                c11 = 3;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            bVar.L(e11);
                            break;
                        case 1:
                            return bVar.n0(e11, HtmlTreeBuilderState.InBody);
                        case 2:
                            bVar.P(e11);
                            break;
                        case 3:
                            return bVar.n0(e11, HtmlTreeBuilderState.InHead);
                        default:
                            bVar.p(this);
                            return false;
                    }
                } else if (token.k() && token.d().D().equals("frameset")) {
                    if (bVar.a().B().equals("html")) {
                        bVar.p(this);
                        return false;
                    }
                    bVar.j0();
                    if (!bVar.Y() && !bVar.a().B().equals("frameset")) {
                        bVar.C0(HtmlTreeBuilderState.AfterFrameset);
                    }
                } else {
                    if (!token.j()) {
                        bVar.p(this);
                        return false;
                    }
                    if (!bVar.a().B().equals("html")) {
                        bVar.p(this);
                    }
                }
            }
            return true;
        }
    },
    AfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.20
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (HtmlTreeBuilderState.isWhitespace(token)) {
                bVar.N(token.a());
                return true;
            }
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i()) {
                bVar.p(this);
                return false;
            }
            if (token.l() && token.e().D().equals("html")) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.k() && token.d().D().equals("html")) {
                bVar.C0(HtmlTreeBuilderState.AfterAfterFrameset);
                return true;
            }
            if (token.l() && token.e().D().equals("noframes")) {
                return bVar.n0(token, HtmlTreeBuilderState.InHead);
            }
            if (token.j()) {
                return true;
            }
            bVar.p(this);
            return false;
        }
    },
    AfterAfterBody { // from class: org.jsoup.parser.HtmlTreeBuilderState.21
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i() || HtmlTreeBuilderState.isWhitespace(token) || (token.l() && token.e().D().equals("html"))) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.j()) {
                return true;
            }
            bVar.p(this);
            bVar.C0(HtmlTreeBuilderState.InBody);
            return bVar.e(token);
        }
    },
    AfterAfterFrameset { // from class: org.jsoup.parser.HtmlTreeBuilderState.22
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            if (token.h()) {
                bVar.O(token.b());
                return true;
            }
            if (token.i() || HtmlTreeBuilderState.isWhitespace(token) || (token.l() && token.e().D().equals("html"))) {
                return bVar.n0(token, HtmlTreeBuilderState.InBody);
            }
            if (token.j()) {
                return true;
            }
            if (token.l() && token.e().D().equals("noframes")) {
                return bVar.n0(token, HtmlTreeBuilderState.InHead);
            }
            bVar.p(this);
            return false;
        }
    },
    ForeignContent { // from class: org.jsoup.parser.HtmlTreeBuilderState.23
        @Override // org.jsoup.parser.HtmlTreeBuilderState
        boolean process(Token token, org.jsoup.parser.b bVar) {
            return true;
        }
    };

    private static String nullString = String.valueOf((char) 0);

    /* loaded from: classes7.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f71892a;

        static {
            int[] iArr = new int[Token.TokenType.values().length];
            f71892a = iArr;
            try {
                iArr[Token.TokenType.Comment.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f71892a[Token.TokenType.Doctype.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f71892a[Token.TokenType.StartTag.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f71892a[Token.TokenType.EndTag.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f71892a[Token.TokenType.Character.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f71892a[Token.TokenType.EOF.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: classes7.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final String[] f71893a = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", TtmlNode.TAG_STYLE, CampaignEx.JSON_KEY_TITLE};

        /* renamed from: b, reason: collision with root package name */
        static final String[] f71894b = {PlaceTypes.ADDRESS, "article", "aside", "blockquote", TtmlNode.CENTER, "details", OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_DIR, TtmlNode.TAG_DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", TtmlNode.TAG_P, "section", "summary", "ul"};

        /* renamed from: c, reason: collision with root package name */
        static final String[] f71895c = {"h1", "h2", "h3", "h4", "h5", "h6"};

        /* renamed from: d, reason: collision with root package name */
        static final String[] f71896d = {"listing", OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_PRE};

        /* renamed from: e, reason: collision with root package name */
        static final String[] f71897e = {PlaceTypes.ADDRESS, TtmlNode.TAG_DIV, TtmlNode.TAG_P};

        /* renamed from: f, reason: collision with root package name */
        static final String[] f71898f = {"dd", "dt"};

        /* renamed from: g, reason: collision with root package name */
        static final String[] f71899g = {DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "big", "code", "em", "font", "i", "s", "small", "strike", "strong", TtmlNode.TAG_TT, TmcStartParams.KEY_URL_SHORT};

        /* renamed from: h, reason: collision with root package name */
        static final String[] f71900h = {"applet", "marquee", "object"};

        /* renamed from: i, reason: collision with root package name */
        static final String[] f71901i = {"area", TtmlNode.TAG_BR, "embed", "img", "keygen", "wbr"};

        /* renamed from: j, reason: collision with root package name */
        static final String[] f71902j = {"param", EventConstants.KEY_SOURCE, "track"};

        /* renamed from: k, reason: collision with root package name */
        static final String[] f71903k = {EventConstants.KEY_ACTION, "name", "prompt"};

        /* renamed from: l, reason: collision with root package name */
        static final String[] f71904l = {"optgroup", "option"};

        /* renamed from: m, reason: collision with root package name */
        static final String[] f71905m = {"rp", "rt"};

        /* renamed from: n, reason: collision with root package name */
        static final String[] f71906n = {"caption", "col", "colgroup", "frame", TtmlNode.TAG_HEAD, "tbody", "td", "tfoot", "th", "thead", "tr"};

        /* renamed from: o, reason: collision with root package name */
        static final String[] f71907o = {PlaceTypes.ADDRESS, "article", "aside", "blockquote", "button", TtmlNode.CENTER, "details", OfflineConstantsKt.OFFLINE_DOWNLOAD_SEARCH_MODE_DIR, TtmlNode.TAG_DIV, "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", OfflineConstantsKt.OFFLINE_DOWNLOAD_MODE_PRE, "section", "summary", "ul"};

        /* renamed from: p, reason: collision with root package name */
        static final String[] f71908p = {"a", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", TtmlNode.TAG_TT, TmcStartParams.KEY_URL_SHORT};

        /* renamed from: q, reason: collision with root package name */
        static final String[] f71909q = {"table", "tbody", "tfoot", "thead", "tr"};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRawtext(Token.h hVar, org.jsoup.parser.b bVar) {
        bVar.f72001b.u(TokeniserState.Rawtext);
        bVar.d0();
        bVar.C0(Text);
        bVar.L(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void handleRcData(Token.h hVar, org.jsoup.parser.b bVar) {
        bVar.f72001b.u(TokeniserState.Rcdata);
        bVar.d0();
        bVar.C0(Text);
        bVar.L(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(String str) {
        return org.jsoup.helper.c.e(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isWhitespace(Token token) {
        if (token.g()) {
            return isWhitespace(token.a().q());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean process(Token token, org.jsoup.parser.b bVar);
}
