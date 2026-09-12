package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.offline.StreamKey;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class e extends y9.d {

    /* renamed from: n, reason: collision with root package name */
    public static final e f26219n = new e("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: d, reason: collision with root package name */
    public final List f26220d;

    /* renamed from: e, reason: collision with root package name */
    public final List f26221e;

    /* renamed from: f, reason: collision with root package name */
    public final List f26222f;

    /* renamed from: g, reason: collision with root package name */
    public final List f26223g;

    /* renamed from: h, reason: collision with root package name */
    public final List f26224h;

    /* renamed from: i, reason: collision with root package name */
    public final List f26225i;

    /* renamed from: j, reason: collision with root package name */
    public final o1 f26226j;

    /* renamed from: k, reason: collision with root package name */
    public final List f26227k;

    /* renamed from: l, reason: collision with root package name */
    public final Map f26228l;

    /* renamed from: m, reason: collision with root package name */
    public final List f26229m;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f26230a;

        /* renamed from: b, reason: collision with root package name */
        public final o1 f26231b;

        /* renamed from: c, reason: collision with root package name */
        public final String f26232c;

        /* renamed from: d, reason: collision with root package name */
        public final String f26233d;

        public a(Uri uri, o1 o1Var, String str, String str2) {
            this.f26230a = uri;
            this.f26231b = o1Var;
            this.f26232c = str;
            this.f26233d = str2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final Uri f26234a;

        /* renamed from: b, reason: collision with root package name */
        public final o1 f26235b;

        /* renamed from: c, reason: collision with root package name */
        public final String f26236c;

        /* renamed from: d, reason: collision with root package name */
        public final String f26237d;

        /* renamed from: e, reason: collision with root package name */
        public final String f26238e;

        /* renamed from: f, reason: collision with root package name */
        public final String f26239f;

        public b(Uri uri, o1 o1Var, String str, String str2, String str3, String str4) {
            this.f26234a = uri;
            this.f26235b = o1Var;
            this.f26236c = str;
            this.f26237d = str2;
            this.f26238e = str3;
            this.f26239f = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new o1.b().S("0").K(MimeTypes.APPLICATION_M3U8).E(), null, null, null, null);
        }

        public b a(o1 o1Var) {
            return new b(this.f26234a, o1Var, this.f26236c, this.f26237d, this.f26238e, this.f26239f);
        }
    }

    public e(String str, List list, List list2, List list3, List list4, List list5, List list6, o1 o1Var, List list7, boolean z10, Map map, List list8) {
        super(str, list, z10);
        this.f26220d = Collections.unmodifiableList(e(list2, list3, list4, list5, list6));
        this.f26221e = Collections.unmodifiableList(list2);
        this.f26222f = Collections.unmodifiableList(list3);
        this.f26223g = Collections.unmodifiableList(list4);
        this.f26224h = Collections.unmodifiableList(list5);
        this.f26225i = Collections.unmodifiableList(list6);
        this.f26226j = o1Var;
        this.f26227k = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f26228l = Collections.unmodifiableMap(map);
        this.f26229m = Collections.unmodifiableList(list8);
    }

    private static void a(List list, List list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = ((a) list.get(i11)).f26230a;
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

    public static e d(String str) {
        return new e("", Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List e(List list, List list2, List list3, List list4, List list5) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            Uri uri = ((b) list.get(i11)).f26234a;
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

    @Override // com.google.android.exoplayer2.offline.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e copy(List list) {
        return new e(this.f79073a, this.f79074b, c(this.f26221e, 0, list), Collections.emptyList(), c(this.f26223g, 1, list), c(this.f26224h, 2, list), Collections.emptyList(), this.f26226j, this.f26227k, this.f79075c, this.f26228l, this.f26229m);
    }
}
