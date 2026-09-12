package org.apache.tools.ant;

import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class l extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Method f71391b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ o f71392c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(o oVar, Method method, Method method2) {
        super(method);
        this.f71392c = oVar;
        this.f71391b = method2;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        this.f71391b.invoke(obj, project.D(str));
    }
}
