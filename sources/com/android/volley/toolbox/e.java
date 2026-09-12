package com.android.volley.toolbox;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private final int f19382a;

    /* renamed from: b, reason: collision with root package name */
    private final List f19383b;

    /* renamed from: c, reason: collision with root package name */
    private final int f19384c;

    /* renamed from: d, reason: collision with root package name */
    private final InputStream f19385d;

    /* renamed from: e, reason: collision with root package name */
    private final byte[] f19386e;

    public e(int i11, List list) {
        this(i11, list, -1, null);
    }

    public e(int i11, List list, int i12, InputStream inputStream) {
        this.f19382a = i11;
        this.f19383b = list;
        this.f19384c = i12;
        this.f19385d = inputStream;
        this.f19386e = null;
    }

    public final InputStream a() {
        InputStream inputStream = this.f19385d;
        if (inputStream != null) {
            return inputStream;
        }
        if (this.f19386e != null) {
            return new ByteArrayInputStream(this.f19386e);
        }
        return null;
    }

    public final int b() {
        return this.f19384c;
    }

    public final List c() {
        return Collections.unmodifiableList(this.f19383b);
    }

    public final int d() {
        return this.f19382a;
    }
}
