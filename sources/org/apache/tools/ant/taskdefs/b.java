package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.u;

/* loaded from: classes7.dex */
public class b extends u {

    /* renamed from: g, reason: collision with root package name */
    private String f71469g = "";

    /* renamed from: h, reason: collision with root package name */
    private ClassLoader f71470h;

    public ClassLoader t() {
        return this.f71470h;
    }

    public String u() {
        return this.f71469g;
    }

    public void v(ClassLoader classLoader) {
        this.f71470h = classLoader;
    }

    public void w(String str) {
        if (str.equals("antlib:org.apache.tools.ant")) {
            str = "";
        }
        if (!str.startsWith("ant:")) {
            this.f71469g = str;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attempt to use a reserved URI ");
        stringBuffer.append(str);
        throw new BuildException(stringBuffer.toString());
    }
}
