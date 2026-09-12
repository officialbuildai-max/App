package androidx.compose.runtime.snapshots;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.sequences.SequencesKt;

/* loaded from: classes.dex */
public final class SnapshotIdSet implements Iterable, KMappedMarker {

    /* renamed from: e, reason: collision with root package name */
    public static final a f3991e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final SnapshotIdSet f3992f = new SnapshotIdSet(0, 0, 0, null);

    /* renamed from: a, reason: collision with root package name */
    private final long f3993a;

    /* renamed from: b, reason: collision with root package name */
    private final long f3994b;

    /* renamed from: c, reason: collision with root package name */
    private final int f3995c;

    /* renamed from: d, reason: collision with root package name */
    private final int[] f3996d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SnapshotIdSet a() {
            return SnapshotIdSet.f3992f;
        }
    }

    private SnapshotIdSet(long j11, long j12, int i11, int[] iArr) {
        this.f3993a = j11;
        this.f3994b = j12;
        this.f3995c = i11;
        this.f3996d = iArr;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return SequencesKt.b(new SnapshotIdSet$iterator$1(this, null)).getF67553a();
    }

    public final SnapshotIdSet j(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        SnapshotIdSet snapshotIdSet3 = f3992f;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet3;
        }
        int i11 = snapshotIdSet.f3995c;
        int i12 = this.f3995c;
        if (i11 == i12) {
            int[] iArr = snapshotIdSet.f3996d;
            int[] iArr2 = this.f3996d;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.f3993a & (~snapshotIdSet.f3993a), this.f3994b & (~snapshotIdSet.f3994b), i12, iArr2);
            }
        }
        int[] iArr3 = snapshotIdSet.f3996d;
        if (iArr3 != null) {
            snapshotIdSet2 = this;
            for (int i13 : iArr3) {
                snapshotIdSet2 = snapshotIdSet2.l(i13);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.f3994b != 0) {
            for (int i14 = 0; i14 < 64; i14++) {
                if ((snapshotIdSet.f3994b & (1 << i14)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.l(snapshotIdSet.f3995c + i14);
                }
            }
        }
        if (snapshotIdSet.f3993a != 0) {
            for (int i15 = 0; i15 < 64; i15++) {
                if ((snapshotIdSet.f3993a & (1 << i15)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.l(i15 + 64 + snapshotIdSet.f3995c);
                }
            }
        }
        return snapshotIdSet2;
    }

    public final SnapshotIdSet l(int i11) {
        int[] iArr;
        int a11;
        int i12 = this.f3995c;
        int i13 = i11 - i12;
        if (i13 >= 0 && i13 < 64) {
            long j11 = 1 << i13;
            long j12 = this.f3994b;
            if ((j12 & j11) != 0) {
                return new SnapshotIdSet(this.f3993a, j12 & (~j11), i12, this.f3996d);
            }
        } else if (i13 >= 64 && i13 < 128) {
            long j13 = 1 << (i13 - 64);
            long j14 = this.f3993a;
            if ((j14 & j13) != 0) {
                return new SnapshotIdSet(j14 & (~j13), this.f3994b, i12, this.f3996d);
            }
        } else if (i13 < 0 && (iArr = this.f3996d) != null && (a11 = m.a(iArr, i11)) >= 0) {
            int length = iArr.length;
            int i14 = length - 1;
            if (i14 == 0) {
                return new SnapshotIdSet(this.f3993a, this.f3994b, this.f3995c, null);
            }
            int[] iArr2 = new int[i14];
            if (a11 > 0) {
                ArraysKt.l(iArr, iArr2, 0, 0, a11);
            }
            if (a11 < i14) {
                ArraysKt.l(iArr, iArr2, a11, a11 + 1, length);
            }
            return new SnapshotIdSet(this.f3993a, this.f3994b, this.f3995c, iArr2);
        }
        return this;
    }

    public final boolean m(int i11) {
        int[] iArr;
        int i12 = i11 - this.f3995c;
        if (i12 >= 0 && i12 < 64) {
            return ((1 << i12) & this.f3994b) != 0;
        }
        if (i12 >= 64 && i12 < 128) {
            return ((1 << (i12 - 64)) & this.f3993a) != 0;
        }
        if (i12 <= 0 && (iArr = this.f3996d) != null) {
            return m.a(iArr, i11) >= 0;
        }
        return false;
    }

    public final int n(int i11) {
        int[] iArr = this.f3996d;
        if (iArr != null) {
            return iArr[0];
        }
        long j11 = this.f3994b;
        if (j11 != 0) {
            return this.f3995c + Long.numberOfTrailingZeros(j11);
        }
        long j12 = this.f3993a;
        return j12 != 0 ? this.f3995c + 64 + Long.numberOfTrailingZeros(j12) : i11;
    }

    public final SnapshotIdSet o(SnapshotIdSet snapshotIdSet) {
        SnapshotIdSet snapshotIdSet2;
        SnapshotIdSet snapshotIdSet3 = f3992f;
        if (snapshotIdSet == snapshotIdSet3) {
            return this;
        }
        if (this == snapshotIdSet3) {
            return snapshotIdSet;
        }
        int i11 = snapshotIdSet.f3995c;
        int i12 = this.f3995c;
        if (i11 == i12) {
            int[] iArr = snapshotIdSet.f3996d;
            int[] iArr2 = this.f3996d;
            if (iArr == iArr2) {
                return new SnapshotIdSet(this.f3993a | snapshotIdSet.f3993a, this.f3994b | snapshotIdSet.f3994b, i12, iArr2);
            }
        }
        int i13 = 0;
        if (this.f3996d == null) {
            int[] iArr3 = this.f3996d;
            if (iArr3 != null) {
                for (int i14 : iArr3) {
                    snapshotIdSet = snapshotIdSet.p(i14);
                }
            }
            if (this.f3994b != 0) {
                for (int i15 = 0; i15 < 64; i15++) {
                    if ((this.f3994b & (1 << i15)) != 0) {
                        snapshotIdSet = snapshotIdSet.p(this.f3995c + i15);
                    }
                }
            }
            if (this.f3993a != 0) {
                while (i13 < 64) {
                    if ((this.f3993a & (1 << i13)) != 0) {
                        snapshotIdSet = snapshotIdSet.p(i13 + 64 + this.f3995c);
                    }
                    i13++;
                }
            }
            return snapshotIdSet;
        }
        int[] iArr4 = snapshotIdSet.f3996d;
        if (iArr4 != null) {
            snapshotIdSet2 = this;
            for (int i16 : iArr4) {
                snapshotIdSet2 = snapshotIdSet2.p(i16);
            }
        } else {
            snapshotIdSet2 = this;
        }
        if (snapshotIdSet.f3994b != 0) {
            for (int i17 = 0; i17 < 64; i17++) {
                if ((snapshotIdSet.f3994b & (1 << i17)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.p(snapshotIdSet.f3995c + i17);
                }
            }
        }
        if (snapshotIdSet.f3993a != 0) {
            while (i13 < 64) {
                if ((snapshotIdSet.f3993a & (1 << i13)) != 0) {
                    snapshotIdSet2 = snapshotIdSet2.p(i13 + 64 + snapshotIdSet.f3995c);
                }
                i13++;
            }
        }
        return snapshotIdSet2;
    }

    public final SnapshotIdSet p(int i11) {
        int i12;
        int[] iArr;
        int i13 = this.f3995c;
        int i14 = i11 - i13;
        long j11 = 0;
        if (i14 >= 0 && i14 < 64) {
            long j12 = 1 << i14;
            long j13 = this.f3994b;
            if ((j13 & j12) == 0) {
                return new SnapshotIdSet(this.f3993a, j13 | j12, i13, this.f3996d);
            }
        } else if (i14 >= 64 && i14 < 128) {
            long j14 = 1 << (i14 - 64);
            long j15 = this.f3993a;
            if ((j15 & j14) == 0) {
                return new SnapshotIdSet(j15 | j14, this.f3994b, i13, this.f3996d);
            }
        } else if (i14 < 128) {
            int[] iArr2 = this.f3996d;
            if (iArr2 == null) {
                return new SnapshotIdSet(this.f3993a, this.f3994b, i13, new int[]{i11});
            }
            int a11 = m.a(iArr2, i11);
            if (a11 < 0) {
                int i15 = -(a11 + 1);
                int length = iArr2.length;
                int[] iArr3 = new int[length + 1];
                ArraysKt.l(iArr2, iArr3, 0, 0, i15);
                ArraysKt.l(iArr2, iArr3, i15 + 1, i15, length);
                iArr3[i15] = i11;
                return new SnapshotIdSet(this.f3993a, this.f3994b, this.f3995c, iArr3);
            }
        } else if (!m(i11)) {
            long j16 = this.f3993a;
            long j17 = this.f3994b;
            int i16 = this.f3995c;
            int i17 = ((i11 + 1) / 64) * 64;
            ArrayList arrayList = null;
            long j18 = j17;
            long j19 = j16;
            while (true) {
                if (i16 >= i17) {
                    i12 = i16;
                    break;
                }
                if (j18 != j11) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        int[] iArr4 = this.f3996d;
                        if (iArr4 != null) {
                            for (int i18 : iArr4) {
                                arrayList.add(Integer.valueOf(i18));
                            }
                        }
                    }
                    for (int i19 = 0; i19 < 64; i19++) {
                        if (((1 << i19) & j18) != 0) {
                            arrayList.add(Integer.valueOf(i19 + i16));
                        }
                    }
                    j11 = 0;
                }
                if (j19 == j11) {
                    i12 = i17;
                    j18 = j11;
                    break;
                }
                i16 += 64;
                j18 = j19;
                j19 = j11;
            }
            if (arrayList == null || (iArr = CollectionsKt.Q0(arrayList)) == null) {
                iArr = this.f3996d;
            }
            return new SnapshotIdSet(j19, j18, i12, iArr).p(i11);
        }
        return this;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(" [");
        ArrayList arrayList = new ArrayList(CollectionsKt.v(this, 10));
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(((Number) it.next()).intValue()));
        }
        sb2.append(androidx.compose.runtime.snapshots.a.d(arrayList, null, null, null, 0, null, null, 63, null));
        sb2.append(']');
        return sb2.toString();
    }
}
