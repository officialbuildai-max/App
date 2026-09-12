package mo;

import androidx.media3.common.f0;
import androidx.media3.common.i0;
import androidx.media3.common.r;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.r4;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class a {
    public static final f0 a(i0 i0Var, d mediaTrackGroup) {
        Intrinsics.h(i0Var, "<this>");
        Intrinsics.h(mediaTrackGroup, "mediaTrackGroup");
        r4 it = i0Var.a().iterator();
        Intrinsics.g(it, "iterator(...)");
        while (it.hasNext()) {
            i0.a aVar = (i0.a) it.next();
            if (Intrinsics.c(aVar.a().f10054b, mediaTrackGroup.c()) && aVar.a().f10055c == mediaTrackGroup.e()) {
                return aVar.a();
            }
        }
        return null;
    }

    public static final b b(r rVar) {
        Intrinsics.h(rVar, "<this>");
        return new b(rVar.f10229a, rVar.f10230b, rVar.f10232d, rVar.f10233e, rVar.f10236h, rVar.f10237i, rVar.f10238j, rVar.f10239k, rVar.f10250v, rVar.f10251w, rVar.f10252x, rVar.f10253y, rVar.f10254z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final c c(i0 i0Var) {
        Intrinsics.h(i0Var, "<this>");
        if (i0Var.b()) {
            return new c(null, 1, null);
        }
        int size = i0Var.a().size();
        d[] dVarArr = new d[size];
        for (int i11 = 0; i11 < size; i11++) {
            E e11 = i0Var.a().get(i11);
            Intrinsics.g(e11, "get(...)");
            dVarArr[i11] = d((i0.a) e11);
        }
        ImmutableList copyOf = ImmutableList.copyOf(dVarArr);
        Intrinsics.g(copyOf, "copyOf(...)");
        return new c(copyOf);
    }

    public static final d d(i0.a aVar) {
        Intrinsics.h(aVar, "<this>");
        int i11 = aVar.f10173a;
        b[] bVarArr = new b[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            r b11 = aVar.b(i12);
            Intrinsics.g(b11, "getTrackFormat(...)");
            bVarArr[i12] = b(b11);
        }
        return new d(aVar.f10173a, aVar.a().f10054b, aVar.a().f10055c, aVar.e(), bVarArr);
    }
}
