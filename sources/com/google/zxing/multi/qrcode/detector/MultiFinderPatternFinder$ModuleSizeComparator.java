package com.google.zxing.multi.qrcode.detector;

import com.google.zxing.qrcode.detector.d;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes4.dex */
final class MultiFinderPatternFinder$ModuleSizeComparator implements Comparator<d>, Serializable {
    private MultiFinderPatternFinder$ModuleSizeComparator() {
    }

    @Override // java.util.Comparator
    public int compare(d dVar, d dVar2) {
        double i11 = dVar2.i() - dVar.i();
        if (i11 < 0.0d) {
            return -1;
        }
        return i11 > 0.0d ? 1 : 0;
    }
}
