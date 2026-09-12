package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.ByteString;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import androidx.datastore.preferences.protobuf.e;
import androidx.datastore.preferences.protobuf.h0;
import androidx.datastore.preferences.protobuf.w;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.mvel2.ast.ASTNode;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q0 implements b1 {

    /* renamed from: r, reason: collision with root package name */
    private static final int[] f8962r = new int[0];

    /* renamed from: s, reason: collision with root package name */
    private static final Unsafe f8963s = k1.H();

    /* renamed from: a, reason: collision with root package name */
    private final int[] f8964a;

    /* renamed from: b, reason: collision with root package name */
    private final Object[] f8965b;

    /* renamed from: c, reason: collision with root package name */
    private final int f8966c;

    /* renamed from: d, reason: collision with root package name */
    private final int f8967d;

    /* renamed from: e, reason: collision with root package name */
    private final n0 f8968e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f8969f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f8970g;

    /* renamed from: h, reason: collision with root package name */
    private final ProtoSyntax f8971h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f8972i;

    /* renamed from: j, reason: collision with root package name */
    private final int[] f8973j;

    /* renamed from: k, reason: collision with root package name */
    private final int f8974k;

    /* renamed from: l, reason: collision with root package name */
    private final int f8975l;

    /* renamed from: m, reason: collision with root package name */
    private final s0 f8976m;

    /* renamed from: n, reason: collision with root package name */
    private final c0 f8977n;

    /* renamed from: o, reason: collision with root package name */
    private final h1 f8978o;

    /* renamed from: p, reason: collision with root package name */
    private final p f8979p;

    /* renamed from: q, reason: collision with root package name */
    private final i0 f8980q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f8981a;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            f8981a = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8981a[WireFormat.FieldType.BYTES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8981a[WireFormat.FieldType.DOUBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8981a[WireFormat.FieldType.FIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8981a[WireFormat.FieldType.SFIXED32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8981a[WireFormat.FieldType.FIXED64.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8981a[WireFormat.FieldType.SFIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8981a[WireFormat.FieldType.FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8981a[WireFormat.FieldType.ENUM.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8981a[WireFormat.FieldType.INT32.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8981a[WireFormat.FieldType.UINT32.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8981a[WireFormat.FieldType.INT64.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f8981a[WireFormat.FieldType.UINT64.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8981a[WireFormat.FieldType.MESSAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f8981a[WireFormat.FieldType.SINT32.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8981a[WireFormat.FieldType.SINT64.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8981a[WireFormat.FieldType.STRING.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private q0(int[] iArr, Object[] objArr, int i11, int i12, n0 n0Var, ProtoSyntax protoSyntax, boolean z10, int[] iArr2, int i13, int i14, s0 s0Var, c0 c0Var, h1 h1Var, p pVar, i0 i0Var) {
        this.f8964a = iArr;
        this.f8965b = objArr;
        this.f8966c = i11;
        this.f8967d = i12;
        this.f8970g = n0Var instanceof GeneratedMessageLite;
        this.f8971h = protoSyntax;
        this.f8969f = pVar != null && pVar.e(n0Var);
        this.f8972i = z10;
        this.f8973j = iArr2;
        this.f8974k = i13;
        this.f8975l = i14;
        this.f8976m = s0Var;
        this.f8977n = c0Var;
        this.f8978o = h1Var;
        this.f8979p = pVar;
        this.f8968e = n0Var;
        this.f8980q = i0Var;
    }

    private static boolean A(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).z();
        }
        return true;
    }

    private boolean B(Object obj, Object obj2, int i11) {
        long c02 = c0(i11) & 1048575;
        return k1.C(obj, c02) == k1.C(obj2, c02);
    }

    private boolean C(Object obj, int i11, int i12) {
        return k1.C(obj, (long) (c0(i12) & 1048575)) == i11;
    }

    private static boolean D(int i11) {
        return (i11 & ASTNode.DEOP) != 0;
    }

    private static long E(Object obj, long j11) {
        return k1.E(obj, j11);
    }

    /* JADX WARN: Code restructure failed: missing block: B:208:0x0093, code lost:
    
        r0 = r18.f8974k;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x0098, code lost:
    
        if (r0 >= r18.f8975l) goto L237;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x009a, code lost:
    
        r4 = k(r21, r18.f8973j[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x00b0, code lost:
    
        r11 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:214:0x00b1, code lost:
    
        if (r4 == null) goto L240;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x00b3, code lost:
    
        r7.o(r11, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x00b6, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x00c2. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:37:0x064b A[Catch: all -> 0x0671, TRY_LEAVE, TryCatch #0 {all -> 0x0671, blocks: (B:35:0x0645, B:37:0x064b, B:50:0x0675, B:51:0x067a), top: B:34:0x0645 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0673  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x06b1 A[LOOP:4: B:66:0x06ad->B:68:0x06b1, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x06c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void F(androidx.datastore.preferences.protobuf.h1 r19, androidx.datastore.preferences.protobuf.p r20, java.lang.Object r21, androidx.datastore.preferences.protobuf.a1 r22, androidx.datastore.preferences.protobuf.o r23) {
        /*
            Method dump skipped, instructions count: 1880
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.F(androidx.datastore.preferences.protobuf.h1, androidx.datastore.preferences.protobuf.p, java.lang.Object, androidx.datastore.preferences.protobuf.a1, androidx.datastore.preferences.protobuf.o):void");
    }

    private final void G(Object obj, int i11, Object obj2, o oVar, a1 a1Var) {
        long Q = Q(o0(i11));
        Object G = k1.G(obj, Q);
        if (G == null) {
            G = this.f8980q.newMapField(obj2);
            k1.W(obj, Q, G);
        } else if (this.f8980q.isImmutable(G)) {
            Object newMapField = this.f8980q.newMapField(obj2);
            this.f8980q.mergeFrom(newMapField, G);
            k1.W(obj, Q, newMapField);
            G = newMapField;
        }
        a1Var.c(this.f8980q.forMutableMapData(G), this.f8980q.forMapMetadata(obj2), oVar);
    }

    private void H(Object obj, Object obj2, int i11) {
        if (u(obj2, i11)) {
            long Q = Q(o0(i11));
            Unsafe unsafe = f8963s;
            Object object = unsafe.getObject(obj2, Q);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + P(i11) + " is present but null: " + obj2);
            }
            b1 p11 = p(i11);
            if (!u(obj, i11)) {
                if (A(object)) {
                    Object newInstance = p11.newInstance();
                    p11.mergeFrom(newInstance, object);
                    unsafe.putObject(obj, Q, newInstance);
                } else {
                    unsafe.putObject(obj, Q, object);
                }
                i0(obj, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, Q);
            if (!A(object2)) {
                Object newInstance2 = p11.newInstance();
                p11.mergeFrom(newInstance2, object2);
                unsafe.putObject(obj, Q, newInstance2);
                object2 = newInstance2;
            }
            p11.mergeFrom(object2, object);
        }
    }

    private void I(Object obj, Object obj2, int i11) {
        int P = P(i11);
        if (C(obj2, P, i11)) {
            long Q = Q(o0(i11));
            Unsafe unsafe = f8963s;
            Object object = unsafe.getObject(obj2, Q);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + P(i11) + " is present but null: " + obj2);
            }
            b1 p11 = p(i11);
            if (!C(obj, P, i11)) {
                if (A(object)) {
                    Object newInstance = p11.newInstance();
                    p11.mergeFrom(newInstance, object);
                    unsafe.putObject(obj, Q, newInstance);
                } else {
                    unsafe.putObject(obj, Q, object);
                }
                j0(obj, P, i11);
                return;
            }
            Object object2 = unsafe.getObject(obj, Q);
            if (!A(object2)) {
                Object newInstance2 = p11.newInstance();
                p11.mergeFrom(newInstance2, object2);
                unsafe.putObject(obj, Q, newInstance2);
                object2 = newInstance2;
            }
            p11.mergeFrom(object2, object);
        }
    }

    private void J(Object obj, Object obj2, int i11) {
        int o02 = o0(i11);
        long Q = Q(o02);
        int P = P(i11);
        switch (n0(o02)) {
            case 0:
                if (u(obj2, i11)) {
                    k1.S(obj, Q, k1.A(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 1:
                if (u(obj2, i11)) {
                    k1.T(obj, Q, k1.B(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 2:
                if (u(obj2, i11)) {
                    k1.V(obj, Q, k1.E(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 3:
                if (u(obj2, i11)) {
                    k1.V(obj, Q, k1.E(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 4:
                if (u(obj2, i11)) {
                    k1.U(obj, Q, k1.C(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 5:
                if (u(obj2, i11)) {
                    k1.V(obj, Q, k1.E(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 6:
                if (u(obj2, i11)) {
                    k1.U(obj, Q, k1.C(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 7:
                if (u(obj2, i11)) {
                    k1.M(obj, Q, k1.t(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 8:
                if (u(obj2, i11)) {
                    k1.W(obj, Q, k1.G(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 9:
                H(obj, obj2, i11);
                return;
            case 10:
                if (u(obj2, i11)) {
                    k1.W(obj, Q, k1.G(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 11:
                if (u(obj2, i11)) {
                    k1.U(obj, Q, k1.C(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 12:
                if (u(obj2, i11)) {
                    k1.U(obj, Q, k1.C(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 13:
                if (u(obj2, i11)) {
                    k1.U(obj, Q, k1.C(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 14:
                if (u(obj2, i11)) {
                    k1.V(obj, Q, k1.E(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 15:
                if (u(obj2, i11)) {
                    k1.U(obj, Q, k1.C(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 16:
                if (u(obj2, i11)) {
                    k1.V(obj, Q, k1.E(obj2, Q));
                    i0(obj, i11);
                    return;
                }
                return;
            case 17:
                H(obj, obj2, i11);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                this.f8977n.b(obj, obj2, Q);
                return;
            case 50:
                d1.E(this.f8980q, obj, obj2, Q);
                return;
            case AD_REWARD_USER_VALUE:
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case AD_VISIBILITY_VALUE:
            case 57:
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
            case 59:
                if (C(obj2, P, i11)) {
                    k1.W(obj, Q, k1.G(obj2, Q));
                    j0(obj, P, i11);
                    return;
                }
                return;
            case 60:
                I(obj, obj2, i11);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
            case 66:
            case 67:
                if (C(obj2, P, i11)) {
                    k1.W(obj, Q, k1.G(obj2, Q));
                    j0(obj, P, i11);
                    return;
                }
                return;
            case 68:
                I(obj, obj2, i11);
                return;
            default:
                return;
        }
    }

    private Object K(Object obj, int i11) {
        b1 p11 = p(i11);
        long Q = Q(o0(i11));
        if (!u(obj, i11)) {
            return p11.newInstance();
        }
        Object object = f8963s.getObject(obj, Q);
        if (A(object)) {
            return object;
        }
        Object newInstance = p11.newInstance();
        if (object != null) {
            p11.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    private Object L(Object obj, int i11, int i12) {
        b1 p11 = p(i12);
        if (!C(obj, i11, i12)) {
            return p11.newInstance();
        }
        Object object = f8963s.getObject(obj, Q(o0(i12)));
        if (A(object)) {
            return object;
        }
        Object newInstance = p11.newInstance();
        if (object != null) {
            p11.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static q0 M(Class cls, l0 l0Var, s0 s0Var, c0 c0Var, h1 h1Var, p pVar, i0 i0Var) {
        if (l0Var instanceof z0) {
            return O((z0) l0Var, s0Var, c0Var, h1Var, pVar, i0Var);
        }
        android.support.v4.media.session.c.a(l0Var);
        return N(null, s0Var, c0Var, h1Var, pVar, i0Var);
    }

    static q0 N(f1 f1Var, s0 s0Var, c0 c0Var, h1 h1Var, p pVar, i0 i0Var) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static androidx.datastore.preferences.protobuf.q0 O(androidx.datastore.preferences.protobuf.z0 r31, androidx.datastore.preferences.protobuf.s0 r32, androidx.datastore.preferences.protobuf.c0 r33, androidx.datastore.preferences.protobuf.h1 r34, androidx.datastore.preferences.protobuf.p r35, androidx.datastore.preferences.protobuf.i0 r36) {
        /*
            Method dump skipped, instructions count: 993
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.O(androidx.datastore.preferences.protobuf.z0, androidx.datastore.preferences.protobuf.s0, androidx.datastore.preferences.protobuf.c0, androidx.datastore.preferences.protobuf.h1, androidx.datastore.preferences.protobuf.p, androidx.datastore.preferences.protobuf.i0):androidx.datastore.preferences.protobuf.q0");
    }

    private int P(int i11) {
        return this.f8964a[i11];
    }

    private static long Q(int i11) {
        return i11 & 1048575;
    }

    private static boolean R(Object obj, long j11) {
        return ((Boolean) k1.G(obj, j11)).booleanValue();
    }

    private static double S(Object obj, long j11) {
        return ((Double) k1.G(obj, j11)).doubleValue();
    }

    private static float T(Object obj, long j11) {
        return ((Float) k1.G(obj, j11)).floatValue();
    }

    private static int U(Object obj, long j11) {
        return ((Integer) k1.G(obj, j11)).intValue();
    }

    private static long V(Object obj, long j11) {
        return ((Long) k1.G(obj, j11)).longValue();
    }

    private int W(Object obj, byte[] bArr, int i11, int i12, int i13, long j11, e.a aVar) {
        Unsafe unsafe = f8963s;
        Object o11 = o(i13);
        Object object = unsafe.getObject(obj, j11);
        if (this.f8980q.isImmutable(object)) {
            Object newMapField = this.f8980q.newMapField(o11);
            this.f8980q.mergeFrom(newMapField, object);
            unsafe.putObject(obj, j11, newMapField);
            object = newMapField;
        }
        return g(bArr, i11, i12, this.f8980q.forMapMetadata(o11), this.f8980q.forMutableMapData(object), aVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0023. Please report as an issue. */
    private int Y(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, int i17, long j11, int i18, e.a aVar) {
        Unsafe unsafe = f8963s;
        long j12 = this.f8964a[i18 + 2] & 1048575;
        switch (i17) {
            case AD_REWARD_USER_VALUE:
                if (i15 == 1) {
                    unsafe.putObject(obj, j11, Double.valueOf(e.e(bArr, i11)));
                    int i19 = i11 + 8;
                    unsafe.putInt(obj, j12, i14);
                    return i19;
                }
                return i11;
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                if (i15 == 5) {
                    unsafe.putObject(obj, j11, Float.valueOf(e.l(bArr, i11)));
                    int i20 = i11 + 4;
                    unsafe.putInt(obj, j12, i14);
                    return i20;
                }
                return i11;
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                if (i15 == 0) {
                    int L = e.L(bArr, i11, aVar);
                    unsafe.putObject(obj, j11, Long.valueOf(aVar.f8828b));
                    unsafe.putInt(obj, j12, i14);
                    return L;
                }
                return i11;
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case 62:
                if (i15 == 0) {
                    int I = e.I(bArr, i11, aVar);
                    unsafe.putObject(obj, j11, Integer.valueOf(aVar.f8827a));
                    unsafe.putInt(obj, j12, i14);
                    return I;
                }
                return i11;
            case AD_VISIBILITY_VALUE:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                if (i15 == 1) {
                    unsafe.putObject(obj, j11, Long.valueOf(e.j(bArr, i11)));
                    int i21 = i11 + 8;
                    unsafe.putInt(obj, j12, i14);
                    return i21;
                }
                return i11;
            case 57:
            case 64:
                if (i15 == 5) {
                    unsafe.putObject(obj, j11, Integer.valueOf(e.h(bArr, i11)));
                    int i22 = i11 + 4;
                    unsafe.putInt(obj, j12, i14);
                    return i22;
                }
                return i11;
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                if (i15 == 0) {
                    int L2 = e.L(bArr, i11, aVar);
                    unsafe.putObject(obj, j11, Boolean.valueOf(aVar.f8828b != 0));
                    unsafe.putInt(obj, j12, i14);
                    return L2;
                }
                return i11;
            case 59:
                if (i15 == 2) {
                    int I2 = e.I(bArr, i11, aVar);
                    int i23 = aVar.f8827a;
                    if (i23 == 0) {
                        unsafe.putObject(obj, j11, "");
                    } else {
                        if ((i16 & ASTNode.DISCARD) != 0 && !Utf8.s(bArr, I2, I2 + i23)) {
                            throw InvalidProtocolBufferException.invalidUtf8();
                        }
                        unsafe.putObject(obj, j11, new String(bArr, I2, i23, w.f8998b));
                        I2 += i23;
                    }
                    unsafe.putInt(obj, j12, i14);
                    return I2;
                }
                return i11;
            case 60:
                if (i15 == 2) {
                    Object L3 = L(obj, i14, i18);
                    int O = e.O(L3, p(i18), bArr, i11, i12, aVar);
                    m0(obj, i14, i18, L3);
                    return O;
                }
                return i11;
            case 61:
                if (i15 == 2) {
                    int c11 = e.c(bArr, i11, aVar);
                    unsafe.putObject(obj, j11, aVar.f8829c);
                    unsafe.putInt(obj, j12, i14);
                    return c11;
                }
                return i11;
            case 63:
                if (i15 == 0) {
                    int I3 = e.I(bArr, i11, aVar);
                    int i24 = aVar.f8827a;
                    w.c n11 = n(i18);
                    if (n11 == null || n11.isInRange(i24)) {
                        unsafe.putObject(obj, j11, Integer.valueOf(i24));
                        unsafe.putInt(obj, j12, i14);
                    } else {
                        q(obj).n(i13, Long.valueOf(i24));
                    }
                    return I3;
                }
                return i11;
            case 66:
                if (i15 == 0) {
                    int I4 = e.I(bArr, i11, aVar);
                    unsafe.putObject(obj, j11, Integer.valueOf(i.c(aVar.f8827a)));
                    unsafe.putInt(obj, j12, i14);
                    return I4;
                }
                return i11;
            case 67:
                if (i15 == 0) {
                    int L4 = e.L(bArr, i11, aVar);
                    unsafe.putObject(obj, j11, Long.valueOf(i.d(aVar.f8828b)));
                    unsafe.putInt(obj, j12, i14);
                    return L4;
                }
                return i11;
            case 68:
                if (i15 == 3) {
                    Object L5 = L(obj, i14, i18);
                    int N = e.N(L5, p(i18), bArr, i11, i12, (i13 & (-8)) | 4, aVar);
                    m0(obj, i14, i18, L5);
                    return N;
                }
                return i11;
            default:
                return i11;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:9:0x002f. Please report as an issue. */
    private int Z(Object obj, byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, long j11, int i17, long j12, e.a aVar) {
        int J;
        Unsafe unsafe = f8963s;
        w.d dVar = (w.d) unsafe.getObject(obj, j12);
        if (!dVar.isModifiable()) {
            int size = dVar.size();
            dVar = dVar.mutableCopyWithCapacity(size == 0 ? 10 : size * 2);
            unsafe.putObject(obj, j12, dVar);
        }
        switch (i17) {
            case 18:
            case 35:
                if (i15 == 2) {
                    return e.s(bArr, i11, dVar, aVar);
                }
                if (i15 == 1) {
                    return e.f(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 19:
            case 36:
                if (i15 == 2) {
                    return e.v(bArr, i11, dVar, aVar);
                }
                if (i15 == 5) {
                    return e.m(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i15 == 2) {
                    return e.z(bArr, i11, dVar, aVar);
                }
                if (i15 == 0) {
                    return e.M(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 22:
            case NOTIFICATION_REDIRECT_VALUE:
            case 39:
            case 43:
                if (i15 == 2) {
                    return e.y(bArr, i11, dVar, aVar);
                }
                if (i15 == 0) {
                    return e.J(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i15 == 2) {
                    return e.u(bArr, i11, dVar, aVar);
                }
                if (i15 == 1) {
                    return e.k(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 24:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 41:
            case 45:
                if (i15 == 2) {
                    return e.t(bArr, i11, dVar, aVar);
                }
                if (i15 == 5) {
                    return e.i(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 25:
            case 42:
                if (i15 == 2) {
                    return e.r(bArr, i11, dVar, aVar);
                }
                if (i15 == 0) {
                    return e.b(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 26:
                if (i15 == 2) {
                    return (j11 & 536870912) == 0 ? e.D(i13, bArr, i11, i12, dVar, aVar) : e.E(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 27:
                if (i15 == 2) {
                    return e.q(p(i16), i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 28:
                if (i15 == 2) {
                    return e.d(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 30:
            case 44:
                if (i15 != 2) {
                    if (i15 == 0) {
                        J = e.J(i13, bArr, i11, i12, dVar, aVar);
                    }
                    return i11;
                }
                J = e.y(bArr, i11, dVar, aVar);
                d1.z(obj, i14, dVar, n(i16), null, this.f8978o);
                return J;
            case 33:
            case 47:
                if (i15 == 2) {
                    return e.w(bArr, i11, dVar, aVar);
                }
                if (i15 == 0) {
                    return e.A(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case 34:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                if (i15 == 2) {
                    return e.x(bArr, i11, dVar, aVar);
                }
                if (i15 == 0) {
                    return e.B(i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                if (i15 == 3) {
                    return e.o(p(i16), i13, bArr, i11, i12, dVar, aVar);
                }
                return i11;
            default:
                return i11;
        }
    }

    private int a0(int i11) {
        if (i11 < this.f8966c || i11 > this.f8967d) {
            return -1;
        }
        return k0(i11, 0);
    }

    private int b0(int i11, int i12) {
        if (i11 < this.f8966c || i11 > this.f8967d) {
            return -1;
        }
        return k0(i11, i12);
    }

    private int c0(int i11) {
        return this.f8964a[i11 + 2];
    }

    private boolean d(Object obj, Object obj2, int i11) {
        return u(obj, i11) == u(obj2, i11);
    }

    private void d0(Object obj, long j11, a1 a1Var, b1 b1Var, o oVar) {
        a1Var.e(this.f8977n.c(obj, j11), b1Var, oVar);
    }

    private static boolean e(Object obj, long j11) {
        return k1.t(obj, j11);
    }

    private void e0(Object obj, int i11, a1 a1Var, b1 b1Var, o oVar) {
        a1Var.b(this.f8977n.c(obj, Q(i11)), b1Var, oVar);
    }

    private static void f(Object obj) {
        if (A(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private void f0(Object obj, int i11, a1 a1Var) {
        if (t(i11)) {
            k1.W(obj, Q(i11), a1Var.readStringRequireUtf8());
        } else if (this.f8970g) {
            k1.W(obj, Q(i11), a1Var.readString());
        } else {
            k1.W(obj, Q(i11), a1Var.readBytes());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private int g(byte[] bArr, int i11, int i12, h0.a aVar, Map map, e.a aVar2) {
        int i13;
        int I = e.I(bArr, i11, aVar2);
        int i14 = aVar2.f8827a;
        if (i14 < 0 || i14 > i12 - I) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i15 = I + i14;
        Object obj = aVar.f8864b;
        Object obj2 = aVar.f8866d;
        while (I < i15) {
            int i16 = I + 1;
            byte b11 = bArr[I];
            if (b11 < 0) {
                i13 = e.H(b11, bArr, i16, aVar2);
                b11 = aVar2.f8827a;
            } else {
                i13 = i16;
            }
            int i17 = b11 >>> 3;
            int i18 = b11 & 7;
            if (i17 != 1) {
                if (i17 == 2 && i18 == aVar.f8865c.getWireType()) {
                    I = h(bArr, i13, i12, aVar.f8865c, aVar.f8866d.getClass(), aVar2);
                    obj2 = aVar2.f8829c;
                }
                I = e.P(b11, bArr, i13, i12, aVar2);
            } else if (i18 == aVar.f8863a.getWireType()) {
                I = h(bArr, i13, i12, aVar.f8863a, null, aVar2);
                obj = aVar2.f8829c;
            } else {
                I = e.P(b11, bArr, i13, i12, aVar2);
            }
        }
        if (I != i15) {
            throw InvalidProtocolBufferException.parseFailure();
        }
        map.put(obj, obj2);
        return i15;
    }

    private void g0(Object obj, int i11, a1 a1Var) {
        if (t(i11)) {
            a1Var.readStringListRequireUtf8(this.f8977n.c(obj, Q(i11)));
        } else {
            a1Var.readStringList(this.f8977n.c(obj, Q(i11)));
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    private int h(byte[] bArr, int i11, int i12, WireFormat.FieldType fieldType, Class cls, e.a aVar) {
        switch (a.f8981a[fieldType.ordinal()]) {
            case 1:
                int L = e.L(bArr, i11, aVar);
                aVar.f8829c = Boolean.valueOf(aVar.f8828b != 0);
                return L;
            case 2:
                return e.c(bArr, i11, aVar);
            case 3:
                aVar.f8829c = Double.valueOf(e.e(bArr, i11));
                return i11 + 8;
            case 4:
            case 5:
                aVar.f8829c = Integer.valueOf(e.h(bArr, i11));
                return i11 + 4;
            case 6:
            case 7:
                aVar.f8829c = Long.valueOf(e.j(bArr, i11));
                return i11 + 8;
            case 8:
                aVar.f8829c = Float.valueOf(e.l(bArr, i11));
                return i11 + 4;
            case 9:
            case 10:
            case 11:
                int I = e.I(bArr, i11, aVar);
                aVar.f8829c = Integer.valueOf(aVar.f8827a);
                return I;
            case 12:
            case 13:
                int L2 = e.L(bArr, i11, aVar);
                aVar.f8829c = Long.valueOf(aVar.f8828b);
                return L2;
            case 14:
                return e.p(x0.a().c(cls), bArr, i11, i12, aVar);
            case 15:
                int I2 = e.I(bArr, i11, aVar);
                aVar.f8829c = Integer.valueOf(i.c(aVar.f8827a));
                return I2;
            case 16:
                int L3 = e.L(bArr, i11, aVar);
                aVar.f8829c = Long.valueOf(i.d(aVar.f8828b));
                return L3;
            case 17:
                return e.F(bArr, i11, aVar);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private static Field h0(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private static double i(Object obj, long j11) {
        return k1.A(obj, j11);
    }

    private void i0(Object obj, int i11) {
        int c02 = c0(i11);
        long j11 = 1048575 & c02;
        if (j11 == 1048575) {
            return;
        }
        k1.U(obj, j11, (1 << (c02 >>> 20)) | k1.C(obj, j11));
    }

    private boolean j(Object obj, Object obj2, int i11) {
        int o02 = o0(i11);
        long Q = Q(o02);
        switch (n0(o02)) {
            case 0:
                return d(obj, obj2, i11) && Double.doubleToLongBits(k1.A(obj, Q)) == Double.doubleToLongBits(k1.A(obj2, Q));
            case 1:
                return d(obj, obj2, i11) && Float.floatToIntBits(k1.B(obj, Q)) == Float.floatToIntBits(k1.B(obj2, Q));
            case 2:
                return d(obj, obj2, i11) && k1.E(obj, Q) == k1.E(obj2, Q);
            case 3:
                return d(obj, obj2, i11) && k1.E(obj, Q) == k1.E(obj2, Q);
            case 4:
                return d(obj, obj2, i11) && k1.C(obj, Q) == k1.C(obj2, Q);
            case 5:
                return d(obj, obj2, i11) && k1.E(obj, Q) == k1.E(obj2, Q);
            case 6:
                return d(obj, obj2, i11) && k1.C(obj, Q) == k1.C(obj2, Q);
            case 7:
                return d(obj, obj2, i11) && k1.t(obj, Q) == k1.t(obj2, Q);
            case 8:
                return d(obj, obj2, i11) && d1.H(k1.G(obj, Q), k1.G(obj2, Q));
            case 9:
                return d(obj, obj2, i11) && d1.H(k1.G(obj, Q), k1.G(obj2, Q));
            case 10:
                return d(obj, obj2, i11) && d1.H(k1.G(obj, Q), k1.G(obj2, Q));
            case 11:
                return d(obj, obj2, i11) && k1.C(obj, Q) == k1.C(obj2, Q);
            case 12:
                return d(obj, obj2, i11) && k1.C(obj, Q) == k1.C(obj2, Q);
            case 13:
                return d(obj, obj2, i11) && k1.C(obj, Q) == k1.C(obj2, Q);
            case 14:
                return d(obj, obj2, i11) && k1.E(obj, Q) == k1.E(obj2, Q);
            case 15:
                return d(obj, obj2, i11) && k1.C(obj, Q) == k1.C(obj2, Q);
            case 16:
                return d(obj, obj2, i11) && k1.E(obj, Q) == k1.E(obj2, Q);
            case 17:
                return d(obj, obj2, i11) && d1.H(k1.G(obj, Q), k1.G(obj2, Q));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case NOTIFICATION_REDIRECT_VALUE:
            case 30:
            case TEMPLATE_HTML_SIZE_VALUE:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                return d1.H(k1.G(obj, Q), k1.G(obj2, Q));
            case 50:
                return d1.H(k1.G(obj, Q), k1.G(obj2, Q));
            case AD_REWARD_USER_VALUE:
            case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
            case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
            case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
            case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
            case AD_VISIBILITY_VALUE:
            case 57:
            case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
            case 66:
            case 67:
            case 68:
                return B(obj, obj2, i11) && d1.H(k1.G(obj, Q), k1.G(obj2, Q));
            default:
                return true;
        }
    }

    private void j0(Object obj, int i11, int i12) {
        k1.U(obj, c0(i12) & 1048575, i11);
    }

    private Object k(Object obj, int i11, Object obj2, h1 h1Var, Object obj3) {
        w.c n11;
        int P = P(i11);
        Object G = k1.G(obj, Q(o0(i11)));
        return (G == null || (n11 = n(i11)) == null) ? obj2 : l(i11, P, this.f8980q.forMutableMapData(G), n11, obj2, h1Var, obj3);
    }

    private int k0(int i11, int i12) {
        int length = (this.f8964a.length / 3) - 1;
        while (i12 <= length) {
            int i13 = (length + i12) >>> 1;
            int i14 = i13 * 3;
            int P = P(i14);
            if (i11 == P) {
                return i14;
            }
            if (i11 < P) {
                length = i13 - 1;
            } else {
                i12 = i13 + 1;
            }
        }
        return -1;
    }

    private Object l(int i11, int i12, Map map, w.c cVar, Object obj, h1 h1Var, Object obj2) {
        h0.a forMapMetadata = this.f8980q.forMapMetadata(o(i11));
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!cVar.isInRange(((Integer) entry.getValue()).intValue())) {
                if (obj == null) {
                    obj = h1Var.f(obj2);
                }
                ByteString.f newCodedBuilder = ByteString.newCodedBuilder(h0.b(forMapMetadata, entry.getKey(), entry.getValue()));
                try {
                    h0.e(newCodedBuilder.b(), forMapMetadata, entry.getKey(), entry.getValue());
                    h1Var.d(obj, i12, newCodedBuilder.a());
                    it.remove();
                } catch (IOException e11) {
                    throw new RuntimeException(e11);
                }
            }
        }
        return obj;
    }

    private void l0(Object obj, int i11, Object obj2) {
        f8963s.putObject(obj, Q(o0(i11)), obj2);
        i0(obj, i11);
    }

    private static float m(Object obj, long j11) {
        return k1.B(obj, j11);
    }

    private void m0(Object obj, int i11, int i12, Object obj2) {
        f8963s.putObject(obj, Q(o0(i12)), obj2);
        j0(obj, i11, i12);
    }

    private w.c n(int i11) {
        return (w.c) this.f8965b[((i11 / 3) * 2) + 1];
    }

    private static int n0(int i11) {
        return (i11 & 267386880) >>> 20;
    }

    private Object o(int i11) {
        return this.f8965b[(i11 / 3) * 2];
    }

    private int o0(int i11) {
        return this.f8964a[i11 + 1];
    }

    private b1 p(int i11) {
        int i12 = (i11 / 3) * 2;
        b1 b1Var = (b1) this.f8965b[i12];
        if (b1Var != null) {
            return b1Var;
        }
        b1 c11 = x0.a().c((Class) this.f8965b[i12 + 1]);
        this.f8965b[i12] = c11;
        return c11;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0095. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void p0(java.lang.Object r22, androidx.datastore.preferences.protobuf.Writer r23) {
        /*
            Method dump skipped, instructions count: 1746
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.p0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i1 q(Object obj) {
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
        i1 i1Var = generatedMessageLite.unknownFields;
        if (i1Var != i1.c()) {
            return i1Var;
        }
        i1 k11 = i1.k();
        generatedMessageLite.unknownFields = k11;
        return k11;
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q0(java.lang.Object r11, androidx.datastore.preferences.protobuf.Writer r12) {
        /*
            Method dump skipped, instructions count: 1586
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.q0(java.lang.Object, androidx.datastore.preferences.protobuf.Writer):void");
    }

    private int r(h1 h1Var, Object obj) {
        return h1Var.h(h1Var.g(obj));
    }

    private void r0(Writer writer, int i11, Object obj, int i12) {
        if (obj != null) {
            writer.d(i11, this.f8980q.forMapMetadata(o(i12)), this.f8980q.forMapData(obj));
        }
    }

    private static int s(Object obj, long j11) {
        return k1.C(obj, j11);
    }

    private void s0(int i11, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i11, (String) obj);
        } else {
            writer.b(i11, (ByteString) obj);
        }
    }

    private static boolean t(int i11) {
        return (i11 & ASTNode.DISCARD) != 0;
    }

    private void t0(h1 h1Var, Object obj, Writer writer) {
        h1Var.t(h1Var.g(obj), writer);
    }

    private boolean u(Object obj, int i11) {
        int c02 = c0(i11);
        long j11 = 1048575 & c02;
        if (j11 != 1048575) {
            return (k1.C(obj, j11) & (1 << (c02 >>> 20))) != 0;
        }
        int o02 = o0(i11);
        long Q = Q(o02);
        switch (n0(o02)) {
            case 0:
                return Double.doubleToRawLongBits(k1.A(obj, Q)) != 0;
            case 1:
                return Float.floatToRawIntBits(k1.B(obj, Q)) != 0;
            case 2:
                return k1.E(obj, Q) != 0;
            case 3:
                return k1.E(obj, Q) != 0;
            case 4:
                return k1.C(obj, Q) != 0;
            case 5:
                return k1.E(obj, Q) != 0;
            case 6:
                return k1.C(obj, Q) != 0;
            case 7:
                return k1.t(obj, Q);
            case 8:
                Object G = k1.G(obj, Q);
                if (G instanceof String) {
                    return !((String) G).isEmpty();
                }
                if (G instanceof ByteString) {
                    return !ByteString.EMPTY.equals(G);
                }
                throw new IllegalArgumentException();
            case 9:
                return k1.G(obj, Q) != null;
            case 10:
                return !ByteString.EMPTY.equals(k1.G(obj, Q));
            case 11:
                return k1.C(obj, Q) != 0;
            case 12:
                return k1.C(obj, Q) != 0;
            case 13:
                return k1.C(obj, Q) != 0;
            case 14:
                return k1.E(obj, Q) != 0;
            case 15:
                return k1.C(obj, Q) != 0;
            case 16:
                return k1.E(obj, Q) != 0;
            case 17:
                return k1.G(obj, Q) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private boolean v(Object obj, int i11, int i12, int i13, int i14) {
        return i12 == 1048575 ? u(obj, i11) : (i13 & i14) != 0;
    }

    private static boolean w(Object obj, int i11, b1 b1Var) {
        return b1Var.isInitialized(k1.G(obj, Q(i11)));
    }

    private static boolean x(int i11) {
        return (i11 & Integer.MIN_VALUE) != 0;
    }

    private boolean y(Object obj, int i11, int i12) {
        List list = (List) k1.G(obj, Q(i11));
        if (list.isEmpty()) {
            return true;
        }
        b1 p11 = p(i12);
        for (int i13 = 0; i13 < list.size(); i13++) {
            if (!p11.isInitialized(list.get(i13))) {
                return false;
            }
        }
        return true;
    }

    private boolean z(Object obj, int i11, int i12) {
        Map forMapData = this.f8980q.forMapData(k1.G(obj, Q(i11)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.f8980q.forMapMetadata(o(i12)).f8865c.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        b1 b1Var = null;
        for (Object obj2 : forMapData.values()) {
            if (b1Var == null) {
                b1Var = x0.a().c(obj2.getClass());
            }
            if (!b1Var.isInitialized(obj2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x0370, code lost:
    
        if (r0 != r8) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x0372, code lost:
    
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r36;
        r1 = r17;
        r8 = r18;
        r6 = r20;
        r3 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x038c, code lost:
    
        r8 = r35;
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x03c2, code lost:
    
        if (r0 != r15) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x03e3, code lost:
    
        if (r0 != r15) goto L115;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:21:0x0095. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int X(java.lang.Object r31, byte[] r32, int r33, int r34, int r35, androidx.datastore.preferences.protobuf.e.a r36) {
        /*
            Method dump skipped, instructions count: 1210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.q0.X(java.lang.Object, byte[], int, int, int, androidx.datastore.preferences.protobuf.e$a):int");
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void a(Object obj, a1 a1Var, o oVar) {
        oVar.getClass();
        f(obj);
        F(this.f8978o, this.f8979p, obj, a1Var, oVar);
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void b(Object obj, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            q0(obj, writer);
        } else {
            p0(obj, writer);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void c(Object obj, byte[] bArr, int i11, int i12, e.a aVar) {
        X(obj, bArr, i11, i12, 0, aVar);
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public boolean equals(Object obj, Object obj2) {
        int length = this.f8964a.length;
        for (int i11 = 0; i11 < length; i11 += 3) {
            if (!j(obj, obj2, i11)) {
                return false;
            }
        }
        if (!this.f8978o.g(obj).equals(this.f8978o.g(obj2))) {
            return false;
        }
        if (this.f8969f) {
            return this.f8979p.c(obj).equals(this.f8979p.c(obj2));
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0060. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.b1
    public int getSerializedSize(Object obj) {
        int i11;
        int i12;
        int i13;
        int j11;
        int e11;
        int I;
        boolean z10;
        int f11;
        int i14;
        int S;
        int U;
        Unsafe unsafe = f8963s;
        int i15 = 1048575;
        int i16 = 1048575;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        while (i18 < this.f8964a.length) {
            int o02 = o0(i18);
            int n02 = n0(o02);
            int P = P(i18);
            int i20 = this.f8964a[i18 + 2];
            int i21 = i20 & i15;
            if (n02 <= 17) {
                if (i21 != i16) {
                    i17 = i21 == i15 ? 0 : unsafe.getInt(obj, i21);
                    i16 = i21;
                }
                i11 = i16;
                i12 = i17;
                i13 = 1 << (i20 >>> 20);
            } else {
                i11 = i16;
                i12 = i17;
                i13 = 0;
            }
            long Q = Q(o02);
            if (n02 < FieldType.DOUBLE_LIST_PACKED.id() || n02 > FieldType.SINT64_LIST_PACKED.id()) {
                i21 = 0;
            }
            switch (n02) {
                case 0:
                    if (!v(obj, i18, i11, i12, i13)) {
                        break;
                    } else {
                        j11 = CodedOutputStream.j(P, 0.0d);
                        i19 += j11;
                        break;
                    }
                case 1:
                    if (!v(obj, i18, i11, i12, i13)) {
                        break;
                    } else {
                        j11 = CodedOutputStream.r(P, 0.0f);
                        i19 += j11;
                        break;
                    }
                case 2:
                    if (!v(obj, i18, i11, i12, i13)) {
                        break;
                    } else {
                        j11 = CodedOutputStream.y(P, unsafe.getLong(obj, Q));
                        i19 += j11;
                        break;
                    }
                case 3:
                    if (!v(obj, i18, i11, i12, i13)) {
                        break;
                    } else {
                        j11 = CodedOutputStream.V(P, unsafe.getLong(obj, Q));
                        i19 += j11;
                        break;
                    }
                case 4:
                    if (!v(obj, i18, i11, i12, i13)) {
                        break;
                    } else {
                        j11 = CodedOutputStream.w(P, unsafe.getInt(obj, Q));
                        i19 += j11;
                        break;
                    }
                case 5:
                    if (!v(obj, i18, i11, i12, i13)) {
                        break;
                    } else {
                        j11 = CodedOutputStream.p(P, 0L);
                        i19 += j11;
                        break;
                    }
                case 6:
                    if (v(obj, i18, i11, i12, i13)) {
                        j11 = CodedOutputStream.n(P, 0);
                        i19 += j11;
                        break;
                    }
                    break;
                case 7:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.e(P, true);
                        i19 += e11;
                    }
                    break;
                case 8:
                    if (v(obj, i18, i11, i12, i13)) {
                        Object object = unsafe.getObject(obj, Q);
                        e11 = object instanceof ByteString ? CodedOutputStream.h(P, (ByteString) object) : CodedOutputStream.Q(P, (String) object);
                        i19 += e11;
                    }
                    break;
                case 9:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = d1.o(P, unsafe.getObject(obj, Q), p(i18));
                        i19 += e11;
                    }
                    break;
                case 10:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.h(P, (ByteString) unsafe.getObject(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 11:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.T(P, unsafe.getInt(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 12:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.l(P, unsafe.getInt(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 13:
                    if (v(obj, i18, i11, i12, i13)) {
                        I = CodedOutputStream.I(P, 0);
                        i19 += I;
                    }
                    break;
                case 14:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.K(P, 0L);
                        i19 += e11;
                    }
                    break;
                case 15:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.M(P, unsafe.getInt(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 16:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.O(P, unsafe.getLong(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 17:
                    if (v(obj, i18, i11, i12, i13)) {
                        e11 = CodedOutputStream.t(P, (n0) unsafe.getObject(obj, Q), p(i18));
                        i19 += e11;
                    }
                    break;
                case 18:
                    e11 = d1.h(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += e11;
                    break;
                case 19:
                    z10 = false;
                    f11 = d1.f(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 20:
                    z10 = false;
                    f11 = d1.m(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 21:
                    z10 = false;
                    f11 = d1.x(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 22:
                    z10 = false;
                    f11 = d1.k(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 23:
                    z10 = false;
                    f11 = d1.h(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 24:
                    z10 = false;
                    f11 = d1.f(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 25:
                    z10 = false;
                    f11 = d1.a(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 26:
                    e11 = d1.u(P, (List) unsafe.getObject(obj, Q));
                    i19 += e11;
                    break;
                case 27:
                    e11 = d1.p(P, (List) unsafe.getObject(obj, Q), p(i18));
                    i19 += e11;
                    break;
                case 28:
                    e11 = d1.c(P, (List) unsafe.getObject(obj, Q));
                    i19 += e11;
                    break;
                case NOTIFICATION_REDIRECT_VALUE:
                    e11 = d1.v(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += e11;
                    break;
                case 30:
                    z10 = false;
                    f11 = d1.d(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case TEMPLATE_HTML_SIZE_VALUE:
                    z10 = false;
                    f11 = d1.f(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 32:
                    z10 = false;
                    f11 = d1.h(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 33:
                    z10 = false;
                    f11 = d1.q(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 34:
                    z10 = false;
                    f11 = d1.s(P, (List) unsafe.getObject(obj, Q), false);
                    i19 += f11;
                    break;
                case 35:
                    i14 = d1.i((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 36:
                    i14 = d1.g((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 37:
                    i14 = d1.n((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 38:
                    i14 = d1.y((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 39:
                    i14 = d1.l((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 40:
                    i14 = d1.i((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 41:
                    i14 = d1.g((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 42:
                    i14 = d1.b((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 43:
                    i14 = d1.w((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 44:
                    i14 = d1.e((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 45:
                    i14 = d1.g((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 46:
                    i14 = d1.i((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case 47:
                    i14 = d1.r((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                    i14 = d1.t((List) unsafe.getObject(obj, Q));
                    if (i14 > 0) {
                        if (this.f8972i) {
                            unsafe.putInt(obj, i21, i14);
                        }
                        S = CodedOutputStream.S(P);
                        U = CodedOutputStream.U(i14);
                        I = S + U + i14;
                        i19 += I;
                    }
                    break;
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    e11 = d1.j(P, (List) unsafe.getObject(obj, Q), p(i18));
                    i19 += e11;
                    break;
                case 50:
                    e11 = this.f8980q.getSerializedSize(P, unsafe.getObject(obj, Q), o(i18));
                    i19 += e11;
                    break;
                case AD_REWARD_USER_VALUE:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.j(P, 0.0d);
                        i19 += e11;
                    }
                    break;
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.r(P, 0.0f);
                        i19 += e11;
                    }
                    break;
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.y(P, V(obj, Q));
                        i19 += e11;
                    }
                    break;
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.V(P, V(obj, Q));
                        i19 += e11;
                    }
                    break;
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.w(P, U(obj, Q));
                        i19 += e11;
                    }
                    break;
                case AD_VISIBILITY_VALUE:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.p(P, 0L);
                        i19 += e11;
                    }
                    break;
                case 57:
                    if (C(obj, P, i18)) {
                        I = CodedOutputStream.n(P, 0);
                        i19 += I;
                    }
                    break;
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.e(P, true);
                        i19 += e11;
                    }
                    break;
                case 59:
                    if (C(obj, P, i18)) {
                        Object object2 = unsafe.getObject(obj, Q);
                        e11 = object2 instanceof ByteString ? CodedOutputStream.h(P, (ByteString) object2) : CodedOutputStream.Q(P, (String) object2);
                        i19 += e11;
                    }
                    break;
                case 60:
                    if (C(obj, P, i18)) {
                        e11 = d1.o(P, unsafe.getObject(obj, Q), p(i18));
                        i19 += e11;
                    }
                    break;
                case 61:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.h(P, (ByteString) unsafe.getObject(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 62:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.T(P, U(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 63:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.l(P, U(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 64:
                    if (C(obj, P, i18)) {
                        I = CodedOutputStream.I(P, 0);
                        i19 += I;
                    }
                    break;
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.K(P, 0L);
                        i19 += e11;
                    }
                    break;
                case 66:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.M(P, U(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 67:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.O(P, V(obj, Q));
                        i19 += e11;
                    }
                    break;
                case 68:
                    if (C(obj, P, i18)) {
                        e11 = CodedOutputStream.t(P, (n0) unsafe.getObject(obj, Q), p(i18));
                        i19 += e11;
                    }
                    break;
            }
            i18 += 3;
            i16 = i11;
            i17 = i12;
            i15 = 1048575;
        }
        int r11 = i19 + r(this.f8978o, obj);
        return this.f8969f ? r11 + this.f8979p.c(obj).i() : r11;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.b1
    public int hashCode(Object obj) {
        int i11;
        int f11;
        int length = this.f8964a.length;
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13 += 3) {
            int o02 = o0(i13);
            int P = P(i13);
            long Q = Q(o02);
            int i14 = 37;
            switch (n0(o02)) {
                case 0:
                    i11 = i12 * 53;
                    f11 = w.f(Double.doubleToLongBits(k1.A(obj, Q)));
                    i12 = i11 + f11;
                    break;
                case 1:
                    i11 = i12 * 53;
                    f11 = Float.floatToIntBits(k1.B(obj, Q));
                    i12 = i11 + f11;
                    break;
                case 2:
                    i11 = i12 * 53;
                    f11 = w.f(k1.E(obj, Q));
                    i12 = i11 + f11;
                    break;
                case 3:
                    i11 = i12 * 53;
                    f11 = w.f(k1.E(obj, Q));
                    i12 = i11 + f11;
                    break;
                case 4:
                    i11 = i12 * 53;
                    f11 = k1.C(obj, Q);
                    i12 = i11 + f11;
                    break;
                case 5:
                    i11 = i12 * 53;
                    f11 = w.f(k1.E(obj, Q));
                    i12 = i11 + f11;
                    break;
                case 6:
                    i11 = i12 * 53;
                    f11 = k1.C(obj, Q);
                    i12 = i11 + f11;
                    break;
                case 7:
                    i11 = i12 * 53;
                    f11 = w.c(k1.t(obj, Q));
                    i12 = i11 + f11;
                    break;
                case 8:
                    i11 = i12 * 53;
                    f11 = ((String) k1.G(obj, Q)).hashCode();
                    i12 = i11 + f11;
                    break;
                case 9:
                    Object G = k1.G(obj, Q);
                    if (G != null) {
                        i14 = G.hashCode();
                    }
                    i12 = (i12 * 53) + i14;
                    break;
                case 10:
                    i11 = i12 * 53;
                    f11 = k1.G(obj, Q).hashCode();
                    i12 = i11 + f11;
                    break;
                case 11:
                    i11 = i12 * 53;
                    f11 = k1.C(obj, Q);
                    i12 = i11 + f11;
                    break;
                case 12:
                    i11 = i12 * 53;
                    f11 = k1.C(obj, Q);
                    i12 = i11 + f11;
                    break;
                case 13:
                    i11 = i12 * 53;
                    f11 = k1.C(obj, Q);
                    i12 = i11 + f11;
                    break;
                case 14:
                    i11 = i12 * 53;
                    f11 = w.f(k1.E(obj, Q));
                    i12 = i11 + f11;
                    break;
                case 15:
                    i11 = i12 * 53;
                    f11 = k1.C(obj, Q);
                    i12 = i11 + f11;
                    break;
                case 16:
                    i11 = i12 * 53;
                    f11 = w.f(k1.E(obj, Q));
                    i12 = i11 + f11;
                    break;
                case 17:
                    Object G2 = k1.G(obj, Q);
                    if (G2 != null) {
                        i14 = G2.hashCode();
                    }
                    i12 = (i12 * 53) + i14;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case NOTIFICATION_REDIRECT_VALUE:
                case 30:
                case TEMPLATE_HTML_SIZE_VALUE:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                    i11 = i12 * 53;
                    f11 = k1.G(obj, Q).hashCode();
                    i12 = i11 + f11;
                    break;
                case 50:
                    i11 = i12 * 53;
                    f11 = k1.G(obj, Q).hashCode();
                    i12 = i11 + f11;
                    break;
                case AD_REWARD_USER_VALUE:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = w.f(Double.doubleToLongBits(S(obj, Q)));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case AD_REQUIRED_DOWNLOAD_DURATION_MS_VALUE:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = Float.floatToIntBits(T(obj, Q));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case AD_OPTIONAL_DOWNLOAD_DURATION_MS_VALUE:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = w.f(V(obj, Q));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case AD_BACKGROUND_BEFORE_IMPRESSION_VALUE:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = w.f(V(obj, Q));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case AD_CLOSED_BEFORE_IMPRESSION_VALUE:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = U(obj, Q);
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case AD_VISIBILITY_VALUE:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = w.f(V(obj, Q));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = U(obj, Q);
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case INIT_TO_FAIL_CALLBACK_DURATION_MS_VALUE:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = w.c(R(obj, Q));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = ((String) k1.G(obj, Q)).hashCode();
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = k1.G(obj, Q).hashCode();
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = k1.G(obj, Q).hashCode();
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = U(obj, Q);
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 63:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = U(obj, Q);
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 64:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = U(obj, Q);
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH /* 65 */:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = w.f(V(obj, Q));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = U(obj, Q);
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = w.f(V(obj, Q));
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (C(obj, P, i13)) {
                        i11 = i12 * 53;
                        f11 = k1.G(obj, Q).hashCode();
                        i12 = i11 + f11;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i12 * 53) + this.f8978o.g(obj).hashCode();
        return this.f8969f ? (hashCode * 53) + this.f8979p.c(obj).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public final boolean isInitialized(Object obj) {
        int i11;
        int i12;
        int i13 = 1048575;
        int i14 = 0;
        int i15 = 0;
        while (i15 < this.f8974k) {
            int i16 = this.f8973j[i15];
            int P = P(i16);
            int o02 = o0(i16);
            int i17 = this.f8964a[i16 + 2];
            int i18 = i17 & 1048575;
            int i19 = 1 << (i17 >>> 20);
            if (i18 != i13) {
                if (i18 != 1048575) {
                    i14 = f8963s.getInt(obj, i18);
                }
                i12 = i14;
                i11 = i18;
            } else {
                i11 = i13;
                i12 = i14;
            }
            if (D(o02) && !v(obj, i16, i11, i12, i19)) {
                return false;
            }
            int n02 = n0(o02);
            if (n02 != 9 && n02 != 17) {
                if (n02 != 27) {
                    if (n02 == 60 || n02 == 68) {
                        if (C(obj, P, i16) && !w(obj, o02, p(i16))) {
                            return false;
                        }
                    } else if (n02 != 49) {
                        if (n02 == 50 && !z(obj, o02, i16)) {
                            return false;
                        }
                    }
                }
                if (!y(obj, o02, i16)) {
                    return false;
                }
            } else if (v(obj, i16, i11, i12, i19) && !w(obj, o02, p(i16))) {
                return false;
            }
            i15++;
            i13 = i11;
            i14 = i12;
        }
        return !this.f8969f || this.f8979p.c(obj).m();
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void makeImmutable(Object obj) {
        if (A(obj)) {
            if (obj instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) obj;
                generatedMessageLite.l();
                generatedMessageLite.k();
                generatedMessageLite.B();
            }
            int length = this.f8964a.length;
            for (int i11 = 0; i11 < length; i11 += 3) {
                int o02 = o0(i11);
                long Q = Q(o02);
                int n02 = n0(o02);
                if (n02 != 9) {
                    if (n02 != 60 && n02 != 68) {
                        switch (n02) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case NOTIFICATION_REDIRECT_VALUE:
                            case 30:
                            case TEMPLATE_HTML_SIZE_VALUE:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE:
                            case AD_VALIDATION_TO_PRESENT_DURATION_MS_VALUE:
                                this.f8977n.a(obj, Q);
                                break;
                            case 50:
                                Unsafe unsafe = f8963s;
                                Object object = unsafe.getObject(obj, Q);
                                if (object != null) {
                                    unsafe.putObject(obj, Q, this.f8980q.toImmutable(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (C(obj, P(i11), i11)) {
                        p(i11).makeImmutable(f8963s.getObject(obj, Q));
                    }
                }
                if (u(obj, i11)) {
                    p(i11).makeImmutable(f8963s.getObject(obj, Q));
                }
            }
            this.f8978o.j(obj);
            if (this.f8969f) {
                this.f8979p.f(obj);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public void mergeFrom(Object obj, Object obj2) {
        f(obj);
        obj2.getClass();
        for (int i11 = 0; i11 < this.f8964a.length; i11 += 3) {
            J(obj, obj2, i11);
        }
        d1.F(this.f8978o, obj, obj2);
        if (this.f8969f) {
            d1.D(this.f8979p, obj, obj2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.b1
    public Object newInstance() {
        return this.f8976m.newInstance(this.f8968e);
    }
}
