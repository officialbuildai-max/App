package androidx.appcompat.app;

import java.util.LinkedHashSet;
import java.util.Locale;

/* loaded from: classes.dex */
abstract class z {
    private static androidx.core.os.i a(androidx.core.os.i iVar, androidx.core.os.i iVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i11 = 0;
        while (i11 < iVar.g() + iVar2.g()) {
            Locale d11 = i11 < iVar.g() ? iVar.d(i11) : iVar2.d(i11 - iVar.g());
            if (d11 != null) {
                linkedHashSet.add(d11);
            }
            i11++;
        }
        return androidx.core.os.i.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static androidx.core.os.i b(androidx.core.os.i iVar, androidx.core.os.i iVar2) {
        return (iVar == null || iVar.f()) ? androidx.core.os.i.e() : a(iVar, iVar2);
    }
}
