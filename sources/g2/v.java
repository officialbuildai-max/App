package g2;

import java.util.Arrays;
import java.util.Random;

/* loaded from: classes2.dex */
public interface v {

    /* loaded from: classes2.dex */
    public static class a implements v {

        /* renamed from: a, reason: collision with root package name */
        private final Random f63368a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f63369b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f63370c;

        public a(int i11) {
            this(i11, new Random());
        }

        private a(int i11, Random random) {
            this(b(i11, random), random);
        }

        private a(int[] iArr, Random random) {
            this.f63369b = iArr;
            this.f63368a = random;
            this.f63370c = new int[iArr.length];
            for (int i11 = 0; i11 < iArr.length; i11++) {
                this.f63370c[iArr[i11]] = i11;
            }
        }

        private static int[] b(int i11, Random random) {
            int[] iArr = new int[i11];
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12 + 1;
                int nextInt = random.nextInt(i13);
                iArr[i12] = iArr[nextInt];
                iArr[nextInt] = i12;
                i12 = i13;
            }
            return iArr;
        }

        @Override // g2.v
        public v a(int i11, int i12) {
            int i13 = i12 - i11;
            int[] iArr = new int[this.f63369b.length - i13];
            int i14 = 0;
            int i15 = 0;
            while (true) {
                int[] iArr2 = this.f63369b;
                if (i14 >= iArr2.length) {
                    return new a(iArr, new Random(this.f63368a.nextLong()));
                }
                int i16 = iArr2[i14];
                if (i16 < i11 || i16 >= i12) {
                    int i17 = i14 - i15;
                    if (i16 >= i11) {
                        i16 -= i13;
                    }
                    iArr[i17] = i16;
                } else {
                    i15++;
                }
                i14++;
            }
        }

        @Override // g2.v
        public v cloneAndClear() {
            return new a(0, new Random(this.f63368a.nextLong()));
        }

        @Override // g2.v
        public v cloneAndInsert(int i11, int i12) {
            int[] iArr = new int[i12];
            int[] iArr2 = new int[i12];
            int i13 = 0;
            int i14 = 0;
            while (i14 < i12) {
                iArr[i14] = this.f63368a.nextInt(this.f63369b.length + 1);
                int i15 = i14 + 1;
                int nextInt = this.f63368a.nextInt(i15);
                iArr2[i14] = iArr2[nextInt];
                iArr2[nextInt] = i14 + i11;
                i14 = i15;
            }
            Arrays.sort(iArr);
            int[] iArr3 = new int[this.f63369b.length + i12];
            int i16 = 0;
            int i17 = 0;
            while (true) {
                int[] iArr4 = this.f63369b;
                if (i13 >= iArr4.length + i12) {
                    return new a(iArr3, new Random(this.f63368a.nextLong()));
                }
                if (i16 >= i12 || i17 != iArr[i16]) {
                    int i18 = i17 + 1;
                    int i19 = iArr4[i17];
                    iArr3[i13] = i19;
                    if (i19 >= i11) {
                        iArr3[i13] = i19 + i12;
                    }
                    i17 = i18;
                } else {
                    iArr3[i13] = iArr2[i16];
                    i16++;
                }
                i13++;
            }
        }

        @Override // g2.v
        public int getFirstIndex() {
            int[] iArr = this.f63369b;
            if (iArr.length > 0) {
                return iArr[0];
            }
            return -1;
        }

        @Override // g2.v
        public int getLastIndex() {
            int[] iArr = this.f63369b;
            if (iArr.length > 0) {
                return iArr[iArr.length - 1];
            }
            return -1;
        }

        @Override // g2.v
        public int getLength() {
            return this.f63369b.length;
        }

        @Override // g2.v
        public int getNextIndex(int i11) {
            int i12 = this.f63370c[i11] + 1;
            int[] iArr = this.f63369b;
            if (i12 < iArr.length) {
                return iArr[i12];
            }
            return -1;
        }

        @Override // g2.v
        public int getPreviousIndex(int i11) {
            int i12 = this.f63370c[i11] - 1;
            if (i12 >= 0) {
                return this.f63369b[i12];
            }
            return -1;
        }
    }

    v a(int i11, int i12);

    v cloneAndClear();

    v cloneAndInsert(int i11, int i12);

    int getFirstIndex();

    int getLastIndex();

    int getLength();

    int getNextIndex(int i11);

    int getPreviousIndex(int i11);
}
