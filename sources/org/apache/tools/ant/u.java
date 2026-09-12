package org.apache.tools.ant;

import java.util.Enumeration;

/* loaded from: classes7.dex */
public abstract class u extends q {

    /* renamed from: a, reason: collision with root package name */
    protected t f71663a;

    /* renamed from: b, reason: collision with root package name */
    protected String f71664b;

    /* renamed from: c, reason: collision with root package name */
    protected String f71665c;

    /* renamed from: d, reason: collision with root package name */
    protected RuntimeConfigurable f71666d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f71667e;

    /* renamed from: f, reason: collision with root package name */
    private w f71668f;

    private w g() {
        if (this.f71668f == null) {
            w wVar = new w(this.f71665c);
            this.f71668f = wVar;
            wVar.setProject(getProject());
            this.f71668f.s(this.f71665c);
            this.f71668f.r(this.f71664b);
            this.f71668f.setLocation(this.location);
            this.f71668f.p(this.f71663a);
            this.f71668f.q(this.f71666d);
            this.f71666d.setProxy(this.f71668f);
            o(this.f71666d, this.f71668f);
            this.f71663a.g(this, this.f71668f);
            this.f71668f.m();
        }
        return this.f71668f;
    }

    private void o(RuntimeConfigurable runtimeConfigurable, w wVar) {
        Enumeration children = runtimeConfigurable.getChildren();
        while (children.hasMoreElements()) {
            RuntimeConfigurable runtimeConfigurable2 = (RuntimeConfigurable) children.nextElement();
            w wVar2 = new w(runtimeConfigurable2.getElementTag());
            wVar.t(wVar2);
            wVar2.setProject(getProject());
            wVar2.q(runtimeConfigurable2);
            runtimeConfigurable2.setProxy(wVar2);
            o(runtimeConfigurable2, wVar2);
        }
    }

    public void e() {
    }

    public t f() {
        return this.f71663a;
    }

    public String i() {
        return this.f71664b;
    }

    public String j() {
        return this.f71665c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RuntimeConfigurable k() {
        return this.f71666d;
    }

    public void l() {
    }

    @Override // org.apache.tools.ant.q
    public void log(String str) {
        log(str, 2);
    }

    @Override // org.apache.tools.ant.q
    public void log(String str, int i11) {
        if (getProject() != null) {
            getProject().z(this, str, i11);
        } else {
            super.log(str, i11);
        }
    }

    public void m() {
        if (this.f71667e) {
            g();
            return;
        }
        RuntimeConfigurable runtimeConfigurable = this.f71666d;
        if (runtimeConfigurable != null) {
            runtimeConfigurable.maybeConfigure(getProject());
        }
    }

    public final void n() {
        Throwable th2;
        if (this.f71667e) {
            g().C().n();
            return;
        }
        getProject().l(this);
        BuildException buildException = null;
        try {
            try {
                m();
                r00.a.a(this);
                getProject().k(this, null);
            } catch (Error e11) {
                throw e11;
            } catch (BuildException e12) {
                if (e12.getLocation() == Location.UNKNOWN_LOCATION) {
                    e12.setLocation(getLocation());
                }
                try {
                    throw e12;
                } catch (Throwable th3) {
                    th2 = th3;
                    buildException = e12;
                    getProject().k(this, buildException);
                    throw th2;
                }
            } catch (Exception e13) {
                BuildException buildException2 = new BuildException(e13);
                buildException2.setLocation(getLocation());
                throw buildException2;
            }
        } catch (Throwable th4) {
            th2 = th4;
            getProject().k(this, buildException);
            throw th2;
        }
    }

    public void p(t tVar) {
        this.f71663a = tVar;
    }

    public void q(RuntimeConfigurable runtimeConfigurable) {
        this.f71666d = runtimeConfigurable;
    }

    public void r(String str) {
        this.f71664b = str;
    }

    public void s(String str) {
        this.f71665c = str;
    }
}
