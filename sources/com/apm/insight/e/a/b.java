package com.apm.insight.e.a;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;

/* loaded from: classes2.dex */
public final class b extends a<com.apm.insight.d.a> {
    public b() {
        super("duplicatelog");
    }

    @Override // com.apm.insight.e.a.a
    protected final /* synthetic */ ContentValues a(com.apm.insight.d.a aVar) {
        com.apm.insight.d.a aVar2 = aVar;
        ContentValues contentValues = new ContentValues();
        contentValues.put("path", aVar2.f19528a);
        contentValues.put("insert_time", Long.valueOf(aVar2.f19529b));
        return contentValues;
    }

    @Override // com.apm.insight.e.a.a
    protected final HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("path", "TEXT");
        hashMap.put("insert_time", "INTEGER");
        hashMap.put("ext1", "TEXT");
        hashMap.put("ext2", "TEXT");
        return hashMap;
    }

    @Override // com.apm.insight.e.a.a
    public final void a(SQLiteDatabase sQLiteDatabase, com.apm.insight.d.a aVar) {
        if (aVar == null || a(sQLiteDatabase, aVar.f19528a)) {
            return;
        }
        super.a(sQLiteDatabase, (SQLiteDatabase) aVar);
        try {
            sQLiteDatabase.execSQL("delete from " + this.f19560a + " where _id in (select _id from " + this.f19560a + " order by insert_time desc limit 1000 offset 500)");
        } catch (Exception e11) {
            com.apm.insight.a.b((Throwable) e11);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = 0
            if (r11 == 0) goto L2e
            boolean r1 = android.text.TextUtils.isEmpty(r12)
            if (r1 == 0) goto La
            goto L2e
        La:
            java.lang.String r3 = r10.f19560a     // Catch: java.lang.Throwable -> L25
            java.lang.String r5 = "path=?"
            java.lang.String[] r6 = new java.lang.String[]{r12}     // Catch: java.lang.Throwable -> L25
            r8 = 0
            r9 = 0
            r4 = 0
            r7 = 0
            r2 = r11
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L25
            int r12 = r11.getCount()     // Catch: java.lang.Throwable -> L25
            r11.close()     // Catch: java.lang.Throwable -> L23
            goto L2a
        L23:
            r11 = move-exception
            goto L27
        L25:
            r11 = move-exception
            r12 = r0
        L27:
            com.apm.insight.a.b(r11)
        L2a:
            if (r12 <= 0) goto L2e
            r11 = 1
            return r11
        L2e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apm.insight.e.a.b.a(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
    }
}
