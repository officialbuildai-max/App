package com.bytedance.sdk.openadsdk.multipro.aidl.Sj;

import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.bytedance.sdk.component.utils.sU;
import com.bytedance.sdk.openadsdk.IAppOpenAdInteractionListener;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class sP extends Sj {
    private static final Map<String, RemoteCallbackList<IAppOpenAdInteractionListener>> Sj = Collections.synchronizedMap(new HashMap());
    private static volatile sP sP;

    public static sP Sj() {
        if (sP == null) {
            synchronized (sP.class) {
                try {
                    if (sP == null) {
                        sP = new sP();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sP;
    }

    private synchronized void Sj(String str, String str2) {
        try {
            Map<String, RemoteCallbackList<IAppOpenAdInteractionListener>> map = Sj;
            if (map != null) {
                RemoteCallbackList<IAppOpenAdInteractionListener> remove = "recycleRes".equals(str2) ? map.remove(str) : map.get(str);
                if (remove != null) {
                    int beginBroadcast = remove.beginBroadcast();
                    for (int i11 = 0; i11 < beginBroadcast; i11++) {
                        try {
                            IAppOpenAdInteractionListener broadcastItem = remove.getBroadcastItem(i11);
                            if (broadcastItem != null) {
                                if ("onAdShow".equals(str2)) {
                                    broadcastItem.onAdShow();
                                } else if ("onAdClicked".equals(str2)) {
                                    broadcastItem.onAdClicked();
                                } else if ("onAdSkip".equals(str2)) {
                                    broadcastItem.onAdSkip();
                                } else if ("onAdTimeOver".equals(str2)) {
                                    broadcastItem.onAdTimeOver();
                                } else if ("recycleRes".equals(str2)) {
                                    broadcastItem.onDestroy();
                                }
                            }
                        } catch (Throwable th2) {
                            sU.Sj("MultiProcess", "appOpenAd2 method " + str2 + " throws Exception :", th2);
                        }
                    }
                    remove.finishBroadcast();
                    if ("recycleRes".equals(str2)) {
                        remove.kill();
                    }
                }
            }
        } catch (Throwable th3) {
            sU.Sj("MultiProcess", "appOpenAd1 method " + str2 + " throws Exception :", th3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.Sj.Sj, com.bytedance.sdk.openadsdk.IListenerManager
    public void executeAppOpenAdCallback(String str, String str2) throws RemoteException {
        Sj(str, str2);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.aidl.Sj.Sj, com.bytedance.sdk.openadsdk.IListenerManager
    public synchronized void registerAppOpenAdListener(String str, IAppOpenAdInteractionListener iAppOpenAdInteractionListener) throws RemoteException {
        RemoteCallbackList<IAppOpenAdInteractionListener> remoteCallbackList = new RemoteCallbackList<>();
        remoteCallbackList.register(iAppOpenAdInteractionListener);
        Sj.put(str, remoteCallbackList);
    }
}
