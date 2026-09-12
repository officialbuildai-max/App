package com.transsion.fission;

import com.tencent.mmkv.MMKV;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f44205a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static final MMKV f44206b = MMKV.I("one_room_fission");

    private l() {
    }

    public final String a() {
        MMKV mmkv = f44206b;
        if (mmkv != null) {
            return mmkv.getString("KEY_FISSION_INVITATION_CODE", null);
        }
        return null;
    }

    public final String b() {
        MMKV mmkv = f44206b;
        if (mmkv != null) {
            return mmkv.getString("KEY_FISSION_INVITE_REG", null);
        }
        return null;
    }

    public final void c(String str) {
        MMKV mmkv = f44206b;
        if (mmkv != null) {
            mmkv.putString("KEY_FISSION_INVITATION_CODE", str);
        }
    }
}
