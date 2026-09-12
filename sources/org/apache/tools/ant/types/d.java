package org.apache.tools.ant.types;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Properties;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.types.c;
import org.apache.tools.ant.types.g;
import org.apache.tools.ant.types.q;

/* loaded from: classes7.dex */
public class d implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    private String f71582f;

    /* renamed from: a, reason: collision with root package name */
    private c f71577a = new c();

    /* renamed from: b, reason: collision with root package name */
    private c f71578b = new c();

    /* renamed from: c, reason: collision with root package name */
    private a f71579c = new a();

    /* renamed from: d, reason: collision with root package name */
    private m f71580d = null;

    /* renamed from: e, reason: collision with root package name */
    private m f71581e = null;

    /* renamed from: g, reason: collision with root package name */
    private String f71583g = null;

    /* renamed from: h, reason: collision with root package name */
    private b f71584h = null;

    /* renamed from: i, reason: collision with root package name */
    private boolean f71585i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f71586j = false;

    /* loaded from: classes7.dex */
    public static class a extends g implements Cloneable {

        /* renamed from: b, reason: collision with root package name */
        Properties f71587b = null;

        /* renamed from: c, reason: collision with root package name */
        private Vector f71588c = new Vector();

        private Properties e() {
            Properties properties = new Properties();
            Enumeration elements = this.f71588c.elements();
            while (elements.hasMoreElements()) {
                properties.putAll(((q) elements.nextElement()).m());
            }
            return properties;
        }

        public void b(ListIterator listIterator) {
            String[] a11 = super.a();
            if (a11 != null) {
                for (String str : a11) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("-D");
                    stringBuffer.append(str);
                    listIterator.add(stringBuffer.toString());
                }
            }
            Properties e11 = e();
            Enumeration keys = e11.keys();
            while (keys.hasMoreElements()) {
                String str2 = (String) keys.nextElement();
                String property = e11.getProperty(str2);
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("-D");
                stringBuffer2.append(str2);
                stringBuffer2.append(UrlUtils.EQUAL_MARK);
                stringBuffer2.append(property);
                listIterator.add(stringBuffer2.toString());
            }
        }

        public void c(a aVar) {
            this.f71591a.addAll(aVar.f71591a);
            this.f71588c.addAll(aVar.f71588c);
        }

        public Object clone() {
            try {
                a aVar = (a) super.clone();
                aVar.f71591a = (Vector) this.f71591a.clone();
                aVar.f71588c = (Vector) this.f71588c.clone();
                return aVar;
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public void d(q qVar) {
            this.f71588c.addElement(qVar);
        }

        public void f() {
            Properties properties = this.f71587b;
            if (properties == null) {
                throw new BuildException("Unbalanced nesting of SysProperties");
            }
            try {
                System.setProperties(properties);
                this.f71587b = null;
            } catch (SecurityException e11) {
                throw new BuildException("Cannot modify system properties", e11);
            }
        }

        public void g() {
            try {
                this.f71587b = System.getProperties();
                Properties properties = new Properties();
                Enumeration<?> propertyNames = this.f71587b.propertyNames();
                while (propertyNames.hasMoreElements()) {
                    String str = (String) propertyNames.nextElement();
                    properties.put(str, this.f71587b.getProperty(str));
                }
                properties.putAll(e());
                Enumeration elements = this.f71591a.elements();
                while (elements.hasMoreElements()) {
                    g.a aVar = (g.a) elements.nextElement();
                    aVar.d();
                    properties.put(aVar.b(), aVar.c());
                }
                System.setProperties(properties);
            } catch (SecurityException e11) {
                throw new BuildException("Cannot modify system properties", e11);
            }
        }
    }

    public d() {
        n(org.apache.tools.ant.util.f.g("java"));
        o(org.apache.tools.ant.util.f.e());
    }

    private void a(ListIterator listIterator) {
        g().b(listIterator);
        this.f71579c.b(listIterator);
        if (l()) {
            a aVar = new a();
            q qVar = new q();
            q.a aVar2 = new q.a();
            aVar2.e("system");
            qVar.f(aVar2);
            aVar.d(qVar);
            aVar.b(listIterator);
        }
        m c11 = c(true);
        if (c11.size() > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("-Xbootclasspath:");
            stringBuffer.append(c11.toString());
            listIterator.add(stringBuffer.toString());
        }
        if (k()) {
            listIterator.add("-classpath");
            listIterator.add(this.f71580d.n("ignore").toString());
        }
        if (i() != null) {
            i().d(listIterator);
        }
        if (this.f71585i) {
            listIterator.add("-jar");
        }
        this.f71578b.b(listIterator);
    }

    private m c(boolean z10) {
        if (this.f71582f.startsWith("1.1")) {
            m mVar = this.f71581e;
            if (mVar != null && z10) {
                mVar.log("Ignoring bootclasspath as the target VM doesn't support it.");
            }
        } else {
            m mVar2 = this.f71581e;
            if (mVar2 != null) {
                return mVar2.m(l() ? "last" : "ignore");
            }
            if (l()) {
                return m.f71617d;
            }
        }
        return new m(null);
    }

    private boolean l() {
        return this.f71586j || "true".equals(System.getProperty("ant.build.clonevm"));
    }

    public void b(a aVar) {
        this.f71579c.c(aVar);
    }

    public Object clone() {
        try {
            d dVar = (d) super.clone();
            dVar.f71577a = (c) this.f71577a.clone();
            dVar.f71578b = (c) this.f71578b.clone();
            dVar.f71579c = (a) this.f71579c.clone();
            m mVar = this.f71580d;
            if (mVar != null) {
                dVar.f71580d = (m) mVar.clone();
            }
            m mVar2 = this.f71581e;
            if (mVar2 != null) {
                dVar.f71581e = (m) mVar2.clone();
            }
            b bVar = this.f71584h;
            if (bVar != null) {
                dVar.f71584h = (b) bVar.clone();
            }
            return dVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public c.a e() {
        return this.f71578b.c();
    }

    public m f(Project project) {
        if (this.f71580d == null) {
            this.f71580d = new m(project);
        }
        return this.f71580d;
    }

    protected c g() {
        c cVar = (c) this.f71577a.clone();
        if (this.f71583g != null) {
            if (this.f71582f.startsWith("1.1")) {
                c.a c11 = cVar.c();
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("-mx");
                stringBuffer.append(this.f71583g);
                c11.f(stringBuffer.toString());
            } else {
                c.a c12 = cVar.c();
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("-Xmx");
                stringBuffer2.append(this.f71583g);
                c12.f(stringBuffer2.toString());
            }
        }
        return cVar;
    }

    public b i() {
        return this.f71584h;
    }

    public String[] j() {
        LinkedList linkedList = new LinkedList();
        a(linkedList.listIterator());
        return (String[]) linkedList.toArray(new String[linkedList.size()]);
    }

    public boolean k() {
        m mVar = this.f71580d;
        m n11 = mVar != null ? mVar.n("ignore") : null;
        return n11 != null && n11.toString().trim().length() > 0;
    }

    public void m(String str) {
        this.f71578b.l(str);
        this.f71585i = false;
    }

    public void n(String str) {
        this.f71577a.l(str);
    }

    public void o(String str) {
        this.f71582f = str;
    }

    public String toString() {
        return c.m(j());
    }
}
