package com.mbridge.msdk.tracker.network.toolbox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private final int f38709a;

    /* renamed from: b, reason: collision with root package name */
    private final List<com.mbridge.msdk.tracker.network.g> f38710b;

    /* renamed from: c, reason: collision with root package name */
    private final int f38711c;

    /* renamed from: d, reason: collision with root package name */
    private final InputStream f38712d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f38713e;

    public g(int i11, List<com.mbridge.msdk.tracker.network.g> list) {
        this(i11, list, -1, null);
    }

    public g(int i11, List<com.mbridge.msdk.tracker.network.g> list, int i12, InputStream inputStream) {
        this.f38709a = i11;
        this.f38710b = list;
        this.f38711c = i12;
        this.f38712d = inputStream;
        this.f38713e = null;
    }

    public final InputStream a() {
        InputStream inputStream = this.f38712d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f38713e != null) {
            return new ByteArrayInputStream(this.f38713e);
        }
        return null;
    }

    public final int b() {
        return this.f38711c;
    }

    public final List<com.mbridge.msdk.tracker.network.g> c() {
        return Collections.unmodifiableList(this.f38710b);
    }

    public final int d() {
        return this.f38709a;
    }
}
