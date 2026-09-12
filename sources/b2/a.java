package b2;

import android.net.Uri;
import androidx.media3.common.t;
import androidx.media3.common.util.r0;
import androidx.media3.datasource.cache.a;
import androidx.media3.exoplayer.hls.playlist.HlsPlaylistParser;
import androidx.media3.exoplayer.hls.playlist.c;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.upstream.q;
import c2.d;
import com.google.android.gms.location.DeviceOrientationRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import w1.h;

/* loaded from: classes2.dex */
public final class a extends SegmentDownloader {
    public a(t tVar, a.c cVar, Executor executor) {
        this(tVar, new HlsPlaylistParser(), cVar, executor, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT);
    }

    public a(t tVar, q.a aVar, a.c cVar, Executor executor, long j11) {
        super(tVar, aVar, cVar, executor, j11);
    }

    private void l(List list, List list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            list2.add(SegmentDownloader.f((Uri) list.get(i11)));
        }
    }

    private void m(c cVar, c.f fVar, HashSet hashSet, ArrayList arrayList) {
        String str = cVar.f17066a;
        long j11 = cVar.f11957h + fVar.f12002e;
        String str2 = fVar.f12004g;
        if (str2 != null) {
            Uri f11 = r0.f(str, str2);
            if (hashSet.add(f11)) {
                arrayList.add(new SegmentDownloader.b(j11, SegmentDownloader.f(f11)));
            }
        }
        arrayList.add(new SegmentDownloader.b(j11, new h(r0.f(str, fVar.f11998a), fVar.f12006i, fVar.f12007j)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.offline.SegmentDownloader
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public List h(androidx.media3.datasource.a aVar, d dVar, boolean z10) {
        ArrayList arrayList = new ArrayList();
        if (dVar instanceof androidx.media3.exoplayer.hls.playlist.d) {
            l(((androidx.media3.exoplayer.hls.playlist.d) dVar).f12015d, arrayList);
        } else {
            arrayList.add(SegmentDownloader.f(Uri.parse(dVar.f17066a)));
        }
        ArrayList arrayList2 = new ArrayList();
        HashSet hashSet = new HashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            h hVar = (h) it.next();
            arrayList2.add(new SegmentDownloader.b(0L, hVar));
            try {
                c cVar = (c) g(aVar, hVar, z10);
                List list = cVar.f11967r;
                c.f fVar = null;
                for (int i11 = 0; i11 < list.size(); i11++) {
                    c.f fVar2 = (c.f) list.get(i11);
                    c.f fVar3 = fVar2.f11999b;
                    if (fVar3 != null && fVar3 != fVar) {
                        m(cVar, fVar3, hashSet, arrayList2);
                        fVar = fVar3;
                    }
                    m(cVar, fVar2, hashSet, arrayList2);
                }
            } catch (IOException e11) {
                if (!z10) {
                    throw e11;
                }
            }
        }
        return arrayList2;
    }
}
