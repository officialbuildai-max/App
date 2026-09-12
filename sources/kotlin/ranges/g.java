package kotlin.ranges;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.ULong;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;

/* loaded from: classes7.dex */
final class g implements Iterator, KMappedMarker {

    /* renamed from: a, reason: collision with root package name */
    private final long f67501a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f67502b;

    /* renamed from: c, reason: collision with root package name */
    private final long f67503c;

    /* renamed from: d, reason: collision with root package name */
    private long f67504d;

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0019, code lost:
    
        if (r0 >= 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0 <= 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0013, code lost:
    
        r1 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private g(long r4, long r6, long r8) {
        /*
            r3 = this;
            r3.<init>()
            r3.f67501a = r6
            r0 = 0
            int r0 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 <= 0) goto L15
            int r0 = androidx.collection.b0.a(r4, r6)
            if (r0 > 0) goto L1c
        L13:
            r1 = r2
            goto L1c
        L15:
            int r0 = androidx.collection.b0.a(r4, r6)
            if (r0 < 0) goto L1c
            goto L13
        L1c:
            r3.f67502b = r1
            long r8 = kotlin.ULong.b(r8)
            r3.f67503c = r8
            boolean r8 = r3.f67502b
            if (r8 == 0) goto L29
            goto L2a
        L29:
            r4 = r6
        L2a:
            r3.f67504d = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.ranges.g.<init>(long, long, long):void");
    }

    public /* synthetic */ g(long j11, long j12, long j13, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13);
    }

    public long a() {
        long j11 = this.f67504d;
        if (j11 != this.f67501a) {
            this.f67504d = ULong.b(this.f67503c + j11);
        } else {
            if (!this.f67502b) {
                throw new NoSuchElementException();
            }
            this.f67502b = false;
        }
        return j11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f67502b;
    }

    @Override // java.util.Iterator
    public /* bridge */ /* synthetic */ Object next() {
        return ULong.a(a());
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
