package androidx.room.util;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class l {
    public static final int a(z3.e eVar, String name) {
        Intrinsics.h(eVar, "<this>");
        Intrinsics.h(name, "name");
        int columnCount = eVar.getColumnCount();
        for (int i11 = 0; i11 < columnCount; i11++) {
            if (Intrinsics.c(name, eVar.getColumnName(i11))) {
                return i11;
            }
        }
        return -1;
    }

    public static final int b(z3.e stmt, String name) {
        Intrinsics.h(stmt, "stmt");
        Intrinsics.h(name, "name");
        return k.a(stmt, name);
    }

    public static final int c(z3.e stmt, String name) {
        Intrinsics.h(stmt, "stmt");
        Intrinsics.h(name, "name");
        int a11 = k.a(stmt, name);
        if (a11 >= 0) {
            return a11;
        }
        int columnCount = stmt.getColumnCount();
        ArrayList arrayList = new ArrayList(columnCount);
        for (int i11 = 0; i11 < columnCount; i11++) {
            arrayList.add(stmt.getColumnName(i11));
        }
        throw new IllegalArgumentException("Column '" + name + "' does not exist. Available columns: [" + CollectionsKt.s0(arrayList, null, null, null, 0, null, null, 63, null) + ']');
    }
}
