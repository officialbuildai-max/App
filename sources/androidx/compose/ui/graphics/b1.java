package androidx.compose.ui.graphics;

/* loaded from: classes.dex */
public abstract class b1 {
    public static final long b(float f11, float f12, float f13, float f14, float[] fArr, int i11) {
        float f15 = (f12 - f11) * 3.0f;
        float f16 = (f13 - f12) * 3.0f;
        float f17 = (f14 - f13) * 3.0f;
        int f18 = f(f15, f16, f17, fArr, i11);
        float f19 = (f16 - f15) * 2.0f;
        int g11 = f18 + g((-f19) / (((f17 - f16) * 2.0f) - f19), fArr, i11 + f18);
        float min = Math.min(f11, f14);
        float max = Math.max(f11, f14);
        for (int i12 = 0; i12 < g11; i12++) {
            float d11 = d(f11, f12, f13, f14, fArr[i12]);
            min = Math.min(min, d11);
            max = Math.max(max, d11);
        }
        return androidx.collection.h.a(min, max);
    }

    public static final float c(float f11, float f12, float f13) {
        return ((((((f11 - f12) + 0.33333334f) * f13) + (f12 - (2.0f * f11))) * f13) + f11) * 3.0f * f13;
    }

    private static final float d(float f11, float f12, float f13, float f14, float f15) {
        float f16 = (f14 + ((f12 - f13) * 3.0f)) - f11;
        return (((((f16 * f15) + (((f13 - (2.0f * f12)) + f11) * 3.0f)) * f15) + ((f12 - f11) * 3.0f)) * f15) + f11;
    }

    public static final float e(float f11, float f12, float f13, float f14) {
        double d11 = f11;
        double d12 = ((d11 - (f12 * 2.0d)) + f13) * 3.0d;
        double d13 = (f12 - f11) * 3.0d;
        double d14 = (-f11) + ((f12 - f13) * 3.0d) + f14;
        if (Math.abs(d14 - 0.0d) < 1.0E-7d) {
            if (Math.abs(d12 - 0.0d) < 1.0E-7d) {
                if (Math.abs(d13 - 0.0d) < 1.0E-7d) {
                    return Float.NaN;
                }
                float f15 = (float) ((-d11) / d13);
                if (f15 < 0.0f) {
                    if (f15 >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (f15 <= 1.0f) {
                        return f15;
                    }
                    if (f15 <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            double sqrt = Math.sqrt((d13 * d13) - ((4.0d * d12) * d11));
            double d15 = d12 * 2.0d;
            float f16 = (float) ((sqrt - d13) / d15);
            if (f16 < 0.0f) {
                if (f16 >= -8.34465E-7f) {
                    f16 = 0.0f;
                }
                f16 = Float.NaN;
            } else if (f16 > 1.0f) {
                if (f16 <= 1.0000008f) {
                    f16 = 1.0f;
                }
                f16 = Float.NaN;
            }
            if (!Float.isNaN(f16)) {
                return f16;
            }
            float f17 = (float) (((-d13) - sqrt) / d15);
            if (f17 < 0.0f) {
                if (f17 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f17 <= 1.0f) {
                    return f17;
                }
                if (f17 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double d16 = d12 / d14;
        double d17 = d13 / d14;
        double d18 = d11 / d14;
        double d19 = ((d17 * 3.0d) - (d16 * d16)) / 9.0d;
        double d20 = (((((2.0d * d16) * d16) * d16) - ((9.0d * d16) * d17)) + (d18 * 27.0d)) / 54.0d;
        double d21 = d19 * d19 * d19;
        double d22 = (d20 * d20) + d21;
        double d23 = d16 / 3.0d;
        if (d22 >= 0.0d) {
            if (d22 != 0.0d) {
                double sqrt2 = Math.sqrt(d22);
                float a11 = (float) ((q0.b.a((float) ((-d20) + sqrt2)) - q0.b.a((float) (d20 + sqrt2))) - d23);
                if (a11 < 0.0f) {
                    if (a11 >= -8.34465E-7f) {
                        return 0.0f;
                    }
                } else {
                    if (a11 <= 1.0f) {
                        return a11;
                    }
                    if (a11 <= 1.0000008f) {
                        return 1.0f;
                    }
                }
                return Float.NaN;
            }
            float f18 = -q0.b.a((float) d20);
            float f19 = (float) d23;
            float f20 = (2.0f * f18) - f19;
            if (f20 < 0.0f) {
                if (f20 >= -8.34465E-7f) {
                    f20 = 0.0f;
                }
                f20 = Float.NaN;
            } else if (f20 > 1.0f) {
                if (f20 <= 1.0000008f) {
                    f20 = 1.0f;
                }
                f20 = Float.NaN;
            }
            if (!Float.isNaN(f20)) {
                return f20;
            }
            float f21 = (-f18) - f19;
            if (f21 < 0.0f) {
                if (f21 >= -8.34465E-7f) {
                    return 0.0f;
                }
            } else {
                if (f21 <= 1.0f) {
                    return f21;
                }
                if (f21 <= 1.0000008f) {
                    return 1.0f;
                }
            }
            return Float.NaN;
        }
        double sqrt3 = Math.sqrt(-d21);
        double d24 = (-d20) / sqrt3;
        if (d24 < -1.0d) {
            d24 = -1.0d;
        }
        if (d24 > 1.0d) {
            d24 = 1.0d;
        }
        double acos = Math.acos(d24);
        double a12 = q0.b.a((float) sqrt3) * 2.0f;
        float cos = (float) ((Math.cos(acos / 3.0d) * a12) - d23);
        if (cos < 0.0f) {
            if (cos >= -8.34465E-7f) {
                cos = 0.0f;
            }
            cos = Float.NaN;
        } else if (cos > 1.0f) {
            if (cos <= 1.0000008f) {
                cos = 1.0f;
            }
            cos = Float.NaN;
        }
        if (!Float.isNaN(cos)) {
            return cos;
        }
        float cos2 = (float) ((Math.cos((6.283185307179586d + acos) / 3.0d) * a12) - d23);
        if (cos2 < 0.0f) {
            if (cos2 >= -8.34465E-7f) {
                cos2 = 0.0f;
            }
            cos2 = Float.NaN;
        } else if (cos2 > 1.0f) {
            if (cos2 <= 1.0000008f) {
                cos2 = 1.0f;
            }
            cos2 = Float.NaN;
        }
        if (!Float.isNaN(cos2)) {
            return cos2;
        }
        float cos3 = (float) ((a12 * Math.cos((acos + 12.566370614359172d) / 3.0d)) - d23);
        if (cos3 < 0.0f) {
            if (cos3 >= -8.34465E-7f) {
                return 0.0f;
            }
        } else {
            if (cos3 <= 1.0f) {
                return cos3;
            }
            if (cos3 <= 1.0000008f) {
                return 1.0f;
            }
        }
        return Float.NaN;
    }

    private static final int f(float f11, float f12, float f13, float[] fArr, int i11) {
        double d11 = f11;
        double d12 = f12;
        double d13 = f13;
        double d14 = d12 * 2.0d;
        double d15 = (d11 - d14) + d13;
        if (d15 == 0.0d) {
            if (d12 == d13) {
                return 0;
            }
            return g((float) ((d14 - d13) / (d14 - (d13 * 2.0d))), fArr, i11);
        }
        double d16 = -Math.sqrt((d12 * d12) - (d13 * d11));
        double d17 = (-d11) + d12;
        int g11 = g((float) ((-(d16 + d17)) / d15), fArr, i11);
        int g12 = g11 + g((float) ((d16 - d17) / d15), fArr, i11 + g11);
        if (g12 > 1) {
            float f14 = fArr[i11];
            int i12 = i11 + 1;
            float f15 = fArr[i12];
            if (f14 > f15) {
                fArr[i11] = f15;
                fArr[i12] = f14;
            } else if (f14 == f15) {
                return g12 - 1;
            }
        }
        return g12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001c, code lost:
    
        if (r3 <= 1.0000008f) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000b, code lost:
    
        if (r3 >= (-8.34465E-7f)) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000d, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000f, code lost:
    
        r3 = Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int g(float r3, float[] r4, int r5) {
        /*
            r0 = 0
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            r2 = 2143289344(0x7fc00000, float:NaN)
            if (r1 >= 0) goto L11
            r1 = -1251999744(0xffffffffb5600000, float:-8.34465E-7)
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 < 0) goto Lf
        Ld:
            r3 = r0
            goto L1f
        Lf:
            r3 = r2
            goto L1f
        L11:
            r0 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L1f
            r1 = 1065353223(0x3f800007, float:1.0000008)
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 > 0) goto Lf
            goto Ld
        L1f:
            r4[r5] = r3
            boolean r3 = java.lang.Float.isNaN(r3)
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.b1.g(float, float[], int):int");
    }
}
