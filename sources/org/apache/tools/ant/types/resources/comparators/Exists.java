package org.apache.tools.ant.types.resources.comparators;

import org.apache.tools.ant.types.t;

/* loaded from: classes7.dex */
public class Exists extends ResourceComparator {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        boolean k11 = tVar.k();
        if (k11 == tVar2.k()) {
            return 0;
        }
        return k11 ? 1 : -1;
    }
}
