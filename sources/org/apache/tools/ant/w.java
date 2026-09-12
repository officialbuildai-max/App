package org.apache.tools.ant;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import org.apache.tools.ant.o;

/* loaded from: classes7.dex */
public class w extends u {

    /* renamed from: g, reason: collision with root package name */
    private String f71729g;

    /* renamed from: i, reason: collision with root package name */
    private String f71731i;

    /* renamed from: j, reason: collision with root package name */
    private Object f71732j;

    /* renamed from: h, reason: collision with root package name */
    private String f71730h = "";

    /* renamed from: k, reason: collision with root package name */
    private List f71733k = null;

    /* renamed from: l, reason: collision with root package name */
    private boolean f71734l = false;

    public w(String str) {
        this.f71729g = str;
    }

    private boolean D(String str, o oVar, Object obj, w wVar, RuntimeConfigurable runtimeConfigurable) {
        String e11 = r.e(wVar.x(), wVar.B());
        if (!oVar.s(str, e11)) {
            return false;
        }
        o.d i11 = oVar.i(getProject(), str, obj, e11, wVar);
        i11.b(runtimeConfigurable.getPolyType());
        Object a11 = i11.a();
        runtimeConfigurable.setCreator(i11);
        runtimeConfigurable.setProxy(a11);
        if (a11 instanceof u) {
            u uVar = (u) a11;
            uVar.q(runtimeConfigurable);
            uVar.r(e11);
            uVar.s(e11);
        }
        if (a11 instanceof q) {
            ((q) a11).setLocation(wVar.getLocation());
        }
        runtimeConfigurable.maybeConfigure(getProject());
        wVar.E(a11, runtimeConfigurable);
        i11.c();
        return true;
    }

    public Object A() {
        return this.f71732j;
    }

    public String B() {
        return this.f71729g;
    }

    public u C() {
        Object obj = this.f71732j;
        if (obj instanceof u) {
            return (u) obj;
        }
        return null;
    }

    protected void E(Object obj, RuntimeConfigurable runtimeConfigurable) {
        String x10 = x();
        o k11 = o.k(getProject(), obj.getClass());
        List<w> list = this.f71733k;
        if (list != null) {
            int i11 = 0;
            for (w wVar : list) {
                RuntimeConfigurable child = runtimeConfigurable.getChild(i11);
                try {
                    if (!D(x10, k11, obj, wVar, child)) {
                        if (obj instanceof v) {
                            ((v) obj).b(wVar);
                        } else {
                            k11.t(getProject(), obj, wVar.B());
                        }
                    }
                    i11++;
                } catch (UnsupportedElementException e11) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(runtimeConfigurable.getElementTag());
                    stringBuffer.append(" doesn't support the nested \"");
                    stringBuffer.append(e11.getElement());
                    stringBuffer.append("\" element.");
                    throw new BuildException(stringBuffer.toString(), e11);
                }
            }
        }
    }

    protected Object F(w wVar, RuntimeConfigurable runtimeConfigurable) {
        ComponentHelper j11 = ComponentHelper.j(getProject());
        String w11 = wVar.w();
        Object e11 = j11.e(wVar, wVar.x(), w11);
        if (e11 == null) {
            throw y("task or type", w11);
        }
        if (e11 instanceof w) {
            w wVar2 = (w) e11;
            e11 = wVar2.F(wVar2, runtimeConfigurable);
        }
        if (e11 instanceof u) {
            ((u) e11).p(f());
        }
        if (e11 instanceof q) {
            ((q) e11).setLocation(getLocation());
        }
        return e11;
    }

    public void G(String str) {
        if (str.equals("ant:current")) {
            str = ComponentHelper.j(getProject()).k();
        }
        if (str == null) {
            str = "";
        }
        this.f71730h = str;
    }

    public void H(String str) {
        this.f71731i = str;
    }

    public void I(Object obj) {
        this.f71732j = obj;
    }

    @Override // org.apache.tools.ant.u
    public String i() {
        Object obj = this.f71732j;
        return (obj == null || !(obj instanceof u)) ? super.i() : ((u) obj).i();
    }

    @Override // org.apache.tools.ant.u
    public RuntimeConfigurable k() {
        return super.k();
    }

    @Override // org.apache.tools.ant.u
    public void m() {
        if (this.f71732j != null) {
            return;
        }
        u(F(this, k()));
    }

    public void t(w wVar) {
        if (this.f71733k == null) {
            this.f71733k = new ArrayList();
        }
        this.f71733k.add(wVar);
    }

    public void u(Object obj) {
        u uVar;
        this.f71732j = obj;
        k().setProxy(this.f71732j);
        Object obj2 = this.f71732j;
        if (obj2 instanceof u) {
            uVar = (u) obj2;
            uVar.q(k());
            if (k().getId() != null) {
                f().g(this, (u) this.f71732j);
            }
        } else {
            uVar = null;
        }
        if (uVar != null) {
            uVar.m();
        } else {
            k().maybeConfigure(getProject());
        }
        E(this.f71732j, k());
    }

    public w v(Project project) {
        w wVar = new w(B());
        wVar.G(x());
        wVar.setProject(project);
        wVar.H(z());
        wVar.s(j());
        wVar.r(i());
        wVar.setLocation(getLocation());
        if (f() == null) {
            t tVar = new t();
            tVar.m(getProject());
            wVar.p(tVar);
        } else {
            wVar.p(f());
        }
        RuntimeConfigurable runtimeConfigurable = new RuntimeConfigurable(wVar, i());
        runtimeConfigurable.setPolyType(k().getPolyType());
        for (Map.Entry entry : k().getAttributeMap().entrySet()) {
            runtimeConfigurable.setAttribute((String) entry.getKey(), (String) entry.getValue());
        }
        runtimeConfigurable.addText(k().getText().toString());
        Enumeration children = k().getChildren();
        while (children.hasMoreElements()) {
            w v11 = ((w) ((RuntimeConfigurable) children.nextElement()).getProxy()).v(project);
            runtimeConfigurable.addChild(v11.k());
            wVar.t(v11);
        }
        return wVar;
    }

    protected String w() {
        return r.e(x(), B());
    }

    public String x() {
        return this.f71730h;
    }

    protected BuildException y(String str, String str2) {
        return new BuildException(ComponentHelper.j(getProject()).f(str2, str), getLocation());
    }

    public String z() {
        return this.f71731i;
    }
}
