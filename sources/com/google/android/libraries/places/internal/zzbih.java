package com.google.android.libraries.places.internal;

import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public final class zzbih extends zzbcv {
    static final boolean zza;
    static final boolean zzb;
    protected static final boolean zzc;
    private static final Logger zzg;
    private static final Set zzh;
    private static final String zzi;
    private static final String zzj;
    private static final String zzk;
    private static final zzbig zzl;
    private static String zzm;
    private boolean zzA;
    private zzbcr zzB;
    final zzbde zzd;
    protected boolean zzf;
    private final String zzp;
    private final String zzq;
    private final int zzr;
    private final zzbql zzs;
    private final long zzt;
    private final zzbdw zzu;
    private final zzna zzv;
    private boolean zzw;
    private Executor zzx;
    private final boolean zzy;
    private final zzbcu zzz;
    private final Random zzn = new Random();
    protected volatile zzbhz zze = zzbic.INSTANCE;
    private final AtomicReference zzo = new AtomicReference();

    static {
        Logger logger = Logger.getLogger(zzbih.class.getName());
        zzg = logger;
        zzh = Collections.unmodifiableSet(new HashSet(Arrays.asList("clientLanguage", "percentage", "clientHostname", "serviceConfig")));
        String property = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi", "true");
        zzi = property;
        String property2 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_jndi_localhost", "false");
        zzj = property2;
        String property3 = System.getProperty("io.grpc.internal.DnsNameResolverProvider.enable_service_config", "false");
        zzk = property3;
        zza = Boolean.parseBoolean(property);
        zzb = Boolean.parseBoolean(property2);
        zzc = Boolean.parseBoolean(property3);
        zzbig zzbigVar = null;
        try {
            try {
                try {
                    zzbig zzbigVar2 = (zzbig) Class.forName("io.grpc.internal.JndiResourceResolverFactory", true, zzbih.class.getClassLoader()).asSubclass(zzbig.class).getConstructor(null).newInstance(null);
                    if (zzbigVar2.zzb() != null) {
                        logger.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "JndiResourceResolverFactory not available, skipping.", zzbigVar2.zzb());
                    } else {
                        zzbigVar = zzbigVar2;
                    }
                } catch (Exception e11) {
                    zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't construct JndiResourceResolverFactory, skipping.", (Throwable) e11);
                }
            } catch (Exception e12) {
                zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Can't find JndiResourceResolverFactory ctor, skipping.", (Throwable) e12);
            }
        } catch (ClassCastException e13) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to cast JndiResourceResolverFactory, skipping.", (Throwable) e13);
        } catch (ClassNotFoundException e14) {
            zzg.logp(Level.FINE, "io.grpc.internal.DnsNameResolver", "getResourceResolverFactory", "Unable to find JndiResourceResolverFactory, skipping.", (Throwable) e14);
        }
        zzl = zzbigVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbih(String str, String str2, zzbco zzbcoVar, zzbql zzbqlVar, zzna zznaVar, boolean z10) {
        zzmt.zzc(zzbcoVar, NativeComponentConstants.KEY_COMPONENT_EVENT_ARGS);
        this.zzs = zzbqlVar;
        zzmt.zzc(str2, "name");
        URI create = URI.create("//".concat(str2));
        zzmt.zzj(create.getHost() != null, "Invalid DNS name: %s", str2);
        String authority = create.getAuthority();
        zzmt.zzd(authority, "nameUri (%s) doesn't have an authority", create);
        this.zzp = authority;
        this.zzq = create.getHost();
        if (create.getPort() == -1) {
            this.zzr = zzbcoVar.zza();
        } else {
            this.zzr = create.getPort();
        }
        this.zzd = zzbcoVar.zzd();
        long j11 = 0;
        if (!z10) {
            String property = System.getProperty("networkaddress.cache.ttl");
            long j12 = 30;
            if (property != null) {
                try {
                    j12 = Long.parseLong(property);
                } catch (NumberFormatException unused) {
                    zzg.logp(Level.WARNING, "io.grpc.internal.DnsNameResolver", "getNetworkAddressCacheTtlNanos", "Property({0}) valid is not valid number format({1}), fall back to default({2})", new Object[]{"networkaddress.cache.ttl", property, 30L});
                }
            }
            j11 = j12 > 0 ? TimeUnit.SECONDS.toNanos(j12) : j12;
        }
        this.zzt = j11;
        this.zzv = zznaVar;
        this.zzu = zzbcoVar.zze();
        Executor zzf = zzbcoVar.zzf();
        this.zzx = zzf;
        this.zzy = zzf == null;
        this.zzz = zzbcoVar.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zzazs zzg(zzbih zzbihVar) {
        zzbdd zza2 = zzbihVar.zzd.zza(InetSocketAddress.createUnresolved(zzbihVar.zzq, zzbihVar.zzr));
        if (zza2 == null) {
            return null;
        }
        return new zzazs(Collections.singletonList(zza2), zzaye.zza);
    }

    private static String zzm() {
        if (zzm == null) {
            try {
                zzm = InetAddress.getLocalHost().getHostName();
            } catch (UnknownHostException e11) {
                throw new RuntimeException(e11);
            }
        }
        return zzm;
    }

    private final void zzn() {
        if (this.zzA || this.zzw) {
            return;
        }
        if (this.zzf) {
            long j11 = this.zzt;
            if (j11 != 0 && (j11 <= 0 || this.zzv.zza(TimeUnit.NANOSECONDS) <= this.zzt)) {
                return;
            }
        }
        this.zzA = true;
        this.zzx.execute(new zzbie(this, this.zzB));
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final String zza() {
        return this.zzp;
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final void zzb() {
        zzmt.zzp(this.zzB != null, "not started");
        zzn();
    }

    @Override // com.google.android.libraries.places.internal.zzbcv
    public final void zzc() {
        if (this.zzw) {
            return;
        }
        this.zzw = true;
        Executor executor = this.zzx;
        if (executor == null || !this.zzy) {
            return;
        }
        zzbqm.zzc(this.zzs, executor);
        this.zzx = null;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [java.util.concurrent.Executor, java.lang.Object] */
    @Override // com.google.android.libraries.places.internal.zzbcv
    public final void zzd(zzbcr zzbcrVar) {
        zzmt.zzp(this.zzB == null, "already started");
        if (this.zzy) {
            this.zzx = zzbqm.zza(this.zzs);
        }
        this.zzB = zzbcrVar;
        zzn();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x006d, code lost:
    
        if (r9 == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x009a, code lost:
    
        r0 = (com.google.android.libraries.places.internal.zzbif) r18.zzo.get();
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00a2, code lost:
    
        if (r0 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00a4, code lost:
    
        r8 = com.google.android.libraries.places.internal.zzbih.zzl;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00a6, code lost:
    
        if (r8 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00a8, code lost:
    
        r0 = r8.zza();
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0097, code lost:
    
        if (r9 != false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01db A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:77:? A[LOOP:2: B:41:0x0131->B:77:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.libraries.places.internal.zzbib zzi(boolean r19) {
        /*
            Method dump skipped, instructions count: 648
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.places.internal.zzbih.zzi(boolean):com.google.android.libraries.places.internal.zzbib");
    }
}
