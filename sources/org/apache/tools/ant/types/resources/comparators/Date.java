package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* loaded from: classes7.dex */
public class Date extends ResourceComparator {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        long f11 = tVar.f() - tVar2.f();
        if (f11 > 0) {
            return 1;
        }
        return f11 < 0 ? -1 : 0;
    }
}
