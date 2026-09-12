package c4;

import android.database.sqlite.SQLiteDatabase;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b implements z3.c {
    @Override // z3.c
    public z3.b open(String fileName) {
        Intrinsics.h(fileName, "fileName");
        SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(fileName, (SQLiteDatabase.CursorFactory) null);
        Intrinsics.e(openOrCreateDatabase);
        return new a(openOrCreateDatabase);
    }
}
