package org.apache.tools.ant.types;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;

/* loaded from: classes7.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private String f71651a;

    /* renamed from: b, reason: collision with root package name */
    private Project f71652b;

    public String a() {
        return this.f71651a;
    }

    public Object b(Project project) {
        String str = this.f71651a;
        if (str == null) {
            throw new BuildException("No reference specified");
        }
        Project project2 = this.f71652b;
        Object t11 = project2 == null ? project.t(str) : project2.t(str);
        if (t11 != null) {
            return t11;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Reference ");
        stringBuffer.append(this.f71651a);
        stringBuffer.append(" not found.");
        throw new BuildException(stringBuffer.toString());
    }
}
