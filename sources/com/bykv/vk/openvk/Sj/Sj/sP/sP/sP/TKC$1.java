package com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;

import android.database.sqlite.SQLiteStatement;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;

/* loaded from: classes2.dex */
class TKC$1 implements Runnable {
    final /* synthetic */ sP.d Sj;
    final /* synthetic */ sP.e sP;

    TKC$1(sP.e eVar, sP.d dVar) {
        this.Sj = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        SQLiteStatement sQLiteStatement;
        SQLiteStatement sQLiteStatement2;
        SQLiteStatement sQLiteStatement3;
        SQLiteStatement sQLiteStatement4;
        SQLiteStatement sQLiteStatement5;
        SQLiteStatement sQLiteStatement6;
        SQLiteStatement sQLiteStatement7;
        SQLiteStatement sQLiteStatement8;
        sP.c cVar;
        try {
            sQLiteStatement = this.sP.f20355b;
            if (sQLiteStatement == null) {
                sP.e eVar = this.sP;
                cVar = eVar.f20354a;
                eVar.f20355b = cVar.getWritableDatabase().compileStatement("INSERT INTO video_http_header_t (key,mime,contentLength,flag,extra) VALUES(?,?,?,?,?)");
            } else {
                sQLiteStatement2 = this.sP.f20355b;
                sQLiteStatement2.clearBindings();
            }
            sQLiteStatement3 = this.sP.f20355b;
            sQLiteStatement3.bindString(1, this.Sj.f20349a);
            sQLiteStatement4 = this.sP.f20355b;
            sQLiteStatement4.bindString(2, this.Sj.f20350b);
            sQLiteStatement5 = this.sP.f20355b;
            sQLiteStatement5.bindLong(3, this.Sj.f20351c);
            sQLiteStatement6 = this.sP.f20355b;
            sQLiteStatement6.bindLong(4, this.Sj.f20352d);
            sQLiteStatement7 = this.sP.f20355b;
            sQLiteStatement7.bindString(5, this.Sj.f20353e);
            sQLiteStatement8 = this.sP.f20355b;
            sQLiteStatement8.executeInsert();
        } catch (Throwable unused) {
        }
    }
}
