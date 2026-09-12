package com.google.common.primitives;

import java.util.Comparator;

/* loaded from: classes4.dex */
public abstract class Floats extends b {

    /* loaded from: classes4.dex */
    private enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i11 = 0; i11 < min; i11++) {
                int compare = Float.compare(fArr[i11], fArr2[i11]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    public static int a(float f11) {
        return Float.valueOf(f11).hashCode();
    }
}
