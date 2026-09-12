package com.transsion.lib_web.download_render.init;

import com.transsion.lib_web.download_render.FileDownloadTaskManager;
import com.transsion.lib_web.download_render.data.PageListData;

/* loaded from: classes5.dex */
public final class b implements c {
    @Override // com.transsion.lib_web.download_render.init.c
    public void invoke() {
        PageListData l11 = com.transsion.lib_web.download_render.c.f46221a.l();
        if (l11 == null) {
            return;
        }
        FileDownloadTaskManager.f46201a.g(l11.getH5Pages());
    }
}
