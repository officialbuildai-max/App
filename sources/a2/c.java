package a2;

import android.net.Uri;
import androidx.media3.common.StreamKey;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.offline.q;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class c implements q {

    /* renamed from: a, reason: collision with root package name */
    public final long f120a;

    /* renamed from: b, reason: collision with root package name */
    public final long f121b;

    /* renamed from: c, reason: collision with root package name */
    public final long f122c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f123d;

    /* renamed from: e, reason: collision with root package name */
    public final long f124e;

    /* renamed from: f, reason: collision with root package name */
    public final long f125f;

    /* renamed from: g, reason: collision with root package name */
    public final long f126g;

    /* renamed from: h, reason: collision with root package name */
    public final long f127h;

    /* renamed from: i, reason: collision with root package name */
    public final o f128i;

    /* renamed from: j, reason: collision with root package name */
    public final l f129j;

    /* renamed from: k, reason: collision with root package name */
    public final Uri f130k;

    /* renamed from: l, reason: collision with root package name */
    public final h f131l;

    /* renamed from: m, reason: collision with root package name */
    private final List f132m;

    public c(long j11, long j12, long j13, boolean z10, long j14, long j15, long j16, long j17, h hVar, o oVar, l lVar, Uri uri, List list) {
        this.f120a = j11;
        this.f121b = j12;
        this.f122c = j13;
        this.f123d = z10;
        this.f124e = j14;
        this.f125f = j15;
        this.f126g = j16;
        this.f127h = j17;
        this.f131l = hVar;
        this.f128i = oVar;
        this.f130k = uri;
        this.f129j = lVar;
        this.f132m = list == null ? Collections.emptyList() : list;
    }

    private static ArrayList b(List list, LinkedList linkedList) {
        StreamKey streamKey = (StreamKey) linkedList.poll();
        int i11 = streamKey.periodIndex;
        ArrayList arrayList = new ArrayList();
        do {
            int i12 = streamKey.groupIndex;
            a aVar = (a) list.get(i12);
            List list2 = aVar.f112c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add((j) list2.get(streamKey.streamIndex));
                streamKey = (StreamKey) linkedList.poll();
                if (streamKey.periodIndex != i11) {
                    break;
                }
            } while (streamKey.groupIndex == i12);
            arrayList.add(new a(aVar.f110a, aVar.f111b, arrayList2, aVar.f113d, aVar.f114e, aVar.f115f));
        } while (streamKey.periodIndex == i11);
        linkedList.addFirst(streamKey);
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.offline.q
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
                arrayList.add(new g(c11.f156a, c11.f157b - j12, b(c11.f158c, linkedList), c11.f159d));
            }
            i11++;
        }
        long j13 = this.f121b;
        if (j13 != C.TIME_UNSET) {
            j11 = j13 - j12;
        }
        return new c(this.f120a, j11, this.f122c, this.f123d, this.f124e, this.f125f, this.f126g, this.f127h, this.f131l, this.f128i, this.f129j, this.f130k, arrayList);
    }

    public final g c(int i11) {
        return (g) this.f132m.get(i11);
    }

    public final int d() {
        return this.f132m.size();
    }

    public final long e(int i11) {
        long j11;
        long j12;
        if (i11 == this.f132m.size() - 1) {
            j11 = this.f121b;
            if (j11 == C.TIME_UNSET) {
                return C.TIME_UNSET;
            }
            j12 = ((g) this.f132m.get(i11)).f157b;
        } else {
            j11 = ((g) this.f132m.get(i11 + 1)).f157b;
            j12 = ((g) this.f132m.get(i11)).f157b;
        }
        return j11 - j12;
    }

    public final long f(int i11) {
        return a1.R0(e(i11));
    }
}
