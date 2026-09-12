package androidx.media3.extractor.flv;

import androidx.media3.common.util.j0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import l2.n;

/* loaded from: classes2.dex */
final class c extends TagPayloadReader {

    /* renamed from: b, reason: collision with root package name */
    private long f13505b;

    /* renamed from: c, reason: collision with root package name */
    private long[] f13506c;

    /* renamed from: d, reason: collision with root package name */
    private long[] f13507d;

    public c() {
        super(new n());
        this.f13505b = C.TIME_UNSET;
        this.f13506c = new long[0];
        this.f13507d = new long[0];
    }

    private static Boolean g(j0 j0Var) {
        return Boolean.valueOf(j0Var.H() == 1);
    }

    private static Object h(j0 j0Var, int i11) {
        if (i11 == 0) {
            return j(j0Var);
        }
        if (i11 == 1) {
            return g(j0Var);
        }
        if (i11 == 2) {
            return n(j0Var);
        }
        if (i11 == 3) {
            return l(j0Var);
        }
        if (i11 == 8) {
            return k(j0Var);
        }
        if (i11 == 10) {
            return m(j0Var);
        }
        if (i11 != 11) {
            return null;
        }
        return i(j0Var);
    }

    private static Date i(j0 j0Var) {
        Date date = new Date((long) j(j0Var).doubleValue());
        j0Var.X(2);
        return date;
    }

    private static Double j(j0 j0Var) {
        return Double.valueOf(Double.longBitsToDouble(j0Var.A()));
    }

    private static HashMap k(j0 j0Var) {
        int L = j0Var.L();
        HashMap hashMap = new HashMap(L);
        for (int i11 = 0; i11 < L; i11++) {
            String n11 = n(j0Var);
            Object h11 = h(j0Var, o(j0Var));
            if (h11 != null) {
                hashMap.put(n11, h11);
            }
        }
        return hashMap;
    }

    private static HashMap l(j0 j0Var) {
        HashMap hashMap = new HashMap();
        while (true) {
            String n11 = n(j0Var);
            int o11 = o(j0Var);
            if (o11 == 9) {
                return hashMap;
            }
            Object h11 = h(j0Var, o11);
            if (h11 != null) {
                hashMap.put(n11, h11);
            }
        }
    }

    private static ArrayList m(j0 j0Var) {
        int L = j0Var.L();
        ArrayList arrayList = new ArrayList(L);
        for (int i11 = 0; i11 < L; i11++) {
            Object h11 = h(j0Var, o(j0Var));
            if (h11 != null) {
                arrayList.add(h11);
            }
        }
        return arrayList;
    }

    private static String n(j0 j0Var) {
        int P = j0Var.P();
        int f11 = j0Var.f();
        j0Var.X(P);
        return new String(j0Var.e(), f11, P);
    }

    private static int o(j0 j0Var) {
        return j0Var.H();
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean b(j0 j0Var) {
        return true;
    }

    @Override // androidx.media3.extractor.flv.TagPayloadReader
    protected boolean c(j0 j0Var, long j11) {
        if (o(j0Var) != 2 || !"onMetaData".equals(n(j0Var)) || j0Var.a() == 0 || o(j0Var) != 8) {
            return false;
        }
        HashMap k11 = k(j0Var);
        Object obj = k11.get("duration");
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.f13505b = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = k11.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.f13506c = new long[size];
                this.f13507d = new long[size];
                for (int i11 = 0; i11 < size; i11++) {
                    Object obj5 = list.get(i11);
                    Object obj6 = list2.get(i11);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.f13506c = new long[0];
                        this.f13507d = new long[0];
                        break;
                    }
                    this.f13506c[i11] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                    this.f13507d[i11] = ((Double) obj5).longValue();
                }
            }
        }
        return false;
    }

    public long d() {
        return this.f13505b;
    }

    public long[] e() {
        return this.f13507d;
    }

    public long[] f() {
        return this.f13506c;
    }
}
