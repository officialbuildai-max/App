package com.bykv.vk.openvk.preload.geckox.d;

import android.net.Uri;
import android.util.Pair;
import com.bykv.vk.openvk.preload.b.k;
import com.bykv.vk.openvk.preload.geckox.logger.GeckoLogger;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import java.util.List;

/* loaded from: classes2.dex */
public class h extends k<UpdatePackage, Pair<Uri, UpdatePackage>> {

    /* renamed from: d, reason: collision with root package name */
    private int f20764d = 0;

    @Override // com.bykv.vk.openvk.preload.b.k
    protected final /* synthetic */ Pair<Uri, UpdatePackage> a() {
        UpdatePackage g11 = g();
        List<String> urlList = g11.getPatch().getUrlList();
        int i11 = this.f20764d;
        this.f20764d = i11 + 1;
        return new Pair<>(Uri.parse(urlList.get(i11)), g11);
    }

    @Override // com.bykv.vk.openvk.preload.b.k
    protected final boolean a(Throwable th2) {
        GeckoLogger.w("gecko-debug-tag", "patch update failed", th2);
        if (this.f20764d >= g().getPatch().getUrlList().size()) {
            return false;
        }
        return (th2 instanceof com.bykv.vk.openvk.preload.geckox.b.a) || (th2 instanceof com.bykv.vk.openvk.preload.geckox.b.b);
    }
}
