package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.work.impl.constraints.b;
import androidx.work.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class k extends ConnectivityManager.NetworkCallback {

    /* renamed from: a, reason: collision with root package name */
    public static final k f15707a = new k();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f15708b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final Map f15709c = new LinkedHashMap();

    /* renamed from: d, reason: collision with root package name */
    private static NetworkCapabilities f15710d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f15711e;

    /* renamed from: f, reason: collision with root package name */
    private static Boolean f15712f;

    private k() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit c(Function1 function1, ConnectivityManager connectivityManager) {
        String str;
        synchronized (f15708b) {
            Map map = f15709c;
            map.remove(function1);
            if (map.isEmpty()) {
                t e11 = t.e();
                str = WorkConstraintsTrackerKt.f15671a;
                e11.a(str, "NetworkRequestConstraintController unregister shared callback");
                connectivityManager.unregisterNetworkCallback(f15707a);
                f15712f = null;
                f15710d = null;
                f15711e = false;
            }
        }
        return Unit.f67184a;
    }

    private final boolean d(NetworkRequest networkRequest, NetworkCapabilities networkCapabilities) {
        boolean canBeSatisfiedBy;
        Boolean bool = f15712f;
        Intrinsics.e(bool);
        if (!bool.booleanValue()) {
            canBeSatisfiedBy = networkRequest.canBeSatisfiedBy(networkCapabilities);
            if (canBeSatisfiedBy) {
                return true;
            }
        }
        return false;
    }

    private final void e() {
        String str;
        ArrayList<Pair> arrayList = new ArrayList();
        synchronized (f15708b) {
            try {
                if (f15711e && f15712f != null) {
                    for (Map.Entry entry : f15709c.entrySet()) {
                        arrayList.add(TuplesKt.a((Function1) entry.getKey(), f15707a.d((NetworkRequest) entry.getValue(), f15710d) ? b.a.f15674a : new b.C0142b(7)));
                    }
                    Unit unit = Unit.f67184a;
                    for (Pair pair : arrayList) {
                        ((Function1) pair.component1()).invoke((b) pair.component2());
                    }
                    return;
                }
                t e11 = t.e();
                str = WorkConstraintsTrackerKt.f15671a;
                e11.a(str, "Not dispatching constraint state yet: isBlocked=" + f15712f + ", capabilitiesInitialized=" + f15711e);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Function0 b(final ConnectivityManager connManager, NetworkRequest networkRequest, final Function1 onConstraintState) {
        String str;
        String str2;
        Intrinsics.h(connManager, "connManager");
        Intrinsics.h(networkRequest, "networkRequest");
        Intrinsics.h(onConstraintState, "onConstraintState");
        synchronized (f15708b) {
            try {
                Map map = f15709c;
                boolean isEmpty = map.isEmpty();
                map.put(onConstraintState, networkRequest);
                if (isEmpty) {
                    t e11 = t.e();
                    str2 = WorkConstraintsTrackerKt.f15671a;
                    e11.a(str2, "NetworkRequestConstraintController register shared callback");
                    connManager.registerDefaultNetworkCallback(f15707a);
                } else if (f15711e && f15712f != null) {
                    t e12 = t.e();
                    str = WorkConstraintsTrackerKt.f15671a;
                    e12.a(str, "NetworkRequestConstraintController send initial capabilities");
                    onConstraintState.invoke(f15707a.d(networkRequest, f15710d) ? b.a.f15674a : new b.C0142b(7));
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return new Function0() { // from class: androidx.work.impl.constraints.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit c11;
                c11 = k.c(Function1.this, connManager);
                return c11;
            }
        };
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network network, boolean z10) {
        String str;
        Intrinsics.h(network, "network");
        t e11 = t.e();
        str = WorkConstraintsTrackerKt.f15671a;
        e11.a(str, "NetworkRequestConstraintController onBlockedStatusChanged callback " + z10);
        synchronized (f15708b) {
            if (Intrinsics.c(f15712f, Boolean.valueOf(z10))) {
                return;
            }
            f15712f = Boolean.valueOf(z10);
            Unit unit = Unit.f67184a;
            e();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        t e11 = t.e();
        str = WorkConstraintsTrackerKt.f15671a;
        e11.a(str, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (f15708b) {
            f15710d = networkCapabilities;
            f15711e = true;
            Unit unit = Unit.f67184a;
        }
        e();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str;
        Intrinsics.h(network, "network");
        t e11 = t.e();
        str = WorkConstraintsTrackerKt.f15671a;
        e11.a(str, "NetworkRequestConstraintController onLost callback");
        synchronized (f15708b) {
            try {
                f15710d = null;
                Iterator it = f15709c.keySet().iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(new b.C0142b(7));
                }
                Unit unit = Unit.f67184a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
