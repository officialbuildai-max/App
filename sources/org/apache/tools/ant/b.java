package org.apache.tools.ant;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    static /* synthetic */ Class f71366g;

    /* renamed from: a, reason: collision with root package name */
    private String f71367a;

    /* renamed from: b, reason: collision with root package name */
    private Class f71368b;

    /* renamed from: c, reason: collision with root package name */
    private Class f71369c;

    /* renamed from: d, reason: collision with root package name */
    private Class f71370d;

    /* renamed from: e, reason: collision with root package name */
    private String f71371e;

    /* renamed from: f, reason: collision with root package name */
    private ClassLoader f71372f;

    static /* synthetic */ Class b(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private Object d(Project project, Class cls) {
        try {
            return l(cls, project);
        } catch (IllegalAccessException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not create type ");
            stringBuffer.append(this.f71367a);
            stringBuffer.append(" as the constructor ");
            stringBuffer.append(cls);
            stringBuffer.append(" is not accessible");
            throw new BuildException(stringBuffer.toString());
        } catch (InstantiationException unused2) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not create type ");
            stringBuffer2.append(this.f71367a);
            stringBuffer2.append(" as the class ");
            stringBuffer2.append(cls);
            stringBuffer2.append(" is abstract");
            throw new BuildException(stringBuffer2.toString());
        } catch (NoClassDefFoundError e11) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Type ");
            stringBuffer3.append(this.f71367a);
            stringBuffer3.append(": A class needed by class ");
            stringBuffer3.append(cls);
            stringBuffer3.append(" cannot be found: ");
            stringBuffer3.append(e11.getMessage());
            throw new BuildException(stringBuffer3.toString(), e11);
        } catch (NoSuchMethodException unused3) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not create type ");
            stringBuffer4.append(this.f71367a);
            stringBuffer4.append(" as the class ");
            stringBuffer4.append(cls);
            stringBuffer4.append(" has no compatible constructor");
            throw new BuildException(stringBuffer4.toString());
        } catch (InvocationTargetException e12) {
            Throwable targetException = e12.getTargetException();
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Could not create type ");
            stringBuffer5.append(this.f71367a);
            stringBuffer5.append(" due to ");
            stringBuffer5.append(targetException);
            throw new BuildException(stringBuffer5.toString(), targetException);
        } catch (Throwable th2) {
            StringBuffer stringBuffer6 = new StringBuffer();
            stringBuffer6.append("Could not create type ");
            stringBuffer6.append(this.f71367a);
            stringBuffer6.append(" due to ");
            stringBuffer6.append(th2);
            throw new BuildException(stringBuffer6.toString(), th2);
        }
    }

    private String e(Class cls) {
        return cls == null ? "<null>" : cls.getClass().getName();
    }

    private Object k(Project project) {
        Class j11 = j(project);
        if (j11 == null) {
            return null;
        }
        Object d11 = d(project, j11);
        if (d11 == null || this.f71369c == null) {
            return d11;
        }
        Class cls = this.f71370d;
        if (cls != null && cls.isAssignableFrom(d11.getClass())) {
            return d11;
        }
        android.support.v4.media.session.c.a(d(project, this.f71369c));
        return null;
    }

    public void a(Project project) {
        if (this.f71368b == null) {
            Class j11 = j(project);
            this.f71368b = j11;
            if (j11 == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unable to create class for ");
                stringBuffer.append(i());
                throw new BuildException(stringBuffer.toString());
            }
        }
        if (this.f71369c != null) {
            Class cls = this.f71370d;
            if (cls == null || !cls.isAssignableFrom(this.f71368b)) {
                android.support.v4.media.session.c.a(d(project, this.f71369c));
                throw new BuildException("Unable to create adapter object");
            }
        }
    }

    public Object c(Project project) {
        return k(project);
    }

    public ClassLoader f() {
        return this.f71372f;
    }

    public String g() {
        return this.f71371e;
    }

    public Class h(Project project) {
        Class<?> j11;
        if (this.f71370d != null && ((j11 = j(project)) == null || this.f71370d.isAssignableFrom(j11))) {
            return j11;
        }
        Class cls = this.f71369c;
        return cls == null ? j(project) : cls;
    }

    public String i() {
        return this.f71367a;
    }

    public Class j(Project project) {
        try {
            return m();
        } catch (ClassNotFoundException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Could not load class (");
            stringBuffer.append(this.f71371e);
            stringBuffer.append(") for type ");
            stringBuffer.append(this.f71367a);
            project.x(stringBuffer.toString(), 4);
            return null;
        } catch (NoClassDefFoundError e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Could not load a dependent class (");
            stringBuffer2.append(e11.getMessage());
            stringBuffer2.append(") for type ");
            stringBuffer2.append(this.f71367a);
            project.x(stringBuffer2.toString(), 4);
            return null;
        }
    }

    public Object l(Class cls, Project project) {
        Constructor constructor;
        boolean z10;
        try {
            constructor = cls.getConstructor(null);
            z10 = true;
        } catch (NoSuchMethodException unused) {
            Class<?> cls2 = f71366g;
            if (cls2 == null) {
                cls2 = b("org.apache.tools.ant.Project");
                f71366g = cls2;
            }
            constructor = cls.getConstructor(cls2);
            z10 = false;
        }
        Object newInstance = constructor.newInstance(z10 ? new Object[0] : new Object[]{project});
        project.K(newInstance);
        return newInstance;
    }

    public Class m() {
        Class cls = this.f71368b;
        if (cls != null) {
            return cls;
        }
        ClassLoader classLoader = this.f71372f;
        if (classLoader == null) {
            this.f71368b = Class.forName(this.f71371e);
        } else {
            this.f71368b = classLoader.loadClass(this.f71371e);
        }
        return this.f71368b;
    }

    public boolean n(b bVar, Project project) {
        return bVar != null && bVar.getClass() == getClass() && bVar.j(project).equals(j(project)) && bVar.h(project).equals(h(project)) && bVar.f71369c == this.f71369c && bVar.f71370d == this.f71370d;
    }

    public void o(Class cls) {
        this.f71370d = cls;
    }

    public void p(Class cls) {
        this.f71369c = cls;
    }

    public void q(Class cls) {
        this.f71368b = cls;
        if (cls == null) {
            return;
        }
        ClassLoader classLoader = this.f71372f;
        if (classLoader == null) {
            classLoader = cls.getClassLoader();
        }
        this.f71372f = classLoader;
        String str = this.f71371e;
        if (str == null) {
            str = cls.getName();
        }
        this.f71371e = str;
    }

    public void r(ClassLoader classLoader) {
        this.f71372f = classLoader;
    }

    public void s(String str) {
        this.f71371e = str;
    }

    public void t(String str) {
        this.f71367a = str;
    }

    public boolean u(b bVar, Project project) {
        if (bVar == null || getClass() != bVar.getClass() || !g().equals(bVar.g()) || !e(this.f71369c).equals(e(bVar.f71369c)) || !e(this.f71370d).equals(e(bVar.f71370d))) {
            return false;
        }
        ClassLoader f11 = bVar.f();
        ClassLoader f12 = f();
        return f11 == f12 || ((f11 instanceof a) && (f12 instanceof a) && ((a) f11).s().equals(((a) f12).s()));
    }
}
