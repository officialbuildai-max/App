package org.apache.tools.ant;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ boolean f71375b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Constructor f71376c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ Method f71377d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ o f71378e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(o oVar, Method method, boolean z10, Constructor constructor, Method method2) {
        super(method);
        this.f71378e = oVar;
        this.f71375b = z10;
        this.f71376c = constructor;
        this.f71377d = method2;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        try {
            Object newInstance = this.f71376c.newInstance(this.f71375b ? new Object[]{project, str} : new Object[]{str});
            if (project != null) {
                project.K(newInstance);
            }
            this.f71377d.invoke(obj, newInstance);
        } catch (InstantiationException e11) {
            throw new BuildException(e11);
        }
    }
}
