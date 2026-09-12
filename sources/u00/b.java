package u00;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.hisavana.common.tracking.TrackingKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Stack;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Location;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.RuntimeConfigurable;
import org.apache.tools.ant.r;
import org.apache.tools.ant.t;
import org.apache.tools.ant.u;
import org.apache.tools.ant.util.p;
import org.apache.tools.ant.w;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* loaded from: classes7.dex */
public class b extends r {

    /* renamed from: b, reason: collision with root package name */
    private static a f76664b = new C0961b();

    /* renamed from: c, reason: collision with root package name */
    private static a f76665c = new f();

    /* renamed from: d, reason: collision with root package name */
    private static a f76666d = new c();

    /* renamed from: e, reason: collision with root package name */
    private static a f76667e = new d();

    /* renamed from: f, reason: collision with root package name */
    private static final org.apache.tools.ant.util.d f76668f = org.apache.tools.ant.util.d.k();

    /* loaded from: classes7.dex */
    public static class a {
        public void a(char[] cArr, int i11, int i12, u00.a aVar) {
            String trim = new String(cArr, i11, i12).trim();
            if (trim.length() <= 0) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unexpected text \"");
            stringBuffer.append(trim);
            stringBuffer.append("\"");
            throw new SAXParseException(stringBuffer.toString(), aVar.k());
        }

        public void b(String str, String str2, String str3, u00.a aVar) {
        }

        public void c(String str, String str2, u00.a aVar) {
        }

        public a d(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unexpected element \"");
            stringBuffer.append(str3);
            stringBuffer.append(" \"");
            throw new SAXParseException(stringBuffer.toString(), aVar.k());
        }

        public void e(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
        }
    }

    /* renamed from: u00.b$b, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0961b extends a {
        @Override // u00.b.a
        public void a(char[] cArr, int i11, int i12, u00.a aVar) {
            aVar.c().addText(cArr, i11, i12);
        }

        @Override // u00.b.a
        public void c(String str, String str2, u00.a aVar) {
            aVar.o();
        }

        @Override // u00.b.a
        public a d(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            return b.f76664b;
        }

        @Override // u00.b.a
        public void e(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            RuntimeConfigurable c11 = aVar.c();
            Object proxy = c11 != null ? c11.getProxy() : null;
            w wVar = new w(str2);
            wVar.setProject(aVar.m());
            wVar.G(str);
            wVar.H(str3);
            wVar.s(r.e(wVar.x(), str2));
            wVar.r(str3);
            wVar.setLocation(new Location(aVar.k().getSystemId(), aVar.k().getLineNumber(), aVar.k().getColumnNumber()));
            wVar.p(aVar.h());
            if (proxy != null) {
                ((w) proxy).t(wVar);
            } else {
                aVar.h().b(wVar);
            }
            aVar.b(wVar, attributes);
            RuntimeConfigurable runtimeConfigurable = new RuntimeConfigurable(wVar, wVar.i());
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                String localName = attributes.getLocalName(i11);
                String uri = attributes.getURI(i11);
                if (uri != null && !uri.equals("") && !uri.equals(str)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(uri);
                    stringBuffer.append(":");
                    stringBuffer.append(attributes.getQName(i11));
                    localName = stringBuffer.toString();
                }
                String value = attributes.getValue(i11);
                if ("ant-type".equals(localName) || ("antlib:org.apache.tools.ant".equals(uri) && "ant-type".equals(attributes.getLocalName(i11)))) {
                    Project m11 = aVar.m();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("WARNING: the ant-type mechanism has been deprecated");
                    stringBuffer2.append(p.f71726a);
                    stringBuffer2.append("         and");
                    stringBuffer2.append(" will not be available in Ant 1.8.0 or higher");
                    m11.x(stringBuffer2.toString(), 1);
                    int indexOf = value.indexOf(":");
                    if (indexOf >= 0) {
                        String substring = value.substring(0, indexOf);
                        String l11 = aVar.l(substring);
                        if (l11 == null) {
                            StringBuffer stringBuffer3 = new StringBuffer();
                            stringBuffer3.append("Unable to find XML NS prefix \"");
                            stringBuffer3.append(substring);
                            stringBuffer3.append("\"");
                            throw new BuildException(stringBuffer3.toString());
                        }
                        value = r.e(l11, value.substring(indexOf + 1));
                    }
                    localName = "ant-type";
                }
                runtimeConfigurable.setAttribute(localName, value);
            }
            if (c11 != null) {
                c11.addChild(runtimeConfigurable);
            }
            aVar.p(runtimeConfigurable);
        }
    }

    /* loaded from: classes7.dex */
    public static class c extends a {
        @Override // u00.b.a
        public a d(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            if (str2.equals("project") && (str.equals("") || str.equals("antlib:org.apache.tools.ant"))) {
                return b.f76667e;
            }
            if (!str2.equals(str3)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unexpected element \"");
                stringBuffer.append(str3);
                stringBuffer.append("\" ");
                stringBuffer.append(str2);
                throw new SAXParseException(stringBuffer.toString(), aVar.k());
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Unexpected element \"{");
            stringBuffer2.append(str);
            stringBuffer2.append("}");
            stringBuffer2.append(str2);
            stringBuffer2.append("\" {");
            stringBuffer2.append("antlib:org.apache.tools.ant");
            stringBuffer2.append("}");
            stringBuffer2.append(str2);
            throw new SAXParseException(stringBuffer2.toString(), aVar.k());
        }
    }

    /* loaded from: classes7.dex */
    public static class d extends a {
        @Override // u00.b.a
        public a d(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            return (str2.equals("target") && (str.equals("") || str.equals("antlib:org.apache.tools.ant"))) ? b.f76665c : b.f76664b;
        }

        @Override // u00.b.a
        public void e(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            Project m11 = aVar.m();
            aVar.j().k(new Location(aVar.k()));
            String str4 = null;
            boolean z10 = false;
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                String uri = attributes.getURI(i11);
                if (uri == null || uri.equals("") || uri.equals(str)) {
                    String localName = attributes.getLocalName(i11);
                    String value = attributes.getValue(i11);
                    if (localName.equals("default")) {
                        if (value != null && !value.equals("") && !aVar.n()) {
                            m11.H(value);
                        }
                    } else if (localName.equals("name")) {
                        if (value != null) {
                            aVar.r(value);
                            if (!aVar.n()) {
                                m11.I(value);
                                m11.d(value, m11);
                            }
                            z10 = true;
                        }
                    } else if (!localName.equals("id")) {
                        if (!localName.equals("basedir")) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Unexpected attribute \"");
                            stringBuffer.append(attributes.getQName(i11));
                            stringBuffer.append("\"");
                            throw new SAXParseException(stringBuffer.toString(), aVar.k());
                        }
                        if (!aVar.n()) {
                            str4 = value;
                        }
                    } else if (value != null && !aVar.n()) {
                        m11.d(value, m11);
                    }
                }
            }
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("ant.file.");
            stringBuffer2.append(aVar.g());
            String s11 = m11.s(stringBuffer2.toString());
            if (s11 != null && z10) {
                File file = new File(s11);
                if (aVar.n() && !file.equals(aVar.e())) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("Duplicated project name in import. Project ");
                    stringBuffer3.append(aVar.g());
                    stringBuffer3.append(" defined first in ");
                    stringBuffer3.append(s11);
                    stringBuffer3.append(" and again in ");
                    stringBuffer3.append(aVar.e());
                    m11.x(stringBuffer3.toString(), 1);
                }
            }
            if (aVar.e() != null && z10) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("ant.file.");
                stringBuffer4.append(aVar.g());
                m11.M(stringBuffer4.toString(), aVar.e().toString());
            }
            if (aVar.n()) {
                return;
            }
            if (m11.s("basedir") != null) {
                m11.G(m11.s("basedir"));
            } else if (str4 == null) {
                m11.G(aVar.f().getAbsolutePath());
            } else if (new File(str4).isAbsolute()) {
                m11.G(str4);
            } else {
                m11.F(b.f76668f.q(aVar.f(), str4));
            }
            m11.e("", aVar.j());
            aVar.s(aVar.j());
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends DefaultHandler {

        /* renamed from: a, reason: collision with root package name */
        private Stack f76669a;

        /* renamed from: b, reason: collision with root package name */
        private a f76670b;

        /* renamed from: c, reason: collision with root package name */
        private u00.a f76671c;

        public e(u00.a aVar, a aVar2) {
            Stack stack = new Stack();
            this.f76669a = stack;
            this.f76670b = aVar2;
            stack.push(aVar2);
            this.f76671c = aVar;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i11, int i12) {
            this.f76670b.a(cArr, i11, i12, this.f76671c);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) {
            this.f76670b.c(str, str2, this.f76671c);
            a aVar = (a) this.f76669a.pop();
            this.f76670b = aVar;
            if (aVar != null) {
                aVar.b(str, str2, str3, this.f76671c);
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
            this.f76671c.d(str);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.EntityResolver
        public InputSource resolveEntity(String str, String str2) {
            Project m11 = this.f76671c.m();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("resolving systemId: ");
            stringBuffer.append(str2);
            m11.x(stringBuffer.toString(), 3);
            if (str2.startsWith("file:")) {
                String i11 = b.f76668f.i(str2);
                File file = new File(i11);
                if (!file.isAbsolute()) {
                    file = b.f76668f.q(this.f76671c.f(), i11);
                    Project m12 = this.f76671c.m();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Warning: '");
                    stringBuffer2.append(str2);
                    stringBuffer2.append("' in ");
                    stringBuffer2.append(this.f76671c.e());
                    stringBuffer2.append(" should be expressed simply as '");
                    stringBuffer2.append(i11.replace('\\', '/'));
                    stringBuffer2.append("' for compliance with other XML tools");
                    m12.x(stringBuffer2.toString(), 1);
                }
                Project m13 = this.f76671c.m();
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("file=");
                stringBuffer3.append(file);
                m13.x(stringBuffer3.toString(), 4);
                try {
                    InputSource inputSource = new InputSource(new FileInputStream(file));
                    inputSource.setSystemId(b.f76668f.r(file.getAbsolutePath()));
                    return inputSource;
                } catch (FileNotFoundException unused) {
                    Project m14 = this.f76671c.m();
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(file.getAbsolutePath());
                    stringBuffer4.append(" could not be found");
                    m14.x(stringBuffer4.toString(), 1);
                }
            }
            this.f76671c.m().x("could not resolve systemId", 4);
            return null;
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
            this.f76671c.u(locator);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) {
            a d11 = this.f76670b.d(str, str2, str3, attributes, this.f76671c);
            this.f76669a.push(this.f76670b);
            this.f76670b = d11;
            d11.e(str, str2, str3, attributes, this.f76671c);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
            this.f76671c.v(str, str2);
        }
    }

    /* loaded from: classes7.dex */
    public static class f extends a {
        @Override // u00.b.a
        public void c(String str, String str2, u00.a aVar) {
            aVar.s(aVar.j());
        }

        @Override // u00.b.a
        public a d(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            return b.f76664b;
        }

        @Override // u00.b.a
        public void e(String str, String str2, String str3, Attributes attributes, u00.a aVar) {
            Project m11 = aVar.m();
            t tVar = new t();
            tVar.m(m11);
            tVar.k(new Location(aVar.k()));
            aVar.a(tVar);
            String str4 = null;
            boolean z10 = false;
            String str5 = "";
            for (int i11 = 0; i11 < attributes.getLength(); i11++) {
                String uri = attributes.getURI(i11);
                if (uri == null || uri.equals("") || uri.equals(str)) {
                    String localName = attributes.getLocalName(i11);
                    String value = attributes.getValue(i11);
                    if (localName.equals("name")) {
                        if ("".equals(value)) {
                            throw new BuildException("name attribute must not be empty");
                        }
                        str4 = value;
                    } else if (localName.equals("depends")) {
                        str5 = value;
                    } else if (localName.equals("if")) {
                        tVar.j(value);
                    } else if (localName.equals("unless")) {
                        tVar.n(value);
                    } else if (!localName.equals("id")) {
                        if (!localName.equals(TrackingKey.DESCRIPTION)) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Unexpected attribute \"");
                            stringBuffer.append(localName);
                            stringBuffer.append("\"");
                            throw new SAXParseException(stringBuffer.toString(), aVar.k());
                        }
                        tVar.i(value);
                    } else if (value != null && !value.equals("")) {
                        aVar.m().d(value, tVar);
                    }
                }
            }
            if (str4 == null) {
                throw new SAXParseException("target element appears without a name attribute", aVar.k());
            }
            if (aVar.i().get(str4) != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Duplicate target '");
                stringBuffer2.append(str4);
                stringBuffer2.append("'");
                throw new BuildException(stringBuffer2.toString(), tVar.c());
            }
            if (m11.u().containsKey(str4)) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("Already defined in main or a previous import, ignore ");
                stringBuffer3.append(str4);
                m11.x(stringBuffer3.toString(), 3);
            } else {
                tVar.l(str4);
                aVar.i().put(str4, tVar);
                m11.c(str4, tVar);
                z10 = true;
            }
            if (str5.length() > 0) {
                tVar.h(str5);
            }
            if (!aVar.n() || aVar.g() == null || aVar.g().length() == 0) {
                return;
            }
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append(aVar.g());
            stringBuffer4.append(".");
            stringBuffer4.append(str4);
            String stringBuffer5 = stringBuffer4.toString();
            if (z10) {
                tVar = new t(tVar);
            }
            tVar.l(stringBuffer5);
            aVar.i().put(stringBuffer5, tVar);
            m11.c(stringBuffer5, tVar);
        }
    }

    public void j(Project project, Object obj, e eVar) {
        String url;
        URL url2;
        File file;
        String url3;
        u00.a aVar = eVar.f76671c;
        InputStream inputStream = null;
        if (obj instanceof File) {
            file = f76668f.o(((File) obj).getAbsolutePath());
            aVar.q(file);
            url = file.toString();
            url2 = null;
        } else {
            if (!(obj instanceof URL)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Source ");
                stringBuffer.append(obj.getClass().getName());
                stringBuffer.append(" not supported by this plugin");
                throw new BuildException(stringBuffer.toString());
            }
            URL url4 = (URL) obj;
            url = url4.toString();
            url2 = url4;
            file = null;
        }
        try {
            try {
                try {
                    try {
                        try {
                            try {
                                XMLReader c11 = org.apache.tools.ant.util.e.c();
                                if (file != null) {
                                    url3 = f76668f.r(file.getAbsolutePath());
                                    inputStream = new FileInputStream(file);
                                } else {
                                    inputStream = FirebasePerfUrlConnection.openStream(url2);
                                    url3 = url2.toString();
                                }
                                InputSource inputSource = new InputSource(inputStream);
                                if (url3 != null) {
                                    inputSource.setSystemId(url3);
                                }
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("parsing buildfile ");
                                stringBuffer2.append(url);
                                stringBuffer2.append(" with URI = ");
                                stringBuffer2.append(url3);
                                project.x(stringBuffer2.toString(), 3);
                                c11.setContentHandler(eVar);
                                c11.setEntityResolver(eVar);
                                c11.setErrorHandler(eVar);
                                c11.setDTDHandler(eVar);
                                c11.parse(inputSource);
                                org.apache.tools.ant.util.d.b(inputStream);
                            } catch (UnsupportedEncodingException e11) {
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("Encoding of project file ");
                                stringBuffer3.append(url);
                                stringBuffer3.append(" is invalid.");
                                throw new BuildException(stringBuffer3.toString(), e11);
                            }
                        } catch (IOException e12) {
                            StringBuffer stringBuffer4 = new StringBuffer();
                            stringBuffer4.append("Error reading project file ");
                            stringBuffer4.append(url);
                            stringBuffer4.append(": ");
                            stringBuffer4.append(e12.getMessage());
                            throw new BuildException(stringBuffer4.toString(), e12);
                        }
                    } catch (SAXParseException e13) {
                        e = e13;
                        Location location = new Location(e.getSystemId(), e.getLineNumber(), e.getColumnNumber());
                        Exception exception = e.getException();
                        if (!(exception instanceof BuildException)) {
                            String message = e.getMessage();
                            if (exception != null) {
                                e = exception;
                            }
                            throw new BuildException(message, e, location);
                        }
                        BuildException buildException = (BuildException) exception;
                        if (buildException.getLocation() != Location.UNKNOWN_LOCATION) {
                            throw buildException;
                        }
                        buildException.setLocation(location);
                        throw buildException;
                    }
                } catch (SAXException e14) {
                    e = e14;
                    Exception exception2 = e.getException();
                    if (exception2 instanceof BuildException) {
                        throw ((BuildException) exception2);
                    }
                    String message2 = e.getMessage();
                    if (exception2 != null) {
                        e = exception2;
                    }
                    throw new BuildException(message2, e);
                }
            } catch (FileNotFoundException e15) {
                throw new BuildException(e15);
            }
        } catch (Throwable th2) {
            org.apache.tools.ant.util.d.b(inputStream);
            throw th2;
        }
    }

    public w k(Project project, URL url) {
        t tVar = new t();
        tVar.m(project);
        u00.a aVar = new u00.a(project);
        aVar.a(tVar);
        aVar.t(tVar);
        j(aVar.m(), url, new e(aVar, f76664b));
        u[] f11 = tVar.f();
        if (f11.length == 1) {
            return (w) f11[0];
        }
        throw new BuildException("No tasks defined");
    }
}
