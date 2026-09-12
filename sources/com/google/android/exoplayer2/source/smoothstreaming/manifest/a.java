package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.offline.c;
import com.google.android.exoplayer2.util.n0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import o9.p;

/* loaded from: classes3.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public final int f26663a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26664b;

    /* renamed from: c, reason: collision with root package name */
    public final int f26665c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f26666d;

    /* renamed from: e, reason: collision with root package name */
    public final C0378a f26667e;

    /* renamed from: f, reason: collision with root package name */
    public final b[] f26668f;

    /* renamed from: g, reason: collision with root package name */
    public final long f26669g;

    /* renamed from: h, reason: collision with root package name */
    public final long f26670h;

    /* renamed from: com.google.android.exoplayer2.source.smoothstreaming.manifest.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0378a {

        /* renamed from: a, reason: collision with root package name */
        public final UUID f26671a;

        /* renamed from: b, reason: collision with root package name */
        public final byte[] f26672b;

        /* renamed from: c, reason: collision with root package name */
        public final p[] f26673c;

        public C0378a(UUID uuid, byte[] bArr, p[] pVarArr) {
            this.f26671a = uuid;
            this.f26672b = bArr;
            this.f26673c = pVarArr;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f26674a;

        /* renamed from: b, reason: collision with root package name */
        public final String f26675b;

        /* renamed from: c, reason: collision with root package name */
        public final long f26676c;

        /* renamed from: d, reason: collision with root package name */
        public final String f26677d;

        /* renamed from: e, reason: collision with root package name */
        public final int f26678e;

        /* renamed from: f, reason: collision with root package name */
        public final int f26679f;

        /* renamed from: g, reason: collision with root package name */
        public final int f26680g;

        /* renamed from: h, reason: collision with root package name */
        public final int f26681h;

        /* renamed from: i, reason: collision with root package name */
        public final String f26682i;

        /* renamed from: j, reason: collision with root package name */
        public final o1[] f26683j;

        /* renamed from: k, reason: collision with root package name */
        public final int f26684k;

        /* renamed from: l, reason: collision with root package name */
        private final String f26685l;

        /* renamed from: m, reason: collision with root package name */
        private final String f26686m;

        /* renamed from: n, reason: collision with root package name */
        private final List f26687n;

        /* renamed from: o, reason: collision with root package name */
        private final long[] f26688o;

        /* renamed from: p, reason: collision with root package name */
        private final long f26689p;

        public b(String str, String str2, int i11, String str3, long j11, String str4, int i12, int i13, int i14, int i15, String str5, o1[] o1VarArr, List list, long j12) {
            this(str, str2, i11, str3, j11, str4, i12, i13, i14, i15, str5, o1VarArr, list, p0.O0(list, 1000000L, j11), p0.N0(j12, 1000000L, j11));
        }

        private b(String str, String str2, int i11, String str3, long j11, String str4, int i12, int i13, int i14, int i15, String str5, o1[] o1VarArr, List list, long[] jArr, long j12) {
            this.f26685l = str;
            this.f26686m = str2;
            this.f26674a = i11;
            this.f26675b = str3;
            this.f26676c = j11;
            this.f26677d = str4;
            this.f26678e = i12;
            this.f26679f = i13;
            this.f26680g = i14;
            this.f26681h = i15;
            this.f26682i = str5;
            this.f26683j = o1VarArr;
            this.f26687n = list;
            this.f26688o = jArr;
            this.f26689p = j12;
            this.f26684k = list.size();
        }

        public Uri a(int i11, int i12) {
            com.google.android.exoplayer2.util.a.g(this.f26683j != null);
            com.google.android.exoplayer2.util.a.g(this.f26687n != null);
            com.google.android.exoplayer2.util.a.g(i12 < this.f26687n.size());
            String num = Integer.toString(this.f26683j[i11].f25546h);
            String l11 = ((Long) this.f26687n.get(i12)).toString();
            return n0.e(this.f26685l, this.f26686m.replace("{bitrate}", num).replace("{Bitrate}", num).replace("{start time}", l11).replace("{start_time}", l11));
        }

        public b b(o1[] o1VarArr) {
            return new b(this.f26685l, this.f26686m, this.f26674a, this.f26675b, this.f26676c, this.f26677d, this.f26678e, this.f26679f, this.f26680g, this.f26681h, this.f26682i, o1VarArr, this.f26687n, this.f26688o, this.f26689p);
        }

        public long c(int i11) {
            if (i11 == this.f26684k - 1) {
                return this.f26689p;
            }
            long[] jArr = this.f26688o;
            return jArr[i11 + 1] - jArr[i11];
        }

        public int d(long j11) {
            return p0.i(this.f26688o, j11, true, true);
        }

        public long e(int i11) {
            return this.f26688o[i11];
        }
    }

    private a(int i11, int i12, long j11, long j12, int i13, boolean z10, C0378a c0378a, b[] bVarArr) {
        this.f26663a = i11;
        this.f26664b = i12;
        this.f26669g = j11;
        this.f26670h = j12;
        this.f26665c = i13;
        this.f26666d = z10;
        this.f26667e = c0378a;
        this.f26668f = bVarArr;
    }

    public a(int i11, int i12, long j11, long j12, long j13, int i13, boolean z10, C0378a c0378a, b[] bVarArr) {
        this(i11, i12, j12 == 0 ? -9223372036854775807L : p0.N0(j12, 1000000L, j11), j13 != 0 ? p0.N0(j13, 1000000L, j11) : C.TIME_UNSET, i13, z10, c0378a, bVarArr);
    }

    @Override // com.google.android.exoplayer2.offline.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final a copy(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i11 = 0;
        while (i11 < arrayList.size()) {
            StreamKey streamKey = (StreamKey) arrayList.get(i11);
            b bVar2 = this.f26668f[streamKey.groupIndex];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((o1[]) arrayList3.toArray(new o1[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.f26683j[streamKey.streamIndex]);
            i11++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((o1[]) arrayList3.toArray(new o1[0])));
        }
        return new a(this.f26663a, this.f26664b, this.f26669g, this.f26670h, this.f26665c, this.f26666d, this.f26667e, (b[]) arrayList2.toArray(new b[0]));
    }
}
