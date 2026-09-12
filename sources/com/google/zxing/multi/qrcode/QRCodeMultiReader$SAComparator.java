package com.google.zxing.multi.qrcode;

import com.google.zxing.ResultMetadataType;
import com.google.zxing.j;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;

/* loaded from: classes4.dex */
final class QRCodeMultiReader$SAComparator implements Comparator<j>, Serializable {
    private QRCodeMultiReader$SAComparator() {
    }

    @Override // java.util.Comparator
    public int compare(j jVar, j jVar2) {
        Map d11 = jVar.d();
        ResultMetadataType resultMetadataType = ResultMetadataType.STRUCTURED_APPEND_SEQUENCE;
        return Integer.compare(((Integer) d11.get(resultMetadataType)).intValue(), ((Integer) jVar2.d().get(resultMetadataType)).intValue());
    }
}
