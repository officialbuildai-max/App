package org.apache.tools.ant;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.util.WeakHashMap;

/* loaded from: classes7.dex */
public class Project {

    /* renamed from: r, reason: collision with root package name */
    private static final String f71327r = System.getProperty("line.separator");

    /* renamed from: s, reason: collision with root package name */
    private static final org.apache.tools.ant.util.d f71328s = org.apache.tools.ant.util.d.k();

    /* renamed from: t, reason: collision with root package name */
    static /* synthetic */ Class f71329t;

    /* renamed from: a, reason: collision with root package name */
    private String f71330a;

    /* renamed from: e, reason: collision with root package name */
    private String f71334e;

    /* renamed from: g, reason: collision with root package name */
    private org.apache.tools.ant.types.i f71336g;

    /* renamed from: h, reason: collision with root package name */
    private org.apache.tools.ant.types.j f71337h;

    /* renamed from: i, reason: collision with root package name */
    private File f71338i;

    /* renamed from: j, reason: collision with root package name */
    private Vector f71339j;

    /* renamed from: k, reason: collision with root package name */
    private ClassLoader f71340k;

    /* renamed from: l, reason: collision with root package name */
    private Map f71341l;

    /* renamed from: m, reason: collision with root package name */
    private Map f71342m;

    /* renamed from: n, reason: collision with root package name */
    private v00.b f71343n;

    /* renamed from: o, reason: collision with root package name */
    private InputStream f71344o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f71345p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f71346q;

    /* renamed from: b, reason: collision with root package name */
    private Hashtable f71331b = new AntRefTable();

    /* renamed from: c, reason: collision with root package name */
    private HashMap f71332c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    private Project f71333d = null;

    /* renamed from: f, reason: collision with root package name */
    private Hashtable f71335f = new Hashtable();

    /* loaded from: classes7.dex */
    private static class AntRefTable extends Hashtable {
        AntRefTable() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object a(Object obj) {
            return super.get(obj);
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object get(Object obj) {
            Object a11 = a(obj);
            if (!(a11 instanceof w)) {
                return a11;
            }
            w wVar = (w) a11;
            wVar.m();
            return wVar.A();
        }
    }

    public Project() {
        org.apache.tools.ant.types.i iVar = new org.apache.tools.ant.types.i();
        this.f71336g = iVar;
        iVar.setProject(this);
        this.f71337h = new org.apache.tools.ant.types.j(this.f71336g);
        this.f71339j = new Vector();
        this.f71340k = null;
        this.f71341l = Collections.synchronizedMap(new WeakHashMap());
        this.f71342m = Collections.synchronizedMap(new WeakHashMap());
        this.f71343n = null;
        this.f71344o = null;
        this.f71345p = false;
        this.f71346q = false;
        this.f71343n = new v00.a();
    }

    private Object E(String str, Project project) {
        w wVar = (w) this.f71332c.get(str);
        if (wVar == null) {
            Project project2 = this.f71333d;
            if (project2 == null) {
                return null;
            }
            return project2.E(str, project);
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Warning: Reference ");
        stringBuffer.append(str);
        stringBuffer.append(" has not been set at runtime,");
        stringBuffer.append(" but was found during");
        String str2 = f71327r;
        stringBuffer.append(str2);
        stringBuffer.append("build file parsing, attempting to resolve.");
        stringBuffer.append(" Future versions of Ant may support");
        stringBuffer.append(str2);
        stringBuffer.append(" referencing ids defined in non-executed targets.");
        project.x(stringBuffer.toString(), 1);
        w v11 = wVar.v(project);
        v11.m();
        return v11.A();
    }

    private void L(String str, String str2) {
        s.d(this).l(null, str, str2, false);
    }

    public static boolean N(String str) {
        return "on".equalsIgnoreCase(str) || "true".equalsIgnoreCase(str) || "yes".equalsIgnoreCase(str);
    }

    static /* synthetic */ Class f(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private void j(BuildEvent buildEvent, String str, int i11) {
        String str2 = org.apache.tools.ant.util.p.f71726a;
        if (str.endsWith(str2)) {
            buildEvent.setMessage(str.substring(0, str.length() - str2.length()), i11);
        } else {
            buildEvent.setMessage(str, i11);
        }
        synchronized (this) {
            if (this.f71346q) {
                return;
            }
            try {
                this.f71346q = true;
                Iterator it = this.f71339j.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(buildEvent);
                }
            } finally {
                this.f71346q = false;
            }
        }
    }

    public static Project q(Object obj) {
        if (obj instanceof q) {
            return ((q) obj).getProject();
        }
        try {
            Method method = obj.getClass().getMethod("getProject", null);
            Class<?> cls = f71329t;
            if (cls == null) {
                cls = f("org.apache.tools.ant.Project");
                f71329t = cls;
            }
            if (cls == method.getReturnType()) {
                return (Project) method.invoke(obj, null);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public synchronized void A(Thread thread, u uVar) {
        try {
            if (uVar != null) {
                this.f71341l.put(thread, uVar);
                this.f71342m.put(thread.getThreadGroup(), uVar);
            } else {
                this.f71341l.remove(thread);
                this.f71342m.remove(thread.getThreadGroup());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void B(c cVar) {
        Vector n11 = n();
        n11.removeElement(cVar);
        this.f71339j = n11;
    }

    public String C(String str) {
        return s.d(this).i(null, str, null);
    }

    public File D(String str) {
        return f71328s.q(this.f71338i, str);
    }

    public void F(File file) {
        File o11 = f71328s.o(file.getAbsolutePath());
        if (!o11.exists()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Basedir ");
            stringBuffer.append(o11.getAbsolutePath());
            stringBuffer.append(" does not exist");
            throw new BuildException(stringBuffer.toString());
        }
        if (!o11.isDirectory()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Basedir ");
            stringBuffer2.append(o11.getAbsolutePath());
            stringBuffer2.append(" is not a directory");
            throw new BuildException(stringBuffer2.toString());
        }
        this.f71338i = o11;
        L("basedir", o11.getPath());
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append("Project base dir set to: ");
        stringBuffer3.append(this.f71338i);
        x(stringBuffer3.toString(), 3);
    }

    public void G(String str) {
        F(new File(str));
    }

    public void H(String str) {
        this.f71334e = str;
    }

    public void I(String str) {
        M("ant.project.name", str);
        this.f71330a = str;
    }

    public void J(String str, String str2) {
        s.d(this).j(null, str, str2);
    }

    public final void K(Object obj) {
        if (obj instanceof q) {
            ((q) obj).setProject(this);
            return;
        }
        try {
            Class<?> cls = obj.getClass();
            Class<?> cls2 = f71329t;
            if (cls2 == null) {
                cls2 = f("org.apache.tools.ant.Project");
                f71329t = cls2;
            }
            Method method = cls.getMethod("setProject", cls2);
            if (method != null) {
                method.invoke(obj, this);
            }
        } catch (Throwable unused) {
        }
    }

    public void M(String str, String str2) {
        s.d(this).n(null, str, str2);
    }

    public synchronized void a(c cVar) {
        if (this.f71339j.contains(cVar)) {
            return;
        }
        Vector n11 = n();
        n11.addElement(cVar);
        this.f71339j = n11;
    }

    public void b(String str, Object obj) {
        this.f71332c.put(str, obj);
    }

    public void c(String str, t tVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" +Target: ");
        stringBuffer.append(str);
        x(stringBuffer.toString(), 4);
        tVar.m(this);
        this.f71335f.put(str, tVar);
    }

    public void d(String str, Object obj) {
        synchronized (this.f71331b) {
            try {
                Object a11 = ((AntRefTable) this.f71331b).a(str);
                if (a11 == obj) {
                    return;
                }
                if (a11 != null && !(a11 instanceof w)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Overriding previous definition of reference to ");
                    stringBuffer.append(str);
                    x(stringBuffer.toString(), 3);
                }
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Adding reference: ");
                stringBuffer2.append(str);
                x(stringBuffer2.toString(), 4);
                this.f71331b.put(str, obj);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(String str, t tVar) {
        if (this.f71335f.get(str) == null) {
            c(str, tVar);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Duplicate target: `");
        stringBuffer.append(str);
        stringBuffer.append("'");
        throw new BuildException(stringBuffer.toString());
    }

    public a g(org.apache.tools.ant.types.m mVar) {
        return new a(getClass().getClassLoader(), this, mVar);
    }

    protected void h(Project project, String str, Throwable th2, int i11) {
        BuildEvent buildEvent = new BuildEvent(project);
        buildEvent.setException(th2);
        j(buildEvent, str, i11);
    }

    protected void i(u uVar, String str, Throwable th2, int i11) {
        BuildEvent buildEvent = new BuildEvent(uVar);
        buildEvent.setException(th2);
        j(buildEvent, str, i11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(u uVar, Throwable th2) {
        A(Thread.currentThread(), null);
        System.out.flush();
        System.err.flush();
        BuildEvent buildEvent = new BuildEvent(uVar);
        buildEvent.setException(th2);
        Iterator it = this.f71339j.iterator();
        while (it.hasNext()) {
            ((c) it.next()).c(buildEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(u uVar) {
        A(Thread.currentThread(), uVar);
        BuildEvent buildEvent = new BuildEvent(uVar);
        Iterator it = this.f71339j.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b(buildEvent);
        }
    }

    public File m() {
        if (this.f71338i == null) {
            try {
                G(".");
            } catch (BuildException e11) {
                e11.printStackTrace();
            }
        }
        return this.f71338i;
    }

    public Vector n() {
        return (Vector) this.f71339j.clone();
    }

    public ClassLoader o() {
        return this.f71340k;
    }

    public String p(Object obj) {
        return ComponentHelper.j(this).m(obj);
    }

    public Hashtable r() {
        return s.d(this).b();
    }

    public String s(String str) {
        return (String) s.d(this).c(null, str);
    }

    public Object t(String str) {
        Object obj = this.f71331b.get(str);
        if (obj != null) {
            return obj;
        }
        Object E = E(str, this);
        if (E == null && !str.equals("ant.PropertyHelper")) {
            Vector vector = new Vector();
            s.d(this).g(str, new Vector(), vector);
            if (vector.size() == 1) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Unresolvable reference ");
                stringBuffer.append(str);
                stringBuffer.append(" might be a misuse of property expansion syntax.");
                x(stringBuffer.toString(), 1);
            }
        }
        return E;
    }

    public Hashtable u() {
        return this.f71335f;
    }

    public u v(Thread thread) {
        u uVar = (u) this.f71341l.get(thread);
        if (uVar == null) {
            for (ThreadGroup threadGroup = thread.getThreadGroup(); uVar == null && threadGroup != null; threadGroup = threadGroup.getParent()) {
                uVar = (u) this.f71342m.get(threadGroup);
            }
        }
        return uVar;
    }

    public Hashtable w() {
        return s.d(this).f();
    }

    public void x(String str, int i11) {
        y(str, null, i11);
    }

    public void y(String str, Throwable th2, int i11) {
        h(this, str, th2, i11);
    }

    public void z(u uVar, String str, int i11) {
        i(uVar, str, null, i11);
    }
}
