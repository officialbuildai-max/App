package org.apache.tools.ant.types;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* loaded from: classes7.dex */
public class b extends e implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private Boolean f71568a;

    /* renamed from: b, reason: collision with root package name */
    private ArrayList f71569b = new ArrayList();

    /* loaded from: classes7.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        private String f71570a;

        /* renamed from: b, reason: collision with root package name */
        private String f71571b;

        protected String a() {
            return this.f71571b;
        }

        public abstract String b();

        protected String c() {
            return this.f71570a;
        }

        public String d() {
            if (c() != null && a() != null) {
                throw new BuildException("Both package and class have been set");
            }
            StringBuffer stringBuffer = new StringBuffer(b());
            if (c() != null) {
                stringBuffer.append(':');
                stringBuffer.append(c());
                if (!stringBuffer.toString().endsWith("...")) {
                    stringBuffer.append("...");
                }
            } else if (a() != null) {
                stringBuffer.append(':');
                stringBuffer.append(a());
            }
            return stringBuffer.toString();
        }
    }

    private b e() {
        if (getRefid() == null) {
            return this;
        }
        Object b11 = getRefid().b(getProject());
        if (b11 instanceof b) {
            return (b) b11;
        }
        throw new BuildException("reference is of wrong type");
    }

    @Override // org.apache.tools.ant.types.e, org.apache.tools.ant.q
    public Object clone() {
        b bVar = (b) super.clone();
        bVar.f71569b = (ArrayList) this.f71569b.clone();
        return bVar;
    }

    public void d(ListIterator listIterator) {
        getProject().x("Applying assertions", 4);
        b e11 = e();
        if (Boolean.TRUE.equals(e11.f71568a)) {
            getProject().x("Enabling system assertions", 4);
            listIterator.add("-enablesystemassertions");
        } else if (Boolean.FALSE.equals(e11.f71568a)) {
            getProject().x("disabling system assertions", 4);
            listIterator.add("-disablesystemassertions");
        }
        Iterator it = e11.f71569b.iterator();
        while (it.hasNext()) {
            String d11 = ((a) it.next()).d();
            Project project = getProject();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("adding assertion ");
            stringBuffer.append(d11);
            project.x(stringBuffer.toString(), 4);
            listIterator.add(d11);
        }
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (this.f71569b.size() > 0 || this.f71568a != null) {
            throw tooManyAttributes();
        }
        super.setRefid(rVar);
    }
}
