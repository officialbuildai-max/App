package com.google.android.libraries.places.internal;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import javax.net.SocketFactory;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes4.dex */
final class zzbsc implements Runnable {
    final /* synthetic */ CountDownLatch zza;
    final /* synthetic */ zzbri zzb;
    final /* synthetic */ zzbsf zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbsc(zzbsf zzbsfVar, CountDownLatch countDownLatch, zzbri zzbriVar) {
        this.zza = countDownLatch;
        this.zzb = zzbriVar;
        this.zzc = zzbsfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbuf zzbufVar;
        zzbuf zzbufVar2;
        Socket socket;
        SSLSocketFactory sSLSocketFactory;
        zzaye zzayeVar;
        zzbuf zzbufVar3;
        Object obj;
        SSLSocketFactory sSLSocketFactory2;
        zzbsz zzbszVar;
        SocketFactory socketFactory;
        InetSocketAddress inetSocketAddress;
        InetSocketAddress inetSocketAddress2;
        try {
            this.zza.await();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        zzbwd zzb = zzbwh.zzb(new zzbsb(this));
        try {
            try {
                try {
                    zzbsf zzbsfVar = this.zzc;
                    zzbaa zzbaaVar = zzbsfVar.zza;
                    SSLSession sSLSession = null;
                    if (zzbaaVar == null) {
                        socketFactory = zzbsfVar.zzE;
                        inetSocketAddress = zzbsfVar.zze;
                        InetAddress address = inetSocketAddress.getAddress();
                        inetSocketAddress2 = this.zzc.zze;
                        socket = socketFactory.createSocket(address, inetSocketAddress2.getPort());
                    } else {
                        if (!(zzbaaVar.zze() instanceof InetSocketAddress)) {
                            throw new zzbdp(zzbdo.zzo.zzg("Unsupported SocketAddress implementation " + String.valueOf(this.zzc.zza.zze().getClass())), null);
                        }
                        socket = zzbsf.zzA(zzbsfVar, zzbaaVar.zzd(), (InetSocketAddress) zzbaaVar.zze(), this.zzc.zza.zzc(), this.zzc.zza.zzb());
                    }
                    zzbsf zzbsfVar2 = this.zzc;
                    sSLSocketFactory = zzbsfVar2.zzF;
                    Socket socket2 = socket;
                    if (sSLSocketFactory != null) {
                        sSLSocketFactory2 = zzbsfVar2.zzF;
                        String zzy = zzbsfVar2.zzy();
                        int zzi = this.zzc.zzi();
                        zzbszVar = this.zzc.zzJ;
                        zzmt.zzc(sSLSocketFactory2, "sslSocketFactory");
                        zzmt.zzc(socket, "socket");
                        zzmt.zzc(zzbszVar, "spec");
                        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory2.createSocket(socket, zzy, zzi, true);
                        zzbszVar.zza(sSLSocket, false);
                        String zzb2 = zzbsk.zzd().zzb(sSLSocket, zzy, zzbszVar.zzb() ? zzbsm.zza : null);
                        List list = zzbsm.zza;
                        zzmt.zzr(list.contains(zzbtm.zza(zzb2)), "Only " + String.valueOf(list) + " are supported, but negotiated protocol is %s", zzb2);
                        if (!zzbte.zza.verify((zzy.startsWith("[") && zzy.endsWith("]")) ? zzy.substring(1, zzy.length() - 1) : zzy, sSLSocket.getSession())) {
                            throw new SSLPeerUnverifiedException("Cannot verify hostname: ".concat(zzy));
                        }
                        sSLSession = sSLSocket.getSession();
                        socket2 = sSLSocket;
                    }
                    socket2.setTcpNoDelay(true);
                    zzbwd zzb3 = zzbwh.zzb(zzbwh.zzd(socket2));
                    this.zzb.zzm(zzbwh.zzc(socket2), socket2);
                    zzbsf zzbsfVar3 = this.zzc;
                    zzayeVar = zzbsfVar3.zzy;
                    zzayb zzb4 = zzayeVar.zzb();
                    zzb4.zzb(zzazw.zza, socket2.getRemoteSocketAddress());
                    zzb4.zzb(zzazw.zzb, socket2.getLocalSocketAddress());
                    zzb4.zzb(zzazw.zzc, sSLSession);
                    zzb4.zzb(zzbit.zza, sSLSession == null ? zzbdf.NONE : zzbdf.PRIVACY_AND_INTEGRITY);
                    zzbsfVar3.zzy = zzb4.zzc();
                    zzbsf zzbsfVar4 = this.zzc;
                    zzbufVar3 = zzbsfVar4.zzk;
                    zzbsfVar4.zzx = new zzbse(zzbsfVar4, zzbufVar3.zzc(zzb3, true));
                    obj = this.zzc.zzo;
                    synchronized (obj) {
                        try {
                            zzbsf zzbsfVar5 = this.zzc;
                            zzmt.zzc(socket2, "socket");
                            zzbsfVar5.zzG = socket2;
                            if (sSLSession != null) {
                                this.zzc.zzP = new zzbaf(new zzbag(sSLSession));
                            }
                        } finally {
                        }
                    }
                } catch (Throwable th2) {
                    zzbsf zzbsfVar6 = this.zzc;
                    zzbufVar2 = zzbsfVar6.zzk;
                    zzbsfVar6.zzx = new zzbse(zzbsfVar6, zzbufVar2.zzc(zzb, true));
                    throw th2;
                }
            } catch (zzbdp e11) {
                this.zzc.zzaa(0, zzbtp.INTERNAL_ERROR, e11.zza());
                zzbsf zzbsfVar7 = this.zzc;
                zzbufVar = zzbsfVar7.zzk;
                zzbsfVar7.zzx = new zzbse(zzbsfVar7, zzbufVar.zzc(zzb, true));
            }
        } catch (Exception e12) {
            this.zzc.zzb(e12);
            zzbsf zzbsfVar72 = this.zzc;
            zzbufVar = zzbsfVar72.zzk;
            zzbsfVar72.zzx = new zzbse(zzbsfVar72, zzbufVar.zzc(zzb, true));
        }
    }
}
