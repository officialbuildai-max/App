package org.apache.tools.ant;

import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f extends o.e {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Object f71379b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Object f71380c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ o f71381d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(o oVar, Method method, Object obj, Object obj2) {
        super(method);
        this.f71381d = oVar;
        this.f71379b = obj;
        this.f71380c = obj2;
    }

    @Override // org.apache.tools.ant.o.e
    Object a(Project project, Object obj, Object obj2) {
        if (!b().getName().endsWith("Configured")) {
            b().invoke(obj, this.f71379b);
        }
        return this.f71380c;
    }

    @Override // org.apache.tools.ant.o.e
    void d(Object obj, Object obj2) {
        if (b().getName().endsWith("Configured")) {
            b().invoke(obj, this.f71379b);
        }
    }
}
