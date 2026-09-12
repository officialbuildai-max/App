package com.google.common.collect;

import java.util.Comparator;

/* loaded from: classes4.dex */
public abstract class h2 {

    /* renamed from: a, reason: collision with root package name */
    private static final h2 f30853a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final h2 f30854b = new b(-1);

    /* renamed from: c, reason: collision with root package name */
    private static final h2 f30855c = new b(1);

    /* loaded from: classes4.dex */
    class a extends h2 {
        a() {
            super(null);
        }

        @Override // com.google.common.collect.h2
        public h2 d(int i11, int i12) {
            return l(Integer.compare(i11, i12));
        }

        @Override // com.google.common.collect.h2
        public h2 e(long j11, long j12) {
            return l(Long.compare(j11, j12));
        }

        @Override // com.google.common.collect.h2
        public h2 f(Comparable comparable, Comparable comparable2) {
            return l(comparable.compareTo(comparable2));
        }

        @Override // com.google.common.collect.h2
        public h2 g(Object obj, Object obj2, Comparator comparator) {
            return l(comparator.compare(obj, obj2));
        }

        @Override // com.google.common.collect.h2
        public h2 h(boolean z10, boolean z11) {
            return l(Boolean.compare(z10, z11));
        }

        @Override // com.google.common.collect.h2
        public h2 i(boolean z10, boolean z11) {
            return l(Boolean.compare(z11, z10));
        }

        @Override // com.google.common.collect.h2
        public int j() {
            return 0;
        }

        h2 l(int i11) {
            return i11 < 0 ? h2.f30854b : i11 > 0 ? h2.f30855c : h2.f30853a;
        }
    }

    /* loaded from: classes4.dex */
    private static final class b extends h2 {

        /* renamed from: d, reason: collision with root package name */
        final int f30856d;

        b(int i11) {
            super(null);
            this.f30856d = i11;
        }

        @Override // com.google.common.collect.h2
        public h2 d(int i11, int i12) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 e(long j11, long j12) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 f(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 g(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 h(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public h2 i(boolean z10, boolean z11) {
            return this;
        }

        @Override // com.google.common.collect.h2
        public int j() {
            return this.f30856d;
        }
    }

    private h2() {
    }

    /* synthetic */ h2(a aVar) {
        this();
    }

    public static h2 k() {
        return f30853a;
    }

    public abstract h2 d(int i11, int i12);

    public abstract h2 e(long j11, long j12);

    public abstract h2 f(Comparable comparable, Comparable comparable2);

    public abstract h2 g(Object obj, Object obj2, Comparator comparator);

    public abstract h2 h(boolean z10, boolean z11);

    public abstract h2 i(boolean z10, boolean z11);

    public abstract int j();
}
