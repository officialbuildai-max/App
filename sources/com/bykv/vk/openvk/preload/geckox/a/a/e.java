package com.bykv.vk.openvk.preload.geckox.a.a;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class e extends b {
    @Override // com.bykv.vk.openvk.preload.geckox.a.a.b
    public final void a() {
        Iterator<String> it = this.f20675e.iterator();
        while (it.hasNext()) {
            List<File> b11 = com.bykv.vk.openvk.preload.geckox.utils.b.b(new File(this.f20674d, it.next()));
            if (b11 != null && b11.size() > this.f20673c.f20665a) {
                for (File file : b11.subList(0, b11.size() - this.f20673c.f20665a)) {
                    com.bykv.vk.openvk.preload.geckox.a.c.b(file.getAbsolutePath());
                    if (this.f20673c.f20666b != null) {
                        file.getName();
                    }
                }
            }
        }
    }

    @Override // com.bykv.vk.openvk.preload.geckox.a.a.b
    public final void a(a aVar, File file, List<String> list) {
        super.a(aVar, file, list);
    }
}
