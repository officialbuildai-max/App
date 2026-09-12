package com.transsion.gslb;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantLock;
import qk.a;

/* loaded from: classes5.dex */
public class Worker implements Handler.Callback {
    public static final int MAX_RETRY_TIMES = 3;
    public static final int WHAT_ADD_DOMAIN = 101;
    public static final int WHAT_CHECK_EMPTY = 102;
    public static final int WHAT_INIT = 100;
    public static final int WHAT_QUIT = 110;
    public static final int WHAT_SYNC_DATA = 103;
    public static Worker sWorker;
    public DomainManager domainManager;
    public Handler mHandler;
    public HandlerThread handlerThread = null;
    public int netRetryTimes = 0;
    public final ReentrantLock threadLock = new ReentrantLock();

    public Worker() {
        init();
        this.mHandler.sendEmptyMessage(100);
    }

    private String getBackupId() {
        SharedPreferences sharedPreferences;
        String str = "";
        try {
            sharedPreferences = GslbSdk.getContext().getSharedPreferences("gslb", 0);
            try {
                str = sharedPreferences.getString("deviceID", "");
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            sharedPreferences = null;
        }
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String uuid = UUID.randomUUID().toString();
        if (sharedPreferences != null) {
            try {
                sharedPreferences.edit().putString("deviceID", uuid).apply();
            } catch (Exception unused3) {
            }
        }
        return uuid;
    }

    public static Worker getInstance() {
        if (sWorker == null) {
            synchronized (Worker.class) {
                try {
                    if (sWorker == null) {
                        sWorker = new Worker();
                    }
                } finally {
                }
            }
        }
        return sWorker;
    }

    private void init() {
        try {
            if (this.threadLock.tryLock()) {
                try {
                    if (this.handlerThread == null) {
                        HandlerThread handlerThread = new HandlerThread("GSLB Worker");
                        this.handlerThread = handlerThread;
                        handlerThread.setPriority(10);
                        this.handlerThread.start();
                        this.mHandler = new Handler(this.handlerThread.getLooper(), this);
                    } else if (this.mHandler.hasMessages(110)) {
                        this.mHandler.removeMessages(110);
                    }
                    this.threadLock.unlock();
                } catch (Exception e11) {
                    Utils.LOG.i(Log.getStackTraceString(e11));
                    this.threadLock.unlock();
                }
            }
        } catch (Throwable th2) {
            this.threadLock.unlock();
            throw th2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:1|(2:2|3)|(1:63)|7|(1:9)|10|(1:12)|13|14|15|16|17|18|(21:23|24|(2:27|25)|28|29|30|31|(1:33)|34|35|36|37|38|39|40|41|42|43|44|(1:46)(2:49|(4:52|53|54|55)(1:51))|47)|61|24|(1:25)|28|29|30|31|(0)|34|35|36|37|38|39|40|41|42|43|44|(0)(0)|47) */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00db A[Catch: JSONException -> 0x01d6, LOOP:0: B:25:0x00d5->B:27:0x00db, LOOP_END, TryCatch #0 {JSONException -> 0x01d6, blocks: (B:15:0x0093, B:17:0x009a, B:20:0x00b8, B:23:0x00bf, B:24:0x00cc, B:25:0x00d5, B:27:0x00db, B:29:0x00e5, B:31:0x00f0, B:33:0x00f6, B:34:0x00fa, B:36:0x0103, B:38:0x0114, B:40:0x0125, B:61:0x00c7), top: B:14:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6 A[Catch: JSONException -> 0x01d6, TryCatch #0 {JSONException -> 0x01d6, blocks: (B:15:0x0093, B:17:0x009a, B:20:0x00b8, B:23:0x00bf, B:24:0x00cc, B:25:0x00d5, B:27:0x00db, B:29:0x00e5, B:31:0x00f0, B:33:0x00f6, B:34:0x00fa, B:36:0x0103, B:38:0x0114, B:40:0x0125, B:61:0x00c7), top: B:14:0x0093 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0176  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean netRequest(java.util.List<java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 471
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.gslb.Worker.netRequest(java.util.List):boolean");
    }

    private String notNull(String str) {
        return str == null ? "" : str;
    }

    public void addListeners(ListenerBean listenerBean) {
        init();
        Message obtainMessage = this.mHandler.obtainMessage(101);
        obtainMessage.obj = listenerBean;
        this.mHandler.sendMessage(obtainMessage);
    }

    public void checkEmpty() {
        if (this.mHandler.hasMessages(102)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(102, 1000L);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NonNull Message message) {
        int i11 = message.what;
        if (i11 != 110) {
            switch (i11) {
                case 100:
                    a.b(GslbSdk.getContext());
                    Utils.LOG.n("-->WHAT_INIT.");
                    try {
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                        GslbSdk.getContext().registerReceiver(new GslbBroadcastReceiver(), intentFilter);
                    } catch (Exception e11) {
                        Utils.LOG.g("regiseter gslb sdk error " + e11.toString());
                    }
                    Utils.LOG.n("GSLB SDK version is 1.0.3.2");
                    this.domainManager = DomainManager.getInstance();
                    break;
                case 101:
                    Utils.LOG.n("-->WHAT_ADD_DOMAIN.");
                    ListenerBean listenerBean = (ListenerBean) message.obj;
                    if (listenerBean.domains != null) {
                        this.netRetryTimes = 0;
                    }
                    this.domainManager.addListener(listenerBean);
                    checkEmpty();
                    if (this.mHandler.hasMessages(110)) {
                        this.mHandler.removeMessages(110);
                        break;
                    }
                    break;
                case 102:
                    Utils.LOG.n("-->WHAT_CHECK_EMPTY.");
                    if (!Utils.isNetworkAvailable(GslbSdk.getContext())) {
                        this.domainManager.notifyNoNetwork();
                        this.mHandler.removeMessages(110);
                        this.mHandler.sendEmptyMessageDelayed(110, MBInterstitialActivity.WEB_LOAD_TIME);
                        break;
                    } else {
                        List<String> blankDomains = this.domainManager.getBlankDomains();
                        if (blankDomains.size() <= 0) {
                            if (!TextUtils.isEmpty(this.domainManager.getCountry())) {
                                this.mHandler.removeMessages(110);
                                this.mHandler.sendEmptyMessageDelayed(110, MBInterstitialActivity.WEB_LOAD_TIME);
                                break;
                            } else {
                                if (netRequest(this.domainManager.getAllDomains())) {
                                    Utils.LOG.g("net request for country success");
                                    this.domainManager.notifyListener();
                                    this.mHandler.removeMessages(103);
                                }
                                this.mHandler.removeMessages(110);
                                this.mHandler.sendEmptyMessageDelayed(110, MBInterstitialActivity.WEB_LOAD_TIME);
                                break;
                            }
                        } else {
                            Utils.LOG.n("getBlankDomains size > 0");
                            Utils.LOG.n("blankDomains.size()" + blankDomains.size());
                            if (!netRequest(this.domainManager.getAllDomains())) {
                                this.domainManager.notifyNoNetwork();
                                int i12 = this.netRetryTimes + 1;
                                this.netRetryTimes = i12;
                                if (i12 < 3) {
                                    checkEmpty();
                                    break;
                                } else {
                                    this.domainManager.notifyListener();
                                    this.mHandler.removeMessages(110);
                                    this.mHandler.sendEmptyMessageDelayed(110, MBInterstitialActivity.WEB_LOAD_TIME);
                                    break;
                                }
                            } else {
                                this.domainManager.notifyListener();
                                checkEmpty();
                                break;
                            }
                        }
                    }
                case 103:
                    Utils.LOG.n("-->WHAT_SYNC_DATA.");
                    if (Utils.isNetworkAvailable(GslbSdk.getContext())) {
                        List<String> allDomains = this.domainManager.getAllDomains();
                        if (allDomains.size() > 0) {
                            netRequest(allDomains);
                        }
                        this.mHandler.removeMessages(103);
                    }
                    this.mHandler.removeMessages(110);
                    this.mHandler.sendEmptyMessageDelayed(110, MBInterstitialActivity.WEB_LOAD_TIME);
                    break;
            }
        } else {
            Utils.LOG.n("-->WHAT_QUIT.");
            if (this.threadLock.tryLock()) {
                try {
                    HandlerThread handlerThread = this.handlerThread;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.handlerThread = null;
                    }
                } finally {
                    this.threadLock.unlock();
                }
            }
        }
        return false;
    }

    public void retry() {
        init();
        checkEmpty();
        DomainManager.getInstance().checkSync();
    }

    public void syncData() {
        init();
        if (this.mHandler.hasMessages(103)) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(103, 100L);
    }
}
