package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* loaded from: classes7.dex */
public class Type extends ResourceComparator {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        boolean j11 = tVar.j();
        if (j11 == tVar2.j()) {
            return 0;
        }
        return j11 ? 1 : -1;
    }
}
