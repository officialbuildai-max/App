package org.apache.tools.ant;

import java.io.File;
import java.util.StringTokenizer;

/* loaded from: classes7.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    private StringTokenizer f71434a;

    /* renamed from: b, reason: collision with root package name */
    private String f71435b = null;

    /* renamed from: c, reason: collision with root package name */
    private boolean f71436c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f71437d;

    public p(String str) {
        boolean a11 = x00.a.a("netware");
        this.f71436c = a11;
        if (a11) {
            this.f71434a = new StringTokenizer(str, ":;", true);
        } else {
            this.f71434a = new StringTokenizer(str, ":;", false);
        }
        this.f71437d = File.pathSeparatorChar == ';';
    }

    public boolean a() {
        if (this.f71435b != null) {
            return true;
        }
        return this.f71434a.hasMoreTokens();
    }

    public String b() {
        String str = this.f71435b;
        if (str != null) {
            this.f71435b = null;
        } else {
            str = this.f71434a.nextToken().trim();
        }
        if (!this.f71436c) {
            if (str.length() != 1 || !Character.isLetter(str.charAt(0)) || !this.f71437d || !this.f71434a.hasMoreTokens()) {
                return str;
            }
            String trim = this.f71434a.nextToken().trim();
            if (!trim.startsWith("\\") && !trim.startsWith("/")) {
                this.f71435b = trim;
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(":");
            stringBuffer.append(trim);
            return stringBuffer.toString();
        }
        String str2 = File.pathSeparator;
        if (str.equals(str2) || str.equals(":")) {
            str = this.f71434a.nextToken().trim();
        }
        if (!this.f71434a.hasMoreTokens()) {
            return str;
        }
        String trim2 = this.f71434a.nextToken().trim();
        if (trim2.equals(str2)) {
            return str;
        }
        if (!trim2.equals(":")) {
            this.f71435b = trim2;
            return str;
        }
        if (str.startsWith("/") || str.startsWith("\\") || str.startsWith(".") || str.startsWith("..")) {
            return str;
        }
        String trim3 = this.f71434a.nextToken().trim();
        if (!trim3.equals(str2)) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(str);
            stringBuffer2.append(":");
            stringBuffer2.append(trim3);
            return stringBuffer2.toString();
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(str);
        stringBuffer3.append(":");
        String stringBuffer4 = stringBuffer3.toString();
        this.f71435b = trim3;
        return stringBuffer4;
    }
}
