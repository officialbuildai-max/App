package org.apache.tools.ant;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* loaded from: classes7.dex */
public class s {

    /* renamed from: a, reason: collision with root package name */
    private Project f71439a;

    /* renamed from: b, reason: collision with root package name */
    private s f71440b;

    /* renamed from: c, reason: collision with root package name */
    private Hashtable f71441c = new Hashtable();

    /* renamed from: d, reason: collision with root package name */
    private Hashtable f71442d = new Hashtable();

    /* renamed from: e, reason: collision with root package name */
    private Hashtable f71443e = new Hashtable();

    protected s() {
    }

    public static synchronized s d(Project project) {
        synchronized (s.class) {
            s sVar = (s) project.t("ant.PropertyHelper");
            if (sVar != null) {
                return sVar;
            }
            s sVar2 = new s();
            sVar2.k(project);
            project.d("ant.PropertyHelper", sVar2);
            return sVar2;
        }
    }

    static void h(String str, Vector vector, Vector vector2) {
        int i11 = 0;
        while (true) {
            int indexOf = str.indexOf("$", i11);
            if (indexOf < 0) {
                if (i11 < str.length()) {
                    vector.addElement(str.substring(i11));
                    return;
                }
                return;
            }
            if (indexOf > 0) {
                vector.addElement(str.substring(i11, indexOf));
            }
            if (indexOf == str.length() - 1) {
                vector.addElement("$");
                i11 = indexOf + 1;
            } else {
                int i12 = indexOf + 1;
                if (str.charAt(i12) == '{') {
                    int indexOf2 = str.indexOf(Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE, indexOf);
                    if (indexOf2 < 0) {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append("Syntax error in property: ");
                        stringBuffer.append(str);
                        throw new BuildException(stringBuffer.toString());
                    }
                    String substring = str.substring(indexOf + 2, indexOf2);
                    vector.addElement(null);
                    vector2.addElement(substring);
                    i11 = indexOf2 + 1;
                } else if (str.charAt(i12) == '$') {
                    vector.addElement("$");
                    i11 = indexOf + 2;
                } else {
                    i11 = indexOf + 2;
                    vector.addElement(str.substring(indexOf, i11));
                }
            }
        }
    }

    public s a() {
        return this.f71440b;
    }

    public Hashtable b() {
        Hashtable hashtable;
        synchronized (this.f71441c) {
            hashtable = new Hashtable(this.f71441c);
        }
        return hashtable;
    }

    public synchronized Object c(String str, String str2) {
        if (str2 == null) {
            return null;
        }
        Object e11 = e(str, str2, false);
        if (e11 != null) {
            return e11;
        }
        return this.f71441c.get(str2);
    }

    public Object e(String str, String str2, boolean z10) {
        Object e11;
        if (a() != null && (e11 = a().e(str, str2, z10)) != null) {
            return e11;
        }
        if (!str2.startsWith("toString:")) {
            return null;
        }
        Object t11 = this.f71439a.t(str2.substring(9));
        if (t11 == null) {
            return null;
        }
        return t11.toString();
    }

    public Hashtable f() {
        Hashtable hashtable;
        synchronized (this.f71442d) {
            hashtable = new Hashtable(this.f71442d);
        }
        return hashtable;
    }

    public void g(String str, Vector vector, Vector vector2) {
        h(str, vector, vector2);
    }

    public String i(String str, String str2, Hashtable hashtable) {
        if (str2 == null || str2.indexOf(36) == -1) {
            return str2;
        }
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        g(str2, vector, vector2);
        StringBuffer stringBuffer = new StringBuffer();
        Enumeration elements = vector.elements();
        Enumeration elements2 = vector2.elements();
        while (elements.hasMoreElements()) {
            String str3 = (String) elements.nextElement();
            if (str3 == null) {
                String str4 = (String) elements2.nextElement();
                Object obj = hashtable != null ? hashtable.get(str4) : null;
                if (obj == null) {
                    obj = c(str, str4);
                }
                if (obj == null) {
                    Project project = this.f71439a;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Property \"");
                    stringBuffer2.append(str4);
                    stringBuffer2.append("\" has not been set");
                    project.x(stringBuffer2.toString(), 3);
                }
                if (obj != null) {
                    str3 = obj.toString();
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("${");
                    stringBuffer3.append(str4);
                    stringBuffer3.append("}");
                    str3 = stringBuffer3.toString();
                }
            }
            stringBuffer.append(str3);
        }
        return stringBuffer.toString();
    }

    public synchronized void j(String str, String str2, Object obj) {
        if (this.f71441c.get(str2) != null) {
            Project project = this.f71439a;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Override ignored for property \"");
            stringBuffer.append(str2);
            stringBuffer.append("\"");
            project.x(stringBuffer.toString(), 3);
            return;
        }
        if (m(str, str2, obj, false, false, true)) {
            return;
        }
        Project project2 = this.f71439a;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("Setting project property: ");
        stringBuffer2.append(str2);
        stringBuffer2.append(" -> ");
        stringBuffer2.append(obj);
        project2.x(stringBuffer2.toString(), 4);
        if (str2 != null && obj != null) {
            this.f71441c.put(str2, obj);
        }
    }

    public void k(Project project) {
        this.f71439a = project;
    }

    public synchronized boolean l(String str, String str2, Object obj, boolean z10) {
        if (this.f71442d.get(str2) != null) {
            if (z10) {
                Project project = this.f71439a;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Override ignored for user property \"");
                stringBuffer.append(str2);
                stringBuffer.append("\"");
                project.x(stringBuffer.toString(), 3);
            }
            return false;
        }
        if (m(str, str2, obj, false, false, false)) {
            return true;
        }
        if (this.f71441c.get(str2) != null && z10) {
            Project project2 = this.f71439a;
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Overriding previous definition of property \"");
            stringBuffer2.append(str2);
            stringBuffer2.append("\"");
            project2.x(stringBuffer2.toString(), 3);
        }
        if (z10) {
            Project project3 = this.f71439a;
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Setting project property: ");
            stringBuffer3.append(str2);
            stringBuffer3.append(" -> ");
            stringBuffer3.append(obj);
            project3.x(stringBuffer3.toString(), 4);
        }
        if (str2 != null && obj != null) {
            this.f71441c.put(str2, obj);
        }
        return true;
    }

    public boolean m(String str, String str2, Object obj, boolean z10, boolean z11, boolean z12) {
        return a() != null && a().m(str, str2, obj, z10, z11, z12);
    }

    public synchronized void n(String str, String str2, Object obj) {
        Project project = this.f71439a;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Setting ro project property: ");
        stringBuffer.append(str2);
        stringBuffer.append(" -> ");
        stringBuffer.append(obj);
        project.x(stringBuffer.toString(), 4);
        this.f71442d.put(str2, obj);
        if (m(str, str2, obj, false, true, false)) {
            return;
        }
        this.f71441c.put(str2, obj);
    }
}
