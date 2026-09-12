package org.apache.tools.ant;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class d extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Method f71373b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ o f71374c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(o oVar, Method method, Method method2) {
        super(method);
        this.f71374c = oVar;
        this.f71373b = method2;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        try {
            this.f71373b.invoke(obj, new Long(org.apache.tools.ant.util.p.a(str)));
        } catch (IllegalAccessException e11) {
            throw e11;
        } catch (InvocationTargetException e12) {
            throw e12;
        } catch (Exception e13) {
            throw new BuildException(e13);
        }
    }
}
