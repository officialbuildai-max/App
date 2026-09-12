package com.transsion.transfer.androidasync;

import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedSelectorException;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class AsyncServer {

    /* renamed from: g, reason: collision with root package name */
    static AsyncServer f55260g = new AsyncServer();

    /* renamed from: h, reason: collision with root package name */
    private static ExecutorService f55261h = A("AsyncServer-worker-");

    /* renamed from: i, reason: collision with root package name */
    private static final Comparator f55262i = new Comparator<InetAddress>() { // from class: com.transsion.transfer.androidasync.AsyncServer.5
        @Override // java.util.Comparator
        public int compare(InetAddress inetAddress, InetAddress inetAddress2) {
            boolean z10 = inetAddress instanceof Inet4Address;
            if (z10 && (inetAddress2 instanceof Inet4Address)) {
                return 0;
            }
            if ((inetAddress instanceof Inet6Address) && (inetAddress2 instanceof Inet6Address)) {
                return 0;
            }
            return (z10 && (inetAddress2 instanceof Inet6Address)) ? -1 : 1;
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private static ExecutorService f55263j = A("AsyncServer-resolver-");

    /* renamed from: k, reason: collision with root package name */
    private static final ThreadLocal f55264k = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private x f55265a;

    /* renamed from: b, reason: collision with root package name */
    String f55266b;

    /* renamed from: c, reason: collision with root package name */
    boolean f55267c;

    /* renamed from: d, reason: collision with root package name */
    int f55268d;

    /* renamed from: e, reason: collision with root package name */
    PriorityQueue f55269e;

    /* renamed from: f, reason: collision with root package name */
    Thread f55270f;

    /* renamed from: com.transsion.transfer.androidasync.AsyncServer$7, reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass7 implements Runnable {
        final /* synthetic */ AsyncDatagramSocket val$handler;
        final /* synthetic */ String val$host;
        final /* synthetic */ int val$port;
        final /* synthetic */ DatagramChannel val$socket;

        AnonymousClass7(String str, int i11, AsyncDatagramSocket asyncDatagramSocket, DatagramChannel datagramChannel) {
            this.val$host = str;
            this.val$port = i11;
            this.val$handler = asyncDatagramSocket;
            this.val$socket = datagramChannel;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                InetSocketAddress inetSocketAddress = new InetSocketAddress(this.val$host, this.val$port);
                AsyncServer.this.s(this.val$handler);
                this.val$socket.connect(inetSocketAddress);
            } catch (IOException e11) {
                Log.e("NIO", "Datagram error", e11);
                com.transsion.transfer.androidasync.util.d.a(this.val$socket);
            }
        }
    }

    /* renamed from: com.transsion.transfer.androidasync.AsyncServer$9, reason: invalid class name */
    /* loaded from: classes6.dex */
    class AnonymousClass9 implements Runnable {
        AnonymousClass9() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AsyncServer.this.f55265a == null) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Key Count: ");
            sb2.append(AsyncServer.this.f55265a.h().size());
            for (SelectionKey selectionKey : AsyncServer.this.f55265a.h()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Key: ");
                sb3.append(selectionKey);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class AsyncSelectorException extends IOException {
        public AsyncSelectorException(Exception exc) {
            super(exc);
        }
    }

    /* loaded from: classes6.dex */
    private static class RunnableWrapper implements Runnable {
        Handler handler;
        boolean hasRun;
        Runnable runnable;
        ThreadQueue threadQueue;

        private RunnableWrapper() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                try {
                    if (this.hasRun) {
                        return;
                    }
                    this.hasRun = true;
                    try {
                        this.runnable.run();
                    } finally {
                        this.threadQueue.remove(this);
                        this.handler.removeCallbacks(this);
                        this.threadQueue = null;
                        this.handler = null;
                        this.runnable = null;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class Scheduled implements com.transsion.transfer.androidasync.future.a, Runnable {
        boolean cancelled;
        public Runnable runnable;
        public AsyncServer server;
        public long time;

        public Scheduled(AsyncServer asyncServer, Runnable runnable, long j11) {
            this.server = asyncServer;
            this.runnable = runnable;
            this.time = j11;
        }

        @Override // com.transsion.transfer.androidasync.future.a
        public boolean cancel() {
            boolean remove;
            synchronized (this.server) {
                remove = this.server.f55269e.remove(this);
                this.cancelled = remove;
            }
            return remove;
        }

        @Override // com.transsion.transfer.androidasync.future.a
        public boolean isCancelled() {
            return this.cancelled;
        }

        public boolean isDone() {
            boolean z10;
            synchronized (this.server) {
                try {
                    z10 = (this.cancelled || this.server.f55269e.contains(this)) ? false : true;
                } finally {
                }
            }
            return z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class Scheduler implements Comparator<Scheduled> {
        public static Scheduler INSTANCE = new Scheduler();

        private Scheduler() {
        }

        @Override // java.util.Comparator
        public int compare(Scheduled scheduled, Scheduled scheduled2) {
            long j11 = scheduled.time;
            long j12 = scheduled2.time;
            if (j11 == j12) {
                return 0;
            }
            return j11 > j12 ? 1 : -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements com.transsion.transfer.androidasync.future.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ bv.b f55275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.transsion.transfer.androidasync.future.w f55276b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ InetSocketAddress f55277c;

        a(bv.b bVar, com.transsion.transfer.androidasync.future.w wVar, InetSocketAddress inetSocketAddress) {
            this.f55275a = bVar;
            this.f55276b = wVar;
            this.f55277c = inetSocketAddress;
        }

        @Override // com.transsion.transfer.androidasync.future.g
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Exception exc, InetAddress inetAddress) {
            if (exc == null) {
                this.f55276b.E((b) AsyncServer.this.l(new InetSocketAddress(inetAddress, this.f55277c.getPort()), this.f55275a));
            } else {
                this.f55275a.a(exc, null);
                this.f55276b.G(exc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public class b extends com.transsion.transfer.androidasync.future.w {

        /* renamed from: f, reason: collision with root package name */
        SocketChannel f55279f;

        /* renamed from: g, reason: collision with root package name */
        bv.b f55280g;

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.transsion.transfer.androidasync.future.n
        public void cancelCleanup() {
            super.cancelCleanup();
            try {
                SocketChannel socketChannel = this.f55279f;
                if (socketChannel != null) {
                    socketChannel.close();
                }
            } catch (IOException unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class c implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final ThreadGroup f55282a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicInteger f55283b = new AtomicInteger(1);

        /* renamed from: c, reason: collision with root package name */
        private final String f55284c;

        c(String str) {
            SecurityManager securityManager = System.getSecurityManager();
            this.f55282a = securityManager != null ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            this.f55284c = str;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(this.f55282a, runnable, this.f55284c + this.f55283b.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            if (thread.getPriority() != 5) {
                thread.setPriority(5);
            }
            return thread;
        }
    }

    /* loaded from: classes6.dex */
    private static class d {

        /* renamed from: a, reason: collision with root package name */
        Object f55285a;

        private d() {
        }
    }

    public AsyncServer() {
        this(null);
    }

    public AsyncServer(String str) {
        this.f55268d = 0;
        this.f55269e = new PriorityQueue(1, Scheduler.INSTANCE);
        this.f55266b = str == null ? "AsyncServer" : str;
    }

    private static ExecutorService A(String str) {
        return new ThreadPoolExecutor(0, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c(str));
    }

    private void F() {
        synchronized (this) {
            try {
                x xVar = this.f55265a;
                if (xVar != null) {
                    PriorityQueue priorityQueue = this.f55269e;
                    try {
                        try {
                            I(this, xVar, priorityQueue);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    } catch (AsyncSelectorException unused2) {
                        xVar.d().close();
                        return;
                    }
                }
                try {
                    final x xVar2 = new x(SelectorProvider.provider().openSelector());
                    this.f55265a = xVar2;
                    final PriorityQueue priorityQueue2 = this.f55269e;
                    Thread thread = new Thread(this.f55266b) { // from class: com.transsion.transfer.androidasync.AsyncServer.8
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                AsyncServer.f55264k.set(AsyncServer.this);
                                AsyncServer.G(AsyncServer.this, xVar2, priorityQueue2);
                            } finally {
                                AsyncServer.f55264k.remove();
                            }
                        }
                    };
                    this.f55270f = thread;
                    thread.start();
                } catch (IOException e11) {
                    throw new RuntimeException("unable to create selector?", e11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void G(AsyncServer asyncServer, x xVar, PriorityQueue priorityQueue) {
        while (true) {
            try {
                I(asyncServer, xVar, priorityQueue);
            } catch (AsyncSelectorException e11) {
                boolean z10 = e11.getCause() instanceof ClosedSelectorException;
                com.transsion.transfer.androidasync.util.d.a(xVar);
            }
            synchronized (asyncServer) {
                try {
                    if (!xVar.isOpen() || (xVar.h().size() <= 0 && priorityQueue.size() <= 0)) {
                        break;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        J(xVar);
        if (asyncServer.f55265a == xVar) {
            asyncServer.f55269e = new PriorityQueue(1, Scheduler.INSTANCE);
            asyncServer.f55265a = null;
            asyncServer.f55270f = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX WARN: Type inference failed for: r3v18, types: [bv.b] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r3v7, types: [bv.f] */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.transsion.transfer.androidasync.future.w, com.transsion.transfer.androidasync.AsyncServer$b] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.nio.channels.SelectionKey] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r6v4, types: [com.transsion.transfer.androidasync.AsyncNetworkSocket, com.transsion.transfer.androidasync.j, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v4, types: [com.transsion.transfer.androidasync.AsyncNetworkSocket, com.transsion.transfer.androidasync.j, java.lang.Object] */
    private static void I(AsyncServer asyncServer, x xVar, PriorityQueue priorityQueue) {
        ?? r11;
        SocketChannel socketChannel;
        SelectionKey selectionKey;
        ?? r52;
        long z10 = z(asyncServer, priorityQueue);
        try {
            synchronized (asyncServer) {
                try {
                    if (xVar.m() != 0) {
                        r11 = false;
                    } else if (xVar.h().size() == 0 && z10 == Long.MAX_VALUE) {
                        return;
                    } else {
                        r11 = true;
                    }
                    if (r11 != false) {
                        if (z10 == Long.MAX_VALUE) {
                            xVar.k();
                        } else {
                            xVar.l(z10);
                        }
                    }
                    Set<??> n11 = xVar.n();
                    for (?? r32 : n11) {
                        try {
                            socketChannel = null;
                            r52 = 0;
                        } catch (CancelledKeyException unused) {
                        }
                        if (r32.isAcceptable()) {
                            try {
                                SocketChannel accept = ((ServerSocketChannel) r32.channel()).accept();
                                if (accept != null) {
                                    try {
                                        accept.configureBlocking(false);
                                        accept.socket().setKeepAlive(true);
                                        accept.socket().setTcpNoDelay(true);
                                        accept.socket().setSoLinger(true, 0);
                                        r52 = accept.register(xVar.d(), 1);
                                        ?? r33 = (bv.f) r32.attachment();
                                        ?? asyncNetworkSocket = new AsyncNetworkSocket();
                                        asyncNetworkSocket.f(accept, (InetSocketAddress) accept.socket().getRemoteSocketAddress());
                                        asyncNetworkSocket.y(asyncServer, r52);
                                        r52.attach(asyncNetworkSocket);
                                        r33.w(asyncNetworkSocket);
                                    } catch (IOException unused2) {
                                        selectionKey = r52;
                                        socketChannel = accept;
                                        com.transsion.transfer.androidasync.util.d.a(socketChannel);
                                        if (selectionKey != null) {
                                            selectionKey.cancel();
                                        }
                                    }
                                }
                            } catch (IOException unused3) {
                                selectionKey = null;
                            }
                        } else if (r32.isReadable()) {
                            asyncServer.B(((AsyncNetworkSocket) r32.attachment()).q());
                        } else if (!r32.isWritable()) {
                            if (!r32.isConnectable()) {
                                throw new RuntimeException("Unknown key state.");
                                break;
                            }
                            ?? r42 = (b) r32.attachment();
                            SocketChannel socketChannel2 = (SocketChannel) r32.channel();
                            r32.interestOps(1);
                            try {
                                socketChannel2.finishConnect();
                                ?? asyncNetworkSocket2 = new AsyncNetworkSocket();
                                asyncNetworkSocket2.y(asyncServer, r32);
                                asyncNetworkSocket2.f(socketChannel2, (InetSocketAddress) socketChannel2.socket().getRemoteSocketAddress());
                                r32.attach(asyncNetworkSocket2);
                                if (r42.J(asyncNetworkSocket2)) {
                                    r42.f55280g.a(null, asyncNetworkSocket2);
                                }
                            } catch (IOException e11) {
                                r32.cancel();
                                com.transsion.transfer.androidasync.util.d.a(socketChannel2);
                                if (r42.G(e11)) {
                                    r42.f55280g.a(e11, null);
                                }
                            }
                        } else {
                            ((AsyncNetworkSocket) r32.attachment()).m();
                        }
                    }
                    n11.clear();
                } finally {
                }
            }
        } catch (Exception e12) {
            throw new AsyncSelectorException(e12);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J(x xVar) {
        K(xVar);
        com.transsion.transfer.androidasync.util.d.a(xVar);
    }

    private static void K(x xVar) {
        try {
            for (SelectionKey selectionKey : xVar.h()) {
                com.transsion.transfer.androidasync.util.d.a(selectionKey.channel());
                try {
                    selectionKey.cancel();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    private static void N(final x xVar) {
        f55261h.execute(new Runnable() { // from class: com.transsion.transfer.androidasync.e
            @Override // java.lang.Runnable
            public final void run() {
                AsyncServer.x(x.this);
            }
        });
    }

    public static AsyncServer r() {
        return f55260g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(AsyncNetworkSocket asyncNetworkSocket) {
        SelectionKey i11 = asyncNetworkSocket.j().i(this.f55265a.d());
        i11.attach(asyncNetworkSocket);
        asyncNetworkSocket.y(this, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InetAddress u(InetAddress[] inetAddressArr) {
        return inetAddressArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v(Runnable runnable, Semaphore semaphore) {
        runnable.run();
        semaphore.release();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w(x xVar) {
        try {
            xVar.p();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x(x xVar) {
        try {
            xVar.p();
        } catch (Exception unused) {
        }
    }

    private static long z(AsyncServer asyncServer, PriorityQueue priorityQueue) {
        Scheduled scheduled;
        long j11 = Long.MAX_VALUE;
        while (true) {
            synchronized (asyncServer) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    scheduled = null;
                    if (priorityQueue.size() > 0) {
                        Scheduled scheduled2 = (Scheduled) priorityQueue.remove();
                        long j12 = scheduled2.time;
                        if (j12 <= elapsedRealtime) {
                            scheduled = scheduled2;
                        } else {
                            priorityQueue.add(scheduled2);
                            j11 = j12 - elapsedRealtime;
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (scheduled == null) {
                asyncServer.f55268d = 0;
                return j11;
            }
            scheduled.run();
        }
    }

    protected void B(int i11) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void C(int i11) {
    }

    public com.transsion.transfer.androidasync.future.a D(Runnable runnable) {
        return E(runnable, 0L);
    }

    public com.transsion.transfer.androidasync.future.a E(Runnable runnable, long j11) {
        synchronized (this) {
            try {
                if (this.f55267c) {
                    return com.transsion.transfer.androidasync.future.n.CANCELLED;
                }
                long j12 = 0;
                if (j11 > 0) {
                    j12 = SystemClock.elapsedRealtime() + j11;
                } else if (j11 == 0) {
                    int i11 = this.f55268d;
                    this.f55268d = i11 + 1;
                    j12 = i11;
                } else if (this.f55269e.size() > 0) {
                    j12 = Math.min(0L, ((Scheduled) this.f55269e.peek()).time - 1);
                }
                PriorityQueue priorityQueue = this.f55269e;
                Scheduled scheduled = new Scheduled(this, runnable, j12);
                priorityQueue.add(scheduled);
                if (this.f55265a == null) {
                    F();
                }
                if (!t()) {
                    N(this.f55265a);
                }
                return scheduled;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void H(final Runnable runnable) {
        if (Thread.currentThread() == this.f55270f) {
            D(runnable);
            z(this, this.f55269e);
            return;
        }
        synchronized (this) {
            try {
                if (this.f55267c) {
                    return;
                }
                final Semaphore semaphore = new Semaphore(0);
                D(new Runnable() { // from class: com.transsion.transfer.androidasync.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncServer.v(runnable, semaphore);
                    }
                });
                try {
                    semaphore.acquire();
                } catch (InterruptedException e11) {
                    Log.e("NIO", "run", e11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void L() {
        M(false);
    }

    public void M(boolean z10) {
        synchronized (this) {
            try {
                boolean t11 = t();
                final x xVar = this.f55265a;
                if (xVar == null) {
                    return;
                }
                final Semaphore semaphore = new Semaphore(0);
                this.f55269e.add(new Scheduled(this, new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncServer.J(xVar);
                        semaphore.release();
                    }
                }, 0L));
                f55261h.execute(new Runnable() { // from class: com.transsion.transfer.androidasync.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        AsyncServer.w(x.this);
                    }
                });
                K(xVar);
                this.f55269e = new PriorityQueue(1, Scheduler.INSTANCE);
                this.f55265a = null;
                this.f55270f = null;
                if (t11 || !z10) {
                    return;
                }
                try {
                    semaphore.acquire();
                } catch (Exception unused) {
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public b k(InetSocketAddress inetSocketAddress, bv.b bVar, bv.h hVar) {
        b bVar2 = new b();
        D(new Runnable(bVar2, bVar, hVar, inetSocketAddress) { // from class: com.transsion.transfer.androidasync.AsyncServer.3
            final /* synthetic */ InetSocketAddress val$address;
            final /* synthetic */ bv.b val$callback;
            final /* synthetic */ b val$cancel;
            final /* synthetic */ bv.h val$createCallback;

            {
                this.val$address = inetSocketAddress;
            }

            @Override // java.lang.Runnable
            public void run() {
                SocketChannel socketChannel;
                if (this.val$cancel.isCancelled()) {
                    return;
                }
                b bVar3 = this.val$cancel;
                bVar3.f55280g = this.val$callback;
                SelectionKey selectionKey = null;
                try {
                    socketChannel = SocketChannel.open();
                    bVar3.f55279f = socketChannel;
                    try {
                        socketChannel.configureBlocking(false);
                        selectionKey = socketChannel.register(AsyncServer.this.f55265a.d(), 8);
                        selectionKey.attach(this.val$cancel);
                        socketChannel.connect(this.val$address);
                    } catch (Throwable th2) {
                        th = th2;
                        if (selectionKey != null) {
                            selectionKey.cancel();
                        }
                        com.transsion.transfer.androidasync.util.d.a(socketChannel);
                        this.val$cancel.G(new RuntimeException(th));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    socketChannel = null;
                }
            }
        });
        return bVar2;
    }

    public com.transsion.transfer.androidasync.future.a l(InetSocketAddress inetSocketAddress, bv.b bVar) {
        return k(inetSocketAddress, bVar, null);
    }

    public com.transsion.transfer.androidasync.future.a m(String str, int i11, bv.b bVar) {
        return n(InetSocketAddress.createUnresolved(str, i11), bVar);
    }

    public com.transsion.transfer.androidasync.future.a n(InetSocketAddress inetSocketAddress, bv.b bVar) {
        if (!inetSocketAddress.isUnresolved()) {
            return l(inetSocketAddress, bVar);
        }
        com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        com.transsion.transfer.androidasync.future.f q11 = q(inetSocketAddress.getHostName());
        wVar.setParent(q11);
        q11.f(new a(bVar, wVar, inetSocketAddress));
        return wVar;
    }

    public Thread o() {
        return this.f55270f;
    }

    public com.transsion.transfer.androidasync.future.f p(final String str) {
        final com.transsion.transfer.androidasync.future.w wVar = new com.transsion.transfer.androidasync.future.w();
        f55263j.execute(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.6
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final InetAddress[] allByName = InetAddress.getAllByName(str);
                    Arrays.sort(allByName, AsyncServer.f55262i);
                    if (allByName == null || allByName.length == 0) {
                        throw new HostnameResolutionException("no addresses for host");
                    }
                    AsyncServer.this.D(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            wVar.H(null, allByName);
                        }
                    });
                } catch (Exception e11) {
                    AsyncServer.this.D(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.6.2
                        @Override // java.lang.Runnable
                        public void run() {
                            wVar.H(e11, null);
                        }
                    });
                }
            }
        });
        return wVar;
    }

    public com.transsion.transfer.androidasync.future.f q(String str) {
        return p(str).h(new com.transsion.transfer.androidasync.future.y() { // from class: com.transsion.transfer.androidasync.g
            @Override // com.transsion.transfer.androidasync.future.y
            public final Object then(Object obj) {
                InetAddress u11;
                u11 = AsyncServer.u((InetAddress[]) obj);
                return u11;
            }
        });
    }

    public boolean t() {
        return this.f55270f == Thread.currentThread();
    }

    public i y(final InetAddress inetAddress, final int i11, final bv.f fVar) {
        final d dVar = new d();
        H(new Runnable() { // from class: com.transsion.transfer.androidasync.AsyncServer.2

            /* renamed from: com.transsion.transfer.androidasync.AsyncServer$2$a */
            /* loaded from: classes6.dex */
            class a implements i {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ ServerSocketChannel f55271a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ y f55272b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ SelectionKey f55273c;

                a(ServerSocketChannel serverSocketChannel, y yVar, SelectionKey selectionKey) {
                    this.f55271a = serverSocketChannel;
                    this.f55272b = yVar;
                    this.f55273c = selectionKey;
                }

                @Override // com.transsion.transfer.androidasync.i
                public void stop() {
                    com.transsion.transfer.androidasync.util.d.a(this.f55272b);
                    try {
                        this.f55273c.cancel();
                    } catch (Exception unused) {
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                y yVar;
                IOException e11;
                ServerSocketChannel serverSocketChannel;
                try {
                    serverSocketChannel = ServerSocketChannel.open();
                    try {
                        yVar = new y(serverSocketChannel);
                    } catch (IOException e12) {
                        yVar = null;
                        e11 = e12;
                    }
                    try {
                        serverSocketChannel.socket().bind(inetAddress == null ? new InetSocketAddress(i11) : new InetSocketAddress(inetAddress, i11));
                        SelectionKey i12 = yVar.i(AsyncServer.this.f55265a.d());
                        i12.attach(fVar);
                        bv.f fVar2 = fVar;
                        d dVar2 = dVar;
                        a aVar = new a(serverSocketChannel, yVar, i12);
                        dVar2.f55285a = aVar;
                        fVar2.q(aVar);
                    } catch (IOException e13) {
                        e11 = e13;
                        Log.e("NIO", "wtf", e11);
                        com.transsion.transfer.androidasync.util.d.a(yVar, serverSocketChannel);
                        fVar.g(e11);
                    }
                } catch (IOException e14) {
                    yVar = null;
                    e11 = e14;
                    serverSocketChannel = null;
                }
            }
        });
        return (i) dVar.f55285a;
    }
}
