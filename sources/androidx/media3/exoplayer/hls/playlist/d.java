package androidx.media3.exoplayer.hls.playlist;

import android.net.Uri;
import androidx.media3.common.StreamKey;
import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d extends c2.d {

    /* renamed from: n, reason: collision with root package name */
    public static final d f12014n = new d("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d, reason: collision with root package name */
    public final List f12015d;

    /* renamed from: e, reason: collision with root package name */
    public final List f12016e;

    /* renamed from: f, reason: collision with root package name */
    public final List f12017f;

    /* renamed from: g, reason: collision with root package name */
    public final List f12018g;

    /* renamed from: h, reason: collision with root package name */
    public final List f12019h;

    /* renamed from: i, reason: collision with root package name */
    public final List f12020i;

    /* renamed from: j, reason: collision with root package name */
    public final r f12021j;

    /* renamed from: k, reason: collision with root package name */
    public final List f12022k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f12023l;

    /* renamed from: m, reason: collision with root package name */
    public final List f12024m;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f12025a;

        /* renamed from: b, reason: collision with root package name */
        public final r f12026b;

        /* renamed from: c, reason: collision with root package name */
        public final String f12027c;

        /* renamed from: d, reason: collision with root package name */
        public final String f12028d;

        public a(Uri uri, r rVar, String str, String str2) {
            this.f12025a = uri;
            this.f12026b = rVar;
            this.f12027c = str;
            this.f12028d = str2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f12029a;

        /* renamed from: b, reason: collision with root package name */
        public final r f12030b;

        /* renamed from: c, reason: collision with root package name */
        public final String f12031c;

        /* renamed from: d, reason: collision with root package name */
        public final String f12032d;

        /* renamed from: e, reason: collision with root package name */
        public final String f12033e;

        /* renamed from: f, reason: collision with root package name */
        public final String f12034f;

        public b(Uri uri, r rVar, String str, String str2, String str3, String str4) {
            this.f12029a = uri;
            this.f12030b = rVar;
            this.f12031c = str;
            this.f12032d = str2;
            this.f12033e = str3;
            this.f12034f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new r.b().f0("0").U(MimeTypes.APPLICATION_M3U8).N(), null, null, null, null);
        }

        public b a(r rVar) {
            return new b(this.f12029a, rVar, this.f12031c, this.f12032d, this.f12033e, this.f12034f);
        }
    }

    public d(String str, List list, List list2, List list3, List list4, List list5, List list6, r rVar, List list7, boolean z10, Map map, List list8) {
        super(str, list, z10);
        this.f12015d = Collections.unmodifiableList(e(list2, list3, list4, list5, list6));
        this.f12016e = Collections.unmodifiableList(list2);
        this.f12017f = Collections.unmodifiableList(list3);
        this.f12018g = Collections.unmodifiableList(list4);
        this.f12019h = Collections.unmodifiableList(list5);
        this.f12020i = Collections.unmodifiableList(list6);
        this.f12021j = rVar;
        this.f12022k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f12023l = Collections.unmodifiableMap(map);
        this.f12024m = Collections.unmodifiableList(list8);
    }

    private static void a(List list, List list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = ((a) list.get(i11)).f12025a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    private static List c(List list, int i11, List list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i12 = 0; i12 < list.size(); i12++) {
            Object obj = list.get(i12);
            int i13 = 0;
            while (true) {
                if (i13 < list2.size()) {
                    StreamKey streamKey = (StreamKey) list2.get(i13);
                    if (streamKey.groupIndex == i11 && streamKey.streamIndex == i12) {
                        arrayList.add(obj);
                        break;
                    }
                    i13++;
                }
            }
        }
        return arrayList;
    }

    public static d d(String str) {
        return new d("", Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List e(List list, List list2, List list3, List list4, List list5) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = ((b) list.get(i11)).f12029a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        a(list2, arrayList);
        a(list3, arrayList);
        a(list4, arrayList);
        a(list5, arrayList);
        return arrayList;
    }

    @Override // androidx.media3.exoplayer.offline.q
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public d copy(List list) {
        return new d(this.f17066a, this.f17067b, c(this.f12016e, 0, list), Collections.emptyList(), c(this.f12018g, 1, list), c(this.f12019h, 2, list), Collections.emptyList(), this.f12021j, this.f12022k, this.f17068c, this.f12023l, this.f12024m);
    }
}
