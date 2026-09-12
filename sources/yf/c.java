package yf;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class c {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String c(List list, d dVar) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb2.append(((d) it.next()).d());
            sb2.append("-->");
        }
        if (dVar != null) {
            sb2.append(dVar.d());
        }
        String sb3 = sb2.toString();
        Intrinsics.g(sb3, "toString(...)");
        return sb3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(Set set) {
        return (set == null || set.isEmpty()) ? false : true;
    }
}
