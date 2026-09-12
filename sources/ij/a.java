package ij;

import a4.d;
import android.database.Cursor;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class a {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b(d dVar, String str, String str2) {
        Cursor i02 = dVar.i0("PRAGMA table_info(" + str + ")");
        try {
            int columnIndex = i02.getColumnIndex("name");
            if (columnIndex < 0) {
                CloseableKt.a(i02, null);
                return false;
            }
            while (i02.moveToNext()) {
                if (Intrinsics.c(i02.getString(columnIndex), str2)) {
                    CloseableKt.a(i02, null);
                    return true;
                }
            }
            Unit unit = Unit.f67184a;
            CloseableKt.a(i02, null);
            return false;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(i02, th2);
                throw th3;
            }
        }
    }
}
