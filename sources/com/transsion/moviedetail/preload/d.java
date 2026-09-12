package com.transsion.moviedetail.preload;

import android.os.Bundle;
import java.util.Collections;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class d implements qm.c {
    @Override // qm.c
    public List a(String str, Bundle bundle) {
        List list;
        String string;
        if (Intrinsics.c(str, "/movie/detail")) {
            Integer valueOf = bundle != null ? Integer.valueOf(bundle.getInt("season")) : null;
            if (bundle == null || (string = bundle.getString("id")) == null || (list = CollectionsKt.h(new b(string, valueOf, false, 4, null), new MovieDetailDownloadListLoader(string), new MovieDetailResourcesSeasonLoader(string))) == null) {
                list = Collections.emptyList();
                Intrinsics.g(list, "emptyList(...)");
            }
        } else {
            list = null;
        }
        if (list != null) {
            return list;
        }
        Intrinsics.z("iPreloadList");
        return null;
    }

    @Override // qm.c
    public String getPath() {
        return "/movie/detail";
    }
}
