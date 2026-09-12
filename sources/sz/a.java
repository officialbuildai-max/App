package sz;

import g10.h;
import ir.ac.iust.htmlchardet.Charsets;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* loaded from: classes7.dex */
public abstract class a {
    private static Document a(byte[] bArr, String str) {
        return d10.a.b(new String(bArr, Charset.forName(str)));
    }

    public static String b(byte[] bArr, boolean... zArr) {
        Document document;
        byte[] bArr2 = null;
        if (zArr == null || zArr.length <= 0 || !zArr[0]) {
            document = null;
        } else {
            document = a(bArr, "ISO-8859-1");
            String d11 = d(document);
            if (Charsets.isValid(d11)) {
                return Charsets.normalize(d11);
            }
        }
        String e11 = e(bArr);
        if (e11.equalsIgnoreCase("UTF-8")) {
            return Charsets.normalize(e11);
        }
        if (document == null) {
            document = a(bArr, "ISO-8859-1");
        }
        try {
            bArr2 = document.W0().getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
        }
        if (bArr2 != null && bArr2.length >= 40) {
            bArr = bArr2;
        }
        return Charsets.normalize(c(bArr));
    }

    private static String c(byte[] bArr) {
        tz.a aVar = new tz.a();
        aVar.d(bArr);
        return aVar.b().getName();
    }

    private static String d(Document document) {
        Iterator<Element> it = document.R0("meta").iterator();
        while (it.hasNext()) {
            Element next = it.next();
            String f11 = next.f("charset");
            if (Charsets.isValid(f11)) {
                return f11;
            }
            String f12 = next.f("content");
            if (f12.contains("charset")) {
                String trim = f12.substring(f12.indexOf("charset=") + 8, f12.length()).trim();
                if (Charsets.isValid(trim)) {
                    return trim;
                }
            }
        }
        return null;
    }

    private static String e(byte[] bArr) {
        h hVar = new h(0);
        hVar.i(bArr, bArr.length, false);
        hVar.a();
        return hVar.g()[0];
    }
}
