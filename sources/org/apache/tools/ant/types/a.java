package org.apache.tools.ant.types;

import java.util.Vector;
import org.apache.tools.ant.BuildException;

/* loaded from: classes7.dex */
public final class a extends e implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    private String f71565a;

    /* renamed from: b, reason: collision with root package name */
    private final Vector f71566b = new Vector();

    /* renamed from: c, reason: collision with root package name */
    private m f71567c;

    public void d(l lVar) {
        this.f71566b.addElement(lVar);
    }

    public String e() {
        return this.f71565a;
    }

    public m f() {
        return this.f71567c;
    }

    public l[] g() {
        l[] lVarArr = new l[this.f71566b.size()];
        this.f71566b.copyInto(lVarArr);
        return lVarArr;
    }

    public void i(String str) {
        this.f71565a = str;
    }

    public void j(m mVar) {
        if (isReference()) {
            throw tooManyAttributes();
        }
        m mVar2 = this.f71567c;
        if (mVar2 == null) {
            this.f71567c = mVar;
        } else {
            mVar2.i(mVar);
        }
    }

    @Override // org.apache.tools.ant.types.e
    public void setRefid(r rVar) {
        if (!this.f71566b.isEmpty() || this.f71565a != null || this.f71567c != null) {
            throw tooManyAttributes();
        }
        Object b11 = rVar.b(getProject());
        if (!(b11 instanceof a)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(rVar.a());
            stringBuffer.append(" doesn't refer to a FilterReader");
            throw new BuildException(stringBuffer.toString());
        }
        a aVar = (a) b11;
        i(aVar.e());
        j(aVar.f());
        l[] g11 = aVar.g();
        if (g11 != null) {
            for (l lVar : g11) {
                d(lVar);
            }
        }
        super.setRefid(rVar);
    }
}
