package a10;

import android.support.v4.media.session.c;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Project;
import org.apache.tools.ant.util.f;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    static /* synthetic */ Class f108a;

    /* renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f109b;

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e11) {
            throw new NoClassDefFoundError(e11.getMessage());
        }
    }

    static Throwable e(Throwable th2, BuildException buildException, boolean z10) {
        if (th2 != null) {
            return th2;
        }
        Throwable exception = buildException.getException();
        if (z10 && (exception instanceof ClassNotFoundException)) {
            return null;
        }
        return exception;
    }

    protected a b(String str) {
        Class cls = f108a;
        if (cls == null) {
            cls = a("org.apache.tools.ant.util.regexp.RegexpMatcherFactory");
            f108a = cls;
        }
        ClassLoader classLoader = cls.getClassLoader();
        Class cls2 = f109b;
        if (cls2 == null) {
            cls2 = a("org.apache.tools.ant.util.regexp.RegexpMatcher");
            f109b = cls2;
        }
        c.a(org.apache.tools.ant.util.a.f(str, classLoader, cls2));
        return null;
    }

    public a c() {
        d(null);
        return null;
    }

    public a d(Project project) {
        String str;
        String property = project == null ? System.getProperty("ant.regexp.regexpimpl") : project.s("ant.regexp.regexpimpl");
        if (property != null) {
            b(property);
            return null;
        }
        try {
            f("java.util.regex.Matcher");
            b("org.apache.tools.ant.util.regexp.Jdk14RegexpMatcher");
            return null;
        } catch (BuildException e11) {
            Throwable e12 = e(null, e11, f.f() < 14);
            try {
                f("org.apache.oro.text.regex.Pattern");
                b("org.apache.tools.ant.util.regexp.JakartaOroMatcher");
                return null;
            } catch (BuildException e13) {
                Throwable e14 = e(e12, e13, true);
                try {
                    f("org.apache.regexp.RE");
                    b("org.apache.tools.ant.util.regexp.JakartaRegexpMatcher");
                    return null;
                } catch (BuildException e15) {
                    Throwable e16 = e(e14, e15, true);
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("No supported regular expression matcher found");
                    if (e16 != null) {
                        StringBuffer stringBuffer2 = new StringBuffer();
                        stringBuffer2.append(": ");
                        stringBuffer2.append(e16);
                        str = stringBuffer2.toString();
                    } else {
                        str = "";
                    }
                    stringBuffer.append(str);
                    throw new BuildException(stringBuffer.toString(), e16);
                }
            }
        }
    }

    protected void f(String str) {
        try {
            Class.forName(str);
        } catch (Throwable th2) {
            throw new BuildException(th2);
        }
    }
}
