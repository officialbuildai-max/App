package com.journeyapps.barcodescanner.camera;

import android.graphics.Rect;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import xe.q;

/* loaded from: classes4.dex */
public class LegacyPreviewScalingStrategy extends PreviewScalingStrategy {
    public static q e(q qVar, q qVar2) {
        q e11;
        if (qVar2.b(qVar)) {
            while (true) {
                e11 = qVar.e(2, 3);
                q e12 = qVar.e(1, 2);
                if (!qVar2.b(e12)) {
                    break;
                }
                qVar = e12;
            }
            return qVar2.b(e11) ? e11 : qVar;
        }
        do {
            q e13 = qVar.e(3, 2);
            qVar = qVar.e(2, 1);
            if (qVar2.b(e13)) {
                return e13;
            }
        } while (!qVar2.b(qVar));
        return qVar;
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public q b(List list, final q qVar) {
        if (qVar == null) {
            return (q) list.get(0);
        }
        Collections.sort(list, new Comparator<q>() { // from class: com.journeyapps.barcodescanner.camera.LegacyPreviewScalingStrategy.1
            @Override // java.util.Comparator
            public int compare(q qVar2, q qVar3) {
                int i11 = LegacyPreviewScalingStrategy.e(qVar2, qVar).f78357a - qVar2.f78357a;
                int i12 = LegacyPreviewScalingStrategy.e(qVar3, qVar).f78357a - qVar3.f78357a;
                if (i11 == 0 && i12 == 0) {
                    return qVar2.compareTo(qVar3);
                }
                if (i11 == 0) {
                    return -1;
                }
                if (i12 == 0) {
                    return 1;
                }
                return (i11 >= 0 || i12 >= 0) ? (i11 <= 0 || i12 <= 0) ? i11 < 0 ? -1 : 1 : -qVar2.compareTo(qVar3) : qVar2.compareTo(qVar3);
            }
        });
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Viewfinder size: ");
        sb2.append(qVar);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Preview in order of preference: ");
        sb3.append(list);
        return (q) list.get(0);
    }

    @Override // com.journeyapps.barcodescanner.camera.PreviewScalingStrategy
    public Rect d(q qVar, q qVar2) {
        q e11 = e(qVar, qVar2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Preview: ");
        sb2.append(qVar);
        sb2.append("; Scaled: ");
        sb2.append(e11);
        sb2.append("; Want: ");
        sb2.append(qVar2);
        int i11 = (e11.f78357a - qVar2.f78357a) / 2;
        int i12 = (e11.f78358b - qVar2.f78358b) / 2;
        return new Rect(-i11, -i12, e11.f78357a - i11, e11.f78358b - i12);
    }
}
