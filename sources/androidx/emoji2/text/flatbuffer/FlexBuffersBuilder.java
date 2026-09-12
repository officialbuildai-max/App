package androidx.emoji2.text.flatbuffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes.dex */
public class FlexBuffersBuilder {

    /* renamed from: a, reason: collision with root package name */
    private final d f9158a;

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList f9159b;

    /* renamed from: c, reason: collision with root package name */
    private final HashMap f9160c;

    /* renamed from: d, reason: collision with root package name */
    private final HashMap f9161d;

    /* renamed from: e, reason: collision with root package name */
    private final int f9162e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f9163f;

    /* renamed from: g, reason: collision with root package name */
    private Comparator f9164g;

    /* loaded from: classes.dex */
    private static class a {
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    public FlexBuffersBuilder(int i11) {
        this(new androidx.emoji2.text.flatbuffer.a(i11), 1);
    }

    public FlexBuffersBuilder(d dVar, int i11) {
        this.f9159b = new ArrayList();
        this.f9160c = new HashMap();
        this.f9161d = new HashMap();
        this.f9163f = false;
        this.f9164g = new Comparator<a>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            /* renamed from: compare, reason: avoid collision after fix types in other method */
            public int compare2(a aVar, a aVar2) {
                throw null;
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(a aVar, a aVar2) {
                android.support.v4.media.session.c.a(aVar);
                android.support.v4.media.session.c.a(aVar2);
                return compare2((a) null, (a) null);
            }
        };
        this.f9158a = dVar;
        this.f9162e = i11;
    }
}
