package com.mbridge.msdk.tracker.network.toolbox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    protected static final Comparator<byte[]> f38704e = new a();

    /* renamed from: a, reason: collision with root package name */
    private final List<byte[]> f38705a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final List<byte[]> f38706b = new ArrayList(64);

    /* renamed from: c, reason: collision with root package name */
    private int f38707c = 0;

    /* renamed from: d, reason: collision with root package name */
    private final int f38708d;

    /* loaded from: classes5.dex */
    class a implements Comparator<byte[]> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(byte[] bArr, byte[] bArr2) {
            return bArr.length - bArr2.length;
        }
    }

    public c(int i11) {
        this.f38708d = i11;
    }

    private synchronized void a() {
        while (this.f38707c > this.f38708d) {
            byte[] remove = this.f38705a.remove(0);
            this.f38706b.remove(remove);
            this.f38707c -= remove.length;
        }
    }

    public synchronized void a(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f38708d) {
                this.f38705a.add(bArr);
                int binarySearch = Collections.binarySearch(this.f38706b, bArr, f38704e);
                if (binarySearch < 0) {
                    binarySearch = (-binarySearch) - 1;
                }
                this.f38706b.add(binarySearch, bArr);
                this.f38707c += bArr.length;
                a();
            }
        }
    }

    public synchronized byte[] a(int i11) {
        for (int i12 = 0; i12 < this.f38706b.size(); i12++) {
            byte[] bArr = this.f38706b.get(i12);
            if (bArr.length >= i11) {
                this.f38707c -= bArr.length;
                this.f38706b.remove(i12);
                this.f38705a.remove(bArr);
                return bArr;
            }
        }
        return new byte[i11];
    }
}
