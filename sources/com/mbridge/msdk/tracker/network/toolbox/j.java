package com.mbridge.msdk.tracker.network.toolbox;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ImagesContract;
import com.mbridge.msdk.tracker.network.p;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

/* loaded from: classes5.dex */
public class j implements com.mbridge.msdk.thrid.okhttp.m {

    /* renamed from: b, reason: collision with root package name */
    private final String f38726b;

    /* renamed from: c, reason: collision with root package name */
    private final String f38727c;

    /* renamed from: d, reason: collision with root package name */
    private final p f38728d;

    public j(String str, String str2, p pVar) {
        this.f38726b = str;
        this.f38727c = str2;
        this.f38728d = pVar;
    }

    private List<InetAddress> a(String str, UnknownHostException unknownHostException) throws UnknownHostException {
        p pVar = this.f38728d;
        if (pVar != null) {
            pVar.c(ImagesContract.LOCAL);
        }
        return i.b().a(str, unknownHostException);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.m
    @NonNull
    public List<InetAddress> a(@NonNull String str) throws UnknownHostException {
        try {
            List<InetAddress> a11 = com.mbridge.msdk.thrid.okhttp.m.f38335a.a(str);
            return (a11.isEmpty() && i.b().c(this.f38726b, this.f38727c, str)) ? a(str, new UnknownHostException("DNS result is empty")) : a11;
        } catch (UnknownHostException e11) {
            if (i.b().c(this.f38726b, this.f38727c, str)) {
                return a(str, new UnknownHostException(e11.getMessage()));
            }
            throw e11;
        }
    }
}
