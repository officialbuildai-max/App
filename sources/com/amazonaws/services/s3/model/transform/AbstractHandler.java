package com.amazonaws.services.s3.model.transform;

import java.util.Iterator;
import java.util.LinkedList;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes2.dex */
abstract class AbstractHandler extends DefaultHandler {

    /* renamed from: a, reason: collision with root package name */
    private final StringBuilder f18931a = new StringBuilder();

    /* renamed from: b, reason: collision with root package name */
    private final LinkedList f18932b = new LinkedList();

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean a() {
        return this.f18932b.isEmpty();
    }

    protected abstract void b(String str, String str2, String str3);

    protected abstract void c(String str, String str2, String str3, Attributes attributes);

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void characters(char[] cArr, int i11, int i12) {
        this.f18931a.append(cArr, i11, i12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String d() {
        return this.f18931a.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean e(String... strArr) {
        if (strArr.length != this.f18932b.size()) {
            return false;
        }
        Iterator it = this.f18932b.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = strArr[i11];
            if (!str2.equals("*") && !str2.equals(str)) {
                return false;
            }
            i11++;
        }
        return true;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void endElement(String str, String str2, String str3) {
        this.f18932b.removeLast();
        b(str, str2, str3);
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public final void startElement(String str, String str2, String str3, Attributes attributes) {
        this.f18931a.setLength(0);
        c(str, str2, str3, attributes);
        this.f18932b.add(str2);
    }
}
