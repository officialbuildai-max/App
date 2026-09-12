package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.amazonaws.event.ProgressEvent;
import com.amazonaws.event.ProgressListener;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class TransferStatusUpdater {

    /* renamed from: c, reason: collision with root package name */
    private static final Log f18594c = LogFactory.b(TransferStatusUpdater.class);

    /* renamed from: d, reason: collision with root package name */
    private static final HashSet f18595d = new HashSet(Arrays.asList(TransferState.PART_COMPLETED, TransferState.PENDING_CANCEL, TransferState.PENDING_PAUSE, TransferState.PENDING_NETWORK_DISCONNECT));

    /* renamed from: e, reason: collision with root package name */
    static final Map f18596e = new ConcurrentHashMap<Integer, List<TransferListener>>() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.1
    };

    /* renamed from: f, reason: collision with root package name */
    private static TransferDBUtil f18597f;

    /* renamed from: g, reason: collision with root package name */
    private static TransferStatusUpdater f18598g;

    /* renamed from: a, reason: collision with root package name */
    private final Map f18599a;

    /* renamed from: b, reason: collision with root package name */
    private final Handler f18600b;

    /* loaded from: classes2.dex */
    private class TransferProgressListener implements ProgressListener {

        /* renamed from: a, reason: collision with root package name */
        private final TransferRecord f18601a;

        /* renamed from: b, reason: collision with root package name */
        private long f18602b;

        public TransferProgressListener(TransferRecord transferRecord) {
            this.f18601a = transferRecord;
        }

        @Override // com.amazonaws.event.ProgressListener
        public synchronized void a(ProgressEvent progressEvent) {
            try {
                if (32 == progressEvent.b()) {
                    TransferStatusUpdater.f18594c.d("Reset Event triggered. Resetting the bytesCurrent to 0.");
                    this.f18602b = 0L;
                } else {
                    long a11 = this.f18602b + progressEvent.a();
                    this.f18602b = a11;
                    TransferRecord transferRecord = this.f18601a;
                    if (a11 > transferRecord.f18571i) {
                        transferRecord.f18571i = a11;
                        TransferStatusUpdater.this.k(transferRecord.f18563a, a11, transferRecord.f18570h, true);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    TransferStatusUpdater(TransferDBUtil transferDBUtil) {
        f18597f = transferDBUtil;
        this.f18600b = new Handler(Looper.getMainLooper());
        this.f18599a = new ConcurrentHashMap();
    }

    public static synchronized TransferStatusUpdater c(Context context) {
        TransferStatusUpdater transferStatusUpdater;
        synchronized (TransferStatusUpdater.class) {
            try {
                if (f18598g == null) {
                    TransferDBUtil transferDBUtil = new TransferDBUtil(context);
                    f18597f = transferDBUtil;
                    f18598g = new TransferStatusUpdater(transferDBUtil);
                }
                transferStatusUpdater = f18598g;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return transferStatusUpdater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(int i11, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map map = f18596e;
        synchronized (map) {
            try {
                List list = (List) map.get(Integer.valueOf(i11));
                if (list == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(transferListener);
                    map.put(Integer.valueOf(i11), copyOnWriteArrayList);
                } else if (!list.contains(transferListener)) {
                    list.add(transferListener);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void j(int i11, TransferListener transferListener) {
        if (transferListener == null) {
            throw new IllegalArgumentException("Listener can't be null");
        }
        Map map = f18596e;
        synchronized (map) {
            try {
                List list = (List) map.get(Integer.valueOf(i11));
                if (list != null && !list.isEmpty()) {
                    list.remove(transferListener);
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void b(TransferRecord transferRecord) {
        this.f18599a.put(Integer.valueOf(transferRecord.f18563a), transferRecord);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized TransferRecord d(int i11) {
        return (TransferRecord) this.f18599a.get(Integer.valueOf(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized Map e() {
        return Collections.unmodifiableMap(this.f18599a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized ProgressListener f(int i11) {
        TransferRecord d11;
        d11 = d(i11);
        if (d11 == null) {
            f18594c.d("TransferStatusUpdater doesn't track the transfer: " + i11);
            throw new IllegalArgumentException("transfer " + i11 + " doesn't exist");
        }
        f18594c.d("Creating a new progress listener for transfer: " + i11);
        return new TransferProgressListener(d11);
    }

    synchronized void h(int i11) {
        try {
            TransferRecord j11 = f18597f.j(i11);
            if (j11 != null) {
                String str = j11.f18581s;
                if (new File(str).getName().startsWith("aws-s3-d861b25a-1edf-11eb-adc1-0242ac120002")) {
                    new File(str).delete();
                }
            }
            S3ClientReference.c(Integer.valueOf(i11));
            f18597f.c(i11);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final int i11, final Exception exc) {
        Map map = f18596e;
        synchronized (map) {
            try {
                List<TransferListener> list = (List) map.get(Integer.valueOf(i11));
                if (list != null && !list.isEmpty()) {
                    for (final TransferListener transferListener : list) {
                        this.f18600b.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.4
                            @Override // java.lang.Runnable
                            public void run() {
                                transferListener.c(i11, exc);
                            }
                        });
                    }
                }
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void k(final int i11, final long j11, final long j12, boolean z10) {
        try {
            TransferRecord transferRecord = (TransferRecord) this.f18599a.get(Integer.valueOf(i11));
            if (transferRecord != null) {
                transferRecord.f18571i = j11;
                transferRecord.f18570h = j12;
            }
            f18597f.p(i11, j11);
            if (z10) {
                Map map = f18596e;
                synchronized (map) {
                    try {
                        List list = (List) map.get(Integer.valueOf(i11));
                        if (list != null && !list.isEmpty()) {
                            for (Iterator it = list.iterator(); it.hasNext(); it = it) {
                                final TransferListener transferListener = (TransferListener) it.next();
                                this.f18600b.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        transferListener.b(i11, j11, j12);
                                    }
                                });
                            }
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void l(final int i11, final TransferState transferState) {
        try {
            boolean contains = f18595d.contains(transferState);
            TransferRecord transferRecord = (TransferRecord) this.f18599a.get(Integer.valueOf(i11));
            if (transferRecord != null) {
                contains |= transferState.equals(transferRecord.f18577o);
                transferRecord.f18577o = transferState;
                if (f18597f.t(transferRecord) == 0) {
                    f18594c.j("Failed to update the status of transfer " + i11);
                }
            } else if (f18597f.s(i11, transferState) == 0) {
                f18594c.j("Failed to update the status of transfer " + i11);
            }
            if (contains) {
                return;
            }
            if (TransferState.COMPLETED.equals(transferState)) {
                h(i11);
            }
            Map map = f18596e;
            synchronized (map) {
                try {
                    List<TransferListener> list = (List) map.get(Integer.valueOf(i11));
                    if (list != null && !list.isEmpty()) {
                        for (final TransferListener transferListener : list) {
                            this.f18600b.post(new Runnable() { // from class: com.amazonaws.mobileconnectors.s3.transferutility.TransferStatusUpdater.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    transferListener.a(i11, transferState);
                                }
                            });
                        }
                        if (TransferState.COMPLETED.equals(transferState) || TransferState.FAILED.equals(transferState) || TransferState.CANCELED.equals(transferState)) {
                            list.clear();
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
