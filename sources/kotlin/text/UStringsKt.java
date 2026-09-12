package kotlin.text;

import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.http2.Settings;

@Metadata(d1 = {"\u0000,\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0010\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0013\u0010\b\u001a\u00020\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\u00020\n*\u00020\u0000H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u0015\u0010\r\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a\u001d\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0004*\u00020\u0000H\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0000H\u0007¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0015\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0000H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001d\u0010\u001d\u001a\u0004\u0018\u00010\n*\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"", "Lkotlin/UByte;", "a", "(Ljava/lang/String;)B", "Lkotlin/UShort;", com.mbridge.msdk.foundation.same.report.j.f35620b, "(Ljava/lang/String;)S", "Lkotlin/UInt;", "d", "(Ljava/lang/String;)I", "Lkotlin/ULong;", be.g.f16474b, "(Ljava/lang/String;)J", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "(Ljava/lang/String;)Lkotlin/UByte;", "", "radix", "c", "(Ljava/lang/String;I)Lkotlin/UByte;", CampaignEx.JSON_KEY_AD_K, "(Ljava/lang/String;)Lkotlin/UShort;", "l", "(Ljava/lang/String;I)Lkotlin/UShort;", "e", "(Ljava/lang/String;)Lkotlin/UInt;", "f", "(Ljava/lang/String;I)Lkotlin/UInt;", "h", "(Ljava/lang/String;)Lkotlin/ULong;", "i", "(Ljava/lang/String;I)Lkotlin/ULong;", "kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@JvmName
/* loaded from: classes7.dex */
public final class UStringsKt {
    public static final byte a(String str) {
        Intrinsics.h(str, "<this>");
        UByte b11 = b(str);
        if (b11 != null) {
            return b11.getData();
        }
        r.u(str);
        throw new KotlinNothingValueException();
    }

    public static final UByte b(String str) {
        Intrinsics.h(str, "<this>");
        return c(str, 10);
    }

    public static final UByte c(String str, int i11) {
        int compare;
        Intrinsics.h(str, "<this>");
        UInt f11 = f(str, i11);
        if (f11 == null) {
            return null;
        }
        int data = f11.getData();
        compare = Integer.compare(data ^ Integer.MIN_VALUE, UInt.b(255) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return UByte.a(UByte.b((byte) data));
    }

    public static final int d(String str) {
        Intrinsics.h(str, "<this>");
        UInt e11 = e(str);
        if (e11 != null) {
            return e11.getData();
        }
        r.u(str);
        throw new KotlinNothingValueException();
    }

    public static final UInt e(String str) {
        Intrinsics.h(str, "<this>");
        return f(str, 10);
    }

    public static final UInt f(String str, int i11) {
        int i12;
        int compare;
        int compare2;
        int compare3;
        Intrinsics.h(str, "<this>");
        CharsKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i13 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.j(charAt, 48) < 0) {
            i12 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        } else {
            i12 = 0;
        }
        int b11 = UInt.b(i11);
        int i14 = 119304647;
        while (i12 < length) {
            int b12 = b.b(str.charAt(i12), i11);
            if (b12 < 0) {
                return null;
            }
            compare = Integer.compare(i13 ^ Integer.MIN_VALUE, i14 ^ Integer.MIN_VALUE);
            if (compare > 0) {
                if (i14 == 119304647) {
                    i14 = y.a(-1, b11);
                    compare3 = Integer.compare(i13 ^ Integer.MIN_VALUE, i14 ^ Integer.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            int b13 = UInt.b(i13 * b11);
            int b14 = UInt.b(UInt.b(b12) + b13);
            compare2 = Integer.compare(b14 ^ Integer.MIN_VALUE, b13 ^ Integer.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i12++;
            i13 = b14;
        }
        return UInt.a(i13);
    }

    public static final long g(String str) {
        Intrinsics.h(str, "<this>");
        ULong h11 = h(str);
        if (h11 != null) {
            return h11.getData();
        }
        r.u(str);
        throw new KotlinNothingValueException();
    }

    public static final ULong h(String str) {
        Intrinsics.h(str, "<this>");
        return i(str, 10);
    }

    public static final ULong i(String str, int i11) {
        int compare;
        int compare2;
        int compare3;
        Intrinsics.h(str, "<this>");
        CharsKt.a(i11);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char charAt = str.charAt(0);
        if (Intrinsics.j(charAt, 48) < 0) {
            i12 = 1;
            if (length == 1 || charAt != '+') {
                return null;
            }
        }
        long b11 = ULong.b(i11);
        long j11 = 0;
        long j12 = 512409557603043100L;
        while (i12 < length) {
            if (b.b(str.charAt(i12), i11) < 0) {
                return null;
            }
            compare = Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE);
            if (compare > 0) {
                if (j12 == 512409557603043100L) {
                    j12 = x.a(-1L, b11);
                    compare3 = Long.compare(j11 ^ Long.MIN_VALUE, j12 ^ Long.MIN_VALUE);
                    if (compare3 > 0) {
                    }
                }
                return null;
            }
            long b12 = ULong.b(j11 * b11);
            long b13 = ULong.b(ULong.b(UInt.b(r13) & 4294967295L) + b12);
            compare2 = Long.compare(b13 ^ Long.MIN_VALUE, b12 ^ Long.MIN_VALUE);
            if (compare2 < 0) {
                return null;
            }
            i12++;
            j11 = b13;
        }
        return ULong.a(j11);
    }

    public static final short j(String str) {
        Intrinsics.h(str, "<this>");
        UShort k11 = k(str);
        if (k11 != null) {
            return k11.getData();
        }
        r.u(str);
        throw new KotlinNothingValueException();
    }

    public static final UShort k(String str) {
        Intrinsics.h(str, "<this>");
        return l(str, 10);
    }

    public static final UShort l(String str, int i11) {
        int compare;
        Intrinsics.h(str, "<this>");
        UInt f11 = f(str, i11);
        if (f11 == null) {
            return null;
        }
        int data = f11.getData();
        compare = Integer.compare(data ^ Integer.MIN_VALUE, UInt.b(Settings.DEFAULT_INITIAL_WINDOW_SIZE) ^ Integer.MIN_VALUE);
        if (compare > 0) {
            return null;
        }
        return UShort.a(UShort.b((short) data));
    }
}
