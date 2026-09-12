package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    protected int f35069a;

    /* renamed from: b, reason: collision with root package name */
    protected int f35070b;

    /* renamed from: c, reason: collision with root package name */
    protected int f35071c;

    /* renamed from: d, reason: collision with root package name */
    protected int f35072d;

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i11) {
        this.f35069a = i11;
        this.f35070b = i11;
        this.f35071c = i11;
    }

    public void authDeviceIdStatus(int i11) {
        this.f35070b = i11;
    }

    public void authGenDataStatus(int i11) {
        this.f35069a = i11;
    }

    public void authOtherDataStatus(int i11) {
        this.f35072d = i11;
    }

    public void authSerialIdStatus(int i11) {
        this.f35071c = i11;
    }

    public int getAuthDeviceIdStatus() {
        return this.f35070b;
    }

    public int getAuthGenDataStatus() {
        return this.f35069a;
    }

    public int getAuthSerialIdStatus() {
        return this.f35071c;
    }

    public int getOtherDataStatus() {
        return this.f35072d;
    }

    public int getStatusByKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            str.hashCode();
            char c11 = 65535;
            switch (str.hashCode()) {
                case -1262204598:
                    if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -663505496:
                    if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 1026848797:
                    if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1564683028:
                    if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    return this.f35071c;
                case 1:
                    return this.f35070b;
                case 2:
                    return this.f35069a;
                case 3:
                    return this.f35072d;
            }
        }
        return 1;
    }
}
