package tz;

import com.google.android.gms.auth.api.phone.SmsRetrieverStatusCodes;
import java.util.Arrays;

/* loaded from: classes7.dex */
abstract class f extends h {

    /* loaded from: classes7.dex */
    static class a extends f {

        /* renamed from: a, reason: collision with root package name */
        static int[] f76563a = {41280, 41281, 41282, 41283, 41287, 41289, 41333, 41334, 42048, 42054, 42055, 42056, 42065, 42068, 42071, 42084, 42090, 42092, 42103, 42147, 42148, 42151, 42177, 42190, 42193, 42207, 42216, 42237, 42304, 42312, 42328, 42345, 42445, 42471, 42583, 42593, 42594, 42600, 42608, 42664, 42675, 42681, 42707, 42715, 42726, 42738, 42816, 42833, 42841, 42970, 43171, 43173, 43181, 43217, 43219, 43236, 43260, 43456, 43474, 43507, 43627, 43706, 43710, 43724, 43772, 44103, 44111, 44208, 44242, 44377, 44745, 45024, 45290, 45423, 45747, 45764, 45935, 46156, 46158, 46412, 46501, 46525, 46544, 46552, 46705, 47085, 47207, 47428, 47832, 47940, 48033, 48593, 49860, 50105, 50240, 50271};

        @Override // tz.h
        public String a() {
            return "zh";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "Big5";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            int d11 = d(aVar, f76563a);
            if (d11 == 0) {
                return null;
            }
            return new tz.b(aVar, this, d11);
        }

        @Override // tz.f
        boolean e(e eVar, tz.a aVar) {
            eVar.f76570c = false;
            int a11 = eVar.a(aVar);
            eVar.f76568a = a11;
            if (a11 < 0) {
                return false;
            }
            if (a11 > 127 && a11 != 255) {
                int a12 = eVar.a(aVar);
                if (a12 < 0) {
                    return false;
                }
                eVar.f76568a = (eVar.f76568a << 8) | a12;
                if (a12 < 64 || a12 == 127 || a12 == 255) {
                    eVar.f76570c = true;
                }
            }
            return true;
        }
    }

    /* loaded from: classes7.dex */
    static abstract class b extends f {

        /* loaded from: classes7.dex */
        static class a extends b {

            /* renamed from: a, reason: collision with root package name */
            static int[] f76564a = {41377, 41378, 41379, 41382, 41404, 41418, 41419, 41430, 41431, 42146, 42148, 42150, 42152, 42154, 42155, 42156, 42157, 42159, 42161, 42163, 42165, 42167, 42169, 42171, 42173, 42175, 42176, 42177, 42179, 42180, 42182, 42183, 42184, 42185, 42186, 42187, 42190, 42191, 42192, 42206, 42207, 42209, 42210, 42212, 42216, 42217, 42218, 42219, 42220, 42223, 42226, 42227, 42402, 42403, 42404, 42406, 42407, 42410, 42413, 42415, 42416, 42419, 42421, 42423, 42424, 42425, 42431, 42435, 42438, 42439, 42440, 42441, 42443, 42448, 42453, 42454, 42455, 42462, 42464, 42465, 42469, 42473, 42474, 42475, 42476, 42477, 42483, 47273, 47572, 47854, 48072, 48880, 49079, 50410, 50940, 51133, 51896, 51955, 52188, 52689};

            @Override // tz.h
            public String a() {
                return "ja";
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // tz.h
            public String b() {
                return "EUC-JP";
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // tz.h
            public tz.b c(tz.a aVar) {
                int d11 = d(aVar, f76564a);
                if (d11 == 0) {
                    return null;
                }
                return new tz.b(aVar, this, d11);
            }
        }

        /* renamed from: tz.f$b$b, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        static class C0959b extends b {

            /* renamed from: a, reason: collision with root package name */
            static int[] f76565a = {45217, 45235, 45253, 45261, 45268, 45286, 45293, 45304, 45306, 45308, 45496, 45497, 45511, 45527, 45538, 45994, 46011, 46274, 46287, 46297, 46315, 46501, 46517, 46527, 46535, 46569, 46835, 47023, 47042, 47054, 47270, 47278, 47286, 47288, 47291, 47337, 47531, 47534, 47564, 47566, 47613, 47800, 47822, 47824, 47857, 48103, 48115, 48125, 48301, 48314, 48338, 48374, 48570, 48576, 48579, 48581, 48838, 48840, 48863, 48878, 48888, 48890, 49057, 49065, 49088, 49124, 49131, 49132, 49144, 49319, 49327, 49336, 49338, 49339, 49341, 49351, 49356, 49358, 49359, 49366, 49370, 49381, 49403, 49404, 49572, 49574, 49590, 49622, 49631, 49654, 49656, 50337, 50637, 50862, 51151, 51153, 51154, 51160, 51173, 51373};

            @Override // tz.h
            public String a() {
                return "ko";
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // tz.h
            public String b() {
                return "EUC-KR";
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // tz.h
            public tz.b c(tz.a aVar) {
                int d11 = d(aVar, f76565a);
                if (d11 == 0) {
                    return null;
                }
                return new tz.b(aVar, this, d11);
            }
        }

        b() {
        }

        @Override // tz.f
        boolean e(e eVar, tz.a aVar) {
            eVar.f76570c = false;
            int a11 = eVar.a(aVar);
            eVar.f76568a = a11;
            if (a11 < 0) {
                eVar.f76571d = true;
            } else if (a11 > 141) {
                int a12 = eVar.a(aVar);
                eVar.f76568a = (eVar.f76568a << 8) | a12;
                if (a11 < 161 || a11 > 254) {
                    if (a11 == 142) {
                        if (a12 < 161) {
                            eVar.f76570c = true;
                        }
                    } else if (a11 == 143) {
                        int a13 = eVar.a(aVar);
                        eVar.f76568a = (eVar.f76568a << 8) | a13;
                        if (a13 < 161) {
                            eVar.f76570c = true;
                        }
                    }
                } else if (a12 < 161) {
                    eVar.f76570c = true;
                }
            }
            return !eVar.f76571d;
        }
    }

    /* loaded from: classes7.dex */
    static class c extends f {

        /* renamed from: a, reason: collision with root package name */
        static int[] f76566a = {41377, 41378, 41379, 41380, 41392, 41393, 41457, 41459, 41889, 41900, 41914, 45480, 45496, 45502, 45755, 46025, 46070, 46323, 46525, 46532, 46563, 46767, 46804, 46816, 47010, 47016, 47037, 47062, 47069, 47284, 47327, 47350, 47531, 47561, 47576, 47610, 47613, 47821, 48039, 48086, 48097, 48122, 48316, 48347, 48382, 48588, 48845, 48861, 49076, 49094, 49097, 49332, 49389, 49611, 49883, 50119, 50396, 50410, 50636, 50935, 51192, 51371, 51403, 51413, 51431, 51663, 51706, 51889, 51893, 51911, 51920, 51926, 51957, 51965, 52460, 52728, 52906, 52932, 52946, 52965, 53173, 53186, 53206, 53442, 53445, 53456, 53460, 53671, 53930, 53938, 53941, 53947, 53972, 54211, 54224, 54269, 54466, 54490, 54754, 54992};

        @Override // tz.h
        public String a() {
            return "zh";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "GB18030";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            int d11 = d(aVar, f76566a);
            if (d11 == 0) {
                return null;
            }
            return new tz.b(aVar, this, d11);
        }

        @Override // tz.f
        boolean e(e eVar, tz.a aVar) {
            int a11;
            int a12;
            eVar.f76570c = false;
            int a13 = eVar.a(aVar);
            eVar.f76568a = a13;
            if (a13 < 0) {
                eVar.f76571d = true;
            } else if (a13 > 128) {
                int a14 = eVar.a(aVar);
                eVar.f76568a = (eVar.f76568a << 8) | a14;
                if (a13 >= 129 && a13 <= 254 && ((a14 < 64 || a14 > 126) && (a14 < 80 || a14 > 254))) {
                    if (a14 < 48 || a14 > 57 || (a11 = eVar.a(aVar)) < 129 || a11 > 254 || (a12 = eVar.a(aVar)) < 48 || a12 > 57) {
                        eVar.f76570c = true;
                    } else {
                        eVar.f76568a = a12 | (eVar.f76568a << 16) | (a11 << 8);
                    }
                }
            }
            return !eVar.f76571d;
        }
    }

    /* loaded from: classes7.dex */
    static class d extends f {

        /* renamed from: a, reason: collision with root package name */
        static int[] f76567a = {33088, 33089, 33090, 33093, 33115, 33129, 33130, 33141, 33142, 33440, 33442, 33444, 33449, 33450, 33451, 33453, 33455, 33457, 33459, 33461, 33463, 33469, 33470, 33473, 33476, 33477, 33478, 33480, 33481, 33484, 33485, 33500, 33504, 33511, 33512, 33513, 33514, 33520, 33521, 33601, 33603, 33614, 33615, 33624, 33630, 33634, 33639, 33653, 33654, 33673, 33674, 33675, 33677, 33683, SmsRetrieverStatusCodes.USER_PERMISSION_REQUIRED, 37882, 38314};

        @Override // tz.h
        public String a() {
            return "ja";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public String b() {
            return "Shift_JIS";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // tz.h
        public tz.b c(tz.a aVar) {
            int d11 = d(aVar, f76567a);
            if (d11 == 0) {
                return null;
            }
            return new tz.b(aVar, this, d11);
        }

        @Override // tz.f
        boolean e(e eVar, tz.a aVar) {
            eVar.f76570c = false;
            int a11 = eVar.a(aVar);
            eVar.f76568a = a11;
            if (a11 < 0) {
                return false;
            }
            if (a11 > 127 && (a11 <= 160 || a11 > 223)) {
                int a12 = eVar.a(aVar);
                if (a12 < 0) {
                    return false;
                }
                eVar.f76568a = (a11 << 8) | a12;
                if ((a12 < 64 || a12 > 127) && (a12 < 128 || a12 > 255)) {
                    eVar.f76570c = true;
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        int f76568a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f76569b = 0;

        /* renamed from: c, reason: collision with root package name */
        boolean f76570c = false;

        /* renamed from: d, reason: collision with root package name */
        boolean f76571d = false;

        e() {
        }

        int a(tz.a aVar) {
            int i11 = this.f76569b;
            if (i11 >= aVar.f76548f) {
                this.f76571d = true;
                return -1;
            }
            byte[] bArr = aVar.f76547e;
            this.f76569b = i11 + 1;
            return bArr[i11] & 255;
        }

        void b() {
            this.f76568a = 0;
            this.f76569b = 0;
            this.f76570c = false;
            this.f76571d = false;
        }
    }

    f() {
    }

    int d(tz.a aVar, int[] iArr) {
        e eVar = new e();
        eVar.b();
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (e(eVar, aVar)) {
            i12++;
            if (eVar.f76570c) {
                i13++;
            } else {
                long j11 = eVar.f76568a & 4294967295L;
                if (j11 > 255) {
                    i11++;
                    if (iArr != null && Arrays.binarySearch(iArr, (int) j11) >= 0) {
                        i14++;
                    }
                }
            }
            if (i13 >= 2 && i13 * 5 >= i11) {
                return 0;
            }
        }
        int i15 = 10;
        if (i11 > 10 || i13 != 0) {
            int i16 = i13 * 20;
            if (i11 < i16) {
                return 0;
            }
            if (iArr != null) {
                return Math.min((int) ((Math.log(i14 + 1) * (90.0d / Math.log(i11 / 4.0f))) + 10.0d), 100);
            }
            i15 = (i11 + 30) - i16;
            if (i15 > 100) {
                return 100;
            }
        } else if (i11 == 0 && i12 < 10) {
            return 0;
        }
        return i15;
    }

    abstract boolean e(e eVar, tz.a aVar);
}
