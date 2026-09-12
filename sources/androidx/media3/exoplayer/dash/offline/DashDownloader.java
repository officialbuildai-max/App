package androidx.media3.exoplayer.dash.offline;

import a2.c;
import a2.d;
import a2.i;
import a2.j;
import androidx.media3.common.t;
import androidx.media3.common.util.RunnableFutureTask;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.cache.a;
import androidx.media3.exoplayer.offline.SegmentDownloader;
import androidx.media3.exoplayer.upstream.q;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import l2.h;
import z1.b;
import z1.e;
import z1.f;
import z1.g;

/* loaded from: classes2.dex */
public final class DashDownloader extends SegmentDownloader {

    /* renamed from: l, reason: collision with root package name */
    private final b f11568l;

    public DashDownloader(t tVar, a.c cVar, Executor executor) {
        this(tVar, new d(), cVar, executor, DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT);
    }

    public DashDownloader(t tVar, q.a aVar, a.c cVar, Executor executor, long j11) {
        super(tVar, aVar, cVar, executor, j11);
        this.f11568l = new b();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l(androidx.media3.datasource.a r27, a2.a r28, long r29, long r31, boolean r33, java.util.ArrayList r34) {
        /*
            r26 = this;
            r7 = r26
            r8 = r28
            r9 = r33
            r10 = r34
            r0 = 0
            r11 = r0
        La:
            java.util.List r0 = r8.f112c
            int r0 = r0.size()
            if (r11 >= r0) goto Lbd
            java.util.List r0 = r8.f112c
            java.lang.Object r0 = r0.get(r11)
            a2.j r0 = (a2.j) r0
            int r1 = r8.f111b     // Catch: java.io.IOException -> Lb2
            r12 = r27
            z1.e r13 = r7.n(r12, r1, r0, r9)     // Catch: java.io.IOException -> Lae
            if (r13 == 0) goto La2
            r14 = r31
            long r16 = r13.f(r14)
            r1 = -1
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 == 0) goto L9a
            z1.b r1 = r7.f11568l
            com.google.common.collect.ImmutableList r2 = r0.f172c
            a2.b r1 = r1.j(r2)
            java.lang.Object r1 = androidx.media3.common.util.a1.i(r1)
            a2.b r1 = (a2.b) r1
            java.lang.String r6 = r1.f116a
            a2.i r18 = r0.m()
            if (r18 == 0) goto L58
            r1 = r26
            r2 = r0
            r3 = r6
            r4 = r29
            r19 = r6
            r6 = r18
            androidx.media3.exoplayer.offline.SegmentDownloader$b r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            goto L5a
        L58:
            r19 = r6
        L5a:
            a2.i r6 = r0.l()
            if (r6 == 0) goto L6e
            r1 = r26
            r2 = r0
            r3 = r19
            r4 = r29
            androidx.media3.exoplayer.offline.SegmentDownloader$b r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
        L6e:
            long r1 = r13.h()
            long r16 = r1 + r16
            r20 = 1
            long r16 = r16 - r20
            r4 = r1
        L79:
            int r1 = (r4 > r16 ? 1 : (r4 == r16 ? 0 : -1))
            if (r1 > 0) goto Lb8
            long r1 = r13.getTimeUs(r4)
            long r22 = r29 + r1
            a2.i r6 = r13.d(r4)
            r1 = r26
            r2 = r0
            r3 = r19
            r24 = r4
            r4 = r22
            androidx.media3.exoplayer.offline.SegmentDownloader$b r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            long r4 = r24 + r20
            goto L79
        L9a:
            androidx.media3.exoplayer.offline.DownloadException r0 = new androidx.media3.exoplayer.offline.DownloadException
            java.lang.String r1 = "Unbounded segment index"
            r0.<init>(r1)
            throw r0
        La2:
            r14 = r31
            androidx.media3.exoplayer.offline.DownloadException r0 = new androidx.media3.exoplayer.offline.DownloadException     // Catch: java.io.IOException -> Lac
            java.lang.String r1 = "Missing segment index"
            r0.<init>(r1)     // Catch: java.io.IOException -> Lac
            throw r0     // Catch: java.io.IOException -> Lac
        Lac:
            r0 = move-exception
            goto Lb6
        Lae:
            r0 = move-exception
        Laf:
            r14 = r31
            goto Lb6
        Lb2:
            r0 = move-exception
            r12 = r27
            goto Laf
        Lb6:
            if (r9 == 0) goto Lbc
        Lb8:
            int r11 = r11 + 1
            goto La
        Lbc:
            throw r0
        Lbd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.dash.offline.DashDownloader.l(androidx.media3.datasource.a, a2.a, long, long, boolean, java.util.ArrayList):void");
    }

    private SegmentDownloader.b m(j jVar, String str, long j11, i iVar) {
        return new SegmentDownloader.b(j11, f.a(jVar, str, iVar, 0, ImmutableMap.of()));
    }

    private e n(final androidx.media3.datasource.a aVar, final int i11, final j jVar, boolean z10) {
        e k11 = jVar.k();
        if (k11 != null) {
            return k11;
        }
        h hVar = (h) e(new RunnableFutureTask<h, IOException>() { // from class: androidx.media3.exoplayer.dash.offline.DashDownloader.1
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // androidx.media3.common.util.RunnableFutureTask
            public h doWork() throws IOException {
                return f.b(aVar, i11, jVar);
            }
        }, z10);
        if (hVar == null) {
            return null;
        }
        return new g(hVar, jVar.f173d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.offline.SegmentDownloader
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public List h(androidx.media3.datasource.a aVar, c cVar, boolean z10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < cVar.d(); i11++) {
            a2.g c11 = cVar.c(i11);
            long R0 = a1.R0(c11.f157b);
            long f11 = cVar.f(i11);
            int i12 = 0;
            for (List list = c11.f158c; i12 < list.size(); list = list) {
                l(aVar, (a2.a) list.get(i12), R0, f11, z10, arrayList);
                i12++;
            }
        }
        return arrayList;
    }
}
