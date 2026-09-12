package com.transsion.sdk.oneid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* loaded from: classes6.dex */
class c extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private boolean f51967a = true;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (this.f51967a) {
                this.f51967a = false;
                return;
            }
            try {
                if (b.p(context)) {
                    e.a(context).l();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
