package org.apache.tools.ant.taskdefs;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.ComponentHelper;
import org.apache.tools.ant.r;

/* loaded from: classes7.dex */
public abstract class e extends c {

    /* renamed from: w, reason: collision with root package name */
    private static b f71476w = new b(null);

    /* renamed from: k, reason: collision with root package name */
    private String f71477k;

    /* renamed from: l, reason: collision with root package name */
    private String f71478l;

    /* renamed from: m, reason: collision with root package name */
    private File f71479m;

    /* renamed from: n, reason: collision with root package name */
    private String f71480n;

    /* renamed from: o, reason: collision with root package name */
    private int f71481o = 0;

    /* renamed from: p, reason: collision with root package name */
    private boolean f71482p = false;

    /* renamed from: q, reason: collision with root package name */
    private int f71483q = 0;

    /* renamed from: r, reason: collision with root package name */
    private String f71484r;

    /* renamed from: s, reason: collision with root package name */
    private String f71485s;

    /* renamed from: t, reason: collision with root package name */
    private Class f71486t;

    /* renamed from: u, reason: collision with root package name */
    private Class f71487u;

    /* loaded from: classes7.dex */
    public static class a extends org.apache.tools.ant.types.f {
        public a() {
        }

        public a(String str) {
            e(str);
        }

        @Override // org.apache.tools.ant.types.f
        public String[] c() {
            return new String[]{"fail", "report", "ignore", "failall"};
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class b extends ThreadLocal {
        private b() {
        }

        /* synthetic */ b(d dVar) {
            this();
        }

        Map a() {
            return (Map) get();
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return new HashMap();
        }
    }

    private URL A() {
        String str;
        if (this.f71479m.exists()) {
            str = null;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("File ");
            stringBuffer.append(this.f71479m);
            stringBuffer.append(" does not exist");
            str = stringBuffer.toString();
        }
        if (str == null && !this.f71479m.isFile()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("File ");
            stringBuffer2.append(this.f71479m);
            stringBuffer2.append(" is not a file");
            str = stringBuffer2.toString();
        }
        if (str == null) {
            try {
                return this.f71479m.toURL();
            } catch (Exception e11) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("File ");
                stringBuffer3.append(this.f71479m);
                stringBuffer3.append(" cannot use as URL: ");
                stringBuffer3.append(e11.toString());
                str = stringBuffer3.toString();
            }
        }
        int i11 = this.f71483q;
        if (i11 == 0 || i11 == 1) {
            log(str, 1);
        } else if (i11 == 2) {
            log(str, 3);
        } else if (i11 == 3) {
            throw new BuildException(str);
        }
        return null;
    }

    private void B(ClassLoader classLoader, URL url) {
        try {
            org.apache.tools.ant.taskdefs.a u11 = org.apache.tools.ant.taskdefs.a.u(getProject(), url, u());
            u11.w(classLoader);
            u11.x(u());
            u11.e();
        } catch (BuildException e11) {
            throw r.a(e11, getLocation());
        }
    }

    public static String D(String str) {
        String substring = str.substring(7);
        if (!substring.startsWith("//")) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(substring.replace('.', '/'));
            stringBuffer.append("/antlib.xml");
            return stringBuffer.toString();
        }
        String substring2 = substring.substring(2);
        if (substring2.endsWith(".xml")) {
            return substring2;
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(substring2);
        stringBuffer2.append("/antlib.xml");
        return stringBuffer2.toString();
    }

    private Enumeration E(ClassLoader classLoader) {
        try {
            Enumeration<URL> resources = classLoader.getResources(this.f71480n);
            if (!resources.hasMoreElements()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not load definitions from resource ");
                stringBuffer.append(this.f71480n);
                stringBuffer.append(". It could not be found.");
                String stringBuffer2 = stringBuffer.toString();
                int i11 = this.f71483q;
                if (i11 == 0 || i11 == 1) {
                    log(stringBuffer2, 1);
                } else if (i11 == 2) {
                    log(stringBuffer2, 3);
                } else if (i11 == 3) {
                    throw new BuildException(stringBuffer2);
                }
            }
            return resources;
        } catch (IOException e11) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not fetch resources named ");
            stringBuffer3.append(this.f71480n);
            throw new BuildException(stringBuffer3.toString(), e11, getLocation());
        }
    }

    private void H() {
        throw new BuildException("Only one of the attributes name, file and resource can be set", getLocation());
    }

    protected void C(ClassLoader classLoader, URL url) {
        try {
            try {
                InputStream openStream = FirebasePerfUrlConnection.openStream(url);
                if (openStream == null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Could not load definitions from ");
                    stringBuffer.append(url);
                    log(stringBuffer.toString(), 1);
                    org.apache.tools.ant.util.d.b(openStream);
                    return;
                }
                Properties properties = new Properties();
                properties.load(openStream);
                Enumeration keys = properties.keys();
                while (keys.hasMoreElements()) {
                    String str = (String) keys.nextElement();
                    this.f71477k = str;
                    String property = properties.getProperty(str);
                    this.f71478l = property;
                    z(classLoader, this.f71477k, property);
                }
                org.apache.tools.ant.util.d.b(openStream);
            } catch (IOException e11) {
                throw new BuildException(e11, getLocation());
            }
        } catch (Throwable th2) {
            org.apache.tools.ant.util.d.b(null);
            throw th2;
        }
    }

    public void F(a aVar) {
        this.f71483q = aVar.a();
    }

    public void G(String str) {
        if (this.f71482p) {
            H();
        }
        this.f71482p = true;
        this.f71480n = str;
    }

    @Override // org.apache.tools.ant.u
    public void e() {
        Enumeration E;
        ClassLoader x10 = x();
        if (!this.f71482p) {
            if (u() == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("name, file or resource attribute of ");
                stringBuffer.append(i());
                stringBuffer.append(" is undefined");
                throw new BuildException(stringBuffer.toString(), getLocation());
            }
            if (!u().startsWith("antlib:")) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Only antlib URIs can be located from the URI alone,not the URI ");
                stringBuffer2.append(u());
                throw new BuildException(stringBuffer2.toString());
            }
            G(D(u()));
        }
        String str = this.f71477k;
        if (str != null) {
            String str2 = this.f71478l;
            if (str2 != null) {
                z(x10, str, str2);
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("classname attribute of ");
            stringBuffer3.append(i());
            stringBuffer3.append(" element ");
            stringBuffer3.append("is undefined");
            throw new BuildException(stringBuffer3.toString(), getLocation());
        }
        if (this.f71478l != null) {
            throw new BuildException("You must not specify classname together with file or resource.", getLocation());
        }
        if (this.f71479m != null) {
            URL A = A();
            if (A == null) {
                return;
            } else {
                E = new d(this, A);
            }
        } else {
            E = E(x10);
        }
        while (E.hasMoreElements()) {
            URL url = (URL) E.nextElement();
            int i11 = this.f71481o;
            if (url.toString().toLowerCase(Locale.US).endsWith(".xml")) {
                i11 = 1;
            }
            if (i11 == 0) {
                C(x10, url);
                return;
            }
            if (f71476w.a().get(url) != null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("Warning: Recursive loading of ");
                stringBuffer4.append(url);
                stringBuffer4.append(" ignored");
                stringBuffer4.append(" at ");
                stringBuffer4.append(getLocation());
                stringBuffer4.append(" originally loaded at ");
                stringBuffer4.append(f71476w.a().get(url));
                log(stringBuffer4.toString(), 1);
            } else {
                try {
                    f71476w.a().put(url, getLocation());
                    B(x10, url);
                } finally {
                    f71476w.a().remove(url);
                }
            }
        }
    }

    protected void z(ClassLoader classLoader, String str, String str2) {
        try {
            try {
                String e11 = r.e(u(), str);
                Class<?> cls = this.f71483q != 2 ? Class.forName(str2, true, classLoader) : null;
                String str3 = this.f71484r;
                if (str3 != null) {
                    this.f71486t = Class.forName(str3, true, classLoader);
                }
                String str4 = this.f71485s;
                if (str4 != null) {
                    this.f71487u = Class.forName(str4, true, classLoader);
                }
                org.apache.tools.ant.b bVar = new org.apache.tools.ant.b();
                bVar.t(e11);
                bVar.s(str2);
                bVar.q(cls);
                bVar.p(this.f71486t);
                bVar.o(this.f71487u);
                bVar.r(classLoader);
                if (cls != null) {
                    bVar.a(getProject());
                }
                ComponentHelper.j(getProject()).a(bVar);
            } catch (ClassNotFoundException e12) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(i());
                stringBuffer.append(" class ");
                stringBuffer.append(str2);
                stringBuffer.append(" cannot be found");
                throw new BuildException(stringBuffer.toString(), e12, getLocation());
            } catch (NoClassDefFoundError e13) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(i());
                stringBuffer2.append(" A class needed by class ");
                stringBuffer2.append(str2);
                stringBuffer2.append(" cannot be found: ");
                stringBuffer2.append(e13.getMessage());
                throw new BuildException(stringBuffer2.toString(), e13, getLocation());
            }
        } catch (BuildException e14) {
            int i11 = this.f71483q;
            if (i11 != 0) {
                if (i11 == 1) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(e14.getLocation());
                    stringBuffer3.append("Warning: ");
                    stringBuffer3.append(e14.getMessage());
                    log(stringBuffer3.toString(), 1);
                    return;
                }
                if (i11 != 3) {
                    StringBuffer stringBuffer4 = new StringBuffer();
                    stringBuffer4.append(e14.getLocation());
                    stringBuffer4.append(e14.getMessage());
                    log(stringBuffer4.toString(), 4);
                    return;
                }
            }
            throw e14;
        }
    }
}
