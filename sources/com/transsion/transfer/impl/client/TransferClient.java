package com.transsion.transfer.impl.client;

import android.os.Build;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.transfer.androidasync.http.AsyncHttpClient;
import com.transsion.transfer.androidasync.http.b0;
import com.transsion.transfer.impl.PingPongHelper;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.client.TransferClient;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.entity.TransferResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes6.dex */
public final class TransferClient implements com.transsion.transfer.impl.e {

    /* renamed from: t */
    public static final a f55788t = new a(null);

    /* renamed from: u */
    private static final String f55789u;

    /* renamed from: v */
    private static volatile com.transsion.transfer.impl.e f55790v;

    /* renamed from: w */
    private static String f55791w;

    /* renamed from: x */
    private static String f55792x;

    /* renamed from: y */
    private static String f55793y;

    /* renamed from: a */
    private final String f55794a;

    /* renamed from: b */
    private final String f55795b;

    /* renamed from: c */
    private final String f55796c;

    /* renamed from: d */
    private final Lazy f55797d;

    /* renamed from: e */
    private final Lazy f55798e;

    /* renamed from: f */
    private final Lazy f55799f;

    /* renamed from: g */
    private final Lazy f55800g;

    /* renamed from: h */
    private volatile b0 f55801h;

    /* renamed from: i */
    private boolean f55802i;

    /* renamed from: j */
    private final Lazy f55803j;

    /* renamed from: k */
    private PingPongHelper f55804k;

    /* renamed from: l */
    private final Lazy f55805l;

    /* renamed from: m */
    private String f55806m;

    /* renamed from: n */
    private Function3 f55807n;

    /* renamed from: o */
    private boolean f55808o;

    /* renamed from: p */
    private final PingPongHelper.a f55809p;

    /* renamed from: q */
    private final b f55810q;

    /* renamed from: r */
    private final CopyOnWriteArrayList f55811r;

    /* renamed from: s */
    private final h f55812s;

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static final Unit f(Function0 function0) {
            if (function0 != null) {
                function0.invoke();
            }
            return Unit.f67184a;
        }

        private final String h() {
            return jv.d.b(System.currentTimeMillis() + "&1000&" + Build.BRAND + UrlUtils.AND_MARK + Build.MODEL + UrlUtils.AND_MARK + Build.PRODUCT);
        }

        public static /* synthetic */ void m(a aVar, String str, String str2, String str3, Function0 function0, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                str3 = aVar.h();
            }
            aVar.l(str, str2, str3, function0);
        }

        public static final Unit n(Function0 function0) {
            function0.invoke();
            TransferClient.f55790v = null;
            return Unit.f67184a;
        }

        public final com.transsion.transfer.androidasync.http.h c(String url, String clientIp, String transferId) {
            Intrinsics.h(url, "url");
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(transferId, "transferId");
            com.transsion.transfer.androidasync.http.h hVar = new com.transsion.transfer.androidasync.http.h(url);
            hVar.c("clientIp", clientIp);
            hVar.c("transferId", transferId);
            hVar.c("transferProtocolVersion", "1");
            hVar.y(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            return hVar;
        }

        public final com.transsion.transfer.androidasync.http.i d(String url, String clientIp, String transferId) {
            Intrinsics.h(url, "url");
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(transferId, "transferId");
            com.transsion.transfer.androidasync.http.i iVar = new com.transsion.transfer.androidasync.http.i(url);
            iVar.c("clientIp", clientIp);
            iVar.c("transferId", transferId);
            iVar.c("transferProtocolVersion", "1");
            iVar.y(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            return iVar;
        }

        public final void e(final Function0 function0) {
            TransferClient.f55791w = null;
            TransferClient.f55792x = null;
            TransferClient.f55793y = null;
            mv.a.f70136a.b();
            if (TransferClient.f55790v == null) {
                if (function0 != null) {
                    function0.invoke();
                }
            } else {
                com.transsion.transfer.impl.e eVar = TransferClient.f55790v;
                if (eVar != null) {
                    eVar.c(new Function0() { // from class: com.transsion.transfer.impl.client.k
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            Unit f11;
                            f11 = TransferClient.a.f(Function0.this);
                            return f11;
                        }
                    });
                }
                TransferClient.f55790v = null;
            }
        }

        public final boolean g() {
            String str;
            String str2;
            String str3 = TransferClient.f55791w;
            if (str3 == null) {
                return false;
            }
            if (!(!(str3.length() == 0)) || (str = TransferClient.f55792x) == null) {
                return false;
            }
            if (!(!(str.length() == 0)) || (str2 = TransferClient.f55793y) == null) {
                return false;
            }
            return (str2.length() == 0) ^ true;
        }

        public final com.transsion.transfer.impl.e i() {
            com.transsion.transfer.impl.e eVar = TransferClient.f55790v;
            if (eVar == null) {
                synchronized (this) {
                    String str = TransferClient.f55791w;
                    Intrinsics.e(str);
                    String str2 = TransferClient.f55792x;
                    Intrinsics.e(str2);
                    String str3 = TransferClient.f55793y;
                    Intrinsics.e(str3);
                    eVar = new TransferClient(str, str2, str3, null);
                    TransferClient.f55790v = eVar;
                }
            }
            return eVar;
        }

        public final String j() {
            return TransferClient.f55789u;
        }

        public final String k() {
            return TransferClient.f55793y;
        }

        public final void l(String serverIpNew, String clientIpNew, String transferIdNew, final Function0 callback) {
            Intrinsics.h(serverIpNew, "serverIpNew");
            Intrinsics.h(clientIpNew, "clientIpNew");
            Intrinsics.h(transferIdNew, "transferIdNew");
            Intrinsics.h(callback, "callback");
            TransferClient.f55791w = serverIpNew;
            TransferClient.f55792x = clientIpNew;
            TransferClient.f55793y = transferIdNew;
            if (TransferClient.f55790v == null) {
                callback.invoke();
                return;
            }
            com.transsion.transfer.impl.e eVar = TransferClient.f55790v;
            if (eVar != null) {
                eVar.c(new Function0() { // from class: com.transsion.transfer.impl.client.l
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit n11;
                        n11 = TransferClient.a.n(Function0.this);
                        return n11;
                    }
                });
            }
        }
    }

    /* loaded from: classes6.dex */
    public static final class b implements Function2 {
        b() {
        }

        public void a(List list, boolean z10) {
            Intrinsics.h(list, "list");
            TransferClient.this.o0(list);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((List) obj, ((Boolean) obj2).booleanValue());
            return Unit.f67184a;
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends AsyncHttpClient.j {

        /* renamed from: a */
        final /* synthetic */ Function0 f55814a;

        c(Function0 function0) {
            this.f55814a = function0;
        }

        @Override // bv.g
        /* renamed from: d */
        public void c(Exception exc, com.transsion.transfer.androidasync.http.k kVar, String str) {
            this.f55814a.invoke();
            TransferClient.f55788t.j();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: notifyServerClientClose ,");
            sb2.append(message);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends AsyncHttpClient.j {

        /* renamed from: a */
        final /* synthetic */ Function1 f55815a;

        d(Function1 function1) {
            this.f55815a = function1;
        }

        @Override // bv.g
        /* renamed from: d */
        public void c(Exception exc, com.transsion.transfer.androidasync.http.k kVar, String str) {
            TransferClient.f55788t.j();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: sendServerCreateNotify , e:");
            sb2.append(message);
            this.f55815a.invoke(exc);
        }
    }

    /* loaded from: classes6.dex */
    public static final class e extends AsyncHttpClient.j {
        e() {
        }

        @Override // bv.g
        /* renamed from: d */
        public void c(Exception exc, com.transsion.transfer.androidasync.http.k kVar, String str) {
            TransferClient.f55788t.j();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: notifyServerClientSpaceLimit ,");
            sb2.append(message);
        }
    }

    /* loaded from: classes6.dex */
    public static final class f extends AsyncHttpClient.j {

        /* renamed from: a */
        final /* synthetic */ List f55816a;

        f(List list) {
            this.f55816a = list;
        }

        @Override // bv.g
        /* renamed from: d */
        public void c(Exception exc, com.transsion.transfer.androidasync.http.k kVar, String str) {
            TransferClient.f55788t.j();
            List list = this.f55816a;
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: notifyServerTaskFinish:");
            sb2.append(list);
            sb2.append(" ,");
            sb2.append(message);
        }
    }

    /* loaded from: classes6.dex */
    public static final class g implements PingPongHelper.a {
        g() {
        }

        public static final Unit c(TransferClient transferClient, boolean z10, String error) {
            Intrinsics.h(error, "error");
            if (z10) {
                TransferClient.f55788t.j();
            } else {
                TransferClient.f55788t.j();
                transferClient.f55801h = null;
                transferClient.f55812s.M();
                transferClient.e0().q();
                transferClient.f55806m = null;
            }
            return Unit.f67184a;
        }

        @Override // com.transsion.transfer.impl.PingPongHelper.a
        public void a(String remoteIp, b0 socket) {
            Intrinsics.h(remoteIp, "remoteIp");
            Intrinsics.h(socket, "socket");
            TransferClient.f55788t.j();
            boolean z10 = TransferClient.this.f55808o;
            String str = TransferClient.this.f55794a;
            String str2 = TransferClient.this.f55795b;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("client detach socket has closed, disconnectByUser:");
            sb2.append(z10);
            sb2.append(", serverIp: ");
            sb2.append(str);
            sb2.append(", clientIp: ");
            sb2.append(str2);
            sb2.append(", start auto connect");
            socket.close();
            PingPongHelper pingPongHelper = TransferClient.this.f55804k;
            if (pingPongHelper != null) {
                pingPongHelper.o();
            }
            TransferClient.this.f55804k = null;
            if (TransferClient.this.f55808o) {
                return;
            }
            final TransferClient transferClient = TransferClient.this;
            transferClient.W(new Function2() { // from class: com.transsion.transfer.impl.client.m
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit c11;
                    c11 = TransferClient.g.c(TransferClient.this, ((Boolean) obj).booleanValue(), (String) obj2);
                    return c11;
                }
            });
        }
    }

    /* loaded from: classes6.dex */
    public static final class h implements com.transsion.transfer.impl.f {
        h() {
        }

        @Override // com.transsion.transfer.impl.f
        public void B(String remoteFilePath, long j11, long j12) {
            Object obj;
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            Iterator it = mv.a.f70136a.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(remoteFilePath, ((FileData) obj).getFileRemotePath())) {
                        break;
                    }
                }
            }
            FileData fileData = (FileData) obj;
            if (fileData != null) {
                fileData.setState(2);
                fileData.setDownloadSize(j11);
                fileData.setFileSize(j12);
            }
            Iterator it2 = TransferClient.this.f55811r.iterator();
            while (it2.hasNext()) {
                ((com.transsion.transfer.impl.f) it2.next()).B(remoteFilePath, j11, j12);
            }
        }

        @Override // com.transsion.transfer.impl.f
        public void I(String remoteFilePath, TaskState state, long j11, long j12, long j13, String str) {
            Object obj;
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            Intrinsics.h(state, "state");
            Iterator it = mv.a.f70136a.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(remoteFilePath, ((FileData) obj).getFileRemotePath())) {
                        break;
                    }
                }
            }
            FileData fileData = (FileData) obj;
            if (fileData != null && fileData.getState() != 5 && fileData.getState() != 6 && fileData.getState() != 3 && fileData.getState() != 4 && fileData.getState() != 7) {
                fileData.setState(FileData.INSTANCE.a(state));
                fileData.setDownloadSize(j11);
                fileData.setFileSize(j12);
            }
            Iterator it2 = TransferClient.this.f55811r.iterator();
            while (it2.hasNext()) {
                ((com.transsion.transfer.impl.f) it2.next()).I(remoteFilePath, state, j11, j12, j13, str);
            }
            if (state == TaskState.SPACE_LIMIT) {
                TransferClient.this.n0(remoteFilePath, 7);
            }
        }

        @Override // com.transsion.transfer.impl.f
        public void M() {
            for (FileData fileData : mv.a.f70136a.d()) {
                if (fileData.getState() != 4 && fileData.getState() != 3 && fileData.getState() != 7) {
                    fileData.setState(5);
                }
            }
            Iterator it = TransferClient.this.f55811r.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.impl.f) it.next()).M();
            }
        }

        @Override // com.transsion.transfer.impl.f
        public void j(int i11) {
            Iterator it = TransferClient.this.f55811r.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.impl.f) it.next()).j(i11);
            }
        }

        @Override // com.transsion.transfer.impl.f
        public void o(String remoteFilePath) {
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            Iterator it = TransferClient.this.f55811r.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.impl.f) it.next()).o(remoteFilePath);
            }
        }
    }

    static {
        String name = TransferClient.class.getName();
        Intrinsics.g(name, "getName(...)");
        f55789u = name;
    }

    private TransferClient(String str, String str2, String str3) {
        this.f55794a = str;
        this.f55795b = str2;
        this.f55796c = str3;
        this.f55797d = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.client.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String U;
                U = TransferClient.U();
                return U;
            }
        });
        this.f55798e = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.client.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                AsyncHttpClient S;
                S = TransferClient.S();
                return S;
            }
        });
        this.f55799f = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.client.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                o a02;
                a02 = TransferClient.a0(TransferClient.this);
                return a02;
            }
        });
        this.f55800g = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.client.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n T;
                T = TransferClient.T(TransferClient.this);
                return T;
            }
        });
        this.f55803j = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.client.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Gson i02;
                i02 = TransferClient.i0();
                return i02;
            }
        });
        this.f55805l = LazyKt.b(new Function0() { // from class: com.transsion.transfer.impl.client.f
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                String l02;
                l02 = TransferClient.l0(TransferClient.this);
                return l02;
            }
        });
        this.f55809p = new g();
        this.f55810q = new b();
        this.f55811r = new CopyOnWriteArrayList();
        this.f55812s = new h();
    }

    public /* synthetic */ TransferClient(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    public static final AsyncHttpClient S() {
        return AsyncHttpClient.w();
    }

    public static final n T(TransferClient transferClient) {
        AsyncHttpClient b02 = transferClient.b0();
        Intrinsics.g(b02, "<get-client>(...)");
        return new n(b02, transferClient.f55795b, transferClient.f55796c, transferClient.g0(), transferClient.f55812s);
    }

    public static final String U() {
        return Build.MODEL;
    }

    public static final Unit V(TransferClient transferClient, Function0 function0) {
        b0 b0Var = transferClient.f55801h;
        if (b0Var != null) {
            b0Var.close();
        }
        transferClient.f55802i = false;
        PingPongHelper pingPongHelper = transferClient.f55804k;
        if (pingPongHelper != null) {
            pingPongHelper.o();
        }
        function0.invoke();
        transferClient.e0().q();
        return Unit.f67184a;
    }

    public final void W(final Function2 function2) {
        this.f55808o = false;
        AsyncHttpClient b02 = b0();
        String str = this.f55795b;
        String str2 = this.f55796c;
        String d02 = d0();
        Intrinsics.g(d02, "<get-deviceName>(...)");
        b02.L(h0("/pingpong?clientIp=" + str + "&transferId=" + str2 + "&deviceName=" + jv.a.b(d02)), "socket_connect", new AsyncHttpClient.k() { // from class: com.transsion.transfer.impl.client.h
            @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.k
            public final void a(Exception exc, b0 b0Var) {
                TransferClient.X(TransferClient.this, function2, exc, b0Var);
            }
        });
    }

    public static final void X(TransferClient transferClient, Function2 function2, Exception exc, final b0 b0Var) {
        boolean z10 = false;
        transferClient.f55802i = false;
        if (exc == null) {
            transferClient.f55801h = b0Var;
            b0 b0Var2 = transferClient.f55801h;
            if (b0Var2 != null) {
                b0Var2.J(new b0.c() { // from class: com.transsion.transfer.impl.client.i
                    @Override // com.transsion.transfer.androidasync.http.b0.c
                    public final void a(String str) {
                        TransferClient.Y(TransferClient.this, str);
                    }
                });
            }
            b0 b0Var3 = transferClient.f55801h;
            if (b0Var3 != null) {
                b0Var3.p(new bv.a() { // from class: com.transsion.transfer.impl.client.j
                    @Override // bv.a
                    public final void g(Exception exc2) {
                        TransferClient.Z(TransferClient.this, b0Var, exc2);
                    }
                });
            }
            String str = transferClient.f55794a;
            Intrinsics.e(b0Var);
            PingPongHelper pingPongHelper = new PingPongHelper(str, false, b0Var, transferClient.f55809p);
            pingPongHelper.n();
            transferClient.f55804k = pingPongHelper;
        } else {
            exc.printStackTrace();
            String str2 = transferClient.f55794a;
            String message = exc.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("serverIP:");
            sb2.append(str2);
            sb2.append(" connect error: ");
            sb2.append(message);
            sb2.append(" ");
        }
        if (exc == null && b0Var != null) {
            z10 = true;
        }
        Boolean valueOf = Boolean.valueOf(z10);
        String message2 = exc.getMessage();
        if (message2 == null) {
            message2 = "";
        }
        function2.invoke(valueOf, message2);
    }

    public static final void Y(TransferClient transferClient, String str) {
        Intrinsics.e(str);
        transferClient.j0(str);
    }

    public static final void Z(TransferClient transferClient, b0 b0Var, Exception exc) {
        PingPongHelper pingPongHelper = transferClient.f55804k;
        if (pingPongHelper != null) {
            pingPongHelper.o();
        }
        PingPongHelper.a aVar = transferClient.f55809p;
        String str = transferClient.f55794a;
        Intrinsics.e(b0Var);
        aVar.a(str, b0Var);
    }

    public static final o a0(TransferClient transferClient) {
        AsyncHttpClient b02 = transferClient.b0();
        Intrinsics.g(b02, "<get-client>(...)");
        return new o(b02, transferClient.f55795b, transferClient.f55796c, transferClient.g0(), transferClient.f55812s, transferClient.f55810q);
    }

    private final AsyncHttpClient b0() {
        return (AsyncHttpClient) this.f55798e.getValue();
    }

    private final n c0() {
        return (n) this.f55800g.getValue();
    }

    private final String d0() {
        return (String) this.f55797d.getValue();
    }

    public final o e0() {
        return (o) this.f55799f.getValue();
    }

    public final Gson f0() {
        return (Gson) this.f55803j.getValue();
    }

    private final String g0() {
        return (String) this.f55805l.getValue();
    }

    private final String h0(String str) {
        String str2 = g0() + str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getUrl baseUrl: ");
        sb2.append(str2);
        return str2;
    }

    public static final Gson i0() {
        return new Gson();
    }

    private final boolean j0(String str) {
        if (!StringsKt.W(str, "cmd", false, 2, null)) {
            return false;
        }
        try {
            List S0 = StringsKt.S0(str, new String[]{UrlUtils.QUESTION_MARK}, false, 0, 6, null);
            int parseInt = Integer.parseInt((String) StringsKt.S0((CharSequence) S0.get(0), new String[]{UrlUtils.EQUAL_MARK}, false, 0, 6, null).get(1));
            List S02 = S0.size() > 1 ? StringsKt.S0((CharSequence) S0.get(1), new String[]{UrlUtils.AND_MARK}, false, 0, 6, null) : new ArrayList();
            if (parseInt < 0) {
                k0(parseInt, S02);
            } else {
                this.f55812s.j(parseInt);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return true;
    }

    private final void k0(int i11, List list) {
        b0 b0Var;
        if (i11 != -2) {
            if (i11 == -1 && (b0Var = this.f55801h) != null) {
                b0Var.close();
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            List S0 = StringsKt.S0((String) it.next(), new String[]{UrlUtils.EQUAL_MARK}, false, 0, 6, null);
            linkedHashMap.put(S0.get(0), jv.a.a((String) S0.get(1)));
        }
        String str = (String) linkedHashMap.get("deviceName");
        this.f55806m = str;
        Function3 function3 = this.f55807n;
        if (function3 != null) {
            function3.invoke(str, Boolean.TRUE, "client");
        }
    }

    public static final String l0(TransferClient transferClient) {
        return "http://" + transferClient.f55794a + ":9890";
    }

    private final void m0(Function0 function0) {
        b0().v(f55788t.c(h0("/client/notifyClientClose"), this.f55795b, this.f55796c), new c(function0));
    }

    public final void n0(String str, int i11) {
        AsyncHttpClient b02 = b0();
        com.transsion.transfer.androidasync.http.i d11 = f55788t.d(h0("/client/notifyFileTaskError"), this.f55795b, this.f55796c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(str, Integer.valueOf(i11)));
        d11.w(new cv.f(f0().toJson(arrayList)));
        b02.v(d11, new e());
    }

    public final void o0(List list) {
        if (list.isEmpty()) {
            return;
        }
        AsyncHttpClient b02 = b0();
        com.transsion.transfer.androidasync.http.i d11 = f55788t.d(h0("/client/notifyFileTaskFinish"), this.f55795b, this.f55796c);
        d11.w(new cv.f(f0().toJson(list)));
        b02.v(d11, new f(list));
    }

    @Override // com.transsion.transfer.impl.e
    public void a(Function1 callback) {
        Intrinsics.h(callback, "callback");
        b0().v(f55788t.c(h0("/client/notifyServerCreate"), this.f55795b, this.f55796c), new d(callback));
    }

    @Override // com.transsion.transfer.impl.e
    public void b(Function3 function3) {
        this.f55807n = function3;
    }

    @Override // com.transsion.transfer.impl.e
    public void c(final Function0 callback) {
        Intrinsics.h(callback, "callback");
        this.f55808o = true;
        m0(new Function0() { // from class: com.transsion.transfer.impl.client.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit V;
                V = TransferClient.V(TransferClient.this, callback);
                return V;
            }
        });
        this.f55811r.clear();
    }

    @Override // com.transsion.transfer.impl.e
    public void d(Function2 listener) {
        b0 b0Var;
        b0 b0Var2;
        Intrinsics.h(listener, "listener");
        if ((this.f55801h == null || (b0Var2 = this.f55801h) == null || !b0Var2.isOpen()) && !this.f55802i) {
            this.f55802i = true;
            W(listener);
            return;
        }
        b0 b0Var3 = this.f55801h;
        b0 b0Var4 = this.f55801h;
        Boolean valueOf = b0Var4 != null ? Boolean.valueOf(b0Var4.isOpen()) : null;
        boolean z10 = this.f55802i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connect: socket:");
        sb2.append(b0Var3);
        sb2.append(", socket#isOpen:");
        sb2.append(valueOf);
        sb2.append(", socketConnecting:");
        sb2.append(z10);
        listener.invoke(Boolean.valueOf((this.f55801h == null || (b0Var = this.f55801h) == null || !b0Var.isOpen()) ? false : true), "connect is process");
    }

    @Override // com.transsion.transfer.impl.e
    public void e(final String root, final Function2 callback) {
        Intrinsics.h(root, "root");
        Intrinsics.h(callback, "callback");
        b0().v(f55788t.c(h0("/client/getTransferFilesList"), this.f55795b, this.f55796c), new AsyncHttpClient.j() { // from class: com.transsion.transfer.impl.client.TransferClient$fetchList$1
            @Override // bv.g
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public void c(Exception exc, com.transsion.transfer.androidasync.http.k kVar, String str) {
                Object m1185constructorimpl;
                Gson f02;
                TransferClient.f55788t.j();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fetchList onCompleted: result:");
                sb2.append(str);
                sb2.append(" and e:");
                sb2.append(exc);
                if (exc != null) {
                    Function2.this.invoke(null, exc);
                    return;
                }
                TransferClient transferClient = this;
                Function2 function2 = Function2.this;
                String str2 = root;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    f02 = transferClient.f0();
                    TransferResponse transferResponse = (TransferResponse) f02.fromJson(str, new TypeToken<TransferResponse<List<FileData>>>() { // from class: com.transsion.transfer.impl.client.TransferClient$fetchList$1$onCompleted$1$data$1
                    }.getType());
                    if (transferResponse.getCode() == 0) {
                        for (FileData fileData : (Iterable) transferResponse.getData()) {
                            com.transsion.transfer.impl.server.service.b.f55926c.a();
                            String fileRemotePath = fileData.getFileRemotePath();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("fetchList#onCompleted: ");
                            sb3.append(fileRemotePath);
                            if (fileData.getFileReceiveCachePath().length() != 0 && !new File(fileData.getFileReceiveCachePath()).isDirectory()) {
                            }
                            String absolutePath = new File(str2, fileData.getFileName()).getAbsolutePath();
                            Intrinsics.g(absolutePath, "getAbsolutePath(...)");
                            fileData.setFileReceiveCachePath(absolutePath);
                        }
                        mv.a.f70136a.a((List) transferResponse.getData());
                        function2.invoke(transferResponse.getData(), null);
                    } else {
                        function2.invoke(null, null);
                    }
                    m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                Result.m1184boximpl(m1185constructorimpl);
            }
        });
    }

    @Override // com.transsion.transfer.impl.e
    public void f(FileData fileData) {
        Intrinsics.h(fileData, "fileData");
        e0().t(fileData);
    }

    @Override // com.transsion.transfer.impl.e
    public void g(com.transsion.transfer.impl.f listener) {
        Intrinsics.h(listener, "listener");
        this.f55811r.remove(listener);
    }

    @Override // com.transsion.transfer.impl.e
    public boolean h() {
        b0 b0Var = this.f55801h;
        return b0Var != null && b0Var.isOpen();
    }

    @Override // com.transsion.transfer.impl.e
    public void i(String root, List files, Function1 notifyFileListener) {
        Intrinsics.h(root, "root");
        Intrinsics.h(files, "files");
        Intrinsics.h(notifyFileListener, "notifyFileListener");
        ArrayList arrayList = new ArrayList();
        c0().e(files);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : files) {
            FileData fileData = (FileData) obj;
            boolean verifyFile = fileData.verifyFile();
            if (verifyFile) {
                this.f55812s.I(fileData.getFileRemotePath(), TaskState.FINISH, fileData.getFileSize(), fileData.getFileSize(), -1L, null);
                arrayList.add(fileData.getFileRemotePath());
            }
            if (!verifyFile) {
                arrayList2.add(obj);
            }
        }
        List U0 = CollectionsKt.U0(arrayList2);
        notifyFileListener.invoke(CollectionsKt.U0(arrayList));
        o0(arrayList);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("transferFiles: ");
        sb2.append(U0);
        e0().p(U0);
    }

    @Override // com.transsion.transfer.impl.e
    public String j() {
        return this.f55806m;
    }

    @Override // com.transsion.transfer.impl.e
    public void k(com.transsion.transfer.impl.f listener) {
        Intrinsics.h(listener, "listener");
        this.f55811r.remove(listener);
        this.f55811r.add(listener);
    }
}
