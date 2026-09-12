package cg;

import com.cloud.tmc.integration.net.UrlKt;
import com.tmc.monitor.AppMonitor;
import com.tmc.network.NetworkConfig;
import com.tmc.network.NetworkMonitor;
import com.tmc.network.stat.ConnectStat;
import com.tmc.network.stat.RequestStat;
import com.tmc.network.strategy.LocalDnsStrategy;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.TlsVersion;

/* loaded from: classes4.dex */
public final class b extends EventListener {

    /* renamed from: c, reason: collision with root package name */
    public static final a f17311c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private static final EventListener.Factory f17312d = new EventListener.Factory() { // from class: cg.a
        @Override // okhttp3.EventListener.Factory
        public final EventListener create(Call call) {
            EventListener c11;
            c11 = b.c(call);
            return c11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private RequestStat f17313a;

    /* renamed from: b, reason: collision with root package name */
    private ConnectStat f17314b;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EventListener.Factory a() {
            return b.f17312d;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public b() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public b(RequestStat requestStat, ConnectStat connectStat) {
        Intrinsics.h(requestStat, "requestStat");
        Intrinsics.h(connectStat, "connectStat");
        this.f17313a = requestStat;
        this.f17314b = connectStat;
        NetworkMonitor networkMonitor = NetworkMonitor.INSTANCE;
        connectStat.setNetworkConnected(networkMonitor.isConnected());
        this.f17314b.setNetStatus(networkMonitor.getNetworkStatus());
        this.f17313a.setNetStatus(this.f17314b.getNetStatus());
        this.f17313a.setNetworkConnected(this.f17314b.getIsNetworkConnected());
        ConnectStat connectStat2 = this.f17314b;
        NetworkConfig networkConfig = NetworkConfig.INSTANCE;
        connectStat2.setAppName(networkConfig.getPackageName());
        this.f17313a.setAppName(networkConfig.getPackageName());
        this.f17313a.setNetworkType(networkMonitor.getNetworkType());
        this.f17314b.setNetworkType(networkMonitor.getNetworkType());
        this.f17313a.setNetworkImprove(networkConfig.isNetworkImproveEnable());
        this.f17314b.setNetworkImprove(networkConfig.isNetworkImproveEnable());
    }

    public /* synthetic */ b(RequestStat requestStat, ConnectStat connectStat, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new RequestStat() : requestStat, (i11 & 2) != 0 ? new ConnectStat() : connectStat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final EventListener c(Call it) {
        Intrinsics.h(it, "it");
        return new b(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Intrinsics.h(call, "call");
        super.callEnd(call);
        this.f17313a.setOnewayTime(System.currentTimeMillis() - this.f17313a.getCallStart());
        this.f17314b.setStep(10);
        this.f17313a.setStep(10);
        if (this.f17313a.getIsPre()) {
            return;
        }
        AppMonitor.d().c(this.f17313a);
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.h(call, "call");
        Intrinsics.h(ioe, "ioe");
        super.callFailed(call, ioe);
        this.f17313a.setOnewayTime(System.currentTimeMillis() - this.f17313a.getCallStart());
        this.f17313a.setRet(0);
        this.f17313a.setConnRet(this.f17314b.getRet());
        this.f17313a.setErrMsg(ioe.getMessage());
        this.f17314b.setStep(this.f17313a.getStep());
        if (ioe instanceof UnknownHostException) {
            this.f17313a.setErrCode(-399);
            this.f17314b.setDnsTime(System.currentTimeMillis() - this.f17314b.getDnsStart());
            if (!this.f17314b.getIsPre()) {
                AppMonitor.d().c(this.f17314b);
            }
        } else if (ioe instanceof SSLException) {
            this.f17313a.setErrCode(-402);
        } else if (ioe instanceof ConnectException) {
            this.f17313a.setErrCode(-400);
        } else {
            this.f17313a.setErrCode(-406);
            if (Intrinsics.c(this.f17313a.getErrMsg(), "Canceled")) {
                this.f17313a.setRet(2);
            }
        }
        if (this.f17313a.getIsPre()) {
            return;
        }
        AppMonitor.d().c(this.f17313a);
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Intrinsics.h(call, "call");
        super.callStart(call);
        this.f17313a.setUrl(call.request().url().getUrl());
        this.f17314b.setHost(call.request().url().host());
        this.f17313a.setHost(this.f17314b.getHost());
        this.f17313a.setCallStart(System.currentTimeMillis());
        if (Intrinsics.c(call.request().header("isPre"), "true")) {
            this.f17313a.setPre(true);
            this.f17314b.setPre(true);
        }
        this.f17313a.setRequestChannel(call.request().header(UrlKt.KEY_HEADER_REQUESTCHANNEL));
        this.f17314b.setStep(0);
        this.f17313a.setStep(0);
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        Intrinsics.h(call, "call");
        super.canceled(call);
        this.f17313a.setOnewayTime(System.currentTimeMillis() - this.f17313a.getCallStart());
        this.f17313a.setRet(2);
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.h(call, "call");
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        ConnectStat connectStat = this.f17314b;
        InetAddress address = inetSocketAddress.getAddress();
        connectStat.setIp(address == null ? null : address.getHostAddress());
        this.f17314b.setProtocol(protocol != null ? protocol.name() : null);
        this.f17314b.setRet(1);
        this.f17314b.setConnTime(System.currentTimeMillis() - this.f17314b.getConnectStart());
        this.f17313a.setConnWaitTime(this.f17314b.getConnTime());
        ConnectStat connectStat2 = this.f17314b;
        connectStat2.setTcpTime(connectStat2.getConnTime() - this.f17314b.getTlsTime());
        this.f17313a.setTcpTime(this.f17314b.getTcpTime());
        this.f17314b.setStep(this.f17313a.getStep());
        if (this.f17314b.getIsPre()) {
            return;
        }
        AppMonitor.d().c(this.f17314b);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.h(call, "call");
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        Intrinsics.h(ioe, "ioe");
        super.connectFailed(call, inetSocketAddress, proxy, protocol, ioe);
        this.f17314b.setConnTime(System.currentTimeMillis() - this.f17314b.getConnectStart());
        this.f17313a.setConnWaitTime(this.f17314b.getConnTime());
        this.f17314b.setRet(0);
        this.f17314b.setErrMsg(ioe.getMessage());
        if (ioe instanceof SSLPeerUnverifiedException) {
            this.f17314b.setErrCode(-402);
            String message = ioe.getMessage();
            if (message != null && StringsKt.a0(message, "Certificate pinning failure!", true)) {
                this.f17314b.setPinning(true);
                this.f17313a.setPinning(true);
            }
        } else if (ioe instanceof SSLException) {
            this.f17314b.setErrCode(-402);
        } else if (ioe instanceof ConnectException) {
            this.f17314b.setErrCode(-400);
        } else {
            this.f17314b.setErrCode(-406);
        }
        this.f17314b.setStep(this.f17313a.getStep());
        if (!this.f17314b.getIsPre()) {
            AppMonitor.d().c(this.f17314b);
        }
        LocalDnsStrategy a11 = LocalDnsStrategy.f40858c.a();
        String hostName = inetSocketAddress.getHostName();
        Intrinsics.g(hostName, "inetSocketAddress.hostName");
        InetAddress address = inetSocketAddress.getAddress();
        Intrinsics.g(address, "inetSocketAddress.address");
        a11.i(hostName, address);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.h(call, "call");
        Intrinsics.h(inetSocketAddress, "inetSocketAddress");
        Intrinsics.h(proxy, "proxy");
        super.connectStart(call, inetSocketAddress, proxy);
        this.f17314b.setConnectStart(System.currentTimeMillis());
        this.f17314b.setStep(2);
        this.f17313a.setStep(2);
        this.f17314b.setIp(inetSocketAddress.getAddress().getHostAddress());
        this.f17313a.setIp(this.f17314b.getIp());
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        TlsVersion tlsVersion;
        String name;
        Intrinsics.h(call, "call");
        Intrinsics.h(connection, "connection");
        super.connectionAcquired(call, connection);
        this.f17313a.setConnRet(1);
        this.f17313a.setIp(connection.getRoute().socketAddress().getAddress().getHostAddress());
        this.f17313a.setProtocol(connection.protocol().name());
        CertificatePinner certificatePinner = connection.getRoute().address().certificatePinner();
        List<CertificatePinner.Pin> findMatchingPins = certificatePinner == null ? null : certificatePinner.findMatchingPins(connection.getRoute().address().url().host());
        if (findMatchingPins != null && !findMatchingPins.isEmpty()) {
            this.f17314b.setPinning(true);
            this.f17313a.setPinning(true);
        }
        RequestStat requestStat = this.f17313a;
        Handshake handshake = connection.getHandshake();
        String str = "";
        if (handshake != null && (tlsVersion = handshake.tlsVersion()) != null && (name = tlsVersion.name()) != null) {
            str = name;
        }
        requestStat.setTlsVersion(str);
        this.f17314b.setTlsVersion(this.f17313a.getTlsVersion());
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String domainName, List inetAddressList) {
        Intrinsics.h(call, "call");
        Intrinsics.h(domainName, "domainName");
        Intrinsics.h(inetAddressList, "inetAddressList");
        super.dnsEnd(call, domainName, inetAddressList);
        this.f17314b.setDnsTime(System.currentTimeMillis() - this.f17314b.getDnsStart());
        this.f17313a.setDnsTime(this.f17314b.getDnsTime());
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String domainName) {
        Intrinsics.h(call, "call");
        Intrinsics.h(domainName, "domainName");
        super.dnsStart(call, domainName);
        this.f17314b.setDnsStart(System.currentTimeMillis());
        this.f17314b.setStep(1);
        this.f17313a.setStep(1);
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j11) {
        Intrinsics.h(call, "call");
        super.requestBodyEnd(call, j11);
        this.f17313a.setReqBodyTime(System.currentTimeMillis() - this.f17313a.getReqBodyStart());
        this.f17313a.setSendDataEnd(System.currentTimeMillis());
        this.f17313a.setSendDataTime(System.currentTimeMillis() - this.f17313a.getReqHeaderStart());
        this.f17314b.setStep(6);
        this.f17313a.setStep(6);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Intrinsics.h(call, "call");
        super.requestBodyStart(call);
        this.f17313a.setReqBodyStart(System.currentTimeMillis());
        this.f17314b.setStep(5);
        this.f17313a.setStep(5);
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.h(call, "call");
        Intrinsics.h(ioe, "ioe");
        super.requestFailed(call, ioe);
        this.f17313a.setRet(0);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.h(call, "call");
        Intrinsics.h(request, "request");
        super.requestHeadersEnd(call, request);
        this.f17313a.setReqHeaderTime(System.currentTimeMillis() - this.f17313a.getReqHeaderStart());
        this.f17313a.setSendDataEnd(System.currentTimeMillis());
        RequestStat requestStat = this.f17313a;
        requestStat.setSendDataTime(requestStat.getReqHeaderTime());
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Intrinsics.h(call, "call");
        super.requestHeadersStart(call);
        this.f17313a.setReqHeaderStart(System.currentTimeMillis());
        this.f17314b.setStep(4);
        this.f17313a.setStep(4);
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j11) {
        Intrinsics.h(call, "call");
        super.responseBodyEnd(call, j11);
        this.f17313a.setRecvBodySize(j11);
        this.f17313a.setRecvDataTime(System.currentTimeMillis() - this.f17313a.getSendDataEnd());
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Intrinsics.h(call, "call");
        super.responseBodyStart(call);
        this.f17314b.setStep(8);
        this.f17313a.setStep(8);
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.h(call, "call");
        Intrinsics.h(ioe, "ioe");
        super.responseFailed(call, ioe);
        this.f17313a.setRet(0);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.h(call, "call");
        Intrinsics.h(response, "response");
        super.responseHeadersEnd(call, response);
        this.f17313a.setResHeaderTime(System.currentTimeMillis() - this.f17313a.getResHeaderStart());
        String header$default = Response.header$default(response, "X-Cache", null, 2, null);
        this.f17313a.setXCache("miss");
        if (header$default != null && StringsKt.a0(header$default, "hit", true)) {
            this.f17313a.setXCache("hit");
        }
        this.f17313a.setRequestSrc(Response.header$default(response, "x-request-cdn", null, 2, null));
        this.f17313a.setRequestLLID(Response.header$default(response, "X-LLID", null, 2, null));
        this.f17313a.setEagleId(Response.header$default(response, "EagleId", null, 2, null));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Intrinsics.h(call, "call");
        super.responseHeadersStart(call);
        this.f17313a.setRet(1);
        this.f17313a.setFirstDataTime(System.currentTimeMillis() - this.f17313a.getSendDataEnd());
        this.f17313a.setResHeaderStart(System.currentTimeMillis());
        this.f17314b.setStep(7);
        this.f17313a.setStep(7);
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.h(call, "call");
        super.secureConnectEnd(call, handshake);
        this.f17314b.setTlsTime(System.currentTimeMillis() - this.f17314b.getTlsStart());
        this.f17313a.setTlsTime(this.f17314b.getTlsTime());
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Intrinsics.h(call, "call");
        super.secureConnectStart(call);
        this.f17314b.setTlsStart(System.currentTimeMillis());
        this.f17314b.setStep(3);
        this.f17313a.setStep(3);
    }
}
