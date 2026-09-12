package org.apache.tools.ant.types;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;
import java.util.Vector;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* loaded from: classes7.dex */
public class m extends e implements Cloneable, u {

    /* renamed from: c, reason: collision with root package name */
    public static m f71616c = new m(null, System.getProperty("java.class.path"));

    /* renamed from: d, reason: collision with root package name */
    public static m f71617d = new m(null, System.getProperty("sun.boot.class.path"));

    /* renamed from: e, reason: collision with root package name */
    private static final Iterator f71618e = Collections.EMPTY_SET.iterator();

    /* renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f71619f;

    /* renamed from: a, reason: collision with root package name */
    private Boolean f71620a;

    /* renamed from: b, reason: collision with root package name */
    private y00.g f71621b;

    /* loaded from: classes7.dex */
    public class a implements u {

        /* renamed from: a, reason: collision with root package name */
        private String[] f71622a;

        public a() {
        }

        @Override // org.apache.tools.ant.types.u
        public boolean a() {
            return true;
        }

        public void b(File file) {
            this.f71622a = new String[]{m.u(file.getAbsolutePath())};
        }

        public void c(String str) {
            this.f71622a = m.w(m.this.getProject(), str);
        }

        @Override // org.apache.tools.ant.types.u
        public Iterator iterator() {
            return new y00.d(null, this.f71622a);
        }

        @Override // org.apache.tools.ant.types.u
        public int size() {
            String[] strArr = this.f71622a;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }
    }

    public m(Project project) {
        this.f71621b = null;
        setProject(project);
    }

    public m(Project project, String str) {
        this(project);
        o().c(str);
    }

    static /* synthetic */ Class k(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    private m l(String str, m mVar) {
        String s11;
        m mVar2 = new m(getProject());
        if (getProject() != null && (s11 = getProject().s("build.sysclasspath")) != null) {
            str = s11;
        }
        if (str.equals("only")) {
            mVar2.g(mVar, true);
        } else if (str.equals("first")) {
            mVar2.g(mVar, true);
            mVar2.f(this);
        } else if (str.equals("ignore")) {
            mVar2.f(this);
        } else {
            if (!str.equals("last")) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("invalid value for build.sysclasspath: ");
                stringBuffer.append(str);
                log(stringBuffer.toString(), 1);
            }
            mVar2.f(this);
            mVar2.g(mVar, true);
        }
        return mVar2;
    }

    private synchronized boolean q() {
        try {
            if (this.f71620a == null) {
                this.f71620a = p() ? Boolean.TRUE : Boolean.FALSE;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f71620a.booleanValue();
    }

    private static File s(Project project, String str) {
        return org.apache.tools.ant.util.d.k().q(project == null ? null : project.m(), str);
    }

    public static String u(String str) {
        if (str == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(str);
        for (int i11 = 0; i11 < stringBuffer.length(); i11++) {
            v(stringBuffer, i11);
        }
        return stringBuffer.toString();
    }

    protected static boolean v(StringBuffer stringBuffer, int i11) {
        if (stringBuffer.charAt(i11) != '/' && stringBuffer.charAt(i11) != '\\') {
            return false;
        }
        stringBuffer.setCharAt(i11, File.separatorChar);
        return true;
    }

    public static String[] w(Project project, String str) {
        Vector vector = new Vector();
        if (str == null) {
            return new String[0];
        }
        org.apache.tools.ant.p pVar = new org.apache.tools.ant.p(str);
        StringBuffer stringBuffer = new StringBuffer();
        while (pVar.a()) {
            String b11 = pVar.b();
            try {
                stringBuffer.append(s(project, b11).getPath());
            } catch (BuildException unused) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Dropping path element ");
                stringBuffer2.append(b11);
                stringBuffer2.append(" as it is not valid relative to the project");
                project.x(stringBuffer2.toString(), 3);
            }
            for (int i11 = 0; i11 < stringBuffer.length(); i11++) {
                v(stringBuffer, i11);
            }
            vector.addElement(stringBuffer.toString());
            stringBuffer = new StringBuffer();
        }
        String[] strArr = new String[vector.size()];
        vector.copyInto(strArr);
        return strArr;
    }

    @Override // org.apache.tools.ant.types.u
    public synchronized boolean a() {
        if (isReference()) {
            return ((m) getCheckedRef()).a();
        }
        dieOnCircularReference();
        j(this.f71621b);
        return true;
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.q
    public Object clone() {
        try {
            m mVar = (m) super.clone();
            y00.g gVar = this.f71621b;
            if (gVar != null) {
                gVar = (y00.g) gVar.clone();
            }
            mVar.f71621b = gVar;
            return mVar;
        } catch (CloneNotSupportedException e11) {
            throw new BuildException(e11);
        }
    }

    public void d(m mVar) {
        if (mVar == this) {
            throw circularReference();
        }
        if (mVar.getProject() == null) {
            mVar.setProject(getProject());
        }
        e(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.types.e
    public synchronized void dieOnCircularReference(Stack stack, Project project) {
        try {
            if (isChecked()) {
                return;
            }
            if (isReference()) {
                super.dieOnCircularReference(stack, project);
            } else {
                y00.g gVar = this.f71621b;
                if (gVar != null) {
                    stack.push(gVar);
                    e.invokeCircularReferenceCheck(this.f71621b, stack, project);
                    stack.pop();
                }
                setChecked(true);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public void e(u uVar) {
        checkChildrenAllowed();
        if (uVar == null) {
            return;
        }
        if (this.f71621b == null) {
            y00.g gVar = new y00.g();
            this.f71621b = gVar;
            gVar.setProject(getProject());
            this.f71621b.j(false);
        }
        this.f71621b.d(uVar);
        setChecked(false);
    }

    public void f(m mVar) {
        g(mVar, false);
    }

    public void g(m mVar, boolean z10) {
        String[] r11 = mVar.r();
        File file = z10 ? new File(System.getProperty("user.dir")) : null;
        for (int i11 = 0; i11 < r11.length; i11++) {
            File s11 = s(getProject(), r11[i11]);
            if (z10 && !s11.exists()) {
                s11 = new File(file, r11[i11]);
            }
            if (s11.exists()) {
                t(s11);
            } else {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("dropping ");
                stringBuffer.append(s11);
                stringBuffer.append(" from path as it doesn't exist");
                log(stringBuffer.toString(), 3);
            }
        }
    }

    public void i(m mVar) {
        if (mVar == null) {
            return;
        }
        d(mVar);
    }

    @Override // org.apache.tools.ant.types.u
    public final synchronized Iterator iterator() {
        if (isReference()) {
            return ((m) getCheckedRef()).iterator();
        }
        dieOnCircularReference();
        if (q()) {
            return new y00.d(null, r());
        }
        y00.g gVar = this.f71621b;
        return gVar == null ? f71618e : j(gVar).iterator();
    }

    protected u j(u uVar) {
        if (uVar == null || uVar.a()) {
            return uVar;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getDataTypeName());
        stringBuffer.append(" allows only filesystem resources.");
        throw new BuildException(stringBuffer.toString());
    }

    public m m(String str) {
        return l(str, f71617d);
    }

    public m n(String str) {
        return l(str, f71616c);
    }

    public a o() {
        if (isReference()) {
            throw noChildrenAllowed();
        }
        a aVar = new a();
        e(aVar);
        return aVar;
    }

    protected boolean p() {
        Class<?> cls = getClass();
        Class cls2 = f71619f;
        if (cls2 == null) {
            cls2 = k("org.apache.tools.ant.types.Path");
            f71619f = cls2;
        }
        if (cls.equals(cls2)) {
            return false;
        }
        try {
            Class<?> declaringClass = getClass().getMethod("list", null).getDeclaringClass();
            Class cls3 = f71619f;
            if (cls3 == null) {
                cls3 = k("org.apache.tools.ant.types.Path");
                f71619f = cls3;
            }
            return !declaringClass.equals(cls3);
        } catch (Exception unused) {
            return false;
        }
    }

    public String[] r() {
        return isReference() ? ((m) getCheckedRef()).r() : j(this.f71621b) == null ? new String[0] : this.f71621b.l();
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.f71621b != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }

    @Override // org.apache.tools.ant.types.u
    public synchronized int size() {
        if (isReference()) {
            return ((m) getCheckedRef()).size();
        }
        dieOnCircularReference();
        y00.g gVar = this.f71621b;
        return gVar == null ? 0 : j(gVar).size();
    }

    public void t(File file) {
        checkAttributesAllowed();
        o().b(file);
    }

    @Override // org.apache.tools.ant.types.e
    public String toString() {
        if (isReference()) {
            return getCheckedRef().toString();
        }
        y00.g gVar = this.f71621b;
        return gVar == null ? "" : gVar.toString();
    }
}
