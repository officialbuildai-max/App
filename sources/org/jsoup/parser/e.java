package org.jsoup.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private i f71958a;

    /* renamed from: b, reason: collision with root package name */
    private int f71959b = 0;

    /* renamed from: c, reason: collision with root package name */
    private ParseErrorList f71960c;

    /* renamed from: d, reason: collision with root package name */
    private d f71961d;

    public e(i iVar) {
        this.f71958a = iVar;
        this.f71961d = iVar.b();
    }

    public static e a() {
        return new e(new b());
    }

    public static Document c(String str, String str2) {
        b bVar = new b();
        return bVar.d(new StringReader(str), str2, ParseErrorList.noTracking(), bVar.b());
    }

    public static List d(String str, Element element, String str2) {
        b bVar = new b();
        return bVar.i0(str, element, str2, ParseErrorList.noTracking(), bVar.b());
    }

    public static e g() {
        return new e(new j());
    }

    public boolean b() {
        return this.f71959b > 0;
    }

    public Document e(Reader reader, String str) {
        ParseErrorList tracking = b() ? ParseErrorList.tracking(this.f71959b) : ParseErrorList.noTracking();
        this.f71960c = tracking;
        return this.f71958a.d(reader, str, tracking, this.f71961d);
    }

    public Document f(String str, String str2) {
        this.f71960c = b() ? ParseErrorList.tracking(this.f71959b) : ParseErrorList.noTracking();
        return this.f71958a.d(new StringReader(str), str2, this.f71960c, this.f71961d);
    }
}
