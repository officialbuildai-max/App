package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.p3;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Booleans;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public final class p3 implements k {

    /* renamed from: b, reason: collision with root package name */
    public static final p3 f25653b = new p3(ImmutableList.of());

    /* renamed from: c, reason: collision with root package name */
    public static final k.a f25654c = new k.a() { // from class: com.google.android.exoplayer2.n3
        @Override // com.google.android.exoplayer2.k.a
        public final k a(Bundle bundle) {
            p3 e11;
            e11 = p3.e(bundle);
            return e11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final ImmutableList f25655a;

    /* loaded from: classes3.dex */
    public static final class a implements k {

        /* renamed from: f, reason: collision with root package name */
        public static final k.a f25656f = new k.a() { // from class: com.google.android.exoplayer2.o3
            @Override // com.google.android.exoplayer2.k.a
            public final k a(Bundle bundle) {
                p3.a g11;
                g11 = p3.a.g(bundle);
                return g11;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final int f25657a;

        /* renamed from: b, reason: collision with root package name */
        private final TrackGroup f25658b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f25659c;

        /* renamed from: d, reason: collision with root package name */
        private final int[] f25660d;

        /* renamed from: e, reason: collision with root package name */
        private final boolean[] f25661e;

        public a(TrackGroup trackGroup, boolean z10, int[] iArr, boolean[] zArr) {
            int i11 = trackGroup.f25727a;
            this.f25657a = i11;
            boolean z11 = false;
            com.google.android.exoplayer2.util.a.a(i11 == iArr.length && i11 == zArr.length);
            this.f25658b = trackGroup;
            if (z10 && i11 > 1) {
                z11 = true;
            }
            this.f25659c = z11;
            this.f25660d = (int[]) iArr.clone();
            this.f25661e = (boolean[]) zArr.clone();
        }

        private static String f(int i11) {
            return Integer.toString(i11, 36);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ a g(Bundle bundle) {
            TrackGroup trackGroup = (TrackGroup) TrackGroup.f25726f.a((Bundle) com.google.android.exoplayer2.util.a.e(bundle.getBundle(f(0))));
            return new a(trackGroup, bundle.getBoolean(f(4), false), (int[]) com.google.common.base.h.a(bundle.getIntArray(f(1)), new int[trackGroup.f25727a]), (boolean[]) com.google.common.base.h.a(bundle.getBooleanArray(f(3)), new boolean[trackGroup.f25727a]));
        }

        public o1 b(int i11) {
            return this.f25658b.c(i11);
        }

        public int c() {
            return this.f25658b.f25729c;
        }

        public boolean d() {
            return Booleans.a(this.f25661e, true);
        }

        public boolean e(int i11) {
            return this.f25661e[i11];
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f25659c == aVar.f25659c && this.f25658b.equals(aVar.f25658b) && Arrays.equals(this.f25660d, aVar.f25660d) && Arrays.equals(this.f25661e, aVar.f25661e);
        }

        public int hashCode() {
            return (((((this.f25658b.hashCode() * 31) + (this.f25659c ? 1 : 0)) * 31) + Arrays.hashCode(this.f25660d)) * 31) + Arrays.hashCode(this.f25661e);
        }

        @Override // com.google.android.exoplayer2.k
        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putBundle(f(0), this.f25658b.toBundle());
            bundle.putIntArray(f(1), this.f25660d);
            bundle.putBooleanArray(f(3), this.f25661e);
            bundle.putBoolean(f(4), this.f25659c);
            return bundle;
        }
    }

    public p3(List list) {
        this.f25655a = ImmutableList.copyOf((Collection) list);
    }

    private static String d(int i11) {
        return Integer.toString(i11, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p3 e(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return new p3(parcelableArrayList == null ? ImmutableList.of() : com.google.android.exoplayer2.util.d.b(a.f25656f, parcelableArrayList));
    }

    public ImmutableList b() {
        return this.f25655a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean c(int i11) {
        for (int i12 = 0; i12 < this.f25655a.size(); i12++) {
            a aVar = (a) this.f25655a.get(i12);
            if (aVar.d() && aVar.c() == i11) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p3.class != obj.getClass()) {
            return false;
        }
        return this.f25655a.equals(((p3) obj).f25655a);
    }

    public int hashCode() {
        return this.f25655a.hashCode();
    }

    @Override // com.google.android.exoplayer2.k
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), com.google.android.exoplayer2.util.d.d(this.f25655a));
        return bundle;
    }
}
