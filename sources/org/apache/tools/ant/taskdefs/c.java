package org.apache.tools.ant.taskdefs;

import org.apache.tools.ant.util.a;

/* loaded from: classes7.dex */
public abstract class c extends b {

    /* renamed from: i, reason: collision with root package name */
    private ClassLoader f71471i;

    /* renamed from: j, reason: collision with root package name */
    private a.C0893a f71472j;

    private a.C0893a y() {
        if (this.f71472j == null) {
            this.f71472j = org.apache.tools.ant.util.a.c(this);
        }
        return this.f71472j;
    }

    @Override // org.apache.tools.ant.u
    public void l() {
        super.l();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ClassLoader x() {
        if (t() != null && this.f71472j == null) {
            return t();
        }
        if (this.f71471i == null) {
            ClassLoader b11 = y().b();
            this.f71471i = b11;
            ((org.apache.tools.ant.a) b11).h("org.apache.tools.ant");
        }
        return this.f71471i;
    }
}
