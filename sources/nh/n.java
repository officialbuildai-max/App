package nh;

import android.net.Network;
import android.net.NetworkCapabilities;

/* loaded from: classes4.dex */
public interface n {

    /* loaded from: classes4.dex */
    public static final class a {
        public static void a(n nVar) {
        }
    }

    void onConnected();

    void onConnected(Network network, NetworkCapabilities networkCapabilities);

    void onDisconnected();
}
