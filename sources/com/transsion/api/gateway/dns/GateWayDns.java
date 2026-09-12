package com.transsion.api.gateway.dns;

import com.transsion.api.gateway.utils.GatewayUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Dns;

/* loaded from: classes5.dex */
public class GateWayDns implements Dns {

    /* renamed from: a, reason: collision with root package name */
    public static AtomicBoolean f42571a = new AtomicBoolean(false);
    private static volatile GateWayDns mInstance;

    public static GateWayDns getInstance() {
        if (mInstance == null) {
            synchronized (GateWayDns.class) {
                try {
                    if (mInstance == null) {
                        mInstance = new GateWayDns();
                    }
                } finally {
                }
            }
        }
        return mInstance;
    }

    public boolean getIsUseGatewayDns() {
        return f42571a.get();
    }

    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        b bVar;
        CopyOnWriteArrayList copyOnWriteArrayList;
        GatewayUtils.L.d("look up");
        if (!com.transsion.api.gateway.config.b.a().f42568a.f42546a) {
            GatewayUtils.L.d("dns function closed");
            return Dns.SYSTEM.lookup(str);
        }
        if (!GatewayUtils.canUseGateWay(str)) {
            return Dns.SYSTEM.lookup(str);
        }
        if (!getIsUseGatewayDns()) {
            GatewayUtils.L.d("use dns");
            return Dns.SYSTEM.lookup(str);
        }
        ArrayList arrayList = new ArrayList();
        c.a().getClass();
        synchronized (c.class) {
            try {
                Iterator it = c.f42574a.iterator();
                bVar = null;
                b bVar2 = null;
                while (it.hasNext()) {
                    b bVar3 = (b) it.next();
                    String str2 = bVar3.f42572a;
                    if (str2 != null && str2.equals(str)) {
                        bVar2 = bVar3;
                    }
                }
                if (bVar2 != null) {
                    bVar = new b(bVar2);
                }
            } finally {
            }
        }
        if (bVar != null && (copyOnWriteArrayList = bVar.f42573b) != null && copyOnWriteArrayList.size() != 0) {
            Iterator it2 = bVar.f42573b.iterator();
            while (it2.hasNext()) {
                try {
                    arrayList.add(InetAddress.getByAddress(str, GatewayUtils.textToNumericFormatV4(((d) it2.next()).f42576b)));
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        if (arrayList.size() <= 0) {
            GatewayUtils.L.d("use dns");
            return Dns.SYSTEM.lookup(str);
        }
        GatewayUtils.L.d("use nodns ips");
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            InetAddress inetAddress = (InetAddress) it3.next();
            GatewayUtils.L.d(inetAddress.getHostName() + inetAddress.getHostAddress());
        }
        return arrayList;
    }

    public void setIsUseGatewayDns(boolean z10) {
        f42571a.set(z10);
    }
}
