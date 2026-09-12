package z0;

import android.graphics.Path;
import android.util.Log;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.cloud.tmc.offline.download.model.TaskResultKt;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public abstract class e {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f79253a;

        /* renamed from: b, reason: collision with root package name */
        boolean f79254b;

        a() {
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private char f79255a;

        /* renamed from: b, reason: collision with root package name */
        private final float[] f79256b;

        b(char c11, float[] fArr) {
            this.f79255a = c11;
            this.f79256b = fArr;
        }

        b(b bVar) {
            this.f79255a = bVar.f79255a;
            float[] fArr = bVar.f79256b;
            this.f79256b = e.c(fArr, 0, fArr.length);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        public static void e(Path path, float[] fArr, char c11, char c12, float[] fArr2) {
            int i11;
            int i12;
            int i13;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            float f16;
            float f17;
            float f18;
            char c13 = c12;
            boolean z10 = false;
            float f19 = fArr[0];
            float f20 = fArr[1];
            float f21 = fArr[2];
            float f22 = fArr[3];
            float f23 = fArr[4];
            float f24 = fArr[5];
            switch (c13) {
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                case 'a':
                    i11 = 7;
                    i12 = i11;
                    break;
                case 'C':
                case 'c':
                    i11 = 6;
                    i12 = i11;
                    break;
                case 'H':
                case 'V':
                case 'h':
                case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                    i12 = 1;
                    break;
                case 'L':
                case 'M':
                case 'T':
                case TaskResultKt.ERROR_LOAD_RESPONSE_STR_EMPTY /* 108 */:
                case 'm':
                case GZIP_ENCODE_ERROR_VALUE:
                default:
                    i12 = 2;
                    break;
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_TOP_SHOW /* 81 */:
                case TmcConstants.NOTIFY_ADDHOME_GUIDE_BACK_SHOW /* 83 */:
                case 'q':
                case INVALID_INDEX_URL_VALUE:
                    i12 = 4;
                    break;
                case TmcConstants.NOTIFY_ADDHOME_API_SHOW /* 90 */:
                case INVALID_ADS_ENDPOINT_VALUE:
                    path.close();
                    path.moveTo(f23, f24);
                    f19 = f23;
                    f21 = f19;
                    f20 = f24;
                    f22 = f20;
                    i12 = 2;
                    break;
            }
            float f25 = f19;
            float f26 = f20;
            float f27 = f23;
            float f28 = f24;
            int i14 = 0;
            char c14 = c11;
            while (i14 < fArr2.length) {
                if (c13 != 'A') {
                    if (c13 == 'C') {
                        i13 = i14;
                        int i15 = i13 + 2;
                        int i16 = i13 + 3;
                        int i17 = i13 + 4;
                        int i18 = i13 + 5;
                        path.cubicTo(fArr2[i13], fArr2[i13 + 1], fArr2[i15], fArr2[i16], fArr2[i17], fArr2[i18]);
                        f25 = fArr2[i17];
                        float f29 = fArr2[i18];
                        float f30 = fArr2[i15];
                        float f31 = fArr2[i16];
                        f26 = f29;
                        f22 = f31;
                        f21 = f30;
                    } else if (c13 == 'H') {
                        i13 = i14;
                        path.lineTo(fArr2[i13], f26);
                        f25 = fArr2[i13];
                    } else if (c13 == 'Q') {
                        i13 = i14;
                        int i19 = i13 + 1;
                        int i20 = i13 + 2;
                        int i21 = i13 + 3;
                        path.quadTo(fArr2[i13], fArr2[i19], fArr2[i20], fArr2[i21]);
                        float f32 = fArr2[i13];
                        float f33 = fArr2[i19];
                        f25 = fArr2[i20];
                        f26 = fArr2[i21];
                        f21 = f32;
                        f22 = f33;
                    } else if (c13 == 'V') {
                        i13 = i14;
                        path.lineTo(f25, fArr2[i13]);
                        f26 = fArr2[i13];
                    } else if (c13 != 'a') {
                        if (c13 != 'c') {
                            if (c13 == 'h') {
                                path.rLineTo(fArr2[i14], 0.0f);
                                f25 += fArr2[i14];
                            } else if (c13 != 'q') {
                                if (c13 == 'v') {
                                    path.rLineTo(0.0f, fArr2[i14]);
                                    f14 = fArr2[i14];
                                } else if (c13 == 'L') {
                                    int i22 = i14 + 1;
                                    path.lineTo(fArr2[i14], fArr2[i22]);
                                    f25 = fArr2[i14];
                                    f26 = fArr2[i22];
                                } else if (c13 == 'M') {
                                    f25 = fArr2[i14];
                                    f26 = fArr2[i14 + 1];
                                    if (i14 > 0) {
                                        path.lineTo(f25, f26);
                                    } else {
                                        path.moveTo(f25, f26);
                                        i13 = i14;
                                        f28 = f26;
                                        f27 = f25;
                                    }
                                } else if (c13 == 'S') {
                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                        f25 = (f25 * 2.0f) - f21;
                                        f26 = (f26 * 2.0f) - f22;
                                    }
                                    float f34 = f26;
                                    float f35 = f25;
                                    int i23 = i14 + 1;
                                    int i24 = i14 + 2;
                                    int i25 = i14 + 3;
                                    path.cubicTo(f35, f34, fArr2[i14], fArr2[i23], fArr2[i24], fArr2[i25]);
                                    f11 = fArr2[i14];
                                    f12 = fArr2[i23];
                                    f25 = fArr2[i24];
                                    f26 = fArr2[i25];
                                    f21 = f11;
                                    f22 = f12;
                                } else if (c13 == 'T') {
                                    if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                        f25 = (f25 * 2.0f) - f21;
                                        f26 = (f26 * 2.0f) - f22;
                                    }
                                    int i26 = i14 + 1;
                                    path.quadTo(f25, f26, fArr2[i14], fArr2[i26]);
                                    i13 = i14;
                                    f22 = f26;
                                    f21 = f25;
                                    f25 = fArr2[i14];
                                    f26 = fArr2[i26];
                                } else if (c13 == 'l') {
                                    int i27 = i14 + 1;
                                    path.rLineTo(fArr2[i14], fArr2[i27]);
                                    f25 += fArr2[i14];
                                    f14 = fArr2[i27];
                                } else if (c13 == 'm') {
                                    float f36 = fArr2[i14];
                                    f25 += f36;
                                    float f37 = fArr2[i14 + 1];
                                    f26 += f37;
                                    if (i14 > 0) {
                                        path.rLineTo(f36, f37);
                                    } else {
                                        path.rMoveTo(f36, f37);
                                        i13 = i14;
                                        f28 = f26;
                                        f27 = f25;
                                    }
                                } else if (c13 == 's') {
                                    if (c14 == 'c' || c14 == 's' || c14 == 'C' || c14 == 'S') {
                                        float f38 = f25 - f21;
                                        f15 = f26 - f22;
                                        f16 = f38;
                                    } else {
                                        f16 = 0.0f;
                                        f15 = 0.0f;
                                    }
                                    int i28 = i14 + 1;
                                    int i29 = i14 + 2;
                                    int i30 = i14 + 3;
                                    path.rCubicTo(f16, f15, fArr2[i14], fArr2[i28], fArr2[i29], fArr2[i30]);
                                    f11 = fArr2[i14] + f25;
                                    f12 = fArr2[i28] + f26;
                                    f25 += fArr2[i29];
                                    f13 = fArr2[i30];
                                } else if (c13 == 't') {
                                    if (c14 == 'q' || c14 == 't' || c14 == 'Q' || c14 == 'T') {
                                        f17 = f25 - f21;
                                        f18 = f26 - f22;
                                    } else {
                                        f18 = 0.0f;
                                        f17 = 0.0f;
                                    }
                                    int i31 = i14 + 1;
                                    path.rQuadTo(f17, f18, fArr2[i14], fArr2[i31]);
                                    float f39 = f17 + f25;
                                    float f40 = f18 + f26;
                                    f25 += fArr2[i14];
                                    f26 += fArr2[i31];
                                    f22 = f40;
                                    f21 = f39;
                                }
                                f26 += f14;
                            } else {
                                int i32 = i14 + 1;
                                int i33 = i14 + 2;
                                int i34 = i14 + 3;
                                path.rQuadTo(fArr2[i14], fArr2[i32], fArr2[i33], fArr2[i34]);
                                f11 = fArr2[i14] + f25;
                                f12 = fArr2[i32] + f26;
                                f25 += fArr2[i33];
                                f13 = fArr2[i34];
                            }
                            i13 = i14;
                        } else {
                            int i35 = i14 + 2;
                            int i36 = i14 + 3;
                            int i37 = i14 + 4;
                            int i38 = i14 + 5;
                            path.rCubicTo(fArr2[i14], fArr2[i14 + 1], fArr2[i35], fArr2[i36], fArr2[i37], fArr2[i38]);
                            f11 = fArr2[i35] + f25;
                            f12 = fArr2[i36] + f26;
                            f25 += fArr2[i37];
                            f13 = fArr2[i38];
                        }
                        f26 += f13;
                        f21 = f11;
                        f22 = f12;
                        i13 = i14;
                    } else {
                        int i39 = i14 + 5;
                        int i40 = i14 + 6;
                        i13 = i14;
                        g(path, f25, f26, fArr2[i39] + f25, fArr2[i40] + f26, fArr2[i14], fArr2[i14 + 1], fArr2[i14 + 2], fArr2[i14 + 3] != 0.0f, fArr2[i14 + 4] != 0.0f);
                        f25 += fArr2[i39];
                        f26 += fArr2[i40];
                    }
                    i14 = i13 + i12;
                    c14 = c12;
                    c13 = c14;
                    z10 = false;
                } else {
                    i13 = i14;
                    int i41 = i13 + 5;
                    int i42 = i13 + 6;
                    g(path, f25, f26, fArr2[i41], fArr2[i42], fArr2[i13], fArr2[i13 + 1], fArr2[i13 + 2], fArr2[i13 + 3] != 0.0f, fArr2[i13 + 4] != 0.0f);
                    f25 = fArr2[i41];
                    f26 = fArr2[i42];
                }
                f22 = f26;
                f21 = f25;
                i14 = i13 + i12;
                c14 = c12;
                c13 = c14;
                z10 = false;
            }
            fArr[z10 ? 1 : 0] = f25;
            fArr[1] = f26;
            fArr[2] = f21;
            fArr[3] = f22;
            fArr[4] = f27;
            fArr[5] = f28;
        }

        private static void f(Path path, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
            double d20 = d13;
            int ceil = (int) Math.ceil(Math.abs((d19 * 4.0d) / 3.141592653589793d));
            double cos = Math.cos(d17);
            double sin = Math.sin(d17);
            double cos2 = Math.cos(d18);
            double sin2 = Math.sin(d18);
            double d21 = -d20;
            double d22 = d21 * cos;
            double d23 = d14 * sin;
            double d24 = (d22 * sin2) - (d23 * cos2);
            double d25 = d21 * sin;
            double d26 = d14 * cos;
            double d27 = (sin2 * d25) + (cos2 * d26);
            double d28 = d19 / ceil;
            double d29 = d27;
            double d30 = d24;
            int i11 = 0;
            double d31 = d15;
            double d32 = d16;
            double d33 = d18;
            while (i11 < ceil) {
                double d34 = d33 + d28;
                double sin3 = Math.sin(d34);
                double cos3 = Math.cos(d34);
                double d35 = (d11 + ((d20 * cos) * cos3)) - (d23 * sin3);
                double d36 = d12 + (d20 * sin * cos3) + (d26 * sin3);
                double d37 = (d22 * sin3) - (d23 * cos3);
                double d38 = (sin3 * d25) + (cos3 * d26);
                double d39 = d34 - d33;
                double tan = Math.tan(d39 / 2.0d);
                double sin4 = (Math.sin(d39) * (Math.sqrt(((tan * 3.0d) * tan) + 4.0d) - 1.0d)) / 3.0d;
                double d40 = d31 + (d30 * sin4);
                path.rLineTo(0.0f, 0.0f);
                path.cubicTo((float) d40, (float) (d32 + (d29 * sin4)), (float) (d35 - (sin4 * d37)), (float) (d36 - (sin4 * d38)), (float) d35, (float) d36);
                i11++;
                d28 = d28;
                sin = sin;
                d31 = d35;
                d25 = d25;
                cos = cos;
                d33 = d34;
                d29 = d38;
                d30 = d37;
                ceil = ceil;
                d32 = d36;
                d20 = d13;
            }
        }

        private static void g(Path path, float f11, float f12, float f13, float f14, float f15, float f16, float f17, boolean z10, boolean z11) {
            double d11;
            double d12;
            double radians = Math.toRadians(f17);
            double cos = Math.cos(radians);
            double sin = Math.sin(radians);
            double d13 = f11;
            double d14 = d13 * cos;
            double d15 = f12;
            double d16 = f15;
            double d17 = (d14 + (d15 * sin)) / d16;
            double d18 = ((-f11) * sin) + (d15 * cos);
            double d19 = f16;
            double d20 = d18 / d19;
            double d21 = f14;
            double d22 = ((f13 * cos) + (d21 * sin)) / d16;
            double d23 = (((-f13) * sin) + (d21 * cos)) / d19;
            double d24 = d17 - d22;
            double d25 = d20 - d23;
            double d26 = (d17 + d22) / 2.0d;
            double d27 = (d20 + d23) / 2.0d;
            double d28 = (d24 * d24) + (d25 * d25);
            if (d28 == 0.0d) {
                Log.w("PathParser", " Points are coincident");
                return;
            }
            double d29 = (1.0d / d28) - 0.25d;
            if (d29 < 0.0d) {
                Log.w("PathParser", "Points are too far apart " + d28);
                float sqrt = (float) (Math.sqrt(d28) / 1.99999d);
                g(path, f11, f12, f13, f14, f15 * sqrt, f16 * sqrt, f17, z10, z11);
                return;
            }
            double sqrt2 = Math.sqrt(d29);
            double d30 = d24 * sqrt2;
            double d31 = sqrt2 * d25;
            if (z10 == z11) {
                d11 = d26 - d31;
                d12 = d27 + d30;
            } else {
                d11 = d26 + d31;
                d12 = d27 - d30;
            }
            double atan2 = Math.atan2(d20 - d12, d17 - d11);
            double atan22 = Math.atan2(d23 - d12, d22 - d11) - atan2;
            if (z11 != (atan22 >= 0.0d)) {
                atan22 = atan22 > 0.0d ? atan22 - 6.283185307179586d : atan22 + 6.283185307179586d;
            }
            double d32 = d11 * d16;
            double d33 = d12 * d19;
            f(path, (d32 * cos) - (d33 * sin), (d32 * sin) + (d33 * cos), d16, d19, d13, d15, radians, atan2, atan22);
        }

        public static void i(b[] bVarArr, Path path) {
            e.j(bVarArr, path);
        }

        public void h(b bVar, b bVar2, float f11) {
            this.f79255a = bVar.f79255a;
            int i11 = 0;
            while (true) {
                float[] fArr = bVar.f79256b;
                if (i11 >= fArr.length) {
                    return;
                }
                this.f79256b[i11] = (fArr[i11] * (1.0f - f11)) + (bVar2.f79256b[i11] * f11);
                i11++;
            }
        }
    }

    private static void a(ArrayList arrayList, char c11, float[] fArr) {
        arrayList.add(new b(c11, fArr));
    }

    public static boolean b(b[] bVarArr, b[] bVarArr2) {
        if (bVarArr == null || bVarArr2 == null || bVarArr.length != bVarArr2.length) {
            return false;
        }
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            if (bVarArr[i11].f79255a != bVarArr2[i11].f79255a || bVarArr[i11].f79256b.length != bVarArr2[i11].f79256b.length) {
                return false;
            }
        }
        return true;
    }

    static float[] c(float[] fArr, int i11, int i12) {
        if (i11 > i12) {
            throw new IllegalArgumentException();
        }
        int length = fArr.length;
        if (i11 < 0 || i11 > length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int i13 = i12 - i11;
        int min = Math.min(i13, length - i11);
        float[] fArr2 = new float[i13];
        System.arraycopy(fArr, i11, fArr2, 0, min);
        return fArr2;
    }

    public static b[] d(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        int i12 = 1;
        while (i12 < str.length()) {
            int i13 = i(str, i12);
            String trim = str.substring(i11, i13).trim();
            if (!trim.isEmpty()) {
                a(arrayList, trim.charAt(0), h(trim));
            }
            i11 = i13;
            i12 = i13 + 1;
        }
        if (i12 - i11 == 1 && i11 < str.length()) {
            a(arrayList, str.charAt(i11), new float[0]);
        }
        return (b[]) arrayList.toArray(new b[0]);
    }

    public static Path e(String str) {
        Path path = new Path();
        try {
            b.i(d(str), path);
            return path;
        } catch (RuntimeException e11) {
            throw new RuntimeException("Error in parsing " + str, e11);
        }
    }

    public static b[] f(b[] bVarArr) {
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i11 = 0; i11 < bVarArr.length; i11++) {
            bVarArr2[i11] = new b(bVarArr[i11]);
        }
        return bVarArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:10:0x001e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039 A[LOOP:0: B:2:0x0007->B:14:0x0039, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void g(java.lang.String r8, int r9, z0.e.a r10) {
        /*
            r0 = 0
            r10.f79254b = r0
            r1 = r9
            r2 = r0
            r3 = r2
            r4 = r3
        L7:
            int r5 = r8.length()
            if (r1 >= r5) goto L3c
            char r5 = r8.charAt(r1)
            r6 = 32
            r7 = 1
            if (r5 == r6) goto L29
            r6 = 69
            if (r5 == r6) goto L35
            r6 = 101(0x65, float:1.42E-43)
            if (r5 == r6) goto L35
            switch(r5) {
                case 44: goto L29;
                case 45: goto L2c;
                case 46: goto L22;
                default: goto L21;
            }
        L21:
            goto L33
        L22:
            if (r3 != 0) goto L27
            r2 = r0
            r3 = r7
            goto L36
        L27:
            r10.f79254b = r7
        L29:
            r2 = r0
            r4 = r7
            goto L36
        L2c:
            if (r1 == r9) goto L33
            if (r2 != 0) goto L33
            r10.f79254b = r7
            goto L29
        L33:
            r2 = r0
            goto L36
        L35:
            r2 = r7
        L36:
            if (r4 == 0) goto L39
            goto L3c
        L39:
            int r1 = r1 + 1
            goto L7
        L3c:
            r10.f79253a = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.e.g(java.lang.String, int, z0.e$a):void");
    }

    private static float[] h(String str) {
        if (str.charAt(0) == 'z' || str.charAt(0) == 'Z') {
            return new float[0];
        }
        try {
            float[] fArr = new float[str.length()];
            a aVar = new a();
            int length = str.length();
            int i11 = 1;
            int i12 = 0;
            while (i11 < length) {
                g(str, i11, aVar);
                int i13 = aVar.f79253a;
                if (i11 < i13) {
                    fArr[i12] = Float.parseFloat(str.substring(i11, i13));
                    i12++;
                }
                i11 = aVar.f79254b ? i13 : i13 + 1;
            }
            return c(fArr, 0, i12);
        } catch (NumberFormatException e11) {
            throw new RuntimeException("error in parsing \"" + str + "\"", e11);
        }
    }

    private static int i(String str, int i11) {
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            if (((charAt - 'A') * (charAt - 'Z') <= 0 || (charAt - 'a') * (charAt - 'z') <= 0) && charAt != 'e' && charAt != 'E') {
                return i11;
            }
            i11++;
        }
        return i11;
    }

    public static void j(b[] bVarArr, Path path) {
        float[] fArr = new float[6];
        char c11 = 'm';
        for (b bVar : bVarArr) {
            b.e(path, fArr, c11, bVar.f79255a, bVar.f79256b);
            c11 = bVar.f79255a;
        }
    }

    public static void k(b[] bVarArr, b[] bVarArr2) {
        for (int i11 = 0; i11 < bVarArr2.length; i11++) {
            bVarArr[i11].f79255a = bVarArr2[i11].f79255a;
            for (int i12 = 0; i12 < bVarArr2[i11].f79256b.length; i12++) {
                bVarArr[i11].f79256b[i12] = bVarArr2[i11].f79256b[i12];
            }
        }
    }
}
