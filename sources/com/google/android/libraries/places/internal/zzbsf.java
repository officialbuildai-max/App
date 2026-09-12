package com.google.android.libraries.places.internal;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.libraries.places.api.model.PlaceTypes;
import java.io.EOFException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.internal.http2.Settings;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzbsf implements zzbgf, zzbrj, zzbsr {
    private static final Map zzc;
    private static final Logger zzd;
    private boolean zzA;
    private zzbjh zzB;
    private boolean zzC;
    private boolean zzD;
    private final SocketFactory zzE;
    private SSLSocketFactory zzF;
    private Socket zzG;
    private int zzH;
    private final Deque zzI;
    private final zzbsz zzJ;
    private zzbkh zzK;
    private final Runnable zzL;
    private final int zzM;
    private final zzbqz zzN;
    private final zzbji zzO;
    private zzbaf zzP;
    final zzbaa zza;
    int zzb;
    private final InetSocketAddress zze;
    private final String zzf;
    private final String zzg;
    private final Random zzh;
    private final zznc zzi;
    private final int zzj;
    private final zzbuf zzk;
    private zzbmk zzl;
    private zzbrk zzm;
    private zzbsu zzn;
    private final Object zzo;
    private final zzbap zzp;
    private int zzq;
    private final Map zzr;
    private final Executor zzs;
    private final zzbqe zzt;
    private final ScheduledExecutorService zzu;
    private final int zzv;
    private int zzw;
    private zzbse zzx;
    private zzaye zzy;
    private zzbdo zzz;

    static {
        EnumMap enumMap = new EnumMap(zzbtp.class);
        zzbtp zzbtpVar = zzbtp.NO_ERROR;
        zzbdo zzbdoVar = zzbdo.zzo;
        enumMap.put((EnumMap) zzbtpVar, (zzbtp) zzbdoVar.zzg("No error: A GRPC status of OK should have been sent"));
        enumMap.put((EnumMap) zzbtp.PROTOCOL_ERROR, (zzbtp) zzbdoVar.zzg("Protocol error"));
        enumMap.put((EnumMap) zzbtp.INTERNAL_ERROR, (zzbtp) zzbdoVar.zzg("Internal error"));
        enumMap.put((EnumMap) zzbtp.FLOW_CONTROL_ERROR, (zzbtp) zzbdoVar.zzg("Flow control error"));
        enumMap.put((EnumMap) zzbtp.STREAM_CLOSED, (zzbtp) zzbdoVar.zzg("Stream closed"));
        enumMap.put((EnumMap) zzbtp.FRAME_TOO_LARGE, (zzbtp) zzbdoVar.zzg("Frame too large"));
        enumMap.put((EnumMap) zzbtp.REFUSED_STREAM, (zzbtp) zzbdo.zzp.zzg("Refused stream"));
        enumMap.put((EnumMap) zzbtp.CANCEL, (zzbtp) zzbdo.zzb.zzg("Cancelled"));
        enumMap.put((EnumMap) zzbtp.COMPRESSION_ERROR, (zzbtp) zzbdoVar.zzg("Compression error"));
        enumMap.put((EnumMap) zzbtp.CONNECT_ERROR, (zzbtp) zzbdoVar.zzg("Connect error"));
        enumMap.put((EnumMap) zzbtp.ENHANCE_YOUR_CALM, (zzbtp) zzbdo.zzj.zzg("Enhance your calm"));
        enumMap.put((EnumMap) zzbtp.INADEQUATE_SECURITY, (zzbtp) zzbdo.zzh.zzg("Inadequate security"));
        zzc = Collections.unmodifiableMap(enumMap);
        zzd = Logger.getLogger(zzbsf.class.getName());
    }

    public zzbsf(zzbru zzbruVar, InetSocketAddress inetSocketAddress, String str, String str2, zzaye zzayeVar, zzbaa zzbaaVar, Runnable runnable) {
        zznc zzncVar = zzbjd.zzr;
        zzbub zzbubVar = new zzbub();
        this.zzh = new Random();
        Object obj = new Object();
        this.zzo = obj;
        this.zzr = new HashMap();
        this.zzH = 0;
        this.zzI = new LinkedList();
        this.zzO = new zzbrz(this);
        this.zzb = 30000;
        zzmt.zzc(inetSocketAddress, PlaceTypes.ADDRESS);
        this.zze = inetSocketAddress;
        this.zzf = str;
        this.zzv = 4194304;
        this.zzj = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        Executor executor = zzbruVar.zza;
        zzmt.zzc(executor, "executor");
        this.zzs = executor;
        this.zzt = new zzbqe(zzbruVar.zza);
        ScheduledExecutorService scheduledExecutorService = zzbruVar.zzb;
        zzmt.zzc(scheduledExecutorService, "scheduledExecutorService");
        this.zzu = scheduledExecutorService;
        this.zzq = 3;
        this.zzE = SocketFactory.getDefault();
        this.zzF = zzbruVar.zzd;
        zzbsz zzbszVar = zzbruVar.zze;
        zzmt.zzc(zzbszVar, "connectionSpec");
        this.zzJ = zzbszVar;
        zzmt.zzc(zzncVar, "stopwatchFactory");
        this.zzi = zzncVar;
        this.zzk = zzbubVar;
        this.zzg = "grpc-java-okhttp/1.64.0-SNAPSHOT";
        this.zza = zzbaaVar;
        this.zzL = runnable;
        this.zzM = Integer.MAX_VALUE;
        zzbqz zza = zzbruVar.zzc.zza();
        this.zzN = zza;
        this.zzp = zzbap.zzb(zzbsf.class, inetSocketAddress.toString());
        zzayb zza2 = zzaye.zza();
        zza2.zzb(zzbit.zzb, zzayeVar);
        this.zzy = zza2.zzc();
        synchronized (obj) {
            zza.zzf(new zzbsa(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ Socket zzA(zzbsf zzbsfVar, InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) {
        Socket socket;
        int i11;
        String str3;
        try {
            socket = inetSocketAddress2.getAddress() != null ? zzbsfVar.zzE.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : zzbsfVar.zzE.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            try {
                socket.setTcpNoDelay(true);
                socket.setSoTimeout(zzbsfVar.zzb);
                zzbws zzd2 = zzbwh.zzd(socket);
                zzbwc zza = zzbwh.zza(zzbwh.zzc(socket));
                zzbug zzbugVar = new zzbug();
                zzbugVar.zzd("https");
                zzbugVar.zzb(inetSocketAddress.getHostName());
                zzbugVar.zzc(inetSocketAddress.getPort());
                zzbui zze = zzbugVar.zze();
                zzbuj zzbujVar = new zzbuj();
                zzbujVar.zzd(zze);
                zzbujVar.zzc(HttpHeaders.HOST, zze.zzd() + ":" + zze.zzc());
                zzbujVar.zzc("User-Agent", zzbsfVar.zzg);
                if (str != null && str2 != null) {
                    try {
                        byte[] bytes = (str + ":" + str2).getBytes("ISO-8859-1");
                        zzbwe zzbweVar = zzbwf.zza;
                        zzbujVar.zzc("Proxy-Authorization", "Basic " + zzbwe.zzb(bytes).zzd());
                    } catch (UnsupportedEncodingException unused) {
                        throw new AssertionError();
                    }
                }
                zzbul zze2 = zzbujVar.zze();
                zzbui zzb = zze2.zzb();
                zza.zzx(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", zzb.zzd(), Integer.valueOf(zzb.zzc())));
                zza.zzx("\r\n");
                int zza2 = zze2.zza().zza();
                for (int i12 = 0; i12 < zza2; i12++) {
                    zza.zzx(zze2.zza().zzb(i12));
                    zza.zzx(": ");
                    zza.zzx(zze2.zza().zzc(i12));
                    zza.zzx("\r\n");
                }
                zza.zzx("\r\n");
                zza.flush();
                String zzW = zzW(zzd2);
                if (zzW.startsWith("HTTP/1.")) {
                    i11 = 9;
                    if (zzW.length() < 9 || zzW.charAt(8) != ' ') {
                        throw new ProtocolException("Unexpected status line: ".concat(zzW));
                    }
                    int charAt = zzW.charAt(7) - '0';
                    if (charAt == 0) {
                        zzbtm zzbtmVar = zzbtm.HTTP_1_0;
                    } else {
                        if (charAt != 1) {
                            throw new ProtocolException("Unexpected status line: ".concat(zzW));
                        }
                        zzbtm zzbtmVar2 = zzbtm.HTTP_1_0;
                    }
                } else {
                    if (!zzW.startsWith("ICY ")) {
                        throw new ProtocolException("Unexpected status line: ".concat(zzW));
                    }
                    zzbtm zzbtmVar3 = zzbtm.HTTP_1_0;
                    i11 = 4;
                }
                int i13 = i11 + 3;
                if (zzW.length() < i13) {
                    throw new ProtocolException("Unexpected status line: ".concat(zzW));
                }
                try {
                    int parseInt = Integer.parseInt(zzW.substring(i11, i13));
                    if (zzW.length() <= i13) {
                        str3 = "";
                    } else {
                        if (zzW.charAt(i13) != ' ') {
                            throw new ProtocolException("Unexpected status line: ".concat(zzW));
                        }
                        str3 = zzW.substring(i11 + 4);
                    }
                    do {
                    } while (!zzW(zzd2).equals(""));
                    if (parseInt >= 200 && parseInt < 300) {
                        socket.setSoTimeout(0);
                        return socket;
                    }
                    zzbwb zzbwbVar = new zzbwb();
                    try {
                        socket.shutdownOutput();
                        zzd2.zza(zzbwbVar, 1024L);
                    } catch (IOException e11) {
                        zzbwbVar.zzs("Unable to read body: " + e11.toString());
                    }
                    try {
                        socket.close();
                    } catch (IOException unused2) {
                    }
                    throw new zzbdp(zzbdo.zzp.zzg(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(parseInt), str3, zzbwbVar.zzi())), null);
                } catch (NumberFormatException unused3) {
                    throw new ProtocolException("Unexpected status line: ".concat(zzW));
                }
            } catch (IOException e12) {
                e = e12;
                if (socket != null) {
                    zzbjd.zzi(socket);
                }
                throw new zzbdp(zzbdo.zzp.zzg("Failed trying to connect with proxy").zzf(e), null);
            }
        } catch (IOException e13) {
            e = e13;
            socket = null;
        }
    }

    private static String zzW(zzbws zzbwsVar) throws IOException {
        zzbwb zzbwbVar = new zzbwb();
        while (zzbwsVar.zza(zzbwbVar, 1L) != -1) {
            if (zzbwbVar.zzb(zzbwbVar.zzg() - 1) == 10) {
                return zzbwbVar.zzj(Long.MAX_VALUE);
            }
        }
        throw new EOFException("\\n not found: ".concat(String.valueOf(zzbwbVar.zzy(zzbwbVar.zzg()).zze())));
    }

    private final Throwable zzX() {
        synchronized (this.zzo) {
            try {
                zzbdo zzbdoVar = this.zzz;
                if (zzbdoVar != null) {
                    return new zzbdp(zzbdoVar, null);
                }
                return new zzbdp(zzbdo.zzp.zzg("Connection closed"), null);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void zzY(zzbry zzbryVar) {
        if (this.zzD && this.zzI.isEmpty() && this.zzr.isEmpty()) {
            this.zzD = false;
            zzbkh zzbkhVar = this.zzK;
            if (zzbkhVar != null) {
                zzbkhVar.zzc();
            }
        }
        if (zzbryVar.zzq()) {
            this.zzO.zzc(zzbryVar, false);
        }
    }

    private final void zzZ(zzbry zzbryVar) {
        if (!this.zzD) {
            this.zzD = true;
            zzbkh zzbkhVar = this.zzK;
            if (zzbkhVar != null) {
                zzbkhVar.zzb();
            }
        }
        if (zzbryVar.zzq()) {
            this.zzO.zzc(zzbryVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaa(int i11, zzbtp zzbtpVar, zzbdo zzbdoVar) {
        synchronized (this.zzo) {
            try {
                if (this.zzz == null) {
                    this.zzz = zzbdoVar;
                    this.zzl.zzd(zzbdoVar);
                }
                if (zzbtpVar != null && !this.zzA) {
                    this.zzA = true;
                    this.zzm.zzh(0, zzbtpVar, new byte[0]);
                }
                Iterator it = this.zzr.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (((Integer) entry.getKey()).intValue() > i11) {
                        it.remove();
                        ((zzbry) entry.getValue()).zzD().zzj(zzbdoVar, zzbfs.REFUSED, false, new zzbcf());
                        zzY((zzbry) entry.getValue());
                    }
                }
                for (zzbry zzbryVar : this.zzI) {
                    zzbryVar.zzD().zzj(zzbdoVar, zzbfs.MISCARRIED, true, new zzbcf());
                    zzY(zzbryVar);
                }
                this.zzI.clear();
                zzac();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private final void zzab(zzbry zzbryVar) {
        zzmt.zzp(zzbryVar.zzD().zzG() == -1, "StreamId already assigned");
        this.zzr.put(Integer.valueOf(this.zzq), zzbryVar);
        zzZ(zzbryVar);
        zzbryVar.zzD().zzN(this.zzq);
        if (zzbryVar.zzx() == zzbcj.UNARY || zzbryVar.zzx() == zzbcj.SERVER_STREAMING) {
            zzbryVar.zzI();
        } else {
            this.zzm.zzg();
        }
        int i11 = this.zzq;
        if (i11 < 2147483645) {
            this.zzq = i11 + 2;
        } else {
            this.zzq = Integer.MAX_VALUE;
            zzaa(Integer.MAX_VALUE, zzbtp.NO_ERROR, zzbdo.zzp.zzg("Stream ids exhausted"));
        }
    }

    private final void zzac() {
        if (this.zzz == null || !this.zzr.isEmpty() || !this.zzI.isEmpty() || this.zzC) {
            return;
        }
        this.zzC = true;
        zzbkh zzbkhVar = this.zzK;
        if (zzbkhVar != null) {
            zzbkhVar.zzd();
        }
        zzbjh zzbjhVar = this.zzB;
        if (zzbjhVar != null) {
            zzbjhVar.zzb(zzX());
            this.zzB = null;
        }
        if (!this.zzA) {
            this.zzA = true;
            this.zzm.zzh(0, zzbtp.NO_ERROR, new byte[0]);
        }
        this.zzm.close();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzad() {
        boolean z10 = false;
        while (!this.zzI.isEmpty() && this.zzr.size() < this.zzH) {
            zzab((zzbry) this.zzI.poll());
            z10 = true;
        }
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbdo zzm(zzbtp zzbtpVar) {
        zzbdo zzbdoVar = (zzbdo) zzc.get(zzbtpVar);
        if (zzbdoVar != null) {
            return zzbdoVar;
        }
        return zzbdo.zzc.zzg("Unknown http2 error code: " + zzbtpVar.zzs);
    }

    public final String toString() {
        zzmm zzb = zzmn.zzb(this);
        zzb.zzc("logId", this.zzp.zza());
        zzb.zzd(PlaceTypes.ADDRESS, this.zze);
        return zzb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzP(int i11, zzbdo zzbdoVar, zzbfs zzbfsVar, boolean z10, zzbtp zzbtpVar, zzbcf zzbcfVar) {
        synchronized (this.zzo) {
            try {
                zzbry zzbryVar = (zzbry) this.zzr.remove(Integer.valueOf(i11));
                if (zzbryVar != null) {
                    if (zzbtpVar != null) {
                        this.zzm.zzc(i11, zzbtp.CANCEL);
                    }
                    if (zzbdoVar != null) {
                        zzbrx zzD = zzbryVar.zzD();
                        if (zzbcfVar == null) {
                            zzbcfVar = new zzbcf();
                        }
                        zzD.zzj(zzbdoVar, zzbfsVar, z10, zzbcfVar);
                    }
                    if (!zzad()) {
                        zzac();
                    }
                    zzY(zzbryVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzQ(zzbry zzbryVar) {
        this.zzI.remove(zzbryVar);
        zzY(zzbryVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzR(zzbry zzbryVar) {
        zzbdo zzbdoVar = this.zzz;
        if (zzbdoVar != null) {
            zzbryVar.zzD().zzj(zzbdoVar, zzbfs.MISCARRIED, true, new zzbcf());
        } else if (this.zzr.size() < this.zzH) {
            zzab(zzbryVar);
        } else {
            this.zzI.add(zzbryVar);
            zzZ(zzbryVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzT() {
        return this.zzF == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzU(int i11) {
        boolean z10;
        synchronized (this.zzo) {
            z10 = false;
            if (i11 < this.zzq && (i11 & 1) == 1) {
                z10 = true;
            }
        }
        return z10;
    }

    @Override // com.google.android.libraries.places.internal.zzbsr
    public final zzbsq[] zzV() {
        zzbsq[] zzbsqVarArr;
        synchronized (this.zzo) {
            try {
                zzbsqVarArr = new zzbsq[this.zzr.size()];
                Iterator it = this.zzr.values().iterator();
                int i11 = 0;
                while (it.hasNext()) {
                    zzbsqVarArr[i11] = ((zzbry) it.next()).zzD().zzH();
                    i11++;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzbsqVarArr;
    }

    @Override // com.google.android.libraries.places.internal.zzbfu
    public final /* synthetic */ zzbfr zza(zzbcl zzbclVar, zzbcf zzbcfVar, zzayj zzayjVar, zzayx[] zzayxVarArr) {
        zzmt.zzc(zzbclVar, "method");
        zzbqo zza = zzbqo.zza(zzayxVarArr, this.zzy, zzbcfVar);
        synchronized (this.zzo) {
            try {
                try {
                    return new zzbry(zzbclVar, zzbcfVar, this.zzm, this, this.zzn, this.zzo, this.zzv, this.zzj, this.zzf, this.zzg, zza, this.zzN, zzayjVar, false);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbrj
    public final void zzb(Throwable th2) {
        zzaa(0, zzbtp.INTERNAL_ERROR, zzbdo.zzp.zzf(th2));
    }

    @Override // com.google.android.libraries.places.internal.zzbau
    public final zzbap zzc() {
        return this.zzp;
    }

    @Override // com.google.android.libraries.places.internal.zzbml
    public final void zzd(zzbdo zzbdoVar) {
        synchronized (this.zzo) {
            try {
                if (this.zzz != null) {
                    return;
                }
                this.zzz = zzbdoVar;
                this.zzl.zzd(zzbdoVar);
                zzac();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgf
    public final zzaye zze() {
        return this.zzy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzi() {
        URI zzf = zzbjd.zzf(this.zzf);
        return zzf.getPort() != -1 ? zzf.getPort() : this.zze.getPort();
    }

    @Override // com.google.android.libraries.places.internal.zzbml
    public final Runnable zzj(zzbmk zzbmkVar) {
        this.zzl = zzbmkVar;
        zzbri zzc2 = zzbri.zzc(this.zzt, this, 10000);
        zzbrf zzbrfVar = new zzbrf(zzc2, this.zzk.zzd(zzbwh.zza(zzc2), true));
        synchronized (this.zzo) {
            zzbrk zzbrkVar = new zzbrk(this, zzbrfVar);
            this.zzm = zzbrkVar;
            this.zzn = new zzbsu(this, zzbrkVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.zzt.execute(new zzbsc(this, countDownLatch, zzc2));
        try {
            synchronized (this.zzo) {
                this.zzm.zze();
                zzbue zzbueVar = new zzbue();
                zzbueVar.zze(7, 0, this.zzj);
                this.zzm.zzi(zzbueVar);
            }
            countDownLatch.countDown();
            this.zzt.execute(new zzbsd(this));
            return null;
        } catch (Throwable th2) {
            countDownLatch.countDown();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbry zzr(int i11) {
        zzbry zzbryVar;
        synchronized (this.zzo) {
            zzbryVar = (zzbry) this.zzr.get(Integer.valueOf(i11));
        }
        return zzbryVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzy() {
        URI zzf = zzbjd.zzf(this.zzf);
        return zzf.getHost() != null ? zzf.getHost() : this.zzf;
    }
}
