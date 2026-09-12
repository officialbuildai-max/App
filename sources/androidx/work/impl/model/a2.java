package androidx.work.impl.model;

import android.net.NetworkRequest;
import android.net.Uri;
import android.os.Build;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.d;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a2 {

    /* renamed from: a, reason: collision with root package name */
    public static final a2 f15797a = new a2();

    /* loaded from: classes2.dex */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15798a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f15799b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f15800c;

        /* renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int[] f15801d;

        static {
            int[] iArr = new int[WorkInfo.State.values().length];
            try {
                iArr[WorkInfo.State.ENQUEUED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WorkInfo.State.RUNNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WorkInfo.State.SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WorkInfo.State.FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WorkInfo.State.BLOCKED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WorkInfo.State.CANCELLED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f15798a = iArr;
            int[] iArr2 = new int[BackoffPolicy.values().length];
            try {
                iArr2[BackoffPolicy.EXPONENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[BackoffPolicy.LINEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            f15799b = iArr2;
            int[] iArr3 = new int[NetworkType.values().length];
            try {
                iArr3[NetworkType.NOT_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[NetworkType.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr3[NetworkType.UNMETERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr3[NetworkType.NOT_ROAMING.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr3[NetworkType.METERED.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            f15800c = iArr3;
            int[] iArr4 = new int[OutOfQuotaPolicy.values().length];
            try {
                iArr4[OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr4[OutOfQuotaPolicy.DROP_WORK_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused15) {
            }
            f15801d = iArr4;
        }
    }

    private a2() {
    }

    public static final int a(BackoffPolicy backoffPolicy) {
        Intrinsics.h(backoffPolicy, "backoffPolicy");
        int i11 = a.f15799b[backoffPolicy.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final Set b(byte[] bytes) {
        ObjectInputStream objectInputStream;
        Intrinsics.h(bytes, "bytes");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (bytes.length == 0) {
            return linkedHashSet;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(byteArrayInputStream, th2);
                    throw th3;
                }
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        try {
            int readInt = objectInputStream.readInt();
            for (int i11 = 0; i11 < readInt; i11++) {
                Uri parse = Uri.parse(objectInputStream.readUTF());
                boolean readBoolean = objectInputStream.readBoolean();
                Intrinsics.e(parse);
                linkedHashSet.add(new d.c(parse, readBoolean));
            }
            Unit unit = Unit.f67184a;
            CloseableKt.a(objectInputStream, null);
            Unit unit2 = Unit.f67184a;
            CloseableKt.a(byteArrayInputStream, null);
            return linkedHashSet;
        } finally {
        }
    }

    public static final byte[] c(androidx.work.impl.utils.v requestCompat) {
        Intrinsics.h(requestCompat, "requestCompat");
        if (Build.VERSION.SDK_INT < 28) {
            return new byte[0];
        }
        NetworkRequest b11 = requestCompat.b();
        if (b11 == null) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                int[] c11 = androidx.work.impl.utils.w.c(b11);
                int[] b12 = androidx.work.impl.utils.w.b(b11);
                objectOutputStream.writeInt(c11.length);
                for (int i11 : c11) {
                    objectOutputStream.writeInt(i11);
                }
                objectOutputStream.writeInt(b12.length);
                for (int i12 : b12) {
                    objectOutputStream.writeInt(i12);
                }
                Unit unit = Unit.f67184a;
                CloseableKt.a(objectOutputStream, null);
                CloseableKt.a(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.g(byteArray, "toByteArray(...)");
                return byteArray;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(byteArrayOutputStream, th2);
                throw th3;
            }
        }
    }

    public static final BackoffPolicy d(int i11) {
        if (i11 == 0) {
            return BackoffPolicy.EXPONENTIAL;
        }
        if (i11 == 1) {
            return BackoffPolicy.LINEAR;
        }
        throw new IllegalArgumentException("Could not convert " + i11 + " to BackoffPolicy");
    }

    public static final NetworkType e(int i11) {
        if (i11 == 0) {
            return NetworkType.NOT_REQUIRED;
        }
        if (i11 == 1) {
            return NetworkType.CONNECTED;
        }
        if (i11 == 2) {
            return NetworkType.UNMETERED;
        }
        if (i11 == 3) {
            return NetworkType.NOT_ROAMING;
        }
        if (i11 == 4) {
            return NetworkType.METERED;
        }
        if (Build.VERSION.SDK_INT >= 30 && i11 == 5) {
            return NetworkType.TEMPORARILY_UNMETERED;
        }
        throw new IllegalArgumentException("Could not convert " + i11 + " to NetworkType");
    }

    public static final OutOfQuotaPolicy f(int i11) {
        if (i11 == 0) {
            return OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        }
        if (i11 == 1) {
            return OutOfQuotaPolicy.DROP_WORK_REQUEST;
        }
        throw new IllegalArgumentException("Could not convert " + i11 + " to OutOfQuotaPolicy");
    }

    public static final WorkInfo.State g(int i11) {
        if (i11 == 0) {
            return WorkInfo.State.ENQUEUED;
        }
        if (i11 == 1) {
            return WorkInfo.State.RUNNING;
        }
        if (i11 == 2) {
            return WorkInfo.State.SUCCEEDED;
        }
        if (i11 == 3) {
            return WorkInfo.State.FAILED;
        }
        if (i11 == 4) {
            return WorkInfo.State.BLOCKED;
        }
        if (i11 == 5) {
            return WorkInfo.State.CANCELLED;
        }
        throw new IllegalArgumentException("Could not convert " + i11 + " to State");
    }

    public static final int h(NetworkType networkType) {
        Intrinsics.h(networkType, "networkType");
        int i11 = a.f15800c[networkType.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        int i12 = 2;
        if (i11 == 2) {
            return 1;
        }
        if (i11 != 3) {
            i12 = 4;
            if (i11 == 4) {
                return 3;
            }
            if (i11 != 5) {
                if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
                    return 5;
                }
                throw new IllegalArgumentException("Could not convert " + networkType + " to int");
            }
        }
        return i12;
    }

    public static final int i(OutOfQuotaPolicy policy) {
        Intrinsics.h(policy, "policy");
        int i11 = a.f15801d[policy.ordinal()];
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final byte[] j(Set triggers) {
        Intrinsics.h(triggers, "triggers");
        if (triggers.isEmpty()) {
            return new byte[0];
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            try {
                objectOutputStream.writeInt(triggers.size());
                Iterator it = triggers.iterator();
                while (it.hasNext()) {
                    d.c cVar = (d.c) it.next();
                    objectOutputStream.writeUTF(cVar.a().toString());
                    objectOutputStream.writeBoolean(cVar.b());
                }
                Unit unit = Unit.f67184a;
                CloseableKt.a(objectOutputStream, null);
                CloseableKt.a(byteArrayOutputStream, null);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.g(byteArray, "toByteArray(...)");
                return byteArray;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(byteArrayOutputStream, th2);
                throw th3;
            }
        }
    }

    public static final int k(WorkInfo.State state) {
        Intrinsics.h(state, "state");
        switch (a.f15798a[state.ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final androidx.work.impl.utils.v l(byte[] bytes) {
        Intrinsics.h(bytes, "bytes");
        if (Build.VERSION.SDK_INT < 28 || bytes.length == 0) {
            return new androidx.work.impl.utils.v(null);
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            try {
                int readInt = objectInputStream.readInt();
                int[] iArr = new int[readInt];
                for (int i11 = 0; i11 < readInt; i11++) {
                    iArr[i11] = objectInputStream.readInt();
                }
                int readInt2 = objectInputStream.readInt();
                int[] iArr2 = new int[readInt2];
                for (int i12 = 0; i12 < readInt2; i12++) {
                    iArr2[i12] = objectInputStream.readInt();
                }
                androidx.work.impl.utils.v b11 = androidx.work.impl.utils.r.f16075a.b(iArr2, iArr);
                CloseableKt.a(objectInputStream, null);
                CloseableKt.a(byteArrayInputStream, null);
                return b11;
            } finally {
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(byteArrayInputStream, th2);
                throw th3;
            }
        }
    }
}
