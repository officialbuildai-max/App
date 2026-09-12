package org.apache.tools.ant;

import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class j extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Method f71387b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ o f71388c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(o oVar, Method method, Method method2) {
        super(method);
        this.f71388c = oVar;
        this.f71387b = method2;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        this.f71387b.invoke(obj, Project.N(str) ? Boolean.TRUE : Boolean.FALSE);
    }
}
