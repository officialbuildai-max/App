package com.android.volley.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes2.dex */
public class ByteArrayPool {

    /* renamed from: e, reason: collision with root package name */
    protected static final Comparator f19351e = new Comparator<byte[]>() { // from class: com.android.volley.toolbox.ByteArrayPool.1
        @Override // java.util.Comparator
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final List f19352a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List f19353b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    private int f19354c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final int f19355d;

    public ByteArrayPool(int i11) {
        this.f19355d = i11;
    }

    private synchronized void c() {
        while (this.f19354c > this.f19355d) {
            byte[] bArr = (byte[]) this.f19352a.remove(0);
            this.f19353b.remove(bArr);
            this.f19354c -= bArr.length;
        }
    }

    public synchronized byte[] a(int i11) {
        for (int i12 = 0; i12 < this.f19353b.size(); i12++) {
            byte[] bArr = (byte[]) this.f19353b.get(i12);
            if (bArr.length >= i11) {
                this.f19354c -= bArr.length;
                this.f19353b.remove(i12);
                this.f19352a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i11];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f19355d) {
                this.f19352a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f19353b, bArr, f19351e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f19353b.add(binarySearch, bArr);
                this.f19354c += bArr.length;
                c();
            }
        }
    }
}
