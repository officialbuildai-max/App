package org.jsoup.nodes;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import org.jsoup.nodes.Entities;

/* loaded from: classes7.dex */
public class Document extends Element {

    /* renamed from: j, reason: collision with root package name */
    private OutputSettings f71847j;

    /* renamed from: k, reason: collision with root package name */
    private QuirksMode f71848k;

    /* renamed from: l, reason: collision with root package name */
    private String f71849l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f71850m;

    /* loaded from: classes7.dex */
    public static class OutputSettings implements Cloneable {

        /* renamed from: b, reason: collision with root package name */
        private Charset f71852b;

        /* renamed from: d, reason: collision with root package name */
        Entities.CoreCharset f71854d;

        /* renamed from: a, reason: collision with root package name */
        private Entities.EscapeMode f71851a = Entities.EscapeMode.base;

        /* renamed from: c, reason: collision with root package name */
        private ThreadLocal f71853c = new ThreadLocal();

        /* renamed from: e, reason: collision with root package name */
        private boolean f71855e = true;

        /* renamed from: f, reason: collision with root package name */
        private boolean f71856f = false;

        /* renamed from: g, reason: collision with root package name */
        private int f71857g = 1;

        /* renamed from: h, reason: collision with root package name */
        private Syntax f71858h = Syntax.html;

        /* loaded from: classes7.dex */
        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            c(Charset.forName("UTF8"));
        }

        public Charset a() {
            return this.f71852b;
        }

        public OutputSettings b(String str) {
            c(Charset.forName(str));
            return this;
        }

        public OutputSettings c(Charset charset) {
            this.f71852b = charset;
            return this;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.b(this.f71852b.name());
                outputSettings.f71851a = Entities.EscapeMode.valueOf(this.f71851a.name());
                return outputSettings;
            } catch (CloneNotSupportedException e11) {
                throw new RuntimeException(e11);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CharsetEncoder f() {
            CharsetEncoder charsetEncoder = (CharsetEncoder) this.f71853c.get();
            return charsetEncoder != null ? charsetEncoder : k();
        }

        public Entities.EscapeMode g() {
            return this.f71851a;
        }

        public int i() {
            return this.f71857g;
        }

        public boolean j() {
            return this.f71856f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public CharsetEncoder k() {
            CharsetEncoder newEncoder = this.f71852b.newEncoder();
            this.f71853c.set(newEncoder);
            this.f71854d = Entities.CoreCharset.byName(newEncoder.charset().name());
            return newEncoder;
        }

        public boolean l() {
            return this.f71855e;
        }

        public Syntax m() {
            return this.f71858h;
        }

        public OutputSettings n(Syntax syntax) {
            this.f71858h = syntax;
            return this;
        }
    }

    /* loaded from: classes7.dex */
    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(org.jsoup.parser.f.l("#root", org.jsoup.parser.d.f71954c), str);
        this.f71847j = new OutputSettings();
        this.f71848k = QuirksMode.noQuirks;
        this.f71850m = false;
        this.f71849l = str;
    }

    private Element f1(String str, j jVar) {
        if (jVar.B().equals(str)) {
            return (Element) jVar;
        }
        int n11 = jVar.n();
        for (int i11 = 0; i11 < n11; i11++) {
            Element f12 = f1(str, jVar.m(i11));
            if (f12 != null) {
                return f12;
            }
        }
        return null;
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.j
    public String B() {
        return "#document";
    }

    @Override // org.jsoup.nodes.j
    public String D() {
        return super.B0();
    }

    @Override // org.jsoup.nodes.Element
    public Element X0(String str) {
        d1().X0(str);
        return this;
    }

    public Element d1() {
        return f1(TtmlNode.TAG_BODY, this);
    }

    @Override // org.jsoup.nodes.Element
    /* renamed from: e1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public Document q() {
        Document document = (Document) super.q();
        document.f71847j = this.f71847j.clone();
        return document;
    }

    public OutputSettings g1() {
        return this.f71847j;
    }

    public QuirksMode h1() {
        return this.f71848k;
    }

    public Document i1(QuirksMode quirksMode) {
        this.f71848k = quirksMode;
        return this;
    }

    public String j1() {
        Element first = y0(CampaignEx.JSON_KEY_TITLE).first();
        return first != null ? org.jsoup.helper.c.k(first.W0()).trim() : "";
    }
}
