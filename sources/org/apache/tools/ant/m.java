package org.apache.tools.ant;

import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Class f71393b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Method f71394c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ o f71395d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(o oVar, Method method, Class cls, Method method2) {
        super(method);
        this.f71395d = oVar;
        this.f71393b = cls;
        this.f71394c = method2;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        try {
            org.apache.tools.ant.types.f fVar = (org.apache.tools.ant.types.f) this.f71393b.newInstance();
            fVar.e(str);
            this.f71394c.invoke(obj, fVar);
        } catch (InstantiationException e11) {
            throw new BuildException(e11);
        }
    }
}
