package org.apache.tools.ant.util;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* loaded from: classes7.dex */
public class a {

    /* renamed from: org.apache.tools.ant.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0893a {

        /* renamed from: a, reason: collision with root package name */
        private final org.apache.tools.ant.q f71669a;

        /* renamed from: b, reason: collision with root package name */
        private org.apache.tools.ant.types.m f71670b;

        /* renamed from: c, reason: collision with root package name */
        private String f71671c;

        /* renamed from: d, reason: collision with root package name */
        private String f71672d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f71673e = false;

        C0893a(org.apache.tools.ant.q qVar) {
            this.f71669a = qVar;
        }

        private Project c() {
            return this.f71669a.getProject();
        }

        public String a() {
            String str = this.f71672d;
            if (str != null || this.f71671c == null) {
                return str;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ant.loader.");
            stringBuffer.append(this.f71671c);
            return stringBuffer.toString();
        }

        public ClassLoader b() {
            return a.b(c(), this.f71670b, a(), this.f71673e, this.f71672d != null || a.e(c()));
        }
    }

    public static ClassLoader b(Project project, org.apache.tools.ant.types.m mVar, String str, boolean z10, boolean z11) {
        ClassLoader classLoader;
        if (str == null || !z11) {
            classLoader = null;
        } else {
            Object t11 = project.t(str);
            if (t11 != null && !(t11 instanceof ClassLoader)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("The specified loader id ");
                stringBuffer.append(str);
                stringBuffer.append(" does not reference a class loader");
                throw new BuildException(stringBuffer.toString());
            }
            classLoader = (ClassLoader) t11;
        }
        if (classLoader == null) {
            classLoader = d(project, mVar, z10);
            if (str != null && z11) {
                project.d(str, classLoader);
            }
        }
        return classLoader;
    }

    public static C0893a c(org.apache.tools.ant.q qVar) {
        return new C0893a(qVar);
    }

    public static ClassLoader d(Project project, org.apache.tools.ant.types.m mVar, boolean z10) {
        org.apache.tools.ant.a g11 = project.g(mVar);
        if (z10) {
            g11.G(false);
            g11.e();
        }
        return g11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean e(Project project) {
        return project.s("ant.reuse.loader") != null;
    }

    public static Object f(String str, ClassLoader classLoader, Class cls) {
        try {
            Object newInstance = Class.forName(str, true, classLoader).newInstance();
            if (cls.isInstance(newInstance)) {
                return newInstance;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Class of unexpected Type: ");
            stringBuffer.append(str);
            stringBuffer.append(" expected :");
            stringBuffer.append(cls);
            throw new BuildException(stringBuffer.toString());
        } catch (ClassNotFoundException e11) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Class not found: ");
            stringBuffer2.append(str);
            throw new BuildException(stringBuffer2.toString(), e11);
        } catch (IllegalAccessException e12) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("Could not instantiate ");
            stringBuffer3.append(str);
            stringBuffer3.append(". Specified class should have a ");
            stringBuffer3.append("public constructor.");
            throw new BuildException(stringBuffer3.toString(), e12);
        } catch (InstantiationException e13) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("Could not instantiate ");
            stringBuffer4.append(str);
            stringBuffer4.append(". Specified class should have a no ");
            stringBuffer4.append("argument constructor.");
            throw new BuildException(stringBuffer4.toString(), e13);
        } catch (LinkageError e14) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("Class ");
            stringBuffer5.append(str);
            stringBuffer5.append(" could not be loaded because of an invalid dependency.");
            throw new BuildException(stringBuffer5.toString(), e14);
        }
    }
}
