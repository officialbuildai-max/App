package org.apache.tools.ant;

import java.lang.reflect.Method;
import org.apache.tools.ant.o;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class i extends o.b {

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ String f71384b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ Method f71385c;

    /* renamed from: d, reason: collision with root package name */
    private final /* synthetic */ o f71386d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(o oVar, Method method, String str, Method method2) {
        super(method);
        this.f71386d = oVar;
        this.f71384b = str;
        this.f71385c = method2;
    }

    @Override // org.apache.tools.ant.o.b
    public void a(Project project, Object obj, String str) {
        if (str.length() != 0) {
            this.f71385c.invoke(obj, new Character(str.charAt(0)));
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("The value \"\" is not a legal value for attribute \"");
        stringBuffer.append(this.f71384b);
        stringBuffer.append("\"");
        throw new BuildException(stringBuffer.toString());
    }
}
