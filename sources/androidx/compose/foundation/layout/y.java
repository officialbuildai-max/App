package androidx.compose.foundation.layout;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public abstract class y {
    public static final androidx.compose.ui.layout.v a(x xVar, int i11, int i12, int i13, int i14, int i15, androidx.compose.ui.layout.x xVar2, List list, androidx.compose.ui.layout.g0[] g0VarArr, int i16, int i17, int[] iArr, int i18) {
        int[] iArr2;
        long j11;
        long j12;
        String str;
        String str2;
        int i19;
        Integer num;
        int i20;
        int m11;
        int i21;
        String str3;
        int i22;
        float f11;
        String str4;
        float f12;
        long j13;
        long j14;
        String str5;
        String str6;
        String str7;
        String str8;
        int i23;
        int i24;
        String str9;
        float f13;
        int i25;
        int i26;
        float f14;
        String str10;
        long j15;
        int i27;
        String str11;
        String str12;
        int i28;
        int i29;
        float f15;
        float f16;
        char c11;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        long j16;
        int[] iArr3;
        int i37;
        int i38;
        float f17;
        int[] iArr4;
        int i39;
        List list2 = list;
        int i40 = i17;
        int i41 = i40 - i16;
        int i42 = 0;
        int i43 = i16;
        int i44 = 0;
        int i45 = 0;
        int i46 = 0;
        int i47 = 0;
        int[] iArr5 = new int[i41];
        long j17 = i15;
        float f18 = 0.0f;
        int i48 = 0;
        while (true) {
            if (i43 >= i40) {
                break;
            }
            int i49 = i48;
            androidx.compose.ui.layout.s sVar = (androidx.compose.ui.layout.s) list2.get(i43);
            z c12 = v.c(sVar);
            float e11 = v.e(c12);
            i47 = (i47 != 0 || v.f(c12)) ? 1 : i42;
            if (e11 > 0.0f) {
                i46++;
                i36 = i43;
                j16 = j17;
                iArr4 = iArr5;
                i38 = i41;
                f17 = f18 + e11;
                i39 = i42;
            } else {
                if (i14 != Integer.MAX_VALUE && c12 != null) {
                    c12.c();
                }
                int i50 = i13 - i45;
                androidx.compose.ui.layout.g0 g0Var = g0VarArr[i43];
                if (g0Var == null) {
                    i33 = i50;
                    i34 = i45;
                    i35 = i46;
                    i36 = i43;
                    iArr3 = iArr5;
                    j16 = j17;
                    i37 = i49;
                    i38 = i41;
                    f17 = f18;
                    g0Var = sVar.P(w.a(xVar, 0, 0, i13 != Integer.MAX_VALUE ? RangesKt.f(i50, i42) : Integer.MAX_VALUE, i14, false, 16, null));
                } else {
                    i33 = i50;
                    i34 = i45;
                    i35 = i46;
                    i36 = i43;
                    j16 = j17;
                    iArr3 = iArr5;
                    i37 = i49;
                    i38 = i41;
                    f17 = f18;
                }
                androidx.compose.ui.layout.g0 g0Var2 = g0Var;
                int e12 = xVar.e(g0Var2);
                int f19 = xVar.f(g0Var2);
                iArr4 = iArr3;
                iArr4[i36 - i16] = e12;
                i39 = 0;
                int min = Math.min(i15, RangesKt.f(i33 - e12, 0));
                i45 = e12 + min + i34;
                int max = Math.max(i37, f19);
                g0VarArr[i36] = g0Var2;
                i49 = max;
                i44 = min;
                i46 = i35;
            }
            i43 = i36 + 1;
            iArr5 = iArr4;
            i42 = i39;
            f18 = f17;
            i41 = i38;
            i48 = i49;
            j17 = j16;
        }
        int i51 = i48;
        long j18 = j17;
        int[] iArr6 = iArr5;
        int i52 = i41;
        float f20 = f18;
        int i53 = i42;
        int i54 = i45;
        int i55 = i46;
        if (i55 == 0) {
            i21 = i54 - i44;
            iArr2 = iArr6;
            m11 = i53;
            i19 = i11;
            i20 = i51;
            num = null;
        } else {
            int i56 = i13 != Integer.MAX_VALUE ? i13 : i11;
            iArr2 = iArr6;
            long j19 = (i55 - 1) * j18;
            long g11 = RangesKt.g((i56 - i54) - j19, 0L);
            float f21 = ((float) g11) / f20;
            int i57 = i16;
            long j20 = g11;
            while (true) {
                j11 = g11;
                j12 = j19;
                str = "arrangementSpacingPx ";
                str2 = "targetSpace ";
                if (i57 >= i40) {
                    break;
                }
                float e13 = v.e(v.c((androidx.compose.ui.layout.s) list2.get(i57)));
                float f22 = f21 * e13;
                try {
                    j20 -= Math.round(f22);
                    i57++;
                    list2 = list;
                    i40 = i17;
                    g11 = j11;
                    j19 = j12;
                } catch (IllegalArgumentException e14) {
                    throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/297974033 mainAxisMax " + i13 + "mainAxisMin " + i11 + "targetSpace " + i56 + "arrangementSpacingPx " + j18 + "weightChildrenCount " + i55 + "fixedSpace " + i54 + "arrangementSpacingTotal " + j12 + "remainingToTarget " + j11 + "totalWeight " + f20 + "weightUnitSpace " + f21 + "itemWeight " + e13 + "weightedSize " + f22).initCause(e14);
                }
            }
            i19 = i11;
            float f23 = f20;
            String str13 = "weightedSize ";
            String str14 = "weightUnitSpace ";
            String str15 = "totalWeight ";
            long j21 = j11;
            String str16 = "remainingToTarget ";
            long j22 = j12;
            String str17 = "arrangementSpacingTotal ";
            long j23 = j18;
            int i58 = i51;
            int i59 = 0;
            int i60 = i16;
            int i61 = i17;
            while (i60 < i61) {
                if (g0VarArr[i60] == null) {
                    androidx.compose.ui.layout.s sVar2 = (androidx.compose.ui.layout.s) list.get(i60);
                    z c13 = v.c(sVar2);
                    float e15 = v.e(c13);
                    String str18 = str;
                    int i62 = i56;
                    if (i14 != Integer.MAX_VALUE && c13 != null) {
                        c13.c();
                    }
                    if (e15 <= 0.0f) {
                        throw new IllegalStateException("All weights <= 0 should have placeables");
                    }
                    int b11 = MathKt.b(j20);
                    String str19 = str2;
                    j20 -= b11;
                    float f24 = f21 * e15;
                    int max2 = Math.max(0, Math.round(f24) + b11);
                    try {
                        try {
                            if (v.b(c13)) {
                                c11 = 65535;
                                if (max2 != Integer.MAX_VALUE) {
                                    i30 = max2;
                                    j15 = j22;
                                    str11 = str18;
                                    i28 = b11;
                                    i29 = max2;
                                    str12 = str19;
                                    int i63 = i30;
                                    f13 = f24;
                                    i27 = i62;
                                    i25 = i55;
                                    i26 = i54;
                                    f14 = e15;
                                    f15 = f21;
                                    str10 = str13;
                                    f16 = f23;
                                    j13 = j23;
                                    androidx.compose.ui.layout.g0 P = sVar2.P(xVar.a(i63, 0, i29, i14, true));
                                    int e16 = xVar.e(P);
                                    int f25 = xVar.f(P);
                                    iArr2[i60 - i16] = e16;
                                    i59 += e16;
                                    int max3 = Math.max(i58, f25);
                                    g0VarArr[i60] = P;
                                    i58 = max3;
                                    str4 = str10;
                                    f12 = f16;
                                    f11 = f15;
                                    j14 = j21;
                                    str5 = str14;
                                    str6 = str15;
                                    str7 = str16;
                                    str8 = str17;
                                    j22 = j15;
                                    str3 = str11;
                                    str9 = str12;
                                    i23 = i27;
                                    i24 = i25;
                                    i22 = i26;
                                }
                            } else {
                                c11 = 65535;
                            }
                            androidx.compose.ui.layout.g0 P2 = sVar2.P(xVar.a(i63, 0, i29, i14, true));
                            int e162 = xVar.e(P2);
                            int f252 = xVar.f(P2);
                            iArr2[i60 - i16] = e162;
                            i59 += e162;
                            int max32 = Math.max(i58, f252);
                            g0VarArr[i60] = P2;
                            i58 = max32;
                            str4 = str10;
                            f12 = f16;
                            f11 = f15;
                            j14 = j21;
                            str5 = str14;
                            str6 = str15;
                            str7 = str16;
                            str8 = str17;
                            j22 = j15;
                            str3 = str11;
                            str9 = str12;
                            i23 = i27;
                            i24 = i25;
                            i22 = i26;
                        } catch (IllegalArgumentException e17) {
                            e = e17;
                            throw new IllegalArgumentException("This log indicates a hard-to-reproduce Compose issue, modified with additional debugging details. Please help us by adding your experiences to the bug link provided. Thank you for helping us improve Compose. https://issuetracker.google.com/issues/300280216 mainAxisMax " + i13 + "mainAxisMin " + i19 + str12 + i27 + str11 + j13 + "weightChildrenCount " + i25 + "fixedSpace " + i26 + str17 + j15 + str16 + j21 + str15 + f16 + str14 + f15 + "weight " + f14 + str10 + f13 + "crossAxisDesiredSize " + ((Object) null) + "remainderUnit " + i28 + "childMainAxisSize " + i29).initCause(e);
                        }
                        i30 = 0;
                        j15 = j22;
                        str11 = str18;
                        i28 = b11;
                        i29 = max2;
                        str12 = str19;
                        int i632 = i30;
                        f13 = f24;
                        i27 = i62;
                        i25 = i55;
                        i26 = i54;
                        f14 = e15;
                        f15 = f21;
                        str10 = str13;
                        f16 = f23;
                        j13 = j23;
                    } catch (IllegalArgumentException e18) {
                        e = e18;
                        f13 = f24;
                        i25 = i55;
                        i26 = i54;
                        f14 = e15;
                        str10 = str13;
                        j15 = j22;
                        i27 = i62;
                        str11 = str18;
                        str12 = str19;
                        i28 = b11;
                        i29 = max2;
                        f15 = f21;
                        f16 = f23;
                        j13 = j23;
                    }
                } else {
                    str3 = str;
                    i22 = i54;
                    f11 = f21;
                    str4 = str13;
                    f12 = f23;
                    j13 = j23;
                    j14 = j21;
                    str5 = str14;
                    str6 = str15;
                    str7 = str16;
                    str8 = str17;
                    i23 = i56;
                    i24 = i55;
                    str9 = str2;
                }
                i60++;
                str2 = str9;
                i56 = i23;
                str = str3;
                i55 = i24;
                i54 = i22;
                j21 = j14;
                f21 = f11;
                str14 = str5;
                str15 = str6;
                str16 = str7;
                str17 = str8;
                i61 = i17;
                j23 = j13;
                f23 = f12;
                str13 = str4;
            }
            int i64 = i54;
            num = null;
            i20 = i58;
            m11 = RangesKt.m((int) (i59 + j22), 0, i13 - i64);
            i21 = i64;
        }
        if (i47 != 0) {
            int i65 = 0;
            int i66 = 0;
            for (int i67 = i16; i67 < i17; i67++) {
                androidx.compose.ui.layout.g0 g0Var3 = g0VarArr[i67];
                Intrinsics.e(g0Var3);
                m a11 = v.a(v.d(g0Var3));
                Integer b12 = a11 != null ? a11.b(g0Var3) : num;
                if (b12 != null) {
                    int intValue = b12.intValue();
                    int f26 = xVar.f(g0Var3);
                    i65 = Math.max(i65, intValue != Integer.MIN_VALUE ? b12.intValue() : 0);
                    if (intValue == Integer.MIN_VALUE) {
                        intValue = f26;
                    }
                    i66 = Math.max(i66, f26 - intValue);
                }
            }
            i31 = i66;
            i32 = i65;
        } else {
            i31 = 0;
            i32 = 0;
        }
        int max4 = Math.max(RangesKt.f(i21 + m11, 0), i19);
        int max5 = Math.max(i20, Math.max(i12, i31 + i32));
        int[] iArr7 = new int[i52];
        for (int i68 = 0; i68 < i52; i68++) {
            iArr7[i68] = 0;
        }
        xVar.b(max4, iArr2, iArr7, xVar2);
        return xVar.d(g0VarArr, xVar2, i32, iArr7, max4, max5, iArr, i18, i16, i17);
    }
}
