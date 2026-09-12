package x9;

import android.net.Uri;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class c implements com.google.android.exoplayer2.offline.c {

    /* renamed from: a, reason: collision with root package name */
    public final long f78184a;

    /* renamed from: b, reason: collision with root package name */
    public final long f78185b;

    /* renamed from: c, reason: collision with root package name */
    public final long f78186c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f78187d;

    /* renamed from: e, reason: collision with root package name */
    public final long f78188e;

    /* renamed from: f, reason: collision with root package name */
    public final long f78189f;

    /* renamed from: g, reason: collision with root package name */
    public final long f78190g;

    /* renamed from: h, reason: collision with root package name */
    public final long f78191h;

    /* renamed from: i, reason: collision with root package name */
    public final o f78192i;

    /* renamed from: j, reason: collision with root package name */
    public final l f78193j;

    /* renamed from: k, reason: collision with root package name */
    public final Uri f78194k;

    /* renamed from: l, reason: collision with root package name */
    public final h f78195l;

    /* renamed from: m, reason: collision with root package name */
    private final List f78196m;

    public c(long j11, long j12, long j13, boolean z10, long j14, long j15, long j16, long j17, h hVar, o oVar, l lVar, Uri uri, List list) {
        this.f78184a = j11;
        this.f78185b = j12;
        this.f78186c = j13;
        this.f78187d = z10;
        this.f78188e = j14;
        this.f78189f = j15;
        this.f78190g = j16;
        this.f78191h = j17;
        this.f78195l = hVar;
        this.f78192i = oVar;
        this.f78194k = uri;
        this.f78193j = lVar;
        this.f78196m = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList b(List list, LinkedList linkedList) {
        StreamKey streamKey = (StreamKey) linkedList.poll();
        int i11 = streamKey.periodIndex;
        ArrayList arrayList = new ArrayList();
        do {
            int i12 = streamKey.groupIndex;
            a aVar = (a) list.get(i12);
            List list2 = aVar.f78176c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add((j) list2.get(streamKey.streamIndex));
                streamKey = (StreamKey) linkedList.poll();
                if (streamKey.periodIndex != i11) {
                    break;
                }
            } while (streamKey.groupIndex == i12);
            arrayList.add(new a(aVar.f78174a, aVar.f78175b, arrayList2, aVar.f78177d, aVar.f78178e, aVar.f78179f));
        } while (streamKey.periodIndex == i11);
        linkedList.addFirst(streamKey);
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.offline.c
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c copy(List list) {
        long j11;
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j12 = 0;
        int i11 = 0;
        while (true) {
            int d11 = d();
            j11 = C.TIME_UNSET;
            if (i11 >= d11) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i11) {
                long e11 = e(i11);
                if (e11 != C.TIME_UNSET) {
                    j12 += e11;
                }
            } else {
                g c11 = c(i11);
                arrayList.add(new g(c11.f78219a, c11.f78220b - j12, b(c11.f78221c, linkedList), c11.f78222d));
            }
            i11++;
        }
        long j13 = this.f78185b;
        if (j13 != C.TIME_UNSET) {
            j11 = j13 - j12;
        }
        return new c(this.f78184a, j11, this.f78186c, this.f78187d, this.f78188e, this.f78189f, this.f78190g, this.f78191h, this.f78195l, this.f78192i, this.f78193j, this.f78194k, arrayList);
    }

    public final g c(int i11) {
        return (g) this.f78196m.get(i11);
    }

    public final int d() {
        return this.f78196m.size();
    }

    public final long e(int i11) {
        long j11;
        long j12;
        if (i11 == this.f78196m.size() - 1) {
            j11 = this.f78185b;
            if (j11 == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            j12 = ((g) this.f78196m.get(i11)).f78220b;
        } else {
            j11 = ((g) this.f78196m.get(i11 + 1)).f78220b;
            j12 = ((g) this.f78196m.get(i11)).f78220b;
        }
        return j11 - j12;
    }

    public final long f(int i11) {
        return p0.B0(e(i11));
    }
}
