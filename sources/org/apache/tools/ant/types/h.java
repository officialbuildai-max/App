package org.apache.tools.ant.types;

import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public class h extends e implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private Vector f71594a = new Vector();

    public Vector e() {
        return this.f71594a;
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (!this.f71594a.isEmpty()) {
            throw tooManyAttributes();
        }
        Object b11 = rVar.b(getProject());
        if (b11 instanceof h) {
            this.f71594a = ((h) b11).e();
            super.setRefid(rVar);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(rVar.a());
            stringBuffer.append(" doesn't refer to a FilterChain");
            throw new BuildException(stringBuffer.toString());
        }
    }
}
