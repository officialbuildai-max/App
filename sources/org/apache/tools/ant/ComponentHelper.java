package org.apache.tools.ant;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.Stack;
import org.apache.tools.ant.taskdefs.e;

/* loaded from: classes7.dex */
public class ComponentHelper {

    /* renamed from: j, reason: collision with root package name */
    private static Properties[] f71316j = new Properties[2];

    /* renamed from: k, reason: collision with root package name */
    static /* synthetic */ Class f71317k;

    /* renamed from: a, reason: collision with root package name */
    private AntTypeTable f71318a;

    /* renamed from: b, reason: collision with root package name */
    private Hashtable f71319b = new Hashtable();

    /* renamed from: c, reason: collision with root package name */
    private boolean f71320c = true;

    /* renamed from: d, reason: collision with root package name */
    private Hashtable f71321d = new Hashtable();

    /* renamed from: e, reason: collision with root package name */
    private boolean f71322e = true;

    /* renamed from: f, reason: collision with root package name */
    private Set f71323f = new HashSet();

    /* renamed from: g, reason: collision with root package name */
    private Stack f71324g = new Stack();

    /* renamed from: h, reason: collision with root package name */
    private String f71325h = null;

    /* renamed from: i, reason: collision with root package name */
    private Project f71326i;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class AntTypeTable extends Hashtable {
        private static final long serialVersionUID = -3060442320477772028L;
        private Project project;

        AntTypeTable(Project project) {
            this.project = project;
        }

        @Override // java.util.Hashtable
        public boolean contains(Object obj) {
            boolean z10;
            if (!(obj instanceof Class)) {
                return false;
            }
            Iterator it = values().iterator();
            loop0: while (true) {
                z10 = false;
                while (it.hasNext() && !z10) {
                    if (((b) it.next()).h(this.project) == obj) {
                        z10 = true;
                    }
                }
            }
            return z10;
        }

        @Override // java.util.Hashtable, java.util.Map
        public boolean containsValue(Object obj) {
            return contains(obj);
        }

        Object create(String str) {
            b definition = getDefinition(str);
            if (definition == null) {
                return null;
            }
            return definition.c(this.project);
        }

        public List findMatches(String str) {
            ArrayList arrayList = new ArrayList();
            for (b bVar : values()) {
                if (bVar.i().startsWith(str)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        @Override // java.util.Hashtable, java.util.Dictionary, java.util.Map
        public Object get(Object obj) {
            return getTypeClass((String) obj);
        }

        b getDefinition(String str) {
            return (b) super.get(str);
        }

        Class getExposedClass(String str) {
            b definition = getDefinition(str);
            if (definition == null) {
                return null;
            }
            return definition.h(this.project);
        }

        Class getTypeClass(String str) {
            b definition = getDefinition(str);
            if (definition == null) {
                return null;
            }
            return definition.j(this.project);
        }
    }

    protected ComponentHelper() {
    }

    private synchronized void b(String str) {
        try {
            String d11 = r.d(str);
            if ("".equals(d11)) {
                d11 = "antlib:org.apache.tools.ant";
            }
            if (d11.startsWith("antlib:")) {
                if (this.f71323f.contains(d11)) {
                    return;
                }
                this.f71323f.add(d11);
                org.apache.tools.ant.taskdefs.n nVar = new org.apache.tools.ant.taskdefs.n();
                nVar.setProject(this.f71326i);
                nVar.l();
                nVar.w(d11);
                nVar.r(d11);
                nVar.G(org.apache.tools.ant.taskdefs.e.D(d11));
                nVar.F(new e.a("ignore"));
                nVar.e();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    static /* synthetic */ Class c(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    public static ComponentHelper j(Project project) {
        if (project == null) {
            return null;
        }
        ComponentHelper componentHelper = (ComponentHelper) project.t("ant.ComponentHelper");
        if (componentHelper != null) {
            return componentHelper;
        }
        ComponentHelper componentHelper2 = new ComponentHelper();
        componentHelper2.u(project);
        project.d("ant.ComponentHelper", componentHelper2);
        return componentHelper2;
    }

    public static String o(Project project, Object obj, boolean z10) {
        if (project == null) {
            project = Project.q(obj);
        }
        return project == null ? p(obj.getClass(), z10) : j(project).n(obj, z10);
    }

    private static String p(Class cls, boolean z10) {
        if (!z10) {
            return cls.toString();
        }
        String name = cls.getName();
        return name.substring(name.lastIndexOf(46) + 1);
    }

    private void q(PrintWriter printWriter, String str, boolean z10, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cause: the class ");
        stringBuffer.append(str);
        stringBuffer.append(" was not found.");
        printWriter.println(stringBuffer.toString());
        if (z10) {
            printWriter.println("        This looks like one of Ant's optional components.");
            printWriter.println("Action: Check that the appropriate optional JAR exists in");
            printWriter.println(str2);
        } else {
            printWriter.println("Action: Check that the component has been correctly declared");
            printWriter.println("        and that the implementing JAR is in one of:");
            printWriter.println(str2);
        }
    }

    private void r(PrintWriter printWriter, boolean z10, NoClassDefFoundError noClassDefFoundError, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Cause: Could not load a dependent class ");
        stringBuffer.append(noClassDefFoundError.getMessage());
        printWriter.println(stringBuffer.toString());
        if (z10) {
            printWriter.println("       It is not enough to have Ant's optional JARs");
            printWriter.println("       you need the JAR files that the optional tasks depend upon.");
            printWriter.println("       Ant's optional task dependencies are listed in the manual.");
        } else {
            printWriter.println("       This class may be in a separate JAR that is not installed.");
        }
        printWriter.println("Action: Determine what extra JAR files are needed, and place them in one of:");
        printWriter.println(str);
    }

    private void s(PrintWriter printWriter, String str, String str2) {
        boolean z10 = str.indexOf("antlib:") == 0;
        String d11 = r.d(str);
        printWriter.println("Cause: The name is undefined.");
        printWriter.println("Action: Check the spelling.");
        printWriter.println("Action: Check that any custom tasks/types have been declared.");
        printWriter.println("Action: Check that any <presetdef>/<macrodef> declarations have taken place.");
        if (d11.length() > 0) {
            List findMatches = this.f71318a.findMatches(d11);
            if (findMatches.size() <= 0) {
                printWriter.println("No types or tasks have been defined in this namespace yet");
                if (z10) {
                    printWriter.println();
                    printWriter.println("This appears to be an antlib declaration. ");
                    printWriter.println("Action: Check that the implementing library exists in one of:");
                    printWriter.println(str2);
                    return;
                }
                return;
            }
            printWriter.println();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("The definitions in the namespace ");
            stringBuffer.append(d11);
            stringBuffer.append(" are:");
            printWriter.println(stringBuffer.toString());
            Iterator it = findMatches.iterator();
            while (it.hasNext()) {
                String c11 = r.c(((b) it.next()).i());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("    ");
                stringBuffer2.append(c11);
                printWriter.println(stringBuffer2.toString());
            }
        }
    }

    private boolean t(b bVar, b bVar2) {
        boolean w11 = w(bVar);
        return w11 == w(bVar2) && (!w11 || bVar.n(bVar2, this.f71326i));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void v(org.apache.tools.ant.b r9) {
        /*
            r8 = this;
            java.lang.String r0 = r9.i()
            org.apache.tools.ant.ComponentHelper$AntTypeTable r1 = r8.f71318a
            monitor-enter(r1)
            r2 = 1
            r8.f71320c = r2     // Catch: java.lang.Throwable -> L1c
            r8.f71322e = r2     // Catch: java.lang.Throwable -> L1c
            org.apache.tools.ant.ComponentHelper$AntTypeTable r3 = r8.f71318a     // Catch: java.lang.Throwable -> L1c
            org.apache.tools.ant.b r3 = r3.getDefinition(r0)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L64
            boolean r4 = r8.t(r9, r3)     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L1e
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1c
            return
        L1c:
            r9 = move-exception
            goto L8e
        L1e:
            org.apache.tools.ant.ComponentHelper$AntTypeTable r4 = r8.f71318a     // Catch: java.lang.Throwable -> L1c
            java.lang.Class r4 = r4.getExposedClass(r0)     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L3a
            java.lang.Class r5 = org.apache.tools.ant.ComponentHelper.f71317k     // Catch: java.lang.Throwable -> L1c
            if (r5 != 0) goto L32
            java.lang.String r5 = "org.apache.tools.ant.Task"
            java.lang.Class r5 = c(r5)     // Catch: java.lang.Throwable -> L1c
            org.apache.tools.ant.ComponentHelper.f71317k = r5     // Catch: java.lang.Throwable -> L1c
        L32:
            boolean r4 = r5.isAssignableFrom(r4)     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L3a
            r4 = r2
            goto L3b
        L3a:
            r4 = 0
        L3b:
            org.apache.tools.ant.Project r5 = r8.f71326i     // Catch: java.lang.Throwable -> L1c
            java.lang.StringBuffer r6 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L1c
            r6.<init>()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r7 = "Trying to override old definition of "
            r6.append(r7)     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L4c
            java.lang.String r4 = "task "
            goto L4e
        L4c:
            java.lang.String r4 = "datatype "
        L4e:
            r6.append(r4)     // Catch: java.lang.Throwable -> L1c
            r6.append(r0)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r4 = r6.toString()     // Catch: java.lang.Throwable -> L1c
            org.apache.tools.ant.Project r6 = r8.f71326i     // Catch: java.lang.Throwable -> L1c
            boolean r3 = r9.u(r3, r6)     // Catch: java.lang.Throwable -> L1c
            if (r3 == 0) goto L61
            r2 = 3
        L61:
            r5.x(r4, r2)     // Catch: java.lang.Throwable -> L1c
        L64:
            org.apache.tools.ant.Project r2 = r8.f71326i     // Catch: java.lang.Throwable -> L1c
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch: java.lang.Throwable -> L1c
            r3.<init>()     // Catch: java.lang.Throwable -> L1c
            java.lang.String r4 = " +Datatype "
            r3.append(r4)     // Catch: java.lang.Throwable -> L1c
            r3.append(r0)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r4 = " "
            r3.append(r4)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r4 = r9.g()     // Catch: java.lang.Throwable -> L1c
            r3.append(r4)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L1c
            r4 = 4
            r2.x(r3, r4)     // Catch: java.lang.Throwable -> L1c
            org.apache.tools.ant.ComponentHelper$AntTypeTable r2 = r8.f71318a     // Catch: java.lang.Throwable -> L1c
            r2.put(r0, r9)     // Catch: java.lang.Throwable -> L1c
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1c
            return
        L8e:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L1c
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tools.ant.ComponentHelper.v(org.apache.tools.ant.b):void");
    }

    private boolean w(b bVar) {
        return (bVar.j(this.f71326i) == null || bVar.h(this.f71326i) == null) ? false : true;
    }

    public void a(b bVar) {
        v(bVar);
    }

    public Object d(String str) {
        b l11 = l(str);
        if (l11 == null) {
            return null;
        }
        return l11.c(this.f71326i);
    }

    public Object e(w wVar, String str, String str2) {
        Object d11 = d(str2);
        if (d11 instanceof u) {
            u uVar = (u) d11;
            uVar.setLocation(wVar.getLocation());
            uVar.s(str2);
            uVar.r(wVar.i());
            uVar.p(wVar.f());
            uVar.l();
        }
        return d11;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01c0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String f(java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 467
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.tools.ant.ComponentHelper.f(java.lang.String, java.lang.String):java.lang.String");
    }

    public void g(String str) {
        this.f71325h = str;
        this.f71324g.push(str);
    }

    public void h() {
        this.f71324g.pop();
        this.f71325h = this.f71324g.size() == 0 ? null : (String) this.f71324g.peek();
    }

    public Class i(String str) {
        b l11 = l(str);
        if (l11 == null) {
            return null;
        }
        return l11.h(this.f71326i);
    }

    public String k() {
        return this.f71325h;
    }

    public b l(String str) {
        b(str);
        return this.f71318a.getDefinition(str);
    }

    public String m(Object obj) {
        return n(obj, false);
    }

    public String n(Object obj, boolean z10) {
        Class cls = obj.getClass();
        String name = cls.getName();
        for (b bVar : this.f71318a.values()) {
            if (name.equals(bVar.g()) && cls == bVar.h(this.f71326i)) {
                String i11 = bVar.i();
                if (z10) {
                    return i11;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The <");
                stringBuffer.append(i11);
                stringBuffer.append("> type");
                return stringBuffer.toString();
            }
        }
        return p(obj.getClass(), z10);
    }

    public void u(Project project) {
        this.f71326i = project;
        this.f71318a = new AntTypeTable(project);
    }
}
