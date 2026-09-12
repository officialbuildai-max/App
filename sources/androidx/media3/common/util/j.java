package androidx.media3.common.util;

import android.util.Pair;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mvel2.ast.ASTNode;

/* loaded from: classes2.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f10474a = {0, 0, 0, 1};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f10475b = {"", "A", "B", "C"};

    /* renamed from: c, reason: collision with root package name */
    private static final Pattern f10476c = Pattern.compile("^\\D?(\\d+)$");

    private static int a(int i11) {
        switch (i11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return 256;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return 4096;
            case 13:
                return 8192;
            case 14:
                return 16384;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    private static int b(int i11) {
        switch (i11) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i11) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i11) {
                            case 30:
                                return 256;
                            case TEMPLATE_HTML_SIZE_VALUE:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i11) {
                                    case 40:
                                        return 2048;
                                    case 41:
                                        return 4096;
                                    case 42:
                                        return 8192;
                                    default:
                                        switch (i11) {
                                            case 50:
                                                return 16384;
                                            case AD_REWARD_USER_VALUE:
                                                return 32768;
                                            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    private static int c(int i11) {
        if (i11 == 66) {
            return 1;
        }
        if (i11 == 77) {
            return 2;
        }
        if (i11 == 88) {
            return 4;
        }
        if (i11 == 100) {
            return 8;
        }
        if (i11 == 110) {
            return 16;
        }
        if (i11 != 122) {
            return i11 != 244 ? -1 : 64;
        }
        return 32;
    }

    public static String d(int i11, int i12, int i13) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13));
    }

    public static List e(boolean z10) {
        return Collections.singletonList(z10 ? new byte[]{1} : new byte[]{0});
    }

    public static String f(int i11, boolean z10, int i12, int i13, int[] iArr, int i14) {
        StringBuilder sb2 = new StringBuilder(a1.G("hvc1.%s%d.%X.%c%d", f10475b[i11], Integer.valueOf(i12), Integer.valueOf(i13), Character.valueOf(z10 ? 'H' : 'L'), Integer.valueOf(i14)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i15 = 0; i15 < length; i15++) {
            sb2.append(String.format(".%02X", Integer.valueOf(iArr[i15])));
        }
        return sb2.toString();
    }

    public static byte[] g(byte[] bArr, int i11, int i12) {
        byte[] bArr2 = f10474a;
        byte[] bArr3 = new byte[bArr2.length + i12];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i11, bArr3, bArr2.length, i12);
        return bArr3;
    }

    public static ImmutableList h(byte b11, byte b12, byte b13, byte b14) {
        return ImmutableList.of(new byte[]{1, 1, b11, 2, 1, b12, 3, 1, b13, 4, 1, b14});
    }

    private static Integer i(String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 1537:
                if (str.equals("01")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1568:
                if (str.equals(PrepareException.ERROR_DOWNLOAD_PACKAGE_URL_EMPTY)) {
                    c11 = '\n';
                    break;
                }
                break;
            case 1569:
                if (str.equals("12")) {
                    c11 = 11;
                    break;
                }
                break;
            case 1570:
                if (str.equals(PrepareException.ERROR_WARMUP_DOWNLOAD_EXCEPTION)) {
                    c11 = '\f';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case '\b':
                return 256;
            case '\t':
                return 512;
            case '\n':
                return 1024;
            case 11:
                return 2048;
            case '\f':
                return 4096;
            default:
                return null;
        }
    }

    private static Integer j(String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 1536:
                if (str.equals("00")) {
                    c11 = 0;
                    break;
                }
                break;
            case 1537:
                if (str.equals("01")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1538:
                if (str.equals("02")) {
                    c11 = 2;
                    break;
                }
                break;
            case 1539:
                if (str.equals("03")) {
                    c11 = 3;
                    break;
                }
                break;
            case 1540:
                if (str.equals("04")) {
                    c11 = 4;
                    break;
                }
                break;
            case 1541:
                if (str.equals("05")) {
                    c11 = 5;
                    break;
                }
                break;
            case 1542:
                if (str.equals("06")) {
                    c11 = 6;
                    break;
                }
                break;
            case 1543:
                if (str.equals("07")) {
                    c11 = 7;
                    break;
                }
                break;
            case 1544:
                if (str.equals("08")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 1545:
                if (str.equals("09")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 1567:
                if (str.equals("10")) {
                    c11 = '\n';
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case '\b':
                return 256;
            case '\t':
                return 512;
            case '\n':
                return 1024;
            default:
                return null;
        }
    }

    private static Pair k(String str, String[] strArr) {
        int t11;
        if (strArr.length != 3) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if (MimeTypes.AUDIO_AAC.equals(androidx.media3.common.y.h(Integer.parseInt(strArr[1], 16))) && (t11 = t(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(t11), 0);
            }
        } catch (NumberFormatException unused) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    private static Pair l(String str, String[] strArr, androidx.media3.common.i iVar) {
        int i11;
        if (strArr.length < 4) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2].substring(0, 2));
            int parseInt3 = Integer.parseInt(strArr[3]);
            if (parseInt != 0) {
                u.h("CodecSpecificDataUtil", "Unknown AV1 profile: " + parseInt);
                return null;
            }
            if (parseInt3 != 8 && parseInt3 != 10) {
                u.h("CodecSpecificDataUtil", "Unknown AV1 bit depth: " + parseInt3);
                return null;
            }
            int i12 = parseInt3 != 8 ? (iVar == null || !(iVar.f10156d != null || (i11 = iVar.f10155c) == 7 || i11 == 6)) ? 2 : 4096 : 1;
            int a11 = a(parseInt2);
            if (a11 != -1) {
                return new Pair(Integer.valueOf(i12), Integer.valueOf(a11));
            }
            u.h("CodecSpecificDataUtil", "Unknown AV1 level: " + parseInt2);
            return null;
        } catch (NumberFormatException unused) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    private static Pair m(String str, String[] strArr) {
        int parseInt;
        int i11;
        if (strArr.length < 2) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i11 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                parseInt = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    u.h("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int parseInt2 = Integer.parseInt(strArr[1]);
                parseInt = Integer.parseInt(strArr[2]);
                i11 = parseInt2;
            }
            int c11 = c(i11);
            if (c11 == -1) {
                u.h("CodecSpecificDataUtil", "Unknown AVC profile: " + i11);
                return null;
            }
            int b11 = b(parseInt);
            if (b11 != -1) {
                return new Pair(Integer.valueOf(c11), Integer.valueOf(b11));
            }
            u.h("CodecSpecificDataUtil", "Unknown AVC level: " + parseInt);
            return null;
        } catch (NumberFormatException unused) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0080, code lost:
    
        if (r3.equals("av01") == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.util.Pair n(androidx.media3.common.r r6) {
        /*
            r0 = 0
            java.lang.String r1 = r6.f10239k
            r2 = 0
            if (r1 != 0) goto L7
            return r2
        L7:
            java.lang.String r3 = "\\."
            java.lang.String[] r1 = r1.split(r3)
            java.lang.String r3 = "video/dolby-vision"
            java.lang.String r4 = r6.f10243o
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L1e
            java.lang.String r6 = r6.f10239k
            android.util.Pair r6 = o(r6, r1)
            return r6
        L1e:
            r3 = r1[r0]
            r3.hashCode()
            r4 = -1
            int r5 = r3.hashCode()
            switch(r5) {
                case 3004662: goto L7a;
                case 3006243: goto L6f;
                case 3006244: goto L64;
                case 3199032: goto L59;
                case 3214780: goto L4e;
                case 3356560: goto L43;
                case 3475740: goto L38;
                case 3624515: goto L2d;
                default: goto L2b;
            }
        L2b:
            r0 = r4
            goto L83
        L2d:
            java.lang.String r0 = "vp09"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L36
            goto L2b
        L36:
            r0 = 7
            goto L83
        L38:
            java.lang.String r0 = "s263"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L41
            goto L2b
        L41:
            r0 = 6
            goto L83
        L43:
            java.lang.String r0 = "mp4a"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L4c
            goto L2b
        L4c:
            r0 = 5
            goto L83
        L4e:
            java.lang.String r0 = "hvc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L57
            goto L2b
        L57:
            r0 = 4
            goto L83
        L59:
            java.lang.String r0 = "hev1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L62
            goto L2b
        L62:
            r0 = 3
            goto L83
        L64:
            java.lang.String r0 = "avc2"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L6d
            goto L2b
        L6d:
            r0 = 2
            goto L83
        L6f:
            java.lang.String r0 = "avc1"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L78
            goto L2b
        L78:
            r0 = 1
            goto L83
        L7a:
            java.lang.String r5 = "av01"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L83
            goto L2b
        L83:
            switch(r0) {
                case 0: goto Lac;
                case 1: goto La5;
                case 2: goto La5;
                case 3: goto L9c;
                case 4: goto L9c;
                case 5: goto L95;
                case 6: goto L8e;
                case 7: goto L87;
                default: goto L86;
            }
        L86:
            return r2
        L87:
            java.lang.String r6 = r6.f10239k
            android.util.Pair r6 = r(r6, r1)
            return r6
        L8e:
            java.lang.String r6 = r6.f10239k
            android.util.Pair r6 = p(r6, r1)
            return r6
        L95:
            java.lang.String r6 = r6.f10239k
            android.util.Pair r6 = k(r6, r1)
            return r6
        L9c:
            java.lang.String r0 = r6.f10239k
            androidx.media3.common.i r6 = r6.C
            android.util.Pair r6 = q(r0, r1, r6)
            return r6
        La5:
            java.lang.String r6 = r6.f10239k
            android.util.Pair r6 = m(r6, r1)
            return r6
        Lac:
            java.lang.String r0 = r6.f10239k
            androidx.media3.common.i r6 = r6.C
            android.util.Pair r6 = l(r0, r1, r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.j.n(androidx.media3.common.r):android.util.Pair");
    }

    private static Pair o(String str, String[] strArr) {
        if (strArr.length < 3) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = f10476c.matcher(strArr[1]);
        if (!matcher.matches()) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        Integer j11 = j(group);
        if (j11 == null) {
            u.h("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: " + group);
            return null;
        }
        String str2 = strArr[2];
        Integer i11 = i(str2);
        if (i11 != null) {
            return new Pair(j11, i11);
        }
        u.h("CodecSpecificDataUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    private static Pair p(String str, String[] strArr) {
        Pair pair = new Pair(1, 1);
        if (strArr.length < 3) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
        try {
            return new Pair(Integer.valueOf(Integer.parseInt(strArr[1])), Integer.valueOf(Integer.parseInt(strArr[2])));
        } catch (NumberFormatException unused) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
    }

    public static Pair q(String str, String[] strArr, androidx.media3.common.i iVar) {
        if (strArr.length < 4) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i11 = 1;
        Matcher matcher = f10476c.matcher(strArr[1]);
        if (!matcher.matches()) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String group = matcher.group(1);
        if (!"1".equals(group)) {
            i11 = 6;
            if ("2".equals(group)) {
                i11 = (iVar == null || iVar.f10155c != 6) ? 2 : 4096;
            } else if (!PrepareException.ERROR_NO_URL.equals(group)) {
                u.h("CodecSpecificDataUtil", "Unknown HEVC profile string: " + group);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer s11 = s(str2);
        if (s11 != null) {
            return new Pair(Integer.valueOf(i11), s11);
        }
        u.h("CodecSpecificDataUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    private static Pair r(String str, String[] strArr) {
        if (strArr.length < 3) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int parseInt = Integer.parseInt(strArr[1]);
            int parseInt2 = Integer.parseInt(strArr[2]);
            int x10 = x(parseInt);
            if (x10 == -1) {
                u.h("CodecSpecificDataUtil", "Unknown VP9 profile: " + parseInt);
                return null;
            }
            int w11 = w(parseInt2);
            if (w11 != -1) {
                return new Pair(Integer.valueOf(x10), Integer.valueOf(w11));
            }
            u.h("CodecSpecificDataUtil", "Unknown VP9 level: " + parseInt2);
            return null;
        } catch (NumberFormatException unused) {
            u.h("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    private static Integer s(String str) {
        if (str == null) {
            return null;
        }
        char c11 = 65535;
        switch (str.hashCode()) {
            case 70821:
                if (str.equals("H30")) {
                    c11 = 0;
                    break;
                }
                break;
            case 70914:
                if (str.equals("H60")) {
                    c11 = 1;
                    break;
                }
                break;
            case 70917:
                if (str.equals("H63")) {
                    c11 = 2;
                    break;
                }
                break;
            case 71007:
                if (str.equals("H90")) {
                    c11 = 3;
                    break;
                }
                break;
            case 71010:
                if (str.equals("H93")) {
                    c11 = 4;
                    break;
                }
                break;
            case 74665:
                if (str.equals("L30")) {
                    c11 = 5;
                    break;
                }
                break;
            case 74758:
                if (str.equals("L60")) {
                    c11 = 6;
                    break;
                }
                break;
            case 74761:
                if (str.equals("L63")) {
                    c11 = 7;
                    break;
                }
                break;
            case 74851:
                if (str.equals("L90")) {
                    c11 = '\b';
                    break;
                }
                break;
            case 74854:
                if (str.equals("L93")) {
                    c11 = '\t';
                    break;
                }
                break;
            case 2193639:
                if (str.equals("H120")) {
                    c11 = '\n';
                    break;
                }
                break;
            case 2193642:
                if (str.equals("H123")) {
                    c11 = 11;
                    break;
                }
                break;
            case 2193732:
                if (str.equals("H150")) {
                    c11 = '\f';
                    break;
                }
                break;
            case 2193735:
                if (str.equals("H153")) {
                    c11 = '\r';
                    break;
                }
                break;
            case 2193738:
                if (str.equals("H156")) {
                    c11 = 14;
                    break;
                }
                break;
            case 2193825:
                if (str.equals("H180")) {
                    c11 = 15;
                    break;
                }
                break;
            case 2193828:
                if (str.equals("H183")) {
                    c11 = 16;
                    break;
                }
                break;
            case 2193831:
                if (str.equals("H186")) {
                    c11 = 17;
                    break;
                }
                break;
            case 2312803:
                if (str.equals("L120")) {
                    c11 = 18;
                    break;
                }
                break;
            case 2312806:
                if (str.equals("L123")) {
                    c11 = 19;
                    break;
                }
                break;
            case 2312896:
                if (str.equals("L150")) {
                    c11 = 20;
                    break;
                }
                break;
            case 2312899:
                if (str.equals("L153")) {
                    c11 = 21;
                    break;
                }
                break;
            case 2312902:
                if (str.equals("L156")) {
                    c11 = 22;
                    break;
                }
                break;
            case 2312989:
                if (str.equals("L180")) {
                    c11 = 23;
                    break;
                }
                break;
            case 2312992:
                if (str.equals("L183")) {
                    c11 = 24;
                    break;
                }
                break;
            case 2312995:
                if (str.equals("L186")) {
                    c11 = 25;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return 2;
            case 1:
                return 8;
            case 2:
                return 32;
            case 3:
                return 128;
            case 4:
                return 512;
            case 5:
                return 1;
            case 6:
                return 4;
            case 7:
                return 16;
            case '\b':
                return 64;
            case '\t':
                return 256;
            case '\n':
                return 2048;
            case 11:
                return 8192;
            case '\f':
                return 32768;
            case '\r':
                return 131072;
            case 14:
                return 524288;
            case 15:
                return 2097152;
            case 16:
                return 8388608;
            case 17:
                return Integer.valueOf(ASTNode.PCTX_STORED);
            case 18:
                return 1024;
            case 19:
                return 4096;
            case 20:
                return 16384;
            case 21:
                return 65536;
            case 22:
                return 262144;
            case 23:
                return 1048576;
            case 24:
                return 4194304;
            case 25:
                return 16777216;
            default:
                return null;
        }
    }

    private static int t(int i11) {
        int i12 = 17;
        if (i11 != 17) {
            i12 = 20;
            if (i11 != 20) {
                i12 = 23;
                if (i11 != 23) {
                    i12 = 29;
                    if (i11 != 29) {
                        i12 = 39;
                        if (i11 != 39) {
                            i12 = 42;
                            if (i11 != 42) {
                                switch (i11) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i12;
    }

    public static Pair u(byte[] bArr) {
        j0 j0Var = new j0(bArr);
        j0Var.W(9);
        int H = j0Var.H();
        j0Var.W(20);
        return Pair.create(Integer.valueOf(j0Var.L()), Integer.valueOf(H));
    }

    public static boolean v(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    private static int w(int i11) {
        if (i11 == 10) {
            return 1;
        }
        if (i11 == 11) {
            return 2;
        }
        if (i11 == 20) {
            return 4;
        }
        if (i11 == 21) {
            return 8;
        }
        if (i11 == 30) {
            return 16;
        }
        if (i11 == 31) {
            return 32;
        }
        if (i11 == 40) {
            return 64;
        }
        if (i11 == 41) {
            return 128;
        }
        if (i11 == 50) {
            return 256;
        }
        if (i11 == 51) {
            return 512;
        }
        switch (i11) {
            case 60:
                return 2048;
            case 61:
                return 4096;
            case 62:
                return 8192;
            default:
                return -1;
        }
    }

    private static int x(int i11) {
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return 2;
        }
        if (i11 != 2) {
            return i11 != 3 ? -1 : 8;
        }
        return 4;
    }
}
