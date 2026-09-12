package x;

import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class f {
    public static final void a(d dVar, SparseArray sparseArray) {
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            int keyAt = sparseArray.keyAt(i11);
            AutofillValue a11 = e.a(sparseArray.get(keyAt));
            r rVar = r.f78119a;
            if (rVar.d(a11)) {
                dVar.b().b(keyAt, rVar.i(a11).toString());
            } else {
                if (rVar.b(a11)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
                }
                if (rVar.c(a11)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
                }
                if (rVar.e(a11)) {
                    throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
                }
            }
        }
    }

    public static final void b(d dVar, ViewStructure viewStructure) {
        int a11 = h.f78118a.a(viewStructure, dVar.b().a().size());
        for (Map.Entry entry : dVar.b().a().entrySet()) {
            int intValue = ((Number) entry.getKey()).intValue();
            android.support.v4.media.session.c.a(entry.getValue());
            h hVar = h.f78118a;
            ViewStructure b11 = hVar.b(viewStructure, a11);
            if (b11 != null) {
                r rVar = r.f78119a;
                AutofillId a12 = rVar.a(viewStructure);
                Intrinsics.e(a12);
                rVar.g(b11, a12, intValue);
                hVar.d(b11, intValue, dVar.c().getContext().getPackageName(), null, null);
                rVar.h(b11, x.f78122a.a());
                throw null;
            }
            a11++;
        }
    }
}
