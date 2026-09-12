package com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;

import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;

/* loaded from: classes2.dex */
class TKC$2 implements Runnable {
    final /* synthetic */ int Sj;
    final /* synthetic */ sP.e sP;

    TKC$2(sP.e eVar, int i11) {
        this.Sj = i11;
    }

    @Override // java.lang.Runnable
    public void run() {
        sP.c cVar;
        try {
            cVar = this.sP.f20354a;
            cVar.getWritableDatabase().delete("video_http_header_t", "flag=?", new String[]{String.valueOf(this.Sj)});
        } catch (Throwable unused) {
        }
    }
}
