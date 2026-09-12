package dg;

import dg.b;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a implements b.InterfaceC0757b {

    /* renamed from: c, reason: collision with root package name */
    private final String f61474c = "HttpLogger";

    @Override // dg.b.InterfaceC0757b
    public void log(String message) {
        Intrinsics.h(message, "message");
        Intrinsics.q("log: ->> ", message);
    }
}
