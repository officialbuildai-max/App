package org.apache.tools.ant;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/* loaded from: classes7.dex */
public class t implements v {

    /* renamed from: a, reason: collision with root package name */
    private String f71444a;

    /* renamed from: b, reason: collision with root package name */
    private String f71445b;

    /* renamed from: c, reason: collision with root package name */
    private String f71446c;

    /* renamed from: d, reason: collision with root package name */
    private List f71447d;

    /* renamed from: e, reason: collision with root package name */
    private List f71448e;

    /* renamed from: f, reason: collision with root package name */
    private Location f71449f;

    /* renamed from: g, reason: collision with root package name */
    private Project f71450g;

    /* renamed from: h, reason: collision with root package name */
    private String f71451h;

    public t() {
        this.f71445b = "";
        this.f71446c = "";
        this.f71447d = null;
        this.f71448e = new ArrayList();
        this.f71449f = Location.UNKNOWN_LOCATION;
        this.f71451h = null;
    }

    public t(t tVar) {
        this.f71445b = "";
        this.f71446c = "";
        this.f71447d = null;
        this.f71448e = new ArrayList();
        this.f71449f = Location.UNKNOWN_LOCATION;
        this.f71451h = null;
        this.f71444a = tVar.f71444a;
        this.f71445b = tVar.f71445b;
        this.f71446c = tVar.f71446c;
        this.f71447d = tVar.f71447d;
        this.f71449f = tVar.f71449f;
        this.f71450g = tVar.f71450g;
        this.f71451h = tVar.f71451h;
        this.f71448e = tVar.f71448e;
    }

    public void a(String str) {
        if (this.f71447d == null) {
            this.f71447d = new ArrayList(2);
        }
        this.f71447d.add(str);
    }

    @Override // org.apache.tools.ant.v
    public void b(u uVar) {
        this.f71448e.add(uVar);
    }

    public Location c() {
        return this.f71449f;
    }

    public String d() {
        return this.f71444a;
    }

    public Project e() {
        return this.f71450g;
    }

    public u[] f() {
        ArrayList arrayList = new ArrayList(this.f71448e.size());
        for (Object obj : this.f71448e) {
            if (obj instanceof u) {
                arrayList.add(obj);
            }
        }
        return (u[]) arrayList.toArray(new u[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(u uVar, u uVar2) {
        while (true) {
            int indexOf = this.f71448e.indexOf(uVar);
            if (indexOf < 0) {
                return;
            } else {
                this.f71448e.set(indexOf, uVar2);
            }
        }
    }

    public void h(String str) {
        if (str.length() > 0) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",", true);
            while (stringTokenizer.hasMoreTokens()) {
                String trim = stringTokenizer.nextToken().trim();
                if ("".equals(trim) || ",".equals(trim)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Syntax Error: depends attribute of target \"");
                    stringBuffer.append(d());
                    stringBuffer.append("\" has an empty string as dependency.");
                    throw new BuildException(stringBuffer.toString());
                }
                a(trim);
                if (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    if (!stringTokenizer.hasMoreTokens() || !",".equals(nextToken)) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append("Syntax Error: Depend attribute for target \"");
                        stringBuffer2.append(d());
                        stringBuffer2.append("\" ends with a , character");
                        throw new BuildException(stringBuffer2.toString());
                    }
                }
            }
        }
    }

    public void i(String str) {
        this.f71451h = str;
    }

    public void j(String str) {
        if (str == null) {
            str = "";
        }
        this.f71445b = str;
    }

    public void k(Location location) {
        this.f71449f = location;
    }

    public void l(String str) {
        this.f71444a = str;
    }

    public void m(Project project) {
        this.f71450g = project;
    }

    public void n(String str) {
        if (str == null) {
            str = "";
        }
        this.f71446c = str;
    }

    public String toString() {
        return this.f71444a;
    }
}
