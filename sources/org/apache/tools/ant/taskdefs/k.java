package org.apache.tools.ant.taskdefs;

import com.aliyun.player.BuildConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private String f71519a;

    /* renamed from: b, reason: collision with root package name */
    private b f71520b = new b();

    /* renamed from: c, reason: collision with root package name */
    private Hashtable f71521c = new Hashtable();

    /* renamed from: d, reason: collision with root package name */
    private Vector f71522d = new Vector();

    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private String f71523a;

        /* renamed from: b, reason: collision with root package name */
        private Vector f71524b;

        /* renamed from: c, reason: collision with root package name */
        private int f71525c;

        public a() {
            this.f71523a = null;
            this.f71524b = new Vector();
            this.f71525c = 0;
        }

        public a(String str) {
            this.f71523a = null;
            this.f71524b = new Vector();
            this.f71525c = 0;
            g(str);
        }

        public a(String str, String str2) {
            this.f71523a = null;
            this.f71524b = new Vector();
            this.f71525c = 0;
            this.f71523a = str;
            h(str2);
        }

        private void j(PrintWriter printWriter, String str) {
            String stringBuffer;
            int length = this.f71523a.getBytes("UTF-8").length;
            if (length <= 68) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(this.f71523a);
                stringBuffer2.append(": ");
                stringBuffer2.append(str);
                stringBuffer = stringBuffer2.toString();
            } else {
                if (length > 70) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Unable to write manifest line ");
                    stringBuffer3.append(this.f71523a);
                    stringBuffer3.append(": ");
                    stringBuffer3.append(str);
                    throw new IOException(stringBuffer3.toString());
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.f71523a);
                stringBuffer4.append(": ");
                stringBuffer4.append("\r\n");
                printWriter.print(stringBuffer4.toString());
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append(" ");
                stringBuffer5.append(str);
                stringBuffer = stringBuffer5.toString();
            }
            while (stringBuffer.getBytes("UTF-8").length > 70) {
                int length2 = 70 >= stringBuffer.length() ? stringBuffer.length() - 1 : 70;
                String substring = stringBuffer.substring(0, length2);
                while (substring.getBytes("UTF-8").length > 70 && length2 > 0) {
                    length2--;
                    substring = stringBuffer.substring(0, length2);
                }
                if (length2 == 0) {
                    StringBuffer stringBuffer6 = new StringBuffer();
                    stringBuffer6.append("Unable to write manifest line ");
                    stringBuffer6.append(this.f71523a);
                    stringBuffer6.append(": ");
                    stringBuffer6.append(str);
                    throw new IOException(stringBuffer6.toString());
                }
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append(substring);
                stringBuffer7.append("\r\n");
                printWriter.print(stringBuffer7.toString());
                StringBuffer stringBuffer8 = new StringBuffer();
                stringBuffer8.append(" ");
                stringBuffer8.append(stringBuffer.substring(length2));
                stringBuffer = stringBuffer8.toString();
            }
            StringBuffer stringBuffer9 = new StringBuffer();
            stringBuffer9.append(stringBuffer);
            stringBuffer9.append("\r\n");
            printWriter.print(stringBuffer9.toString());
        }

        public void a(String str) {
            String str2 = (String) this.f71524b.elementAt(this.f71525c);
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2);
            stringBuffer.append(str.substring(1));
            h(stringBuffer.toString());
        }

        public void b(String str) {
            this.f71525c++;
            h(str);
        }

        public String c() {
            String str = this.f71523a;
            if (str == null) {
                return null;
            }
            return str.toLowerCase();
        }

        public String d() {
            return this.f71523a;
        }

        public String e() {
            if (this.f71524b.size() == 0) {
                return null;
            }
            Enumeration f11 = f();
            String str = "";
            while (f11.hasMoreElements()) {
                String str2 = (String) f11.nextElement();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(str);
                stringBuffer.append(str2);
                stringBuffer.append(" ");
                str = stringBuffer.toString();
            }
            return str.trim();
        }

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            a aVar = (a) obj;
            String c11 = c();
            String c12 = aVar.c();
            if ((c11 != null || c12 == null) && (c11 == null || c11.equals(c12))) {
                return this.f71524b.equals(aVar.f71524b);
            }
            return false;
        }

        public Enumeration f() {
            return this.f71524b.elements();
        }

        public void g(String str) {
            int indexOf = str.indexOf(": ");
            if (indexOf != -1) {
                this.f71523a = str.substring(0, indexOf);
                h(str.substring(indexOf + 2));
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Manifest line \"");
            stringBuffer.append(str);
            stringBuffer.append("\" is not valid as it does not ");
            stringBuffer.append("contain a name and a value separated by ': ' ");
            throw new ManifestException(stringBuffer.toString());
        }

        public void h(String str) {
            if (this.f71525c < this.f71524b.size()) {
                this.f71524b.setElementAt(str, this.f71525c);
            } else {
                this.f71524b.addElement(str);
                this.f71525c = this.f71524b.size() - 1;
            }
        }

        public int hashCode() {
            return (this.f71523a != null ? c().hashCode() : 0) + this.f71524b.hashCode();
        }

        public void i(PrintWriter printWriter) {
            Enumeration f11 = f();
            while (f11.hasMoreElements()) {
                j(printWriter, (String) f11.nextElement());
            }
        }
    }

    /* loaded from: classes7.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private Vector f71526a = new Vector();

        /* renamed from: b, reason: collision with root package name */
        private String f71527b = null;

        /* renamed from: c, reason: collision with root package name */
        private Hashtable f71528c = new Hashtable();

        /* renamed from: d, reason: collision with root package name */
        private Vector f71529d = new Vector();

        private void j(a aVar) {
            if (aVar == null) {
                return;
            }
            String c11 = aVar.c();
            this.f71528c.put(c11, aVar);
            if (this.f71529d.contains(c11)) {
                return;
            }
            this.f71529d.addElement(c11);
        }

        public String a(a aVar) {
            if (aVar.d() == null || aVar.e() == null) {
                throw new BuildException("Attributes must have name and value");
            }
            if (aVar.c().equalsIgnoreCase("Name")) {
                Vector vector = this.f71526a;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("\"Name\" attributes should not occur in the main section and must be the first element in all other sections: \"");
                stringBuffer.append(aVar.d());
                stringBuffer.append(": ");
                stringBuffer.append(aVar.e());
                stringBuffer.append("\"");
                vector.addElement(stringBuffer.toString());
                return aVar.e();
            }
            if (aVar.c().startsWith("From".toLowerCase())) {
                Vector vector2 = this.f71526a;
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Manifest attributes should not start with \"From\" in \"");
                stringBuffer2.append(aVar.d());
                stringBuffer2.append(": ");
                stringBuffer2.append(aVar.e());
                stringBuffer2.append("\"");
                vector2.addElement(stringBuffer2.toString());
                return null;
            }
            String c11 = aVar.c();
            if (c11.equalsIgnoreCase("Class-Path")) {
                a aVar2 = (a) this.f71528c.get(c11);
                if (aVar2 == null) {
                    j(aVar);
                    return null;
                }
                this.f71526a.addElement("Multiple Class-Path attributes are supported but violate the Jar specification and may not be correctly processed in all environments");
                Enumeration f11 = aVar.f();
                while (f11.hasMoreElements()) {
                    aVar2.b((String) f11.nextElement());
                }
                return null;
            }
            if (!this.f71528c.containsKey(c11)) {
                j(aVar);
                return null;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("The attribute \"");
            stringBuffer3.append(aVar.d());
            stringBuffer3.append("\" may not occur more ");
            stringBuffer3.append("than once in the same section");
            throw new ManifestException(stringBuffer3.toString());
        }

        public void b(a aVar) {
            if (a(aVar) != null) {
                throw new BuildException("Specify the section name using the \"name\" attribute of the <section> element rather than using a \"Name\" manifest attribute");
            }
        }

        public a c(String str) {
            return (a) this.f71528c.get(str.toLowerCase());
        }

        public Object clone() {
            b bVar = new b();
            bVar.i(this.f71527b);
            Enumeration d11 = d();
            while (d11.hasMoreElements()) {
                a c11 = c((String) d11.nextElement());
                bVar.j(new a(c11.d(), c11.e()));
            }
            return bVar;
        }

        public Enumeration d() {
            return this.f71529d.elements();
        }

        public String e(String str) {
            a c11 = c(str.toLowerCase());
            if (c11 == null) {
                return null;
            }
            return c11.e();
        }

        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            return this.f71528c.equals(((b) obj).f71528c);
        }

        public String f() {
            return this.f71527b;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String g(java.io.BufferedReader r6) {
            /*
                r5 = this;
                r0 = 0
                r1 = r0
            L2:
                java.lang.String r2 = r6.readLine()
                if (r2 == 0) goto L66
                int r3 = r2.length()
                if (r3 != 0) goto Lf
                goto L66
            Lf:
                r3 = 0
                char r3 = r2.charAt(r3)
                r4 = 32
                if (r3 != r4) goto L52
                if (r1 != 0) goto L4e
                java.lang.String r3 = r5.f71527b
                if (r3 == 0) goto L37
                java.lang.StringBuffer r3 = new java.lang.StringBuffer
                r3.<init>()
                java.lang.String r4 = r5.f71527b
                r3.append(r4)
                r4 = 1
                java.lang.String r2 = r2.substring(r4)
                r3.append(r2)
                java.lang.String r2 = r3.toString()
                r5.f71527b = r2
                goto L2
            L37:
                org.apache.tools.ant.taskdefs.ManifestException r6 = new org.apache.tools.ant.taskdefs.ManifestException
                java.lang.StringBuffer r0 = new java.lang.StringBuffer
                r0.<init>()
                java.lang.String r1 = "Can't start an attribute with a continuation line "
                r0.append(r1)
                r0.append(r2)
                java.lang.String r0 = r0.toString()
                r6.<init>(r0)
                throw r6
            L4e:
                r1.a(r2)
                goto L2
            L52:
                org.apache.tools.ant.taskdefs.k$a r1 = new org.apache.tools.ant.taskdefs.k$a
                r1.<init>(r2)
                java.lang.String r2 = r5.a(r1)
                java.lang.String r1 = r1.c()
                org.apache.tools.ant.taskdefs.k$a r1 = r5.c(r1)
                if (r2 == 0) goto L2
                return r2
            L66:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.apache.tools.ant.taskdefs.k.b.g(java.io.BufferedReader):java.lang.String");
        }

        public void h(String str) {
            String lowerCase = str.toLowerCase();
            this.f71528c.remove(lowerCase);
            this.f71529d.removeElement(lowerCase);
        }

        public int hashCode() {
            return this.f71528c.hashCode();
        }

        public void i(String str) {
            this.f71527b = str;
        }

        public void k(PrintWriter printWriter) {
            String str = this.f71527b;
            if (str != null) {
                new a("Name", str).i(printWriter);
            }
            Enumeration d11 = d();
            while (d11.hasMoreElements()) {
                c((String) d11.nextElement()).i(printWriter);
            }
            printWriter.print("\r\n");
        }
    }

    public k() {
        this.f71519a = BuildConfig.VERSION_NAME;
        this.f71519a = null;
    }

    public k(Reader reader) {
        this.f71519a = BuildConfig.VERSION_NAME;
        BufferedReader bufferedReader = new BufferedReader(reader);
        String g11 = this.f71520b.g(bufferedReader);
        String e11 = this.f71520b.e("Manifest-Version");
        if (e11 != null) {
            this.f71519a = e11;
            this.f71520b.h("Manifest-Version");
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            if (readLine.length() != 0) {
                b bVar = new b();
                if (g11 == null) {
                    a aVar = new a(readLine);
                    if (!aVar.d().equalsIgnoreCase("Name")) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Manifest sections should start with a \"Name\" attribute and not \"");
                        stringBuffer.append(aVar.d());
                        stringBuffer.append("\"");
                        throw new ManifestException(stringBuffer.toString());
                    }
                    g11 = aVar.e();
                } else {
                    bVar.a(new a(readLine));
                }
                bVar.i(g11);
                g11 = bVar.g(bufferedReader);
                a(bVar);
            }
        }
    }

    public void a(b bVar) {
        String f11 = bVar.f();
        if (f11 == null) {
            throw new BuildException("Sections must have a name");
        }
        this.f71521c.put(f11, bVar);
        if (this.f71522d.contains(f11)) {
            return;
        }
        this.f71522d.addElement(f11);
    }

    public b b() {
        return this.f71520b;
    }

    public b c(String str) {
        return (b) this.f71521c.get(str);
    }

    public void d(PrintWriter printWriter) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Manifest-Version: ");
        stringBuffer.append(this.f71519a);
        stringBuffer.append("\r\n");
        printWriter.print(stringBuffer.toString());
        String e11 = this.f71520b.e("Signature-Version");
        if (e11 != null) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Signature-Version: ");
            stringBuffer2.append(e11);
            stringBuffer2.append("\r\n");
            printWriter.print(stringBuffer2.toString());
            this.f71520b.h("Signature-Version");
        }
        this.f71520b.k(printWriter);
        if (e11 != null) {
            try {
                this.f71520b.b(new a("Signature-Version", e11));
            } catch (ManifestException unused) {
            }
        }
        Enumeration elements = this.f71522d.elements();
        while (elements.hasMoreElements()) {
            c((String) elements.nextElement()).k(printWriter);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        k kVar = (k) obj;
        String str = this.f71519a;
        if (str == null) {
            if (kVar.f71519a != null) {
                return false;
            }
        } else if (!str.equals(kVar.f71519a)) {
            return false;
        }
        if (this.f71520b.equals(kVar.f71520b)) {
            return this.f71521c.equals(kVar.f71521c);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f71519a;
        return (str != null ? str.hashCode() : 0) + this.f71520b.hashCode() + this.f71521c.hashCode();
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        try {
            d(new PrintWriter(stringWriter));
            return stringWriter.toString();
        } catch (IOException unused) {
            return null;
        }
    }
}
