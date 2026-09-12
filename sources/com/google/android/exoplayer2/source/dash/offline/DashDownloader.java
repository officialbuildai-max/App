package com.google.android.exoplayer2.source.dash.offline;

import com.google.android.exoplayer2.offline.SegmentDownloader;
import com.google.android.exoplayer2.upstream.b0;
import com.google.android.exoplayer2.upstream.cache.a;
import com.google.android.exoplayer2.upstream.k;
import com.google.android.exoplayer2.util.RunnableFutureTask;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.v1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import w9.b;
import w9.e;
import w9.f;
import w9.g;
import x9.c;
import x9.d;
import x9.i;
import x9.j;

/* loaded from: classes3.dex */
public final class DashDownloader extends SegmentDownloader {

    /* renamed from: k, reason: collision with root package name */
    private final b f25952k;

    public DashDownloader(v1 v1Var, b0.a aVar, a.c cVar, Executor executor) {
        super(v1Var, aVar, cVar, executor);
        this.f25952k = new b();
    }

    public DashDownloader(v1 v1Var, a.c cVar, Executor executor) {
        this(v1Var, new d(), cVar, executor);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void l(com.google.android.exoplayer2.upstream.k r27, x9.a r28, long r29, long r31, boolean r33, java.util.ArrayList r34) {
        /*
            r26 = this;
            r7 = r26
            r8 = r28
            r9 = r33
            r10 = r34
            r0 = 0
            r11 = r0
        La:
            java.util.List r0 = r8.f78176c
            int r0 = r0.size()
            if (r11 >= r0) goto Lbd
            java.util.List r0 = r8.f78176c
            java.lang.Object r0 = r0.get(r11)
            x9.j r0 = (x9.j) r0
            int r1 = r8.f78175b     // Catch: java.io.IOException -> Lb2
            r12 = r27
            w9.e r13 = r7.n(r12, r1, r0, r9)     // Catch: java.io.IOException -> Lae
            if (r13 == 0) goto La2
            r14 = r31
            long r16 = r13.f(r14)
            r1 = -1
            int r1 = (r16 > r1 ? 1 : (r16 == r1 ? 0 : -1))
            if (r1 == 0) goto L9a
            w9.b r1 = r7.f25952k
            com.google.common.collect.ImmutableList r2 = r0.f78235c
            x9.b r1 = r1.j(r2)
            java.lang.Object r1 = com.google.android.exoplayer2.util.p0.j(r1)
            x9.b r1 = (x9.b) r1
            java.lang.String r6 = r1.f78180a
            x9.i r18 = r0.m()
            if (r18 == 0) goto L58
            r1 = r26
            r2 = r0
            r3 = r6
            r4 = r29
            r19 = r6
            r6 = r18
            com.google.android.exoplayer2.offline.SegmentDownloader$b r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            goto L5a
        L58:
            r19 = r6
        L5a:
            x9.i r6 = r0.l()
            if (r6 == 0) goto L6e
            r1 = r26
            r2 = r0
            r3 = r19
            r4 = r29
            com.google.android.exoplayer2.offline.SegmentDownloader$b r1 = r1.m(r2, r3, r4, r6)
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
            x9.i r6 = r13.d(r4)
            r1 = r26
            r2 = r0
            r3 = r19
            r24 = r4
            r4 = r22
            com.google.android.exoplayer2.offline.SegmentDownloader$b r1 = r1.m(r2, r3, r4, r6)
            r10.add(r1)
            long r4 = r24 + r20
            goto L79
        L9a:
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException
            java.lang.String r1 = "Unbounded segment index"
            r0.<init>(r1)
            throw r0
        La2:
            r14 = r31
            com.google.android.exoplayer2.offline.DownloadException r0 = new com.google.android.exoplayer2.offline.DownloadException     // Catch: java.io.IOException -> Lac
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.offline.DashDownloader.l(com.google.android.exoplayer2.upstream.k, x9.a, long, long, boolean, java.util.ArrayList):void");
    }

    private SegmentDownloader.b m(j jVar, String str, long j11, i iVar) {
        return new SegmentDownloader.b(j11, f.a(jVar, str, iVar, 0));
    }

    private e n(final k kVar, final int i11, final j jVar, boolean z10) {
        e k11 = jVar.k();
        if (k11 != null) {
            return k11;
        }
        g9.d dVar = (g9.d) e(new RunnableFutureTask<g9.d, IOException>(this) { // from class: com.google.android.exoplayer2.source.dash.offline.DashDownloader.1
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.exoplayer2.util.RunnableFutureTask
            public g9.d doWork() throws IOException {
                return f.b(kVar, i11, jVar);
            }
        }, z10);
        if (dVar == null) {
            return null;
        }
        return new g(dVar, jVar.f78236d);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.offline.SegmentDownloader
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public List h(k kVar, c cVar, boolean z10) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < cVar.d(); i11++) {
            x9.g c11 = cVar.c(i11);
            long B0 = p0.B0(c11.f78220b);
            long f11 = cVar.f(i11);
            int i12 = 0;
            for (List list = c11.f78221c; i12 < list.size(); list = list) {
                l(kVar, (x9.a) list.get(i12), B0, f11, z10, arrayList);
                i12++;
            }
        }
        return arrayList;
    }
}
