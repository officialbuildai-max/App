package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.i;
import java.util.Comparator;
import java.util.TreeSet;
import okhttp3.internal.http2.Settings;

/* loaded from: classes3.dex */
final class i {

    /* renamed from: a, reason: collision with root package name */
    private final TreeSet f26473a = new TreeSet(new Comparator() { // from class: com.google.android.exoplayer2.source.rtsp.h
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int d11;
            d11 = i.d((i.a) obj, (i.a) obj2);
            return d11;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private int f26474b;

    /* renamed from: c, reason: collision with root package name */
    private int f26475c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f26476d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final g f26477a;

        /* renamed from: b, reason: collision with root package name */
        public final long f26478b;

        public a(g gVar, long j11) {
            this.f26477a = gVar;
            this.f26478b = j11;
        }
    }

    public i() {
        g();
    }

    private synchronized void b(a aVar) {
        this.f26474b = aVar.f26477a.f26433g;
        this.f26473a.add(aVar);
    }

    private static int c(int i11, int i12) {
        int min;
        int i13 = i11 - i12;
        return (Math.abs(i13) <= 1000 || (min = (Math.min(i11, i12) - Math.max(i11, i12)) + Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 1000) ? i13 : i11 < i12 ? min : -min;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int d(a aVar, a aVar2) {
        return c(aVar.f26477a.f26433g, aVar2.f26477a.f26433g);
    }

    public synchronized boolean e(g gVar, long j11) {
        if (this.f26473a.size() >= 5000) {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
        int i11 = gVar.f26433g;
        if (!this.f26476d) {
            g();
            this.f26475c = g.c(i11);
            this.f26476d = true;
            b(new a(gVar, j11));
            return true;
        }
        if (Math.abs(c(i11, g.b(this.f26474b))) < 1000) {
            if (c(i11, this.f26475c) <= 0) {
                return false;
            }
            b(new a(gVar, j11));
            return true;
        }
        this.f26475c = g.c(i11);
        this.f26473a.clear();
        b(new a(gVar, j11));
        return true;
    }

    public synchronized g f(long j11) {
        if (this.f26473a.isEmpty()) {
            return null;
        }
        a aVar = (a) this.f26473a.first();
        int i11 = aVar.f26477a.f26433g;
        if (i11 != g.b(this.f26475c) && j11 < aVar.f26478b) {
            return null;
        }
        this.f26473a.pollFirst();
        this.f26475c = i11;
        return aVar.f26477a;
    }

    public synchronized void g() {
        this.f26473a.clear();
        this.f26476d = false;
        this.f26475c = -1;
        this.f26474b = -1;
    }
}
