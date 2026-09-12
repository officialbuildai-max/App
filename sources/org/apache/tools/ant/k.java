package org.apache.tools.ant;

import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class k extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Method f71389b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ o f71390c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(o oVar, Method method, Method method2) {
        super(method);
        this.f71390c = oVar;
        this.f71389b = method2;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        try {
            this.f71389b.invoke(obj, Class.forName(str));
        } catch (ClassNotFoundException e11) {
            throw new BuildException(e11);
        }
    }
}
