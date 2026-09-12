package com.google.android.exoplayer2.upstream;

import java.io.IOException;

/* loaded from: classes3.dex */
public interface z {

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f27590a;

        /* renamed from: b, reason: collision with root package name */
        public final int f27591b;

        /* renamed from: c, reason: collision with root package name */
        public final int f27592c;

        /* renamed from: d, reason: collision with root package name */
        public final int f27593d;

        public a(int i11, int i12, int i13, int i14) {
            this.f27590a = i11;
            this.f27591b = i12;
            this.f27592c = i13;
            this.f27593d = i14;
        }

        public boolean a(int i11) {
            if (i11 == 1) {
                if (this.f27590a - this.f27591b <= 1) {
                    return false;
                }
            } else if (this.f27592c - this.f27593d <= 1) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f27594a;

        /* renamed from: b, reason: collision with root package name */
        public final long f27595b;

        public b(int i11, long j11) {
            com.google.android.exoplayer2.util.a.a(j11 >= 0);
            this.f27594a = i11;
            this.f27595b = j11;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c {

        /* renamed from: a, reason: collision with root package name */
        public final t9.h f27596a;

        /* renamed from: b, reason: collision with root package name */
        public final t9.i f27597b;

        /* renamed from: c, reason: collision with root package name */
        public final IOException f27598c;

        /* renamed from: d, reason: collision with root package name */
        public final int f27599d;

        public c(t9.h hVar, t9.i iVar, IOException iOException, int i11) {
            this.f27596a = hVar;
            this.f27597b = iVar;
            this.f27598c = iOException;
            this.f27599d = i11;
        }
    }

    int a(int i11);

    void b(long j11);

    long c(c cVar);

    b d(a aVar, c cVar);
}
