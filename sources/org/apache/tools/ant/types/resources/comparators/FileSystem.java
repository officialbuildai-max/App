package org.apache.tools.ant.types.resources.comparators;

import java.io.File;
import org.apache.tools.ant.types.t;
import org.apache.tools.ant.util.d;
import y00.c;

/* loaded from: classes7.dex */
public class FileSystem extends ResourceComparator {
    private static final d FILE_UTILS = d.k();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.apache.tools.ant.types.resources.comparators.ResourceComparator
    public int resourceCompare(t tVar, t tVar2) {
        File r11 = ((c) tVar).r();
        File r12 = ((c) tVar2).r();
        if (r11.equals(r12)) {
            return 0;
        }
        d dVar = FILE_UTILS;
        if (dVar.n(r11, r12)) {
            return -1;
        }
        return dVar.o(r11.getAbsolutePath()).compareTo(dVar.o(r12.getAbsolutePath()));
    }
}
