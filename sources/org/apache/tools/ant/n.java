package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class n extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Method f71396b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Class f71397c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ o f71398d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(o oVar, Method method, Method method2, Class cls) {
        super(method);
        this.f71398d = oVar;
        this.f71396b = method2;
        this.f71397c = cls;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        try {
            Method method = this.f71396b;
            Class cls = this.f71397c;
            Class<?> cls2 = o.f71411t;
            if (cls2 == null) {
                cls2 = o.c("java.lang.String");
                o.f71411t = cls2;
            }
            method.invoke(obj, cls.getMethod("valueOf", cls2).invoke(null, str));
        } catch (InvocationTargetException e11) {
            if (!(e11.getTargetException() instanceof IllegalArgumentException)) {
                throw o.g(e11);
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("'");
            stringBuffer.append(str);
            stringBuffer.append("' is not a permitted value for ");
            stringBuffer.append(this.f71397c.getName());
            throw new BuildException(stringBuffer.toString());
        } catch (Exception e12) {
            throw new BuildException(e12);
        }
    }
}
