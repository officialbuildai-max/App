package com.transsnet.downloader.ugc.viewmodel;

import androidx.compose.foundation.e;
import androidx.view.t0;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class b extends t0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f60005a = "UGCForYouCacheViewModel";

    /* renamed from: b, reason: collision with root package name */
    private final Map f60006b = new LinkedHashMap();

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List f60007a;

        /* renamed from: b, reason: collision with root package name */
        private String f60008b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f60009c;

        public a() {
            this(null, null, false, 7, null);
        }

        public a(List videos, String str, boolean z10) {
            Intrinsics.h(videos, "videos");
            this.f60007a = videos;
            this.f60008b = str;
            this.f60009c = z10;
        }

        public /* synthetic */ a(List list, String str, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? new ArrayList() : list, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? true : z10);
        }

        public final boolean a() {
            return this.f60009c;
        }

        public final String b() {
            return this.f60008b;
        }

        public final List c() {
            return this.f60007a;
        }

        public final void d(boolean z10) {
            this.f60009c = z10;
        }

        public final void e(String str) {
            this.f60008b = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f60007a, aVar.f60007a) && Intrinsics.c(this.f60008b, aVar.f60008b) && this.f60009c == aVar.f60009c;
        }

        public int hashCode() {
            int hashCode = this.f60007a.hashCode() * 31;
            String str = this.f60008b;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + e.a(this.f60009c);
        }

        public String toString() {
            return "CacheData(videos=" + this.f60007a + ", nextPage=" + this.f60008b + ", hasMore=" + this.f60009c + ")";
        }
    }

    public final String b(String cacheKey) {
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.f60006b.get(cacheKey);
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public final List c(String cacheKey) {
        List c11;
        List R0;
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.f60006b.get(cacheKey);
        return (aVar == null || (c11 = aVar.c()) == null || (R0 = CollectionsKt.R0(c11)) == null) ? CollectionsKt.l() : R0;
    }

    public final boolean d(String cacheKey) {
        List c11;
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.f60006b.get(cacheKey);
        return (aVar == null || (c11 = aVar.c()) == null || !(c11.isEmpty() ^ true)) ? false : true;
    }

    public final boolean e(String cacheKey) {
        Intrinsics.h(cacheKey, "cacheKey");
        a aVar = (a) this.f60006b.get(cacheKey);
        if (aVar != null) {
            return aVar.a();
        }
        return true;
    }

    public final void f(String cacheKey, List videos, String str, boolean z10) {
        Intrinsics.h(cacheKey, "cacheKey");
        Intrinsics.h(videos, "videos");
        Map map = this.f60006b;
        Object obj = map.get(cacheKey);
        if (obj == null) {
            obj = new a(null, null, false, 7, null);
            map.put(cacheKey, obj);
        }
        a aVar = (a) obj;
        List c11 = aVar.c();
        ArrayList arrayList = new ArrayList();
        Iterator it = c11.iterator();
        while (it.hasNext()) {
            String ugcVideoId = ((UGCVideo) it.next()).getUgcVideoId();
            if (ugcVideoId != null) {
                arrayList.add(ugcVideoId);
            }
        }
        Set W0 = CollectionsKt.W0(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : videos) {
            UGCVideo uGCVideo = (UGCVideo) obj2;
            String ugcVideoId2 = uGCVideo.getUgcVideoId();
            if (ugcVideoId2 != null && ugcVideoId2.length() != 0 && !CollectionsKt.b0(W0, uGCVideo.getUgcVideoId())) {
                arrayList2.add(obj2);
            }
        }
        aVar.c().addAll(arrayList2);
        aVar.e(str);
        aVar.d(z10);
        a.C0856a.f(lg.a.f68962a, this.f60005a, "saveCacheAppend: cacheKey=" + cacheKey + ", newSize=" + arrayList2.size() + ", totalSize=" + aVar.c().size() + ", hasMore=" + z10, false, 4, null);
    }

    public final void g(String cacheKey, List videos, String str, boolean z10) {
        Intrinsics.h(cacheKey, "cacheKey");
        Intrinsics.h(videos, "videos");
        Map map = this.f60006b;
        Object obj = map.get(cacheKey);
        if (obj == null) {
            obj = new a(null, null, false, 7, null);
            map.put(cacheKey, obj);
        }
        a aVar = (a) obj;
        aVar.c().clear();
        aVar.c().addAll(videos);
        aVar.e(str);
        aVar.d(z10);
        a.C0856a.f(lg.a.f68962a, this.f60005a, "saveCacheRefresh: cacheKey=" + cacheKey + ", size=" + videos.size() + ", hasMore=" + z10, false, 4, null);
    }
}
