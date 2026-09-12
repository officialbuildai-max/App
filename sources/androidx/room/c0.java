package androidx.room;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f14676a = new c0();

    private c0() {
    }

    public static final String a(String hash) {
        Intrinsics.h(hash, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')";
    }
}
