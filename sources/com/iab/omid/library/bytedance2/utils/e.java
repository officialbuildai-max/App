package com.iab.omid.library.bytedance2.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;
import com.iab.omid.library.bytedance2.adsession.DeviceCategory;
import com.iab.omid.library.bytedance2.adsession.OutputDeviceStatus;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static OutputDeviceStatus f33548a = OutputDeviceStatus.UNKNOWN;

    /* loaded from: classes4.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                if (intExtra == 0) {
                    OutputDeviceStatus unused = e.f33548a = OutputDeviceStatus.NOT_DETECTED;
                } else if (intExtra == 1) {
                    OutputDeviceStatus unused2 = e.f33548a = OutputDeviceStatus.UNKNOWN;
                }
            }
        }
    }

    public static OutputDeviceStatus a() {
        return com.iab.omid.library.bytedance2.utils.a.a() != DeviceCategory.CTV ? OutputDeviceStatus.UNKNOWN : f33548a;
    }

    public static void a(@NonNull Context context) {
        context.registerReceiver(new a(), new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"));
    }
}
