package com.google.firebase.perf.metrics;

import android.util.SparseIntArray;

/* loaded from: classes4.dex */
public class g {

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f32346a;

        /* renamed from: b, reason: collision with root package name */
        int f32347b;

        /* renamed from: c, reason: collision with root package name */
        int f32348c;

        public a(int i11, int i12, int i13) {
            this.f32346a = i11;
            this.f32347b = i12;
            this.f32348c = i13;
        }

        public a a(a aVar) {
            return new a(this.f32346a - aVar.d(), this.f32347b - aVar.c(), this.f32348c - aVar.b());
        }

        public int b() {
            return this.f32348c;
        }

        public int c() {
            return this.f32347b;
        }

        public int d() {
            return this.f32346a;
        }
    }

    public static a a(SparseIntArray[] sparseIntArrayArr) {
        int i11;
        int i12;
        SparseIntArray sparseIntArray;
        int i13 = 0;
        if (sparseIntArrayArr == null || (sparseIntArray = sparseIntArrayArr[0]) == null) {
            i11 = 0;
            i12 = 0;
        } else {
            int i14 = 0;
            i11 = 0;
            i12 = 0;
            while (i13 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i13);
                int valueAt = sparseIntArray.valueAt(i13);
                i14 += valueAt;
                if (keyAt > 700) {
                    i12 += valueAt;
                }
                if (keyAt > 16) {
                    i11 += valueAt;
                }
                i13++;
            }
            i13 = i14;
        }
        return new a(i13, i11, i12);
    }
}
