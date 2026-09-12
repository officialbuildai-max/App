package com.amazonaws.services.s3.internal;

import com.amazonaws.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class XmlWriter {

    /* renamed from: a, reason: collision with root package name */
    List f18755a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    StringBuilder f18756b = new StringBuilder();

    private void a(String str, StringBuilder sb2) {
        if (str == null) {
            str = "";
        }
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            String str2 = charAt != '\t' ? charAt != '\n' ? charAt != '\r' ? charAt != '\"' ? charAt != '&' ? charAt != '<' ? charAt != '>' ? null : "&gt;" : "&lt;" : "&amp;" : "&quot;" : "&#13;" : "&#10;" : "&#9;";
            if (str2 != null) {
                if (i12 < i11) {
                    sb2.append((CharSequence) str, i12, i11);
                }
                this.f18756b.append(str2);
                i12 = i11 + 1;
            }
            i11++;
        }
        if (i12 < i11) {
            this.f18756b.append((CharSequence) str, i12, i11);
        }
    }

    public XmlWriter b() {
        String str = (String) this.f18755a.remove(r0.size() - 1);
        StringBuilder sb2 = this.f18756b;
        sb2.append("</");
        sb2.append(str);
        sb2.append(">");
        return this;
    }

    public byte[] c() {
        return toString().getBytes(StringUtils.f19086a);
    }

    public XmlWriter d(String str) {
        StringBuilder sb2 = this.f18756b;
        sb2.append("<");
        sb2.append(str);
        sb2.append(">");
        this.f18755a.add(str);
        return this;
    }

    public XmlWriter e(String str) {
        a(str, this.f18756b);
        return this;
    }

    public String toString() {
        return this.f18756b.toString();
    }
}
