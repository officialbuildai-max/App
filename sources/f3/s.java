package f3;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.util.j0;
import l2.q0;

/* loaded from: classes2.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f62413a = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    private static boolean a(int i11, boolean z10) {
        if ((i11 >>> 8) == 3368816) {
            return true;
        }
        if (i11 == 1751476579 && z10) {
            return true;
        }
        for (int i12 : f62413a) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public static q0 b(l2.s sVar) {
        return c(sVar, true, false);
    }

    private static q0 c(l2.s sVar, boolean z10, boolean z11) {
        int i11;
        int i12;
        int i13;
        boolean z12;
        int[] iArr;
        long length = sVar.getLength();
        long j11 = -1;
        long j12 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        if (length != -1 && length <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j12 = length;
        }
        int i14 = (int) j12;
        j0 j0Var = new j0(64);
        int i15 = 0;
        int i16 = 0;
        boolean z13 = false;
        while (i16 < i14) {
            j0Var.S(8);
            if (!sVar.peekFully(j0Var.e(), i15, 8, true)) {
                break;
            }
            long J = j0Var.J();
            int q11 = j0Var.q();
            if (J == 1) {
                sVar.peekFully(j0Var.e(), 8, 8);
                i12 = 16;
                j0Var.V(16);
                J = j0Var.A();
            } else {
                if (J == 0) {
                    long length2 = sVar.getLength();
                    if (length2 != j11) {
                        J = (length2 - sVar.getPeekPosition()) + 8;
                    }
                }
                i12 = 8;
            }
            long j13 = J;
            long j14 = i12;
            if (j13 < j14) {
                return new a(q11, j13, i12);
            }
            i16 += i12;
            if (q11 == 1836019574) {
                i14 += (int) j13;
                if (length != -1 && i14 > length) {
                    i14 = (int) length;
                }
            } else {
                if (q11 == 1836019558 || q11 == 1836475768) {
                    i11 = 1;
                    break;
                }
                long j15 = length;
                if (q11 == 1835295092) {
                    z13 = true;
                }
                if ((i16 + j13) - j14 >= i14) {
                    i11 = 0;
                    break;
                }
                int i17 = (int) (j13 - j14);
                i16 += i17;
                if (q11 != 1718909296) {
                    i13 = 0;
                    if (i17 != 0) {
                        sVar.advancePeekPosition(i17);
                    }
                } else {
                    if (i17 < 8) {
                        return new a(q11, i17, 8);
                    }
                    j0Var.S(i17);
                    i13 = 0;
                    sVar.peekFully(j0Var.e(), 0, i17);
                    int q12 = j0Var.q();
                    if (a(q12, z11)) {
                        z13 = true;
                    }
                    j0Var.X(4);
                    int a11 = j0Var.a() / 4;
                    if (!z13 && a11 > 0) {
                        iArr = new int[a11];
                        int i18 = 0;
                        while (true) {
                            if (i18 >= a11) {
                                z12 = z13;
                                break;
                            }
                            int q13 = j0Var.q();
                            iArr[i18] = q13;
                            if (a(q13, z11)) {
                                z12 = true;
                                break;
                            }
                            i18++;
                        }
                    } else {
                        z12 = z13;
                        iArr = null;
                    }
                    if (!z12) {
                        return new x(q12, iArr);
                    }
                    z13 = z12;
                }
                i15 = i13;
                length = j15;
            }
            j11 = -1;
        }
        i11 = i15;
        if (!z13) {
            return o.f62400a;
        }
        if (z10 != i11) {
            return i11 != 0 ? i.f62366b : i.f62367c;
        }
        return null;
    }

    public static q0 d(l2.s sVar, boolean z10) {
        return c(sVar, false, z10);
    }
}
