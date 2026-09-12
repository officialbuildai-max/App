package org.apache.tools.ant.taskdefs;

import java.io.IOException;
import org.apache.tools.ant.q;

/* loaded from: classes7.dex */
public class j extends org.apache.tools.ant.util.j {

    /* renamed from: c, reason: collision with root package name */
    private q f71517c;

    /* renamed from: d, reason: collision with root package name */
    private int f71518d;

    public j(q qVar) {
        this.f71518d = 2;
        this.f71517c = qVar;
    }

    public j(q qVar, int i11) {
        this(qVar);
        this.f71518d = i11;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.util.j
    public void d() {
        try {
            super.d();
        } catch (IOException e11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Impossible IOException caught: ");
            stringBuffer.append(e11);
            throw new RuntimeException(stringBuffer.toString());
        }
    }

    @Override // org.apache.tools.ant.util.j
    protected void h(String str) {
        i(str, this.f71518d);
    }

    protected void i(String str, int i11) {
        this.f71517c.log(str, i11);
    }
}
