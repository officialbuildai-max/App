package com.tmc.network.strategy;

import android.content.Context;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tmc.network.NetworkConfig;
import com.tmc.network.NetworkMonitor;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Dns;

/* loaded from: classes5.dex */
public final class LocalDnsStrategy implements Dns {

    /* renamed from: c, reason: collision with root package name */
    public static final a f40858c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f40859d = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap f40860a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private AtomicBoolean f40861b = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LocalDnsStrategy a() {
            return b.f40862a.a();
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f40862a = new b();

        /* renamed from: b, reason: collision with root package name */
        private static final LocalDnsStrategy f40863b = new LocalDnsStrategy();

        private b() {
        }

        public final LocalDnsStrategy a() {
            return f40863b;
        }
    }

    /* loaded from: classes5.dex */
    public final class c implements NetworkMonitor.INetworkChangeListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocalDnsStrategy f40864a;

        public c(LocalDnsStrategy this$0) {
            Intrinsics.h(this$0, "this$0");
            this.f40864a = this$0;
        }

        @Override // com.tmc.network.NetworkMonitor.INetworkChangeListener
        public void onNetworkChanged(NetworkMonitor.NetworkStatus status) {
            Intrinsics.h(status, "status");
            this.f40864a.j();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v10, types: [com.tmc.network.strategy.StrategyTable, T, java.lang.Object] */
    private final List f(final String str) {
        try {
            String networkId = NetworkMonitor.INSTANCE.getNetworkId();
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            ?? r32 = this.f40860a.get(networkId);
            objectRef.element = r32;
            if (r32 == 0) {
                ?? strategyTable = new StrategyTable(networkId);
                objectRef.element = strategyTable;
                this.f40860a.put(networkId, strategyTable);
            }
            List<InetAddress> queryStrategyList = ((StrategyTable) objectRef.element).queryStrategyList(str);
            List<InetAddress> list = queryStrategyList;
            if (list != null && !list.isEmpty()) {
                gg.c a11 = gg.c.f63695c.a();
                if (a11 != null) {
                    a11.a(new Runnable() { // from class: com.tmc.network.strategy.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            LocalDnsStrategy.g(Ref.ObjectRef.this, str, this);
                        }
                    });
                }
                return queryStrategyList;
            }
            InetAddress[] ips = InetAddress.getAllByName(str);
            if (ips != null && ips.length != 0) {
                StrategyTable strategyTable2 = (StrategyTable) objectRef.element;
                Intrinsics.g(ips, "ips");
                strategyTable2.addStrategyList(str, ArraysKt.O0(ips));
                l();
                return ArraysKt.K0(ips);
            }
            return null;
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(Ref.ObjectRef table, String host, LocalDnsStrategy this$0) {
        Intrinsics.h(table, "$table");
        Intrinsics.h(host, "$host");
        Intrinsics.h(this$0, "this$0");
        try {
            if (((StrategyTable) table.element).checkIsExpire(host)) {
                ((StrategyTable) table.element).removeStrategy(host);
                InetAddress[] ips = InetAddress.getAllByName(host);
                if (ips != null && ips.length != 0) {
                    StrategyTable strategyTable = (StrategyTable) table.element;
                    Intrinsics.g(ips, "ips");
                    strategyTable.addStrategyList(host, ArraysKt.O0(ips));
                    this$0.l();
                }
            }
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        final String networkId = NetworkMonitor.INSTANCE.getNetworkId();
        if (this.f40860a.get(networkId) != null) {
            gg.b.f63690a.c("map already has this strategy.");
            return;
        }
        gg.c a11 = gg.c.f63695c.a();
        if (a11 == null) {
            return;
        }
        a11.b(new Runnable() { // from class: com.tmc.network.strategy.b
            @Override // java.lang.Runnable
            public final void run() {
                LocalDnsStrategy.k(networkId, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(String netId, LocalDnsStrategy this$0) {
        Intrinsics.h(netId, "$netId");
        Intrinsics.h(this$0, "this$0");
        if (Intrinsics.c(netId, TmcConstants.ROUTE_UNKNOWN)) {
            gg.b.f63690a.c("network is invalid.");
            return;
        }
        fg.b bVar = fg.b.f62513a;
        StrategyTable strategyTable = (StrategyTable) bVar.l(netId);
        if (strategyTable == null) {
            return;
        }
        strategyTable.removeExpired();
        StrategyTable strategyTable2 = (StrategyTable) this$0.f40860a.get(netId);
        if (strategyTable2 != null) {
            strategyTable.convertTable(strategyTable2);
        }
        this$0.f40860a.put(netId, strategyTable);
        gg.b.f63690a.c(Intrinsics.q("restore file ", strategyTable));
        bVar.j();
    }

    private final void l() {
        gg.c a11;
        if (!f40859d.compareAndSet(false, true) || (a11 = gg.c.f63695c.a()) == null) {
            return;
        }
        a11.d(new Runnable() { // from class: com.tmc.network.strategy.LocalDnsStrategy$updateLocalDnsStrategy$1
            @Override // java.lang.Runnable
            public void run() {
                AtomicBoolean atomicBoolean;
                ConcurrentHashMap concurrentHashMap;
                try {
                    atomicBoolean = LocalDnsStrategy.f40859d;
                    atomicBoolean.set(false);
                    String networkId = NetworkMonitor.INSTANCE.getNetworkId();
                    concurrentHashMap = LocalDnsStrategy.this.f40860a;
                    StrategyTable strategyTable = (StrategyTable) concurrentHashMap.get(networkId);
                    if (strategyTable == null) {
                        return;
                    }
                    gg.b.f63690a.c(Intrinsics.q("updateLocalDnsStrategy  table = ", strategyTable));
                    fg.b.f62513a.i(strategyTable, networkId);
                } catch (Throwable th2) {
                    gg.b.f63690a.e(th2);
                }
            }
        }, 2000L, TimeUnit.MILLISECONDS);
    }

    public final void h(Context context) {
        Intrinsics.h(context, "context");
        try {
            if (this.f40861b.compareAndSet(false, true)) {
                j();
                NetworkMonitor.INSTANCE.registerListener(new c(this));
            }
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
        }
    }

    public final void i(String host, InetAddress address) {
        Intrinsics.h(host, "host");
        Intrinsics.h(address, "address");
        try {
            StrategyTable strategyTable = (StrategyTable) this.f40860a.get(NetworkMonitor.INSTANCE.getNetworkId());
            if (strategyTable == null) {
                return;
            }
            strategyTable.removeStrategy(host, address);
            l();
        } catch (Throwable th2) {
            gg.b.f63690a.e(th2);
        }
    }

    @Override // okhttp3.Dns
    public List lookup(String hostname) {
        Intrinsics.h(hostname, "hostname");
        if (this.f40861b.get() && NetworkConfig.INSTANCE.isNetworkImproveEnable()) {
            List f11 = f(hostname);
            if (f11 != null) {
                return f11;
            }
            throw new UnknownHostException(hostname);
        }
        try {
            return Dns.SYSTEM.lookup(hostname);
        } catch (Throwable th2) {
            gg.b.f63690a.d("LocalDnsStrategy", th2.getMessage());
            throw new UnknownHostException(hostname);
        }
    }
}
